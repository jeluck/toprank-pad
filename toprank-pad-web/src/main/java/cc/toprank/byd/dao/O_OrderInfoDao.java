package cc.toprank.byd.dao;

import cc.toprank.byd.entity.O_BookingInfoEntity;
import cc.toprank.byd.entity.O_OrderInfoEntity;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**********************************************************************************************************************
 *
 * 版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 * O_OrderInfo数据访问类
 *
 ********************************************************************************************************************/
public interface O_OrderInfoDao {
    int deleteByPrimaryKey(Long orderid);

    int insert(O_OrderInfoEntity record);

    int insertSelective(O_OrderInfoEntity record);

    O_OrderInfoEntity selectByPrimaryKey(Long orderid);

    int updateByPrimaryKeySelective(O_OrderInfoEntity record);

    int updateByPrimaryKey(O_OrderInfoEntity record);

    /**
     * @description 查询桌台使用中订单
     * @author LiSH
     * @time 2017-3-8 10:09
     * @version 2.0.0
     */
    List<Map<String, Object>> getUsingOrderList(Map map);

    /**
     * @description 查询当前餐次桌台下的预定单列表
     * @author LiSH
     * @time 2017-3-8 10:21
     * @version 2.0.0
     */
    List<O_BookingInfoEntity> getBookingOrderListByTableIDAndMealsID(@Param("tableID") Long tableID, @Param("mealsID") Long mealsID, @Param("now") LocalDate now);
    O_OrderInfoEntity get(O_OrderInfoEntity orderInfo);

    List<O_OrderInfoEntity> getAll();

    int update(O_OrderInfoEntity orderInfo);

    void delete(O_OrderInfoEntity orderInfo);

    void save(O_OrderInfoEntity orderInfo);

    /**
     * 修改订单总额和实际金额
     *
     * @param o_suborderinfo
     * @throws Exception
     * @author LanZY
     */
    void updateOrderInfoByOrderID(O_OrderInfoEntity orderInfo);


    /**
     * 根据桌台id，餐次ID，查询，返回实体类
     *
     * @param O_OrderInfoEntity
     * @return
     * @author xuexin
     */
    O_OrderInfoEntity getOrderInfoEntity(Map<String, Object> orderinfoMap);

    /**
     * 新增子订单
     *
     * @param O_OrderInfoEntity
     * @return
     * @author xuexin
     */
    Long saveOrderInfoEntity(O_OrderInfoEntity orderInfo);

    /**
     * 根据订单编号改变订单状态
     *
     * @param orderID
     * @throws Exception
     * @author HuangCY
     */
    void updateOrderInfoStatus(O_OrderInfoEntity entity);

    /**
     * 根据订单开始时间，结束时间，桌台号，订单编码，餐次id，订单状态，档案id来查询相关订单
     *
     * @param Map<String, Object>
     * @return List<Map<String, Object>>
     * @author xuexin
     */
    List<O_OrderInfoEntity> getOrderCenterInfoList(Map<String, Object> map);

    /**
     * 根据订单编号改变订单折扣金额和实际金额
     *
     * @param entity
     * @throws Exception
     * @author HuangCY
     */
    void updateAmountByOrderID(O_OrderInfoEntity entity);

    /**
     * 根据订单,桌台号，订单编码，餐次id，订单状态，档案id来查询一条订单，进行中的订单
     *
     * @param Map<String, Object>
     * @return
     * @author xuexin
     */
    O_OrderInfoEntity getOrderInfoEntityByTableIDAndOrderStatus(Map<String, Object> map);

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 根据主键查询订单信息
     * @time 2017-4-10 13:48
     */
    O_OrderInfoEntity queryOrderInfoByOrderID(long orderID);

    /**
     * @author Zhaolingcen
     * @version 2.0.0
     * @description  查询用户消费记录
     * @time 2017-05-20 11:00:00
     */
    List<Map<String, Object>> getConsumeRecordInfo(Map<String, Object> map);

    /**
     * @description 查询用户点菜记录信息
     * @author Zhaolingchen
     * @time 2017-5-23 10:12
     * @version 2.0.0
     */
    List<Map<String,Object>> getOrderDishesRecordInfo(Map<String,Object> param);

    /**
     * @description 查询用户点菜记录信息
     * @author Zhaolingchen
     * @time 2017-5-23 10:12
     * @version 2.0.0
     */
    List<Map<String,Object>> getOrderTasteRecordInfo(Map<String,Object> param);

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 根据订单ID修改折扣金额
     * @time 2017-6-13 16:50
     */
    void updateDiscountAmountByOrderID (O_OrderInfoEntity entity) ;
}