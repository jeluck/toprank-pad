package cc.toprank.byd.entity;

import java.math.BigDecimal;
import java.util.List;

/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 *   继承自自动生成的实体，具体业务方法使用的实体类
 *   如果具体业务需要扩展字段，请扩展该类
 * 
 * ********************************************************************************************************************/
public class F_ViceFundInfoEntity  extends F_ViceFundInfoEntityBase{
  private double initAmountCopy ;   // 挂账额度
  private double realAmountCopy ;   // 剩余额度
  private double tempAmountCopy ;   // 临时额度
  private double fundAmount;   // 资金余额
  private int bonusAmount;      // 积分余额
  private String customerName;      // 账号姓名
  private String mobile; 
  private List<String> mobiles;     // 手机号列表
  
  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public List<String> getMobiles() {
    return mobiles;
  }

  public void setMobiles(List<String> mobiles) {
    this.mobiles = mobiles;
  }

  public double getInitAmountCopy() {
    if (super.getInitAmount() == null) {
      return BigDecimal.ZERO.doubleValue();
    }
    return super.getInitAmount().doubleValue();
  }

  public void setInitAmountCopy(double initAmountCopy) {
    super.setInitAmount(BigDecimal.valueOf(initAmountCopy));
  }

  public double getRealAmountCopy() {
    if(super.getRealAmount() == null){
      return BigDecimal.ZERO.doubleValue();
    }
    return super.getRealAmount().doubleValue();
  }

  public void setRealAmountCopy(double realAmountCopy) {
    super.setRealAmount(BigDecimal.valueOf(realAmountCopy));
  }

  public double getTempAmountCopy() {
    if(super.getTempAmount() == null){
        return BigDecimal.ZERO.doubleValue();
    }
    return super.getTempAmount().doubleValue();
  }

  public void setTempAmountCopy(double tempAmountCopy) {
    super.setTempAmount(BigDecimal.valueOf(tempAmountCopy));
  }

  public double getFundAmount() {
    return fundAmount;
  }

  public void setFundAmount(double fundAmount) {
    this.fundAmount = fundAmount;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }
  

}