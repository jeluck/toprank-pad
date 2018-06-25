package cc.toprank.byd.stall.service;

import cc.toprank.byd.dao.P_ProductCategoryInfoDao;
import cc.toprank.byd.dao.P_ProductInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @version 2.0.0
 * @description：查询商品信息
 * @author：ZhaoLC
 * @time: 2017-3-15 10:00
 */
@Service
public class StallProductService {
    @Autowired
    private P_ProductInfoDao productInfoMapper;
    @Autowired
    private P_ProductCategoryInfoDao productCategoryInfoMapper;

    /**
     * 查询称重档口 商品信息
     * @author ZhaoLC
     * @Time 2017-3-13 14:00
     */
    public List<Map<String,Object>> getProductsByCondition(Map<String,Object> map){
        return productInfoMapper.getProductsByCondition(map);
    }

    /**
     * 查询称重档口 商品分类信息
     * @author ZhaoLC
     * @Time 2017-3-13 14:00
     */
    public List<Map<String,Object>> getCategorysByCategoryID(Map<String,Object> map){
        return productCategoryInfoMapper.getCategorysByCategoryID(map);
    }
}
