package com.edu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author wyg_edu
 * @version 1.0
 * @date 2020/4/9 21:21
 */
@RestController
public class OrderNacosController {
    @Resource
    private RestTemplate template;

    @Value("${service-url.nacos-user-service}")// 避免写死地址
    private String serverUrl;

    @GetMapping(value = "/consumer/payment/nacos/{id}")
    public String getPayemnt(@PathVariable("id") long id) {
        return template.getForObject(serverUrl + "/payment/nacos/" + id, String.class);
    }
}
