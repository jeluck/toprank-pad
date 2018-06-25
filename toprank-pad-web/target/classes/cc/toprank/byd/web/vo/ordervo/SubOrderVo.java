package cc.toprank.byd.web.vo.ordervo;/**
 * Created by ZhouWei on 2017-5-4.
 */

import cc.toprank.byd.entity.O_SubOrderInfoEntity;

/**
 * @param
 * @author zhouwei
 * @version 2.0.0
 * @description 子订单信息
 * @time 2017-05-04-15:53
 * @return
 */
public class SubOrderVo extends O_SubOrderInfoEntity{
    private String tableMainName; //桌台名称

    public String getTableMainName() {
        return tableMainName;
    }

    public void setTableMainName(String tableMainName) {
        this.tableMainName = tableMainName;
    }
}
