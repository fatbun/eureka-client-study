package com.benjamin.eurekaclientstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class EurekaClientStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientStudyApplication.class,
                args);
    }

//    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){

        return new RestTemplate();
    }
}
