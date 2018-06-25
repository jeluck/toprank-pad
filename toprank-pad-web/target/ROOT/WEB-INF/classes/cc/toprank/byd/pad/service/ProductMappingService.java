package cc.toprank.byd.pad.service;

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.dao.W_ProductMappingDao;
import cc.toprank.byd.entity.W_ProductMappingEntity;
import cc.toprank.byd.pad.pojo.OrderDishesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 菜品映射service
 *
 * @author LeeJun
 * @version 2.0.0
 * @time 2017-2-20 17:12
 */
@Service
public class ProductMappingService {

//    @Autowired
//    private W_ProductMappingDao productMappingMapper;
//
//    /**
//     * 修改菜品锁定数量
//     *
//     * @author LeeJun
//     * @time 2017-2-20 17:11
//     * @version 2.0.0
//     */
//    public boolean updateLockQuantity(OrderDishesDTO.Dishes dishes) {
//        return this.updateLockQuantity(dishes.getProductID(), dishes.getVariantID(), dishes.getOptionID(), dishes.getQuantity());
//    }
//
//    /**
//     * 修改菜品锁定数量
//     *
//     * @author LeeJun
//     * @time 2017-2-20 17:11
//     * @version 2.0.0
//     */
//    public boolean updateLockQuantity(Long productID, Long variantID, Long optionID, int lockQuantity) {
//        W_ProductMappingEntity productMapping = productMappingMapper.getOneByParam(productID, variantID, optionID);
//        if (productMapping != null && productMapping.getAvailableQuantity() != null) {
//            if (productMapping.getAvailableQuantity() >= lockQuantity) {
//                productMappingMapper.updateLockQuantity(productID, variantID, lockQuantity);
//                return true;
//            } else {
//                BizException.error("此菜品已售完");
//            }
//        }
//        return false;
//    }

}
