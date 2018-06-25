package cc.toprank.byd.pad.controller;

import cc.toprank.byd.pad.pojo.OrderDishesDTO;
import cc.toprank.byd.pad.service.BookingService;
import cc.toprank.byd.pad.service.OrderService;
import cc.toprank.byd.web.constant.ResultData;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 订单接口
 *
 * @author LeeJun
 * @version 2.0.0
 * @time 2017-3-30 16:41
 */
@RestController
@RequestMapping("/pad/order")
@Api(value = "/pad/order", description = "订单")
public class OrderController extends PadController {


    @Autowired
    private BookingService bookingService;
    @Autowired
    private OrderService orderService;

    @ApiOperation(value = "获取桌台下个预定时间", httpMethod = "GET", response = ResultData.class)
    @GetMapping(value = "/nextBookingTime", produces = "application/json;charset=UTF-8")
    public ResultData nextBookingTime() throws Exception {
        return ResultData.makeResult(bookingService.getNextBookingTimeByTableID());
    }

    @ApiOperation(value = "下单", httpMethod = "POST", response = ResultData.class)
    @PostMapping(value = "/order", produces = "application/json;charset=UTF-8")
    public ResultData placeOrder(@RequestBody OrderDishesDTO dishesDto) throws Exception {
        return ResultData.makeSuccessResult(orderService.placeOrder(dishesDto));
    }

    @ApiOperation(value = "订单详情", httpMethod = "GET", response = ResultData.class)
    @GetMapping(value = "/details/{subOrderID}", produces = "application/json;charset=UTF-8")
    public ResultData orderDetails(@PathVariable("subOrderID") Long subOrderID) {
        return ResultData.makeResult(orderService.getOrderDetails(subOrderID));
    }

    @ApiOperation(value = "消费明细", httpMethod = "GET", response = ResultData.class)
    @GetMapping(value = "/consumer/{subOrderID}", produces = "application/json;charset=UTF-8")
    public ResultData ConsumerDetails(@PathVariable("subOrderID") Long subOrderID) {
        return ResultData.makeSuccessResult(orderService.getConsumerDetails(subOrderID));
    }

    @ApiOperation(value = "预订单详情", httpMethod = "GET", response = ResultData.class)
    @GetMapping(value = "/bookingDetails/{subOrderID}", produces = "application/json;charset=UTF-8")
    public ResultData bookingDetails(@PathVariable("subOrderID") Long subOrderID) {
        return ResultData.makeResult(bookingService.getBookingDetailBySubOrderID(subOrderID));
    }

    @ApiOperation(value = "等叫", httpMethod = "POST", response = ResultData.class)
    @PostMapping(value = "/waits", produces = "application/json;charset=UTF-8")
    public ResultData waits(@RequestBody String detailIDs) {
        return ResultData.makeResult(orderService.waitsOrderDetail(detailIDs));
    }

    @ApiOperation(value = "叫起", httpMethod = "POST", response = ResultData.class)
    @PostMapping(value = "/rouse", produces = "application/json;charset=UTF-8")
    public ResultData rouse(@RequestBody String detailIDs) {
        return ResultData.makeResult(orderService.rouseOrderDetail(detailIDs));
    }

    @ApiOperation(value = "催菜", httpMethod = "POST", response = ResultData.class)
    @PostMapping(value = "/urge", produces = "application/json;charset=UTF-8")
    public ResultData urge(@RequestBody String detailIDs) {
        return ResultData.makeResult(orderService.urgeDishes(detailIDs));
    }

    @ApiOperation(value = "推荐菜品", httpMethod = "POST", response = ResultData.class)
    @PostMapping(value = "/commend", produces = "application/json;charset=UTF-8")
    public ResultData commend(@RequestBody String detailIDs) {
        return ResultData.makeResult(orderService.commendDishes(detailIDs));
    }

    @ApiOperation(value = "餐中服务(1.等叫;2.叫起;3.催菜;4.推荐;5.加菜)", httpMethod = "POST", response = ResultData.class)
    @PostMapping(value = "/service/{type}", produces = "application/json;charset=UTF-8")
    public ResultData service(@PathVariable("type") int type, @RequestParam("detailIDs") String detailIDs) {
        return ResultData.makeResult(orderService.serviceOperating(type, detailIDs));
    }

}
