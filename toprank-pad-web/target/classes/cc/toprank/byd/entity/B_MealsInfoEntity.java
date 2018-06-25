package cc.toprank.byd.entity;

import java.util.ArrayList;
import java.util.List;

/**********************************************************************************************************************
 *
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 *   继承自自动生成的实体，具体业务方法使用的实体类
 *   如果具体业务需要扩展字段，请扩展该类
 *
 * ********************************************************************************************************************/
public class B_MealsInfoEntity  extends B_MealsInfoEntityBase{

	private String duration;
	private String timeUnit;
	private Integer count;  //记录数

	private List<String> rserveTimeList = new ArrayList<>();

	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getTimeUnit() {
		return timeUnit;
	}
	public void setTimeUnit(String timeUnit) {
		this.timeUnit = timeUnit;
	}

	public List<String> getRserveTimeList() {
		return rserveTimeList;
	}

	public void setRserveTimeList(List<String> rserveTimeList) {
		this.rserveTimeList = rserveTimeList;
	}
}