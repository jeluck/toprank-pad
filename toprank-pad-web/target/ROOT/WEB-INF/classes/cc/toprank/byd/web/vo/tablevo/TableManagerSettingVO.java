package cc.toprank.byd.web.vo.tablevo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

/**
 * Created by LiuXJ on 2017-6-7.
 */
public class TableManagerSettingVO {
    private Long configID;
    private Long archiveID;
    private Long loginID;
    private String employeeCode; //员工编号
    private String orgName; //部门
    private String userName;
    private Long areaID;
    private Long settingID;
    private Long tableID;
    private String tableCode;
    private String tableName;
    private Long manageType;
    private Long serviceAnswerType;
    private Long mappingStatus;
    private String manageDesc;
    private Long creatorID;
    private String memo;


    private Long dutyID;
    private String dutyCode;
    private Long mealsID;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Long roleID;
    private String roleName;
    private Long cycleType;
    private String dutyDay;

    private Set<Long> serviceAnswerTypeList;
    private List<ServiceAnswerTypeVO> serviceAnswerTypeVOList;

    /** 调整原因 */
    private Long changeReason;
    /** 调整描述 */
    private String dealDesc;

    public Long getConfigID() {
        return configID;
    }

    public void setConfigID(Long configID) {
        this.configID = configID;
    }

    public Long getArchiveID() {
        return archiveID;
    }

    public void setArchiveID(Long archiveID) {
        this.archiveID = archiveID;
    }

    public Long getLoginID() {
        return loginID;
    }

    public void setLoginID(Long loginID) {
        this.loginID = loginID;
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

    public Long getTableID() {
        return tableID;
    }

    public void setTableID(Long tableID) {
        this.tableID = tableID;
    }

    public String getTableCode() {
        return tableCode;
    }

    public void setTableCode(String tableCode) {
        this.tableCode = tableCode;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Long getManageType() {
        return manageType;
    }

    public void setManageType(Long manageType) {
        this.manageType = manageType;
    }

    public Long getServiceAnswerType() {
        return serviceAnswerType;
    }

    public void setServiceAnswerType(Long serviceAnswerType) {
        this.serviceAnswerType = serviceAnswerType;
    }

    public Long getMappingStatus() {
        return mappingStatus;
    }

    public void setMappingStatus(Long mappingStatus) {
        this.mappingStatus = mappingStatus;
    }

    public Long getDutyID() {
        return dutyID;
    }

    public void setDutyID(Long dutyID) {
        this.dutyID = dutyID;
    }

    public String getDutyCode() {
        return dutyCode;
    }

    public void setDutyCode(String dutyCode) {
        this.dutyCode = dutyCode;
    }

    public Long getMealsID() {
        return mealsID;
    }

    public void setMealsID(Long mealsID) {
        this.mealsID = mealsID;
    }

    public Long getRoleID() {
        return roleID;
    }

    public void setRoleID(Long roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Long getCycleType() {
        return cycleType;
    }

    public void setCycleType(Long cycleType) {
        this.cycleType = cycleType;
    }

    public String getDutyDay() {
        return dutyDay;
    }

    public void setDutyDay(String dutyDay) {
        this.dutyDay = dutyDay;
    }

    public String getManageDesc() {
        return manageDesc;
    }

    public void setManageDesc(String manageDesc) {
        this.manageDesc = manageDesc;
    }

    public Long getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(Long creatorID) {
        this.creatorID = creatorID;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Set<Long> getServiceAnswerTypeList() {
        return serviceAnswerTypeList;
    }

    public void setServiceAnswerTypeList(Set<Long> serviceAnswerTypeList) {
        this.serviceAnswerTypeList = serviceAnswerTypeList;
    }

    public List<ServiceAnswerTypeVO> getServiceAnswerTypeVOList() {
        return serviceAnswerTypeVOList;
    }

    public void setServiceAnswerTypeVOList(List<ServiceAnswerTypeVO> serviceAnswerTypeVOList) {
        this.serviceAnswerTypeVOList = serviceAnswerTypeVOList;
    }

    public Long getChangeReason() {
        return changeReason;
    }

    public void setChangeReason(Long changeReason) {
        this.changeReason = changeReason;
    }

    public String getDealDesc() {
        return dealDesc;
    }

    public void setDealDesc(String dealDesc) {
        this.dealDesc = dealDesc;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
