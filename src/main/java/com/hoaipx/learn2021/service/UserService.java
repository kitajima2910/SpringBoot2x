package com.hoaipx.learn2021.service;

import com.hoaipx.learn2021.base.BaseService;
import com.hoaipx.learn2021.entity.User;

import java.util.concurrent.Future;

public interface UserService extends BaseService<User, String> {

    /**
     * Signup
     * @param user
     * @return Integer
     */
    Future<?> signup(User user);

}
