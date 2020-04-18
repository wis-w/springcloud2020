package com.edu.springcloud.service;

import com.edu.springcloud.entities.CommonResult;
import com.edu.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author wyg_edu
 * @version 1.0
 * @date 2020/4/18 11:51
 */
@Component
public class PaymentFallbackService implements  PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444,"服务降价返回，来自于PaymentFallbackService",new Payment(id,"error"));
    }
}
