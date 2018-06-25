package cc.toprank.byd.web.service.table;

import cc.toprank.byd.dao.B_ReservationTimeInfoDao;
import cc.toprank.byd.entity.B_ReservationTimeInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**********************************************************************************************************************
 *
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   B_AttachmentInfoService 真实的业务实现类，允许修改
 *
 * ********************************************************************************************************************/

@Service("b_ReservationTimeInfoService")
public class B_ReservationTimeInfoService {

    @Autowired
    private B_ReservationTimeInfoDao reservationTimeInfoDao;


    public B_ReservationTimeInfoEntity get(B_ReservationTimeInfoEntity b_reservationtimeinfo) throws Exception{
        return reservationTimeInfoDao.get(b_reservationtimeinfo);
    }
    public List<B_ReservationTimeInfoEntity> getAll() throws Exception{
        return reservationTimeInfoDao.getAll();
    }

    public void update(B_ReservationTimeInfoEntity b_reservationtimeinfo) throws Exception{
        reservationTimeInfoDao.update(b_reservationtimeinfo);
    }

    public void delete(B_ReservationTimeInfoEntity b_reservationtimeinfo) throws Exception{
        reservationTimeInfoDao.delete(b_reservationtimeinfo);
    }

    public void save(B_ReservationTimeInfoEntity b_reservationtimeinfo) throws Exception{
        reservationTimeInfoDao.save(b_reservationtimeinfo);
    }
    /**
     * 根据   档案编号	   and   区域编号    and   餐次编号
     *
     * @param b_ReservationTimeInfoEntity B_ReservationTimeInfoEntity
     * @return List<B_ReservationTimeInfoEntity>
     * @author LiuWH
     */
    public List<B_ReservationTimeInfoEntity> GetB_ReservationTimeInfoCollectionByCondition(B_ReservationTimeInfoEntity b_ReservationTimeInfoEntity) {
        return reservationTimeInfoDao.GetB_ReservationTimeInfoCollectionByCondition(b_ReservationTimeInfoEntity);
    }

    /**
     * @author Zhaolingcen
     * @version 2.0.0
     * @description  根据   档案编号	   and   区域编号    and   餐次编号
     * @time 2017-05-10 11:00:00
     */

    public List<B_ReservationTimeInfoEntity> getReservationTimeInfoByWhere(B_ReservationTimeInfoEntity reservationTimeParam) throws Exception{
        List<B_ReservationTimeInfoEntity> reservationTimeInfoList = reservationTimeInfoDao.getReservationTimeInfoByWhere(reservationTimeParam);
        if(reservationTimeInfoList == null || reservationTimeInfoList.isEmpty()){
            reservationTimeParam.setMealsID(null);
            reservationTimeInfoList = reservationTimeInfoDao.getReservationTimeInfoByWhere(reservationTimeParam);
        }
        //如果没有查询到数据,就查询整个整个商家的
        if(reservationTimeInfoList == null || reservationTimeInfoList.isEmpty()){
            reservationTimeParam.setAreaID(null);
            reservationTimeInfoList = reservationTimeInfoDao.getReservationTimeInfoByWhere(reservationTimeParam);
        }
        return reservationTimeInfoList;
    }
}