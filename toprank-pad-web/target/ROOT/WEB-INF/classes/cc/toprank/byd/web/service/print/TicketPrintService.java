package cc.toprank.byd.web.service.print;

import cc.toprank.byd.common.utils.DateUtils;
import cc.toprank.byd.common.utils.json.JSONUtils;
import cc.toprank.byd.dao.B_MerchantInfoDao;
import cc.toprank.byd.dao.O_TicketPrintDealInfoDao;
import cc.toprank.byd.dao.O_TicketPrintInfoDao;
import cc.toprank.byd.dao.U_LoginInfoDao;
import cc.toprank.byd.entity.B_MerchantInfoEntity;
import cc.toprank.byd.enums.MerchantManageEnum;
import cc.toprank.byd.util.EnumUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cc.toprank.byd.entity.O_OrderDetailInfoEntity;
import cc.toprank.byd.entity.O_TicketPrintInfoEntity;
import cc.toprank.byd.entity.U_LoginInfoEntity;
import cc.toprank.byd.web.vo.printvo.AccountPrintVO;
import cc.toprank.byd.web.vo.printvo.AdvancePrintVO;
import cc.toprank.byd.web.vo.printvo.AllCancelPrintVO;
import cc.toprank.byd.web.vo.printvo.AllCookroomPrintVO;
import cc.toprank.byd.web.vo.printvo.CancelCartePrintVO;
import cc.toprank.byd.web.vo.printvo.CarteListVO;
import cc.toprank.byd.web.vo.printvo.CartePrintVO;
import cc.toprank.byd.web.vo.printvo.ConnectPrintVO;
import cc.toprank.byd.web.vo.printvo.CookroomListVO;
import cc.toprank.byd.web.vo.printvo.PayTypeVO;
import cc.toprank.byd.web.vo.printvo.PlatBillVO;
import cc.toprank.byd.web.vo.printvo.SingleCancelVO;
import cc.toprank.byd.web.vo.printvo.SingleDishVO;
import cc.toprank.byd.web.vo.printvo.TablePrintVO;
import cc.toprank.byd.web.vo.printvo.CancelMenuVO;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @Description：票据打印服务
 * @Author：HuTao
 * @Time: 2017-3-10 17:19
 * @Version 2.0.0
 */

@Service
public class TicketPrintService {
    // 日志打印
    protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private O_TicketPrintInfoDao ticketPrintInfoService; // 票据打印信息

    @Autowired
    private B_MerchantInfoDao merchantInfoService;       // 商户档案信息

    @Autowired
    private U_LoginInfoDao loginInfoService; // 登录信息

    B_MerchantInfoEntity merchantinfo = null; // 档案信息

    @Autowired
    private O_TicketPrintDealInfoDao o_TicketPrintDealInfoDao;

    /**
     * @param orderID   订单号
     * @param archiveID 档案ID
     * @param loginID   登入ID
     * @return
     * @Description：生成 台单
     * @Author：HuTao
     * @Time: 2017-3-10 17:16
     * @Version 2.0.0
     */

    //  返回定义   0 失败  1 成功  2 没有取到配置信息
    @Transactional
    public String ticketReceiptData(String orderID, String archiveID, String loginID) {
        String result = "0";
        String orderCode = "";
        try {
            // 此处 orderID 传过来是子订单号subOrderID 使用订单号 取订单号，档案ID
            String subOrderID = orderID;
            Map<String, Object> dataMap = ticketPrintInfoService.getArchiveID(subOrderID);
            archiveID = dataMap.get("ArchiveID").toString();
            orderID = dataMap.get("OrderID").toString();
            orderCode = dataMap.getOrDefault("OrderCode", "").toString();
            iniInfo(archiveID, orderID);
            // 菜品明细数据 test
            Map<String, String> conMap = new HashMap<String, String>();
            conMap.put("OrderID", orderID);
            conMap.put("ArchiveID", archiveID);
            // 台单
            List<O_OrderDetailInfoEntity> dataList = ticketPrintInfoService.getMenuList(conMap);
            O_TicketPrintInfoEntity ticketPrintdata = null;
            ticketPrintdata = getTablePrintData(dataList, archiveID, orderCode);
            ticketPrintdata.setCreatorID(Long.valueOf(loginID));
            ticketPrintdata.setIsSync(false);
            ticketPrintInfoService.save(ticketPrintdata);
//            for (O_OrderDetailInfoEntity infoEntity:dataList){
//
//            }
            result = "1";
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("ticketReceiptData 生成台单:" + e.getMessage());
            result = "2";
        }
        return result;
    }


    /**
     * @param orderID   订单号
     * @param archiveID 档案ID
     * @param loginID   登入ID
     * @return
     * @Description：生成票据打印数据 // 台单 , 厨房总单 厨房小单 , 传菜总单( 出品总单 )
     * @Author：HuTao
     * @Time: 2017-3-10 17:15
     * @Version 2.0.0
     */

    public String orderReceiptData(String orderID, String archiveID, String loginID) {
        String result = "0";
        String orderCode = "";
        List<O_TicketPrintInfoEntity> printDataList = new ArrayList();
        try {
            // 此处 orderID 传过来是子订单号subOrderID 使用订单号 取订单号，档案ID
            String subOrderID = orderID;
            Map<String, Object> daMap = ticketPrintInfoService.getArchiveID(subOrderID);
            archiveID = daMap.get("ArchiveID").toString();
            orderID = daMap.get("OrderID").toString();
            orderCode = daMap.getOrDefault("OrderCode", "").toString();
            iniInfo(archiveID, orderID);
            // 菜品明细数据
            Map<String, String> conMap = new HashMap();
            conMap.put("OrderID", orderID);
            conMap.put("ArchiveID", archiveID);
            List<O_OrderDetailInfoEntity> dataList = ticketPrintInfoService.getMenuList(conMap);
            O_TicketPrintInfoEntity ticketPrintdata = null;
            // 台单
            ticketPrintdata = getTablePrintData(dataList, archiveID, orderCode);
            ticketPrintdata.setCreatorID(Long.valueOf(loginID));
            ticketPrintdata.setIsSync(false);
            printDataList.add(ticketPrintdata);
            // 传菜总单 ( 出品总单 )
            ticketPrintdata = getPassPrintData(dataList, archiveID, orderCode);
            ticketPrintdata.setCreatorID(Long.valueOf(loginID));
            ticketPrintdata.setIsSync(false);
            printDataList.add(ticketPrintdata);
            String ticketCode = "TotalTicket"; // 厨房总单
            Map<String, Object> allPrintConfig = getPrintConfigtInfo(ticketCode, archiveID);
            ticketPrintdata = getAllCookroomPrintData(dataList, allPrintConfig, orderCode);
            ticketPrintdata.setCreatorID(Long.valueOf(loginID));
            ticketPrintdata.setIsSync(false);
            printDataList.add(ticketPrintdata);
            // -----------------------------------
            ticketCode = "SingleTicket"; // 厨房小单
            Map<String, Object> printConfig = getPrintConfigtInfo(ticketCode, archiveID); // 获的票据打印配置信息
            Map<String, String> dMap = new HashMap();
            dMap.put("OrderID", orderID);
            dMap.put("ArchiveID", archiveID);
            List<Map<String, Object>> dataMap = ticketPrintInfoService.getOrderMenuType(dMap); // 所有菜的类别ID
            for (int i = 0; i < dataMap.size(); i++) {
                if (dataMap.get(i) != null) {
                    String categoryID = dataMap.get(i).get("CategoryID").toString();
                    dMap.clear();
                    dMap.put("OrderID", orderID);
                    dMap.put("ArchiveID", archiveID);
                    dMap.put("CategoryID", categoryID);
                    // 菜品明细数据
                    List<O_OrderDetailInfoEntity> menuList = ticketPrintInfoService.getPrintMenuList(dMap);
                    if (dataList.size() > 0) {
                        for (O_OrderDetailInfoEntity detailInfo : menuList) {
                            // 厨房小单
                            ticketPrintdata = getCartePrintData(printConfig, detailInfo, orderCode);
                            ticketPrintdata.setCreatorID(Long.valueOf(loginID));
                            ticketPrintdata.setIsSync(false);
                            printDataList.add(ticketPrintdata);
                        }
                    }
                }
            }
            saveDatalist(printDataList);
            result = "1";
        } catch (Exception e) {
            logger.error(" orderReceiptData :" + e.getMessage());
            e.printStackTrace();
            result = "2";
        }
        return result;
    }

    /**
     * @param subOrderID
     * @param archiveID
     * @param loginID
     * @param menuList
     * @return
     * @Description：生成 退菜单
     * @Author：HuTao
     * @Time: 2017-3-10 17:15
     * @Version 2.0.0
     */

    public String retreatFoodData(String subOrderID, String archiveID, String loginID, List<CancelMenuVO> menuList) {
        String result = "0";
        String orderCode = "";
        U_LoginInfoEntity logininfo = new U_LoginInfoEntity();
        logininfo.setLoginID(Long.valueOf(loginID));

        List<O_TicketPrintInfoEntity> printDataList = new ArrayList<O_TicketPrintInfoEntity>();
        try {
            String orderID = "0";
            Map<String, Object> ddMap = ticketPrintInfoService.getArchiveID(subOrderID);
            archiveID = ddMap.get("ArchiveID").toString();
            orderID = ddMap.get("OrderID").toString();
            if (ddMap.equals("OrderCode")) {
                orderCode = ddMap.get("OrderCode").toString();
            }
            iniInfo(archiveID, orderID);
            logininfo = loginInfoService.get(logininfo); // 登录信息
            O_OrderDetailInfoEntity configEntity = ticketPrintInfoService.getOrderDetailInfo(subOrderID);   //  取订单的 楼层 桌号 餐次 等信息
            O_TicketPrintInfoEntity ticketPrintdata = null;
            String ticketCode = "RetreatTotalTicket";        //    退菜总单
            Map<String, Object> allPrintConfig = getPrintConfigtInfo(ticketCode, archiveID);
            ticketPrintdata = getAllCancelPrintData(configEntity, logininfo, menuList, allPrintConfig, orderID, orderCode);
            ticketPrintdata.setIsSync(false);
            printDataList.add(ticketPrintdata);
            ticketCode = "RetreatSingleTicket";    //    退菜单
            Map<String, Object> printConfig = getPrintConfigtInfo(ticketCode, archiveID); // 获的票据打印配置信息
            //  取每道菜的打盒子IP

            //  打印 退菜小单
            for (CancelMenuVO cancelMenu : menuList) {
                if (cancelMenu.getComboID() == 0) {
                    ticketPrintdata = getCancelCartePrintData(configEntity, logininfo, cancelMenu, printConfig, archiveID, orderID, orderCode);
                    ticketPrintdata.setIsSync(false);
                    printDataList.add(ticketPrintdata);
                } else {                      //
                    printCancelComListData(printDataList, configEntity, logininfo, cancelMenu, printConfig, archiveID, orderID, orderCode);  //  打印退  明细
                }
            }
            saveDatalist(printDataList);
            result = "1";
        } catch (Exception e) {
            e.printStackTrace();
            result = "2";
        }
        return result;
    }

    /**
     * @param orderID   订单号
     * @param archiveID 档案ID
     * @param loginID   登入ID
     * @return
     * @Description：生成 结算单 票据打印数据
     * @Author：HuTao
     * @Time: 2017-3-10 17:15
     * @Version 2.0.0
     */

    public String accountsOrderData(String orderID, String archiveID, String loginID) {
        String result = "0";
        String orderCode = "";
        List<O_TicketPrintInfoEntity> printDataList = new ArrayList<O_TicketPrintInfoEntity>();
        try {
            iniInfo(archiveID, orderID);
            Map<String, String> conMap = new HashMap<String, String>();
            conMap.put("OrderID", orderID);
            conMap.put("ArchiveID", archiveID);
            // 菜品明细数据
            List<O_OrderDetailInfoEntity> dataList = ticketPrintInfoService.getAllMenuList(conMap);
            String subOrderID = dataList.get(0).getSubOrderID().toString();
            orderCode = getOrderCode(subOrderID);
            O_TicketPrintInfoEntity ticketPrintdata = null;
            // 结帐单
            ticketPrintdata = getAccountPrintData(dataList, archiveID, orderCode);
            ticketPrintdata.setCreatorID(Long.valueOf(loginID));
            ticketPrintdata.setIsSync(false);
            printDataList.add(ticketPrintdata);
            saveDatalist(printDataList);
            result = "1";
        } catch (Exception e) {
            e.printStackTrace();
            result = "2";
        }
        return result;
    }

    /**
     * @param orderID   订单号
     * @param archiveID 档案ID
     * @param loginID   登入ID
     * @return
     * @Description：生成 预结帐单
     * @Author：HuTao
     * @Time: 2017-3-10 17:14
     * @Version 2.0.0
     */

    public String beforeAccountsOrderData(String orderID, String archiveID, String loginID) {
        String result = "0";
        String orderCode = "";
        List<O_TicketPrintInfoEntity> printDataList = new ArrayList<O_TicketPrintInfoEntity>();
        try {
            iniInfo(archiveID, orderID);
            Map<String, String> conMap = new HashMap<String, String>();
            conMap.put("OrderID", orderID);
            conMap.put("ArchiveID", archiveID);
            // 菜品明细数据
            List<O_OrderDetailInfoEntity> dataList = ticketPrintInfoService.getAllMenuList(conMap);
            String subOrderID = dataList.get(0).getSubOrderID().toString();
            orderCode = getOrderCode(subOrderID);
            O_TicketPrintInfoEntity ticketPrintdata = null;
            // 预结帐单
            ticketPrintdata = getAdvancePrintData(dataList, archiveID, orderCode);
            ticketPrintdata.setCreatorID(Long.valueOf(loginID));
            ticketPrintdata.setIsSync(false);
            printDataList.add(ticketPrintdata);
            saveDatalist(printDataList);
            result = "1";
        } catch (Exception e) {
            e.printStackTrace();
            result = "2";
        }
        return result;
    }


    /**
     * @param archiveID
     * @param loginID
     * @param connectPrintVO
     * @return
     * @Description：生成交接表
     * @Author：HuTao
     * @Time: 2017-3-10 17:14
     * @Version 2.0.0
     */

    public String connectTableData(String archiveID, String loginID, ConnectPrintVO connectPrintVO) {
        String result = "0";
        O_TicketPrintInfoEntity ticketPrintdata = new O_TicketPrintInfoEntity();
        try {
            String ticketCode = "ConnectCode";   // 交接单
            Map<String, Object> printConfig = getPrintConfigtInfo(ticketCode, archiveID);
            // 交接单Vo
            connectPrintVO.setOptCode("101");
            connectPrintVO.setBillType("9"); // 单类型(值9)
            String jsonStr = JSONUtils.toJson(connectPrintVO);
            ticketPrintdata.setRecordID(Long.valueOf(0));
            // ticketPrintdata.setDetailID(Long.valueOf(0));
            ticketPrintdata.setMappingID(Long.valueOf(printConfig.get("MappingID").toString()));
            ticketPrintdata.setTicketName(printConfig.get("TicketName").toString());
            ticketPrintdata.setPrintStatus(Long.valueOf(0));
            ticketPrintdata.setPrintNumber(0);
            ticketPrintdata.setPrintContent(jsonStr);
            ticketPrintdata.setLongContent("");
            //  ticketPrintdata.setOrderID(dataList.get(0).getOrderID());
            ticketPrintdata.setCreatorID(Long.valueOf(loginID));
            ticketPrintdata.setIsSync(false);
            ticketPrintdata.setCreateTime(LocalDateTime.now());
            ticketPrintdata.setMemo("");
            ticketPrintInfoService.save(ticketPrintdata);
            result = "1";
        } catch (Exception e) {
            e.printStackTrace();
            result = "2";
        }
        return result;
    }


    /**
     * @param dataList
     * @throws Exception
     * @Description：保存票据信息
     * @Author：HuTao
     * @Time: 2017-2-20 17:36
     * @Version 2.0.0
     */

    @Transactional
    public void saveDatalist(List<O_TicketPrintInfoEntity> dataList) throws Exception {
        for (O_TicketPrintInfoEntity TicketPrintdata : dataList) {
            ticketPrintInfoService.save(TicketPrintdata);
        }
    }

    /**
     * 根据订单号到档案ID
     *
     * @param orderID
     * @return
     * @Description：
     * @Author：HuTao
     * @Time: 2017-2-20 17:02
     * @Version 2.0.0
     */
    private String getArchiveID(String orderID) {
        Map<String, Object> dataMap;
        String result = "";
        try {
            dataMap = ticketPrintInfoService.getArchiveID(orderID);
            result = dataMap.get("ArchiveID").toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * // 根据订单号 获取 OrderCode
     *
     * @param subOrderID
     * @return
     * @Description：
     * @Author：HuTao
     * @Time: 2017-2-20 17:04
     * @Version 2.0.0
     */
    private String getOrderCode(String subOrderID) {
        Map<String, Object> dataMap;
        String result = "";
        try {
            dataMap = ticketPrintInfoService.getArchiveID(subOrderID);
            result = dataMap.get("OrderCode").toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // 台单
    private O_TicketPrintInfoEntity getTablePrintData(List<O_OrderDetailInfoEntity> dataList, String vArchiveID,
                                                      String orderCode) {
        String ticketCode = "DeskTicket";
        Map<String, Object> printConfig = getPrintConfigtInfo(ticketCode, vArchiveID); // 获的票据打印配置信息
        TablePrintVO tablePrintVO = getTablePrintVo(printConfig, dataList, orderCode); // 台单Vo
        O_TicketPrintInfoEntity ticketPrintdata = new O_TicketPrintInfoEntity(); // 票据信息
        String jsonStr = JSONUtils.toJson(tablePrintVO);
        ticketPrintdata.setRecordID(Long.valueOf(0));
        // ticketPrintdata.setDetailID(Long.valueOf(0));
        ticketPrintdata.setMappingID(Long.valueOf(printConfig.get("MappingID").toString()));
        ticketPrintdata.setTicketName(printConfig.get("TicketName").toString());
        ticketPrintdata.setPrintStatus(Long.valueOf(0));
        ticketPrintdata.setPrintNumber(0);
        ticketPrintdata.setPrintContent(jsonStr);
        ticketPrintdata.setLongContent("");
        ticketPrintdata.setBusinessID(dataList.get(0).getOrderID());
        ticketPrintdata.setCreatorID(Long.valueOf(0));
        ticketPrintdata.setCreateTime(LocalDateTime.now());
        ticketPrintdata.setMemo("");
        return ticketPrintdata;
    }

    // 传菜总单 出品总单
    private O_TicketPrintInfoEntity getPassPrintData(List<O_OrderDetailInfoEntity> dataList, String vArchiveID,
                                                     String orderCode) {
        O_TicketPrintInfoEntity ticketPrintdata = new O_TicketPrintInfoEntity(); // 票据信息
        String ticketCode = "PassTotalTicket"; // 传菜总单
        Map<String, Object> printConfig = getPrintConfigtInfo(ticketCode, vArchiveID);
        // AllCookroomPrintVo                   // 传菜总单Vo
        AllCookroomPrintVO allCookroomPrintVo = getAllCookroomPrintVo(printConfig, dataList, orderCode);
        allCookroomPrintVo.setBillType("8"); // 出品总单（传菜总单) // 单类型(值8)
        String jsonStr = JSONUtils.toJson(allCookroomPrintVo);
        ticketPrintdata.setRecordID(Long.valueOf(0));
        // ticketPrintdata.setDetailID(Long.valueOf(0));
        ticketPrintdata.setMappingID(Long.valueOf(printConfig.get("MappingID").toString()));
        ticketPrintdata.setTicketName(printConfig.get("TicketName").toString());
        ticketPrintdata.setPrintStatus(Long.valueOf(0));
        ticketPrintdata.setPrintNumber(0);
        ticketPrintdata.setPrintContent(jsonStr);
        ticketPrintdata.setLongContent("");
        ticketPrintdata.setBusinessID(dataList.get(0).getOrderID());
        ticketPrintdata.setCreatorID(Long.valueOf(0));
        ticketPrintdata.setCreateTime(LocalDateTime.now());
        ticketPrintdata.setMemo("");
        return ticketPrintdata;
    }

    // 预结帐单
    private O_TicketPrintInfoEntity getAdvancePrintData(List<O_OrderDetailInfoEntity> dataList, String vArchiveID,
                                                        String orderCode) {
        O_TicketPrintInfoEntity ticketPrintdata = new O_TicketPrintInfoEntity();         //  票据信息
        String ticketCode = "AdvanceTicket";
        Map<String, Object> printConfig = getPrintConfigtInfo(ticketCode, vArchiveID);   //  获的票据打印配置信息
        AdvancePrintVO advancePrintVo = getAdvancePrintVo(printConfig, dataList, orderCode);
        String jsonStr = JSONUtils.toJson(advancePrintVo);
        // 预结帐单 AdvancePrintVo
        ticketPrintdata.setRecordID(Long.valueOf(0));
        // ticketPrintdata.setDetailID(Long.valueOf(0));
        ticketPrintdata.setMappingID(Long.valueOf(printConfig.get("MappingID").toString()));
        ticketPrintdata.setTicketName(printConfig.get("TicketName").toString());
        ticketPrintdata.setPrintStatus(Long.valueOf(0));
        ticketPrintdata.setPrintNumber(0);
        ticketPrintdata.setPrintContent(jsonStr);
        ticketPrintdata.setLongContent("");
        ticketPrintdata.setBusinessID(dataList.get(0).getOrderID());
        ticketPrintdata.setCreatorID(Long.valueOf(0));
        ticketPrintdata.setCreateTime(LocalDateTime.now());
        ticketPrintdata.setMemo("");
        return ticketPrintdata;
    }

    // 结帐单
    private O_TicketPrintInfoEntity getAccountPrintData(List<O_OrderDetailInfoEntity> dataList, String vArchiveID,
                                                        String orderCode) {
        O_TicketPrintInfoEntity ticketPrintdata = new O_TicketPrintInfoEntity();
        String ticketCode = "ReckoningTicket";
        Map<String, Object> printConfig = getPrintConfigtInfo(ticketCode, vArchiveID); // 获的票据打印配置信息
        AccountPrintVO accountPrintVo = getAccountPrintVo(printConfig, dataList, orderCode);
        String jsonStr = JSONUtils.toJson(accountPrintVo);
        ticketPrintdata.setRecordID(Long.valueOf(0));
        ticketPrintdata.setMappingID(Long.valueOf(printConfig.get("MappingID").toString()));
        ticketPrintdata.setTicketName(printConfig.get("TicketName").toString());
        ticketPrintdata.setPrintStatus(Long.valueOf(0));
        ticketPrintdata.setPrintNumber(0);
        ticketPrintdata.setPrintContent(jsonStr);
        ticketPrintdata.setLongContent("");
        ticketPrintdata.setBusinessID(dataList.get(0).getOrderID());
        ticketPrintdata.setCreatorID(Long.valueOf(0));
        ticketPrintdata.setCreateTime(LocalDateTime.now());
        ticketPrintdata.setMemo("");
        return ticketPrintdata;
    }

    // 厨房总单
    private O_TicketPrintInfoEntity getAllCookroomPrintData(List<O_OrderDetailInfoEntity> dataList,
                                                            Map<String, Object> printConfig, String orderCode) {
        O_TicketPrintInfoEntity ticketPrintdata = new O_TicketPrintInfoEntity();
        AllCookroomPrintVO allCookroomPrintVo = getAllCookroomPrintVo(printConfig, dataList, orderCode);
        String jsonStr = JSONUtils.toJson(allCookroomPrintVo);
        ticketPrintdata.setRecordID(Long.valueOf(0));
        ticketPrintdata.setMappingID(Long.valueOf(printConfig.get("MappingID").toString()));
        ticketPrintdata.setTicketName(printConfig.get("TicketName").toString());
        ticketPrintdata.setPrintStatus(Long.valueOf(0));
        ticketPrintdata.setPrintNumber(0);
        ticketPrintdata.setPrintContent(jsonStr);
        ticketPrintdata.setLongContent("");
        ticketPrintdata.setBusinessID(dataList.get(0).getOrderID());
        ticketPrintdata.setCreatorID(Long.valueOf(0));
        ticketPrintdata.setCreateTime(LocalDateTime.now());
        ticketPrintdata.setMemo("");
        return ticketPrintdata;
    }

    // 厨房小单
    private O_TicketPrintInfoEntity getCartePrintData(Map<String, Object> printConfig,
                                                      O_OrderDetailInfoEntity detailInfo, String orderCode) {
        O_TicketPrintInfoEntity ticketPrintdata = new O_TicketPrintInfoEntity();
        CartePrintVO cartePrintVO = getCartePrintVo(printConfig, detailInfo, orderCode);
        String jsonStr = JSONUtils.toJson(cartePrintVO);
        ticketPrintdata.setRecordID(Long.valueOf(0));
        ticketPrintdata.setDetailID(detailInfo.getDetailID());
        if (detailInfo.getRecordID() != null) {
            ticketPrintdata.setComboDetailID(Long.valueOf(detailInfo.getRecordID()));  //  套餐明细记录ID
        }
        ticketPrintdata.setMappingID(Long.valueOf(printConfig.get("MappingID").toString()));
        ticketPrintdata.setTicketName(printConfig.get("TicketName").toString());
        ticketPrintdata.setPrintStatus(Long.valueOf(0));
        ticketPrintdata.setPrintNumber(0);
        ticketPrintdata.setPrintContent(jsonStr);
        ticketPrintdata.setLongContent("");
        ticketPrintdata.setBusinessID(detailInfo.getOrderID());
        ticketPrintdata.setCreatorID(Long.valueOf(0));
        ticketPrintdata.setCreateTime(LocalDateTime.now());
        ticketPrintdata.setMemo("");
        return ticketPrintdata;
    }

    // 退菜总单
    private O_TicketPrintInfoEntity getAllCancelPrintData(O_OrderDetailInfoEntity entity, U_LoginInfoEntity loginInfo,
                                                          List<CancelMenuVO> dataList, Map<String, Object> printConfig, String orderID, String orderCode) {
        O_TicketPrintInfoEntity ticketPrintdata = new O_TicketPrintInfoEntity();
        AllCancelPrintVO allCancelPrintVO = getAllCancelPrintVo(entity, loginInfo, printConfig, dataList, orderCode);
        String jsonStr = JSONUtils.toJson(allCancelPrintVO);
        ticketPrintdata.setRecordID(Long.valueOf(0));
        ticketPrintdata.setMappingID(Long.valueOf(printConfig.get("MappingID").toString()));
        ticketPrintdata.setTicketName(printConfig.get("TicketName").toString());
        ticketPrintdata.setPrintStatus(Long.valueOf(0));
        ticketPrintdata.setPrintNumber(0);
        ticketPrintdata.setPrintContent(jsonStr);
        ticketPrintdata.setLongContent("");
        ticketPrintdata.setBusinessID(Long.valueOf(orderID));
        if (loginInfo != null) {
            ticketPrintdata.setCreatorID(loginInfo.getLoginID());
        }
        ticketPrintdata.setCreateTime(LocalDateTime.now());
        ticketPrintdata.setMemo("");
        return ticketPrintdata;
    }

    // 退菜单
    private O_TicketPrintInfoEntity getCancelCartePrintData(O_OrderDetailInfoEntity configEntity, U_LoginInfoEntity loginInfo,
                                                            CancelMenuVO detailInfo, Map<String, Object> printConfig, String archiveID, String orderID, String orderCode) {
        O_TicketPrintInfoEntity ticketPrintdata = new O_TicketPrintInfoEntity();
        CancelCartePrintVO cancelCartePrintVO = getCancelCartePrintVo(configEntity, loginInfo, printConfig, detailInfo, archiveID, orderCode);
        String jsonStr = JSONUtils.toJson(cancelCartePrintVO);
        ticketPrintdata.setRecordID(Long.valueOf(0));
//		ticketPrintdata.setDetailID(detailInfo.getDetailID());
//		if(detailInfo.getRecordID()!=null) {
//		   ticketPrintdata.setComboDetailID(Long.valueOf(detailInfo.getRecordID()));  //  套餐明细记录ID
//		}
        ticketPrintdata.setMappingID(Long.valueOf(printConfig.get("MappingID").toString()));
        ticketPrintdata.setTicketName(printConfig.get("TicketName").toString());
        ticketPrintdata.setPrintStatus(Long.valueOf(0));
        ticketPrintdata.setPrintNumber(0);
        ticketPrintdata.setPrintContent(jsonStr);
        ticketPrintdata.setLongContent("");
        ticketPrintdata.setBusinessID(Long.valueOf(orderID));
        if (loginInfo != null) {
            ticketPrintdata.setCreatorID(loginInfo.getLoginID());
        }
        ticketPrintdata.setCreateTime(LocalDateTime.now());
        ticketPrintdata.setMemo("");
        return ticketPrintdata;
    }

    private void iniInfo(String archiveID, String orderID) throws Exception {
        if (merchantinfo == null) {
            merchantinfo = new B_MerchantInfoEntity();
        }
        merchantinfo.setArchiveID(Long.valueOf(archiveID));
        merchantinfo = merchantInfoService.get(merchantinfo); // 档案信息
    }

    // 获的票据打印配置信息
    private Map<String, Object> getPrintConfigtInfo(String ticketCode, String vArchiveID) {
        Map<String, Object> dataMap = null;
        Map<String, String> vMap = new HashMap<String, String>();
        vMap.put("ticketCode", ticketCode);
        vMap.put("ArchiveID", vArchiveID);
        try {
            dataMap = ticketPrintInfoService.getPrintConfigtInfo(vMap).get(0);
            ;
        } catch (Exception e) {
            logger.error(" getPrintConfigtInfo :" + e.getMessage());
            e.printStackTrace();
        }
        return dataMap;
    }

    private String formatOrderDateTime(Date vDate) {
        String resultStr = "";
        if (vDate != null) {
            SimpleDateFormat formatter;
            formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            resultStr = formatter.format(vDate);
        }
        return resultStr;
    }

    private String addDateTime(LocalDateTime vDate, int hourInt) {
        String resultStr = "";
        if (vDate != null) {
            DateUtils.addHour(vDate,hourInt);
            resultStr = DateUtils.formaterLocalDateTime(vDate);
        }
        return resultStr;
    }

    // 台单Vo
    private TablePrintVO getTablePrintVo(Map<String, Object> printConfig, List<O_OrderDetailInfoEntity> dataList,
                                         String orderCode) {
        TablePrintVO tablePrintVO = new TablePrintVO();
        List<PlatBillVO> billBoList = new ArrayList<PlatBillVO>();
        tablePrintVO.setOptCode("101"); // 操作码(值101）
        tablePrintVO.setBillType("3");  // 单类型(值3)
        if (merchantinfo != null) {
            tablePrintVO.setStrtName(merchantinfo.getMerchantName()); // 公司名称
        }
        tablePrintVO.setMeals(dataList.get(0).getMealName()); // 餐次
        tablePrintVO.setOrderid(orderCode); // 单据号
        tablePrintVO.setOrderTime(addDateTime(dataList.get(0).getCreateTime(), 8)); // 开台时间
        tablePrintVO.setPrintTime(formatOrderDateTime(new Date())); // 打印时间
        tablePrintVO.setDeskNum(dataList.get(0).getTtableName()); // 桌号
        tablePrintVO.setiTotalDish(String.valueOf(dataList.size())); // 点菜个数
        if (printConfig != null) {
            tablePrintVO.setiQty(printConfig.get("PrintNumber").toString()); // 打印份数
            tablePrintVO.setPrintIp(printConfig.get("PrinterIP").toString()); // 打印机Ip
        }
        tablePrintVO.setPlatbill(billBoList); // 单个台单信息
        double fCostPrice = 0; // 原价金额
        double fTotalDist = 0; // 折扣总金额
        double fADistAmt = 0; // 折后金额
        double fComforts = 0; // 优惠总计
        Integer Quantity = 0;
        Double price = 0.0;
        for (O_OrderDetailInfoEntity detailInfo : dataList) {
            PlatBillVO PlatBillVO = new PlatBillVO();
            PlatBillVO.setdName(detailInfo.getProductName()); // 菜名
            PlatBillVO.setdQty(String.valueOf(detailInfo.getQuantity())); // 数量
            PlatBillVO.setdUint(detailInfo.getUnitName()); // 单位
            if (detailInfo.getComboName() != null) { // 套餐明细节处理
                PlatBillVO.setfOriPrice(String.valueOf(detailInfo.getComboPrice())); // 套餐原价
                PlatBillVO.setfPrice(String.valueOf(detailInfo.getComboPrice())); // 折后单价
                price = detailInfo.getComboPrice().doubleValue();
            } else {
                PlatBillVO.setfOriPrice(String.valueOf(detailInfo.getPrice())); // 原价
                PlatBillVO.setfPrice(String.valueOf(detailInfo.getPrice())); // 折后单价
                price = detailInfo.getPrice().doubleValue();
            }
            PlatBillVO.setfADistAmt("0"); // 菜单折扣金额
            PlatBillVO.setfIncrease("0"); // 加价
            PlatBillVO.setfProcessFee("0"); // 加工费
            PlatBillVO.setfADistAmt("0"); // 折后金额
            PlatBillVO.setdRemark(detailInfo.getDetailDesc()); // 备注
            PlatBillVO.setiPackagel("0"); // 是否菜单明细
            PlatBillVO.setiSendFlag("0"); // 赠送标记
            PlatBillVO.setiAutoSend("0"); // 自动赠送
            PlatBillVO.setiWeighting("0"); // 是否称重 重量 FloatQuantity
            if (detailInfo.getQuantity() == null) {
                Quantity = 0;
            } else {
                Quantity = detailInfo.getQuantity();
            }
            fCostPrice = fCostPrice + Quantity * price;
            billBoList.add(PlatBillVO);
            tableComboDetaildata(billBoList, detailInfo); // 台单 套餐明细节处理
        }
        tablePrintVO.setPc_remark(""); // 拼菜备注信息
        tablePrintVO.setfCostPrice(String.valueOf(fCostPrice)); // 原价金额
        tablePrintVO.setfTotalDist(String.valueOf(fTotalDist)); // 折扣总金额
        tablePrintVO.setfADistAmt(String.valueOf(fADistAmt)); // 折后金额
        tablePrintVO.setfComforts(String.valueOf(fComforts)); // 优惠总计
        return tablePrintVO;
    }

    // 预结帐单
    private AdvancePrintVO getAdvancePrintVo(Map<String, Object> printConfig, List<O_OrderDetailInfoEntity> dataList,
                                             String orderCode) {
        AdvancePrintVO advancePrintVo = new AdvancePrintVO();
        List<SingleDishVO> singleList = new ArrayList<SingleDishVO>();
        advancePrintVo.setOptCode("101"); // 操作码(值101）
        advancePrintVo.setBillType("7"); // 单类型(值7)
        advancePrintVo.setStrtName(merchantinfo.getMerchantName()); // 公司名称
        advancePrintVo.setMeals(dataList.get(0).getMealName()); // 餐次
        advancePrintVo.setOrderid(orderCode); // 单据号
        advancePrintVo.setOrderTime(addDateTime(dataList.get(0).getCreateTime(), 8)); // 下单时间
        advancePrintVo.setPrintTime(formatOrderDateTime(new Date())); // 打印时间
        advancePrintVo.setDeskNum(dataList.get(0).getTtableName()); // 桌号
        advancePrintVo.setCashier(""); // 收银员
        advancePrintVo.setiTotalDish(String.valueOf(dataList.size())); // 点菜个数
        advancePrintVo.setiQty(printConfig.get("PrintNumber").toString()); // 单据打印数量
        advancePrintVo.setPrintIp(printConfig.get("PrinterIP").toString()); // 打印机Ip
        advancePrintVo.setSingleDish(singleList);
        String sign = null;
        String vsign = ""; // 套餐标识
        double fCostPrice = 0; // 原价金额
        double fTotalDist = 0; // 折扣总金额
        double fZsje = 0; // 赠送金额
        double fWipeZero = 0; // 抹零
        Double price = 0.0;
        Double fProcessFe = 0.0; // 加工费
        Double adjustAmount = 0.0;
        for (O_OrderDetailInfoEntity detailInfo : dataList) {
            SingleDishVO dishVo = new SingleDishVO();
            dishVo.setdQty(String.valueOf(detailInfo.getQuantity())); // 数量
            dishVo.setdUint(detailInfo.getUnitName()); // 单位
            dishVo.setdName(detailInfo.getProductName()); // 菜名
            if (detailInfo.getComboName() != null) { // 套餐明细节处理
                dishVo.setfOriPrice(String.valueOf(detailInfo.getComboPrice())); // 原价
                dishVo.setfPrice(String.valueOf(detailInfo.getComboPrice())); // 折扣单价
                price = detailInfo.getComboPrice().doubleValue();
            } else {
                dishVo.setfOriPrice(String.valueOf(detailInfo.getPrice())); // 原价
                dishVo.setfPrice(String.valueOf(detailInfo.getPrice())); // 折扣单价
                price = detailInfo.getPrice().doubleValue();
            }
            fProcessFe = null == detailInfo.getProduceCost() ? 0.0 : detailInfo.getProduceCost().doubleValue();
            dishVo.setfProcessFee(String.valueOf(fProcessFe)); // 加工费
            // dishVo.setfADistAmt(String.valueOf(detailInfo.getAdjustAmount()));
            // dishVo.setiSendFlag(); // 赠送标记
            // dishVo.setiAutoSend(); // 自动赠送
            // dishVo.setdRemark(); // 备注
            // dishVo.setfDiscountRate(); // 结账时段折
            adjustAmount = null == detailInfo.getAdjustAmount() ? 0.0 : detailInfo.getAdjustAmount().doubleValue();
            fCostPrice = fCostPrice + fProcessFe + detailInfo.getQuantity() * price;
            fTotalDist = fTotalDist + adjustAmount;
            singleList.add(dishVo);
            advanceComboDetaildata(singleList, detailInfo); // 套餐明细节处理
        }
        advancePrintVo.setfCostPrice(String.valueOf(fCostPrice)); // 原价金额
        advancePrintVo.setfTotalDist(String.valueOf(fTotalDist)); // 折扣总金额
        advancePrintVo.setfZsje(String.valueOf(fZsje)); // 赠送金额
        advancePrintVo.setfWipeZero(String.valueOf(fWipeZero)); // 抹零
        return advancePrintVo;
    }

    // 结帐单
    private AccountPrintVO getAccountPrintVo(Map<String, Object> printConfig, List<O_OrderDetailInfoEntity> dataList,
                                             String orderCode) {
        AccountPrintVO accountPrintVo = new AccountPrintVO();
        List<SingleDishVO> singleList = new ArrayList<SingleDishVO>();
        accountPrintVo.setOptCode("101"); // 操作码(值101）
        accountPrintVo.setBillType("6"); // 单类型(值7)
        accountPrintVo.setStrtName(merchantinfo.getMerchantName()); // 公司名称
        accountPrintVo.setMeals(dataList.get(0).getMealName()); // 餐次
        accountPrintVo.setOrderid(orderCode); // 单据号
        accountPrintVo.setOrderTime(addDateTime(dataList.get(0).getCreateTime(), 8)); // 下单时间
        accountPrintVo.setPrintTime(formatOrderDateTime(new Date())); // 打印时间
        accountPrintVo.setDeskNum(dataList.get(0).getTtableName()); // 桌号
        accountPrintVo.setCashier(""); // 收银员
        accountPrintVo.setiTotalDish(String.valueOf(dataList.size())); // 点菜个数
        accountPrintVo.setiQty(printConfig.get("PrintNumber").toString()); // 单据打印数量
        accountPrintVo.setPrintIp(printConfig.get("PrinterIP").toString()); // 打印机Ip
        accountPrintVo.setSingleDish(singleList); // 菜品明细列表
        double fTotalDist = 0; // 折扣金额
        double fWipeZero = 0; // 抹零
        double fZsje = 0; // 赠送金额
        double fShoudCheckAt = 0; // 应收金额
        Double price = 0.0;
        Double fProcessFe = 0.0; // 加工费
        for (O_OrderDetailInfoEntity detailInfo : dataList) {
            SingleDishVO dishVo = new SingleDishVO();
            dishVo.setdQty(String.valueOf(detailInfo.getQuantity())); // 数量
            dishVo.setdUint(detailInfo.getUnitName()); // 单位
            dishVo.setdName(detailInfo.getProductName()); // 菜名
            if (detailInfo.getComboName() != null) { // 套餐明细节处理
                dishVo.setfOriPrice(String.valueOf(detailInfo.getPrice())); // 原价
                dishVo.setfPrice(String.valueOf(detailInfo.getPrice())); // 折扣单价
                price = detailInfo.getPrice().doubleValue();
            } else {
                dishVo.setfOriPrice(String.valueOf(detailInfo.getComboPrice())); // 原价
                dishVo.setfPrice(String.valueOf(detailInfo.getComboPrice())); // 折扣单价
                price = detailInfo.getComboPrice().doubleValue();
            }
            fProcessFe = null == detailInfo.getProduceCost() ? 0.0 : detailInfo.getProduceCost().doubleValue();
            dishVo.setfProcessFee(String.valueOf(fProcessFe)); // 加工费
            // detailInfo.getTotalAmount() // 总价
            dishVo.setfADistAmt(String.valueOf(detailInfo.getAdjustAmount())); // 折后金额
            // dishVo.setiSendFlag(); // 赠送标记
            // dishVo.setiAutoSend(); // 自动赠送
            // dishVo.setdRemark(); // 备注
            // dishVo.setfIncrease(); // 名厨加价
            // dishVo.setfDiscountRate(); // 结账时段折
            singleList.add(dishVo);
            accountComboDetaildata(singleList, detailInfo); // 套餐明细节处理
        }
        // accountPrintVo.setfPriceAll(fPriceAll); // 支付方式处理
        accountPrintVo.setfTotalDist(String.valueOf(fTotalDist)); // 折扣金额
        accountPrintVo.setfWipeZero(String.valueOf(fWipeZero)); // 抹零
        accountPrintVo.setfZsje(String.valueOf(fZsje)); // 赠送金额
        accountPrintVo.setfShoudCheckAt(String.valueOf(fShoudCheckAt)); // 应收金额
        accountPrintVo.setfRemark("");
        // accountPrintVo.setfPriceAll(fPriceAll); // 支付类型
        return accountPrintVo;
    }

    // 厨房总单
    private AllCookroomPrintVO getAllCookroomPrintVo(Map<String, Object> printConfig,
                                                     List<O_OrderDetailInfoEntity> dataList, String orderCode) {
        AllCookroomPrintVO allCookroomPrintVo = new AllCookroomPrintVO();
        List<CookroomListVO> cookList = new ArrayList<CookroomListVO>();
        allCookroomPrintVo.setOptCode("101"); // 操作码(值101）
        allCookroomPrintVo.setBillType("1");  // 单类型(值1)
        allCookroomPrintVo.setDeskNum(dataList.get(0).getTtableName()); // 桌号
        allCookroomPrintVo.setSumPeople(String.valueOf(dataList.get(0).getPeopleNum())); // 人数
        allCookroomPrintVo.setOrderTime(addDateTime(dataList.get(0).getCreateTime(), 8)); // 下单时间
        allCookroomPrintVo.setTaker(dataList.get(0).getLoginName()); // 点菜员
        allCookroomPrintVo.setOrderid(orderCode); // 单据号
        allCookroomPrintVo.setiTotalDish(String.valueOf(dataList.size())); // 点菜个数
        allCookroomPrintVo.setiQty(printConfig.get("PrintNumber").toString()); // 单据打印数量
        allCookroomPrintVo.setPrintIp(printConfig.get("PrinterIP").toString()); // 打印机Ip
        allCookroomPrintVo.setSingleDish(cookList);
        for (O_OrderDetailInfoEntity detailInfo : dataList) {
            CookroomListVO cookVo = new CookroomListVO();
            cookVo.setdName(detailInfo.getProductName()); // 菜品名称
            cookVo.setdUint(detailInfo.getUnitName()); // 菜品单位
            cookVo.setdQty(String.valueOf(detailInfo.getQuantity())); // 菜品数量
            cookVo.setfPrice(String.valueOf(null == detailInfo.getPrice() ? 0 : detailInfo.getPrice().doubleValue()));
            cookVo.setdRemark(""); // 是否套餐明细
            cookVo.setStrRemark(detailInfo.getDetailDesc()); // 菜品备注
            cookList.add(cookVo);
            allCookroomComboDetaildata(cookList, detailInfo); // 套餐明细节处理
        }
        return allCookroomPrintVo;
    }

    // 厨房小单
    private CartePrintVO getCartePrintVo(Map<String, Object> printConfig, O_OrderDetailInfoEntity orderDetailInfo,
                                         String orderCode) {
        CartePrintVO cartePrintVO = new CartePrintVO();
        List<CarteListVO> carteList = new ArrayList<CarteListVO>();
        cartePrintVO.setOptCode("101"); // 操作码(值101）
        cartePrintVO.setBillType("2"); // 单类型(值2)
        cartePrintVO.setDeskNum(orderDetailInfo.getTtableName()); // 桌号
        cartePrintVO.setSumPeople(String.valueOf(orderDetailInfo.getPeopleNum())); // 人数
        cartePrintVO.setOrderTime(addDateTime(orderDetailInfo.getCreateTime(), 8)); // 下单时间
        cartePrintVO.setTaker(orderDetailInfo.getLoginName()); // 点菜员
        cartePrintVO.setOrderid(orderCode); // 单据号
        cartePrintVO.setiTotalDish("1"); // 点菜总数
        cartePrintVO.setiQty(printConfig.get("PrintNumber").toString()); // 单据打印数量
        cartePrintVO.setPrintIp(orderDetailInfo.getPrinterIP()); // 打印机Ip
        cartePrintVO.setSingleDish(carteList);
        CarteListVO carteVo = new CarteListVO();
        carteVo.setdName(orderDetailInfo.getProductName()); // 菜品名称
        carteVo.setdUint(orderDetailInfo.getUnitName());    // 菜品单位
        carteVo.setdQty(String.valueOf(orderDetailInfo.getQuantity())); // 菜品数量
        carteVo.setfPrice(
                String.valueOf(null == orderDetailInfo.getPrice() ? "0" : orderDetailInfo.getPrice().doubleValue()));
        // carteVo.set
        // carteVo.setdRemark(); // 是否套餐明细
        // carteVo.setdCookMethod(); // 制作方法
        // carteVo.setdTaste(); // 口味
        carteVo.setStrRemark(orderDetailInfo.getDetailDesc()); // 菜品备注
        // carteVo.setchef(); // 指定厨师
        carteList.add(carteVo);
        return cartePrintVO;
    }

    // 退菜总单
    private AllCancelPrintVO getAllCancelPrintVo(O_OrderDetailInfoEntity detailEntity, U_LoginInfoEntity loginInfo, Map<String, Object> printConfig,
                                                 List<CancelMenuVO> dataList, String orderCode) {
        AllCancelPrintVO allCancelPrintVO = new AllCancelPrintVO();
        List<SingleCancelVO> cancellist = new ArrayList<SingleCancelVO>();
        //	O_OrderDetailInfoEntity detailEntity = dataList.get(0);
        allCancelPrintVO.setOptCode("101"); // 操作码(值101）
        allCancelPrintVO.setBillType("4"); // 单类型(值4)
        allCancelPrintVO.setRstrtName(null == merchantinfo.getMerchantName() ? "" : merchantinfo.getMerchantName()); // 公司名称
        allCancelPrintVO.setFloorNum(null == detailEntity.getAreaName() ? "" : detailEntity.getAreaName()); // 楼层
        allCancelPrintVO.setDeskNum(null == detailEntity.getTtableName() ? "" : detailEntity.getTtableName()); // 桌号
        allCancelPrintVO.setMeals(null == detailEntity.getMealName() ? "" : detailEntity.getMealName()); // 餐次
        allCancelPrintVO
                .setSumPeople(String.valueOf(null == detailEntity.getPeopleNum() ? "1" : detailEntity.getPeopleNum())); // 人数
        allCancelPrintVO.setOrderid(orderCode); // 单据号
        allCancelPrintVO.setBackDishTime(addDateTime(detailEntity.getCreateTime(), 8)); // 退菜时间
        if (loginInfo != null) {
            allCancelPrintVO.setTaker(loginInfo.getLoginName()); // 退菜员
        }
        allCancelPrintVO.setiTotalDish(String.valueOf(dataList.size())); // 退菜总数
        allCancelPrintVO.setiQty(printConfig.get("PrintNumber").toString()); // 单据打印数量
        allCancelPrintVO.setPrintIp(printConfig.get("PrinterIP").toString()); // 打印机Ip
        allCancelPrintVO.setSingleDish(cancellist);
        for (CancelMenuVO detailInfo : dataList) {
            SingleCancelVO CancelVo = new SingleCancelVO();
            CancelVo.setdName(detailInfo.getProductName()); // 菜品名称
            CancelVo.setdQty(String.valueOf(detailInfo.getQuantity())); // 菜品数量
            CancelVo.setdUint(null == detailInfo.getProductUnit() ? "" : detailInfo.getProductUnit()); // 菜品单位
            CancelVo.setTheReason(null == detailInfo.getCancelDesc() ? "" : detailInfo.getCancelDesc()); // 退菜原因
            cancellist.add(CancelVo);
            // 退菜总单  套餐明细节处理
            canceComboDetaildata(cancellist, detailInfo); // 套餐明细节处理
        }
        return allCancelPrintVO;
    }

    // 退菜单
    private CancelCartePrintVO getCancelCartePrintVo(O_OrderDetailInfoEntity configEntity, U_LoginInfoEntity loginInfo, Map<String, Object> printConfig,
                                                     CancelMenuVO CancelInfo, String archiveID, String orderCode) {
        CancelCartePrintVO cancelCartePrintVO = new CancelCartePrintVO();
        List<SingleCancelVO> cancellist = new ArrayList<SingleCancelVO>();
        cancelCartePrintVO.setOptCode("101"); // 操作码(值101）
        cancelCartePrintVO.setBillType("5"); // 单类型(值4)
        cancelCartePrintVO.setRstrtName(merchantinfo.getMerchantName()); // 公司名称
        cancelCartePrintVO.setFloorNum(null == configEntity.getAreaName() ? "" : configEntity.getAreaName()); // 楼层
        cancelCartePrintVO.setDeskNum(configEntity.getTtableName());
        // 桌号
        cancelCartePrintVO.setMeals(configEntity.getMealName());
        // 餐次
        cancelCartePrintVO.setSumPeople(configEntity.getPeopleNum().toString());
        // 人数
        cancelCartePrintVO.setOrderid(orderCode);
        // 单据号
        cancelCartePrintVO.setBackDishTime(formatOrderDateTime(new Date()));
        // 退菜时间
        if (loginInfo != null) {
            cancelCartePrintVO.setTaker(loginInfo.getLoginName()); // 退菜员
        }
        cancelCartePrintVO.setiTotalDish(""); // 退菜总数
        cancelCartePrintVO.setiQty(printConfig.get("PrintNumber").toString()); // 单据打印数量
        // 菜品明细数据
        Map<String, String> conMap = new HashMap();
        conMap.put("archiveID", archiveID);
        conMap.put("variantIDStr", String.valueOf(CancelInfo.getVariantID()));
        List<Map<String, Object>> conlist = null;
        try {
            conlist = ticketPrintInfoService.getCancelMenuPrintIPSet(conMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ;
        if (conlist != null) {
            if (conlist.get(0).get("PrinterID") != null) {
                cancelCartePrintVO.setPrintIp(conlist.get(0).get("PrinterIP").toString());    // 打印机Ip
            }
        }
        cancelCartePrintVO.setSingleDish(cancellist);
        SingleCancelVO cancelVo = new SingleCancelVO();
        cancelVo.setdName(CancelInfo.getProductName()); // 菜品名称
        cancelVo.setdQty(String.valueOf(CancelInfo.getQuantity())); // 菜品数量
        cancelVo.setdUint(CancelInfo.getProductUnit()); // 菜品单位
        cancelVo.setTheReason(CancelInfo.getCancelDesc()); // 退菜原因
        cancellist.add(cancelVo);
        return cancelCartePrintVO;
    }

    // 厨房总单  套餐明细节处理
    private void allCookroomComboDetaildata(List<CookroomListVO> cookList, O_OrderDetailInfoEntity detailInfo) {
        if (detailInfo.getComboName() != null) { // 套餐明细节处理
            String ProductID = detailInfo.getComboID().toString();
            try {
                List<Map<String, Object>> comlist = ticketPrintInfoService.getComboDetail(ProductID);
                for (int i = 0; i < comlist.size(); i++) {
                    CookroomListVO dishVo = new CookroomListVO();
                    dishVo.setdName(comlist.get(i).get("ProductName").toString()); // 菜名
                    dishVo.setdQty(comlist.get(i).get("Quantity").toString()); // 数量
                    dishVo.setdUint(
                            null == comlist.get(i).get("UnitName") ? "" : comlist.get(i).get("UnitName").toString()); // 单位
                    //dishVo.setiPackagel("1"); // 是否套餐明细
                    dishVo.setfPrice(comlist.get(i).get("price").toString());
                    cookList.add(dishVo);
                }
            } catch (Exception e) {
                logger.error(" accountComboDetaildata :" + e.getMessage());
                e.printStackTrace();
            }

        }
    }

    // 退菜总单  套餐明细节处理
    private void canceComboDetaildata(List<SingleCancelVO> cancellist, CancelMenuVO detailInfo) { // 套餐明细节处理
        if (detailInfo.getComboID() == 0) { // 套餐明细节处理
            Long ProductID = detailInfo.getComboID();
            try {
                List<Map<String, Object>> comlist = ticketPrintInfoService.getComboDetail(String.valueOf(ProductID));
                for (int i = 0; i < comlist.size(); i++) {
                    SingleCancelVO dishVo = new SingleCancelVO();
                    dishVo.setdName(comlist.get(i).get("ProductName").toString()); // 菜名
                    dishVo.setdQty(comlist.get(i).get("Quantity").toString()); // 数量
                    dishVo.setdUint(
                            null == comlist.get(i).get("UnitName") ? "" : comlist.get(i).get("UnitName").toString()); // 单位
                    //dishVo.setiPackagel("1"); // 是否套餐明细
                    cancellist.add(dishVo);
                }
            } catch (Exception e) {
                logger.error(" accountComboDetaildata :" + e.getMessage());
                e.printStackTrace();
            }

        }
    }

    // 结帐单 套餐明细节处理
    private void accountComboDetaildata(List<SingleDishVO> singleList, O_OrderDetailInfoEntity detailInfo) {
        if (detailInfo.getComboName() != null) { // 套餐明细节处理
            String ProductID = detailInfo.getComboID().toString();
            try {
                List<Map<String, Object>> comlist = ticketPrintInfoService.getComboDetail(ProductID);
                for (int i = 0; i < comlist.size(); i++) {
                    SingleDishVO dishVo = new SingleDishVO();
                    dishVo.setdName(comlist.get(i).get("ProductName").toString()); // 菜名
                    dishVo.setdQty(comlist.get(i).get("Quantity").toString()); // 数量
                    dishVo.setdUint(
                            null == comlist.get(i).get("UnitName") ? "" : comlist.get(i).get("UnitName").toString()); // 单位
                    dishVo.setiPackagel("1"); // 是否套餐明细
                    singleList.add(dishVo);
                }
            } catch (Exception e) {
                logger.error(" accountComboDetaildata :" + e.getMessage());
                e.printStackTrace();
            }

        }
    }

    // 预结帐单 套餐
    private void advanceComboDetaildata(List<SingleDishVO> singleList, O_OrderDetailInfoEntity detailInfo) {
        if (detailInfo.getComboName() != null) { // 套餐明细节处理
            String ProductID = detailInfo.getComboID().toString();
            try {
                List<Map<String, Object>> comlist = ticketPrintInfoService.getComboDetail(ProductID);
                for (int i = 0; i < comlist.size(); i++) {
                    SingleDishVO dishVo = new SingleDishVO();
                    dishVo.setdName(comlist.get(i).get("ProductName").toString()); // 菜名
                    dishVo.setdQty(comlist.get(i).get("Quantity").toString()); // 数量
                    dishVo.setdUint(
                            null == comlist.get(i).get("UnitName") ? "" : comlist.get(i).get("UnitName").toString()); // 单位
                    dishVo.setiPackagel("1"); // 是否套餐明细
                    singleList.add(dishVo);
                }
            } catch (Exception e) {
                logger.error(" advanceComboDetaildata :" + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    ;

    // 台单 套餐明细节处理
    private void tableComboDetaildata(List<PlatBillVO> billBoList, O_OrderDetailInfoEntity detailInfo) {
        if (detailInfo.getComboName() != null) { // 套餐明细节处理
            String ProductID = detailInfo.getComboID().toString();
            try {
                List<Map<String, Object>> comlist = ticketPrintInfoService.getComboDetail(ProductID);
                for (int i = 0; i < comlist.size(); i++) {
                    PlatBillVO dishVo = new PlatBillVO();

                    dishVo.setdName(comlist.get(i).get("ProductName").toString()); // 菜名
                    dishVo.setdQty(comlist.get(i).get("Quantity").toString());     // 数量
                    dishVo.setdUint(
                            null == comlist.get(i).get("UnitName") ? "" : comlist.get(i).get("UnitName").toString()); // 单位
                    dishVo.setiPackagel("1"); // 是否套餐明细
                    billBoList.add(dishVo);
                }
            } catch (Exception e) {
                logger.error(" tableComboDetaildata :" + e.getMessage());
                e.printStackTrace();
            }

        }

    }

    ;

    // // 支付方式处理
    private List<PayTypeVO> getPayType(String subOrderIDStr) {
        List<PayTypeVO> payTypelist = new ArrayList<PayTypeVO>();
        List<Map<String, Object>> paylist;
        try {
            paylist = ticketPrintInfoService.getPayType(subOrderIDStr);
            for (int i = 0; i < paylist.size(); i++) {
                PayTypeVO PayTypeVO = new PayTypeVO();
                PayTypeVO.setPayType(paylist.get(i).get("PaymentMethodID").toString());
                PayTypeVO.setPrice(paylist.get(i).get("ChangeAmount").toString());
                payTypelist.add(PayTypeVO);
            }
        } catch (Exception e) {
            logger.error(" getPayType :" + e.getMessage());
            e.printStackTrace();
        }
        return payTypelist;
    }

    private void printCancelComListData(List<O_TicketPrintInfoEntity> printDataList, O_OrderDetailInfoEntity configEntity, U_LoginInfoEntity loginInfo,
                                        CancelMenuVO detailInfo, Map<String, Object> printConfig, String archiveID, String orderID, String orderCode) {  //  打印退套餐  明细
        if (detailInfo.getComboID() != 0) { // 套餐明细节处理
            long ProductID = detailInfo.getComboID();
            try {
                List<Map<String, Object>> comlist = ticketPrintInfoService.getComboDetail(String.valueOf(ProductID));
                O_TicketPrintInfoEntity ticketPrintdata = null;
                for (int i = 0; i < comlist.size(); i++) {
                    CancelMenuVO cancelMenu = new CancelMenuVO();
                    cancelMenu.setPrice(Double.valueOf(comlist.get(i).get("price").toString()));
                    cancelMenu.setProductName(comlist.get(i).get("ProductName").toString());
                    cancelMenu.setQuantity(Integer.valueOf(comlist.get(i).get("Quantity").toString()));
                    cancelMenu.setProductUnit(comlist.get(i).get("UnitName").toString());
                    cancelMenu.setVariantID(Long.valueOf(comlist.get(i).get("VariantID").toString()));
                    cancelMenu.setCancelDesc("");
                    ticketPrintdata = getCancelCartePrintData(configEntity, loginInfo, cancelMenu, printConfig, archiveID, orderID, orderCode);
                    ticketPrintdata.setIsSync(false);
                    printDataList.add(ticketPrintdata);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    //打印日志列表
    public List<Map<String, Object>> getPrintLogList(String printDate, String ceriation) {
        return ticketPrintInfoService.getPrintLogList(printDate, ceriation);
    }

    // 打印记录ID获取打印日志信息
    public O_TicketPrintInfoEntity getPrintLog(Long recordID) {
        O_TicketPrintInfoEntity queryParam = new O_TicketPrintInfoEntity();
        queryParam.setRecordID(recordID);
        return ticketPrintInfoService.get(queryParam);
    }

    //获取打印日志
    public List<Map<String, Object>> getRecordsBySubOrder(Long subOrderID) {
        List<Map<String, Object>> dataList = ticketPrintInfoService.getRecordsBySubOrder(subOrderID);
        if(dataList != null && !dataList.isEmpty()) {
            for(Map<String, Object> data : dataList) {
                Object status = data.get("printStatus");
                String name = parsePrintStatus(status);
                data.put("printStatus", name == null ? "" : name);
            }
        }
        return dataList;
    }

    public List<Map<String, Object>> getPrintHistoryByRedord(Long recordID) {
        List<Map<String, Object>> dataList = o_TicketPrintDealInfoDao.getPrintHistoryByRecord(recordID);
        if(dataList != null && !dataList.isEmpty()) {
            for(Map<String, Object> data : dataList) {
                Object status = data.get("printStatus");
                String name = parsePrintStatus(status);
                data.put("printStatus", name == null ? "" : name);
            }
        }
        return dataList;
    }

    public Map<String, Object> getRecordInfoById(Long recordID) {
        return ticketPrintInfoService.getRecordInfoById(recordID);
    }

    private String parsePrintStatus(Object status) {
        String name = null;
        if(status == null) {
            name = "";
        } else {
            try {
                name =  EnumUtil.getEnumNmae(MerchantManageEnum.PrintStatus.class, (Long)status);
            } catch (Exception e) { }
        }
        return name;
    }
}
