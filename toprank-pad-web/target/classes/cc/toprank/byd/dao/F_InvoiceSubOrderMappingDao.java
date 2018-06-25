package cc.toprank.byd.dao;

import cc.toprank.byd.entity.F_InvoiceSubOrderMappingEntity;

/**
 * 发票子订单关联信息
 * Created by HuangCY on 2017-5-26.
 */
public interface F_InvoiceSubOrderMappingDao {
    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 新增发票子订单关联信息
     * @time 2017-5-26 18:07
     */
    void save (F_InvoiceSubOrderMappingEntity entity);

}
