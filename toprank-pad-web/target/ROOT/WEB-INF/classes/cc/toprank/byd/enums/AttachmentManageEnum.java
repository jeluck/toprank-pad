package cc.toprank.byd.enums;

/******************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的字典枚举类，不能手动修改。
 * 
 * ****************************************************************************************************/

public class AttachmentManageEnum {

	/**
	 * 
	 * 商户附件管理
	 */
	public enum MerchanAattachmentManage{
	  /**
	   * 商户注册附件
	   */
	  REGISTER(580, "商户注册附件"),
	  /**
	   * 商户头像附件
	   */
	  HEADPORTRAIT(581, "商户头像附件"),
	  /**
	   * 商户店面附件
	   */
	  STORE(582, "商户店面附件"),
	  /**
	   * 商户评论附件
	   */
	  COMMENT(599, "商户评论附件"),
	  /**
	   * 商户环境图
	   */
	  HUANGJINGTU(704, "商户环境图"),
	  /**
	   * 商户营业执照图
	   */
	  YINGYEZHIZHAO(705, "商户营业执照图"),
	  /**
	   * 商户身份证正面
	   */
	  IDCARDHEAD(740, "商户身份证正面"),
	  /**
	   * 商户身份证反面
	   */
	  IDCRADTAIL(741, "商户身份证反面"),
	  /**
	   * 商户卫生许可证
	   */
	  HYGIENICLICENSE(742, "商户卫生许可证"),
	  /**
	   * 餐饮服务许可证
	   */
	  SERVICELICENSE(743, "餐饮服务许可证"),
	  /**
	   * 商户支付凭证
	   */
	  PAYDEPOSIT(764, "商户支付凭证"),
	  /**
	   * 水牌banner图
	   */
	  PAD_BANNER(804, "水牌banner图"),
	  /**
	   * 水牌广告图
	   */
	  PAD_ADVERT(805, "水牌广告图");
  
	  private final long value;
	  private final String name;
	  
	  private MerchanAattachmentManage(long value,String name) {
	    this.value = value;
	    this.name = name;
	  }
	
	  public long getValue() {
	    return this.value;
	  }
	  
	  public String getName() {
	    return this.name;
	  }
	}
	
	/**
	 * 
	 * 商品附件管理
	 */
	public enum ProductAattachmentManage{
	  /**
	   * 商品图片
	   */
	  GOODSPICTURE(583, "商品图片"),
	  /**
	   * 商品头像图片类型
	   */
	  PRODUCTHEADTYPE(624, "商品头像图片类型"),
	  /**
	   * 商品变体头像图片类型
	   */
	  PRODUCTVARIANTHEADTYPE(625, "商品变体头像图片类型"),
	  /**
	   * 商品评论图片
	   */
	  PRODUCT_REVIEW_PICTURE(744, "商品评论图片");
  
	  private final long value;
	  private final String name;
	  
	  private ProductAattachmentManage(long value,String name) {
	    this.value = value;
	    this.name = name;
	  }
	
	  public long getValue() {
	    return this.value;
	  }
	  
	  public String getName() {
	    return this.name;
	  }
	}
	
	/**
	 * 
	 * 客户附件管理
	 */
	public enum CustomerAattachmentManage{
	  /**
	   * 头像相册
	   */
	  HEADPHOTOS(657, "头像相册"),
	  /**
	   * 共享相册
	   */
	  SHAREPHOTOS(658, "共享相册");
  
	  private final long value;
	  private final String name;
	  
	  private CustomerAattachmentManage(long value,String name) {
	    this.value = value;
	    this.name = name;
	  }
	
	  public long getValue() {
	    return this.value;
	  }
	  
	  public String getName() {
	    return this.name;
	  }
	}
	
}