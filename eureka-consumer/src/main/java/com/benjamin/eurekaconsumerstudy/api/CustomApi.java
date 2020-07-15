package com.benjamin.eurekaconsumerstudy.api;

import com.benjamin.eurekaconsumerstudy.fallback.CustomApiFallback;
import com.benjamin.eurekaconsumerstudy.fallback.CustomApiFallbackFactory;
import com.benjamin.eurekaproviderstudy.api.HiApi;
import org.springframework.cloud.openfeign.FeignClient;

//@FeignClient(value = "Eureka-Provider", fallback = CustomApiFallback.class)
@FeignClient(value = "Eureka-Provider", fallbackFactory = CustomApiFallbackFactory.class)
public interface CustomApi extends HiApi {
}
