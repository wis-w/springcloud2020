package com.edu.springcloud.controller;

import com.edu.springcloud.doMain.CommonResult;
import com.edu.springcloud.doMain.Order;
import com.edu.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wyg_edu
 * @version 1.0
 * @date 2020/4/18 21:06
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult(200, "订单成功了",null);
    }

}
