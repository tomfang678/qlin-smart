package com.qlin.smart.service.test;

import com.qlin.smart.api.IGoods;
import com.qlin.smart.bean.Goods;
import com.qlin.smart.dao.IGoodsMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 作者：tomfang
 * 日期：2017-08-24
 * 描述：
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class goodsTest {

    @Resource
    private IGoods iGoods;

    @Resource
    private IGoodsMapper goodsMapper;

    @Test
    public void getOneTest() {
        try {
            Goods goods = new Goods();
            goods.setId(6);
            goods.setIntnlCode("555");
            goods.setName("测试2");
            goods.setProductDate(new Date());
            goods.setRemark("test");
            goods.setAuthor("tom");
            goods.setCreateDate(new Date());
            Integer result = goodsMapper.insert(goods);
            Assert.assertEquals(1, (long) result);
            goods = iGoods.getGood(1);
            Assert.assertEquals("123", goods.getIntnlCode());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
