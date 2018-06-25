package cc.toprank.byd.dao;

import cc.toprank.byd.web.vo.order.RefundQueryVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by LiuHM on 2017-6-7.
 */
public interface RefundDao {

    List<Map<String, Object>> getRefundListByCondition(RefundQueryVO queryVO);

    Map getRefundByBookingIDAndDealID(@Param("bookingID") Long bookingID, @Param("dealID") Long dealID);

    int countRefund(RefundQueryVO refundQueryVO);
}
