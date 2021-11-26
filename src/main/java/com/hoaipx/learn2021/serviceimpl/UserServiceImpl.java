package com.hoaipx.learn2021.serviceimpl;


import com.hoaipx.learn2021.base.BaseDAO;
import com.hoaipx.learn2021.common.exception.PXHException;
import com.hoaipx.learn2021.dao.UserDAO;
import com.hoaipx.learn2021.entity.User;
import com.hoaipx.learn2021.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Service
@Transactional(rollbackFor = { RuntimeException.class, Exception.class, PXHException.class })
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public BaseDAO<User, String> getRepository() {
        return userDAO;
    }

    @Override
    @Async("asyncExecutor")
    public Future<?> signup(User user) {
        if(userDAO.existsByUsername(user.getUsername())) {
            throw new PXHException("Username already exists.");
        }

        // Asynchronous process
        return CompletableFuture.supplyAsync(() -> userDAO.saveAndFlush(user));
    }
}
