package cc.toprank.byd.web.controller.menu;

import cc.toprank.byd.base.BaseController;
import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.common.utils.DateUtils;
import cc.toprank.byd.entity.O_ComboDetailInfoEntity;
import cc.toprank.byd.entity.O_OrderDetailInfoEntity;
import cc.toprank.byd.entity.P_ProductVariantInfoEntity;
import cc.toprank.byd.enums.OrderManagerEnum;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.constant.ResultData;
import cc.toprank.byd.web.service.menu.O_ComboDetailInfoService;
import cc.toprank.byd.web.service.menu.O_OrderDetailInfoService;
import cc.toprank.byd.web.service.menu.P_ProductVariantInfoService;
import cc.toprank.byd.web.vo.menu.OrderDetailOperationVO;
import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 已下单操作
 * Created by HuangCY on 2017-4-19.
 */
@Controller
@RequestMapping(value = "/reception/product")
public class OrderedOperationController extends BaseController {

    //订单明细
    @Autowired
    private O_OrderDetailInfoService o_OrderDetailInfoService;
    //商品变体
    @Autowired
    private P_ProductVariantInfoService p_ProductVariantInfoService;
    //套餐明细
    @Autowired
    private O_ComboDetailInfoService o_ComboDetailInfoService;

    //日志打印
    protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 叫起
     * @time 2017-5-24 13:54
     */
    @ApiOperation(value = "叫起", httpMethod = "GET", response = JSONPObject.class)
    @RequestMapping(value = "/wakeUp", method = RequestMethod.GET)
    @ResponseBody
    public JSONPObject wakeUp(
            @ApiParam("订单明细信息") @RequestParam(value = "detailInfoList") String detailInfoList,
            @ApiParam("callback") @RequestParam(value = "callback", defaultValue = "?") String callback) {
        ResultData resultData = new ResultData();

        try {
            List<OrderDetailOperationVO> detailList = JSONArray.parseArray(detailInfoList, OrderDetailOperationVO.class);

            //制作状态
            Long produceStatus = OrderManagerEnum.ProductionStatus.SOCALLED.getValue();

            for (OrderDetailOperationVO detail : detailList) {
                //变体ID
                Long variantID = null;
                //记录ID集合
                List<Long> recordIDList = new ArrayList<>();
                //是否可以叫起
                boolean canWakeUp = true;

                Map<String, Object> map = new HashMap<>();

                //普通菜品或套餐的叫起
                if (null != detail.getDetailID()) {
                    //根据订单明细ID查询订单明细
                    O_OrderDetailInfoEntity orderDetailInfoEntity = o_OrderDetailInfoService.getOrderDetailInfoById(detail.getDetailID());

                    //只有制作状态为等叫的才能被叫起
                    if (orderDetailInfoEntity.getProduceStatus().equals(produceStatus)) {
                        //套餐
                        if (null == orderDetailInfoEntity.getVariantID()) {
                            O_ComboDetailInfoEntity comboSetParamsEntity = new O_ComboDetailInfoEntity();

                            comboSetParamsEntity.setRecordID(detail.getRecordID());

                            //根据明细编号查询套餐信息
                            List<O_ComboDetailInfoEntity> comboDetailList = o_ComboDetailInfoService.getComboDetailByDetailID(detail.getDetailID());

                            for (O_ComboDetailInfoEntity combo : comboDetailList) {
                                recordIDList.add(combo.getRecordID());
                            }

                            //因为套餐明细下的明细ID全部是一样的，所以只取一个就可以了
                            variantID = comboDetailList.get(0).getVariantID();

                            map.put("recordIDList", recordIDList);
                        } else {
                            variantID = orderDetailInfoEntity.getVariantID();

                            map.put("detailID", Long.valueOf(detail.getDetailID()));
                        }
                    } else {
                        canWakeUp = false;
                    }
                }
                //套餐明细的叫起
                if (null != detail.getRecordID()) {
                    O_ComboDetailInfoEntity comboSetParamsEntity = new O_ComboDetailInfoEntity();

                    comboSetParamsEntity.setRecordID(detail.getRecordID());

                    //根据套餐明细ID查询套餐明细
                    O_ComboDetailInfoEntity comboDetail = o_ComboDetailInfoService.get(comboSetParamsEntity);

                    //只有制作状态为等叫的才能被叫起
                    if (comboDetail.getProduceStatus().equals(produceStatus)) {
                        variantID = comboDetail.getVariantID();

                        recordIDList.add(detail.getRecordID());

                        map.put("recordIDList", recordIDList);
                    } else {
                        canWakeUp = false;
                    }
                }

                if (canWakeUp) {
                    //制作状态为制作中
                    map.put("produceStatus", OrderManagerEnum.ProductionStatus.INPRODUCTION.getValue());

                    //根据变体ID查询商品变体信息
                    P_ProductVariantInfoEntity productVariantInfo = p_ProductVariantInfoService.getProductVariantInfoByID(variantID);

                    //获取制作时间
                    int produceMinute = productVariantInfo.getProduceMinute();
                    //计算出品时间
                    LocalDateTime produceTime = DateUtils.addMinute(LocalDateTime.now(), produceMinute);

                    map.put("produceTime", produceTime);

                    //根据订单明细ID或套餐明细ID更新制作状态
                    o_OrderDetailInfoService.updateProduceStatusByDetailID(map);

                    resultData.setCode(CodeMsgConstants.SUCCESS);
                    resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
                } else {
                    throw new BizException(CodeMsgConstants.WAKEUP_ERROR , CodeMsgConstants.WAKEUP_ERROR_MSG);
                }
            }
        } catch (BizException e){
            logger.error(e.getMessage(), e);
            resultData.setCode(e.getCode());
            resultData.setMessage(e.getMessage());
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
     * @description 等叫
     * @time 2017-5-24 11:22
     */
    @ApiOperation(value = "等叫", httpMethod = "GET", response = JSONPObject.class)
    @RequestMapping(value = "/socalled", method = RequestMethod.GET)
    @ResponseBody
    public JSONPObject socalled(
            @ApiParam("订单明细信息") @RequestParam(value = "detailInfoList") String detailInfoList,
            @ApiParam("callback") @RequestParam(value = "callback", defaultValue = "?") String callback) {
        ResultData resultData = new ResultData();

        try {
            List<OrderDetailOperationVO> detailList = JSONArray.parseArray(detailInfoList, OrderDetailOperationVO.class);

            //制作状态
            Long produceStatus = OrderManagerEnum.ProductionStatus.SERVINGALREADY.getValue();

            for (OrderDetailOperationVO detail : detailList) {
                List<Long> recordIDList = new ArrayList<>();

                Map<String, Object> map = new HashMap<>();

                map.put("produceStatus", OrderManagerEnum.ProductionStatus.SOCALLED.getValue());

                //是否可以等叫
                boolean canSocalled = true;

                //普通菜品或套餐的等起
                if (null != detail.getDetailID()) {
                    //根据订单明细ID查询订单明细
                    O_OrderDetailInfoEntity orderDetailInfoEntity = o_OrderDetailInfoService.getOrderDetailInfoById(detail.getDetailID());

                    //制作状态不为已上菜才可以等叫
                    if (!orderDetailInfoEntity.getProduceStatus().equals(produceStatus)) {
                        //套餐
                        if (null == orderDetailInfoEntity.getVariantID()) {
                            //根据明细编号查询套餐信息
                            List<O_ComboDetailInfoEntity> comboDetailList = o_ComboDetailInfoService.getComboDetailByDetailID(detail.getDetailID());

                            for (O_ComboDetailInfoEntity combo : comboDetailList) {
                                recordIDList.add(combo.getRecordID());
                            }
                            map.put("recordIDList", recordIDList);
                        } else {
                            map.put("detailID", Long.valueOf(detail.getDetailID()));
                        }
                    } else {
                        canSocalled = false;
                    }
                }
                //套餐明细的等起
                if (null != detail.getRecordID()) {
                    O_ComboDetailInfoEntity comboSetParamsEntity = new O_ComboDetailInfoEntity();

                    comboSetParamsEntity.setRecordID(detail.getRecordID());

                    //根据套餐明细ID查询套餐明细
                    O_ComboDetailInfoEntity comboDetail = o_ComboDetailInfoService.get(comboSetParamsEntity);

                    //制作状态不为已上菜才可以等叫
                    if (!comboDetail.getProduceStatus().equals(produceStatus)) {
                        recordIDList.add(detail.getRecordID());
                        map.put("recordIDList", recordIDList);
                    } else {
                        canSocalled = false;
                    }
                }

                if (canSocalled) {
                    map.put("produceTime", null);

                    //根据订单明细ID或套餐明细ID更新制作状态
                    o_OrderDetailInfoService.updateProduceStatusByDetailID(map);

                    resultData.setCode(CodeMsgConstants.SUCCESS);
                    resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
                } else {
                    throw new BizException(CodeMsgConstants.SOCALLED_ERROR , CodeMsgConstants.SOCALLED_ERROR_MSG);
                }
            }
        } catch (BizException e){
            logger.error(e.getMessage(), e);
            resultData.setCode(e.getCode());
            resultData.setMessage(e.getMessage());
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }
        return new JSONPObject(callback, resultData);
    }
}
