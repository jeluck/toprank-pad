package cc.toprank.byd.dao;

import cc.toprank.byd.entity.O_ComboDetailValueMappingEntity;

import java.util.List;

/**
 * Created by LanZY on 2017-5-6.
 */
public interface O_ComboDetailValueMappingDao {
    int deleteByPrimaryKey(Long mappingID);

    int insert(O_ComboDetailValueMappingEntity record);

    int insertSelective(O_ComboDetailValueMappingEntity record);

    O_ComboDetailValueMappingEntity selectByPrimaryKey(Long mappingID);

    int updateByPrimaryKeySelective(O_ComboDetailValueMappingEntity record);

    int updateByPrimaryKey(O_ComboDetailValueMappingEntity record);

    O_ComboDetailValueMappingEntity get(O_ComboDetailValueMappingEntity comboDetailValueMapping);

    List<O_ComboDetailValueMappingEntity> getAll();

    void update(O_ComboDetailValueMappingEntity comboDetailValueMapping);

    void delete(O_ComboDetailValueMappingEntity comboDetailValueMapping);

    void save(O_ComboDetailValueMappingEntity comboDetailValueMapping);
}
