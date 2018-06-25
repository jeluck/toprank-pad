package cc.toprank.byd.enums;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


/**
 * 商户字典类型
 *
 * @author LinYN
 * @date 2017-5-25
 */
public enum DictionaryCatalogEnum {
    /**
     * 操作原因
     */
    OPERATION_TYPE("OperationType", "操作原因"),
    /**
     * 删除估清
     */
    DELETE_CUR_SALE("DeleteCurbSale", "删除估清"),
    /**
     * 手动估清
     */
    MANUAL_CUR_SALE("ManualCurbSale", "手动估清"),
    /**
     * 退菜
     */
    REVOKE_PRODUCT("RevokeProduct", "退菜"),
    /**
     * 赠菜
     */
    GIVE_PRODUCT("GiveProduct", "赠菜"),
    /**
     * 消台
     */
    ELIMINATE_TABLE("EliminateTable", "消台"),
    /**
     * 反结账
     */
    REVOKE_SETTLE("RevokeSettle", "反结账"),
    /**
     * 增加估清
     */
    ADD_CURB_SALE_NUMBER("AddCurbSaleNum", "增加估清"),
    /**
     * 减少估清
     */
    REDUCE_CURB_SALE_NUMBER("ReduceCurbSaleNum", "减少估清"),
    /**
     * 制作报损
     */
    LOSS_PRODUCT("Loss", "制作报损"),

    ADD_TABLE_MANAGER("AddTableMan", "新增桌台负责人"),

    CHANGE_SERVER_CONTENT("ChangeServerContent", "修改服务内容"),

    REMOVE_TABLE_MANAGER("RemoveTableMan", "移除桌台负责人");


    private String code;
    private String name;

    DictionaryCatalogEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
