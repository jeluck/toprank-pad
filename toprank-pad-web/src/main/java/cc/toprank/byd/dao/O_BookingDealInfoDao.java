package cc.toprank.byd.dao;

import cc.toprank.byd.entity.O_BookingDealInfoEntity;

import java.util.List;

/**
 * @author Zhaolingchen
 * @version 2.0.0
 * @description
 * @time 2017-5-19 13:03
 */
public interface O_BookingDealInfoDao {
    int deleteByPrimaryKey(Long dealID);

    int insert(O_BookingDealInfoEntity record);

    int insertSelective(O_BookingDealInfoEntity record);

    O_BookingDealInfoEntity selectByPrimaryKey(Long dealID);

    int updateByPrimaryKeySelective(O_BookingDealInfoEntity record);

    int updateByPrimaryKey(O_BookingDealInfoEntity record);

    O_BookingDealInfoEntity get(O_BookingDealInfoEntity InfoEntity);

    List<O_BookingDealInfoEntity> getAll();

    int update(O_BookingDealInfoEntity InfoEntity);

    void delete(O_BookingDealInfoEntity InfoEntity);

    void save(O_BookingDealInfoEntity InfoEntity);
}
