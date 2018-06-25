package cc.toprank.byd.enums;

/******************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的字典枚举类，不能手动修改。
 * 
 * ****************************************************************************************************/

public class PlatformImageManageEnum {

	/**
	 * 
	 * 首页图片
	 */
	public enum IndexImages{
	  /**
	   * Banner图
	   */
	  BANNERIMAGES(514, "Banner图"),
	  /**
	   * 横条图
	   */
	  CROSSBANNERIMAGES(515, "横条图"),
	  /**
	   * 今日优惠
	   */
	  TODAYDISCOUNTIMAGE(516, "今日优惠");
  
	  private final long value;
	  private final String name;
	  
	  private IndexImages(long value,String name) {
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