package cc.toprank.byd.dao;

import cc.toprank.byd.entity.B_WeighDealInfoEntity;

public interface B_WeighDealInfoDao {
    int deleteByPrimaryKey(Long dealID);

    int insert(B_WeighDealInfoEntity record);

    int insertSelective(B_WeighDealInfoEntity record);

    B_WeighDealInfoEntity selectByPrimaryKey(Long dealID);

    int updateByPrimaryKeySelective(B_WeighDealInfoEntity record);

    int updateByPrimaryKey(B_WeighDealInfoEntity record);
}