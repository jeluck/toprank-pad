package cc.toprank.byd.dao;

import cc.toprank.byd.entity.O_OrderRelationDetailInfoEntity;

/**
 * 订单关联明细
 * Created by HuangCY on 2017-6-12.
 */
public interface O_OrderRelationDetailInfoDao {
    
    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 新增订单关联明细
     * @time 2017-6-12 15:07
     */
    void saveOrderRelationDetailInfo (O_OrderRelationDetailInfoEntity entity);

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 根据子订单ID查询关联明细
     * @time 2017-6-15 13:52
     */
    O_OrderRelationDetailInfoEntity queryOrderRelationBySubOrderID(Long subOrderID);
}
