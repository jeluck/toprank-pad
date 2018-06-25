package cc.toprank.byd.web.controller.table;

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.component.DictionaryComponent;
import cc.toprank.byd.enums.DictionaryCatalogEnum;
import cc.toprank.byd.vo.ReasonVO;
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
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



/*********************************************************************************************.
 * 
 * 
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 * @author ZhouWei
 * @version 2.0.0
 *
 * <p></p>
 *********************************************************************************************/

@Controller
@RequestMapping("/reception/table")
public class EliminateTableController extends BaseController{

	private static final Logger logger = LoggerFactory.getLogger(EliminateTableController.class.getName());

	@Autowired
	private B_DinningTableInfoService b_DinningTableInfoService;

	@Autowired
	private DictionaryComponent dictionaryComponent;

	/**
	 * @Description 进行消台处理，
	 * @param传入参数信息
	 * @return int    响应0处理异常，1处理成功,2处理失败，证明还有客户在使用，只要这个餐桌存在订单就不能消台
	 * @author zhouwei
	 **/
	@ResponseBody
	@GetMapping(value = "/eliminateTable")
	public JSONPObject eliminateTable(@ApiParam(value = "桌台编号组", required = false) @RequestParam( value="tableIDs",required = false) String tableIDs,
									  @ApiParam(value = "桌台名称", required = false) @RequestParam( value="subOrderIDs",required = false) String subOrderIDs,
									  @ApiParam(value = "桌台编号", required = true) @RequestParam("tableID") Long tableID,
									  @ApiParam(value = "消台原因", required = false) @RequestParam(value = "memo",required = false) String memo) {
		ResultData resultData = new ResultData();
		Map map = new HashMap();
		try {
			if (tableID == null){
				resultData.setCode(CodeMsgConstants.PARAM_ERROR);
				resultData.setMessage(CodeMsgConstants.PARAM_ERROR_MSG);
			}
			if (subOrderIDs != null){
				map.put("subOrderIDs",subOrderIDs);
			} else {
				map.put("subOrderIDs","");
			}
            if (tableIDs != null){
				map.put("tableIDs",tableIDs);
            } else {
				map.put("tableIDs","");
			}
            Long archiveID = getArchiveID();
			if (archiveID != null){
				map.put("archiveID",archiveID);
			}
			map.put("tableID" , tableID);
			map.put("memo",memo);
			resultData = b_DinningTableInfoService.eliminateTable(map);
		} catch (BizException be) {
			logger.error(be.getMessage(), be);
			resultData.setCode(be.getCode());
			resultData.setMessage(be.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
		}
		return getResultJSONPObject(resultData);
	}

	/**
	 * @Description 通过tableID获取所关联的联台桌的信息
     *  @author zhouwei
	 *  @version 2.0.0
	 */
	@ResponseBody
	@GetMapping("/getRelationTableList")
	public JSONPObject getRelationTableList(@ApiParam(value = "桌台编号", required = true) @RequestParam("tableID") Long tableID){
		ResultData resultData = null;
        try{
			Map useMap = new HashMap<>();
			useMap.put("tableID",tableID);
			useMap.put("archiveID",getArchiveID());
			resultData = b_DinningTableInfoService.getRelationTableList(useMap);
        }catch (Exception e){
			logger.error(e.getMessage(), e);
			resultData.setCode(CodeMsgConstants.ERROR);
			resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }
        return getResultJSONPObject(resultData);
	}
	/**
	 * @Description 消台原因列表
	 *  @author zhouwei
	 *  @version 2.0.0
	 */
	@ResponseBody
	@GetMapping("/getEliminateTableReason")
	public JSONPObject getEliminateTableReason(){
		ResultData resultData = new ResultData();
		try{
			List<ReasonVO> dictionaryReason =  dictionaryComponent.getReasonByCatalogCode(DictionaryCatalogEnum.ELIMINATE_TABLE,this.getArchiveID());
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
