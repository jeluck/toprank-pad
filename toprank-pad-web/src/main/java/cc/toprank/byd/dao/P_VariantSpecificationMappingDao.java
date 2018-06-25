package cc.toprank.byd.dao;


import cc.toprank.byd.entity.P_VariantSpecificationMappingEntity;

import java.util.List;

public interface P_VariantSpecificationMappingDao {
    int deleteByPrimaryKey(Long mappingID);

    int insert(P_VariantSpecificationMappingEntity record);

    int insertSelective(P_VariantSpecificationMappingEntity record);

    P_VariantSpecificationMappingEntity selectByPrimaryKey(Long mappingID);

    int updateByPrimaryKeySelective(P_VariantSpecificationMappingEntity record);

    int updateByPrimaryKey(P_VariantSpecificationMappingEntity record);

    P_VariantSpecificationMappingEntity get(P_VariantSpecificationMappingEntity entity);

    List<P_VariantSpecificationMappingEntity> getAll();

    void update(P_VariantSpecificationMappingEntity entity);

    void delete(P_VariantSpecificationMappingEntity entity);

    void save(P_VariantSpecificationMappingEntity entity);

    /**
     * @Description： 根据变体ID和规格ID查询加价规格信息
     * @Author：LanZY
     * @Time: 2017-5-8 14:17
     * @Version 2.0.0
     * @param entity
     * @return
     */
    P_VariantSpecificationMappingEntity getVariantSpecificationMappingByVariantIDAndOptionID(P_VariantSpecificationMappingEntity entity);

    /**
     * @Description：根据变体id获取规格信息
     * @Author：chenkangyi
     * @Time: 2017-5-16 13:55
     * @param variantID
     * @return
     */
    List<P_VariantSpecificationMappingEntity> getVariantSpecificationMappingByVariantID(Long variantID);

}