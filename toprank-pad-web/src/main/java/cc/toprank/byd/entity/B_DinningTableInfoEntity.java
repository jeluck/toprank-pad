package cc.toprank.byd.entity;


/**********************************************************************************************************************
 *
 * 版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 * 继承自自动生成的实体，具体业务方法使用的实体类 如果具体业务需要扩展字段，请扩展该类
 *
 ********************************************************************************************************************/
public class B_DinningTableInfoEntity extends B_DinningTableInfoEntityBase {
	private Long orgID;
	private Long configID;
	private Long manageType;
	private Long serviceAnswerType;
	private String userName;

	private Long mealsID;//餐次编号
	private Integer peopleNum;//就餐人数
	private Long loginID; //登录编号
	private Long customerID;//客户编号
    private Long areaType;  //  区域ID
	private String areaTypeName;  //  区域名称

	private String areaName;

	private Integer bookingNum;//预订次数

	private Long bookingID;//预订ID

	public Long getAreaType() {
		return areaType;
	}

	public void setAreaType(Long areaType) {
		this.areaType = areaType;
	}

	public String getAreaTypeName() {
		return areaTypeName;
	}

	public void setAreaTypeName(String areaTypeName) {
		this.areaTypeName = areaTypeName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Long getConfigID() {
		return configID;
	}

	public void setConfigID(Long configID) {
		this.configID = configID;
	}

	public Long getManageType() {
		return manageType;
	}

	public void setManageType(Long manageType) {
		this.manageType = manageType;
	}

	public Long getServiceAnswerType() {
		return serviceAnswerType;
	}

	public void setServiceAnswerType(Long serviceAnswerType) {
		this.serviceAnswerType = serviceAnswerType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 机构ID
	 */
	public Long getOrgID() {
		return orgID;
	}

	/**
	 * 机构ID
	 */
	public void setOrgID(Long orgID) {
		this.orgID = orgID;
	}

	public Long getMealsID() {
		return mealsID;
	}

	public void setMealsID(Long mealsID) {
		this.mealsID = mealsID;
	}

	public Integer getPeopleNum() {
		return peopleNum;
	}

	public void setPeopleNum(Integer peopleNum) {
		this.peopleNum = peopleNum;
	}

	public Long getLoginID() {
		return loginID;
	}

	public void setLoginID(Long loginID) {
		this.loginID = loginID;
	}

	public Long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
	}

	public Integer getBookingNum() {
		return bookingNum;
	}

	public void setBookingNum(Integer bookingNum) {
		this.bookingNum = bookingNum;
	}

	public Long getBookingID() {
		return bookingID;
	}

	public void setBookingID(Long bookingID) {
		this.bookingID = bookingID;
	}
}