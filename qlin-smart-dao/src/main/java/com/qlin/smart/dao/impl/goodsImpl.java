package com.qlin.smart.dao.impl;

import com.qlin.smart.bean.Goods;
import com.qlin.smart.dao.IGoodsMapper;
import org.springframework.stereotype.Repository;
import qlin.smart.base.dao.impl.BaseDaoImpl;

/**
 * 作者：fangbin fangbin12@metersbonwe.com
 * 日期：2017-08-24
 * 描述：
 */
@Repository
public class goodsImpl extends BaseDaoImpl<Goods> implements IGoodsMapper {
    @Override
    protected String getNameSpace() {
        return "com.qlin.smart.dao.IGoodsMapper.";
    }
}
