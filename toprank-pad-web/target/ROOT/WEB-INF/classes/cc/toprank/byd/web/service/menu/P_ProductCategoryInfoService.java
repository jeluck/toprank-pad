package cc.toprank.byd.web.service.menu;

import cc.toprank.byd.dao.P_ProductCategoryInfoDao;
import cc.toprank.byd.entity.P_ProductCategoryInfoEntity;
import cc.toprank.byd.pad.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Description： 菜品分类service
 * @Author：LanZY
 * @Time: 2017-3-8 16:31
 * @Version 2.0.0
 */
@Service("p_ProductCategoryInfoService")
public class P_ProductCategoryInfoService {

    @Autowired
    protected P_ProductCategoryInfoDao productCategoryInfoDao;
    @Autowired
    ProductService productService;

    public List<P_ProductCategoryInfoEntity> getAll() throws Exception {
        return productCategoryInfoDao.getAll();
    }

    public void update(P_ProductCategoryInfoEntity productCategoryInfo) throws Exception {
        productCategoryInfoDao.update(productCategoryInfo);
    }

    public void delete(P_ProductCategoryInfoEntity productCategoryInfo) throws Exception {
        productCategoryInfoDao.delete(productCategoryInfo);
    }

    public void save(P_ProductCategoryInfoEntity productCategoryInfo) throws Exception {
        productCategoryInfoDao.save(productCategoryInfo);
    }

    /**
     * 根据档案编号查询菜品分类信息
     *
     * @param ArchiveID
     * @return
     * @author LanZY
     */
    public List<P_ProductCategoryInfoEntity> getProductCategoryListByArchiveID(Long ArchiveID) {
        return productCategoryInfoDao.getProductCategoryListByArchiveID(ArchiveID);
    }

}