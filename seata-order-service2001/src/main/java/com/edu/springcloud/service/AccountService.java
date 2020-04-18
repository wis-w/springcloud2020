package com.edu.springcloud.service;

import com.edu.springcloud.doMain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import javax.websocket.server.PathParam;
import java.math.BigDecimal;

/**
 * @author wyg_edu
 * @version 1.0
 * @date 2020/4/18 20:40
 */
@FeignClient(value = "seata-accout-service")
public interface AccountService {
    @PostMapping(value = "/accout/decrease")
    CommonResult decrease(@PathParam("userId")Long userId, @PathParam("money") BigDecimal money);
}
