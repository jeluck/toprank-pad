package cc.toprank.byd.dao;

import cc.toprank.byd.entity.U_RoleLoginInfoEntity;

import java.util.Map;

public interface U_RoleLoginInfoDao {
    int deleteByPrimaryKey(Long mappingID);

    int insert(U_RoleLoginInfoEntity record);

    int insertSelective(U_RoleLoginInfoEntity record);

    U_RoleLoginInfoEntity selectByPrimaryKey(Long mappingID);

    int updateByPrimaryKeySelective(U_RoleLoginInfoEntity record);

    int updateByPrimaryKey(U_RoleLoginInfoEntity record);

    /**
     * 根据loginID、moduleCode、privilegeCode获取角色的权限信息
     * chenkangyi
     * 2017-5-26 17:59
     * @param map
     * @return
     */
    U_RoleLoginInfoEntity  selectPrivilegeInfo(Map<String, Object> map);
}