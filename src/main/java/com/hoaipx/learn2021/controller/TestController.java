package com.hoaipx.learn2021.controller;

import com.hoaipx.learn2021.entity.TestTable;
import com.hoaipx.learn2021.payload.request.TestTableRequest;
import com.hoaipx.learn2021.pxh.Result;
import com.hoaipx.learn2021.service.TestTableService;
import com.hoaipx.learn2021.common.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/createData")
    @ApiOperation(value = "Create Data")
    public Result<Object> createData(@RequestBody TestTableRequest testTableRequest) {

        // Model -> Entity
        TestTable testTable = new TestTable();
        testTable.setId(testTableRequest.getId())
                .setName(testTableRequest.getName());
        testTableService.saveData(testTable);

        return ResultUtil.success("Successfully.");
    }

    // GET, POST, PUT, DELETE
    // PATCH
    @PutMapping("/updateData")
    @ApiOperation(value = "Update Data")
    public Result<Object> updateData(@RequestBody TestTableRequest testTableRequest) {

        // Model -> Entity
        TestTable testTable = new TestTable();
        testTable.setId(testTableRequest.getId())
                .setName(testTableRequest.getName());
        testTableService.updateDate(testTable);

        return ResultUtil.success("Successfully.");
    }

}
