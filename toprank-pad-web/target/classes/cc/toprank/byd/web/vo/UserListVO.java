package cc.toprank.byd.web.vo;

/**
 * Created by HuTao on 2017-4-19.
 */
public class UserListVO {
    private String loginName;    //  登入名
    private Long userID;         //   用户ID
    private String orgName;       //   组织名称
    private Long loginID;        //    登入ID
    private String title;         //    职衔

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Long getLoginID() {
        return loginID;
    }

    public void setLoginID(Long loginID) {
        this.loginID = loginID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
