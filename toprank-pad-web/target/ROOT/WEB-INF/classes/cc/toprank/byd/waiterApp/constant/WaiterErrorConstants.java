package cc.toprank.byd.waiterApp.constant;

/**
 * @author LiSH
 * @version 2.0.0
 * @time 2017-6-16 11:45
 */
public interface WaiterErrorConstants {
    interface UserLoginError{
        int code = 2;
        String msg ="用户名或密码错误!";
    }
    interface UserExistError{
        int code = 3;
        String msg ="用户未登陆!";
    }
}
