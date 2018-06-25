package cc.toprank.byd.dao;


import cc.toprank.byd.entity.B_DinningTableInfoEntity;
import cc.toprank.byd.web.vo.tablevo.DinningTableInfoVO;
import cc.toprank.byd.web.vo.tablevo.TableMessageVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**********************************************************************************************************************
 *
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 *   B_DinningTableInfo数据访问类
 *
 * ********************************************************************************************************************/

public interface B_DinningTableInfoDao {

    int deleteByPrimaryKey(Long tableid);

    int insert(B_DinningTableInfoEntity record);

    int insertSelective(B_DinningTableInfoEntity record);

    B_DinningTableInfoEntity selectByPrimaryKey(Long tableid);

    int updateByPrimaryKeySelective(B_DinningTableInfoEntity record);

    int updateByPrimaryKey(B_DinningTableInfoEntity record);

    B_DinningTableInfoEntity get(B_DinningTableInfoEntity InfoEntity);

    List<B_DinningTableInfoEntity> getAll();

    int update(B_DinningTableInfoEntity InfoEntity);

    void delete(B_DinningTableInfoEntity InfoEntity);

    void save(B_DinningTableInfoEntity InfoEntity);

    /**
     * 根据tableIds查询餐桌信息
     */
    List<B_DinningTableInfoEntity> getTablesByTableIds(String tableIDs);

    /**
     *
     * 查询所有在用的餐桌信息
     * @author ZhangBo
     * @since 2016-10-24
     *
     *
     */
    /**
     * 批量清台
     *
     * @param
     * @return
     */
    void updateTablesBatch(Map<String, Object> map);

    /**
     * 根据orgID和AreaID获取餐桌信息
     *
     * @author ZhangBo
     * @since 2016-12-6
     */
    List<B_DinningTableInfoEntity> getTableInfoByAreaIDAndOrgID(Map map);

    /**
     * 根据OrgID和table Code确定AreaID
     *
     * @author ZhangBo
     * @since 2016-12-19
     */
    B_DinningTableInfoEntity getTableInfoByOrgIDAndTableCode(Map map);


    /**
     * 根据桌台ID查询桌台
     *
     * @param dinning B_DinningTableInfoEntity
     * @return B_DinningTableInfoEntity
     * @author xuexin
     */
    B_DinningTableInfoEntity getDinningTableInfoEntityByTableId(B_DinningTableInfoEntity dinning);


    /**
     * 根据机构编号和区域编号查询可以联合的桌台
     * 只有在使用中并且没有关联属性的桌台才可以联台
     *
     * @param map#archiveID 机构编号
     * @return 可以联合的桌台
     * @author LinYN
     * @since 2017-3-24
     */
    List<TableMessageVO> getCanCombineTableInfos(Map<String, Object> map);

    /**
     * 根据联台编号查询可以拆分的桌台
     * 只有联台才可以拆分
     *
     * @param map#tableID 联台编号
     * @return 可以拆分的桌台
     * @author LinYN
     * @since 2017-3-24
     */
    List<TableMessageVO> getCanSplitTableInfos(Map<String, Object> map);


    /**
     * 根据联台编号查询可以拆分的桌台
     * 只有联台才可以拆分
     *
     * @param map#tableID 联台编号
     * @return 联台集合
     * @author zhouwei
     * @since 2017-3-24
     */
    List<TableMessageVO> getCanUnionTables(Map<String, Object> map);

    /**
     * 根据联台编号查询可以转台的桌台
     * 只有联台才可以拆分
     *
     * @param map#tableID 联台编号
     * @return 可以拆分的桌台
     * @author LinYN
     * @since 2017-3-24
     */
    List<TableMessageVO> getCanTransferTableInfos(Map<String, Object> map);

    /**
     * 根据桌台名称和机构编号获取正在使用中的桌台
     *
     * @param map#tableName 桌台名称
     * @param map#archiveID 机构编号
     * @return 正在使用中的桌台
     * @author LinYN
     * @date 2017-4-21
     */
    List<TableMessageVO> getUsingTableInfosByTableName(Map<String, Object> map);

    /**
     * 根据多个桌台编号改变当前使用中的桌台信息中的联合属性
     *
     * @param map#tableIDs      桌台编号
     * @param map#combineName   联台名称
     * @param map#combineNumber 联台数量
     * @author LinYN
     * @since 2017-3-24
     */
    void updateCombineInfoByTableIDs(Map<String, Object> map);


    /**
     * 根据桌台编号和状态获取右侧展示信息
     *
     * @author zhowuei
     */
    DinningTableInfoVO getTableShowMessage(Map map);

    /**
     * 根据桌台ID查询桌台信息
     *
     * @author ZhouWei
     */
    B_DinningTableInfoEntity getDinningTableInfoEntityByTableID(Map map);

    /**
     * @author LiSH  @date 2017年1月16日
     * @Description: (根据tableID获得基础table信息)
     */
    Map<String, Object> getTableBaseDetailByTableID(Long tableID);

    /**
     * @author LiSH  @date 2017年1月16日
     * @Description: 根据tableID获取使用中订单列表
     */
    List<Map<String, Object>> getUseringOrderListByTableID(@Param("tableID") Long tableID);

    /**
     * @author LiSH  @date 2017年1月18日
     * @Description: 根据areaID获得对应的桌台详情
     */
    List<Map<String, String>> getListByAreaID(Map<String, Object> map);

    /**
     * @author LiSH  @date 2017年1月18日
     * @Description: TODO(这里用一句话描述这个方法的作用)
     */
    Map<String, String> getTableBaseDetailByTableIDAndMealsID(Long tableID, Long mealsid);

    /**
     * @author LiYC  @date 2017年2月16日
     * @Description: 根据水牌ID获取该水牌目前绑定的桌台
     */
    B_DinningTableInfoEntity queryDinningTableInfoByPadID(@Param("padID") Long padID, @Param("mappingStatus") Long mappingStatus);

    /**
     * 根据ArchiveID 查询所有在用的桌台信息
     *
     * @author HuangCY
     * @Time 2017-3-14
     */
    Map<String, Object> queryDinningTableInfoByArchiveID(B_DinningTableInfoEntity entity);

    /**
     * 按条件查询桌台信息
     *
     * @param map
     * @author HuangCY
     * @Time 2017-3-14
     */
    List<B_DinningTableInfoEntity> queryDinningTableInfoByCondition(Map map);

    /**
     * @Description：根所档案ID ,区域ID 取桌台信息
     * @Author：HuTao
     * @Time: 2017-5-11 14:53
     * @Version 2.0.0
     * @param map
     * @return
     */
    List<B_DinningTableInfoEntity> getDinningTableInfoArchiveIDAndAreaID(Map map);

    /**
     * @Description：
     * @Author：HuTao
     * @Time: 2017-5-15 13:37
     * @Version 2.0.0
     * @param map
     * @return
     */
    int  getTableCountByStatusAndArchiveID(Map map);

    /**
     * @author Zhaolingchen
     * @version 2.0.0
     * @description 根据预订单查询相关桌台
     * @time 2017-06-14 14:00:00
     */
    List<B_DinningTableInfoEntity> queryBookingTableListByBookingID(Long bookingID);

    /**
     * @author 赵凌晨
     * @version 2.0.0
     * @description 根据区域筛选可以用桌
     * @time 2017-05-17 17:00:00
     */
    List<B_DinningTableInfoEntity> getTableByStatusAndArchiveID(Map map);

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 根据桌台ID改变桌台状态
     * @time 2017-5-19 14:05
     */
    void updateTableStatusByTableID (B_DinningTableInfoEntity entity) throws Exception;


    /**
     * @author Zhaolingchen
     * @version 2.0.0
     * @description 获取桌台预订信息状态信息
     * @time 2017-05-20 16:00:00
     */
    public  List<Map<String,Object>>  getDinningTableBookingInfo(Map param) throws Exception;

    /**
     * @author Zhaolingchen
     * @version 2.0.0
     * @description 查询用户偏好桌
     * @time 2017-05-20 16:00:00
     */
    public List<B_DinningTableInfoEntity> getPreferenceDinningTableInfo(Map param) throws Exception;

    /**
     * @author LiuXJ
     * @param map
     * @return
     */
    List<B_DinningTableInfoEntity> getTablesByAreaIDAndTableCode(Map map);

}