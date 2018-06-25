package cc.toprank.byd.enums;

/******************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的字典枚举类，不能手动修改。
 * 
 * ****************************************************************************************************/

public class OrderManagerEnum {

	/**
	 * 
	 * 订单点菜方式
	 */
	public enum OrderMode{
	  /**
	   * 正常点菜
	   */
	  NORMALORDERPRODUCT(684L, "正常点菜"),
	  /**
	   * 退菜
	   */
	  RETURNPRODUCT(685L, "退菜"),
	  /**
	   * 赠菜
	   */
	  GIVEPRODUCT(686L, "赠菜"),
	  /**
	   * 加菜
	   */
	  ADDPRODUCT(687L, "加菜"),
	  /**
	   * 转菜
	   */
	  TURNPRODUCT(996L, "转菜"),
	  /**
	   * 换菜
	   */
	  CHANGEPRODUCT(997L, "换菜"),
	  /**
	   * 转赠
	   */
	  TURNGIVE(998L, "转赠");
  
	  private final Long value;
	  private final String name;
	  
	  private OrderMode(Long value,String name) {
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
	
	/**
	 * 
	 * 制作状态
	 */
	public enum ProductionStatus{
	  /**
	   * 未制作
	   */
	  UNINPRODUCTION(692L, "未制作"),
	  /**
	   * 制作中
	   */
	  INPRODUCTION(693L, "制作中"),
	  /**
	   * 等叫
	   */
	  SOCALLED(694L, "等叫"),
	  /**
	   * 超时
	   */
	  OVERTIME(698L, "超时"),
	  /**
	   * 未称重
	   */
	  PENDINGWEIGH(830L, "未称重"),
	  /**
	   * 已出品
	   */
	  ALREADYPRODUCED(981L, "已出品"),
	  /**
	   * 已上菜
	   */
	  SERVINGALREADY(982L, "已上菜");
  
	  private final Long value;
	  private final String name;
	  
	  private ProductionStatus(Long value,String name) {
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
	
	/**
	 * 
	 * 选择厨师的方式
	 */
	public enum SelectedDesigner{
	  /**
	   * 客户指定
	   */
	  CUSTOMER_SPECIFIED(824L, "客户指定"),
	  /**
	   * 系统分配
	   */
	  SYSTEM_ALLOCATED(825L, "系统分配"),
	  /**
	   * 后厨调配
	   */
	  KITCHEN_DEPLOYMENT(826L, "后厨调配");
  
	  private final Long value;
	  private final String name;
	  
	  private SelectedDesigner(Long value,String name) {
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
	
	/**
	 * 
	 * 重量单位
	 */
	public enum WeighUnit{
	  /**
	   * 斤
	   */
	  G(831L, "斤"),
	  /**
	   * 两
	   */
	  TAEL(832L, "两"),
	  /**
	   * 千克
	   */
	  KG(833L, "千克");
  
	  private final Long value;
	  private final String name;
	  
	  private WeighUnit(Long value,String name) {
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
	
	/**
	 * 
	 * 档口称重处理类型
	 */
	public enum DealType{
	  /**
	   * 变价格
	   */
	  CHANGEPRICE(834L, "变价格"),
	  /**
	   * 变重量
	   */
	  CHANGEWEIGH(835L, "变重量"),
	  /**
	   * 变商品
	   */
	  CHANGEPRODUCT(836L, "变商品"),
	  /**
	   * 变状态
	   */
	  CHANGESTATUS(899L, "变状态"),
	  /**
	   * 变厨师
	   */
	  CHANGECOOK(977L, "变厨师"),
	  /**
	   * 变等级
	   */
	  CHANGELEVEL(1097L, "变等级");
  
	  private final Long value;
	  private final String name;
	  
	  private DealType(Long value,String name) {
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
	
	/**
	 * 
	 * 称重状态
	 */
	public enum WeighingStatus{
	  /**
	   * 待称重
	   */
	  PENDINGWEIGHING(984L, "待称重"),
	  /**
	   * 已称重
	   */
	  BEWEIGHING(985L, "已称重"),
	  /**
	   * 待确认
	   */
	  WAITINGCONFIRM(986L, "待确认");
  
	  private final Long value;
	  private final String name;
	  
	  private WeighingStatus(Long value,String name) {
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
	
	/**
	 * 
	 * 退款状态
	 */
	public enum RefundStatus{
	  /**
	   * 退款成功
	   */
	  REFUNDSUCCESS(987L, "退款成功"),
	  /**
	   * 退款失败
	   */
	  REFUNDFAIL(988L, "退款失败"),
	  /**
	   * 异常
	   */
	  ABNORMAL(989L, "异常");
  
	  private final Long value;
	  private final String name;
	  
	  private RefundStatus(Long value,String name) {
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
	
	/**
	 * 
	 * 发票订单来源
	 */
	public enum OrderSource{
	  /**
	   * 订单
	   */
	  ORDER(1080L, "订单"),
	  /**
	   * 充值
	   */
	  RECHARGE(1081L, "充值"),
	  /**
	   * 订金
	   */
	  DEPOSIT(1082L, "订金");
  
	  private final Long value;
	  private final String name;
	  
	  private OrderSource(Long value,String name) {
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