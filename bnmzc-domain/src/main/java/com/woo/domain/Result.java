package com.woo.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wuminggu on 2017/8/28.
 */
public class Result {
    /**
     * 是否成功
     */
    private boolean success;
    /**
     * service返回的对象
     */
    private Object data;
    private int code;
    private String errorMsg;
    private Map<String, Object> oth;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Object getFromOth(String key) {
        if (null == oth)
            return null;
        return oth.get(key);
    }

    public void addOthParam(String key, Object value) {
        if (null == oth)
            oth = new HashMap<String, Object>();

        oth.put(key, value);
    }
}
