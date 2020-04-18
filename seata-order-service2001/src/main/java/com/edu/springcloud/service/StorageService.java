package com.edu.springcloud.service;

import com.edu.springcloud.doMain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import javax.websocket.server.PathParam;

/**
 * @author wyg_edu
 * @version 1.0
 * @date 2020/4/18 20:40
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {
    @PostMapping(value = "/storage/decrease")
    CommonResult decrease(@PathParam("productId")Long prodectId,@PathParam("count")Integer count);
}
