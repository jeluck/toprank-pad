package cc.toprank.byd.enums;

/******************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的字典枚举类，不能手动修改。
 * 
 * ****************************************************************************************************/

public class NewsManageEnum {

	/**
	 * 
	 * 幻灯状态
	 */
	public enum SlideStatus{
	  /**
	   * 未知
	   */
	  UNKNOWN(455L, "未知"),
	  /**
	   * 待发布
	   */
	  WAITPUBLISH(456L, "待发布"),
	  /**
	   * 正常
	   */
	  NORMAL(457L, "正常"),
	  /**
	   * 暂停
	   */
	  SUSPEND(458L, "暂停"),
	  /**
	   * 已过期
	   */
	  EXPIRED(459L, "已过期"),
	  /**
	   * 已删除
	   */
	  DELETED(460L, "已删除");
  
	  private final Long value;
	  private final String name;
	  
	  private SlideStatus(Long value,String name) {
	    this.value = value;
	    this.name = name;
	  }
	
	  public Long getValue() {
	    return this.value;
	  }
	  
	  public String getName() {
	    return this.name;
	  }
	}
	
	/**
	 * 
	 * 弹出方式
	 */
	public enum PopupType{
	  /**
	   * 未知
	   */
	  UNKNOWN(461L, "未知"),
	  /**
	   * 当前页
	   */
	  OWNER(462L, "当前页"),
	  /**
	   * 弹出新页
	   */
	  NEWPAGE(463L, "弹出新页"),
	  /**
	   * 蒙板弹出
	   */
	  MASK(464L, "蒙板弹出");
  
	  private final Long value;
	  private final String name;
	  
	  private PopupType(Long value,String name) {
	    this.value = value;
	    this.name = name;
	  }
	
	  public Long getValue() {
	    return this.value;
	  }
	  
	  public String getName() {
	    return this.name;
	  }
	}
	
	/**
	 * 
	 * 幻灯类别
	 */
	public enum SlideType{
	  /**
	   * 首页新闻栏一
	   */
	  HOMEPOS1(379L, "首页新闻栏一"),
	  /**
	   * 首页新闻栏二
	   */
	  HOMEPOS2(380L, "首页新闻栏二"),
	  /**
	   * 新闻主页位置二
	   */
	  NEWSHOMEPOS2(382L, "新闻主页位置二"),
	  /**
	   * 新闻主页位置三
	   */
	  NEWSHOMEPOS3(383L, "新闻主页位置三");
  
	  private final Long value;
	  private final String name;
	  
	  private SlideType(Long value,String name) {
	    this.value = value;
	    this.name = name;
	  }
	
	  public Long getValue() {
	    return this.value;
	  }
	  
	  public String getName() {
	    return this.name;
	  }
	}
	
}