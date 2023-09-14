package com.lin.gateway.filter;

import org.apache.http.client.utils.DateUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @author lin
 * @version 22:16
 * @date 2023-08-26
 */
@Component
public class GateWayGlobalFilter implements GlobalFilter, Ordered {



    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("=============================================");
        String date = DateUtils.formatDate(new Date(), "yyyy-MM-dd hh:mm:ss");
        System.out.println("网关时间："+date);
//        String username = exchange.getRequest().getQueryParams().getFirst("username");
//        if(username==null){
//            System.out.println("用户名为null，非法用户！！！");
//            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
//            return exchange.getResponse().setComplete();
//        }

        ServerHttpRequest request = exchange.getRequest();
        System.out.println("请求地址："+request.getPath());
        System.out.println("请求地址："+request.getURI());
        System.out.println("请求方式："+request.getMethod());
        System.out.println("请求参数："+request.getQueryParams());
        System.out.println("请求头："+request.getHeaders());
        System.out.println("请求体："+request.getBody());
        System.out.println("=============================================");
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
