package com.edu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author wis_edu
 * @date 2020/3/25
 */
@SpringBootApplication
@EnableEurekaServer// 标注这个是一个注册中心
public class EurakeMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurakeMain7001.class, args);
    }
}
