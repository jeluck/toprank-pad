package cc.toprank.byd.web.vo.paymentvo;

import cc.toprank.byd.entity.C_PaymentMethodInfoEntity;

import java.util.List;

/**
 * 支付方式VO
 * Created by HuangCY on 2017-5-9.
 */
public class PaymentMethodVO {
    // 结果码
    private int code;
    // 返回消息
    private String message;
    //返回结果集
    List<C_PaymentMethodInfoEntity> resultList;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<C_PaymentMethodInfoEntity> getResultList() {
        return resultList;
    }

    public void setResultList(List<C_PaymentMethodInfoEntity> resultList) {
        this.resultList = resultList;
    }
}
