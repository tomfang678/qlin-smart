package qlin.smart.base.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import qlin.smart.base.dao.IBaseDao;

import javax.annotation.Resource;
import java.util.List;

/**
 * 作者：fangbin fangbin12@metersbonwe.com
 * 日期：2017-08-24
 * 描述：
 */
public abstract class BaseDaoImpl<T> implements IBaseDao<T> {
    @Resource
    protected SqlSessionTemplate localSqlSession;

    protected abstract String getNameSpace();

    @Override
    public int deleteByPrimaryKey(Object id) {
        return localSqlSession.delete(getNameSpace() + "deleteByPrimaryKey", id);
    }

    @Override
    public int insert(T record) {
        return localSqlSession.insert(getNameSpace() + "insert", record);
    }

    @Override
    public int insertSelective(T t) {
        return localSqlSession.insert(getNameSpace() + "insertSelective", t);
    }

    @Override
    public int insertByBatch(List<T> t) {
        return 0;
    }

    @Override
    public int insertByBatch(List<T> t, String SqlName) {
        return 0;
    }

    @Override
    public T selectByPrimaryKey(Object id) {
        return localSqlSession.selectOne(getNameSpace() + "selectByPrimaryKey", id);
    }

    @Override
    public int updateByPrimaryKeySelective(T t) {
        return localSqlSession.update(getNameSpace() + "updateByPrimaryKeySelective", t);
    }

    @Override
    public int updateByPrimaryKey(T t) {
        return localSqlSession.update(getNameSpace() + "updateByPrimaryKey", t);
    }

    @Override
    public int updateByBatch(List<T> t) {
        return 0;
    }

    @Override
    public int updateByBatch(List<T> t, String SqlName) {
        return 0;
    }
}
