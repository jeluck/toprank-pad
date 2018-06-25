package cc.toprank.byd.web.service.counter;

import cc.toprank.byd.dao.B_DinningTableUseInfoDao;
import cc.toprank.byd.dao.O_OrderDetailInfoDao;
import cc.toprank.byd.entity.B_DinningTableUseInfoEntity;
import cc.toprank.byd.entity.O_OrderDetailInfoEntity;
import cc.toprank.byd.entity.O_SubOrderInfoEntity;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.constant.ResultData;
import cc.toprank.byd.web.service.menu.O_SubOrderInfoService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author HouXH
 * @version 1.0.0
 * @description  结账信息展示
 * @time 2017/4/7 15:30
 */
@Service("settleService")
public class SettleService {

    @Autowired
    private O_SubOrderInfoService o_subOrderInfoService;

    @Autowired
    private O_OrderDetailInfoDao o_orderDetailInfoDao;

    @Autowired
    private B_DinningTableUseInfoDao b_dinningTableUseInfoDao;

    /**
     * @author HouXH
     * @version 1.0.0
     * @description  根据子订单号和桌台号查询订单信息和桌台使用信息
     * @time 2017/4/7 17:13
     * @param subOrderId 子订单单号
     */
    public ResultData getSettleOrderInfo(String subOrderId)throws Exception{
        ResultData resultData=new ResultData();
        //根据子订单号查询子订单信息
        O_SubOrderInfoEntity o_subOrderInfoEntity=new O_SubOrderInfoEntity();
        o_subOrderInfoEntity.setSubOrderID(Long.parseLong(subOrderId));
        o_subOrderInfoEntity=o_subOrderInfoService.get(o_subOrderInfoEntity);
        if(o_subOrderInfoEntity==null){
            resultData.setCode(CodeMsgConstants.TABLE_SUBORDER_NOT_EXIST);
            resultData.setMessage(CodeMsgConstants.TABLE_SUBORDER_NOT_EXIST_MSG);
            return resultData;
        }
        Map<String,Object> tableMap=new HashMap<>();
        tableMap.put("tableId",o_subOrderInfoEntity.getTableID());
        tableMap.put("mealsId",o_subOrderInfoEntity.getMealsID());
        //根据桌台编号查询桌台使用列表
        B_DinningTableUseInfoEntity b_dinningTableUseInfoEntity= b_dinningTableUseInfoDao.getDinningTableUseInfoByTableIDAndMealsID(tableMap);
        if(b_dinningTableUseInfoEntity==null){
            resultData.setCode(CodeMsgConstants.NO_TABLE_USE_DATA);
            resultData.setMessage(CodeMsgConstants.NO_TABLE_USE_DATA_MSG);
            return resultData;
        }
        //根据子订单号查询子订单明细信息
        List<O_OrderDetailInfoEntity> o_orderDetailInfoList=o_orderDetailInfoDao.getAllById(Long.parseLong(subOrderId));
        if(CollectionUtils.isEmpty(o_orderDetailInfoList)) {
            resultData.setCode(CodeMsgConstants.ORDER_DETAIL_NOT_EXIST);
            resultData.setMessage(CodeMsgConstants.ORDER_DETAIL_NOT_EXIST_MSG);
            return resultData;
        }
        Map<String,Object> dateMap=new HashMap<>();
        dateMap.put("tableUseInfo",b_dinningTableUseInfoEntity);
        dateMap.put("orderDetailInfoList",o_orderDetailInfoList);
        resultData.setCode(CodeMsgConstants.SUCCESS);
        resultData.setData(dateMap);
        return resultData;
    }
}
