package cc.toprank.byd.web.vo;

/**
 * @Description： 桌台信息Vo  用于桌台负责人操作，向前端传递消息
 * @Author：HuTao
 * @Time: 2017-3-8 17:15
 * @Version 2.0.0
 *
 * Created by HuTao on 2017-3-8.
 */
public class TableMesgVO {
    private String tableCode;
    int defaultPeople;
    private Long areaId;
    private Long configId;
    private Long manageType;
    private Long serviceAnswerType;
    private String  userName;

    public String getTableCode() {
        return tableCode;
    }

    public void setTableCode(String tableCode) {
        this.tableCode = tableCode;
    }

    public int getDefaultPeople() {
        return defaultPeople;
    }

    public void setDefaultPeople(int defaultPeople) {
        this.defaultPeople = defaultPeople;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Long getConfigId() {
        return configId;
    }

    public void setConfigId(Long configId) {
        this.configId = configId;
    }

    public Long getManageType() {
        return manageType;
    }

    public void setManageType(Long manageType) {
        this.manageType = manageType;
    }

    public Long getServiceAnswerType() {
        return serviceAnswerType;
    }

    public void setServiceAnswerType(Long serviceAnswerType) {
        this.serviceAnswerType = serviceAnswerType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
