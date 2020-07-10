package com.benjamin.eurekaclientstudy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Ben Li.
 * @since: 2020/7/10 11:00 上午
 */
@RestController
public class HiController {

    @GetMapping("/hi")
    public String hi() {
        System.out.println("hi!!!");
        return "hi";
    }
}
