package cc.toprank.byd.dao;

import cc.toprank.byd.entity.P_SpecificationInfoEntity;

import java.util.List;

/**
 * Created by LanZY on 2017-4-10.
 */
public interface P_SpecificationInfoDao {

    List<P_SpecificationInfoEntity> getAll();

    void update(P_SpecificationInfoEntity specificationInfo);

    void delete(P_SpecificationInfoEntity specificationInfo);

    void save(P_SpecificationInfoEntity specificationInfo);


}
