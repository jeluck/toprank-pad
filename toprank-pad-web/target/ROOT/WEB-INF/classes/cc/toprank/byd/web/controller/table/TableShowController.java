package cc.toprank.byd.web.controller.table;

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.constant.ResultData;
import cc.toprank.byd.base.BaseController;
import cc.toprank.byd.web.service.table.B_DinningTableInfoService;
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
 * 
 * <p></p>
 *********************************************************************************************/

@Controller
@RequestMapping("/reception/table")
public class TableShowController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(TableShowController.class.getName());

	@Autowired
	private B_DinningTableInfoService b_DinningTableInfoService;

	/**
	 * 通过点击获取右侧加载信息
     *  @author zhouwei
	 */
	@ResponseBody
	@GetMapping("/getShowTable")
	public JSONPObject getTableShowMessage(@ApiParam(value = "桌台编号", required = true) @RequestParam("tableID") Long tableID,
										   @ApiParam(value = "桌台名称", required = false) @RequestParam( value="subOrderID",required = false) Long subOrderID){
		ResultData resultData = new ResultData();
        try{
        	if (tableID == null){
				resultData.setCode(CodeMsgConstants.PARAM_ERROR);
				resultData.setMessage(CodeMsgConstants.PARAM_ERROR_MSG);
				return getResultJSONPObject(resultData);
			}
			return getResultJSONPObject(b_DinningTableInfoService.getTableShowMessage(tableID,subOrderID));
        }catch (BizException ex){
			logger.error(ex.getMessage(),ex);
			resultData.setCode(ex.getCode());
			resultData.setMessage(ex.getMessage());
		}catch (Exception e){
			logger.error(e.getMessage(),e);
			resultData.setCode(CodeMsgConstants.ERROR);
			resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }
        return getResultJSONPObject(resultData);
	}

}
