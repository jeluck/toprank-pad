package cc.toprank.byd.web.vo.printvo;

public class CarteListVO {
	private String  dName;  //  	菜品名称
	private String  dUint;  //  	菜品单位
	private String  dQty;   //      菜品数量
	private String  fPrice;      //    单价  
	private String  dRemark;     //  	是否套餐明细
	private String  dCookMethod;  //  	制作方法
	private String  dTaste;      //  	口味
	private String  strRemark;  //  	菜品备注
	private String  chef;       //  	指定厨师
	
	private String 	iQty;          //	单据打印数量
	private String  printIp;       //   打印机Ip
	
	public String getdName() {
		return dName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	public String getdUint() {
		return dUint;
	}
	public void setdUint(String dUint) {
		this.dUint = dUint;
	}
	public String getdQty() {
		return dQty;
	}
	public void setdQty(String dQty) {
		this.dQty = dQty;
	}
	public String getfPrice() {
		return fPrice;
	}
	public void setfPrice(String fPrice) {
		this.fPrice = fPrice;
	}
	public String getdRemark() {
		return dRemark;
	}
	public void setdRemark(String dRemark) {
		this.dRemark = dRemark;
	}
	public String getdCookMethod() {
		return dCookMethod;
	}
	public void setdCookMethod(String dCookMethod) {
		this.dCookMethod = dCookMethod;
	}
	public String getdTaste() {
		return dTaste;
	}
	public void setdTaste(String dTaste) {
		this.dTaste = dTaste;
	}
	public String getStrRemark() {
		return strRemark;
	}
	public void setStrRemark(String strRemark) {
		this.strRemark = strRemark;
	}
	public String getChef() {
		return chef;
	}
	public void setChef(String chef) {
		this.chef = chef;
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
