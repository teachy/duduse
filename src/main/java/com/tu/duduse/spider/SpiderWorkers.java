package com.tu.duduse.spider;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.tu.duduse.common.model.bo.SpiderUrlBo;
import com.tu.duduse.common.model.dto.SourcesDto;
import com.tu.duduse.common.model.dto.WebsDto;
import com.tu.duduse.common.utils.PackageScannerManager;
import com.tu.duduse.infrastructure.persistence.SourceDao;
import com.tu.duduse.infrastructure.persistence.SpiderUrlDao;
import com.tu.duduse.infrastructure.persistence.ToolsDao;
import com.tu.duduse.spider.all.BaseSpider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author gang.tu
 * @ClassName SpiderWorkers
 * @Description
 * @Date 2019/11/7 16:31
 */
@Component
@Slf4j
public class SpiderWorkers implements SpiderWorkService {
    /**
     * @description 按类型分所有的爬虫
     * @author gang.tu
     * @date 2019/11/25 15:05
     */
    Map<String, List<Function<String, WebsDto>>> allWorks = new HashMap<>();
    /**
     * @description 所有的爬虫
     * @author gang.tu
     * @date 2019/11/25 15:05
     */
    List<Function<String, WebsDto>> all = new ArrayList<>();
    /**
     * @description 数据库内部数据（tools）
     * @author gang.tu
     * @date 2019/11/25 15:06
     */
    List<String> inDataBases = new ArrayList<>();
    /**
     * @description 通过网上直接配置零时保存的爬虫
     * @author gang.tu
     * @date 2019/11/25 15:06
     */
    List<Function<String, WebsDto>> allTest = new ArrayList<>();
    private SpiderUrlBo testSpiderUrlBo;
    private ExecutorService executorService;
    private ScheduledExecutorService schedulerExecutor;
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private SpiderUrlDao spiderUrlDao;
    @Autowired
    private ToolsDao toolsDao;
    @Autowired
    private SourceDao sourceDao;

    @Autowired
    SpiderWorkers() {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("spider-pool-%d").build();
        executorService = new ThreadPoolExecutor(DEFAULT_WORKS, DEFAULT_WORKS * 2,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(DEFAULT_WORKS * 2), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
        ThreadFactory schedulerThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("scheduler-pool-%d").build();
        schedulerExecutor = new ScheduledThreadPoolExecutor(DEFAULT_WORKS, schedulerThreadFactory);
    }

    @PostConstruct
    void init() {
        inDataBases.add("tools");
        //加载数据库可用的spider,更新已经加载的集合,触发初始化
        new BaseSpider();
        allWorks.putAll(BaseSpider.allWorks);
        //加载特殊的spider
        PackageScannerManager packageScannerManager = new PackageScannerManager(BASE_PATH);
        List<String> results = packageScannerManager.getFullyQualifiedClassNameList();
        results.stream().forEach(e -> {
            if (!e.contains(BASE)) {
                try {
                    BaseSpider spider = (BaseSpider) applicationContext.getBean(Class.forName(e));
                    List<Function<String, WebsDto>> list = allWorks.get(spider.getType());
                    if (list == null) {
                        allWorks.put(spider.getType(), spider.getWorks());
                    } else {
                        list.addAll(spider.getWorks());
                        allWorks.put(spider.getType(), list);
                    }
                } catch (ClassNotFoundException e1) {
                    log.error("读取爬虫信息错误：", e);
                }
            }
        });

        for (Map.Entry<String, List<Function<String, WebsDto>>> entry : allWorks.entrySet()) {
            all.addAll(entry.getValue());
        }
    }

    @Override
    public List<WebsDto> queryBySpider(String type, String query) {
        if (TYPE_ALL.equalsIgnoreCase(type) || "".equals(type)) {
            List<WebsDto> list1 = toolsDao.queryTools(query);
            List<WebsDto> list2 = getWebsDtosBySpider(type, query);
            List<WebsDto> list3 = getWebsDtosBySource(query);
            list1.addAll(list2);
            list1.addAll(list3);
            return list1;
        }
        if (TYPE_LOCAL.equalsIgnoreCase(type)) {
            return getWebsDtosBySource(query);
        }
        if (inDataBases.contains(type)) {
            return toolsDao.queryTools(query);
        } else {
            return getWebsDtosBySpider(type, query);
        }
    }

    @Override
    public List<WebsDto> queryByTestSpider(String query) {
        return runSpiders(query, allTest);
    }

    @Override
    public SpiderUrlBo insertTestUrl() {
        all.addAll(allTest);
        List<Function<String, WebsDto>> list = allWorks.get(testSpiderUrlBo.getType());
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(allTest.get(0));
        allWorks.put(testSpiderUrlBo.getType(), list);
        allTest.clear();
        return testSpiderUrlBo;
    }


    @Override
    public boolean insertTestSpiderUrl(SpiderUrlBo spiderUrlBo) {
        if (checkName(spiderUrlBo)) {
            if (!allTest.isEmpty()) {
                allTest.clear();
            }
            testSpiderUrlBo = spiderUrlBo;
            allTest.add(BaseSpider.getStringWebsDtoFunction(spiderUrlBo.getXpath(), spiderUrlBo.getName(), spiderUrlBo.getUrl(), spiderUrlBo.getCharset()));
            return true;
        }
        return false;
    }

    private List<WebsDto> getWebsDtosBySpider(String type, String query) {
        List<Function<String, WebsDto>> list;
        list = (!allWorks.containsKey(type) ? all : allWorks.get(type));
        int size = list.size();
        if (size > DEFAULT_WORKS) {
            List<Integer> integers = Stream.generate(() -> new Random().nextInt(size)).distinct().limit(DEFAULT_WORKS).collect(Collectors.toList());
            List<Function<String, WebsDto>> newList = new ArrayList<>(DEFAULT_WORKS);
            for (Integer integer : integers) {
                newList.add(list.get(integer));
            }
            return runSpiders(query, newList);
        }
        return runSpiders(query, list);
    }

    private List<WebsDto> getWebsDtosBySource(String query) {
        List<SourcesDto> list = sourceDao.querySources(query);
        List<WebsDto> res = new ArrayList<>(list.size());
        list.forEach(e -> {
            WebsDto websDto = new WebsDto();
            websDto.setWebName(e.getName());
            websDto.setPass(e.getPass());
            websDto.setUrl(e.getUrl());
            res.add(websDto);
        });
        return res;
    }

    /**
     * @description 定义任务和超时时间（超时直接返回空，之后过滤该网站数据）
     * @author gang.tu
     * @date 2019/11/13 15:16
     * @return: java.util.concurrent.CompletableFuture<com.tu.duduse.common.model.dto.WebsDto>
     */
    private CompletableFuture<WebsDto> getWebsDto(Function<String, WebsDto> function, String query) {
        CompletableFuture<WebsDto> futureTimeout = CompletableFuture.supplyAsync(() -> function.apply(query), executorService);
        schedulerExecutor.schedule(() -> futureTimeout.complete(new WebsDto()), TIME_OUT, TimeUnit.MILLISECONDS);
        return futureTimeout;
    }

    /**
     * @description 防止重复添加网址
     * @author gang.tu
     * @date 2019/11/15 17:41
     * @Param spiderUrlBo:
     * @return: boolean
     */
    private boolean checkName(SpiderUrlBo spiderUrlBo) {
        SpiderUrlBo spider = spiderUrlDao.getSpiderByName(spiderUrlBo.getName());
        return spider == null;
    }

    private List<WebsDto> runSpiders(String query, List<Function<String, WebsDto>> spiderList) {
        List<CompletableFuture<WebsDto>> works = spiderList.stream().map(e -> getWebsDto(e, query)).collect(Collectors.toList());
        CompletableFuture<Void> allCompletableFuture = CompletableFuture.allOf(works.toArray(new CompletableFuture[works.size()]));
        List<WebsDto> allResult = allCompletableFuture.thenApply(v -> works.stream().map(CompletableFuture::join).collect(Collectors.toList())).join();
        allResult = allResult.stream().filter(e -> e.getUrl() != null).collect(Collectors.toList());
        return allResult;
    }

    private static final String BASE = "BaseSpider";
    /**
     * @description 爬虫的基础路劲
     * @author gang.tu
     * @date 2019/11/25 15:14
     */
    private static final String BASE_PATH = "com.tu.duduse.spider.all";
    /**
     * @description 一次请求最多允许30个爬虫工作
     * @author gang.tu
     * @date 2019/11/25 15:14
     */
    private static final int DEFAULT_WORKS = 30;
    /**
     * @description 每一个爬虫最多允许运行时间
     * @author gang.tu
     * @date 2019/11/25 15:14
     */
    private static final int TIME_OUT = 3000;
    private static final String TYPE_ALL = "all";
    private static final String TYPE_LOCAL = "local";
}