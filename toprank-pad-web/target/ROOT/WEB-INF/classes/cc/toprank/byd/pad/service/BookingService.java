package cc.toprank.byd.pad.service;

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.dao.CommonMapper;
import cc.toprank.byd.dao.O_BookingInfoDao;
import cc.toprank.byd.entity.B_MealsInfoEntity;
import cc.toprank.byd.entity.O_BookingInfoEntity;
import cc.toprank.byd.enums.MerchantManageEnum;
import cc.toprank.byd.pad.util.MerchantCacheUtils;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 预定service
 *
 * @author LeeJun
 * @version 2.0.0
 * @time 2017-2-20 17:08
 */
@Service
public class BookingService {

    @Autowired
    private O_BookingInfoDao bookingInfoDAO;
    @Autowired
    private TableService tableService;

    /**
     * 获取桌台下次预定时间
     *
     * @author LeeJun
     * @time 2017-4-17 14:00
     * @version 2.0.0
     */
    public Map<String, Object> getNextBookingTimeByTableID() {
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> tableDetail1 = CommonMapper.getTableDetail();
        long customerNumber = MapUtils.getLongValue(tableDetail1, "customerNumber");
        result.put("maxPerson", MapUtils.getLongValue(tableDetail1, "maxPerson") - customerNumber);
        result.put("minPerson", MapUtils.getLongValue(tableDetail1, "minPerson"));

        List<Map<String, Object>> usingOrderList = tableService.getUsingOrderList(MerchantCacheUtils.getCurrentTableID());
        if (usingOrderList.size() > 1) {
            result.put("isSharing", 1);
        } else {
            result.put("isSharing", 0);
        }
        O_BookingInfoEntity bookingOrder = bookingInfoDAO.getNextBookingOrderByTableID(MerchantCacheUtils.getCurrentTableID());
        if (bookingOrder != null) {
            result.put("bookingTime", bookingOrder.getBookingTime());
        } else {
            result.put("bookingTime", "");
        }
        return result;
    }

    /**
     * 查询预定单详细信息
     *
     * @author LeeJun
     * @time 2017-5-19 11:23
     * @version 2.0.0
     */
    public Map<String, Object> getBookingDetailBySubOrderID(Long subOrderID) {
        B_MealsInfoEntity currentMealsInfo = CommonMapper.getCurrentMealsInfo();
        Map<String, Object> bookingDetail = bookingInfoDAO.getBookingDetailBySubOrderID(subOrderID, currentMealsInfo.getMealsID());
        Long tableStatus = MapUtils.getLong(bookingDetail, "tableStatus");
        Long bookingID = MapUtils.getLong(bookingDetail, "bookingID");
        boolean isOpen = this.checkBookingCanOpenTable(bookingInfoDAO.selectByPrimaryKey(bookingID), tableStatus);
        bookingDetail.put("isOpen", isOpen);
        return bookingDetail;
    }

    public boolean isOpenTable(O_BookingInfoEntity bookingInfo, Long tableStatus) {
        if (bookingInfo == null || tableStatus != MerchantManageEnum.TableStatus.EMPTYTABLE.getValue()) {
            return false;
        }
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime bookingTime = bookingInfo.getBookingTime();
        int minLength = CommonMapper.getCurrentMealsInfo().getMinLength();
        // 预订时间-最短就餐时长 < 当前时间 < 预订时间+保留时长(最短就餐时长+加时时长)
        if (bookingTime.minusMinutes(minLength).isBefore(now) && bookingTime.plusMinutes(bookingInfo.getDuration()).isAfter(now)) {
            return true;
        }
        return false;
    }

    /**
     * 检查当前预定单是否可预定开台
     *
     * @param bookingInfo 预定单信息
     * @author LeeJun
     * @time 2017-5-19 14:09
     * @version 2.0.0
     */
    public boolean checkBookingCanOpenTable(O_BookingInfoEntity bookingInfo, Long tableStatus) {
        int minLength = CommonMapper.getCurrentMealsInfo().getMinLength();
        return this.checkBookingCanOpenTable(bookingInfo, tableStatus, minLength);
    }

    /**
     * 检查当前预定单是否可预定开台
     *
     * @param bookingInfo 预定单信息
     * @param minLength   最短就餐时长
     * @author LeeJun
     * @time 2017-5-19 14:01
     * @version 2.0.0
     */
    public boolean checkBookingCanOpenTable(O_BookingInfoEntity bookingInfo, Long tableStatus, int minLength) {
        if (bookingInfo == null) {
            throw new BizException("该预定单不存在:" + bookingInfo.getBookingID());
        }
        if (tableStatus != MerchantManageEnum.TableStatus.EMPTYTABLE.getValue()) {
            throw new BizException("当前桌台状态为不可用！");
        }
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime bookingTime = bookingInfo.getBookingTime();
        // 预订时间-最短就餐时长 < 当前时间 < 预订时间+保留时长(最短就餐时长+加时时长)
        if (bookingTime.minusMinutes(minLength).isBefore(now) && bookingTime.plusMinutes(bookingInfo.getDuration()).isAfter(now)) {
            return true;
        }
        return false;
    }

    /**
     * 修改预定单的到店时间
     *
     * @author LeeJun
     * @time 2017-5-19 17:01
     * @version 2.0.0
     */
    public void updateArrivalTime(Long bookingID) {
        O_BookingInfoEntity bookingInfo = new O_BookingInfoEntity();
        bookingInfo.setBookingID(bookingID);
        bookingInfo.setArrivalTime(LocalDateTime.now());
        bookingInfoDAO.updateByPrimaryKeySelective(bookingInfo);
    }

}
