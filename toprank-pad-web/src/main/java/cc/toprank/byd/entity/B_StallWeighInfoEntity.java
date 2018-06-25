package cc.toprank.byd.entity;

import java.math.BigDecimal;

/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在B_StallWeighInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class B_StallWeighInfoEntity extends B_StallWeighInfoEntityBase {

    private java.math.BigDecimal beforeNum; //变动前数量

    private java.math.BigDecimal afterNum;//变动后数量

    private String valueIDs;              //做法口味

    public BigDecimal getBeforeNum() {
        return beforeNum;
    }

    public void setBeforeNum(BigDecimal beforeNum) {
        this.beforeNum = beforeNum;
    }

    public BigDecimal getAfterNum() {
        return afterNum;
    }

    public void setAfterNum(BigDecimal afterNum) {
        this.afterNum = afterNum;
    }
}