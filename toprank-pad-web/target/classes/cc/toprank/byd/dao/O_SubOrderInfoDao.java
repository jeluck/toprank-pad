package cc.toprank.byd.dao;

import cc.toprank.byd.web.dto.SubOrderInfoVo;
import cc.toprank.byd.entity.O_SubOrderInfoEntity;
import cc.toprank.byd.web.vo.order.OrderEditVO;
import cc.toprank.byd.web.vo.ordervo.SubOrderVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**********************************************************************************************************************
 *
 * 版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 * O_SubOrderInfo数据访问类
 *
 ********************************************************************************************************************/
public interface O_SubOrderInfoDao {

	int deleteByPrimaryKey(Long suborderid);

	int insert(O_SubOrderInfoEntity record);

	int insertSelective(O_SubOrderInfoEntity record);

	O_SubOrderInfoEntity selectByPrimaryKey(Long suborderid);

	int updateByPrimaryKeySelective(O_SubOrderInfoEntity record);

	int updateByPrimaryKey(O_SubOrderInfoEntity record);

	O_SubOrderInfoEntity get(O_SubOrderInfoEntity subOrderInfo);

	List<O_SubOrderInfoEntity> getAll();

	void update(O_SubOrderInfoEntity subOrderInfo);

	void updateBatch(Map map);

	void delete(O_SubOrderInfoEntity subOrderInfo);

	void save(O_SubOrderInfoEntity subOrderInfo);

	/**
	 * @Description： 根据桌台编号,订单状态查询子订单信息
	 * @Author：LanZY
	 * @Time: 2017-4-7 13:16
	 * @Version 2.0.0
	 * @param subOrderInfoEntity
	 * @return
	 */
	List<O_SubOrderInfoEntity> getSubOrderInfoByTableIDAndOrderStatus(O_SubOrderInfoEntity subOrderInfoEntity);

	/**
	 * 根据桌台编号（多选）查询订单状态为进行中的子订单信息
	 *
	 * @author LinYN
	 * @param tableIDs 多个桌台编号，使用逗号隔开
	 * @return 子订单信息列表
	 */
	List<O_SubOrderInfoEntity> getUsingSubOrderInfoByTableIDs(String tableIDs);

	/**
	 * 根据主订单编号查询订单状态为进行中的子订单信息
	 *
	 * @param orderID 多个桌台编号，使用逗号隔开
	 * @return 子订单信息列表
	 *
	 * @author LinYN
	 * @date 2017-5-6
	 */
	List<O_SubOrderInfoEntity> getUsingSubOrderInfoByOrderID(Long orderID);

	/**
	 * 根据桌台编号查询订单状态为进行中的子订单信息（输出到前端的数据）
	 *
	 * @author LinYN
	 * @param tableID 桌台编号
	 * @return 订单状态为进行中的子订单信息（输出到前端的数据）
	 */
	List<SubOrderInfoVo> getSubOrderInfoVOByTableIDAndOrderStatus(Long tableID);

	/**
	 * 根据桌台编号查询订单状态为进行中的子订单信息（输出到前端的数据）
	 *
	 * @author zhouwei
	 * @param tableID 桌台编号
	 * @return 订单状态为进行中,脏台的子订单信息（输出到前端的数据）
	 */
	List<SubOrderInfoVo> getSubOrderInfoVOByTableIDAndStatus(Long tableID);


	/**
	 * 修改订单总额和实际金额
	 *
	 * @author LanZY
	 * @param o_suborderinfo
	 * @throws Exception
	 */
	void updateSubOrderInfoEntityBySubOrderID(O_SubOrderInfoEntity o_suborderinfo);

	/**
	 * @Description： 根据桌台编号,餐次编号,订单状态,创建时间查询子订单
	 * @Author：LanZY
	 * @Time: 2017-4-6 11:00
	 * @Version 2.0.0
	 * @param subOrderInfoEntity
	 * @return
	 */
	O_SubOrderInfoEntity getSubOrderInfoByCondition(O_SubOrderInfoEntity subOrderInfoEntity);



	/**
	 * 根据之前的餐次ID和餐桌ID来修改把新的餐次ID和餐桌ID传入到子订单中修改。
	 *
	 * @param O_SubOrderInfoEntity
	 *            suborderinfo
	 * @throws Exception
	 * @author xuexin
	 */
	long saveSubOrderInfo(O_SubOrderInfoEntity suborderinfo);


	/**
	 * 根据订单编号查询子订单信息
	 *
	 * @author HuangCY
	 * @param orderID
	 * @return
	 */
	List<O_SubOrderInfoEntity> queryByOrderID(Long orderID);

	/**
	 * 根据订单编号改变子订单状态
	 *
	 * @author HuangCY
	 * @param orderID
	 * @throws Exception
	 */
	void updateByID(O_SubOrderInfoEntity entity);

	/**
	 * 根据子订单编号改变子订单折扣金额和实际金额
	 *
	 * @author HuangCY
	 * @param entity
	 * @throws Exception
	 */
	void updateAmountByID(O_SubOrderInfoEntity entity);


	/**
	 * 根据桌台编号、桌台名称、订单状态查询子订单信息
	 * @date 2017-2-15
	 * @author xujin
	 * @param map
	 * @return
	 */
  List<O_SubOrderInfoEntity> Get_ReceptionO_SubOrderInfoEntityByTableIDAndTableName(Map map);

	/**
	 * 根据桌台编号、桌台名称、订单状态查询子订单信息
	 * @date 2017-2-15
	 * @author zhouwei
	 * @param map
	 * @return
	 */
	List<O_SubOrderInfoEntity> Get_ReceptionO_SubOrderInfoEntityByTableIDsAndTableName(Map map);

	/**
     * 将当前桌台的子订单转到目标桌台
     *
     * @param map#srcTableID 当前桌台ID
     * @param map#targetTableID 目标桌台ID
     *
     * @author LinYN
     * @date 2017-4-5
     */
	void transferSubOrder2TargetTable(Map map);

	/**
     * 将当前桌台的子订单转到目标桌台
     *
     * @param map#srcTableID 当前桌台ID
     * @param map#targetTableID 目标桌台ID
     *
     * @author LinYN
     * @date 2017-4-5
     */
	void changeOrderDetailSubOrderID(Map<String, Object> map);


	/**
	 * 将当前桌台的子订单合到新的主订单
	 *
	 * @param map#tableIDs 桌台ID
	 * @param map#newOrderID 新的主订单ID
	 *
	 * @author LinYN
	 * @date 2017-4-5
	 */
	void combineSubOrder2NewOrder(Map map);
	/**
	 * 根据桌台编号、餐次查询子订单信息
	 * @date 2017-2-15
	 * @author zhouwei
	 * @param map
	 * @return
	 */
	List<O_SubOrderInfoEntity> getSubOrderInfoByTableIdAndMealsId(Map map);

	O_SubOrderInfoEntity getById(long orderID);

	/**
	 * @author HuangCY
	 * @version 1.0.0
	 * @description 根据主键查找子订单信息
	 * @time 2017-4-10 11:46
	 */
	O_SubOrderInfoEntity querySubOrderInfoBySubOrderID(long orderID);

	/**
	 * @Description：根据子订单ID, 取订单的编辑信息
	 * @Author：HuTao
	 * @Time: 2017-4-20 10:26
	 * @Version 2.0.0
	 * @param subOrderID
	 * @return
	 */
	OrderEditVO getEditSubOrder(long subOrderID);

	/**
	 * @Description：保存编辑的订单数据
	 * @Author：HuTao
	 * @Time: 2017-4-20 11:39
	 * @Version 2.0.0
	 * @param mapData
	 */
	void updateEditOrderInfo(Map<String,Object> mapData);

	/**
	 * @Description：根据桌台ID ,取子订单信息列表
	 * @Author：HuTao
	 * @Time: 2017-4-21 17:44
	 * @Version 2.0.0
	 * @param subOrderID
	 * @return
	 */
	List<O_SubOrderInfoEntity> getSubOrderList(Long subOrderID);



	/**
	 * @Description： 根据桌台ID查询进行状态或未下单状态
	 * @Author：LanZY
	 * @Time: 2017-4-24 13:25
	 * @Version 2.0.0
	 * @param tableID
	 * @return
	 */
	List<O_SubOrderInfoEntity> getSubOrderStatusInfoByTableID(Long tableID);

	/**
	 * @Description： 根据桌台ID查询进行状态或未下单、待支付、己支付（脏台）状态
	 * @param tableID
	 *
	 * @Author：LinYN
	 * @Time: 2017-5-26
	 * @return
	 */
	List<O_SubOrderInfoEntity> getRelationSubOrderInfoByTableID(Long tableID);


	/**
	 * 根据桌台编号、桌台名称、订单状态修改子订单信息
	 * @date 2017-4-25
	 * @author zhouwei
	 * @param map
	 * @return
	 */
	int update_ReceptionO_SubOrderInfoEntityByTableIDs(Map map);

	/**
	 * @Description：根据档案ID,桌台状态,区域ID ,取桌台信息
	 * @Author：HuTao
	 * @Time: 2017-4-25 9:50
	 * @Version 2.0.0
	 * @param mapData
	 * @return
	 */
	List<O_SubOrderInfoEntity> getTableListByTableStatusAreaID(Map<String,Object> mapData);

	List<O_SubOrderInfoEntity> getAllTableListByTableStatusAreaID(Map<String,Object> mapData);


	/**
	 * @Description：根据档案ID,桌台状态,取桌台状态总数
	 * @Author：HuTao
	 * @Time: 2017-4-25 9:54
	 * @Version 2.0.0
	 * @param map
	 * @return
	 */
	int getTableCountByStatusAndArchiveID(Map<String,Object> map);

	/**
	 * @Description：堂食订单信息查询
	 * @Author：HuTao
	 * @Time: 2017-5-3 10:35
	 * @Version 2.0.0
	 * @param mapData
	 * @return
	 */
	List<O_SubOrderInfoEntity> quOrderInfo(Map<String,Object> mapData);

	/**
	 * @Description：根据订单ID,取所有子订单的信息
	 * @Author：HuTao
	 * @Time: 2017-5-5 10:29
	 * @Version 2.0.0
	 * @param orderID
	 * @return
	 */
	List<O_SubOrderInfoEntity> getSubOrderInfoByOrderID(Long orderID);

	/**
	 * @Description：根据订单ID，取收款记录明细
	 * @Author：HuTao
	 * @Time: 2017-5-5 13:40
	 * @Version 2.0.0
	 * @param orderID
	 * @return
	 */
	List<Map<String,Object>> getMakeCollectionsRecode(Long orderID);

	/**
	 * @Description：根据订单ID，取拆扣信息明细
	 * @Author：HuTao
	 * @Time: 2017-5-5 13:40
	 * @Version 2.0.0
	 * @param orderID
	 * @return
	 */
	List<Map<String,Object>> getOrderDiscountInfo(Long orderID);

	/**
	 * @Description：根据子订单状态，取拆扣信息明细
	 * @Author：HuTao
	 * @Time: 2017-5-12 9:25
	 * @Version 2.0.0
	 * @param parm
	 * @return
	 */
	List<O_SubOrderInfoEntity> getSubOrderTableByStatus(Map<String,Object> parm);

	/**
	 * 根据桌台编号、桌台名称、订单状态查询子订单信息
	 * @date 2017-5-15
	 * @author zhouwei
	 * @param map
	 * @return
	 */
	List<O_SubOrderInfoEntity> getO_SubOrderInfoEntityByTableIDs(Map map);
	
	/**
	 * @author HuangCY
	 * @version 1.0.0
	 * @description 根据子订单ID更新状态
	 * @time 2017-6-6 16:36
	 */
	void updateStatusBySubOrderID (O_SubOrderInfoEntity entity);


	/**
	 * @Description： 查询预定子订单
	 * @Author：LanZY
	 * @Time: 2017-4-6 11:00
	 * @Version 2.0.0
	 * @return
	 */
	O_SubOrderInfoEntity getBookingSubOrderInfo(@Param("orderID") Long orderID,@Param("tableID") Long tableID);

	List<O_SubOrderInfoEntity> getBookingSubOrderListByOrderID(Long orderID);
	/**
	 * @author HuangCY
	 * @version 1.0.0
	 * @description 根据子订单ID集合查询子订单信息
	 * @time 2017-6-12 11:52
	 */
	List<O_SubOrderInfoEntity> querySubOrderInfoByIDs (List<Long> subOrderIDlist);
}