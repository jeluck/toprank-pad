package cc.toprank.byd.web.vo.curbsale;

import java.time.LocalDateTime;

/**
 *  沽清历史操作信息
 */
public class CurbSaleOperationHistoryVO {
    private Long dealID;    //日志编号
    private Long mappingID; //关联编号
    private String productName; //商品名称
    private String firstLetter; //首拼
    private Boolean needWeigh; //是否称重
    private Long changeType;    //操作类型
    private String changeTypeName; //操作类型名称
    private Integer changeQuantity;   //变动数量
    private Float changeFloatQuantity;   //变动小数
    private String changeReason;    //操作原因
    private Long authorizerID; //授权人ID
    private String authorizer;  //授权人
    private Long creatorID; //操作人ID
    private String creator; //操作人
    private LocalDateTime createTime;   //创建时间

    public Long getDealID() {
        return dealID;
    }

    public void setDealID(Long dealID) {
        this.dealID = dealID;
    }

    public Long getMappingID() {
        return mappingID;
    }

    public void setMappingID(Long mappingID) {
        this.mappingID = mappingID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter;
    }

    public Boolean getNeedWeigh() {
        return needWeigh;
    }

    public void setNeedWeigh(Boolean needWeigh) {
        this.needWeigh = needWeigh;
    }

    public Long getChangeType() {
        return changeType;
    }

    public void setChangeType(Long changeType) {
        this.changeType = changeType;
    }

    public String getChangeTypeName() {
        return changeTypeName;
    }

    public void setChangeTypeName(String changeTypeName) {
        this.changeTypeName = changeTypeName;
    }

    public Integer getChangeQuantity() {
        return changeQuantity;
    }

    public void setChangeQuantity(Integer changeQuantity) {
        this.changeQuantity = changeQuantity;
    }

    public Float getChangeFloatQuantity() {
        return changeFloatQuantity;
    }

    public void setChangeFloatQuantity(Float changeFloatQuantity) {
        this.changeFloatQuantity = changeFloatQuantity;
    }

    public String getChangeReason() {
        return changeReason;
    }

    public void setChangeReason(String changeReason) {
        this.changeReason = changeReason;
    }

    public Long getAuthorizerID() {
        return authorizerID;
    }

    public void setAuthorizerID(Long authorizerID) {
        this.authorizerID = authorizerID;
    }

    public String getAuthorizer() {
        return authorizer;
    }

    public void setAuthorizer(String authorizer) {
        this.authorizer = authorizer;
    }

    public Long getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(Long creatorID) {
        this.creatorID = creatorID;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
