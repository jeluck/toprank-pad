package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在U_LoginInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class U_LoginInfoEntityBase extends Entity {

  /**
   *	CertificateCode数据库列名
   */
  public final static java.lang.String CERTIFICATECODE_FIELD =  "CertificateCode";
  
  /**
   *	CertificateCode字段中文名，用于视图展示
   */
  public final static java.lang.String CERTIFICATECODE_LABLE = "证书";
  
  /**
   *	CertificateCode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String certificateCode;
  
  /**
   *	CreateTime数据库列名
   */
  public final static java.lang.String CREATETIME_FIELD =  "CreateTime";
  
  /**
   *	CreateTime字段中文名，用于视图展示
   */
  public final static java.lang.String CREATETIME_LABLE = "创建时间";
  
  /**
   *	CreateTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime createTime;
  
  /**
   *	CreatorID数据库列名
   */
  public final static java.lang.String CREATORID_FIELD =  "CreatorID";
  
  /**
   *	CreatorID字段中文名，用于视图展示
   */
  public final static java.lang.String CREATORID_LABLE = "创建人";
  
  /**
   *	CreatorID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long creatorID;
  
  /**
   *	EffectiveTime数据库列名
   */
  public final static java.lang.String EFFECTIVETIME_FIELD =  "EffectiveTime";
  
  /**
   *	EffectiveTime字段中文名，用于视图展示
   */
  public final static java.lang.String EFFECTIVETIME_LABLE = "密码生效时间";
  
  /**
   *	EffectiveTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime effectiveTime;
  
  /**
   *	EmployeeCode数据库列名
   */
  public final static java.lang.String EMPLOYEECODE_FIELD =  "EmployeeCode";
  
  /**
   *	EmployeeCode字段中文名，用于视图展示
   */
  public final static java.lang.String EMPLOYEECODE_LABLE = "工号";
  
  /**
   *	EmployeeCode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String employeeCode;
  
  /**
   *	ExpireTime数据库列名
   */
  public final static java.lang.String EXPIRETIME_FIELD =  "ExpireTime";
  
  /**
   *	ExpireTime字段中文名，用于视图展示
   */
  public final static java.lang.String EXPIRETIME_LABLE = "密码失效时间";
  
  /**
   *	ExpireTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime expireTime;
  
  /**
   *	FailedPasswordAttemptCount数据库列名
   */
  public final static java.lang.String FAILEDPASSWORDATTEMPTCOUNT_FIELD =  "FailedPasswordAttemptCount";
  
  /**
   *	FailedPasswordAttemptCount字段中文名，用于视图展示
   */
  public final static java.lang.String FAILEDPASSWORDATTEMPTCOUNT_LABLE = "密码重试次数";
  
  /**
   *	FailedPasswordAttemptCount对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer failedPasswordAttemptCount;
  
  /**
   *	IsForceChange数据库列名
   */
  public final static java.lang.String ISFORCECHANGE_FIELD =  "IsForceChange";
  
  /**
   *	IsForceChange字段中文名，用于视图展示
   */
  public final static java.lang.String ISFORCECHANGE_LABLE = "是否强制更改密码";
  
  /**
   *	IsForceChange对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean isForceChange;
  
  /**
   *	IsSync数据库列名
   */
  public final static java.lang.String ISSYNC_FIELD =  "IsSync";
  
  /**
   *	IsSync字段中文名，用于视图展示
   */
  public final static java.lang.String ISSYNC_LABLE = "是否同步";
  
  /**
   *	IsSync对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean isSync;
  
  /**
   *	IsValid数据库列名
   */
  public final static java.lang.String ISVALID_FIELD =  "IsValid";
  
  /**
   *	IsValid字段中文名，用于视图展示
   */
  public final static java.lang.String ISVALID_LABLE = "有效性标志";
  
  /**
   *	IsValid对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean isValid;
  
  /**
   *	LatestFailedLoginTime数据库列名
   */
  public final static java.lang.String LATESTFAILEDLOGINTIME_FIELD =  "LatestFailedLoginTime";
  
  /**
   *	LatestFailedLoginTime字段中文名，用于视图展示
   */
  public final static java.lang.String LATESTFAILEDLOGINTIME_LABLE = "上次登录失败时间";
  
  /**
   *	LatestFailedLoginTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime latestFailedLoginTime;
  
  /**
   *	LatestLoginArea数据库列名
   */
  public final static java.lang.String LATESTLOGINAREA_FIELD =  "LatestLoginArea";
  
  /**
   *	LatestLoginArea字段中文名，用于视图展示
   */
  public final static java.lang.String LATESTLOGINAREA_LABLE = "最后登录地区";
  
  /**
   *	LatestLoginArea对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String latestLoginArea;
  
  /**
   *	LatestLoginIP数据库列名
   */
  public final static java.lang.String LATESTLOGINIP_FIELD =  "LatestLoginIP";
  
  /**
   *	LatestLoginIP字段中文名，用于视图展示
   */
  public final static java.lang.String LATESTLOGINIP_LABLE = "最后登录IP";
  
  /**
   *	LatestLoginIP对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String latestLoginIP;
  
  /**
   *	LatestLoginTime数据库列名
   */
  public final static java.lang.String LATESTLOGINTIME_FIELD =  "LatestLoginTime";
  
  /**
   *	LatestLoginTime字段中文名，用于视图展示
   */
  public final static java.lang.String LATESTLOGINTIME_LABLE = "最后登录时间";
  
  /**
   *	LatestLoginTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime latestLoginTime;
  
  /**
   *	LatestPasswordChangeTime数据库列名
   */
  public final static java.lang.String LATESTPASSWORDCHANGETIME_FIELD =  "LatestPasswordChangeTime";
  
  /**
   *	LatestPasswordChangeTime字段中文名，用于视图展示
   */
  public final static java.lang.String LATESTPASSWORDCHANGETIME_LABLE = "最后修改时间";
  
  /**
   *	LatestPasswordChangeTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime latestPasswordChangeTime;
  
  /**
   *	LoginID数据库列名
   */
  public final static java.lang.String LOGINID_FIELD =  "LoginID";
  
  /**
   *	LoginID字段中文名，用于视图展示
   */
  public final static java.lang.String LOGINID_LABLE = "登录编号";
  
  /**
   *	LoginID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long loginID;
  
  /**
   *	LoginName数据库列名
   */
  public final static java.lang.String LOGINNAME_FIELD =  "LoginName";
  
  /**
   *	LoginName字段中文名，用于视图展示
   */
  public final static java.lang.String LOGINNAME_LABLE = "登录名";
  
  /**
   *	LoginName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String loginName;
  
  /**
   *	LoginPassword数据库列名
   */
  public final static java.lang.String LOGINPASSWORD_FIELD =  "LoginPassword";
  
  /**
   *	LoginPassword字段中文名，用于视图展示
   */
  public final static java.lang.String LOGINPASSWORD_LABLE = "登录密码";
  
  /**
   *	LoginPassword对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String loginPassword;
  
  /**
   *	LoginStatus数据库列名
   */
  public final static java.lang.String LOGINSTATUS_FIELD =  "LoginStatus";
  
  /**
   *	LoginStatus字段中文名，用于视图展示
   */
  public final static java.lang.String LOGINSTATUS_LABLE = "状态";
  
  /**
   *	LoginStatus对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long loginStatus;
  
  /**
   *	Memo数据库列名
   */
  public final static java.lang.String MEMO_FIELD =  "Memo";
  
  /**
   *	Memo字段中文名，用于视图展示
   */
  public final static java.lang.String MEMO_LABLE = "备注";
  
  /**
   *	Memo对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String memo;
  
  /**
   *	NickName数据库列名
   */
  public final static java.lang.String NICKNAME_FIELD =  "NickName";
  
  /**
   *	NickName字段中文名，用于视图展示
   */
  public final static java.lang.String NICKNAME_LABLE = "昵称";
  
  /**
   *	NickName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String nickName;
  
  /**
   *	OrgCode数据库列名
   */
  public final static java.lang.String ORGCODE_FIELD =  "OrgCode";
  
  /**
   *	OrgCode字段中文名，用于视图展示
   */
  public final static java.lang.String ORGCODE_LABLE = "机构编码";
  
  /**
   *	OrgCode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String orgCode;
  
  /**
   *	PasswordAnswer数据库列名
   */
  public final static java.lang.String PASSWORDANSWER_FIELD =  "PasswordAnswer";
  
  /**
   *	PasswordAnswer字段中文名，用于视图展示
   */
  public final static java.lang.String PASSWORDANSWER_LABLE = "密码遗失问题答案";
  
  /**
   *	PasswordAnswer对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String passwordAnswer;
  
  /**
   *	PasswordFormat数据库列名
   */
  public final static java.lang.String PASSWORDFORMAT_FIELD =  "PasswordFormat";
  
  /**
   *	PasswordFormat字段中文名，用于视图展示
   */
  public final static java.lang.String PASSWORDFORMAT_LABLE = "密码格式";
  
  /**
   *	PasswordFormat对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long passwordFormat;
  
  /**
   *	PasswordQuestion数据库列名
   */
  public final static java.lang.String PASSWORDQUESTION_FIELD =  "PasswordQuestion";
  
  /**
   *	PasswordQuestion字段中文名，用于视图展示
   */
  public final static java.lang.String PASSWORDQUESTION_LABLE = "密码遗失提示问题";
  
  /**
   *	PasswordQuestion对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String passwordQuestion;
  
  /**
   *	Signature数据库列名
   */
  public final static java.lang.String SIGNATURE_FIELD =  "Signature";
  
  /**
   *	Signature字段中文名，用于视图展示
   */
  public final static java.lang.String SIGNATURE_LABLE = "个性签名";
  
  /**
   *	Signature对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String signature;
  
  /**
   *	SortNo数据库列名
   */
  public final static java.lang.String SORTNO_FIELD =  "SortNo";
  
  /**
   *	SortNo字段中文名，用于视图展示
   */
  public final static java.lang.String SORTNO_LABLE = "序号";
  
  /**
   *	SortNo对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer sortNo;
  
  /**
   *	SyncTime数据库列名
   */
  public final static java.lang.String SYNCTIME_FIELD =  "SyncTime";
  
  /**
   *	SyncTime字段中文名，用于视图展示
   */
  public final static java.lang.String SYNCTIME_LABLE = "SyncTime";
  
  /**
   *	SyncTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime syncTime;
  
  /**
   *	SyncTimeResult数据库列名
   */
  public final static java.lang.String SYNCTIMERESULT_FIELD =  "SyncTimeResult";
  
  /**
   *	SyncTimeResult字段中文名，用于视图展示
   */
  public final static java.lang.String SYNCTIMERESULT_LABLE = "SyncTimeResult";
  
  /**
   *	SyncTimeResult对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime syncTimeResult;
  
  /**
   *	UserID数据库列名
   */
  public final static java.lang.String USERID_FIELD =  "UserID";
  
  /**
   *	UserID字段中文名，用于视图展示
   */
  public final static java.lang.String USERID_LABLE = "用户编号";
  
  /**
   *	UserID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long userID;
  
  /**
   * 证书 getter
   */
  public java.lang.String getCertificateCode(){
    return certificateCode;
  }
  /**
   * 证书 setter
   * @param CertificateCode
   */  
  public void setCertificateCode(java.lang.String certificateCode){
    this.certificateCode = certificateCode;
  }
 
  /**
   * 创建时间 getter
   */
  public java.time.LocalDateTime getCreateTime(){
    return createTime;
  }
  /**
   * 创建时间 setter
   * @param CreateTime
   */  
  public void setCreateTime(java.time.LocalDateTime createTime){
    this.createTime = createTime;
  }
 
  /**
   * 创建人 getter
   */
  public java.lang.Long getCreatorID(){
    return creatorID;
  }
  /**
   * 创建人 setter
   * @param CreatorID
   */  
  public void setCreatorID(java.lang.Long creatorID){
    this.creatorID = creatorID;
  }
 
  /**
   * 密码生效时间 getter
   */
  public java.time.LocalDateTime getEffectiveTime(){
    return effectiveTime;
  }
  /**
   * 密码生效时间 setter
   * @param EffectiveTime
   */  
  public void setEffectiveTime(java.time.LocalDateTime effectiveTime){
    this.effectiveTime = effectiveTime;
  }
 
  /**
   * 工号 getter
   */
  public java.lang.String getEmployeeCode(){
    return employeeCode;
  }
  /**
   * 工号 setter
   * @param EmployeeCode
   */  
  public void setEmployeeCode(java.lang.String employeeCode){
    this.employeeCode = employeeCode;
  }
 
  /**
   * 密码失效时间 getter
   */
  public java.time.LocalDateTime getExpireTime(){
    return expireTime;
  }
  /**
   * 密码失效时间 setter
   * @param ExpireTime
   */  
  public void setExpireTime(java.time.LocalDateTime expireTime){
    this.expireTime = expireTime;
  }
 
  /**
   * 密码重试次数 getter
   */
  public java.lang.Integer getFailedPasswordAttemptCount(){
    return failedPasswordAttemptCount;
  }
  /**
   * 密码重试次数 setter
   * @param FailedPasswordAttemptCount
   */  
  public void setFailedPasswordAttemptCount(java.lang.Integer failedPasswordAttemptCount){
    this.failedPasswordAttemptCount = failedPasswordAttemptCount;
  }
 
  /**
   * 是否强制更改密码 getter
   */
  public java.lang.Boolean getIsForceChange(){
    return isForceChange;
  }
  /**
   * 是否强制更改密码 setter
   * @param IsForceChange
   */  
  public void setIsForceChange(java.lang.Boolean isForceChange){
    this.isForceChange = isForceChange;
  }
 
  /**
   * 是否同步 getter
   */
  public java.lang.Boolean getIsSync(){
    return isSync;
  }
  /**
   * 是否同步 setter
   * @param IsSync
   */  
  public void setIsSync(java.lang.Boolean isSync){
    this.isSync = isSync;
  }
 
  /**
   * 有效性标志 getter
   */
  public java.lang.Boolean getIsValid(){
    return isValid;
  }
  /**
   * 有效性标志 setter
   * @param IsValid
   */  
  public void setIsValid(java.lang.Boolean isValid){
    this.isValid = isValid;
  }
 
  /**
   * 上次登录失败时间 getter
   */
  public java.time.LocalDateTime getLatestFailedLoginTime(){
    return latestFailedLoginTime;
  }
  /**
   * 上次登录失败时间 setter
   * @param LatestFailedLoginTime
   */  
  public void setLatestFailedLoginTime(java.time.LocalDateTime latestFailedLoginTime){
    this.latestFailedLoginTime = latestFailedLoginTime;
  }
 
  /**
   * 最后登录地区 getter
   */
  public java.lang.String getLatestLoginArea(){
    return latestLoginArea;
  }
  /**
   * 最后登录地区 setter
   * @param LatestLoginArea
   */  
  public void setLatestLoginArea(java.lang.String latestLoginArea){
    this.latestLoginArea = latestLoginArea;
  }
 
  /**
   * 最后登录IP getter
   */
  public java.lang.String getLatestLoginIP(){
    return latestLoginIP;
  }
  /**
   * 最后登录IP setter
   * @param LatestLoginIP
   */  
  public void setLatestLoginIP(java.lang.String latestLoginIP){
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
   * @param LatestLoginTime
   */  
  public void setLatestLoginTime(java.time.LocalDateTime latestLoginTime){
    this.latestLoginTime = latestLoginTime;
  }
 
  /**
   * 最后修改时间 getter
   */
  public java.time.LocalDateTime getLatestPasswordChangeTime(){
    return latestPasswordChangeTime;
  }
  /**
   * 最后修改时间 setter
   * @param LatestPasswordChangeTime
   */  
  public void setLatestPasswordChangeTime(java.time.LocalDateTime latestPasswordChangeTime){
    this.latestPasswordChangeTime = latestPasswordChangeTime;
  }
 
  /**
   * 登录编号 getter
   */
  public java.lang.Long getLoginID(){
    return loginID;
  }
  /**
   * 登录编号 setter
   * @param LoginID
   */  
  public void setLoginID(java.lang.Long loginID){
    this.loginID = loginID;
  }
 
  /**
   * 登录名 getter
   */
  public java.lang.String getLoginName(){
    return loginName;
  }
  /**
   * 登录名 setter
   * @param LoginName
   */  
  public void setLoginName(java.lang.String loginName){
    this.loginName = loginName;
  }
 
  /**
   * 登录密码 getter
   */
  public java.lang.String getLoginPassword(){
    return loginPassword;
  }
  /**
   * 登录密码 setter
   * @param LoginPassword
   */  
  public void setLoginPassword(java.lang.String loginPassword){
    this.loginPassword = loginPassword;
  }
 
  /**
   * 状态 getter
   */
  public java.lang.Long getLoginStatus(){
    return loginStatus;
  }
  /**
   * 状态 setter
   * @param LoginStatus
   */  
  public void setLoginStatus(java.lang.Long loginStatus){
    this.loginStatus = loginStatus;
  }
 
  /**
   * 备注 getter
   */
  public java.lang.String getMemo(){
    return memo;
  }
  /**
   * 备注 setter
   * @param Memo
   */  
  public void setMemo(java.lang.String memo){
    this.memo = memo;
  }
 
  /**
   * 昵称 getter
   */
  public java.lang.String getNickName(){
    return nickName;
  }
  /**
   * 昵称 setter
   * @param NickName
   */  
  public void setNickName(java.lang.String nickName){
    this.nickName = nickName;
  }
 
  /**
   * 机构编码 getter
   */
  public java.lang.String getOrgCode(){
    return orgCode;
  }
  /**
   * 机构编码 setter
   * @param OrgCode
   */  
  public void setOrgCode(java.lang.String orgCode){
    this.orgCode = orgCode;
  }
 
  /**
   * 密码遗失问题答案 getter
   */
  public java.lang.String getPasswordAnswer(){
    return passwordAnswer;
  }
  /**
   * 密码遗失问题答案 setter
   * @param PasswordAnswer
   */  
  public void setPasswordAnswer(java.lang.String passwordAnswer){
    this.passwordAnswer = passwordAnswer;
  }
 
  /**
   * 密码格式 getter
   */
  public java.lang.Long getPasswordFormat(){
    return passwordFormat;
  }
  /**
   * 密码格式 setter
   * @param PasswordFormat
   */  
  public void setPasswordFormat(java.lang.Long passwordFormat){
    this.passwordFormat = passwordFormat;
  }
 
  /**
   * 密码遗失提示问题 getter
   */
  public java.lang.String getPasswordQuestion(){
    return passwordQuestion;
  }
  /**
   * 密码遗失提示问题 setter
   * @param PasswordQuestion
   */  
  public void setPasswordQuestion(java.lang.String passwordQuestion){
    this.passwordQuestion = passwordQuestion;
  }
 
  /**
   * 个性签名 getter
   */
  public java.lang.String getSignature(){
    return signature;
  }
  /**
   * 个性签名 setter
   * @param Signature
   */  
  public void setSignature(java.lang.String signature){
    this.signature = signature;
  }
 
  /**
   * 序号 getter
   */
  public java.lang.Integer getSortNo(){
    return sortNo;
  }
  /**
   * 序号 setter
   * @param SortNo
   */  
  public void setSortNo(java.lang.Integer sortNo){
    this.sortNo = sortNo;
  }
 
  /**
   * SyncTime getter
   */
  public java.time.LocalDateTime getSyncTime(){
    return syncTime;
  }
  /**
   * SyncTime setter
   * @param SyncTime
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
   * @param SyncTimeResult
   */  
  public void setSyncTimeResult(java.time.LocalDateTime syncTimeResult){
    this.syncTimeResult = syncTimeResult;
  }
 
  /**
   * 用户编号 getter
   */
  public java.lang.Long getUserID(){
    return userID;
  }
  /**
   * 用户编号 setter
   * @param UserID
   */  
  public void setUserID(java.lang.Long userID){
    this.userID = userID;
  }
 
}