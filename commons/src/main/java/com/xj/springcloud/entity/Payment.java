package com.xj.springcloud.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ApiModel(value = "文件详情")
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    private String id;
    @ApiModelProperty(value = "文件名")
    private String serial;
}
