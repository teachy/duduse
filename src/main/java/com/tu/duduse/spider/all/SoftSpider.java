package com.tu.duduse.spider.all;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author gang.tu
 * @ClassName SoftSpider
 * @Date 2019/11/7 14:33
 */
@Component
@Slf4j
public class SoftSpider extends BaseSpider {
    private static final String WEB_TYPE = "soft";

    @PostConstruct
    void init() {
//        works.add(getStringWebsDtoFunction(CR_173_XPATH, CR_173_NAME, CR_173_URL, CHARSET_UTF_8));
        type = WEB_TYPE;
    }

//    private static final String CR_173_URL = "https://so.cr173.com/search/d/{0}_all_rank.html";
//    private static final String CR_173_NAME = "西西软件园";
//    private static final String CR_173_XPATH = "//div[@class='m-solist']/div";

}