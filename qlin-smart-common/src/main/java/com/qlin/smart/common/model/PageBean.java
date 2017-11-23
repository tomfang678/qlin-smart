package com.qlin.smart.common.model;

import java.io.Serializable;

/**
 * 作者：tomfang
 * 日期：2017-11-23
 * 描述：
 */
public class PageBean implements Serializable {
    private int start;
    private int end;
    private int pageSize = 10;
    private int curPage = 1;

    public int getStart() {
        return (curPage - 1) * pageSize + 1;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return curPage * pageSize;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
