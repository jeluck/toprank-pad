package cc.toprank.byd.waiterApp.vo;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * @author LiSH
 * @version 2.0.0
 * @time 2017-6-14 10:10
 */
@ApiModel
public class WaiterLoginVO {
    @ApiModelProperty(value = "用户名", required = true)
    private String loginName;
    @ApiModelProperty(value = "用户密码", required = true)
    private String password;
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
