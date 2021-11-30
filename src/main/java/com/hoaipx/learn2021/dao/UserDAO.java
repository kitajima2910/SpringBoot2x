package com.hoaipx.learn2021.dao;

import com.hoaipx.learn2021.base.BaseDAO;
import com.hoaipx.learn2021.entity.User;

public interface UserDAO extends BaseDAO<User, String> {

    /**
     * Exists by username
     * @param username username
     * @return boolean
     */
    boolean existsByUsername(String username);

    /**
     * Find by username
     * @param username username
     * @return User
     */
    User findByUsername(String username);

}
