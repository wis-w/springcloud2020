package com.edu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wis_edu
 * @date 2020/4/2
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule getRule(){
        return new RandomRule();
    }
}
