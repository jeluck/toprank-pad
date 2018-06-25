package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 *
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在B_StallWeighSettingInfo类中进行修改
 *
 * ********************************************************************************************************************/
public class B_StallWeighSettingInfoEntityBase extends Entity {

  /**
   *	AlreadyColor数据库列名
   */
  public final static String ALREADYCOLOR_FIELD =  "AlreadyColor";

  /**
   *	AlreadyColor字段中文名，用于视图展示
   */
  public final static String ALREADYCOLOR_LABLE = "已称颜色";

  /**
   *	AlreadyColor对应的java字段名,业务操作使用这个字段。
   */
  private String alreadyColor;

  /**
   *	ArchiveID数据库列名
   */
  public final static String ARCHIVEID_FIELD =  "ArchiveID";

  /**
   *	ArchiveID字段中文名，用于视图展示
   */
  public final static String ARCHIVEID_LABLE = "档案编号";

  /**
   *	ArchiveID对应的java字段名,业务操作使用这个字段。
   */
  private Long archiveID;

  /**
   *	COMPort数据库列名
   */
  public final static String COMPORT_FIELD =  "COMPort";

  /**
   *	COMPort字段中文名，用于视图展示
   */
  public final static String COMPORT_LABLE = "电子秤端口";

  /**
   *	COMPort对应的java字段名,业务操作使用这个字段。
   */
  private Long cOMPort;

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
   *	CreatorID数据库列名
   */
  public final static String CREATORID_FIELD =  "CreatorID";

  /**
   *	CreatorID字段中文名，用于视图展示
   */
  public final static String CREATORID_LABLE = "创建人";

  /**
   *	CreatorID对应的java字段名,业务操作使用这个字段。
   */
  private Long creatorID;

  /**
   *	DiffRate数据库列名
   */
  public final static String DIFFRATE_FIELD =  "DiffRate";

  /**
   *	DiffRate字段中文名，用于视图展示
   */
  public final static String DIFFRATE_LABLE = "差异比例";

  /**
   *	DiffRate对应的java字段名,业务操作使用这个字段。
   */
  private Integer diffRate;

  /**
   *	FirstLetter数据库列名
   */
  public final static String FIRSTLETTER_FIELD =  "FirstLetter";

  /**
   *	FirstLetter字段中文名，用于视图展示
   */
  public final static String FIRSTLETTER_LABLE = "首拼";

  /**
   *	FirstLetter对应的java字段名,业务操作使用这个字段。
   */
  private String firstLetter;

  /**
   *	HandleColor数据库列名
   */
  public final static String HANDLECOLOR_FIELD =  "HandleColor";

  /**
   *	HandleColor字段中文名，用于视图展示
   */
  public final static String HANDLECOLOR_LABLE = "处理颜色";

  /**
   *	HandleColor对应的java字段名,业务操作使用这个字段。
   */
  private String handleColor;

  /**
   *	IsSync数据库列名
   */
  public final static String ISSYNC_FIELD =  "IsSync";

  /**
   *	IsSync字段中文名，用于视图展示
   */
  public final static String ISSYNC_LABLE = "是否同步";

  /**
   *	IsSync对应的java字段名,业务操作使用这个字段。
   */
  private Boolean isSync;

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
   *	NeedConfirm数据库列名
   */
  public final static String NEEDCONFIRM_FIELD =  "NeedConfirm";

  /**
   *	NeedConfirm字段中文名，用于视图展示
   */
  public final static String NEEDCONFIRM_LABLE = "需要确认";

  /**
   *	NeedConfirm对应的java字段名,业务操作使用这个字段。
   */
  private Boolean needConfirm;

  /**
   *	SortNo数据库列名
   */
  public final static String SORTNO_FIELD =  "SortNo";

  /**
   *	SortNo字段中文名，用于视图展示
   */
  public final static String SORTNO_LABLE = "序号";

  /**
   *	SortNo对应的java字段名,业务操作使用这个字段。
   */
  private Integer sortNo;

  /**
   *	StallCode数据库列名
   */
  public final static String STALLCODE_FIELD =  "StallCode";

  /**
   *	StallCode字段中文名，用于视图展示
   */
  public final static String STALLCODE_LABLE = "档口编码";

  /**
   *	StallCode对应的java字段名,业务操作使用这个字段。
   */
  private String stallCode;

  /**
   *	StallDesc数据库列名
   */
  public final static String STALLDESC_FIELD =  "StallDesc";

  /**
   *	StallDesc字段中文名，用于视图展示
   */
  public final static String STALLDESC_LABLE = "档口说明";

  /**
   *	StallDesc对应的java字段名,业务操作使用这个字段。
   */
  private String stallDesc;

  /**
   *	StallID数据库列名
   */
  public final static String STALLID_FIELD =  "StallID";

  /**
   *	StallID字段中文名，用于视图展示
   */
  public final static String STALLID_LABLE = "档口编号";

  /**
   *	StallID对应的java字段名,业务操作使用这个字段。
   */
  private Long stallID;

  /**
   *	StallName数据库列名
   */
  public final static String STALLNAME_FIELD =  "StallName";

  /**
   *	StallName字段中文名，用于视图展示
   */
  public final static String STALLNAME_LABLE = "档口名称";

  /**
   *	StallName对应的java字段名,业务操作使用这个字段。
   */
  private String stallName;

  /**
   *	StallStatus数据库列名
   */
  public final static String STALLSTATUS_FIELD =  "StallStatus";

  /**
   *	StallStatus字段中文名，用于视图展示
   */
  public final static String STALLSTATUS_LABLE = "配置状态";

  /**
   *	StallStatus对应的java字段名,业务操作使用这个字段。
   */
  private Long stallStatus;

  /**
   *	UnitID数据库列名
   */
  public final static String UNITID_FIELD =  "UnitID";

  /**
   *	UnitID字段中文名，用于视图展示
   */
  public final static String UNITID_LABLE = "单位";

  /**
   *	UnitID对应的java字段名,业务操作使用这个字段。
   */
  private Long unitID;

  /**
   *	WaitColor数据库列名
   */
  public final static String WAITCOLOR_FIELD =  "WaitColor";

  /**
   *	WaitColor字段中文名，用于视图展示
   */
  public final static String WAITCOLOR_LABLE = "待称颜色";

  /**
   *	WaitColor对应的java字段名,业务操作使用这个字段。
   */
  private String waitColor;

  /**
   *	WeightType数据库列名
   */
  public final static String WEIGHTTYPE_FIELD =  "WeightType";

  /**
   *	WeightType字段中文名，用于视图展示
   */
  public final static String WEIGHTTYPE_LABLE = "称重方式";

  /**
   *	WeightType对应的java字段名,业务操作使用这个字段。
   */
  private Long weightType;

  /**
   * 已称颜色 getter
   */
  public String getAlreadyColor(){
    return alreadyColor;
  }
  /**
   * 已称颜色 setter
   * @param AlreadyColor
   */
  public void setAlreadyColor(String alreadyColor){
    this.alreadyColor = alreadyColor;
  }

  /**
   * 档案编号 getter
   */
  public Long getArchiveID(){
    return archiveID;
  }
  /**
   * 档案编号 setter
   * @param ArchiveID
   */
  public void setArchiveID(Long archiveID){
    this.archiveID = archiveID;
  }

  /**
   * 电子秤端口 getter
   */
  public Long getCOMPort(){
    return cOMPort;
  }
  /**
   * 电子秤端口 setter
   * @param COMPort
   */
  public void setCOMPort(Long cOMPort){
    this.cOMPort = cOMPort;
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
  public Long getCreatorID(){
    return creatorID;
  }
  /**
   * 创建人 setter
   * @param CreatorID
   */
  public void setCreatorID(Long creatorID){
    this.creatorID = creatorID;
  }

  /**
   * 差异比例 getter
   */
  public Integer getDiffRate(){
    return diffRate;
  }
  /**
   * 差异比例 setter
   * @param DiffRate
   */
  public void setDiffRate(Integer diffRate){
    this.diffRate = diffRate;
  }

  /**
   * 首拼 getter
   */
  public String getFirstLetter(){
    return firstLetter;
  }
  /**
   * 首拼 setter
   * @param FirstLetter
   */
  public void setFirstLetter(String firstLetter){
    this.firstLetter = firstLetter;
  }

  /**
   * 处理颜色 getter
   */
  public String getHandleColor(){
    return handleColor;
  }
  /**
   * 处理颜色 setter
   * @param HandleColor
   */
  public void setHandleColor(String handleColor){
    this.handleColor = handleColor;
  }

  /**
   * 是否同步 getter
   */
  public Boolean getIsSync(){
    return isSync;
  }
  /**
   * 是否同步 setter
   * @param IsSync
   */
  public void setIsSync(Boolean isSync){
    this.isSync = isSync;
  }

  /**
   * 备注 getter
   */
  public String getMemo(){
    return memo;
  }
  /**
   * 备注 setter
   * @param Memo
   */
  public void setMemo(String memo){
    this.memo = memo;
  }

  /**
   * 需要确认 getter
   */
  public Boolean getNeedConfirm(){
    return needConfirm;
  }
  /**
   * 需要确认 setter
   * @param NeedConfirm
   */
  public void setNeedConfirm(Boolean needConfirm){
    this.needConfirm = needConfirm;
  }

  /**
   * 序号 getter
   */
  public Integer getSortNo(){
    return sortNo;
  }
  /**
   * 序号 setter
   * @param SortNo
   */
  public void setSortNo(Integer sortNo){
    this.sortNo = sortNo;
  }

  /**
   * 档口编码 getter
   */
  public String getStallCode(){
    return stallCode;
  }
  /**
   * 档口编码 setter
   * @param StallCode
   */
  public void setStallCode(String stallCode){
    this.stallCode = stallCode;
  }

  /**
   * 档口说明 getter
   */
  public String getStallDesc(){
    return stallDesc;
  }
  /**
   * 档口说明 setter
   * @param StallDesc
   */
  public void setStallDesc(String stallDesc){
    this.stallDesc = stallDesc;
  }

  /**
   * 档口编号 getter
   */
  public Long getStallID(){
    return stallID;
  }
  /**
   * 档口编号 setter
   * @param StallID
   */
  public void setStallID(Long stallID){
    this.stallID = stallID;
  }

  /**
   * 档口名称 getter
   */
  public String getStallName(){
    return stallName;
  }
  /**
   * 档口名称 setter
   * @param StallName
   */
  public void setStallName(String stallName){
    this.stallName = stallName;
  }

  /**
   * 配置状态 getter
   */
  public Long getStallStatus(){
    return stallStatus;
  }
  /**
   * 配置状态 setter
   * @param StallStatus
   */
  public void setStallStatus(Long stallStatus){
    this.stallStatus = stallStatus;
  }

  /**
   * 单位 getter
   */
  public Long getUnitID(){
    return unitID;
  }
  /**
   * 单位 setter
   * @param UnitID
   */
  public void setUnitID(Long unitID){
    this.unitID = unitID;
  }

  /**
   * 待称颜色 getter
   */
  public String getWaitColor(){
    return waitColor;
  }
  /**
   * 待称颜色 setter
   * @param WaitColor
   */
  public void setWaitColor(String waitColor){
    this.waitColor = waitColor;
  }

  /**
   * 称重方式 getter
   */
  public Long getWeightType(){
    return weightType;
  }
  /**
   * 称重方式 setter
   * @param WeightType
   */
  public void setWeightType(Long weightType){
    this.weightType = weightType;
  }

}