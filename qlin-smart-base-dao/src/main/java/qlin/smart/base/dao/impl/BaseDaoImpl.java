package qlin.smart.base.dao.impl;

import com.qlin.smart.bean.SearchBean;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import qlin.smart.base.dao.IBaseDao;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public int deleteByPrimaryKey(Object id) throws Exception {
        return localSqlSession.delete(getNameSpace() + "deleteByPrimaryKey", id);
    }

    @Override
    public int insert(T record) throws Exception {
        return localSqlSession.insert(getNameSpace() + "insert", record);
    }

    @Override
    public int insertSelective(T t) throws Exception {
        return localSqlSession.insert(getNameSpace() + "insertSelective", t);
    }

    @Override
    public int insertByBatch(List<T> t) throws Exception {
        return insertByBatch(t, "insertByBatch");
    }

    @Override
    public int insertByBatch(List<T> t, String SqlName) {
        int result = 1;
        SqlSession batchSqlSession = null;
        try {
            // 获取批量方式的sqlsession
            batchSqlSession = localSqlSession.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
            int batchCount = 1000;// 每批commit的个数
            int batchLastIndex = batchCount;// 每批最后一个的下标
            for (int index = 0; index < t.size(); ) {
                if (batchLastIndex >= t.size()) {
                    batchLastIndex = t.size();
                    Map<String, Object> map = new HashMap();
                    map.put("list", t.subList(index, batchLastIndex));
                    result = result + batchSqlSession.insert(getNameSpace() + SqlName, map);
                    batchSqlSession.commit();
                    break;// 数据插入完毕，退出循环
                } else {
                    Map<String, Object> map = new HashMap();
                    map.put("list", t.subList(index, batchLastIndex));
                    result = result + batchSqlSession.insert(getNameSpace() + SqlName, map);
                    batchSqlSession.commit();
                    index = batchLastIndex;// 设置下一批下标
                    batchLastIndex = index + (batchCount - 1);
                }
            }
            batchSqlSession.commit();

        } finally {
            batchSqlSession.close();
        }
        return result;
    }

    @Override
    public T selectByPrimaryKey(Object id) throws Exception {
        return localSqlSession.selectOne(getNameSpace() + "selectByPrimaryKey", id);
    }

    @Override
    public int updateByPrimaryKeySelective(T t) throws Exception {
        return localSqlSession.update(getNameSpace() + "updateByPrimaryKeySelective", t);
    }

    @Override
    public int updateByPrimaryKey(T t) throws Exception {
        return localSqlSession.update(getNameSpace() + "updateByPrimaryKey", t);
    }

    @Override
    public int updateByBatch(List<T> t) throws Exception {
        return updateByBatch(t, "updateByBatch");
    }

    @Override
    public int updateByBatch(List<T> t, String SqlName) throws Exception {
        int result = 1;
        SqlSession batchSqlSession = null;
        try {
            // 获取批量方式的sqlsession
            batchSqlSession = localSqlSession.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
            int batchCount = 1000;// 每批commit的个数
            int batchLastIndex = batchCount;// 每批最后一个的下标
            for (int index = 0; index < t.size(); ) {
                if (batchLastIndex >= t.size()) {
                    batchLastIndex = t.size();
                    Map<String, Object> map = new HashMap();
                    map.put("list", t.subList(index, batchLastIndex));
                    result = result + batchSqlSession.update(getNameSpace() + SqlName, map);
                    batchSqlSession.commit();
                    break;// 数据更新完毕，退出循环
                } else {
                    Map<String, Object> map = new HashMap();
                    map.put("list", t.subList(index, batchLastIndex));
                    result = result + batchSqlSession.update(getNameSpace() + SqlName, map);
                    batchSqlSession.commit();
                    index = batchLastIndex;// 设置下一批下标
                    batchLastIndex = index + (batchCount - 1);
                }
            }
            batchSqlSession.commit();

        } finally {
            batchSqlSession.close();
        }
        return result;
    }

    @Override
    public int deleteByBatch(List<Object> list) throws Exception {
        return 0;
    }

    @Override
    public List<T> selectByConditions(SearchBean searchBean) throws Exception {
        return localSqlSession.selectList(getNameSpace() + "selectByConditions", searchBean);
    }

    @Override
    public int selectTotalByConditions(SearchBean searchBean) throws Exception {
        return localSqlSession.selectOne(getNameSpace() + "selectTotalByConditions", searchBean);
    }
}
