package cc.toprank.byd.web.vo.printvo;

public class SingleCancelVO {
	private String dName;   //  	菜品名称
	private String dQty;    //  	菜品数量
	private String dUint;   //  	菜品单位
	private String theReason;   //  	退菜原因
	private String 	iQty;          //	单据打印数量
	private String  printIp;       //    打印机Ip
	public String getdName() {
		return dName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	public String getdQty() {
		return dQty;
	}
	public void setdQty(String dQty) {
		this.dQty = dQty;
	}
	public String getdUint() {
		return dUint;
	}
	public void setdUint(String dUint) {
		this.dUint = dUint;
	}
	public String getTheReason() {
		return theReason;
	}
	public void setTheReason(String theReason) {
		this.theReason = theReason;
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
	

}
