package com.qfedu.onedrive.api.config;

import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FeignConfig {
    private int connecttimeout=10000;//10秒
    private int readtimeout=10000;//10秒
    @Bean
    public Request.Options createOp(){
        return new Request.Options(connecttimeout,readtimeout);
    }
}
