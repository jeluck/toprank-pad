package cc.toprank.byd.enums;

/******************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的字典枚举类，不能手动修改。
 * 
 * ****************************************************************************************************/

public class DenominationEnum {

	/**
	 * 
	 * 人民币面额
	 */
	public enum RMBDenomination{
	  /**
	   * 人民币100元
	   */
	  RMB100(235, "人民币100元"),
	  /**
	   * 人民币50元
	   */
	  RMB50(236, "人民币50元");
  
	  private final long value;
	  private final String name;
	  
	  private RMBDenomination(long value,String name) {
	    this.value = value;
	    this.name = name;
	  }
	
	  public long getValue() {
	    return this.value;
	  }
	  
	  public String getName() {
	    return this.name;
	  }
	}
	
	/**
	 * 
	 * 港币面额
	 */
	public enum HKDenomination{
	  /**
	   * 港币1000元
	   */
	  HK1000(237, "港币1000元"),
	  /**
	   * 港币500元
	   */
	  HK500(238, "港币500元"),
	  /**
	   * 港币100元
	   */
	  HK100(239, "港币100元"),
	  /**
	   * 港币50元
	   */
	  HK50(240, "港币50元"),
	  /**
	   * 港币20元
	   */
	  HK20(241, "港币20元"),
	  /**
	   * 港币10元
	   */
	  HK10(242, "港币10元");
  
	  private final long value;
	  private final String name;
	  
	  private HKDenomination(long value,String name) {
	    this.value = value;
	    this.name = name;
	  }
	
	  public long getValue() {
	    return this.value;
	  }
	  
	  public String getName() {
	    return this.name;
	  }
	}
	
}