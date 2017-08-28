package com.woo.web.aop;

import com.woo.dao.impl.DemoDaoImpl;
import com.woo.domain.BnmzcLog;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * Created by wuminggu on 2017/8/28.
 */
@Aspect
public class bnmzcLogAspect {
    private final Logger LOGGER = LoggerFactory.getLogger(bnmzcLogAspect.class);

    @After("execution(public * com.jd.assignments.dao..*.*(..))")
    public void afterLog(JoinPoint jp) throws Throwable {
        try {
            String className = jp.getTarget().getClass().getName();
            String methodName = jp.getSignature().getName();
            if (className.equals(DemoDaoImpl.class.getName()))
                return;
            if (methodName.contains("insert") || methodName.contains("update")) {
                BnmzcLog log = new BnmzcLog();
                log.setOperator("system");
                log.setOperation(className + "." + methodName);
                String str = "";
                Object[] objs = jp.getArgs();
                if (null != objs && objs.length > 0) {
                    List<Object> list = Arrays.asList(objs);
//                    str = JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd HH:mm:ss");
                }
                log.setValue(str);
//                assignmentLogDao.insertAssignmentLog(log);
            }
        } catch (Exception e) {
            LOGGER.error("AssignmentLogAspect afterLog exception", e);
        }
    }
}
