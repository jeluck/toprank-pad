package cc.toprank.byd.dao;


import cc.toprank.byd.entity.B_MerchantMenuDealInfoEntity;
import cc.toprank.byd.web.vo.haltsales.HaltsSalesHistoryInfoVO;

import java.util.List;
import java.util.Map;

public interface B_MerchantMenuDealInfoDao {
    int deleteByPrimaryKey(Long dealID);

    int insert(B_MerchantMenuDealInfoEntity record);

    int insertSelective(B_MerchantMenuDealInfoEntity record);

    B_MerchantMenuDealInfoEntity selectByPrimaryKey(Long dealID);

    int updateByPrimaryKeySelective(B_MerchantMenuDealInfoEntity record);

    int updateByPrimaryKey(B_MerchantMenuDealInfoEntity record);

    List<Map<String,Object>> queryMerchantMenuDealByCondition(Map<String,Object> map);

    /**
     * 根据menuid和AfterStatus查询设置停售的菜单
     * chenkangyi
     * 2017-6-5 17:22
     * @param map
     * @return
     */
    HaltsSalesHistoryInfoVO selectNewItemByMenuID(Map<String,Object> map);
}
