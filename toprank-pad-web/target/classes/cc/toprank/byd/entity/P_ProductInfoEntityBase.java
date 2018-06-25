package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在P_ProductInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class P_ProductInfoEntityBase extends Entity {

  /**
   *	AdminComment数据库列名
   */
  public final static java.lang.String ADMINCOMMENT_FIELD =  "AdminComment";
  
  /**
   *	AdminComment字段中文名，用于视图展示
   */
  public final static java.lang.String ADMINCOMMENT_LABLE = "推荐信息";
  
  /**
   *	AdminComment对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String adminComment;
  
  /**
   *	AllowCustomerReview数据库列名
   */
  public final static java.lang.String ALLOWCUSTOMERREVIEW_FIELD =  "AllowCustomerReview";
  
  /**
   *	AllowCustomerReview字段中文名，用于视图展示
   */
  public final static java.lang.String ALLOWCUSTOMERREVIEW_LABLE = "允许用户评论";
  
  /**
   *	AllowCustomerReview对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean allowCustomerReview;
  
  /**
   *	ApprovedRatingSum数据库列名
   */
  public final static java.lang.String APPROVEDRATINGSUM_FIELD =  "ApprovedRatingSum";
  
  /**
   *	ApprovedRatingSum字段中文名，用于视图展示
   */
  public final static java.lang.String APPROVEDRATINGSUM_LABLE = "核准评分总计";
  
  /**
   *	ApprovedRatingSum对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer approvedRatingSum;
  
  /**
   *	ApprovedTotalReview数据库列名
   */
  public final static java.lang.String APPROVEDTOTALREVIEW_FIELD =  "ApprovedTotalReview";
  
  /**
   *	ApprovedTotalReview字段中文名，用于视图展示
   */
  public final static java.lang.String APPROVEDTOTALREVIEW_LABLE = "核准评论总计";
  
  /**
   *	ApprovedTotalReview对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer approvedTotalReview;
  
  /**
   *	AttachmentNum数据库列名
   */
  public final static java.lang.String ATTACHMENTNUM_FIELD =  "AttachmentNum";
  
  /**
   *	AttachmentNum字段中文名，用于视图展示
   */
  public final static java.lang.String ATTACHMENTNUM_LABLE = "附件数量";
  
  /**
   *	AttachmentNum对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer attachmentNum;
  
  /**
   *	BarCode数据库列名
   */
  public final static java.lang.String BARCODE_FIELD =  "BarCode";
  
  /**
   *	BarCode字段中文名，用于视图展示
   */
  public final static java.lang.String BARCODE_LABLE = "商品条码";
  
  /**
   *	BarCode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String barCode;
  
  /**
   *	CategoryID数据库列名
   */
  public final static java.lang.String CATEGORYID_FIELD =  "CategoryID";
  
  /**
   *	CategoryID字段中文名，用于视图展示
   */
  public final static java.lang.String CATEGORYID_LABLE = "类别编号";
  
  /**
   *	CategoryID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long categoryID;
  
  /**
   *	ComboPrice数据库列名
   */
  public final static java.lang.String COMBOPRICE_FIELD =  "ComboPrice";
  
  /**
   *	ComboPrice字段中文名，用于视图展示
   */
  public final static java.lang.String COMBOPRICE_LABLE = "套餐价";
  
  /**
   *	ComboPrice对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal comboPrice;
  
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
   *	CurrencyID数据库列名
   */
  public final static java.lang.String CURRENCYID_FIELD =  "CurrencyID";
  
  /**
   *	CurrencyID字段中文名，用于视图展示
   */
  public final static java.lang.String CURRENCYID_LABLE = "货币编号";
  
  /**
   *	CurrencyID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long currencyID;
  
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
   *	FullDescUrl数据库列名
   */
  public final static java.lang.String FULLDESCURL_FIELD =  "FullDescUrl";
  
  /**
   *	FullDescUrl字段中文名，用于视图展示
   */
  public final static java.lang.String FULLDESCURL_LABLE = "详细介绍";
  
  /**
   *	FullDescUrl对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String fullDescUrl;
  
  /**
   *	Gtin数据库列名
   */
  public final static java.lang.String GTIN_FIELD =  "Gtin";
  
  /**
   *	Gtin字段中文名，用于视图展示
   */
  public final static java.lang.String GTIN_LABLE = "商品编码";
  
  /**
   *	Gtin对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String gtin;
  
  /**
   *	HighestPrice数据库列名
   */
  public final static java.lang.String HIGHESTPRICE_FIELD =  "HighestPrice";
  
  /**
   *	HighestPrice字段中文名，用于视图展示
   */
  public final static java.lang.String HIGHESTPRICE_LABLE = "最高价";
  
  /**
   *	HighestPrice对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal highestPrice;
  
  /**
   *	IsCombo数据库列名
   */
  public final static java.lang.String ISCOMBO_FIELD =  "IsCombo";
  
  /**
   *	IsCombo字段中文名，用于视图展示
   */
  public final static java.lang.String ISCOMBO_LABLE = "是否套餐";
  
  /**
   *	IsCombo对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean isCombo;
  
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
   *	LowestPrice数据库列名
   */
  public final static java.lang.String LOWESTPRICE_FIELD =  "LowestPrice";
  
  /**
   *	LowestPrice字段中文名，用于视图展示
   */
  public final static java.lang.String LOWESTPRICE_LABLE = "最低价";
  
  /**
   *	LowestPrice对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal lowestPrice;
  
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
   *	NotApprovedRatingSum数据库列名
   */
  public final static java.lang.String NOTAPPROVEDRATINGSUM_FIELD =  "NotApprovedRatingSum";
  
  /**
   *	NotApprovedRatingSum字段中文名，用于视图展示
   */
  public final static java.lang.String NOTAPPROVEDRATINGSUM_LABLE = "未核准评分总计";
  
  /**
   *	NotApprovedRatingSum对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer notApprovedRatingSum;
  
  /**
   *	NotApprovedTotalReview数据库列名
   */
  public final static java.lang.String NOTAPPROVEDTOTALREVIEW_FIELD =  "NotApprovedTotalReview";
  
  /**
   *	NotApprovedTotalReview字段中文名，用于视图展示
   */
  public final static java.lang.String NOTAPPROVEDTOTALREVIEW_LABLE = "未核准评论总计";
  
  /**
   *	NotApprovedTotalReview对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer notApprovedTotalReview;
  
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
   *	OriginalPrice数据库列名
   */
  public final static java.lang.String ORIGINALPRICE_FIELD =  "OriginalPrice";
  
  /**
   *	OriginalPrice字段中文名，用于视图展示
   */
  public final static java.lang.String ORIGINALPRICE_LABLE = "原价";
  
  /**
   *	OriginalPrice对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal originalPrice;
  
  /**
   *	PriceType数据库列名
   */
  public final static java.lang.String PRICETYPE_FIELD =  "PriceType";
  
  /**
   *	PriceType字段中文名，用于视图展示
   */
  public final static java.lang.String PRICETYPE_LABLE = "价格方式";
  
  /**
   *	PriceType对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long priceType;
  
  /**
   *	ProductID数据库列名
   */
  public final static java.lang.String PRODUCTID_FIELD =  "ProductID";
  
  /**
   *	ProductID字段中文名，用于视图展示
   */
  public final static java.lang.String PRODUCTID_LABLE = "商品编号";
  
  /**
   *	ProductID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long productID;
  
  /**
   *	ProductName数据库列名
   */
  public final static java.lang.String PRODUCTNAME_FIELD =  "ProductName";
  
  /**
   *	ProductName字段中文名，用于视图展示
   */
  public final static java.lang.String PRODUCTNAME_LABLE = "商品名称";
  
  /**
   *	ProductName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String productName;
  
  /**
   *	ProductStatus数据库列名
   */
  public final static java.lang.String PRODUCTSTATUS_FIELD =  "ProductStatus";
  
  /**
   *	ProductStatus字段中文名，用于视图展示
   */
  public final static java.lang.String PRODUCTSTATUS_LABLE = "商品状态";
  
  /**
   *	ProductStatus对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long productStatus;
  
  /**
   *	ShortDescription数据库列名
   */
  public final static java.lang.String SHORTDESCRIPTION_FIELD =  "ShortDescription";
  
  /**
   *	ShortDescription字段中文名，用于视图展示
   */
  public final static java.lang.String SHORTDESCRIPTION_LABLE = "简介";
  
  /**
   *	ShortDescription对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String shortDescription;
  
  /**
   *	ShowOnHomePage数据库列名
   */
  public final static java.lang.String SHOWONHOMEPAGE_FIELD =  "ShowOnHomePage";
  
  /**
   *	ShowOnHomePage字段中文名，用于视图展示
   */
  public final static java.lang.String SHOWONHOMEPAGE_LABLE = "是否首页显示";
  
  /**
   *	ShowOnHomePage对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean showOnHomePage;
  
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
   *	StarLevel数据库列名
   */
  public final static java.lang.String STARLEVEL_FIELD =  "StarLevel";
  
  /**
   *	StarLevel字段中文名，用于视图展示
   */
  public final static java.lang.String STARLEVEL_LABLE = "评价星级";
  
  /**
   *	StarLevel对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer starLevel;
  
  /**
   * 推荐信息 getter
   */
  public java.lang.String getAdminComment(){
    return adminComment;
  }
  /**
   * 推荐信息 setter
   * @param AdminComment
   */  
  public void setAdminComment(java.lang.String adminComment){
    this.adminComment = adminComment;
  }
 
  /**
   * 允许用户评论 getter
   */
  public java.lang.Boolean getAllowCustomerReview(){
    return allowCustomerReview;
  }
  /**
   * 允许用户评论 setter
   * @param AllowCustomerReview
   */  
  public void setAllowCustomerReview(java.lang.Boolean allowCustomerReview){
    this.allowCustomerReview = allowCustomerReview;
  }
 
  /**
   * 核准评分总计 getter
   */
  public java.lang.Integer getApprovedRatingSum(){
    return approvedRatingSum;
  }
  /**
   * 核准评分总计 setter
   * @param ApprovedRatingSum
   */  
  public void setApprovedRatingSum(java.lang.Integer approvedRatingSum){
    this.approvedRatingSum = approvedRatingSum;
  }
 
  /**
   * 核准评论总计 getter
   */
  public java.lang.Integer getApprovedTotalReview(){
    return approvedTotalReview;
  }
  /**
   * 核准评论总计 setter
   * @param ApprovedTotalReview
   */  
  public void setApprovedTotalReview(java.lang.Integer approvedTotalReview){
    this.approvedTotalReview = approvedTotalReview;
  }
 
  /**
   * 附件数量 getter
   */
  public java.lang.Integer getAttachmentNum(){
    return attachmentNum;
  }
  /**
   * 附件数量 setter
   * @param AttachmentNum
   */  
  public void setAttachmentNum(java.lang.Integer attachmentNum){
    this.attachmentNum = attachmentNum;
  }
 
  /**
   * 商品条码 getter
   */
  public java.lang.String getBarCode(){
    return barCode;
  }
  /**
   * 商品条码 setter
   * @param BarCode
   */  
  public void setBarCode(java.lang.String barCode){
    this.barCode = barCode;
  }
 
  /**
   * 类别编号 getter
   */
  public java.lang.Long getCategoryID(){
    return categoryID;
  }
  /**
   * 类别编号 setter
   * @param CategoryID
   */  
  public void setCategoryID(java.lang.Long categoryID){
    this.categoryID = categoryID;
  }
 
  /**
   * 套餐价 getter
   */
  public java.math.BigDecimal getComboPrice(){
    return comboPrice;
  }
  /**
   * 套餐价 setter
   * @param ComboPrice
   */  
  public void setComboPrice(java.math.BigDecimal comboPrice){
    this.comboPrice = comboPrice;
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
   * 货币编号 getter
   */
  public java.lang.Long getCurrencyID(){
    return currencyID;
  }
  /**
   * 货币编号 setter
   * @param CurrencyID
   */  
  public void setCurrencyID(java.lang.Long currencyID){
    this.currencyID = currencyID;
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
   * 详细介绍 getter
   */
  public java.lang.String getFullDescUrl(){
    return fullDescUrl;
  }
  /**
   * 详细介绍 setter
   * @param FullDescUrl
   */  
  public void setFullDescUrl(java.lang.String fullDescUrl){
    this.fullDescUrl = fullDescUrl;
  }
 
  /**
   * 商品编码 getter
   */
  public java.lang.String getGtin(){
    return gtin;
  }
  /**
   * 商品编码 setter
   * @param Gtin
   */  
  public void setGtin(java.lang.String gtin){
    this.gtin = gtin;
  }
 
  /**
   * 最高价 getter
   */
  public java.math.BigDecimal getHighestPrice(){
    return highestPrice;
  }
  /**
   * 最高价 setter
   * @param HighestPrice
   */  
  public void setHighestPrice(java.math.BigDecimal highestPrice){
    this.highestPrice = highestPrice;
  }
 
  /**
   * 是否套餐 getter
   */
  public java.lang.Boolean getIsCombo(){
    return isCombo;
  }
  /**
   * 是否套餐 setter
   * @param IsCombo
   */  
  public void setIsCombo(java.lang.Boolean isCombo){
    this.isCombo = isCombo;
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
   * 最低价 getter
   */
  public java.math.BigDecimal getLowestPrice(){
    return lowestPrice;
  }
  /**
   * 最低价 setter
   * @param LowestPrice
   */  
  public void setLowestPrice(java.math.BigDecimal lowestPrice){
    this.lowestPrice = lowestPrice;
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
   * 未核准评分总计 getter
   */
  public java.lang.Integer getNotApprovedRatingSum(){
    return notApprovedRatingSum;
  }
  /**
   * 未核准评分总计 setter
   * @param NotApprovedRatingSum
   */  
  public void setNotApprovedRatingSum(java.lang.Integer notApprovedRatingSum){
    this.notApprovedRatingSum = notApprovedRatingSum;
  }
 
  /**
   * 未核准评论总计 getter
   */
  public java.lang.Integer getNotApprovedTotalReview(){
    return notApprovedTotalReview;
  }
  /**
   * 未核准评论总计 setter
   * @param NotApprovedTotalReview
   */  
  public void setNotApprovedTotalReview(java.lang.Integer notApprovedTotalReview){
    this.notApprovedTotalReview = notApprovedTotalReview;
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
   * 原价 getter
   */
  public java.math.BigDecimal getOriginalPrice(){
    return originalPrice;
  }
  /**
   * 原价 setter
   * @param OriginalPrice
   */  
  public void setOriginalPrice(java.math.BigDecimal originalPrice){
    this.originalPrice = originalPrice;
  }
 
  /**
   * 价格方式 getter
   */
  public java.lang.Long getPriceType(){
    return priceType;
  }
  /**
   * 价格方式 setter
   * @param PriceType
   */  
  public void setPriceType(java.lang.Long priceType){
    this.priceType = priceType;
  }
 
  /**
   * 商品编号 getter
   */
  public java.lang.Long getProductID(){
    return productID;
  }
  /**
   * 商品编号 setter
   * @param ProductID
   */  
  public void setProductID(java.lang.Long productID){
    this.productID = productID;
  }
 
  /**
   * 商品名称 getter
   */
  public java.lang.String getProductName(){
    return productName;
  }
  /**
   * 商品名称 setter
   * @param ProductName
   */  
  public void setProductName(java.lang.String productName){
    this.productName = productName;
  }
 
  /**
   * 商品状态 getter
   */
  public java.lang.Long getProductStatus(){
    return productStatus;
  }
  /**
   * 商品状态 setter
   * @param ProductStatus
   */  
  public void setProductStatus(java.lang.Long productStatus){
    this.productStatus = productStatus;
  }
 
  /**
   * 简介 getter
   */
  public java.lang.String getShortDescription(){
    return shortDescription;
  }
  /**
   * 简介 setter
   * @param ShortDescription
   */  
  public void setShortDescription(java.lang.String shortDescription){
    this.shortDescription = shortDescription;
  }
 
  /**
   * 是否首页显示 getter
   */
  public java.lang.Boolean getShowOnHomePage(){
    return showOnHomePage;
  }
  /**
   * 是否首页显示 setter
   * @param ShowOnHomePage
   */  
  public void setShowOnHomePage(java.lang.Boolean showOnHomePage){
    this.showOnHomePage = showOnHomePage;
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
   * 评价星级 getter
   */
  public java.lang.Integer getStarLevel(){
    return starLevel;
  }
  /**
   * 评价星级 setter
   * @param StarLevel
   */  
  public void setStarLevel(java.lang.Integer starLevel){
    this.starLevel = starLevel;
  }
 
}