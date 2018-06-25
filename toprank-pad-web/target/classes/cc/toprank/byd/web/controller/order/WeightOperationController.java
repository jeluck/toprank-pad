package cc.toprank.byd.web.controller.order;

import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.constant.ResultData;
import cc.toprank.byd.base.BaseController;
import cc.toprank.byd.entity.P_ProductVariantInfoEntity;
import cc.toprank.byd.web.service.menu.O_OrderDetailInfoService;
import cc.toprank.byd.web.service.menu.P_ProductVariantInfoService;
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


/*********************************************************************************************.
 * 
 * 
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 * @author zhouwei
 * @version 2.0.0
 * <p></p>
 *********************************************************************************************/

@Controller
@RequestMapping("/order/weight")
public class WeightOperationController extends BaseController{
    private static final Logger logger = LoggerFactory.getLogger(WeightOperationController.class.getName());
	@Autowired
	private P_ProductVariantInfoService p_productVariantInfoService;
	@Autowired
	private O_OrderDetailInfoService o_orderDetailInfoService;

	/**
	 * 获取商量重量单位
	 * @param variantID 变体编号
	 * @return  ResultData
	 * @author zhouwei
	 * @version 2.0.0
	 */
	@ResponseBody
	@GetMapping("/getWeightName")
	public JSONPObject getWeightName(@ApiParam(value = "变体编号", required = true) @RequestParam("variantID") Long variantID){
		ResultData resultData = new ResultData();
		try{
			if ( variantID == null ){
				resultData.setCode(CodeMsgConstants.PARAM_ERROR);
				resultData.setMessage(CodeMsgConstants.PARAM_ERROR_MSG);
				return getResultJSONPObject(resultData);
			}
			P_ProductVariantInfoEntity p_productVariantInfoEntity  = p_productVariantInfoService.getProductVariantInfoByID(variantID);
			return getResultJSONPObject(p_productVariantInfoEntity);
		}catch (Exception e){
			logger.error(e.getMessage(), e);
			resultData.setCode(CodeMsgConstants.ERROR);
			resultData.setMessage(CodeMsgConstants.ERROR_MSG);
			return getResultJSONPObject(resultData);
		}
	}
    /**
     * 修改已下单商品称重
     * @param menuID 菜单编号
     * @return  ResultData
     * @author zhouwei
	 * @version 2.0.0
     */
    @ResponseBody
    @GetMapping("/updateWeight")
    public JSONPObject updateWeight(@ApiParam(value = "菜单编号", required = true) @RequestParam("menuID") Long menuID,
									@ApiParam(value = "重量", required = true) @RequestParam("floatQuantity") Float floatQuantity,
									@ApiParam(value = "订单明细编号", required = true) @RequestParam("detailID") Long detailID) {
		ResultData resultData = new ResultData();
		try {
			if (menuID == null || floatQuantity == null) {
				resultData.setCode(CodeMsgConstants.PARAM_ERROR);
				resultData.setMessage(CodeMsgConstants.PARAM_ERROR_MSG);
				return getResultJSONPObject(resultData);
			}
			o_orderDetailInfoService.updateOrderDetailInfoByVariantID(menuID,floatQuantity,detailID);
			return getResultJSONPObject(resultData);
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			resultData.setCode(CodeMsgConstants.FAIL);
			resultData.setMessage(CodeMsgConstants.FAIL_MSG);
			return getResultJSONPObject(resultData);
		}
	}
}
