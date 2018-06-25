package cc.toprank.byd.dao;

import cc.toprank.byd.entity.P_ComboGroupProductMappingEntity;

import java.util.List;

/**
 * Created by LanZY on 2017-4-21.
 */
public interface P_ComboGroupProductMappingDao {

    P_ComboGroupProductMappingEntity get(P_ComboGroupProductMappingEntity comboGroupProduct);

    List<P_ComboGroupProductMappingEntity> getAll();

    void update(P_ComboGroupProductMappingEntity comboGroupProduct);

    void delete(P_ComboGroupProductMappingEntity comboGroupProduct);

    void save(P_ComboGroupProductMappingEntity comboGroupProduct);


}
