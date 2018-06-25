package cc.toprank.byd.web.constant;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


/**
 * @author LinYN
 * @date 2017-6-7
 */
public interface WebConstants {

    interface ContextAttribute {

        String CASHER_ID = "CasherID"; // 收银机编号

        String CASHER_NAME = "CasherName"; // 收银机名称
    }

    interface SessionAttribute {

        String USER_INFO = "UserInfo"; // 用户
        String PERMISSION_USER_INFO = "PermissionUserInfo"; // 二次验权用户
    }

    interface RequestAttribute {
    }

    interface RequestParameter {

        String LOGIN_NAME = "loginName";

        String PASSWORD = "password";
    }

    interface Location {

        String LOGIN_URL = "/";

        String CONFIG_URL = "/config";
    }
}
