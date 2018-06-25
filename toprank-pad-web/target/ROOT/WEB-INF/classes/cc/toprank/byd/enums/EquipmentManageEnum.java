package cc.toprank.byd.enums;

/******************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的字典枚举类，不能手动修改。
 * 
 * ****************************************************************************************************/

public class EquipmentManageEnum {

	/**
	 * 
	 * 售货机状态
	 */
	public enum VendingStatus{
	  /**
	   * 未知
	   */
	  UNKNOWN(111, "未知"),
	  /**
	   * 正常
	   */
	  NORMAL(112, "正常"),
	  /**
	   * 维护中
	   */
	  MAINTENANCE(113, "维护中"),
	  /**
	   * 暂停服务
	   */
	  SUSPEND(114, "暂停服务"),
	  /**
	   * 已注销
	   */
	  CANCELLED(115, "已注销");
  
	  private final long value;
	  private final String name;
	  
	  private VendingStatus(long value,String name) {
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
	 * 饮料机状态
	 */
	public enum DrinksDriverStatus{
	  /**
	   * 饮料机串口失败
	   */
	  OPENFAILED(139, "饮料机串口失败"),
	  /**
	   * 读取超时
	   */
	  READTIMEOUT(140, "读取超时"),
	  /**
	   * 打开指示灯失败
	   */
	  OPENLAMPFAILED(141, "打开指示灯失败"),
	  /**
	   * 正常
	   */
	  DRINKSNORMAL(142, "正常"),
	  /**
	   * 异常
	   */
	  DRINKSABNORMAL(143, "异常");
  
	  private final long value;
	  private final String name;
	  
	  private DrinksDriverStatus(long value,String name) {
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
	 * 关联类别
	 */
	public enum MappingType{
	  /**
	   * 未知
	   */
	  UNKNOWN(163, "未知"),
	  /**
	   * 所有权
	   */
	  OWNERSHIP(164, "所有权"),
	  /**
	   * 管理权
	   */
	  MANAGEMENT(165, "管理权");
  
	  private final long value;
	  private final String name;
	  
	  private MappingType(long value,String name) {
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
	 * 售货机操作类别
	 */
	public enum VendingOperateType{
	  /**
	   * 未知
	   */
	  UNKNOWN(166, "未知"),
	  /**
	   * 补货
	   */
	  REPLENISHMENT(167, "补货"),
	  /**
	   * 购买
	   */
	  BUY(168, "购买"),
	  /**
	   * 取货
	   */
	  DELIVERY(169, "取货");
  
	  private final long value;
	  private final String name;
	  
	  private VendingOperateType(long value,String name) {
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
	 * 售货机异常状态
	 */
	public enum VendingErrorCode{
	  /**
	   * 正常
	   */
	  NORMAL(198, "正常"),
	  /**
	   * 未知错误
	   */
	  UNKNOWN(199, "未知错误"),
	  /**
	   * 打开串口失败
	   */
	  OPENSERIALFAILED(200, "打开串口失败"),
	  /**
	   * 读取超时
	   */
	  READTIMEOUT(201, "读取超时"),
	  /**
	   * 写入超时
	   */
	  WRITETIMEOUT(202, "写入超时"),
	  /**
	   * 打开货仓失败
	   */
	  OPENGODOWNFAILED(203, "打开货仓失败"),
	  /**
	   * 未找到设备
	   */
	  CANNOTFOUNDDEVICE(204, "未找到设备");
  
	  private final long value;
	  private final String name;
	  
	  private VendingErrorCode(long value,String name) {
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
	 * 看板显示方式
	 */
	public enum MonitorShowType{
	  /**
	   * 按商品类别显示
	   */
	  PRODUCTCATEGORY(814, "按商品类别显示"),
	  /**
	   * 按厨师显示
	   */
	  CHEF(815, "按厨师显示");
  
	  private final long value;
	  private final String name;
	  
	  private MonitorShowType(long value,String name) {
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