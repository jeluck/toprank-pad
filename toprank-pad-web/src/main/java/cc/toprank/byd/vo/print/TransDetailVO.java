package cc.toprank.byd.vo.print;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


import java.math.BigDecimal;
import java.util.List;

/**
 *
 * 交接明细
 *
 * @author LinYN
 * @date 2017-6-5
 */
public class TransDetailVO {

    private String project; // 交接项目
    private BigDecimal totalAmount; // 合计金额
    private Integer totalCount; // 交易总数
    private List<PaymentDetailVO> payDetails; // 结算明细

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<PaymentDetailVO> getPayDetails() {
        return payDetails;
    }

    public void setPayDetails(List<PaymentDetailVO> payDetails) {
        this.payDetails = payDetails;
    }
}


