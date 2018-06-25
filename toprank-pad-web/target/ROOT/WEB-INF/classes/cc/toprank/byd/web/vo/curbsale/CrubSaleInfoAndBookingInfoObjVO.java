package cc.toprank.byd.web.vo.curbsale;

import java.util.List;

/**
 * Created by ChenKY on 2017-5-17.
 */
public class CrubSaleInfoAndBookingInfoObjVO {
    private Long productID;            //菜品编号
    private Long variantID;           // 变体id
    private boolean needWeigh;        //需要称重   1.是 0.
    private Long warehouseID;         //仓库编号
    private int optionIDSum;        //规格数量
    private List<CrubSaleInfoAndBookingInfoVO> list;

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

    public boolean isNeedWeigh() {
        return needWeigh;
    }

    public void setNeedWeigh(boolean needWeigh) {
        this.needWeigh = needWeigh;
    }

    public List<CrubSaleInfoAndBookingInfoVO> getList() {
        return list;
    }

    public void setList(List<CrubSaleInfoAndBookingInfoVO> list) {
        this.list = list;
    }

    public Long getWarehouseID() {
        return warehouseID;
    }

    public void setWarehouseID(Long warehouseID) {
        this.warehouseID = warehouseID;
    }

    public int getOptionIDSum() {
        return optionIDSum;
    }

    public void setOptionIDSum(int optionIDSum) {
        this.optionIDSum = optionIDSum;
    }
}
