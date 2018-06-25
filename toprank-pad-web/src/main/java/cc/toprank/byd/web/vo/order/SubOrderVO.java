package cc.toprank.byd.web.vo.order;

import java.util.List;

/**
 * Created by HuTao on 2017-6-7.
 */
public class SubOrderVO {
    private String tableName;      //   桌台名称
    private String orderCode;      //    订单号
    private List<FoodDetailVO> foodlist;         //  菜品详情

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public List<FoodDetailVO> getFoodlist() {
        return foodlist;
    }

    public void setFoodlist(List<FoodDetailVO> foodlist) {
        this.foodlist = foodlist;
    }
}
