package com.tu.duduse.common.configuration;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author gang.tu
 * @date 2019/10/10 17:35
 */
@Configuration
@EnableSwagger2
@PropertySource("classpath:apiInfo.properties")
//@Profile({"local"})
@EnableSwaggerBootstrapUI
public class SwaggerConfig {

    @Autowired
    private Environment environment;

    @Bean
    public Docket restApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("api")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.tu.duduse.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(environment.getProperty("title"))
                .description(environment.getProperty("description"))
                .contact(new Contact(environment.getProperty("contact.name"), environment.getProperty("contact.host"),
                        environment.getProperty("contact.mail")))
                .license(environment.getProperty("license"))
                .licenseUrl(environment.getProperty("licenseUrl"))
                .version(environment.getProperty("version"))
                .build();
    }

}
