package cc.toprank.byd.entity;

import java.math.BigDecimal;

/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在P_ComboGroupInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class P_ComboGroupInfoEntity  extends P_ComboGroupInfoEntityBase{
    private Long variantID;     //商品变体ID
    private String variantName; //商品名称
    private String unit;        //单位
    private BigDecimal price;   //价格
    private int number;         //数量
    private String optionName;  //规格名称
    private Long priceType;     //价格类型 841总价 842 明细合计
    private Long mappingID;     //套餐分组商品关联ID,
    private Long settingID;     //套餐配置ID

    public Long getSettingID() {
        return settingID;
    }

    public void setSettingID(Long settingID) {
        this.settingID = settingID;
    }

    public Long getMappingID() {
        return mappingID;
    }

    public void setMappingID(Long mappingID) {
        this.mappingID = mappingID;
    }

    public Long getPriceType() {
        return priceType;
    }

    public void setPriceType(Long priceType) {
        this.priceType = priceType;
    }

    public Long getVariantID() {
        return variantID;
    }

    public void setVariantID(Long variantID) {
        this.variantID = variantID;
    }

    public String getVariantName() {
        return variantName;
    }

    public void setVariantName(String variantName) {
        this.variantName = variantName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }
}