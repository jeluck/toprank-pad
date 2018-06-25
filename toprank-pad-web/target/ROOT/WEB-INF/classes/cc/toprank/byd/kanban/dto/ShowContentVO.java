package cc.toprank.byd.kanban.dto;

/**
 * 用于看板定制显示字段
 *
 * @author LeeJun
 * @create 2017-04-06 15:22
 */
public class ShowContentVO {

    private boolean price = true;
    private boolean remainingSeconds = true;
    private boolean clerkName = true;
    private boolean productName = true;
    private boolean tableName = true;
    private boolean quantity = true;
    private boolean optionName = true;
    private boolean attributeName = true;
    private boolean createTime = true;
    private boolean memo = true;

    public boolean isMemo() {
        return memo;
    }

    public void setMemo(boolean memo) {
        this.memo = memo;
    }

    public boolean isPrice() {
        return price;
    }

    public void setPrice(boolean price) {
        this.price = price;
    }

    public boolean isRemainingSeconds() {
        return remainingSeconds;
    }

    public void setRemainingSeconds(boolean remainingSeconds) {
        this.remainingSeconds = remainingSeconds;
    }

    public boolean isClerkName() {
        return clerkName;
    }

    public void setClerkName(boolean clerkName) {
        this.clerkName = clerkName;
    }

    public boolean isProductName() {
        return productName;
    }

    public void setProductName(boolean productName) {
        this.productName = productName;
    }

    public boolean isTableName() {
        return tableName;
    }

    public void setTableName(boolean tableName) {
        this.tableName = tableName;
    }

    public boolean isQuantity() {
        return quantity;
    }

    public void setQuantity(boolean quantity) {
        this.quantity = quantity;
    }

    public boolean isOptionName() {
        return optionName;
    }

    public void setOptionName(boolean optionName) {
        this.optionName = optionName;
    }

    public boolean isAttributeName() {
        return attributeName;
    }

    public void setAttributeName(boolean attributeName) {
        this.attributeName = attributeName;
    }

    public boolean isCreateTime() {
        return createTime;
    }

    public void setCreateTime(boolean createTime) {
        this.createTime = createTime;
    }
}
