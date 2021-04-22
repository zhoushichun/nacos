package com.yfm.service;

import com.yfm.comment.result.Result;
import com.yfm.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(value = "CLOUD-PROVIDER-PAYMENT")
@Service
public interface PaymentFeignService {


    @GetMapping("/system/payment/listAll")
    Result listAll();

    @PostMapping("/system/payment/add")
    Result add(@RequestBody Payment entity);
}
