package com.tu.duduse.service.impl;

import com.tu.duduse.common.model.bo.IpListBo;
import com.tu.duduse.common.model.dto.WebsDto;
import com.tu.duduse.common.utils.IpUtil;
import com.tu.duduse.infrastructure.persistence.IpListDao;
import com.tu.duduse.service.SpiderService;
import com.tu.duduse.spider.SpiderWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gang.tu
 * @ClassName SpiderServiceImpl
 * @Description
 * @Date 2019/11/7 16:20
 */
@Service
public class SpiderServiceImpl implements SpiderService {
    private final SpiderWorkService spiderWorkService;
    private final IpListDao ipListDao;
    private static Map<String, Long> ipTime = new HashMap();

    @Autowired
    SpiderServiceImpl(SpiderWorkService spiderWorkService, IpListDao ipListDao) {
        this.spiderWorkService = spiderWorkService;
        this.ipListDao = ipListDao;
    }

    @Override
    public List<WebsDto> queryBySpider(String type, String query, HttpServletRequest request) {
        String ip = IpUtil.getIpAddr(request);
        if (checkIp(ip)) {
            long a = System.currentTimeMillis();
            List<WebsDto> list = spiderWorkService.queryBySpider(type, query);
            long b = System.currentTimeMillis();
            long useTime = b - a;
            ipListDao.insert(new IpListBo(ip, query, useTime));
            return list;
        }
        return new ArrayList<>();
    }

    @Override
    public List<WebsDto> queryByTestSpider(String query) {
        return spiderWorkService.queryByTestSpider(query);
    }


    /**
     * @description 简单校验ip频率
     * @author gang.tu
     * @date 2019/11/25 14:58
     */
    private boolean checkIp(String ip) {
        if (ipTime.containsKey(ip)) {
            long now = System.currentTimeMillis();
            long before = ipTime.get(ip);
            if (now - before < MIN_TIME) {
                ipTime.put(ip, now + MIN_SIZE);
                return false;
            }
        }
        ipTime.put(ip, System.currentTimeMillis());
        if (ipTime.size() > MIN_SIZE) {
            ipTime.clear();
        }
        return true;
    }

    /**
     * @description 同ip最新访问间隔
     * @author gang.tu
     * @date 2019/11/25 14:55
     */
    private static final long MIN_TIME = 500;
    /**
     * @description 内存最多保留ip个数/如果有问题，多少毫秒内不让访问
     * @author gang.tu
     * @date 2019/11/25 14:55
     */
    private static final long MIN_SIZE = 10000;
}