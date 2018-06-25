package cc.toprank.byd.dao;

import cc.toprank.byd.entity.O_OrderDetailValueMappingEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by LanZY on 2017-5-6.
 */
public interface O_OrderDetailValueMappingDao {

    int deleteByPrimaryKey(Long mappingID);

    int insert(O_OrderDetailValueMappingEntity record);

    int insertSelective(O_OrderDetailValueMappingEntity record);

    O_OrderDetailValueMappingEntity selectByPrimaryKey(Long mappingID);

    int updateByPrimaryKeySelective(O_OrderDetailValueMappingEntity record);

    int updateByPrimaryKey(O_OrderDetailValueMappingEntity record);

    O_OrderDetailValueMappingEntity get(O_OrderDetailValueMappingEntity orderDetailValueMapping);

    List<O_OrderDetailValueMappingEntity> getAll();

    void update(O_OrderDetailValueMappingEntity orderDetailValueMapping);

    void delete(O_OrderDetailValueMappingEntity orderDetailValueMapping);

    void save(O_OrderDetailValueMappingEntity orderDetailValueMapping);

    List<O_OrderDetailValueMappingEntity> getAttributeValueByOrderIDAndValueID(Map<String,Object> parm );
}
