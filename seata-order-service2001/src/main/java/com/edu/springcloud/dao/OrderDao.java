package com.edu.springcloud.dao;

import com.edu.springcloud.doMain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author wyg_edu
 * @version 1.0
 * @date 2020/4/18 18:14
 */
@Mapper
public interface OrderDao {
    // 1、新建订单模块
    void create(Order order);

    //2、修改订单状态
    void updae(@Param("userId") Long userId, @Param("status") int status);

}
