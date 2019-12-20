package com.tu.duduse.common.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author gang.tu
 * @ClassName DefaultView
 * @Description
 * @Date 2019/11/5 10:21
 */
@Configuration
public class DefaultView implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController( "/" ).setViewName( "index.html" );
        registry.setOrder( Ordered.HIGHEST_PRECEDENCE );
    }

}