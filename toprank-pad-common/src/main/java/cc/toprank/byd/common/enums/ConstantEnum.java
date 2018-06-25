package cc.toprank.byd.common.enums;

/**
 * Enum description
 *
 */
public enum ConstantEnum {
    Valid(0, "��Ч"),      // ��Ч�������������õȵ�
    Invalid(1, "����");    // ��Ч�����á��ѽ��õȵ�

    /** Field description */
    private Integer code;

    /** Field description */
    private String desc;

    /**
     * Constructs ...
     *
     *
     * @param code
     * @param desc
     */
    ConstantEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public Integer getCode() {
        return code;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public String getDesc() {
        return desc;
    }
}



