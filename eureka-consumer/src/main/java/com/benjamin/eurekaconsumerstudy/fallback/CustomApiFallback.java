package com.benjamin.eurekaconsumerstudy.fallback;

import com.benjamin.eurekaconsumerstudy.api.CustomApi;
import org.springframework.stereotype.Component;

/**
 * @author Ben Li.
 * @since: 2020/7/15 10:33 上午
 */
@Component
public class CustomApiFallback implements CustomApi {
    @Override
    public String hi(Integer id, String name) {
        return "/hi fallback了...";
    }
}
