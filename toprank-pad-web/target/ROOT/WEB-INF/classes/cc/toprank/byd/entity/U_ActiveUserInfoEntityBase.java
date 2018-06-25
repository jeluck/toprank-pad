package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在U_ActiveUserInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class U_ActiveUserInfoEntityBase extends Entity {

  /**
   *	AppVer数据库列名
   */
  public final static java.lang.String APPVER_FIELD =  "AppVer";
  
  /**
   *	AppVer字段中文名，用于视图展示
   */
  public final static java.lang.String APPVER_LABLE = "应用版本";
  
  /**
   *	AppVer对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String appVer;
  
  /**
   *	HostName数据库列名
   */
  public final static java.lang.String HOSTNAME_FIELD =  "HostName";
  
  /**
   *	HostName字段中文名，用于视图展示
   */
  public final static java.lang.String HOSTNAME_LABLE = "机器名";
  
  /**
   *	HostName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String hostName;
  
  /**
   *	IMEI数据库列名
   */
  public final static java.lang.String IMEI_FIELD =  "IMEI";
  
  /**
   *	IMEI字段中文名，用于视图展示
   */
  public final static java.lang.String IMEI_LABLE = "设备号";
  
  /**
   *	IMEI对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String iMEI;
  
  /**
   *	IPAddress数据库列名
   */
  public final static java.lang.String IPADDRESS_FIELD =  "IPAddress";
  
  /**
   *	IPAddress字段中文名，用于视图展示
   */
  public final static java.lang.String IPADDRESS_LABLE = "IP地址";
  
  /**
   *	IPAddress对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime iPAddress;
  
  /**
   *	LogID数据库列名
   */
  public final static java.lang.String LOGID_FIELD =  "LogID";
  
  /**
   *	LogID字段中文名，用于视图展示
   */
  public final static java.lang.String LOGID_LABLE = "日志编号";
  
  /**
   *	LogID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long logID;
  
  /**
   *	LoginChannel数据库列名
   */
  public final static java.lang.String LOGINCHANNEL_FIELD =  "LoginChannel";
  
  /**
   *	LoginChannel字段中文名，用于视图展示
   */
  public final static java.lang.String LOGINCHANNEL_LABLE = "登录渠道";
  
  /**
   *	LoginChannel对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long loginChannel;
  
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
   *	LoginTime数据库列名
   */
  public final static java.lang.String LOGINTIME_FIELD =  "LoginTime";
  
  /**
   *	LoginTime字段中文名，用于视图展示
   */
  public final static java.lang.String LOGINTIME_LABLE = "登录时间";
  
  /**
   *	LoginTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime loginTime;
  
  /**
   *	MacAddress数据库列名
   */
  public final static java.lang.String MACADDRESS_FIELD =  "MacAddress";
  
  /**
   *	MacAddress字段中文名，用于视图展示
   */
  public final static java.lang.String MACADDRESS_LABLE = "设备地址";
  
  /**
   *	MacAddress对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String macAddress;
  
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
   *	Token数据库列名
   */
  public final static java.lang.String TOKEN_FIELD =  "Token";
  
  /**
   *	Token字段中文名，用于视图展示
   */
  public final static java.lang.String TOKEN_LABLE = "登录标识";
  
  /**
   *	Token对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String token;
  
  /**
   *	UserName数据库列名
   */
  public final static java.lang.String USERNAME_FIELD =  "UserName";
  
  /**
   *	UserName字段中文名，用于视图展示
   */
  public final static java.lang.String USERNAME_LABLE = "用户名";
  
  /**
   *	UserName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String userName;
  
  /**
   * 应用版本 getter
   */
  public java.lang.String getAppVer(){
    return appVer;
  }
  /**
   * 应用版本 setter
   * @param AppVer
   */  
  public void setAppVer(java.lang.String appVer){
    this.appVer = appVer;
  }
 
  /**
   * 机器名 getter
   */
  public java.lang.String getHostName(){
    return hostName;
  }
  /**
   * 机器名 setter
   * @param HostName
   */  
  public void setHostName(java.lang.String hostName){
    this.hostName = hostName;
  }
 
  /**
   * 设备号 getter
   */
  public java.lang.String getIMEI(){
    return iMEI;
  }
  /**
   * 设备号 setter
   * @param IMEI
   */  
  public void setIMEI(java.lang.String iMEI){
    this.iMEI = iMEI;
  }
 
  /**
   * IP地址 getter
   */
  public java.time.LocalDateTime getIPAddress(){
    return iPAddress;
  }
  /**
   * IP地址 setter
   * @param IPAddress
   */  
  public void setIPAddress(java.time.LocalDateTime iPAddress){
    this.iPAddress = iPAddress;
  }
 
  /**
   * 日志编号 getter
   */
  public java.lang.Long getLogID(){
    return logID;
  }
  /**
   * 日志编号 setter
   * @param LogID
   */  
  public void setLogID(java.lang.Long logID){
    this.logID = logID;
  }
 
  /**
   * 登录渠道 getter
   */
  public java.lang.Long getLoginChannel(){
    return loginChannel;
  }
  /**
   * 登录渠道 setter
   * @param LoginChannel
   */  
  public void setLoginChannel(java.lang.Long loginChannel){
    this.loginChannel = loginChannel;
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
   * 登录时间 getter
   */
  public java.time.LocalDateTime getLoginTime(){
    return loginTime;
  }
  /**
   * 登录时间 setter
   * @param LoginTime
   */  
  public void setLoginTime(java.time.LocalDateTime loginTime){
    this.loginTime = loginTime;
  }
 
  /**
   * 设备地址 getter
   */
  public java.lang.String getMacAddress(){
    return macAddress;
  }
  /**
   * 设备地址 setter
   * @param MacAddress
   */  
  public void setMacAddress(java.lang.String macAddress){
    this.macAddress = macAddress;
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
   * 登录标识 getter
   */
  public java.lang.String getToken(){
    return token;
  }
  /**
   * 登录标识 setter
   * @param Token
   */  
  public void setToken(java.lang.String token){
    this.token = token;
  }
 
  /**
   * 用户名 getter
   */
  public java.lang.String getUserName(){
    return userName;
  }
  /**
   * 用户名 setter
   * @param UserName
   */  
  public void setUserName(java.lang.String userName){
    this.userName = userName;
  }
 
}