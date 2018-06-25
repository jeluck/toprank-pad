package cc.toprank.byd.pad.service;


import cc.toprank.byd.dao.P_CategoryAttributeValueInfoDao;
import cc.toprank.byd.enums.ProductManageEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 菜品属性service
 *
 * @author LeeJun
 * @version 2.0.0
 * @time 2017-2-20 17:09
 */
@Service
public class ProductAttributeService {
    protected final static Logger LOGGER = LoggerFactory.getLogger(ProductAttributeService.class);

    @Autowired
    private P_CategoryAttributeValueInfoDao categoryAttributeValueInfoDAO;

    /**
     * 获取菜品的辣度属性值
     *
     * @author LeeJun
     * @time 2017-5-25 13:59
     * @version 2.0.0
     */
    public int getSpicyVariantID(Long variantID) {
        if (variantID == null) {
            return 0;
        }
        List<String> attributeValues = categoryAttributeValueInfoDAO.getAttributeValueByVariantID(variantID, ProductManageEnum.AttributeType.SPICY.getValue());
        if (attributeValues.size() == 1) {
            try {
                return Integer.parseInt(attributeValues.get(0));
            } catch (NumberFormatException e) {
                LOGGER.error("辣度属性值只能配置为int", e);
            }
        }
        return 0;
    }

    /**
     * 获取菜品分类属性信息
     *
     * @author LeeJun
     * @time 2017-2-20 17:10
     * @version 2.0.0
     */
    public List<Map<String, Object>> getProductAttribute(Long dishesID, boolean isCombo) {
        if (isCombo) {
            // 查询套餐分类属性
            return categoryAttributeValueInfoDAO.getProductAttributeByProductID(dishesID);
        } else {
            // 查询单品分类属性
            return categoryAttributeValueInfoDAO.getProductAttributeByVariantID(dishesID);
        }
    }

    /**
     * 计算属性加价
     *
     * @author LeeJun
     * @time 2017-6-7 13:55
     * @version 2.0.0
     */
    public BigDecimal calcAttributeAddedPrice(String valueIDs) {
        double addPrice = categoryAttributeValueInfoDAO.getAddedPriceByValueIDs(valueIDs);
        return new BigDecimal(addPrice);
    }
}
