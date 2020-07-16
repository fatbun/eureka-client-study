package com.benjamin.eurekaproviderstudy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ben Li.
 * @since: 2020/7/10 11:00 上午
 */
@RestController
public class HiController {
    private final Logger logger = LoggerFactory.getLogger(HiController.class);

    @Value("${server.port}")
    private String myPort;

    @GetMapping("/hi")
    public String hi(Integer id, String name) {

                int i = 1 / 0;

        String response = "hi, " + id + ":" + name + "!!! my port: " + myPort;
        logger.info(response);
        return response;
    }
}
