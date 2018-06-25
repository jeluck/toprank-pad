package cc.toprank.byd.web.service.payment;

import cc.toprank.byd.dao.O_OrderRelationDetailInfoDao;
import cc.toprank.byd.entity.O_OrderRelationDetailInfoEntity;
import cc.toprank.byd.util.MaxIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 订单关联明细
 * Created by HuangCY on 2017-6-12.
 */
@Service("orderRelationDetailInfoService")
public class OrderRelationDetailInfoService {

    //订单关联明细
    @Autowired
    private O_OrderRelationDetailInfoDao o_orderRelationDetailInfoDao;

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 新增订单关联明细
     * @time 2017-6-12 15:16
     */
    public void saveOrderRelationDetailInfo(Long mappingID , Long subOrderID , BigDecimal amount , Long loginID){
        O_OrderRelationDetailInfoEntity orderRelationDetailInfoEntity = new O_OrderRelationDetailInfoEntity();

        orderRelationDetailInfoEntity.setDetailID(MaxIDUtils.getID(O_OrderRelationDetailInfoEntity.class));
        orderRelationDetailInfoEntity.setMappingID(mappingID);
        orderRelationDetailInfoEntity.setCreateTime(LocalDateTime.now());
        orderRelationDetailInfoEntity.setCreatorID(loginID);
        orderRelationDetailInfoEntity.setTargetID(subOrderID);
        orderRelationDetailInfoEntity.setTargetIsOrder(false);
        orderRelationDetailInfoEntity.setTargetAmount(amount);

        o_orderRelationDetailInfoDao.saveOrderRelationDetailInfo(orderRelationDetailInfoEntity);
    }

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 根据子订单ID查询关联明细
     * @time 2017-6-15 13:46
     */
    public O_OrderRelationDetailInfoEntity queryOrderRelationBySubOrderID(Long subOrderID){
        return o_orderRelationDetailInfoDao.queryOrderRelationBySubOrderID(subOrderID);
    }
}
