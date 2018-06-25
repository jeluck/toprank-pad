package cc.toprank.byd.enums;

/******************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的字典枚举类，不能手动修改。
 * 
 * ****************************************************************************************************/

public class MerchantManageEnum {

	/**
	 * 
	 * 订金收取方式
	 */
	public enum ReservationType{
	  /**
	   * 未知
	   */
	  UNKNOWN(517, "未知"),
	  /**
	   * 按人收取
	   */
	  BYPERSON(518, "按人收取"),
	  /**
	   * 按桌收取
	   */
	  BYTABLE(519, "按桌收取"),
	  /**
	   * 按单收取
	   */
	  BYORDER(520, "按单收取");
  
	  private final long value;
	  private final String name;
	  
	  private ReservationType(long value,String name) {
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
	 * 服务费收取方式
	 */
	public enum ServiceFeeType{
	  /**
	   * 固定金额
	   */
	  FIXAMOUNT(522, "固定金额"),
	  /**
	   * 固定比例
	   */
	  FIXRATE(523, "固定比例");
  
	  private final long value;
	  private final String name;
	  
	  private ServiceFeeType(long value,String name) {
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
	 * 商户状态
	 */
	public enum MerchantStatus{
	  /**
	   * 未知
	   */
	  UNKNOWN(530, "未知"),
	  /**
	   * 待提交资料
	   */
	  WAITSUBMIT(531, "待提交资料"),
	  /**
	   * 待审核
	   */
	  WAITAUDIT(532, "待审核"),
	  /**
	   * 待补充资料
	   */
	  WAITSUPPLEMENTARY(533, "待补充资料"),
	  /**
	   * 待审批
	   */
	  WAITAPPROVAL(534, "待审批"),
	  /**
	   * 待发布
	   */
	  WAIPUBLISH(535, "待发布"),
	  /**
	   * 已拒绝
	   */
	  REJECTED(536, "已拒绝"),
	  /**
	   * 已暂停
	   */
	  SUSPEND(537, "已暂停"),
	  /**
	   * 正常
	   */
	  NORMAL(538, "正常"),
	  /**
	   * 待交预付金
	   */
	  DEPOSIT_PAYABLE(922, "待交预付金"),
	  /**
	   * 取消审核
	   */
	  CANCELAUDIT(926, "取消审核");
  
	  private final long value;
	  private final String name;
	  
	  private MerchantStatus(long value,String name) {
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
	 * 商户级别
	 */
	public enum MerchantLevel{
	  /**
	   * 普通餐厅
	   */
	  NORMAL(577, "普通餐厅"),
	  /**
	   * 会员餐厅
	   */
	  MERMBER(578, "会员餐厅"),
	  /**
	   * 智慧餐厅
	   */
	  INTELLIGENT(579, "智慧餐厅");
  
	  private final long value;
	  private final String name;
	  
	  private MerchantLevel(long value,String name) {
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
	 * 票据状态
	 */
	public enum TicketStatus{
	  /**
	   * 已暂停
	   */
	  SUSPEND(591, "已暂停"),
	  /**
	   * 已删除
	   */
	  DELETED(592, "已删除"),
	  /**
	   * 已作废
	   */
	  CANCELED(593, "已作废"),
	  /**
	   * 正常
	   */
	  NORMAL(594, "正常"),
	  /**
	   * 未知
	   */
	  UNKNOWN(603, "未知"),
	  /**
	   * 已过期
	   */
	  EXPIRED(604, "已过期");
  
	  private final long value;
	  private final String name;
	  
	  private TicketStatus(long value,String name) {
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
	 * 餐饮状态
	 */
	public enum MealStatus{
	  /**
	   * 未知
	   */
	  UNKNOWN(595, "未知"),
	  /**
	   * 可预定
	   */
	  PREDETERMINE(596, "可预定");
  
	  private final long value;
	  private final String name;
	  
	  private MealStatus(long value,String name) {
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
	 * 打印状态
	 */
	public enum PrintStatus{
	  /**
	   * 未知
	   */
	  UNKNOWN(584, "未知"),
	  /**
	   * 打印中
	   */
	  PRINTING(585, "打印中"),
	  /**
	   * 已打印
	   */
	  PRINTED(586, "已打印"),
	  /**
	   * 已重打
	   */
	  REPRINTED(587, "已重打"),
	  /**
	   * 备用打印机打印
	   */
	  VICEPRINTERPRINT(588, "备用打印机打印"),
	  /**
	   * 数据传输中
	   */
	  DATATRANSFER(589, "数据传输中"),
	  /**
	   * 已过期
	   */
	  EXPIRED(590, "已过期");
  
	  private final long value;
	  private final String name;
	  
	  private PrintStatus(long value,String name) {
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
	 * 桌台状态
	 */
	public enum TableStatus{
	  /**
	   * 未知
	   */
	  UNKNOWN(605, "未知"),
	  /**
	   * 预定
	   */
	  PREDETERMINE(606, "预定"),
	  /**
	   * 空台
	   */
	  EMPTYTABLE(607, "空台"),
	  /**
	   * 脏台
	   */
	  DIRTYTABLE(609, "脏台"),
	  /**
	   * 维护
	   */
	  MAINTAIN(610, "维护"),
	  /**
	   * 服务中
	   */
	  PLACEMAN (652, "服务中"),
	  /**
	   * 暂结
	   */
	  STOPTABLE(728, "暂结"),
	  /**
	   * 锁定
	   */
	  LOCK(777, "锁定"),
	  /**
	   * 已删除
	   */
	  DELETED(780, "已删除"),
	  /**
	   * 开台
	   */
	  PLACEORDER(827, "开台");
  
	  private final long value;
	  private final String name;
	  
	  private TableStatus(long value,String name) {
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
	 * 预订状态
	 */
	public enum ReservaManage{
	  /**
	   * 未知
	   */
	  UNKNOWN(617, "未知"),
	  /**
	   * 成功
	   */
	  SUCCESS(618, "成功"),
	  /**
	   * 失败
	   */
	  FAIL(619, "失败"),
	  /**
	   * 已过期
	   */
	  EXPIRED(620, "已过期"),
	  /**
	   * 已删除
	   */
	  DELETED(621, "已删除"),
	  /**
	   * 已改期
	   */
	  OTHERDATE(622, "已改期"),
	  /**
	   * 已取消
	   */
	  CANCELED(729, "已取消"),
	  /**
	   * 预定完成
	   */
	  FINISH(759, "预定完成"),
	  /**
	   * 排队
	   */
	  LINE(762, "排队"),
	  /**
	   * 进行中
	   */
	  HAVEINHAND(1002, "进行中"),
	  /**
	   * 待支付
	   */
	  PENDINGPAYMENT(1012, "待支付");
  
	  private final long value;
	  private final String name;
	  
	  private ReservaManage(long value,String name) {
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
	 * 下单渠道
	 */
	public enum OrderChannel{
	  /**
	   * 未知
	   */
	  UNKNOWN(627, "未知"),
	  /**
	   * 客户APP
	   */
	  CUSTOMERAPP(628, "客户APP"),
	  /**
	   * 服务员APP
	   */
	  WAITERAPP(629, "服务员APP"),
	  /**
	   * 水牌
	   */
	  LICENSE(630, "水牌"),
	  /**
	   * 收银机
	   */
	  CASHREGISTER(631, "收银机"),
	  /**
	   * Web
	   */
	  WEB(632, "Web"),
	  /**
	   * WinClient
	   */
	  WINCLIENT(633, "WinClient");
  
	  private final long value;
	  private final String name;
	  
	  private OrderChannel(long value,String name) {
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
	 * 预订来源
	 */
	public enum BookingChannel{
	  /**
	   * 未知
	   */
	  UNKNOWN(736, "未知"),
	  /**
	   * 电话
	   */
	  PHONE(737, "电话"),
	  /**
	   * 不用等App
	   */
	  BYDAPP(738, "不用等App"),
	  /**
	   * 收银机
	   */
	  CASHREGISTER(739, "收银机");
  
	  private final long value;
	  private final String name;
	  
	  private BookingChannel(long value,String name) {
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
	 * 网络状态
	 */
	public enum NetWorkType{
	  /**
	   * 10M
	   */
	  TEN_M(637, "10M"),
	  /**
	   * 10M wifi
	   */
	  TEN_MWIFI(638, "10M wifi");
  
	  private final long value;
	  private final String name;
	  
	  private NetWorkType(long value,String name) {
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
	 * 菜品单位
	 */
	public enum ProductUnit{
	  /**
	   * 未知
	   */
	  未知(639, "未知"),
	  /**
	   * 份
	   */
	  份(640, "份"),
	  /**
	   * 半份
	   */
	  半份(641, "半份"),
	  /**
	   * 公斤
	   */
	  公斤(642, "公斤"),
	  /**
	   * 克
	   */
	  克(923, "克");
  
	  private final long value;
	  private final String name;
	  
	  private ProductUnit(long value,String name) {
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
	 * 服务响应状态
	 */
	public enum ServiceResponse{
	  /**
	   * 处理中
	   */
	  PROCESSING(675, "处理中"),
	  /**
	   * 未处理
	   */
	  UNTREATED(676, "未处理"),
	  /**
	   * 已处理
	   */
	  PROCESSED(677, "已处理");
  
	  private final long value;
	  private final String name;
	  
	  private ServiceResponse(long value,String name) {
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
	 * 桌台使用方式
	 */
	public enum UseWay{
	  /**
	   * 未知
	   */
	  UNKNOWN(679, "未知"),
	  /**
	   * 预订
	   */
	  BOOKING(680, "预订"),
	  /**
	   * 水牌
	   */
	  LICENSE(681, "水牌"),
	  /**
	   * 扫码
	   */
	  SCANCODE(682, "扫码"),
	  /**
	   * 服务员
	   */
	  WAITER(683, "服务员");
  
	  private final long value;
	  private final String name;
	  
	  private UseWay(long value,String name) {
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
	 * 抹零方式
	 */
	public enum DroptailMethod{
	  /**
	   * 不抹零
	   */
	  UNDROP(745, "不抹零"),
	  /**
	   * 四舍五入到角
	   */
	  ROUNDINGJIAO(746, "四舍五入到角"),
	  /**
	   * 进位到角
	   */
	  UPJIAO(747, "进位到角"),
	  /**
	   * 进位到元
	   */
	  UPYUAN(748, "进位到元"),
	  /**
	   * 进位到十元
	   */
	  UPTENTH(749, "进位到十元"),
	  /**
	   * 四舍五入到元
	   */
	  ROUNDINGYUAN(1033, "四舍五入到元"),
	  /**
	   * 四舍五入到十元
	   */
	  ROUNDINGTENTH(1034, "四舍五入到十元"),
	  /**
	   * 舍位到元
	   */
	  REMOVEYUAN(1035, "舍位到元"),
	  /**
	   * 舍位到十元
	   */
	  REMOVETENTH(1036, "舍位到十元"),
	  /**
	   * 舍位到百元
	   */
	  REMOVEHUNDRED(1037, "舍位到百元");
  
	  private final long value;
	  private final String name;
	  
	  private DroptailMethod(long value,String name) {
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
	 * 预订方式
	 */
	public enum BookingType{
	  /**
	   * 全额付款
	   */
	  FULLPAYMENT(614, "全额付款"),
	  /**
	   * 留位金
	   */
	  RESERVEDSEAT(615, "留位金"),
	  /**
	   * 普通预订
	   */
	  NORMAL(616, "普通预订"),
	  /**
	   * 未知
	   */
	  UNKNOWN(750, "未知");
  
	  private final long value;
	  private final String name;
	  
	  private BookingType(long value,String name) {
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
	 * 沽清类型
	 */
	public enum GuqingType{
	  /**
	   * 不沽清
	   */
	  NOTGUQING(771, "不沽清"),
	  /**
	   * 手动沽清
	   */
	  MANUALGUQING(772, "手动沽清"),
	  /**
	   * 数量沽清
	   */
	  NUMBERGUQING(773, "数量沽清"),
	  /**
	   * 当日沽清
	   */
	  SAMEDAYGUQING(774, "当日沽清");
  
	  private final long value;
	  private final String name;
	  
	  private GuqingType(long value,String name) {
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
	 * 模板类别
	 */
	public enum TemplateType{
	  /**
	   * 适用大型
	   */
	  LARGE(807, "适用大型"),
	  /**
	   * 适用中型
	   */
	  MEDIUMSIZED (808, "适用中型"),
	  /**
	   * 适用小型
	   */
	  SMALLSCALE(809, "适用小型");
  
	  private final long value;
	  private final String name;
	  
	  private TemplateType(long value,String name) {
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
	 * 日期方式
	 */
	public enum DayType{
	  /**
	   * 周
	   */
	  WEEK(810, "周"),
	  /**
	   * 月
	   */
	  MONTH(811, "月"),
	  /**
	   * 年
	   */
	  YEAR(812, "年"),
	  /**
	   * 指定日期
	   */
	  DATETIME(813, "指定日期");
  
	  private final long value;
	  private final String name;
	  
	  private DayType(long value,String name) {
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
	 * 区域类型
	 */
	public enum AreaType{
	  /**
	   * 大厅
	   */
	  HALL(849, "大厅"),
	  /**
	   * 包厢
	   */
	  BOX(850, "包厢");
  
	  private final long value;
	  private final String name;
	  
	  private AreaType(long value,String name) {
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
	 * 称重方式
	 */
	public enum WeighingMethod{
	  /**
	   * 电子称重
	   */
	  ELECTRONICWEIGHING(860, "电子称重"),
	  /**
	   * 手工称重
	   */
	  MANUALWEIGHING(861, "手工称重");
  
	  private final long value;
	  private final String name;
	  
	  private WeighingMethod(long value,String name) {
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
	 * 电子秤端口
	 */
	public enum Port{
	  /**
	   * COM1
	   */
	  COM1(862, "COM1"),
	  /**
	   * COM2
	   */
	  COM2(863, "COM2");
  
	  private final long value;
	  private final String name;
	  
	  private Port(long value,String name) {
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
	 * 票据类型
	 */
	public enum BillType{
	  /**
	   * 总单
	   */
	  GENERALSINGLE(873, "总单"),
	  /**
	   * 小单
	   */
	  XIAOCHAN(874, "小单");
  
	  private final long value;
	  private final String name;
	  
	  private BillType(long value,String name) {
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
	 * 打印机类型
	 */
	public enum PrinterType{
	  /**
	   * 热敏
	   */
	  SENSITIVE(879, "热敏"),
	  /**
	   * 针打
	   */
	  THENEEDLE(880, "针打"),
	  /**
	   * 喷墨
	   */
	  JET(881, "喷墨");
  
	  private final long value;
	  private final String name;
	  
	  private PrinterType(long value,String name) {
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
	 * 审批结果类型
	 */
	public enum AuditResultType{
	  /**
	   * 通过
	   */
	  PASS(900, "通过"),
	  /**
	   * 不通过
	   */
	  NOPASS(901, "不通过");
  
	  private final long value;
	  private final String name;
	  
	  private AuditResultType(long value,String name) {
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
	 * 优惠类型
	 */
	public enum SpecialType{
	  /**
	   * 折扣
	   */
	  DISCOUNTS(904, "折扣"),
	  /**
	   * 返利
	   */
	  REBATE(905, "返利"),
	  /**
	   * 抽奖
	   */
	  LUCKDRAW(906, "抽奖");
  
	  private final long value;
	  private final String name;
	  
	  private SpecialType(long value,String name) {
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
	 * 服务功能
	 */
	public enum ServiceFunction{
	  /**
	   * 预订
	   */
	  BOOK(911, "预订"),
	  /**
	   * 排队
	   */
	  LINEUP(912, "排队"),
	  /**
	   * 外卖
	   */
	  TAKE_OUT_FOOD(913, "外卖"),
	  /**
	   * 点餐
	   */
	  ORDER(914, "点餐");
  
	  private final long value;
	  private final String name;
	  
	  private ServiceFunction(long value,String name) {
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
	 * 商家星级
	 */
	public enum BusinessLevel{
	  /**
	   * 一星级
	   */
	  ONE_STAR(915, "一星级"),
	  /**
	   * 二星级
	   */
	  TWO_STAR(916, "二星级"),
	  /**
	   * 三星级
	   */
	  THREE_STAR(917, "三星级"),
	  /**
	   * 四星级
	   */
	  FOUR_STAR(918, "四星级"),
	  /**
	   * 五星级
	   */
	  FIVE_STAR(919, "五星级");
  
	  private final long value;
	  private final String name;
	  
	  private BusinessLevel(long value,String name) {
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
	 * 周营业日
	 */
	public enum Business_Week{
	  /**
	   * 周一
	   */
	  MONDAY(952l, "周一"),
	  /**
	   * 周二
	   */
	  TUESDAY(953, "周二"),
	  /**
	   * 周三
	   */
	  WEDNESDAY(954, "周三"),
	  /**
	   * 周四
	   */
	  THURSDAY(955, "周四"),
	  /**
	   * 周五
	   */
	  FRIDAY(956, "周五"),
	  /**
	   * 周六
	   */
	  SATURDAY(957, "周六"),
	  /**
	   * 周日
	   */
	  SUNDAY(958, "周日");
  
	  private final long value;
	  private final String name;
	  
	  private Business_Week(long value,String name) {
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
	 * 服务费收取模式
	 */
	public enum FeeMode{
	  /**
	   * 按人
	   */
	  BYPERSON(962, "按人"),
	  /**
	   * 按桌
	   */
	  BYTABLE(963, "按桌"),
	  /**
	   * 按单
	   */
	  BYORDER(964, "按单"),
	  /**
	   * 按菜品
	   */
	  BYPRODUCT(1008, "按菜品");
  
	  private final long value;
	  private final String name;
	  
	  private FeeMode(long value,String name) {
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
	 * 时间依据
	 */
	public enum TimeBasis{
	  /**
	   * 开单时间
	   */
	  BILLINGTIME(1006, "开单时间"),
	  /**
	   * 当前时间
	   */
	  CURRENTTIME(1007, "当前时间");
  
	  private final long value;
	  private final String name;
	  
	  private TimeBasis(long value,String name) {
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
	 * 估清变动类型
	 */
	public enum CurbSaleChangeType{
		/**
		 * 增加沽清记录
		 */
		ADDRECORD(1088L, "增加沽清记录"),
		/**
		 * 修改沽清记录
		 */
		MODIFYRECORD(1089L, "修改沽清记录"),
		/**
		 * 删除沽清记录
		 */
		DELETERECORD(1090L, "删除沽清记录"),
		/**
		 * 增加沽清数量
		 */
		ADDCOUNT(1091L, "增加沽清数量"),
		/**
		 * 减少沽清数量
		 */
		REMOVECOUNT(1092L, "减少沽清数量"),
		/**
		 * 制作报损
		 */
		MAKINGNEWSPAPERLOSS(1093L, "制作报损"),
		/**
		 * 手动沽清
		 */
		MANUALSELLING(1094L, "手动沽清"),
		/**
		 * 退菜报损
		 */
		LOSSOFRETURNINGFOOD(1095L, "退菜报损");

		private final Long value;
		private final String name;

		private CurbSaleChangeType(Long value,String name) {
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