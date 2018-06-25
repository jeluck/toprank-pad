package cc.toprank.byd.dao;

import cc.toprank.byd.entity.U_ActiveUserInfoEntity;

public interface U_ActiveUserInfoDao {
    int deleteByPrimaryKey(Long logid);

    int insert(U_ActiveUserInfoEntity record);

    int insertSelective(U_ActiveUserInfoEntity record);

    U_ActiveUserInfoEntity selectByPrimaryKey(Long logid);

    int updateByPrimaryKeySelective(U_ActiveUserInfoEntity record);

    int updateByPrimaryKey(U_ActiveUserInfoEntity record);

    int deleteByLoginID(Long LoginID);
}