package cc.toprank.byd.dao;

import cc.toprank.byd.entity.B_TableManagerSettingInfoEntity;
import cc.toprank.byd.web.vo.tablevo.TableManagerSettingVO;

import java.util.List;

public interface B_TableManagerSettingInfoDao {
    int deleteByPrimaryKey(Long configID);

    int insert(B_TableManagerSettingInfoEntity record);

    int insertSelective(B_TableManagerSettingInfoEntity record);

    B_TableManagerSettingInfoEntity selectByPrimaryKey(Long configID);

    int updateByPrimaryKeySelective(B_TableManagerSettingInfoEntity record);

    int updateByPrimaryKey(B_TableManagerSettingInfoEntity record);

    /**
     * 根据 桌台负责人配置信息 与餐厅排班信息，返回所有日期餐次的桌台负责人
     * @param archiveID
     * @return
     */
    List<TableManagerSettingVO> getTableManagerSettingInfoByArchiveID(Long archiveID);
}