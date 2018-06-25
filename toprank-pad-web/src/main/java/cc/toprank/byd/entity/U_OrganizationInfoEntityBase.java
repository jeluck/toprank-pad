package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在U_OrganizationInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class U_OrganizationInfoEntityBase extends Entity {

  /**
   *	CityID数据库列名
   */
  public final static java.lang.String CITYID_FIELD =  "CityID";
  
  /**
   *	CityID字段中文名，用于视图展示
   */
  public final static java.lang.String CITYID_LABLE = "城市编号";
  
  /**
   *	CityID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long cityID;
  
  /**
   *	CityName数据库列名
   */
  public final static java.lang.String CITYNAME_FIELD =  "CityName";
  
  /**
   *	CityName字段中文名，用于视图展示
   */
  public final static java.lang.String CITYNAME_LABLE = "城市名称";
  
  /**
   *	CityName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String cityName;
  
  /**
   *	CountryID数据库列名
   */
  public final static java.lang.String COUNTRYID_FIELD =  "CountryID";
  
  /**
   *	CountryID字段中文名，用于视图展示
   */
  public final static java.lang.String COUNTRYID_LABLE = "国家编号";
  
  /**
   *	CountryID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long countryID;
  
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
   *	DistrictID数据库列名
   */
  public final static java.lang.String DISTRICTID_FIELD =  "DistrictID";
  
  /**
   *	DistrictID字段中文名，用于视图展示
   */
  public final static java.lang.String DISTRICTID_LABLE = "区(县)编号";
  
  /**
   *	DistrictID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long districtID;
  
  /**
   *	DistrictName数据库列名
   */
  public final static java.lang.String DISTRICTNAME_FIELD =  "DistrictName";
  
  /**
   *	DistrictName字段中文名，用于视图展示
   */
  public final static java.lang.String DISTRICTNAME_LABLE = "区(县)名称";
  
  /**
   *	DistrictName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String districtName;
  
  /**
   *	Email数据库列名
   */
  public final static java.lang.String EMAIL_FIELD =  "Email";
  
  /**
   *	Email字段中文名，用于视图展示
   */
  public final static java.lang.String EMAIL_LABLE = "电子邮箱";
  
  /**
   *	Email对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String email;
  
  /**
   *	Fax数据库列名
   */
  public final static java.lang.String FAX_FIELD =  "Fax";
  
  /**
   *	Fax字段中文名，用于视图展示
   */
  public final static java.lang.String FAX_LABLE = "传真";
  
  /**
   *	Fax对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String fax;
  
  /**
   *	FirstLetter数据库列名
   */
  public final static java.lang.String FIRSTLETTER_FIELD =  "FirstLetter";
  
  /**
   *	FirstLetter字段中文名，用于视图展示
   */
  public final static java.lang.String FIRSTLETTER_LABLE = "首拼";
  
  /**
   *	FirstLetter对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String firstLetter;
  
  /**
   *	HashKey数据库列名
   */
  public final static java.lang.String HASHKEY_FIELD =  "HashKey";
  
  /**
   *	HashKey字段中文名，用于视图展示
   */
  public final static java.lang.String HASHKEY_LABLE = "Hash码";
  
  /**
   *	HashKey对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String hashKey;
  
  /**
   *	Industry数据库列名
   */
  public final static java.lang.String INDUSTRY_FIELD =  "Industry";
  
  /**
   *	Industry字段中文名，用于视图展示
   */
  public final static java.lang.String INDUSTRY_LABLE = "行业";
  
  /**
   *	Industry对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long industry;
  
  /**
   *	Latitude数据库列名
   */
  public final static java.lang.String LATITUDE_FIELD =  "Latitude";
  
  /**
   *	Latitude字段中文名，用于视图展示
   */
  public final static java.lang.String LATITUDE_LABLE = "纬度";
  
  /**
   *	Latitude对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal latitude;
  
  /**
   *	Longitude数据库列名
   */
  public final static java.lang.String LONGITUDE_FIELD =  "Longitude";
  
  /**
   *	Longitude字段中文名，用于视图展示
   */
  public final static java.lang.String LONGITUDE_LABLE = "经度";
  
  /**
   *	Longitude对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal longitude;
  
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
   *	OrgDesc数据库列名
   */
  public final static java.lang.String ORGDESC_FIELD =  "OrgDesc";
  
  /**
   *	OrgDesc字段中文名，用于视图展示
   */
  public final static java.lang.String ORGDESC_LABLE = "机构描述";
  
  /**
   *	OrgDesc对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String orgDesc;
  
  /**
   *	OrgID数据库列名
   */
  public final static java.lang.String ORGID_FIELD =  "OrgID";
  
  /**
   *	OrgID字段中文名，用于视图展示
   */
  public final static java.lang.String ORGID_LABLE = "机构编号";
  
  /**
   *	OrgID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long orgID;
  
  /**
   *	OrgName数据库列名
   */
  public final static java.lang.String ORGNAME_FIELD =  "OrgName";
  
  /**
   *	OrgName字段中文名，用于视图展示
   */
  public final static java.lang.String ORGNAME_LABLE = "机构名称";
  
  /**
   *	OrgName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String orgName;
  
  /**
   *	OrgStatus数据库列名
   */
  public final static java.lang.String ORGSTATUS_FIELD =  "OrgStatus";
  
  /**
   *	OrgStatus字段中文名，用于视图展示
   */
  public final static java.lang.String ORGSTATUS_LABLE = "机构状态";
  
  /**
   *	OrgStatus对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long orgStatus;
  
  /**
   *	OrgType数据库列名
   */
  public final static java.lang.String ORGTYPE_FIELD =  "OrgType";
  
  /**
   *	OrgType字段中文名，用于视图展示
   */
  public final static java.lang.String ORGTYPE_LABLE = "机构类型";
  
  /**
   *	OrgType对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long orgType;
  
  /**
   *	ParentID数据库列名
   */
  public final static java.lang.String PARENTID_FIELD =  "ParentID";
  
  /**
   *	ParentID字段中文名，用于视图展示
   */
  public final static java.lang.String PARENTID_LABLE = "上级编号";
  
  /**
   *	ParentID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long parentID;
  
  /**
   *	Phone数据库列名
   */
  public final static java.lang.String PHONE_FIELD =  "Phone";
  
  /**
   *	Phone字段中文名，用于视图展示
   */
  public final static java.lang.String PHONE_LABLE = "电话";
  
  /**
   *	Phone对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String phone;
  
  /**
   *	PostalAddress数据库列名
   */
  public final static java.lang.String POSTALADDRESS_FIELD =  "PostalAddress";
  
  /**
   *	PostalAddress字段中文名，用于视图展示
   */
  public final static java.lang.String POSTALADDRESS_LABLE = "通信地址";
  
  /**
   *	PostalAddress对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String postalAddress;
  
  /**
   *	PostCode数据库列名
   */
  public final static java.lang.String POSTCODE_FIELD =  "PostCode";
  
  /**
   *	PostCode字段中文名，用于视图展示
   */
  public final static java.lang.String POSTCODE_LABLE = "邮编";
  
  /**
   *	PostCode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String postCode;
  
  /**
   *	ProvinceID数据库列名
   */
  public final static java.lang.String PROVINCEID_FIELD =  "ProvinceID";
  
  /**
   *	ProvinceID字段中文名，用于视图展示
   */
  public final static java.lang.String PROVINCEID_LABLE = "省(州)编号";
  
  /**
   *	ProvinceID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long provinceID;
  
  /**
   *	ProvinceName数据库列名
   */
  public final static java.lang.String PROVINCENAME_FIELD =  "ProvinceName";
  
  /**
   *	ProvinceName字段中文名，用于视图展示
   */
  public final static java.lang.String PROVINCENAME_LABLE = "省(州)";
  
  /**
   *	ProvinceName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String provinceName;
  
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
   *	Street数据库列名
   */
  public final static java.lang.String STREET_FIELD =  "Street";
  
  /**
   *	Street字段中文名，用于视图展示
   */
  public final static java.lang.String STREET_LABLE = "街道";
  
  /**
   *	Street对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String street;
  
  /**
   *	StreetID数据库列名
   */
  public final static java.lang.String STREETID_FIELD =  "StreetID";
  
  /**
   *	StreetID字段中文名，用于视图展示
   */
  public final static java.lang.String STREETID_LABLE = "街道编号";
  
  /**
   *	StreetID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long streetID;
  
  /**
   *	TreeID数据库列名
   */
  public final static java.lang.String TREEID_FIELD =  "TreeID";
  
  /**
   *	TreeID字段中文名，用于视图展示
   */
  public final static java.lang.String TREEID_LABLE = "树结构编号";
  
  /**
   *	TreeID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String treeID;
  
  /**
   *	WebUrl数据库列名
   */
  public final static java.lang.String WEBURL_FIELD =  "WebUrl";
  
  /**
   *	WebUrl字段中文名，用于视图展示
   */
  public final static java.lang.String WEBURL_LABLE = "网址";
  
  /**
   *	WebUrl对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String webUrl;
  
  /**
   * 城市编号 getter
   */
  public java.lang.Long getCityID(){
    return cityID;
  }
  /**
   * 城市编号 setter
   * @param CityID
   */  
  public void setCityID(java.lang.Long cityID){
    this.cityID = cityID;
  }
 
  /**
   * 城市名称 getter
   */
  public java.lang.String getCityName(){
    return cityName;
  }
  /**
   * 城市名称 setter
   * @param CityName
   */  
  public void setCityName(java.lang.String cityName){
    this.cityName = cityName;
  }
 
  /**
   * 国家编号 getter
   */
  public java.lang.Long getCountryID(){
    return countryID;
  }
  /**
   * 国家编号 setter
   * @param CountryID
   */  
  public void setCountryID(java.lang.Long countryID){
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
   * 区(县)编号 getter
   */
  public java.lang.Long getDistrictID(){
    return districtID;
  }
  /**
   * 区(县)编号 setter
   * @param DistrictID
   */  
  public void setDistrictID(java.lang.Long districtID){
    this.districtID = districtID;
  }
 
  /**
   * 区(县)名称 getter
   */
  public java.lang.String getDistrictName(){
    return districtName;
  }
  /**
   * 区(县)名称 setter
   * @param DistrictName
   */  
  public void setDistrictName(java.lang.String districtName){
    this.districtName = districtName;
  }
 
  /**
   * 电子邮箱 getter
   */
  public java.lang.String getEmail(){
    return email;
  }
  /**
   * 电子邮箱 setter
   * @param Email
   */  
  public void setEmail(java.lang.String email){
    this.email = email;
  }
 
  /**
   * 传真 getter
   */
  public java.lang.String getFax(){
    return fax;
  }
  /**
   * 传真 setter
   * @param Fax
   */  
  public void setFax(java.lang.String fax){
    this.fax = fax;
  }
 
  /**
   * 首拼 getter
   */
  public java.lang.String getFirstLetter(){
    return firstLetter;
  }
  /**
   * 首拼 setter
   * @param FirstLetter
   */  
  public void setFirstLetter(java.lang.String firstLetter){
    this.firstLetter = firstLetter;
  }
 
  /**
   * Hash码 getter
   */
  public java.lang.String getHashKey(){
    return hashKey;
  }
  /**
   * Hash码 setter
   * @param HashKey
   */  
  public void setHashKey(java.lang.String hashKey){
    this.hashKey = hashKey;
  }
 
  /**
   * 行业 getter
   */
  public java.lang.Long getIndustry(){
    return industry;
  }
  /**
   * 行业 setter
   * @param Industry
   */  
  public void setIndustry(java.lang.Long industry){
    this.industry = industry;
  }
 
  /**
   * 纬度 getter
   */
  public java.math.BigDecimal getLatitude(){
    return latitude;
  }
  /**
   * 纬度 setter
   * @param Latitude
   */  
  public void setLatitude(java.math.BigDecimal latitude){
    this.latitude = latitude;
  }
 
  /**
   * 经度 getter
   */
  public java.math.BigDecimal getLongitude(){
    return longitude;
  }
  /**
   * 经度 setter
   * @param Longitude
   */  
  public void setLongitude(java.math.BigDecimal longitude){
    this.longitude = longitude;
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
   * 机构描述 getter
   */
  public java.lang.String getOrgDesc(){
    return orgDesc;
  }
  /**
   * 机构描述 setter
   * @param OrgDesc
   */  
  public void setOrgDesc(java.lang.String orgDesc){
    this.orgDesc = orgDesc;
  }
 
  /**
   * 机构编号 getter
   */
  public java.lang.Long getOrgID(){
    return orgID;
  }
  /**
   * 机构编号 setter
   * @param OrgID
   */  
  public void setOrgID(java.lang.Long orgID){
    this.orgID = orgID;
  }
 
  /**
   * 机构名称 getter
   */
  public java.lang.String getOrgName(){
    return orgName;
  }
  /**
   * 机构名称 setter
   * @param OrgName
   */  
  public void setOrgName(java.lang.String orgName){
    this.orgName = orgName;
  }
 
  /**
   * 机构状态 getter
   */
  public java.lang.Long getOrgStatus(){
    return orgStatus;
  }
  /**
   * 机构状态 setter
   * @param OrgStatus
   */  
  public void setOrgStatus(java.lang.Long orgStatus){
    this.orgStatus = orgStatus;
  }
 
  /**
   * 机构类型 getter
   */
  public java.lang.Long getOrgType(){
    return orgType;
  }
  /**
   * 机构类型 setter
   * @param OrgType
   */  
  public void setOrgType(java.lang.Long orgType){
    this.orgType = orgType;
  }
 
  /**
   * 上级编号 getter
   */
  public java.lang.Long getParentID(){
    return parentID;
  }
  /**
   * 上级编号 setter
   * @param ParentID
   */  
  public void setParentID(java.lang.Long parentID){
    this.parentID = parentID;
  }
 
  /**
   * 电话 getter
   */
  public java.lang.String getPhone(){
    return phone;
  }
  /**
   * 电话 setter
   * @param Phone
   */  
  public void setPhone(java.lang.String phone){
    this.phone = phone;
  }
 
  /**
   * 通信地址 getter
   */
  public java.lang.String getPostalAddress(){
    return postalAddress;
  }
  /**
   * 通信地址 setter
   * @param PostalAddress
   */  
  public void setPostalAddress(java.lang.String postalAddress){
    this.postalAddress = postalAddress;
  }
 
  /**
   * 邮编 getter
   */
  public java.lang.String getPostCode(){
    return postCode;
  }
  /**
   * 邮编 setter
   * @param PostCode
   */  
  public void setPostCode(java.lang.String postCode){
    this.postCode = postCode;
  }
 
  /**
   * 省(州)编号 getter
   */
  public java.lang.Long getProvinceID(){
    return provinceID;
  }
  /**
   * 省(州)编号 setter
   * @param ProvinceID
   */  
  public void setProvinceID(java.lang.Long provinceID){
    this.provinceID = provinceID;
  }
 
  /**
   * 省(州) getter
   */
  public java.lang.String getProvinceName(){
    return provinceName;
  }
  /**
   * 省(州) setter
   * @param ProvinceName
   */  
  public void setProvinceName(java.lang.String provinceName){
    this.provinceName = provinceName;
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
   * 街道 getter
   */
  public java.lang.String getStreet(){
    return street;
  }
  /**
   * 街道 setter
   * @param Street
   */  
  public void setStreet(java.lang.String street){
    this.street = street;
  }
 
  /**
   * 街道编号 getter
   */
  public java.lang.Long getStreetID(){
    return streetID;
  }
  /**
   * 街道编号 setter
   * @param StreetID
   */  
  public void setStreetID(java.lang.Long streetID){
    this.streetID = streetID;
  }
 
  /**
   * 树结构编号 getter
   */
  public java.lang.String getTreeID(){
    return treeID;
  }
  /**
   * 树结构编号 setter
   * @param TreeID
   */  
  public void setTreeID(java.lang.String treeID){
    this.treeID = treeID;
  }
 
  /**
   * 网址 getter
   */
  public java.lang.String getWebUrl(){
    return webUrl;
  }
  /**
   * 网址 setter
   * @param WebUrl
   */  
  public void setWebUrl(java.lang.String webUrl){
    this.webUrl = webUrl;
  }
 
}