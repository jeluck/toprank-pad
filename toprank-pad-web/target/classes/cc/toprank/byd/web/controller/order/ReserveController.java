package cc.toprank.byd.web.controller.order;

import cc.toprank.byd.base.BaseController;
import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.common.utils.DateUtils;
import cc.toprank.byd.entity.*;
import cc.toprank.byd.enums.CommonManageEnum;
import cc.toprank.byd.enums.MerchantManageEnum;
import cc.toprank.byd.enums.OrderManageEnum;
import cc.toprank.byd.stall.service.ShopAreaInfoService;
import cc.toprank.byd.util.EnumUtil;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.constant.ResultData;
import cc.toprank.byd.web.dto.UserInfoVo;
import cc.toprank.byd.web.service.booking.B_PeriodConfigInfoService;
import cc.toprank.byd.web.service.booking.O_BookingInfoService;
import cc.toprank.byd.web.service.member.MemberInfoService;
import cc.toprank.byd.web.service.menu.B_MerchantInfoService;
import cc.toprank.byd.web.service.menu.O_OrderDetailInfoService;
import cc.toprank.byd.web.service.menu.O_OrderInfoService;
import cc.toprank.byd.web.service.menu.O_SubOrderInfoService;
import cc.toprank.byd.web.service.order.DictionaryInfoService;
import cc.toprank.byd.web.service.payment.BasicParamInfoService;
import cc.toprank.byd.web.service.table.B_DinningTableInfoService;
import cc.toprank.byd.web.service.table.B_MealsInfoService;
import cc.toprank.byd.web.service.table.B_ReservationTimeInfoService;
import cc.toprank.byd.web.vo.reserve.QueryReserveVO;
import cc.toprank.byd.web.vo.reserve.ReserveVo;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mangofactory.swagger.annotations.ApiIgnore;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiImplicitParams;
import com.wordnik.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.beetl.ext.fn.Json;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @Description：预订相关接口类
 * @Author：Zhaolingchen
 * @Time: 2017-5-17 10:00
 * @Version 2.0.0
 */
@RestController
@RequestMapping("/order/reserve")
@Api(value = "/order/reserve", description = "预订相关接口类")
public class ReserveController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(ReserveController.class.getName());

    @Autowired
    private O_BookingInfoService bookingInfoService;

    @Autowired
    private B_MealsInfoService mealsInfoService;

    @Autowired
    private B_DinningTableInfoService dinningTableInfoService;

    @Autowired
    private BasicParamInfoService basicParamInfoService;

    @Autowired
    private ShopAreaInfoService shopAreaInfoService;

    @Autowired
    private B_ReservationTimeInfoService reservationTimeInfoService;

    @Autowired
    private B_PeriodConfigInfoService periodConfigInfoService;

    @Autowired
    private MemberInfoService memberInfoService;

    @Autowired
    private O_OrderInfoService orderInfoService;

    @Autowired
    private DictionaryInfoService dictionaryInfoService;

    @Autowired
    private O_OrderDetailInfoService orderDetailInfoService;

    @Autowired
    private O_SubOrderInfoService subOrderInfoService;

    @Autowired
    private B_MerchantInfoService merchantInfoService;

    /**
     * @Description：查询预订列表
     * @Author：Zhaolingchen
     * @Time: 2017-5-17 10:00
     * @Version 2.0.0
     */
    @ApiOperation(value = "查询预订列表", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "startTime", value = "搜索开始日期", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "query", name = "endTime", value = "搜索结束日期", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "query", name = "search", value = "搜索输入框", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "query", name = "bookingStatus", value = "预订状态", dataType = "Long", required = false),
            @ApiImplicitParam(paramType = "query", name = "bookingChannel", value = "预订来源", dataType = "Long", required = false),
            @ApiImplicitParam(paramType = "query", name = "bookingType", value = "预订方式", dataType = "Long", required = false)
    })
    @GetMapping("/getBookingList")
    public JSONPObject getBookingList(@ApiIgnore QueryReserveVO queryReserveVO) throws Exception {
        Long archiveID = this.getArchiveID();
        Map<String, Object> param = this.getParaMapNotEmpty();
        param.put("archiveID", archiveID);
        param.remove("loginID");
        if (StringUtils.isNoneBlank(queryReserveVO.getStartTime())) {
            param.put("startTime", DateUtils.parseLocalDateTime(queryReserveVO.getStartTime()));
        }
        if (StringUtils.isNoneBlank(queryReserveVO.getEndTime())) {
            param.put("endTime", DateUtils.parseLocalDateTime(queryReserveVO.getEndTime()));
        }

        List<O_BookingInfoEntity> bookingInfoList = bookingInfoService.getBookingInfoByWhere(param);
        ResultData result = ResultData.makeSuccessResult(bookingInfoList);
        return getResultJSONPObject(result);
    }

    /**
     * @Description：查询预订状态,预订来源,预订类型,营销人员,餐次,餐段信息接口
     * @Author：Zhaolingchen
     * @Time: 2017-5-17 10:00
     * @Version 2.0.0
     */
    @ApiOperation(value = "查询筛选条件", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "archiveID", value = "档案ID", dataType = "Long", required = false)
    })
    @GetMapping("/getQueryCondition")
    public JSONPObject getQueryCondition() {
        List<Map> reservaManage = dictionaryInfoService.getByDictionaryBycatalogNameOrCode("ReservaManage", MerchantManageEnum.ReservaManage.UNKNOWN.getValue());//预订状态
        List<Map> bookingChannel = dictionaryInfoService.getByDictionaryBycatalogNameOrCode("BookingChannel", MerchantManageEnum.BookingChannel.UNKNOWN.getValue());//预订来源
        List<Map> bookingType = dictionaryInfoService.getByDictionaryBycatalogNameOrCode("BookingType", MerchantManageEnum.BookingType.UNKNOWN.getValue());//预订方式

        //筛选条件加入全部这个状态
        Map statuMap = new HashMap();
        statuMap.put("name", "全部");
        statuMap.put("value", "");

        reservaManage.add(statuMap);
        bookingChannel.add(statuMap);
        bookingType.add(statuMap);

        //查询餐次
        Map<String, Object> param = new HashMap<>();
        param.put("archiveID", this.getArchiveID());
        List<B_MealsInfoEntity> mealsInfoList = mealsInfoService.getMealsInfoEntityListByArchiveID(param);
        B_MealsInfoEntity mealsInfoEntity = new B_MealsInfoEntity();
        mealsInfoEntity.setMealName("全部");
        mealsInfoList.add(mealsInfoEntity);

        Map<String, Object> result = new HashMap<>();
        result.put("reservaManage", reservaManage);
        result.put("bookingChannel", bookingChannel);
        result.put("bookingType", bookingType);
        result.put("mealsInfoList", mealsInfoList);

        ResultData resultData = ResultData.makeSuccessResult(result);
        return getResultJSONPObject(resultData);
    }

    /**
     * @Description：查询预订餐次信息
     * @Author：Zhaolingchen
     * @Time: 2017-5-17 10:00
     * @Version 2.0.0
     */
    @ApiOperation(value = "查询预订餐次信息", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "archiveID", value = "档案ID", dataType = "Long", required = false),
            @ApiImplicitParam(paramType = "query", name = "reserveTime", value = "预订时间", dataType = "String", required = true)
    })
    @GetMapping("/getMealsInfo")
    public JSONPObject getMealsInfo(@ApiIgnore String reserveTime) throws Exception {
        Long archiveID = this.getArchiveID();

        B_MealsInfoEntity b_MealsInfoEntity = new B_MealsInfoEntity();
        Map<String, Object> param = new HashMap<>();
        param.put("archiveID", archiveID);
        //预订时间为当天，查询当前时间以后的餐次
        LocalDateTime reserveDateTime = DateUtils.parseLocalDateTime10(reserveTime);
        if (DateUtils.isSameDate(reserveDateTime, LocalDateTime.now())) {//判断是否为当天
            reserveDateTime = LocalDateTime.now();
            param.put("reserveTime", reserveDateTime);
        }
        //查询餐厅所有默认餐次信息（空区域餐次）
        List<B_MealsInfoEntity> mealsInfoList = mealsInfoService.getMealsInfoAndReserveTimeList(reserveDateTime, param);

        ResultData result = ResultData.makeSuccessResult(mealsInfoList);
        return getResultJSONPObject(result);
    }

    /**
     * @author 赵凌晨
     * @version 2.0.0
     * @description 选择餐位-查询区域
     * @time 2017-04-19 15:30:00
     */
    @ApiOperation(value = "查询区域", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "archiveID", value = "档案ID", dataType = "Long", required = false)
    })
    @GetMapping("queryReserveAreaID")
    public JSONPObject queryReserveAreaID() throws Exception {
        Long archiveID = this.getArchiveID();
        //查询所有区域
        List<B_ShopAreaInfoEntity> shopAreaInfoList = shopAreaInfoService.getShopAreaInfoListByArchiveID(archiveID);
        ResultData result = ResultData.makeSuccessResult(shopAreaInfoList);
        return getResultJSONPObject(result);
    }

    /**
     * @Description：查询可预订的桌台
     * @Author：Zhaolingchen
     * @Time: 2017-5-17 10:00
     * @Version 2.0.0
     */
    @ApiOperation(value = "查询可预订的桌台", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "archiveID", value = "档案ID", dataType = "Long", required = false),
            @ApiImplicitParam(paramType = "query", name = "reserveTime", value = "预订时间", dataType = "Long", required = true),
            @ApiImplicitParam(paramType = "query", name = "duration", value = "就餐时长", dataType = "Integer", required = true),
            @ApiImplicitParam(paramType = "query", name = "areaID", value = "区域ID", dataType = "Long", required = false)
    })
    @GetMapping("/getMayBookingTableList")
    public JSONPObject getMayBookingTableList(@ApiIgnore String reserveTime, @ApiIgnore Integer duration, @ApiIgnore Long areaID) throws Exception {
        Long archiveID = this.getArchiveID();
        Map<String, Object> param = new HashMap<>();
        param.put("archiveID", archiveID);
        param.put("reserveTime", DateUtils.parseLocalDateTime(reserveTime));
        param.put("duration", duration);
        param.put("areaID", areaID);
        List<B_DinningTableInfoEntity> dinningTableInfoList = dinningTableInfoService.getDinningTableInfoListByBooking(param);
        ResultData result = ResultData.makeSuccessResult(dinningTableInfoList);
        return getResultJSONPObject(result);
    }

    /**
     * @Description：查询用户偏好桌
     * @Author：Zhaolingchen
     * @Time: 2017-5-17 10:00
     * @Version 2.0.0
     */
    @ApiOperation(value = "查询用户偏好桌", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "archiveID", value = "档案ID", dataType = "Long", required = false),
            @ApiImplicitParam(paramType = "query", name = "loginID", value = "登录ID", dataType = "Long", required = true)
    })
    @GetMapping("/getPreferenceDinningTableList")
    public JSONPObject getPreferenceDinningTableList(@ApiIgnore Long loginID) throws Exception {
        Long archiveID = this.getArchiveID();
        Map<String, Object> param = new HashMap<>();
        param.put("archiveID", archiveID);
        param.put("loginID", loginID);
        List<B_DinningTableInfoEntity> dinningTableInfoList = dinningTableInfoService.getPreferenceDinningTableInfo(param);
        ResultData result = ResultData.makeSuccessResult(dinningTableInfoList);
        return getResultJSONPObject(result);
    }

    /**
     * @author Zhaolingcen
     * @version 2.0.0
     * @description 获取桌台预订信息状态信息
     * @time 2017-05-20 11:00:00
     */
    @ApiOperation(value = "获取桌台预订信息状态信息", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "archiveID", value = "档案ID", dataType = "Long", required = false),
            @ApiImplicitParam(paramType = "query", name = "areaID", value = "区域ID", dataType = "Long", required = false),
            @ApiImplicitParam(paramType = "query", name = "startTime", value = "搜索开始时间", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "query", name = "endTime", value = "搜索结束时间", dataType = "String", required = false)
    })
    @GetMapping("/getBookingTableStatus")
    public JSONPObject getBookingTableStatus(@ApiIgnore Long areaID, @ApiIgnore String startTime, @ApiIgnore String endTime) throws Exception {
        Long archiveID = this.getArchiveID();
        Map<String, Object> param = this.getParaMapNotEmpty();
        param.put("archiveID", archiveID);
        List<Map<String, Object>> dinningTableInfoList = dinningTableInfoService.getBookingTableStatus(param);
        ResultData result = ResultData.makeSuccessResult(dinningTableInfoList);
        return getResultJSONPObject(result);
    }

    /**
     * @author 赵凌晨
     * @version 2.0.0
     * @description 查询订金
     * @time 2017-05-19 14:30:00
     */
    @ApiOperation(value = "查询订金", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "archiveID", value = "档案ID", dataType = "Long", required = false),
            @ApiImplicitParam(paramType = "query", name = "peopleNum", value = "就餐人数", dataType = "Integer", required = false),
            @ApiImplicitParam(paramType = "query", name = "tableNum", value = "预订桌数", dataType = "Integer", required = false)
    })
    @GetMapping("/queryReservationFee")
    public JSONPObject queryReservationFee(@ApiIgnore Long archiveID, @ApiIgnore Integer peopleNum, @ApiIgnore Integer tableNum) throws Exception {
        Integer reservationFee = basicParamInfoService.getReservationFee(archiveID, peopleNum, tableNum);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("reservationFee", reservationFee);
        ResultData result = ResultData.makeSuccessResult(resultMap);
        return getResultJSONPObject(result);
    }

    /**
     * @author 赵凌晨
     * @version 2.0.0
     * @description 查询退款规则
     * @time 2017-05-14 9:30:00
     */
    @ApiOperation(value = "查询退款规则", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "bookingType", value = "预订方式", dataType = "Long", required = true),
            @ApiImplicitParam(paramType = "query", name = "areaID", value = "区域ID", dataType = "Long", required = false),
            @ApiImplicitParam(paramType = "query", name = "mealsID", value = "餐次ID", dataType = "Long", required = false)
    })
    @GetMapping("/queryRefundRule")
    public JSONPObject queryRefundRule(@ApiIgnore Long bookingType, @ApiIgnore Long areaID, @ApiIgnore Long mealsID) throws Exception {
        Long archiveID = this.getArchiveID();
        Map<String, Object> param = this.getParaMapNotEmpty();
        List<B_PeriodConfigInfoEntity> periodConfigInfoList = periodConfigInfoService.getPeriodConfigInfoListSort(param);

        //查询期限配置,获取保留时长
        B_ReservationTimeInfoEntity reservationTimeParam = new B_ReservationTimeInfoEntity();
        reservationTimeParam.setArchiveID(archiveID);
        reservationTimeParam.setAreaID(areaID);
        reservationTimeParam.setMealsID(mealsID);
        reservationTimeParam.setBookingType(bookingType);
        List<B_ReservationTimeInfoEntity> reservationTimeInfoList = reservationTimeInfoService.getReservationTimeInfoByWhere(reservationTimeParam);

        Integer extensionMinute = 0;
        if (reservationTimeInfoList != null && reservationTimeInfoList.size() > 0) {
            extensionMinute = reservationTimeInfoList.get(0).getExtensionMinute();
        }

        StringBuffer sb = new StringBuffer("");
        if (MerchantManageEnum.BookingType.RESERVEDSEAT.getValue() == bookingType) {
            B_BasicParamInfoEntity basicParamInfoEntity = basicParamInfoService.getBasicParamInfoByArchiveID(archiveID);
            if (basicParamInfoEntity == null) {
                ResultData result = ResultData.makeFailResult();
                return getResultJSONPObject(result);
            }
            //按人均1元收费标准支付预订留位费用，未能按时到达最长保留x分       钟，提前一小时以上取消预订，全额退还预订留位金，过期退还留       位金的80%
            if (MerchantManageEnum.ReservationType.BYPERSON.getValue() == basicParamInfoEntity.getReservationType()) {
                sb.append("按人均").append(basicParamInfoEntity.getReservationFee());
            } else if (MerchantManageEnum.ReservationType.BYTABLE.getValue() == basicParamInfoEntity.getReservationType()) {
                sb.append("按每桌").append(basicParamInfoEntity.getReservationFee());
            } else if (MerchantManageEnum.ReservationType.BYORDER.getValue() == basicParamInfoEntity.getReservationType()) {
                sb.append("按每单").append(basicParamInfoEntity.getReservationFee());
            }
            sb.append("元收费标准支付预订留位费用，未能按时到达最长保留").append(extensionMinute).append("分钟,");

            for (B_PeriodConfigInfoEntity periodConfigInfo : periodConfigInfoList) {
                sb.append("提前").append(periodConfigInfo.getDuration()).append(EnumUtil.getEnumNmae(CommonManageEnum.DurationType.class, periodConfigInfo.getTimeUnit())).append("取消预订,");
                if (periodConfigInfo.getRefundRate() == 1) {
                    sb.append("全额退还预订留位金,");
                } else {
                    sb.append("退还留位金的").append(periodConfigInfo.getRefundRate()).append("%");
                }
            }
        } else if (MerchantManageEnum.BookingType.FULLPAYMENT.getValue() == bookingType) {
            //预订点菜并支付，商家保留预订桌台及预订菜品，过期最长保留  XX分钟，提前一天及以上取消预订，全额退还支付金额，否则不            退！请知悉
            sb.append("预订点菜并支付，商家保留预订桌台及预订菜品，过期最长保留").append(extensionMinute).append("分钟,");
            for (B_PeriodConfigInfoEntity periodConfigInfo : periodConfigInfoList) {
                sb.append("提前").append(periodConfigInfo.getDuration()).append(EnumUtil.getEnumNmae(CommonManageEnum.DurationType.class, periodConfigInfo.getTimeUnit())).append("取消预订,");
                if (periodConfigInfo.getRefundRate() == 1) {
                    sb.append("全额退还预订留位金,");
                } else {
                    sb.append("退还留位金的").append(periodConfigInfo.getRefundRate()).append("%,");
                }
            }
            sb.append("请知悉");
        }

        JSONObject resultMap = new JSONObject();
        resultMap.put("msg", sb.toString());
        ResultData result = ResultData.makeSuccessResult(resultMap);
        return getResultJSONPObject(result);
    }

    /**
     * @Description：保存预订
     * @Author：Zhaolingchen
     * @Time: 2017-5-17 10:00
     * @Version 2.0.0
     */
    @ApiOperation(value = "保存预订", httpMethod = "GET")
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
            @ApiImplicitParam(paramType = "query", name = "memo", value = "备注", dataType = "String", required = false)
    })
    @RequestMapping("/saveBooking")
    public JSONPObject saveBooking(@ApiIgnore ReserveVo reserveVo) throws Exception {
        //校验参数正确性
        if (reserveVo.getPeopleNum() == null || reserveVo.getPeopleNum() <= 0) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        } else if (StringUtils.isBlank(reserveVo.getContact())) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        } else if (StringUtils.isBlank(reserveVo.getPhone())) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        } else if (StringUtils.isBlank(reserveVo.getBookingTime())) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        } else if (StringUtils.isNotBlank(reserveVo.getTableIDs()) && reserveVo.getTableIDs().split(",").length > 3) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }

        if (LocalDateTime.now().isAfter(DateUtils.parseLocalDateTime(reserveVo.getBookingTime())) || LocalDateTime.now().isEqual(DateUtils.parseLocalDateTime(reserveVo.getBookingTime()))) {
            throw new BizException(CodeMsgConstants.RESERVE_TIME_ERROR_KEY_CODE, CodeMsgConstants.RESERVE_TIME_ERROR_KEY_MSG);
        }

        reserveVo.setArchiveID(this.getArchiveID());
        reserveVo.setLoginID(getLoginID());
        O_BookingInfoEntity bookingInfo = bookingInfoService.addBookingInfo(reserveVo);
        ResultData result = ResultData.makeSuccessResult(bookingInfo);
        return getResultJSONPObject(result);
    }

    /**
     * @Description：保存预订
     * @Author：Zhaolingchen
     * @Time: 2017-5-17 10:00
     * @Version 2.0.0
     */
    @ApiOperation(value = "修改预订", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "bookingID", value = "预订单ID", dataType = "Long", required = true),
            @ApiImplicitParam(paramType = "query", name = "peopleNum", value = "人数", dataType = "Integer", required = true)
    })
    @RequestMapping("/updateBooking")
    public JSONPObject updateBooking(@ApiIgnore Long bookingID, @ApiIgnore Integer peopleNum, String memo) throws Exception {
        O_BookingInfoEntity bookingInfoEntity = bookingInfoService.updateBookingInfo(bookingID, peopleNum, memo);
        ResultData result = ResultData.makeSuccessResult(bookingInfoEntity);
        return getResultJSONPObject(result);
    }

    /**
     * @Description：取消预订
     * @Author：Zhaolingchen
     * @Time: 2017-5-17 10:00
     * @Version 2.0.0
     */
    @ApiOperation(value = "取消预订", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "bookingID", value = "预订单ID", dataType = "Long", required = true),
            @ApiImplicitParam(paramType = "query", name = "memo", value = "取消原因", dataType = "Long", required = true)
    })
    @RequestMapping("/cancelBooking")
    public JSONPObject cancelBooking(@ApiIgnore Long bookingID, @ApiIgnore String memo) throws Exception {
        UserInfoVo userInf = getCurrentUser();
        bookingInfoService.cancelBooking(bookingID, memo, userInf);

        ResultData result = ResultData.makeSuccessResult(bookingID);
        return getResultJSONPObject(result);
    }

    /**
     * @Description：退定金;对已取消的订单进行退定金,退款金额不能大于已支付定金
     * @Author：Zhaolingchen
     * @Time: 2017-5-17 10:00
     * @Version 2.0.0
     */
    @ApiOperation(value = "退定金", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "bookingID", value = "预订单ID", dataType = "Long", required = true),
            @ApiImplicitParam(paramType = "query", name = "amount", value = "需要退的订单金额", dataType = "Double", required = true),
    })
    @RequestMapping("/refundBookingAmount")
    public JSONPObject refundBookingAmount(@ApiIgnore Long bookingID, @ApiIgnore Double amount) throws Exception {
        UserInfoVo userInf = getCurrentUser();
        bookingInfoService.refundBookingAmount(bookingID, amount);
        ResultData result = ResultData.makeSuccessResult(bookingID);
        return getResultJSONPObject(result);
    }

    /**
     * @Description：查询预订单详情
     * @Author：Zhaolingchen
     * @Time: 2017-5-17 10:00
     * @Version 2.0.0
     */
    @ApiOperation(value = "查询预订单详情", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "bookingID", value = "预订单ID", dataType = "Long", required = true)
    })
    @GetMapping("/getBookingDetail")
    public JSONPObject getBookingDetail(@ApiIgnore Long bookingID) throws Exception {
        //查询预订详情信息
        O_BookingInfoEntity bookingDetailInfo = bookingInfoService.getBookingDetailInfo(bookingID);

        if (bookingDetailInfo == null) {
            throw new BizException(CodeMsgConstants.ORDER_NOT_EXIST_ERROR_KEY_CODE, CodeMsgConstants.ORDER_NOT_EXIST_ERROR_KEY_MSG);
        }

        JSONObject result = new JSONObject();
        result.put("bookingDetail", bookingDetailInfo);

        Map<String, Object> param = new HashMap<>();
        param.put("mobile", bookingDetailInfo.getMobile());
        param.put("archiveID", bookingDetailInfo.getArchiveID());

        if (bookingDetailInfo.getBookingType() == MerchantManageEnum.BookingType.FULLPAYMENT.getValue()) {
            //查询子订单信息
            List<O_SubOrderInfoEntity> subOrderInfoList = subOrderInfoService.queryByOrderID(bookingDetailInfo.getOrderID());
            if (subOrderInfoList != null && subOrderInfoList.size() > 0) {
                //查询每桌点的菜品信息
                List<Map<String, Object>> orderDetailInfoList = new ArrayList<>();
                for (O_SubOrderInfoEntity subOrderInfo : subOrderInfoList) {
                    Map<String, Object> tableOrderDetail = new HashMap<>();
                    tableOrderDetail.put("tableName", subOrderInfo.getTableName());
                    tableOrderDetail.put("orderDetail", orderDetailInfoService.queryOrderDetailBySubOrderID(subOrderInfo.getSubOrderID()));
                    orderDetailInfoList.add(tableOrderDetail);
                }
                result.put("tableOrderDetail", orderDetailInfoList);
            }
        }

        ResultData resultData = ResultData.makeSuccessResult(result);
        return getResultJSONPObject(resultData);
    }

    /**
     * @Description：查询预订支付信息
     * @Author：Zhaolingchen
     * @Time: 2017-5-17 10:00
     * @Version 2.0.0
     */
    @ApiOperation(value = "预订支付查询", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "bookingID", value = "预订单ID", dataType = "Long", required = true)
    })
    @GetMapping("/getBookingPaymentInfo")
    public JSONPObject getBookingPaymentInfo(@ApiIgnore Long bookingID) throws Exception {
        //查询预订详情信息
        O_BookingInfoEntity bookingDetailInfo = bookingInfoService.getBookingDetailInfo(bookingID);

        if (bookingDetailInfo == null) {
            throw new BizException(CodeMsgConstants.ORDER_NOT_EXIST_ERROR_KEY_CODE, CodeMsgConstants.ORDER_NOT_EXIST_ERROR_KEY_MSG);
        }

        //查询预订资金变动,获取已支付定金
        F_FundChangeInfoEntity fundChangeInfo = bookingInfoService.getBookingFundChangeInfo(bookingID);
        if (fundChangeInfo != null && fundChangeInfo.getChangeAmount() != null) {
            bookingDetailInfo.setPaidAmount(fundChangeInfo.getChangeAmount());//已付金额
        }

        JSONObject result = new JSONObject();
        result.put("bookingDetail", bookingDetailInfo);
        result.put("tableOrderDetail", new JSONArray());
        Map<String, Object> param = new HashMap<>();
        param.put("mobile", bookingDetailInfo.getMobile());
        param.put("archiveID", bookingDetailInfo.getArchiveID());

        if (bookingDetailInfo.getBookingType() == MerchantManageEnum.BookingType.FULLPAYMENT.getValue()) {
            //查询子订单信息
            List<O_SubOrderInfoEntity> subOrderInfoList = subOrderInfoService.getSubOrderInfoByOrderID(bookingDetailInfo.getOrderID());
            //查询每桌点的菜品信息

            for (O_SubOrderInfoEntity subOrderInfo : subOrderInfoList) {
                Map<String, Object> tableOrderDetail = new HashMap<>();
                tableOrderDetail.put("tableName", subOrderInfo.getTableName());
                tableOrderDetail.put("orderDetail", orderDetailInfoService.queryOrderDetailBySubOrderID(subOrderInfo.getSubOrderID()));
                result.getJSONArray("tableOrderDetail").add(tableOrderDetail);
            }
        }
        ResultData resultData = ResultData.makeSuccessResult(result);
        return getResultJSONPObject(resultData);
    }

    /**
     * @Description：查询用户档案信息
     * @Author：Zhaolingchen
     * @Time: 2017-5-17 10:00
     * @Version 2.0.0
     */
    @ApiOperation(value = "查询用户档案信息", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "mobile", value = "手机号", dataType = "String", required = true)
    })
    @GetMapping("/getMemberRecordInfo")
    public JSONPObject getMemberRecordInfo() {
        Map<String, Object> param = new HashMap<>();
        param.put("mobile", this.getString("mobile"));
        //查询用户档案详情
        Map<String, Object> memberInfoMap = memberInfoService.getMemberRecordInfoByMobile(param);

        if (memberInfoMap == null) {//没有该用户信息
            ResultData resultData = ResultData.makeFailResult();
            return getResultJSONPObject(resultData);
        }
        param.put("archiveID", this.getArchiveID());

        JSONObject result = new JSONObject();
        //查询用户预订记录
        List<O_BookingInfoEntity> bookingRecord = bookingInfoService.getMemberBookingRecordInfo(param);
        //查询用户消费记录
        param = new HashMap<>();
        param.put("customerID", memberInfoMap.get("customerID"));
        List<Map<String, Object>> consumeRecord = orderInfoService.getConsumeRecordInfo(param);
        //查询用户点菜偏好
        List<Map<String, Object>> orderDishesRecord = bookingInfoService.getOrderDishesRecordInfo(param);
        //查询口味偏好
        param = new HashMap<>();
        param.put("mobile", this.getString("mobile"));
        List<Map<String, Object>> orderTasteRecord = bookingInfoService.getOrderTasteRecordInfo(param);

        result.put("memberInfo", memberInfoMap);
        result.put("orderTasteRecord", orderTasteRecord);
        result.put("memberInfo", memberInfoMap);
        result.put("bookingRecord", bookingRecord);
        result.put("consumeRecord", consumeRecord);
        result.put("orderDishesRecord", orderDishesRecord);

        ResultData resultData = ResultData.makeSuccessResult(result);
        return getResultJSONPObject(resultData);
    }

    /**
     * @Description：查询退定金页面信息
     * @Author：Zhaolingchen
     * @Time: 2017-5-17 10:00
     * @Version 2.0.0
     */
    @ApiOperation(value = "查询退定金页面信息", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "bookingID", value = "预订单ID", dataType = "Long", required = true)
    })
    @RequestMapping("/queryRefundInfo")
    public JSONPObject queryRefundInfo(@ApiIgnore Long bookingID) throws Exception {
        //查询预订详情信息
        O_BookingInfoEntity bookingInfoEntity = bookingInfoService.selectByPrimaryKey(bookingID);

        if (bookingInfoEntity == null) {
            throw new BizException(CodeMsgConstants.ORDER_NOT_EXIST_ERROR_KEY_CODE, CodeMsgConstants.ORDER_NOT_EXIST_ERROR_KEY_MSG);
        }
        if (bookingInfoEntity.getBookingStatus() != MerchantManageEnum.ReservaManage.CANCELED.getValue() && bookingInfoEntity.getBookingStatus() != MerchantManageEnum.ReservaManage.EXPIRED.getValue()) {
            throw new BizException(CodeMsgConstants.NOT_REFUND_AMOUNT_CODE, CodeMsgConstants.NOT_REFUND_AMOUNT_MSG);
        }

        ResultData resultData = ResultData.makeSuccessResult(bookingInfoEntity);
        return getResultJSONPObject(resultData);
    }


    /**
     * @Description：保存预订后查询预订详情信息
     * @Author：Zhaolingchen
     * @Time: 2017-6-1 17:00
     * @Version 2.0.0
     */
    @ApiOperation(value = "保存预订后查询预订详情信息", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "bookingID", value = "预订单ID", dataType = "Long", required = true)
    })
    @RequestMapping("/returnBookingDetail")
    public JSONPObject returnBookingDetail(@ApiIgnore Long bookingID) throws Exception {
        //查询预订详情信息
        O_BookingInfoEntity bookingDetailInfo = bookingInfoService.selectByPrimaryKey(bookingID);

        if (bookingDetailInfo == null) {
            throw new BizException(CodeMsgConstants.ORDER_NOT_EXIST_ERROR_KEY_CODE, CodeMsgConstants.ORDER_NOT_EXIST_ERROR_KEY_MSG);
        }

        B_MerchantInfoEntity merchantInfoEntity = merchantInfoService.getMerchantInfoOrgByArchiveID(bookingDetailInfo.getArchiveID());
        bookingDetailInfo.setMerchantName(merchantInfoEntity.getMerchantName());
        bookingDetailInfo.setManagerPhone(merchantInfoEntity.getManagerPhone());
        bookingDetailInfo.setPostalAddress(merchantInfoEntity.getPostalAddress());

        ResultData resultData = ResultData.makeSuccessResult(bookingDetailInfo);
        return getResultJSONPObject(resultData);
    }

    /**
     * @author 赵凌晨
     * @version 2.0.0
     * @description 取消预定时查询退款比例
     * @time 2017-05-14 9:30:00
     */
    @ApiOperation(value = "取消预定时查询退款比例", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "bookingID", value = "档案ID", dataType = "Long", required = false)
    })
    @GetMapping("/queryRefundScale")
    public JSONPObject queryRefundScale(@ApiIgnore Long bookingID) throws Exception {
        JSONObject resultMap = new JSONObject();
        //查询预订详情信息
        O_BookingInfoEntity bookingInfo = bookingInfoService.selectByPrimaryKey(bookingID);

        B_PeriodConfigInfoEntity periodConfigInfo = bookingInfoService.getRefundRule(bookingInfo);

        StringBuffer sb = new StringBuffer("");
        if (periodConfigInfo == null) {
            resultMap.put("scale", 1);
            sb.append("注:取消预定,退定金").append(bookingInfo.getBookingAmount()).append(",点击\"下一步\"退定金");
        } else if (periodConfigInfo.getRefundRate() == 0) {
            resultMap.put("scale", periodConfigInfo.getRefundRate());
            sb.append("注:取消预定没有提前").append(periodConfigInfo.getDuration()).append(EnumUtil.getEnumNmae(CommonManageEnum.DurationType.class, periodConfigInfo.getTimeUnit())).append(",定金").append(bookingInfo.getBookingAmount()).append("不退");
        } else {

            sb.append("注:提前").append(periodConfigInfo.getDuration()).append(EnumUtil.getEnumNmae(CommonManageEnum.DurationType.class, periodConfigInfo.getTimeUnit())).append(",退定金").append(bookingInfo.getBookingAmount().multiply(BigDecimal.valueOf(periodConfigInfo.getRefundRate()))).append(",点击\"下一步\"退定金");
        }

        List<String> causeList = new ArrayList<>();
        causeList.add("计划变更");
        causeList.add("时间来不及");
        causeList.add("听说你们家不好");

        resultMap.put("msg", sb.toString());
        resultMap.put("cause", causeList);
        ResultData result = ResultData.makeSuccessResult(resultMap);
        return getResultJSONPObject(result);
    }
    /**
     * 判断是否营业
     * @return
     */
    private boolean isBusiness(Long archiveID,LocalDateTime reserveDateTim){
        //判断预定的日期是在营业日
        B_BasicParamInfoEntity basicParamInfoEntity = basicParamInfoService.getBasicParamInfoByArchiveID(archiveID);
        if(basicParamInfoEntity == null || StringUtils.isBlank(basicParamInfoEntity.getWeekDay())){
            return true;
        }
        //获取周营业日:周日到周六，对应0到6的字符串，有对应日期表示营业
        String weekDay = basicParamInfoEntity.getWeekDay();
        //获取预订时间为周几
        int week = reserveDateTim.getDayOfWeek().getValue();
        if(week == 7){//如果是周日,对应营业日为0
            week = 0;
        }
        if(weekDay.indexOf(String.valueOf(week)) == -1){
            return false;
        }
        return true;
    }
}
