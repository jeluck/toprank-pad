package cc.toprank.byd.web.vo.product;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


import java.util.ArrayList;
import java.util.List;

/**
 * @author LinYN
 * @date 2017-5-3
 */
public class ProductWeightRequestVo {

    private Long archiveID;

    private List<ProductWeightVo> productWeights = new ArrayList<>();

    public Long getArchiveID() {
        return archiveID;
    }

    public void setArchiveID(Long archiveID) {
        this.archiveID = archiveID;
    }

    public List<ProductWeightVo> getProductWeights() {
        return productWeights;
    }

    public void setProductWeights(List<ProductWeightVo> productWeights) {
        this.productWeights = productWeights;
    }
}
