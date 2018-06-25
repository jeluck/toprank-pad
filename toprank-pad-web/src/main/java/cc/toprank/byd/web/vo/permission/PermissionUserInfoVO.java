package cc.toprank.byd.web.vo.permission;

/**
 * Created by ChenKY on 2017-6-18.
 */
public class PermissionUserInfoVO {
    private Long loginID;              //    登入ID
    private String loginName;         //     登入名称
    private String password;           //    口令

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
}
