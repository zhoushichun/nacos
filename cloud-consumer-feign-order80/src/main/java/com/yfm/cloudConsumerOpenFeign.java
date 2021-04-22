package com.yfm;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class cloudConsumerOpenFeign {
    public static void main(String[] args) {
        SpringApplication.run(cloudConsumerOpenFeign.class,args);
    }


    @Bean
    Logger.Level feignLoggerLevel()
    {
        return Logger.Level.FULL;
    }

}
