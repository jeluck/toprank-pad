package cc.toprank.byd.web.vo.tablevo;

import java.util.List;

/**
 * Created by HuTao on 2017-5-18.
 */
public class DeskPersonSaveVO {
    private Long tableID;     //    桌台ID
    private Long mealsID;     //    餐次
    private Long areaID;      //    区域ID
    private Long loginID;     //    服务员ID
    private String dealDesc;    //    调整备注
    private Long   serverID;      //  服务项目ID
    private String serverName;    //  服务项目名称

    public Long getTableID() {
        return tableID;
    }

    public void setTableID(Long tableID) {
        this.tableID = tableID;
    }

    public Long getMealsID() {
        return mealsID;
    }

    public void setMealsID(Long mealsID) {
        this.mealsID = mealsID;
    }

    public Long getAreaID() {
        return areaID;
    }

    public void setAreaID(Long areaID) {
        this.areaID = areaID;
    }

    public Long getLoginID() {
        return loginID;
    }

    public void setLoginID(Long loginID) {
        this.loginID = loginID;
    }

    public String getDealDesc() {
        return dealDesc;
    }

    public void setDealDesc(String dealDesc) {
        this.dealDesc = dealDesc;
    }

    public Long getServerID() {
        return serverID;
    }

    public void setServerID(Long serverID) {
        this.serverID = serverID;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }
}
