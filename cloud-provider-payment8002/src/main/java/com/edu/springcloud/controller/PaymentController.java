package com.edu.springcloud.controller;


import com.edu.springcloud.entities.CommonResult;
import com.edu.springcloud.entities.Payment;
import com.edu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author wyg_edu
 * @version 1.0
 * @date 2020/3/22 10:46
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult creat(@RequestBody Payment payment){
        log.info("controller增加payment表信息");
        int rs = paymentService.create(payment);
        if (rs > 0) {
            return new CommonResult(200, "插入成功", rs);
        } else {
            return new CommonResult(444, "失败了", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult select(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentByID(id);
        log.info("业务端口号{}", new Object[]{serverPort});
        log.info("controller查询payment表信息{}", new Object[]{payment});
        if (payment != null) {
            return new CommonResult(200, "查询成功了" + serverPort, payment);
        } else {
            return new CommonResult(444, "查询没有记录id=" + id, null);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLb(){
        return serverPort;
    }

    /**
     * 自动超时设置
     */
    @GetMapping(value = "/payment/feign/timeout")
    public String PaymentTimOut() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return serverPort;
    }

}


