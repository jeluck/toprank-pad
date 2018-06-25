package cc.toprank.byd.dao;


import cc.toprank.byd.entity.F_MemberCardRequestInfoEntity;
import java.util.List;

/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 *   F_MemberCardRequestInfo数据访问类
 * 
 * ********************************************************************************************************************/

public interface F_MemberCardRequestInfoDao {

    F_MemberCardRequestInfoEntity get(F_MemberCardRequestInfoEntity InfoEntity);

    List<F_MemberCardRequestInfoEntity> getAll();

    int update(F_MemberCardRequestInfoEntity InfoEntity);

    void delete(F_MemberCardRequestInfoEntity InfoEntity);

    void save(F_MemberCardRequestInfoEntity InfoEntity);

}