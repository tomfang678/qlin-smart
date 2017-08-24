package com.qlin.smart.service;

import com.qlin.smart.api.IGoods;
import com.qlin.smart.bean.Goods;
import com.qlin.smart.bean.SearchBean;
import com.qlin.smart.dao.IGoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 作者：fangbin fangbin12@metersbonwe.com
 * 日期：2017-08-24
 * 描述：
 */
@Service("goodsService")
public class GoodsService implements IGoods {
    @Autowired
    private IGoodsMapper goodsDaoImpl;

    @Override
    public Goods getGood(Integer id) {
        return goodsDaoImpl.selectByPrimaryKey(id);
    }

    @Override
    public List<Goods> getList(SearchBean searchBean) {
        return null;
    }

    @Override
    public Integer addGoods(Goods goods) {
        return goodsDaoImpl.insert(goods);
    }
}
