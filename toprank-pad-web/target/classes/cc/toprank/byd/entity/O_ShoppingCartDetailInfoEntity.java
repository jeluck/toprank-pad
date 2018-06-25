package cc.toprank.byd.entity;

import cc.toprank.byd.entity.O_ShoppingCartDetailInfoEntityBase;

import java.math.BigDecimal;

/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在O_ShoppingCartDetailInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class O_ShoppingCartDetailInfoEntity extends O_ShoppingCartDetailInfoEntityBase {
    private Integer cartTotalQuantity;

    private BigDecimal cartTotalAmount;

    public Integer getCartTotalQuantity() {
        return cartTotalQuantity;
    }

    public void setCartTotalQuantity(Integer cartTotalQuantity) {
        this.cartTotalQuantity = cartTotalQuantity;
    }

    public BigDecimal getCartTotalAmount() {
        return cartTotalAmount;
    }

    public void setCartTotalAmount(BigDecimal cartTotalAmount) {
        this.cartTotalAmount = cartTotalAmount;
    }
  
}