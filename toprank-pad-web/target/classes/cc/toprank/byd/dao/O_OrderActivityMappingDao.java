package cc.toprank.byd.dao;/**
 * Created by ZhouWei on 2017-5-22.
 */

import cc.toprank.byd.entity.O_OrderActivityMappingEntity;

/**
 * @param
 * @author zhouwei
 * @version 2.0.0
 * @description 订单活动关联信息
 * @time 2017-05-22-17:09
 * @return
 */
public interface O_OrderActivityMappingDao {
    /**
     * @param
     * @author zhouwei
     * @version 2.0.0
     * @description 插入订单活动关联信息
     * @time 2017-05-22-17:09
     * @return
     */
    int addActivityInfoMapping(O_OrderActivityMappingEntity o_orderActivityMappingEntity);
}
