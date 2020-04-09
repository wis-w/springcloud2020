package com.edu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wyg_edu
 * @version 1.0
 * @date 2020/4/9 20:51
 */
@RestController
public class PayemntController {
    @Value("${server.port}")
    public String serverPort;

    @GetMapping(value = "/payment/nacos/{id}")
    public String getPayemnt(@PathVariable("id") long id) {
        return "nacos registry, serverport: " + serverPort + "\t id:" + id;
    }
}
