package cc.toprank.byd.dao;

import cc.toprank.byd.entity.M_ActivityRuleInfoEntity;

import java.util.Map;

public interface M_ActivityRuleInfoDao {
    int deleteByPrimaryKey(Long ruleID);

    int insert(M_ActivityRuleInfoEntity record);

    int insertSelective(M_ActivityRuleInfoEntity record);

    M_ActivityRuleInfoEntity selectByPrimaryKey(Long ruleID);

    int updateByPrimaryKeySelective(M_ActivityRuleInfoEntity record);

    int updateByPrimaryKey(M_ActivityRuleInfoEntity record);

    /**
     * 根据roleID查询活动规则信息
     * chenkangyi
     * 2017-5-25 16:35
     * @param map
     * @return
     */
    M_ActivityRuleInfoEntity selectByRoleID(Map<String, Object> map);
}