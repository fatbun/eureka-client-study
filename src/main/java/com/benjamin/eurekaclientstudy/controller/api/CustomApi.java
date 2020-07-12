package com.benjamin.eurekaclientstudy.controller.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("Eureka-Provider")
//@FeignClient(value = "ooxx",url = "http://127.0.0.1:8001")
public interface CustomApi {

    @GetMapping("/hi")
    String hi(@RequestParam("id") Integer id, @RequestParam("name") String name);
}
