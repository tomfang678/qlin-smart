package com.qlin.smart.controller;

import com.qlin.smart.api.IGoods;
import com.qlin.smart.bean.Goods;
import com.qlin.smart.bean.SearchBean;
import com.qlin.smart.common.MessageInfo;
import com.qlin.smart.common.MessageStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 作者：tomfang
 * 日期：2017-08-24
 * 描述：
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private IGoods goodsService;

    @RequestMapping(value = "/getById", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
    @ResponseBody
    public Goods getGoods(Integer id) {
        return goodsService.getGood(id);
    }

    @RequestMapping("/getList")
    @ResponseBody
    public MessageInfo<List<Goods>> getGoodsList(SearchBean searchBean) {
        MessageInfo<List<Goods>> msg = new MessageInfo<List<Goods>>();
        try {
            List<Goods> list = goodsService.getList(searchBean);
            msg.setData(list);
            return msg;
        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatusAndMessage(MessageStatus.SYS_ERROR.getStatus(), e.getMessage());
        }
        return msg;
    }
}
