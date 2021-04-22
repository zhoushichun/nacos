package com.yfm.service;


import com.yfm.comment.result.Result;
import com.yfm.service.impl.PaymentHystrixServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback= PaymentHystrixServiceImpl.class)
public interface PaymentHystrixService {


    @GetMapping("/system/payment/listAll")
    Result listAll();

    @GetMapping("/system/payment/listHystrix")
    Result listHystrix();

    @PostMapping("/system/payment/list")
    String listAllHystrix( @RequestParam (value = "id") Integer id );


}
