package com.benjamin.eurekaconsumerstudy.api;

import com.benjamin.eurekaproviderstudy.api.HiApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("Eureka-Provider")
public interface CustomApi extends HiApi {
}
