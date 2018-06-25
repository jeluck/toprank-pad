package cc.toprank.byd.dao;

import cc.toprank.byd.entity.B_ShopStoreMappingEntity;

public interface B_ShopStoreMappingDao {
    int deleteByPrimaryKey(Long mappingID);

    int insert(B_ShopStoreMappingEntity record);

    int insertSelective(B_ShopStoreMappingEntity record);

    B_ShopStoreMappingEntity selectByPrimaryKey(Long mappingID);

    int updateByPrimaryKeySelective(B_ShopStoreMappingEntity record);

    int updateByPrimaryKey(B_ShopStoreMappingEntity record);

    /**
     * 根据archiveID获取门店仓库关联信息
     * chenkangyi
     * 2017-5-21
     * @param archiveID
     * @return
     */
    B_ShopStoreMappingEntity selectByArchiveID(Long archiveID);
}