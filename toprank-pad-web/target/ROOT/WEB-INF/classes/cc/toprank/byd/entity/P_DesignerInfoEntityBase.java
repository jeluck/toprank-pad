package cc.toprank.byd.entity;

/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在P_DesignerInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class P_DesignerInfoEntityBase  extends Entity{

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
   *	Birthday数据库列名
   */
  public final static String BIRTHDAY_FIELD =  "Birthday";
  
  /**
   *	Birthday字段中文名，用于视图展示
   */
  public final static String BIRTHDAY_LABLE = "出生日期";
  
  /**
   *	Birthday对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime birthday;
  
  /**
   *	ComapnyPostCode数据库列名
   */
  public final static String COMAPNYPOSTCODE_FIELD =  "ComapnyPostCode";
  
  /**
   *	ComapnyPostCode字段中文名，用于视图展示
   */
  public final static String COMAPNYPOSTCODE_LABLE = "办公邮编";
  
  /**
   *	ComapnyPostCode对应的java字段名,业务操作使用这个字段。
   */
  private String comapnyPostCode;
  
  /**
   *	CompanyAddress数据库列名
   */
  public final static String COMPANYADDRESS_FIELD =  "CompanyAddress";
  
  /**
   *	CompanyAddress字段中文名，用于视图展示
   */
  public final static String COMPANYADDRESS_LABLE = "办公地址";
  
  /**
   *	CompanyAddress对应的java字段名,业务操作使用这个字段。
   */
  private String companyAddress;
  
  /**
   *	CompanyPhone数据库列名
   */
  public final static String COMPANYPHONE_FIELD =  "CompanyPhone";
  
  /**
   *	CompanyPhone字段中文名，用于视图展示
   */
  public final static String COMPANYPHONE_LABLE = "办公电话";
  
  /**
   *	CompanyPhone对应的java字段名,业务操作使用这个字段。
   */
  private String companyPhone;
  
  /**
   *	CountryID数据库列名
   */
  public final static String COUNTRYID_FIELD =  "CountryID";
  
  /**
   *	CountryID字段中文名，用于视图展示
   */
  public final static String COUNTRYID_LABLE = "国家编号";
  
  /**
   *	CountryID对应的java字段名,业务操作使用这个字段。
   */
  private Long countryID;
  
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
   *	DesignerCode数据库列名
   */
  public final static String DESIGNERCODE_FIELD =  "DesignerCode";
  
  /**
   *	DesignerCode字段中文名，用于视图展示
   */
  public final static String DESIGNERCODE_LABLE = "设计师编码";
  
  /**
   *	DesignerCode对应的java字段名,业务操作使用这个字段。
   */
  private String designerCode;
  
  /**
   *	DesignerID数据库列名
   */
  public final static String DESIGNERID_FIELD =  "DesignerID";
  
  /**
   *	DesignerID字段中文名，用于视图展示
   */
  public final static String DESIGNERID_LABLE = "设计师编号";
  
  /**
   *	DesignerID对应的java字段名,业务操作使用这个字段。
   */
  private Long designerID;
  
  /**
   *	DesignerLevel数据库列名
   */
  public final static String DESIGNERLEVEL_FIELD =  "DesignerLevel";
  
  /**
   *	DesignerLevel字段中文名，用于视图展示
   */
  public final static String DESIGNERLEVEL_LABLE = "星级";
  
  /**
   *	DesignerLevel对应的java字段名,业务操作使用这个字段。
   */
  private Long designerLevel;
  
  /**
   *	DesignerName数据库列名
   */
  public final static String DESIGNERNAME_FIELD =  "DesignerName";
  
  /**
   *	DesignerName字段中文名，用于视图展示
   */
  public final static String DESIGNERNAME_LABLE = "设计师名称";
  
  /**
   *	DesignerName对应的java字段名,业务操作使用这个字段。
   */
  private String designerName;
  
  /**
   *	DesignerStatus数据库列名
   */
  public final static String DESIGNERSTATUS_FIELD =  "DesignerStatus";
  
  /**
   *	DesignerStatus字段中文名，用于视图展示
   */
  public final static String DESIGNERSTATUS_LABLE = "设计师状态";
  
  /**
   *	DesignerStatus对应的java字段名,业务操作使用这个字段。
   */
  private Long designerStatus;
  
  /**
   *	Email数据库列名
   */
  public final static String EMAIL_FIELD =  "Email";
  
  /**
   *	Email字段中文名，用于视图展示
   */
  public final static String EMAIL_LABLE = "电子邮箱";
  
  /**
   *	Email对应的java字段名,业务操作使用这个字段。
   */
  private String email;
  
  /**
   *	EmployeeCode数据库列名
   */
  public final static String EMPLOYEECODE_FIELD =  "EmployeeCode";
  
  /**
   *	EmployeeCode字段中文名，用于视图展示
   */
  public final static String EMPLOYEECODE_LABLE = "工号";
  
  /**
   *	EmployeeCode对应的java字段名,业务操作使用这个字段。
   */
  private String employeeCode;
  
  /**
   *	Expirence数据库列名
   */
  public final static String EXPIRENCE_FIELD =  "Expirence";
  
  /**
   *	Expirence字段中文名，用于视图展示
   */
  public final static String EXPIRENCE_LABLE = "从业经历";
  
  /**
   *	Expirence对应的java字段名,业务操作使用这个字段。
   */
  private String expirence;
  
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
   *	Gender数据库列名
   */
  public final static String GENDER_FIELD =  "Gender";
  
  /**
   *	Gender字段中文名，用于视图展示
   */
  public final static String GENDER_LABLE = "性别";
  
  /**
   *	Gender对应的java字段名,业务操作使用这个字段。
   */
  private Long gender;
  
  /**
   *	Intro数据库列名
   */
  public final static String INTRO_FIELD =  "Intro";
  
  /**
   *	Intro字段中文名，用于视图展示
   */
  public final static String INTRO_LABLE = "简介";
  
  /**
   *	Intro对应的java字段名,业务操作使用这个字段。
   */
  private String intro;
  
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
   *	MajorWorks数据库列名
   */
  public final static String MAJORWORKS_FIELD =  "MajorWorks";
  
  /**
   *	MajorWorks字段中文名，用于视图展示
   */
  public final static String MAJORWORKS_LABLE = "主要作品";
  
  /**
   *	MajorWorks对应的java字段名,业务操作使用这个字段。
   */
  private String majorWorks;
  
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
   *	Mobile数据库列名
   */
  public final static String MOBILE_FIELD =  "Mobile";
  
  /**
   *	Mobile字段中文名，用于视图展示
   */
  public final static String MOBILE_LABLE = "手机";
  
  /**
   *	Mobile对应的java字段名,业务操作使用这个字段。
   */
  private String mobile;
  
  /**
   *	Picture数据库列名
   */
  public final static String PICTURE_FIELD =  "Picture";
  
  /**
   *	Picture字段中文名，用于视图展示
   */
  public final static String PICTURE_LABLE = "照片";
  
  /**
   *	Picture对应的java字段名,业务操作使用这个字段。
   */
  private String picture;
  
  /**
   *	ProvinceID数据库列名
   */
  public final static String PROVINCEID_FIELD =  "ProvinceID";
  
  /**
   *	ProvinceID字段中文名，用于视图展示
   */
  public final static String PROVINCEID_LABLE = "省区编号";
  
  /**
   *	ProvinceID对应的java字段名,业务操作使用这个字段。
   */
  private Long provinceID;
  
  /**
   *	ResumeUrl数据库列名
   */
  public final static String RESUMEURL_FIELD =  "ResumeUrl";
  
  /**
   *	ResumeUrl字段中文名，用于视图展示
   */
  public final static String RESUMEURL_LABLE = "简历";
  
  /**
   *	ResumeUrl对应的java字段名,业务操作使用这个字段。
   */
  private String resumeUrl;
  
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
   *	WorkExperience数据库列名
   */
  public final static String WORKEXPERIENCE_FIELD =  "WorkExperience";
  
  /**
   *	WorkExperience字段中文名，用于视图展示
   */
  public final static String WORKEXPERIENCE_LABLE = "从业时间";
  
  /**
   *	WorkExperience对应的java字段名,业务操作使用这个字段。
   */
  private Float workExperience;
  
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
   * 出生日期 getter
   */
  public java.time.LocalDateTime getBirthday(){
    return birthday;
  }
  /**
   * 出生日期 setter
   * @param Birthday
   */  
  public void setBirthday(java.time.LocalDateTime birthday){
    this.birthday = birthday;
  }
 
  /**
   * 办公邮编 getter
   */
  public String getComapnyPostCode(){
    return comapnyPostCode;
  }
  /**
   * 办公邮编 setter
   * @param ComapnyPostCode
   */  
  public void setComapnyPostCode(String comapnyPostCode){
    this.comapnyPostCode = comapnyPostCode;
  }
 
  /**
   * 办公地址 getter
   */
  public String getCompanyAddress(){
    return companyAddress;
  }
  /**
   * 办公地址 setter
   * @param CompanyAddress
   */  
  public void setCompanyAddress(String companyAddress){
    this.companyAddress = companyAddress;
  }
 
  /**
   * 办公电话 getter
   */
  public String getCompanyPhone(){
    return companyPhone;
  }
  /**
   * 办公电话 setter
   * @param CompanyPhone
   */  
  public void setCompanyPhone(String companyPhone){
    this.companyPhone = companyPhone;
  }
 
  /**
   * 国家编号 getter
   */
  public Long getCountryID(){
    return countryID;
  }
  /**
   * 国家编号 setter
   * @param CountryID
   */  
  public void setCountryID(Long countryID){
    this.countryID = countryID;
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
   * 设计师编码 getter
   */
  public String getDesignerCode(){
    return designerCode;
  }
  /**
   * 设计师编码 setter
   * @param DesignerCode
   */  
  public void setDesignerCode(String designerCode){
    this.designerCode = designerCode;
  }
 
  /**
   * 设计师编号 getter
   */
  public Long getDesignerID(){
    return designerID;
  }
  /**
   * 设计师编号 setter
   * @param DesignerID
   */  
  public void setDesignerID(Long designerID){
    this.designerID = designerID;
  }
 
  /**
   * 星级 getter
   */
  public Long getDesignerLevel(){
    return designerLevel;
  }
  /**
   * 星级 setter
   * @param DesignerLevel
   */  
  public void setDesignerLevel(Long designerLevel){
    this.designerLevel = designerLevel;
  }
 
  /**
   * 设计师名称 getter
   */
  public String getDesignerName(){
    return designerName;
  }
  /**
   * 设计师名称 setter
   * @param DesignerName
   */  
  public void setDesignerName(String designerName){
    this.designerName = designerName;
  }
 
  /**
   * 设计师状态 getter
   */
  public Long getDesignerStatus(){
    return designerStatus;
  }
  /**
   * 设计师状态 setter
   * @param DesignerStatus
   */  
  public void setDesignerStatus(Long designerStatus){
    this.designerStatus = designerStatus;
  }
 
  /**
   * 电子邮箱 getter
   */
  public String getEmail(){
    return email;
  }
  /**
   * 电子邮箱 setter
   * @param Email
   */  
  public void setEmail(String email){
    this.email = email;
  }
 
  /**
   * 工号 getter
   */
  public String getEmployeeCode(){
    return employeeCode;
  }
  /**
   * 工号 setter
   * @param EmployeeCode
   */  
  public void setEmployeeCode(String employeeCode){
    this.employeeCode = employeeCode;
  }
 
  /**
   * 从业经历 getter
   */
  public String getExpirence(){
    return expirence;
  }
  /**
   * 从业经历 setter
   * @param Expirence
   */  
  public void setExpirence(String expirence){
    this.expirence = expirence;
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
   * 性别 getter
   */
  public Long getGender(){
    return gender;
  }
  /**
   * 性别 setter
   * @param Gender
   */  
  public void setGender(Long gender){
    this.gender = gender;
  }
 
  /**
   * 简介 getter
   */
  public String getIntro(){
    return intro;
  }
  /**
   * 简介 setter
   * @param Intro
   */  
  public void setIntro(String intro){
    this.intro = intro;
  }
 
  /**
   * 登录编号 getter
   */
  public Long getLoginID(){
    return loginID;
  }
  /**
   * 登录编号 setter
   * @param LoginID
   */  
  public void setLoginID(Long loginID){
    this.loginID = loginID;
  }
 
  /**
   * 主要作品 getter
   */
  public String getMajorWorks(){
    return majorWorks;
  }
  /**
   * 主要作品 setter
   * @param MajorWorks
   */  
  public void setMajorWorks(String majorWorks){
    this.majorWorks = majorWorks;
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
   * 手机 getter
   */
  public String getMobile(){
    return mobile;
  }
  /**
   * 手机 setter
   * @param Mobile
   */  
  public void setMobile(String mobile){
    this.mobile = mobile;
  }
 
  /**
   * 照片 getter
   */
  public String getPicture(){
    return picture;
  }
  /**
   * 照片 setter
   * @param Picture
   */  
  public void setPicture(String picture){
    this.picture = picture;
  }
 
  /**
   * 省区编号 getter
   */
  public Long getProvinceID(){
    return provinceID;
  }
  /**
   * 省区编号 setter
   * @param ProvinceID
   */  
  public void setProvinceID(Long provinceID){
    this.provinceID = provinceID;
  }
 
  /**
   * 简历 getter
   */
  public String getResumeUrl(){
    return resumeUrl;
  }
  /**
   * 简历 setter
   * @param ResumeUrl
   */  
  public void setResumeUrl(String resumeUrl){
    this.resumeUrl = resumeUrl;
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
   * 从业时间 getter
   */
  public Float getWorkExperience(){
    return workExperience;
  }
  /**
   * 从业时间 setter
   * @param WorkExperience
   */  
  public void setWorkExperience(Float workExperience){
    this.workExperience = workExperience;
  }
 
}