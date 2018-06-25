package cc.toprank.byd.web.dto;

/**
 * 支付结果
 * Created by HuangCY on 2017-4-14.
 */
public class PayResult {
    // 支付结果
    private int code;
    // 返回消息
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
