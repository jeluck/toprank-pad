package cc.toprank.byd.web.controller.order;

import cc.toprank.byd.base.BaseController;
import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.entity.B_MerchantMenuInfoEntity;
import cc.toprank.byd.entity.O_OrderDetailInfoEntity;
import cc.toprank.byd.enums.DictionaryCatalogEnum;
import cc.toprank.byd.vo.ReasonVO;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.constant.ResultData;
import cc.toprank.byd.web.service.menu.*;
import cc.toprank.byd.web.vo.product.ProductMessageVo;
import cc.toprank.byd.web.vo.product.ProductSpecificationVo;
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

import java.util.List;


/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 * @author zhouwei
 * @version 2.0.0
 * <p></p>
 *********************************************************************************************/

@Controller
@RequestMapping("/reception/product")
public class FoodOperationController extends BaseController{
    private static final Logger logger = LoggerFactory.getLogger(FoodOperationController.class.getName());
	@Autowired
	private P_ProductVariantInfoService p_productVariantInfoService;
	@Autowired
	private O_OrderDetailInfoService o_orderDetailInfoService;
	@Autowired
	private O_SubOrderInfoService o_subOrderInfoService;
	@Autowired
	private B_MerchantMenuInfoService b_merchantMenuInfoService;
	@Autowired
	private  ProductMessageService productMessageService;

	/**
	 * 获取菜单信息
	 * @param menuID，detailID 菜单编号
	 * @return  ResultData
	 * @author zhouwei
	 * @version 2.0.0
	 */
	@ResponseBody
	@GetMapping("/getOrderDetail")
	public JSONPObject getOrderDetail(@ApiParam(value = "明细编号", required = true) @RequestParam("detailID") Long detailID,
									 @ApiParam(value = "变体编号", required = true) @RequestParam("menuID") Long menuID){
		ResultData resultData = new ResultData();
		try{
			if ( menuID == null || detailID == null){
				resultData.setCode(CodeMsgConstants.PARAM_ERROR);
				resultData.setMessage(CodeMsgConstants.PARAM_ERROR_MSG);
				return getResultJSONPObject(resultData);
			}
			O_OrderDetailInfoEntity orderDetailInfo = new O_OrderDetailInfoEntity();
			orderDetailInfo.setMenuID(menuID);
			orderDetailInfo.setDetailID(detailID);
			O_OrderDetailInfoEntity detailInfo  = o_orderDetailInfoService.get(orderDetailInfo);
			resultData.setCode(CodeMsgConstants.SUCCESS);
			resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
			return getResultJSONPObject(detailInfo);
		}catch (BizException ex) {
			resultData.setCode(ex.getCode());
			resultData.setMessage(ex.getMessage());
			return getResultJSONPObject(resultData);
		}catch (Exception e){
			logger.error(e.getMessage(), e);
			resultData.setCode(CodeMsgConstants.ERROR);
			resultData.setMessage(CodeMsgConstants.ERROR_MSG);
			return getResultJSONPObject(resultData);
		}
	}
    /**
     * 修改退菜信息
     * @param quantity 菜单编号
     * @return  ResultData
     * @author zhouwei
	 * @version 2.0.0
     */
    @ResponseBody
    @GetMapping("/revocationFood")
    public JSONPObject revocationFood(@ApiParam(value = "数量", required = true) @RequestParam("quantity") Integer quantity,
									@ApiParam(value = "订单明细编号", required = true) @RequestParam("detailID") Long detailID,
									@ApiParam(value = "退菜原因", required = true) @RequestParam("memo") String memo,
									@ApiParam(value = "是否报损退菜", required = false) @RequestParam(value = "revocationType",required = false) Long revocationType) {
		ResultData resultData = new ResultData();
		try {
			if (quantity == null || detailID == null) {
				resultData.setCode(CodeMsgConstants.PARAM_ERROR);
				resultData.setMessage(CodeMsgConstants.PARAM_ERROR_MSG);
				return getResultJSONPObject(resultData);
			}
			resultData = o_orderDetailInfoService.revocationFoodAndPrint(quantity,detailID,memo,this.getArchiveID(),revocationType);
			return getResultJSONPObject(resultData);
		}catch (BizException ex) {
			resultData.setCode(ex.getCode());
			resultData.setMessage(ex.getMessage());
			return getResultJSONPObject(resultData);
		}catch (Exception e){
			logger.error(e.getMessage(), e);
			resultData.setCode(CodeMsgConstants.FAIL);
			resultData.setMessage(CodeMsgConstants.FAIL_MSG);
			return getResultJSONPObject(resultData);
		}
	}

	/**
	 * 修改加菜信息
	 * @param detailID 菜单编号
	 * @return  ResultData
	 * @author zhouwei
	 * @version 2.0.0
	 */
	@ResponseBody
	@GetMapping("/addFood")
	public JSONPObject addFood(@ApiParam(value = "订单明细编号", required = true) @RequestParam("detailID") Long detailID,
							   @ApiParam(value = "套餐记录编号", required = false) @RequestParam(value = "recordID",required = false) Long recordID) {
		ResultData resultData = new ResultData();
		try {
			if (detailID == null) {
				resultData.setCode(CodeMsgConstants.PARAM_ERROR);
				resultData.setMessage(CodeMsgConstants.PARAM_ERROR_MSG);
				return getResultJSONPObject(resultData);
			}
			resultData = o_orderDetailInfoService.addFood(detailID,recordID,this.getArchiveID());
			return getResultJSONPObject(resultData);
		}catch (BizException ex) {
			resultData.setCode(ex.getCode());
			resultData.setMessage(ex.getMessage());
			return getResultJSONPObject(resultData);
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			resultData.setCode(CodeMsgConstants.ADDFOOD_ERROR);
			resultData.setMessage(CodeMsgConstants.ADDFOOD_MSG);
			return getResultJSONPObject(resultData);
		}
	}

	/**
	 * @Description 通过订单ID获取所有菜品信息
	 * @author ZhouWei
	 * @version 2.0.0
	 * @time 2017-04-21
	 * @return
	 * @param subOrderID
	 */
	@ResponseBody
	@GetMapping("/getFood")
	public JSONPObject getFoodList(@ApiParam(value = "订单编号",required = true) @RequestParam("OrderID") Long subOrderID){
		ResultData resultData = new ResultData();
		try {
			if (subOrderID == null) {
				resultData.setCode(CodeMsgConstants.PARAM_ERROR);
				resultData.setMessage(CodeMsgConstants.PARAM_ERROR_MSG);
				return getResultJSONPObject(resultData);
			}
			List<O_OrderDetailInfoEntity>  orderDetailInfoList = o_orderDetailInfoService.getUnderOrderDetailInfoList(subOrderID);
			return getResultJSONPObject(orderDetailInfoList);
		}catch (BizException ex) {
			resultData.setCode(ex.getCode());
			resultData.setMessage(ex.getMessage());
			return getResultJSONPObject(resultData);
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			resultData.setCode(CodeMsgConstants.FAIL);
			resultData.setMessage(CodeMsgConstants.FAIL_MSG);
			return getResultJSONPObject(resultData);
		}
	}

	/**
	 * @Description 批量退菜
	 * @author ZhouWei
	 * @version 2.0.0
	 * @time 2017-04-21
	 * @param
	 * @return
	 */
	@ResponseBody
	@GetMapping("/revocationFoodBatch")
	public JSONPObject revocationFoodBatch(@ApiParam(value = "数量", required = true) @RequestParam("quantitys") Integer[] quantitys,
                                           @ApiParam(value = "订单明细编号", required = true) @RequestParam("detailIDs") Long[] detailIDs,
                                           @ApiParam(value = "退菜原因", required = true) @RequestParam("memo") String memo,
										   @ApiParam(value = "是否报损退菜", required = false) @RequestParam(value = "revocationType",required = false) Long revocationType){
		ResultData resultData = new ResultData();
		try{
			if (quantitys.length == detailIDs.length) {
                resultData = o_orderDetailInfoService.revocationFoodBatch(quantitys,detailIDs,memo,this.getArchiveID(),revocationType);
			}else {
                resultData.setCode(CodeMsgConstants.PARAM_ERROR);
                resultData.setMessage(CodeMsgConstants.PARAM_ERROR_MSG);
                return getResultJSONPObject(resultData);
            }
			return getResultJSONPObject(resultData);
		}catch (BizException ex) {
			resultData.setCode(ex.getCode());
			resultData.setMessage(ex.getMessage());
			return getResultJSONPObject(resultData);
		}catch (Exception e){
			logger.error(e.getMessage(), e);
			resultData.setCode(CodeMsgConstants.FAIL);
			resultData.setMessage(CodeMsgConstants.FAIL_MSG);
			return getResultJSONPObject(resultData);
		}
	}

	/**
	 * @Description 已下单赠菜
	 * @author ZhouWei
	 * @version 2.0.0
	 * @time 2017-04-25
	 * @param
	 * @return
	 */
	@ResponseBody
	@GetMapping("/presentFood")
	public JSONPObject presentFood(@ApiParam(value = "数量", required = false) @RequestParam(value="quantity",required = false) Integer quantity,
								   @ApiParam(value = "订单明细编号", required = true) @RequestParam("detailID") Long detailID,
								   @ApiParam(value = "赠菜原因", required = true) @RequestParam("memo") String memo,
								   @ApiParam(value = "称重数量", required = false) @RequestParam(value="floatQuantity",required = false) Float floatQuantity){
		ResultData resultData = new ResultData();
		try {
			if (detailID == null || (quantity == null && floatQuantity == null)) {
				resultData.setCode(CodeMsgConstants.PARAM_ERROR);
				resultData.setMessage(CodeMsgConstants.PARAM_ERROR_MSG);
				return getResultJSONPObject(resultData);
			}
			resultData = o_orderDetailInfoService.presentFood(quantity,detailID,memo,floatQuantity);
			return getResultJSONPObject(resultData);
		}catch (BizException ex) {
			resultData.setCode(ex.getCode());
			resultData.setMessage(ex.getMessage());
			return getResultJSONPObject(resultData);
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			resultData.setCode(CodeMsgConstants.FAIL);
			resultData.setMessage(CodeMsgConstants.FAIL_MSG);
			return getResultJSONPObject(resultData);
		}
	}

	/**
	 * @Description 已下单取消赠菜
	 * @author ZhouWei
	 * @version 2.0.0
	 * @time 2017-04-25
	 * @param
	 * @return
	 */
	@ResponseBody
	@GetMapping("/unPresentFood")
	public JSONPObject unPresentFood(@ApiParam(value = "数量", required = false) @RequestParam(value="quantity",required = false) Integer quantity,
								   @ApiParam(value = "订单明细编号", required = true) @RequestParam("detailID") Long detailID,
									 @ApiParam(value = "称重数量", required = false) @RequestParam(value="floatQuantity",required = false) Float floatQuantity){
		ResultData resultData = new ResultData();
		try {
			if (detailID == null  || (quantity == null && floatQuantity == null)) {
				resultData.setCode(CodeMsgConstants.PARAM_ERROR);
				resultData.setMessage(CodeMsgConstants.PARAM_ERROR_MSG);
				return getResultJSONPObject(resultData);
			}
			resultData = o_orderDetailInfoService.unPresentFood(quantity,detailID,floatQuantity);
			return getResultJSONPObject(resultData);
		}catch (BizException ex) {
			resultData.setCode(ex.getCode());
			resultData.setMessage(ex.getMessage());
			return getResultJSONPObject(resultData);
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			resultData.setCode(CodeMsgConstants.FAIL);
			resultData.setMessage(CodeMsgConstants.FAIL_MSG);
			return getResultJSONPObject(resultData);
		}
	}


	/**
	 * @Description 已下单同价换菜
	 * @author ZhouWei
	 * @version 2.0.0
	 * @time 2017-04-25
	 * @param
	 * @return
	 */
	@ResponseBody
	@GetMapping("/changeSameFood")
	public JSONPObject changeSameFood(@ApiParam(value = "订单明细编号", required = true) @RequestParam("detailID") Long detailID,
									  @ApiParam(value = "换菜单编号", required = true) @RequestParam("detailID") Long changeMenuID){
		ResultData resultData = new ResultData();
		try {
			if (changeMenuID == null || detailID == null) {
				resultData.setCode(CodeMsgConstants.PARAM_ERROR);
				resultData.setMessage(CodeMsgConstants.PARAM_ERROR_MSG);
				return getResultJSONPObject(resultData);
			}
			resultData = o_orderDetailInfoService.changeFood(detailID,changeMenuID);
			return getResultJSONPObject(resultData);
		}catch (BizException ex) {
			resultData.setCode(ex.getCode());
			resultData.setMessage(ex.getMessage());
			return getResultJSONPObject(resultData);
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			resultData.setCode(CodeMsgConstants.FAIL);
			resultData.setMessage(CodeMsgConstants.FAIL_MSG);
			return getResultJSONPObject(resultData);
		}
	}

	/**
	 * @Description 已下单不同价按同价换菜
	 * @author ZhouWei
	 * @version 2.0.0
	 * @time 2017-04-25
	 * @param
	 * @return
	 */
	@ResponseBody
	@GetMapping("/changeSamePriceFood")
	public JSONPObject changeSamePriceFood(@ApiParam(value = "订单明细编号", required = true) @RequestParam("detailID") Long detailID,
									  @ApiParam(value = "换菜单编号", required = true) @RequestParam("detailID") Long changeMenuID){
		ResultData resultData = new ResultData();
		try {
			if (changeMenuID == null || detailID == null) {
				resultData.setCode(CodeMsgConstants.PARAM_ERROR);
				resultData.setMessage(CodeMsgConstants.PARAM_ERROR_MSG);
				return getResultJSONPObject(resultData);
			}
			resultData = o_orderDetailInfoService.changeSamePriceFood(detailID,changeMenuID);
			return getResultJSONPObject(resultData);
		}catch (BizException ex) {
			resultData.setCode(ex.getCode());
			resultData.setMessage(ex.getMessage());
			return getResultJSONPObject(resultData);
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			resultData.setCode(CodeMsgConstants.FAIL);
			resultData.setMessage(CodeMsgConstants.FAIL_MSG);
			return getResultJSONPObject(resultData);
		}
	}

	/**
	 * @Description 已下单不同价按新价换菜
	 * @author ZhouWei
	 * @version 2.0.0
	 * @time 2017-04-25
	 * @param
	 * @return
	 */
	@ResponseBody
	@GetMapping("/changeNotSamePriceFood")
	public JSONPObject changeNotSamePriceFood(@ApiParam(value = "订单明细编号", required = true) @RequestParam("detailID") Long detailID,
										   @ApiParam(value = "换菜单编号", required = true) @RequestParam("changeMenuID") Long changeMenuID,
											  @ApiParam(value = "称重数量", required = false) @RequestParam(value = "floatQuantity",required = false) Float floatQuantity){
		ResultData resultData = new ResultData();
		try {
			if (changeMenuID == null || detailID == null) {
				resultData.setCode(CodeMsgConstants.PARAM_ERROR);
				resultData.setMessage(CodeMsgConstants.PARAM_ERROR_MSG);
				return getResultJSONPObject(resultData);
			}
			resultData = o_orderDetailInfoService.changeNotSamePriceFood(detailID,changeMenuID,floatQuantity);
			return getResultJSONPObject(resultData);
		}catch (BizException ex) {
			resultData.setCode(ex.getCode());
			resultData.setMessage(ex.getMessage());
			return getResultJSONPObject(resultData);
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			resultData.setCode(CodeMsgConstants.FAIL);
			resultData.setMessage(CodeMsgConstants.FAIL_MSG);
			return getResultJSONPObject(resultData);
		}
	}

	/**
	 * @Description 已下单不同规格换菜
	 * @author ZhouWei
	 * @version 2.0.0
	 * @time 2017-04-25
	 * @param
	 * @return
	 */
	@ResponseBody
	@GetMapping("/changeNotStandardFood")
	public JSONPObject changeNotStandardFood(@ApiParam(value = "订单明细编号", required = true) @RequestParam("detailID") Long detailID,
											  @ApiParam(value = "规格编号", required = true) @RequestParam("specificationID") Long specificationID){
		ResultData resultData = new ResultData();
		try {
			if (detailID == null || specificationID == null) {
				resultData.setCode(CodeMsgConstants.PARAM_ERROR);
				resultData.setMessage(CodeMsgConstants.PARAM_ERROR_MSG);
				return getResultJSONPObject(resultData);
			}
			O_OrderDetailInfoEntity orderDetailInfo = new O_OrderDetailInfoEntity();
			orderDetailInfo.setDetailID(detailID);
			//获得订单明细信息
			O_OrderDetailInfoEntity o_orderDetailInfoEntity = o_orderDetailInfoService.get(orderDetailInfo);
			if (o_orderDetailInfoEntity != null){
				ProductMessageVo productMessageVo = productMessageService.getProductMessage(o_orderDetailInfoEntity.getMenuID());
				ProductSpecificationVo specificationVo = new ProductSpecificationVo();
				List<ProductSpecificationVo> productSpecificationVoList = productMessageVo.getSpecificationList();
//			for (ProductSpecificationVo productSpecificationVo: productSpecificationVoList) {
//				if (specificationID.equals(productSpecificationVo.getSpecificationID())){
//					specificationVo = productSpecificationVo;
//				}
//			}
				resultData = o_orderDetailInfoService.changeNotStandardFood(detailID,specificationID,productSpecificationVoList);
			}
			return getResultJSONPObject(resultData);
		}catch (BizException ex) {
			resultData.setCode(ex.getCode());
			resultData.setMessage(ex.getMessage());
			return getResultJSONPObject(resultData);
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			resultData.setCode(CodeMsgConstants.FAIL);
			resultData.setMessage(CodeMsgConstants.FAIL_MSG);
			return getResultJSONPObject(resultData);
		}
	}

	/**
	 * @Description 获取同价菜单列表
	 * @author ZhouWei
	 * @version 2.0.0
	 * @time 2017-05-3
	 * @param
	 * @return
	 */
	@ResponseBody
	@GetMapping("/getSamePriceFood")
	public JSONPObject getSamePriceFoodList(@ApiParam(value = "菜单编号", required = true) @RequestParam("menuID") Long menuID,
								  @ApiParam(value = "菜名", required = false) @RequestParam(value="productName",required = false) String productName){
		ResultData resultData = new ResultData();
		try {
			if (menuID == null) {
				resultData.setCode(CodeMsgConstants.PARAM_ERROR);
				resultData.setMessage(CodeMsgConstants.PARAM_ERROR_MSG);
				return getResultJSONPObject(resultData);
			}
			resultData.setData(b_merchantMenuInfoService.getSamePriceFoodList(menuID,productName));
			resultData.setCode(CodeMsgConstants.SUCCESS);
			resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
			return getResultJSONPObject(resultData);
		}catch (BizException ex) {
			resultData.setCode(ex.getCode());
			resultData.setMessage(ex.getMessage());
			return getResultJSONPObject(resultData);
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			resultData.setCode(CodeMsgConstants.FAIL);
			resultData.setMessage(CodeMsgConstants.FAIL_MSG);
			return getResultJSONPObject(resultData);
		}
	}

	/**
	 * @Description 获取不同价菜单列表
	 * @author ZhouWei
	 * @version 2.0.0
	 * @time 2017-05-3
	 * @param
	 * @return
	 */
	@ResponseBody
	@GetMapping("/getNotSamePriceFood")
	public JSONPObject getNotSamePriceFoodList(@ApiParam(value = "菜单编号", required = true) @RequestParam("menuID") Long menuID,
											@ApiParam(value = "菜名", required = false) @RequestParam(value = "productName",required = false) String productName){
		ResultData resultData = new ResultData();
		try {
			if (menuID == null) {
				resultData.setCode(CodeMsgConstants.PARAM_ERROR);
				resultData.setMessage(CodeMsgConstants.PARAM_ERROR_MSG);
				return getResultJSONPObject(resultData);
			}
			resultData.setData(b_merchantMenuInfoService.getNotSamePriceFoodList(menuID,productName));
			resultData.setCode(CodeMsgConstants.SUCCESS);
			resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
			return getResultJSONPObject(resultData);
		}catch (BizException ex) {
			resultData.setCode(ex.getCode());
			resultData.setMessage(ex.getMessage());
			return getResultJSONPObject(resultData);
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			resultData.setCode(CodeMsgConstants.FAIL);
			resultData.setMessage(CodeMsgConstants.FAIL_MSG);
			return getResultJSONPObject(resultData);
		}
	}

	/**
	 * @Description 获取不同规格菜单列表
	 * @author ZhouWei
	 * @version 2.0.0
	 * @time 2017-05-3
	 * @param
	 * @return
	 */
	@ResponseBody
	@GetMapping("/getNotStandardFood")
	public JSONPObject getNotStandardFoodList(@ApiParam(value = "菜单编号", required = true) @RequestParam("menuID") Long menuID){
		ResultData resultData = new ResultData();
		try {
			if (menuID == null) {
				resultData.setCode(CodeMsgConstants.PARAM_ERROR);
				resultData.setMessage(CodeMsgConstants.PARAM_ERROR_MSG);
				return getResultJSONPObject(resultData);
			}
			ProductMessageVo productMessageVo = productMessageService.getProductMessage(menuID);
			B_MerchantMenuInfoEntity b_merchantMenuInfoEntity = new B_MerchantMenuInfoEntity();
			b_merchantMenuInfoEntity.setMenuID(menuID);
			B_MerchantMenuInfoEntity merchantMenuInfoEntity = b_merchantMenuInfoService.get(b_merchantMenuInfoEntity);
			if (productMessageVo == null || merchantMenuInfoEntity == null){
				resultData.setCode(CodeMsgConstants.PARAM_ERROR);
				resultData.setMessage(CodeMsgConstants.PARAM_ERROR_MSG);
				return getResultJSONPObject(resultData);
			}

			List<ProductSpecificationVo> specificationVoList = productMessageVo.getSpecificationList();
			for (ProductSpecificationVo productSpecificationVo: specificationVoList) {
				productSpecificationVo.setPrice(merchantMenuInfoEntity.getPrice().add(productSpecificationVo.getAddedPrice()));
			}
			resultData.setData(specificationVoList);
			resultData.setCode(CodeMsgConstants.SUCCESS);
			resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
			return getResultJSONPObject(resultData);
		}catch (BizException ex) {
			resultData.setCode(ex.getCode());
			resultData.setMessage(ex.getMessage());
			return getResultJSONPObject(resultData);
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			resultData.setCode(CodeMsgConstants.FAIL);
			resultData.setMessage(CodeMsgConstants.FAIL_MSG);
			return getResultJSONPObject(resultData);
		}
	}
	/**
	 * @Description 转菜
	 * @author ZhouWei
	 * @version 2.0.0
	 * @time 2017-05-3
	 * @param
	 * @return
	 */
	@ResponseBody
	@GetMapping("/changeFoodTable")
	public JSONPObject changeFoodTable(@ApiParam(value = "订单明细编号", required = true) @RequestParam("detailID") Long detailID,
									   @ApiParam(value = "换菜的数量", required = true) @RequestParam("quantity") Integer quantity,
									   @ApiParam(value = "换菜的目标桌台子订单ID", required = true) @RequestParam("subOrderID") Long subOrderID){
		ResultData resultData = new ResultData();
		try {
			if (detailID == null || quantity == null || subOrderID == null) {
				resultData.setCode(CodeMsgConstants.PARAM_ERROR);
				resultData.setMessage(CodeMsgConstants.PARAM_ERROR_MSG);
				return getResultJSONPObject(resultData);
			}
			resultData = o_orderDetailInfoService.changeFoodTableAndPrint(detailID,quantity,subOrderID,this.getArchiveID());
			return getResultJSONPObject(resultData);
		}catch (BizException ex) {
			resultData.setCode(ex.getCode());
			resultData.setMessage(ex.getMessage());
			return getResultJSONPObject(resultData);
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			resultData.setCode(CodeMsgConstants.FAIL);
			resultData.setMessage(CodeMsgConstants.FAIL_MSG);
			return getResultJSONPObject(resultData);
		}
	}

	/**
	 * @Description 批量转菜
	 * @author ZhouWei
	 * @version 2.0.0
	 * @time 2017-05-3
	 * @param
	 * @return
	 */
	@ResponseBody
	@GetMapping("/changeFoodTableBatch")
	public JSONPObject changeFoodTableBatch(@ApiParam(value = "订单明细编号", required = true) @RequestParam("detailIDs") Long[] detailIDs,
                                            @ApiParam(value = "换菜的数量", required = true) @RequestParam("quantitys") Integer[] quantitys,
                                            @ApiParam(value = "换菜的目标桌台子订单ID", required = true) @RequestParam("subOrderID") Long subOrderID){
		ResultData resultData = new ResultData();
		try {
			if (quantitys.length == detailIDs.length) {
                resultData = o_orderDetailInfoService.changeFoodTableBatch(detailIDs,quantitys,subOrderID,this.getArchiveID());
			}else {
                resultData.setCode(CodeMsgConstants.PARAM_ERROR);
                resultData.setMessage(CodeMsgConstants.PARAM_ERROR_MSG);
                return getResultJSONPObject(resultData);
            }
			return getResultJSONPObject(resultData);
		}catch (BizException ex) {
			resultData.setCode(ex.getCode());
			resultData.setMessage(ex.getMessage());
			return getResultJSONPObject(resultData);
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			resultData.setCode(CodeMsgConstants.FAIL);
			resultData.setMessage(CodeMsgConstants.FAIL_MSG);
			return getResultJSONPObject(resultData);
		}
	}

	/**
	 * @Description 退菜原因
	 *  @author zhouwei
	 *  @version 2.0.0
	 */
	@ResponseBody
	@GetMapping("/getRevocationFood")
	public JSONPObject getRevocationFood(){
		ResultData resultData = new ResultData();
		try{
			List<ReasonVO> dictionaryReason = o_orderDetailInfoService.getFoodReason(DictionaryCatalogEnum.REVOKE_PRODUCT,this.getArchiveID());
			resultData.setCode(CodeMsgConstants.SUCCESS);
			resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
			resultData.setData(dictionaryReason);
		}catch (Exception e){
			logger.error(e.getMessage(), e);
			resultData.setCode(CodeMsgConstants.ERROR);
			resultData.setMessage(CodeMsgConstants.ERROR_MSG);
		}
		return getResultJSONPObject(resultData);
	}

	/**
	 * @Description 赠菜原因
	 *  @author zhouwei
	 *  @version 2.0.0
	 */
	@ResponseBody
	@GetMapping("/getPresentFood")
	public JSONPObject getPresentFood(){
		ResultData resultData = new ResultData();
		try{
			List<ReasonVO> dictionaryReason = o_orderDetailInfoService.getFoodReason(DictionaryCatalogEnum.GIVE_PRODUCT,this.getArchiveID());
			resultData.setCode(CodeMsgConstants.SUCCESS);
			resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
			resultData.setData(dictionaryReason);
		}catch (Exception e){
			logger.error(e.getMessage(), e);
			resultData.setCode(CodeMsgConstants.ERROR);
			resultData.setMessage(CodeMsgConstants.ERROR_MSG);
		}
		return getResultJSONPObject(resultData);
	}


}
