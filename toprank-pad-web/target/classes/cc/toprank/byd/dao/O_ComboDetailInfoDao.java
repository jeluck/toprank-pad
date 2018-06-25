package cc.toprank.byd.dao;


import cc.toprank.byd.entity.O_ComboDetailInfoEntity;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**********************************************************************************************************************
 *
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 *   O_ComboDetailInfo数据访问类
 *
 * ********************************************************************************************************************/
public interface O_ComboDetailInfoDao {
    int deleteByPrimaryKey(Long recordid);

    int insert(O_ComboDetailInfoEntity record);

    int insertSelective(O_ComboDetailInfoEntity record);

    int updateBatch(Map<String, Object> map);

    int updateBatch2(List<O_ComboDetailInfoEntity> record);

    O_ComboDetailInfoEntity selectByPrimaryKey(Long recordid);

    int updateByPrimaryKeySelective(O_ComboDetailInfoEntity record);

    int updateByPrimaryKey(O_ComboDetailInfoEntity record);

    O_ComboDetailInfoEntity get(O_ComboDetailInfoEntity comboDetailInfo);

    List<O_ComboDetailInfoEntity> getAll();

    void update(O_ComboDetailInfoEntity comboDetailInfo);

    void delete(O_ComboDetailInfoEntity comboDetailInfo);

    void save(O_ComboDetailInfoEntity comboDetailInfo);

    /**
     * 根据明细编号查询套餐信息
     *
     * @return
     * @author LanZY
     */
    List<O_ComboDetailInfoEntity> getComboDetailInfoByDetailIDAndStatus(O_ComboDetailInfoEntity comboDetailInfo);

    /**
     * 根据明细编号查询套餐明细ID字符串
     *
     * @param DetailID
     * @return
     */
    Map<String, Object> getRecordIDStrByDetailID(Long DetailID);

    /**
     * 根据套餐订单明细编号修改套餐明细数量
     *
     * @param comboDetailInfo
     * @author LanZY
     */
    void updateComboDetailInfoByDetailID(O_ComboDetailInfoEntity comboDetailInfo);

    /**
     * 根据明细ID删除套餐信息
     *
     * @param comboDetailInfoEntity
     * @throws Exception
     * @author HuangCY
     */
    void deleteByDetailID(O_ComboDetailInfoEntity comboDetailInfoEntity);

    /**
     * 通过detail id列表修改套餐明细菜品制作状态
     *
     * @author LeeJun
     * @time 2017-5-22 14:52
     * @version 2.0.0
     */
    int batchStatusByDetailIDs(@Param("recordIDs") String recordIDs, @Param("produceStatus") Long produceStatus, @Param("now") LocalDateTime now);

    /**
     * 通过detailIDs查询套餐明细ID列表
     *
     * @author LeeJun
     * @time 2017-5-22 17:52
     * @version 2.0.0
     */
    List<Long> getComboRecordIDByDetailIDs(List detailIDs);

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 根据明细ID查询套餐明细
     * @time 2017-5-25 10:22
     */
    List<O_ComboDetailInfoEntity> getComboDetailByDetailID(Long detailID);

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 根据记录ID和制作状态查询套餐明细
     * @time 2017-5-25 10:22
     */
    O_ComboDetailInfoEntity getComboDetailByRecordIDAndStatus(O_ComboDetailInfoEntity entity);

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 根据套餐明细ID修改套餐的状态和制作时间
     * @time 2017-6-15 9:55
     */
    void updateComboByRecordID(O_ComboDetailInfoEntity entity);
}