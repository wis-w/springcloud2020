package com.edu.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author wis_edu
 * @date 2020/3/26
 */
@SpringBootApplication
@EnableEurekaServer
public class EurakeMain7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurakeMain7002.class, args);
    }
}
