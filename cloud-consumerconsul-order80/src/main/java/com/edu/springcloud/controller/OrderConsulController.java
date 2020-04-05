package com.edu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author wis_edu
 * @date 2020/3/31
 */
@RestController
@Slf4j
public class OrderConsulController {

    private String PATH_URL = "http://consul-provider-payment";

    @Resource
    private RestTemplate template;

    @GetMapping(value = "/consumer/payment/consul")
    public String paymentInfo(){
        log.info("lalalal");
        return template.getForObject(PATH_URL + "/payment/consul", String.class);
    }

}
