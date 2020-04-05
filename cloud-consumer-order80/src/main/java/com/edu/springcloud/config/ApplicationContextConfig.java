package com.edu.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author wyg_edu
 * @version 1.0
 * @date 2020/3/22 20:21
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    // @LoadBalanced// 开启了负载均衡能力 默认时轮询机制
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
