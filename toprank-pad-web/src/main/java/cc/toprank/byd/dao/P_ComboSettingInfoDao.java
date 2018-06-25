package cc.toprank.byd.dao;

import cc.toprank.byd.entity.P_ComboSettingInfoEntity;
import cc.toprank.byd.vo.ComboProductVO;

import java.util.List;

public interface P_ComboSettingInfoDao {
    int deleteByPrimaryKey(Long settingid);

    int insert(P_ComboSettingInfoEntity record);

    int insertSelective(P_ComboSettingInfoEntity record);

    P_ComboSettingInfoEntity selectByPrimaryKey(Long settingid);

    int updateByPrimaryKeySelective(P_ComboSettingInfoEntity record);

    int updateByPrimaryKey(P_ComboSettingInfoEntity record);

    /**
     * 通过商品ID查询套餐明细信息
     * @param productID
     * @return
     */
    List<P_ComboSettingInfoEntity> getByProductID(Long productID);

    List<ComboProductVO> getByComboSettingProductID(Long productID);
}