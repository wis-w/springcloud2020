package com.edu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wis_edu
 * @date 2020/3/29
 */
@SpringBootApplication
@EnableDiscoveryClient// 改注解用于向使用consul与zookpeer作为注册中心时使用
public class PaymentMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class, args);
    }
}
