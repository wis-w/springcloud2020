package com.edu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author wyg_edu
 * @version 1.0
 * @date 2020/4/9 21:20
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced// 开启负载均衡
    public RestTemplate getConfig(){
        return new RestTemplate();
    }
}
