package cc.toprank.byd.web.vo.printvo;

public class CookroomListVO {
	private String  dName;  // 	菜品名称
	private String  dUint;  // 		菜品单位
	private String  dQty;  // 		菜品数量
	private String  dRemark;  // 		是否套餐明细
	private String  strRemark;  // 		菜品备注
	private String  chef;       // 		指定厨师
	private String  dTaste;     // 		口味
	private String  fPrice;     // 		单价
	
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
	public String getdRemark() {
		return dRemark;
	}
	public void setdRemark(String dRemark) {
		this.dRemark = dRemark;
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
	public String getdTaste() {
		return dTaste;
	}
	public void setdTaste(String dTaste) {
		this.dTaste = dTaste;
	}
	public String getfPrice() {
		return fPrice;
	}
	public void setfPrice(String fPrice) {
		this.fPrice = fPrice;
	}
	
}
