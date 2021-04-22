
package com.yfm.system.base.entity;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel
public abstract class DataEntity<T extends Model> extends BaseEntity<T> {

//    /**
//     * 实体类上面才有效果，继承的没用。。
//     *
//     * @JsonIgnore：返回不显示的字段 hidden = true swagger 不显示该字段
//     */
//    @ApiModelProperty(value = "创建时间")
////    @JsonIgnore
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
//    @TableField(value = "create_date", fill = FieldFill.INSERT)
//    private Date createDate;
//
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
//    @ApiModelProperty(value = "更新时间")
////    @JsonIgnore
//    @TableField(value = "update_date", fill = FieldFill.INSERT_UPDATE)
//    private Date updateDate;
//
//    @TableLogic
//    @ApiModelProperty(value = "删除标记",hidden = true)
//    @JsonIgnore
//    @TableField(value = "deleted")
//    private Integer deleted=0;
//
//    @JsonIgnore
//    @ApiModelProperty(value = "状态")
//    private Integer status=0;
//
//    @ApiModelProperty(value = "备注")
//    private String remark;

}
