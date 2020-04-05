package com.edu.springcloud.service.impl;


import com.edu.springcloud.dao.PaymentDao;
import com.edu.springcloud.entities.Payment;
import com.edu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wyg_edu
 * @version 1.0
 * @date 2020/3/22 10:39
 */
@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    @Resource
    PaymentDao paymentDao;

    @Override
    public int create(Payment payment){
        log.info("Service进行parment增加信息了");
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentByID(Long id){
        log.info("Service进行payment表的查询id= {}", new Object[]{id});
        return paymentDao.getPaymentById(id);
    }

}
