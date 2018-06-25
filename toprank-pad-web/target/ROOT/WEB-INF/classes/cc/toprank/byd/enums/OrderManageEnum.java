package cc.toprank.byd.enums;

/******************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的字典枚举类，不能手动修改。
 * 
 * ****************************************************************************************************/

public class OrderManageEnum {

	/**
	 * 
	 * 订单状态
	 */
	public enum OrderStatus{
	  /**
	   * 待支付
	   */
	  WAITINGPAY(59, "待支付"),
	  /**
	   * 待确认
	   */
	  WAITINGCONFIRM(60, "待确认"),
	  /**
	   * 待审核
	   */
	  WAITINGAUDIT(61, "待审核"),
	  /**
	   * 正在配货
	   */
	  PICKING(62, "正在配货"),
	  /**
	   * 配送中
	   */
	  DISTRIBUTING(63, "配送中"),
	  /**
	   * 已配送到店
	   */
	  REACHSTORE(64, "已配送到店"),
	  /**
	   * 客户已提货
	   */
	  DELIVERED(65, "客户已提货"),
	  /**
	   * 已送达
	   */
	  DISTRIBUTED(66, "已送达"),
	  /**
	   * 确认收货
	   */
	  CUSTOMERCONFIRM(67, "确认收货"),
	  /**
	   * 已完成
	   */
	  COMPLETED(68, "已完成"),
	  /**
	   * 客户取消
	   */
	  CUSTOMERCANCEL(69, "客户取消"),
	  /**
	   * 系统取消
	   */
	  SYSTEMCANCEL(70, "系统取消"),
	  /**
	   * 客服取消
	   */
	  MANUALCANCEL(71, "客服取消"),
	  /**
	   * 预订
	   */
	  BOOKING(626, "预订"),
	  /**
	   * 待消费
	   */
	  TOBECONSUMED (649, "待消费"),
	  /**
	   * 待评价
	   */
	  TOBEEVALUATED (650, "待评价"),
	  /**
	   * 待结账
	   */
	  TOBECHECKED (651, "待结账"),
	  /**
	   * 进行中
	   */
	  HAVEINHAND(654, "进行中"),
	  /**
	   * 订单审核中
	   */
	  AUDITING(688, "订单审核中"),
	  /**
	   * 已过期
	   */
	  EXPIRED(701, "已过期"),
	  /**
	   * 订单合台状态
	   */
	  ORDERMAGERTABLESTUST(783, "订单合台状态"),
	  /**
	   * 未下单
	   */
	  NOORDER(875, "未下单"),
	  /**
	   * 已支付
	   */
	  ALREADYPAID(876, "已支付");
  
	  private final long value;
	  private final String name;
	  
	  private OrderStatus(long value,String name) {
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
	 * 小票打印状态
	 */
	public enum TicketPrintStatus{
	  /**
	   * 未知
	   */
	  UNKNOWN(116, "未知"),
	  /**
	   * 打印不完整
	   */
	  INCOMPLETE(117, "打印不完整"),
	  /**
	   * 正常打印
	   */
	  NORMALCOMPLETED(118, "正常打印"),
	  /**
	   * 补打正常
	   */
	  NORMALADDITIONAL(119, "补打正常"),
	  /**
	   * 补打异常
	   */
	  ADDITIONALINCOMPLETE(120, "补打异常"),
	  /**
	   * 未打印
	   */
	  UNPRINTED(123, "未打印");
  
	  private final long value;
	  private final String name;
	  
	  private TicketPrintStatus(long value,String name) {
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
	 * 支付状态
	 */
	public enum PayStatus{
	  /**
	   * 未知
	   */
	  UNKNOW(187, "未知"),
	  /**
	   * 等待支付
	   */
	  WAITINGPAY(188, "等待支付"),
	  /**
	   * 支付中
	   */
	  PAYING(189, "支付中"),
	  /**
	   * 已支付
	   */
	  HASPAID(190, "已支付");
  
	  private final long value;
	  private final String name;
	  
	  private PayStatus(long value,String name) {
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
	 * 配送方式
	 */
	public enum ShippingType{
	  /**
	   * 未知
	   */
	  UNKNOWN(191, "未知"),
	  /**
	   * 自提
	   */
	  SELFDELIVERY(192, "自提"),
	  /**
	   * 到店自提
	   */
	  SELFFROMSHOP(193, "到店自提"),
	  /**
	   * 平邮
	   */
	  REGULARMAIL(194, "平邮"),
	  /**
	   * 邮政特快
	   */
	  EMS(195, "邮政特快"),
	  /**
	   * 普通快递
	   */
	  GENERALDELIVERY(196, "普通快递"),
	  /**
	   * 限时到达
	   */
	  LIMITTOREACH(197, "限时到达");
  
	  private final long value;
	  private final String name;
	  
	  private ShippingType(long value,String name) {
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