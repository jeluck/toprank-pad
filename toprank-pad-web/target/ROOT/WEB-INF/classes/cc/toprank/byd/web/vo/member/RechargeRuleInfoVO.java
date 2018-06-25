package cc.toprank.byd.web.vo.member;

import java.math.BigDecimal;

/**
 * 充值规则VO
 * Created by HuTao on 2017-5-26.
 *
 */
public class RechargeRuleInfoVO {
    private Long activityID;    //  活动ID
    private String activityName;  //  活动名称
    private Long ruleID;          //    活动规则
    private String ruleName;       //     活动名称
    private double spentAmount;       //   花费金额      充值金额
    private double presentAmount;     //   赠送金额
    private int presentBonus;      //   赠送积分

    public Long getActivityID() {
        return activityID;
    }

    public void setActivityID(Long activityID) {
        this.activityID = activityID;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Long getRuleID() {
        return ruleID;
    }

    public void setRuleID(Long ruleID) {
        this.ruleID = ruleID;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public double getSpentAmount() {
        return spentAmount;
    }

    public void setSpentAmount(double spentAmount) {
        this.spentAmount = spentAmount;
    }

    public double getPresentAmount() {
        return presentAmount;
    }

    public void setPresentAmount(double presentAmount) {
        this.presentAmount = presentAmount;
    }

    public int getPresentBonus() {
        return presentBonus;
    }

    public void setPresentBonus(int presentBonus) {
        this.presentBonus = presentBonus;
    }
}
