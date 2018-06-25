package cc.toprank.byd.web.constant;

/**
 * Copyright:Toprank
 * 
 * @content 桌台常量类
 * @author xuexin
 * @since 2016年10月31日
 */
public class DinningTableInfoConstants {
	
	/**餐桌状态-待清理状态*/
	public final static Long TABLESTATUSCLEAR = 609l ;
	
	/**餐桌状态-空闲状态*/
	public final static Long TABLESTATUFREE = 607l ;
	
	/**餐桌的订单数量*/
	public final static Integer ORDERCOUNT = 0;
	
	/**餐桌状态-在用状态*/
	public final static Long TABLESTATUUSE = 652l ;
	
	/**合台-只合人数*/
	public final static Integer ISMARKCUSTOMERNUMBER = 1 ;
	
	/**合台-合桌*/
	public final static Integer ISMARKTABLE = 2 ;

	/**合台-合台名称  合-*
	 * (己过期，改用 COMBINE_TABLENAME)
	 * @see DinningTableInfoConstants#COMBINE_TABLENAME
·	 * */
	@Deprecated
	public final static String ANDTABLENAME = "合-";
	
	/**拼台-拼台名称  拼-* 此名称在子订单表中*/
	public final static String FIGHTTABLENAME = "拼";
	
	/**加台-加台名称  加-* 此名称在餐次桌台表中合台名称字段修改*/
	public final static String ADDTABLENAME = "加-";

	/**联台-联台名称  联-* 此名称在餐次桌台表中合台名称字段修改*/
	public final static String COMBINE_TABLENAME = "联-";
	
	/**合台-合台名称  合-* */
	public final static Integer ANDTABLENUMBER = 1;
	
	/**在订单，子订单，桌台使用记录表中，标记当前这个状态* */
	public final static Long COMBINE = 165l;
	
}
