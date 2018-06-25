package cc.toprank.byd.producePort.controller;

import cc.toprank.byd.entity.B_MerchantInfoEntity;
import cc.toprank.byd.pad.controller.PadController;
import cc.toprank.byd.producePort.service.ProducePortService;
import cc.toprank.byd.web.constant.ResultData;
import cc.toprank.byd.web.service.menu.B_MerchantInfoService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 出品口
 *
 * @author LeeJun
 * @create 2017-06-12 16:51
 */
@RestController
@RequestMapping("/producePort")
@Api(value = "/producePort", description = "出品口")
public class ProducePortController extends PadController {

    private final static String ARCHIVEID_KEY = "ArchiveID";

    @Autowired
    private ProducePortService producePortService;
    @Autowired
    private B_MerchantInfoService merchantInfoService;

    @PostMapping(value = "init", produces = "application/json;charset=UTF-8")
    @ApiOperation(value = "出品口初始化", httpMethod = "POST", response = ResultData.class)
    public ResultData init() {
        B_MerchantInfoEntity merchantInfo = merchantInfoService.getMerchantInfoByOnly();
        // 档案信息存入session
        super.getSession().setAttribute(ARCHIVEID_KEY, merchantInfo.getArchiveID());
        return ResultData.makeResult(merchantInfo);
    }

    @GetMapping(value = "producePort", produces = "application/json;charset=UTF-8")
    @ApiOperation(value = "获取出品口配置列表", httpMethod = "GET", response = ResultData.class)
    public ResultData getProducePortList() {
        Long archiveID = (Long) super.getSession().getAttribute(ARCHIVEID_KEY);
        return ResultData.makeSuccessResult(producePortService.getProducePortList(archiveID));
    }

    @GetMapping(value = "dishes", produces = "application/json;charset=UTF-8")
    @ApiOperation(value = "获取出品口菜品列表", httpMethod = "GET", response = ResultData.class)
    public ResultData getDishes(@ApiParam(name = "portID", value = "出品口ID") @RequestParam("portID") Long portID,
                                @ApiParam(name = "type", value = "待出品:0,已出品:1") @RequestParam(name = "type", defaultValue = "0") int type,
                                @ApiParam(name = "keywords", value = "搜索关键字") @RequestParam(name = "keywords", required = false) String keywords,
                                @ApiParam(name = "pageNum", value = "当前页码") @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum) {
        return ResultData.makeResult(producePortService.getProduceByPortID(portID, type, keywords, pageNum));
    }

    @PostMapping(value = "produce", produces = "application/json;charset=UTF-8")
    @ApiOperation(value = "出品/反出品", httpMethod = "POST", response = ResultData.class)
    public ResultData updateProduceStatus(@ApiParam(name = "produceID", value = "制作ID") @RequestParam("produceID") Long produceID,
                                          @ApiParam(name = "type", value = "出品:0,反出品:1") @RequestParam(name = "type", defaultValue = "0") int type) {
        return ResultData.makeResult(producePortService.updateProduceStatus(produceID, type));
    }


}
