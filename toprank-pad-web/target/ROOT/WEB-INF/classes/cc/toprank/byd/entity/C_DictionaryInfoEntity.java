package cc.toprank.byd.entity;

import cc.toprank.byd.entity.C_DictionaryInfoEntityBase;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在C_DictionaryInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class C_DictionaryInfoEntity extends C_DictionaryInfoEntityBase {
    private String catalogCode;

    private Long filterID;

    public String getCatalogCode() {
        return catalogCode;
    }

    public void setCatalogCode(String catalogCode) {
        this.catalogCode = catalogCode;
    }

    public Long getFilterID() {
        return filterID;
    }

    public void setFilterID(Long filterID) {
        this.filterID = filterID;
    }
}