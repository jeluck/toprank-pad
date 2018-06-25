package cc.toprank.byd.enums;

/******************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的字典枚举类，不能手动修改。
 * 
 * ****************************************************************************************************/

public class CommonManageEnum {

	/**
	 * 
	 * 性别
	 */
	public enum Gender{
	  /**
	   * 男
	   */
	  MALE(2, "男"),
	  /**
	   * 女
	   */
	  FEMALE(3, "女");
  
	  private final long value;
	  private final String name;
	  
	  private Gender(long value,String name) {
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
	 * 密码格式
	 */
	public enum PasswordFormat{
	  /**
	   * 明文
	   */
	  CLEARTEXT(6, "明文"),
	  /**
	   * 密文
	   */
	  CIPHERTEXT(7, "密文");
  
	  private final long value;
	  private final String name;
	  
	  private PasswordFormat(long value,String name) {
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
	 * 银行错误代码
	 */
	public enum BankErrorCode{
	  /**
	   * 正常
	   */
	  BANKNORMAL(53, "正常"),
	  /**
	   * 银行返回的密码错误
	   */
	  BANKPASSWORDERROR(54, "银行返回的密码错误"),
	  /**
	   * 终端未签到
	   */
	  BANKNOSIGN(55, "终端未签到"),
	  /**
	   * 商户资金不足
	   */
	  MERCHANTSNOENOUGH(56, "商户资金不足"),
	  /**
	   * 已签到
	   */
	  BANKSIGNED(57, "已签到"),
	  /**
	   * 超限额,30分钟内无法再次购买该商品
	   */
	  BANKOVERMONEY(58, "超限额,30分钟内无法再次购买该商品"),
	  /**
	   * 交易成功
	   */
	  BANKTRADESUCCESS(72, "交易成功"),
	  /**
	   * 交易失败
	   */
	  BANKTRADEFAIL(162, "交易失败");
  
	  private final long value;
	  private final String name;
	  
	  private BankErrorCode(long value,String name) {
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
	 * 图片类别
	 */
	public enum ImageType{
	  /**
	   * 普通图片
	   */
	  NORMALIMAGE(144, "普通图片"),
	  /**
	   * 封面图片
	   */
	  COVERIMAGE(145, "封面图片"),
	  /**
	   * 透明图片
	   */
	  CLEARGIFS(146, "透明图片");
  
	  private final long value;
	  private final String name;
	  
	  private ImageType(long value,String name) {
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
	 * 附件类型
	 */
	public enum AttachmentType{
	  /**
	   * 描述文本
	   */
	  DESCDOC(147, "描述文本"),
	  /**
	   * 文本中的图片
	   */
	  IMAGEINDOC(148, "文本中的图片"),
	  /**
	   * 主题图片
	   */
	  TOPICIMAGE(149, "主题图片"),
	  /**
	   * 图片
	   */
	  IMAGE(150, "图片"),
	  /**
	   * 音频文件
	   */
	  AUDIO(151, "音频文件"),
	  /**
	   * 视频文件
	   */
	  VIDEO(152, "视频文件"),
	  /**
	   * 附件文档
	   */
	  DOC(153, "附件文档"),
	  /**
	   * 列表图片
	   */
	  LISTIAMGE(569, "列表图片"),
	  /**
	   * 默认图片
	   */
	  DEFAULTIMAGE(570, "默认图片"),
	  /**
	   * 放大图
	   */
	  BIGIMAGE(571, "放大图"),
	  /**
	   * 未知
	   */
	  UNKNOWN(572, "未知");
  
	  private final long value;
	  private final String name;
	  
	  private AttachmentType(long value,String name) {
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
	 * 关联状态
	 */
	public enum MappingStatus{
	  /**
	   * 未知
	   */
	  UNKNOWN(218, "未知"),
	  /**
	   * 正常
	   */
	  NORMAL(219, "正常"),
	  /**
	   * 锁定
	   */
	  LOCKED(220, "锁定"),
	  /**
	   * 失效
	   */
	  INVALID(221, "失效");
  
	  private final long value;
	  private final String name;
	  
	  private MappingStatus(long value,String name) {
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
	 * 周期类别
	 */
	public enum DurationType{
	  /**
	   * 未知
	   */
	  UNKNOWN(229, "未知"),
	  /**
	   * 小时
	   */
	  HOUR(230, "小时"),
	  /**
	   * 天
	   */
	  DAY(231, "天"),
	  /**
	   * 周
	   */
	  WEEK(232, "周"),
	  /**
	   * 月
	   */
	  MONTH(233, "月"),
	  /**
	   * 年
	   */
	  YEAR(234, "年"),
	  /**
	   * 分钟
	   */
	  MINUTE(636, "分钟");
  
	  private final long value;
	  private final String name;
	  
	  private DurationType(long value,String name) {
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
	 * 证件类型
	 */
	public enum CredentType{
	  /**
	   * 身份证
	   */
	  IDCARD(244, "身份证"),
	  /**
	   * 港澳通行证
	   */
	  VISA(245, "港澳通行证"),
	  /**
	   * 护照
	   */
	  PASSPORT(246, "护照"),
	  /**
	   * 未知
	   */
	  UNKNOWN(247, "未知"),
	  /**
	   * 军人证
	   */
	  MILITARYCARD(866, "军人证"),
	  /**
	   * 工作证
	   */
	  WORK(867, "工作证");
  
	  private final long value;
	  private final String name;
	  
	  private CredentType(long value,String name) {
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
	 * 短信通知业务类别
	 */
	public enum SMSSettingType{
	  /**
	   * 未知
	   */
	  UNKNOWN(258, "未知"),
	  /**
	   * 额度调整
	   */
	  QUOTAADJUST(259, "额度调整"),
	  /**
	   * 额度库存警报
	   */
	  QUOTAWARNING(260, "额度库存警报"),
	  /**
	   * 验证码调整
	   */
	  VALIDATIONADJUCT(261, "验证码调整"),
	  /**
	   * 验证码库存警报
	   */
	  VALIDATIONWARNING(262, "验证码库存警报"),
	  /**
	   * 交易通知
	   */
	  TRADINGNOTICE(263, "交易通知"),
	  /**
	   * 服务消费通知
	   */
	  SERVICEUSED(271, "服务消费通知"),
	  /**
	   * 数据库任务
	   */
	  DATABASETASK(297, "数据库任务"),
	  /**
	   * 订单处理阶段通知
	   */
	  NOTICE_OF_ORDER_PROCESSING(674, "订单处理阶段通知");
  
	  private final long value;
	  private final String name;
	  
	  private SMSSettingType(long value,String name) {
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
	 * 短信配置状态
	 */
	public enum SMSSettingStatus{
	  /**
	   * 未知
	   */
	  UNKNOWN(264, "未知"),
	  /**
	   * 正常
	   */
	  NORMAL(265, "正常"),
	  /**
	   * 停用
	   */
	  DISABLE(266, "停用");
  
	  private final long value;
	  private final String name;
	  
	  private SMSSettingStatus(long value,String name) {
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
	 * 短信发送状态
	 */
	public enum SMSSendStatus{
	  /**
	   * 未知
	   */
	  UNKNOWN(290, "未知"),
	  /**
	   * 待发送
	   */
	  WAITINGSEND(291, "待发送"),
	  /**
	   * 正在发送
	   */
	  SENDING(292, "正在发送"),
	  /**
	   * 发送成功
	   */
	  SENDEDOK(293, "发送成功"),
	  /**
	   * 发送失败
	   */
	  SENDEDFAILED(294, "发送失败"),
	  /**
	   * 第一次重发
	   */
	  RESENDFIRST(295, "第一次重发"),
	  /**
	   * 第二次重发
	   */
	  RESENDSECOND(296, "第二次重发");
  
	  private final long value;
	  private final String name;
	  
	  private SMSSendStatus(long value,String name) {
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
	 * 数据库任务状态
	 */
	public enum DBTaskStatus{
	  /**
	   * 未知
	   */
	  UNKNOWN(298, "未知"),
	  /**
	   * 未启动
	   */
	  UNSTART(299, "未启动"),
	  /**
	   * 启动中
	   */
	  STARTING(300, "启动中"),
	  /**
	   * 执行中
	   */
	  RUNNING(301, "执行中"),
	  /**
	   * 成功
	   */
	  SUCCESS(302, "成功"),
	  /**
	   * 失败
	   */
	  FAILED(303, "失败");
  
	  private final long value;
	  private final String name;
	  
	  private DBTaskStatus(long value,String name) {
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
	 * 子系统类别
	 */
	public enum SubSystemType{
	  /**
	   * 显示菜单
	   */
	  SHOWMENU(362, "显示菜单"),
	  /**
	   * 前台菜单
	   */
	  FOREGROUNDMENU(933, "前台菜单");
  
	  private final long value;
	  private final String name;
	  
	  private SubSystemType(long value,String name) {
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
	 * 权限类别
	 */
	public enum PrivilegeType{
	  /**
	   * 未知
	   */
	  UNKNOWN(349, "未知"),
	  /**
	   * 固定
	   */
	  STABLE(350, "固定"),
	  /**
	   * 可编辑
	   */
	  EDITABLE(351, "可编辑"),
	  /**
	   * 可添加
	   */
	  ADDABLE(352, "可添加");
  
	  private final long value;
	  private final String name;
	  
	  private PrivilegeType(long value,String name) {
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
	 * 目标类别
	 */
	public enum GoalsType{
	  /**
	   * 未知
	   */
	  UNKNOWN(354, "未知"),
	  /**
	   * 商品
	   */
	  PRODUCT(355, "商品"),
	  /**
	   * 商品变体
	   */
	  PRODUCTVARIANT(356, "商品变体"),
	  /**
	   * 设计师
	   */
	  DESIGNER(357, "设计师"),
	  /**
	   * 品牌
	   */
	  BRAND(557, "品牌"),
	  /**
	   * 新闻
	   */
	  NEWS(558, "新闻"),
	  /**
	   * 订单明细
	   */
	  ORDER_DETAILS(943, "订单明细"),
	  /**
	   * 套餐明细
	   */
	  PACKAGE_DETAILS(944, "套餐明细");
  
	  private final long value;
	  private final String name;
	  
	  private GoalsType(long value,String name) {
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
	 * 融资方式
	 */
	public enum FinancingType{
	  /**
	   * 未知
	   */
	  UNKNOWN(371, "未知"),
	  /**
	   * 供应商
	   */
	  VENDOR(372, "供应商"),
	  /**
	   * 合作商
	   */
	  COOPERATION(373, "合作商"),
	  /**
	   * 门店
	   */
	  SHOP(374, "门店"),
	  /**
	   * 客户
	   */
	  CUSTOMER(375, "客户"),
	  /**
	   * 仓库
	   */
	  WAREHOUSE(376, "仓库"),
	  /**
	   * 担保
	   */
	  GUARANTEE(392, "担保"),
	  /**
	   * 保理
	   */
	  FACTORING(446, "保理"),
	  /**
	   * 抵押
	   */
	  MORTGAGE(447, "抵押"),
	  /**
	   * 商票
	   */
	  COMMERCIALPAPER(448, "商票");
  
	  private final long value;
	  private final String name;
	  
	  private FinancingType(long value,String name) {
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
	 * 访问渠道
	 */
	public enum AccessChannel{
	  /**
	   * 未知
	   */
	  UNKNOWN(397, "未知"),
	  /**
	   * 网站
	   */
	  WEB(398, "网站"),
	  /**
	   * Android
	   */
	  ANDROID(399, "Android"),
	  /**
	   * H5
	   */
	  H5(400, "H5"),
	  /**
	   * iOS
	   */
	  IOS(401, "iOS"),
	  /**
	   * 微信
	   */
	  WEICHART(402, "微信"),
	  /**
	   * 微博
	   */
	  MICROBLOG(403, "微博"),
	  /**
	   * 合作伙伴
	   */
	  PARTNER(404, "合作伙伴"),
	  /**
	   * Windows客户端
	   */
	  WINCLIENT(408, "Windows客户端"),
	  /**
	   * 内部专用
	   */
	  PRIVATE(470, "内部专用");
  
	  private final long value;
	  private final String name;
	  
	  private AccessChannel(long value,String name) {
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
	 * 短信服务提供商
	 */
	public enum EnumSMSProvider{
	  /**
	   * 未知
	   */
	  UNKNOWN(405, "未知"),
	  /**
	   * 建周
	   */
	  JIANZHOU(406, "建周"),
	  /**
	   * 微网通联
	   */
	  WEIWANG(407, "微网通联");
  
	  private final long value;
	  private final String name;
	  
	  private EnumSMSProvider(long value,String name) {
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
	 * 托管平台类别
	 */
	public enum PlatformType{
	  /**
	   * 未知
	   */
	  UNKNOWN(409, "未知"),
	  /**
	   * 银行
	   */
	  BANK(410, "银行"),
	  /**
	   * 第三方支付
	   */
	  ESCROW(411, "第三方支付");
  
	  private final long value;
	  private final String name;
	  
	  private PlatformType(long value,String name) {
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
	 * 网络类别
	 */
	public enum NetType{
	  /**
	   * 未知
	   */
	  UNKNOWN(550, "未知"),
	  /**
	   * 3G
	   */
	  THREE_G(551, "3G"),
	  /**
	   * 4G
	   */
	  FOUR_G(552, "4G"),
	  /**
	   * 2M以下
	   */
	  TWO_M(553, "2M以下"),
	  /**
	   * 10M
	   */
	  TEN_M(554, "10M"),
	  /**
	   * 20M
	   */
	  TWENTY_M(555, "20M"),
	  /**
	   * 100M及以上
	   */
	  ONEHUNDRED(556, "100M及以上");
  
	  private final long value;
	  private final String name;
	  
	  private NetType(long value,String name) {
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
	 * 业务状态
	 */
	public enum BusinessStatus{
	  /**
	   * 未知
	   */
	  BUSINESSUNKNOWN(659, "未知"),
	  /**
	   * 正常
	   */
	  BUSINESSNORMAL(660, "正常"),
	  /**
	   * 停用
	   */
	  BUSINESSDISABLE(661, "停用"),
	  /**
	   * 已处理
	   */
	  BUSINESSPROCESSED(789, "已处理"),
	  /**
	   * 已转发
	   */
	  BUSINESSFORWARD(790, "已转发"),
	  /**
	   * 待处理
	   */
	  BUSINESSPENDING(791, "待处理"),
	  /**
	   * 转发过来的消息状态
	   */
	  BUSINESSFORWARDIN(793, "转发过来的消息状态");
  
	  private final long value;
	  private final String name;
	  
	  private BusinessStatus(long value,String name) {
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
	 * 负责类别
	 */
	public enum ManageType{
	  /**
	   * 上菜
	   */
	  SERVING(666, "上菜"),
	  /**
	   * 收拾
	   */
	  TIDY(667, "收拾"),
	  /**
	   * 点菜
	   */
	  ADDDISH(668, "点菜"),
	  /**
	   * 领位
	   */
	  HOSTESS(669, "领位");
  
	  private final long value;
	  private final String name;
	  
	  private ManageType(long value,String name) {
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
	 * 响应类别
	 */
	public enum ServiceAnswerType{
	  /**
	   * 点菜
	   */
	  ORDER(662, "点菜"),
	  /**
	   * 加菜
	   */
	  ADDDISH(663, "加菜"),
	  /**
	   * 退菜
	   */
	  RETREATFOOD(664, "退菜"),
	  /**
	   * 结账
	   */
	  CHECKOUT(665, "结账");
  
	  private final long value;
	  private final String name;
	  
	  private ServiceAnswerType(long value,String name) {
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
	 * 消息类别
	 */
	public enum MessageType{
	  /**
	   * 不用等预定消息
	   */
	  SCHEDULEDMESSAGE(670, "不用等预定消息"),
	  /**
	   * 美味推送通知
	   */
	  PUSHNOTIFICATIONS(671, "美味推送通知"),
	  /**
	   * 审核通知
	   */
	  AUDITNOTICE(672, "审核通知");
  
	  private final long value;
	  private final String name;
	  
	  private MessageType(long value,String name) {
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
	 * 分享信息内容
	 */
	public enum ShareMessage{
	  /**
	   * 不用等默认分享消息
	   */
	  BYDSHAREMESSAGE(678, "不用等默认分享消息");
  
	  private final long value;
	  private final String name;
	  
	  private ShareMessage(long value,String name) {
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
	 * 网址
	 */
	public enum URL{
	  /**
	   * APP下载地址
	   */
	  DOWNLOADADDRESS(689, "APP下载地址"),
	  /**
	   * 关于我们
	   */
	  ABOUTUS(690, "关于我们"),
	  /**
	   * 成为商家协议书
	   */
	  AGREEMENT(735, "成为商家协议书"),
	  /**
	   * 商家版简介
	   */
	  SYNOPSIS(760, "商家版简介");
  
	  private final long value;
	  private final String name;
	  
	  private URL(long value,String name) {
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
	 * APP下载地址
	 */
	public enum APPDownloadPath{
	  /**
	   * 不用等IOS下载APP地址
	   */
	  BYDIOSDOWNLOADPATH(706, "不用等IOS下载APP地址"),
	  /**
	   * 不用等安卓下载APP地址
	   */
	  BYDANDROIDDOWNLOADPATH(708, "不用等安卓下载APP地址");
  
	  private final long value;
	  private final String name;
	  
	  private APPDownloadPath(long value,String name) {
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
	 * 业务类别
	 */
	public enum BusinessType{
	  /**
	   * 未知
	   */
	  UNKNOWN(754, "未知"),
	  /**
	   * 充值
	   */
	  RECHARGE(755, "充值"),
	  /**
	   * 提现
	   */
	  CASH(756, "提现"),
	  /**
	   * 红包
	   */
	  RED(757, "红包"),
	  /**
	   * 签到
	   */
	  SIGN(758, "签到"),
	  /**
	   * 订金
	   */
	  SUBSCRIPTION(765, "订金"),
	  /**
	   * 消息通知类型
	   */
	  BUSINESSMESSAGES(792, "消息通知类型"),
	  /**
	   * 转发
	   */
	  FORWARD(927, "转发"),
	  /**
	   * 晋升
	   */
	  PROMOTION(928, "晋升"),
	  /**
	   * 主订单
	   */
	  MAINORDER(1084, "主订单"),
	  /**
	   * 子订单
	   */
	  SUBORDER(1085, "子订单"),
	  /**
	   * 订单明细
	   */
	  ORDERDETAIL(1086, "订单明细"),
	  /**
	   * 套餐明细
	   */
	  COMBODETAIL(1087, "套餐明细"),
	  /**
	   * 预订
	   */
	  BOOK(1099, "预订"),
	  /**
	   * 推荐
	   */
	  RECOMMEND(1100, "推荐"),
	  /**
	   * 邀请
	   */
	  INVITATION(1101, "邀请"),
	  /**
	   * 暂结单
	   */
	  SETTLE(1119, "暂结单"),
	  /**
	   * 结账单
	   */
	  PAYMENT(1120, "结账单"),
	  /**
	   * 预订账单
	   */
	  BOOKING(1121, "预订账单"),
	  /**
	   * 还款账单
	   */
	  REPAY(1122, "还款账单"),
	  /**
	   * 交班对账单
	   */
	  CHANGE(1123, "交班对账单"),
	  /**
	   * 日结对账单
	   */
	  DAILYSETTLE(1124, "日结对账单"),
	  /**
	   * 会员付款单
	   */
	  CARDSETTLE(1125, "会员付款单");
  
	  private final long value;
	  private final String name;
	  
	  private BusinessType(long value,String name) {
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
	 * 邀请聚餐状态
	 */
	public enum InvitationStatus{
	  /**
	   * 接受邀请
	   */
	  ACCEPTTHEINVITATION(794, "接受邀请"),
	  /**
	   * 邀请已过期
	   */
	  INVITATIONEXPIRED(799, "邀请已过期");
  
	  private final long value;
	  private final String name;
	  
	  private InvitationStatus(long value,String name) {
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
	 * 水牌状态
	 */
	public enum DrinkStatus{
	  /**
	   * 水牌启用
	   */
	  CONSENTIRE(800, "水牌启用"),
	  /**
	   * 水牌停用
	   */
	  DISATTIVARE(801, "水牌停用");
  
	  private final long value;
	  private final String name;
	  
	  private DrinkStatus(long value,String name) {
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
	 * 水牌关联状态
	 */
	public enum DrinkMappingStatus{
	  /**
	   * 绑定中
	   */
	  INUNLEGAME(802, "绑定中"),
	  /**
	   * 绑定取消
	   */
	  ANNULLAREVINCOLANTE(803, "绑定取消");
  
	  private final long value;
	  private final String name;
	  
	  private DrinkMappingStatus(long value,String name) {
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
	 * 普通权限
	 */
	public enum GeneralPrivilege{
	  /**
	   * 添加
	   */
	  ADD(482, "添加"),
	  /**
	   * 删除
	   */
	  DELETE(483, "删除"),
	  /**
	   * 修改
	   */
	  MODIFY(484, "修改"),
	  /**
	   * 查询
	   */
	  SEARCH(485, "查询"),
	  /**
	   * 启用
	   */
	  ENABLE(929, "启用"),
	  /**
	   * 禁用
	   */
	  DISABLE(930, "禁用"),
	  /**
	   * 后台授权
	   */
	  PLATFORMROLEPRIVILEGE(978, "后台授权"),
	  /**
	   * 批量新增
	   */
	  ADDMORE(979, "批量新增");
  
	  private final long value;
	  private final String name;
	  
	  private GeneralPrivilege(long value,String name) {
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
	 * 登录状态
	 */
	public enum LoginStatus{
	  /**
	   * 登录
	   */
	  LOGIN(960, "登录"),
	  /**
	   * 注销
	   */
	  CANCELLATION(961, "注销");
  
	  private final long value;
	  private final String name;
	  
	  private LoginStatus(long value,String name) {
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
	 * 周期执行方式
	 */
	public enum DurationAction{
	  /**
	   * 期间内每天执行
	   */
	  ONDAY(990, "期间内每天执行"),
	  /**
	   * 期间内每周几执行
	   */
	  ONWEEK(991, "期间内每周几执行"),
	  /**
	   * 期间内每月几号执行
	   */
	  ONMONTH(992, "期间内每月几号执行");
  
	  private final long value;
	  private final String name;
	  
	  private DurationAction(long value,String name) {
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
	 * 评价项目类型
	 */
	public enum EvaluateType{
	  /**
	   * 口味
	   */
	  FLAVOR(999, "口味"),
	  /**
	   * 服务
	   */
	  SERVICE(1000, "服务"),
	  /**
	   * 环境
	   */
	  ENVIRONMENTAL (1001, "环境");
  
	  private final long value;
	  private final String name;
	  
	  private EvaluateType(long value,String name) {
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
	 * 优惠券
	 */
	public enum Coupon{
	  /**
	   * 现金券
	   */
	  CASHCOUPON(1028, "现金券"),
	  /**
	   * 折扣券
	   */
	  DISCOUNTCOUPON(1029, "折扣券"),
	  /**
	   * 超级返利
	   */
	  SUPERREBATE(1030, "超级返利");
  
	  private final long value;
	  private final String name;
	  
	  private Coupon(long value,String name) {
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
	 * 推荐状态
	 */
	public enum IntroduceType{
	  /**
	   * 未知
	   */
	  UNKNOWN(1041, "未知"),
	  /**
	   * 待审核
	   */
	  WAITTOAUDIT(1042, "待审核"),
	  /**
	   * 正常
	   */
	  NORMAL(1043, "正常"),
	  /**
	   * 已删除
	   */
	  DELETED(1044, "已删除"),
	  /**
	   * 已禁用
	   */
	  DISABLED(1045, "已禁用");
  
	  private final long value;
	  private final String name;
	  
	  private IntroduceType(long value,String name) {
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
	 * 群组编号
	 */
	public enum GroupNum{
	  /**
	   * 亲人
	   */
	  RELATIVE(1046, "亲人"),
	  /**
	   * 朋友
	   */
	  FRIENDS(1047, "朋友"),
	  /**
	   * 同学
	   */
	  STUDENTS(1048, "同学"),
	  /**
	   * 同事
	   */
	  WORKMATE(1049, "同事"),
	  /**
	   * 客户
	   */
	  CUSTOMERS(1050, "客户"),
	  /**
	   * 陌生人
	   */
	  STRANGERS(1051, "陌生人"),
	  /**
	   * 黑名单
	   */
	  BLACKLIST(1052, "黑名单");
  
	  private final long value;
	  private final String name;
	  
	  private GroupNum(long value,String name) {
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
	 * 关联类别2
	 */
	public enum RelatedType{
	  /**
	   * 邀请
	   */
	  INVITE(1053, "邀请"),
	  /**
	   * 推荐
	   */
	  RECOMMEND(1054, "推荐"),
	  /**
	   * 通信录
	   */
	  CALLMENU(1055, "通信录");
  
	  private final long value;
	  private final String name;
	  
	  private RelatedType(long value,String name) {
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
	 * 推荐类型
	 */
	public enum RecommendType{
	  /**
	   * 未知
	   */
	  UNKNOWN(1056, "未知"),
	  /**
	   * 推荐
	   */
	  RECOMMEND(1057, "推荐"),
	  /**
	   * 点赞
	   */
	  LIKE(1058, "点赞"),
	  /**
	   * 浏览
	   */
	  REVIEW(1059, "浏览"),
	  /**
	   * 转发
	   */
	  REDICT(1060, "转发");
  
	  private final long value;
	  private final String name;
	  
	  private RecommendType(long value,String name) {
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
	 * 评论类型
	 */
	public enum ReviewType{
	  /**
	   * 未知
	   */
	  UNKOWN(1061, "未知"),
	  /**
	   * 商户评论
	   */
	  MERCHANTCOMMAND(1062, "商户评论"),
	  /**
	   * 拍菜
	   */
	  COMMITFOOD(1063, "拍菜");
  
	  private final long value;
	  private final String name;
	  
	  private ReviewType(long value,String name) {
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