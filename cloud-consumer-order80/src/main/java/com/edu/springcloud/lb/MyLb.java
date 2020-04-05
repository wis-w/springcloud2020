package com.edu.springcloud.lb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wis_edu
 * @date 2020/4/4
 * 定制版轮询算法
 */

@Component// 容器正常扫描，包放在启动类的扫描下
@Slf4j
public class MyLb implements LoadBalance {

    private AtomicInteger atomicInteger = new AtomicInteger(0);// 默认初始值0

    /**
     * CompareAndSet(CAS)
     * @return
     */
    public final int getAndiAnInt(){
        int current;// 当前值
        int next;// 期望值
        do {
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next));// 达到期望值时才会跳出，原子锁，较Synchronized更加高效
        log.info("***访问次数next" + next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> ServiceInstance) {
        int index = getAndiAnInt() % ServiceInstance.size();
        return ServiceInstance.get(index);
    }

}
