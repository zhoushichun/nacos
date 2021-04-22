package com.yfm.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {

    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "序号")
    private String serial;
}
