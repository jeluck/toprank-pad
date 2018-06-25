package cc.toprank.byd.enums;

/******************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的字典枚举类，不能手动修改。
 * 
 * ****************************************************************************************************/

public class ServiceManageEnum {

	/**
	 * 
	 * 配额状态
	 */
	public enum QuotaStatus{
	  /**
	   * 未知
	   */
	  UNKNOWN(205, "未知"),
	  /**
	   * 正常
	   */
	  NORMAL(206, "正常"),
	  /**
	   * 余量有限
	   */
	  LESS(207, "余量有限"),
	  /**
	   * 售罄
	   */
	  SOLDOUT(208, "售罄"),
	  /**
	   * 已锁定
	   */
	  FROZEN(209, "已锁定"),
	  /**
	   * 暂停销售
	   */
	  SUSPEND(210, "暂停销售"),
	  /**
	   * 已停售
	   */
	  EXPIRED(211, "已停售"),
	  /**
	   * 已使用
	   */
	  USED(222, "已使用");
  
	  private final long value;
	  private final String name;
	  
	  private QuotaStatus(long value,String name) {
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
	 * 验证码状态
	 */
	public enum ValidationCodeStatus{
	  /**
	   * 未知
	   */
	  UNKNOWN(212, "未知"),
	  /**
	   * 正常
	   */
	  NORMAL(213, "正常"),
	  /**
	   * 未激活
	   */
	  UNACTIVATED(214, "未激活"),
	  /**
	   * 已锁定
	   */
	  LOCKED(215, "已锁定"),
	  /**
	   * 已使用
	   */
	  USED(216, "已使用"),
	  /**
	   * 已过期
	   */
	  EXPIRED(217, "已过期"),
	  /**
	   * 已分配
	   */
	  ALLOCATED(223, "已分配");
  
	  private final long value;
	  private final String name;
	  
	  private ValidationCodeStatus(long value,String name) {
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
	 * 额度调整类型
	 */
	public enum QuotaChangeType{
	  /**
	   * 未知
	   */
	  UNKNOWN(248, "未知"),
	  /**
	   * 配额
	   */
	  QUOTA(249, "配额"),
	  /**
	   * 本期配额
	   */
	  CURRENTQUOTA(250, "本期配额"),
	  /**
	   * 数量
	   */
	  QUANTITY(251, "数量"),
	  /**
	   * 本期数量
	   */
	  CURRENTQUANTITY(252, "本期数量"),
	  /**
	   * 起止日期调整
	   */
	  DATECHANGE(272, "起止日期调整"),
	  /**
	   * 额度状态
	   */
	  QUOTASTATUS(273, "额度状态"),
	  /**
	   * 创建额度
	   */
	  QUOTACREATE(274, "创建额度"),
	  /**
	   * 期末自动重置
	   */
	  DURATIONAUTORESET(320, "期末自动重置");
  
	  private final long value;
	  private final String name;
	  
	  private QuotaChangeType(long value,String name) {
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
	 * 服务订单查询类型
	 */
	public enum ServiceOrderQueryType{
	  /**
	   * 未知
	   */
	  UNKNOWN(253, "未知"),
	  /**
	   * 未付款
	   */
	  WAITINGPAID(254, "未付款"),
	  /**
	   * 已付款
	   */
	  PAID(255, "已付款"),
	  /**
	   * 已付款未兑换
	   */
	  WAITINGCHANGE(256, "已付款未兑换"),
	  /**
	   * 已付款已兑换
	   */
	  CHANGED(257, "已付款已兑换");
  
	  private final long value;
	  private final String name;
	  
	  private ServiceOrderQueryType(long value,String name) {
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