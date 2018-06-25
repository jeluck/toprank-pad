package cc.toprank.byd.stall.controller;

import cc.toprank.byd.entity.B_DinningTableInfoEntity;
import cc.toprank.byd.pad.controller.PadController;
import cc.toprank.byd.stall.service.DinningTableInfoService;
import cc.toprank.byd.web.constant.ResultData;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 桌台信息
 * Created by HuangCY on 2017-3-16.
 */
@RestController
@RequestMapping("/stall/table")
@Api(value = "/stall/table", description = "桌台信息")
public class DinningTableInfoController extends PadController {
    @Autowired
    private DinningTableInfoService dinningTableInfoService;

    /**
     * 按条件查询桌台信息
     * @author HuangCY
     * @Time 2017-3-16
     * @param archiveID
     * @param tableName
     * @param areaID
     * @param request
     * @return
     */
    @ApiOperation(value = "查询桌台信息", httpMethod = "POST", response = ResultData.class)
    @PostMapping(value = "/query", produces = "application/json;charset=UTF-8")
    public ResultData queryDinningTableInfoByCondition (
            @ApiParam(value = "档案编号") @RequestParam(required = false) Long archiveID,
            @ApiParam(value = "桌台名称") @RequestParam(required = false) String tableName,
            @ApiParam(value = "区域编号") @RequestParam(required = false) Long areaID,
            HttpServletRequest request) {

        Map paramMap = new HashMap();

        paramMap.put("archiveID",archiveID);
        paramMap.put("tableName",tableName);
        paramMap.put("areaID",areaID);

        //按条件查询桌台信息
        List<B_DinningTableInfoEntity> resultList = dinningTableInfoService.queryDinningTableInfoByCondition(paramMap);

        return ResultData.makeResult(resultList);
    }
}

