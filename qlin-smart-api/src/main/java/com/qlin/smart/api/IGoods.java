package com.qlin.smart.api;

import com.qlin.smart.bean.Goods;

import java.util.List;

public interface IGoods {
    Goods getGood(Integer id);

    List<Goods> getList();

    Integer addGoods(Goods goods);
}
