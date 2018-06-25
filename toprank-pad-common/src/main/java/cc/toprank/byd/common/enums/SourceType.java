package cc.toprank.byd.common.enums;

/**
 * Enum description
 *
 */
public enum SourceType {
    WEB("web", "web��"), IOS("ios", "ios"), ANDROID("android", "android");

    /** Field description */
    private String code;

    /** Field description */
    private String desc;

    /**
     * Constructs ...
     *
     *
     * @param code
     * @param desc
     */
    SourceType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public String getCode() {
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



