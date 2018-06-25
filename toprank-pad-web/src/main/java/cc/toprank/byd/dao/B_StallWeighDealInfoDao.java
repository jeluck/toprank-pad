package cc.toprank.byd.dao;

import cc.toprank.byd.entity.B_StallWeighDealInfoEntity;

import java.util.List;

public interface B_StallWeighDealInfoDao {
    int deleteByPrimaryKey(Long dealid);

    int insertBatch(List<B_StallWeighDealInfoEntity> record);

    int insert(B_StallWeighDealInfoEntity record);

    int insertSelective(B_StallWeighDealInfoEntity record);

    B_StallWeighDealInfoEntity selectByPrimaryKey(Long dealid);

    int updateByPrimaryKeySelective(B_StallWeighDealInfoEntity record);

    int updateByPrimaryKey(B_StallWeighDealInfoEntity record);

    B_StallWeighDealInfoEntity get(B_StallWeighDealInfoEntity stallWeighDealInfo);

    List<B_StallWeighDealInfoEntity> getAll();

    void update(B_StallWeighDealInfoEntity stallWeighDealInfo);

    void delete(B_StallWeighDealInfoEntity stallWeighDealInfo);

    void save(B_StallWeighDealInfoEntity stallWeighDealInfo);
}