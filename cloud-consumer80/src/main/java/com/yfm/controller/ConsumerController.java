package com.yfm.controller;

import com.yfm.comment.result.Result;
import com.yfm.entity.Payment;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    private static final  String url="http://cloud-provider-payment";
    /**
     * @Title: 查询信息
     * @Description: <p></p>
     * @author: zhou
     * @date 2021-04-16
     * @param:
     * @return:
     * @throws
     */
    @ApiOperation(value = "查询信息", notes = "查询信息")
    @PostMapping("/list")
    public Result list(){
        Result forObject = restTemplate.getForObject(url + "/system/payment/list", Result.class);
        return forObject;
    }

    @ApiOperation(value = "zhengjia", notes = "zhengjia")
    @PostMapping("/add")
    public Result add( Payment payment){
        Result result = restTemplate.postForObject(url + "/system/payment/add", payment, Result.class);
        return result;
    }
}
