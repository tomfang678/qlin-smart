package qlin.smart.base.dao;

import java.util.List;

/**
 * 作者：fangbin fangbin12@metersbonwe.com
 * 日期：2017-08-24
 * 描述：
 */
public interface IBaseDao<T> {

    int deleteByPrimaryKey(Object id);

    int insert(T record);

    int insertSelective(T t);

    int insertByBatch(List<T> t);

    int insertByBatch(List<T> t, String SqlName);

    T selectByPrimaryKey(Object id);

    int updateByPrimaryKeySelective(T t);

    int updateByPrimaryKey(T t);

    int updateByBatch(List<T> t);

    int updateByBatch(List<T> t, String SqlName);

}
