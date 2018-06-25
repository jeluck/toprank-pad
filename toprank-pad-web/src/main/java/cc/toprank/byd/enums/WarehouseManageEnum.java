package cc.toprank.byd.enums;

/******************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的字典枚举类，不能手动修改。
 * 
 * ****************************************************************************************************/

public class WarehouseManageEnum {

	/**
	 * 
	 * 仓库类别
	 */
	public enum WarehouseType{
	  /**
	   * 普通仓库
	   */
	  WAREHOUSETYPENORMAL(89, "普通仓库"),
	  /**
	   * 冷冻仓库
	   */
	  WAREHOUSETYPECOLD(90, "冷冻仓库"),
	  /**
	   * 虚拟库房
	   */
	  VIRTUALWAREHOUSE(110, "虚拟库房");
  
	  private final long value;
	  private final String name;
	  
	  private WarehouseType(long value,String name) {
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
	 * 仓库状态
	 */
	public enum WarehouseStatus{
	  /**
	   * 启用
	   */
	  ENABLE(91, "启用"),
	  /**
	   * 禁用
	   */
	  DISABLE(92, "禁用"),
	  /**
	   * 未知
	   */
	  UNKNOWN(93, "未知");
  
	  private final long value;
	  private final String name;
	  
	  private WarehouseStatus(long value,String name) {
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
	 * 大区编号
	 */
	public enum BigAreaCode{
	  /**
	   * 亚太
	   */
	  ASIAPACIFIC(97, "亚太"),
	  /**
	   * 北美
	   */
	  NORTHAMERICA(98, "北美"),
	  /**
	   * 大中华
	   */
	  GREATERCHINA(99, "大中华"),
	  /**
	   * 欧洲
	   */
	  EUROPE(100, "欧洲");
  
	  private final long value;
	  private final String name;
	  
	  private BigAreaCode(long value,String name) {
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