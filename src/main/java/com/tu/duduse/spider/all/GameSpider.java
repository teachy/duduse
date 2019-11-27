package com.tu.duduse.spider.all;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author gang.tu
 * @ClassName GameSpider
 * @Date 2019/11/14 11:56
 */
@Component
@Slf4j
public class GameSpider extends BaseSpider {
    private static final String WEB_TYPE = "game";
    @PostConstruct
    void init() {
        type = WEB_TYPE;
    }

}