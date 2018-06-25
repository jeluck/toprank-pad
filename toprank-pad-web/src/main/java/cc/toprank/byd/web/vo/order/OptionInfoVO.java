package cc.toprank.byd.web.vo.order;

/**
 * Created by HuTao on 2017-5-4.
 */
public class OptionInfoVO {
    private  String optionName;      // 规格
    private  double addedPrice;      //  规格 加价

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public double getAddedPrice() {
        return addedPrice;
    }

    public void setAddedPrice(double addedPrice) {
        this.addedPrice = addedPrice;
    }
}
