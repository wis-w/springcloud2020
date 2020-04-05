package com.edu.springcloud.service.impl;

import com.edu.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author wyg_edu
 * @version 1.0
 * @date 2020/4/5 10:56
 */
@Slf4j
@Service
public class PaymentServiceImpl implements PaymentService {
    /**
     * 正常访问业务
     * @param id
     * @return
     */
    @Override
    public String paymentInfo_OK(Integer id) {
        return "线程池： " + Thread.currentThread().getName() + "  PaymentInfo_OK: " + id + "\t" + "OKOKOKOK";
    }

    /**
     * 模拟错误的请求
     *
     * @param id
     * @return
     */
    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_timeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })// 指定错误后的运行方法:出现异常，或者时超时3秒
    public String paymentInfo_TimeOut(Integer id) {
//            int a = 10 / 0;
        try {
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池： " + Thread.currentThread().getName() + "  paymentInfo_TimeOut: " + id + "\t" + "OKOKOK耗时4秒";
    }

    public String paymentInfo_timeoutHandler(Integer id) {
        log.info("8001服务端超时了");
        return "线程池： " + Thread.currentThread().getName() + "  8001服务异常请稍后重试: " + id;
    }

    //********** 服务熔断开始***************

    // 服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),                    //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "101"),       //请求数达到后才计算
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //休眠时间窗
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),     //错误率达到多少跳闸  // 10(窗口期)秒钟内10次请求错误率达到60%
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if(id < 0){
            throw  new RuntimeException("****id 不能为负数");
        }

        return Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + UUID.randomUUID().toString().replace("-","");
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "8001服务端 id 不能为负数,请稍后再试， o(╥_╥)o id: " + id;
    }
    //********** 服务熔断结束***************
}
