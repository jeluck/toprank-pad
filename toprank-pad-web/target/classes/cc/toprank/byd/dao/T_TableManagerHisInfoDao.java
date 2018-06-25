package cc.toprank.byd.dao;

import cc.toprank.byd.entity.T_TableManagerHisInfoEntity;

public interface T_TableManagerHisInfoDao {
    int deleteByPrimaryKey(Long hisID);

    int insert(T_TableManagerHisInfoEntity record);

    int insertSelective(T_TableManagerHisInfoEntity record);

    T_TableManagerHisInfoEntity selectByPrimaryKey(Long hisID);

    int updateByPrimaryKeySelective(T_TableManagerHisInfoEntity record);

    int updateByPrimaryKey(T_TableManagerHisInfoEntity record);
}