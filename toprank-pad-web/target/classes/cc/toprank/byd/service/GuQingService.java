package cc.toprank.byd.service;

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.dao.W_ProductMappingDao;
import cc.toprank.byd.entity.W_ProductMappingEntity;
import cc.toprank.byd.pad.pojo.OrderDishesDTO;
import cc.toprank.byd.util.ResultHelper;
import org.apache.commons.collections.MapUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 估清相关service
 *
 * @author LeeJun
 * @create 2017-05-23 11:01
 */
@Service
public class GuQingService {

    @Autowired
    private W_ProductMappingDao productMappingDao;

    /**
     * 修改菜品锁定数量
     *
     * @author LeeJun
     * @time 2017-2-20 17:11
     * @version 2.0.0
     */
    public boolean updateLockQuantity(OrderDishesDTO.Dishes dishes, boolean isUpdateSurplus) {
        if (dishes.getExpectedWeight() == 0) {
            return this.updateLockQuantity(dishes.getProductID(), dishes.getVariantID(), dishes.getOptionID(), dishes.getQuantity(), isUpdateSurplus);
        } else {
            return this.updateLockFloatQuantity(dishes.getProductID(), dishes.getVariantID(), dishes.getOptionID(), dishes.getExpectedWeight(), isUpdateSurplus);
        }
    }

    /**
     * 修改菜品锁定数量
     *
     * @author LeeJun
     * @time 2017-2-20 17:11
     * @version 2.0.0
     */
    public boolean updateLockQuantity(Map<String, Object> param, boolean isUpdateSurplus) {
        Long productID = MapUtils.getLong(param, "productID");
        Long variantID = MapUtils.getLong(param, "variantID");
        Long optionID = MapUtils.getLong(param, "optionID");
        Integer quantity = MapUtils.getInteger(param, "quantity");
        float weigh = MapUtils.getFloatValue(param, "expectedWeight", 0);
        if (weigh == 0) {
            return this.updateLockQuantity(productID, variantID, optionID, quantity, isUpdateSurplus);
        } else {
            return this.updateLockFloatQuantity(productID, variantID, optionID, weigh, isUpdateSurplus);
        }
    }

    /**
     * 修改菜品锁定数量
     *
     * @author LeeJun
     * @time 2017-2-20 17:11
     * @version 2.0.0
     */
    public boolean updateLockQuantity(Long productID, Long variantID, Long optionID, int lockQuantity, boolean isUpdateSurplus) {
        W_ProductMappingEntity productMapping = productMappingDao.getOneByParam(productID, variantID, optionID);
        if (productMapping != null && productMapping.getAvailableQuantity() != null) {
            if (productMapping.getAvailableQuantity() >= lockQuantity) {
                productMapping.setAvailableQuantity(productMapping.getAvailableQuantity() - lockQuantity);
                productMapping.setLockQuantity(productMapping.getLockQuantity() + lockQuantity);
                if (isUpdateSurplus) {
                    productMapping.setRemainingQuantity(productMapping.getRemainingQuantity() - lockQuantity);
                }
                return ResultHelper.retBool(productMappingDao.updateByPrimaryKeySelective(productMapping));
            } else {
                throw new BizException("此菜品已售完！");
            }
        }
        return false;
    }

    /**
     * 修改菜品锁定小数数量(称重菜)
     *
     * @author LeeJun
     * @time 2017-2-20 17:11
     * @version 2.0.0
     */
    public boolean updateLockFloatQuantity(Long productID, Long variantID, Long optionID, float lockFloatQuantity, boolean isUpdateSurplus) {
        W_ProductMappingEntity productMapping = productMappingDao.getOneByParam(productID, variantID, optionID);
        if (productMapping != null && productMapping.getAvailableFloatQuantity() != null) {
            if (productMapping.getAvailableFloatQuantity() >= lockFloatQuantity) {
                productMapping.setAvailableFloatQuantity(productMapping.getAvailableFloatQuantity() - lockFloatQuantity);
                productMapping.setLockFloatQuantity(productMapping.getLockFloatQuantity() + lockFloatQuantity);
                if (isUpdateSurplus) {
                    productMapping.setRemainingFloatQuantity(productMapping.getRemainingFloatQuantity() - lockFloatQuantity);
                }
                return ResultHelper.retBool(productMappingDao.updateByPrimaryKeySelective(productMapping));
            } else {
                throw new BizException("此菜品已售完！");
            }
        }
        return false;
    }

    /**
     * 检查菜品是否可购买
     *
     * @author LeeJun
     * @time 2017-5-26 13:34
     * @version 2.0.0
     */
    public boolean checkIsGuQing(OrderDishesDTO.Dishes dishes) {
        if (dishes.getExpectedWeight() == 0) {
            return this.checkIsGuQing(dishes.getProductID(), dishes.getVariantID(), dishes.getOptionID(), dishes.getQuantity());
        } else {
            return this.checkFloatIsGuQing(dishes.getProductID(), dishes.getVariantID(), dishes.getOptionID(), dishes.getExpectedWeight());
        }
    }

    /**
     * 检查菜品是否估清
     *
     * @author LeeJun
     * @time 2017-5-24 16:48
     * @version 2.0.0
     */
    public boolean checkIsGuQing(Long productID, Long variantID, Long optionID, int num) {
        Integer quantity = productMappingDao.getAvailableQuantityByParam(productID, variantID, optionID);
        if (quantity == null) {
            return false;
        }
        if (quantity > 0 && quantity >= num) {
            return false;
        }
        return true;
    }

    /**
     * 检查称重菜品是否估清
     *
     * @author LeeJun
     * @time 2017-5-24 16:48
     * @version 2.0.0
     */
    public boolean checkFloatIsGuQing(Long productID, Long variantID, Long optionID, float weigh) {
        Float quantity = productMappingDao.getAvailableFloatQuantityByParam(productID, variantID, optionID);
        if (quantity == null) {
            return false;
        }
        if (quantity > 0 && quantity >= weigh) {
            return false;
        }
        return true;
    }

    public boolean checkIsGuQing(Map<String, Object> param) {
        Long productID = MapUtils.getLong(param, "productID");
        Long variantID = MapUtils.getLong(param, "variantID");
        Long optionID = MapUtils.getLong(param, "optionID");
        Integer quantity = MapUtils.getInteger(param, "quantity");
        float weigh = MapUtils.getFloatValue(param, "expectedWeight", 0);
        if (weigh == 0) {
            return this.checkIsGuQing(productID, variantID, optionID, quantity);
        } else {
            return this.checkFloatIsGuQing(productID, variantID, optionID, weigh);
        }
    }


    /**
     * 检查菜品是否估清
     *
     * @author LeeJun
     * @time 2017-5-24 18:48
     * @version 2.0.0
     */
    public boolean checkIsGuQing(Map<String, Object> param, int num) {
        Long productID = MapUtils.getLong(param, "productID");
        Long variantID = MapUtils.getLong(param, "variantID");
        Long optionID = MapUtils.getLong(param, "optionID");
        return this.checkIsGuQing(productID, variantID, optionID, num);
    }

    /**
     * 检查称重菜品是否估清
     *
     * @author LeeJun
     * @time 2017-5-24 18:48
     * @version 2.0.0
     */
    public boolean checkFloatIsGuQing(Map<String, Object> param, float weigh) {
        Long productID = MapUtils.getLong(param, "productID");
        Long variantID = MapUtils.getLong(param, "variantID");
        Long optionID = MapUtils.getLong(param, "optionID");
        return this.checkFloatIsGuQing(productID, variantID, optionID, weigh);
    }

}
