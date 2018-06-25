package cc.toprank.byd.stall.dto;

/**
 * 产品信息VO类
 * @author ZhaoLC
 * @Time 2017-3-10 14:00
 */
public class ProductVO {
    /**
     * 商家ID
     */
    private Long archiveID;
    /**
     * 搜索关键字
     */
    private String keyWord;
    /**
     * 商品分类ID
     */
    private Long categoryID;
    /**
     * 商品ID
     */
    private Long productID;

    public Long getArchiveID() {
        return archiveID;
    }

    public void setArchiveID(Long archiveID) {
        this.archiveID = archiveID;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public Long getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Long categoryID) {
        this.categoryID = categoryID;
    }

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }
}
