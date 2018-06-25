package cc.toprank.byd.dao;

import cc.toprank.byd.entity.P_ProductSpecificationMappingEntity;

import java.util.List;

public interface P_ProductSpecificationMappingDao {
    int deleteByPrimaryKey(Long mappingID);

    int insert(P_ProductSpecificationMappingEntity record);

    int insertSelective(P_ProductSpecificationMappingEntity record);

    P_ProductSpecificationMappingEntity selectByPrimaryKey(Long mappingID);

    int updateByPrimaryKeySelective(P_ProductSpecificationMappingEntity record);

    int updateByPrimaryKey(P_ProductSpecificationMappingEntity record);

    /**
     * @Description：根据productID获取规格信息
     * @Author：chenkangyi
     * @Time: 2017-5-16 17:55
     * @param productID
     * @return
     */
    List<P_ProductSpecificationMappingEntity> getProductSpecificationMappingByProductID(Long productID);
}