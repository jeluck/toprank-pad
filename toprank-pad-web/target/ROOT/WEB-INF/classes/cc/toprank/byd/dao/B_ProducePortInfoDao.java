package cc.toprank.byd.dao;

import cc.toprank.byd.entity.B_ProducePortInfoEntity;

import java.util.List;

public interface B_ProducePortInfoDao {
    int deleteByPrimaryKey(Long portID);

    int insert(B_ProducePortInfoEntity record);

    int insertSelective(B_ProducePortInfoEntity record);

    B_ProducePortInfoEntity selectByPrimaryKey(Long portID);

    int updateByPrimaryKeySelective(B_ProducePortInfoEntity record);

    int updateByPrimaryKey(B_ProducePortInfoEntity record);

    List<B_ProducePortInfoEntity> getProducePortByArchiveID(Long archiveID);
}