
package com.yfm.system.service;

import com.yfm.comment.result.Result;
import com.yfm.comment.base.service.BaseService;
import com.yfm.system.entity.Payment;

import java.util.List;
/**
*
* @ClassName:订单 服务类
* @Description:
* @author: zhou
* @date 2021-04-16
*
*/
public interface IPaymentService extends BaseService<Payment> {


    List<Payment>  listAll();

    Result add(Payment entity);

    Result delete(long[] arr);

    Result deleteIds(long[] ids);

}
