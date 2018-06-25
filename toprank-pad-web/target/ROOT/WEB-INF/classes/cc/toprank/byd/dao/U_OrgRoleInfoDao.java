package cc.toprank.byd.dao;

import cc.toprank.byd.entity.U_OrgRoleInfoEntity;
import cc.toprank.byd.web.vo.tablevo.OrgRoleVO;

import java.util.List;
import java.util.Map;

public interface U_OrgRoleInfoDao {
    int deleteByPrimaryKey(Long mappingID);

    int insert(U_OrgRoleInfoEntity record);

    int insertSelective(U_OrgRoleInfoEntity record);

    U_OrgRoleInfoEntity selectByPrimaryKey(Long mappingID);

    int updateByPrimaryKeySelective(U_OrgRoleInfoEntity record);

    int updateByPrimaryKey(U_OrgRoleInfoEntity record);

    //查询商户角色配置
    List<OrgRoleVO> queryRoleInfo(Map<String, Object> map);
}