package cc.toprank.byd.kanban.service;

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.common.utils.DateUtils;
import cc.toprank.byd.dao.*;
import cc.toprank.byd.entity.B_DesignerMonitorInfoEntity;
import cc.toprank.byd.entity.B_MerchantInfoEntity;
import cc.toprank.byd.entity.B_MonitorContentInfoEntity;
import cc.toprank.byd.entity.B_MonitorInfoEntity;
import cc.toprank.byd.enums.OrderManagerEnum;
import cc.toprank.byd.kanban.dto.ShowContentVO;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 看板接口服务类
 *
 * @author LeeJun
 * @version 2.0.0
 * @time 2017-3-7 10:57
 */
@Service
public class DisplayService {

    private static final Logger logger = LoggerFactory.getLogger(DisplayService.class);

    @Autowired
    private B_MonitorInfoDao monitorInfoDao;
    @Autowired
    private B_MonitorContentInfoDao monitorContentInfoMapper;
    @Autowired
    private B_DesignerMonitorInfoDao designerMonitorInfoDao;

    /**
     * @param archiveID
     * @return
     * @description：根据商户档案编号查询该商户所有看板配置
     * @author：LiYC
     * @time: 2017-3-7 15:27
     * @version 2.0.0
     */
    public List<B_MonitorInfoEntity> getKanBanInfoList(Long archiveID) {
        return monitorInfoDao.selectByArchiveID(archiveID); // 取出商户档案信息
    }

    /**
     * @param monitorID
     * @return
     * @description：根据看板编号查询该看板配置
     * @author：LiYC
     * @time: 2017-3-7 15:27
     * @version 2.0.0
     */
    public B_MonitorInfoEntity getMerchantInfoByID(Long monitorID) {
        return monitorInfoDao.selectByPrimaryKey(monitorID); // 取出看板信息
    }

    @Transactional
    public Map<String, List<B_DesignerMonitorInfoEntity>> getWaitMakeProduct(Long monitorID) throws ParseException {
        B_MonitorInfoEntity monitorInfo = monitorInfoDao.selectByPrimaryKey(monitorID);
        if (null == monitorInfo) {
            BizException.error("此看板未配置");
        }
        Long showType = monitorInfo.getShowType();
        String showContentID = monitorInfo.getShowContentID();
        if (StringUtils.isEmpty(showContentID)) {
            BizException.error("此看板未指定厨师或分类");
        }
        List<B_DesignerMonitorInfoEntity> maitMakeProducts = designerMonitorInfoDao.getDesignerMonitorByMonitorID(monitorID, showType, showContentID);
        Map<String, List<B_DesignerMonitorInfoEntity>> products = new LinkedHashMap<>();
        for (B_DesignerMonitorInfoEntity product : maitMakeProducts) {
            handleProduceStatus(product);
            // 拆分数据结构，以桌台分类，每个桌台对应一个菜品列表
            String tableName = product.getTableName();
            List<B_DesignerMonitorInfoEntity> tempProducts = null;
            if (products.containsKey(tableName)) {
                products.get(tableName).add(product);
            } else {
                tempProducts = new ArrayList();
                tempProducts.add(product);
                products.put(tableName, tempProducts);
            }
        }
        return products;
    }

    /**
     * 处理看板显示商品制作状态\计算制作剩余时间
     *
     * @author LeeJun
     * @time 2017-5-15 15:04
     * @version 2.0.0
     */
    public void handleProduceStatus(B_DesignerMonitorInfoEntity designerMonitor) {
        Long produceStatus = designerMonitor.getProduceStatus();
        long remainingSeconds = DateUtils.getSecondsBetween(LocalDateTime.now(), designerMonitor.getAuditTime().plusMinutes(designerMonitor.getProduceMinute()));
        String productName = designerMonitor.getProductName();
        if (OrderManagerEnum.ProductionStatus.SOCALLED.getValue().equals(produceStatus)) {
            // 等叫状态默认剩余时长为菜品制作时长
            remainingSeconds = designerMonitor.getProduceMinute() * 60;
            designerMonitor.getAuditTime();
            if (DateUtils.getSecondsBetween(LocalDateTime.now(), designerMonitor.getAuditTime()) <= 0) {
                produceStatus = OrderManagerEnum.ProductionStatus.INPRODUCTION.getValue();
                designerMonitor.setProduceStatus(produceStatus);
                designerMonitorInfoDao.updateByPrimaryKeySelective(designerMonitor);
                remainingSeconds = DateUtils.getSecondsBetween(LocalDateTime.now(), designerMonitor.getAuditTime().plusMinutes(designerMonitor.getProduceMinute()));
            }
        } else if (OrderManagerEnum.ProductionStatus.PENDINGWEIGH.getValue().equals(produceStatus)) {
            // 待称重状态，在菜品名称后面标示待称重，状态改为延时。
            productName = designerMonitor.getProductName() + "(待称重)";
            remainingSeconds = designerMonitor.getProduceMinute() * 60;
            produceStatus = OrderManagerEnum.ProductionStatus.SOCALLED.getValue();
        } else {
            // 其他状态都改为制作中(未制作) 693
            produceStatus = OrderManagerEnum.ProductionStatus.INPRODUCTION.getValue();
        }
        // 未制作状态且剩余时间少于0改为超时698
        if (OrderManagerEnum.ProductionStatus.INPRODUCTION.getValue().equals(produceStatus) && remainingSeconds < 0) {
            // 超时
            produceStatus = OrderManagerEnum.ProductionStatus.OVERTIME.getValue();
        }
        designerMonitor.setProduceStatus(produceStatus);
        designerMonitor.setProductName(productName);
        designerMonitor.setRemainingSeconds(remainingSeconds);
    }

//    public void handleProduceStatus(B_DesignerMonitorInfoEntity designerMonitor) {
//        Long produceStatus = designerMonitor.getProduceStatus();
//        long remainingSeconds = DateUtils.getSecondsBetween(LocalDateTime.now(), designerMonitor.getCreateTime().plusMinutes(designerMonitor.getProduceMinute()));
//        String productName = designerMonitor.getProductName();
//        if (produceStatus == OrderManagerEnum.ProductionStatus.SOCALLED.getValue() || produceStatus == OrderManagerEnum.ProductionStatus.DELAYED.getValue()) {
//            // 等叫694设为延时697
//            produceStatus = OrderManagerEnum.ProductionStatus.DELAYED.getValue();
//            // 等叫状态默认剩余时长为菜品制作时长
//            remainingSeconds = designerMonitor.getProduceMinute() * 60;
//        } else if (produceStatus == OrderManagerEnum.ProductionStatus.REMINDER.getValue() || produceStatus == OrderManagerEnum.ProductionStatus.URGENT.getValue()) {
//            // 催菜695设为加急696
//            produceStatus = OrderManagerEnum.ProductionStatus.URGENT.getValue();
//        } else if (produceStatus == OrderManagerEnum.ProductionStatus.PENDINGWEIGH.getValue()) {
//            // 待称重状态，在菜品名称后面标示待称重，状态改为延时。
//            productName = designerMonitor.getProductName() + "(待称重)";
//            remainingSeconds = designerMonitor.getProduceMinute() * 60;
//            produceStatus = OrderManagerEnum.ProductionStatus.DELAYED.getValue();
//        } else if (produceStatus == OrderManagerEnum.ProductionStatus.WEIGHED.getValue()) {
//            // 已称重状态，在菜品名称后面标示已称重
//            productName = designerMonitor.getProductName() + "(已称重)";
//            // 状态改为制作中
//            produceStatus = OrderManagerEnum.ProductionStatus.INPRODUCTION.getValue();
//        } else {
//            // 其他状态都改为制作中(未制作) 693
//            produceStatus = OrderManagerEnum.ProductionStatus.INPRODUCTION.getValue();
//        }
//        // 未制作状态且剩余时间少于0改为超时698
//        if (produceStatus == OrderManagerEnum.ProductionStatus.INPRODUCTION.getValue() && remainingSeconds < 0) {
//            // 超时
//            produceStatus = OrderManagerEnum.ProductionStatus.OVERTIME.getValue();
//        }
//        designerMonitor.setProduceStatus(produceStatus);
//        designerMonitor.setProductName(productName);
//        designerMonitor.setRemainingSeconds(remainingSeconds);
//    }


    public ShowContentVO getShowContent(Long monitorID) {
        List<B_MonitorContentInfoEntity> contents = monitorContentInfoMapper.getByMonitorID(monitorID);
        ShowContentVO showContentVO = null;
        try {
            Class clazz = Class.forName(ShowContentVO.class.getName());
            Method method;
            showContentVO = (ShowContentVO) clazz.newInstance();
            Method[] methods = clazz.getMethods();
            for (B_MonitorContentInfoEntity c : contents) {
                method = clazz.getMethod("set" + c.getTitleField(), boolean.class);
                method.invoke(showContentVO, c.getIsShow());
            }
        } catch (Exception e) {
            logger.error("getShowContent error", e);
        }
        return showContentVO;
    }

}
