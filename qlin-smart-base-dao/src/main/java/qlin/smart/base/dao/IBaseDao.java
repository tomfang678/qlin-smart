package qlin.smart.base.dao;

import com.qlin.smart.bean.SearchBean;

import java.util.List;

/**
 * 作者：fangbin fangbin12@metersbonwe.com
 * 日期：2017-08-24
 * 描述：
 */
public interface IBaseDao<T> {

    /**
     * 根据ID删除指定项
     *
     * @param
     * @return
     */
    int deleteByPrimaryKey(Object id) throws Exception;

    /**
     * 批量删除
     *
     * @param
     * @return
     */
    int deleteByBatch(List<Object> list) throws Exception;

    /**
     * 新增
     *
     * @param
     * @return
     */
    int insert(T record) throws Exception;

    /**
     * 选择插入
     *
     * @param
     * @return
     */
    int insertSelective(T t) throws Exception;

    /**
     * 批量插入
     *
     * @param
     * @return
     */
    int insertByBatch(List<T> t) throws Exception;

    /**
     * 批量插入
     *
     * @param
     * @return
     */
    int insertByBatch(List<T> t, String SqlName) throws Exception;

    /**
     * 选择指定项
     *
     * @param
     * @return
     */
    T selectByPrimaryKey(Object id) throws Exception;

    /**
     * 选择更新
     *
     * @param
     * @return
     */
    int updateByPrimaryKeySelective(T t) throws Exception;

    /**
     * 更新
     *
     * @param
     * @return
     */
    int updateByPrimaryKey(T t) throws Exception;

    /**
     * 批量更新
     *
     * @param
     * @return
     */
    int updateByBatch(List<T> t) throws Exception;

    /**
     * 批量更新
     *
     * @param
     * @return
     */
    int updateByBatch(List<T> t, String SqlName) throws Exception;

    /**
     * 功能：获取分页数据
     */
    List<T> selectByConditions(SearchBean searchBean) throws Exception;

    /**
     * 功能：获取总条数
     */
    int selectTotalByConditions(SearchBean searchBean) throws Exception;


}
