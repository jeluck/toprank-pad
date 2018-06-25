package cc.toprank.byd.web.vo.printvo;

public class PlatBillVO {
	private String dName;       //  	菜名
	private String dQty;        //  	数量
	private String dUint;       //  	单位
	private String fOriPrice;   //  	原价
	private String fPrice;      //  	折后单价
	private String fDiscountAmt;  //  	菜单折扣金额
	private String fIncrease;     //  	加价
	private String fProcessFee;   //  	加工费
	private String fADistAmt;   //  	折后金额
	private String dRemark;     //  	备注
	private String iPackagel;   //  	是否菜单明细
	private String iSendFlag;   //  	赠送标记
	private String iAutoSend;   //  	自动赠送
	private String iWeighting;  //  	是否称重
	private String czsl;        //	        称重重量

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
	public String getfOriPrice() {
		return fOriPrice;
	}
	public void setfOriPrice(String fOriPrice) {
		this.fOriPrice = fOriPrice;
	}
	public String getfPrice() {
		return fPrice;
	}
	public void setfPrice(String fPrice) {
		this.fPrice = fPrice;
	}
	public String getfDiscountAmt() {
		return fDiscountAmt;
	}
	public void setfDiscountAmt(String fDiscountAmt) {
		this.fDiscountAmt = fDiscountAmt;
	}
	public String getfIncrease() {
		return fIncrease;
	}
	public void setfIncrease(String fIncrease) {
		this.fIncrease = fIncrease;
	}
	public String getfProcessFee() {
		return fProcessFee;
	}
	public void setfProcessFee(String fProcessFee) {
		this.fProcessFee = fProcessFee;
	}
	public String getfADistAmt() {
		return fADistAmt;
	}
	public void setfADistAmt(String fADistAmt) {
		this.fADistAmt = fADistAmt;
	}
	public String getdRemark() {
		return dRemark;
	}
	public void setdRemark(String dRemark) {
		this.dRemark = dRemark;
	}
	public String getiPackagel() {
		return iPackagel;
	}
	public void setiPackagel(String iPackagel) {
		this.iPackagel = iPackagel;
	}
	public String getiSendFlag() {
		return iSendFlag;
	}
	public void setiSendFlag(String iSendFlag) {
		this.iSendFlag = iSendFlag;
	}
	public String getiAutoSend() {
		return iAutoSend;
	}
	public void setiAutoSend(String iAutoSend) {
		this.iAutoSend = iAutoSend;
	}
	public String getiWeighting() {
		return iWeighting;
	}
	public void setiWeighting(String iWeighting) {
		this.iWeighting = iWeighting;
	}

}
