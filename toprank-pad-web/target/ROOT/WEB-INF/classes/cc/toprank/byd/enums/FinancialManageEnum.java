package cc.toprank.byd.enums;

/******************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的字典枚举类，不能手动修改。
 * 
 * ****************************************************************************************************/

public class FinancialManageEnum {

	/**
	 * 
	 * 账户类别
	 */
	public enum AccountType{
	  /**
	   * 未知
	   */
	  UNKNOWN(124L, "未知"),
	  /**
	   * 真实账户
	   */
	  REALACCOUNT(125L, "真实账户"),
	  /**
	   * 辅助账户
	   */
	  VICEACCOUNT(126L, "辅助账户"),
	  /**
	   * 虚拟账户
	   */
	  VIRTUALACCOUNT(127L, "虚拟账户"),
	  /**
	   * 银行账户
	   */
	  BANKACCOUNT(128L, "银行账户"),
	  /**
	   * 商城会员卡账户
	   */
	  MALLCARDACCOUNT(181L, "商城会员卡账户"),
	  /**
	   * 联名账户
	   */
	  COBRANDEDCARDACCOUNT(182L, "联名账户"),
	  /**
	   * 赠送不限时账户
	   */
	  PRESENTEDUNLIMITEDACCOUNT(527L, "赠送不限时账户"),
	  /**
	   * 现金账户
	   */
	  CASHACCOUNT(691L, "现金账户"),
	  /**
	   * 会员账户
	   */
	  MEMBERACCOUNT(700L, "会员账户"),
	  /**
	   * 充值赠送账户
	   */
	  DEPOSITPRESENTACCOUNT(703L, "充值赠送账户"),
	  /**
	   * 挂账账户
	   */
	  LEDGERACCOUNT(763L, "挂账账户"),
	  /**
	   * 微信账户
	   */
	  WECHATACCOUNT(768L, "微信账户"),
	  /**
	   * 支付宝账户
	   */
	  ALIPAYACCOUNT(769L, "支付宝账户");
  
	  private final Long value;
	  private final String name;
	  
	  private AccountType(Long value,String name) {
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
	 * 资金变动方式
	 */
	public enum FundChangeType{
	  /**
	   * 未知
	   */
	  UNKNOWN(133L, "未知"),
	  /**
	   * 增加
	   */
	  ADD(134L, "增加"),
	  /**
	   * 减少
	   */
	  REDUCE(135L, "减少"),
	  /**
	   * 冻结
	   */
	  FREEZE(136L, "冻结"),
	  /**
	   * 解冻
	   */
	  UNFREEZE(137L, "解冻");
  
	  private final Long value;
	  private final String name;
	  
	  private FundChangeType(Long value,String name) {
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
	 * 资金变动业务类别
	 */
	public enum FundChangeBusinessType{
	  /**
	   * 未知
	   */
	  UNKNOWN(158L, "未知"),
	  /**
	   * 预订
	   */
	  BOOKING(159L, "预订"),
	  /**
	   * 充值
	   */
	  RECHARGE(160L, "充值"),
	  /**
	   * 取款
	   */
	  WITHDRAW(161L, "取款"),
	  /**
	   * 红包
	   */
	  REDENVELOPE(183L, "红包"),
	  /**
	   * 积分兑换
	   */
	  REDEEM(184L, "积分兑换"),
	  /**
	   * 服务
	   */
	  SERVICE(185L, "服务"),
	  /**
	   * 财务结算
	   */
	  FINANCIALSETTLEMENT(186L, "财务结算"),
	  /**
	   * 返利
	   */
	  REBATE(243L, "返利"),
	  /**
	   * 就餐结算
	   */
	  CHECKOUT(381L, "就餐结算"),
	  /**
	   * 佣金
	   */
	  COMMISSION(559L, "佣金"),
	  /**
	   * 订单
	   */
	  ORDER(635L, "订单"),
	  /**
	   * 子订单
	   */
	  SUBORDERINFO(673L, "子订单"),
	  /**
	   * 充值赠送
	   */
	  DEPOSITPRESENT(702L, "充值赠送");
  
	  private final Long value;
	  private final String name;
	  
	  private FundChangeBusinessType(Long value,String name) {
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
	 * 结算类别
	 */
	public enum SettlementType{
	  /**
	   * 未知
	   */
	  UNKOWN(275L, "未知"),
	  /**
	   * 推荐码结算
	   */
	  REFERRALCODESETTLEMENT(276L, "推荐码结算"),
	  /**
	   * 合作分成结算
	   */
	  COOPERATIVESETTLEMENT(277L, "合作分成结算"),
	  /**
	   * 代理商结算
	   */
	  AGENTSETTLEMENT(278L, "代理商结算"),
	  /**
	   * 商户结算
	   */
	  MERCHANTSETTLEMENT(279L, "商户结算"),
	  /**
	   * 联名商户结算
	   */
	  JOINTMERCHANTSETTLEMENT(280L, "联名商户结算"),
	  /**
	   * 基金结算
	   */
	  FOUNDATIONSETTLEMENT(560L, "基金结算");
  
	  private final Long value;
	  private final String name;
	  
	  private SettlementType(Long value,String name) {
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
	 * 结算状态
	 */
	public enum SettlementStatus{
	  /**
	   * 未知
	   */
	  UNKNOWN(304L, "未知"),
	  /**
	   * 结算单已生成
	   */
	  SETTLEMENTGENERATED(305L, "结算单已生成"),
	  /**
	   * 公司调整
	   */
	  HEADQUARTERSADJUST(306L, "公司调整"),
	  /**
	   * 客户调整
	   */
	  CUSTOMERADJUST(307L, "客户调整"),
	  /**
	   * 公司确认
	   */
	  HEADQUARTERSCONFIRM(308L, "公司确认"),
	  /**
	   * 客户确认
	   */
	  CUSTOMERCONFIRM(309L, "客户确认"),
	  /**
	   * 双方确认
	   */
	  BOTHCONFIRM(310L, "双方确认"),
	  /**
	   * 到账确认
	   */
	  ACCOUNTEDCONFIRM(311L, "到账确认"),
	  /**
	   * 已完成
	   */
	  COMPLETED(312L, "已完成");
  
	  private final Long value;
	  private final String name;
	  
	  private SettlementStatus(Long value,String name) {
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
	 * 结算变动类别
	 */
	public enum SettlementChangeType{
	  /**
	   * 未知
	   */
	  UNKNOWN(313L, "未知"),
	  /**
	   * 佣金变动
	   */
	  COMMISSIONCHANGED(314L, "佣金变动"),
	  /**
	   * 税额变动
	   */
	  TAXCHANGED(315L, "税额变动"),
	  /**
	   * 奖金变动
	   */
	  AWARDCHANGED(316L, "奖金变动"),
	  /**
	   * 赔付变动
	   */
	  PAYMENTCHANGED(317L, "赔付变动"),
	  /**
	   * 罚金变动
	   */
	  PUNISHCHANGED(318L, "罚金变动"),
	  /**
	   * 其他金额变动
	   */
	  OTHERCHANGED(319L, "其他金额变动");
  
	  private final Long value;
	  private final String name;
	  
	  private SettlementChangeType(Long value,String name) {
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
	 * 取款处理状态
	 */
	public enum WithdrawalStatus{
	  /**
	   * 未知
	   */
	  UNKNOWN(331L, "未知"),
	  /**
	   * 已申请
	   */
	  REQUESTED(332L, "已申请"),
	  /**
	   * 待审核
	   */
	  WAITINGAUDIT(333L, "待审核"),
	  /**
	   * 待确认
	   */
	  WAITINGCONFIRM(334L, "待确认"),
	  /**
	   * 已完成
	   */
	  FINISHED(335L, "已完成"),
	  /**
	   * 待重新审核
	   */
	  WAITINGREAUDIT(344L, "待重新审核"),
	  /**
	   * 待重新确认
	   */
	  WAITINGRECONFIRM(345L, "待重新确认"),
	  /**
	   * 待完成
	   */
	  WAITINGFINISH(346L, "待完成");
  
	  private final Long value;
	  private final String name;
	  
	  private WithdrawalStatus(Long value,String name) {
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
	 * 收益状态
	 */
	public enum IncomeStatus{
	  /**
	   * 未知
	   */
	  UNKNOWN(427L, "未知"),
	  /**
	   * 待收款
	   */
	  WAITING(428L, "待收款"),
	  /**
	   * 已收款
	   */
	  INCOMED(429L, "已收款"),
	  /**
	   * 延期
	   */
	  DELAY(430L, "延期"),
	  /**
	   * 失败
	   */
	  FAILED(431L, "失败");
  
	  private final Long value;
	  private final String name;
	  
	  private IncomeStatus(Long value,String name) {
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
	 * 还款状态
	 */
	public enum RepaymentStatus{
	  /**
	   * 未知
	   */
	  UNKNOWN(422L, "未知"),
	  /**
	   * 待还款
	   */
	  WAITING(423L, "待还款"),
	  /**
	   * 已还款
	   */
	  REPAYED(424L, "已还款"),
	  /**
	   * 还款延期
	   */
	  DELAY(425L, "还款延期"),
	  /**
	   * 还款失败
	   */
	  FAILED(426L, "还款失败");
  
	  private final Long value;
	  private final String name;
	  
	  private RepaymentStatus(Long value,String name) {
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
	 * 充值状态
	 */
	public enum DepositStatus{
	  /**
	   * 未知
	   */
	  UNKNOWN(416L, "未知"),
	  /**
	   * 待处理
	   */
	  WAITINGDEAL(417L, "待处理"),
	  /**
	   * 成功
	   */
	  SUCCESS(418L, "成功"),
	  /**
	   * 失败
	   */
	  FAILED(419L, "失败"),
	  /**
	   * 银行处理中
	   */
	  WAITINGBANKDEAL(421L, "银行处理中");
  
	  private final Long value;
	  private final String name;
	  
	  private DepositStatus(Long value,String name) {
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
	 * 取现状态
	 */
	public enum WithdrawStatus{
	  /**
	   * 未知
	   */
	  UNKNOWN(412L, "未知"),
	  /**
	   * 待处理
	   */
	  WAITINGDEAL(413L, "待处理"),
	  /**
	   * 成功
	   */
	  SUCCESS(414L, "成功"),
	  /**
	   * 失败
	   */
	  FAILED(415L, "失败"),
	  /**
	   * 银行处理中
	   */
	  WAITINGBANKDEAL(420L, "银行处理中");
  
	  private final Long value;
	  private final String name;
	  
	  private WithdrawStatus(Long value,String name) {
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
	 * 获取方式
	 */
	public enum GetMode{
	  /**
	   * 未知
	   */
	  UNKNOWN(539L, "未知"),
	  /**
	   * 销售
	   */
	  SALE(565L, "销售"),
	  /**
	   * 储值
	   */
	  REFILL(566L, "储值"),
	  /**
	   * 促销活动
	   */
	  PROMOTIONS(567L, "促销活动"),
	  /**
	   * 返券
	   */
	  COUPON(568L, "返券");
  
	  private final Long value;
	  private final String name;
	  
	  private GetMode(Long value,String name) {
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
	 * 使用方式
	 */
	public enum UseMode{
	  /**
	   * 未知
	   */
	  UNKNOWN(561L, "未知"),
	  /**
	   * 全场通用
	   */
	  ALLMALL(562L, "全场通用"),
	  /**
	   * 特定门店
	   */
	  SPECIFICSTORES(563L, "特定门店"),
	  /**
	   * 特定地区
	   */
	  SPECIFICREGION(564L, "特定地区");
  
	  private final Long value;
	  private final String name;
	  
	  private UseMode(Long value,String name) {
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
	 * 支付方式
	 */
	public enum PayMethod{
	  /**
	   * 未知
	   */
	  UNKNOWN(540L, "未知"),
	  /**
	   * 储蓄卡
	   */
	  SAVINGCARD(541L, "储蓄卡"),
	  /**
	   * 信用卡
	   */
	  CREDITCARD(542L, "信用卡"),
	  /**
	   * 微信
	   */
	  WECHAT(543L, "微信"),
	  /**
	   * 支付宝
	   */
	  ALIPAY(544L, "支付宝"),
	  /**
	   * 银联
	   */
	  CHINAUNIONPAY(545L, "银联"),
	  /**
	   * 现金
	   */
	  CASH(546L, "现金"),
	  /**
	   * 商户会员卡
	   */
	  MERCHANTMEMBERSHIP(547L, "商户会员卡"),
	  /**
	   * 平台会员卡
	   */
	  PLATFORMMEMBERSHIP(548L, "平台会员卡"),
	  /**
	   * 代金币
	   */
	  VIRTUALCURRENCY(549L, "代金币"),
	  /**
	   * 扫码支付
	   */
	  QRCODE(767L, "扫码支付");
  
	  private final Long value;
	  private final String name;
	  
	  private PayMethod(Long value,String name) {
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
	 * 支付机构类别
	 */
	public enum PayOrgType{
	  /**
	   * 未知
	   */
	  UNKNOWN(778L, "未知"),
	  /**
	   * 银行
	   */
	  BANK(779L, "银行"),
	  /**
	   * 第三方支付平台
	   */
	  THIRDPAYPLATFORM(781L, "第三方支付平台"),
	  /**
	   * 现金
	   */
	  CACH(782L, "现金");
  
	  private final Long value;
	  private final String name;
	  
	  private PayOrgType(Long value,String name) {
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
	 * 充值金额模式
	 */
	public enum RechargeAmountModel{
	  /**
	   * 固定金额
	   */
	  FIXED_AMOUNT(934L, "固定金额"),
	  /**
	   * 比率金额
	   */
	  RATIO_AMOUNT(935L, "比率金额"),
	  /**
	   * 无
	   */
	  NOTHING(938L, "无");
  
	  private final Long value;
	  private final String name;
	  
	  private RechargeAmountModel(Long value,String name) {
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
	 * 充值积分模式
	 */
	public enum RechargeIntegralMode{
	  /**
	   * 固定积分
	   */
	  FIXED_INTEGRAL(936L, "固定积分"),
	  /**
	   * 比率积分
	   */
	  RATIO_INTEGRAL(937L, "比率积分"),
	  /**
	   * 无
	   */
	  NOTHING(939L, "无");
  
	  private final Long value;
	  private final String name;
	  
	  private RechargeIntegralMode(Long value,String name) {
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