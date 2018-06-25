package cc.toprank.byd.pad.controller;

import cc.toprank.byd.pad.service.OpenTableService;
import cc.toprank.byd.pad.service.TableService;
import cc.toprank.byd.pad.util.MerchantCacheUtils;
import cc.toprank.byd.web.constant.ResultData;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/pad/order/table")
@Api(value = "/pad/order/table", description = "桌态")
public class TableController extends PadController {

    @Autowired
    private TableService tableInfoService;
    @Autowired
    private OpenTableService openTableService;

    /**
     * @description 根据传入的tableID 查询桌台详细信息
     * @author LiSH
     * @time 2017-2-21 9:32
     * @version 2.0.0
     */
    @ApiOperation(value = "桌台基础信息详细(LiSH)", httpMethod = "GET", response = ResultData.class)
    @RequestMapping(value = "/tableDetail", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResultData getTableByTableID() throws Exception {
        return ResultData.makeSuccessResult(tableInfoService.getTableDetailByTableID(MerchantCacheUtils.getCurrentTableID()));
    }


    @ApiOperation(value = "查看当前时间是否被预定(LiSH)", httpMethod = "GET", response = ResultData.class)
    @ResponseBody
    @RequestMapping(value = "/isBooking", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResultData isBooking() throws Exception {
        return ResultData.makeSuccessResult(tableInfoService.checkIsBooking(MerchantCacheUtils.getCurrentTableID()));
    }

    /**
     * @Description 根据预定单ID 桌台ID 消费人数 进行预定开台操作
     * @Author LiSH
     * @Time 2017-2-21 9:33
     * @Version 2.0.0
     */
    @ApiOperation(value = "预定开台(LiSH)", httpMethod = "POST", response = ResultData.class)
    @RequestMapping(value = "/bookingOpenTable", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultData bookingOpenTable(@ApiParam(value = "预订单ID") @RequestParam(required = true) Long bookingID,
                                       @ApiParam(value = "消费人数") @RequestParam int personNumber,
                                       @ApiParam(value = "说明") @RequestParam(required = false) String desc) throws Exception {
        return ResultData.makeSuccessResult(openTableService.bookingOpenTable(bookingID, MerchantCacheUtils.getCurrentTableID(), personNumber, desc));
        // return ResultData.makeSuccessResult(tableInfoService.bookingOpenTable(bookingID, MerchantCacheUtils.getCurrentTableID(), personNumber, desc, MerchantCacheUtils.getTableManagerID()));
    }

    /**
     * @description 正常通过桌台ID进行开台操作
     * @author LiSH
     * @time 2017-2-21 9:36
     * @version 2.0.0
     */
    @ApiOperation(value = "普通开台(LiSH)", httpMethod = "POST", response = ResultData.class)
    @RequestMapping(value = "/openTable", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultData openTable(@ApiParam(value = "消费人数") @RequestParam Integer personNumber,
                                @ApiParam(value = "说明") @RequestParam(required = false) String desc) throws Exception {
        return ResultData.makeSuccessResult(openTableService.openTable(MerchantCacheUtils.getCurrentTableID(), personNumber, desc));
        // return ResultData.makeSuccessResult(tableInfoService.openTable(MerchantCacheUtils.getCurrentTableID(), personNumber, desc, MerchantCacheUtils.getTableManagerID()));
    }

    /**
     * @description 查询所在餐厅的区域列表
     * @author LiSH
     * @time 2017-2-21 9:36
     * @version 2.0.0
     */
    @RequestMapping(value = "/areas", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value = "区域列表(LiSH)", httpMethod = "GET", response = ResultData.class)
    public ResultData getAreaList(HttpServletRequest request) throws Exception {
        return ResultData.makeSuccessResult(tableInfoService.getAreasByArchiveID());
    }

    /**
     * @description 根据areaID 查询该区域下所有桌台信息 !!tips: 当areaID = 0 查询全部桌台
     * @author LiSH
     * @time 2017-2-21 9:37
     * @version 2.0.0
     */
    @RequestMapping(value = "/tables/{areaID}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value = "桌台列表(LiSH)", httpMethod = "GET", response = ResultData.class)
    public ResultData getTableList(@ApiParam(value = "区域ID") @PathVariable Long areaID) throws Exception {
        return ResultData.makeSuccessResult(tableInfoService.getTableListByAreaID(areaID));
    }

    @ApiOperation(value = "(此接口不用测试 后台做数据使用)给当前桌台添加一条预定单(LiSH)", httpMethod = "GET", response = ResultData.class)
    @RequestMapping(value = "/addBooking", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResultData addBooking() throws Exception {
        return ResultData.makeSuccessResult(tableInfoService.addBooking(MerchantCacheUtils.getCurrentTableID()));
    }

    @ApiOperation(value = "(此接口不用测试 后台做数据使用)给当前桌台补全餐次信息(LiSH)", httpMethod = "GET", response = ResultData.class)
    @RequestMapping(value = "/addMealData", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResultData addMealData() throws Exception {
        return ResultData.makeSuccessResult(tableInfoService.addMealData(MerchantCacheUtils.getCurrentTableID()));
    }

    @ApiOperation(value = "(此接口不用测试 后台做数据使用)给当前桌台补全当前餐次餐段信息(LiSH)", httpMethod = "GET", response = ResultData.class)
    @RequestMapping(value = "/addMealTableMapping", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResultData addMealTableMapping() throws Exception {
        return ResultData.makeSuccessResult(tableInfoService.addMealTableMapping(MerchantCacheUtils.getCurrentTableID()));
    }

    @ApiOperation(value = "(此接口不用测试 后台做数据使用)清除桌台ID的所有使用中订单,并且重置为空台(不传默认清除当前桌台)(LiSH)", httpMethod = "GET", response = ResultData.class)
    @RequestMapping(value = "/cleanTableUsingOrderList", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResultData cleanTableUsingOrderList(@ApiParam(value = "桌台ID") @RequestParam(required = false) Long tableID) throws Exception {
        if (tableID == null) {
            tableID = MerchantCacheUtils.getCurrentTableID();
        }
        return ResultData.makeSuccessResult(tableInfoService.cleanTableUsingOrderList(tableID));
    }
}
