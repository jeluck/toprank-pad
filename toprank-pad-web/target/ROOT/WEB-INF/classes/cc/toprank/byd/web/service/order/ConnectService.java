package cc.toprank.byd.web.service.order;

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.common.utils.DateUtils;
import cc.toprank.byd.common.utils.MapHelper;
import cc.toprank.byd.component.PrintComponent;
import cc.toprank.byd.dao.B_WorkingInfoDao;
import cc.toprank.byd.dao.CommonMapper;
import cc.toprank.byd.dto.common.MerchantBusinessDTO;
import cc.toprank.byd.entity.B_WorkingInfoEntity;
import cc.toprank.byd.util.MaxIDUtils;
import cc.toprank.byd.vo.print.AmountInfoVO;
import cc.toprank.byd.vo.print.PaymentDetailVO;
import cc.toprank.byd.vo.print.TransDetailVO;
import cc.toprank.byd.web.service.payment.MerchantFeeInfoService;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author LiSH
 * @version 2.0.0
 * @description 交接班-接口服务
 * @time 2017-5-27 14:15
 */
@Service
public class ConnectService {

    public static final Logger LOGGER = LoggerFactory.getLogger(ConnectService.class);

    @Autowired
    private B_WorkingInfoDao workingInfoDao;
    @Autowired
    private PrintComponent printComponent;
    @Autowired
    private MerchantFeeInfoService merchantFeeInfoService;

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 开班
     * @time 2017-5-26 10:05
     */
    public Map<String, Object> startWorking(Map param) {
        //1.根据当前人和收银机获得当前交接班信息(开班记录)
        Map<String, Object> workingInfoMap = workingInfoDao.getWorkingInfo(param);
        if (workingInfoMap == null) {
            //2.1 查询上一开班信息
            Map<String, Object> beforeWorkingInfoMap = workingInfoDao.getBeforeWorkingInfo(param);
            Long casherID = MapUtils.getLong(param, "casherID");
            Long loginID = MapUtils.getLong(param, "loginID");
            String casherCode = MapUtils.getString(param, "casherCode");
            String loginName = MapUtils.getString(param, "loginName");
            BigDecimal moneyAmount = new BigDecimal(MapUtils.getDouble(param, "moneyAmount", -1D));
            if (moneyAmount.compareTo(new BigDecimal(0)) < 0) {
                BizException.error(4, "备用金金额有误");
            }
            Long archiveID = MapUtils.getLong(param, "archiveID");
            //2.2 插入开班记录
            B_WorkingInfoEntity b_workingInfoEntity = new B_WorkingInfoEntity();
            b_workingInfoEntity.setWorkingID(MaxIDUtils.getID(b_workingInfoEntity));
            b_workingInfoEntity.setSettlementType(1115L);
            b_workingInfoEntity.setArchiveID(archiveID);
            b_workingInfoEntity.setBeforeID(MapUtils.getLong(beforeWorkingInfoMap, "workingID"));
            b_workingInfoEntity.setWorkingType(0L);//字典 收银/厨师/点菜
            b_workingInfoEntity.setIsMappingDeivce(true);
            b_workingInfoEntity.setDeviceType(0L);//关联的设备编号 收银机/移动收银机
            b_workingInfoEntity.setDeviceID(casherID);
            b_workingInfoEntity.setDeviceCode(casherCode);
            b_workingInfoEntity.setMoneyAmount(moneyAmount);
            b_workingInfoEntity.setIsNormalWorking(true);
            b_workingInfoEntity.setWorkingDesc(loginName + "开班,备用金(" + moneyAmount + ")");
            b_workingInfoEntity.setWorkingStatus(9L); //正常工作状况
            b_workingInfoEntity.setCreatorID(loginID);
            b_workingInfoEntity.setCreatorName(loginName);
            b_workingInfoEntity.setCreateTime(LocalDateTime.now());

            workingInfoDao.insertSelective(b_workingInfoEntity);
        } else {
            BizException.error(3, "当前存在未交班的班次!,请先交班");
        }
        return null;
    }


    /**
     * @author LiSH
     * @version 2.0.0
     * @description 获得交接班详细信息
     * @time 2017-5-26 10:05
     */
    public Map<String, Object> getConnectData(Map param) throws Exception {
        //1.根据当前人和收银机获得当前交接班信息(开班记录)
        Map<String, Object> workingInfoMap = workingInfoDao.getWorkingInfo(param);
        if (workingInfoMap == null) {
            BizException.error(2, "找不到对应的开班记录,请先开班");
        }
        return getConnectDataDetail(MapHelper.put("workingID", MapUtils.getLong(workingInfoMap, "workingID")).toMap(), false);
    }


    /**
     * @author LiSH
     * @version 2.0.0
     * @description 获得交接班详细信息 根据workingID
     * @time 2017-5-26 10:05
     */
    public Map<String, Object> getConnectDataByWorkingID(Map param) throws Exception {
        return getConnectDataDetail(param, true);
    }


    /**
     * @author LiSH
     * @version 2.0.0
     * @description 获得交接班数据详情 根据workingID
     * @time 2017-5-27 11:27
     */
    private Map<String, Object> getConnectDataDetail(Map<String, Object> param, Boolean endTimeFlag) throws Exception {
        Map<String, Object> workingInfoMap = workingInfoDao.getWorkingInfoByWorkingID(param);
        LocalDateTime startTime = (LocalDateTime) workingInfoMap.get("createTime");
        Long archiveID = MapUtils.getLong(workingInfoMap, "archiveID");
        LocalDateTime endTime;
        if (endTimeFlag) {
            endTime = (LocalDateTime) workingInfoMap.get("workOffTime");
        } else {
            endTime = LocalDateTime.now();
        }
        Map<String, Object> paramMap = MapHelper.put("archiveID", archiveID).put("startTime", startTime).put("orderStatus", 68).put("endTime", endTime).toMap();

        Map<String, Object> businessStatistics = getBusinessStatistics(paramMap);

        Map<String, Object> mealsInfoMap = workingInfoDao.getMealsInfo(paramMap);
        String mealsName = MapUtils.getString(mealsInfoMap, "mealsName", "未设置");

        workingInfoMap.put("mealsName", mealsName);
        workingInfoMap.put("endTime", endTime);
        workingInfoMap.put("businessStatistics", businessStatistics);
        return workingInfoMap;
    }

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 获得营业统计 archiveID orderStatus startTime endTime
     * @time 2017-6-6 11:15
     */
    public Map<String, Object> getBusinessStatistics(Map paramMap) throws Exception {
        paramMap.put("orderStatus", 68);
        //餐厅支付方式统计
        List<Map<String, Object>> payMethodList = workingInfoDao.getPayMethod(paramMap);
        //营业总计
        //查询时间段所有的子订单 以及 服务费
        List<Long> subOrderIDList = workingInfoDao.getSubOrderIDList(paramMap);
        BigDecimal subOrderTotalFee = merchantFeeInfoService.getMerchantFee(MapUtils.getLong(paramMap, "archiveID"), subOrderIDList);
        Map<String, Object> workingMoneyMap = workingInfoDao.getWorkingMoney(paramMap);
        workingMoneyMap.put("fuwuAmount",subOrderTotalFee);
        //订单收款
        List<Map<String, Object>> orderMoneyList = workingInfoDao.getOrderMoney(paramMap);
        //会员充值
        List<Map<String, Object>> memberMoneyList = workingInfoDao.getMemberMoney(paramMap);
        //预收定金
        List<Map<String, Object>> bookingMoneyList = workingInfoDao.getBookingMoney(paramMap);
        //退订
        List<Map<String, Object>> unSubscribeMoneyList = workingInfoDao.getUnsubscribeMoney(paramMap);

        Map<String, Object> resultMap = MapHelper.newMap();
        resultMap.put("workingMoney", workingMoneyMap);
        resultMap.put("orderMoney", handlerMoneyMap(payMethodList, orderMoneyList));

        //会员统计
        List<Map<String, Object>> memberList = handlerMoneyMap(payMethodList, memberMoneyList);
        double presentMoney = memberList.stream().mapToDouble(map -> MapUtils.getDouble(map, "presentMoney", 0D)).sum();
        double presentNum = memberList.stream().mapToDouble(map -> MapUtils.getDouble(map, "presentNum", 0D)).sum();
        memberList.add(MapHelper.put("payMethodName", "赠送金额").put("amount", presentMoney).put("num", presentNum).toMap());
        resultMap.put("memberMoney", memberList);
        resultMap.put("bookingMoney", handlerMoneyMap(payMethodList, bookingMoneyList));
        resultMap.put("unSubscribeMoney", handlerMoneyMap(payMethodList, unSubscribeMoneyList));
        return resultMap;
    }

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 保存交接班
     * @time 2017-5-26 10:05
     */
    public Map<String, Object> saveWorking(Map param) throws Exception {
        //1.根据当前人和收银机获得当前交接班信息(开班记录)
        Map<String, Object> workingInfoMap = getConnectData(param);
        Map<String, Object> businessStatistics = (Map<String, Object>) workingInfoMap.get("businessStatistics");
        Long workingID = MapUtils.getLong(workingInfoMap, "workingID");
        B_WorkingInfoEntity b_workingInfoEntity = workingInfoDao.selectByPrimaryKey(workingID);

        Map<String, Object> workingMoney = (Map<String, Object>) businessStatistics.get("workingMoney");
        List<Map<String, Object>> orderMoney = (List<Map<String, Object>>) businessStatistics.get("orderMoney");
        List<Map<String, Object>> memberMoney = (List<Map<String, Object>>) businessStatistics.get("memberMoney");
        List<Map<String, Object>> bookingMoney = (List<Map<String, Object>>) businessStatistics.get("bookingMoney");
        List<Map<String, Object>> unSubscribeMoney = (List<Map<String, Object>>) businessStatistics.get("unSubscribeMoney");


        b_workingInfoEntity.setWorkOffTime(LocalDateTime.now());
        b_workingInfoEntity.setOrderNum(MapUtils.getInteger(orderMoney.get(orderMoney.size() - 1), "num"));
        b_workingInfoEntity.setOrderTotalAmount(new BigDecimal(MapUtils.getDouble(orderMoney.get(orderMoney.size() - 1), "amount", 0D)));

        b_workingInfoEntity.setRechargeNum(MapUtils.getInteger(memberMoney.get(orderMoney.size() - 1), "num"));
        b_workingInfoEntity.setRechargeTotalAmount(new BigDecimal(MapUtils.getDouble(memberMoney.get(orderMoney.size() - 2), "amount", 0D)));

        b_workingInfoEntity.setBookingNum(MapUtils.getInteger(bookingMoney.get(orderMoney.size() - 1), "num"));
        b_workingInfoEntity.setBookingTotalAmount(new BigDecimal(MapUtils.getDouble(bookingMoney.get(orderMoney.size() - 1), "amount", 0D)));

        b_workingInfoEntity.setRepaymentNum(MapUtils.getInteger(unSubscribeMoney.get(orderMoney.size() - 1), "num"));
        b_workingInfoEntity.setRepaymentTotalAmount(new BigDecimal(MapUtils.getDouble(unSubscribeMoney.get(orderMoney.size() - 1), "amount", 0D)));

        b_workingInfoEntity.setIncomeTotalAmount(new BigDecimal(MapUtils.getDouble(workingMoney, "shoukuanAmount")));
//        b_workingInfoEntity.setIncomeCashAmount();
//        b_workingInfoEntity.setCashTotalAmount();
        workingInfoDao.updateByPrimaryKeySelective(b_workingInfoEntity);
        return null;
    }


    /**
     * @author LiSH
     * @version 2.0.0
     * @description 获得交接班次列表
     * @time 2017-5-27 9:58
     */
    public Map<String, Object> getWorkingList(Map param) {
        param.put("settlementType", 1115L);//只查询交接班类型的数据
        List<Map<String, Object>> workingList = workingInfoDao.getWorkingList(param);
        return MapHelper.put("workingList", workingList).toMap();
    }

    //内部方法 根据支付方式组成Map
    private List<Map<String, Object>> handlerMoneyMap(List<Map<String, Object>> payMethodList, List<Map<String, Object>> targetMapList) {
        List<Map<String, Object>> resultList = deepCopyList(payMethodList);
        Integer totalNum = 0;
        Double totalAmount = 0D;
        for (Map<String, Object> item : targetMapList) {
            String payMethodID = MapUtils.getString(item, "payMethodID");
            boolean flag = false;
            for (Map<String, Object> item2 : resultList) {
                String payMethodID2 = MapUtils.getString(item2, "payMethodID");
                Integer num = MapUtils.getInteger(item, "num");
                Double amount = MapUtils.getDouble(item, "amount");
                if (payMethodID2.equals(payMethodID)) {
                    item2.putAll(item);
                    totalNum += num;
                    totalAmount += amount;
                    flag = true;
                }
            }
            if (!flag) {
                Integer num = MapUtils.getInteger(item, "num");
                Double amount = MapUtils.getDouble(item, "amount");
                if (num > 0) {
                    totalNum += num;
                    totalAmount += amount;
                    String payMethodName = workingInfoDao.getPayMethodNameByPayMethodID(payMethodID);
                    item.put("payMethodName", payMethodName == null ? "未知" : payMethodName);
                    resultList.add(item);
                }
            }
        }
        Map<String, Object> totalMap = MapHelper.put("num", totalNum).put("amount", totalAmount).put("payMethodID", 0).put("payMethodName", "全部").toMap();
        resultList.add(totalMap);
        return resultList;
    }

    //内部方法，深度复制,List装载的对象需实现序列化接口
    @SuppressWarnings("unchecked")
    public static <T> List<T> deepCopyList(List<T> src) {

        List<T> dest = null;
        if (null != src) {
            try {
                ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
                ObjectOutputStream out = new ObjectOutputStream(byteOut);
                out.writeObject(src);
                ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
                ObjectInputStream in = new ObjectInputStream(byteIn);
                dest = (List<T>) in.readObject();
            } catch (IOException e) {
                LOGGER.error("深度复制List发生IO异常：" + e.getMessage());
            } catch (ClassNotFoundException e) {
                LOGGER.error("深度复制List发生Class Not found异常：" + e.getMessage());
            }
        }

        return dest;
    }


    /**
     * @author LiSH
     * @version 2.0.0
     * @description 某台收银机的日结信息
     * @time 2017-6-12 11:14
     */
    public Map<String, Object> addDailyWorking(Map<String, Object> paraMap) throws Exception {
        //获得 startTime , endTime 时间段内的日结记录
        MerchantBusinessDTO merchantBusinessDate = CommonMapper.getMerchantBusinessDate(paraMap);
        if (merchantBusinessDate == null) {
            BizException.error(6, "请先配置餐厅营业时间段!");
        }
        LocalTime openTime = merchantBusinessDate.getOpenTime().toLocalTime();
        LocalTime closeTime = merchantBusinessDate.getCloseTime().toLocalTime();
        LocalTime nowTime = LocalTime.now();
        if (!(nowTime.isBefore(openTime) && nowTime.isAfter(closeTime))) {
            BizException.error(4, "当前处于营业时间,无法日结");
        }
        LocalDate now = LocalDate.now();
        paraMap.put("startTime", DateUtils.getDayStart(now));
        paraMap.put("endTime", DateUtils.getDayEnd(now));
        //检查当天是否所有订单已完结
        Map<String, Object> orderMap = workingInfoDao.getDailyCloseOrderCount(paraMap);
        int payCount = MapUtils.getIntValue(orderMap, "payCount");
        int noPayCount = MapUtils.getIntValue(orderMap, "noPayCount");
        if (payCount != noPayCount) {
            BizException.error(5, "当前存在未结账的单,无法日结");
        }
        //检查当天是否日结
        List<Map<String, Object>> workingList = workingInfoDao.getDailyWorkingList(paraMap);
        if (workingList.size() == 0) {
            Long archiveID = MapUtils.getLong(paraMap, "archiveID");
            Long casherID = MapUtils.getLong(paraMap, "casherID");
            String casherCode = MapUtils.getString(paraMap, "casherCode");
            Long loginID = MapUtils.getLong(paraMap, "loginID");
            String loginName = MapUtils.getString(paraMap, "loginName");
            //添加一条日结记录
            B_WorkingInfoEntity b_workingInfoEntity = new B_WorkingInfoEntity();
            b_workingInfoEntity.setWorkingID(MaxIDUtils.getID(b_workingInfoEntity));
            b_workingInfoEntity.setSettlementType(1116L);
            b_workingInfoEntity.setSettlementMethod(1118L);
            b_workingInfoEntity.setArchiveID(archiveID);
            b_workingInfoEntity.setWorkingType(0L);//字典 收银/厨师/点菜
            b_workingInfoEntity.setIsMappingDeivce(true);
            b_workingInfoEntity.setDeviceType(0L);//关联的设备编号 收银机/移动收银机
            b_workingInfoEntity.setDeviceID(casherID);
            b_workingInfoEntity.setDeviceCode(casherCode);
            b_workingInfoEntity.setIsNormalWorking(true);
            b_workingInfoEntity.setWorkingDesc("这是一条日结记录");
            b_workingInfoEntity.setWorkingStatus(9L); //正常工作状况
            b_workingInfoEntity.setCreatorID(loginID);
            b_workingInfoEntity.setCreatorName(loginName);
            LocalDateTime localDateTime = LocalDateTime.now();
            b_workingInfoEntity.setCreateTime(localDateTime);
            b_workingInfoEntity.setWorkOffTime(localDateTime);

            Map<String, Object> businessStatistics = getBusinessStatistics(paraMap);
            Map<String, Object> workingMoney = (Map<String, Object>) businessStatistics.get("workingMoney");
            List<Map<String, Object>> orderMoney = (List<Map<String, Object>>) businessStatistics.get("orderMoney");
            List<Map<String, Object>> memberMoney = (List<Map<String, Object>>) businessStatistics.get("memberMoney");
            List<Map<String, Object>> bookingMoney = (List<Map<String, Object>>) businessStatistics.get("bookingMoney");
            List<Map<String, Object>> unSubscribeMoney = (List<Map<String, Object>>) businessStatistics.get("unSubscribeMoney");


            b_workingInfoEntity.setWorkOffTime(LocalDateTime.now());
            b_workingInfoEntity.setOrderNum(MapUtils.getInteger(orderMoney.get(orderMoney.size() - 1), "num"));
            b_workingInfoEntity.setOrderTotalAmount(new BigDecimal(MapUtils.getDouble(orderMoney.get(orderMoney.size() - 1), "amount", 0D)));

            b_workingInfoEntity.setRechargeNum(MapUtils.getInteger(memberMoney.get(orderMoney.size() - 1), "num"));
            b_workingInfoEntity.setRechargeTotalAmount(new BigDecimal(MapUtils.getDouble(memberMoney.get(orderMoney.size() - 1), "amount", 0D)));

            b_workingInfoEntity.setBookingNum(MapUtils.getInteger(bookingMoney.get(orderMoney.size() - 1), "num"));
            b_workingInfoEntity.setBookingTotalAmount(new BigDecimal(MapUtils.getDouble(bookingMoney.get(orderMoney.size() - 1), "amount", 0D)));

            b_workingInfoEntity.setRepaymentNum(MapUtils.getInteger(unSubscribeMoney.get(orderMoney.size() - 1), "num"));
            b_workingInfoEntity.setRepaymentTotalAmount(new BigDecimal(MapUtils.getDouble(unSubscribeMoney.get(orderMoney.size() - 1), "amount", 0D)));

            b_workingInfoEntity.setIncomeTotalAmount(new BigDecimal(MapUtils.getDouble(workingMoney, "shoukuanAmount")));

            workingInfoDao.insertSelective(b_workingInfoEntity);

        } else {
            BizException.error("当天已存在日结数据");
        }
        return null;
    }

    public Map<String, Object> getDailyWorkingList(Map param) {
        List<Map<String, Object>> workingList = workingInfoDao.getDailyWorkingList(param);
        return MapHelper.put("workingList", workingList).toMap();
    }

    public Map<String, Object> getDailyWorkingDetail(Map param) throws Exception {
        Map<String, Object> resultMap = MapHelper.newMap();
        Long workingID = MapUtils.getLong(param, "workingID");
        LocalDate now = LocalDate.now();
        String loginName = MapUtils.getString(param, "loginName");
        String casherCode = MapUtils.getString(param, "casherCode");
        if (workingID != null) {
            B_WorkingInfoEntity b_workingInfoEntity = workingInfoDao.selectByPrimaryKey(workingID);
            now = b_workingInfoEntity.getCreateTime().toLocalDate();
            loginName = b_workingInfoEntity.getCreatorName();
            casherCode = b_workingInfoEntity.getDeviceCode();
        }
        param.put("startTime", DateUtils.getDayStart(now));
        param.put("endTime", DateUtils.getDayEnd(now));
        Map<String, Object> businessStatistics = getBusinessStatistics(param);

        resultMap.put("businessDate", now);
        resultMap.put("loginName", loginName);
        resultMap.put("casherCode", casherCode);
        resultMap.put("businessStatistics", businessStatistics);
        return resultMap;
    }

    public Map<String, Object> checkBeforeDailyWorking(Map param) {
        Map<String, Object> resultMap = MapHelper.newMap();
        //1.查看上一个营业日是哪一天
        LocalDate now = LocalDate.now();
        MerchantBusinessDTO beforeBusinessDate = CommonMapper.getMerchantBusinessDate(param);
        String weekDay = beforeBusinessDate.getWeekDay();
        LocalDate beforeDay = getBeforeBusinessDate(now, weekDay);
        //2.是否有日结数据
        param.put("startTime", DateUtils.getDayStart(beforeDay));
        param.put("endTime", DateUtils.getDayEnd(beforeDay));
        List<Map<String, Object>> workingList = workingInfoDao.getDailyWorkingList(param);

        resultMap.put("workingListSize", workingList.size());
        resultMap.put("checkResult", workingList.size() == 0);

        return resultMap;
    }

    private LocalDate getBeforeBusinessDate(LocalDate now, String weekDay) {
        List<DayOfWeek> weekDayList = new ArrayList<>();
        LocalDate beforeDay = now.minusDays(1);
        if (StringUtils.isNotBlank(weekDay)) {
            String[] split = weekDay.split("");
            for (String s : split) {
                switch (s) {
                    case "0":
                        weekDayList.add(DayOfWeek.SUNDAY);
                        continue;
                    case "1":
                        weekDayList.add(DayOfWeek.MONDAY);
                        continue;
                    case "2":
                        weekDayList.add(DayOfWeek.TUESDAY);
                        continue;
                    case "3":
                        weekDayList.add(DayOfWeek.WEDNESDAY);
                        continue;
                    case "4":
                        weekDayList.add(DayOfWeek.THURSDAY);
                        continue;
                    case "5":
                        weekDayList.add(DayOfWeek.FRIDAY);
                        continue;
                    case "6":
                        weekDayList.add(DayOfWeek.SATURDAY);
                        continue;
                }
            }
        }
        if (weekDayList.size() > 0) {
            while (!weekDayList.contains(beforeDay.getDayOfWeek())) {
                beforeDay.minusDays(1);
            }
        }
        return beforeDay;
    }


    /**
     * @author LiSH
     * @version 2.0.0
     * @description 交接班 预打印
     * @time 2017-5-27 11:31
     */
    public Map<String, Object> prePrint(Map param) throws Exception {
        Map<String, Object> workingMap = getConnectDataByWorkingID(param);
        Map<String, Object> businessStatistics = (Map<String, Object>) workingMap.get("businessStatistics");
        Map<String, Object> workingMoney = (Map<String, Object>) businessStatistics.get("workingMoney");
        //构建打印VO
        AmountInfoVO amountInfoVO = new AmountInfoVO();
        amountInfoVO.setBusinessID(MapUtils.getLong(workingMap, "workingID"));
        amountInfoVO.setBusinessType(0L);
        amountInfoVO.setOperatorID(MapUtils.getLong(param, "loginID"));
        amountInfoVO.setArchiveID(MapUtils.getLong(workingMap, "archiveID"));
        //基础参数计算
        LocalDateTime createTime = (LocalDateTime) workingMap.get("createTime");
        BigDecimal yingshouAmount = new BigDecimal(MapUtils.getDouble(workingMoney, "yingshouAmount"));
        Integer orderNum = MapUtils.getInteger(workingMoney, "orderNum");
        Integer peopleNum = MapUtils.getInteger(workingMoney, "peopleNum");
        BigDecimal avgOrderMoney = orderNum > 0 ? yingshouAmount.divide(new BigDecimal(orderNum), 2, RoundingMode.HALF_UP) : new BigDecimal(0);
        BigDecimal avgPeopleMoney = peopleNum > 0 ? yingshouAmount.divide(new BigDecimal(peopleNum), 2, RoundingMode.HALF_UP) : new BigDecimal(0);
        Float tableTurnoverRate = 0F;
        Float tableRate = 0F;
        amountInfoVO.setTurnoverRate(tableTurnoverRate);
        amountInfoVO.setTableRate(tableRate);
        //构建打印外层对象
        amountInfoVO.setBusinessDate(createTime.toLocalDate());
        amountInfoVO.setCashRegister(MapUtils.getString(workingMap, "deviceCode"));
        amountInfoVO.setMeals(MapUtils.getString(workingMap, "mealsName"));
        amountInfoVO.setJoinTime((LocalDateTime) workingMap.get("endTime"));
        amountInfoVO.setJoinPeople(MapUtils.getString(workingMap, "creatorName"));
        amountInfoVO.setTotalQuantity(orderNum);
        amountInfoVO.setTotalAmount(yingshouAmount);
        amountInfoVO.setGiveAmount(new BigDecimal(MapUtils.getDouble(workingMoney, "zengsongAmount")));
        amountInfoVO.setDiscountAmount(new BigDecimal(MapUtils.getDouble(workingMoney, "zhekouAmount")));
        amountInfoVO.setReduceAmount(new BigDecimal(MapUtils.getDouble(workingMoney, "zhijianAmount")));
        amountInfoVO.setReduceAmount(new BigDecimal(MapUtils.getDouble(workingMoney, "zhijianAmount")));
        amountInfoVO.setServiceAmount(new BigDecimal(MapUtils.getDouble(workingMoney, "fuwuAmount")));
        amountInfoVO.setSmallAmount(new BigDecimal(MapUtils.getDouble(workingMoney, "molingAmount")));
        amountInfoVO.setActualAmount(yingshouAmount);
        amountInfoVO.setIncomeAmount(new BigDecimal(MapUtils.getDouble(workingMoney, "shoukuanAmount")));
        amountInfoVO.setInvoiceAmount(new BigDecimal(MapUtils.getDouble(workingMoney, "kaipiaoAmount")));
        amountInfoVO.setOrderCount(orderNum);
        amountInfoVO.setPeopleCount(peopleNum);
        amountInfoVO.setAvgOrderAmount(avgOrderMoney);
        amountInfoVO.setAvgPeopleAmount(avgPeopleMoney);
        //构建打印明细列表
        ArrayList<TransDetailVO> transDetailVOS = new ArrayList<>();
        //订单统计
        List<Map<String, Object>> orderMoney = (List<Map<String, Object>>) businessStatistics.get("orderMoney");
        TransDetailVO orderDetail = fillTransDetailVO(orderMoney, "收款统计");
        //会员统计
        List<Map<String, Object>> memberMoney = (List<Map<String, Object>>) businessStatistics.get("memberMoney");
        TransDetailVO memberDetail = fillTransDetailVO(memberMoney, "会员统计");
        //预定统计
        List<Map<String, Object>> bookingMoney = (List<Map<String, Object>>) businessStatistics.get("bookingMoney");
        TransDetailVO bookingDetail = fillTransDetailVO(bookingMoney, "预定统计");
        //预定退款统计
        List<Map<String, Object>> unSubscribeMoney = (List<Map<String, Object>>) businessStatistics.get("unSubscribeMoney");
        TransDetailVO unSubscribeDetail = fillTransDetailVO(unSubscribeMoney, "预定退款统计");
        transDetailVOS.add(orderDetail);
        transDetailVOS.add(memberDetail);
        transDetailVOS.add(bookingDetail);
        transDetailVOS.add(unSubscribeDetail);

        printComponent.printChangeSettleTicket(amountInfoVO, transDetailVOS);
        return null;
    }

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 构建明细对象
     * @time 2017-6-13 14:01
     */
    private TransDetailVO fillTransDetailVO(List<Map<String, Object>> orderMoney, String project) {
        TransDetailVO transDetailVO = new TransDetailVO();
        ArrayList<PaymentDetailVO> paymentDetailVOS = new ArrayList<>();
        transDetailVO.setProject(project);
        for (Map<String, Object> item : orderMoney) {
            String payMethodID = MapUtils.getString(item, "payMethodID");
            String payMethodName = MapUtils.getString(item, "payMethodName");
            Double amount = MapUtils.getDouble(item, "amount");
            Integer num = MapUtils.getInteger(item, "num");
            PaymentDetailVO paymentDetailVO = new PaymentDetailVO();
            paymentDetailVO.setPayAmount(new BigDecimal(amount));
            paymentDetailVO.setPayCount(num);
            paymentDetailVO.setPayMethod(payMethodName);
            paymentDetailVOS.add(paymentDetailVO);
        }
        transDetailVO.setPayDetails(paymentDetailVOS);
        return transDetailVO;
    }

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 日结的打印
     * @time 2017-6-13 14:20
     */
    public Map<String, Object> prePrintDailyWorking(Map<String, Object> paraMap) throws Exception {
        Map<String, Object> workingMap = getDailyWorkingDetail(paraMap);
        Map<String, Object> businessStatistics = (Map<String, Object>) workingMap.get("businessStatistics");
        Map<String, Object> workingMoney = (Map<String, Object>) businessStatistics.get("workingMoney");
        //基础参数计算
        LocalDate businessDate = (LocalDate) workingMap.get("businessDate");
        BigDecimal yingshouAmount = new BigDecimal(MapUtils.getDouble(workingMoney, "yingshouAmount"));
        Integer orderNum = MapUtils.getInteger(workingMoney, "orderNum");
        Integer peopleNum = MapUtils.getInteger(workingMoney, "peopleNum");
        BigDecimal avgOrderMoney = orderNum > 0 ? yingshouAmount.divide(new BigDecimal(orderNum), 2, RoundingMode.HALF_UP) : new BigDecimal(0);
        BigDecimal avgPeopleMoney = peopleNum > 0 ? yingshouAmount.divide(new BigDecimal(peopleNum), 2, RoundingMode.HALF_UP) : new BigDecimal(0);
//        翻台率 ＝ 当天子订单数量 / 所有桌台数量
//        上座率 ＝ 当天就餐人数总和 / 所有桌台标准人数之和
        Map<String, Object> turnoverRateMap = workingInfoDao.getTurnoverRate();
        Map<String, Object> tableRateMap = workingInfoDao.getTableRate();

        Float turnoverSubOrderNum = MapUtils.getFloat(turnoverRateMap, "subOrderNum");
        Float turnoverPeopleNum = MapUtils.getFloat(turnoverRateMap, "peopleNum");
        Float turnoverTablePeopleNum = MapUtils.getFloat(turnoverRateMap, "tablePeopleNum");
        Float tableNum = MapUtils.getFloat(tableRateMap, "tableNum");

        Float turnoverRate = (tableNum == 0 ? 0 : turnoverSubOrderNum / tableNum);
        Float tableRate = (turnoverTablePeopleNum == 0 ? 0 : turnoverPeopleNum / turnoverTablePeopleNum);
        //构建打印VO
        AmountInfoVO amountInfoVO = new AmountInfoVO();
        amountInfoVO.setBusinessID(businessDate.toEpochDay());
        amountInfoVO.setBusinessType(0L);
        amountInfoVO.setOperatorID(MapUtils.getLong(paraMap, "loginID"));
        amountInfoVO.setArchiveID(MapUtils.getLong(paraMap, "archiveID"));
        //构建打印外层对象
        amountInfoVO.setBusinessDate(businessDate);
        amountInfoVO.setCashRegister(MapUtils.getString(workingMap, "casherCode"));
        amountInfoVO.setJoinTime(LocalDateTime.now());
        amountInfoVO.setJoinPeople(MapUtils.getString(workingMap, "loginName"));
        amountInfoVO.setTotalQuantity(orderNum);
        amountInfoVO.setTotalAmount(yingshouAmount);
        amountInfoVO.setGiveAmount(new BigDecimal(MapUtils.getDouble(workingMoney, "zengsongAmount")));
        amountInfoVO.setDiscountAmount(new BigDecimal(MapUtils.getDouble(workingMoney, "zhekouAmount")));
        amountInfoVO.setReduceAmount(new BigDecimal(MapUtils.getDouble(workingMoney, "zhijianAmount")));
        amountInfoVO.setReduceAmount(new BigDecimal(MapUtils.getDouble(workingMoney, "zhijianAmount")));
        amountInfoVO.setServiceAmount(new BigDecimal(MapUtils.getDouble(workingMoney, "fuwuAmount")));
        amountInfoVO.setSmallAmount(new BigDecimal(MapUtils.getDouble(workingMoney, "molingAmount")));
        amountInfoVO.setActualAmount(yingshouAmount);
        amountInfoVO.setIncomeAmount(new BigDecimal(MapUtils.getDouble(workingMoney, "shoukuanAmount")));
        amountInfoVO.setInvoiceAmount(new BigDecimal(MapUtils.getDouble(workingMoney, "kaipiaoAmount")));
        amountInfoVO.setOrderCount(orderNum);
        amountInfoVO.setPeopleCount(peopleNum);
        amountInfoVO.setAvgOrderAmount(avgOrderMoney);
        amountInfoVO.setAvgPeopleAmount(avgPeopleMoney);
        amountInfoVO.setTableRate(tableRate);
        amountInfoVO.setTurnoverRate(turnoverRate);
        //构建打印明细列表
        ArrayList<TransDetailVO> transDetailVOS = new ArrayList<>();
        //订单统计
        List<Map<String, Object>> orderMoney = (List<Map<String, Object>>) businessStatistics.get("orderMoney");
        TransDetailVO orderDetail = fillTransDetailVO(orderMoney, "收款统计");
        //会员统计
        List<Map<String, Object>> memberMoney = (List<Map<String, Object>>) businessStatistics.get("memberMoney");
        TransDetailVO memberDetail = fillTransDetailVO(memberMoney, "会员统计");
        //预定统计
        List<Map<String, Object>> bookingMoney = (List<Map<String, Object>>) businessStatistics.get("bookingMoney");
        TransDetailVO bookingDetail = fillTransDetailVO(bookingMoney, "预定统计");
        //预定退款统计
        List<Map<String, Object>> unSubscribeMoney = (List<Map<String, Object>>) businessStatistics.get("unSubscribeMoney");
        TransDetailVO unSubscribeDetail = fillTransDetailVO(unSubscribeMoney, "预定退款统计");
        transDetailVOS.add(orderDetail);
        transDetailVOS.add(memberDetail);
        transDetailVOS.add(bookingDetail);
        transDetailVOS.add(unSubscribeDetail);

        printComponent.printDailySettleTicket(amountInfoVO, transDetailVOS);
        return null;
    }

    public Map<String, Object> isInWorking(Map param) {
        Map<String, Object> workingInfoMap = workingInfoDao.getWorkingInfo(param);
        if (workingInfoMap == null) {
            BizException.error(2, "找不到对应的开班记录,请先开班");
        }
        return null;
    }

}
