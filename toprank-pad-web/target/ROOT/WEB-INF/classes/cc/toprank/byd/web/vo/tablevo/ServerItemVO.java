package cc.toprank.byd.web.vo.tablevo;

/**
 * Created by HuTao on 2017-5-19.
 */
public class ServerItemVO {
    private Long serverID;  //  服务项目ID
    private String serverName;  //  服务项目名称

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
