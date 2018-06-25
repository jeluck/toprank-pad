package cc.toprank.byd.web.vo.menu;

import cc.toprank.byd.vo.TreeNodeVO;

import java.time.LocalDateTime;

/**
 * Created by LanZY on 2017-5-31.
 */
public class UnderOrderDetailVO extends TreeNodeVO implements Comparable<UnderOrderDetailVO> {
    private Long detailID;              //明细编号
    private Long recordID;              //套餐明细编号
    private String  productName;        //商品名称
    private String optionName;          //规格名称
    private boolean needWeigh;          //需要称重   1.是 0.
    private int quantity;               //数量
    private int servingQuantity;        //上菜数量
    private float floatQuantity;        //称重数量
    private double totalAmount;         //明细总金额
    private double comboDetaPrice;      //套餐明细价格
    private Long aLaCarteMethod;        //点菜方式：684.正常点菜 685.退菜 686.赠菜 697.加菜,996.加菜 997.换菜 998.转赠
    private Long produceStatus;         //制作状态：692.未制作 693.制作中 694.等叫 698 超时 830 未称重 981 已出品 982 已上菜 984待称重 985 已称重 986 待确认
    private String memo;                //备注
    private int subTotalNumber;         //子订单总数量
    private double subTotalAmount;      //子订单总金额
    private String valueNames;          //口味做法名称
    private Boolean isCombo;            //是否套餐
    private String tagIDs;              //标签ID
    private Long menuID;                //菜单ID
    private String unit;                //单位
    private Long parentID;              //订单明细父ID
    private Long tableID;               //转菜的目标桌台ID
    private String tableName;           //转菜的目标桌台名称
    private LocalDateTime createTime;   // Create Time



    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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

    public int getServingQuantity() {
        return servingQuantity;
    }

    public void setServingQuantity(int servingQuantity) {
        this.servingQuantity = servingQuantity;
    }

    public float getFloatQuantity() {
        return floatQuantity;
    }

    public void setFloatQuantity(float floatQuantity) {
        this.floatQuantity = floatQuantity;
    }

    public boolean isNeedWeigh() {
        return needWeigh;
    }

    public void setNeedWeigh(boolean needWeigh) {
        this.needWeigh = needWeigh;
    }


    public Long getRecordID() {
        return recordID;
    }

    public void setRecordID(Long recordID) {
        this.recordID = recordID;
    }

    public String getTagIDs() {
        return tagIDs;
    }

    public void setTagIDs(String tagIDs) {
        this.tagIDs = tagIDs;
    }

    public double getComboDetaPrice() {
        return comboDetaPrice;
    }

    public void setComboDetaPrice(double comboDetaPrice) {
        this.comboDetaPrice = comboDetaPrice;
    }

    public String getValueNames() {
        return valueNames;
    }

    public void setValueNames(String valueNames) {
        this.valueNames = valueNames;
    }


    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Long getaLaCarteMethod() {
        return aLaCarteMethod;
    }

    public void setaLaCarteMethod(Long aLaCarteMethod) {
        this.aLaCarteMethod = aLaCarteMethod;
    }

    public Long getProduceStatus() {
        return produceStatus;
    }

    public void setProduceStatus(Long produceStatus) {
        this.produceStatus = produceStatus;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

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

    public Long getDetailID() {
        return detailID;
    }

    public void setDetailID(Long detailID) {
        this.detailID = detailID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }


    public Boolean getCombo() {
        return isCombo;
    }


    public void setCombo(Boolean combo) {
        isCombo = combo;
    }

    public Long getParentID() {
        return parentID;
    }

    public void setParentID(Long parentID) {
        this.parentID = parentID;
    }

    public Long getTableID() {
        return tableID;
    }

    public void setTableID(Long tableID) {
        this.tableID = tableID;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UnderOrderDetailVO that = (UnderOrderDetailVO) o;

        return detailID != null ? detailID.equals(that.detailID) : that.detailID == null;
    }

    @Override
    public int hashCode() {
        return detailID != null ? detailID.hashCode() : 0;
    }

    @Override
    public int compareTo(UnderOrderDetailVO o) {
        if (o == null) return 1;
        Long detailID1 = parentID != null ? parentID : detailID;
        Long detailID2 = o.parentID != null ? o.parentID : o.detailID;
        int result = detailID1.compareTo(detailID2);
        if (result == 0) {
            LocalDateTime createTime1 = createTime == null ? LocalDateTime.now() : createTime;
            LocalDateTime createTime2 = o.createTime == null ? LocalDateTime.now() : o.createTime;
            result = createTime2.compareTo(createTime1);
        }
        return result;
    }
}
