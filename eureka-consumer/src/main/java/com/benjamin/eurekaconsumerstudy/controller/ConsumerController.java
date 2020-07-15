package com.benjamin.eurekaconsumerstudy.controller;

import com.benjamin.eurekaconsumerstudy.api.CustomApi;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Ben Li.
 * @since: 2020/7/10 11:33 上午
 */
@RestController
public class ConsumerController {

    @Autowired
    private EurekaDiscoveryClient discoveryClient;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private CustomApi customApi;
    @Value("${server.port}")
    private String port;

    @GetMapping("/client")
    public String client() {
        List<String> services = discoveryClient.getServices();
        System.out.println(services);

        List<ServiceInstance> instances = discoveryClient.getInstances("eureka-provider");
        System.out.println(instances);

        String response = null;
        if (instances.size() > 0) {
            ServiceInstance serviceInstance = instances.get(0);
            String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/hi";

            System.out.println(url);

            response = restTemplate.getForObject(url,
                    String.class);

            System.out.println("response: " + response);
        }

        return response;
    }

    @HystrixCommand(fallbackMethod = "client2Fallback")
    @GetMapping("/client2")
    public String client2(String name) {

        String response = restTemplate.getForObject("http://Eureka-Provider/hi",
                String.class);

        return response + " " + name;
    }

    @GetMapping("/feign")
    public String feign() {

        String response = customApi.hi(100,
                "lb");

        return "consumer port:" + port + "->>>>> provider " + response;
    }

    private String client2Fallback(String name) {
        return "name:" + name + " client2 fallback了...";
    }

}
