package cc.toprank.byd.common.enums;

/**
 * Enum description
 *
 */
public enum RegisterType {
    MEMBER(0, "����"), MERCHANT(1, "�̼�");

    /** Field description */
    private int code;

    /** Field description */
    private String desc;

    /**
     * Constructs ...
     *
     *
     * @param code
     * @param desc
     */
    RegisterType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public int getCode() {
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



