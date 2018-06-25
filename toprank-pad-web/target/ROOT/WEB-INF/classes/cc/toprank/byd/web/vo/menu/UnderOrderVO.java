package cc.toprank.byd.web.vo.menu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LanZY on 2017-5-31.
 */
public class UnderOrderVO {

    private int subTotalNumber;         //子订单总数量
    private double subTotalAmount;      //子订单总金额
    private List<UnderOrderDetailVO> orderProductList = new ArrayList<>();

    public int getSubTotalNumber() {
        return subTotalNumber;
    }

    public void setSubTotalNumber(int subTotalNumber) {
        this.subTotalNumber = subTotalNumber;
    }

    public double getSubTotalAmount() {
        return subTotalAmount;
    }

    public void setSubTotalAmount(double subTotalAmount) {
        this.subTotalAmount = subTotalAmount;
    }

    public List<UnderOrderDetailVO> getOrderProductList() {
        return orderProductList;
    }

    public void setOrderProductList(List<UnderOrderDetailVO> orderProductList) {
        this.orderProductList = orderProductList;
    }
}
