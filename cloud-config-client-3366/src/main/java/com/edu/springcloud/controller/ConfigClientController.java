package com.edu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wyg_edu
 * @version 1.0
 * @date 2020/4/6 21:01
 */
@RestController
@Slf4j
@RefreshScope// 启用刷新
public class ConfigClientController {
    @Value("${config.info}")
    private String serverInfo;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/configInfo")
    public String getServerInfo(){
        return serverInfo + "**" + serverPort;
    }
}
