package com.edu.springboot.service;

import com.edu.springcloud.entities.CommonResult;
import com.edu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author wis_edu
 * @date 2020/4/4
 */
@Component// 把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")// 指定服务调用
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")    //哪个地址
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/feign/timeout")
    public String PaymentTimOut() throws InterruptedException;

}
