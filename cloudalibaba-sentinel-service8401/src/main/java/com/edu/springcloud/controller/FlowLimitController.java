package com.edu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wyg_edu
 * @version 1.0
 * @date 2020/4/14 21:22
 */
@RestController
@Slf4j
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA(){
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB(){
        System.out.println(Thread.currentThread().getName()+"/t"+"...testB");
        return "------testB";
    }

    @GetMapping("/testD")
    public String testD(){
        System.out.println("testD RT");
        return "___testD";
    }
}
