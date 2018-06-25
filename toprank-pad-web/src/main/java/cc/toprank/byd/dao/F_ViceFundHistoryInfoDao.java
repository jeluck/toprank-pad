package cc.toprank.byd.dao;


import cc.toprank.byd.entity.F_ViceFundHistoryInfoEntity;
import java.util.List;

/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 *   F_ViceFundHistoryInfo数据访问类
 * 
 * ********************************************************************************************************************/
public interface F_ViceFundHistoryInfoDao  {

    F_ViceFundHistoryInfoEntity get(F_ViceFundHistoryInfoEntity InfoEntity);

    List<F_ViceFundHistoryInfoEntity> getAll();

    int update(F_ViceFundHistoryInfoEntity InfoEntity);

    void delete(F_ViceFundHistoryInfoEntity InfoEntity);

    void save(F_ViceFundHistoryInfoEntity InfoEntity);
}