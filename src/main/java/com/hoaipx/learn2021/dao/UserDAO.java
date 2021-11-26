package com.hoaipx.learn2021.dao;

import com.hoaipx.learn2021.base.BaseDAO;
import com.hoaipx.learn2021.entity.User;

public interface UserDAO extends BaseDAO<User, String> {

    boolean existsByUsername(String username);

}
