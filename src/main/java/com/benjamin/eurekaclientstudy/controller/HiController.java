package com.benjamin.eurekaclientstudy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Ben Li.
 * @since: 2020/7/10 11:00 上午
 */
@RestController
public class HiController {

    @Value("${server.port}")
    private String myPort;

    @GetMapping("/hi")
    public String hi() {

        String response = "hi!!! my port: " + myPort;
        System.out.println(response);
        return response;
    }
}
