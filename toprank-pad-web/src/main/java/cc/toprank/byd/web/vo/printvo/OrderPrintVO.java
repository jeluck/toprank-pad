package cc.toprank.byd.web.vo.printvo;/**
 * Created by ZhouWei on 2017-6-8.
 */

import cc.toprank.byd.vo.print.ProductDetailVO;
import cc.toprank.byd.vo.print.TableInfoVO;

import java.util.List;

/**
 * @param
 * @author zhouwei
 * @version 2.0.0
 * @description 退菜，转菜信息打印
 * @time 2017-06-08-15:29
 * @return
 */
public class OrderPrintVO {
    private TableInfoVO tableInfo;
    private ProductDetailVO productDetailVO;
    private List<ProductDetailVO> productDetailVOList;
    public TableInfoVO getTableInfo() {
        return tableInfo;
    }

    public List<ProductDetailVO> getProductDetailVOList() {
        return productDetailVOList;
    }

    public void setProductDetailVOList(List<ProductDetailVO> productDetailVOList) {
        this.productDetailVOList = productDetailVOList;
    }

    public void setTableInfo(TableInfoVO tableInfo) {
        this.tableInfo = tableInfo;
    }

    public ProductDetailVO getProductDetailVO() {
        return productDetailVO;
    }

    public void setProductDetailVO(ProductDetailVO productDetailVO) {
        this.productDetailVO = productDetailVO;
    }
}
