package cc.toprank.byd.dao;

import cc.toprank.byd.entity.U_UserOrganizationMappingEntity;

public interface U_UserOrganizationMappingDao {
    int deleteByPrimaryKey(Long mappingid);

    int insert(U_UserOrganizationMappingEntity record);

    int insertSelective(U_UserOrganizationMappingEntity record);

    U_UserOrganizationMappingEntity selectByPrimaryKey(Long mappingid);

    int updateByPrimaryKeySelective(U_UserOrganizationMappingEntity record);

    int updateByPrimaryKey(U_UserOrganizationMappingEntity record);
}