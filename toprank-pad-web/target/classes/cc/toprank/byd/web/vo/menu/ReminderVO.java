package cc.toprank.byd.web.vo.menu;

/**
 * 催菜信息VO
 * Created by HuangCY on 2017-5-16.
 */
public class ReminderVO {
    //明细ID
    private Long detailID;
    //标签ID
    private Long tagID;
    //商品ID
    private Long productID;
    //变体ID
    private Long variantID;

    public Long getDetailID() {
        return detailID;
    }

    public void setDetailID(Long detailID) {
        this.detailID = detailID;
    }

    public Long getTagID() {
        return tagID;
    }

    public void setTagID(Long tagID) {
        this.tagID = tagID;
    }

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public Long getVariantID() {
        return variantID;
    }

    public void setVariantID(Long variantID) {
        this.variantID = variantID;
    }
}
