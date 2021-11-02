package com.hoaipx.learn2021.pxh;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "Success")
    private boolean success;

    @ApiModelProperty(value = "Message")
    private String message;

    @ApiModelProperty(value = "Message code")
    private String messageCode;

    @ApiModelProperty(value = "Code")
    private Integer code;

    @ApiModelProperty(value = "Timestamp")
    private long timestamp = System.currentTimeMillis();

    @ApiModelProperty(value = "Result object")
    private T result;

}
