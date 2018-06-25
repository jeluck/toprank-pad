package cc.toprank.byd.entity;

/**
 * 会员卡信息
 * Created by HuangCY on 2017-6-9.
 */
public class MemberCardInfoVO {
    // 结果码
    private int code;
    // 返回消息
    private String message;
    //会员卡信息对象
    private MemCardInfoDTO memCardInfoDTO;

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

    public MemCardInfoDTO getMemCardInfoDTO() {
        return memCardInfoDTO;
    }

    public void setMemCardInfoDTO(MemCardInfoDTO memCardInfoDTO) {
        this.memCardInfoDTO = memCardInfoDTO;
    }
}
