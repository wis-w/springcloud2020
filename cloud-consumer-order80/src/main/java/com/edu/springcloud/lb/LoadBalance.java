package com.edu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author wis_edu
 * @date 2020/4/4
 */
public interface LoadBalance {

    ServiceInstance instances(List<ServiceInstance> ServiceInstance);

}
