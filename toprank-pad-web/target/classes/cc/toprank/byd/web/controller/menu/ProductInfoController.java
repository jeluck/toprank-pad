package cc.toprank.byd.web.controller.menu;

import cc.toprank.byd.base.BaseController;
import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.constant.MerchantTagCodeConstants;
import cc.toprank.byd.enums.CommonManageEnum;
import cc.toprank.byd.vo.ProductInfoVO;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.constant.ResultData;
import cc.toprank.byd.web.service.menu.O_OrderDetailInfoService;
import cc.toprank.byd.web.service.menu.OrderInfoService;
import cc.toprank.byd.web.service.menu.P_ProductCategoryInfoService;
import cc.toprank.byd.web.service.menu.ProductInfoService;
import cc.toprank.byd.web.vo.menu.OrderDetailOperationVO;
import cc.toprank.byd.web.vo.reserve.ReserveVo;
import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mangofactory.swagger.annotations.ApiIgnore;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiImplicitParams;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @Description： 点菜页面controller
 * @Author：LanZY
 * @Time: 2017-3-6 16:48
 * @Version 2.0.0
 */
@Controller
@RequestMapping(value = "/reception/product")
public class ProductInfoController extends BaseController {

    @Autowired
    ProductInfoService productInfoService;
    @Autowired
    P_ProductCategoryInfoService productCategoryInfoService;
    @Autowired
    OrderInfoService orderInfoService;
    @Autowired
    O_OrderDetailInfoService orderDetailInfoService;

    //日志打印
    protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    /**
     * @param tableID    桌台ID
     * @param categoryID 分类ID
     * @param searchCode 菜品名称或首字母或编码
     * @param callback   callback
     * @return
     * @Description： 获取菜品列表
     * @Author：LanZY
     * @Time: 2017-4-10 10:44
     * @Version 2.0.0
     */
    @ApiOperation(value = "菜品列表", httpMethod = "GET", response = JSONPObject.class)
    @RequestMapping(value = "/getProductList", method = RequestMethod.GET)
    @ResponseBody
    public JSONPObject getProductList(
            @ApiParam("桌台ID") @RequestParam(value = "tableID") Long tableID,
            @ApiParam("分类ID") @RequestParam(required = false, value = "categoryID", defaultValue = "0") Long categoryID,
            @ApiParam("菜品名称或首字母或编码") @RequestParam(required = false, value = "searchCode", defaultValue = "") String searchCode,
            @ApiParam("是否预定") @RequestParam(required = false, value = "booking", defaultValue = "0") Long booking,
            @ApiParam("预定时间") @RequestParam(required = false, value = "bookingTime") String bookingTime,
            @ApiParam("callback") @RequestParam(value = "callback", defaultValue = "?") String callback) {
        ResultData resultData = new ResultData();
        try {
            List<ProductInfoVO> productInfoList = productInfoService.getProductListByCondition(categoryID,searchCode,tableID,booking,bookingTime);
            resultData = resultData.makeResult(productInfoList);
        } catch (BizException be) {
            logger.error(be.getMessage(), be);
            resultData.setCode(be.getCode());
            resultData.setMessage(be.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }
        return new JSONPObject(callback, resultData);
    }

    /**
     * @param callback
     * @return
     * @Description： 获取分类列表
     * @Author：LanZY
     * @Time: 2017-4-10 15:28
     * @Version 2.0.0
     */
    @ApiOperation(value = "菜品分类列表", httpMethod = "GET", response = JSONPObject.class, notes = "菜品分类列表")
    @RequestMapping(value = "/getCategoryInfoList", method = RequestMethod.GET)
    @ResponseBody
    public JSONPObject getCategoryInfoList(@ApiParam("档案ID") @RequestParam(required = false, value = "archiveID", defaultValue = "0") Long archiveID,
                                           @ApiParam("桌台ID") @RequestParam(value = "tableID") Long tableID,
                                           @ApiParam("餐次ID") @RequestParam(required = false,value = "mealsID", defaultValue = "0") Long mealsID,
                                           @ApiParam("是否预定") @RequestParam(required = false, value = "booking", defaultValue = "0") Long booking,
                                           @ApiParam("预定时间") @RequestParam(required = false, value = "bookingTime") String bookingTime,
                                           @ApiParam("callback") @RequestParam(value = "callback", defaultValue = "?") String callback) {
        ResultData resultData = new ResultData();
        try {
            List<Map<String, Object>> categoryList = productInfoService.getCategoryList(archiveID == 0 ? getArchiveID() : archiveID, tableID, mealsID, booking, bookingTime);
            resultData = resultData.makeResult(categoryList);
        } catch (BizException be) {
            logger.error(be.getMessage(), be);
            resultData.setCode(be.getCode());
            resultData.setMessage(be.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }
        return new JSONPObject(callback, resultData);
    }

    /**
     * @return
     * @Description： 下单
     * @Author：LanZY
     * @Time: 2017-4-7 9:52
     * @Version 2.0.0
     */
    @ApiOperation(value = "下单", httpMethod = "GET", response = JSONPObject.class, notes = "输入桌台ID,和购物车JSON数据")
    @RequestMapping(value = "/addOrder", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public JSONPObject addOrder(@ApiParam("子订单ID") @RequestParam(value = "subOrderID") Long subOrderID,
                                @ApiParam("购物车") @RequestParam(value = "shoppingCart") String shoppingCart,
                                @ApiParam("callback") @RequestParam(value = "callback", defaultValue = "?") String callback) {
        ResultData resultData = new ResultData();
        try {
            orderInfoService.addOrder(subOrderID, shoppingCart);
            resultData.setCode(CodeMsgConstants.SUCCESS);
            resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
        } catch (BizException be) {
            logger.error(be.getMessage(), be);
            resultData.setCode(be.getCode());
            resultData.setMessage(be.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }
        return new JSONPObject(callback, resultData);
    }

    /**
     * @return
     * @Description： 预定下单
     * @Author：LanZY
     * @Time: 2017-4-7 9:52
     * @Version 2.0.0
     */
    @ApiOperation(value = "预定下单", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "areaID", value = "区域ID", dataType = "Long", required = true),
            @ApiImplicitParam(paramType = "query", name = "peopleNum", value = "人数", dataType = "Integer", required = true),
            @ApiImplicitParam(paramType = "query", name = "bookingTime", value = "预订时间", dataType = "String", required = true),
            @ApiImplicitParam(paramType = "query", name = "bookingType", value = "预订方式", dataType = "Long", required = true),
            @ApiImplicitParam(paramType = "query", name = "duration", value = "就餐时长", dataType = "Long", required = true),
            @ApiImplicitParam(paramType = "query", name = "phone", value = "电话号码", dataType = "String", required = true),
            @ApiImplicitParam(paramType = "query", name = "contact", value = "姓名", dataType = "String", required = true),
            @ApiImplicitParam(paramType = "query", name = "gender", value = "性别", dataType = "Integer", required = true),
            @ApiImplicitParam(paramType = "query", name = "tableIDs", value = "预订桌台ID(以逗号隔开)", dataType = "String", required = true),
            @ApiImplicitParam(paramType = "query", name = "shoppingCarts", value = "购物车JSON(以逗号隔开)", dataType = "String", required = true),
            @ApiImplicitParam(paramType = "query", name = "memo", value = "备注", dataType = "String", required = false)
    })
    @RequestMapping("/addBookingOrder")
    @ResponseBody
    public JSONPObject addBookingOrder(@ApiIgnore ReserveVo reserveVo,
                                @ApiParam("callback") @RequestParam(value = "callback", defaultValue = "?") String callback) {
        ResultData resultData = new ResultData();
        try {
            reserveVo.setLoginID(getLoginID());
            Long bookingID = orderInfoService.addBookingOrder(reserveVo);
            resultData.setData(bookingID);
            resultData.setCode(CodeMsgConstants.SUCCESS);
            resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
        } catch (BizException be) {
            logger.error(be.getMessage(), be);
            resultData.setCode(be.getCode());
            resultData.setMessage(be.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }
        return new JSONPObject(callback, resultData);
    }


    /**
     * @param subOrderID 子订单ID
     * @param callback
     * @return
     * @Description： 获取已下单的订单明细
     * @Author：LanZY
     * @Time: 2017-4-11 14:12
     * @Version 2.0.0
     */
    @ApiOperation(value = "获取已下单的订单明细", httpMethod = "GET", response = JSONPObject.class, notes = "订单明细")
    @RequestMapping(value = "/getUnderOrdersList", method = RequestMethod.GET)
    @ResponseBody
    public JSONPObject getUnderOrders(
            @ApiParam("子订单ID") @RequestParam(value = "subOrderID") Long subOrderID,
            @ApiParam("callback") @RequestParam(value = "callback", defaultValue = "?") String callback) {

        return new JSONPObject(callback, ResultData.makeResult(orderDetailInfoService.getUnderOrderList(subOrderID)));
    }

    /**
     * @param productID
     * @param callback
     * @return
     * @Description： 根据商品ID查询套餐分组信息
     * @Author：LanZY
     * @Time: 2017-4-26 11:52
     * @Version 2.0.0
     */
    @ApiOperation(value = "根据商品ID查询套餐分组信息", httpMethod = "GET", response = JSONPObject.class)
    @RequestMapping(value = "/getComboGroupInfo", method = RequestMethod.GET)
    @ResponseBody
    public JSONPObject getComboGroupInfo(
            @ApiParam("商品ID") @RequestParam(value = "productID") Long productID,
            @ApiParam("callback") @RequestParam(value = "callback", defaultValue = "?") String callback) {
        return new JSONPObject(callback, ResultData.makeResult(productInfoService.getComboGroupInfoByProductID(productID)));
    }


    /**
     * @param markOrderDetail
     * @param callback
     * @return
     * @Description： 划单
     * @Author：LanZY
     * @Time: 2017-4-26 11:52
     * @Version 2.0.0
     */
    @ApiOperation(value = "划单", httpMethod = "GET", response = JSONPObject.class, notes = "划单JSON数据")
    @RequestMapping(value = "/markOrderDetail", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public JSONPObject markOrderDetail(
            @ApiParam("划单明细JSON") @RequestParam(value = "markOrderDetail") String markOrderDetail,
            @ApiParam("callback") @RequestParam(value = "callback", defaultValue = "?") String callback) {
        ResultData resultData = new ResultData();
        try {
            orderInfoService.markOrderDetail(markOrderDetail);
            resultData.setCode(CodeMsgConstants.SUCCESS);
            resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
        } catch (BizException be) {
            logger.error(be.getMessage(), be);
            resultData.setCode(be.getCode());
            resultData.setMessage(be.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }
        return new JSONPObject(callback, resultData);
    }


    /**
     * @param cancelMarkOrderDetail
     * @param callback
     * @return
     * @Description： 取消划单
     * @Author：LanZY
     * @Time: 2017-4-26 11:52
     * @Version 2.0.0
     */
    @ApiOperation(value = "取消划单", httpMethod = "GET", response = JSONPObject.class, notes = "取消划单JSON数据")
    @RequestMapping(value = "/cancelMarkOrderDetail", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public JSONPObject cancelMarkOrderDetail(
            @ApiParam("划单明细JSON") @RequestParam(value = "cancelMarkOrderDetail") String cancelMarkOrderDetail,
            @ApiParam("callback") @RequestParam(value = "callback", defaultValue = "?") String callback) {
        ResultData resultData = new ResultData();
        try {
            List<OrderDetailOperationVO> cancelMarkOrderDetailList = JSONArray.parseArray(cancelMarkOrderDetail, OrderDetailOperationVO.class);
            if(CollectionUtils.isEmpty(cancelMarkOrderDetailList)){
                throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
            }
            orderInfoService.cancelMarkOrderDetail(cancelMarkOrderDetailList);
            resultData.setCode(CodeMsgConstants.SUCCESS);
            resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
        } catch (BizException be) {
            logger.error(be.getMessage(), be);
            resultData.setCode(be.getCode());
            resultData.setMessage(be.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }
        return new JSONPObject(callback, resultData);
    }


    /**
     * @param merchantTagMappings
     * @param callback
     * @return
     * @Description： 免做, 先做, 打包, 催菜
     * @Author：LanZY
     * @Time: 2017-5-20 18:57
     * @Version 2.0.0
     */
    @ApiOperation(value = "免做,先做,打包,催菜", httpMethod = "GET", response = JSONPObject.class)
    @RequestMapping(value = "/merchantProductOperation", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public JSONPObject merchantProductOperation(
            @ApiParam("标签JSON") @RequestParam(value = "merchantTagMappings") String merchantTagMappings,
            @ApiParam("callback") @RequestParam(value = "callback", defaultValue = "?") String callback) {
        ResultData resultData = new ResultData();
        try {
            orderInfoService.addMerchantTagMapping(merchantTagMappings, getCurrentUser());
            resultData.setCode(CodeMsgConstants.SUCCESS);
            resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
        } catch (BizException be) {
            logger.error(be.getMessage(), be);
            resultData.setCode(be.getCode());
            resultData.setMessage(be.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }
        return new JSONPObject(callback, resultData);
}

    @ApiOperation(value = "依据催菜等标签获取菜品", httpMethod = "GET", response = JSONPObject.class, notes = "菜品JSON数据")
    @RequestMapping(value = "/getProductPushBySubOrder", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public JSONPObject getProductPushBySubOrder(@ApiParam(required = true, name = "subOrderID") Long subOrderID) {
        ResultData resultData = new ResultData();
        if(subOrderID == null) {
            resultData.setCode(CodeMsgConstants.PARAM_ERROR);
        } else {
            List<Map<String, Object>> dataList = orderDetailInfoService.getProductBySubOrderAndTag(CommonManageEnum.GoalsType.ORDER_DETAILS, MerchantTagCodeConstants.PUSH_FOOD, subOrderID);
            if(dataList == null || dataList.isEmpty()) {
                resultData.setCode(CodeMsgConstants.NODATA);
            }else {
                resultData.setCode(CodeMsgConstants.SUCCESS);
                resultData.setData(dataList);
            }
        }

        return getResultJSONPObject(resultData);
    }

    @ApiOperation(value = "依据菜品制作状态获取菜品", httpMethod = "GET", response = JSONPObject.class, notes = "菜品JSON数据，制作状态：692-未制作，693-制作中" +
            "694-等叫，698-超时，830-未称重，981-已出品，982-已上菜")
    @RequestMapping(value = "/getProductBySubOrderAndProStatus", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public JSONPObject getProductBySubOrderAndProStatus(@ApiParam(required = true, name = "subOrderID") Long subOrderID,
                                                        @ApiParam(required = true, name="productStatus") Long productStatus) {
        ResultData resultData = new ResultData();
        if(subOrderID == null || productStatus == null) {
            resultData.setCode(CodeMsgConstants.PARAM_ERROR);
        } else {
            List<Map<String, Object>> dataList = orderDetailInfoService.getProductBySubOrderAndProStatus(productStatus, subOrderID);
            if(dataList == null || dataList.isEmpty()) {
                resultData.setCode(CodeMsgConstants.NODATA);
            }else {
                resultData.setCode(CodeMsgConstants.SUCCESS);
                resultData.setData(dataList);
            }
        }
        return getResultJSONPObject(resultData);
    }

    @ApiOperation(value = "可以退菜菜单", notes = "没出品，没上菜的可以退菜" , httpMethod = "GET", response = JSONPObject.class )
    @RequestMapping(value = "/getBackProduct", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public JSONPObject getBackProduct(@ApiParam(required = true, name = "subOrderID") Long subOrderID) {
        ResultData resultData = new ResultData();
        if(subOrderID == null) {
            resultData.setCode(CodeMsgConstants.PARAM_ERROR);
        } else {
            resultData.setData(orderDetailInfoService.getProductBack(subOrderID));
        }
        return getResultJSONPObject(resultData);
    }

    @ApiOperation(value = "可以划单菜单", notes = "制作中，已出品的可以划单" , httpMethod = "GET", response = JSONPObject.class )
    @RequestMapping(value = "/getCancelProduct", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public JSONPObject getCancelProduct(@ApiParam(required = true, name = "subOrderID") Long subOrderID) {
        ResultData resultData = new ResultData();
        if(subOrderID == null) {
            resultData.setCode(CodeMsgConstants.PARAM_ERROR);
        } else {
            resultData.setData(orderDetailInfoService.getProductCancel(subOrderID));
        }
        return getResultJSONPObject(resultData);
    }

    @ApiOperation(value = "可以转菜菜单", notes = "没上菜的可以转菜" , httpMethod = "GET", response = JSONPObject.class )
    @RequestMapping(value = "/getTransferProduct", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public JSONPObject getTransferProduct(@ApiParam(required = true, name = "subOrderID", value = "子订单号") Long subOrderID) {
        ResultData resultData = new ResultData();
        if(subOrderID == null) {
            resultData.setCode(CodeMsgConstants.PARAM_ERROR);
        } else {
            resultData.setData(orderDetailInfoService.getProductTransfer(subOrderID));
        }
        return getResultJSONPObject(resultData);
    }

}
