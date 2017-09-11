package com.woo.service.service.impl;

import com.woo.dao.DemoDao;
import com.woo.domain.Result;
import com.woo.service.service.DemoService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wuminggu on 2017/8/28.
 */
@Service("demoService")
public class DemoServiceImpl implements DemoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Autowired
    private DemoDao demoDao;

    public Result getDemoResult() {
        Result result = new Result();
        Integer res = demoDao.getDemoResult();
        if (res == null) {
            result.setSuccess(false);
            result.setErrorMsg("数据为空");
        }
        result.setData(res);
        return result;
    }
}
