package cc.toprank.byd.enums;

/******************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的字典枚举类，不能手动修改。
 * 
 * ****************************************************************************************************/

public class TargetTypeEnum {

	/**
	 * 
	 * 合同类型
	 */
	public enum ContractType{
	  /**
	   * 挂账合同
	   */
	  LEDGERCONTRACT(766L, "挂账合同");
  
	  private final Long value;
	  private final String name;
	  
	  private ContractType(Long value,String name) {
	    this.value = value;
	    this.name = name;
	  }
	
	  public Long getValue() {
	    return this.value;
	  }
	  
	  public String getName() {
	    return this.name;
	  }
	}
	
}