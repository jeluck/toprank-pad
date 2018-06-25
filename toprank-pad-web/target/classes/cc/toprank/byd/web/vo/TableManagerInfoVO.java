package cc.toprank.byd.web.vo;

import java.security.PrivateKey;

/**
 * @Description： 查询桌台负责人详情 数据传递
 * @Author：HuTao
 * @Time: 2017-3-9 10:15
 * @Version 2.0.0
 * Created by HuTao on 2017-3-9.
 */
public class TableManagerInfoVO {
    private String userName;
    private Long managerType;
    private Long serviceAnswerType ;
    private Long configID ;
    private Long segmentID ;
    private Long loginID ;
    private Long mealsID ;
    private Long areaID ;
    private Long settingID ;
    private Long manageStatus ;
    private Long creatorID ;
    private String  tableCode;
    private String  mealName;
    private String  tableName;
    private Long archiveID ;
    private Long userID;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getManagerType() {
        return managerType;
    }

    public void setManagerType(Long managerType) {
        this.managerType = managerType;
    }

    public Long getServiceAnswerType() {
        return serviceAnswerType;
    }

    public void setServiceAnswerType(Long serviceAnswerType) {
        this.serviceAnswerType = serviceAnswerType;
    }

    public Long getConfigID() {
        return configID;
    }

    public void setConfigID(Long configID) {
        this.configID = configID;
    }

    public Long getSegmentID() {
        return segmentID;
    }

    public void setSegmentID(Long segmentID) {
        this.segmentID = segmentID;
    }

    public Long getLoginID() {
        return loginID;
    }

    public void setLoginID(Long loginID) {
        this.loginID = loginID;
    }

    public Long getMealsID() {
        return mealsID;
    }

    public void setMealsID(Long mealsID) {
        this.mealsID = mealsID;
    }

    public Long getAreaID() {
        return areaID;
    }

    public void setAreaID(Long areaID) {
        this.areaID = areaID;
    }

    public Long getSettingID() {
        return settingID;
    }

    public void setSettingID(Long settingID) {
        this.settingID = settingID;
    }

    public Long getManageStatus() {
        return manageStatus;
    }

    public void setManageStatus(Long manageStatus) {
        this.manageStatus = manageStatus;
    }

    public Long getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(Long creatorID) {
        this.creatorID = creatorID;
    }

    public String getTableCode() {
        return tableCode;
    }

    public void setTableCode(String tableCode) {
        this.tableCode = tableCode;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Long getArchiveID() {
        return archiveID;
    }

    public void setArchiveID(Long archiveID) {
        this.archiveID = archiveID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }
}
