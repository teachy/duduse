package com.tu.duduse;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author gang.tu
 * @ClassName SpringBootServletInitializer
 * @Description
 * @Date 2019/11/28 16:55
 */
public class ServletInitializer extends SpringBootServletInitializer{
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DuduseApplication.class);
    }
}
