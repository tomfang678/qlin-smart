package com.qlin.smart.api;

import com.qlin.smart.bean.Goods;
import com.qlin.smart.bean.SearchBean;

import java.util.List;

public interface IGoods {
    Goods getGood(Integer id);

    List<Goods> getList(SearchBean searchBean);

    Integer addGoods(Goods goods);
}
