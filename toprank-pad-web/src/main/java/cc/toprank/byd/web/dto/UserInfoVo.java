package cc.toprank.byd.web.dto;

import java.time.LocalDateTime;

/**
 * @Description： 用户信息VO
 * @Author：HuTao
 * @Time: 2017-3-2 15:07
 * @Version 2.0.0
 */
public class UserInfoVo {
    private Long loginID;              //    登入ID
    private String loginName;         //     登入名称
    private String password;           //    口令
    private Long userID;                //   用户ID
    private String userName;            //   用户名
    private Long orgID;                 //    组织ID
    private String orgName;             //    组织名称
    private Long archiveID;                  //       档案 ID
    private String merchantName;             //       档案名称
    private Long creatorId;                   //       建档ID
    private LocalDateTime latestLoginTime;   //        最后登入时间

    public Long getCasherID() {
        return casherID;
    }

    public void setCasherID(Long casherID) {
        this.casherID = casherID;
    }

    public String getCasherName() {
        return casherName;
    }

    public void setCasherName(String casherName) {
        this.casherName = casherName;
    }

    private Long casherID ;
    private String casherName;

    public Long getLoginID() {
        return loginID;
    }

    public void setLoginID(Long loginID) {
        this.loginID = loginID;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getOrgID() {
        return orgID;
    }

    public void setOrgID(Long orgID) {
        this.orgID = orgID;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Long getArchiveID() {
        return archiveID;
    }

    public void setArchiveID(Long archiveID) {
        this.archiveID = archiveID;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public LocalDateTime getLatestLoginTime() {
        return latestLoginTime;
    }

    public void setLatestLoginTime(LocalDateTime latestLoginTime) {
        this.latestLoginTime = latestLoginTime;
    }
}
