package com.yfm.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
@RefreshScope
public class NacosPaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${add.add1}")
    private String service;

    @GetMapping(value = "/payment/nacos")
    public String getPayment() {
        return "nacos registry, serverPort: "+ serverPort+"==="+service;
    }
}
