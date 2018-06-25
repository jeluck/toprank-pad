package cc.toprank.byd.dao;

import cc.toprank.byd.entity.O_OrderDiscountMappingEntity;
import cc.toprank.byd.entity.O_OrderInfoEntity;
import cc.toprank.byd.entity.PayOrderDTO;

import java.util.List;
import java.util.Map;

/**
 * 订单折扣信息
 * Created by HuangCY on 2017-5-11.
 */
public interface O_OrderDiscountMappingDao {
    int deleteByPrimaryKey(Long mappingID);

    int insert(O_OrderDiscountMappingEntity record);

    int insertSelective(O_OrderDiscountMappingEntity record);

    O_OrderDiscountMappingEntity selectByPrimaryKey(Long mappingID);

    int updateByPrimaryKeySelective(O_OrderDiscountMappingEntity record);

    int updateByPrimaryKey(O_OrderDiscountMappingEntity record);

    O_OrderInfoEntity get(O_OrderDiscountMappingEntity orderDiscountMapping);

    List<O_OrderDiscountMappingEntity> getAll();

    int update(O_OrderDiscountMappingEntity orderDiscountMapping);

    void delete(O_OrderDiscountMappingEntity orderDiscountMapping);

    void save(O_OrderDiscountMappingEntity orderDiscountMapping);

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 根据子订单ID或订单ID查询订单折扣信息
     * @time 2017-5-11 14:59
     */
    List<O_OrderDiscountMappingEntity> queryDiscountInfoByOrderID(PayOrderDTO payOrderDTO);

    /**
     * @author chenkangyi
     * @version 2.0.0
     * @description 根据子订单ID和折扣类别查询订单折扣信息
     * @time 2017-6-6 14:20
     */
    List<O_OrderDiscountMappingEntity> queryDiscountInfoBySubOrderIDAndDiscountType(Map<String, Object> map);

    /**
     * @author chenkangyi
     * @version 2.0.0
     * @description 根据子订单ID和折扣类别删除订单折扣信息
     * @time 2017-6-8 10:59
     */
    void deleteOrderDiscountMappingBySubOrderIDListAndDiscountType(Map<String, Object> map);

    /**
     * @author chenkangyi
     * @version 2.0.0
     * @description 根据子订单ID和折扣类别查询订单折扣信息
     * @time 2017-6-8 10:59
     */
    List<O_OrderDiscountMappingEntity> selectOrderDiscountMappingBySubOrderIDListAndDiscountType(Map<String, Object> map);

    /**
     * @author zhouwei
     * @version 2.0.0
     * @description 根据子订单ID获取折扣名称
     * @time 2017-6-8 10:59
     */
    List<String> getOrderDisCountMappingBySubOrderID(Map map);

    /**
     * @author chenkangyi
     * @version 2.0.0
     * @description 根据订单ID和折扣类别查询订单折扣信息
     * @time 2017-6-6 14:20
     */
    O_OrderDiscountMappingEntity queryDiscountInfoByOrderIDAndDiscountType(Map<String, Object> map);

    /**
     * @author chenkangyi
     * @version 2.0.0
     * @description 根据订单ID和折扣类别删除订单折扣信息
     * @time 2017-6-14 17:06
     */
    void deleteOrderDiscountMappingByOrderIDAndDiscountType(Map<String, Object> map);

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 根据支付订单ID改变订单折扣信息的金额
     * @time 2017-6-17 19:25
     */
    void updateDiscountAmountByOrderID(O_OrderDiscountMappingEntity orderDiscountMapping);
}
