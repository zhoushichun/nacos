
package com.yfm.system.service.impl;


import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Lists;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.yfm.comment.result.RCode;
import com.yfm.comment.result.Result;
import com.yfm.system.entity.Payment;
import com.yfm.system.mapper.PaymentMapper;
import com.yfm.system.service.IPaymentService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName:订单 服务实现类
 * @Description:
 * @author: zhou
 * @date 2021-04-16
 */
@Service

public class PaymentServiceImpl extends com.yfm.comment.base.service.impl.BaseServiceImpl<PaymentMapper, Payment> implements IPaymentService {
    @Override
    public List<Payment> listAll() {
        QueryWrapper<Payment> queryWrapper = new QueryWrapper<>();
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public Result add(Payment entity) {
        if (entity == null) {
            return Result.FAIL("不能为空");
        }
        //新增
        if (entity.getId() == null) {
            int insert = baseMapper.insert(entity);
            if (insert != 1) {
                return Result.FAIL("新增数据失败");
            }
            return Result.SUCCESS(RCode.SUCCESS);
        }
        //修改
        int update = baseMapper.updateById(entity);
        if (update != 1) {
            return Result.FAIL();
        }
        return Result.SUCCESS(RCode.SUCCESS);
    }

    @Override
    public Result delete(long[] arr) {

        Boolean aBoolean = baseMapper.doRemoveeIds(arr);
        if (!aBoolean) {
            return Result.FAIL();
        }
        return Result.SUCCESS(aBoolean);

    }

    @Override
    public Result deleteIds(long[] ids) {
        ArrayList<Long> objects = Lists.newArrayList();
        for (int i = 0; i < ids.length; i++) {
            objects.add(ids[i]);
        }
        int i = baseMapper.deleteBatchIds(objects);
        if (i == 0) {
            return Result.FAIL();
        }
        return Result.SUCCESS(RCode.SUCCESS);
    }

    //超时3秒就有问题
    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")
    })
    public List<Payment> listHystrix() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
            QueryWrapper<Payment> queryWrapper = new QueryWrapper<>();
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//开启熔断
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//超过10次请求
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//10秒内
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),//失败率超过……60%
    })

    public String listAllHystrix(Integer id) {

        if(id < 0)
        {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + serialNumber;
    }

    public String paymentCircuitBreaker_fallback( Integer id)
    {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " +id;
    }


    public List<Payment> paymentInfo_TimeOutHandler() {

        ArrayList<Object> objects = new ArrayList<>();


        return null;
    }
}
