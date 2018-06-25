package cc.toprank.byd.dao;

import cc.toprank.byd.entity.B_DesignerMonitorInfoEntity;
import cc.toprank.byd.producePort.pojo.ProduceDTO;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface B_DesignerMonitorInfoDao {
    int insertSelective(B_DesignerMonitorInfoEntity monitorInfoEntity);

    int deleteByPrimaryKey(Long produceID);

    int insertBatch(List<B_DesignerMonitorInfoEntity> record);

    int updateBatch(Map<String, Object> map);

    B_DesignerMonitorInfoEntity selectByPrimaryKey(Long produceID);

    int updateByPrimaryKeySelective(B_DesignerMonitorInfoEntity record);

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 根据订单明细ID更新制作状态
     * @time 2017-5-8 16:48
     */
    void updateDesignerMonitorInfoByDetailID(Map map);

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 根据订单明细ID查询厨师看板信息
     * @time 2017-5-8 17:01
     */
    List<B_DesignerMonitorInfoEntity> getDesignerMonitorInfoByDetailID(B_DesignerMonitorInfoEntity entity);

    /**
     * @Description： 根据套餐明细集合ID查询厨师看板信息
     * @Author：LanZY
     * @Time: 2017-5-20 14:31
     * @Version 2.0.0
     */
    List<B_DesignerMonitorInfoEntity> getDesignerMonitorInfoByRecordID(B_DesignerMonitorInfoEntity entity);

    String getDesignerNameNameByID(Long designerID);

    /**
     * 根据看板配置所有厨师分配厨师
     * 分配给负责该菜品的厨师，取剩余制作时长最短的厨师，如有多个，则随即分配
     *
     * @author LeeJun
     * @time 2017-5-10 18:28
     * @version 2.0.0
     */
    Long getDesignerProduceMinuteByDesignerID(List designerIDs);

    /**
     * 通过subOrderID查询订单明细信息
     *
     * @author LeeJun
     * @time 2017-5-11 19:41
     * @version 2.0.0
     */
    List<B_DesignerMonitorInfoEntity> getOrderDetailByDetailIDs(List<Long> orderDetailIDs);

    /**
     * 通过subOrderID查询套餐明细信息
     *
     * @author LeeJun
     * @time 2017-5-11 19:41
     * @version 2.0.0
     */
    List<B_DesignerMonitorInfoEntity> getComboDetailByDetailIDs(List<Long> orderDetailIDs);

    /**
     * 查询待制作菜品
     *
     * @author LeeJun
     * @time 2017-5-15 14:28
     * @version 2.0.0
     */
    List<B_DesignerMonitorInfoEntity> getDesignerMonitorByMonitorID(@Param("monitorID") Long monitorID, @Param("showType") Long showType, @Param("showContentID") String showContentID);

    /**
     * 查询菜品对应的厨师ID
     *
     * @author LeeJun
     * @time 2017-5-15 16:55
     * @version 2.0.0
     */
    List<Long> getDesignerByProductID(@Param("productID") Long productID, @Param("variantID") Long variantID);

    /**
     * 查询菜品分类对应的厨师ID
     *
     * @author LeeJun
     * @time 2017-6-17 11:18
     * @version 2.0.0
     */
    List<Long> getDesignerByCategoryID(@Param("categoryID") Long categoryID);

    /**
     * 查询菜品对应的厨师ID
     *
     * @author LeeJun
     * @time 2017-5-15 16:55
     * @version 2.0.0
     */
    List<Long> getDesignerIDByMonitorMapping(Long archiveID);

    /**
     * 根据订单明细ID列表批量修改菜品制作状态
     *
     * @author LeeJun
     * @time 2017-5-22 15:02
     * @version 2.0.0
     */
    int batchStatusByDetailIDs(@Param("detailIDs") String detailIDs, @Param("produceStatus") Long produceStatus, @Param("now") LocalDateTime now);

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 根据记录ID修改制作状态
     * @time 2017-5-23 17:35
     */
    void updateDesignerByRecordID(B_DesignerMonitorInfoEntity entity);

    int deleteByDetailID(Long detailID);

    /**
     * 查询出品口菜品
     *
     * @author LeeJun
     * @time 2017-6-13 13:59
     * @version 2.0.0
     */
    List<ProduceDTO> getProduceByPortID(@Param("portID") Long portID, @Param("type") int type, @Param("keywords") String keywords);

}
