package com.edu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author wyg_edu
 * @version 1.0
 * @date 2020/4/5 17:35
 */
@Component// 进行同期扫描
public class PaymentFallBackService implements PaymentHysrtixService {
    @Override
    public String paymentInfo_timeout(Integer id) {
        return "--------paymentFallBackService fall back paymentInfo_timeout---------";
    }

    @Override
    public String paymentInfo_OK(Integer id) {
        return "--------paymentFallBackService fall back paymentInfo_OK---------";
    }
}
