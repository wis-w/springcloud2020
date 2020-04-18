package com.edu.springcloud.service.impl;

import com.edu.springcloud.dao.OrderDao;
import com.edu.springcloud.doMain.Order;
import com.edu.springcloud.service.AccountService;
import com.edu.springcloud.service.OrderService;
import com.edu.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wyg_edu
 * @version 1.0
 * @date 2020/4/18 20:38
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;

    @Resource
    private AccountService accountservice;

    @Resource
    private StorageService storageService;

    @Override
    public void create(Order order) {
       log.info("---->开始新建订单");
       orderDao.create(order);

       log.info("----->微服务开始调用库存，扣减库存，做减法--start");
       storageService.decrease(order.getProductId(), order.getCount());
       log.info("----->微服务开始调用库存，扣减库存，做减法--end");

       log.info("----->微服务开始支付模块，扣减金额，做减法---start");
       accountservice.decrease(order.getUserId(), order.getMoney());
       log.info("----->微服务开始支付模块，扣减金额，做减法---end");

       log.info("------>开始修改订单状态，修改成完成时");
       orderDao.updae(order.getUserId(), 0);
       log.info("-------交易结束---------");
    }
}
