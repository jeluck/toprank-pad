package cc.toprank.byd.dao;


import cc.toprank.byd.entity.O_BookingInfoEntity;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface O_BookingInfoDao {

    O_BookingInfoEntity get(O_BookingInfoEntity o_bookinginfo);

    List<O_BookingInfoEntity> getAll();

    void update(O_BookingInfoEntity o_bookinginfo);

    void delete(O_BookingInfoEntity o_bookinginfo);

    void save(O_BookingInfoEntity o_bookinginfo);

    int deleteByPrimaryKey(Long bookingid);

    int insert(O_BookingInfoEntity record);

    int insertSelective(O_BookingInfoEntity record);

    O_BookingInfoEntity selectByPrimaryKey(Long bookingid);

    int updateByPrimaryKeySelective(O_BookingInfoEntity record);

    int updateByPrimaryKey(O_BookingInfoEntity record);

    O_BookingInfoEntity getByID(Long bookingID);

    /**
     * @author LiSH  @date 2017年1月16日
     * @Description: 根据餐次ID和桌台ID 查询餐次中的预订单
     */
    List<O_BookingInfoEntity> getBookingOrderListByTableIDAndMealsID(@Param("tableID") Long tableID, @Param("mealsID") Long mealsid);

    /**
     * 查询桌台下个预定单信息
     *
     * @param tableID
     * @return
     */
    O_BookingInfoEntity getNextBookingOrderByTableID(@Param("tableID") Long tableID);

    /**
     * @description 查询当前时间下是否有预定单锁定
     * @author LiSH
     * @time 2017-3-2 10:12
     * @version 2.0.0
     */
    List<O_BookingInfoEntity> getEntityByParams(HashMap<String, Object> params);

    /**
     * @description 根据条件查询预订单信息
     * @author Zhaolingchen
     * @time 2017-5-17 10:12
     * @version 2.0.0
     */
    List<O_BookingInfoEntity> getBookingInfoByWhere(Map<String,Object> param);


    /**
     * @description 根据预订ID 查询预订详情
     * @author Zhaolingchen
     * @time 2017-5-17 10:12
     * @version 2.0.0
     */
    public O_BookingInfoEntity getBookingDetailInfo(Long bookingID);

    /**
     * @description 根据查询指时间内的预订单信息
     * @author Zhaolingchen
     * @time 2017-5-17 10:12
     * @version 2.0.0
     */
    List<O_BookingInfoEntity> getBookingInfoListByBookingTime(Map<String,Object> param);

    /**
     * @description 查询用户预订记录信息
     * @author Zhaolingchen
     * @time 2017-5-23 10:12
     * @version 2.0.0
     */
    List<O_BookingInfoEntity> getMemberBookingRecordInfo(Map<String,Object> param);


    /**
     * 通过子订单号查询预定单详情信息
     * @author LeeJun
     * @time 2017-5-17 17:02
     * @version 2.0.0
     */
    Map<String, Object> getBookingDetailBySubOrderID(@Param("subOrderID") Long subOrderID, @Param("mealsID") Long mealsID);

    /**
     * @author Zhaolingchen
     * @version 2.0.0
     * @description 查询指定桌台,在指定时间属于某个预订单单
     * @time 2017-06-14 16:00:00
     */
    O_BookingInfoEntity getBookingInfoByTableID(O_BookingInfoEntity bookingInfoEntity);
    
    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 根据预订ID更新预订信息
     * @time 2017-6-14 19:45
     */
    void updateByBookingID(O_BookingInfoEntity bookingInfoEntity);

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 根据订单ID查询预订信息
     * @time 2017-6-16 17:03
     */
    O_BookingInfoEntity queryByOrderID(Long orderID);
}