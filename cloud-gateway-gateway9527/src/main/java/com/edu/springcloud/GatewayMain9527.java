package com.edu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author wyg_edu
 * @version 1.0
 * @date 2020/4/6 9:31
 */
@SpringBootApplication
@EnableEurekaClient// 标注Eureka客户端
public class GatewayMain9527 {
    public static void main(String[] args) {
        SpringApplication.run(GatewayMain9527.class, args);
    }
}
