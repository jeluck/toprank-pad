package cc.toprank.byd.producePort.service;

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.common.utils.DateUtils;
import cc.toprank.byd.constant.PadConstants;
import cc.toprank.byd.dao.*;
import cc.toprank.byd.entity.B_DesignerMonitorInfoEntity;
import cc.toprank.byd.entity.B_ProducePortInfoEntity;
import cc.toprank.byd.entity.O_ComboDetailInfoEntity;
import cc.toprank.byd.entity.O_OrderDetailInfoEntity;
import cc.toprank.byd.enums.CommonManageEnum;
import cc.toprank.byd.enums.OrderManagerEnum;
import cc.toprank.byd.producePort.pojo.ProduceDTO;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 出品口service
 *
 * @author LeeJun
 * @create 2017-06-12 17:13
 */
@Service
public class ProducePortService {

    @Autowired
    private B_ProducePortInfoDao producePortInfoDao;
    @Autowired
    private B_DesignerMonitorInfoDao monitorInfoDao;
    @Autowired
    private B_MerchantTagInfoDao merchantTagInfoDao;
    @Autowired
    private O_OrderDetailInfoDao orderDetailInfoDao;
    @Autowired
    private O_ComboDetailInfoDao comboDetailInfoDao;

    /**
     * 获取出品口列表
     *
     * @author LeeJun
     * @time 2017-6-12 17:20
     * @version 2.0.0
     */
    public List<B_ProducePortInfoEntity> getProducePortList(Long archiveID) {
        return producePortInfoDao.getProducePortByArchiveID(archiveID);
    }

    /**
     * 获取出品口菜品列表
     *
     * @author LeeJun
     * @time 2017-6-13 14:21
     * @version 2.0.0
     */
    public List<ProduceDTO> getProduceByPortID(Long portID, int type, String keywords, int pageNum) {
        PageHelper.startPage(pageNum, PadConstants.PAGE_SIZE);
        List<ProduceDTO> produceList = monitorInfoDao.getProduceByPortID(portID, type, keywords);
        Long targetType = CommonManageEnum.GoalsType.ORDER_DETAILS.getValue();
        for (ProduceDTO produce : produceList) {
            long duration = DateUtils.getMinutesBetween(produce.getAuditTime(), LocalDateTime.now());
            produce.setDuration(duration);
            Long targetID = produce.getDetailID();
            if (produce.isCombo()) {
                targetID = produce.getRecordID();
                targetType = CommonManageEnum.GoalsType.PACKAGE_DETAILS.getValue();
            }
            List<String> tagNames = merchantTagInfoDao.getTagNameByTargetID(targetID, targetType);
            produce.setTagNames(tagNames);
        }
        return produceList;
    }

    /**
     * 修改订单明细制作状态
     *
     * @author LeeJun
     * @time 2017-6-13 15:39
     * @version 2.0.0
     */
    public boolean updateProduceStatus(Long produceID, int type) {
        B_DesignerMonitorInfoEntity designerMonitorInfo = monitorInfoDao.selectByPrimaryKey(produceID);
        Long produceStatus = OrderManagerEnum.ProductionStatus.ALREADYPRODUCED.getValue();
        if (type == 1) {
            produceStatus = OrderManagerEnum.ProductionStatus.INPRODUCTION.getValue();
        }
        if (designerMonitorInfo == null) {
            throw new BizException("不存在ID:%s对应的制作菜品：", produceID);
        }
        designerMonitorInfo.setProduceStatus(produceStatus);
        designerMonitorInfo.setAuditTime(LocalDateTime.now());
        monitorInfoDao.updateByPrimaryKeySelective(designerMonitorInfo);
        if (designerMonitorInfo.isComob()) {
            O_ComboDetailInfoEntity comboDetail = new O_ComboDetailInfoEntity();
            comboDetail.setRecordID(designerMonitorInfo.getRecordID());
            comboDetail.setProduceStatus(produceStatus);
            comboDetail.setProduceTime(LocalDateTime.now());
            comboDetailInfoDao.updateByPrimaryKeySelective(comboDetail);
        } else {
            O_OrderDetailInfoEntity orderDetail = new O_OrderDetailInfoEntity();
            orderDetail.setDetailID(designerMonitorInfo.getDetailID());
            orderDetail.setProduceStatus(produceStatus);
            orderDetail.setProduceTime(LocalDateTime.now());
            orderDetailInfoDao.updateByPrimaryKeySelective(orderDetail);
        }
        return true;
    }

}
