package cc.toprank.byd.entity;

import java.time.LocalDateTime;

/**********************************************************************************************************************
 *
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在B_DesignerMonitorInfo类中进行修改
 *
 * ********************************************************************************************************************/
public class B_DesignerMonitorInfoEntity extends B_DesignerMonitorInfoEntityBase {

    // 拼桌数量
    private int shareNumber;

    private Long remainingSeconds;

    private String attributeName;

    private boolean isComob;

    public boolean isComob() {
        return isComob;
    }

    public void setComob(boolean comob) {
        isComob = comob;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public int getShareNumber() {
        return shareNumber;
    }

    public void setShareNumber(int shareNumber) {
        this.shareNumber = shareNumber;
    }

    public Long getRemainingSeconds() {
        return remainingSeconds;
    }

    public void setRemainingSeconds(Long remainingSeconds) {
        this.remainingSeconds = remainingSeconds;
    }
}