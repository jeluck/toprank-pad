package cc.toprank.byd.dao;

import cc.toprank.byd.entity.O_MessageDealInfoEntity;

public interface O_MessageDealInfoDao {
    int deleteByPrimaryKey(Long dealID);

    int insert(O_MessageDealInfoEntity record);

    int insertSelective(O_MessageDealInfoEntity record);

    O_MessageDealInfoEntity selectByPrimaryKey(Long dealID);

    int updateByPrimaryKeySelective(O_MessageDealInfoEntity record);

    int updateByPrimaryKey(O_MessageDealInfoEntity record);
}