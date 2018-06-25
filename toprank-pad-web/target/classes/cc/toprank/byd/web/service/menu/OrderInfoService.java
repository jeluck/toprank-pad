package cc.toprank.byd.web.service.menu;

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.common.utils.BigDecimalUtil;
import cc.toprank.byd.common.utils.number.NumberUtil;
import cc.toprank.byd.common.utils.string.StringUtil;
import cc.toprank.byd.component.*;
import cc.toprank.byd.dao.*;
import cc.toprank.byd.entity.*;
import cc.toprank.byd.enums.OrderManageEnum;
import cc.toprank.byd.enums.OrderManagerEnum;
import cc.toprank.byd.enums.SystemManageEnum;
import cc.toprank.byd.service.MonitorService;
import cc.toprank.byd.service.StallWeighService;
import cc.toprank.byd.util.CollectionHelper;
import cc.toprank.byd.util.MaxIDUtils;
import cc.toprank.byd.vo.print.ProductDetailVO;
import cc.toprank.byd.vo.print.TableInfoVO;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.dto.UserInfoVo;
import cc.toprank.byd.web.service.booking.O_BookingInfoService;
import cc.toprank.byd.web.service.order.O_OrderDealInfoService;
import cc.toprank.byd.web.service.table.B_DinningTableInfoService;
import cc.toprank.byd.web.vo.menu.OrderDetailOperationVO;
import cc.toprank.byd.web.vo.menu.OrderDetailResultVO;
import cc.toprank.byd.web.vo.menu.OrderDetailVO;
import cc.toprank.byd.web.vo.order.OrderMsgVO;
import cc.toprank.byd.web.vo.order.OrderQuVO;
import cc.toprank.byd.web.vo.reserve.ReserveVo;
import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONArray;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by LanZY on 2017-4-6.
 */
@Service("orderInfoService")
public class OrderInfoService {

    @Autowired
    B_DinningTableInfoService dinningTableInfoService;
    @Autowired
    O_SubOrderInfoDao subOrderInfoDao;
    @Autowired
    O_OrderDetailInfoService orderDetailInfoService;
    @Autowired
    O_OrderInfoDao orderInfoDao;
    @Autowired
    O_OrderDealInfoService orderDealInfoService;
    @Autowired
    B_StallWeighSettingInfoDao stallWeighSettingInfoDao;
    @Autowired
    MonitorService monitorService;
    @Autowired
    StallWeighService stallWeighService;
    @Autowired
    O_OrderDetailInfoDao orderDetailInfoDao;
    @Autowired
    B_DesignerMonitorInfoDao designerMonitorInfoDao;
    @Autowired
    B_MerchantTagMappingDao merchantTagMappingDao;
    @Autowired
    O_ComboDetailInfoDao comboDetailInfoDao;
    @Autowired
    CurbSaleComponent curbSaleComponent;
    @Autowired
    O_BookingInfoService bookingInfoService;
    @Autowired
    ProductInfoDao productInfoDao;
    @Autowired
    TableComponent tableComponent;
    @Autowired
    PrintComponent printComponent;
    @Autowired
    ProductComponent productComponent;
    @Autowired
    OrderComponent orderComponent;
    @Autowired
    B_MerchantTagInfoDao merchantTagInfoDao;

    // 日志打印
    protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());


    /**
     * @param subOrderID   子订单ID
     * @param shoppingCart 购物车：JSON格式
     * @Description： 下单
     * @Author： LanZY
     * @Time: 2017-4-11 15:42
     * @Version 2.0.0
     */
    @Transactional(rollbackFor = {Exception.class})
    public void addOrder(Long subOrderID, String shoppingCart) throws Exception {
        //下单返回结果集 用于批量新增标签
        List<OrderDetailResultVO> orderResultVOS = new ArrayList<>();
        //根据子订单ID 查询信息
        O_SubOrderInfoEntity subOrderInfo = orderComponent.getSubOrderInfoBySubOrderID(subOrderID);
        //查询订单
        O_OrderInfoEntity orderInfo = orderComponent.getOrderInfoByOrderID(subOrderInfo.getOrderID());
        //修改桌台状态和餐次桌台状态
        B_DinningTableInfoEntity tableInfo = dinningTableInfoService.updateTableStatus(subOrderInfo.getTableID());
        //修改订单和子订单的状态为进行中
        updateOrderAndSubOrderStatus(subOrderInfo);
        //新增订单明细返回对象
        OrderDetailResultVO orderDetailResult = new OrderDetailResultVO();
        List<OrderDetailVO> orderDetailList = JSONArray.parseArray(shoppingCart, OrderDetailVO.class);
        //新增订单明细
        addOrderDetailHandle(orderResultVOS, subOrderInfo, orderDetailResult, orderDetailList);
        //插入标签信息
        String merchantTagMappings = JSONArray.toJSONString(orderResultVOS);
        addMerchantTagMapping(merchantTagMappings, null);
        //沽清
        curbSaleComponent.addProduct(orderDetailResult.getDetailIDs(), tableInfo.getArchiveID());
        //插入看板关联信息
        monitorService.addWaitMakeProduct2DesignerMonitorInfo(orderDetailResult.getDetailIDs());
        //插入称重档口关联信息
        stallWeighService.addStallWeighInfo(orderDetailResult.getDetailIDs());
        // 新增子订单处理信息
        orderDealInfoService.saveOrderDealInfo(subOrderInfo.getSubOrderID(), orderInfo.getOrderID(), orderDetailResult.getSubTotalAmount(), subOrderInfo.getTotalAmount(), BigDecimalUtil.add(orderDetailResult.getSubTotalAmount(), subOrderInfo.getTotalAmount()), null, null, "");
        // 新增订单处理信息
        orderDealInfoService.saveOrderDealInfo(null, orderInfo.getOrderID(), orderDetailResult.getSubTotalAmount(), orderInfo.getTotalAmount(), BigDecimalUtil.add(orderDetailResult.getSubTotalAmount(), orderInfo.getTotalAmount()), null, null, "");
        // 修改子订单信息
        subOrderInfo.setActualAmount(BigDecimalUtil.add(orderDetailResult.getSubTotalAmount(), subOrderInfo.getTotalAmount()));
        subOrderInfo.setPendingAmount(BigDecimalUtil.add(orderDetailResult.getSubTotalAmount(), subOrderInfo.getTotalAmount()));
        subOrderInfo.setTotalAmount(BigDecimalUtil.add(orderDetailResult.getSubTotalAmount(), subOrderInfo.getTotalAmount()));
        subOrderInfo.setQuantity(orderDetailResult.getSubNum() + subOrderInfo.getQuantity());
        subOrderInfoDao.updateSubOrderInfoEntityBySubOrderID(subOrderInfo);
        // 修改订单信息
        orderInfo.setActualAmount(BigDecimalUtil.add(orderDetailResult.getSubTotalAmount(), orderInfo.getTotalAmount()));
        orderInfo.setTotalAmount(BigDecimalUtil.add(orderDetailResult.getSubTotalAmount(), orderInfo.getTotalAmount()));
        orderInfo.setPendingAmount(BigDecimalUtil.add(orderDetailResult.getSubTotalAmount(), orderInfo.getTotalAmount()));
        orderInfo.setQuantity(orderDetailResult.getSubNum() + orderInfo.getQuantity());
        orderInfoDao.updateOrderInfoByOrderID(orderInfo);

        OrderMsgVO orderMsgVO = new OrderMsgVO();
        List<String> name = new ArrayList<>();
        name.add("ssss1");
        name.add("ssss2");
        List<String> name2 = new ArrayList<>();
        name2.add("ssss13");
        name2.add("ssss22");
        orderMsgVO.setName1(name);
        orderMsgVO.setName2(name2);

        List<OrderQuVO> list3 = new ArrayList<>();
        OrderQuVO orderQuVO = new OrderQuVO();
        orderQuVO.setCashierName("傻B");
        list3.add(orderQuVO);
        orderMsgVO.setList3(list3);
        if (CollectionUtils.isNotEmpty(list3)) {
            throw new BizException(-1, JSONArray.toJSONString(orderMsgVO));
        }

        //打印
        List<ProductDetailVO> printProductDetailList = productComponent.getPrintProductDetailList(orderDetailResult.getDetailIDs());
        TableInfoVO printTable = productComponent.getPrintTable(subOrderID);
        try {
            printComponent.printTableTicket(printTable, printProductDetailList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 循环新增订单明细
     *
     * @param orderResultVOS
     * @param subOrderInfo
     * @param orderDetailResult
     * @param orderDetailList
     * @throws Exception
     */
    private void addOrderDetailHandle(List<OrderDetailResultVO> orderResultVOS, O_SubOrderInfoEntity subOrderInfo, OrderDetailResultVO orderDetailResult, List<OrderDetailVO> orderDetailList) throws Exception {
        for (int i = 0; i < orderDetailList.size(); i++) {
            OrderDetailVO orderDetail = orderDetailList.get(i);
            //根据menID新增订单明细信息
            OrderDetailResultVO orderResultVO = orderDetailInfoService.addOrderDetailInfo(orderDetail, subOrderInfo, i + 1);
            orderDetailResult.getDetailIDs().add(orderResultVO.getDetailID());
            orderResultVOS.add(orderResultVO);
            orderDetailResult.setSubTotalAmount(BigDecimalUtil.add(orderDetailResult.getSubTotalAmount(), orderResultVO.getTotalAmount()));
            orderDetailResult.setSubNum(NumberUtil.add(orderDetailResult.getSubNum(), orderDetail.getQuantity()));
        }
    }

    /**
     * @param reserveVO
     * @throws Exception
     * @Description： 预定点菜下单
     * @Author：LanZY
     * @Time: 2017-6-13 16:33
     * @Version 2.0.0
     */
    @Transactional(rollbackFor = {Exception.class})
    public Long addBookingOrder(ReserveVo reserveVO) throws Exception {
        O_BookingInfoEntity bookingInfo = bookingInfoService.addBooking(reserveVO);
        String[] subOrderIDs = reserveVO.getSubOrderIDs().split(",");
        if (null == reserveVO.getShoppingCarts()) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        String[] shoppingCarts = reserveVO.getShoppingCarts().split("/");
        for (int i = 0; i < subOrderIDs.length; i++) {
            //根据子订单ID 查询信息
            O_SubOrderInfoEntity subOrderInfo = orderComponent.getSubOrderInfoBySubOrderID(Long.valueOf(subOrderIDs[i]));
            //查询订单
            O_OrderInfoEntity orderInfo = orderComponent.getOrderInfoByOrderID(subOrderInfo.getOrderID());
            if (null == shoppingCarts[i]) {
                throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
            }
            List<OrderDetailVO> orderDetailList = JSONArray.parseArray(shoppingCarts[i], OrderDetailVO.class);
            //新增订单明细返回对象集合
            List<OrderDetailResultVO> orderResultVOS = new ArrayList<>();
            OrderDetailResultVO orderDetailResult = new OrderDetailResultVO();
            //新增订单明细处理
            addOrderDetailHandle(orderResultVOS, subOrderInfo, orderDetailResult, orderDetailList);
            //插入标签信息
            String merchantTagMappings = JSONArray.toJSONString(orderResultVOS);
            addMerchantTagMapping(merchantTagMappings, null);
            curbSaleComponent.addProduct(orderDetailResult.getDetailIDs(), subOrderInfo.getArchiveID());
            // 新增子订单处理信息
            orderDealInfoService.saveOrderDealInfo(subOrderInfo.getSubOrderID(), orderInfo.getOrderID(), orderDetailResult.getSubTotalAmount(), subOrderInfo.getTotalAmount(), BigDecimalUtil.add(orderDetailResult.getSubTotalAmount(), subOrderInfo.getTotalAmount()), null, null, "");
            // 新增订单处理信息
            orderDealInfoService.saveOrderDealInfo(null, orderInfo.getOrderID(), orderDetailResult.getSubTotalAmount(), orderInfo.getTotalAmount(), BigDecimalUtil.add(orderDetailResult.getSubTotalAmount(), orderInfo.getTotalAmount()), null, null, "");
            // 修改子订单信息
            subOrderInfo.setActualAmount(BigDecimalUtil.add(orderDetailResult.getSubTotalAmount(), subOrderInfo.getTotalAmount()));
            subOrderInfo.setTotalAmount(BigDecimalUtil.add(orderDetailResult.getSubTotalAmount(), subOrderInfo.getTotalAmount()));
            subOrderInfo.setPendingAmount(BigDecimalUtil.add(orderDetailResult.getSubTotalAmount(), orderInfo.getTotalAmount()));
            subOrderInfo.setQuantity(orderDetailResult.getSubNum() + subOrderInfo.getQuantity());
            subOrderInfoDao.updateSubOrderInfoEntityBySubOrderID(subOrderInfo);
            // 修改订单信息
            orderInfo.setActualAmount(BigDecimalUtil.add(orderDetailResult.getSubTotalAmount(), orderInfo.getTotalAmount()));
            orderInfo.setTotalAmount(BigDecimalUtil.add(orderDetailResult.getSubTotalAmount(), orderInfo.getTotalAmount()));
            orderInfo.setPendingAmount(BigDecimalUtil.add(orderDetailResult.getSubTotalAmount(), orderInfo.getTotalAmount()));
            orderInfo.setQuantity(orderDetailResult.getSubNum() + orderInfo.getQuantity());
            orderInfoDao.updateOrderInfoByOrderID(orderInfo);
        }
        return bookingInfo.getBookingID();
    }


    /**
     * @param merchantTagMappings JSON字符串
     * @Description： 免做, 先做, 打包, 催菜
     * @Author：LanZY
     * @Time: 2017-5-19 15:47
     * @Version 2.0.0
     */
    @Transactional(rollbackFor = Exception.class)
    public void addMerchantTagMapping(String merchantTagMappings, UserInfoVo userInfo) throws Exception {
        List<OrderDetailResultVO> merchantTagMappingList = JSONArray.parseArray(merchantTagMappings, OrderDetailResultVO.class);
        List<B_MerchantTagMappingEntity> record = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(merchantTagMappingList)) {
            B_MerchantTagMappingEntity merchantTagMapping;
            if (null == userInfo) {
                //根据明细ID查询标签关联信息
                merchantTagMapping = merchantTagMappingDao.getMerchantTagMappingByDetailID(merchantTagMappingList.get(0).getDetailID());
            } else {
                //设置标签关联信息
                merchantTagMapping = new B_MerchantTagMappingEntity();
                merchantTagMapping.setCreatorType(SystemManageEnum.UserType.SYSTEMUSER.getValue());
                merchantTagMapping.setCreatorID(userInfo.getLoginID());
                merchantTagMapping.setOrgID(userInfo.getOrgID());
                merchantTagMapping.setArchiveID(userInfo.getArchiveID());
            }
            for (OrderDetailResultVO orderDetailResultVO : merchantTagMappingList) {
                checkTagIDs(orderDetailResultVO.getTagIDs());
                if (CollectionUtils.isNotEmpty(orderDetailResultVO.getComboDetailList())) {
                    for (OrderDetailResultVO.ComboDetailVO comboDetailVO : orderDetailResultVO.getComboDetailList()) {
                        checkTagIDs(comboDetailVO.getTagIDs());
                        merchantTagMapping.setTargetID(comboDetailVO.getRecordID());
                        merchantTagMapping.setTargetType(944l);
                        getMerchantTagMappingList(record, merchantTagMapping, comboDetailVO.getTagIDs());
                    }
                } else {
                    O_OrderDetailInfoEntity orderDetailInfo = orderDetailInfoService.getOrderDetailInfoById(orderDetailResultVO.getDetailID());
                    if (orderDetailInfo.getIsCombo()) {
                        //查询套餐明细
                        O_ComboDetailInfoEntity comboInfo = new O_ComboDetailInfoEntity();
                        comboInfo.setDetailID(orderDetailInfo.getDetailID());
                        comboInfo.setProduceStatus(OrderManagerEnum.ProductionStatus.INPRODUCTION.getValue());
                        List<O_ComboDetailInfoEntity> comboDetailInfoList = comboDetailInfoDao.getComboDetailInfoByDetailIDAndStatus(comboInfo);
                        for (O_ComboDetailInfoEntity comboDetail : comboDetailInfoList) {
                            merchantTagMapping.setTargetID(comboDetail.getRecordID());
                            merchantTagMapping.setTargetType(944l);
                            getMerchantTagMappingList(record, merchantTagMapping, orderDetailResultVO.getTagIDs());
                        }
                    }
                    merchantTagMapping.setTargetID(orderDetailResultVO.getDetailID());
                    merchantTagMapping.setTargetType(943l);
                    getMerchantTagMappingList(record, merchantTagMapping, orderDetailResultVO.getTagIDs());
                }
            }
            if (CollectionUtils.isNotEmpty(record)) {
                merchantTagMappingDao.insertBatch(record);
            }
//            Set<Long> collect = CollectionHelper.collect(record, tag -> tag.getTagID());
//            List<B_MerchantTagInfoEntity> record2 = merchantTagInfoDao.getByTagByTagIDs(collect);
//            if(CollectionUtils.isEmpty(record2)){
//                throw new BizException("配置数据不存在");
//            }
//            List<Long> bczList = new ArrayList<>();
//            for (B_MerchantTagInfoEntity tag: record2) {
//                Stream<Long> longStream = collect.stream().filter((Long s) -> !s.equals(tag.getTagID()));
//                bczList.add(1L);
//            }
//            if(CollectionUtils.isNotEmpty(bczList)){
//                throw new BizException(bczList+"不存在");
//            }

//            if (CollectionUtils.isNotEmpty(record)) {
//                merchantTagMappingDao.insertBatch(record);
//            }
        }
    }

    /**
     * 检查是否存在重复标签
     *
     * @param TagIDs
     */
    private void checkTagIDs(String TagIDs) {
        if (!StringUtils.isEmpty(TagIDs)) {
            List<String> list = new ArrayList<>();
            for (String tagID : TagIDs.split(",")) {
                if (!list.contains(tagID)) {
                    list.add(tagID);
                } else {
                    throw new BizException(CodeMsgConstants.TAGREPEAT_ERROR, CodeMsgConstants.TAGREPEAT_ERROR_MSG);
                }
            }
        }
    }


    /**
     * @param record             集合
     * @param merchantTagMapping 商户标签关联信息
     * @param tagIDs             标签
     * @Description： 添加商户标签关联信息到集合中
     * @Author：LanZY
     * @Time: 2017-5-19 19:13
     * @Version 2.0.0
     */
    private void getMerchantTagMappingList(List<B_MerchantTagMappingEntity> record, B_MerchantTagMappingEntity merchantTagMapping, String tagIDs) throws Exception {
        if (!StringUtil.isEmpty(tagIDs)) {
            for (String tagID : tagIDs.split(",")) {
                if (!StringUtil.isEmpty(tagID)) {
                    B_MerchantTagMappingEntity merchantTag = new B_MerchantTagMappingEntity();
                    merchantTag.setMappingID(MaxIDUtils.getID(B_MerchantTagMappingEntity.class));
                    merchantTag.setTagID(Long.valueOf(tagID));
                    merchantTag.setArchiveID(merchantTagMapping.getArchiveID());
                    merchantTag.setOrgID(merchantTagMapping.getOrgID());
                    merchantTag.setTargetType(merchantTagMapping.getTargetType());
                    //943 明细 944 套餐明细
                    merchantTag.setTargetID(merchantTagMapping.getTargetID());
                    merchantTag.setCreateTime(LocalDateTime.now());
                    merchantTag.setCreatorType(merchantTagMapping.getCreatorType());
                    merchantTag.setCreatorID(merchantTagMapping.getCreatorID());
                    merchantTag.setMappingStatus(SystemManageEnum.EntityStatus.NORMAL.getValue());
                    B_MerchantTagMappingEntity tagMapping = merchantTagMappingDao.getMerchantTagMappingByTargetIDAndTagID(merchantTag);
                    if (tagMapping != null) {
                        throw new BizException(CodeMsgConstants.TAGREPEAT_ERROR, CodeMsgConstants.TAGREPEAT_ERROR_MSG);
                    }
                    record.add(merchantTag);
                }
            }
        }
    }


    /**
     * @Description：修改订单和子订单的状态为进行中
     * @Author：LanZY
     * @Time: 2017-5-2 9:59
     * @Version 2.0.0
     */
    public void updateOrderAndSubOrderStatus(O_SubOrderInfoEntity subOrderInfo) throws Exception {
        O_OrderInfoEntity orderInfo = orderComponent.getOrderInfoByOrderID(subOrderInfo.getOrderID());
        if (orderInfo.getOrderStatus().equals(OrderManageEnum.OrderStatus.NOORDER.getValue())) {
            orderInfo.setOrderStatus(OrderManageEnum.OrderStatus.HAVEINHAND.getValue());
            orderInfoDao.updateByPrimaryKeySelective(orderInfo);
            // 新增子订单处理信息
            orderDealInfoService.saveOrderDealInfo(subOrderInfo.getSubOrderID(), orderInfo.getOrderID(), BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, OrderManageEnum.OrderStatus.NOORDER.getValue(), OrderManageEnum.OrderStatus.HAVEINHAND.getValue(), "");
        }
        if (subOrderInfo.getOrderStatus().equals(OrderManageEnum.OrderStatus.NOORDER.getValue())) {
            subOrderInfo.setOrderStatus(OrderManageEnum.OrderStatus.HAVEINHAND.getValue());
            subOrderInfoDao.updateByPrimaryKeySelective(subOrderInfo);
            // 新增订单处理信息
            orderDealInfoService.saveOrderDealInfo(null, orderInfo.getOrderID(), BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, OrderManageEnum.OrderStatus.NOORDER.getValue(), OrderManageEnum.OrderStatus.HAVEINHAND.getValue(), "");
        }
    }

    /**
     * @Description：划单
     * @Author：LanZY
     * @Time: 2017-5-2 9:59
     * @Version 2.0.0
     */
    @Transactional(rollbackFor = Exception.class)
    public void markOrderDetail(String markOrderDetail) throws Exception {
        //需要修改状态的看板信息
        Set<Long> produceIDs = new HashSet<>();
        //需要修改订单明细状态信息
        List<O_OrderDetailInfoEntity> orderDetailList = new ArrayList<>();
        //需要修改套餐明细状态信息
        List<O_ComboDetailInfoEntity> comboDetailList = new ArrayList<>();
        List<OrderDetailOperationVO> markOrderDetailList = JSONArray.parseArray(markOrderDetail, OrderDetailOperationVO.class);
        if (CollectionUtils.isEmpty(markOrderDetailList)) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        for (OrderDetailOperationVO operationVO : markOrderDetailList) {
            if (NumberUtil.intValue(operationVO.getDetailID()) == 0 && NumberUtil.intValue(operationVO.getRecordID()) == 0) {
                throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
            }
            if (NumberUtil.intValue(operationVO.getQuantity()) == 0) {
                throw new BizException(CodeMsgConstants.MARKORDERDETAIL_NUMBER_ISNULL, CodeMsgConstants.MARKORDERDETAIL_NUMBER_ISNULL_MSG);
            }
            O_OrderDetailInfoEntity orderDetailInfo = null;
            O_ComboDetailInfoEntity comboDetailInfo = null;
            B_DesignerMonitorInfoEntity designerMonitorInfo = new B_DesignerMonitorInfoEntity();
            List<B_DesignerMonitorInfoEntity> designerMonitorInfoList = new ArrayList<>();
            //可划单的数量
            Integer quantity;
            if (null != operationVO.getDetailID()) {
                orderDetailInfo = orderDetailInfoService.getOrderDetailInfoById(operationVO.getDetailID());
                if (!orderDetailInfo.getProduceStatus().equals(OrderManagerEnum.ProductionStatus.INPRODUCTION.getValue()) && !orderDetailInfo.getProduceStatus().equals(OrderManagerEnum.ProductionStatus.ALREADYPRODUCED.getValue())) {
                    throw new BizException(CodeMsgConstants.MARKORDERDETAIL_ERROR, CodeMsgConstants.MARKORDERDETAIL_ERROR_MSG, orderDetailInfo.getDetailID() + "" + orderDetailInfo.getProductName());
                }
                quantity = orderDetailInfo.getQuantity() - orderDetailInfo.getServedNum();
            } else {
                comboDetailInfo = new O_ComboDetailInfoEntity();
                comboDetailInfo.setRecordID(operationVO.getRecordID());
                comboDetailInfo = comboDetailInfoDao.get(comboDetailInfo);
                if (!comboDetailInfo.getProduceStatus().equals(OrderManagerEnum.ProductionStatus.INPRODUCTION.getValue()) && !orderDetailInfo.getProduceStatus().equals(OrderManagerEnum.ProductionStatus.ALREADYPRODUCED.getValue())) {
                    throw new BizException(CodeMsgConstants.MARKORDERDETAIL_ERROR, CodeMsgConstants.MARKORDERDETAIL_ERROR_MSG, comboDetailInfo.getRecordID() + "" + comboDetailInfo.getProductName());
                }
                quantity = comboDetailInfo.getQuantity() - comboDetailInfo.getServedNum();
            }

            if (operationVO.getQuantity() > quantity) {
                throw new BizException(CodeMsgConstants.MARKORDERDETAIL_NUMBER_ERROR, CodeMsgConstants.MARKORDERDETAIL_NUMBER_ERROR_MSG);
            }

            if (null != operationVO.getDetailID()) {
                //是否套餐
                if (orderDetailInfo.getIsCombo()) {
                    //查询套餐明细
                    O_ComboDetailInfoEntity comboInfo = new O_ComboDetailInfoEntity();
                    comboInfo.setDetailID(operationVO.getDetailID());
                    comboInfo.setProduceStatus(OrderManagerEnum.ProductionStatus.INPRODUCTION.getValue());
                    List<O_ComboDetailInfoEntity> comboDetailInfoList = comboDetailInfoDao.getComboDetailInfoByDetailIDAndStatus(comboInfo);
                    for (O_ComboDetailInfoEntity comboDetail : comboDetailInfoList) {
                        //根据套餐明细查询看板记录
                        designerMonitorInfo.setRecordID(comboDetail.getRecordID());
                        designerMonitorInfo.setProduceStatus(OrderManagerEnum.ProductionStatus.INPRODUCTION.getValue());
                        designerMonitorInfoList = designerMonitorInfoDao.getDesignerMonitorInfoByRecordID(designerMonitorInfo);
                        markComboOrderUpdateList(produceIDs, orderDetailList, comboDetailList, operationVO, orderDetailInfo, comboDetail, designerMonitorInfoList);
                    }
                } else {
                    //根据明细查询看板记录
                    designerMonitorInfo.setDetailID(operationVO.getDetailID());
                    designerMonitorInfo.setProduceStatus(OrderManagerEnum.ProductionStatus.INPRODUCTION.getValue());
                    designerMonitorInfoList = designerMonitorInfoDao.getDesignerMonitorInfoByDetailID(designerMonitorInfo);
                    markOrderUpdateList(produceIDs, orderDetailList, comboDetailList, operationVO, designerMonitorInfoList, orderDetailInfo, comboDetailInfo);
                }
            } else {
                //根据套餐明细查询看板记录
                designerMonitorInfo.setRecordID(operationVO.getRecordID());
                designerMonitorInfo.setProduceStatus(OrderManagerEnum.ProductionStatus.INPRODUCTION.getValue());
                designerMonitorInfoList = designerMonitorInfoDao.getDesignerMonitorInfoByRecordID(designerMonitorInfo);
                markOrderUpdateList(produceIDs, orderDetailList, comboDetailList, operationVO, designerMonitorInfoList, orderDetailInfo, comboDetailInfo);
            }

            if (CollectionUtils.isNotEmpty(designerMonitorInfoList)) {
                if (operationVO.getQuantity() > designerMonitorInfoList.size()) {
                    throw new BizException(CodeMsgConstants.MARKORDERDETAIL_NUMBER_ERROR, CodeMsgConstants.MARKORDERDETAIL_NUMBER_ERROR_MSG);
                }
            }
        }

        /**
         * 批量修改订单明细,套餐明细,看板明细记录
         */
        Map<String, Object> monitorMap = new HashedMap();
        monitorMap.put("list", produceIDs);
        monitorMap.put("produceStatus", OrderManagerEnum.ProductionStatus.SERVINGALREADY.getValue());
        if (CollectionUtils.isNotEmpty(produceIDs)) {
            designerMonitorInfoDao.updateBatch(monitorMap);
        }
        if (CollectionUtils.isNotEmpty(comboDetailList)) {
            comboDetailInfoDao.updateBatch2(comboDetailList);
        }
        if (CollectionUtils.isNotEmpty(orderDetailList)) {
            orderDetailInfoDao.updateBatch2(orderDetailList);
        }
        orderDetailList = handleOrderDetailServedNum(markOrderDetailList);
        if (CollectionUtils.isNotEmpty(orderDetailList)) {
            orderDetailInfoDao.updateBatch2(orderDetailList);
        }
    }

    private List<O_OrderDetailInfoEntity> handleOrderDetailServedNum(List<OrderDetailOperationVO> markOrderDetailList) {
        List<O_OrderDetailInfoEntity> orderDetailList;
        orderDetailList = new ArrayList<>();
        for (OrderDetailOperationVO operationVO : markOrderDetailList) {
            List<Integer> servedNumList = new ArrayList<>();
            O_OrderDetailInfoEntity orderDetailInfo;
            if (null != operationVO.getRecordID()) {
                //查询套餐明细
                O_ComboDetailInfoEntity comboDetailInfo = comboDetailInfoDao.selectByPrimaryKey(operationVO.getRecordID());
                //查询订单明细
                orderDetailInfo = orderComponent.getOrderDetailInfoByID(comboDetailInfo.getDetailID());
            } else {
                //查询订单明细
                orderDetailInfo = orderComponent.getOrderDetailInfoByID(operationVO.getDetailID());
            }
            //根据订单明细ID查询套餐明细
            List<O_ComboDetailInfoEntity> comboDetails = comboDetailInfoDao.getComboDetailByDetailID(orderDetailInfo.getDetailID());
            if (CollectionUtils.isNotEmpty(comboDetails)) {
                for (O_ComboDetailInfoEntity comboDetail : comboDetails) {
                    //每份数量
                    int oneNum = comboDetail.getQuantity() / orderDetailInfo.getQuantity();
                    //计算订单明细的上菜数量
                    int servedNum = NumberUtil.intValue(comboDetail.getServedNum()) / oneNum;
                    servedNumList.add(servedNum);
                }
            }
            if (CollectionUtils.isNotEmpty(servedNumList)) {
                if (NumberUtil.intValue(Collections.min(servedNumList)) > 0) {
                    orderDetailInfo.setServedNum(Collections.min(servedNumList));
                    if (NumberUtil.intValue(orderDetailInfo.getServedNum()) == NumberUtil.intValue(orderDetailInfo.getQuantity())) {
                        orderDetailInfo.setProduceStatus(OrderManagerEnum.ProductionStatus.SERVINGALREADY.getValue());
                    }
                    orderDetailList.add(orderDetailInfo);
                }
            }
        }
        return orderDetailList;
    }


    /**
     * @Description： 需要修改的数据集合
     * @Author：LanZY
     * @Time: 2017-5-20 16:32
     * @Version 2.0.0
     */
    private void markOrderUpdateList(Set<Long> produceIDs, List<O_OrderDetailInfoEntity> orderDetailList, List<O_ComboDetailInfoEntity> comboDetailList, OrderDetailOperationVO operationVO, List<B_DesignerMonitorInfoEntity> designerMonitorInfoList, O_OrderDetailInfoEntity orderDetailInfo, O_ComboDetailInfoEntity comboDetailiInfo) {
        Integer quantity;
        Integer surplusNum;
        if (null != comboDetailiInfo) {
            quantity = comboDetailiInfo.getQuantity();
            surplusNum = comboDetailiInfo.getQuantity() - comboDetailiInfo.getServedNum();
        } else {
            quantity = null == orderDetailInfo.getQuantity() ? 1 : orderDetailInfo.getQuantity();
            surplusNum = quantity - orderDetailInfo.getServedNum();
        }
        if (operationVO.getQuantity() == quantity) {
            if (null != operationVO.getDetailID()) {
                orderDetailInfo.setDetailID(operationVO.getDetailID());
                orderDetailInfo.setServedNum(orderDetailInfo.getServedNum() + operationVO.getQuantity());
                if (orderDetailInfo.getNeedWeigh()) {
                    orderDetailInfo.setServedNum(1);
                }
                orderDetailInfo.setProduceStatus(OrderManagerEnum.ProductionStatus.SERVINGALREADY.getValue());
                orderDetailList.add(orderDetailInfo);
            }
            if (null != operationVO.getRecordID()) {
                comboDetailiInfo.setRecordID(operationVO.getRecordID());
                comboDetailiInfo.setServedNum(comboDetailiInfo.getServedNum() + operationVO.getQuantity());
                comboDetailiInfo.setProduceStatus(OrderManagerEnum.ProductionStatus.SERVINGALREADY.getValue());
                comboDetailList.add(comboDetailiInfo);
            }
            Set<Long> collect = CollectionHelper.collect(designerMonitorInfoList, (monitorInfo) -> monitorInfo.getProduceID());
            produceIDs.addAll(collect);
        } else {
            if (null != operationVO.getDetailID()) {
                if (operationVO.getQuantity() == surplusNum) {
                    orderDetailInfo.setProduceStatus(OrderManagerEnum.ProductionStatus.SERVINGALREADY.getValue());
                }
                orderDetailInfo.setDetailID(operationVO.getDetailID());
                orderDetailInfo.setServedNum(orderDetailInfo.getServedNum() + operationVO.getQuantity());
                if (orderDetailInfo.getNeedWeigh()) {
                    orderDetailInfo.setServedNum(1);
                }
                orderDetailList.add(orderDetailInfo);
            }
            if (null != operationVO.getRecordID()) {
                if (operationVO.getQuantity() == surplusNum) {
                    comboDetailiInfo.setProduceStatus(OrderManagerEnum.ProductionStatus.SERVINGALREADY.getValue());
                }
                comboDetailiInfo.setRecordID(operationVO.getRecordID());
                comboDetailiInfo.setServedNum(comboDetailiInfo.getServedNum() + operationVO.getQuantity());
                comboDetailList.add(comboDetailiInfo);
            }
            for (int i = 0; i < operationVO.getQuantity(); i++) {
                if (i < designerMonitorInfoList.size()) {
                    produceIDs.add(designerMonitorInfoList.get(i).getProduceID());
                }
            }
        }
    }

    /**
     * @Description： 套餐需要修改的数据集合
     * @Author：LanZY
     * @Time: 2017-5-24 18:42
     * @Version 2.0.0
     */
    private void markComboOrderUpdateList(Set<Long> produceIDs, List<O_OrderDetailInfoEntity> orderDetailList, List<O_ComboDetailInfoEntity> comboDetailList, OrderDetailOperationVO operationVO, O_OrderDetailInfoEntity orderDetailInfo, O_ComboDetailInfoEntity comboDetail, List<B_DesignerMonitorInfoEntity> designerMonitorInfoList) throws Exception {
        if (orderDetailInfo.getQuantity() == operationVO.getQuantity()) {
            Set<Long> collect = CollectionHelper.collect(designerMonitorInfoList, (monitorInfo) -> monitorInfo.getProduceID());
            produceIDs.addAll(collect);
            if (null != orderDetailInfo.getDetailID()) {
                orderDetailInfo.setProduceStatus(OrderManagerEnum.ProductionStatus.SERVINGALREADY.getValue());
                orderDetailInfo.setServedNum(operationVO.getQuantity());
                orderDetailList.add(orderDetailInfo);
            }
            if (null != comboDetail.getRecordID()) {
                comboDetail.setProduceStatus(OrderManagerEnum.ProductionStatus.SERVINGALREADY.getValue());
                Integer servedNum = comboDetail.getQuantity() / orderDetailInfo.getQuantity() * operationVO.getQuantity();
                comboDetail.setServedNum(servedNum);
                comboDetailList.add(comboDetail);
            }
        } else {
            Integer surplusNum = comboDetail.getQuantity() - comboDetail.getServedNum();
            if (operationVO.getQuantity() == surplusNum) {
                comboDetail.setProduceStatus(OrderManagerEnum.ProductionStatus.SERVINGALREADY.getValue());
                orderDetailInfo.setProduceStatus(OrderManagerEnum.ProductionStatus.SERVINGALREADY.getValue());
                orderDetailInfo.setServedNum(orderDetailInfo.getServedNum() + operationVO.getQuantity());
                orderDetailList.add(orderDetailInfo);
            } else {
                comboDetail.setProduceStatus(null);
            }
            if (null != comboDetail.getRecordID()) {
                Integer servedNum = comboDetail.getQuantity() / orderDetailInfo.getQuantity() * operationVO.getQuantity() + comboDetail.getServedNum();
                comboDetail.setServedNum(servedNum);
                comboDetailList.add(comboDetail);
            }
            int quantity = Integer.divideUnsigned(comboDetail.getQuantity(), orderDetailInfo.getQuantity());
            for (int i = 0; i < quantity * operationVO.getQuantity(); i++) {
                if (i < designerMonitorInfoList.size()) {
                    produceIDs.add(designerMonitorInfoList.get(i).getProduceID());
                }
            }
        }
    }

    //取消划单
    @Transactional(rollbackFor = Exception.class)
    public void cancelMarkOrderDetail(List<OrderDetailOperationVO> markOrderDetailList) throws Exception {
        //需要修改状态的看板信息
        Set<Long> produceIDs = new HashSet<>();
        //需要修改订单明细状态信息
        List<O_OrderDetailInfoEntity> orderDetailList = new ArrayList<>();
        //需要修改套餐明细状态信息
        List<O_ComboDetailInfoEntity> comboDetailList = new ArrayList<>();

        for (OrderDetailOperationVO operationVO : markOrderDetailList) {
            if (NumberUtil.intValue(operationVO.getQuantity()) == 0) {
                throw new BizException(CodeMsgConstants.CANCELMARKORDERDETAIL_NUMBER_ISNULL, CodeMsgConstants.CANCELMARKORDERDETAIL_NUMBER_ISNULL_MSG);
            }

            O_OrderDetailInfoEntity orderDetailInfo = null;
            O_ComboDetailInfoEntity comboDetailInfo = null;
            B_DesignerMonitorInfoEntity designerMonitorInfo = new B_DesignerMonitorInfoEntity();
            List<B_DesignerMonitorInfoEntity> designerMonitorInfoList = new ArrayList<>();
            Integer quantity;
            if (null != operationVO.getDetailID()) {
                orderDetailInfo = orderDetailInfoService.getOrderDetailInfoById(operationVO.getDetailID());
                if (null == orderDetailInfo) {
                    throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
                }
                if (!orderDetailInfo.getProduceStatus().equals(OrderManagerEnum.ProductionStatus.SERVINGALREADY.getValue())) {
                    throw new BizException(CodeMsgConstants.CANCELMARKORDERDETAIL_ERROR, CodeMsgConstants.CANCELMARKORDERDETAIL_ERROR_MSG, orderDetailInfo.getDetailID() + "" + orderDetailInfo.getProductName());
                }
                quantity = orderDetailInfo.getServedNum();
            } else {
                comboDetailInfo = new O_ComboDetailInfoEntity();
                comboDetailInfo.setRecordID(operationVO.getRecordID());
                comboDetailInfo = comboDetailInfoDao.get(comboDetailInfo);
                if (null == comboDetailInfo) {
                    throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
                }
                if (!comboDetailInfo.getProduceStatus().equals(OrderManagerEnum.ProductionStatus.SERVINGALREADY.getValue())) {
                    throw new BizException(CodeMsgConstants.CANCELMARKORDERDETAIL_ERROR, CodeMsgConstants.CANCELMARKORDERDETAIL_ERROR_MSG, comboDetailInfo.getRecordID() + "" + comboDetailInfo.getProductName());
                }
                quantity = comboDetailInfo.getServedNum();
            }
            //输入数量大于上菜数量
            if (operationVO.getQuantity() > quantity) {
                throw new BizException(CodeMsgConstants.CANCELMARKORDERDETAIL_NUMBER_ERROR, CodeMsgConstants.CANCELMARKORDERDETAIL_NUMBER_ERROR_MSG);
            }

            if (null != operationVO.getDetailID()) {
                //是否套餐
                if (orderDetailInfo.getIsCombo()) {
                    //查询套餐明细
                    O_ComboDetailInfoEntity comboInfo = new O_ComboDetailInfoEntity();
                    comboInfo.setDetailID(operationVO.getDetailID());
                    comboInfo.setProduceStatus(OrderManagerEnum.ProductionStatus.SERVINGALREADY.getValue());
                    List<O_ComboDetailInfoEntity> comboDetailInfoList = comboDetailInfoDao.getComboDetailInfoByDetailIDAndStatus(comboInfo);
                    for (O_ComboDetailInfoEntity comboDetail : comboDetailInfoList) {
                        //根据套餐明细查询看板记录
                        designerMonitorInfo.setRecordID(comboDetail.getRecordID());
                        designerMonitorInfo.setProduceStatus(OrderManagerEnum.ProductionStatus.SERVINGALREADY.getValue());
                        designerMonitorInfoList = designerMonitorInfoDao.getDesignerMonitorInfoByRecordID(designerMonitorInfo);

                        Integer comNum = comboDetail.getQuantity() / orderDetailInfo.getQuantity() * operationVO.getQuantity();
                        if (comNum > comboDetail.getServedNum()) {
                            throw new BizException(CodeMsgConstants.MARKORDERDETAIL_NUMBER_ERROR, "数量输入错误或不能点击套餐取消划单");
                        }
                        orderDetailInfo.setProduceStatus(OrderManagerEnum.ProductionStatus.INPRODUCTION.getValue());
                        orderDetailInfo.setServedNum(0);
                        orderDetailList.add(orderDetailInfo);
                        comboDetail.setProduceStatus(OrderManagerEnum.ProductionStatus.INPRODUCTION.getValue());
                        Integer servedNum = comboDetail.getServedNum() - comNum;
                        comboDetail.setServedNum(servedNum);
                        comboDetailList.add(comboDetail);
                        if (orderDetailInfo.getQuantity() == operationVO.getQuantity()) {
                            Set<Long> collect = CollectionHelper.collect(designerMonitorInfoList, (monitorInfo) -> monitorInfo.getProduceID());
                            produceIDs.addAll(collect);
                        } else {
                            int num = Integer.divideUnsigned(comboDetail.getQuantity(), orderDetailInfo.getQuantity());
                            for (int i = 0; i < num * operationVO.getQuantity(); i++) {
                                if (i < designerMonitorInfoList.size()) {
                                    produceIDs.add(designerMonitorInfoList.get(i).getProduceID());
                                }
                            }
                        }

                    }
                } else {
                    //根据明细查询看板记录
                    designerMonitorInfo.setDetailID(operationVO.getDetailID());
                    designerMonitorInfo.setProduceStatus(OrderManagerEnum.ProductionStatus.SERVINGALREADY.getValue());
                    designerMonitorInfoList = designerMonitorInfoDao.getDesignerMonitorInfoByDetailID(designerMonitorInfo);
                    orderDetailInfo.setServedNum(orderDetailInfo.getServedNum() - operationVO.getQuantity());
                    orderDetailInfo.setProduceStatus(OrderManagerEnum.ProductionStatus.INPRODUCTION.getValue());
                    orderDetailList.add(orderDetailInfo);
                    cancelMarkOrderUpdateList(produceIDs, designerMonitorInfoList, orderDetailInfo.getQuantity(), operationVO.getQuantity());
                }
            } else {
                //根据套餐明细查询看板记录
                designerMonitorInfo.setRecordID(operationVO.getRecordID());
                designerMonitorInfo.setProduceStatus(OrderManagerEnum.ProductionStatus.SERVINGALREADY.getValue());
                designerMonitorInfoList = designerMonitorInfoDao.getDesignerMonitorInfoByRecordID(designerMonitorInfo);
                orderDetailInfo = new O_OrderDetailInfoEntity();
                orderDetailInfo.setServedNum(0);
                orderDetailInfo.setDetailID(comboDetailInfo.getDetailID());
                orderDetailInfo.setProduceStatus(OrderManagerEnum.ProductionStatus.INPRODUCTION.getValue());
                orderDetailList.add(orderDetailInfo);

                comboDetailInfo.setServedNum(comboDetailInfo.getServedNum() - operationVO.getQuantity());
                comboDetailInfo.setProduceStatus(OrderManagerEnum.ProductionStatus.INPRODUCTION.getValue());
                comboDetailList.add(comboDetailInfo);
                cancelMarkOrderUpdateList(produceIDs, designerMonitorInfoList, comboDetailInfo.getQuantity(), operationVO.getQuantity());
            }

            if (CollectionUtils.isNotEmpty(designerMonitorInfoList)) {
                if (operationVO.getQuantity() > designerMonitorInfoList.size()) {
                    throw new BizException(CodeMsgConstants.CANCELMARKORDERDETAIL_NUMBER_ERROR, CodeMsgConstants.CANCELMARKORDERDETAIL_NUMBER_ERROR_MSG);
                }
            }
        }

        /**
         * 批量修改订单明细,套餐明细,看板明细记录
         */
        Map<String, Object> monitorMap = new HashedMap();
        monitorMap.put("list", produceIDs);
        monitorMap.put("produceStatus", OrderManagerEnum.ProductionStatus.INPRODUCTION.getValue());
        if (CollectionUtils.isNotEmpty(produceIDs)) {
            designerMonitorInfoDao.updateBatch(monitorMap);
        }
        if (CollectionUtils.isNotEmpty(comboDetailList)) {
            comboDetailInfoDao.updateBatch2(comboDetailList);
        }
        if (CollectionUtils.isNotEmpty(orderDetailList)) {
            orderDetailInfoDao.updateBatch2(orderDetailList);
        }
        orderDetailList = handleOrderDetailServedNum(markOrderDetailList);
        if (CollectionUtils.isNotEmpty(orderDetailList)) {
            orderDetailInfoDao.updateBatch2(orderDetailList);
        }
    }

    /**
     * @Description： 修改的数据集合
     * @Author：LanZY
     * @Time: 2017-5-25 13:50
     * @Version 2.0.0
     */
    private void cancelMarkOrderUpdateList(Set<Long> produceIDs, List<B_DesignerMonitorInfoEntity> designerMonitorInfoList, Integer quantity, Integer number) {
        if (number == quantity) {
            Set<Long> collect = CollectionHelper.collect(designerMonitorInfoList, (monitorInfo) -> monitorInfo.getProduceID());
            produceIDs.addAll(collect);
        } else {
            for (int i = 0; i < number; i++) {
                if (i < designerMonitorInfoList.size()) {
                    produceIDs.add(designerMonitorInfoList.get(i).getProduceID());
                }
            }
        }
    }


}
