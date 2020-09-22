package com.benjamin.eurekaproviderstudy.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface HiApi {

    @GetMapping("/hi")
    String hi(@RequestParam("id") Integer id, @RequestParam("name") String name);

    @GetMapping("/bye")
    String bye();
}
