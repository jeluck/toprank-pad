package cc.toprank.byd.web.vo.curbsale;

/**
 * Created by ChenKY on 2017/5/11.
 */
public class CrubSaleInfoAndBookingInfoVO {

    private Long OptionID;            //选项编号
    private String optionName;        //选项名称
    private Integer bookingSum;       //预定数量
    private Integer initQuantity;     //初始数量
    private Float initFloatQuantity; //小数数量
    private Long mappingID;            //关联编号
    private Float exchangeRate;        //兑换比率

    public Long getOptionID() {
        return OptionID;
    }

    public void setOptionID(Long optionID) {
        OptionID = optionID;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public Integer getBookingSum() {
        return bookingSum;
    }

    public void setBookingSum(Integer bookingSum) {
        this.bookingSum = bookingSum;
    }

    public Integer getInitQuantity() {
        return initQuantity;
    }

    public void setInitQuantity(Integer initQuantity) {
        this.initQuantity = initQuantity;
    }

    public Float getInitFloatQuantity() {
        return initFloatQuantity;
    }

    public void setInitFloatQuantity(Float initFloatQuantity) {
        this.initFloatQuantity = initFloatQuantity;
    }

    public Long getMappingID() {
        return mappingID;
    }

    public void setMappingID(Long mappingID) {
        this.mappingID = mappingID;
    }

    public Float getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Float exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
}
