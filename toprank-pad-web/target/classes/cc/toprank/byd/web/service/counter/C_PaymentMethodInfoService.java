package cc.toprank.byd.web.service.counter;

import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.constant.ResultData;
import cc.toprank.byd.dao.C_PaymentMethodInfoDao;
import cc.toprank.byd.entity.C_PaymentMethodInfoEntity;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HouXH
 * @version 1.0.0
 * @description 支付方式
 * @time 2017/4/7 18:22
 */
@Service("c_PaymentMethodService")
public class C_PaymentMethodInfoService {
    @Autowired
    private C_PaymentMethodInfoDao c_paymentMethodInfoDao;

    /**
     * @author HouXH
     * @version 1.0.0
     * @description 查询所有支付方式
     * @time 2017/4/7 18:56
     */
    public ResultData getPaymentMethod() {
        ResultData resultData = new ResultData();
        List<C_PaymentMethodInfoEntity> c_paymentMethodInfoEntities = c_paymentMethodInfoDao.getAll();
        if (CollectionUtils.isEmpty(c_paymentMethodInfoEntities)) {
            resultData.setCode(CodeMsgConstants.PAYMENT_NOT_EXIST);
            resultData.setMessage(CodeMsgConstants.PAYMENT_NOT_EXIST_MSG);
        } else {
            resultData.setCode(CodeMsgConstants.SUCCESS);
            resultData.setData(c_paymentMethodInfoEntities);
        }
        return resultData;
    }
}
