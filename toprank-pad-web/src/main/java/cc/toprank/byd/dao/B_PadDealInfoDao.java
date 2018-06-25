package cc.toprank.byd.dao;

import cc.toprank.byd.entity.B_PadDealInfoEntity;

public interface B_PadDealInfoDao {
    int deleteByPrimaryKey(Long dealid);

    int insert(B_PadDealInfoEntity record);

    int insertSelective(B_PadDealInfoEntity record);

    B_PadDealInfoEntity selectByPrimaryKey(Long dealid);

    int updateByPrimaryKeySelective(B_PadDealInfoEntity record);

    int updateByPrimaryKey(B_PadDealInfoEntity record);

}
