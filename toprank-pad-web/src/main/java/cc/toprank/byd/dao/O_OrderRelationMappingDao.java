package cc.toprank.byd.dao;

import cc.toprank.byd.entity.O_OrderRelationMappingEntity;

/**
 * 订单关联信息
 * Created by HuangCY on 2017-6-12.
 */
public interface O_OrderRelationMappingDao {

    int deleteByPrimaryKey(Long mappingID);

    int insert(O_OrderRelationMappingEntity record);

    int insertSelective(O_OrderRelationMappingEntity record);

    O_OrderRelationMappingEntity selectByPrimaryKey(Long mappingID);

    int updateByPrimaryKeySelective(O_OrderRelationMappingEntity record);

    int updateByPrimaryKey(O_OrderRelationMappingEntity record);

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 新增订单关联信息
     * @time 2017-6-12 16:03
     */
    void saveOrderRelationMapping(O_OrderRelationMappingEntity entity);

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 根据订单关联ID修改折扣金额
     * @time 2017-6-13 17:11
     */
    void updateDiscountAmountByMappingOrderID(O_OrderRelationMappingEntity entity);

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 根据订单关联ID修改支付状态和付款时间
     * @time 2017-6-19 12:37
     */
    void updatePayStatusByMappingID(O_OrderRelationMappingEntity entity);
}
