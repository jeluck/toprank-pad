package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在E_LoginInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class E_LoginInfoEntityBase  extends Entity{

  /**
   *	Code数据库列名
   */
  public final static String CODE_FIELD =  "Code";
  
  /**
   *	Code字段中文名，用于视图展示
   */
  public final static String CODE_LABLE = "编码";
  
  /**
   *	Code对应的java字段名,业务操作使用这个字段。
   */
  private String code;
  
  /**
   *	CreateTime数据库列名
   */
  public final static String CREATETIME_FIELD =  "CreateTime";
  
  /**
   *	CreateTime字段中文名，用于视图展示
   */
  public final static String CREATETIME_LABLE = "创建时间";
  
  /**
   *	CreateTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime createTime;
  
  /**
   *	CurrencyID数据库列名
   */
  public final static String CURRENCYID_FIELD =  "CurrencyID";
  
  /**
   *	CurrencyID字段中文名，用于视图展示
   */
  public final static String CURRENCYID_LABLE = "货币编号";
  
  /**
   *	CurrencyID对应的java字段名,业务操作使用这个字段。
   */
  private Long currencyID;
  
  /**
   *	CustomerID数据库列名
   */
  public final static String CUSTOMERID_FIELD =  "CustomerID";
  
  /**
   *	CustomerID字段中文名，用于视图展示
   */
  public final static String CUSTOMERID_LABLE = "客户编号";
  
  /**
   *	CustomerID对应的java字段名,业务操作使用这个字段。
   */
  private Long customerID;
  
  /**
   *	DayFailedNumber数据库列名
   */
  public final static String DAYFAILEDNUMBER_FIELD =  "DayFailedNumber";
  
  /**
   *	DayFailedNumber字段中文名，用于视图展示
   */
  public final static String DAYFAILEDNUMBER_LABLE = "当天失败次数";
  
  /**
   *	DayFailedNumber对应的java字段名,业务操作使用这个字段。
   */
  private Integer dayFailedNumber;
  
  /**
   *	DayLoginNumber数据库列名
   */
  public final static String DAYLOGINNUMBER_FIELD =  "DayLoginNumber";
  
  /**
   *	DayLoginNumber字段中文名，用于视图展示
   */
  public final static String DAYLOGINNUMBER_LABLE = "当天登录次数";
  
  /**
   *	DayLoginNumber对应的java字段名,业务操作使用这个字段。
   */
  private Integer dayLoginNumber;
  
  /**
   *	FailedArea数据库列名
   */
  public final static String FAILEDAREA_FIELD =  "FailedArea";
  
  /**
   *	FailedArea字段中文名，用于视图展示
   */
  public final static String FAILEDAREA_LABLE = "最后失败地区";
  
  /**
   *	FailedArea对应的java字段名,业务操作使用这个字段。
   */
  private String failedArea;
  
  /**
   *	FailedIP数据库列名
   */
  public final static String FAILEDIP_FIELD =  "FailedIP";
  
  /**
   *	FailedIP字段中文名，用于视图展示
   */
  public final static String FAILEDIP_LABLE = "最后失败IP";
  
  /**
   *	FailedIP对应的java字段名,业务操作使用这个字段。
   */
  private String failedIP;
  
  /**
   *	FailedTime数据库列名
   */
  public final static String FAILEDTIME_FIELD =  "FailedTime";
  
  /**
   *	FailedTime字段中文名，用于视图展示
   */
  public final static String FAILEDTIME_LABLE = "最后失败时间";
  
  /**
   *	FailedTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime failedTime;
  
  /**
   *	IsForceChange数据库列名
   */
  public final static String ISFORCECHANGE_FIELD =  "IsForceChange";
  
  /**
   *	IsForceChange字段中文名，用于视图展示
   */
  public final static String ISFORCECHANGE_LABLE = "是否强制更改密码";
  
  /**
   *	IsForceChange对应的java字段名,业务操作使用这个字段。
   */
  private Boolean isForceChange;
  
  /**
   *	IsNormal数据库列名
   */
  public final static String ISNORMAL_FIELD =  "IsNormal";
  
  /**
   *	IsNormal字段中文名，用于视图展示
   */
  public final static String ISNORMAL_LABLE = "是否正常";
  
  /**
   *	IsNormal对应的java字段名,业务操作使用这个字段。
   */
  private Boolean isNormal;
  
  /**
   *	LatestLoginArea数据库列名
   */
  public final static String LATESTLOGINAREA_FIELD =  "LatestLoginArea";
  
  /**
   *	LatestLoginArea字段中文名，用于视图展示
   */
  public final static String LATESTLOGINAREA_LABLE = "最后登录地区";
  
  /**
   *	LatestLoginArea对应的java字段名,业务操作使用这个字段。
   */
  private String latestLoginArea;
  
  /**
   *	LatestLoginIP数据库列名
   */
  public final static String LATESTLOGINIP_FIELD =  "LatestLoginIP";
  
  /**
   *	LatestLoginIP字段中文名，用于视图展示
   */
  public final static String LATESTLOGINIP_LABLE = "最后登录IP";
  
  /**
   *	LatestLoginIP对应的java字段名,业务操作使用这个字段。
   */
  private String latestLoginIP;
  
  /**
   *	LatestLoginTime数据库列名
   */
  public final static String LATESTLOGINTIME_FIELD =  "LatestLoginTime";
  
  /**
   *	LatestLoginTime字段中文名，用于视图展示
   */
  public final static String LATESTLOGINTIME_LABLE = "最后登录时间";
  
  /**
   *	LatestLoginTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime latestLoginTime;
  
  /**
   *	LatestModifyTime数据库列名
   */
  public final static String LATESTMODIFYTIME_FIELD =  "LatestModifyTime";
  
  /**
   *	LatestModifyTime字段中文名，用于视图展示
   */
  public final static String LATESTMODIFYTIME_LABLE = "最后修改时间";
  
  /**
   *	LatestModifyTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime latestModifyTime;
  
  /**
   *	LoginID数据库列名
   */
  public final static String LOGINID_FIELD =  "LoginID";
  
  /**
   *	LoginID字段中文名，用于视图展示
   */
  public final static String LOGINID_LABLE = "登录编号";
  
  /**
   *	LoginID对应的java字段名,业务操作使用这个字段。
   */
  private Long loginID;
  
  /**
   *	LoginName数据库列名
   */
  public final static String LOGINNAME_FIELD =  "LoginName";
  
  /**
   *	LoginName字段中文名，用于视图展示
   */
  public final static String LOGINNAME_LABLE = "登录名";
  
  /**
   *	LoginName对应的java字段名,业务操作使用这个字段。
   */
  private String loginName;
  
  /**
   *	LoginPassword数据库列名
   */
  public final static String LOGINPASSWORD_FIELD =  "LoginPassword";
  
  /**
   *	LoginPassword字段中文名，用于视图展示
   */
  public final static String LOGINPASSWORD_LABLE = "密码";
  
  /**
   *	LoginPassword对应的java字段名,业务操作使用这个字段。
   */
  private String loginPassword;
  
  /**
   *	LoginStatus数据库列名
   */
  public final static String LOGINSTATUS_FIELD =  "LoginStatus";
  
  /**
   *	LoginStatus字段中文名，用于视图展示
   */
  public final static String LOGINSTATUS_LABLE = "登录名状态";
  
  /**
   *	LoginStatus对应的java字段名,业务操作使用这个字段。
   */
  private Long loginStatus;
  
  /**
   *	LogoUrl数据库列名
   */
  public final static String LOGOURL_FIELD =  "LogoUrl";
  
  /**
   *	LogoUrl字段中文名，用于视图展示
   */
  public final static String LOGOURL_LABLE = "LogoUrl";
  
  /**
   *	LogoUrl对应的java字段名,业务操作使用这个字段。
   */
  private String logoUrl;
  
  /**
   *	Memo数据库列名
   */
  public final static String MEMO_FIELD =  "Memo";
  
  /**
   *	Memo字段中文名，用于视图展示
   */
  public final static String MEMO_LABLE = "备注";
  
  /**
   *	Memo对应的java字段名,业务操作使用这个字段。
   */
  private String memo;
  
  /**
   *	NickName数据库列名
   */
  public final static String NICKNAME_FIELD =  "NickName";
  
  /**
   *	NickName字段中文名，用于视图展示
   */
  public final static String NICKNAME_LABLE = "昵称";
  
  /**
   *	NickName对应的java字段名,业务操作使用这个字段。
   */
  private String nickName;
  
  /**
   *	Signature数据库列名
   */
  public final static String SIGNATURE_FIELD =  "Signature";
  
  /**
   *	Signature字段中文名，用于视图展示
   */
  public final static String SIGNATURE_LABLE = "个性签名";
  
  /**
   *	Signature对应的java字段名,业务操作使用这个字段。
   */
  private String signature;
  
  /**
   *	SyncTime数据库列名
   */
  public final static String SYNCTIME_FIELD =  "SyncTime";
  
  /**
   *	SyncTime字段中文名，用于视图展示
   */
  public final static String SYNCTIME_LABLE = "SyncTime";
  
  /**
   *	SyncTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime syncTime;
  
  /**
   *	SyncTimeResult数据库列名
   */
  public final static String SYNCTIMERESULT_FIELD =  "SyncTimeResult";
  
  /**
   *	SyncTimeResult字段中文名，用于视图展示
   */
  public final static String SYNCTIMERESULT_LABLE = "SyncTimeResult";
  
  /**
   *	SyncTimeResult对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime syncTimeResult;
  
  /**
   *	ThirdType数据库列名
   */
  public final static String THIRDTYPE_FIELD =  "ThirdType";
  
  /**
   *	ThirdType字段中文名，用于视图展示
   */
  public final static String THIRDTYPE_LABLE = "第三方类别";
  
  /**
   *	ThirdType对应的java字段名,业务操作使用这个字段。
   */
  private Long thirdType;
  
  /**
   *	TotalLoginNumber数据库列名
   */
  public final static String TOTALLOGINNUMBER_FIELD =  "TotalLoginNumber";
  
  /**
   *	TotalLoginNumber字段中文名，用于视图展示
   */
  public final static String TOTALLOGINNUMBER_LABLE = "历史登录次数";
  
  /**
   *	TotalLoginNumber对应的java字段名,业务操作使用这个字段。
   */
  private Integer totalLoginNumber;
  
  /**
   * 编码 getter
   */
  public String getCode(){
    return code;
  }
  /**
   * 编码 setter
   * @param code
   */  
  public void setCode(String code){
    this.code = code;
  }
 
  /**
   * 创建时间 getter
   */
  public java.time.LocalDateTime getCreateTime(){
    return createTime;
  }
  /**
   * 创建时间 setter
   * @param createTime
   */  
  public void setCreateTime(java.time.LocalDateTime createTime){
    this.createTime = createTime;
  }
 
  /**
   * 货币编号 getter
   */
  public Long getCurrencyID(){
    return currencyID;
  }
  /**
   * 货币编号 setter
   * @param currencyID
   */  
  public void setCurrencyID(Long currencyID){
    this.currencyID = currencyID;
  }
 
  /**
   * 客户编号 getter
   */
  public Long getCustomerID(){
    return customerID;
  }
  /**
   * 客户编号 setter
   * @param customerID
   */  
  public void setCustomerID(Long customerID){
    this.customerID = customerID;
  }
 
  /**
   * 当天失败次数 getter
   */
  public Integer getDayFailedNumber(){
    return dayFailedNumber;
  }
  /**
   * 当天失败次数 setter
   * @param dayFailedNumber
   */  
  public void setDayFailedNumber(Integer dayFailedNumber){
    this.dayFailedNumber = dayFailedNumber;
  }
 
  /**
   * 当天登录次数 getter
   */
  public Integer getDayLoginNumber(){
    return dayLoginNumber;
  }
  /**
   * 当天登录次数 setter
   * @param dayLoginNumber
   */  
  public void setDayLoginNumber(Integer dayLoginNumber){
    this.dayLoginNumber = dayLoginNumber;
  }
 
  /**
   * 最后失败地区 getter
   */
  public String getFailedArea(){
    return failedArea;
  }
  /**
   * 最后失败地区 setter
   * @param failedArea
   */  
  public void setFailedArea(String failedArea){
    this.failedArea = failedArea;
  }
 
  /**
   * 最后失败IP getter
   */
  public String getFailedIP(){
    return failedIP;
  }
  /**
   * 最后失败IP setter
   * @param failedIP
   */  
  public void setFailedIP(String failedIP){
    this.failedIP = failedIP;
  }
 
  /**
   * 最后失败时间 getter
   */
  public java.time.LocalDateTime getFailedTime(){
    return failedTime;
  }
  /**
   * 最后失败时间 setter
   * @param failedTime
   */  
  public void setFailedTime(java.time.LocalDateTime failedTime){
    this.failedTime = failedTime;
  }
 
  /**
   * 是否强制更改密码 getter
   */
  public Boolean getIsForceChange(){
    return isForceChange;
  }
  /**
   * 是否强制更改密码 setter
   * @param isForceChange
   */  
  public void setIsForceChange(Boolean isForceChange){
    this.isForceChange = isForceChange;
  }
 
  /**
   * 是否正常 getter
   */
  public Boolean getIsNormal(){
    return isNormal;
  }
  /**
   * 是否正常 setter
   * @param isNormal
   */  
  public void setIsNormal(Boolean isNormal){
    this.isNormal = isNormal;
  }
 
  /**
   * 最后登录地区 getter
   */
  public String getLatestLoginArea(){
    return latestLoginArea;
  }
  /**
   * 最后登录地区 setter
   * @param latestLoginArea
   */  
  public void setLatestLoginArea(String latestLoginArea){
    this.latestLoginArea = latestLoginArea;
  }
 
  /**
   * 最后登录IP getter
   */
  public String getLatestLoginIP(){
    return latestLoginIP;
  }
  /**
   * 最后登录IP setter
   * @param latestLoginIP
   */  
  public void setLatestLoginIP(String latestLoginIP){
    this.latestLoginIP = latestLoginIP;
  }
 
  /**
   * 最后登录时间 getter
   */
  public java.time.LocalDateTime getLatestLoginTime(){
    return latestLoginTime;
  }
  /**
   * 最后登录时间 setter
   * @param latestLoginTime
   */  
  public void setLatestLoginTime(java.time.LocalDateTime latestLoginTime){
    this.latestLoginTime = latestLoginTime;
  }
 
  /**
   * 最后修改时间 getter
   */
  public java.time.LocalDateTime getLatestModifyTime(){
    return latestModifyTime;
  }
  /**
   * 最后修改时间 setter
   * @param latestModifyTime
   */  
  public void setLatestModifyTime(java.time.LocalDateTime latestModifyTime){
    this.latestModifyTime = latestModifyTime;
  }
 
  /**
   * 登录编号 getter
   */
  public Long getLoginID(){
    return loginID;
  }
  /**
   * 登录编号 setter
   * @param loginID
   */  
  public void setLoginID(Long loginID){
    this.loginID = loginID;
  }
 
  /**
   * 登录名 getter
   */
  public String getLoginName(){
    return loginName;
  }
  /**
   * 登录名 setter
   * @param loginName
   */  
  public void setLoginName(String loginName){
    this.loginName = loginName;
  }
 
  /**
   * 密码 getter
   */
  public String getLoginPassword(){
    return loginPassword;
  }
  /**
   * 密码 setter
   * @param loginPassword
   */  
  public void setLoginPassword(String loginPassword){
    this.loginPassword = loginPassword;
  }
 
  /**
   * 登录名状态 getter
   */
  public Long getLoginStatus(){
    return loginStatus;
  }
  /**
   * 登录名状态 setter
   * @param loginStatus
   */  
  public void setLoginStatus(Long loginStatus){
    this.loginStatus = loginStatus;
  }
 
  /**
   * LogoUrl getter
   */
  public String getLogoUrl(){
    return logoUrl;
  }
  /**
   * LogoUrl setter
   * @param logoUrl
   */  
  public void setLogoUrl(String logoUrl){
    this.logoUrl = logoUrl;
  }
 
  /**
   * 备注 getter
   */
  public String getMemo(){
    return memo;
  }
  /**
   * 备注 setter
   * @param memo
   */  
  public void setMemo(String memo){
    this.memo = memo;
  }
 
  /**
   * 昵称 getter
   */
  public String getNickName(){
    return nickName;
  }
  /**
   * 昵称 setter
   * @param nickName
   */  
  public void setNickName(String nickName){
    this.nickName = nickName;
  }
 
  /**
   * 个性签名 getter
   */
  public String getSignature(){
    return signature;
  }
  /**
   * 个性签名 setter
   * @param signature
   */  
  public void setSignature(String signature){
    this.signature = signature;
  }
 
  /**
   * SyncTime getter
   */
  public java.time.LocalDateTime getSyncTime(){
    return syncTime;
  }
  /**
   * SyncTime setter
   * @param syncTime
   */  
  public void setSyncTime(java.time.LocalDateTime syncTime){
    this.syncTime = syncTime;
  }
 
  /**
   * SyncTimeResult getter
   */
  public java.time.LocalDateTime getSyncTimeResult(){
    return syncTimeResult;
  }
  /**
   * SyncTimeResult setter
   * @param syncTimeResult
   */  
  public void setSyncTimeResult(java.time.LocalDateTime syncTimeResult){
    this.syncTimeResult = syncTimeResult;
  }
 
  /**
   * 第三方类别 getter
   */
  public Long getThirdType(){
    return thirdType;
  }
  /**
   * 第三方类别 setter
   * @param thirdType
   */  
  public void setThirdType(Long thirdType){
    this.thirdType = thirdType;
  }
 
  /**
   * 历史登录次数 getter
   */
  public Integer getTotalLoginNumber(){
    return totalLoginNumber;
  }
  /**
   * 历史登录次数 setter
   * @param totalLoginNumber
   */  
  public void setTotalLoginNumber(Integer totalLoginNumber){
    this.totalLoginNumber = totalLoginNumber;
  }
 
}