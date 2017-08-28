package com.woo.dao.impl;

import com.woo.dao.DemoDao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by wuminggu on 2017/8/28.
 */
@Repository("DemoDao")
public class DemoDaoImpl implements DemoDao {

    @Autowired SqlSessionTemplate demoSqlSession;

    public Integer getDemoResult() {
        return demoSqlSession.selectOne("Demo.getDemoResult");
    }
}
