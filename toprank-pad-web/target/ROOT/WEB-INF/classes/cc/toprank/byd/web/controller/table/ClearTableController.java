package cc.toprank.byd.web.controller.table;

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.constant.ResultData;
import cc.toprank.byd.base.BaseController;
import cc.toprank.byd.entity.B_DinningTableInfoEntity;
import cc.toprank.byd.web.service.table.B_DinningTableInfoService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.wordnik.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/*********************************************************************************************.
 * 
 * 
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 * @author zhouwei
 * @version 2.0.0
 * <p></p>
 *********************************************************************************************/

@Controller
@RequestMapping("/reception/table")
public class ClearTableController extends BaseController{
    private static final Logger logger = LoggerFactory.getLogger(ClearTableController.class.getName());
	@Autowired
	private B_DinningTableInfoService b_DinningTableInfoService;

	/**
	 * 清台
	 * @param tableID 餐次桌台信息
	 * @return  ResultData
	 * @author zhouwei
	 * @version 2.0.0
	 */
	@ResponseBody
	@GetMapping("/clearTable")
	public JSONPObject changeTableStatusToEmpty(@ApiParam(value = "桌台编号", required = true) @RequestParam("tableID") Long tableID){
		ResultData resultData = new ResultData();
		try{
			if ( tableID == null ){
				resultData.setCode(CodeMsgConstants.PARAM_ERROR);
				resultData.setMessage(CodeMsgConstants.PARAM_ERROR_MSG);
				return getResultJSONPObject(resultData);
			}
			B_DinningTableInfoEntity b_dinningTableInfoEntity = new B_DinningTableInfoEntity();
			b_dinningTableInfoEntity.setTableID(tableID);
			resultData = b_DinningTableInfoService.clearTable(b_dinningTableInfoEntity);
			return getResultJSONPObject(resultData);
		}catch (Exception e){
			logger.error(e.getMessage(), e);
			resultData.setCode(CodeMsgConstants.ERROR);
			resultData.setMessage(CodeMsgConstants.ERROR_MSG);
			return getResultJSONPObject(resultData);
		}
	}
    /**
     * 批量清台
     * @param tableIDs 餐次桌台信息
     * @return  ResultData
     * @author zhouwei
	 * @version 2.0.0
     */
    @ResponseBody
    @GetMapping("/clearTableBatch")
    public JSONPObject clearTablesBatch(@ApiParam(value = "桌台编号", required = true) @RequestParam("tableIDs") String tableIDs) {
		ResultData resultData = new ResultData();
		try {
			if (StringUtils.isEmpty(tableIDs)) {
				resultData.setCode(CodeMsgConstants.PARAM_ERROR);
				resultData.setMessage(CodeMsgConstants.PARAM_ERROR_MSG);
				return getResultJSONPObject(resultData);
			}
			resultData = b_DinningTableInfoService.clearTableBatch(tableIDs);
			return getResultJSONPObject(resultData);
		}catch (BizException ex){
			logger.error(ex.getMessage(), ex);
			resultData.setCode(ex.getCode());
			resultData.setMessage(ex.getMessage());
			return getResultJSONPObject(resultData);
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			resultData.setCode(CodeMsgConstants.ERROR);
			resultData.setMessage(CodeMsgConstants.ERROR_MSG);
			return getResultJSONPObject(resultData);
		}
	}
}
