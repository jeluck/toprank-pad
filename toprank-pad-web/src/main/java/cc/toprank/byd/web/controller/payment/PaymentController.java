package cc.toprank.byd.web.controller.payment;

import cc.toprank.byd.base.BaseController;
import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.entity.C_PaymentMethodInfoEntity;
import cc.toprank.byd.entity.MemberCardInfoVO;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.constant.ResultData;
import cc.toprank.byd.web.dto.PayResult;
import cc.toprank.byd.web.dto.PaymentDTO;
import cc.toprank.byd.web.service.payment.*;
import cc.toprank.byd.web.vo.paymentvo.*;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.wordnik.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 结账支付
 * Created by HuangCY on 2017-4-7.
 */
@Controller
@RequestMapping("/reception")
public class PaymentController extends BaseController {

    //支付
    @Autowired
    private PaymentService paymentService;
    //金额情况
    @Autowired
    private AmountSituationService amountSituationService;
    //子订单信息
    @Autowired
    private SubOrderInfoService subOrderInfoService;
    //支付方式
    @Autowired
    private PaymentMethodInfoService paymentMethodInfoService;
    //桌台使用信息
    @Autowired
    private TableUseInfoService tableUseInfoService;
    //发票信息
    @Autowired
    private InvoiceInfoService invoiceInfoService;
    //会员信息
    @Autowired
    private MemberCardInfoService memberCardInfoService;

    //日志打印
    protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 支付
     * @time 2017-4-14 13:38
     */
    @ResponseBody
    @GetMapping("/payment/payment")
    public JSONPObject payment(
            @ApiParam(value = "子订单ID") @RequestParam(value = "subOrderID", required = false) String subOrderID,
            @ApiParam(value = "支付信息集合") @RequestParam(value = "paymentInfoList", required = false) String paymentInfoList,
            @ApiParam(value = "预订ID") @RequestParam(value = "bookingID", required = false) Long bookingID,
            @ApiParam("callback") @RequestParam(value = "callback", defaultValue = "?") String callback) {
        PayResult payResult = new PayResult();

        try {
            if ((null != subOrderID || null != bookingID)) {
                //子订单ID集合
                List<Long> subOrderIDList = null;

                if (null != subOrderID) {
                    //子订单ID集合
                    subOrderIDList = splitSubOrderID(subOrderID);
                }

                List<PaymentInfoVO> list = null;

                if (null != paymentInfoList) {
                    list = JSONObject.parseArray(paymentInfoList, PaymentInfoVO.class);
                }

                PaymentDTO paymentDTO = new PaymentDTO();

                paymentDTO.setArchiveID(getArchiveID());
                paymentDTO.setOperatorID(getLoginID());
                paymentDTO.setOrgID(getOrgID());
//                paymentDTO.setArchiveID(1000034L);
//                paymentDTO.setOperatorID(1000021L);
//                paymentDTO.setOrgID(1000034L);
                paymentDTO.setSubOrderIDList(subOrderIDList);
                paymentDTO.setBookingID(bookingID);

                if (null != bookingID) {
                    paymentService.paymentProcessForBooking(paymentDTO, list);
                } else {
                    paymentService.paymentProcess(paymentDTO, list);
                }

                payResult.setCode(CodeMsgConstants.PAYMENT_SUCCESS);
                payResult.setMessage(CodeMsgConstants.PAYMENT_SUCCESS_MSG);
            } else {
                payResult.setCode(CodeMsgConstants.PARAM_ERROR);
                payResult.setMessage(CodeMsgConstants.PARAM_ERROR_MSG);
            }
        }catch (BizException biz){
            logger.error(biz.getMessage(), biz);
            payResult.setCode(biz.getCode());
            payResult.setMessage(biz.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            payResult.setCode(CodeMsgConstants.ERROR);
            payResult.setMessage(CodeMsgConstants.ERROR_MSG);
        }

        return new JSONPObject(callback, payResult);
    }

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 金额情况（订单金额、收款情况）
     * @time 2017-4-27 11:06
     */
    @ResponseBody
    @GetMapping("/payment/amountSituation")
    public JSONPObject amountSituation(
            @ApiParam(value = "子订单ID", required = true) @RequestParam("subOrderID") String subOrderID,
            @ApiParam("callback") @RequestParam(value = "callback", defaultValue = "?") String callback) {
        AmountSituationVO result = new AmountSituationVO();

        try {
            if (null != subOrderID) {
                //子订单ID集合
                List<Long> subOrderIDList = splitSubOrderID(subOrderID);

                result = amountSituationService.amountSituation(subOrderIDList, getArchiveID()/*1000034L*/, /*1000021L*/getLoginID());

                result.setCode(CodeMsgConstants.SUCCESS);
                result.setMsg(CodeMsgConstants.SUCCESS_MSG);
            } else {
                result.setCode(CodeMsgConstants.PARAM_ERROR);
                result.setMsg(CodeMsgConstants.PARAM_ERROR_MSG);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setCode(CodeMsgConstants.ERROR);
            result.setMsg(CodeMsgConstants.ERROR_MSG);
        }

        return new JSONPObject(callback, result);
    }

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 暂结/取消暂结
     * @time 2017-5-2 11:09
     */
    @ResponseBody
    @GetMapping("/payment/temporarily")
    public JSONPObject temporarily(
            @ApiParam(value = "子订单ID", required = true) @RequestParam("subOrderID") String subOrderID,
            @ApiParam("callback") @RequestParam(value = "callback", defaultValue = "?") String callback) {
        PayResult result = new PayResult();

        try {
            if (null != subOrderID) {
                //子订单ID集合
                List<Long> subOrderIDList = splitSubOrderID(subOrderID);

                subOrderInfoService.temporarily(subOrderIDList);

                result.setCode(CodeMsgConstants.SUCCESS);
                result.setMessage(CodeMsgConstants.SUCCESS_MSG);
            } else {
                result.setCode(CodeMsgConstants.PARAM_ERROR);
                result.setMessage(CodeMsgConstants.PARAM_ERROR_MSG);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setCode(CodeMsgConstants.ERROR);
            result.setMessage(CodeMsgConstants.ERROR_MSG);
        }

        return new JSONPObject(callback, result);
    }

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 结账前验证 是否存在等叫商品和未称重商品
     * @time 2017-5-2 14:22
     */
    @ResponseBody
    @GetMapping("/payment/validateProduct")
    public JSONPObject validateProduct(
            @ApiParam(value = "子订单ID", required = true) @RequestParam("subOrderID") String subOrderID,
            @ApiParam("callback") @RequestParam(value = "callback", defaultValue = "?") String callback) {
        ValidateProductVO result = new ValidateProductVO();

        try {
            if (null != subOrderID) {
                //子订单ID集合
                List<Long> subOrderIDList = splitSubOrderID(subOrderID);

                result = subOrderInfoService.validateProduct(subOrderIDList);
            } else {
                result.setCode(CodeMsgConstants.PARAM_ERROR);
                result.setMessage(CodeMsgConstants.PARAM_ERROR_MSG);
            }
        }catch (BizException biz){
            logger.error(biz.getMessage(), biz);
            result.setCode(biz.getCode());
            result.setMessage(biz.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setCode(CodeMsgConstants.ERROR);
            result.setMessage(CodeMsgConstants.ERROR_MSG);
        }

        return new JSONPObject(callback, result);
    }

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 获取支付方式
     * @time 2017-5-3 14:09
     */
    @ResponseBody
    @GetMapping("/payment/getPaymentMethod")
    public JSONPObject getPaymentMethod(
            @ApiParam("callback") @RequestParam(value = "callback", defaultValue = "?") String callback) {
        PaymentMethodVO result = new PaymentMethodVO();

        List<C_PaymentMethodInfoEntity> resultList;

        try {
            resultList = paymentMethodInfoService.getPaymentMethod();

            if (!resultList.isEmpty() && resultList.size() > 0) {
                result.setResultList(resultList);
                result.setCode(CodeMsgConstants.SUCCESS);
                result.setMessage(CodeMsgConstants.SUCCESS_MSG);
            } else {
                result.setCode(CodeMsgConstants.PAYMENT_METHOD_NOT_EXIST);
                result.setMessage(CodeMsgConstants.PAYMENT_METHOD_NOT_EXIST_MSG);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setCode(CodeMsgConstants.ERROR);
            result.setMessage(CodeMsgConstants.ERROR_MSG);
        }

        return new JSONPObject(callback, result);
    }

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 桌台信息
     * @time 2017-5-10 10:20
     */
    @ResponseBody
    @GetMapping("/payment/tableUseInfo")
    public JSONPObject tableUseInfo(
            @ApiParam(value = "子订单ID", required = true) @RequestParam("subOrderID") String subOrderID,
            @ApiParam("callback") @RequestParam(value = "callback", defaultValue = "?") String callback) {
        TableUseInfoVO result = new TableUseInfoVO();
        PaymentDTO paymentDTO = new PaymentDTO();

        try {

            if (null != subOrderID) {
                //子订单ID集合
                List<Long> subOrderIDList = splitSubOrderID(subOrderID);

                paymentDTO.setArchiveID(getArchiveID()/*138L*/);
                paymentDTO.setSubOrderIDList(subOrderIDList);

                result = tableUseInfoService.queryTableUseInfo(paymentDTO);

                if(result.getCode() == 0){
                    result.setCode(CodeMsgConstants.SUCCESS);
                    result.setMessage(CodeMsgConstants.SUCCESS_MSG);
                }
            } else {
                result.setCode(CodeMsgConstants.PARAM_ERROR);
                result.setMessage(CodeMsgConstants.PARAM_ERROR_MSG);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setCode(CodeMsgConstants.ERROR);
            result.setMessage(CodeMsgConstants.ERROR_MSG);
        }

        return new JSONPObject(callback, result);
    }


    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 查询会员卡信息
     * @time 2017-6-8 18:16
     */
    @ResponseBody
    @GetMapping("/payment/queryMemberCard")
    public JSONPObject queryMemberCard(
            @ApiParam(value = "会员卡号") @RequestParam(value = "cardID", required = false) Long cardID,
            @ApiParam(value = "手机号") @RequestParam(value = "phoneNumber", required = false) String phoneNumber,
            @ApiParam("callback") @RequestParam(value = "callback", defaultValue = "?") String callback) {
        MemberCardInfoVO memberCardInfoVO = new MemberCardInfoVO();

        try {
            if (null != cardID || null != phoneNumber) {
                memberCardInfoService.queryMemberCardByCondition(cardID, phoneNumber, getArchiveID()/*1000034L*/);
            } else {
                memberCardInfoVO.setCode(CodeMsgConstants.PARAM_ERROR);
                memberCardInfoVO.setMessage(CodeMsgConstants.PARAM_ERROR_MSG);
            }
        }catch (BizException biz){
            logger.error(biz.getMessage(), biz);
            memberCardInfoVO.setCode(biz.getCode());
            memberCardInfoVO.setMessage(biz.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            memberCardInfoVO.setCode(CodeMsgConstants.ERROR);
            memberCardInfoVO.setMessage(CodeMsgConstants.ERROR_MSG);
        }

        return new JSONPObject(callback, memberCardInfoVO);
    }

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 线上支付
     * @time 2017-6-15 17:19
     */
    @ResponseBody
    @GetMapping("/payment/onlinePayment")
    public JSONPObject onlinePayment(
            @ApiParam(value = "会员卡号") @RequestParam(value = "cardID", required = false) Long cardID,
            @ApiParam(value = "客户编号") @RequestParam(value = "customerID", required = false) Long customerID,
            @ApiParam(value = "付款码") @RequestParam(value = "authCode", required = false) String authCode,
            @ApiParam(value = "付款码") @RequestParam(value = "bookingID", required = false) Long bookingID,
            @ApiParam(value = "支付金额") @RequestParam("paymentAmount") BigDecimal paymentAmount,
            @ApiParam(value = "支付方式") @RequestParam("paymentMethodID") Long paymentMethodID,
            @ApiParam(value = "子订单ID") @RequestParam(value = "subOrderID", required = false) String subOrderID,
            @ApiParam("callback") @RequestParam(value = "callback", defaultValue = "?") String callback) {
        PayResult resultData = new PayResult();

        try {
            if (null != subOrderID || null != bookingID) {
                //子订单ID集合
                List<Long> subOrderIDList = splitSubOrderID(subOrderID);

                ThirdPartyPayParamVO thirdPartyPayParamVO = new ThirdPartyPayParamVO();

                thirdPartyPayParamVO.setPaymentMethodID(paymentMethodID);
                thirdPartyPayParamVO.setSubOrderIDList(subOrderIDList);
                thirdPartyPayParamVO.setArchiveID(getArchiveID()/*1000034L*/);
                thirdPartyPayParamVO.setCardID(cardID);
                thirdPartyPayParamVO.setPaymentAmount(paymentAmount);
                thirdPartyPayParamVO.setAuthCode(authCode);
                thirdPartyPayParamVO.setLoginID(getLoginID()/*1000021L*/);
                thirdPartyPayParamVO.setCustomerID(customerID);
                thirdPartyPayParamVO.setBookingID(bookingID);

                List<PaymentVos> paymentVosList = new ArrayList<>();

                PaymentVos paymentVos = new PaymentVos();

                //会员卡支付才需要cardID
                if(null != thirdPartyPayParamVO.getCardID()){
                    paymentVos.setCardID(thirdPartyPayParamVO.getCardID());
                }
                //微信、支付宝扫码才需要authCode
                if(null != thirdPartyPayParamVO.getAuthCode()){
                    paymentVos.setAuthCode(thirdPartyPayParamVO.getAuthCode());
                }

                //处理支付金额(把元转成分)
                BigDecimal paymentAmount2 = paymentAmount.multiply(BigDecimal.valueOf(100));
                //去掉小数位
                Integer castPaymentAmount = paymentAmount2.intValue();

                paymentVos.setPaymentMethodID(thirdPartyPayParamVO.getPaymentMethodID());
                paymentVos.setPaymentMoney(castPaymentAmount);

                paymentVosList.add(paymentVos);

                paymentService.paymentProcessForOnline(thirdPartyPayParamVO , paymentVosList);
            } else {
                resultData.setCode(CodeMsgConstants.PARAM_ERROR);
                resultData.setMessage(CodeMsgConstants.PARAM_ERROR_MSG);
            }
        } catch (BizException biz){
            logger.error(biz.getMessage(), biz);
            resultData.setCode(biz.getCode());
            resultData.setMessage(biz.getMessage());
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }

        return new JSONPObject(callback, resultData);
    }

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 开发票
     * @time 2017-5-26 16:25
     */
    @ResponseBody
    @GetMapping("/payment/invoice")
    public JSONPObject invoice(
            @ApiParam(value = "子订单ID", required = true) @RequestParam("subOrderID") String subOrderID,
            @ApiParam(value = "发票信息", required = true) @RequestParam("invoiceInfo") String invoiceInfo,
            @ApiParam("callback") @RequestParam(value = "callback", defaultValue = "?") String callback) {
        ResultData resultData = new ResultData();

        try {
            if (null != subOrderID && null != invoiceInfo) {
                //子订单ID集合
                List<Long> subOrderIDList = splitSubOrderID(subOrderID);

                InvoiceInfoVO invoiceInfoVO = JSONObject.parseObject(invoiceInfo, InvoiceInfoVO.class);

                //开发票
                invoiceInfoService.openInvoice(invoiceInfoVO, subOrderIDList, getLoginID());

                resultData.setCode(CodeMsgConstants.SUCCESS);
                resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
            } else {
                resultData.setCode(CodeMsgConstants.PARAM_ERROR);
                resultData.setMessage(CodeMsgConstants.PARAM_ERROR_MSG);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }

        return new JSONPObject(callback, resultData);
    }

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 分割子订单字符串
     * @time 2017-5-2 14:30
     */
    private List<Long> splitSubOrderID(String subOrderID) {
        //分割子订单ID字符串
        String[] subOrderIDs = subOrderID.split(",");

        //子订单ID集合
        List<Long> subOrderIDList = new ArrayList<>();

        for (int i = 0; i < subOrderIDs.length; i++) {
            subOrderIDList.add(Long.valueOf(subOrderIDs[i]));
        }

        return subOrderIDList;
    }
}
