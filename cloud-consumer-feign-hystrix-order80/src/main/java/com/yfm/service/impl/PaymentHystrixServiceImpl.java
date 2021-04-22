package com.yfm.service.impl;


import com.yfm.comment.result.Result;
import com.yfm.service.PaymentHystrixService;
import org.springframework.stereotype.Component;



@Component
public class PaymentHystrixServiceImpl implements PaymentHystrixService {

    @Override
    public Result listAll() {
        return Result.FAIL("这个是正常的");
    }

    @Override
    public Result listHystrix() {
        return Result.FAIL("这个需要等3秒 服务降级");
    }

    @Override
    public String listAllHystrix( Integer id) {
        return "这是熔断";
    }


}
