package cc.toprank.byd.common.enums;

/**
 * Enum description
 *
 */
public enum FileTypeEnum {
    JPEG("FFD8FF"), PNG("89504E47"), GIF("47494638"), TIFF("49492A00"), BMP("424D"), DWG("41433130"), PSD("38425053"),
    XML("3C3F786D6C"), HTML("68746D6C3E"), PDF("255044462D312E"), ZIP("504B0304"), RAR("52617221"), WAV("57415645"),
    AVI("41564920");

    /** Field description */
    private String value = "";

    /**
     * Constructs ...
     *
     *
     * @param value
     */
    FileTypeEnum(String value) {
        this.value = value;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public String getValue() {
        return value;
    }
}



