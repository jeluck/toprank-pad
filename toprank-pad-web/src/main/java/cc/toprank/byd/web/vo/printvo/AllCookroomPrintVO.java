package cc.toprank.byd.web.vo.printvo;

import java.util.List;

//厨房总单
public class AllCookroomPrintVO {
	private String      optCode;      //  	操作码(值101）
	private String 		billType;     //	单类型(值1)
	private String 		deskNum;      //	桌号
	private String 		sumPeople;    //	人数
	private String 		orderTime;    //	下单时间
	private String 		taker;        //	点菜员
	private String 		orderid;       //	单据号
	private String 		iTotalDish;    //	点菜个数
	private String 	    iQty;          //	单据打印数量
	private String      printIp;       //    打印机Ip
	private String      pc_remark;     //	 拼菜备注信息

	private List<CookroomListVO> 	singleDish;    //	单道菜信息
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
	public String getDeskNum() {
		return deskNum;
	}
	public void setDeskNum(String deskNum) {
		this.deskNum = deskNum;
	}
	public String getSumPeople() {
		return sumPeople;
	}
	public void setSumPeople(String sumPeople) {
		this.sumPeople = sumPeople;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public String getTaker() {
		return taker;
	}
	public void setTaker(String taker) {
		this.taker = taker;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
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
	public List<CookroomListVO> getSingleDish() {
		return singleDish;
	}
	public void setSingleDish(List<CookroomListVO> singleDish) {
		this.singleDish = singleDish;
	}
	

}
