package cc.toprank.byd.entity;

/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在O_OrderDiscountMapping类中进行修改
 * 
 * ********************************************************************************************************************/
public class O_OrderDiscountMappingEntity extends O_OrderDiscountMappingEntityBase {
    private String loginAccount;
    private Long mappingOrderID;

    public Long getMappingOrderID() {
        return mappingOrderID;
    }

    public void setMappingOrderID(Long mappingOrderID) {
        this.mappingOrderID = mappingOrderID;
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }
}