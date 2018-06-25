package cc.toprank.byd.entity;

import cc.toprank.byd.entity.O_OrderInfoEntityBase;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在O_OrderInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class O_OrderInfoEntity extends O_OrderInfoEntityBase {

    //实际金额
    private double actualAmountCopy;

    public double getActualAmountCopy() {
        if(null != super.getActualAmount()){
            actualAmountCopy = super.getActualAmount().doubleValue();
        }
        return actualAmountCopy;
    }

    public void setActualAmountCopy(double actualAmountCopy) {
        this.actualAmountCopy = actualAmountCopy;
    }
  
}