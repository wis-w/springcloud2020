package com.edu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//         }
        int a = 10 / 0;
        log.info("testD");
        return "___testD";
    }

    /**
     * blockHandler该方案只对限流起作用，不包括运行异常
     */
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "dealTestHotKey")// 开启热点限流 value可以为任意 并指定方案
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        return "=--= HOSTKEY-";
    }

    public String dealTestHotKey(String p1, String p2, BlockException exception) {// 参数列表
        return "=--= HOSTKEY=--=error";
    }
}
