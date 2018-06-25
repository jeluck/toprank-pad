package cc.toprank.byd.entity;

import cc.toprank.byd.entity.B_TableManagerInfoEntityBase;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在B_TableManagerInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class B_TableManagerInfoEntity extends B_TableManagerInfoEntityBase {
    private String nickName;
    private String userName;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}