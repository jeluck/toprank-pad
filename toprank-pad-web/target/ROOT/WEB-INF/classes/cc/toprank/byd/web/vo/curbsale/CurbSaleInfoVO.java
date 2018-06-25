package cc.toprank.byd.web.vo.curbsale;

import java.time.LocalDateTime;

/**
 * 沽清列表显示信息VO(沽清前列表，沽清后列表通用)
 */
public class CurbSaleInfoVO {

    private Long hisID; // 历史编号
    private Long storeDay; //沽清日期
    private Long mappingID; //关联编号
    private Long menuID; //菜单编号
    private Long productID; //商品编号
    private String productName; //商品名称
    private Long variantID; //变体编号
    private String variantName; //变体名称
    private String productCode; //商品编码
    private Integer productType; //商品类型 (CASE WHEN m.IsCombo = 1 THEN 1 ELSE 2 END) AS productType,
    private Boolean needWeigh; //需要称重
    private String firstLetter; //首拼
    private Long parentID; //一级分类ID
    private String firstCategoryName; //一级分类
    private Long categoryID; //二级分类ID
    private String secondCategoryName; //二级分类
    private Long unitID; //单位编号
    private String unitName; //单位名称
    private Long optionID; //选项编号
    private String optionName; //选项名称
    private Integer preOrderQuantity; //本日预定数量
    private Float preOrderFloatQuantity; //本日预订小数
    private Integer initQuantity; //初始数量
    private Float initFloatQuantity; //小数数量
    private Integer orderedQuantity; //已点数量
    private Float orderedFloatQuantity; //已点小数
    private Integer lossQuantity;  //报损数量
    private Float lossFloatQuantity; //报损小数
    private Integer remainingQuantity; //剩余数量
    private Float remainingFloatQuantity; //剩余小数
    private String status; //状态
    private LocalDateTime createTime; //创建时间
    private Integer optionIDSum; //规格数量
    private Long archiveID; //商户编号
    private Long orgID; //机构编号
    private Long warehouseID; //仓库编号
    private Long shelfID;
    private Long containerID;
    private Long receiptID;
    private Long configReason;
    private String memo;
    private Boolean isTotal;

    public Long getHisID() {
        return hisID;
    }

    public void setHisID(Long hisID) {
        this.hisID = hisID;
    }

    public Long getStoreDay() {
        return storeDay;
    }

    public void setStoreDay(Long storeDay) {
        this.storeDay = storeDay;
    }

    public Long getMappingID() {
        return mappingID;
    }

    public void setMappingID(Long mappingID) {
        this.mappingID = mappingID;
    }

    public Long getMenuID() {
        return menuID;
    }

    public void setMenuID(Long menuID) {
        this.menuID = menuID;
    }

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getVariantID() {
        return variantID;
    }

    public void setVariantID(Long variantID) {
        this.variantID = variantID;
    }

    public String getVariantName() {
        return variantName;
    }

    public void setVariantName(String variantName) {
        this.variantName = variantName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public Boolean getNeedWeigh() {
        return needWeigh;
    }

    public void setNeedWeigh(Boolean needWeigh) {
        this.needWeigh = needWeigh;
    }

    public String getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter;
    }

    public Long getParentID() {
        return parentID;
    }

    public void setParentID(Long parentID) {
        this.parentID = parentID;
    }

    public String getFirstCategoryName() {
        return firstCategoryName;
    }

    public void setFirstCategoryName(String firstCategoryName) {
        this.firstCategoryName = firstCategoryName;
    }

    public Long getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Long categoryID) {
        this.categoryID = categoryID;
    }

    public String getSecondCategoryName() {
        return secondCategoryName;
    }

    public void setSecondCategoryName(String secondCategoryName) {
        this.secondCategoryName = secondCategoryName;
    }

    public Long getUnitID() {
        return unitID;
    }

    public void setUnitID(Long unitID) {
        this.unitID = unitID;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Long getOptionID() {
        return optionID;
    }

    public void setOptionID(Long optionID) {
        this.optionID = optionID;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public Integer getPreOrderQuantity() {
        return preOrderQuantity;
    }

    public void setPreOrderQuantity(Integer preOrderQuantity) {
        this.preOrderQuantity = preOrderQuantity;
    }

    public Float getPreOrderFloatQuantity() {
        return preOrderFloatQuantity;
    }

    public void setPreOrderFloatQuantity(Float preOrderFloatQuantity) {
        this.preOrderFloatQuantity = preOrderFloatQuantity;
    }

    public Integer getInitQuantity() {
        return initQuantity;
    }

    public void setInitQuantity(Integer initQuantity) {
        this.initQuantity = initQuantity;
    }

    public Float getInitFloatQuantity() {
        return initFloatQuantity;
    }

    public void setInitFloatQuantity(Float initFloatQuantity) {
        this.initFloatQuantity = initFloatQuantity;
    }

    public Integer getOrderedQuantity() {
        return orderedQuantity;
    }

    public void setOrderedQuantity(Integer orderedQuantity) {
        this.orderedQuantity = orderedQuantity;
    }

    public Float getOrderedFloatQuantity() {
        return orderedFloatQuantity;
    }

    public void setOrderedFloatQuantity(Float orderedFloatQuantity) {
        this.orderedFloatQuantity = orderedFloatQuantity;
    }

    public Integer getLossQuantity() {
        return lossQuantity;
    }

    public void setLossQuantity(Integer lossQuantity) {
        this.lossQuantity = lossQuantity;
    }

    public Float getLossFloatQuantity() {
        return lossFloatQuantity;
    }

    public void setLossFloatQuantity(Float lossFloatQuantity) {
        this.lossFloatQuantity = lossFloatQuantity;
    }

    public Integer getRemainingQuantity() {
        return remainingQuantity;
    }

    public void setRemainingQuantity(Integer remainingQuantity) {
        this.remainingQuantity = remainingQuantity;
    }

    public Float getRemainingFloatQuantity() {
        return remainingFloatQuantity;
    }

    public void setRemainingFloatQuantity(Float remainingFloatQuantity) {
        this.remainingFloatQuantity = remainingFloatQuantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getOptionIDSum() {
        return optionIDSum;
    }

    public void setOptionIDSum(Integer optionIDSum) {
        this.optionIDSum = optionIDSum;
    }

    public Long getArchiveID() {
        return archiveID;
    }

    public void setArchiveID(Long archiveID) {
        this.archiveID = archiveID;
    }

    public Long getOrgID() {
        return orgID;
    }

    public void setOrgID(Long orgID) {
        this.orgID = orgID;
    }

    public Long getWarehouseID() {
        return warehouseID;
    }

    public void setWarehouseID(Long warehouseID) {
        this.warehouseID = warehouseID;
    }

    public Long getShelfID() {
        return shelfID;
    }

    public void setShelfID(Long shelfID) {
        this.shelfID = shelfID;
    }

    public Long getContainerID() {
        return containerID;
    }

    public void setContainerID(Long containerID) {
        this.containerID = containerID;
    }

    public Long getReceiptID() {
        return receiptID;
    }

    public void setReceiptID(Long receiptID) {
        this.receiptID = receiptID;
    }

    public Long getConfigReason() {
        return configReason;
    }

    public void setConfigReason(Long configReason) {
        this.configReason = configReason;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Boolean getTotal() {
        return isTotal;
    }

    public void setTotal(Boolean total) {
        isTotal = total;
    }
}
