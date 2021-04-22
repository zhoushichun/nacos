package com.yfm.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yfm.system.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 *
 *@ClassName:订单 Mapper 接口
 *@Description:
 *@author: zhou
 *@date 2021-04-16
 *
 */
 @Mapper
 @Repository
public interface PaymentMapper extends BaseMapper<Payment> {

 /**
 * @Title: 物理批量删除
 * @Description: <p></p>
 * @author: zhou
 * @date: 2021-04-16
 * @param: int []arr = new int []{,}
 * @return: boolean
 * @throws
 */
 Boolean doRemoveeIds(long[] arr);

}
