package cc.toprank.byd.dao;


import cc.toprank.byd.entity.U_OrgCustomerMappingEntity;
import java.util.List;


public interface U_OrgCustomerMappingDao  {

    U_OrgCustomerMappingEntity get(U_OrgCustomerMappingEntity InfoEntity);

    List<U_OrgCustomerMappingEntity> getAll();

    int update(U_OrgCustomerMappingEntity InfoEntity);

    void delete(U_OrgCustomerMappingEntity InfoEntity);

    void save(U_OrgCustomerMappingEntity InfoEntity);
    /**
     * 根据机构编号查询机构客户关联信息
     * @author HuangCY
     * @param orgID
     * @return
     */
    public U_OrgCustomerMappingEntity queryOrgCustomerMappingByOrgID (long orgID);
}