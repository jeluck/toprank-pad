package cc.toprank.byd.web.vo.printvo;

import java.util.List;

// 退菜总单
public class AllCancelPrintVO {
	private String      optCode;     //	操作码(值101）
	private String 		billType;    //	单类型(值4)
	private String 		rstrtName;    //	公司名称
	private String 		floorNum;    //	楼层
	private String 		deskNum;     //	桌号
	private String 		meals;       //	餐次
	private String 		sumPeople;    //	人数
	private String 		orderid;      //	单据号
	private String 		backDishTime;    //	退菜时间
	private String 		taker;        //	退菜员
	private String 		iTotalDish;    //	退菜总数
	private String 	    iQty;          //	单据打印数量
	private String      printIp;       //    打印机Ip
	private List<SingleCancelVO> 		singleDish;    //	单道菜信息
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
	public String getRstrtName() {
		return rstrtName;
	}
	public void setRstrtName(String rstrtName) {
		this.rstrtName = rstrtName;
	}
	public String getFloorNum() {
		return floorNum;
	}
	public void setFloorNum(String floorNum) {
		this.floorNum = floorNum;
	}
	public String getDeskNum() {
		return deskNum;
	}
	public void setDeskNum(String deskNum) {
		this.deskNum = deskNum;
	}
	public String getMeals() {
		return meals;
	}
	public void setMeals(String meals) {
		this.meals = meals;
	}
	public String getSumPeople() {
		return sumPeople;
	}
	public void setSumPeople(String sumPeople) {
		this.sumPeople = sumPeople;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getBackDishTime() {
		return backDishTime;
	}
	public void setBackDishTime(String backDishTime) {
		this.backDishTime = backDishTime;
	}
	public String getTaker() {
		return taker;
	}
	public void setTaker(String taker) {
		this.taker = taker;
	}
	public String getiTotalDish() {
		return iTotalDish;
	}
	public void setiTotalDish(String iTotalDish) {
		this.iTotalDish = iTotalDish;
	}
	public String getiQty() {
		return iQty;
	}
	public void setiQty(String iQty) {
		this.iQty = iQty;
	}
	public String getPrintIp() {
		return printIp;
	}
	public void setPrintIp(String printIp) {
		this.printIp = printIp;
	}
	public List<SingleCancelVO> getSingleDish() {
		return singleDish;
	}
	public void setSingleDish(List<SingleCancelVO> singleDish) {
		this.singleDish = singleDish;
	}
	


}
