package cc.toprank.byd.web.constant;

/**
 * 接口返回状态码常量
 *
 * @author LeeJun
 *
 */
public class CodeMsgConstants {

	/********************** 系统级状态 **********************/
	/** 系统错误 */
	public static final int ERROR = -1;
	public static final String ERROR_MSG = "系统异常";
	/** 处理成功 */
	public static final int SUCCESS = 0;
	public static final String SUCCESS_MSG = "成功";
	/** 处理失败 */
	public static final int FAIL = 1;
	public static final String FAIL_MSG = "处理失败";
	/** 未登录 */
	public static final int NOTLOGIN = 2;
	public static final String NOTLOGIN_MSG = "未登陆";
	/** 参数错误 */
	public static final int PARAM_ERROR = 3;
	public static final String PARAM_ERROR_MSG = "参数错误";

	/** 未找到相关数据 */
	public static final int NODATA = 4;
	public static final String NODATA_MSG = "未找到相关数据";
	/** 未初始化 */
	public static final int NOTINIT = 5;
	public static final String NOTINIT_MSG = "尚未初始化";

	/** 商家不存在 */
	public static final int MERCHANT_NON_EXIST = 6;
	public static final String MERCHANT_NON_EXIST_MSG = "商家不存在";

	/** 保存数据失败 */
	public static final int SAVE_DATA_ERROR = 7;
	public static final String SAVE_DATA_ERROR_MSG = "保存数据失败";

	/********************** 业务级错误 **********************/
	/** 处理成功 */
	public static final int MEMBER_SAVE_SUCCESS = 0;
	public static final String MEMBER_SAVE_SUCCESS_MSG = "注册会员成功";

	public static final int MEMBER_SAVE_FAIL = 1;
	public static final String MEMBER_SAVE_FAIL_MSG = "注册会员失败";

	public static final int MEMBER_ISACCOUNT = 2;
	public static final String MEMBER_ISACCOUNT_MSG = "会员账户已存在";

	public static final int MEMBER_ISUSED = 3;
	public static final String MEMBER_ISUSED_MSG = "会员卡号已被使用";

	public static final int MEMBER_UPDATE_SUCCESS = 0;
	public static final String MEMBER_UPDATE_SUCCESS_MSG = "修改会员信息成功";

	public static final int MEMBER_UPDATE_FAIL =1;
	public static final String MEMBER_UPDATE_FAIL_MSG = "修改会员信息失败";

	public static final int MEMBER_MOBEL_NOTCARD=300;
	public static final String MEMBER_MOBEL_NOTCARD_MSG = "手机号未邦定会员卡";

	public static final int MEMBER_MOBEL_ISUSE=301;
	public static final String MEMBER_MOBEL_ISUSE_MSG = "手机号已注册";

	public static final int MEMBER_MOBEL_NOTUSE=302;
	public static final String MEMBER_MOBEL_NOTUSE_MSG = "手机号未注册";

	public static final int MEMBER_NOCARD=303;
	public static final String MEMBER_NOCARD_MSG = "会员卡未找到";

	public static final int MEMBER_CARD_ISUSE=304;
	public static final String MEMBER_CARD_ISUSE_MSG = "会员卡已使用";

	public static final int MEMBER_CARD_NOTUSE=305;
	public static final String MEMBER_CARD_NOTUSE_MSG = "会员卡未使用";

	public static final int MEMBER_NOTPASSWORD=306;
	public static final String MEMBER_NOTPASSWORD_MSG = "密码不能为空值";

	public static final int MEMBER_NOTNAME=307;
	public static final String MEMBER_NOTNAME_MSG = "会员名称不能为空值";

	public static final int MEMBER_NOTMMOBILE=308;
	public static final String MEMBER_NOTMMOBILE_MSG = "手机号码不能为空值";

	public static final int MEMBER_NOTCODE=309;
	public static final String MEMBER_NOTCODE_MSG = "会员卡序列号，芯片号不能为空";

	public static final int MEMBER_NOTACCOUNT=310;
	public static final String MEMBER_NOTACCOUNT_MSG = "账户不存在";

	public static final int MEMBER_NOTCOUNTERMAN=311;
	public static final String MEMBER_NOTCOUNTERMAN_MSG = "业务员不能为空";

	public static final int MEMBER_NEWPASSWORD=312;
	public static final String MEMBER_NEWPASSWORD_MSG = "新密码不能为空";

	public static final int MEMBER_OLDPASSWORD=313;
	public static final String MEMBER_OLDPASSWORD_MSG = "旧密码输入不正确";

	public static final int EXIST_SIGNIN=314;
	public static final String EXIST_SIGNIN_MSG = "签到已存在，不能重复签到";

	public static final int EXIST_SIGNOUT=315;
	public static final String EXIST_SIGNOUT_MSG = "签退已存在，不能重复签到";

	public static final int MEMBER_RECHARGERECORD_FAIL=314;
	public static final String MEMBER_RECHARGERECORD_FAIL_MSG = "生成充值记录失败";

	public static final int MEMBER_RECHARGERECORD_SUCCESS = 0;
	public static final String MEMBER_RECHARGERECORD_SUCCESS_MSG = "会员充值成功";

	/********************** 用户模块 ***********************/
	/** 用户名或密码错误 */
	public static final int USER_NAMEORPASS_ERROR = 101;
	public static final String USER_NAMEORPASS_ERROR_MSG = "用户名或密码错误!";
	/** 用户已存在 */
	public static final int USER_NAME_EXIST = 102;
	/** 用户不存在 */
	public static final int USER_NAME_NOT_EXIST = 103;
	/** 密码错误 */
	public static final int USER_PASSWORD_EXIST = 104;
	/** 用户token错误 */
	public static final int USER_TOKEN_ERROR = 105;
	public static final String USER_TOKEN_ERROR_MSG = "用户tokeno不合法";
	/** 用户没有操作权限 */
	public static final int USER_NOT_PRIVILEGE = 106;

	/********************** 首页桌态图模块 ***********************/
	public static final int BOOKING_TIME_NULL=121;
	public static final String BOOKING_TIME_NULL_MSG = "预订时间不能为空";


	/********************** 桌台模块 ***********************/
	public static final int TABLE_INFO_NOT_EXIST = 201;
	public static final String TABLE_INFO_NOT_EXIST_MSG = "桌台不存在";

    public static final int TABLE_UN_USED = 202;
	public static final String TABLE_UN_USED_MSG = "桌台[%s]不在使用中";

	public static final int TABLE_IS_EMPTY = 203;
	public static final String TABLE_IS_EMPTY_MSG = "桌台[%s]是空台";

	public static final int TABLE_IS_NOT_EMPTY = 204;
	public static final String TABLE_IS_NOT_EMPTY_MSG = "桌台[%s]不是空台";

	public static final int TABLE_IS_SHARING = 205;
	public static final String TABLE_IS_SHARING_MSG = "桌台[%s]是拼台";

	public static final int TABLE_IS_NOT_SHARING = 206;
	public static final String TABLE_IS_NOT_SHARING_MSG = "桌台[%s]不是拼台";

	public static final int TABLE_ORDER_DISABLED = 207;
	public static final String TABLE_ORDER_DISABLED_MSG = "桌台[%s]的订单不可用";

	public static final int CREATE_TABLE_ORDER_ERROR = 208;
	public static final String CREATE_TABLE_ORDER_ERROR_MSG = "创建订单失败";

	public static final int TABLE_SUBORDER_NOT_EXIST = 209;
	public static final String TABLE_SUBORDER_NOT_EXIST_MSG = "桌台[%s]的子订单不存在";

	public static final int TABLE_IS_COMBINNING = 210;
	public static final String TABLE_IS_COMBINNING_MSG = "桌台[%s]是联台";

	public static final int TABLE_IS_NOT_COMBINNING = 211;
	public static final String TABLE_IS_NOT_COMBINNING_MSG = "桌台[%s]不是联台";

	public static final int TABLE_CAN_NOT_SHARING = 212;
	public static final String TABLE_CAN_NOT_SHARING_MSG = "桌台[%s]不允许拼台";

	public static final int TABLE_CAN_NOT_COMBINNING = 213;
	public static final String TABLE_CAN_NOT_COMBINNING_MSG = "桌台[%s]不允许联台";

	public static final int TABLE_SUBORDER_ERROR = 214;
	public static final String TABLE_SUBORDER_ERROR_MSG = "桌台[%s]存在异常的子订单数据";

	public static final int NO_TABLE_MEALS_DATA = 215;
	public static final String NO_TABLE_MEALS_DATA_MSG = "未找到桌台[%s]的餐次数据";

	public static final int NO_TABLE_USE_DATA = 216;
	public static final String NO_TABLE_USE_DATA_MSG = "未找到桌台[%s]的使用信息";

	public static final int NO_TABLE_EXIST = 217;
	public static final String NO_TABLE_EXIST_DATA_MSG = "选择的桌台编号为[%s]不存在，不可以清台";

	public static final int NOT_DIRTY_TABLE = 218;
	public static final String NOT_DIRTY_TABLE_DATA_MSG = "选择的桌台编号[%s]不是脏台，不能进行批量清台，请重新选择";

	public static final int ELIMINATE_TABLE_FAIL = 219;
	public static final String ELIMINATE_TABLE_FAIL_DATA_MSG = "桌台正在处于消费状态，不能消台";

	public static final int NOT_RELATION_TABLE = 220;
	public static final String NOT_RELATION_TABLE_MSG = "没有关联的桌台";

	public static final int ORDER_ISEXIST = 221;
	public static final String ORDER_ISEXIST_DATA_MSG = "订单已经下单，不能消台";

	public static final int ORDER_DETAIL_NOT_EXIST= 223;
	public static final String ORDER_DETAIL_NOT_EXIST_MSG = "订单明细不存在";

	public static final int TABLES_ARE_COMBINED_ERROR = 224;
	public static final String TABLES_ARE_COMBINED_ERROR_MSG = "所选的桌台己经联合";

	public static final int OPEN_TABLE_CUSTOMER_NUMBER_ERROR = 225;
	public static final String OPEN_TABLE_CUSTOMER_NUMBER_ERROR_MSG = "就餐人数不能为空（开台人数必须大于0）";

	public static final int COMBINED_TABLE_NOT_ALLOW_SHARING = 226;
	public static final String COMBINED_TABLE_NOT_ALLOW_SHARING_MSG = "联台[%s]不可以拼台";

	public static final int SHARING_TABLE_NOT_ALLOW_COMBINE = 227;
	public static final String SHARING_TABLE_NOT_ALLOW_COMBINE_MSG = "拼台[%s]不可以联台";

	public static final int COMBINED_TABLE_NUMBER_LIMIT_ERROR = 228;
	public static final String COMBINED_TABLE_NUMBER_LIMIT_ERROR_MSG = "联台数量不能超过3台";

	public static final int EXIS_TABLE_USE_ERROR_DATA = 229;
	public static final String EXIS_TABLE_USE_ERROR_DATA_MSG = "[%s]已经存在桌台异常的使用信息";

	public static final int NO_TABLE_MEALS_MAPPING_DATA = 230;
	public static final String NO_TABLE_MEALS_MAPPING_DATA_MSG = "未找到[%s]桌台餐次的关联数据";

	public static final int TABLE_IS_RESERVE = 231;
	public static final String TABLE_IS_RESERVE_MSG = "桌台[%s]已经被预定了";

	public static final int NO_MEALS_DATA = 232;
	public static final String NO_MEALS_DATA_MSG = "未找到餐次数据";

	public static final int MEALS_MAPPING_DATA_ERROR = 233;
	public static final String MEALS_MAPPING_DATA_ERROR_MSG = "找到[%s]桌台餐次的异常关联数据";

	public static final int TABLE_IS_STOPPED = 234;
	public static final String TABLE_IS_STOPPED_MSG = "桌台[%s]己经暂结";

	/********************** 点菜模块 ***********************/
	public static final int SUBORDER_NOT_EXISTENCE = 301;
	public static final String SUBORDER_NOT_EXISTENCE_MSG = "子订单不存在";

	public static final int MULTI_ORDER_ERROR = 302;
	public static final String MULTI_ORDER_ERROR_MSG = "不允许同时操作多个订单";

	public static final int RETURNPRODUCT_NOT_ALLOWED_COPY_ERROR = 303;
	public static final String RETURNPRODUCT_NOT_ALLOWED_COPY_ERROR_MSG = "退菜不可以复制";

	public static final int MARKORDERDETAIL_NUMBER_ISNULL = 304;
	public static final String MARKORDERDETAIL_NUMBER_ISNULL_MSG = "划单数量不能为空和0";

	public static final int MARKORDERDETAIL_NUMBER_ERROR = 305;
	public static final String MARKORDERDETAIL_NUMBER_ERROR_MSG = "划单数量输入错误";

	public static final int MARKORDERDETAIL_ERROR = 306;
	public static final String MARKORDERDETAIL_ERROR_MSG = "[%s]非制作中,已出品状态不能划单";

	public static final int CANCELMARKORDERDETAIL_NUMBER_ISNULL = 307;
	public static final String CANCELMARKORDERDETAIL_NUMBER_ISNULL_MSG = "取消划单数量不能为空和0";

	public static final int CANCELMARKORDERDETAIL_NUMBER_ERROR = 308;
	public static final String CANCELMARKORDERDETAIL_NUMBER_ERROR_MSG = "取消划单数量输入错误";

	public static final int CANCELMARKORDERDETAIL_ERROR = 309;
	public static final String CANCELMARKORDERDETAIL_ERROR_MSG = "[%s]非已上菜状态不能取消划单";

	public static final int TAGREPEAT_ERROR = 310;
	public static final String TAGREPEAT_ERROR_MSG = "标签不能重复";

	public static final int NOT_PRESENTFOOD_ERROR = 315;
	public static final String NOT_PRESENTFOOD_MSG = "没有可以取消的赠菜";

	public static final int ADDFOOD_ERROR = 316;
	public static final String ADDFOOD_MSG = "当前不允许加菜";

	public static final int WAKEUP_ERROR = 317;
	public static final String WAKEUP_ERROR_MSG = "非等叫状态不能被叫起";

	public static final int SOCALLED_ERROR = 318;
	public static final String SOCALLED_ERROR_MSG = "已上菜状态不能被叫起";

	public static final int CHANGE_FOOD_ERROR = 333;
	public static final String CHANGE_FOOD_MSG = "转菜数量大于可转的数量";

	public static final int REVOCATION_FOOD_ERROR = 320;
	public static final String REVOCATION_FOOD_MSG = "退菜数量大于可退的数量";

	public static final int UNPRESENT_FOOD_ERROR = 319;
	public static final String UNPRESENT_FOOD_MSG = "取消赠菜数量大于可赠送的数量";

	public static final int PRESENT_FOOD_ERROR = 334;
	public static final String PRESENT_FOOD_MSG = "赠菜数量大于可赠送的数量";

	public static final int NOT_MERCHANT_ERROR = 322;
	public static final String NOT_MERCHANT_MSG = "商品菜单信息不存在";

	public static final int NOT_ALLOWED_UPDATE_WEIGHT_ERROR = 323;
	public static final String NOT_ALLOWED_UPDATE_WEIGHT_ERROR_MSG = "此菜品不在收银机称重";

	public static final int NOT_PRODUCT_VARIANT_ERROR = 323;
	public static final String NOT_PRODUCT_VARIANT_MSG = "商品变体信息不存在";

	public static final int NOT_PRODUCT_ERROR = 324;
	public static final String NOT_PRODUCT_MSG = "商品信息不存在";

	public static final int ORDER_NOT_EXISTENCE = 325;
	public static final String ORDER_NOT_EXISTENCE_MSG = "子订单不存在";

	public static final int MERCHANT_DISABLE = 326;
	public static final String MERCHANT_DISABLE_MSG = "商品[%s]已经停售";

	/********************** 收银模块 ***********************/
	public static final int PAYMENT_NOT_EXIST=401;
	public static final String PAYMENT_NOT_EXIST_MSG = "支付方式不存在";

	/********************** 结账支付模块 ***********************/
	public static final int PAYMENT_SUCCESS=500;
	public static final String PAYMENT_SUCCESS_MSG = "支付成功";

	public static final int PAYMENT_SUBORDERID_NOT_EXIST=501;
	public static final String PAYMENT_SUBORDERID_NOT_EXIST_MSG = "支付子订单不存在";

	public static final int MERCHANT_ACCOUNT_NOT_EXIST=502;
	public static final String MERCHANT_ACCOUNT_NOT_EXIST_MSG = "商家账户不存在";

	public static final int VALIDATE_PRODUCT_PENDINGWEIGH=503;
	public static final String VALIDATE_PRODUCT_PENDINGWEIGH_MSG = "存在未称重商品";

	public static final int VALIDATE_PRODUCT_SOCALLED=504;
	public static final String VALIDATE_PRODUCT_SOCALLED_MSG = "存在等叫商品";

	public static final int PAYMENT_METHOD_NOT_EXIST=505;
	public static final String PAYMENT_METHOD_NOT_EXIST_MSG = "支付方式不存在";

	public static final int REFUND_SUCCESS=506;
	public static final String REFUND_SUCCESS_MSG = "退款成功";

	public static final int THIRD_PARTY_ERROR=507;
	public static final String THIRD_PARTY_ERROR_MSG = "第三方支付异常";

	public static final int THIRD_PARTY_FAIL=508;
	public static final String THIRD_PARTY_FAIL_MSG = "第三方支付失败";

	public static final int CARD_DISABLE = 509;
	public static final String CARD_DISABLE_MSG = "此卡已停用";

	public static final int CARD_EXPIRED = 510;
	public static final String CARD_EXPIRED_MSG = "此卡已过期";

	public static final int CARD_FROZEN = 511;
	public static final String CARD_FROZEN_MSG = "此卡已冻结";

	public static final int CARD_LOCKING = 512;
	public static final String CARD_LOCKING_MSG = "此卡已锁定";

	public static final int CARD_NOTCERTIFIED = 513;
	public static final String CARD_NOTCERTIFIED_MSG = "此卡未认证";

	public static final int CARD_INITIALIZATION = 514;
	public static final String CARD_INITIALIZATION_MSG = "此卡未初始化";

	public static final int CARD_ADVANCE = 515;
	public static final String CARD_ADVANCE_MSG = "此卡为预售状态";

	public static final int CARD_UNKNOWN = 516;
	public static final String CARD_UNKNOWN_MSG = "无效的会员卡";

	public static final int BOOKING_INFO_NOT_EXIST = 517;
	public static final String BOOKING_INFO_NOT_EXIST_MSG = "预订信息不存在";

	public static final int TABLEUSE_INFO_NOT_EXIST = 518;
	public static final String TABLEUSE_INFO_NOT_EXIST_MSG = "桌台使用信息不存在";

	public static final int ORDER_IS_PAID = 519;
	public static final String ORDER_IS_PAID_MSG = "此单已支付完成";

	public static final int THIRD_PARTY_SUCCESS = 520;
	public static final String THIRD_PARTY_SUCCESS_MSG = "请求第三方接口成功";

	public static final int THIRD_PARTY_PAY_SUCCESS = 521;
	public static final String THIRD_PARTY_PAY_SUCCESS_MSG = "第三方支付成功";

	/********************** 打印花模块 ***********************/
	/********************** 打印模块 ***********************/

	public static final int PRINT_SUCCESS=0;
	public static final String PRINT_SUCCESS_MSG = "打印成功";

	public static final int PRINT_FAIL=-1;
	public static final String PRINT_FAIL_MSG = "打印失败";

	public static final int PRINT_GETDATA_FAIL=2;
	public static final String PRINT_GETDATA_FAIL_MSG = "取打印数据失败";

	public static final int TABLE_NOTINFOR=601;
	public static final String TABLE_NOTINFOR_MSG = "台单配置信息不存在";

	public static final int KITHCHEN_NOTINFOR=602;
	public static final String KITHCHEN_NOTINFOR_MSG = "厨打总单配置信息不存在";

	public static final int KITHCHEN_SINGLE_NOTINFOR=603;
	public static final String KITHCHEN_SINGLE_NOTINFOR_MSG = "厨打总单配置信息不存在";

	public static final int PASSMENU_NOTINFOR=604;
	public static final String PASSMENU_NOTINFOR_MSG = "传菜总单配置信息不存在";

	public static final int THIS_SINGLE_TICKET_IS_PRINTED = 605;
	public static final String THIS_SINGLE_TICKET_IS_PRINTED_MSG = "此厨打分单[%s]己经打印，如有需要请选择重打";

	public static final int THIS_DESK_TICKET_IS_PRINTED = 606;
	public static final String THIS_DESK_TICKET_IS_PRINTED_MSG = "此厨打总单己经打印，如有需要请选择重打";

	public static final int PRINTER_NOT_FOUND = 607;
	public static final String PRINTER_NOT_FOUND_MSG = "找不到此单据的打印机";

	/********************** 档口模块 ***********************/
	public static final int WEIGH_NOTINFOR=701;
	public static final String WEIGH_NOTINFOR_MSG = "期望重量不能为空";

	public static final int WEIGH_PRODUCT_NOT_EXIST=702;
	public static final String WEIGH_PRODUCT_NOT_EXIST_MSG = "此菜品ID[%s]在称重档口未配置";

	/********************** 沽清模块 ***********************/
	public static final int CURBSALE_NOT_LOSS_TO_ZERO = 801;
	public static final String CURBSALE_NOT_LOSS_TO_ZERO_MSG = "最多减少[%s]";

	public static final int CURBSALE_NOT_LESS_THEN_BOOKING = 802;
	public static final String CURBSALE_NOT_LESS_THEN_BOOKING_MSG = "沽清数量至少为本日预订数量";

	public static final int CURBSALE_NOT_LESS_THEN_ZERO = 803;
	public static final String CURBSALE_NOT_LESS_THEN_ZERO_MSG = "沽清数量必须大于0";

	public static final int CURBSALE_MUST_THEN_ZERO = 804;
	public static final String CURBSALE_MUST_THEN_ZERO_MSG = "至少有一个规格的沽清数量大于0";

	public static final int CURBSALE_AVAILABLE_QUANTITY_NOT_ENOUGH = 805;
	public static final String CURBSALE_AVAILABLE_QUANTITY_NOT_ENOUGH_MSG = "可用数量不足";

	/************************预订模块**************************/
	public static Integer TABLE_OCCUPY_ERROR_KEY_CODE = 901;
	public static String TABLE_OCCUPY_ERROR_KEY_MSG = "桌台已被预订";

	public static Integer ORDER_NOT_CANCEL_ERROR_KEY_CODE = 902;
	public static String ORDER_NOT_CANCEL_ERROR_KEY_MSG = "订单不能取消";

	public static Integer RESERVE_TIME_ERROR_KEY_CODE = 903;
	public static String RESERVE_TIME_ERROR_KEY_MSG = "预定时间必须大于当前时间";

	public static Integer PEOPLE_NOT_NULL_ERROR_KEY_CODE = 904;
	public static String PEOPLE_NOT_NULL_ERROR_KEY_MSG = "就餐人数必须大于0";

	public static Integer BOOKING_NOT_ERROR_KEY_CODE = 905;
	public static String BOOKING_NOT_ERROR_KEY_MSG = "无此预定信息";

	public static Integer ORDER_NOT_UPDATE_ERROR_KEY_CODE = 906;
	public static String ORDER_NOT_UPDATE_ERROR_KEY_MSG = "订单不能修改";

	public static Integer ORDER_NOT_EXIST_ERROR_KEY_CODE = 907;
	public static String ORDER_NOT_EXIST_ERROR_KEY_MSG = "订单不存在";

	public static Integer NOT_FIND_MEAL_CODE = 908;
	public static String NOT_FIND_MEAL_MSG = "未找到餐次信息";

	public static Integer NOT_REFUND_AMOUNT_CODE = 909;
	public static String NOT_REFUND_AMOUNT_MSG = "不能退定金";

	public static Integer NOT_GREATER_AMOUNT_CODE = 910;
	public static String NOT_GREATER_AMOUNT_MSG = "不能大于已付定金";

	public static Integer BOOK_TABLE_BE_OCCUPY = 911;
	public static String BOOK_TABLE_BE_OCCUPY_MSG = "预定桌台被占用";

	public static Integer BOOKING_ORDER_NOT_EXISTENCE = 912;
	public static String BOOKING_ORDER_NOT_EXISTENCE_MSG = "预定单不存在";

	/************************折扣模块**************************/
	public static Integer ROLE_DISCOUNT_RATE_ERROR_CODE = 1001;
	public static String ROLE_DISCOUNT_RATE_ERROR_MSG = "你不能打折";

	public static Integer INPUT_DISCOUNT_RATE_ERROR_CODE = 1002;
	public static String INPUT_DISCOUNT_RATE_ERROR_MSG = "输入的折扣非法，输入的范围是[%s]-10";

	public static Integer SELECT_OREDER_CANNOT_ALLOW_DISCOUNT_CODE = 1003;
	public static String SELECT_OREDER_CANNOT_ALLOW_DISCOUNT_MSG = "订单所有商品均不能打折";

	public static Integer ROLE_IS_NOT_MEMBER_DISCOUNT_CODE = 1004;
	public static String ROLE_IS_NOT_MEMBER_DISCOUNT_MSG = "你没有会员折权限";

	public static Integer CARD_UNABLE_CODE = 1005;
	public static String CARD_UNABLE_MSG = "此卡已[%s]，不能打折";

	public static Integer REDUCEAMOUNT_MORE_THAN_LIMIT_CODE = 1006;
	public static String REDUCEAMOUNT_MORE_THAN_LIMIT_MSG = "你已超出每单限额，最多减免[%s]元";

	public static Integer REDUCEAMOUNT_CAN_NOT_IS_ZERO_CODE = 1007;
	public static String RREDUCEAMOUNT_CAN_NOT_IS_ZERO_MSG = "减免金额不能为0";

	public static Integer REDUCEAMOUNT_CAN_NOT_LESS_THAN_ZERO_CODE = 1008;
	public static String REDUCEAMOUNT_CAN_NOT_LESS_THAN_ZERO_MSG = "减免金额不能小于0";

	public static Integer ROLE_MOREST_REDUCE_AMOUNT_CAN_NOT_BE_ZERO_CODE = 1009;
	public static String ROLE_MOREST_REDUCE_AMOUNT_CAN_NOT_BE_ZERO_MSG = "你已没有减免金额！";

	public static Integer ROLE_MOREST_REDUCE_AMOUNT_GREATE_THAN_ZERO_CODE = 1010;
	public static String ROLE_MOREST_REDUCE_AMOUNT_GREATE_THAN_ZERO_MSG = "你的减免金额不足免单，最多减免[%s]元";

	public static Integer CANCLE_DISCOUNT_ERROR_CODE = 1011;
	public static String CANCLE_DISCOUNT_ERROR_MSG = "没有可以取消的折扣";

	public static Integer DISCOUNT_EXIST_CODE = 1012;
	public static String DISCOUNT_EXIST_MSG = "已经存在打折，不能重复打折";

	/************************权限验证模块**************************/
	public static Integer USERNAME_NOT_EXIST_CODE = 1101;
	public static String USERNAME_NOT_EXIST_MSG = "用户不存在";

	public static Integer USERNAME_OR_PASSWORD_ERROR_CODE = 1102;
	public static String USERNAME_OR_PASSWORD_ERROR_MSG = "账号或密码错误";

	public static Integer USER_NOT_HAS_PRIVILEGE_CODE = 1103;
	public static String USER_NOT_HAS_PRIVILEGE_MSG = "用户没有操作权限";

	public static Integer CHECK_PERMISSION_FAIL_CODE = 1104;
	public static String CHECK_PERMISSION_FAIL_MSG = "验权失败";

	/************************停售模块**************************/
	public static Integer MENU_NOT_EXIST_CODE = 1201;
	public static String MENU_NOT_EXIST_MSG = "菜单不存在";

	public static Integer BATCH_DELETE_HALTSSALES_MUST_MORE_THAN__ZERO_CODE = 1202;
	public static String BATCH_DELETE_HALTSSALES_MUST_MORE_THAN__ZERO_MSG = "最少选择一条记录";

	/********************** 桌台负责人模块 ***********************/
	public static Integer TABLE_MANAGER_EXIST = 1301;
	public static String TABLE_MANAGER_EXIST_MSG = "桌台负责人重复，请重新选择";
}
