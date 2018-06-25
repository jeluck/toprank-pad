package cc.toprank.byd.enums;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


/**
 * 菜品标签
 *
 * @author LinYN
 * @date 2017-6-9
 */
public enum  ProductTagEnum {

    FREE_TO_DO("free_to_do", "免做"),

    DO_FIRST("do_first", "先做"),

    PUSH_FOOD("push_food", "催菜"),

    PACK("pack", "打包");

    private String tagCode;

    private String tagName;

    ProductTagEnum(String tagCode, String tagName) {
        this.tagCode = tagCode;
        this.tagName = tagName;
    }

    public String getTagCode() {
        return tagCode;
    }

    public String getTagName() {
        return tagName;
    }

    public static ProductTagEnum valueOfCode(String code){
        ProductTagEnum[] values = ProductTagEnum.values();
        int valueCount = values.length;
        for (int i = 0; i < valueCount; i++) {
            if (values[i].getTagCode().equals(code)) {
                return values[i];
            }
        }
        return null;
    }
}
