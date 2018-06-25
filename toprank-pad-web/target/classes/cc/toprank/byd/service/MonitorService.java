package cc.toprank.byd.service;

import cc.toprank.byd.dao.B_DesignerMonitorInfoDao;
import cc.toprank.byd.dao.B_MonitorInfoDao;
import cc.toprank.byd.dao.U_LoginInfoDao;
import cc.toprank.byd.entity.B_DesignerMonitorInfoEntity;
import cc.toprank.byd.entity.B_MonitorInfoEntity;
import cc.toprank.byd.entity.U_LoginInfoEntity;
import cc.toprank.byd.enums.EquipmentManageEnum;
import cc.toprank.byd.enums.SystemManageEnum;
import cc.toprank.byd.util.MaxIDUtils;
import org.apache.commons.collections.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 看板service
 * 智能分配厨师，录入看板显示数据
 *
 * @author LeeJun
 * @create 2017-05-11 19:55
 */
@Service
public class MonitorService {

    private final static Logger LOGGER = LoggerFactory.getLogger(MonitorService.class);

    @Autowired
    private B_MonitorInfoDao monitorInfoDao;
    @Autowired
    private B_DesignerMonitorInfoDao designerMonitorInfoDao;
    @Autowired
    private U_LoginInfoDao loginInfoDao;

    /**
     * 添加待制作菜品信息到厨师看板中
     *
     * @param orderDetailIDs 订单明细ID数组
     * @author LeeJun
     * @time 2017-5-12 17:02
     * @version 2.0.0
     */
    @Transactional
    public boolean addWaitMakeProduct2DesignerMonitorInfo(List<Long> orderDetailIDs) {
        List<B_DesignerMonitorInfoEntity> orderDetail = designerMonitorInfoDao.getOrderDetailByDetailIDs(orderDetailIDs);
        List<B_DesignerMonitorInfoEntity> comboDetail = designerMonitorInfoDao.getComboDetailByDetailIDs(orderDetailIDs);
        handleMonitorInfo(orderDetail, false);
        handleMonitorInfo(comboDetail, true);
        orderDetail = ListUtils.union(orderDetail, comboDetail);
        List<B_DesignerMonitorInfoEntity> splitEntities = splitMonitorInfo(orderDetail);
        orderDetail = ListUtils.union(orderDetail, splitEntities);
        int row = designerMonitorInfoDao.insertBatch(orderDetail);
        if (row > 0) {
            return true;
        }
        return false;
    }

    /**
     * 处理看板显示信息
     *
     * @author LeeJun
     * @time 2017-5-12 16:47
     * @version 2.0.0
     */
    protected void handleMonitorInfo(List<B_DesignerMonitorInfoEntity> designerMonitorList, boolean isComob) {
        for (B_DesignerMonitorInfoEntity designerMonitor : designerMonitorList) {
            Long monitorID = null;
            Long varID = null;
            designerMonitor.setProduceID(MaxIDUtils.getID(B_DesignerMonitorInfoEntity.class));
            Long creatorType = designerMonitor.getCreatorType();
            // 判断是否服务员点餐
            if (creatorType != null && creatorType == SystemManageEnum.UserType.SYSTEMUSER.getValue()
                    && designerMonitor.getCreatorID() != null) {
                // designerMonitor.setClerkID(designerMonitor.getCreatorID());
                U_LoginInfoEntity loginInfo = loginInfoDao.getByID(designerMonitor.getCreatorID());
                designerMonitor.setClerkName(loginInfo.getNickName());
            }
            // 判断是否为套餐
            if (isComob) {
                designerMonitor.setProductName(designerMonitor.getProductName() + "(套)");
            }
            // 判断是否有拼桌子
            int shareNumber = designerMonitor.getShareNumber();
            if (shareNumber > 1) {
                designerMonitor.setTableName(designerMonitor.getTableName() + "-拼" + shareNumber);
            }
            designerMonitor.setCreateTime(LocalDateTime.now());
            // 查询所有看板配置信息
            List<B_MonitorInfoEntity> monitorList = monitorInfoDao.selectByArchiveID(designerMonitor.getArchiveID());
            if (monitorList.isEmpty()) {
                LOGGER.warn("未配置看板数据。");
                return;
            }
            Long designerID = designerMonitor.getDesignerID();
            String designerName = designerMonitor.getDesignerName();
            B_MonitorInfoEntity monitor = monitorList.get(0);
            // 如未指定厨师，则需要分配厨师
            if (designerID == null) {
                // 判断商家配置的看板类型，如为厨师看板则需要分配菜品厨师,商品分类看板无需分配厨师
                if (monitor.getShowType().longValue() == EquipmentManageEnum.MonitorShowType.CHEF.getValue()) {
                    varID = designerID = distributionChef(designerMonitor);
                } else {
                    varID = designerMonitor.getCategoryID();
                }
                if (!StringUtils.isEmpty(designerID)) {
                    designerName = designerMonitorInfoDao.getDesignerNameNameByID(designerID);
                }
            }
            designerMonitor.setDesignerID(designerID);
            designerMonitor.setDesignerName(designerName);
            // 根据厨师ID或分类ID取看板id
            for (B_MonitorInfoEntity monitorInfo : monitorList) {
                List<String> ids = Arrays.asList(monitorInfo.getShowContentID().split(","));
                if (ids.contains(String.valueOf(varID))) {
                    monitorID = monitorInfo.getMonitorID();
                    break;
                }
            }
            designerMonitor.setMonitorID(monitorID);
        }
    }

    /**
     * 拆分数量大于1的记录为多条相同数据
     *
     * @author LeeJun
     * @time 2017-5-26 14:43
     * @version 2.0.0
     */
    public List<B_DesignerMonitorInfoEntity> splitMonitorInfo(List<B_DesignerMonitorInfoEntity> designerMonitorList) {
        List<B_DesignerMonitorInfoEntity> repeatBeans = new ArrayList<>();
        for (B_DesignerMonitorInfoEntity designerMonitor : designerMonitorList) {
            Integer quantity = designerMonitor.getQuantity();
            if (quantity != null && quantity > 1) {
                designerMonitor.setQuantity(1);
                B_DesignerMonitorInfoEntity copyBean = null;
                for (int i = 0; i < quantity - 1; i++) {
                    copyBean = new B_DesignerMonitorInfoEntity();
                    BeanUtils.copyProperties(designerMonitor, copyBean);
                    copyBean.setProduceID(MaxIDUtils.getID(B_DesignerMonitorInfoEntity.class));
                    repeatBeans.add(copyBean);
                }
            }
        }
        return repeatBeans;
    }

    /**
     * 分配厨师
     *
     * @author LeeJun
     * @time 2017-5-10 15:14
     * @version 2.0.0
     */
    protected Long distributionChef(B_DesignerMonitorInfoEntity designerMonitor) {
        // 查询菜品对应的厨师ID列表
        List<Long> designerIDs = designerMonitorInfoDao.getDesignerByProductID(designerMonitor.getProductID(), designerMonitor.getVariantID());
        // 无则查询菜品所属分类对应的厨师ID列表
        if (designerIDs.isEmpty()) {
            designerMonitorInfoDao.getDesignerByCategoryID(designerMonitor.getCategoryID());
        }
        // 无则查询看板配置的厨师ID列表
        if (designerIDs.isEmpty()) {
            designerIDs = designerMonitorInfoDao.getDesignerIDByMonitorMapping(designerMonitor.getArchiveID());
        }
        // 通过厨师ID列表查询厨师剩余的制作时长，取最制作时长短的厨师，相同时间取随机
        Long designerID = null;
        if (!designerIDs.isEmpty()) {
            designerID = designerMonitorInfoDao.getDesignerProduceMinuteByDesignerID(designerIDs);
        }
        // 无则代表当前厨师列表都没待制作菜品
        if (designerID == null && !designerIDs.isEmpty()) {
            // 随机取一个厨师
            Random r = new Random();
            designerID = designerIDs.get(r.nextInt(designerIDs.size()));
        }
        return designerID;
    }
}
