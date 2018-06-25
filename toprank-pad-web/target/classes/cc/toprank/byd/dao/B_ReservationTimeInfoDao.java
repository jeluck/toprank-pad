package cc.toprank.byd.dao;


import cc.toprank.byd.entity.B_ReservationTimeInfoEntity;

import java.util.List;

/**********************************************************************************************************************
 *
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 *   B_ReservationTimeInfo数据访问类
 *
 * ********************************************************************************************************************/
public interface B_ReservationTimeInfoDao {


    B_ReservationTimeInfoEntity get(B_ReservationTimeInfoEntity b_reservationtimeinfo);
    List<B_ReservationTimeInfoEntity> getAll();

    void update(B_ReservationTimeInfoEntity b_reservationtimeinfo);

    void delete(B_ReservationTimeInfoEntity b_reservationtimeinfo);

    void save(B_ReservationTimeInfoEntity b_reservationtimeinfo);
    /**
     * 根据   档案编号	   and   区域编号    and   餐次编号
     *
     * @param b_ReservationTimeInfoEntity B_ReservationTimeInfoEntity
     * @return List<B_ReservationTimeInfoEntity>
     * @author LiuWH
     */
    List<B_ReservationTimeInfoEntity> GetB_ReservationTimeInfoCollectionByCondition(B_ReservationTimeInfoEntity b_ReservationTimeInfoEntity);

    public List<B_ReservationTimeInfoEntity> getReservationTimeInfoByWhere(B_ReservationTimeInfoEntity reservationTimeInfoEntity);
}