package cc.toprank.byd.entity;

/**********************************************************************************************************************
 *
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在B_MerchantInfo类中进行修改
 *
 * ********************************************************************************************************************/
public class B_MerchantInfoEntityBase extends Entity {

    /**
     * ArchiveCode数据库列名
     */
    public final static java.lang.String ARCHIVECODE_FIELD = "ArchiveCode";

    /**
     * ArchiveCode字段中文名，用于视图展示
     */
    public final static java.lang.String ARCHIVECODE_LABLE = "档案编码";

    /**
     * ArchiveCode对应的java字段名,业务操作使用这个字段。
     */
    private java.lang.String archiveCode;

    /**
     * ArchiveID数据库列名
     */
    public final static java.lang.String ARCHIVEID_FIELD = "ArchiveID";

    /**
     * ArchiveID字段中文名，用于视图展示
     */
    public final static java.lang.String ARCHIVEID_LABLE = "档案编号";

    /**
     * ArchiveID对应的java字段名,业务操作使用这个字段。
     */
    private java.lang.Long archiveID;

    /**
     * AroundDesc数据库列名
     */
    public final static java.lang.String AROUNDDESC_FIELD = "AroundDesc";

    /**
     * AroundDesc字段中文名，用于视图展示
     */
    public final static java.lang.String AROUNDDESC_LABLE = "周边说明";

    /**
     * AroundDesc对应的java字段名,业务操作使用这个字段。
     */
    private java.lang.String aroundDesc;

    /**
     * AttachmentNumber数据库列名
     */
    public final static java.lang.String ATTACHMENTNUMBER_FIELD = "AttachmentNumber";

    /**
     * AttachmentNumber字段中文名，用于视图展示
     */
    public final static java.lang.String ATTACHMENTNUMBER_LABLE = "附件数";

    /**
     * AttachmentNumber对应的java字段名,业务操作使用这个字段。
     */
    private java.lang.Integer attachmentNumber;

    /**
     * BranchArea数据库列名
     */
    public final static java.lang.String BRANCHAREA_FIELD = "BranchArea";

    /**
     * BranchArea字段中文名，用于视图展示
     */
    public final static java.lang.String BRANCHAREA_LABLE = "网点面积";

    /**
     * BranchArea对应的java字段名,业务操作使用这个字段。
     */
    private java.lang.String branchArea;

    /**
     * BusinessCategory数据库列名
     */
    public final static java.lang.String BUSINESSCATEGORY_FIELD = "BusinessCategory";

    /**
     * BusinessCategory字段中文名，用于视图展示
     */
    public final static java.lang.String BUSINESSCATEGORY_LABLE = "经营品类";

    /**
     * BusinessCategory对应的java字段名,业务操作使用这个字段。
     */
    private java.lang.String businessCategory;

    /**
     * BusinessLicense数据库列名
     */
    public final static java.lang.String BUSINESSLICENSE_FIELD = "BusinessLicense";

    /**
     * BusinessLicense字段中文名，用于视图展示
     */
    public final static java.lang.String BUSINESSLICENSE_LABLE = "营业执照";

    /**
     * BusinessLicense对应的java字段名,业务操作使用这个字段。
     */
    private java.lang.String businessLicense;

    /**
     * CreateTime数据库列名
     */
    public final static java.lang.String CREATETIME_FIELD = "CreateTime";

    /**
     * CreateTime字段中文名，用于视图展示
     */
    public final static java.lang.String CREATETIME_LABLE = "创建时间";

    /**
     * CreateTime对应的java字段名,业务操作使用这个字段。
     */
    private java.time.LocalDateTime createTime;

    /**
     * CreatorID数据库列名
     */
    public final static java.lang.String CREATORID_FIELD = "CreatorID";

    /**
     * CreatorID字段中文名，用于视图展示
     */
    public final static java.lang.String CREATORID_LABLE = "创建人";

    /**
     * CreatorID对应的java字段名,业务操作使用这个字段。
     */
    private java.lang.Long creatorID;

    /**
     * CredentialCode数据库列名
     */
    public final static java.lang.String CREDENTIALCODE_FIELD = "CredentialCode";

    /**
     * CredentialCode字段中文名，用于视图展示
     */
    public final static java.lang.String CREDENTIALCODE_LABLE = "证件号码";

    /**
     * CredentialCode对应的java字段名,业务操作使用这个字段。
     */
    private java.lang.String credentialCode;

    /**
     * CredentialType数据库列名
     */
    public final static java.lang.String CREDENTIALTYPE_FIELD = "CredentialType";

    /**
     * CredentialType字段中文名，用于视图展示
     */
    public final static java.lang.String CREDENTIALTYPE_LABLE = "证件类型";

    /**
     * CredentialType对应的java字段名,业务操作使用这个字段。
     */
    private java.lang.Long credentialType;

    /**
     * DailyRidership数据库列名
     */
    public final static java.lang.String DAILYRIDERSHIP_FIELD = "DailyRidership";

    /**
     * DailyRidership字段中文名，用于视图展示
     */
    public final static java.lang.String DAILYRIDERSHIP_LABLE = "日客流量";

    /**
     * DailyRidership对应的java字段名,业务操作使用这个字段。
     */
    private java.lang.String dailyRidership;

    /**
     * DailyTurnover数据库列名
     */
    public final static java.lang.String DAILYTURNOVER_FIELD = "DailyTurnover";

    /**
     * DailyTurnover字段中文名，用于视图展示
     */
    public final static java.lang.String DAILYTURNOVER_LABLE = "日流水";

    /**
     * DailyTurnover对应的java字段名,业务操作使用这个字段。
     */
    private java.math.BigDecimal dailyTurnover;

    /**
     * DepositAmount数据库列名
     */
    public final static java.lang.String DEPOSITAMOUNT_FIELD = "DepositAmount";

    /**
     * DepositAmount字段中文名，用于视图展示
     */
    public final static java.lang.String DEPOSITAMOUNT_LABLE = "押金金额";

    /**
     * DepositAmount对应的java字段名,业务操作使用这个字段。
     */
    private java.math.BigDecimal depositAmount;

    /**
     * Developer数据库列名
     */
    public final static java.lang.String DEVELOPER_FIELD = "Developer";

    /**
     * Developer字段中文名，用于视图展示
     */
    public final static java.lang.String DEVELOPER_LABLE = "开发人员";

    /**
     * Developer对应的java字段名,业务操作使用这个字段。
     */
    private java.lang.Long developer;

    /**
     * DeveloperMobile数据库列名
     */
    public final static java.lang.String DEVELOPERMOBILE_FIELD = "DeveloperMobile";

    /**
     * DeveloperMobile字段中文名，用于视图展示
     */
    public final static java.lang.String DEVELOPERMOBILE_LABLE = "手机";

    /**
     * DeveloperMobile对应的java字段名,业务操作使用这个字段。
     */
    private java.lang.String developerMobile;

    /**
     * DevelopTime数据库列名
     */
    public final static java.lang.String DEVELOPTIME_FIELD = "DevelopTime";

    /**
     * DevelopTime字段中文名，用于视图展示
     */
    public final static java.lang.String DEVELOPTIME_LABLE = "开发时间";

    /**
     * DevelopTime对应的java字段名,业务操作使用这个字段。
     */
    private java.time.LocalDateTime developTime;

    /**
     * EffectiveTime数据库列名
     */
    public final static java.lang.String EFFECTIVETIME_FIELD = "EffectiveTime";

    /**
     * EffectiveTime字段中文名，用于视图展示
     */
    public final static java.lang.String EFFECTIVETIME_LABLE = "生效时间";

    /**
     * EffectiveTime对应的java字段名,业务操作使用这个字段。
     */
    private java.time.LocalDateTime effectiveTime;

    /**
     * ExpireTime数据库列名
     */
    public final static java.lang.String EXPIRETIME_FIELD = "ExpireTime";

    /**
     * ExpireTime字段中文名，用于视图展示
     */
    public final static java.lang.String EXPIRETIME_LABLE = "截止时间";

    /**
     * ExpireTime对应的java字段名,业务操作使用这个字段。
     */
    private java.time.LocalDateTime expireTime;

    /**
     * FirstLetter数据库列名
     */
    public final static java.lang.String FIRSTLETTER_FIELD = "FirstLetter";

    /**
     * FirstLetter字段中文名，用于视图展示
     */
    public final static java.lang.String FIRSTLETTER_LABLE = "首拼";

    /**
     * FirstLetter对应的java字段名,业务操作使用这个字段。
     */
    private java.lang.String firstLetter;

    /**
     * HasDeposit数据库列名
     */
    public final static java.lang.String HASDEPOSIT_FIELD = "HasDeposit";

    /**
     * HasDeposit字段中文名，用于视图展示
     */
    public final static java.lang.String HASDEPOSIT_LABLE = "有否押金";

    /**
     * HasDeposit对应的java字段名,业务操作使用这个字段。
     */
    private java.lang.Boolean hasDeposit;

    /**
     * HelpfulNoTotal数据库列名
     */
    public final static java.lang.String HELPFULNOTOTAL_FIELD = "HelpfulNoTotal";

    /**
     * HelpfulNoTotal字段中文名，用于视图展示
     */
    public final static java.lang.String HELPFULNOTOTAL_LABLE = "差评数";

    /**
     * HelpfulNoTotal对应的java字段名,业务操作使用这个字段。
     */
    private java.lang.Integer helpfulNoTotal;

    /**
     * HelpfulYesTotal数据库列名
     */
    public final static java.lang.String HELPFULYESTOTAL_FIELD = "HelpfulYesTotal";

    /**
     * HelpfulYesTotal字段中文名，用于视图展示
     */
    public final static java.lang.String HELPFULYESTOTAL_LABLE = "好评数";

    /**
     * HelpfulYesTotal对应的java字段名,业务操作使用这个字段。
     */
    private java.lang.Integer helpfulYesTotal;

    /**
     * IntelligentStar数据库列名
     */
    public final static java.lang.String INTELLIGENTSTAR_FIELD = "IntelligentStar";

    /**
     * IntelligentStar字段中文名，用于视图展示
     */
    public final static java.lang.String INTELLIGENTSTAR_LABLE = "智慧星级";

    /**
     * IntelligentStar对应的java字段名,业务操作使用这个字段。
     */
    private java.lang.Integer intelligentStar;

    /**
     * IsSync数据库列名
     */
    public final static java.lang.String ISSYNC_FIELD = "IsSync";

    /**
     * IsSync字段中文名，用于视图展示
     */
    public final static java.lang.String ISSYNC_LABLE = "是否同步";

    /**
     * IsSync对应的java字段名,业务操作使用这个字段。
     */
    private java.lang.Boolean isSync;

    /**
     * LegalPerson数据库列名
     */
    public final static java.lang.String LEGALPERSON_FIELD = "LegalPerson";

    /**
     * LegalPerson字段中文名，用于视图展示
     */
    public final static java.lang.String LEGALPERSON_LABLE = "法人姓名";

    /**
     * LegalPerson对应的java字段名,业务操作使用这个字段。
     */
    private java.lang.String legalPerson;

    /**
     * ManagerEmail数据库列名
     */
    public final static java.lang.String MANAGEREMAIL_FIELD = "ManagerEmail";

    /**
     * ManagerEmail字段中文名，用于视图展示
     */
    public final static java.lang.String MANAGEREMAIL_LABLE = "负责人邮箱";

    /**
     * ManagerEmail对应的java字段名,业务操作使用这个字段。
     */
    private java.lang.String managerEmail;

    /**
     * ManagerMobile数据库列名
     */
    public final static java.lang.String MANAGERMOBILE_FIELD = "ManagerMobile";

    /**
     * ManagerMobile字段中文名，用于视图展示
     */
    public final static java.lang.String MANAGERMOBILE_LABLE = "负责人手机";

    /**
     * ManagerMobile对应的java字段名,业务操作使用这个字段。
     */
    private java.lang.String managerMobile;

    /**
     * ManagerPhone数据库列名
     */
    public final static java.lang.String MANAGERPHONE_FIELD = "ManagerPhone";

    /**
     * ManagerPhone字段中文名，用于视图展示
     */
    public final static java.lang.String MANAGERPHONE_LABLE = "负责人电话";

    /**
     * ManagerPhone对应的java字段名,业务操作使用这个字段。
     */
    private java.lang.String managerPhone;

    /**
     * MarchantManager数据库列名
     */
    public final static java.lang.String MARCHANTMANAGER_FIELD = "MarchantManager";

    /**
     * MarchantManager字段中文名，用于视图展示
     */
    public final static java.lang.String MARCHANTMANAGER_LABLE = "商户负责人";

    /**
     * MarchantManager对应的java字段名,业务操作使用这个字段。
     */
    private java.lang.String marchantManager;

    /**
     * MarchantStatus数据库列名
     */
    public final static java.lang.String MARCHANTSTATUS_FIELD = "MarchantStatus";

    /**
     * MarchantStatus字段中文名，用于视图展示
     */
    public final static java.lang.String MARCHANTSTATUS_LABLE = "商户状态";

    /**
     * MarchantStatus对应的java字段名,业务操作使用这个字段。
     */
    private java.lang.Long marchantStatus;

    /**
     * Memo数据库列名
     */
    public final static java.lang.String MEMO_FIELD = "Memo";

    /**
     * Memo字段中文名，用于视图展示
     */
    public final static java.lang.String MEMO_LABLE = "备注";

    /**
     * Memo对应的java字段名,业务操作使用这个字段。
     */
    private java.lang.String memo;

    /**
     * MerchantLevel数据库列名
     */
    public final static java.lang.String MERCHANTLEVEL_FIELD = "MerchantLevel";

    /**
     * MerchantLevel字段中文名，用于视图展示
     */
    public final static java.lang.String MERCHANTLEVEL_LABLE = "商户级别";

    /**
     * MerchantLevel对应的java字段名,业务操作使用这个字段。
     */
    private java.lang.Long merchantLevel;

    /**
     * MerchantName数据库列名
     */
    public final static java.lang.String MERCHANTNAME_FIELD = "MerchantName";

    /**
     * MerchantName字段中文名，用于视图展示
     */
    public final static java.lang.String MERCHANTNAME_LABLE = "商户名称";

    /**
     * MerchantName对应的java字段名,业务操作使用这个字段。
     */
    private java.lang.String merchantName;

    /**
     * MerchantType数据库列名
     */
    public final static java.lang.String MERCHANTTYPE_FIELD = "MerchantType";

    /**
     * MerchantType字段中文名，用于视图展示
     */
    public final static java.lang.String MERCHANTTYPE_LABLE = "商户类型";

    /**
     * MerchantType对应的java字段名,业务操作使用这个字段。
     */
    private java.lang.Long merchantType;

    /**
     * NetworkType数据库列名
     */
    public final static java.lang.String NETWORKTYPE_FIELD = "NetworkType";

    /**
     * NetworkType字段中文名，用于视图展示
     */
    public final static java.lang.String NETWORKTYPE_LABLE = "网络类别";

    /**
     * NetworkType对应的java字段名,业务操作使用这个字段。
     */
    private java.lang.Long networkType;

    /**
     * OrgID数据库列名
     */
    public final static java.lang.String ORGID_FIELD = "OrgID";

    /**
     * OrgID字段中文名，用于视图展示
     */
    public final static java.lang.String ORGID_LABLE = "机构编号";

    /**
     * OrgID对应的java字段名,业务操作使用这个字段。
     */
    private java.lang.Long orgID;

    /**
     * PaymentMethod数据库列名
     */
    public final static java.lang.String PAYMENTMETHOD_FIELD = "PaymentMethod";

    /**
     * PaymentMethod字段中文名，用于视图展示
     */
    public final static java.lang.String PAYMENTMETHOD_LABLE = "支付方式";

    /**
     * PaymentMethod对应的java字段名,业务操作使用这个字段。
     */
    private java.lang.Long paymentMethod;

    /**
     * PerCapita数据库列名
     */
    public final static java.lang.String PERCAPITA_FIELD = "PerCapita";

    /**
     * PerCapita字段中文名，用于视图展示
     */
    public final static java.lang.String PERCAPITA_LABLE = "人均消费";

    /**
     * PerCapita对应的java字段名,业务操作使用这个字段。
     */
    private java.math.BigDecimal perCapita;

    /**
     * RegistrationCode数据库列名
     */
    public final static java.lang.String REGISTRATIONCODE_FIELD = "RegistrationCode";

    /**
     * RegistrationCode字段中文名，用于视图展示
     */
    public final static java.lang.String REGISTRATIONCODE_LABLE = "注册号";

    /**
     * RegistrationCode对应的java字段名,业务操作使用这个字段。
     */
    private java.lang.String registrationCode;

    /**
     * RenewalNumber数据库列名
     */
    public final static java.lang.String RENEWALNUMBER_FIELD = "RenewalNumber";

    /**
     * RenewalNumber字段中文名，用于视图展示
     */
    public final static java.lang.String RENEWALNUMBER_LABLE = "续约次数";

    /**
     * RenewalNumber对应的java字段名,业务操作使用这个字段。
     */
    private java.lang.Integer renewalNumber;

    /**
     * StarLevel数据库列名
     */
    public final static java.lang.String STARLEVEL_FIELD = "StarLevel";

    /**
     * StarLevel字段中文名，用于视图展示
     */
    public final static java.lang.String STARLEVEL_LABLE = "评价星级";

    /**
     * StarLevel对应的java字段名,业务操作使用这个字段。
     */
    private java.lang.Integer starLevel;

    /**
     * 档案编码 getter
     */
    public java.lang.String getArchiveCode() {
        return archiveCode;
    }

    /**
     * 档案编码 setter
     *
     * @param ArchiveCode
     */
    public void setArchiveCode(java.lang.String archiveCode) {
        this.archiveCode = archiveCode;
    }

    /**
     * 档案编号 getter
     */
    public java.lang.Long getArchiveID() {
        return archiveID;
    }

    /**
     * 档案编号 setter
     *
     * @param ArchiveID
     */
    public void setArchiveID(java.lang.Long archiveID) {
        this.archiveID = archiveID;
    }

    /**
     * 周边说明 getter
     */
    public java.lang.String getAroundDesc() {
        return aroundDesc;
    }

    /**
     * 周边说明 setter
     *
     * @param AroundDesc
     */
    public void setAroundDesc(java.lang.String aroundDesc) {
        this.aroundDesc = aroundDesc;
    }

    /**
     * 附件数 getter
     */
    public java.lang.Integer getAttachmentNumber() {
        return attachmentNumber;
    }

    /**
     * 附件数 setter
     *
     * @param AttachmentNumber
     */
    public void setAttachmentNumber(java.lang.Integer attachmentNumber) {
        this.attachmentNumber = attachmentNumber;
    }

    /**
     * 网点面积 getter
     */
    public java.lang.String getBranchArea() {
        return branchArea;
    }

    /**
     * 网点面积 setter
     *
     * @param BranchArea
     */
    public void setBranchArea(java.lang.String branchArea) {
        this.branchArea = branchArea;
    }

    /**
     * 经营品类 getter
     */
    public java.lang.String getBusinessCategory() {
        return businessCategory;
    }

    /**
     * 经营品类 setter
     *
     * @param BusinessCategory
     */
    public void setBusinessCategory(java.lang.String businessCategory) {
        this.businessCategory = businessCategory;
    }

    /**
     * 营业执照 getter
     */
    public java.lang.String getBusinessLicense() {
        return businessLicense;
    }

    /**
     * 营业执照 setter
     *
     * @param BusinessLicense
     */
    public void setBusinessLicense(java.lang.String businessLicense) {
        this.businessLicense = businessLicense;
    }

    /**
     * 创建时间 getter
     */
    public java.time.LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间 setter
     *
     * @param CreateTime
     */
    public void setCreateTime(java.time.LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * 创建人 getter
     */
    public java.lang.Long getCreatorID() {
        return creatorID;
    }

    /**
     * 创建人 setter
     *
     * @param CreatorID
     */
    public void setCreatorID(java.lang.Long creatorID) {
        this.creatorID = creatorID;
    }

    /**
     * 证件号码 getter
     */
    public java.lang.String getCredentialCode() {
        return credentialCode;
    }

    /**
     * 证件号码 setter
     *
     * @param CredentialCode
     */
    public void setCredentialCode(java.lang.String credentialCode) {
        this.credentialCode = credentialCode;
    }

    /**
     * 证件类型 getter
     */
    public java.lang.Long getCredentialType() {
        return credentialType;
    }

    /**
     * 证件类型 setter
     *
     * @param CredentialType
     */
    public void setCredentialType(java.lang.Long credentialType) {
        this.credentialType = credentialType;
    }

    /**
     * 日客流量 getter
     */
    public java.lang.String getDailyRidership() {
        return dailyRidership;
    }

    /**
     * 日客流量 setter
     *
     * @param DailyRidership
     */
    public void setDailyRidership(java.lang.String dailyRidership) {
        this.dailyRidership = dailyRidership;
    }

    /**
     * 日流水 getter
     */
    public java.math.BigDecimal getDailyTurnover() {
        return dailyTurnover;
    }

    /**
     * 日流水 setter
     *
     * @param DailyTurnover
     */
    public void setDailyTurnover(java.math.BigDecimal dailyTurnover) {
        this.dailyTurnover = dailyTurnover;
    }

    /**
     * 押金金额 getter
     */
    public java.math.BigDecimal getDepositAmount() {
        return depositAmount;
    }

    /**
     * 押金金额 setter
     *
     * @param DepositAmount
     */
    public void setDepositAmount(java.math.BigDecimal depositAmount) {
        this.depositAmount = depositAmount;
    }

    /**
     * 开发人员 getter
     */
    public java.lang.Long getDeveloper() {
        return developer;
    }

    /**
     * 开发人员 setter
     *
     * @param Developer
     */
    public void setDeveloper(java.lang.Long developer) {
        this.developer = developer;
    }

    /**
     * 手机 getter
     */
    public java.lang.String getDeveloperMobile() {
        return developerMobile;
    }

    /**
     * 手机 setter
     *
     * @param DeveloperMobile
     */
    public void setDeveloperMobile(java.lang.String developerMobile) {
        this.developerMobile = developerMobile;
    }

    /**
     * 开发时间 getter
     */
    public java.time.LocalDateTime getDevelopTime() {
        return developTime;
    }

    /**
     * 开发时间 setter
     *
     * @param DevelopTime
     */
    public void setDevelopTime(java.time.LocalDateTime developTime) {
        this.developTime = developTime;
    }

    /**
     * 生效时间 getter
     */
    public java.time.LocalDateTime getEffectiveTime() {
        return effectiveTime;
    }

    /**
     * 生效时间 setter
     *
     * @param EffectiveTime
     */
    public void setEffectiveTime(java.time.LocalDateTime effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    /**
     * 截止时间 getter
     */
    public java.time.LocalDateTime getExpireTime() {
        return expireTime;
    }

    /**
     * 截止时间 setter
     *
     * @param ExpireTime
     */
    public void setExpireTime(java.time.LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }

    /**
     * 首拼 getter
     */
    public java.lang.String getFirstLetter() {
        return firstLetter;
    }

    /**
     * 首拼 setter
     *
     * @param FirstLetter
     */
    public void setFirstLetter(java.lang.String firstLetter) {
        this.firstLetter = firstLetter;
    }

    /**
     * 有否押金 getter
     */
    public java.lang.Boolean getHasDeposit() {
        return hasDeposit;
    }

    /**
     * 有否押金 setter
     *
     * @param HasDeposit
     */
    public void setHasDeposit(java.lang.Boolean hasDeposit) {
        this.hasDeposit = hasDeposit;
    }

    /**
     * 差评数 getter
     */
    public java.lang.Integer getHelpfulNoTotal() {
        return helpfulNoTotal;
    }

    /**
     * 差评数 setter
     *
     * @param HelpfulNoTotal
     */
    public void setHelpfulNoTotal(java.lang.Integer helpfulNoTotal) {
        this.helpfulNoTotal = helpfulNoTotal;
    }

    /**
     * 好评数 getter
     */
    public java.lang.Integer getHelpfulYesTotal() {
        return helpfulYesTotal;
    }

    /**
     * 好评数 setter
     *
     * @param HelpfulYesTotal
     */
    public void setHelpfulYesTotal(java.lang.Integer helpfulYesTotal) {
        this.helpfulYesTotal = helpfulYesTotal;
    }

    /**
     * 智慧星级 getter
     */
    public java.lang.Integer getIntelligentStar() {
        return intelligentStar;
    }

    /**
     * 智慧星级 setter
     *
     * @param IntelligentStar
     */
    public void setIntelligentStar(java.lang.Integer intelligentStar) {
        this.intelligentStar = intelligentStar;
    }

    /**
     * 是否同步 getter
     */
    public java.lang.Boolean getIsSync() {
        return isSync;
    }

    /**
     * 是否同步 setter
     *
     * @param IsSync
     */
    public void setIsSync(java.lang.Boolean isSync) {
        this.isSync = isSync;
    }

    /**
     * 法人姓名 getter
     */
    public java.lang.String getLegalPerson() {
        return legalPerson;
    }

    /**
     * 法人姓名 setter
     *
     * @param LegalPerson
     */
    public void setLegalPerson(java.lang.String legalPerson) {
        this.legalPerson = legalPerson;
    }

    /**
     * 负责人邮箱 getter
     */
    public java.lang.String getManagerEmail() {
        return managerEmail;
    }

    /**
     * 负责人邮箱 setter
     *
     * @param ManagerEmail
     */
    public void setManagerEmail(java.lang.String managerEmail) {
        this.managerEmail = managerEmail;
    }

    /**
     * 负责人手机 getter
     */
    public java.lang.String getManagerMobile() {
        return managerMobile;
    }

    /**
     * 负责人手机 setter
     *
     * @param ManagerMobile
     */
    public void setManagerMobile(java.lang.String managerMobile) {
        this.managerMobile = managerMobile;
    }

    /**
     * 负责人电话 getter
     */
    public java.lang.String getManagerPhone() {
        return managerPhone;
    }

    /**
     * 负责人电话 setter
     *
     * @param ManagerPhone
     */
    public void setManagerPhone(java.lang.String managerPhone) {
        this.managerPhone = managerPhone;
    }

    /**
     * 商户负责人 getter
     */
    public java.lang.String getMarchantManager() {
        return marchantManager;
    }

    /**
     * 商户负责人 setter
     *
     * @param MarchantManager
     */
    public void setMarchantManager(java.lang.String marchantManager) {
        this.marchantManager = marchantManager;
    }

    /**
     * 商户状态 getter
     */
    public java.lang.Long getMarchantStatus() {
        return marchantStatus;
    }

    /**
     * 商户状态 setter
     *
     * @param MarchantStatus
     */
    public void setMarchantStatus(java.lang.Long marchantStatus) {
        this.marchantStatus = marchantStatus;
    }

    /**
     * 备注 getter
     */
    public java.lang.String getMemo() {
        return memo;
    }

    /**
     * 备注 setter
     *
     * @param Memo
     */
    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    /**
     * 商户级别 getter
     */
    public java.lang.Long getMerchantLevel() {
        return merchantLevel;
    }

    /**
     * 商户级别 setter
     *
     * @param MerchantLevel
     */
    public void setMerchantLevel(java.lang.Long merchantLevel) {
        this.merchantLevel = merchantLevel;
    }

    /**
     * 商户名称 getter
     */
    public java.lang.String getMerchantName() {
        return merchantName;
    }

    /**
     * 商户名称 setter
     *
     * @param MerchantName
     */
    public void setMerchantName(java.lang.String merchantName) {
        this.merchantName = merchantName;
    }

    /**
     * 商户类型 getter
     */
    public java.lang.Long getMerchantType() {
        return merchantType;
    }

    /**
     * 商户类型 setter
     *
     * @param MerchantType
     */
    public void setMerchantType(java.lang.Long merchantType) {
        this.merchantType = merchantType;
    }

    /**
     * 网络类别 getter
     */
    public java.lang.Long getNetworkType() {
        return networkType;
    }

    /**
     * 网络类别 setter
     *
     * @param NetworkType
     */
    public void setNetworkType(java.lang.Long networkType) {
        this.networkType = networkType;
    }

    /**
     * 机构编号 getter
     */
    public java.lang.Long getOrgID() {
        return orgID;
    }

    /**
     * 机构编号 setter
     *
     * @param OrgID
     */
    public void setOrgID(java.lang.Long orgID) {
        this.orgID = orgID;
    }

    /**
     * 支付方式 getter
     */
    public java.lang.Long getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * 支付方式 setter
     *
     * @param PaymentMethod
     */
    public void setPaymentMethod(java.lang.Long paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * 人均消费 getter
     */
    public java.math.BigDecimal getPerCapita() {
        return perCapita;
    }

    /**
     * 人均消费 setter
     *
     * @param PerCapita
     */
    public void setPerCapita(java.math.BigDecimal perCapita) {
        this.perCapita = perCapita;
    }

    /**
     * 注册号 getter
     */
    public java.lang.String getRegistrationCode() {
        return registrationCode;
    }

    /**
     * 注册号 setter
     *
     * @param RegistrationCode
     */
    public void setRegistrationCode(java.lang.String registrationCode) {
        this.registrationCode = registrationCode;
    }

    /**
     * 续约次数 getter
     */
    public java.lang.Integer getRenewalNumber() {
        return renewalNumber;
    }

    /**
     * 续约次数 setter
     *
     * @param RenewalNumber
     */
    public void setRenewalNumber(java.lang.Integer renewalNumber) {
        this.renewalNumber = renewalNumber;
    }

    /**
     * 评价星级 getter
     */
    public java.lang.Integer getStarLevel() {
        return starLevel;
    }

    /**
     * 评价星级 setter
     *
     * @param StarLevel
     */
    public void setStarLevel(java.lang.Integer starLevel) {
        this.starLevel = starLevel;
    }

}