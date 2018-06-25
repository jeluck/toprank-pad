package cc.toprank.byd.web.service.payment;

import cc.toprank.byd.dao.O_OrderDealInfoDao;
import cc.toprank.byd.dao.O_OrderInfoDao;
import cc.toprank.byd.dao.O_SubOrderInfoDao;
import cc.toprank.byd.entity.O_OrderDealInfoEntity;
import cc.toprank.byd.entity.O_OrderInfoEntity;
import cc.toprank.byd.entity.O_SubOrderInfoEntity;
import cc.toprank.byd.util.MaxIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * 订单处理信息
 * Created by HuangCY on 2017-5-2.
 */
@Service("orderDealInfoService")
public class OrderDealInfoService {

    //子订单信息
    @Autowired
    private O_SubOrderInfoDao o_SubOrderInfoDao;
    //订单信息
    @Autowired
    private O_OrderInfoDao o_OrderInfoDao;
    //订单处理信息
    @Autowired
    private O_OrderDealInfoDao o_OrderDealInfoDao;

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 新增订单处理信息
     * @time 2017-4-10 14:42
     */
    @Transactional
    public void addOrderDealInfo(Map map) throws Exception {
        //处理前状态
        Long befStatus = null;
        //处理后状态
        Long aftStatus = null;
        //处理前金额
        double befAmount = 0;
        //处理后金额
        double aftAmount = 0;
        //变动金额
        double changeAmount = 0;

        O_OrderDealInfoEntity entity = new O_OrderDealInfoEntity();

        O_SubOrderInfoEntity aftSubOrderEntity = new O_SubOrderInfoEntity();

        O_OrderInfoEntity aftOrderInfoEntity = new O_OrderInfoEntity();

        if (null != map.get("subOrderID")) {
            //根据子订单编号查询子订单信息
            aftSubOrderEntity = o_SubOrderInfoDao.querySubOrderInfoBySubOrderID(Long.valueOf(map.get("subOrderID").toString()));
            //根据订单编号查询订单信息
            aftOrderInfoEntity = o_OrderInfoDao.queryOrderInfoByOrderID(aftSubOrderEntity.getOrderID());
            //设置订单编号
            entity.setOrderID(aftOrderInfoEntity.getOrderID());
            //设置子订单编号
            entity.setSubOrderID(Long.valueOf(map.get("subOrderID").toString()));
        }
        if (null != map.get("orderID")) {
            //设置订单编号
            entity.setOrderID(Long.valueOf(map.get("orderID").toString()));
            //根据订单编号查询订单信息
            aftOrderInfoEntity = o_OrderInfoDao.queryOrderInfoByOrderID(Long.valueOf(map.get("orderID").toString()));
        }
        if (null != map.get("befSubOrderActualAmount")) {
            //子订单处理前实际金额
            befAmount = Double.valueOf(map.get("befSubOrderActualAmount").toString());
            //子订单变更后实际金额
            aftAmount = aftSubOrderEntity.getActualAmount().doubleValue();
        }
        if (null != map.get("befSubOrderDiscountAmount")) {
            //子订单处理前折扣金额
            befAmount = Double.valueOf(map.get("befSubOrderDiscountAmount").toString());
            //子订单变更后折扣金额
            aftAmount = aftSubOrderEntity.getDiscountAmount().doubleValue();
        }
        if (null != map.get("befSubOrderTotalAmount")) {
            //子订单处理前总金额
            befAmount = Double.valueOf(map.get("befSubOrderTotalAmount").toString());
            //子订单变更后总金额
            aftAmount = aftSubOrderEntity.getTotalAmount().doubleValue();
        }
        if (null != map.get("befSubOrderPendingAmount")) {
            //子订单处理前待付金额
            befAmount = Double.valueOf(map.get("befSubOrderPendingAmount").toString());
            //子订单变更后待付金额
            aftAmount = aftSubOrderEntity.getPendingAmount().doubleValue();
        }
        if (null != map.get("befOrderActualAmount")) {
            //订单处理前实际金额
            befAmount = Double.valueOf(map.get("befOrderActualAmount").toString());
            //订单变更后实际金额
            aftAmount = aftOrderInfoEntity.getActualAmount().doubleValue();
        }
        if (null != map.get("befOrderDiscountAmount")) {
            //订单处理前折扣金额
            befAmount = Double.valueOf(map.get("befOrderDiscountAmount").toString());
            //订单变更后折扣金额
            aftAmount = aftOrderInfoEntity.getDiscountAmount().doubleValue();
        }
        if (null != map.get("befOrderTotalAmount")) {
            //订单处理前总金额
            befAmount = Double.valueOf(map.get("befOrderTotalAmount").toString());
            //订单变更后总金额
            aftAmount = aftOrderInfoEntity.getTotalAmount().doubleValue();
        }
        if (null != map.get("befOrderPendingAmount")) {
            //订单处理前待付金额
            befAmount = Double.valueOf(map.get("befOrderPendingAmount").toString());
            //订单变更后待付金额
            aftAmount = aftOrderInfoEntity.getPendingAmount().doubleValue();
        }

        //变动金额
        if (null != map.get("changeAmount")) {
            changeAmount = Double.valueOf(map.get("changeAmount").toString());
        }

        //子订单状态变动
        if (null != map.get("befSubOrderStatus")) {
            befStatus = Long.valueOf(map.get("befSubOrderStatus").toString());
            aftStatus = aftSubOrderEntity.getOrderStatus();
        }

        //订单状态变动
        if (null != map.get("befOrderStatus")) {
            befStatus = Long.valueOf(map.get("befOrderStatus").toString());
            aftStatus = aftOrderInfoEntity.getOrderStatus();
        }

        //设置变动金额
        entity.setChangeAmount(BigDecimal.valueOf(changeAmount));
        //设置处理前金额
        entity.setBeforeAmount(BigDecimal.valueOf(befAmount));
        //设置处理后金额
        entity.setAfterAmount(BigDecimal.valueOf(aftAmount));
        //设置处理前状态
        entity.setBeforeStatus(befStatus);
        //设置处理后状态
        entity.setAfterStatus(aftStatus);
        //设置创建时间
        entity.setCreateTime(LocalDateTime.now());
        entity.setDealID(MaxIDUtils.getID(O_OrderDealInfoEntity.class));
        entity.setIsSync(false);

        o_OrderDealInfoDao.insertSelective(entity);
    }
}
