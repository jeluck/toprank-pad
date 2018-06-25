package cc.toprank.byd.dao;

import cc.toprank.byd.entity.F_InvoiceInfoEntity;

/**
 * 发票信息
 * Created by HuangCY on 2017-5-26.
 */
public interface F_InvoiceInfoDao {
    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 新增发票信息
     * @time 2017-5-26 17:01
     */
    void save (F_InvoiceInfoEntity entity) ;

    /**
     * @author Zhaolingchen
     * @version 1.0.0
     * @description 根据子订单ID,获取发票信息
     * @time 2017-6-12 14:01
     */
    F_InvoiceInfoEntity getInvoiceInfoBySubOrderID(Long subOrderID);
}
