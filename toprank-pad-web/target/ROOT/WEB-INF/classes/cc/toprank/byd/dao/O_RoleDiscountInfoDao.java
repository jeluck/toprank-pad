package cc.toprank.byd.dao;

import cc.toprank.byd.entity.O_RoleDiscountInfoEntity;

public interface O_RoleDiscountInfoDao {
    int deleteByPrimaryKey(Long recordID);

    int insert(O_RoleDiscountInfoEntity record);

    int insertSelective(O_RoleDiscountInfoEntity record);

    O_RoleDiscountInfoEntity selectByPrimaryKey(Long recordID);

    int updateByPrimaryKeySelective(O_RoleDiscountInfoEntity record);

    int updateByPrimaryKey(O_RoleDiscountInfoEntity record);

    /**
     * 根据登录ID查询角色折扣信息
     * chenkangyi
     * 2017-5-19 14:49
     * @param loginID
     * @return
     */
    O_RoleDiscountInfoEntity getRoleDiscountInfoByLoginID(Long loginID);
}