package cc.toprank.byd.dao;

import cc.toprank.byd.entity.M_ActivityDiscountInfoEntity;

import java.util.Map;

public interface M_ActivityDiscountInfoDao {
    int deleteByPrimaryKey(Long discountID);

    int insert(M_ActivityDiscountInfoEntity record);

    int insertSelective(M_ActivityDiscountInfoEntity record);

    M_ActivityDiscountInfoEntity selectByPrimaryKey(Long discountID);

    int updateByPrimaryKeySelective(M_ActivityDiscountInfoEntity record);

    int updateByPrimaryKey(M_ActivityDiscountInfoEntity record);

    /**
     * 根据ruleID查询活动折扣信息
     * chenkangyi
     * 2017-6-1 16:45
     * @param map
     * @return
     */
    M_ActivityDiscountInfoEntity selectByRuleID(Map<String, Object> map);
}