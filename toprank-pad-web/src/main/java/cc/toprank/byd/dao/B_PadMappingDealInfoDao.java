package cc.toprank.byd.dao;

import cc.toprank.byd.entity.B_PadMappingDealInfoEntity;

public interface B_PadMappingDealInfoDao {
    int deleteByPrimaryKey(Long dealID);

    int insert(B_PadMappingDealInfoEntity record);

    int insertSelective(B_PadMappingDealInfoEntity record);

    B_PadMappingDealInfoEntity selectByPrimaryKey(Long dealID);

    int updateByPrimaryKeySelective(B_PadMappingDealInfoEntity record);

    int updateByPrimaryKey(B_PadMappingDealInfoEntity record);
}