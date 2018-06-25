package cc.toprank.byd.enums;

/**
 * 支付枚举类
 * Created by HuangCY on 2017-5-25.
 */
public class PaymentEnum {
    /**
     *
     * 支付方式
     */
    public enum PaymentMethod{

        /**
         * 微信
         */
        WEIXIN_PAY(1, "微信"),

        /**
         * 支付宝
         */
        ALI_PAY(2, "支付宝"),
        /**
         * 银联
         */
        UNION_PAY(3, "银联"),
        /**
         * K币
         */
        KCOIN(4, "K币"),
        /**
         * 现金
         */
        CASH(5, "现金");

        private final long value;
        private final String name;

        private PaymentMethod(long value,String name) {
            this.value = value;
            this.name = name;
        }

        public long getValue() {
            return this.value;
        }

        public String getName() {
            return this.name;
        }
    }

    /**
     *
     * 支付回调类型
     */
    public enum CallBackTag{
        /**
         * 消费支付
         */
        CONSUMER_PAYMENT("1", "消费支付"),
        /**
         * 定金缴纳
         */
        BOOKING_AMOUNT_PAY("2", "定金缴纳"),
        /**
         * 充值
         */
        RECHARGE("3", "充值");


        private final String value;
        private final String name;

        private CallBackTag(String value,String name) {
            this.value = value;
            this.name = name;
        }

        public String getValue() {
            return this.value;
        }

        public String getName() {
            return this.name;
        }
    }
}
