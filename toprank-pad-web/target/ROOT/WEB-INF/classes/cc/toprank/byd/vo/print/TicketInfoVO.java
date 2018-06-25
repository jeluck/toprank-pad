package cc.toprank.byd.vo.print;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


import cc.toprank.byd.enums.PrintManageEnum;
import org.springframework.util.Assert;

/**
 * @author LinYN
 * @date 2017-6-10
 */
public class TicketInfoVO {

    private PrintManageEnum.TicketCodeEnum ticketCode; // 票据编码

    private PrintManageEnum.TicketCategoryEnum ticketCategory; // 票据一级分类： 总单、分单、账单 等

    private PrintManageEnum.TicketTypeEnum ticketType; // 票据二级分类： 加菜单、退菜单、等叫单 等

    public TicketInfoVO(PrintManageEnum.TicketCodeEnum ticketCode, PrintManageEnum.TicketCategoryEnum ticketCategory, PrintManageEnum.TicketTypeEnum ticketType) {
        Assert.notNull(ticketCode, "ticketCode is null");
        Assert.notNull(ticketCategory, "ticketCategory is null");
        Assert.notNull(ticketType, "ticketType is null");
        this.ticketCode = ticketCode;
        this.ticketCategory = ticketCategory;
        this.ticketType = ticketType;
    }

    public PrintManageEnum.TicketCodeEnum getTicketCode() {
        return ticketCode;
    }

    public PrintManageEnum.TicketCategoryEnum getTicketCategory() {
        return ticketCategory;
    }

    public PrintManageEnum.TicketTypeEnum getTicketType() {
        return ticketType;
    }
}
