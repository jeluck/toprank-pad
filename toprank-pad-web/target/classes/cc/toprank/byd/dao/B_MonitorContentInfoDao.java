package cc.toprank.byd.dao;

import cc.toprank.byd.entity.B_MonitorContentInfoEntity;

import java.util.List;

public interface B_MonitorContentInfoDao {
    int deleteByPrimaryKey(Long contentid);

    int insert(B_MonitorContentInfoEntity record);

    int insertSelective(B_MonitorContentInfoEntity record);

    B_MonitorContentInfoEntity selectByPrimaryKey(Long contentid);

    int updateByPrimaryKeySelective(B_MonitorContentInfoEntity record);

    int updateByPrimaryKey(B_MonitorContentInfoEntity record);

    /**
     * 通过看板ID查询看板显示字段信息
     * @author LeeJun
     * @time 2017-4-6 17:12
     * @version 2.0.0
     */
    List<B_MonitorContentInfoEntity> getByMonitorID(Long monitorID);
}