package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在E_CustomerInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class E_CustomerInfoEntityBase  extends Entity{

  /**
   *	Birthday数据库列名
   */
  public final static String BIRTHDAY_FIELD =  "Birthday";
  
  /**
   *	Birthday字段中文名，用于视图展示
   */
  public final static String BIRTHDAY_LABLE = "生日";
  
  /**
   *	Birthday对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDate birthday;
  
  /**
   *	BriefIntro数据库列名
   */
  public final static String BRIEFINTRO_FIELD =  "BriefIntro";
  
  /**
   *	BriefIntro字段中文名，用于视图展示
   */
  public final static String BRIEFINTRO_LABLE = "简介";
  
  /**
   *	BriefIntro对应的java字段名,业务操作使用这个字段。
   */
  private String briefIntro;
  
  /**
   *	CityID数据库列名
   */
  public final static String CITYID_FIELD =  "CityID";
  
  /**
   *	CityID字段中文名，用于视图展示
   */
  public final static String CITYID_LABLE = "城市编号";
  
  /**
   *	CityID对应的java字段名,业务操作使用这个字段。
   */
  private Long cityID;
  
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
  public final static String CREATETIME_LABLE = "注册时间";
  
  /**
   *	CreateTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime createTime;
  
  /**
   *	CustomerDesc数据库列名
   */
  public final static String CUSTOMERDESC_FIELD =  "CustomerDesc";
  
  /**
   *	CustomerDesc字段中文名，用于视图展示
   */
  public final static String CUSTOMERDESC_LABLE = "客户描述";
  
  /**
   *	CustomerDesc对应的java字段名,业务操作使用这个字段。
   */
  private String customerDesc;
  
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
   *	CustomerName数据库列名
   */
  public final static String CUSTOMERNAME_FIELD =  "CustomerName";
  
  /**
   *	CustomerName字段中文名，用于视图展示
   */
  public final static String CUSTOMERNAME_LABLE = "客户名称";
  
  /**
   *	CustomerName对应的java字段名,业务操作使用这个字段。
   */
  private String customerName;
  
  /**
   *	CustomerStatus数据库列名
   */
  public final static String CUSTOMERSTATUS_FIELD =  "CustomerStatus";
  
  /**
   *	CustomerStatus字段中文名，用于视图展示
   */
  public final static String CUSTOMERSTATUS_LABLE = "客户状态";
  
  /**
   *	CustomerStatus对应的java字段名,业务操作使用这个字段。
   */
  private Long customerStatus;
  
  /**
   *	CustomerType数据库列名
   */
  public final static String CUSTOMERTYPE_FIELD =  "CustomerType";
  
  /**
   *	CustomerType字段中文名，用于视图展示
   */
  public final static String CUSTOMERTYPE_LABLE = "客户类别";
  
  /**
   *	CustomerType对应的java字段名,业务操作使用这个字段。
   */
  private Long customerType;
  
  /**
   *	DetailAddress数据库列名
   */
  public final static String DETAILADDRESS_FIELD =  "DetailAddress";
  
  /**
   *	DetailAddress字段中文名，用于视图展示
   */
  public final static String DETAILADDRESS_LABLE = "详细地址";
  
  /**
   *	DetailAddress对应的java字段名,业务操作使用这个字段。
   */
  private String detailAddress;
  
  /**
   *	DistrictID数据库列名
   */
  public final static String DISTRICTID_FIELD =  "DistrictID";
  
  /**
   *	DistrictID字段中文名，用于视图展示
   */
  public final static String DISTRICTID_LABLE = "区(县)编号";
  
  /**
   *	DistrictID对应的java字段名,业务操作使用这个字段。
   */
  private Long districtID;
  
  /**
   *	EconomicIncome数据库列名
   */
  public final static String ECONOMICINCOME_FIELD =  "EconomicIncome";
  
  /**
   *	EconomicIncome字段中文名，用于视图展示
   */
  public final static String ECONOMICINCOME_LABLE = "经济收入";
  
  /**
   *	EconomicIncome对应的java字段名,业务操作使用这个字段。
   */
  private Long economicIncome;
  
  /**
   *	EducationLevel数据库列名
   */
  public final static String EDUCATIONLEVEL_FIELD =  "EducationLevel";
  
  /**
   *	EducationLevel字段中文名，用于视图展示
   */
  public final static String EDUCATIONLEVEL_LABLE = "文化程度";
  
  /**
   *	EducationLevel对应的java字段名,业务操作使用这个字段。
   */
  private Long educationLevel;
  
  /**
   *	Email数据库列名
   */
  public final static String EMAIL_FIELD =  "Email";
  
  /**
   *	Email字段中文名，用于视图展示
   */
  public final static String EMAIL_LABLE = "邮箱";
  
  /**
   *	Email对应的java字段名,业务操作使用这个字段。
   */
  private String email;
  
  /**
   *	Fax数据库列名
   */
  public final static String FAX_FIELD =  "Fax";
  
  /**
   *	Fax字段中文名，用于视图展示
   */
  public final static String FAX_LABLE = "传真";
  
  /**
   *	Fax对应的java字段名,业务操作使用这个字段。
   */
  private String fax;
  
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
   *	FirstName数据库列名
   */
  public final static String FIRSTNAME_FIELD =  "FirstName";
  
  /**
   *	FirstName字段中文名，用于视图展示
   */
  public final static String FIRSTNAME_LABLE = "姓";
  
  /**
   *	FirstName对应的java字段名,业务操作使用这个字段。
   */
  private String firstName;
  
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
   *	HashKey数据库列名
   */
  public final static String HASHKEY_FIELD =  "HashKey";
  
  /**
   *	HashKey字段中文名，用于视图展示
   */
  public final static String HASHKEY_LABLE = "Hash码";
  
  /**
   *	HashKey对应的java字段名,业务操作使用这个字段。
   */
  private String hashKey;
  
  /**
   *	IDCode数据库列名
   */
  public final static String IDCODE_FIELD =  "IDCode";
  
  /**
   *	IDCode字段中文名，用于视图展示
   */
  public final static String IDCODE_LABLE = "证件号码";
  
  /**
   *	IDCode对应的java字段名,业务操作使用这个字段。
   */
  private String iDCode;
  
  /**
   *	ImageID数据库列名
   */
  public final static String IMAGEID_FIELD =  "ImageID";
  
  /**
   *	ImageID字段中文名，用于视图展示
   */
  public final static String IMAGEID_LABLE = "图像编号";
  
  /**
   *	ImageID对应的java字段名,业务操作使用这个字段。
   */
  private Long imageID;
  
  /**
   *	ImagePath数据库列名
   */
  public final static String IMAGEPATH_FIELD =  "ImagePath";
  
  /**
   *	ImagePath字段中文名，用于视图展示
   */
  public final static String IMAGEPATH_LABLE = "图像路径";
  
  /**
   *	ImagePath对应的java字段名,业务操作使用这个字段。
   */
  private String imagePath;
  
  /**
   *	LastName数据库列名
   */
  public final static String LASTNAME_FIELD =  "LastName";
  
  /**
   *	LastName字段中文名，用于视图展示
   */
  public final static String LASTNAME_LABLE = "名";
  
  /**
   *	LastName对应的java字段名,业务操作使用这个字段。
   */
  private String lastName;
  
  /**
   *	Latitude数据库列名
   */
  public final static String LATITUDE_FIELD =  "Latitude";
  
  /**
   *	Latitude字段中文名，用于视图展示
   */
  public final static String LATITUDE_LABLE = "纬度";
  
  /**
   *	Latitude对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal latitude;
  
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
   *	Longitude数据库列名
   */
  public final static String LONGITUDE_FIELD =  "Longitude";
  
  /**
   *	Longitude字段中文名，用于视图展示
   */
  public final static String LONGITUDE_LABLE = "经度";
  
  /**
   *	Longitude对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal longitude;
  
  /**
   *	MaritalStatus数据库列名
   */
  public final static String MARITALSTATUS_FIELD =  "MaritalStatus";
  
  /**
   *	MaritalStatus字段中文名，用于视图展示
   */
  public final static String MARITALSTATUS_LABLE = "婚姻状况";
  
  /**
   *	MaritalStatus对应的java字段名,业务操作使用这个字段。
   */
  private Long maritalStatus;
  
  /**
   *	MemberBonus数据库列名
   */
  public final static String MEMBERBONUS_FIELD =  "MemberBonus";
  
  /**
   *	MemberBonus字段中文名，用于视图展示
   */
  public final static String MEMBERBONUS_LABLE = "积分";
  
  /**
   *	MemberBonus对应的java字段名,业务操作使用这个字段。
   */
  private Integer memberBonus;
  
  /**
   *	MemberLevel数据库列名
   */
  public final static String MEMBERLEVEL_FIELD =  "MemberLevel";
  
  /**
   *	MemberLevel字段中文名，用于视图展示
   */
  public final static String MEMBERLEVEL_LABLE = "等级";
  
  /**
   *	MemberLevel对应的java字段名,业务操作使用这个字段。
   */
  private Long memberLevel;
  
  /**
   *	MemberStar数据库列名
   */
  public final static String MEMBERSTAR_FIELD =  "MemberStar";
  
  /**
   *	MemberStar字段中文名，用于视图展示
   */
  public final static String MEMBERSTAR_LABLE = "星级";
  
  /**
   *	MemberStar对应的java字段名,业务操作使用这个字段。
   */
  private Integer memberStar;
  
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
   *	PassportType数据库列名
   */
  public final static String PASSPORTTYPE_FIELD =  "PassportType";
  
  /**
   *	PassportType字段中文名，用于视图展示
   */
  public final static String PASSPORTTYPE_LABLE = "证件类别";
  
  /**
   *	PassportType对应的java字段名,业务操作使用这个字段。
   */
  private Long passportType;
  
  /**
   *	PayPassword数据库列名
   */
  public final static String PAYPASSWORD_FIELD =  "PayPassword";
  
  /**
   *	PayPassword字段中文名，用于视图展示
   */
  public final static String PAYPASSWORD_LABLE = "交易密码";
  
  /**
   *	PayPassword对应的java字段名,业务操作使用这个字段。
   */
  private String payPassword;
  
  /**
   *	Phone数据库列名
   */
  public final static String PHONE_FIELD =  "Phone";
  
  /**
   *	Phone字段中文名，用于视图展示
   */
  public final static String PHONE_LABLE = "电话";
  
  /**
   *	Phone对应的java字段名,业务操作使用这个字段。
   */
  private String phone;
  
  /**
   *	PointNumber数据库列名
   */
  public final static String POINTNUMBER_FIELD =  "PointNumber";
  
  /**
   *	PointNumber字段中文名，用于视图展示
   */
  public final static String POINTNUMBER_LABLE = "点数";
  
  /**
   *	PointNumber对应的java字段名,业务操作使用这个字段。
   */
  private Integer pointNumber;
  
  /**
   *	PostCode数据库列名
   */
  public final static String POSTCODE_FIELD =  "PostCode";
  
  /**
   *	PostCode字段中文名，用于视图展示
   */
  public final static String POSTCODE_LABLE = "邮政编码";
  
  /**
   *	PostCode对应的java字段名,业务操作使用这个字段。
   */
  private String postCode;
  
  /**
   *	ProvinceID数据库列名
   */
  public final static String PROVINCEID_FIELD =  "ProvinceID";
  
  /**
   *	ProvinceID字段中文名，用于视图展示
   */
  public final static String PROVINCEID_LABLE = "省(州)编号";
  
  /**
   *	ProvinceID对应的java字段名,业务操作使用这个字段。
   */
  private Long provinceID;
  
  /**
   *	RefereeID数据库列名
   */
  public final static String REFEREEID_FIELD =  "RefereeID";
  
  /**
   *	RefereeID字段中文名，用于视图展示
   */
  public final static String REFEREEID_LABLE = "推荐人编号";
  
  /**
   *	RefereeID对应的java字段名,业务操作使用这个字段。
   */
  private Long refereeID;
  
  /**
   *	ReferralID数据库列名
   */
  public final static String REFERRALID_FIELD =  "ReferralID";
  
  /**
   *	ReferralID字段中文名，用于视图展示
   */
  public final static String REFERRALID_LABLE = "推荐码编号";
  
  /**
   *	ReferralID对应的java字段名,业务操作使用这个字段。
   */
  private Long referralID;
  
  /**
   *	Residence数据库列名
   */
  public final static String RESIDENCE_FIELD =  "Residence";
  
  /**
   *	Residence字段中文名，用于视图展示
   */
  public final static String RESIDENCE_LABLE = "居住地";
  
  /**
   *	Residence对应的java字段名,业务操作使用这个字段。
   */
  private Long residence;
  
  /**
   *	Residency数据库列名
   */
  public final static String RESIDENCY_FIELD =  "Residency";
  
  /**
   *	Residency字段中文名，用于视图展示
   */
  public final static String RESIDENCY_LABLE = "地区";
  
  /**
   *	Residency对应的java字段名,业务操作使用这个字段。
   */
  private Long residency;
  
  /**
   *	SourceDesc数据库列名
   */
  public final static String SOURCEDESC_FIELD =  "SourceDesc";
  
  /**
   *	SourceDesc字段中文名，用于视图展示
   */
  public final static String SOURCEDESC_LABLE = "来源描述";
  
  /**
   *	SourceDesc对应的java字段名,业务操作使用这个字段。
   */
  private String sourceDesc;
  
  /**
   *	SourceID数据库列名
   */
  public final static String SOURCEID_FIELD =  "SourceID";
  
  /**
   *	SourceID字段中文名，用于视图展示
   */
  public final static String SOURCEID_LABLE = "来源编号";
  
  /**
   *	SourceID对应的java字段名,业务操作使用这个字段。
   */
  private Long sourceID;
  
  /**
   *	SourceType数据库列名
   */
  public final static String SOURCETYPE_FIELD =  "SourceType";
  
  /**
   *	SourceType字段中文名，用于视图展示
   */
  public final static String SOURCETYPE_LABLE = "来源类别";
  
  /**
   *	SourceType对应的java字段名,业务操作使用这个字段。
   */
  private Long sourceType;
  
  /**
   *	StreetID数据库列名
   */
  public final static String STREETID_FIELD =  "StreetID";
  
  /**
   *	StreetID字段中文名，用于视图展示
   */
  public final static String STREETID_LABLE = "街道编号";
  
  /**
   *	StreetID对应的java字段名,业务操作使用这个字段。
   */
  private Long streetID;
  
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
   *	UpdateTime数据库列名
   */
  public final static String UPDATETIME_FIELD =  "UpdateTime";
  
  /**
   *	UpdateTime字段中文名，用于视图展示
   */
  public final static String UPDATETIME_LABLE = "最后修改时间";
  
  /**
   *	UpdateTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime updateTime;
  
  /**
   *	UsePayPassword数据库列名
   */
  public final static String USEPAYPASSWORD_FIELD =  "UsePayPassword";
  
  /**
   *	UsePayPassword字段中文名，用于视图展示
   */
  public final static String USEPAYPASSWORD_LABLE = "启用支付密码";
  
  /**
   *	UsePayPassword对应的java字段名,业务操作使用这个字段。
   */
  private Boolean usePayPassword;
  
  /**
   * 生日 getter
   */
  public java.time.LocalDate getBirthday(){
    return birthday;
  }
  /**
   * 生日 setter
   * @param birthday
   */  
  public void setBirthday(java.time.LocalDate birthday){
    this.birthday = birthday;
  }
 
  /**
   * 简介 getter
   */
  public String getBriefIntro(){
    return briefIntro;
  }
  /**
   * 简介 setter
   * @param briefIntro
   */  
  public void setBriefIntro(String briefIntro){
    this.briefIntro = briefIntro;
  }
 
  /**
   * 城市编号 getter
   */
  public Long getCityID(){
    return cityID;
  }
  /**
   * 城市编号 setter
   * @param cityID
   */  
  public void setCityID(Long cityID){
    this.cityID = cityID;
  }
 
  /**
   * 国家编号 getter
   */
  public Long getCountryID(){
    return countryID;
  }
  /**
   * 国家编号 setter
   * @param countryID
   */  
  public void setCountryID(Long countryID){
    this.countryID = countryID;
  }
 
  /**
   * 注册时间 getter
   */
  public java.time.LocalDateTime getCreateTime(){
    return createTime;
  }
  /**
   * 注册时间 setter
   * @param createTime
   */  
  public void setCreateTime(java.time.LocalDateTime createTime){
    this.createTime = createTime;
  }
 
  /**
   * 客户描述 getter
   */
  public String getCustomerDesc(){
    return customerDesc;
  }
  /**
   * 客户描述 setter
   * @param customerDesc
   */  
  public void setCustomerDesc(String customerDesc){
    this.customerDesc = customerDesc;
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
   * 客户名称 getter
   */
  public String getCustomerName(){
    return customerName;
  }
  /**
   * 客户名称 setter
   * @param customerName
   */  
  public void setCustomerName(String customerName){
    this.customerName = customerName;
  }
 
  /**
   * 客户状态 getter
   */
  public Long getCustomerStatus(){
    return customerStatus;
  }
  /**
   * 客户状态 setter
   * @param customerStatus
   */  
  public void setCustomerStatus(Long customerStatus){
    this.customerStatus = customerStatus;
  }
 
  /**
   * 客户类别 getter
   */
  public Long getCustomerType(){
    return customerType;
  }
  /**
   * 客户类别 setter
   * @param customerType
   */  
  public void setCustomerType(Long customerType){
    this.customerType = customerType;
  }
 
  /**
   * 详细地址 getter
   */
  public String getDetailAddress(){
    return detailAddress;
  }
  /**
   * 详细地址 setter
   * @param detailAddress
   */  
  public void setDetailAddress(String detailAddress){
    this.detailAddress = detailAddress;
  }
 
  /**
   * 区(县)编号 getter
   */
  public Long getDistrictID(){
    return districtID;
  }
  /**
   * 区(县)编号 setter
   * @param districtID
   */  
  public void setDistrictID(Long districtID){
    this.districtID = districtID;
  }
 
  /**
   * 经济收入 getter
   */
  public Long getEconomicIncome(){
    return economicIncome;
  }
  /**
   * 经济收入 setter
   * @param economicIncome
   */  
  public void setEconomicIncome(Long economicIncome){
    this.economicIncome = economicIncome;
  }
 
  /**
   * 文化程度 getter
   */
  public Long getEducationLevel(){
    return educationLevel;
  }
  /**
   * 文化程度 setter
   * @param educationLevel
   */  
  public void setEducationLevel(Long educationLevel){
    this.educationLevel = educationLevel;
  }
 
  /**
   * 邮箱 getter
   */
  public String getEmail(){
    return email;
  }
  /**
   * 邮箱 setter
   * @param email
   */  
  public void setEmail(String email){
    this.email = email;
  }
 
  /**
   * 传真 getter
   */
  public String getFax(){
    return fax;
  }
  /**
   * 传真 setter
   * @param fax
   */  
  public void setFax(String fax){
    this.fax = fax;
  }
 
  /**
   * 首拼 getter
   */
  public String getFirstLetter(){
    return firstLetter;
  }
  /**
   * 首拼 setter
   * @param firstLetter
   */  
  public void setFirstLetter(String firstLetter){
    this.firstLetter = firstLetter;
  }
 
  /**
   * 姓 getter
   */
  public String getFirstName(){
    return firstName;
  }
  /**
   * 姓 setter
   * @param firstName
   */  
  public void setFirstName(String firstName){
    this.firstName = firstName;
  }
 
  /**
   * 性别 getter
   */
  public Long getGender(){
    return gender;
  }
  /**
   * 性别 setter
   * @param gender
   */  
  public void setGender(Long gender){
    this.gender = gender;
  }
 
  /**
   * Hash码 getter
   */
  public String getHashKey(){
    return hashKey;
  }
  /**
   * Hash码 setter
   * @param hashKey
   */  
  public void setHashKey(String hashKey){
    this.hashKey = hashKey;
  }
 
  /**
   * 证件号码 getter
   */
  public String getIDCode(){
    return iDCode;
  }
  /**
   * 证件号码 setter
   * @param iDCode
   */  
  public void setIDCode(String iDCode){
    this.iDCode = iDCode;
  }
 
  /**
   * 图像编号 getter
   */
  public Long getImageID(){
    return imageID;
  }
  /**
   * 图像编号 setter
   * @param imageID
   */  
  public void setImageID(Long imageID){
    this.imageID = imageID;
  }
 
  /**
   * 图像路径 getter
   */
  public String getImagePath(){
    return imagePath;
  }
  /**
   * 图像路径 setter
   * @param imagePath
   */  
  public void setImagePath(String imagePath){
    this.imagePath = imagePath;
  }
 
  /**
   * 名 getter
   */
  public String getLastName(){
    return lastName;
  }
  /**
   * 名 setter
   * @param lastName
   */  
  public void setLastName(String lastName){
    this.lastName = lastName;
  }
 
  /**
   * 纬度 getter
   */
  public java.math.BigDecimal getLatitude(){
    return latitude;
  }
  /**
   * 纬度 setter
   * @param latitude
   */  
  public void setLatitude(java.math.BigDecimal latitude){
    this.latitude = latitude;
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
   * 经度 getter
   */
  public java.math.BigDecimal getLongitude(){
    return longitude;
  }
  /**
   * 经度 setter
   * @param longitude
   */  
  public void setLongitude(java.math.BigDecimal longitude){
    this.longitude = longitude;
  }
 
  /**
   * 婚姻状况 getter
   */
  public Long getMaritalStatus(){
    return maritalStatus;
  }
  /**
   * 婚姻状况 setter
   * @param maritalStatus
   */  
  public void setMaritalStatus(Long maritalStatus){
    this.maritalStatus = maritalStatus;
  }
 
  /**
   * 积分 getter
   */
  public Integer getMemberBonus(){
    return memberBonus;
  }
  /**
   * 积分 setter
   * @param memberBonus
   */  
  public void setMemberBonus(Integer memberBonus){
    this.memberBonus = memberBonus;
  }
 
  /**
   * 等级 getter
   */
  public Long getMemberLevel(){
    return memberLevel;
  }
  /**
   * 等级 setter
   * @param memberLevel
   */  
  public void setMemberLevel(Long memberLevel){
    this.memberLevel = memberLevel;
  }
 
  /**
   * 星级 getter
   */
  public Integer getMemberStar(){
    return memberStar;
  }
  /**
   * 星级 setter
   * @param memberStar
   */  
  public void setMemberStar(Integer memberStar){
    this.memberStar = memberStar;
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
   * 手机 getter
   */
  public String getMobile(){
    return mobile;
  }
  /**
   * 手机 setter
   * @param mobile
   */  
  public void setMobile(String mobile){
    this.mobile = mobile;
  }
 
  /**
   * 证件类别 getter
   */
  public Long getPassportType(){
    return passportType;
  }
  /**
   * 证件类别 setter
   * @param passportType
   */  
  public void setPassportType(Long passportType){
    this.passportType = passportType;
  }
 
  /**
   * 交易密码 getter
   */
  public String getPayPassword(){
    return payPassword;
  }
  /**
   * 交易密码 setter
   * @param payPassword
   */  
  public void setPayPassword(String payPassword){
    this.payPassword = payPassword;
  }
 
  /**
   * 电话 getter
   */
  public String getPhone(){
    return phone;
  }
  /**
   * 电话 setter
   * @param phone
   */  
  public void setPhone(String phone){
    this.phone = phone;
  }
 
  /**
   * 点数 getter
   */
  public Integer getPointNumber(){
    return pointNumber;
  }
  /**
   * 点数 setter
   * @param pointNumber
   */  
  public void setPointNumber(Integer pointNumber){
    this.pointNumber = pointNumber;
  }
 
  /**
   * 邮政编码 getter
   */
  public String getPostCode(){
    return postCode;
  }
  /**
   * 邮政编码 setter
   * @param postCode
   */  
  public void setPostCode(String postCode){
    this.postCode = postCode;
  }
 
  /**
   * 省(州)编号 getter
   */
  public Long getProvinceID(){
    return provinceID;
  }
  /**
   * 省(州)编号 setter
   * @param provinceID
   */  
  public void setProvinceID(Long provinceID){
    this.provinceID = provinceID;
  }
 
  /**
   * 推荐人编号 getter
   */
  public Long getRefereeID(){
    return refereeID;
  }
  /**
   * 推荐人编号 setter
   * @param refereeID
   */  
  public void setRefereeID(Long refereeID){
    this.refereeID = refereeID;
  }
 
  /**
   * 推荐码编号 getter
   */
  public Long getReferralID(){
    return referralID;
  }
  /**
   * 推荐码编号 setter
   * @param referralID
   */  
  public void setReferralID(Long referralID){
    this.referralID = referralID;
  }
 
  /**
   * 居住地 getter
   */
  public Long getResidence(){
    return residence;
  }
  /**
   * 居住地 setter
   * @param residence
   */  
  public void setResidence(Long residence){
    this.residence = residence;
  }
 
  /**
   * 地区 getter
   */
  public Long getResidency(){
    return residency;
  }
  /**
   * 地区 setter
   * @param residency
   */  
  public void setResidency(Long residency){
    this.residency = residency;
  }
 
  /**
   * 来源描述 getter
   */
  public String getSourceDesc(){
    return sourceDesc;
  }
  /**
   * 来源描述 setter
   * @param sourceDesc
   */  
  public void setSourceDesc(String sourceDesc){
    this.sourceDesc = sourceDesc;
  }
 
  /**
   * 来源编号 getter
   */
  public Long getSourceID(){
    return sourceID;
  }
  /**
   * 来源编号 setter
   * @param sourceID
   */  
  public void setSourceID(Long sourceID){
    this.sourceID = sourceID;
  }
 
  /**
   * 来源类别 getter
   */
  public Long getSourceType(){
    return sourceType;
  }
  /**
   * 来源类别 setter
   * @param sourceType
   */  
  public void setSourceType(Long sourceType){
    this.sourceType = sourceType;
  }
 
  /**
   * 街道编号 getter
   */
  public Long getStreetID(){
    return streetID;
  }
  /**
   * 街道编号 setter
   * @param streetID
   */  
  public void setStreetID(Long streetID){
    this.streetID = streetID;
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
   * 最后修改时间 getter
   */
  public java.time.LocalDateTime getUpdateTime(){
    return updateTime;
  }
  /**
   * 最后修改时间 setter
   * @param updateTime
   */  
  public void setUpdateTime(java.time.LocalDateTime updateTime){
    this.updateTime = updateTime;
  }
 
  /**
   * 启用支付密码 getter
   */
  public Boolean getUsePayPassword(){
    return usePayPassword;
  }
  /**
   * 启用支付密码 setter
   * @param usePayPassword
   */  
  public void setUsePayPassword(Boolean usePayPassword){
    this.usePayPassword = usePayPassword;
  }
 
}