
package cc.toprank.byd.common.enums;

/**
 * Enum description
 *
 */
public enum StatusEnum {
    ON(0, "����"), OFF(1, "����");

    /** Field description */
    private final Integer value;

    /** Field description */
    private final String text;

    /**
     * Constructs ...
     *
     *
     * @param value
     * @param text
     */
    StatusEnum(Integer value, String text) {
        this.value = value;
        this.text  = text;
    }

    /**
     * Method description
     *
     *
     * @param value
     *
     * @return
     */
    public static StatusEnum getEnum(Integer value) {
        if (value != null) {
            StatusEnum[] values = StatusEnum.values();

            for (StatusEnum ss : values) {
                if (ss.getValue().equals(value)) {
                    return ss;
                }
            }
        }

        return null;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public String getText() {
        return text;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public Integer getValue() {
        return value;
    }
}



