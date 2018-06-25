package cc.toprank.byd.dao;

import cc.toprank.byd.entity.U_UserInfoEntity;

public interface U_UserInfoDao {
    int deleteByPrimaryKey(Long userid);

    int insert(U_UserInfoEntity record);

    int insertSelective(U_UserInfoEntity record);

    U_UserInfoEntity selectByPrimaryKey(Long userid);

    int updateByPrimaryKeySelective(U_UserInfoEntity record);

    int updateByPrimaryKey(U_UserInfoEntity record);
}