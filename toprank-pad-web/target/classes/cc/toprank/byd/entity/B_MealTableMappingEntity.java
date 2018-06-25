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
public class B_MealTableMappingEntity  extends B_MealTableMappingEntityBase{
	
	
	private String tableName;	//桌台名称
	private String areaName;	//区域名称
	private Integer minLength;  //餐次最短时长

	private LocalDateTime endTime;

	private Long bookingID;			//预定编号

	private Integer minute;			//加时 总 时长

	public Integer getMinute() {
		return minute;
	}
	public void setMinute(Integer minute) {
		this.minute = minute;
	}
	public Long getBookingID() {
		return bookingID;
	}
	public void setBookingID(Long bookingID) {
		this.bookingID = bookingID;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public Integer getMinLength() {
		return minLength;
	}
	public void setMinLength(Integer minLength) {
		this.minLength = minLength;
	}
  
}