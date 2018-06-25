package cc.toprank.byd.dao;

import cc.toprank.byd.entity.V_ProductMappingEntity;

import java.util.List;

public interface V_ProductMappingDao {
    int insert(V_ProductMappingEntity record);

    int insertSelective(V_ProductMappingEntity record);

    List<V_ProductMappingEntity> getAll();

    V_ProductMappingEntity selectByMappingID(Long mappingID);
}