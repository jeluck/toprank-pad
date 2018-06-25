package cc.toprank.byd.dao;



import cc.toprank.byd.entity.O_OrderDetailInfoEntity;
import cc.toprank.byd.entity.O_SubOrderInfoEntity;
import cc.toprank.byd.entity.O_TicketPrintInfoEntity;
import cc.toprank.byd.vo.print.BusinessVO;
import cc.toprank.byd.vo.print.PortPrinterVO;
import cc.toprank.byd.vo.print.PrinterVO;
import cc.toprank.byd.vo.print.ProductDetailVO;
import cc.toprank.byd.vo.print.message.DeviceMessageVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**********************************************************************************************************************
 *
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 *   O_TicketPrintInfo数据访问类
 *
 * ********************************************************************************************************************/

/**
 * @Description：
 * @Author：HuTao
 * @Time: 2017-2-21 9:27
 * @Version 2.0.0
 */
 public interface O_TicketPrintInfoDao {

	List<O_TicketPrintInfoEntity> getAll();

	void update(O_TicketPrintInfoEntity ticketPrintInfo);

	void delete(O_TicketPrintInfoEntity ticketPrintInfo);

	void save(O_TicketPrintInfoEntity ticketPrintInfo);

	O_TicketPrintInfoEntity get(O_TicketPrintInfoEntity ticketPrintInfo);
	/**
	 * @Description：根据订单号到档案ID
	 * @Author：HuTao
	 * @Time: 2017-2-20 17:43
	 * @Version 2.0.0
	 * @param subOrderID
	 * @return
	 * @throws Exception
	 */
	 Map<String,Object> getArchiveID(String subOrderID);

	//  获的票据打印配置信息
	 List<Map<String,Object>> getPrintConfigtInfo(Map<String,String> dataMap);
	//  获取订单信息
	 O_SubOrderInfoEntity getOrderInfo(String vOrderID);

	//  获取订单 菜系类别信息
	  List<Map<String,Object>> getOrderMenuType(Map<String,String> dataMap);

	//   订单明细
	 List<O_OrderDetailInfoEntity> getAllMenuList(Map<String,String> conMap);

	//   订单的台单明细
	 List<O_OrderDetailInfoEntity> getMenuList(Map<String,String> conMap);
    //  取订单的 楼层 桌号 餐次 等信息
	 O_OrderDetailInfoEntity getOrderDetailInfo(String subOrderID);

    //  取厨打明细
	 List<O_OrderDetailInfoEntity> getPrintMenuList(Map<String,String> dataMap);

	//  取退菜所有明细
	 List<O_OrderDetailInfoEntity> getAllCancelMenuList(Map<String,String> dataMap);

	//  取退菜明细  按类别
	 List<O_OrderDetailInfoEntity> getCancelMenuList(Map<String,String> dataMap);

	//  获取套餐明细
	 List<Map<String,Object>> getComboDetail(String detailID );

	//  取单道菜的IP
	 List<Map<String,Object>> getCancelMenuPrintIPSet(Map<String,String> dataMap);

	//  获取支付方式明细
	 List<Map<String,Object>> getPayType(String subOrderIDStr);

	 //   获取充值打印记录
	 O_TicketPrintInfoEntity getRechargeTicketInfo(Map<String,Object> dataMap);


	 //查询打印日志，按打印日期，打印机名，打印内容查询
	 List<Map<String, Object>> getPrintLogList(@Param("printDate")String printDate, @Param("ceriation") String ceriation);


	/**
	 * 根据业务ID和业务类型找到打印记录
	 *
	 * @param businessInfo
	 * @return
	 * @author LinYN
	 * @date 2017-6-8
	 */
	List<O_TicketPrintInfoEntity> getTicketPrintInfoByBusinessIDAndType(BusinessVO businessInfo);

	/**
	 * 根据单据编号查询打印机
	 *
	 * @param queryParam
	 * @return
	 * @author LinYN
	 * @date 2017-6-10
	 */
	List<PrinterVO> getPrinterListByTicketCode(Map<String, Object> queryParam);

	/**
	 * 根据菜品查询出品口和打印机
	 *
	 * @param productDetail
	 * @return
	 * @author LinYN
	 * @date 2017-6-10
	 */
	List<PortPrinterVO> getPortPrinterByProductDetail(ProductDetailVO productDetail);

	/**
	 * 根据档案编号获取打印机列表
	 *
	 * @param archiveID
	 * @return
	 * @author LinYN
	 * @date 2017-6-13
	 */
	List<DeviceMessageVO> getPrinterListByArchiveID(Long archiveID);

	/**
	 * 根据打印机编号修改打印机状态
	 *
	 * @param printerParam
	 * @return
	 * @author LinYN
	 * @date 2017-6-13
	 */
	void updatePrinterStatusByID(PrinterVO printerParam);

	/**
	 * 根据subOrderID查询打印记录
	 * @param subOrderID
	 * @return
	 */
	List<Map<String, Object>> getRecordsBySubOrder(Long subOrderID);

	Map<String, Object> getRecordInfoById(Long recordID);
}