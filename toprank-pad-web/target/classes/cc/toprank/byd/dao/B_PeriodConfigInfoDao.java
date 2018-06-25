package cc.toprank.byd.dao;


import cc.toprank.byd.entity.B_PeriodConfigInfoEntity;

import java.util.List;
import java.util.Map;

/**********************************************************************************************************************
 *
 * 版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 * B_PeriodConfigInfo数据访问类
 *
 ********************************************************************************************************************/
public interface B_PeriodConfigInfoDao {
    B_PeriodConfigInfoEntity get(B_PeriodConfigInfoEntity InfoEntity);

    List<B_PeriodConfigInfoEntity> getAll();

    int update(B_PeriodConfigInfoEntity InfoEntity);

    void delete(B_PeriodConfigInfoEntity InfoEntity);

    void save(B_PeriodConfigInfoEntity InfoEntity);

    /**
     * @author 赵凌晨
     * @version 2.0.0
     * @description 根据 档案编号，区域编号，餐次编号，预定类型
     * @time 2017-05-2 14:00:00
     */
    public List<B_PeriodConfigInfoEntity> getPeriodConfigInfoByCondition(Map parameter);

}
