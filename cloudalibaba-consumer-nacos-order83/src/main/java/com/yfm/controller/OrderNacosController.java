package com.yfm.controller;


import com.yfm.service.OrderNacosService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderNacosController {


    @Resource
    private OrderNacosService orderNacosService;

    @GetMapping("/orderNacosService")
    public String getPayment() {
        return orderNacosService.getPayment();
    }

}
