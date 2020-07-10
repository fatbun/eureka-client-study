package com.benjamin.eurekaclientstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EurekaClientStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientStudyApplication.class,
                args);
    }

}
