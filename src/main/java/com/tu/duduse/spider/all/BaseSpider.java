package com.tu.duduse.spider.all;

import com.tu.duduse.common.model.bo.SpiderUrlBo;
import com.tu.duduse.common.model.dto.SourceTypeDto;
import com.tu.duduse.common.model.dto.WebsDto;
import com.tu.duduse.common.model.qo.HttpQo;
import com.tu.duduse.common.utils.ApplicationContextUtil;
import com.tu.duduse.common.utils.HttpUtil;
import com.tu.duduse.infrastructure.persistence.SourceTypeDao;
import com.tu.duduse.infrastructure.persistence.SpiderUrlDao;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author gang.tu
 * @ClassName BaseSpider
 * @Description
 * @Date 2019/11/7 16:37
 */
@Data
@Slf4j
public class BaseSpider {
    public static Map<String, List<Function<String, WebsDto>>> allWorks = new HashMap<>();
    protected static final String CHARSET_UTF_8 = "utf-8";
    protected static final String CHARSET_GBK = "gb2312";
    protected static final String USED_SPIDER = "1";
    List<Function<String, WebsDto>> works = new ArrayList<>();
    protected String type;
    SpiderUrlDao spiderUrlDao = ApplicationContextUtil.getBean(SpiderUrlDao.class);
    SourceTypeDao sourceTypeDao = ApplicationContextUtil.getBean(SourceTypeDao.class);

    /**
     * @description 加载数据库里的爬虫
     * @author gang.tu
     * @date 2019/11/14 16:34
     */
    public BaseSpider() {
        if (allWorks.isEmpty()) {
            List<SpiderUrlBo> allSpider = spiderUrlDao.getAllSpider();
            allSpider = allSpider.stream().filter(spider -> spider.getStatus().equals(USED_SPIDER)).collect(Collectors.toList());
            allSpider.stream().forEach(e -> {
                String type = e.getType();
                List<Function<String, WebsDto>> list = allWorks.get(type);
                if (list == null) {
                    list = new ArrayList<>();
                    allWorks.put(type, list);
                }
                list.add(getStringWebsDtoFunction(e));
            });
        }
    }

    Html getHtml(String url) {
        HttpClientDownloader down = new HttpClientDownloader();
        return down.download(url);
    }

    public static WebsDto getWebsDto(HttpQo httpQo) {
        try {
            Page page = HttpUtil.getPage(httpQo);
            List<Selectable> res = page.getHtml().xpath(httpQo.getXpath()).nodes();
            if (res != null && !res.isEmpty()) {
                int temp = res.size();
                String s1 = temp > 9 ? ("10+") : (temp + "");
                return new WebsDto(httpQo.getName(), s1, httpQo.getUrl());
            }
        } catch (IOException e) {
            e.printStackTrace();
            ApplicationContextUtil.getBean(SpiderUrlDao.class).updateErrorSpiderByName(httpQo.getName());
            log.error("下载错误--webName：{}", httpQo.getName());
        }
        return new WebsDto();
    }

    public static Function<String, WebsDto> getStringWebsDtoFunction(SpiderUrlBo spiderUrlBo) {
        return (String query) -> getWebsDto(new HttpQo(query, spiderUrlBo));
    }
}