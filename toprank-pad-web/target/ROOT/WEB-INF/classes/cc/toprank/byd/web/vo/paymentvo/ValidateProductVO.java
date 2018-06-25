package cc.toprank.byd.web.vo.paymentvo;

import cc.toprank.byd.entity.O_OrderDetailInfoEntity;

import java.util.List;

/**
 * 验证商品VO
 * Created by HuangCY on 2017-5-2.
 */
public class ValidateProductVO {
    // 结果码
    private int code;
    // 返回消息
    private String message;
    //返回结果集
    private List<O_OrderDetailInfoEntity> resultList;

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

    public List<O_OrderDetailInfoEntity> getResultList() {
        return resultList;
    }

    public void setResultList(List<O_OrderDetailInfoEntity> resultList) {
        this.resultList = resultList;
    }
}
