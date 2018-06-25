package cc.toprank.byd.dao;

import cc.toprank.byd.entity.B_WorkingInfoEntity;
import cc.toprank.byd.web.vo.TableBookVO;

import java.util.List;
import java.util.Map;

public interface B_WorkingInfoDao {
    int deleteByPrimaryKey(Long workingID);

    int insert(B_WorkingInfoEntity record);

    int insertSelective(B_WorkingInfoEntity record);

    B_WorkingInfoEntity selectByPrimaryKey(Long workingID);

    int updateByPrimaryKeySelective(B_WorkingInfoEntity record);

    int updateByPrimaryKey(B_WorkingInfoEntity record);

    Map<String, Object> getWorkingInfo(Map param);

    Map<String, Object> getMealsInfo(Map param);


    /**
     * @author LiSH
     * @version 2.0.0
     * @description 支付方式
     * @time 2017-5-26 16:43
     */
    List<Map<String, Object>> getPayMethod(Map param);


    /**
     * @author LiSH
     * @version 2.0.0
     * @description 总额统计
     * @time 2017-5-26 16:42
     */
    Map<String, Object> getWorkingMoney(Map param);

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 订单统计
     * @time 2017-5-26 16:42
     */
    List<Map<String, Object>> getOrderMoney(Map param);

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 会员统计
     * @time 2017-5-26 16:42
     */
    List<Map<String, Object>> getMemberMoney(Map param);

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 预定统计
     * @time 2017-5-26 16:43
     */
    List<Map<String, Object>> getBookingMoney(Map param);

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 退订统计
     * @time 2017-5-26 16:43
     */
    List<Map<String, Object>> getUnsubscribeMoney(Map param);


    /**
     * @author LiSH
     * @version 2.0.0
     * @description 查询上一个开班数据
     * @time 2017-5-26 17:16
     */
    Map<String, Object> getBeforeWorkingInfo(Map param);

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 获取交接班次列表
     * @time 2017-5-27 9:58
     */
    List<Map<String, Object>> getWorkingList(Map param);

    Map<String, Object> getWorkingInfoByWorkingID(Map<String, Object> param);

    List<Map<String, Object>> getDailyWorkingList(Map<String, Object> paraMap);

    Map<String, Object> testDate();

    TableBookVO testDate2();

    String getPayMethodNameByPayMethodID(String payMethodID);

    Map<String, Object> getDailyCloseOrderCount(Map<String, Object> paraMap);

    Map<String,Object> getTurnoverRate();

    Map<String,Object> getTableRate();

    List<Long> getSubOrderIDList(Map<String,Object> paraMap);
}