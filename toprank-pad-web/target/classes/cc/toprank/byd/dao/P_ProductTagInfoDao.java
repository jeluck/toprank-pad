package cc.toprank.byd.dao;

import cc.toprank.byd.entity.P_ProductTagInfoEntity;

public interface P_ProductTagInfoDao {
    int deleteByPrimaryKey(Long tagid);

    int insert(P_ProductTagInfoEntity record);

    int insertSelective(P_ProductTagInfoEntity record);

    P_ProductTagInfoEntity selectByPrimaryKey(Long tagid);

    int updateByPrimaryKeySelective(P_ProductTagInfoEntity record);

    int updateByPrimaryKey(P_ProductTagInfoEntity record);
}