package cc.toprank.byd.web.service.order;

import cc.toprank.byd.common.utils.DateUtils;
import cc.toprank.byd.common.utils.MapHelper;
import cc.toprank.byd.dao.B_DinningTableUseInfoDao;
import cc.toprank.byd.dao.O_SubOrderInfoDao;
import cc.toprank.byd.entity.O_SubOrderInfoEntity;

import cc.toprank.byd.web.vo.order.OrderEditVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;

/**
 * Created by HuTao on 2017-4-20.
 */
@Service("orderInfoEditService")
public class OrderInfoEditService {

    @Autowired
    private O_SubOrderInfoDao subOrderInfoDao;
    @Autowired
    private B_DinningTableUseInfoDao dinningTableUseInfoDao;

    /**
     * @Description： 根据子订单号，取订单编辑数据
     * @Author：HuTao
     * @Time: 2017-4-20 11:18
     * @Version 2.0.0
     * @param subOrderID
     * @return
     */
   public OrderEditVO getEditOrderInfo(Long subOrderID) throws Exception {
       OrderEditVO orderEditVO = subOrderInfoDao.getEditSubOrder(subOrderID);
       if(null!=orderEditVO) {
           if(null!=orderEditVO.getOrderID()) {
               if(null!=orderEditVO.getNewCreateTime()) {
                   orderEditVO.setCreateTime(orderEditVO.getNewCreateTime().toLocalTime().toString());
               }
               List<O_SubOrderInfoEntity> infoEntityList = subOrderInfoDao.getSubOrderInfoByOrderID(orderEditVO.getOrderID());
               String tableName="";
               for(O_SubOrderInfoEntity infoEntity:infoEntityList){
                   if(!orderEditVO.getTableName().equals(infoEntity.getTableName())) {
                       tableName = tableName + infoEntity.getTableName() + ",";
                   }
               }
               if (tableName.trim().length()>1) {
                   tableName = tableName.substring(0, tableName.length() - 1);
                   orderEditVO.setComTableCode(tableName);      //     关联桌台
               }
           }
           if(null==orderEditVO.getMemo()) {
               orderEditVO.setMemo(" ");
           }
       }
       return  orderEditVO;
    }

    /**
     * @Description：保存编辑的订单数据
     * @Author：HuTao
     * @Time: 2017-4-20 11:28
     * @Version 2.0.0
     * @param orderEditVO
     */

    @Transactional(rollbackFor = Exception.class)
    public void updateOrderInfo(OrderEditVO orderEditVO){
        Map<String,Object>  mapData =new HashMap();
        mapData.put("tableID",orderEditVO.getTableID());
        mapData.put("subOrderID",orderEditVO.getSubOrderID());
        mapData.put("peopleNum",orderEditVO.getPeopleNum());
        mapData.put("waiterLoginID",orderEditVO.getWaiterLoginID());
        mapData.put("memo",orderEditVO.getMemo());
        subOrderInfoDao.updateEditOrderInfo(mapData);
        dinningTableUseInfoDao.updateTableServerInfo(mapData);
    }



}
