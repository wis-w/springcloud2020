package com.edu.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @author wyg_edu
 * @version 1.0
 * @date 2020/4/6 10:45
 */
@Component
@Slf4j
public class MyLogGrteWayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("这个是一个拦截器，come in 全局过滤器" + new Date());
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if (null == uname) {
            log.info("uname为空，非法用户，禁止进入");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;// 数字越小级别越高
    }
}
