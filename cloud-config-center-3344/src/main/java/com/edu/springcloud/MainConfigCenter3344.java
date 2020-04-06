package com.edu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author wyg_edu
 * @version 1.0
 * @date 2020/4/6 16:18
 */
@SpringBootApplication
@EnableConfigServer
public class MainConfigCenter3344 {
    public static void main(String[] args) {
        SpringApplication.run(MainConfigCenter3344.class, args);
    }
}
