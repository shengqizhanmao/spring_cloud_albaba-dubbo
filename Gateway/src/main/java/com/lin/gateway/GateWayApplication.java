package com.lin.gateway;

import com.lin.gateway.config.LoadBalancerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;

/**
 * @author lin
 * @version 22:10
 * @date 2023-08-26
 */
@SpringBootApplication
// 开启负载均衡
@LoadBalancerClients(defaultConfiguration = LoadBalancerConfig.class)
// 根据服务开启不同地负载均衡
//@LoadBalancerClients(defaultConfiguration = LoadBalancerConfig.class, value = {@LoadBalancerClient(name = "service-provider", configuration = LoadBalancerConfig.class), @LoadBalancerClient(name = "service-consumer", configuration = LoadBalancerConfig.class)})
//开启负载均衡,默认是轮询
//@LoadBalancerClients
public class GateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GateWayApplication.class, args);
    }
}
