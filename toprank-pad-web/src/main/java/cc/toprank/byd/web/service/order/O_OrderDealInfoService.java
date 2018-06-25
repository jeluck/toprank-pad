package cc.toprank.byd.web.service.order;

import cc.toprank.byd.dao.O_OrderDealInfoDao;
import cc.toprank.byd.entity.O_OrderDealInfoEntity;
import cc.toprank.byd.entity.O_OrderInfoEntity;
import cc.toprank.byd.entity.O_SubOrderInfoEntity;
import cc.toprank.byd.util.MaxIDUtils;
import cc.toprank.byd.web.service.menu.O_OrderInfoService;
import cc.toprank.byd.web.service.menu.O_SubOrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**********************************************************************************************************************
 *
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   B_AttachmentInfoService 真实的业务实现类，允许修改
 *
 * ********************************************************************************************************************/
@Service("o_OrderDealInfoService")
public class O_OrderDealInfoService {
    @Autowired
    private O_SubOrderInfoService subOrderInfoService;

    @Autowired
    private O_OrderInfoService orderInfoService;

    @Autowired
    private O_OrderDealInfoDao orderDealInfoDao;

    public O_OrderDealInfoEntity get(O_OrderDealInfoEntity orderDealInfo) throws Exception {
        return orderDealInfoDao.get(orderDealInfo);
    }

    public List<O_OrderDealInfoEntity> getAll() throws Exception {
        return orderDealInfoDao.getAll();
    }

    public void update(O_OrderDealInfoEntity orderDealInfo) throws Exception {
        orderDealInfoDao.update(orderDealInfo);
    }

    public void delete(O_OrderDealInfoEntity orderDealInfo) throws Exception {
        orderDealInfoDao.delete(orderDealInfo);
    }

    public void save(O_OrderDealInfoEntity orderDealInfo) throws Exception {
        orderDealInfoDao.save(orderDealInfo);
    }

    /**
     * 新增订单处理信息
     *
     * @param orderID
     * @param subOrderID
     * @param beforStatus
     * @param afterStatus
     * @throws Exception
     * @author HuangCY
     */
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
            aftSubOrderEntity = subOrderInfoService.queryBySubOrderID(Long.valueOf(map.get("subOrderID").toString()));
            //根据订单编号查询订单信息
            aftOrderInfoEntity = orderInfoService.queryByOrderID(aftSubOrderEntity.getOrderID());
            //设置订单编号
            entity.setOrderID(aftOrderInfoEntity.getOrderID());
            //设置子订单编号
            entity.setSubOrderID(Long.valueOf(map.get("subOrderID").toString()));
        }
        if (null != map.get("orderID")) {
            //设置订单编号
            entity.setOrderID(Long.valueOf(map.get("orderID").toString()));
            //根据订单编号查询订单信息
            aftOrderInfoEntity = orderInfoService.queryByOrderID(Long.valueOf(map.get("orderID").toString()));
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

        entity.setIsSync(false);

        orderDealInfoDao.save(entity);
    }


    /**
     * @param subOrderID   子订单ID
     * @param orderID      订单ID
     * @param changeAmount 改变金额
     * @param BeforeAmount 改变前金额
     * @param AfterAmount  改变后金额
     * @param dealDesc     描述
     * @throws Exception
     * @Description： 新增订单处理信息
     * @Author：LanZY
     * @Time: 2017-4-6 15:15
     * @Version 2.0.0
     */
    public void saveOrderDealInfo(Long subOrderID, Long orderID, BigDecimal changeAmount,
                                  BigDecimal BeforeAmount, BigDecimal AfterAmount,
                                  Long beforeStatus, Long afterStatus,  String dealDesc) throws Exception {
        O_OrderDealInfoEntity orderDealInfo = new O_OrderDealInfoEntity();
        orderDealInfo.setSubOrderID(subOrderID);
        orderDealInfo.setOrderID(orderID);
        orderDealInfo.setChangeAmount(changeAmount);
        orderDealInfo.setBeforeAmount(BeforeAmount);
        orderDealInfo.setAfterAmount(AfterAmount);
        orderDealInfo.setDealDesc(dealDesc);
        orderDealInfo.setIsSync(false);
        orderDealInfo.setCreateTime(LocalDateTime.now());
        orderDealInfo.setDealID(MaxIDUtils.getID(O_OrderDealInfoEntity.class));
        orderDealInfo.setAfterStatus(afterStatus);
        orderDealInfo.setBeforeStatus(beforeStatus);
        orderDealInfoDao.insertSelective(orderDealInfo);
    }
}