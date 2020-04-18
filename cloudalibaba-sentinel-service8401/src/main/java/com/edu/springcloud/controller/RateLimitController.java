package com.edu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.edu.springcloud.myHandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wyg_edu
 * @version 1.0
 * @date 2020/4/17 21:12
 */
@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource" , blockHandler = "handException")
    public String byResource(){
//        return new CommonResult(200, "按照资查询OK", new Payment(2020L, "seria001"));
        return "success";
    }


    public String handException(BlockException blockException){
//        return new CommonResult(444, blockException.getMessage().toString()+"服务不可用");
        return "error";
    }

    @GetMapping("/rateLimit/byURL")
    @SentinelResource(value = "byURL")
    public String buURL(){
        return "byURL";
    }

    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",blockHandlerClass = CustomerBlockHandler.class,blockHandler = "handExeption2" )// 指定处理类，指定处理方法
    public String customerBlockHandler(){
        return "客户自定义成功";
    }

}


