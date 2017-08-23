package com.qlin.smart.api;

import com.qlin.smart.bean.Good;

import java.util.List;

public interface IGoods {
    Good getGood(Integer id);

    List<Good> getList();
}
