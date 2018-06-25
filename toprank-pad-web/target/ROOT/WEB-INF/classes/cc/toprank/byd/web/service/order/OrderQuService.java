package cc.toprank.byd.web.service.order;


import cc.toprank.byd.common.utils.DateUtils;
import cc.toprank.byd.common.utils.json.JSONUtils;
import cc.toprank.byd.common.utils.string.StringUtil;
import cc.toprank.byd.component.PrintComponent;
import cc.toprank.byd.dao.*;
import cc.toprank.byd.entity.O_OrderDetailInfoEntity;
import cc.toprank.byd.entity.O_OrderDetailValueMappingEntity;
import cc.toprank.byd.entity.O_SubOrderInfoEntity;
import cc.toprank.byd.entity.O_TicketPrintInfoEntity;
import cc.toprank.byd.enums.CommonManageEnum;
import cc.toprank.byd.enums.ProductManageEnum;
import cc.toprank.byd.util.DateHelper;
import cc.toprank.byd.vo.print.BusinessVO;
import cc.toprank.byd.web.service.payment.AmountSituationService;
import cc.toprank.byd.web.vo.member.MemberRechargePrintVO;
import cc.toprank.byd.web.vo.order.*;
import cc.toprank.byd.web.vo.paymentvo.AmountSituationVO;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


/**
 * Created by HuTao on 2017-5-2.
 */

@Service
public class OrderQuService {

    @Autowired
    private O_SubOrderInfoDao subOrderInfoDao;

    @Autowired
    private O_OrderDetailInfoDao orderDetailInfoDao;

    @Autowired
    private O_OrderInfoDao orderInfoDao;

    @Autowired
    O_OrderDetailValueMappingDao orderDetailValueMappingDao;

    @Autowired
    AmountSituationService amountSituationService;

    @Autowired
    PrintComponent printComponent;
    /**
     * @param orderQuVO
     * @return
     * @Description：堂食订单信息查询的Service
     * @Author：HuTao
     * @Time: 2017-5-4 9:59
     * @Version 2.0.0
     */
    public List<TableOrderInfoVO> quOrderInfo(OrderQuVO orderQuVO) throws Exception {
        //  消费中 已暂结  已结帐  反结帐    已取消
        //  餐次  桌台  订单号
        //  当前班次  今天     昨天         历史日期
        //  收银员    收银机    开台日期    结束日期
        List<TableOrderInfoVO> tableOrderList = new ArrayList();
        Map<String, Object> parm = new HashMap();
        parm.put("orderStatus", orderQuVO.getOrderStatus());
        if (!orderQuVO.getMealName().equals("")) {
            parm.put("mealName", orderQuVO.getMealName());
        } else
            parm.put("mealName", null);
        if (!orderQuVO.getTableName().equals("")) {
            parm.put("tableName", orderQuVO.getTableName());
        } else
            parm.put("tableName", null);
        if (!orderQuVO.getOrderCode().equals("")) {
            parm.put("orderCode", orderQuVO.getOrderCode());
        } else
            parm.put("orderCode", null);
        LocalDate startDate=null;
        LocalDate endDate=null;
        if(null!=orderQuVO.getStartDate()&&!orderQuVO.getStartDate().equals("")) {

             startDate = DateUtils.toUTCDateTime(DateUtils.parseLocalDateTime10(orderQuVO.getStartDate())).toLocalDate();
        }
        if(null!=orderQuVO.getEndDate()&&!orderQuVO.getEndDate().equals("")) {

            endDate = DateUtils.toUTCDateTime(DateUtils.parseLocalDateTime10(orderQuVO.getEndDate())).toLocalDate();

        }
        if (orderQuVO.getOrderStatus().equals(654L) || orderQuVO.getOrderStatus().equals(876L)) {  //   消费中654   已暂结651   已结帐875   取消876
            if (!orderQuVO.getCashierName().equals("")) {
                parm.put("cashierName", orderQuVO.getCashierName());
            } else
                parm.put("cashierName", null);
            if (!orderQuVO.getPostName().equals("")) {
                parm.put("postName", orderQuVO.getPostName());
            } else
                parm.put("postName", null);
            parm.put("dateSign", orderQuVO.getDateSign());
            parm.put("startDate", startDate);                  //    要转成格林威治时间
            parm.put("endDate", endDate);
        } else {
            if (!orderQuVO.getCashierName().equals("")) {
                parm.put("cashierName", orderQuVO.getCashierName());
            } else
                parm.put("cashierName", null);
            if (!orderQuVO.getPostName().equals("")) {
                parm.put("postName", orderQuVO.getPostName());
            } else
                parm.put("postName", null);
            parm.put("dateSign", orderQuVO.getDateSign());     //   1 当前班次  2今天   3  昨天       4  历史日期
            parm.put("startDate", startDate);     //  要转成格林威治时间
            parm.put("endDate", endDate);
        }
        List<O_SubOrderInfoEntity> subOrderList = subOrderInfoDao.quOrderInfo(parm);
        Integer number = 0;
        for (O_SubOrderInfoEntity infoEntity : subOrderList) {
            TableOrderInfoVO orderInfoVO = new TableOrderInfoVO();
            number++;
            orderInfoVO.setNumber(number);
            orderInfoVO.setOrderCode(infoEntity.getOrderCode());                     //  订单编号
            orderInfoVO.setSubOrderID(infoEntity.getSubOrderID());         //  子订单ID
            orderInfoVO.setOrderID(infoEntity.getOrderID());                //  订单ID
            orderInfoVO.setTableID(infoEntity.getTableID());                //  桌台ID
            orderInfoVO.setCustomerNumber(infoEntity.getPeopleNum());        //  就餐人数
            orderInfoVO.setBizDate(infoEntity.getCreateTime().toLocalDate());         //  营业日期
            orderInfoVO.setCreateTime(infoEntity.getCreateTime()); //  开台时间
            orderInfoVO.setTableName(infoEntity.getTableName());         //  桌台名称
            orderInfoVO.setActualAmount(infoEntity.getActualAmount().doubleValue());       //  订单金额
            orderInfoVO.setOrderChannelName(infoEntity.getOrderChannelName());   //  订单来源
            orderInfoVO.setMealName(infoEntity.getMealName());           //   餐次名称
            orderInfoVO.setCreatorName(infoEntity.getCreatorName());       //   开台人
            orderInfoVO.setServerName(infoEntity.getServerName());        //   服务员
            orderInfoVO.setAccountCode(infoEntity.getAccountCode());      //   结帐单号
            orderInfoVO.setAccountTime(infoEntity.getAccountTime());       //  结账时间
            orderInfoVO.setCashier(infoEntity.getCashier());            //  收银员
            orderInfoVO.setCashRegister(infoEntity.getCashRegister());       //  收银机
            orderInfoVO.setCancelReason(infoEntity.getSubOrderDesc());                  //   取消原因
            tableOrderList.add(orderInfoVO);
        }
        return tableOrderList;
    }

    /**
     * @param orderID
     * @return
     * @Description：根据订单ID , 取订单的明细信息
     * @Author：HuTao
     * @Time: 2017-5-4 16:34
     * @Version 2.0.0
     */
    public OrderDetailVO getOrderInfo(Long archiveID, Long orderID) {
        OrderDetailVO orderDetailVO = new OrderDetailVO();
        List<O_SubOrderInfoEntity> subOrderList = subOrderInfoDao.getSubOrderInfoByOrderID(orderID);
        int customerNumber = 0;    //  就餐人数
        String combineMemo = "";   // 关联桌台
        double actualAmount = 0;  //  订单金额
        List<Long> subOrderIDList =new ArrayList<>();
        String tableName= subOrderList.get(0).getTableName();
        for (O_SubOrderInfoEntity infoEntity : subOrderList) {
            customerNumber = customerNumber + (null == infoEntity.getPeopleNum() ? 0 : infoEntity.getPeopleNum());
            if(!tableName.equals(infoEntity.getTableName())) {
                combineMemo = combineMemo + (null == infoEntity.getTableName() ? "" : infoEntity.getTableName()) + ",";
            }
            actualAmount = actualAmount + (null == infoEntity.getTotalAmount() ? 0 : infoEntity.getTotalAmount().doubleValue());
            subOrderIDList.add(infoEntity.getSubOrderID());
        }
        if (null != subOrderList && null != subOrderList.get(0)) {
            orderDetailVO.setOrderID(orderID);           //  订单ID
            orderDetailVO.setOrderCode(subOrderList.get(0).getOrderCode());         //  订单编号
            orderDetailVO.setCustomerNumber(customerNumber);     //  就餐人数
            orderDetailVO.setTableName(subOrderList.get(0).getTableName());         //  桌台名称
            orderDetailVO.setMemo(subOrderList.get(0).getmMemo());                //   整单备注
            orderDetailVO.setCombineMemo(combineMemo);        //   关联桌台 A01、A02、A03
            orderDetailVO.setActualAmount(actualAmount);       //  订单金额    消费金额： 134.8
        }
//   折扣信息处理
        //  795   折扣  796   免单    797   直减    798  抹零
        List<Map<String, Object>> mapDiscountList = subOrderInfoDao.getOrderDiscountInfo(orderID);
        if(null!=mapDiscountList){
            for (int i = 0; i < mapDiscountList.size(); i++) {
               if(null!=mapDiscountList.get(i).get("DiscountType")){
                   if(mapDiscountList.get(i).get("DiscountType").equals(ProductManageEnum.DiscountType.DISCOUNT.getValue())) {
                       orderDetailVO.setDiscount(Double.parseDouble( mapDiscountList.get(i).get("DiscountAmount").toString()));
                   } else if(mapDiscountList.get(i).get("DiscountType").equals(ProductManageEnum.DiscountType.FREESINGLE.getValue())) {
                       //  ------
                   } else if(mapDiscountList.get(i).get("DiscountType").equals(ProductManageEnum.DiscountType.STRAIGHTCUT.getValue())) {
                       orderDetailVO.setDerateAmount(Double.parseDouble( mapDiscountList.get(i).get("DiscountAmount").toString()));
                   }  else if(mapDiscountList.get(i).get("DiscountType").equals(ProductManageEnum.DiscountType.ZERO.getValue())) {
                       orderDetailVO.setNoChange(Double.parseDouble( mapDiscountList.get(i).get("DiscountAmount").toString()));
                   };
               }
            }
        }
        try {
            Map map = new HashMap();
            map.put("subOrderIDList", subOrderIDList);
            map.put("archiveID", archiveID);

            AmountSituationVO amountSituationVO = amountSituationService.amountSituation(subOrderIDList,archiveID,null);
            orderDetailVO.setLargess(null==amountSituationVO.getGiveProductAmount()?0:amountSituationVO.getGiveProductAmount().doubleValue());          //    赠送金额： 42.4
            orderDetailVO.setServerAmount(null==amountSituationVO.getServiceFee()?0:amountSituationVO.getServiceFee().doubleValue() );     //    服务费：0
            orderDetailVO.setDeratePeople(amountSituationVO.getReductionPerson());     //    减费人： 王某某
            orderDetailVO.setReceivable(null==amountSituationVO.getPayableAmount()?0:amountSituationVO.getPayableAmount().doubleValue());       //    应收：92.4
        } catch (Exception e){
            e.printStackTrace();
        }
        String makeCollectionsRecode = "";
        List<Map<String, Object>> mapList = subOrderInfoDao.getMakeCollectionsRecode(orderID);
        if (null != mapList) {
            for (int i = 0; i < mapList.size(); i++) {
                makeCollectionsRecode = makeCollectionsRecode + (null == mapList.get(i).get("PaymentName") ? "" : mapList.get(i).get("PaymentName").toString());
                BigDecimal bg = new BigDecimal(mapList.get(i).get("ChangeAmountDetail").toString());
                makeCollectionsRecode = makeCollectionsRecode +  String.format("%.2f", bg) + ",";
            }
        }
        orderDetailVO.setCreateTime(subOrderList.get(0).getCreateTime());  //  开台时间
        orderDetailVO.setCreateName(subOrderList.get(0).getCreatorName());    //   开台人
        orderDetailVO.setServerName(subOrderList.get(0).getServerName());     //    服务员
        orderDetailVO.setMakeCollectionsRecode(makeCollectionsRecode);      //  收款记录
        orderDetailVO.setMemo(subOrderList.get(0).getSubOrderDesc());      //   备注
        orderDetailVO.setSubOrderVOlist(getSubOrderVOlist(orderDetailVO.getOrderCode(),subOrderList));    //  子订单信息
        return orderDetailVO;
    }

    /**
     *
     * @Description：重打暂结单
     * @Author：HuTao
     * @Time: 2017-6-6 11:38
     * @Version 2.0.0
     * @param subOrderID
     */
  public void  repeatPrintTempBilling(Long subOrderID){
      BusinessVO businessVO = new BusinessVO() ;
      businessVO.setBusinessID(subOrderID);
      businessVO.setBusinessType(CommonManageEnum.BusinessType.SETTLE.getValue());
      printComponent.reprintTicket(businessVO);
  }

   private   List<SubOrderVO>  getSubOrderVOlist(String orderCode,List<O_SubOrderInfoEntity> subOrderList){
       List<SubOrderVO>   subOrderVOList = new ArrayList<>();
      for(O_SubOrderInfoEntity infoEntity:  subOrderList){
          Long   subOrderID=infoEntity.getSubOrderID();
          SubOrderVO subOrderVO=new SubOrderVO();
          subOrderVO.setTableName(infoEntity.getTableName());   //  子订单桌台名称
          subOrderVO.setOrderCode(orderCode);
          subOrderVO.setFoodlist(getFoodlist(subOrderID));
          subOrderVOList.add(subOrderVO);
      }
       return subOrderVOList;
   }

   private List<FoodDetailVO> getFoodlist(Long subOrderID){
       List<FoodDetailVO>  foodVOList=new ArrayList<>();
       List<O_OrderDetailInfoEntity>  infoEntityList= orderDetailInfoDao.getOrderFoodDetail(subOrderID);
       String valueIDs="" ; String detailIDs="";
       //   处理valueIDs,detailIDs
       getValueIDsAndDetailIDs(infoEntityList,valueIDs,detailIDs);
       Map<String,Object> parm = new HashedMap();
       parm.put("subOrderID",subOrderID);
       parm.put("valueIDs",valueIDs);
       parm.put("detailIDs",detailIDs);
       //  取加价，做法等明细数据
       List<O_OrderDetailValueMappingEntity> valueList = orderDetailValueMappingDao.getAttributeValueByOrderIDAndValueID(parm);

       for(O_OrderDetailInfoEntity infoEntity :infoEntityList){
           FoodDetailVO foodDetailVO=new FoodDetailVO();

           foodDetailVO.setSubOrderID(infoEntity.getSubOrderID());       //  子订单ID
           foodDetailVO.setOrderCode(infoEntity.getOrderCode());         //  订单编号
           foodDetailVO.setTableName(infoEntity.getTableName());         //   桌台名
           foodDetailVO.setVariantID(infoEntity.getVariantID());      //   变体ID
           foodDetailVO.setQuantity(infoEntity.getQuantity());         //   数量
           if(null!=infoEntity&&!infoEntity.getProductName().equals("") ) {
               foodDetailVO.setProductName(infoEntity.getProductName());  //     菜名
               foodDetailVO.setPrice(null==infoEntity.getPrice()?0:infoEntity.getPrice().doubleValue());       //   单价
           } else {
               foodDetailVO.setProductName(infoEntity.getComboName());    //      套餐处理
               foodDetailVO.setPrice(null==infoEntity.getComboPrice()?0:infoEntity.getComboPrice().doubleValue());       //   单价
           }
           foodDetailVO.setMemo(infoEntity.getMemo());         //    备注
           foodDetailVO.setaLaCarteMethod(infoEntity.getALaCarteMethod());                //   点菜方式
           foodDetailVO.setaLaCarteMethodName(infoEntity.getaLaCarteMethodName());        //   点菜方式名称
           foodDetailVO.setOptionlist(getOptionlist(infoEntity.getDetailID(),valueList));  //  处理 规格 加价明细
           foodVOList.add(foodDetailVO);
       }
       return foodVOList;
   }

   public List<OptionInfoVO> getOptionlist(Long dealID, List<O_OrderDetailValueMappingEntity> valueList ){
       List<OptionInfoVO>  optionInfoVOList =new ArrayList();
       for(O_OrderDetailValueMappingEntity valueEntity: valueList) {
           if(valueEntity.getDetailID().equals(dealID)) {
               OptionInfoVO optionInfoVO = new OptionInfoVO();
               optionInfoVO.setOptionName(valueEntity.getAttributeValue());      // 规格
               if (null!=valueEntity.getAddedPrice()) {
                   optionInfoVO.getAddedPrice();      //  规格 加价
               }
               optionInfoVOList.add(optionInfoVO);
           }
       }
       return  optionInfoVOList;
   }

    /**
     * @Description：取ValueIDs ，detailIDs
     * @Author：HuTao
     * @Time: 2017-5-9 14:00
     * @Version 2.0.0
     * @param infoEntityList
     * @param valueIDs
     * @param detailIDs
     */
  void getValueIDsAndDetailIDs(List<O_OrderDetailInfoEntity> infoEntityList,String valueIDs, String detailIDs){
      if(null!=infoEntityList) {
          for (O_OrderDetailInfoEntity infoEntity : infoEntityList) {
              detailIDs=detailIDs+ infoEntity.getDetailID()+",";
              if(null!=infoEntity.getValueIDs()) {
                  valueIDs = valueIDs + infoEntity.getValueIDs() + ",";
              }
          }
          if(null!=detailIDs&&!detailIDs.equals("")) {
              detailIDs = detailIDs.substring(0, detailIDs.length() - 1);
          }
          if(null!=valueIDs&&!valueIDs.equals("")) {
              valueIDs = valueIDs.substring(0, valueIDs.length() - 1);
          }
      }
   }


}
