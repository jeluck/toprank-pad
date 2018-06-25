package cc.toprank.byd.dao;

import cc.toprank.byd.entity.C_PaymentMethodInfoEntity;

import java.util.List;

/**
 * @author HouXH
 * @version 1.0.0
 * @description
 * @time 2017/4/7 18:37
 */
public interface C_PaymentMethodInfoDao {
    List<C_PaymentMethodInfoEntity> getAll();

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 查询支付方式
     * @time 2017-5-3 14:48
     */
    List<C_PaymentMethodInfoEntity> getPaymentMethod();
}
