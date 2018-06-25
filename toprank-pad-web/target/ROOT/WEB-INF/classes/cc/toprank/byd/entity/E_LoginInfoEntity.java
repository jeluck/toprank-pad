package cc.toprank.byd.entity;

/**********************************************************************************************************************
 * 
 * 版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 * 继承自自动生成的实体，具体业务方法使用的实体类 如果具体业务需要扩展字段，请扩展该类
 * 
 ********************************************************************************************************************/
public class E_LoginInfoEntity extends E_LoginInfoEntityBase {

	private String mobile;// 手机号码
	private String gender;//性别
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}