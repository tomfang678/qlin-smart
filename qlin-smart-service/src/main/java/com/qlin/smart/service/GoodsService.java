package com.qlin.smart.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qlin.smart.api.IGoods;
import com.qlin.smart.bean.Goods;
import com.qlin.smart.bean.SearchBean;
import com.qlin.smart.common.MessageInfo;
import com.qlin.smart.common.MessageStatus;
import com.qlin.smart.common.model.CommonParam;
import com.qlin.smart.common.model.PageResult;
import com.qlin.smart.dao.IGoodsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 作者：tomfang
 * 日期：2017-08-24
 * 描述：
 */
@Service("goodsService")
public class GoodsService implements IGoods {
    private static Logger logger = LoggerFactory.getLogger(GoodsService.class);

    @Autowired
    private IGoodsMapper goodsDaoImpl;

    @Override
    public Goods getGood(Integer id) {
        try {
            return goodsDaoImpl.selectByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 分页获取数据样例
     *
     * @param
     * @return
     */
    @Override
    public MessageInfo<PageResult<Goods>> getList(CommonParam param) {
        MessageInfo<PageResult<Goods>> msg = new MessageInfo<PageResult<Goods>>();
        try {
            PageResult<Goods> pageResult = new PageResult<Goods>();
            SearchBean searchBean = param.getData(SearchBean.class);
            Page<Object> page = PageHelper.startPage(searchBean.getCurPage(), searchBean.getPageSize());
            List<Goods> list = goodsDaoImpl.selectByConditions(searchBean);
            pageResult.setRecords(list);
            pageResult.setTotal(page.getTotal());
            msg.setData(pageResult);
            msg.setStatusAndMessage(MessageStatus.OK.getStatus(), "获取成功");
        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatusAndMessage(MessageStatus.SYS_ERROR.getStatus(), "获取数据出现异常");
        }

        return msg;
    }

    @Override
    public Integer addGoods(Goods goods) {
        try {
            return goodsDaoImpl.insert(goods);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
