package com.edu.springboot.controller;

import com.edu.springboot.service.PaymentFeignService;
import com.edu.springcloud.entities.CommonResult;
import com.edu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wis_edu
 * @date 2020/4/4
 */
@RestController
@Slf4j
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id")Long id) {
        log.info("*进入feign测试环节id={}", new Object[]{id});
        return paymentFeignService.getPaymentById(id);
    }
    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String getFeignTimrOut() throws InterruptedException {
        log.info("feign准备时间超时了");
        // openFign-riben默认1秒钟超时
        return paymentFeignService.PaymentTimOut();
    }
}
