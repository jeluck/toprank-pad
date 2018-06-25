package cc.toprank.byd.web.vo.printvo;

import java.util.List;

//   预结帐单
public class AdvancePrintVO {
	private String  optCode;  //	操作码(值101）
	private String 	billType;   //	单类型(值7)
	private String 	strtName;   //	公司名称
	private String 	meals;     //	餐次
	private String 	orderid;    //	单据号
	private String 	orderTime;  //	下单时间
	private String 	printTime;  //	打印时间
	private String 	deskNum;  //	桌号
	private String 	cashier;  //	收银员
	private String 	iTotalDish;  //	点菜个数
	
	private String 	fCostPrice;  //		原价金额
	private String 	fTotalDist;  //		折扣总金额
	private String 	fZsje;     //		赠送金额
	private String 	fWipeZero;  //		抹零
	private String 	iQty;     //		单据打印数量
	private String 	fRemark;  //		备注信息

	private String  printIp;      //        打印机Ip
	private List<SingleDishVO> 	singleDish;    //	单道菜信息	数组singleDish起始
	public String getOptCode() {
		return optCode;
	}
	public void setOptCode(String optCode) {
		this.optCode = optCode;
	}
	public String getBillType() {
		return billType;
	}
	public void setBillType(String billType) {
		this.billType = billType;
	}
	public String getStrtName() {
		return strtName;
	}
	public void setStrtName(String strtName) {
		this.strtName = strtName;
	}
	public String getMeals() {
		return meals;
	}
	public void setMeals(String meals) {
		this.meals = meals;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public String getPrintTime() {
		return printTime;
	}
	public void setPrintTime(String printTime) {
		this.printTime = printTime;
	}
	public String getDeskNum() {
		return deskNum;
	}
	public void setDeskNum(String deskNum) {
		this.deskNum = deskNum;
	}
	public String getCashier() {
		return cashier;
	}
	public void setCashier(String cashier) {
		this.cashier = cashier;
	}
	public String getiTotalDish() {
		return iTotalDish;
	}
	public void setiTotalDish(String iTotalDish) {
		this.iTotalDish = iTotalDish;
	}
	public String getfCostPrice() {
		return fCostPrice;
	}
	public void setfCostPrice(String fCostPrice) {
		this.fCostPrice = fCostPrice;
	}
	public String getfTotalDist() {
		return fTotalDist;
	}
	public void setfTotalDist(String fTotalDist) {
		this.fTotalDist = fTotalDist;
	}
	public String getfZsje() {
		return fZsje;
	}
	public void setfZsje(String fZsje) {
		this.fZsje = fZsje;
	}
	public String getfWipeZero() {
		return fWipeZero;
	}
	public void setfWipeZero(String fWipeZero) {
		this.fWipeZero = fWipeZero;
	}
	public String getiQty() {
		return iQty;
	}
	public void setiQty(String iQty) {
		this.iQty = iQty;
	}
	public String getfRemark() {
		return fRemark;
	}
	public void setfRemark(String fRemark) {
		this.fRemark = fRemark;
	}
	public String getPrintIp() {
		return printIp;
	}
	public void setPrintIp(String printIp) {
		this.printIp = printIp;
	}
	public List<SingleDishVO> getSingleDish() {
		return singleDish;
	}
	public void setSingleDish(List<SingleDishVO> singleDish) {
		this.singleDish = singleDish;
	}
	
	
}
