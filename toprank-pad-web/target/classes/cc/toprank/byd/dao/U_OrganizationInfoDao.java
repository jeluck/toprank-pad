package cc.toprank.byd.dao;

import cc.toprank.byd.entity.U_OrganizationInfoEntity;

public interface U_OrganizationInfoDao {
    int deleteByPrimaryKey(Long orgid);

    int insert(U_OrganizationInfoEntity record);

    int insertSelective(U_OrganizationInfoEntity record);

    U_OrganizationInfoEntity selectByPrimaryKey(Long orgid);

    int updateByPrimaryKeySelective(U_OrganizationInfoEntity record);

    int updateByPrimaryKey(U_OrganizationInfoEntity record);

    U_OrganizationInfoEntity getCurrentOrganizationInfo();
}