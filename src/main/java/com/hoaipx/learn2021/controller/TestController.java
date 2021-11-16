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

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/test")
@Api(tags = "Test")
public class TestController {

    @Autowired
    private TestTableService testTableService;

    @GetMapping("/getAll")
    @ApiOperation(value = "Get all")
    public Result<Object> getAll() {
        return ResultUtil.data(testTableService.getAll());
    }

    @PostMapping("/createData")
    @ApiOperation(value = "Create data")
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
    @ApiOperation(value = "Update data")
    public Result<Object> updateData(@RequestBody TestTableRequest testTableRequest) {

        // Model -> Entity
        TestTable testTable = new TestTable();
        testTable.setId(testTableRequest.getId())
                .setName(testTableRequest.getName());
        testTableService.updateDate(testTable);

        return ResultUtil.success("Successfully.");
    }

    @DeleteMapping("/deleteData/{id}")
    @ApiOperation(value = "Delete data")
    public Result<Object> delete(@PathVariable int id) {

        testTableService.deleteData(id);

        return ResultUtil.success("Successfully.");
    }

    @PostMapping("/createBatch")
    @ApiOperation(value = "Crete batch")
    public Result<Object> createBatch(@RequestBody List<TestTableRequest> testTableRequests) {

        if(testTableRequests == null || testTableRequests.isEmpty()) {
            return ResultUtil.error("Fail.");
        }

        List<TestTable> testTables = new ArrayList<>();
        for(TestTableRequest testTableRequest : testTableRequests) {
            TestTable testTable = new TestTable();
            testTable.setId(testTableRequest.getId())
                    .setName(testTableRequest.getName());
            testTables.add(testTable);
        }

        testTableService.createBatch(testTables);

        return ResultUtil.success("Successfully.");
    }

    @PutMapping("/modifiedBatch")
    @ApiOperation(value = "Modified batch")
    public Result<Object> modifiedBatch(@RequestBody List<TestTableRequest> testTableRequests) {

        if(testTableRequests == null || testTableRequests.isEmpty()) {
            return ResultUtil.error("Fail.");
        }

        List<TestTable> testTables = new ArrayList<>();
        for(TestTableRequest testTableRequest : testTableRequests) {
            TestTable testTable = new TestTable();
            testTable.setId(testTableRequest.getId())
                    .setName(testTableRequest.getName());
            testTables.add(testTable);
        }

        testTableService.modifiedBatch(testTables);

        return ResultUtil.success("Successfully.");
    }

    @PutMapping("/createAndModifiedBatch")
    @ApiOperation(value = "Create And Modified batch")
    public Result<Object> createAndModifiedBatch(@RequestBody List<TestTableRequest> testTableRequests) {

        if(testTableRequests == null || testTableRequests.isEmpty()) {
            return ResultUtil.error("Fail.");
        }

        List<TestTable> testTables = new ArrayList<>();
        for(TestTableRequest testTableRequest : testTableRequests) {
            TestTable testTable = new TestTable();
            testTable.setId(testTableRequest.getId())
                    .setName(testTableRequest.getName());
            testTables.add(testTable);
        }

        testTableService.createAndModifiedBatch(testTables);

        return ResultUtil.success("Successfully.");
    }

}
