package com.edu.springboot.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wis_edu
 * @date 2020/4/4
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevrl(){
        return Logger.Level.FULL;
    }
}
