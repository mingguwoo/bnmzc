package com.woo.service.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wuminggu on 2017/8/28.
 */
public class DemoJobService {
    private final Logger LOGGER = LoggerFactory.getLogger(DemoJobService.class);
    public void execute() {
        long time = System.currentTimeMillis();
        System.out.println("调用定时任务" + time);
        LOGGER.error("调用定时任务",time);
    }
}
