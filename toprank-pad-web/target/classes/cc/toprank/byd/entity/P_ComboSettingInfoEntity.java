package cc.toprank.byd.entity;

import cc.toprank.byd.entity.P_ComboSettingInfoEntityBase;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在P_ComboSettingInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class P_ComboSettingInfoEntity extends P_ComboSettingInfoEntityBase {
    // 扩展字段
    private String productName;
    private String filePath;
    private Boolean needWeigh;

    public Boolean getNeedWeigh() {
        return needWeigh;
    }

    public void setNeedWeigh(Boolean needWeigh) {
        this.needWeigh = needWeigh;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        productName = productName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        filePath = filePath;
    }
  
}