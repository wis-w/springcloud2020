package com.edu.springcloud.service;


import com.edu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author wyg_edu
 * @version 1.0
 * @date 2020/3/22 10:39
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentByID(@Param("id") Long id);

}
