package cc.toprank.byd.web.service.payment;

import cc.toprank.byd.common.utils.DateUtils;
import cc.toprank.byd.dao.B_DinningTableUseInfoDao;
import cc.toprank.byd.dao.O_SubOrderInfoDao;
import cc.toprank.byd.dao.U_LoginInfoDao;
import cc.toprank.byd.entity.B_DinningTableUseInfoEntity;
import cc.toprank.byd.entity.O_SubOrderInfoEntity;
import cc.toprank.byd.entity.U_LoginInfoEntity;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.dto.PaymentDTO;
import cc.toprank.byd.web.service.table.TableServiceBase;
import cc.toprank.byd.web.vo.paymentvo.TableUseInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 桌台信息
 * Created by HuangCY on 2017-5-10.
 */
@Service("tableUseInfoService")
public class TableUseInfoService extends TableServiceBase {

    //子订单信息
    @Autowired
    private O_SubOrderInfoDao o_SubOrderInfoDao;
    //登录信息
    @Autowired
    private U_LoginInfoDao u_LoginInfoDao;
    //登录信息
    @Autowired
    private B_DinningTableUseInfoDao b_DinningTableUseInfoDao;

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 获取桌台使用信息参数
     * @time 2017-5-15 16:36
     */
    public TableUseInfoVO queryTableUseInfo(PaymentDTO paymentDTO) throws Exception {
        TableUseInfoVO tableUserInfoVO = new TableUseInfoVO();

        List<Long> subOrderIDList = paymentDTO.getSubOrderIDList();

        for(int i = 0 ; i < subOrderIDList.size() ; i++){
            O_SubOrderInfoEntity subOrderInfoEntity = o_SubOrderInfoDao.querySubOrderInfoBySubOrderID(subOrderIDList.get(i));

            //验证子订单
            if(null != subOrderInfoEntity){
                //服务员
                String waiterName = null;
                //开台人(收银员)
                String cashierName = null;
                //开台时间
                String startTime = null;
                //使用时长
                Long minute = null;
                //订单code
                String orderCode = subOrderInfoEntity.getOrderCode();
                //人数
                Integer peopleNum = subOrderInfoEntity.getPeopleNum();
                //备注
                String memo = subOrderInfoEntity.getmMemo();
                //获取桌台ID
                Long tableID = subOrderInfoEntity.getTableID();
                //桌台名称
                String tableName = subOrderInfoEntity.getTableName();
                //联台名称
//            StringBuffer combineName = new StringBuffer();
//            //获取关联桌台名称
//            List<TableMessageVO> tableList = getCombinedTables(tableID);
//
//            for (int i = 0; i < tableList.size(); i++) {
//                TableMessageVO tableMessageVO = tableList.get(i);
//
//                //桌台名称追加
//                combineName.append(tableMessageVO.getCombineName());
//
//                if (i < tableList.size() - 1) {
//                    combineName.append(",");
//                }
//            }

                Map map = new HashMap<>();

                map.put("tableID", tableID);
                map.put("archiveID", paymentDTO.getArchiveID());

                //根据桌台ID和档案ID查询桌台使用信息
                B_DinningTableUseInfoEntity dinningTableUseInfoEntity = b_DinningTableUseInfoDao.getDinningTableUseInfoEntityByTableIDAndTableStatus(map);

                if(null != dinningTableUseInfoEntity){
                    if(null != dinningTableUseInfoEntity.getStartTime()){
                        //开台时间
                        startTime = dinningTableUseInfoEntity.getStartTime().toString();
                        //使用时长
                        minute = DateUtils.getMinutesBetween(dinningTableUseInfoEntity.getStartTime(), LocalDateTime.now());
                    }
                    if(null != dinningTableUseInfoEntity.getWaiterLoginID()){
                        //服务员
                        waiterName = getLoginName(dinningTableUseInfoEntity.getWaiterLoginID());
                    }
                    if(null != dinningTableUseInfoEntity.getCashierLoginID()){
                        //开台人(收银员)
                        cashierName = getLoginName(dinningTableUseInfoEntity.getCashierLoginID());
                    }

                    tableUserInfoVO.setCashierName(cashierName);
//            tableUserInfoVO.setCombineName(combineName.toString());
                    tableUserInfoVO.setStartTime(startTime);
                    tableUserInfoVO.setWaiterName(waiterName);
                    tableUserInfoVO.setTableName(tableName);
                    tableUserInfoVO.setMemo(memo);
                    tableUserInfoVO.setMinute(minute);
                    tableUserInfoVO.setPeopleNum(peopleNum);
                    tableUserInfoVO.setOrderCode(orderCode);
                }
            }else{
                i = subOrderIDList.size();

                tableUserInfoVO.setCode(CodeMsgConstants.PAYMENT_SUBORDERID_NOT_EXIST);
                tableUserInfoVO.setMessage(CodeMsgConstants.PAYMENT_SUBORDERID_NOT_EXIST_MSG);
            }
        }

        return tableUserInfoVO;
    }

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 获得登录名
     * @time 2017-5-15 14:35
     */
    private String getLoginName(Long loginID) throws Exception {
        U_LoginInfoEntity loginSetParamsEntity = new U_LoginInfoEntity();

        loginSetParamsEntity.setLoginID(loginID);

        //根据登录ID查询登录人信息
        U_LoginInfoEntity loginInfoEntity = u_LoginInfoDao.get(loginSetParamsEntity);

        return loginInfoEntity.getLoginName();
    }
}
