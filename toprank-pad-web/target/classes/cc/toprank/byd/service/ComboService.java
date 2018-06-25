package cc.toprank.byd.service;

import cc.toprank.byd.dao.P_ComboSettingInfoDao;
import cc.toprank.byd.enums.ProductManageEnum;
import cc.toprank.byd.vo.ComboProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 套餐商品service
 *
 * @author LeeJun
 * @create 2017-05-23 17:46
 */
@Service
public class ComboService {

    @Autowired
    private P_ComboSettingInfoDao comboSettingInfoDao;

    /**
     * 判断套餐是否可选,查询套餐下所有的明细分组信息，如果有一个为可选分组就代表此套餐为可选套餐
     *
     * @author LeeJun
     * @time 2017-5-23 18:45
     * @version 2.0.0
     */
    public boolean isOptional(Long productID) {
        List<ComboProductVO> comboProducts = comboSettingInfoDao.getByComboSettingProductID(productID);
        for (ComboProductVO product : comboProducts) {
            if (product.getGroupType() == ProductManageEnum.GroupType.OPTIONAL.getValue()) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取套餐明细菜品
     *
     * @author LeeJun
     * @time 2017-5-31 17:19
     * @version 2.0.0
     */
    public List<List<ComboProductVO>> getComboDetail(Long productID) {
        List<ComboProductVO> comboProducts = comboSettingInfoDao.getByComboSettingProductID(productID);
        Map<String, List<ComboProductVO>> maps = new HashMap<>();
        List<ComboProductVO> tempList = null;
        String groupName;
        for (ComboProductVO product : comboProducts) {
            groupName = product.getGroupName();
            if (maps.containsKey(groupName)) {
                maps.get(groupName).add(product);
            } else {
                tempList = new ArrayList<>();
                tempList.add(product);
                maps.put(groupName, tempList);
            }
        }
        List<List<ComboProductVO>> topList = new ArrayList<>();
        for (List<ComboProductVO> list : maps.values()){
            topList.add(list);
        }
        return topList;
    }
}
