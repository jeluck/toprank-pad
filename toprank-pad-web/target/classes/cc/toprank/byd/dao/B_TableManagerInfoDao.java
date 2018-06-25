package cc.toprank.byd.dao;

import cc.toprank.byd.entity.B_TableManagerInfoEntity;
import cc.toprank.byd.web.vo.tablevo.OrgRoleUserInfoVO;
import cc.toprank.byd.web.vo.tablevo.ServiceAnswerTypeVO;
import cc.toprank.byd.web.vo.tablevo.TableManagerSettingVO;

import java.util.List;
import java.util.Map;

/**
 * Created by HuTao on 2017-3-8.
 */
public interface B_TableManagerInfoDao {

    B_TableManagerInfoEntity get(B_TableManagerInfoEntity InfoEntity);

    List<B_TableManagerInfoEntity> getAll();

    void update(B_TableManagerInfoEntity InfoEntity);

    void delete(B_TableManagerInfoEntity InfoEntity);

    void save(B_TableManagerInfoEntity InfoEntity);

    List<B_TableManagerInfoEntity> getTableManagerInfoByCondition(Map map);

    int getTableManagerInfoCountByCondition(Map map);

    int deleteByPrimaryKey(Long configid);

    int insert(B_TableManagerInfoEntity record);

    int insertSelective(B_TableManagerInfoEntity record);

    B_TableManagerInfoEntity selectByPrimaryKey(Long configid);

    int updateByPrimaryKeySelective(B_TableManagerInfoEntity record);

    int updateByPrimaryKey(B_TableManagerInfoEntity record);

    B_TableManagerInfoEntity getCurrentTableManager(Map param);

    int updateDeskPersonStatus(Map map);

    List<Map<String,Object>>  getAllServerItem();

    List<B_TableManagerInfoEntity> getTableManagerInfoByLoginID();

    /**
     * 根据区域餐次查询桌台负责人
     * @Author LiuXJ
     * @param map
     * @return
     */
    List<TableManagerSettingVO> getTableManagerByAreaIDAndMealsID(Map<String, Object> map);

    /** 返回桌台负责人所有负责内容 */
    List<ServiceAnswerTypeVO> getAllServiceAnswer();

    List<OrgRoleUserInfoVO> getU_LoginInfoByOrgRoleID(Map<String, Object> map);

    /**
     * 调用函数，根据当前机构ID，读取全部子级机构ID，以英文逗号,分隔
     * @param orgID
     * @return
     */
    String getChildOrgList(Long orgID);

    /**
     * 返回桌台负责人管理列表
     * @param map archiveID mappingStatus loginID tableID mealsID
     * @return
     */
    List<B_TableManagerInfoEntity> getTableManagerByParams(Map<String, Object> map);

    /**
     * 根据登录编号、桌台编号、餐次编号、服务内容确定唯一记录。如果存在多条记录则存在问题， 新增或者移除都必须通过状态来设置
     * @param map
     * @return
     */
    B_TableManagerInfoEntity selectOneByServiceType(Map<String, Object> map);

}
