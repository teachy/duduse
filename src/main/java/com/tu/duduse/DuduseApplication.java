package com.tu.duduse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableScheduling
public class DuduseApplication {

    public static void main(String[] args) {
        SpringApplication.run(DuduseApplication.class, args);
    }

}
