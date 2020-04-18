package com.edu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.edu.springcloud.entities.CommonResult;
import com.edu.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author wyg_edu
 * @version 1.0
 * @date 2020/4/18 10:46
 */
@RestController
public class CircleBreakerController {
    public static final String SERVER_URL = "http://nacos-payment-provider";

    @Resource
    RestTemplate restTemplate;

    @GetMapping("/consumer/fallback/{id}")
    @SentinelResource(value = "fallback", fallback = "handlerFallBack",blockHandler = "blockHandler",
                        exceptionsToIgnore = {IllegalArgumentException.class})// 排除java异常种类
//    @SentinelResource(value = "fallback", blockHandler = "blockHandler")
    public CommonResult<Payment> fallback(@PathVariable Long id) {
        CommonResult<Payment> result = null;
        result = restTemplate.getForObject(SERVER_URL + "/paymentSQL/" + id, CommonResult.class, id);
        if (id == 4) {
            throw new IllegalArgumentException("参数非法异常。。。。。");
        }
        if (null == result.getData()) {
            throw new IllegalArgumentException("没有改参数数据，引发空指针异常");
        }
        return result;
    }

    public CommonResult<Payment> handlerFallBack(@PathVariable Long id,Throwable error){
        Payment payment = new Payment(id, "null");
        CommonResult<Payment> result = new CommonResult<>(444, "我是fallback方案" + error.getMessage(), payment);
        return result;
    }

    public CommonResult<Payment> blockHandler(@PathVariable Long id, BlockException error){
        Payment payment = new Payment(id, "null");
        CommonResult<Payment> result = new CommonResult<>(555, "我是blockHandler方案" + error.getMessage(), payment);
        return result;
    }
}
