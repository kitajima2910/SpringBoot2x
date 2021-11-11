package com.hoaipx.learn2021.serviceimpl;

import com.hoaipx.learn2021.base.BaseDAO;
import com.hoaipx.learn2021.common.exception.PXHException;
import com.hoaipx.learn2021.dao.TestTableDAO;
import com.hoaipx.learn2021.entity.TestTable;
import com.hoaipx.learn2021.service.TestTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = { RuntimeException.class, Exception.class, PXHException.class })
public class TestTableServiceImpl implements TestTableService {

    @Autowired
    private TestTableDAO testTableDAO;

    @Override
    public BaseDAO<TestTable, Integer> getRepository() {
        return testTableDAO;
    }

    /**
     * Save data
     * @param testTable testTable
     */
    public void saveData(TestTable testTable) {
        if(testTable.getId() != null && testTableDAO.existsById(testTable.getId())) {
            throw new PXHException("TestTable ID is duplicate.");
        }
        testTableDAO.saveAndFlush(testTable);
    }

    @Override
    public void updateDate(TestTable testTable) {
        if(testTable.getId() == null || !testTableDAO.existsById(testTable.getId())) {
            throw new PXHException("TestTable ID not exist.");
        }

        TestTable testTableOld = testTableDAO.findById(testTable.getId()).get();
        testTableOld.setName(testTable.getName());

        testTableDAO.saveAndFlush(testTableOld);
    }

}
