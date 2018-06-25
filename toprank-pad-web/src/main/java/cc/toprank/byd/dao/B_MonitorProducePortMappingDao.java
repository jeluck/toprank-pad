package cc.toprank.byd.dao;

import cc.toprank.byd.entity.B_MonitorProducePortMappingEntity;

import java.util.List;

/**
 * Created by LanZY on 2017-5-6.
 */
public interface B_MonitorProducePortMappingDao {

    /**
     * @Description： 根据TreeID查询看板出品口显示信息
     * @Author：LanZY
     * @Time: 2017-5-6 15:01
     * @Version 2.0.0
     * @param treeID
     */
    List<B_MonitorProducePortMappingEntity> getMonitorProducePortByTreeID(String treeID);
}
