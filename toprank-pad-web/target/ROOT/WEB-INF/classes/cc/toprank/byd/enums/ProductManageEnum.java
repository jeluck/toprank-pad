package cc.toprank.byd.enums;

/******************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的字典枚举类，不能手动修改。
 * 
 * ****************************************************************************************************/

public class ProductManageEnum {

	/**
	 * 
	 * 商品状态
	 */
	public enum ProductStatus{
	  /**
	   * 未知
	   */
	  UNKNOWN(432, "未知"),
	  /**
	   * 待审核
	   */
	  WAITINGAUDIT(433, "待审核"),
	  /**
	   * 待发布
	   */
	  WAITINGPUBLISH(434, "待发布"),
	  /**
	   * 正常
	   */
	  NORMAL(435, "正常"),
	  /**
	   * 库存低
	   */
	  LOWSTORE(436, "库存低"),
	  /**
	   * 库存过高
	   */
	  HIGHSTORE(437, "库存过高"),
	  /**
	   * 临近保质期
	   */
	  NEAREXPIRE(438, "临近保质期"),
	  /**
	   * 暂停销售
	   */
	  SUSPEND(439, "暂停销售"),
	  /**
	   * 已删除
	   */
	  DELETED(440, "已删除");
  
	  private final long value;
	  private final String name;
	  
	  private ProductStatus(long value,String name) {
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
	 * 品牌级别
	 */
	public enum BrandLevel{
	  /**
	   * 未知
	   */
	  UNKNOWN(76, "未知"),
	  /**
	   * 国际级
	   */
	  INTERNATIONAL(77, "国际级"),
	  /**
	   * 国家级
	   */
	  NATIONAL(78, "国家级"),
	  /**
	   * 省市级
	   */
	  PROVINCIAL(79, "省市级"),
	  /**
	   * 区县级
	   */
	  COUNTIES(80, "区县级");
  
	  private final long value;
	  private final String name;
	  
	  private BrandLevel(long value,String name) {
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
	 * 折价方式
	 */
	public enum DiscountWay{
	  /**
	   * 9折
	   */
	  TENPERCENTOFF(81, "9折"),
	  /**
	   * 8折
	   */
	  PERCENTDISCOUNT20(86, "8折"),
	  /**
	   * 半价
	   */
	  HALFOFF(87, "半价"),
	  /**
	   * 7折
	   */
	  DISCOUNT30(88, "7折");
  
	  private final long value;
	  private final String name;
	  
	  private DiscountWay(long value,String name) {
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
	 * 商品变体状态
	 */
	public enum VariantStatus{
	  /**
	   * 未知
	   */
	  UNKNOWN(82, "未知"),
	  /**
	   * 正常
	   */
	  NORMAL(83, "正常");
  
	  private final long value;
	  private final String name;
	  
	  private VariantStatus(long value,String name) {
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
	 * 折扣状态
	 */
	public enum DiscountStatus{
	  /**
	   * 未知
	   */
	  UNKNOWN(84, "未知"),
	  /**
	   * 正常
	   */
	  NORMAL(85, "正常");
  
	  private final long value;
	  private final String name;
	  
	  private DiscountStatus(long value,String name) {
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
	 * 商品管理
	 */
	public enum ProductCategoryManage{
	  /**
	   * 商户
	   */
	  MERCHANT(611, "商户"),
	  /**
	   * 商品
	   */
	  PRODUCT(612, "商品"),
	  /**
	   * 商品类别
	   */
	  PRODUCTTYPE(613, "商品类别"),
	  /**
	   * 商品变体
	   */
	  PRODICTVARIANTTYPE(623, "商品变体");
  
	  private final long value;
	  private final String name;
	  
	  private ProductCategoryManage(long value,String name) {
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
	 * 商品标签
	 */
	public enum LabelManage{
	  /**
	   * 未知
	   */
	  UNKNOWN(806, "未知");
  
	  private final long value;
	  private final String name;
	  
	  private LabelManage(long value,String name) {
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
	 * 商品分类图片管理
	 */
	public enum PhotoTypeManage{
	  /**
	   * 选中图片状态
	   */
	  SELECTPHOTOSTATUS(643, "选中图片状态"),
	  /**
	   * 未选中图片状态
	   */
	  NOTSELECTPHOTOSTATUS(644, "未选中图片状态"),
	  /**
	   * 商品分类
	   */
	  PRODUCTCATEGORY(645, "商品分类");
  
	  private final long value;
	  private final String name;
	  
	  private PhotoTypeManage(long value,String name) {
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
	 * 折扣类别
	 */
	public enum DiscountType{
	  /**
	   * 折扣
	   */
	  DISCOUNT(795, "折扣"),
	  /**
	   * 免单
	   */
	  FREESINGLE(796, "免单"),
	  /**
	   * 直减
	   */
	  STRAIGHTCUT(797, "直减"),
	  /**
	   * 抹零
	   */
	  ZERO(798, "抹零"),
	  /**
	   * 赠送
	   */
	  GIVE(931, "赠送"),
	  /**
	   * 免服务费
	   */
	  FREE_SERVICE(959, "免服务费"),
	  /**
	   * 活动折扣
	   */
	  ACTIVITYDISCOUNT(1009, "活动折扣"),
	  /**
	   * 会员折扣
	   */
	  MEMBERDISCOUNT(1010, "会员折扣"),
	  /**
	   * 单品折扣
	   */
	  DISCOUNTPERITEM(1011, "单品折扣"),
	  /**
	   * 全单折扣
	   */
	  FULLDISCOUNT(1143, "全单折扣"),
	  /**
	   * 权限折扣
	   */
	  PERMISSIONDISCOUNT(1144, "权限折扣"),
	  /**
	   * 优惠券折扣
	   */
	  COUPONDISCOUNT(1145, "优惠券折扣");
  
	  private final long value;
	  private final String name;
	  
	  private DiscountType(long value,String name) {
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
	 * 商品属性分类
	 */
	public enum AttributeType{
	  /**
	   * 做法
	   */
	  METHOD(820, "做法"),
	  /**
	   * 类别
	   */
	  CATEGORY(821, "类别"),
	  /**
	   * 口味
	   */
	  TASTE(822, "口味"),
	  /**
	   * 辣度
	   */
	  SPICY(993, "辣度");
  
	  private final long value;
	  private final String name;
	  
	  private AttributeType(long value,String name) {
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
	 * 菜单类型
	 */
	public enum MenuType{
	  /**
	   * 默认菜单
	   */
	  DEFAULTMENU(837, "默认菜单");
  
	  private final long value;
	  private final String name;
	  
	  private MenuType(long value,String name) {
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
	 * 价格方式
	 */
	public enum PriceType{
	  /**
	   * 总价
	   */
	  TOTALPRICE(841, "总价"),
	  /**
	   * 明细合计
	   */
	  DETAILTOTALPRICE(842, "明细合计");
  
	  private final long value;
	  private final String name;
	  
	  private PriceType(long value,String name) {
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
	 * 套餐分组类型
	 */
	public enum GroupType{
	  /**
	   * 固定
	   */
	  FIXED (843, "固定"),
	  /**
	   * 任选
	   */
	  OPTIONAL (844, "任选");
  
	  private final long value;
	  private final String name;
	  
	  private GroupType(long value,String name) {
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
	 * 菜单应用
	 */
	public enum MenuUse{
	  /**
	   * 水牌
	   */
	  LICENSE(847, "水牌"),
	  /**
	   * 服务员APP
	   */
	  WAITERAPP(848, "服务员APP");
  
	  private final long value;
	  private final String name;
	  
	  private MenuUse(long value,String name) {
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
	 * 商户标签
	 */
	public enum Merchant_Tag{
	  /**
	   * 菜品制作
	   */
	  DISH_MAKING(941, "菜品制作"),
	  /**
	   * 商户管理
	   */
	  MERCHANT_MANAGEMENT(942, "商户管理"),
	  /**
	   * 提供设备服务
	   */
	  DEVICE_SERVICES(980, "提供设备服务");
  
	  private final long value;
	  private final String name;
	  
	  private Merchant_Tag(long value,String name) {
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
	 * 辣度
	 */
	public enum Spicy{
	  /**
	   * 无
	   */
	  NONE(1076, "无"),
	  /**
	   * 微辣
	   */
	  LITTLESPICY(1077, "微辣"),
	  /**
	   * 中辣
	   */
	  MEDIUMSPICY(1078, "中辣"),
	  /**
	   * 特辣
	   */
	  VERYSPICY(1079, "特辣");
  
	  private final long value;
	  private final String name;
	  
	  private Spicy(long value,String name) {
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