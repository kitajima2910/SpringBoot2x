package com.hoaipx.learn2021.service;

import com.hoaipx.learn2021.base.BaseService;
import com.hoaipx.learn2021.entity.TestTable;

public interface TestTableService extends BaseService<TestTable, Integer> {

    /**
     * Save data
     * @param testTable
     */
    void saveData(TestTable testTable);

}
