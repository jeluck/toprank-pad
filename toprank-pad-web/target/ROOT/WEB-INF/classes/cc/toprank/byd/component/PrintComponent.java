package cc.toprank.byd.component;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


import cc.toprank.byd.common.utils.BooleanUtil;
import cc.toprank.byd.common.utils.ObjectUtil;
import cc.toprank.byd.common.utils.number.NumberUtil;
import cc.toprank.byd.constant.ParamConstants;
import cc.toprank.byd.constant.PrintConstants;
import cc.toprank.byd.dao.O_TicketPrintDealInfoDao;
import cc.toprank.byd.dao.O_TicketPrintInfoDao;
import cc.toprank.byd.entity.O_TicketPrintDealInfoEntity;
import cc.toprank.byd.entity.O_TicketPrintInfoEntity;
import cc.toprank.byd.enums.CommonManageEnum;
import cc.toprank.byd.enums.MerchantManageEnum;
import cc.toprank.byd.enums.PrintManageEnum;
import cc.toprank.byd.util.CollectionHelper;
import cc.toprank.byd.vo.print.*;
import cc.toprank.byd.vo.print.ticket.*;
import com.alibaba.fastjson.JSON;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.*;

/**
 * 票据打印组件
 *
 * @author LinYN
 * @date 2017-5-18
 */
@Component
public class PrintComponent implements PrintConstants, ParamConstants.PrintParam {

    // 日志打印
    private static final Logger logger = LoggerFactory.getLogger(PrintComponent.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private MerchantComponent merchantComponent;

    @Autowired
    private O_TicketPrintInfoDao ticketPrintInfoDao;

    @Autowired
    private O_TicketPrintDealInfoDao ticketPrintDealInfoDao;

    private static final String subTitlePattern = "(第{0}次{1})"; // 第1次加菜

    /*
     * 打印单据公共处理方法
     *
     * @param ticket
     * @author LinYN
     * @date 2017-6-5
     */
    private void print(PrinterTicketVO ticket, BusinessVO businessInfo, TicketInfoVO ticketInfo) {
        Assert.notNull(ticket, "ticket is null");
        Assert.notNull(businessInfo, "businessInfo is null");
        Assert.notNull(ticketInfo, "ticketCode is null");
        businessInfo.setDataType(ticketInfo.getTicketType().getCode());

        ticket.setPrintCount(PrintConfig.DEFAULT_PRINT_COUNT);
        ticket.setCompany(merchantComponent.getCurrentOrganizationInfo().getOrgName());
        ticket.setTitle(ticketInfo.getTicketType().getTypeName(ticketInfo.getTicketCategory()));
        // 打印记录
        List<O_TicketPrintInfoEntity> ticketPrintInfoList = getTicketPrintInfoByBusinessInfo(businessInfo);
        O_TicketPrintInfoEntity ticketPrintInfo = null;
        if (CollectionUtils.isNotEmpty(ticketPrintInfoList)) {
            ticketPrintInfo = ticketPrintInfoList.get(ticketPrintInfoList.size() - 1);
        }
        if (ticketPrintInfo == null || PrintManageEnum.TicketCategoryEnum.TOTAL_TICKET.equals(ticketInfo.getTicketCategory())) {
            ticketPrintInfo = new O_TicketPrintInfoEntity();
            ticketPrintInfo.setBusinessID(businessInfo.getBusinessID());
            ticketPrintInfo.setBusinessType(businessInfo.getBusinessType());
            ticketPrintInfo.setArchiveID(businessInfo.getArchiveID());
            ticketPrintInfo.setTicketName(ticket.getTitle());
            ticketPrintInfo.setPrintNumber(1);
            ticketPrintInfo.setCreatorID(businessInfo.getOperatorID());
            ticketPrintInfo.setCreateTime(LocalDateTime.now());
            ticketPrintInfoDao.save(ticketPrintInfo);
        } else {
            ticketPrintInfo.setPrintNumber(NumberUtil.add(ticketPrintInfo.getPrintNumber(), 1));
        }
        // 设置副标题
        Integer printCount = ticketPrintInfoList == null ? 0 : ticketPrintInfoList.size();
        if (printCount > 0) {
            switch (ticketInfo.getTicketType()) {
                case NORMAL:
                    ticket.setSubTitle(MessageFormat.format(
                            subTitlePattern, printCount, PrintManageEnum.TicketTypeEnum.APPEND.getDescription()));
                    break;
                case APPEND:
                case RETURN:
                    ticket.setSubTitle(MessageFormat.format(
                            subTitlePattern, printCount, ticketInfo.getTicketType().getDescription()));
                    break;
                default:break;
            }
        }
        // 获取打印机
        PrinterVO printer = null;
        if (businessInfo instanceof ProductDetailVO) {
            ProductDetailVO productDetail = (ProductDetailVO) businessInfo;
            printer = findPrinter(ticketInfo, productDetail);
            PortPrinterVO port = printer.getPort();
            if (port != null) {
                // 设置出品口
                productDetail.setProducePort(port.getPortName());
                ticketPrintInfo.setPortID(port.getPortID());
            }
        } else {
            printer = findPrinter(ticketInfo, businessInfo.getArchiveID());
        }
        printer.setBillType(ticketInfo.getTicketType().getTypeCode(ticketInfo.getTicketCategory()));
        ticket.setPrinter(printer);
        ticket.setPrintTime(LocalDateTime.now());
        // 创建打印单据
        List<PrinterTicketVO> tickets = new ArrayList<>();
        tickets.add(ticket);
        PrintTicketVO printTicket = new PrintTicketVO();
        printTicket.setDevType(DeviceType.PRINTER_DEV);
        printTicket.setMsgType(MessageType.PRINTER_MSG_PRINT);
        printTicket.setSn(ticketPrintInfo.getRecordID());
        printTicket.setMsgValue(tickets);
        String longContent = JSON.toJSONString(printTicket);
        ticketPrintInfo.setMappingID(printer.getMappingID());
        ticketPrintInfo.setDataType(businessInfo.getDataType());
        ticketPrintInfo.setPrintStatus(MerchantManageEnum.PrintStatus.PRINTING.getValue());
        ticketPrintInfo.setLongContent(longContent);
        ticketPrintInfoDao.update(ticketPrintInfo);
        // send
        rabbitTemplate.setQueue(PrintConfig.PRINT_DOWN_QUEUE);
        rabbitTemplate.convertAndSend(PrintConfig.PRINT_DOWN_QUEUE, longContent);
    }


    private List<PrinterVO> findPrinterList(TicketInfoVO ticketInfo, Long archiveID) {
        Assert.notNull(ticketInfo, "ticketInfo is null");
        Assert.notNull(archiveID, "archiveID is null");
        Map<String, Object> queryParam = new HashedMap();
        queryParam.put(PARAM_ARCHIVE_ID, archiveID);
        queryParam.put(PARAM_TICKET_CODE, ticketInfo.getTicketCode().getCode());
        queryParam.put(PARAM_TICKET_TYPE, ticketInfo.getTicketType().getTypeCode(ticketInfo.getTicketCategory()));
        return ticketPrintInfoDao.getPrinterListByTicketCode(queryParam);
    }

    private PrinterVO findPrinter(TicketInfoVO ticketInfo, Long archiveID) {
        List<PrinterVO> printerList = findPrinterList(ticketInfo, archiveID);
        if (CollectionUtils.isEmpty(printerList)) {
            return new PrinterVO();
        };
        return printerList.get(0);
    }

    private PrinterVO findPrinter(TicketInfoVO ticketInfo, ProductDetailVO productDetail) {
        List<PrinterVO> printerList = findPrinterList(ticketInfo, productDetail.getArchiveID());
        if (CollectionUtils.isEmpty(printerList)) {
            return new PrinterVO();
        };
        List<PortPrinterVO> portPrinters = ticketPrintInfoDao.getPortPrinterByProductDetail(productDetail);
        if (CollectionUtils.isEmpty(portPrinters)) {
            return printerList.get(0);
        }
        Collections.sort(portPrinters, Comparator.nullsLast(Comparator.reverseOrder()));
        return matchPrinter(printerList, portPrinters);
    }

    private PrinterVO matchPrinter(List<PrinterVO> printerList, List<PortPrinterVO> portPrinters) {
        for (PortPrinterVO portPrinter : portPrinters) {
            if (portPrinter == null) continue ;
            for (PrinterVO printer : printerList) {
                if (printer != null && ObjectUtil.equals(portPrinter.getPrinterID(), printer.getPrinterID())) {
                    printer.setPort(portPrinter);
                    return printer;
                }
            }
        }
        return printerList.get(0);
    }


    private List<O_TicketPrintInfoEntity> getTicketPrintInfoByBusinessInfo(BusinessVO businessInfo) {
        Assert.notNull(businessInfo, "businessInfo is null");
        Assert.notNull(businessInfo.getBusinessID(), "businessID is null");
        Assert.notNull(businessInfo.getBusinessType(), "businessType is null");
        return ticketPrintInfoDao.getTicketPrintInfoByBusinessIDAndType(businessInfo);
    }

    /**
     * 打印厨单（分单）
     *
     * @param tableInfo
     * @param productDetail
     */
    private void printProductTicket(TableInfoVO tableInfo, ProductDetailVO productDetail, TicketInfoVO ticketInfo) {
        Assert.notNull(tableInfo, "tableInfo is null");
        Assert.notNull(productDetail, "productDetail is null");
        Assert.notNull(productDetail.getArchiveID(), "archiveID is null");
        Assert.notNull(productDetail.getBusinessID(), "businessID is null");
        if (BooleanUtil.isTrue(productDetail.getCombo())) {
            productDetail.setBusinessType(CommonManageEnum.BusinessType.COMBODETAIL.getValue());
        } else {
            productDetail.setBusinessType(CommonManageEnum.BusinessType.ORDERDETAIL.getValue());
        }
        if (tableInfo.getTotalAmount() == null) {
            tableInfo.setTotalAmount(productDetail.getAmount());
        }
        if (tableInfo.getTotalQuantity() == null) {
            tableInfo.setTotalQuantity(productDetail.getQuantity());
        }
        // 打印厨单（分单）
        ProductTicketVO productTicket = new ProductTicketVO();
        productTicket.setTableInfo(tableInfo);
        productTicket.setProductDetail(productDetail);

        print(productTicket, productDetail, ticketInfo);
    }

    /**
     * 打印厨单（分单）
     *
     * @param tableInfo
     * @param productDetail
     */
    @Async
    public void printProductTicket(TableInfoVO tableInfo, ProductDetailVO productDetail) {
        TicketInfoVO ticketInfo = new TicketInfoVO(PrintManageEnum.TicketCodeEnum.POLICY_TICKET
                , PrintManageEnum.TicketCategoryEnum.PRODUCT_TICKET, productDetail.getTicketType());
        printProductTicket(tableInfo, productDetail, ticketInfo);
    }

    /**
     * 打印称重单（分单）
     *
     * @param tableInfo
     * @param productDetail
     */
    @Async
    public void printProductWeightTicket(TableInfoVO tableInfo, ProductDetailVO productDetail) {
        TicketInfoVO ticketInfo = new TicketInfoVO(PrintManageEnum.TicketCodeEnum.POLICY_TICKET
                , PrintManageEnum.TicketCategoryEnum.PRODUCT_TICKET, PrintManageEnum.TicketTypeEnum.WEIGHTING);
        printProductTicket(tableInfo, productDetail, ticketInfo);
    }

    /**
     * 打印称重单（总单）
     *
     * @param tableInfo
     * @param details
     */
    @Async
    public void printProductWeightTicket(TableInfoVO tableInfo, List<ProductDetailVO> details) {
        Assert.notNull(tableInfo, "tableInfo is null");
        Assert.notNull(tableInfo.getBusinessID(), "businessID is null");
        Assert.notNull(tableInfo.getArchiveID(), "archiveID is null");
        Assert.notEmpty(details, "details is empty");
        tableInfo.setBusinessType(CommonManageEnum.BusinessType.SUBORDER.getValue());
        for (ProductDetailVO productDetail : details) {
            productDetail.setArchiveID(tableInfo.getArchiveID());
            TicketInfoVO ticketInfo = new TicketInfoVO(PrintManageEnum.TicketCodeEnum.POLICY_TICKET
                    , PrintManageEnum.TicketCategoryEnum.PRODUCT_TICKET, PrintManageEnum.TicketTypeEnum.WEIGHTING);
            printProductTicket(tableInfo, productDetail, ticketInfo);
        }
    }

    /**
     * 打印台单（总单） 和厨单（分单）
     *
     * @param tableInfo
     * @param details
     */
    @Async
    public void printTableTicket(TableInfoVO tableInfo, List<ProductDetailVO> details) {
        Assert.notNull(tableInfo, "tableInfo is null");
        Assert.notNull(tableInfo.getBusinessID(), "businessID is null");
        Assert.notNull(tableInfo.getArchiveID(), "archiveID is null");
        Assert.notEmpty(details, "details is empty");
        tableInfo.setBusinessType(CommonManageEnum.BusinessType.SUBORDER.getValue());
        tableInfo.setTotalAmount(CollectionHelper.sum(details, detail -> detail.getAmount()));
        tableInfo.setTotalQuantity(CollectionHelper.sumOfInteger(details, detail -> detail.getQuantity()
                , detail -> !(BooleanUtil.isTrue(detail.getCombo()) && detail.getVariantID() != null) )); // 套餐明细的数量不计算
        // 打印总单
        List<ProductDetailTicketVO> detailTickets = CollectionHelper.map(details, detail -> new ProductDetailTicketVO(detail));
        TableTicketVO tableTicket = new TableTicketVO();
        tableTicket.setTableInfo(tableInfo);
        tableTicket.setDetails(detailTickets);
        TicketInfoVO ticketInfo = new TicketInfoVO(PrintManageEnum.TicketCodeEnum.TOTAL_TICKET
                , PrintManageEnum.TicketCategoryEnum.TOTAL_TICKET
                , PrintManageEnum.TicketTypeEnum.NORMAL);
        print(tableTicket, tableInfo, ticketInfo);
        // 根据不同的点菜方式打印不同的总单
        Map<PrintManageEnum.TicketTypeEnum, List<ProductDetailVO>> typedDetailsMap = CollectionHelper.group(details, detail -> detail.getTicketType());
        for (Map.Entry<PrintManageEnum.TicketTypeEnum, List<ProductDetailVO>> typedDetailEntry : typedDetailsMap.entrySet()) {
            PrintManageEnum.TicketTypeEnum ticketType = typedDetailEntry.getKey();
            // 出品总单不再打印
            if (PrintManageEnum.TicketTypeEnum.NORMAL.equals(ticketType)) continue;
            List<ProductDetailVO> typedDetails = typedDetailEntry.getValue();
            if (typedDetails == null || typedDetails.size() < 2) continue;
            tableInfo.setTotalAmount(CollectionHelper.sum(typedDetails, detail -> detail.getAmount()));
            tableInfo.setTotalQuantity(CollectionHelper.sumOfInteger(typedDetails, detail -> detail.getQuantity()
                    , detail -> !(BooleanUtil.isTrue(detail.getCombo()) && detail.getVariantID() != null) )); // 套餐明细的数量不计算
            List<ProductDetailTicketVO> typedDetailTickets = CollectionHelper.map(details, detail -> new ProductDetailTicketVO(detail));
            TableTicketVO subTableTicket = new TableTicketVO();
            subTableTicket.setTableInfo(tableInfo);
            subTableTicket.setDetails(typedDetailTickets);
            tableInfo.setBusinessType(CommonManageEnum.BusinessType.SUBORDER.getValue());
            TicketInfoVO subTicketInfo = new TicketInfoVO(PrintManageEnum.TicketCodeEnum.TOTAL_TICKET
                    , PrintManageEnum.TicketCategoryEnum.TOTAL_TICKET, ticketType);
            print(subTableTicket, tableInfo, subTicketInfo);
        }
        // 打印总单的同时打印分单
        for (ProductDetailVO productDetail : details) {
            // 套餐不打分单，但打印套餐明细分单
            if (BooleanUtil.isTrue(productDetail.getCombo())
                    && productDetail.getVariantID() == null) continue;
            productDetail.setArchiveID(tableInfo.getArchiveID());
            if (productDetail.getOperatorID() == null) {
                productDetail.setOperatorID(tableInfo.getOperatorID());
            }
            printProductTicket(tableInfo, productDetail);
        }
    }

    /**
     * 打印暂结单
     *
     * @param settleInfo
     * @param details
     */
    @Async
    public void printSettleTicket(SettleInfoVO settleInfo, List<ProductDetailVO> details) {
        Assert.notNull(settleInfo, "settleInfo is null");
        Assert.notNull(settleInfo.getBusinessID(), "businessID is null");
        Assert.notNull(settleInfo.getArchiveID(), "archiveID is null");
        Assert.notEmpty(details, "details is empty");

        List<ProductDetailTicketVO> detailTickets = CollectionHelper.map(details, detail -> new ProductDetailTicketVO(detail));
        SettleTicketVO settleTicket = new SettleTicketVO();
        settleTicket.setSettleInfo(settleInfo);
        settleTicket.setDetails(detailTickets);
        settleInfo.setBusinessType(CommonManageEnum.BusinessType.SUBORDER.getValue());
        TicketInfoVO ticketInfo = new TicketInfoVO(PrintManageEnum.TicketCodeEnum.ADVANCE_TICKET
                , PrintManageEnum.TicketCategoryEnum.AMOUNT_TICKET
                , PrintManageEnum.TicketTypeEnum.SETTLE_BILL);
        print(settleTicket, settleInfo, ticketInfo);
    }

    /**
     * 打印结账单
     *
     * @param settleInfo
     * @param details
     * @param payment
     * @param memberCardInfo
     */
    @Async
    public void printPaymentTicket(SettleInfoVO settleInfo, List<ProductDetailVO> details, PaymentInfoVO payment, MemberCardInfoVO memberCardInfo) {
        Assert.notNull(settleInfo, "settleInfo is null");
        Assert.notNull(payment, "payment is null");
        Assert.notNull(settleInfo.getBusinessID(), "businessID is null");
        Assert.notNull(settleInfo.getArchiveID(), "archiveID is null");
        Assert.notEmpty(details, "details is empty");

        List<ProductDetailTicketVO> detailTickets = CollectionHelper.map(details, detail -> new ProductDetailTicketVO(detail));
        PaymentTicketVO paymentTicket = new PaymentTicketVO();
        paymentTicket.setSettleInfo(settleInfo);
        paymentTicket.setPayment(payment);
        paymentTicket.setDetails(detailTickets);
        if (memberCardInfo != null) {
            paymentTicket.setMemberCardInfo(memberCardInfo);
        }
        settleInfo.setBusinessType(CommonManageEnum.BusinessType.SUBORDER.getValue());
        TicketInfoVO ticketInfo = new TicketInfoVO(PrintManageEnum.TicketCodeEnum.RECKONING_TICKET
                , PrintManageEnum.TicketCategoryEnum.AMOUNT_TICKET
                , PrintManageEnum.TicketTypeEnum.PAYMENT_BILL);
        print(paymentTicket, settleInfo, ticketInfo);
    }

    /**
     * 打印还款单
     *
     * @param repayment
     */
    @Async
    public void printRepaymentTicket(RepaymentVO repayment) {
        Assert.notNull(repayment, "repayment is null");
        Assert.notNull(repayment.getBusinessID(), "businessID is null");
        Assert.notNull(repayment.getArchiveID(), "archiveID is null");

        RepaymentTicketVO repaymentTicket = new RepaymentTicketVO();
        repaymentTicket.setRepayment(repayment);
        repayment.setBusinessType(CommonManageEnum.BusinessType.SUBORDER.getValue());
        TicketInfoVO ticketInfo = new TicketInfoVO(PrintManageEnum.TicketCodeEnum.REPAYMENT_TICKET
                , PrintManageEnum.TicketCategoryEnum.AMOUNT_TICKET
                , PrintManageEnum.TicketTypeEnum.REPAY_BILL);
        print(repaymentTicket, repayment, ticketInfo);
    }

    /**
     * 会员充值单
     *
     * @param memberRecharge
     * @param memberCardInfo
     */
    @Async
    public void printMemberRechargeTicket(MemberRechargeVO memberRecharge, MemberCardInfoVO memberCardInfo) {
        Assert.notNull(memberRecharge, "memberRecharge is null");
        Assert.notNull(memberRecharge.getBusinessID(), "businessID is null");
        Assert.notNull(memberRecharge.getArchiveID(), "archiveID is null");
        Assert.notNull(memberCardInfo, "memberCardInfo is null");

        MemberRechargeTicketVO memberRechargeTicket = new MemberRechargeTicketVO();
        memberRechargeTicket.setMemberRecharge(memberRecharge);
        memberRechargeTicket.setMemberCardInfo(memberCardInfo);
        memberRecharge.setBusinessType(CommonManageEnum.BusinessType.RECHARGE.getValue());
        TicketInfoVO ticketInfo = new TicketInfoVO(PrintManageEnum.TicketCodeEnum.RECHARGE_TICKET
                , PrintManageEnum.TicketCategoryEnum.AMOUNT_TICKET
                , PrintManageEnum.TicketTypeEnum.CARD_REAPY_BILL);
        print(memberRechargeTicket, memberRecharge, ticketInfo);
    }

    /**
     * 会员付款单
     *
     * @param memberPayment
     * @param memberCardInfo
     */
    @Async
    public void printMemberPaymentTicket(MemberPaymentVO memberPayment, MemberCardInfoVO memberCardInfo) {
        Assert.notNull(memberPayment, "settleInfo is null");
        Assert.notNull(memberCardInfo, "payment is null");
        Assert.notNull(memberPayment.getBusinessID(), "businessID is null");
        Assert.notNull(memberPayment.getArchiveID(), "archiveID is null");

        MemberPaymentTicketVO memberPaymentTicket = new MemberPaymentTicketVO();
        memberPaymentTicket.setMemberPayment(memberPayment);
        memberPaymentTicket.setMemberCardInfo(memberCardInfo);
        memberPayment.setBusinessType(CommonManageEnum.BusinessType.SUBORDER.getValue());
        TicketInfoVO ticketInfo = new TicketInfoVO(PrintManageEnum.TicketCodeEnum.PAYMENT_TICKET
                , PrintManageEnum.TicketCategoryEnum.AMOUNT_TICKET
                , PrintManageEnum.TicketTypeEnum.CARD_SETTLE_BILL);
        print(memberPaymentTicket, memberPayment, ticketInfo);
    }

    /**
     * 交班对账单 / 日结对账单
     *
     * @param amountInfo
     * @param details
     */
    private void printAmountTicket(AmountInfoVO amountInfo, List<TransDetailVO> details, TicketInfoVO ticketInfo) {
        Assert.notNull(amountInfo, "amountInfo is null");
        Assert.notNull(amountInfo.getBusinessID(), "businessID is null");
        Assert.notNull(amountInfo.getArchiveID(), "archiveID is null");
        Assert.notEmpty(details, "details is empty");

        AmountTicketVO amountTicket = new AmountTicketVO();
        amountTicket.setAmountInfo(amountInfo);
        amountTicket.setDetails(details);
        print(amountTicket, amountInfo, ticketInfo);
    }

    /**
     * 交班对账单
     *
     * @param amountInfo
     * @param details
     */
    @Async
    public void printChangeSettleTicket(AmountInfoVO amountInfo, List<TransDetailVO> details) {
        Assert.notNull(amountInfo, "amountInfo is null");
        amountInfo.setBusinessType(CommonManageEnum.BusinessType.CHANGE.getValue());
        TicketInfoVO ticketInfo = new TicketInfoVO(PrintManageEnum.TicketCodeEnum.SHIFT_CHECK_TICKET
                , PrintManageEnum.TicketCategoryEnum.AMOUNT_TICKET
                , PrintManageEnum.TicketTypeEnum.CHANGE_BILL);
        printAmountTicket(amountInfo, details, ticketInfo);
    }

    /**
     * 日结对账单
     *
     * @param amountInfo
     * @param details
     */
    @Async
    public void printDailySettleTicket(AmountInfoVO amountInfo, List<TransDetailVO> details) {
        Assert.notNull(amountInfo, "amountInfo is null");
        amountInfo.setBusinessType(CommonManageEnum.BusinessType.DAILYSETTLE.getValue());
        TicketInfoVO ticketInfo = new TicketInfoVO(PrintManageEnum.TicketCodeEnum.SUN_PAIRED_THE_TICKET
                , PrintManageEnum.TicketCategoryEnum.AMOUNT_TICKET
                , PrintManageEnum.TicketTypeEnum.DAILY_BILL);
        printAmountTicket(amountInfo, details, ticketInfo);
    }

    /**
     * 重打：根据业务ID和业务类型请求重新打印
     */
    @Async
    public void reprintTicket(BusinessVO businessInfo) {
        Assert.notNull(businessInfo, "settleInfo is null");
        Assert.notNull(businessInfo.getBusinessID(), "businessID is null");
        Assert.notNull(businessInfo.getBusinessType(), "businessType is null");
        List<O_TicketPrintInfoEntity> ticketPrintInfos = ticketPrintInfoDao.getTicketPrintInfoByBusinessIDAndType(businessInfo);
        if (CollectionUtils.isNotEmpty(ticketPrintInfos)) {
            for (O_TicketPrintInfoEntity ticketPrintInfo : ticketPrintInfos) {
                ticketPrintInfo.setPrintNumber(NumberUtil.add(ticketPrintInfo.getPrintNumber(), 1));
                ticketPrintInfoDao.update(ticketPrintInfo);
                // 添加重打明细
                O_TicketPrintDealInfoEntity dealInfo = new O_TicketPrintDealInfoEntity();
                try {
                    BeanUtils.copyProperties(dealInfo, ticketPrintInfo);
                    ticketPrintDealInfoDao.save(dealInfo);
                } catch (Exception e) {
                    logger.error(e.getMessage(), e);
                }
                rabbitTemplate.setQueue(PrintConfig.PRINT_DOWN_QUEUE);
                rabbitTemplate.convertAndSend(PrintConfig.PRINT_DOWN_QUEUE, ticketPrintInfo.getLongContent());
            }
        }
    }

    /**
     * 重打：记录ID请求重新打印
     */
    @Async
    public boolean reprintTicket(Long recordID, Long operatorID) {
        O_TicketPrintInfoEntity queryParam = new O_TicketPrintInfoEntity();
        queryParam.setRecordID(recordID);
        O_TicketPrintInfoEntity ticketPrintInfo = ticketPrintInfoDao.get(queryParam);
        if (ticketPrintInfo == null) {
            return false;
        }
        ticketPrintInfo.setPrintNumber(NumberUtil.add(ticketPrintInfo.getPrintNumber(), 1));
        ticketPrintInfo.setCreatorID(operatorID);
        ticketPrintInfo.setCreateTime(LocalDateTime.now());
        ticketPrintInfoDao.update(ticketPrintInfo);
        // 添加重打明细
        O_TicketPrintDealInfoEntity dealInfo = new O_TicketPrintDealInfoEntity();
        try {
            BeanUtils.copyProperties(dealInfo, ticketPrintInfo);
            ticketPrintDealInfoDao.save(dealInfo);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        // send
        rabbitTemplate.setQueue(PrintConfig.PRINT_DOWN_QUEUE);
        rabbitTemplate.convertAndSend(PrintConfig.PRINT_DOWN_QUEUE, ticketPrintInfo.getLongContent());
        return true;
    }
}
