package cc.toprank.byd.web.vo.order;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 订单详情VO
 * Created by HuTao on 2017-5-4.
 */
public class OrderDetailVO {
    private Long    orderID;           //  订单ID
    private String orderCode;         //  订单编号
    private int  customerNumber ;     //  就餐人数
    private  String tableName;         //  桌台名称
    private  LocalDateTime createTime;  //  开台时间
    private  String  createName;        //   开台人
    private  String  serverName;        //    服务员
    private String  memo;                //   整单备注
    private String  combineMemo;        //   关联桌台 A01、A02、A03
    private double actualAmount;       //  订单金额    消费金额： 134.8
    private double discount; //    折扣金额：0
    private double largess;  //    赠送金额： 42.4
    private double serverAmount;  //    服务费：0
    private double derateAmount;   //    减免金额： 0
    private String  deratePeople;     //    减费人： 王某某
    private double  noChange;    //    抹零金额：0
    private double  receivable;  //    应收：92.4

    private  String makeCollectionsRecode;      //  收款记录
    private List<SubOrderVO> subOrderVOlist;         //  子订单信息

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
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

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getCombineMemo() {
        return combineMemo;
    }

    public void setCombineMemo(String combineMemo) {
        this.combineMemo = combineMemo;
    }

    public double getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(double actualAmount) {
        this.actualAmount = actualAmount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getLargess() {
        return largess;
    }

    public void setLargess(double largess) {
        this.largess = largess;
    }

    public double getServerAmount() {
        return serverAmount;
    }

    public void setServerAmount(double serverAmount) {
        this.serverAmount = serverAmount;
    }

    public double getDerateAmount() {
        return derateAmount;
    }

    public void setDerateAmount(double derateAmount) {
        this.derateAmount = derateAmount;
    }

    public String getDeratePeople() {
        return deratePeople;
    }

    public void setDeratePeople(String deratePeople) {
        this.deratePeople = deratePeople;
    }

    public double getNoChange() {
        return noChange;
    }

    public void setNoChange(double noChange) {
        this.noChange = noChange;
    }

    public double getReceivable() {
        return receivable;
    }

    public void setReceivable(double receivable) {
        this.receivable = receivable;
    }

    public String getMakeCollectionsRecode() {
        return makeCollectionsRecode;
    }

    public void setMakeCollectionsRecode(String makeCollectionsRecode) {
        this.makeCollectionsRecode = makeCollectionsRecode;
    }

    public List<SubOrderVO> getSubOrderVOlist() {
        return subOrderVOlist;
    }

    public void setSubOrderVOlist(List<SubOrderVO> subOrderVOlist) {
        this.subOrderVOlist = subOrderVOlist;
    }
}
