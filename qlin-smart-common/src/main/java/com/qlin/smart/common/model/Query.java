package com.qlin.smart.common.model;

import java.io.Serializable;

/**
 * 作者：tomfang
 * 日期：2017-11-23
 * 描述：
 */
public class Query implements Serializable {
    private static final long serialVersionUID = 1L;

    private int pageIndex = 1;//当前页
    private int pageSize = 10;//一页显示多少条

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
