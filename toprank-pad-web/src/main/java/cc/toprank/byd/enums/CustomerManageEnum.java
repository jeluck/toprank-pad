package cc.toprank.byd.enums;

/******************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的字典枚举类，不能手动修改。
 * 
 * ****************************************************************************************************/

public class CustomerManageEnum {

	/**
	 * 
	 * 客户类别
	 */
	public enum CustomerType{
	  /**
	   * 未知
	   */
	  UNKNOWN(321, "未知"),
	  /**
	   * 食客
	   */
	  DINER(322, "食客"),
	  /**
	   * 贵人
	   */
	  REFERENCE(323, "贵人"),
	  /**
	   * 消费商
	   */
	  CONSUMERBUSINESS(324, "消费商"),
	  /**
	   * 联名商户
	   */
	  JOINTMERCHANT(325, "联名商户"),
	  /**
	   * 商户
	   */
	  MERCHANT(655, "商户"),
	  /**
	   * 平台
	   */
	  PLATFORM(656, "平台"),
	  /**
	   * 会员卡
	   */
	  MEMBERSHIPCARD(932, "会员卡");
  
	  private final long value;
	  private final String name;
	  
	  private CustomerType(long value,String name) {
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
	 * 客户状态
	 */
	public enum CustomerStatus{
	  /**
	   * 未知
	   */
	  UNKNOWN(326, "未知"),
	  /**
	   * 待审核
	   */
	  WAITINGAUDIT(327, "待审核"),
	  /**
	   * 正常
	   */
	  NORMAL(328, "正常"),
	  /**
	   * 已锁定
	   */
	  LOCKED(329, "已锁定"),
	  /**
	   * 已过期
	   */
	  EXPIRED(330, "已过期");
  
	  private final long value;
	  private final String name;
	  
	  private CustomerStatus(long value,String name) {
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
	 * 签到金状态
	 */
	public enum RegistrationMoneyStatus{
	  /**
	   * 未知
	   */
	  UNKNOWN(466, "未知"),
	  /**
	   * 未达标
	   */
	  UNREACH(467, "未达标"),
	  /**
	   * 可领取
	   */
	  CANDRAW(468, "可领取"),
	  /**
	   * 已领取
	   */
	  HASDRAW(469, "已领取");
  
	  private final long value;
	  private final String name;
	  
	  private RegistrationMoneyStatus(long value,String name) {
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
	 * 婚姻状态
	 */
	public enum MarriageStatus{
	  /**
	   * 未婚
	   */
	  UNMARRIED(486, "未婚"),
	  /**
	   * 离异
	   */
	  DIVORCE(487, "离异"),
	  /**
	   * 已婚
	   */
	  MARRIED(488, "已婚"),
	  /**
	   * 丧偶
	   */
	  
WIDOWED(489, "丧偶");
  
	  private final long value;
	  private final String name;
	  
	  private MarriageStatus(long value,String name) {
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
	 * 文化程度
	 */
	public enum DegreeOfEducation{
	  /**
	   * 小学
	   */
	  PRIMARYSCHOOL(490, "小学"),
	  /**
	   * 中学
	   */
	  MIDDLESCHOOL(491, "中学"),
	  /**
	   * 大专
	   */
	  JUNIORCOLLEGE(492, "大专"),
	  /**
	   * 大学
	   */
	  UNIVERSITY(493, "大学"),
	  /**
	   * 研究生
	   */
	  GRADUATESTUDENT(494, "研究生");
  
	  private final long value;
	  private final String name;
	  
	  private DegreeOfEducation(long value,String name) {
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
	 * 居住地
	 */
	public enum Residence{
	  /**
	   * 城市
	   */
	  CITY(495, "城市"),
	  /**
	   * 乡镇
	   */
	  TOWNSHIP(496, "乡镇"),
	  /**
	   * 乡村
	   */
	  VILLAGE(497, "乡村"),
	  /**
	   * 未知
	   */
	  UNKNOWN(528, "未知");
  
	  private final long value;
	  private final String name;
	  
	  private Residence(long value,String name) {
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
	 * 经济收入
	 */
	public enum EconomicIncome{
	  /**
	   * 高
	   */
	  HIGH(498, "高"),
	  /**
	   * 中
	   */
	  MEDIUM (499, "中"),
	  /**
	   * 低
	   */
	  LOW(500, "低");
  
	  private final long value;
	  private final String name;
	  
	  private EconomicIncome(long value,String name) {
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
	 * 地区
	 */
	public enum Region{
	  /**
	   * 亚太
	   */
	  ASIAPACIFIC(501, "亚太"),
	  /**
	   * 亚美
	   */
	  AMERICA(502, "亚美"),
	  /**
	   * 大中华
	   */
	  CHINA(503, "大中华"),
	  /**
	   * 澳洲
	   */
	  AUSTRALIA(504, "澳洲");
  
	  private final long value;
	  private final String name;
	  
	  private Region(long value,String name) {
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
	 * 卡级别
	 */
	public enum CardLevel{
	  /**
	   * 钻石卡
	   */
	  DIAMONDCARD(709, "钻石卡"),
	  /**
	   * 白金卡
	   */
	  PLATINUMCARD(710, "白金卡"),
	  /**
	   * 金卡
	   */
	  GOLDCARD(711, "金卡"),
	  /**
	   * 银卡
	   */
	  SILVERCARD(712, "银卡"),
	  /**
	   * 普卡
	   */
	  PUKA(726, "普卡"),
	  /**
	   * 储蓄卡
	   */
	  CREDIT(727, "储蓄卡");
  
	  private final long value;
	  private final String name;
	  
	  private CardLevel(long value,String name) {
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
	 * 卡类别
	 */
	public enum CardType{
	  /**
	   * 未知
	   */
	  UNKNOWN(713, "未知"),
	  /**
	   * 磁条卡
	   */
	  MAGNETICCARD(714, "磁条卡"),
	  /**
	   * 芯片卡
	   */
	  CHIPCARD(715, "芯片卡"),
	  /**
	   * 充值卡
	   */
	  RECHARGEABLECARD(716, "充值卡"),
	  /**
	   * IC卡
	   */
	  ICCARD(717, "IC卡"),
	  /**
	   * 挂账卡
	   */
	  LEDGER(761, "挂账卡");
  
	  private final long value;
	  private final String name;
	  
	  private CardType(long value,String name) {
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
	 * 卡状态
	 */
	public enum CardStatus{
	  /**
	   * 未知
	   */
	  UNKNOWN(718, "未知"),
	  /**
	   * 初始化
	   */
	  INITIALIZATION(719, "初始化"),
	  /**
	   * 预售
	   */
	  ADVANCE(720, "预售"),
	  /**
	   * 正常
	   */
	  NORMAL(721, "正常"),
	  /**
	   * 停用
	   */
	  DISABLE(722, "停用"),
	  /**
	   * 过期
	   */
	  EXPIRED(723, "过期"),
	  /**
	   * 冻结
	   */
	  FROZEN(724, "冻结"),
	  /**
	   * 锁定
	   */
	  LOCKING(725, "锁定"),
	  /**
	   * 未认证
	   */
	  NOTCERTIFIED(730, "未认证");
  
	  private final long value;
	  private final String name;
	  
	  private CardStatus(long value,String name) {
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
	 * 会员卡类别
	 */
	public enum MembershipCardType{
	  /**
	   * 电子卡
	   */
	  ELECTRONICCARD(864, "电子卡"),
	  /**
	   * 实物卡
	   */
	  PHYSICALCARD(865, "实物卡");
  
	  private final long value;
	  private final String name;
	  
	  private MembershipCardType(long value,String name) {
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
	 * 会员来源
	 */
	public enum MemberSources{
	  /**
	   * 商家录入
	   */
	  MERCHANTENTRY(877, "商家录入"),
	  /**
	   * 食客注册
	   */
	  CUSTOMERREGISTRATION(878, "食客注册");
  
	  private final long value;
	  private final String name;
	  
	  private MemberSources(long value,String name) {
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