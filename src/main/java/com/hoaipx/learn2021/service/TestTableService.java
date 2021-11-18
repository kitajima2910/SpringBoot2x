package com.hoaipx.learn2021.service;

import com.hoaipx.learn2021.base.BaseService;
import com.hoaipx.learn2021.common.utils.PageHelper;
import com.hoaipx.learn2021.entity.TestTable;
import org.aspectj.weaver.ast.Test;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.concurrent.CompletableFuture;

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

    /**
     * Delete data
     * @param id id
     */
    void deleteData(int id);

    /**
     * Create batch
     * @param testTables testTables
     */
    void createBatch(List<TestTable> testTables);

    /**
     * Modified batch
     * @param testTables testTables
     */
    void modifiedBatch(List<TestTable> testTables);

    /**
     * Create and modified batch
     * @param testTables testTables
     */
    void createAndModifiedBatch(List<TestTable> testTables);

    /**
     * Get TestTable
     * @param id id
     */
    CompletableFuture<TestTable> getTestTable(int id) throws InterruptedException;

    /**
     * Get all by condition
     * @param testTable
     * @param pageHelper
     * @return
     */
    CompletableFuture<Page<TestTable>> getAllByCondition(TestTable testTable, PageHelper pageHelper);

    /**
     * Delete batch
     * @param ids ids
     */
    void deleteBatch(Integer[] ids); // Test Mybatis with Stored Procedure call

}
