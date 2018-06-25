package cc.toprank.byd.dao;



import cc.toprank.byd.entity.F_AccountCardMappingEntity;
import java.util.List;

/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 *   F_AccountCardMapping数据访问类
 * 
 * ********************************************************************************************************************/
public interface F_AccountCardMappingDao {

    F_AccountCardMappingEntity get(F_AccountCardMappingEntity InfoEntity);

    List<F_AccountCardMappingEntity> getAll();

    int update(F_AccountCardMappingEntity InfoEntity);

    void delete(F_AccountCardMappingEntity InfoEntity);

    void save(F_AccountCardMappingEntity InfoEntity);

}