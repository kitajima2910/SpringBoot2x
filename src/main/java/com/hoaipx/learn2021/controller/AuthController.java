package com.hoaipx.learn2021.controller;

import com.hoaipx.learn2021.common.Constant;
import com.hoaipx.learn2021.common.utils.ResultUtil;
import com.hoaipx.learn2021.entity.User;
import com.hoaipx.learn2021.payload.request.UserRequest;
import com.hoaipx.learn2021.pxh.Result;
import com.hoaipx.learn2021.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/auth")
@Api(tags = "User")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder encoder;

    @PostMapping("/signUp")
    @ApiOperation(value = "Sign up")
    public Result<Object> signUp(@RequestBody UserRequest userRequest) throws ExecutionException, InterruptedException {

        User user = new User();
        user.setUsername(userRequest.getUsername())
                .setPassword(encoder.encode(userRequest.getPassword()));

        userService.signup(user).get();

        return ResultUtil.success(Constant.ADD_SUCCESSFULLY);
    }

//    @PostMapping("/signUpV2")
//    @ApiOperation(value = "Sign up V2")
//    public Result<Object> signInV2(@RequestBody UserRequest userRequest) throws ExecutionException, InterruptedException {
//
//        User user = new User();
//        user.setUsername(userRequest.getUsername())
//                .setPassword(encoder.encode(userRequest.getPassword()));
//
//        userService.signup(user).get();
//
//        return ResultUtil.success(Constant.ADD_SUCCESSFULLY);
//    }

    @PostMapping("/signIn")
    @ApiOperation(value = "Sign in")
    public Result<Object> signIn(@RequestBody UserRequest userRequest) {

        return ResultUtil.success("Successfully.");
    }
}
