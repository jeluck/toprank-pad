package cc.toprank.byd.dao;

import cc.toprank.byd.entity.B_MerchantTagMappingEntity;

import java.util.List;

public interface B_MerchantTagMappingDao {
    int deleteByPrimaryKey(Long mappingID);

    int insert(B_MerchantTagMappingEntity record);

    int insertBatch(List<B_MerchantTagMappingEntity> record);

    int insertSelective(B_MerchantTagMappingEntity record);

    B_MerchantTagMappingEntity selectByPrimaryKey(Long mappingID);

    int updateByPrimaryKeySelective(B_MerchantTagMappingEntity record);

    int updateByPrimaryKey(B_MerchantTagMappingEntity record);

    /**
     * @Description： 根据明细ID查询标签关联信息
     * @Author：LanZY
     * @Time: 2017-5-19 15:29
     * @Version 2.0.0
     * @param detailID
     * @return
     */
    B_MerchantTagMappingEntity getMerchantTagMappingByDetailID(Long detailID);

    /**
     * @Description： 根据明细ID查询标签关联信息
     * @Author：LanZY
     * @Time: 2017-5-26 15:52
     * @Version 2.0.0
     * @param B_MerchantTagMappingEntity
     * @return
     */
    B_MerchantTagMappingEntity getMerchantTagMappingByTargetIDAndTagID(B_MerchantTagMappingEntity B_MerchantTagMappingEntity);
}