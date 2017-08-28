package com.woo.web.controller;

import com.woo.domain.Result;
import com.woo.service.service.DemoService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wuminggu on 2017/8/28.
 */
@Controller
@RequestMapping("/demo")
public class DemoController {
    private final Logger LOGGER = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    private DemoService demoService;

    @RequestMapping(value = "/home/getDemoList",method = RequestMethod.POST)
    @ResponseBody
    public Result getDemoResult() {
        Result result = new Result();
        try {
            result = demoService.getDemoResult();
        } catch (Exception e) {
            result.setSuccess(false);
            result.setErrorMsg("取得数据为null");
            LOGGER.error("demoResult is null");
            return result;
        }

        result.setSuccess(true);
        return result;

    }
}
