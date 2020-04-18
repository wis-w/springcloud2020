package com.edu.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author wyg_edu
 * @version 1.0
 * @date 2020/4/18 21:09
 */
@Configuration
@MapperScan({"com.edu.springcloud.dao"})
public class MyBatisConfig {
}
