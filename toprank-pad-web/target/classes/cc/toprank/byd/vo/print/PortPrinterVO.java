package cc.toprank.byd.vo.print;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


/**
 * @author LinYN
 * @date 2017-6-10
 */
public class PortPrinterVO implements Comparable<PortPrinterVO>{

    private Long mappingID;
    private Long printerID;
    private Long portID;
    private String portName;
    private Long categoryID;
    private Long productID;
    private Long variantID;

    public Long getMappingID() {
        return mappingID;
    }

    public void setMappingID(Long mappingID) {
        this.mappingID = mappingID;
    }

    public Long getPrinterID() {
        return printerID;
    }

    public void setPrinterID(Long printerID) {
        this.printerID = printerID;
    }

    public Long getPortID() {
        return portID;
    }

    public void setPortID(Long portID) {
        this.portID = portID;
    }

    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
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

    public Long getVariantID() {
        return variantID;
    }

    public void setVariantID(Long variantID) {
        this.variantID = variantID;
    }

    @Override
    public int compareTo(PortPrinterVO o) {
        return getSortValue() - o.getSortValue();
    }

    private int getSortValue() {
        int category = categoryID == null ? 0 : 1;
        int product = productID == null ? 0 : 1;
        int variant = variantID == null ? 0 : 1;
        return variant << 2 | product << 1 | category;
    }
}
