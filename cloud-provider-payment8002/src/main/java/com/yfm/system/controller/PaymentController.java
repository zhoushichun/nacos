package com.yfm.system.controller;

import com.yfm.comment.result.Result;
import com.yfm.comment.base.controller.BaseController;
import com.yfm.system.entity.Payment;
import com.yfm.system.service.IPaymentService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;


/**
*
* @ClassName:订单 前端控制器
* @Description:
* @author: zhou
* @date 2021-04-16
*
*/
@RestController
@RequestMapping("/system/payment")
@Api(value="/system/payment",tags={"订单信息"})
@Slf4j
public class PaymentController extends BaseController {

    @Autowired
    IPaymentService  PaymentService;

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
    @GetMapping("/list")
    public Result listAll(){
        List<Payment> payments = PaymentService.listAll();
        return Result.SUCCESS(payments);
    }

    /**
     * @Title: 增加/修改
     * @author: zhou
     * @date 2021-04-16
     * @date: 2020/5/7 16:48
     * @param:
     * @return:
     * @throws
     */
    @ApiOperation(value = "增加/修改", notes = "增加/修改")
    @PostMapping("/add")
    public Result add(@RequestBody Payment entity){


        return PaymentService.add(entity) ;
    }

    /**
     * @Title: 删除
     * @Description: <p>删除使用物理删除</p>
     * @author: zhou
     * @date 2021-04-16
     * @param:
     * @return:
     * @throws
     */
    @ApiOperation(value = "物理删除", notes = "物理删除")
    @DeleteMapping("/delete")
    public Result delete(@RequestParam long[] arr){

        return  PaymentService.delete(arr) ;
    }

    /**
     * @Title: 逻辑删除
     * @Description: <p>逻辑删除</p>
     * @author: zhou
     * @date 2021-04-16
     * @param:
     * @return:
     * @throws
     */
    @ApiOperation(value = "逻辑删除", notes = "逻辑删除")
    @DeleteMapping("/deleteIds")
    public Result deleteIds(@RequestParam long[] ids){
        return PaymentService.deleteIds(ids);
    }
}
