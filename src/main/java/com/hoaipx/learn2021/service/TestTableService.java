package com.hoaipx.learn2021.service;

import com.hoaipx.learn2021.base.BaseService;
import com.hoaipx.learn2021.entity.TestTable;

public interface TestTableService extends BaseService<TestTable, Integer> {

    /**
     * Save data
     * @param testTable testTable
     */
    void saveData(TestTable testTable);

    /**
     * Update date
     * @param testTable testTable
     */
    void updateDate(TestTable testTable);

}
