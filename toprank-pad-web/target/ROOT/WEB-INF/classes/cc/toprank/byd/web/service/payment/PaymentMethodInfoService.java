package cc.toprank.byd.web.service.payment;

import cc.toprank.byd.dao.C_PaymentMethodInfoDao;
import cc.toprank.byd.entity.C_PaymentMethodInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 支付方式
 * Created by HuangCY on 2017-5-21.
 */
@Service("paymentMethodInfoService")
public class PaymentMethodInfoService {
    //支付方式
    @Autowired
    private C_PaymentMethodInfoDao c_PaymentMethodInfoDao;

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 查询支付方式
     * @time 2017-5-21 18:28
     */
    public List<C_PaymentMethodInfoEntity> getPaymentMethod() throws Exception {
        return c_PaymentMethodInfoDao.getPaymentMethod();
    }

}
