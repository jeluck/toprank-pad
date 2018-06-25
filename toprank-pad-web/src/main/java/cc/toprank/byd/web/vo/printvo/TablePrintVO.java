package cc.toprank.byd.web.vo.printvo;

import java.util.List;

//  台单Vo
public class TablePrintVO {
	private String      optCode;    //	操作码(值101）
	private String 		billType;   //		单类型(值3)
	private String 		strtName;   //		公司名称
	private String 		meals;      //		餐次
	private String 		orderid;    //		单据号
	private String 		orderTime;   //		开台时间
	private String 		printTime;   //		打印时间
	private String 		deskNum;     //		桌号
	private String 		iTotalDish;   //		点菜个数
	private String 		iQty;         //		打印份数
	private String      printIp;      //        打印机Ip
	//     新加字段  第二版
	private String      pc_remark;	  //  拼菜备注信息
	private String      fCostPrice;	  //  原价金额
	private String      fTotalDist;	  //  折扣总金额
	private String      fADistAmt;	  //  	折后金额
	private String      fComforts;	  //  	优惠总计
	
	private List<PlatBillVO> 	platbill;   //		单个台单信息

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

	public String getPc_remark() {
		return pc_remark;
	}

	public void setPc_remark(String pc_remark) {
		this.pc_remark = pc_remark;
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

	public String getfADistAmt() {
		return fADistAmt;
	}

	public void setfADistAmt(String fADistAmt) {
		this.fADistAmt = fADistAmt;
	}

	public String getfComforts() {
		return fComforts;
	}

	public void setfComforts(String fComforts) {
		this.fComforts = fComforts;
	}

	public List<PlatBillVO> getPlatbill() {
		return platbill;
	}

	public void setPlatbill(List<PlatBillVO> platbill) {
		this.platbill = platbill;
	}

	
}
