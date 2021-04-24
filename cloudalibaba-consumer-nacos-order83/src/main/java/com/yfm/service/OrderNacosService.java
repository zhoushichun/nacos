package com.yfm.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "nacos-payment-provider")
@Service
public interface OrderNacosService {

    @GetMapping(value = "/payment/nacos")
    String getPayment();

}
