package com.edu.springcloud.controller;

import com.edu.springcloud.service.PaymentHysrtixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author wyg_edu
 * @version 1.0
 * @date 2020/4/5 12:12
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "fallbackMethod")// 全局定义对象
public class OrderHysrtixController {

    @Resource
    private PaymentHysrtixService paymentHysrtixservice;

    @GetMapping(value = "/coument/payment/hystrix/ok/{id}")
    public String getHystrix_Ok(@PathVariable("id") Integer id) {
        log.info("Hystrix的控制层  成功  的调用id= " + id);
        return paymentHysrtixservice.paymentInfo_OK(id);
    }

    @GetMapping(value = "/coument/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "getHystrix_timeoutFallbackMethod",commandProperties ={
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })// 程序发生异常或者超时时候的方案
    @HystrixCommand//全局的选择方案
    public String getHystrix_timeout(@PathVariable("id") Integer id) {
        log.info("Hystrix的控制层  超时  的调用id= " + id);
        int a = 1 / 0;
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("睡眠结束了，开始调用服务端");
        return paymentHysrtixservice.paymentInfo_timeout(id);
    }

    public String getHystrix_timeoutFallbackMethod(@PathVariable("id") Integer id){
        return ("Hystrix的80客户端控制层  超时  的调用id= " + id + "请稍后重试");
    }

    /**
     * 全局fallback方法
     */
    public String fallbackMethod() {
        return "80客户端的全局fallback对象";
    }

}
