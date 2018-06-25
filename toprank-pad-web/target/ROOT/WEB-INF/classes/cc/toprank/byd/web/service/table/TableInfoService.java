package cc.toprank.byd.web.service.table;

import cc.toprank.byd.common.utils.DateUtils;
import cc.toprank.byd.dao.*;
import cc.toprank.byd.entity.*;
import cc.toprank.byd.enums.MerchantManageEnum;
import cc.toprank.byd.enums.OrderManageEnum;
import cc.toprank.byd.web.vo.TableBookVO;
import cc.toprank.byd.web.vo.tablevo.AreaMessageVO;
import cc.toprank.byd.web.vo.tablevo.TableMessageVO;
import cc.toprank.byd.web.vo.tablevo.TableStatusCategoryMessageVO;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

/**
 * @Description： 为桌态图展示 提供数据
 * @Author：HuTao
 * @Time: 2017-3-13 9:39
 * @Version 2.0.0
 */
@Service("tableInfoService")
public class TableInfoService {
    @Autowired
    private ReceptionTableDao receptionTableService;

    @Autowired
    private ReceptionBookingInfoDao receptionBookingInfoService;

    @Autowired
    private B_ShopAreaInfoDao shopAreaInfoService;

    @Autowired
    private B_DinningTableUseInfoDao dinningTableUserInfoService;

    @Autowired
    private B_MealsInfoDao mealsInfoService;

    @Autowired
    private ReceptionBookingInfoDao receptionBookingInfoDao;

    @Autowired
    private O_SubOrderInfoDao subOrderInfoDao;
    @Autowired
    private B_DinningTableInfoDao dinningTableInfoDao;

    // 日志打印
    protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    // 请求参数列表
    private static final String PARAM_ARCHIVEID = "archiveID"; // 商户档案id
    private static final String PARAM_AREAID = "areaID"; // 区域id
    private static final String PARAM_STATUS = "status"; // 桌台状态
    private static final String PARAM_TABLEID = "tableID"; // 桌台编号
    private static final String PARAM_TABLENAME = "tableName"; // 桌台名称
    private static final String PARAM_BOOKINGTIME = "bookTime"; // 预订时间
    private static final String PARAM_DURATION = "duration";//就餐时长
    private static final Long LZERO = 0L;    // 全部

    /**
     * @param archiveID
     * @return
     * @Description：取当前时间的，餐次信息
     * @Author：HuTao
     * @Time: 2017-5-12 13:18
     * @Version 2.0.0
     */
    public Map<String, Object> getMealName(Long archiveID, Long areaID) {
        Map<String, Object> parm = new HashedMap();
        parm.put("archiveID", archiveID);
        if (!areaID.equals(LZERO)) {
            parm.put("areaID", areaID);
        }
        parm.put("time", LocalDateTime.now());
        B_MealsInfoEntity mapData = mealsInfoService.get_ReceptionB_MealsInfoByTimeAndArchiveID(parm);
        parm.clear();
        if (null != mapData) {
            parm.put("mealName", mapData.getMealName());
        } else {
            parm.put("mealName", "");
        }
        return parm;
    }

    /***
     * @Description：首頁获取餐厅区域分类列表并返回所有的餐桌列表 全部
     * @Author：HuTao
     * @Time: 2017-3-13 11:53
     * @Version 2.0.0
     * @param archiveID  档案ID
     * @return
     *
     */
    public List<AreaMessageVO> getAraeListByArchiveID(Long archiveID) {
        List<AreaMessageVO> resultList = new ArrayList<AreaMessageVO>();
        List<B_ShopAreaInfoEntity> areaList = shopAreaInfoService.getShopAreaInfoCollectionByArchiveID(archiveID);
        AreaMessageVO area = new AreaMessageVO();
        if (!areaList.isEmpty()) {
            area.setAreaID(LZERO);
            area.setAreaName("全部");
            resultList.add(0, area);
        } else {
            area.setAreaID(LZERO);
            area.setAreaName("全部");
            resultList.add(area);
        }
        for (B_ShopAreaInfoEntity InfoEntity : areaList) {
            AreaMessageVO areav = new AreaMessageVO();
            areav.setAreaID(InfoEntity.getAreaID());
            areav.setAreaName(InfoEntity.getAreaName());
            resultList.add(areav);
        }
        return resultList;
    }

    /**
     * @param archiveID
     * @return
     * @Description：餐桌状态分类
     * @Author：HuTao
     * @Time: 2017-3-13 16:01
     * @Version 2.0.0
     */
    public List<TableStatusCategoryMessageVO> getTableStatusCategory(Long archiveID, Long areaID) {
        Map<Object, Object> bookMap = new HashMap<>();
        bookMap.put(PARAM_ARCHIVEID, archiveID);
        bookMap.put(PARAM_BOOKINGTIME, DateUtils.formaterLocalDateTime(DateUtils.getUTCLocalDateTime()));
        bookMap.put(PARAM_DURATION, 30);
        if (!areaID.equals(0L)) {
            bookMap.put(PARAM_AREAID, areaID);
        }
        List<TableStatusCategoryMessageVO> reply = getTableCountByStatusAndArchiveID(bookMap);
        return reply;
    }

    /**
     * @param archiveID
     * @param status
     * @param tableName
     * @return
     * @Description：根据档案id和餐桌状态获取餐桌列表
     * @Author：HuTao
     * @Time: 2017-3-13 16:42
     * @Version 2.0.0
     */
    public List<TableMessageVO> getTableListByArchiveIDAndStatus(Long archiveID, Long areaID, Long status, String tableName) {
        //  桌台 预订606  空闲607   未下单652    已下单827   脏台609    暂结728   维修610
        // 查询桌台的条件(商家档案、状态)
        Map<String, Object> map = new HashMap<>();
        map.put(PARAM_ARCHIVEID, archiveID);
        // 如果要查询预订的桌台，先查出所有的空台，即将桌台状态置为空台
        if (status == MerchantManageEnum.TableStatus.PREDETERMINE.getValue()) {
            map.put(PARAM_STATUS, MerchantManageEnum.TableStatus.EMPTYTABLE.getValue());
        } else
            map.put(PARAM_STATUS, status);
        map.put(PARAM_TABLENAME, tableName);
        map.put(PARAM_AREAID, areaID);    //  区域
        // 获取预订桌子的条件
        Map<Object, Object> bookMap = new HashMap<>();
        bookMap.put(PARAM_ARCHIVEID, archiveID);
        bookMap.put(PARAM_BOOKINGTIME, DateUtils.getCurrentDateTime());
        bookMap.put(PARAM_DURATION, 30);
        // 获取当前状态下的桌子
        List<TableMessageVO> tableMessages = new ArrayList<>();
        //全部桌台
        TableMessageVO tableMessageVO = null;
        if (areaID.equals(LZERO) && status.equals(LZERO)) {      //   全部
            map.remove(PARAM_AREAID);
            map.remove(PARAM_STATUS);
            map.remove(PARAM_TABLENAME);
            List<O_SubOrderInfoEntity> entityList = subOrderInfoDao.getAllTableListByTableStatusAreaID(map);
            setTableMessage(entityList, tableMessages);
            setBookingTable(archiveID, tableMessages);      //  处理预定信息
        } else if (!areaID.equals(LZERO) && status.equals(LZERO)) {    //  按区域
            map.remove(PARAM_TABLENAME);
            map.remove(PARAM_STATUS);
            List<O_SubOrderInfoEntity> entityList = subOrderInfoDao.getAllTableListByTableStatusAreaID(map);
            setTableMessage(entityList, tableMessages);
            setBookingTable(archiveID, tableMessages);      //  处理预定信息
        } else if (areaID.equals(LZERO) && !status.equals(LZERO)) {     //  按桌台状态
            setAreaStatusTableMessage(map, archiveID, areaID, status, tableMessages);
            setAreaStatusBookingTable(archiveID, tableMessages);      //  处理预定信息
        } else {                    //  按区域 ,桌台状态
            setAreaStatusTableMessage(map, archiveID, areaID, status, tableMessages);
            setAreaStatusBookingTable(archiveID, tableMessages);      //  处理预定信息
        }
        return tableMessages;
    }

    /**
     * @param archiveID
     * @param tableName
     * @return
     * @Description： 搜索餐桌
     * @Author：HuTao
     * @Time: 2017-3-16 9:51
     * @Version 2.0.0
     */

    public List<TableMessageVO> getTableInfoByTableName(Long archiveID, String tableName) {
        TableMessageVO tableMessage = null;
        List<TableMessageVO> messageListResult = new ArrayList<>();
        // 搜索桌台的条件
        Map<String, Object> map = new HashMap<>();
        map.put(PARAM_ARCHIVEID, archiveID);
        map.put(PARAM_TABLENAME, tableName);
        // 获取预订桌子的条件
        Map<Object, Object> bookMap = new HashMap<>();
        bookMap.put(PARAM_ARCHIVEID, archiveID);
        bookMap.put(PARAM_BOOKINGTIME, DateUtils.getCurrentDateTime());
        bookMap.put(PARAM_DURATION, 30);
        // 搜索到的桌子
        List<O_SubOrderInfoEntity> entityList = subOrderInfoDao.getAllTableListByTableStatusAreaID(map);
        if (!entityList.isEmpty()) {//搜索到的桌子不为空
            for (O_SubOrderInfoEntity subOrderInfo : entityList) {
                tableMessage = new TableMessageVO();
                tableMessage.setAreaID(subOrderInfo.getAreaID());
                tableMessage.setTableID(subOrderInfo.getbTableID());
                tableMessage.setDefaultPerson(subOrderInfo.getDefaultPerson());
                setTableInfor(tableMessage, subOrderInfo);  //设置桌台信息
                messageListResult.add(tableMessage);
            }
            setBookingTable(archiveID, messageListResult);      //  处理预定信息
        }
        return messageListResult;
    }

    /**
     * @param entity       桌台
     * @param tableMessage message消息
     * @param accountMap
     * @param useTable     使用信息
     * @return 返回 TableMessageVO
     * @Description：初始化桌台message
     * @Author：HuTao
     * @Time: 2017-3-16 9:35
     * @Version 2.0.0
     */

    private TableMessageVO initTableMessage(ReceptionTableEntity entity, TableMessageVO tableMessage, Map<Object, Object> accountMap, B_DinningTableUseInfoEntity useTable) {
        TableMessageVO reply = tableMessage;
        if (entity.getTableStatus() == MerchantManageEnum.TableStatus.PLACEMAN.getValue()) {//桌台处于在用
            //进行中的订单  桌台在用
            accountMap.put("orderStatus", OrderManageEnum.OrderStatus.HAVEINHAND.getValue());
        } else if (entity.getTableStatus() == MerchantManageEnum.TableStatus.STOPTABLE.getValue()) {
            //待结账的订单  桌台暂结
            accountMap.put("orderStatus", OrderManageEnum.OrderStatus.TOBECHECKED.getValue());
        }
        //   处理  拼台数  时间长,  联台标识
        if (reply.getTableStatus().equals(MerchantManageEnum.TableStatus.PLACEMAN.getValue()) ||       // 桌台处于使用状态
                reply.getTableStatus().equals(MerchantManageEnum.TableStatus.PLACEORDER.getValue())) {   //   桌台处于开台状态
            ReceptionUsingTableEntity dataMap = receptionBookingInfoService.getTogetherNumTimes(accountMap);
            if (dataMap != null) {
                //  reply.setShareNumber(dataMap.getTogetherNum());   //  拼台数
                reply.setTimes(dataMap.getTimes());               //   时间
                reply.setCombineName(dataMap.getCombineName());  //  联台标识
                reply.setCustomerNumber(dataMap.getPeopleNum());
            }
        }
        if (entity.getTableStatus() == MerchantManageEnum.TableStatus.PLACEMAN.getValue() ||
                entity.getTableStatus() == MerchantManageEnum.TableStatus.PLACEORDER.getValue()) {// 桌台处于使用状态
            ReceptionUsingTableEntity resultMap = receptionBookingInfoService.getTableInfoActualAmountByCondition(accountMap);
            if (resultMap != null) {
                reply.setActualAmount(resultMap.getActualAmount());
                reply.setOrderID(resultMap.getOrderID());
                reply.setSubOrderID(resultMap.getSubOrderID());
            }
            reply.setCustomerNumber(useTable.getCustomerNumber() == null ? entity.getDefaultPerson() : useTable.getCustomerNumber());
            reply.setMealsID(useTable.getMealsID());
        } else if (entity.getTableStatus() == MerchantManageEnum.TableStatus.STOPTABLE.getValue()) {// 桌台处于暂结状态
            ReceptionUsingTableEntity resultMap = receptionBookingInfoService.getTableInfoActualAmountByCondition(accountMap);
            reply.setActualAmount(resultMap.getActualAmount());
            reply.setOrderID(resultMap.getOrderID());
            reply.setSubOrderID(resultMap.getSubOrderID());
            reply.setCustomerNumber(useTable.getCustomerNumber() == null ? entity.getDefaultPerson() : useTable.getCustomerNumber());
            reply.setMealsID(useTable.getMealsID());
        }
        return reply;
    }

    /**
     * @param entity
     * @param tableMessage 消息对象
     * @param bookList     预订列表
     * @return TableMessageVO消息
     * @Description：预订加上TableMessageVO格式化
     * @Author：HuTao
     * @Time: 2017-3-16 9:30
     * @Version 2.0.0
     */

    private TableMessageVO initBookingTable(ReceptionTableEntity entity, TableMessageVO tableMessage, List<ReceptionBookingInfoEntity> bookList) {
        TableMessageVO reply = tableMessage;
        for (ReceptionBookingInfoEntity bookEntity : bookList) {
            if (StringUtils.isBlank(bookEntity.getTableCodes())) {
                continue;
            }
            String[] codesList = bookEntity.getTableCodes().split(",");
            for (String code : codesList) {
                if (entity.getTableCode().equals(code)) {
                    reply.setNickName(bookEntity.getBookingDesc() == null ? "" : bookEntity.getBookingDesc());
                    reply.setCustomerNumber(bookEntity.getPeopleNum());
                    reply.setBookingID(bookEntity.getBookingID());
                    reply.setOrderID(bookEntity.getOrderID());
                    reply.setLoginID(bookEntity.getLoginID());
                    reply.setTableStatus(MerchantManageEnum.TableStatus.PREDETERMINE.getValue());
                    return reply;
                }
            }
        }
        return tableMessage;
    }

    /**
     * @param entity 使用桌台
     * @return B_DiningTableUseInfoEntity桌台使用信息对象
     * @Description：初始化餐次ID为空的
     * @Author：HuTao
     * @Time: 2017-3-16 9:26
     * @Version 2.0.0
     */

    private B_DinningTableUseInfoEntity initMealsID(B_DinningTableUseInfoEntity entity) {
        B_DinningTableUseInfoEntity userTable = entity;
        if (userTable == null) {//没有使用信息就新建一个并设置餐次为0
            userTable = new B_DinningTableUseInfoEntity();
            userTable.setMealsID(LZERO);
        } else if (userTable.getMealsID() == null) {//如果餐次id为空就设置为0
            userTable.setMealsID(LZERO);
        }
        return userTable;
    }

    /**
     * @param map
     * @return
     * @Description：根据机构id,桌台状态查询桌台数量
     * @Author：HuTao
     * @Time: 2017-3-16 9:26
     * @Version 2.0.0
     */
    public List<TableStatusCategoryMessageVO> getTableCountByStatusAndArchiveID(Map map) {
        List<TableStatusCategoryMessageVO> tableStatusList = new ArrayList<>();
        // 获取预订桌子的条件
        int count = 0;
        TableStatusCategoryMessageVO entity = new TableStatusCategoryMessageVO();
        // 获取所有的预订信息
        Map<String, Object> mapCount = receptionBookingInfoDao.getBookingInfoCount(map);
        if (null != mapCount && !mapCount.isEmpty()) {
            count = Integer.parseInt(null == mapCount.get("bCount") ? "0" : mapCount.get("bCount").toString());
        }

        //桌台的各种种状态、获取各种状态下的桌台数
        List<Long> statusList = new ArrayList<>();
        statusList.add(MerchantManageEnum.TableStatus.EMPTYTABLE.getValue());   // 空台
        statusList.add(MerchantManageEnum.TableStatus.PLACEORDER.getValue());   // 开台
        statusList.add(MerchantManageEnum.TableStatus.PLACEMAN.getValue());     // 服务中
        statusList.add(MerchantManageEnum.TableStatus.STOPTABLE.getValue());    // 暂结
        statusList.add(MerchantManageEnum.TableStatus.PREDETERMINE.getValue());     //  预定
        statusList.add(MerchantManageEnum.TableStatus.DIRTYTABLE.getValue());   // 脏台
        statusList.add(MerchantManageEnum.TableStatus.MAINTAIN.getValue());     // 维护

        int tempCount = 0;
        for (Long status : statusList) {
            TableStatusCategoryMessageVO tempEntity = new TableStatusCategoryMessageVO();
            map.put(PARAM_STATUS, status);
            if (status.equals(MerchantManageEnum.TableStatus.PREDETERMINE.getValue())) {//  预定
                tempCount = count;
            } else if (status.equals(MerchantManageEnum.TableStatus.EMPTYTABLE.getValue()) || status.equals(MerchantManageEnum.TableStatus.MAINTAIN.getValue())) {
                tempCount = dinningTableInfoDao.getTableCountByStatusAndArchiveID(map);

            } else {
                if (status.equals(MerchantManageEnum.TableStatus.DIRTYTABLE.getValue())) {   // 脏台
                    map.put(PARAM_STATUS, OrderManageEnum.OrderStatus.ALREADYPAID.getValue());
                } else if (status.equals(MerchantManageEnum.TableStatus.PLACEORDER.getValue())) {   //  开台
                    map.put(PARAM_STATUS, OrderManageEnum.OrderStatus.NOORDER.getValue());
                } else if (status.equals(MerchantManageEnum.TableStatus.PLACEMAN.getValue())) {   //  已下单
                    map.put(PARAM_STATUS, OrderManageEnum.OrderStatus.HAVEINHAND.getValue());
                } else  //  暂结
                    map.put(PARAM_STATUS, OrderManageEnum.OrderStatus.TOBECHECKED.getValue());

                tempCount = subOrderInfoDao.getTableCountByStatusAndArchiveID(map);
            }
            tempEntity.setStatus(status);
            tempEntity.setCount(tempCount);
            tableStatusList.add(tempEntity);
        }
        int totalStatus = 0;

        tableStatusList.get(0).setCount(tableStatusList.get(0).getCount()- tableStatusList.get(4).getCount());   //  原空台数 包括了 预定数   ,  展示中减去预定数

        for (TableStatusCategoryMessageVO statueVo : tableStatusList) {
            totalStatus = totalStatus + statueVo.getCount();
        }
        TableStatusCategoryMessageVO entitytotalStatus = new TableStatusCategoryMessageVO();
        entitytotalStatus.setStatus(LZERO);
        entitytotalStatus.setCount(totalStatus);
        tableStatusList.add(0, entitytotalStatus);
        return tableStatusList;
    }

    /**
     * @param tableMessageVO
     * @param subOrderInfo
     * @Description：桌台信息处理
     * @Author：HuTao
     * @Time: 2017-4-26 11:09
     * @Version 2.0.0
     */

    private void setTableInfor(TableMessageVO tableMessageVO, O_SubOrderInfoEntity subOrderInfo) {
        tableMessageVO.setAreaID(subOrderInfo.getAreaID());
        tableMessageVO.setTableID(subOrderInfo.getbTableID());
        tableMessageVO.setDefaultPerson(subOrderInfo.getDefaultPerson());
        if (null != subOrderInfo.getOrderStatus()) {
            tableMessageVO.setCustomerNumber(null == subOrderInfo.getPeopleNum() ? 0 : subOrderInfo.getPeopleNum());
            if (subOrderInfo.getOrderStatus().equals(OrderManageEnum.OrderStatus.NOORDER.getValue())) {    //  开台
                tableMessageVO.setTableStatus(MerchantManageEnum.TableStatus.PLACEORDER.getValue());
            } else if (subOrderInfo.getOrderStatus().equals(OrderManageEnum.OrderStatus.HAVEINHAND.getValue())) {   //  已下单
                tableMessageVO.setTableStatus(MerchantManageEnum.TableStatus.PLACEMAN.getValue());
            } else if (subOrderInfo.getOrderStatus().equals(OrderManageEnum.OrderStatus.TOBECHECKED.getValue()) ||
                    subOrderInfo.getOrderStatus().equals(OrderManageEnum.OrderStatus.WAITINGPAY.getValue())) {  //  暂结    //   WAITINGPAY(59, "待支付"),
                tableMessageVO.setTableStatus(MerchantManageEnum.TableStatus.STOPTABLE.getValue());
            } else if (subOrderInfo.getOrderStatus().equals(OrderManageEnum.OrderStatus.ALREADYPAID.getValue())) {   //  脏台
                tableMessageVO.setTableStatus(MerchantManageEnum.TableStatus.DIRTYTABLE.getValue());
                tableMessageVO.setCustomerNumber(0);
            } else
                tableMessageVO.setTableStatus(Long.valueOf(subOrderInfo.getTableStatus()));
            tableMessageVO.setNickName(subOrderInfo.getNickName());
            tableMessageVO.setTimes(subOrderInfo.getTimes());
            tableMessageVO.setCombineName(subOrderInfo.getCombineName());
            tableMessageVO.setActualAmount(subOrderInfo.getActualAmount().doubleValue());
            tableMessageVO.setMealsID(subOrderInfo.getMealsID());
            tableMessageVO.setOrderID(subOrderInfo.getOrderID());
            tableMessageVO.setSubOrderID(subOrderInfo.getSubOrderID());
            tableMessageVO.setTableName(subOrderInfo.getbTableName());     //  订单桌台名
            tableMessageVO.setShareTableName(subOrderInfo.getTableName()); //  原桌台名
            tableMessageVO.setAreaType(subOrderInfo.getAreaType());
            tableMessageVO.setAreaTypeName(subOrderInfo.getAreaTypeName());
        } else {
            tableMessageVO.setTableStatus(Long.valueOf(subOrderInfo.getTableStatus()));
            tableMessageVO.setTableName(subOrderInfo.getbTableName());
            tableMessageVO.setCustomerNumber(0);
        }
    }

    /**
     * @param archiveID
     * @return
     * @Description：根据当前档案ID , 取预定信息.
     * @Author：HuTao
     * @Time: 2017-5-11 11:59
     * @Version 2.0.0
     */
    private List<ReceptionBookingInfoEntity> getBookingInfo(Long archiveID) {
        Map<Object, Object> bookMap = new HashMap<>();
        bookMap.put(PARAM_ARCHIVEID, archiveID);
        ;
        bookMap.put(PARAM_BOOKINGTIME, DateUtils.formaterLocalDateTime(DateUtils.getUTCLocalDateTime()));
        List<ReceptionBookingInfoEntity> bookinglist = receptionBookingInfoService.getBookingInfoCollection(bookMap);
        return bookinglist;
    }

    /**
     * @Description：检查当前tableID,是否预定
     * @Author：HuTao
     * @Time: 2017-6-16 13:25
     * @Version 2.0.0
     * @param tableID
     * @param boolingList
     * @return
     */
    private  boolean checkBookingTableID(Long tableID, List<ReceptionBookingInfoEntity> boolingList) {
        boolean result=false;
        if (!CollectionUtils.isEmpty(boolingList)) {
            for (ReceptionBookingInfoEntity infoEntity : boolingList) {
                if (tableID.equals(infoEntity.getTableID())) {
                    result=true;
                    break;
                }
            }
        }
        return  result;
    }

    /**
     * @param tableVO
     * @param boolingList
     * @return
     * @Description： 检查当前 tableID;是否聚预定
     * @Author：HuTao
     * @Time: 2017-5-11 14:28
     * @Version 2.0.0
     */
    private void setCheckTableID(TableMessageVO tableVO, List<ReceptionBookingInfoEntity> boolingList) {
        if (!CollectionUtils.isEmpty(boolingList)) {
            for (ReceptionBookingInfoEntity infoEntity : boolingList) {
                Long tableID = tableVO.getTableID();
                if (tableID.equals(infoEntity.getTableID())) {
                    tableVO.setBookingID(infoEntity.getBookingID());       //  预定ID
                    tableVO.setTableStatus(MerchantManageEnum.TableStatus.PREDETERMINE.getValue());
                }
            }
        }
    }

    /**
     * @param tableID
     * @param boolingList
     * @return
     * @Description： 检查当前 tableID;是否聚预定
     * @Author：HuTao
     * @Time: 2017-5-11 14:28
     * @Version 2.0.0
     */
    private Long getCheckTableID(Long tableID, List<ReceptionBookingInfoEntity> boolingList) {
        Long bookingID = 0L;
        if (!CollectionUtils.isEmpty(boolingList)) {
            for (ReceptionBookingInfoEntity infoEntity : boolingList) {
                if (tableID.equals(infoEntity.getTableID())) {
                    bookingID = infoEntity.getBookingID();
                    break;
                }
            }
        }
        return bookingID;
    }

    /**
     * @param entityList
     * @param tableMessages
     * @Description：设置 空闲桌台  维修桌台信息
     * @Author：HuTao
     * @Time: 2017-6-9 11:11
     * @Version 2.0.0
     */
    private void setDinningTableMessage(List<B_DinningTableInfoEntity> entityList, List<TableMessageVO> tableMessages) {
        if (!CollectionUtils.isEmpty(entityList)) {     //搜索到的桌子不为空
            for (B_DinningTableInfoEntity InfoEntity : entityList) {
                TableMessageVO tableMessageVO = new TableMessageVO();
                tableMessageVO.setTableID(InfoEntity.getTableID());
                tableMessageVO.setTableStatus(InfoEntity.getTableStatus());
                tableMessageVO.setTableName(InfoEntity.getTableName());
                tableMessageVO.setDefaultPerson(InfoEntity.getDefaultPerson());
                tableMessageVO.setCustomerNumber(0);
                tableMessageVO.setAreaType(InfoEntity.getAreaType());
                tableMessages.add(tableMessageVO);
            }
        }
    }

    /**
     * @param entityList
     * @param tableMessages
     * @Description：将返回来的，桌台子订单信息，转换成桌台VO
     * @Author：HuTao
     * @Time: 2017-5-15 9:41
     * @Version 2.0.0
     */

    private void setTableMessage(List<O_SubOrderInfoEntity> entityList, List<TableMessageVO> tableMessages) {
        if (!CollectionUtils.isEmpty(entityList)) {     //搜索到的桌子不为空
            for (O_SubOrderInfoEntity subOrderInfo : entityList) {
                TableMessageVO tableMessageVO = new TableMessageVO();
                setTableInfor(tableMessageVO, subOrderInfo);  //设置桌台信息
                tableMessages.add(tableMessageVO);
            }
        }
    }

    /**
     * @param dinningTableList
     * @param boolingList
     * @param tableMessages
     * @Description：将返回来的预定信息，桌台子订单信息，转换成桌台VO
     * @Author：HuTao
     * @Time: 2017-5-15 9:47
     * @Version 2.0.0
     */
    private void setBookingTableMessage(List<B_DinningTableInfoEntity> dinningTableList, List<ReceptionBookingInfoEntity> boolingList, List<TableMessageVO> tableMessages) {
        if (!CollectionUtils.isEmpty(dinningTableList)) {
            for (B_DinningTableInfoEntity infoEntity : dinningTableList) {
                Long bookingID = getCheckTableID(infoEntity.getTableID(), boolingList);
                if (!bookingID.equals(0L)) {
                    TableMessageVO tableMessageVO = new TableMessageVO();
                    tableMessageVO.setAreaID(infoEntity.getAreaID());
                    tableMessageVO.setTableID(infoEntity.getTableID());
                    tableMessageVO.setDefaultPerson(infoEntity.getDefaultPerson());
                    tableMessageVO.setTableName(infoEntity.getTableName());     //  订单桌台名
                    tableMessageVO.setAreaType(infoEntity.getAreaType());
                    tableMessageVO.setAreaTypeName(infoEntity.getAreaTypeName());
                    tableMessageVO.setBookingID(bookingID);
                    tableMessageVO.setTableStatus(MerchantManageEnum.TableStatus.PREDETERMINE.getValue());
                    tableMessages.add(tableMessageVO);
                }
            }
        }
    }

    /**
     * @param map
     * @param archiveID
     * @param areaID
     * @param status
     * @param tableMessages
     * @Description：设置区域桌台信息
     * @Author：HuTao
     * @Time: 2017-6-9 11:08
     * @Version 2.0.0
     */
    private void setAreaStatusTableMessage(Map<String, Object> map, Long archiveID, Long areaID, Long status, List<TableMessageVO> tableMessages) {
        map.remove(PARAM_TABLENAME);
        if (areaID.equals(LZERO)) {
            map.remove("areaID");
        }
        //  预订606  预订桌台处理
        if (status.equals(MerchantManageEnum.TableStatus.PREDETERMINE.getValue())) {
            List<ReceptionBookingInfoEntity> boolingList = getBookingInfo(archiveID);  // 预订
            List<B_DinningTableInfoEntity> dinningTableList = dinningTableInfoDao.getDinningTableInfoArchiveIDAndAreaID(map);
            setBookingTableMessage(dinningTableList, boolingList, tableMessages);
        } else if (status.equals(MerchantManageEnum.TableStatus.EMPTYTABLE.getValue()) || status.equals(MerchantManageEnum.TableStatus.MAINTAIN.getValue())) {
            //  空台  维修
            List<B_DinningTableInfoEntity> entityList = dinningTableInfoDao.getDinningTableInfoArchiveIDAndAreaID(map);
            setDinningTableMessage(entityList, tableMessages);
        } else {     //   // 未下单652    已下单827   脏台609    暂结728
            //  按子订单 取桌台信息     archiveID, Long areaID, Long status,
            Map<String, Object> parm = new HashMap<>();
            parm.put("archiveID", archiveID);
            if (!areaID.equals(LZERO)) {
                parm.put("areaID", areaID);
            }
            if (status.equals(MerchantManageEnum.TableStatus.DIRTYTABLE.getValue())) {    // 脏台609
                parm.put("orderStatus", OrderManageEnum.OrderStatus.ALREADYPAID.getValue());
            } else if (status.equals(MerchantManageEnum.TableStatus.PLACEORDER.getValue())) {   // 未下单652
                parm.put("orderStatus", OrderManageEnum.OrderStatus.NOORDER.getValue());
            } else if (status.equals(MerchantManageEnum.TableStatus.PLACEMAN.getValue())) {   // 已下单827
                parm.put("orderStatus", OrderManageEnum.OrderStatus.HAVEINHAND.getValue());
            } else
                parm.put("orderStatus", OrderManageEnum.OrderStatus.TOBECHECKED.getValue());   //   暂结728
            List<O_SubOrderInfoEntity> entityList = subOrderInfoDao.getAllTableListByTableStatusAreaID(parm);   //getSubOrderTableByStatus
            setTableMessage(entityList, tableMessages);
        }
    }

    /**
     * @param archiveID
     * @param tableMessages
     * @Description：设置 预定桌台信息
     * @Author：HuTao
     * @Time: 2017-6-9 11:06
     * @Version 2.0.0
     */
    private void setBookingTable(Long archiveID, List<TableMessageVO> tableMessages) {
        if (!CollectionUtils.isEmpty(tableMessages)) {
            List<ReceptionBookingInfoEntity> boolingList = getBookingInfo(archiveID);  // 预订
            if (CollectionUtils.isEmpty(boolingList)) {
                return;
            }
            for (TableMessageVO tableVO : tableMessages) {
                Long TableStatus = tableVO.getTableStatus();
//                if (TableStatus.equals(MerchantManageEnum.TableStatus.EMPTYTABLE.getValue())) {
                    setCheckTableID(tableVO, boolingList);
//                }
            }
        }
    }

    /**
     * @Description：
     * @Author：HuTao
     * @Time: 2017-6-16 12:18
     * @Version 2.0.0
     * @param archiveID
     * @param tableMessages
     */
    private void setAreaStatusBookingTable(Long archiveID, List<TableMessageVO> tableMessages) {   //  处理预定信息
        if (!CollectionUtils.isEmpty(tableMessages)) {
            List<ReceptionBookingInfoEntity> boolingList = getBookingInfo(archiveID);  // 预订
            if (CollectionUtils.isEmpty(boolingList)) {
                return;
            }
            for (int i=tableMessages.size()-1;i>=0;i-- ) {
                TableMessageVO tableVO=tableMessages.get(i);
                Long TableStatus = tableVO.getTableStatus();
                if (TableStatus.equals(MerchantManageEnum.TableStatus.EMPTYTABLE.getValue())) {
                   if(checkBookingTableID(tableVO.getTableID(),boolingList)){
                       tableMessages.remove(tableVO);
                   }
                    
                }
            }
        }
    }     
    

    /**
     * @Description：根据预订单ID,获取预订的桌台信息
     * @Author：Zhaolingchen
     * @Time: 2017-6-14 14:00
     * @Version 2.0.0
     * @return
     */
    public List<B_DinningTableInfoEntity> queryBookingTableListByBookingID(Long bookingID){
        return dinningTableInfoDao.queryBookingTableListByBookingID(bookingID);
    }
}
