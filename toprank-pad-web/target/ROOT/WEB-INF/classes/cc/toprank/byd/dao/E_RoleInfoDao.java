package cc.toprank.byd.dao;

import cc.toprank.byd.entity.E_RoleInfoEntity;

public interface E_RoleInfoDao {
    int deleteByPrimaryKey(Long roleID);

    int insert(E_RoleInfoEntity record);

    int insertSelective(E_RoleInfoEntity record);

    E_RoleInfoEntity selectByPrimaryKey(Long roleID);

    int updateByPrimaryKeySelective(E_RoleInfoEntity record);

    int updateByPrimaryKey(E_RoleInfoEntity record);
}