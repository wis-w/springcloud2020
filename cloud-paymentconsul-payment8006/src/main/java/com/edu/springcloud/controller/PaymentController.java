package com.edu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author wis_edu
 * @date 2020/3/31
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    public String serverPort;

    @GetMapping(value = "/payment/consul")
    public String payment(){
        log.info("consul测试");
        return "springCloud console" + serverPort + "/t" + UUID.randomUUID().toString();
    }

}
