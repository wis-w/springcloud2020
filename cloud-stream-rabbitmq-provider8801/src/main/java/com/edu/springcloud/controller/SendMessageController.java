package com.edu.springcloud.controller;

import com.edu.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wyg_edu
 * @version 1.0
 * @date 2020/4/7 21:30
 */
@RestController
public class SendMessageController {
    @Resource
    private IMessageProvider provider;

    @GetMapping(value = "/sendMessage")
    public String sendMes(){
        return provider.send();
    }
}
