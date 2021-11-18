package com.hoaipx.learn2021.common.utils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PageHelper implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "Page number")
    private int pageNumber;

    @ApiModelProperty(value = "Page size")
    private int pageSize;

    @ApiModelProperty(value = "Sort field")
    private String sortField;

    @ApiModelProperty(value = "Sort by asc/desc")
    private String sortBy;

}
