package com.benjamin.eurekaclientstudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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

            RestTemplate restTemplate = new RestTemplate();
            response = restTemplate.getForObject(url,
                    String.class);

            System.out.println("response: " + response);
        }

        return response;
    }
}