package cc.toprank.byd.dao;

import cc.toprank.byd.entity.B_MonitorInfoEntity;
import cc.toprank.byd.web.vo.menu.MonitorVO;

import java.util.List;
import java.util.Map;

public interface B_MonitorInfoDao {
    int deleteByPrimaryKey(Long monitorid);

    int insert(B_MonitorInfoEntity record);

    int insertSelective(B_MonitorInfoEntity record);

    B_MonitorInfoEntity selectByPrimaryKey(Long monitorid);

    int updateByPrimaryKeySelective(B_MonitorInfoEntity record);

    int updateByPrimaryKey(B_MonitorInfoEntity record);

    /**
     * @description：根据档案号查询看板集合
     * @author：LiYC
     * @time: 2017-3-7 15:13
     * @version 2.0.0
     * @param archiveId
     * @return
     */
    List<B_MonitorInfoEntity> selectByArchiveID(Long archiveId);

    B_MonitorInfoEntity get(B_MonitorInfoEntity monitorInfo);

    List<B_MonitorInfoEntity> getAll();

    void update(B_MonitorInfoEntity monitorInfo);

    void delete(B_MonitorInfoEntity monitorInfo);

    void save(B_MonitorInfoEntity monitorInfo);

    /**
     * @Description： 根据档案ID查询看板配置信息
     * @Author：LanZY
     * @Time: 2017-5-6 13:47
     * @Version 2.0.0
     * @param archiveID
     * @return
     */
    List<B_MonitorInfoEntity> getMonitorInfoByArchiveID(Long archiveID);

    /**
     * @Description： 查询看板基本设置信息
     * @Author：LanZY
     * @Time: 2017-5-6 17:59
     * @Version 2.0.0
     * @param map
     * @return
     */
    MonitorVO getBasicSetInfo(Map<String,Object> map);
}
