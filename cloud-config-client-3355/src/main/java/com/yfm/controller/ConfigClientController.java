package com.yfm.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope //config动态刷新
public class ConfigClientController {

    @Value("${server.info}")
    private String info;

    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return info;
    }
}
