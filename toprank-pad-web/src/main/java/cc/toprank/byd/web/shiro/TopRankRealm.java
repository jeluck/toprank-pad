package cc.toprank.byd.web.shiro;

import cc.toprank.byd.web.constant.WebConstants;
import cc.toprank.byd.web.dto.UserInfoVo;
import cc.toprank.byd.web.service.login.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.List;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @Description：  shiro 操作权限管控
 * @Author：HuTao
 * @Time: 2017-3-3 9:49
 * @Version 2.0.0
 */
public class TopRankRealm extends AuthorizingRealm {
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    private static final String SHIRO_PERS = "SHIRO_PERS";
    private static final String SHIRO_ROLES = "shiro_roles";

    private LoginService loginService;

    /**
     * @Description： 获取用户权限信息
     * @Author：HuTao
     * @Time: 2017-3-7 15:59
     * @Version 2.0.0
     * @param pc
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
        String loginName = (String) pc.fromRealm(getName()).iterator().next();
        // CacheManager cache = new SimpleCacheManager();
        if (!StringUtils.isEmpty(loginName)) {
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            List<String> pers = (List<String>) SecurityUtils.getSubject().getSession().getAttribute(SHIRO_PERS);
            if (pers == null || pers.isEmpty()) {
                pers =loginService.getPermissionsByLoginName(loginName);
                for (String per : pers) {
                    // 添加模块权限到控制器中
                    info.addStringPermission(per);
                }
                SecurityUtils.getSubject().getSession().setAttribute(SHIRO_PERS, pers);
            }
            List<String> roles = (List<String>) SecurityUtils.getSubject().getSession().getAttribute(SHIRO_ROLES);
            if (roles == null || roles.isEmpty()) {
                roles = loginService.getRolesByLoginName(loginName);
                info.addRoles(roles);
                SecurityUtils.getSubject().getSession().setAttribute(SHIRO_ROLES, roles);
            }
            return info;
        }
        return null;
    }

    /**
     * @Description： 登陆验证
     * @Author：HuTao
     * @Time: 2017-3-7 15:59
     * @Version 2.0.0
     * @param arg0
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
        try {
            UsernamePasswordToken token = (UsernamePasswordToken) arg0;
            String username = token.getUsername();
            if (!StringUtils.isEmpty(username)) {
                UserInfoVo userInfo= loginService.getUserInfo(username,"");
                if (userInfo != null) {
                    // 登陆成功后，查询用户信息缓存在session中
                    SecurityUtils.getSubject().getSession().setAttribute(WebConstants.SessionAttribute.USER_INFO, userInfo);
                    // 缓存权限信息在session中
                    String privilegeCodeStr = loginService.getPrivilegeCodeByLoginID(userInfo.getLoginID().toString());
                    String privilegeIDStr = loginService.getPrivilegeIDByLoginID(userInfo.getLoginID().toString());
                    SecurityUtils.getSubject().getSession().setAttribute("privilegeCodeStr", privilegeCodeStr);
                    SecurityUtils.getSubject().getSession().setAttribute("privilegeIDStr", privilegeIDStr);
                    return new SimpleAuthenticationInfo(userInfo.getLoginName(), userInfo.getPassword(), getName());
                }
            }
        } catch (Exception e) {
            logger.error("shiro登陆验证出错。");
        }
        return null;
    }
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }
}
