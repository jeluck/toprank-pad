package cc.toprank.byd.web.vo.product;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


import java.util.List;

/**
 * 复制菜时请求使用的VO
 *
 * @author LinYN
 * @date 2017-5-13
 */
public class ProductCopyRequestVo {

    private Long archiveID;

    private Long subOrderID; // 子订单编号

    private List<ProductQuantityVo> copyProducts;

    private Long targetTableID; // 目标桌台编号

    private Long targetSubOrderID; // 目标桌台的子订单编号

    public Long getArchiveID() {
        return archiveID;
    }

    public void setArchiveID(Long archiveID) {
        this.archiveID = archiveID;
    }

    public Long getSubOrderID() {
        return subOrderID;
    }

    public void setSubOrderID(Long subOrderID) {
        this.subOrderID = subOrderID;
    }

    public List<ProductQuantityVo> getCopyProducts() {
        return copyProducts;
    }

    public void setCopyProducts(List<ProductQuantityVo> copyProducts) {
        this.copyProducts = copyProducts;
    }

    public Long getTargetTableID() {
        return targetTableID;
    }

    public void setTargetTableID(Long targetTableID) {
        this.targetTableID = targetTableID;
    }

    public Long getTargetSubOrderID() {
        return targetSubOrderID;
    }

    public void setTargetSubOrderID(Long targetSubOrderID) {
        this.targetSubOrderID = targetSubOrderID;
    }
}
