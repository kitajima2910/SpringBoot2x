package com.hoaipx.learn2021.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
@Api(tags = "Test")
public class TestController {

    @GetMapping("/content")
    @ApiOperation(value = "Test")
    public ResponseEntity<Object> getAllSubCode() {
        return ResponseEntity.ok("Test 20211101");
    }

}
