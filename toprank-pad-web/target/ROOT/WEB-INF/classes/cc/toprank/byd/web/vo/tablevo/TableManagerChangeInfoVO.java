package cc.toprank.byd.web.vo.tablevo;

import cc.toprank.byd.entity.B_TableManagerChangeInfoEntity;

/**
 * Created by LiuXJ on 2017-6-13.
 */
public class TableManagerChangeInfoVO extends B_TableManagerChangeInfoEntity {

    private Long tableID;
    private String tableName;
    private Long archiveID;
    private String changeTypeName; //操作类型名称

    private String changeObjectName;//调整对象名称
    private String serviceName; //服务内容
    private String changeReasonName; //调整原因名称
    private String operationReason; //操作原因
    private String creator;//操作人

    public Long getTableID() {
        return tableID;
    }

    public void setTableID(Long tableID) {
        this.tableID = tableID;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getChangeObjectName() {
        return changeObjectName;
    }

    public void setChangeObjectName(String changeObjectName) {
        this.changeObjectName = changeObjectName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getOperationReason() {
        return operationReason;
    }

    public void setOperationReason(String operationReason) {
        this.operationReason = operationReason;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Long getArchiveID() {
        return archiveID;
    }

    public void setArchiveID(Long archiveID) {
        this.archiveID = archiveID;
    }

    public String getChangeTypeName() {
        return changeTypeName;
    }

    public void setChangeTypeName(String changeTypeName) {
        this.changeTypeName = changeTypeName;
    }

    public String getChangeReasonName() {
        return changeReasonName;
    }

    public void setChangeReasonName(String changeReasonName) {
        this.changeReasonName = changeReasonName;
    }
}
