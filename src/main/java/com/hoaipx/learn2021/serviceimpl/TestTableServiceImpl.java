package com.hoaipx.learn2021.serviceimpl;

import com.hoaipx.learn2021.base.BaseDAO;
import com.hoaipx.learn2021.common.exception.PXHException;
import com.hoaipx.learn2021.common.utils.PageHelper;
import com.hoaipx.learn2021.dao.TestTableDAO;
import com.hoaipx.learn2021.dao.mapper.TestTableMapper;
import com.hoaipx.learn2021.entity.TestTable;
import com.hoaipx.learn2021.pxh.PageUtil;
import com.hoaipx.learn2021.service.TestTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@Transactional(rollbackFor = { RuntimeException.class, Exception.class, PXHException.class })
public class TestTableServiceImpl implements TestTableService {

    @Autowired
    private TestTableDAO testTableDAO;

    @Autowired
    private TestTableMapper testTableMapper;

    @Override
    public BaseDAO<TestTable, Integer> getRepository() {
        return testTableDAO;
    }

    /**
     * Save data
     * @param testTable testTable
     */
    @Async("asyncExecutor")
    public void saveData(TestTable testTable) {
        if(testTable.getId() != null && testTableDAO.existsById(testTable.getId())) {
            throw new PXHException("TestTable ID is duplicate.");
        }
        testTableDAO.saveAndFlush(testTable);
    }

    @Override
    @Async("asyncExecutor")
    public void updateDate(TestTable testTable) {
        if(testTable.getId() == null || !testTableDAO.existsById(testTable.getId())) {
            throw new PXHException("TestTable ID not exist.");
        }

        TestTable testTableOld = testTableDAO.findById(testTable.getId()).get();
        testTableOld.setName(testTable.getName());

        testTableDAO.saveAndFlush(testTableOld);
    }

    @Override
    @Async("asyncExecutor")
    public void deleteData(int id) {
        if(!testTableDAO.existsById(id)) {
            throw new PXHException("TestTable ID not exist.");
        }

        TestTable testTableOld = testTableDAO.findById(id).get();
        testTableOld.setFlagDel(1);

        testTableDAO.saveAndFlush(testTableOld);
    }

    @Override
    @Async("asyncExecutor")
    public void createBatch(List<TestTable> testTables) {

        if(testTables.isEmpty()) {
            throw new PXHException("TestTables contains no elements.");
        }

        for(TestTable testTable : testTables) {
            testTableDAO.saveAndFlush(testTable);
        }
    }

    @Override
    @Async("asyncExecutor")
    public void modifiedBatch(List<TestTable> testTables) {

        if(testTables.isEmpty()) {
            throw new PXHException("TestTables contains no elements.");
        }

        for(TestTable testTable : testTables) {

            if(testTable.getId() == null || !testTableDAO.existsById(testTable.getId())) {
                throw new PXHException("TestTable ID not exist.");
            }

            testTableDAO.saveAndFlush(testTable);
        }

    }

    @Override
    @Async("asyncExecutor")
    public void createAndModifiedBatch(List<TestTable> testTables) {

        if(testTables.isEmpty()) {
            throw new PXHException("TestTables contains no elements.");
        }

        for(TestTable testTable : testTables) {

            // Create data
            if(testTable.getId() == null) {
                testTableDAO.saveAndFlush(testTable);
            }

            if(!testTableDAO.existsById(testTable.getId())) {
                throw new PXHException("TestTable ID not exist.");
            }

            // Modified data
            TestTable testTableOld = testTableDAO.findById(testTable.getId()).get();
            testTableOld.setName(testTable.getName());
            testTableDAO.saveAndFlush(testTableOld);
        }

    }

    @Override
    @Async("asyncExecutor")
    public CompletableFuture<TestTable> getTestTable(int id) {

        if(!testTableDAO.existsById(id)) {
            throw new PXHException("TestTable ID not exist.");
        }

        TestTable testTable = testTableDAO.findById(id).get();
        return CompletableFuture.completedFuture(testTable);

    }

    @Override
    @Async("asyncExecutor")
    public CompletableFuture<Page<TestTable>> getAllByCondition(TestTable testTable, PageHelper pageHelper) {

        List<TestTable> testTables = testTableMapper.getAllByCondition(testTable, pageHelper);
        Page<TestTable> testTablePage = new PageImpl<>(PageUtil.listToPage(pageHelper, testTables), PageUtil.initPage(pageHelper), pageHelper.getPageSize());

        return CompletableFuture.completedFuture(testTablePage);
    }

    @Override
    @Async("asyncExecutor")
    public void deleteBatch(Integer[] ids) {

        if(ids == null || ids.length == 0) {
            throw new PXHException("TestTables contains no elements.");
        }

        for(Integer id : ids) {
            if(id == null || !testTableDAO.existsById(id)) {
                throw new PXHException("TestTable ID not exist.");
            }

            testTableMapper.deleteById(id);
//            TestTable testTable = testTableDAO.findById(id).get();
//            testTable.setFlagDel(1);
//            testTableDAO.saveAndFlush(testTable);
        }

    }

}
