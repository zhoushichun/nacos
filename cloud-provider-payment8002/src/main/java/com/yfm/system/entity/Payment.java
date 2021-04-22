package com.yfm.system.entity;


import com.yfm.system.base.entity.DataEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 订单
 * </p>
 *
 * @author zhou
 * @since 2021-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Payment对象", description="订单")
public class Payment extends DataEntity<Payment> {


    @ApiModelProperty(value = "序号")
    private String serial;


}
