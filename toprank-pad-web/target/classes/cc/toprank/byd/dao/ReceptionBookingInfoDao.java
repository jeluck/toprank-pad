package cc.toprank.byd.dao;


import cc.toprank.byd.entity.ReceptionBookingInfoEntity;
import cc.toprank.byd.entity.ReceptionUsingTableEntity;

import java.util.List;
import java.util.Map;

/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 *   B_MealsInfo数据访问类
 * 
 * ********************************************************************************************************************/

public interface ReceptionBookingInfoDao  {
  /**
   * 根据机构id查询预定桌台列表
   * 
   * @author XuJin
   * @param map
   * @return
   */
   List<ReceptionBookingInfoEntity> getBookingInfoCollection(Map<?, ?> map);
  
  /**
   * 查询当前使用桌的消费金额总和
   * @author XuJin
   * @param map
   * @return
   */
   ReceptionUsingTableEntity getTableInfoActualAmountByCondition(Map<?, ?> map);

    /**
     *  @Description： 查询当前便用桌的时间长，拼台数量，联台信息
     * @Author：HuTao
     * @Time: 2017-3-22 10:50
     * @Version 2.0.0
     * @param map
     *
     */
    ReceptionUsingTableEntity getTogetherNumTimes(Map<?, ?> map);

    /**
     * @Description：取预定数量
     * @Author：HuTao
     * @Time: 2017-6-14 17:28
     * @Version 2.0.0
     * @param map
     * @return
     */
   Map<String,Object> getBookingInfoCount(Map<?, ?> map);


}