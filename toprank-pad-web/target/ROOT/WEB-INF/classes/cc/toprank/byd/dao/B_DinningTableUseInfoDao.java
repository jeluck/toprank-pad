package cc.toprank.byd.dao;


import cc.toprank.byd.entity.B_DinningTableUseInfoEntity;
import java.util.List;
import java.util.Map;

/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 *   B_DinningTableUseInfo数据访问类
 * 
 * ********************************************************************************************************************/


public interface B_DinningTableUseInfoDao {

	int deleteByPrimaryKey(Long hisid);

	int insert(B_DinningTableUseInfoEntity record);

	int insertSelective(B_DinningTableUseInfoEntity record);

	B_DinningTableUseInfoEntity selectByPrimaryKey(Long hisid);

	int updateByPrimaryKeySelective(B_DinningTableUseInfoEntity record);

	int updateByPrimaryKey(B_DinningTableUseInfoEntity record);

	B_DinningTableUseInfoEntity get(B_DinningTableUseInfoEntity InfoEntity);

	List<B_DinningTableUseInfoEntity> getAll();

	int update(B_DinningTableUseInfoEntity InfoEntity);

	int updateBatch(Map map);

	void delete(B_DinningTableUseInfoEntity InfoEntity);

	int save(B_DinningTableUseInfoEntity InfoEntity);
	/**
     * 根据桌台id 查询桌台使用记录数据
     * @param Map<String,Object>桌台id
     * @author zhaolingchen
     * @throws Exception 
     */
	B_DinningTableUseInfoEntity getDinningTableUseInfoEntityByTableIDAndTableStatus(Map<String,Object> map);

	/**
	 * 根据桌台id 查询桌台使用记录数据
	 * @param Map<String,Object>桌台id
	 * @author zhaolingchen
	 * @throws Exception
	 */
	List<B_DinningTableUseInfoEntity> getDinningTableUseInfoEntityByTableIDs(Map<String,Object> map);

	/**
	 * 根据桌台id 查询桌台使用记录数据
	 * @param map 桌台id
	 * @author zhouwei
	 * @throws Exception
	 */
	B_DinningTableUseInfoEntity getDinningTableUseInfoEntityByTableIDAndStatus(Map<String,Object> map);

	/**
	 * 根据桌台编号更新桌台使用信息
	 * @author HuangCY
	 * @param entity
	 * @throws Exception
	 */
	void updateByTableID (B_DinningTableUseInfoEntity entity);
	
	/**
	 * 根据根据餐次桌台id查询当前最新桌台使用信息第一条记录
	 * @param Map<String,Object>			餐次id，桌台id
	 * @author zhoufy
	 * @throws Exception 
	 */
	B_DinningTableUseInfoEntity getDinningTableUseInfoByTableIDAndMealsID(Map<String,Object> map);

	/**
	 * 根据档案、桌台、餐次  获取桌台使用信息表
	 * @date 2017-1-5
	 * @author LiuWH
	 * @param b_DinningTableUseInfoEntity
	 * @return
	 */
	B_DinningTableUseInfoEntity Get_ReceptionB_DinningTableUseInfoEntityByTableID(B_DinningTableUseInfoEntity b_DinningTableUseInfoEntity);

	/**
	 * @Description：根据桌台ID,更新服务ID
	 * @Author：HuTao
	 * @Time: 2017-4-20 13:40
	 * @Version 2.0.0
	 * @param parm
	 */
	void updateTableServerInfo(Map<String,Object> parm);


	/**
	 * @Description： 根据tableID 和 空结束时间 查桌台使用信息
	 * @Author：LanZY
	 * @Time: 2017-5-27 19:05
	 * @Version 2.0.0
	 * @param b_DinningTableUseInfoEntity
	 * @return
	 */
	B_DinningTableUseInfoEntity getDinningTableUseInfoByTableIDAndEndTime(Long tableID);

}