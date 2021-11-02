package com.hoaipx.learn2021.serviceimpl;

import com.hoaipx.learn2021.base.BaseDAO;
import com.hoaipx.learn2021.dao.TestTableDAO;
import com.hoaipx.learn2021.entity.TestTable;
import com.hoaipx.learn2021.service.TestTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestTableServiceImpl implements TestTableService {

    @Autowired
    private TestTableDAO testTableDAO;

    @Override
    public BaseDAO<TestTable, Integer> getRepository() {
        return testTableDAO;
    }

}
