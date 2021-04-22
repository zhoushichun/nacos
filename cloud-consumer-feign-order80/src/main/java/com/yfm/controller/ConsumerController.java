package com.yfm.controller;

import com.yfm.comment.result.Result;
import com.yfm.entity.Payment;
import com.yfm.service.PaymentFeignService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ConsumerController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @ApiOperation(value = "查询信息", notes = "查询信息")
    @PostMapping("/list")
    public Result listAll() {
        Result list = paymentFeignService.listAll();
        return list;
    }

    @ApiOperation(value = "增加", notes = "增加")
    @PostMapping("/add")
    public Result add(Payment payment) {
        Result add = paymentFeignService.add(payment);
        return add;
    }


}
