package cc.toprank.byd.web.service.order;

import cc.toprank.byd.common.utils.DateUtils;
import cc.toprank.byd.common.utils.string.StringUtil;
import cc.toprank.byd.dao.RefundDao;
import cc.toprank.byd.enums.FinancialManageEnum;
import cc.toprank.byd.enums.MerchantManageEnum;
import cc.toprank.byd.enums.SystemManageEnum;
import cc.toprank.byd.util.EnumUtil;
import cc.toprank.byd.web.vo.order.RefundQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * Created by LiuHM on 2017-6-7.
 */
@Service
public class RefundService {

    @Autowired
    private RefundDao refundDao;

    public List<Map<String, Object>> getRefundList(RefundQueryVO refundQueryVO) {
        refundQueryVO = this.parseQuery(refundQueryVO);
        List<Map<String, Object>> dataList = refundDao.getRefundListByCondition(refundQueryVO);
        if(dataList == null || dataList.isEmpty()) {
            return dataList;
        }
        for(Map<String, Object> data : dataList) {
            this.parseRefund(data);
        }
        return dataList;
    }

    public int countRefund(RefundQueryVO refundQueryVO) {
        refundQueryVO = this.parseQuery(refundQueryVO);
        return refundDao.countRefund(refundQueryVO);
    }

    public Map<String, Object> getRefund(Long bookingID, Long dealID) {
        Map<String, Object> data = refundDao.getRefundByBookingIDAndDealID(bookingID, dealID);
        if(data ==  null || data.isEmpty()) {
            return data;
        }
        return this.parseRefund(data);
    }

    private Map<String, Object> parseRefund(Map<String, Object> data) {
        Long status = (Long)data.get("bookingStatus");
        data.remove("bookingStatus");
        if(status != null) {
            if(MerchantManageEnum.ReservaManage.FINISH.getValue() == status.longValue()) {
                data.put("refundType", "结账退款");
            } else if(MerchantManageEnum.ReservaManage.EXPIRED.getValue() == status.longValue()) {
                data.put("refundType", "系统取消");
                data.put("dealUer", "系统");
            } else if(MerchantManageEnum.ReservaManage.CANCELED.getValue() == status.longValue()) {
                data.put("refundType", "手动取消");
            } else {
                data.put("refundType", "未知");
            }
        }

        Long refundMethod = (Long)data.get("refundMethod");
        try {
            if(refundMethod != null) {
                data.put("refundMethod", EnumUtil.getEnumNmae(FinancialManageEnum.PayMethod.class, refundMethod));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    private RefundQueryVO parseQuery(RefundQueryVO query) {
        if(query.getDateFlag() == 1) {
            query.setRefundDateStart(DateUtils.getCurrentDate() + " 00:00:00");
            query.setRefundDateEnd(DateUtils.getCurrentDate() + " 23:59:59");
        } else if(query.getDateFlag() == 2) {
            query.setRefundDateStart(DateUtils.getYesterday() + " 00:00:00");
            query.setRefundDateEnd(DateUtils.getYesterday() + " 23:59:59");
        } else {
            if(!StringUtil.isEmpty(query.getRefundDateStart())) {
                query.setRefundDateStart(query.getRefundDateStart() + " 00:00:00");
            }
            if(!StringUtil.isEmpty(query.getRefundDateEnd())) {
                query.setRefundDateEnd(query.getRefundDateEnd() + " 23:59:59");
            }
        }
        return query;
    }

}
