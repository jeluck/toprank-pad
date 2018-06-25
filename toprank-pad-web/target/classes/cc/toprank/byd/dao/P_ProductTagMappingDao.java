package cc.toprank.byd.dao;

import cc.toprank.byd.entity.P_ProductTagMappingEntity;

import java.util.Map;

public interface P_ProductTagMappingDao {
    int deleteByPrimaryKey(Long mappingid);

    int insert(P_ProductTagMappingEntity record);

    int insertSelective(P_ProductTagMappingEntity record);

    P_ProductTagMappingEntity selectByPrimaryKey(Long mappingid);

    int updateByPrimaryKeySelective(P_ProductTagMappingEntity record);

    int updateByPrimaryKey(P_ProductTagMappingEntity record);

    P_ProductTagMappingEntity getEntityByParams(Map<String, Object> paramMap);
}