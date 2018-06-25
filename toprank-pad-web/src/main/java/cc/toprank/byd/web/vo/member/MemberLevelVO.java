package cc.toprank.byd.web.vo.member;

/**
 * Created by HuTao on 2017-5-17.
 */
public class MemberLevelVO {
    private Long roleID;   // 等级ID
    private String roleName;  // 等级名称

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
}
