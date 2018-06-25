package cc.toprank.byd.dao;

import cc.toprank.byd.entity.B_TableManagerChangeInfoEntity;
import cc.toprank.byd.web.vo.tablevo.TableManagerChangeInfoVO;

import java.util.List;
import java.util.Map;

public interface B_TableManagerChangeInfoDao {
    int deleteByPrimaryKey(Long changeID);

    int insert(B_TableManagerChangeInfoEntity record);

    int insertSelective(B_TableManagerChangeInfoEntity record);

    B_TableManagerChangeInfoEntity selectByPrimaryKey(Long changeID);

    int updateByPrimaryKeySelective(B_TableManagerChangeInfoEntity record);

    int updateByPrimaryKey(B_TableManagerChangeInfoEntity record);

    List<TableManagerChangeInfoVO> getTableManagerChangeInfo(Map<String, Object> map);
    List<Map<String, Object>> getUserInfo();
}