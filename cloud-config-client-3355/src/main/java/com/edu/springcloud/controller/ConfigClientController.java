package com.edu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wyg_edu
 * @version 1.0
 * @date 2020/4/6 16:55
 */
@RestController
@Slf4j
@RefreshScope// 刷新功能
public class ConfigClientController {
    @Value("${config.info}")
    private String configClient;

    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return configClient;
    }
}
