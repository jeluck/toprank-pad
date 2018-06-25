package cc.toprank.byd.entity;

import cc.toprank.byd.entity.B_ChangeShiftsInfoEntityBase;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在B_ChangeShiftsInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class B_ChangeShiftsInfoEntity extends B_ChangeShiftsInfoEntityBase {
    private String changeReasonName;    //  调整原因
    private String beforeLoginName;      //  调整前
    private String afterLoginName;       // 调整之后
    private String creatorName;         //  操作人

    public String getChangeReasonName() {
        return changeReasonName;
    }

    public void setChangeReasonName(String changeReasonName) {
        this.changeReasonName = changeReasonName;
    }

    public String getBeforeLoginName() {
        return beforeLoginName;
    }

    public void setBeforeLoginName(String beforeLoginName) {
        this.beforeLoginName = beforeLoginName;
    }

    public String getAfterLoginName() {
        return afterLoginName;
    }

    public void setAfterLoginName(String afterLoginName) {
        this.afterLoginName = afterLoginName;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }
  
}