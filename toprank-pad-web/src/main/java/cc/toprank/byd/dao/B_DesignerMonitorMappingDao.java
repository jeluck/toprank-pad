package cc.toprank.byd.dao;

import cc.toprank.byd.entity.B_DesignerMonitorMappingEntity;

import java.util.List;

/**
 * Created by LanZY on 2017-5-6.
 */
public interface B_DesignerMonitorMappingDao {
    B_DesignerMonitorMappingEntity get(B_DesignerMonitorMappingEntity designerMonitorMapping);

    List<B_DesignerMonitorMappingEntity> getAll();

    void update(B_DesignerMonitorMappingEntity designerMonitorMapping);

    void delete(B_DesignerMonitorMappingEntity designerMonitorMapping);

    void save(B_DesignerMonitorMappingEntity designerMonitorMapping);

    /**
     * @Description： 根据厨师编号查询看板信息
     * @Author：LanZY
     * @Time: 2017-5-6 17:33
     * @Version 2.0.0
     * @param designerID
     * @return
     */
    B_DesignerMonitorMappingEntity getDesignerMonitorMappingByDesignerID(Long designerID);
}
