package cc.toprank.byd.dao;

import cc.toprank.byd.entity.B_StallWeighContentInfoEntity;

import java.util.List;

public interface B_StallWeighContentInfoDao {
    int deleteByPrimaryKey(Long contentid);

    int insert(B_StallWeighContentInfoEntity record);

    int insertSelective(B_StallWeighContentInfoEntity record);

    B_StallWeighContentInfoEntity selectByPrimaryKey(Long contentid);

    int updateByPrimaryKeySelective(B_StallWeighContentInfoEntity record);

    int updateByPrimaryKey(B_StallWeighContentInfoEntity record);

    List<B_StallWeighContentInfoEntity> selectStallWeighContentInfoList(Long stallID);
}