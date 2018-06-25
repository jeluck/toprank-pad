package cc.toprank.byd.entity;



/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在F_MemberCardRequestInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class F_MemberCardRequestInfoEntityBase  extends Entity{

  /**
   *	ApproveDesc数据库列名
   */
  public final static java.lang.String APPROVEDESC_FIELD =  "ApproveDesc";

  /**
   *	ApproveDesc字段中文名，用于视图展示
   */
  public final static java.lang.String APPROVEDESC_LABLE = "审批意见";

  /**
   *	ApproveDesc对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String approveDesc;

  /**
   *	Approver数据库列名
   */
  public final static java.lang.String APPROVER_FIELD =  "Approver";

  /**
   *	Approver字段中文名，用于视图展示
   */
  public final static java.lang.String APPROVER_LABLE = "审批人";

  /**
   *	Approver对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long approver;

  /**
   *	ApproveTime数据库列名
   */
  public final static java.lang.String APPROVETIME_FIELD =  "ApproveTime";

  /**
   *	ApproveTime字段中文名，用于视图展示
   */
  public final static java.lang.String APPROVETIME_LABLE = "审批时间";

  /**
   *	ApproveTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime approveTime;

  /**
   *	ArchiveID数据库列名
   */
  public final static java.lang.String ARCHIVEID_FIELD =  "ArchiveID";

  /**
   *	ArchiveID字段中文名，用于视图展示
   */
  public final static java.lang.String ARCHIVEID_LABLE = "档案编号";

  /**
   *	ArchiveID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long archiveID;

  /**
   *	BranchName数据库列名
   */
  public final static java.lang.String BRANCHNAME_FIELD =  "BranchName";

  /**
   *	BranchName字段中文名，用于视图展示
   */
  public final static java.lang.String BRANCHNAME_LABLE = "网点名称";

  /**
   *	BranchName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String branchName;

  /**
   *	CardID数据库列名
   */
  public final static java.lang.String CARDID_FIELD =  "CardID";

  /**
   *	CardID字段中文名，用于视图展示
   */
  public final static java.lang.String CARDID_LABLE = "卡编号";

  /**
   *	CardID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long cardID;

  /**
   *	CardNo数据库列名
   */
  public final static java.lang.String CARDNO_FIELD =  "CardNo";

  /**
   *	CardNo字段中文名，用于视图展示
   */
  public final static java.lang.String CARDNO_LABLE = "卡号";

  /**
   *	CardNo对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String cardNo;

  /**
   *	Counterman数据库列名
   */
  public final static java.lang.String COUNTERMAN_FIELD =  "Counterman";

  /**
   *	Counterman字段中文名，用于视图展示
   */
  public final static java.lang.String COUNTERMAN_LABLE = "业务员";

  /**
   *	Counterman对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String counterman;

  /**
   *	CountermanID数据库列名
   */
  public final static java.lang.String COUNTERMANID_FIELD =  "CountermanID";

  /**
   *	CountermanID字段中文名，用于视图展示
   */
  public final static java.lang.String COUNTERMANID_LABLE = "业务员编号";

  /**
   *	CountermanID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long countermanID;

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
   *	MemberMobile数据库列名
   */
  public final static java.lang.String MEMBERMOBILE_FIELD =  "MemberMobile";

  /**
   *	MemberMobile字段中文名，用于视图展示
   */
  public final static java.lang.String MEMBERMOBILE_LABLE = "会员手机";

  /**
   *	MemberMobile对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String memberMobile;

  /**
   *	MemberName数据库列名
   */
  public final static java.lang.String MEMBERNAME_FIELD =  "MemberName";

  /**
   *	MemberName字段中文名，用于视图展示
   */
  public final static java.lang.String MEMBERNAME_LABLE = "会员姓名";

  /**
   *	MemberName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String memberName;

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
   *	RequestCode数据库列名
   */
  public final static java.lang.String REQUESTCODE_FIELD =  "RequestCode";

  /**
   *	RequestCode字段中文名，用于视图展示
   */
  public final static java.lang.String REQUESTCODE_LABLE = "申请编码";

  /**
   *	RequestCode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String requestCode;

  /**
   *	RequestDesc数据库列名
   */
  public final static java.lang.String REQUESTDESC_FIELD =  "RequestDesc";

  /**
   *	RequestDesc字段中文名，用于视图展示
   */
  public final static java.lang.String REQUESTDESC_LABLE = "申请描述";

  /**
   *	RequestDesc对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String requestDesc;

  /**
   *	RequestID数据库列名
   */
  public final static java.lang.String REQUESTID_FIELD =  "RequestID";

  /**
   *	RequestID字段中文名，用于视图展示
   */
  public final static java.lang.String REQUESTID_LABLE = "申请编号";

  /**
   *	RequestID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long requestID;

  /**
   *	RequestStatus数据库列名
   */
  public final static java.lang.String REQUESTSTATUS_FIELD =  "RequestStatus";

  /**
   *	RequestStatus字段中文名，用于视图展示
   */
  public final static java.lang.String REQUESTSTATUS_LABLE = "申请状态";

  /**
   *	RequestStatus对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long requestStatus;

  /**
   * 审批意见 getter
   */
  public java.lang.String getApproveDesc(){
    return approveDesc;
  }
  /**
   * 审批意见 setter
   * @param ApproveDesc
   */
  public void setApproveDesc(java.lang.String approveDesc){
    this.approveDesc = approveDesc;
  }

  /**
   * 审批人 getter
   */
  public java.lang.Long getApprover(){
    return approver;
  }
  /**
   * 审批人 setter
   * @param Approver
   */
  public void setApprover(java.lang.Long approver){
    this.approver = approver;
  }

  /**
   * 审批时间 getter
   */
  public java.time.LocalDateTime getApproveTime(){
    return approveTime;
  }
  /**
   * 审批时间 setter
   * @param ApproveTime
   */
  public void setApproveTime(java.time.LocalDateTime approveTime){
    this.approveTime = approveTime;
  }

  /**
   * 档案编号 getter
   */
  public java.lang.Long getArchiveID(){
    return archiveID;
  }
  /**
   * 档案编号 setter
   * @param ArchiveID
   */
  public void setArchiveID(java.lang.Long archiveID){
    this.archiveID = archiveID;
  }

  /**
   * 网点名称 getter
   */
  public java.lang.String getBranchName(){
    return branchName;
  }
  /**
   * 网点名称 setter
   * @param BranchName
   */
  public void setBranchName(java.lang.String branchName){
    this.branchName = branchName;
  }

  /**
   * 卡编号 getter
   */
  public java.lang.Long getCardID(){
    return cardID;
  }
  /**
   * 卡编号 setter
   * @param CardID
   */
  public void setCardID(java.lang.Long cardID){
    this.cardID = cardID;
  }

  /**
   * 卡号 getter
   */
  public java.lang.String getCardNo(){
    return cardNo;
  }
  /**
   * 卡号 setter
   * @param CardNo
   */
  public void setCardNo(java.lang.String cardNo){
    this.cardNo = cardNo;
  }

  /**
   * 业务员 getter
   */
  public java.lang.String getCounterman(){
    return counterman;
  }
  /**
   * 业务员 setter
   * @param Counterman
   */
  public void setCounterman(java.lang.String counterman){
    this.counterman = counterman;
  }

  /**
   * 业务员编号 getter
   */
  public java.lang.Long getCountermanID(){
    return countermanID;
  }
  /**
   * 业务员编号 setter
   * @param CountermanID
   */
  public void setCountermanID(java.lang.Long countermanID){
    this.countermanID = countermanID;
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
   * 会员手机 getter
   */
  public java.lang.String getMemberMobile(){
    return memberMobile;
  }
  /**
   * 会员手机 setter
   * @param MemberMobile
   */
  public void setMemberMobile(java.lang.String memberMobile){
    this.memberMobile = memberMobile;
  }

  /**
   * 会员姓名 getter
   */
  public java.lang.String getMemberName(){
    return memberName;
  }
  /**
   * 会员姓名 setter
   * @param MemberName
   */
  public void setMemberName(java.lang.String memberName){
    this.memberName = memberName;
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
   * 申请编码 getter
   */
  public java.lang.String getRequestCode(){
    return requestCode;
  }
  /**
   * 申请编码 setter
   * @param RequestCode
   */
  public void setRequestCode(java.lang.String requestCode){
    this.requestCode = requestCode;
  }

  /**
   * 申请描述 getter
   */
  public java.lang.String getRequestDesc(){
    return requestDesc;
  }
  /**
   * 申请描述 setter
   * @param RequestDesc
   */
  public void setRequestDesc(java.lang.String requestDesc){
    this.requestDesc = requestDesc;
  }

  /**
   * 申请编号 getter
   */
  public java.lang.Long getRequestID(){
    return requestID;
  }
  /**
   * 申请编号 setter
   * @param RequestID
   */
  public void setRequestID(java.lang.Long requestID){
    this.requestID = requestID;
  }

  /**
   * 申请状态 getter
   */
  public java.lang.Long getRequestStatus(){
    return requestStatus;
  }
  /**
   * 申请状态 setter
   * @param RequestStatus
   */
  public void setRequestStatus(java.lang.Long requestStatus){
    this.requestStatus = requestStatus;
  }

}