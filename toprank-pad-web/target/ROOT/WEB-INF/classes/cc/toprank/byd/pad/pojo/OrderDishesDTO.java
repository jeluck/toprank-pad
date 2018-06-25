package cc.toprank.byd.pad.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 点菜入参对象
 *
 * @author LeeJun
 * @version 2.0.0
 * @time 2017-2-20 10:06
 */
public class OrderDishesDTO {
    // 就餐人数
    private int peopleNum;
    // 菜品
    private List<Dishes> dishes = new ArrayList<Dishes>();
    // 商品总额
    private BigDecimal totalAmount;
    // 折扣金额
    private BigDecimal discountAmount;
    // 备注
    private String memo;
    // 是否推迟下单
    private boolean isPostpone;
    // 点菜方式 684（正常点菜）685（退菜） 686（赠菜） 687（加菜） 871（打包） 872（转赠）
    private Long carteMethod;
    // 上菜时间
    private String servingTime;
    // 订单id
    private long orderID;
    // 子订单id
    private long subOrderID;

    public String getServingTime() {
        return servingTime;
    }

    public void setServingTime(String servingTime) {
        this.servingTime = servingTime;
    }

    public Long getCarteMethod() {
        return carteMethod;
    }

    public void setCarteMethod(Long carteMethod) {
        this.carteMethod = carteMethod;
    }

    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(long orderID) {
        this.orderID = orderID;
    }

    public long getSubOrderID() {
        return subOrderID;
    }

    public void setSubOrderID(long subOrderID) {
        this.subOrderID = subOrderID;
    }

    public int getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(int peopleNum) {
        this.peopleNum = peopleNum;
    }

    public List<Dishes> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dishes> dishes) {
        this.dishes = dishes;
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
        return isPostpone;
    }

    public void setPostpone(boolean postpone) {
        isPostpone = postpone;
    }

    public static class Dishes {
        // 菜品在购物车中的明细id
        private Long detailID;
        // 菜品id
        private Long productID;
        // 变体id
        private Long variantID;
        // 是否套餐
        private boolean isCombos;
        // 菜单菜品id
        private Long menuID;
        // 数量
        private int quantity;
        // 备注
        private String memo;
        // 加价
        private BigDecimal addedPrice;
        // 规格选项编号
        private Long optionID;
        // 商品属性值编号列表,多个用','号隔开
        private String valueIDs;
        // 厨师ID
        private Long designerID;
        // 厨师费
        private BigDecimal designerPrice;
        // 期望重量
        private float expectedWeight;

        public Long getDetailID() {
            return detailID;
        }

        public void setDetailID(Long detailID) {
            this.detailID = detailID;
        }

        public Long getProductID() {
            return productID;
        }

        public void setProductID(Long productID) {
            this.productID = productID;
        }

        public Long getVariantID() {
            return variantID;
        }

        public void setVariantID(Long variantID) {
            this.variantID = variantID;
        }

        public boolean isCombos() {
            return isCombos;
        }

        public void setCombos(boolean combos) {
            isCombos = combos;
        }

        public Long getMenuID() {
            return menuID;
        }

        public void setMenuID(Long menuID) {
            this.menuID = menuID;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public String getMemo() {
            return memo;
        }

        public void setMemo(String memo) {
            this.memo = memo;
        }

        public BigDecimal getAddedPrice() {
            return addedPrice;
        }

        public void setAddedPrice(BigDecimal addedPrice) {
            this.addedPrice = addedPrice;
        }

        public Long getOptionID() {
            return optionID;
        }

        public void setOptionID(Long optionID) {
            this.optionID = optionID;
        }

        public String getValueIDs() {
            return valueIDs;
        }

        public void setValueIDs(String valueIDs) {
            this.valueIDs = valueIDs;
        }

        public Long getDesignerID() {
            return designerID;
        }

        public void setDesignerID(Long designerID) {
            this.designerID = designerID;
        }

        public BigDecimal getDesignerPrice() {
            return designerPrice;
        }

        public void setDesignerPrice(BigDecimal designerPrice) {
            this.designerPrice = designerPrice;
        }

        public float getExpectedWeight() {
            return expectedWeight;
        }

        public void setExpectedWeight(float expectedWeight) {
            this.expectedWeight = expectedWeight;
        }
    }

}