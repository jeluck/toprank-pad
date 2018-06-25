package cc.toprank.byd.constant;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


/**
 * 参数常量，用于Map中的KEY较多
 *
 * @author LinYN
 * @date 2017-5-13
 */
public interface ParamConstants {

    interface GlobalParam {
        String PARAM_ARCHIVE_ID = "archiveID"; // 机构编号
        String PARAM_SEPARATOR = ","; // 连接字符串时使用的分隔符, SQL中IN查询使用的分隔符
    }

    interface TableParam extends GlobalParam {
        String PARAM_TABLE_ID = "tableID"; // 桌台编号
        String PARAM_TABLE_NAME = "tableName"; // 桌台名称
        String PARAM_TABLE_IDS = "tableIDs"; // 多个桌台编号
        String PARAM_TABLE_STATUS = "tableStatus"; // 桌台状态
        String PARAM_COMBINE_NAME = "combineName"; // 联台名称
        String PARAM_COMBINE_NUMBER = "combineNumber"; // 联台数量
        String PARAM_IS_COMBINE = "isCombine"; // 是否联台
        String PARAM_CUSTOMER_NUMBER = "customerNumber"; // 就餐人数
        String PARAM_SRC_TABLE_ID = "srcTableID"; // 当前桌台编号
        String PARAM_TARGET_TABLE_ID = "targetTableID"; // 目标桌台编号
        String PARAM_AREA_ID = "areaID"; // 区域编号
        String PARAM_TIME = "time"; // 时间
        String PARAM_IS_SHARING = "isSharing"; // 是否关联
        String PARAM_MEALSID = "mealsID"; // 时间
    }

    interface OrderParam extends GlobalParam {
        String PARAM_ORDER_ID = "orderID"; // 订单编号
        String PARAM_NEW_ORDER_ID = "newOrderID"; // 新的主订单编号
        String PARAM_SUB_ORDER_ID = "subOrderID"; // 子订单编号
        String PARAM_NEW_SUB_ORDER_ID = "newSubOrderID"; // 新的子订单编号
        String PARAM_ORDER_DETAIL_ID = "orderDetailID"; // 订单明细编号
        String PARAM_ORDER_DETAIL_IDS = "orderDetailIDs"; // 订单明细编号（多个）
        String PARAM_DETAIL_ID = "detailID"; // 订单明细编号
        String PARAM_QUANTITY = "quantity"; // 数量
        String PARAM_FLOAT_QUANTITY = "floatQuantity"; // 称重
        String PARAM_PRICE = "price"; // 价格
        String PARAM_PRODUCE_STATUS = "produceStatus"; // 制作状态
        String PARAM_MEMO = "memo"; // 制作状态
    }

    interface ProductParam extends GlobalParam {
        String PARAM_PRODUCT_ID = "productID"; // 商品编号
        String PARAM_VARIANT_ID = "variantID"; // 变体编号
    }

    interface CurbSaleParam extends GlobalParam {
        String NEEDWEIGH = "needWeigh";
        String STOREDAY = "storeDay";
        String CATEGORYID = "categoryID";
        String CHANGETYPE = "changeType";
        String LOGINID = "loginID"; //登录编号
        String CATALOGCODE_OPERATIONTYPE = "OperationType"; //沽清操作类型，DB商户目录分类操作类型的常量值
    }

    interface DictionaryParam extends GlobalParam {
        String PARAM_CATALOG_CODE = "catalogCode"; // 字典编码
    }

    interface PrintParam extends GlobalParam {
        String PARAM_TICKET_CODE = "ticketCode"; // 单据编号
        String PARAM_TICKET_TYPE = "ticketType"; // 单据类型
    }
}
