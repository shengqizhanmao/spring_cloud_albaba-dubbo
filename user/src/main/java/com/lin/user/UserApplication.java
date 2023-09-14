package com.lin.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@Slf4j
public class UserApplication {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext run = SpringApplication.run(UserApplication.class, args);
        while(true){
            String name = run.getEnvironment().getProperty("name");
            String type = run.getEnvironment().getProperty("type");
            log.info("user:"+name+"----"+"type:"+type);
            TimeUnit.SECONDS.sleep(10);
        }
    }

}
