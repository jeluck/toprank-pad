package cc.toprank.byd.web.service.menu;

import cc.toprank.byd.dao.P_ProductVariantInfoDao;
import cc.toprank.byd.entity.P_ProductVariantInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**********************************************************************************************************************
 *
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   B_AttachmentInfoService 真实的业务实现类，允许修改
 *
 * ********************************************************************************************************************/
@Service("p_ProductVariantInfoService")
public class P_ProductVariantInfoService{

    @Autowired
    private P_ProductVariantInfoDao productVariantInfoDao;

    public P_ProductVariantInfoEntity get(P_ProductVariantInfoEntity productVariantInfo) throws Exception {
        return productVariantInfoDao.get(productVariantInfo);
    }

    public List<P_ProductVariantInfoEntity> getAll() throws Exception {
        return productVariantInfoDao.getAll();
    }

    public void update(P_ProductVariantInfoEntity productVariantInfo) throws Exception {
        productVariantInfoDao.update(productVariantInfo);
    }

    public void delete(P_ProductVariantInfoEntity productVariantInfo) throws Exception {
        productVariantInfoDao.delete(productVariantInfo);
    }

    public void save(P_ProductVariantInfoEntity productVariantInfo) throws Exception {
        productVariantInfoDao.save(productVariantInfo);
    }

    /**
     * 根据菜品编号查询套餐变体信息
     *
     * @param productID
     * @return
     * @author LanZY
     */
    public List<P_ProductVariantInfoEntity> getProductComboListByProductID(Long productID) {
        return productVariantInfoDao.getProductComboListByProductID(productID);
    }


    /**
     * @Description： 根据ID查询变体信息
     * @Author：LanZY
     * @param variantID         变体ID
     * @Time: 2017-4-20 11:03
     * @Version 2.0.0
     */
    public P_ProductVariantInfoEntity getProductVariantInfoByID(long variantID) {
        P_ProductVariantInfoEntity productVariantInfo = new P_ProductVariantInfoEntity();
        productVariantInfo.setVariantID(variantID);
        return productVariantInfoDao.get(productVariantInfo);
    }
}