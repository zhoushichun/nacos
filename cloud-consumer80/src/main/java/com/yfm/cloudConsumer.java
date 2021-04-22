package com.yfm;

import com.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration= MySelfRule.class)//换方式的时候打开这个
public class cloudConsumer {
    public static void main(String[] args) {
        SpringApplication.run(cloudConsumer.class,args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
         return  new RestTemplate();
    }
}
