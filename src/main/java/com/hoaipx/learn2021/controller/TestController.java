package com.hoaipx.learn2021.controller;

import com.hoaipx.learn2021.pxh.Result;
import com.hoaipx.learn2021.service.TestTableService;
import com.hoaipx.learn2021.common.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
@Api(tags = "Test")
public class TestController {

    @Autowired
    private TestTableService testTableService;

    @GetMapping("/getAll")
    @ApiOperation(value = "Get All")
    public Result<Object> getAll() {
        return ResultUtil.data(testTableService.getAll());
    }

}
