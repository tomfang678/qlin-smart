package com.qlin.smart.common.util;

import java.util.*;

/**
 * 作者：tomfang
 * 日期：2017-08-24
 * 描述：常用算法
 */
public class AlgorithmUtil {

    /**
     * 根据日期间隔分组
     * eg:间隔7天 7-1,7-2,7-5,7-20 分组为7-1[ 7-1,7-2,7-5];7-20 [7-20]
     *
     * @param arriveDateList 分组数据源
     * @param spliter        分组天数
     * @return
     */
    public static Map<Date, List<Date>> splitBatchDate(List<Date> arriveDateList, Integer spliter) {
        Map<Date, List<Date>> splitResult = new HashMap<Date, List<Date>>();
        try {
            if (null == arriveDateList || arriveDateList.size() == 0) {
                return splitResult;
            }
            if (spliter > 0) {
                spliter = spliter - 1;
            }
            for (int i = 0; i < arriveDateList.size(); ) {
                Date firtDate = arriveDateList.get(i);
                Date endDate = DateUtil.getAppointData(arriveDateList.get(i), spliter);
                List<Date> tempList = new ArrayList<Date>();
                tempList.add(arriveDateList.get(i));
                while (++i < arriveDateList.size()) {
                    if (endDate.after(arriveDateList.get(i)) || endDate.compareTo(arriveDateList.get(i)) == 0) {
                        tempList.add(arriveDateList.get(i));
                    } else {
                        break;
                    }
                }
                splitResult.put(firtDate, tempList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return splitResult;
    }


}
