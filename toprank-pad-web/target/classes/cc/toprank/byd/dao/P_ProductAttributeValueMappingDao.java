package cc.toprank.byd.dao;

import cc.toprank.byd.entity.P_ProductAttributeValueMappingEntity;

public interface P_ProductAttributeValueMappingDao {
    int deleteByPrimaryKey(Long mappingid);

    int insert(P_ProductAttributeValueMappingEntity record);

    int insertSelective(P_ProductAttributeValueMappingEntity record);

    P_ProductAttributeValueMappingEntity selectByPrimaryKey(Long mappingid);

    int updateByPrimaryKeySelective(P_ProductAttributeValueMappingEntity record);

    int updateByPrimaryKey(P_ProductAttributeValueMappingEntity record);
}