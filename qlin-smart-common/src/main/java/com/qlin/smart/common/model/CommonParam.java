package com.qlin.smart.common.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者：tomfang
 * 日期：2017-11-22
 * 描述：
 */
public class CommonParam implements Serializable {

    private static final long serialVersionUID = 7908147397361452249L;

    private String user;

    private String logFlag = "1";

    private Object data;

    public String getLogFlag() {
        return logFlag;
    }

    public void setLogFlag(String logFlag) {
        this.logFlag = logFlag;
    }

    /**
     * 根据参数类型获取参数
     */
    public <U> U getData(Class<U> targetClass) {
        if (data != null) {
            if (data instanceof JSONObject) {
                return JSON.toJavaObject((JSON) data, targetClass);
            } else {
                return targetClass.cast(data);
            }
        }
        return null;
    }

    /**
     * 根据参数类型获取参数集合
     */
    public <U> List<U> getDatas(Class<U> targetClass) {
        List<U> uList = null;
        if (data != null && data instanceof JSONArray) {
            uList = new ArrayList<>();
            List datas = (List) data;
            for (Object o : datas) {
                if (o instanceof JSON) {
                    U u = JSON.toJavaObject((JSON) o, targetClass);
                    uList.add(u);
                } else {
                    U u = targetClass.cast(o);
                    uList.add(u);
                }
            }
        }
        return uList;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

