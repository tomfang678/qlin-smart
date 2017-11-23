package com.qlin.smart.api;

import com.qlin.smart.bean.Goods;
import com.qlin.smart.common.MessageInfo;
import com.qlin.smart.common.model.CommonParam;
import com.qlin.smart.common.model.PageResult;

public interface IGoods {
    Goods getGood(Integer id);

    MessageInfo<PageResult<Goods>> getList(CommonParam param);

    Integer addGoods(Goods goods);
}
