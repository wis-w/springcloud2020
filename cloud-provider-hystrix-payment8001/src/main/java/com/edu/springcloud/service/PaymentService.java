package com.edu.springcloud.service;

/**
 * @author wyg_edu
 * @version 1.0
 * @date 2020/4/5 10:55
 */
public interface PaymentService {

    public String paymentInfo_OK(Integer id);

    public String paymentInfo_TimeOut(Integer id);

}
