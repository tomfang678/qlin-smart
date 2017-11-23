package com.qlin.smart.common.model;

import java.io.Serializable;
import java.util.List;

/**
 * 作者：tomfang
 * 日期：2017-11-23
 * 描述：
 */
public class PageResult<E> implements Serializable {

    private Integer pages;  //总页数
    private List<E> records;//分页查询的结果列表
    private Long total;     //总记录数

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public List<E> getRecords() {
        return records;
    }

    public void setRecords(List<E> records) {
        this.records = records;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
