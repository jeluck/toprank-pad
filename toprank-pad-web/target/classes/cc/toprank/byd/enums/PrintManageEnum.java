package cc.toprank.byd.enums;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


import org.springframework.util.Assert;

/**
 * @author LinYN
 * @date 2017-6-10
 */
public class PrintManageEnum {

    public enum PrinterStatusEnum {

        STATE_OFFLINE(0, "离线"),

        STATE_ONLINE(1, "在线"),

        STATE_ERROR(2, "故障") ;

        private PrinterStatusEnum(int status, String description) {
            this.status = status;
            this.description = description;
        }

        private final int status;

        private final String description;

        public int getStatus() {
            return status;
        }

        public String getDescription() {
            return description;
        }

        public static PrinterStatusEnum valueOf(int status) {
            if (STATE_OFFLINE.status == status) {
                return STATE_OFFLINE;
            } else if (STATE_ONLINE.status == status) {
                return STATE_ONLINE;
            } else if (STATE_ERROR.status == status) {
                return STATE_ERROR;
            } else {
                throw new IllegalArgumentException("Invalid status value of PrinterStatusEnum");
            }
        }
    }


    public enum TicketCategoryEnum {

        PRODUCT_TICKET(1, "分单"),

        TOTAL_TICKET(2, "总单"),

        TABLE_TICKET(3, "台单"),

        AMOUNT_TICKET(4, "账单");

        private int code;

        private String description;

        TicketCategoryEnum(int code, String description) {
            this.code = code;
            this.description = description;
        }

        public int getCode() {
            return code;
        }

        public String getDescription() {
            return description;
        }
    }


    public enum TicketTypeEnum {

        NORMAL(1, "出品"),
        WAITING(2, "等叫"),
        NOTIFY(3, "叫起"),
        DO_FIRST(4, "先做"),
        DONE(5, "免做"),
        PUSH(6, "催菜"),
        APPEND(7, "加菜"),
        RETURN(8, "退菜"),
        SHARING(9, "拼菜"),
        COMBO(10, "套餐"),
        TURN(11, "转菜"),
        TURN_GIVE(12, "转赠"),
        GIVE(13, "赠菜"),
        CHANGE(14, "换菜"),
        MULTIMEDIA(15, "一鱼多味"),
        COMBINED(16, "联台"),
        GROUP(17, "席数出品"),
        BOOKING(18, "预订"),
        WEIGHTING(19, "称重"),
        STALL(20, "档口"),

        SETTLE_BILL(1, "暂结单"),
        PAYMENT_BILL(2, "结账单"),
        BOOKING_BILL(3, "预订账单"),
        REPAY_BILL(4, "还款账单"),
        CHANGE_BILL(5, "交班对账单"),
        DAILY_BILL(6, "日结对账单"),
        CARD_REAPY_BILL(7, "会员充值单"),
        CARD_SETTLE_BILL(8, "会员付款单");

        private int code;

        private String description;

        TicketTypeEnum(Integer code, String description) {
            this.code = code;
            this.description = description;
        }

        public int getCode() {
            return code;
        }

        public String getDescription() {
            return description;
        }

        /**
         * 类型编码 * 100 + 单据编码
         *
         * @param ticketCategory
         * @return
         */
        public int getTypeCode(TicketCategoryEnum ticketCategory) {
            Assert.notNull(ticketCategory, "ticketCategory is null");
            return ticketCategory.getCode() * 100 + this.code;
        }

        public String getTypeName(TicketCategoryEnum ticketCategory) {
            Assert.notNull(ticketCategory, "ticketCategory is null");
            switch (ticketCategory) {
                case AMOUNT_TICKET:
                    return this.description;
                default:
                    return this.description + ticketCategory.getDescription();
            }
        }


        @Override
        public String toString() {
            return getDescription();
        }
    }


    public enum TicketCodeEnum {

        POLICY_TICKET("PolicyTicket", "分单"),
        ADVANCE_TICKET("AdvanceTicket", "暂结单"),
        RECKONING_TICKET("ReckoningTicket", "结帐单"),
        TOTAL_TICKET("TotalTicket", "总单"),
        SHIFT_CHECK_TICKET("ShiftCheckTicket", "交接班对账单"),
        SUN_PAIRED_THE_TICKET("SunPairedTheTicket", "日结对账单"),
        RECHARGE_TICKET("RechargeTicket", "会员充值单"),
        PAYMENT_TICKET("PaymentTicket", "会员付款单"),
        REPAYMENT_TICKET("RepaymentTicket", "还款单"),
        CONNECT_CODE_TICKET("ConnectCode", "交接单");


        TicketCodeEnum(String code, String description) {
            this.code = code;
            this.description = description;
        }

        private String code;

        private String description;

        public String getCode() {
            return code;
        }

        public String getDescription() {
            return description;
        }
    }
}
