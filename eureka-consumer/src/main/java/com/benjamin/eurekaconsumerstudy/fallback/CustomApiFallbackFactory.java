package com.benjamin.eurekaconsumerstudy.fallback;

import com.benjamin.eurekaconsumerstudy.api.CustomApi;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author Ben Li.
 * @since: 2020/7/15 10:58 上午
 */
@Component
public class CustomApiFallbackFactory implements FallbackFactory<CustomApi> {
    @Override
    public CustomApi create(Throwable cause) {
        return new CustomApi() {
            @Override
            public String hi(Integer id, String name) {
                System.out.println("id:" + id);
                System.out.println("name:" + name);
                cause.printStackTrace();

                return "/hi fallbackFactory了...";
            }
        };
    }
}
