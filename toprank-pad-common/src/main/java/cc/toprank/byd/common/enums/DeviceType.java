
package cc.toprank.byd.common.enums;

/**
 * Enum description
 *
 */
public enum DeviceType {
    PC(1, "PC"), Android(2, "ANDROID"), IOS(3, "IOS"), WAP(4, "WAP");

    /** Field description */
    private int type;

    /** Field description */
    private String dis;

    /**
     * Constructs ...
     *
     *
     * @param type
     * @param dis
     */
    DeviceType(int type, String dis) {
        this.type = type;
        this.dis  = dis;
    }

    /**
     * Method description
     *
     *
     * @param o
     *
     * @return
     */
    public static DeviceType valueOf(int o) {
        switch (o) {
        case 1 :
            return DeviceType.PC;

        case 2 :
            return DeviceType.Android;

        case 3 :
            return DeviceType.IOS;

        case 4 :
            return DeviceType.WAP;

        default :
            return null;
        }
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public String getDis() {
        return dis;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public int getType() {
        return type;
    }
}



