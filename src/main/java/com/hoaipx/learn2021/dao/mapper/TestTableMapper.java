package com.hoaipx.learn2021.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hoaipx.learn2021.common.utils.PageHelper;
import com.hoaipx.learn2021.entity.TestTable;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TestTableMapper extends BaseMapper<TestTable> {

    /**
     * Get all buy condition
     * @param testTable testTable
     * @param pageHelper pageHelper
     * @return List
     */
    List<TestTable> getAllByCondition(@Param("testTable") TestTable testTable,
                                      @Param("pageHelper") PageHelper pageHelper);

    /**
     * Delete by id
     * @param id id
     */
    void deleteById(@Param("id") int id);

}
