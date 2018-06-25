package cc.toprank.byd.pad.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 下单入参dto对象
 *
 * @author LeeJun
 * @create 2017-03-30 17:11
 */
public class ShoppingCartDTO {
    // 购物车菜品id
    private List<Long> detailIDs = new ArrayList<Long>();
    // 就餐人数
    private int peopleNum;
    // 商品总额
    private BigDecimal totalAmount;
    // 折扣金额
    private BigDecimal discountAmount;
    // 备注
    private String memo;
    // 是否推迟下单
    private boolean postpone;

    public int getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(int peopleNum) {
        this.peopleNum = peopleNum;
    }

    public List<Long> getDetailIDs() {
        return detailIDs;
    }

    public void setDetailIDs(List<Long> detailIDs) {
        this.detailIDs = detailIDs;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public boolean isPostpone() {
        return postpone;
    }

    public void setPostpone(boolean postpone) {
        this.postpone = postpone;
    }
}
