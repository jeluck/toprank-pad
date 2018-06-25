package cc.toprank.byd.entity;

import java.time.LocalDateTime;

/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 *   继承自自动生成的实体，具体业务方法使用的实体类
 *   如果具体业务需要扩展字段，请扩展该类
 * 
 * ********************************************************************************************************************/
public class O_SubOrderInfoEntity  extends O_SubOrderInfoEntityBase{
	private Long archiveID;
	private Long areaID;
	private int DefaultPerson;
	private int maxPerson;
	private int minPerson;
	private Long tableStatus;
	private Long bTableID;
	private String bTableName;
	private String combineName;
	private Long areaType;
	private String areaTypeName;
	private int times;  //  就餐时间长
    private String mMemo;  //  主订单备注
	private  String orderCode;         //  订单编号
	private  String orderChannelName;  //  订单来源
	private  String mealName;           //   餐次名称
	private  String creatorName;       //   开台人
	private  String serverName;        //   服务员
	private  String accountCode;       //   结帐单号
	private LocalDateTime accountTime;  //  结账时间
	private  String cashier;             //  收银员
	private  String cashRegister;       //  收银机

	public Long getArchiveID() {
		return archiveID;
	}

	public void setArchiveID(Long archiveID) {
		this.archiveID = archiveID;
	}

	public Long getAreaID() {
		return areaID;
	}

	public void setAreaID(Long areaID) {
		this.areaID = areaID;
	}

	public int getDefaultPerson() {
		return DefaultPerson;
	}

	public void setDefaultPerson(int defaultPerson) {
		DefaultPerson = defaultPerson;
	}

	public int getMaxPerson() {
		return maxPerson;
	}

	public void setMaxPerson(int maxPerson) {
		this.maxPerson = maxPerson;
	}

	public int getMinPerson() {
		return minPerson;
	}

	public void setMinPerson(int minPerson) {
		this.minPerson = minPerson;
	}

	public Long getTableStatus() {
		return tableStatus;
	}

	public void setTableStatus(Long tableStatus) {
		this.tableStatus = tableStatus;
	}

	public Long getbTableID() {
		return bTableID;
	}

	public void setbTableID(Long bTableID) {
		this.bTableID = bTableID;
	}

	public String getbTableName() {
		return bTableName;
	}

	public void setbTableName(String bTableName) {
		this.bTableName = bTableName;
	}

	public String getCombineName() {
		return combineName;
	}

	public void setCombineName(String combineName) {
		this.combineName = combineName;
	}

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

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}

	public String getmMemo() {
		return mMemo;
	}

	public void setmMemo(String mMemo) {
		this.mMemo = mMemo;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getOrderChannelName() {
		return orderChannelName;
	}

	public void setOrderChannelName(String orderChannelName) {
		this.orderChannelName = orderChannelName;
	}

	public String getMealName() {
		return mealName;
	}

	public void setMealName(String mealName) {
		this.mealName = mealName;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public LocalDateTime getAccountTime() {
		return accountTime;
	}

	public void setAccountTime(LocalDateTime accountTime) {
		this.accountTime = accountTime;
	}

	public String getCashier() {
		return cashier;
	}

	public void setCashier(String cashier) {
		this.cashier = cashier;
	}

	public String getCashRegister() {
		return cashRegister;
	}

	public void setCashRegister(String cashRegister) {
		this.cashRegister = cashRegister;
	}

}