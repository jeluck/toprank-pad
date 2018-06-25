package cc.toprank.byd.dao;

import cc.toprank.byd.entity.P_VariantAttributeValueMappingEntity;

public interface P_VariantAttributeValueMappingDao {
    int deleteByPrimaryKey(Long mappingid);

    int insert(P_VariantAttributeValueMappingEntity record);

    int insertSelective(P_VariantAttributeValueMappingEntity record);

    P_VariantAttributeValueMappingEntity selectByPrimaryKey(Long mappingid);

    int updateByPrimaryKeySelective(P_VariantAttributeValueMappingEntity record);

    int updateByPrimaryKey(P_VariantAttributeValueMappingEntity record);


}