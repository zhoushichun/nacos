
package com.yfm.system.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Lists;
import com.yfm.comment.result.RCode;
import com.yfm.comment.result.Result;
import com.yfm.system.entity.Payment;
import com.yfm.system.mapper.PaymentMapper;
import com.yfm.system.service.IPaymentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
*
*@ClassName:订单 服务实现类
*@Description:
*@author: zhou
*@date 2021-04-16
*
*/
@Service
public class PaymentServiceImpl extends com.yfm.comment.base.service.impl.BaseServiceImpl<PaymentMapper, Payment> implements IPaymentService {
    @Override
    public List<Payment>  listAll() {
        QueryWrapper<Payment> queryWrapper = new QueryWrapper<>();
        return  baseMapper.selectList(queryWrapper);
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
        if(!aBoolean){
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
        if (i==0) {
            return Result.FAIL();
        }
        return Result.SUCCESS(RCode.SUCCESS);
    }
}
