package com.benjamin.eurekaproviderstudy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ben Li.
 * @since: 2020/7/10 11:00 上午
 */
@RestController
public class HiController {

    @Value("${server.port}")
    private String myPort;

    @GetMapping("/hi")
    public String hi(Integer id, String name) {

        String response = "hi, " + id + ":" + name + "!!! my port: " + myPort;
        System.out.println(response);
        return response;
    }
}
