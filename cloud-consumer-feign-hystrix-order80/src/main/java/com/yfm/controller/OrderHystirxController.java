package com.yfm.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.yfm.comment.result.Result;
import com.yfm.service.PaymentHystrixService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod") //全局降级处理
public class OrderHystirxController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @ApiOperation(value = "查询信息", notes = "查询信息")
    @PostMapping("/listAll")
    public Result listAll() {
        Result list = paymentHystrixService.listAll();
        return list;
    }

    @ApiOperation(value = "查询信息3秒", notes = "查询信息3秒")
    @PostMapping("/listHystrix")
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "20000")
    })
    public Result listHystrix() {
        Result add = paymentHystrixService.listHystrix();
        return add;
    }


    public Result payment_Global_FallbackMethod() {
        return Result.FAIL("这是全局降级处理+降级+熔断！！！");
    }

    @ApiOperation(value = "查询信息熔断", notes = "查询信息熔断")
    @PostMapping("/list")
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//开启熔断
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//超过10次请求
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//10秒内
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),//失败率超过……60%
    })
    public Result list(Integer id ) {

        String list = paymentHystrixService.listAllHystrix(id);
        return Result.SUCCESS(list);
    }

}

