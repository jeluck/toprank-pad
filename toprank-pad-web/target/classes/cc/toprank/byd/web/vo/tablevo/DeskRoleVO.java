package cc.toprank.byd.web.vo.tablevo;

/**
 * 桌台岗位VO
 * Created by HuTao on 2017-5-16.
 */
public class DeskRoleVO {
    private Long  roleID;   //  岗位角色ID
    private String  roleName;  //  岗位角色名称
    private Long roleType;      //  岗位角色类型
    private String roleTypeName;  //  //  岗位角色类型名称

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

    public Long getRoleType() {
        return roleType;
    }

    public void setRoleType(Long roleType) {
        this.roleType = roleType;
    }

    public String getRoleTypeName() {
        return roleTypeName;
    }

    public void setRoleTypeName(String roleTypeName) {
        this.roleTypeName = roleTypeName;
    }
}
