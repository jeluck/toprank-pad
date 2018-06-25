package cc.toprank.byd.web.service.discount;/**
 * Created by ZhouWei on 2017-5-19.
 */

import cc.toprank.byd.dao.M_ActivityInfoDao;
import cc.toprank.byd.dao.O_OrderActivityMappingDao;
import cc.toprank.byd.dao.O_OrderDiscountMappingDao;
import cc.toprank.byd.entity.O_OrderActivityMappingEntity;
import cc.toprank.byd.entity.O_OrderDiscountMappingEntity;
import cc.toprank.byd.util.MaxIDUtils;
import cc.toprank.byd.web.service.payment.PaymentService;
import cc.toprank.byd.web.vo.discount.ActivityInfoVO;
import cc.toprank.byd.web.vo.paymentvo.AmountSituationVO;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @param
 * @author zhouwei
 * @version 2.0.0
 * @description 订单活动关联服务类
 * @time 2017-05-19-14:20
 * @return
 */
@Service("orderActivityMappingService")
public class OrderActivityMappingService {
    @Autowired
    private O_OrderActivityMappingDao o_orderActivityMappingDao;
    @Autowired
    private O_OrderDiscountMappingDao o_orderDiscountMappingDao;
    @Autowired
    private M_ActivityInfoDao m_activityInfoDao;
    @Autowired
    private PaymentService paymentService;

    /**
     * @param
     * @author zhouwei
     * @version 2.0.0
     * @description 插入订单活动关联信息
     * @time 2017-05-19-17:00
     * @return
     */
    @Transactional(rollbackFor=Exception.class)
    public int addActivityInfoMapping(O_OrderActivityMappingEntity orderActivityMappingEntity){
        return o_orderActivityMappingDao.addActivityInfoMapping(orderActivityMappingEntity);
    }

    /**
     * @param
     * @author zhouwei
     * @version 2.0.0
     * @description 插入订单折扣信息
     * @time 2017-05-19-17:00
     * @return
     */
    @Transactional(rollbackFor=Exception.class)
    public int addOrderDisCountMapping(BigDecimal payableAmount, Long subOrderID,Long archiveID,Long loginID) throws Exception{
        Map map = new HashMap<>();
        if (payableAmount != null){
            map.put("currentAmount",payableAmount);
        }
        map.put("archiveID",archiveID);
        List<ActivityInfoVO> activityInfoVOList = m_activityInfoDao.getActivityInfoList(map);
        if (CollectionUtils.isNotEmpty(activityInfoVOList)){
            for (ActivityInfoVO activityInfoVO:activityInfoVOList) {
                O_OrderDiscountMappingEntity o_orderDiscountMappingEntity = new O_OrderDiscountMappingEntity();
                o_orderDiscountMappingEntity.setMappingID(MaxIDUtils.getID(O_OrderDiscountMappingEntity.class));
                o_orderDiscountMappingEntity.setOrderID(paymentService.getOrderID(Arrays.asList(subOrderID),loginID).getOrderID());
//                o_orderDiscountMappingEntity.setMappingOrderID(0L);
                o_orderDiscountMappingEntity.setDiscountID(activityInfoVO.getDiscountID());
//                o_orderDiscountMappingEntity.setRecordID(activityInfoVO.getRecordID());
                o_orderDiscountMappingEntity.setLoginID(loginID);
                o_orderDiscountMappingEntity.setSubOrderID(subOrderID);
                if (activityInfoVO.getDiscountPercentage() != null){
                    o_orderDiscountMappingEntity.setIsRatio(true);
                    o_orderDiscountMappingEntity.setDiscountPercentage(activityInfoVO.getDiscountPercentage());
                }
                o_orderDiscountMappingEntity.setDiscountType(activityInfoVO.getDiscountType());
                o_orderDiscountMappingEntity.setDiscountAmount(activityInfoVO.getDiscountAmount());
                o_orderDiscountMappingEntity.setPresentAmount(activityInfoVO.getPresentAmount());
                o_orderDiscountMappingEntity.setPresentBonus(activityInfoVO.getPresentBonus());
                o_orderDiscountMappingEntity.setIsManualProcess(false);
//                o_orderDiscountMappingEntity.setCustomerMemo();
                o_orderDiscountMappingEntity.setMappingDesc(activityInfoVO.getActivityName());
//                o_orderDiscountMappingEntity.setSortNo();
                o_orderDiscountMappingEntity.setCreatorID(activityInfoVO.getCreatorID());
//                o_orderDiscountMappingEntity.setCreatorType();
                o_orderDiscountMappingEntity.setCreateTime(LocalDateTime.now());
//                o_orderDiscountMappingEntity.setAuthorizer();
                o_orderDiscountMappingEntity.setAuthorizeTime(LocalDateTime.now());
                o_orderDiscountMappingDao.insert(o_orderDiscountMappingEntity);
            }
            return 1;
        }
        return 0;
    }
    /**
     * @param
     * @author zhouwei
     * @version 2.0.0
     * @description 根据子订单获取折扣名称
     * @time 2017-05-19-17:00
     * @return
     */
    public List<String> getOrderDisCountMappingBySubOrderID(Long subOrderID){
        Map<String,Object> map = new HashMap();
        map.put("subOrderID",subOrderID);
        return o_orderDiscountMappingDao.getOrderDisCountMappingBySubOrderID(map);
    }



}
