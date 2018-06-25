package cc.toprank.byd.web.service.menu;/**
 * Created by ZhouWei on 2017-5-3.
 */

import cc.toprank.byd.dao.B_MerchantMenuInfoDao;
import cc.toprank.byd.entity.B_MerchantMenuInfoEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @param
 * @author zhouwei
 * @version 2.0.0
 * @description 商户菜单信息
 * @time 2017-05-03-15:24
 * @return
 */
@Service("b_MerchantMenuInfoService")
public class B_MerchantMenuInfoService{
    @Resource
    private B_MerchantMenuInfoDao b_MerchantMenuInfoDao;

    public B_MerchantMenuInfoEntity get(B_MerchantMenuInfoEntity merchantMenuInfo) {
        return b_MerchantMenuInfoDao.get(merchantMenuInfo);
    }

    public List<B_MerchantMenuInfoEntity> getAll() {
        return b_MerchantMenuInfoDao.getAll();
    }

    public void update(B_MerchantMenuInfoEntity merchantMenuInfo) {
        b_MerchantMenuInfoDao.update(merchantMenuInfo);
    }

    public void delete(B_MerchantMenuInfoEntity merchantMenuInfo) {
        b_MerchantMenuInfoDao.delete(merchantMenuInfo);
    }

    public void save(B_MerchantMenuInfoEntity merchantMenuInfo) {
        b_MerchantMenuInfoDao.save(merchantMenuInfo);
    }

    /**
     * Description 获取同价菜单列表
     * Version 2.0.0
     * Time 2017-05-03
     * param
     * return
     */
    public List<B_MerchantMenuInfoEntity> getSamePriceFoodList(Long menuID,String productName){
        Map map = new HashMap<>();
        map.put("menuID",menuID);
        map.put("productName",productName);
        return b_MerchantMenuInfoDao.getSamePriceFoodList(map);
    }

    /**
     * Description 获取不同价菜单列表
     * Version 2.0.0
     * Time 2017-05-03
     * param
     * return
     */
    public List<B_MerchantMenuInfoEntity> getNotSamePriceFoodList(Long menuID,String productName){
        Map map = new HashMap<>();
        map.put("menuID",menuID);
        map.put("productName",productName);
        return b_MerchantMenuInfoDao.getNotSamePriceFoodList(map);
    }
}
