package cc.toprank.byd.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**********************************************************************************************************************
 *
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在O_ComboDetailInfo类中进行修改
 *
 * ********************************************************************************************************************/
public class O_ComboDetailInfoEntity extends O_ComboDetailInfoEntityBase {
    private Long categoryID;
    private String categoryName;
    private String unitName;
    private Integer produceMinute;

    public Long getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Long categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getProduceMinute() {
        return produceMinute;
    }

    public void setProduceMinute(Integer produceMinute) {
        this.produceMinute = produceMinute;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
}