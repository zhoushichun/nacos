package com.yfm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient //注册进去Eureka
@EnableFeignClients //openfeign
@EnableHystrix//服务降级
public class OrderHystrixMain80 {
    public static void main(String[] args) {

        SpringApplication.run(OrderHystrixMain80.class,args);
    }
}
