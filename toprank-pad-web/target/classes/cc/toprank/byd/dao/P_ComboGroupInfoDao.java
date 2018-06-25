package cc.toprank.byd.dao;

import cc.toprank.byd.entity.P_ComboGroupInfoEntity;

import java.util.List;

/**
 * Created by LanZY on 2017-4-21.
 */
public interface P_ComboGroupInfoDao {
    P_ComboGroupInfoEntity get(P_ComboGroupInfoEntity comboGroupInfo);

    List<P_ComboGroupInfoEntity> getAll();

    void update(P_ComboGroupInfoEntity comboGroupInfo);

    void delete(P_ComboGroupInfoEntity comboGroupInfo);

    void save(P_ComboGroupInfoEntity comboGroupInfo);

    /**
     * @Description： 根据菜品ID查询分组信息
     * @Author：LanZY
     * @Time: 2017-4-21 17:44
     * @Version 2.0.0
     * @param productID  菜品ID
     * @return
     */
    List<P_ComboGroupInfoEntity> getComboGroupInfoByProductID(Long productID);

}
