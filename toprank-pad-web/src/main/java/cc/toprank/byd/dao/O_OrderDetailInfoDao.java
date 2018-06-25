package cc.toprank.byd.dao;


import cc.toprank.byd.entity.O_OrderDetailInfoEntity;
import cc.toprank.byd.pad.pojo.ConsumerDetailsDTO;
import cc.toprank.byd.pad.pojo.OrderDetailsDTO;
import cc.toprank.byd.pad.pojo.OrderDishesDTO;
import cc.toprank.byd.web.vo.menu.UnderOrderDetailVO;
import cc.toprank.byd.web.vo.product.ProductDisplayVO;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


/**********************************************************************************************************************
 *
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 *   O_OrderDetailInfo数据访问类
 *
 * ********************************************************************************************************************/
public interface O_OrderDetailInfoDao {

    int deleteByPrimaryKey(Long detailid);

    int insert(O_OrderDetailInfoEntity record);

    int updateBatch(Map<String, Object> map);

    int updateBatch2(List<O_OrderDetailInfoEntity> record);

    int insertSelective(O_OrderDetailInfoEntity record);

    O_OrderDetailInfoEntity selectByPrimaryKey(Long detailid);

    int updateByPrimaryKeySelective(O_OrderDetailInfoEntity record);

    int updateByPrimaryKey(O_OrderDetailInfoEntity record);

    /**
     * 查询待制作菜品
     *
     * @author LeeJun
     * @time 2017-3-10 11:39
     * @version 2.0.0
     */
    List<Map<String, Object>> selectWaitMakeProducts(@Param("archiveid") Long archiveid, @Param("showType") Long showType, @Param("categoryID") String categoryID);

    /**
     * 海鲜池销量查询
     *
     * @author ZhaoLc
     * @time 2017-3-13 14:39
     * @version 2.0.0
     */
    List<Map<String, Object>> queryStallSalesVolumeByCondition(Map<String, Object> map);

    O_OrderDetailInfoEntity get(O_OrderDetailInfoEntity OrderDetailInfo);

    List<O_OrderDetailInfoEntity> getAll();

    void update(O_OrderDetailInfoEntity orderDetailInfo);

    void delete(O_OrderDetailInfoEntity orderDetailInfo);

    void save(O_OrderDetailInfoEntity orderDetailInfo);

    /**
     * 通过子订单编号查询子订单明细
     *
     * @param id
     * @author ZhangBo
     * @since 2016-10-25
     */

    List<O_OrderDetailInfoEntity> getAllById(Long id);


    /**
     * @param subOrderID 子订单ID
     * @return
     * @Description： 根据子订单ID查询已下单的订单明细
     * @Author：LanZY
     * @Time: 2017-4-11 11:23
     * @Version 2.0.0
     */
    List<UnderOrderDetailVO> getUnderOrderDetailListBySubOrderID(Long subOrderID);

    List<UnderOrderDetailVO> getUnderComboDetailListBySubOrderID(Long subOrderID);

    /**
     * @param map
     * @return
     * @Description 根据菜单编号修改称重信息
     * @author ZhouWei
     * @Time 2017-04-20
     * @version 2.0.0
     */
    int updateOrderDetailInfoByVariantID(Map map);

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 根据订单明细ID更新制作状态
     * @time 2017-4-19 10:51
     */
    public void updateProduceStatusByDetailID(Map map) throws Exception;

    /**
     * Description 根据子订单id获取订单详情
     *
     * @param subOrderID
     * @return
     * @author ZhouWei
     * @time 2017-04-21
     */
    public List<O_OrderDetailInfoEntity> getOrderDetailInfoList(Long subOrderID);

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 根据子订单ID和点菜方式查询订单明细
     * @time 2017-4-28 14:12
     */
    public List<O_OrderDetailInfoEntity> queryOrderDetailByCondition(O_OrderDetailInfoEntity entity);

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 根据子订单ID和制作状态查询订单明细
     * @time 2017-5-2 15:00
     */
    public List<O_OrderDetailInfoEntity> queryBySubOrderIDAndProduceStatus(O_OrderDetailInfoEntity entity);

    /**
     * @author ZhaoLingchen
     * @version 1.0.0
     * @description 根据子订单ID查询订单明细
     * @time 2017-6-9 15:00
     */
    public List<O_OrderDetailInfoEntity> selectBySubOrderId(Long subOrderId);

    /**
     * @param subOrderID
     * @return
     * @Description：子订单ID,取菜品的明细信息
     * @Author：HuTao
     * @Time: 2017-5-5 14:24
     * @Version 2.0.0
     */
    List<O_OrderDetailInfoEntity> getOrderFoodDetail(Long subOrderID);


    /**
     * @Description根据点菜方式和menuID查询是否存在订单详情
     * @version 2.0.0
     * @time 2017-5-12
     * @author ZhouWei
     */
    public O_OrderDetailInfoEntity getOrderDetailInfo(Map map);

    /**
     * @Description根据点菜方式和parentID查询数量
     * @version 2.0.0
     * @time 2017-5-12
     * @author ZhouWei
     */
    public Object getIsOperationFood(Map map);

    /**
     * @description 根据机构编号和订单明细编号查询订单明细信息
     * @author LinYN
     * @time 2017-5-16
     */
    public List<O_OrderDetailInfoEntity> getOrderDetailInfoByIDsAndArchiveID(Map map);

    /**
     * @description 复制菜：查询当前桌台可以复制的菜品
     * @author LinYN
     * @time 2017-5-16
     */
    public List<ProductDisplayVO> getOrderDetailInfoForCopy(Map map);

    /**
     * 根据菜单编号查询当天订单明细
     *
     * @param map
     * @return
     */
    public List<O_OrderDetailInfoEntity> getOrderDetailInfoByMenuID(Map map);

    /**
     * @description 根据menuid、optionid、ArchiveID查询预定数量
     * @author chenkangyi
     * @time 2017-5-16
     */
    int getBookingSumByMenuIDOptionIDArchiveID(Map<String, Object> map);

    /**
     * 根据子订单编号查询订单详情信息
     *
     * @author LeeJun
     * @time 2017-5-17 15:30
     * @version 2.0.0
     */
    OrderDetailsDTO getOrderDetailsBySubOrderID(@Param("subOrderID") Long subOrderID, @Param("mealsID") Long mealsID);

    /**
     * 根据订单明细ID查询Dishes对象
     *
     * @author LeeJun
     * @time 2017-6-16 14:29
     * @version 2.0.0
     */
    List<OrderDishesDTO.Dishes> getDishesListByDetailIDs(String detailIDs);

    /**
     * 根据子订单编号查询订单明细信息
     *
     * @author LeeJun
     * @time 2017-5-17 15:31
     * @version 2.0.0
     */
    List<ConsumerDetailsDTO> getDetailListBySubOrderID(Long subOrderID);

    /**
     * 获取子订单下的所有菜品明细ID
     *
     * @author LeeJun
     * @time 2017-5-19 17:40
     * @version 2.0.0
     */
    List<Long> getDetailIDByOrderID(Long orderID);

    /**
     * 获取子订单下的所有菜品明细ID
     *
     * @author Zhaolingchen
     * @time 2017-5-19 17:40
     * @version 2.0.0
     */
    List<Long> getDetailIDBySubOrderID(Long subOrderID);

    /**
     * 根据subOrderID查询能打折的菜品
     * chenkangyi
     * 2017-5-21 17:12
     *
     * @param subOrderID
     * @return
     */
    List<O_OrderDetailInfoEntity> selectAllowDiscountBySubOrderID(Long subOrderID);

    /**
     * 通过订单明细ID列表修改明细菜品制作状态
     *
     * @author LeeJun
     * @time 2017-5-22 14:13
     * @version 2.0.0
     */
    int batchUpdateStatusByDetailIDs(@Param("detailIDs") String detailIDs, @Param("produceStatus") Long produceStatus, @Param("now") LocalDateTime now);

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 根据明细ID和制作状态查询订单明细
     * @time 2017-5-25 9:47
     */
    O_OrderDetailInfoEntity getOrderDetailByIDAndStatus(O_OrderDetailInfoEntity orderDetailInfo);

    /**
     * 根据subOrderId查询不包括某些标签的菜品
     *
     * @param targetType
     * @param tagCode
     * @param subOrderId
     * @return
     */
    List<Map<String, Object>> getProductBySubOrderAndTag(@Param("targetType") Long targetType, @Param("tagCode") String tagCode,
                                                         @Param("subOrderId") Long subOrderId);

    /**
     * 根据菜品制作状态和subOrderId查询菜品
     *
     * @param subOrderId
     * @param productStatus
     * @return
     */
    List<Map<String, Object>> getProductBySubOrderAndProStatus(@Param("subOrderId") Long subOrderId, @Param("productStatus") Long productStatus);

    /**
     * 可以划单的菜品
     *
     * @param subOrderId
     * @return
     */
    List<Map<String, Object>> getProductCancel(Long subOrderId);

    /**
     * k可以退菜的菜品
     *
     * @param subOrderId
     * @return
     */
    List<Map<String, Object>> getProductBack(Long subOrderId);

    /**
     * 可以转菜的菜品
     *
     * @param subOrderId
     * @return
     */
    List<Map<String, Object>> getProductTransfer(Long subOrderId);

    /**
     * @param subOrderID
     * @return
     * @Description： 根据子订单ID查询订单明细
     * @Author：LanZY
     * @Time: 2017-6-13 17:21
     * @Version 2.0.0
     */
    List<O_OrderDetailInfoEntity> getOrderDetailInfoListBySubOrderID(Long subOrderID);

    /**
     * @description 获取所有子订单下的所有菜品的会员价的总额
     * @author chenkangyi
     * @time 2017-6-16 13:50
     */
    BigDecimal getSubOrderlistAllDetailMemberPriceTotal(Map<String, Object> map);

    /**
     * @description 获取所有子订单下的所有能打折的菜品
     * @author chenkangyi
     * @time 2017-6-16 13:50
     */
    List<O_OrderDetailInfoEntity> selectAllowDiscountBySubOrderIDList(Map<String, Object> map);

}