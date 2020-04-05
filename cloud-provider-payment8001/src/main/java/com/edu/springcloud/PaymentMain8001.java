package com.edu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * PaymentApplication class
 *
 * @author  WYG
 * @date 2020/03/21
 */
@EnableEurekaClient// 启动Eurake
@SpringBootApplication
@EnableDiscoveryClient// 获取该服务基本信息
public class PaymentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class, args);
    }
}
