package com.edu.springcloud.controller;


import com.edu.springcloud.entities.CommonResult;
import com.edu.springcloud.entities.Payment;
import com.edu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
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

    @Value("${server.port}")// 读取yaml的配置属性
    private String serverPort;

    @Resource// 服务发现
    public DiscoveryClient discoveryClient;

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

    @GetMapping("/payment/discovery")
    public Object doscover(){
        // 获取该服务的基本信息
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("***element" + element);
        }

        List<ServiceInstance> list = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : list) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() +   "\t"+instance.getPort() + "\t" + instance.getUri());
        }
        return discoveryClient;
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

    @GetMapping(value = "/payment/zipkin")
    public String paymentZipkin(){
        return "进行信息采集了";
    }
}


