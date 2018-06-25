package cc.toprank.byd.pad.service;

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.common.utils.string.StringUtil;
import cc.toprank.byd.config.BaseConfig;
import cc.toprank.byd.dao.*;
import cc.toprank.byd.entity.*;
import cc.toprank.byd.enums.MerchantManageEnum;
import cc.toprank.byd.pad.pojo.SpecificationDTO;
import cc.toprank.byd.pad.util.MerchantCacheUtils;
import cc.toprank.byd.service.DesignerService;
import cc.toprank.byd.service.GuQingService;
import cc.toprank.byd.util.MaxIDUtils;
import cc.toprank.byd.util.ResultHelper;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cc.toprank.byd.pad.pojo.OrderDishesDTO.Dishes;

/**
 * 购物车
 *
 * @author LeeJun
 * @create 2017-03-24 16:02
 */
@Service
public class ShoppingCartService {

    @Autowired
    private O_ShoppingCartInfoDao shoppingCartInfoDao;
    @Autowired
    private O_ShoppingCartDetailInfoDao cartDetailInfoDao;
    @Autowired
    private P_SpecificationAttributeOptionInfoDao attributeOptionInfoDao;
    @Autowired
    private P_CategoryAttributeValueInfoDao attributeValueInfoDao;
    @Autowired
    private GuQingService guQingService;
    @Autowired
    private ProductService productService;
    @Autowired
    private DesignerService designerService;
    @Autowired
    private ProductAttributeService productAttributeService;
    @Autowired
    private B_MerchantMenuInfoDao menuInfoDao;


    /**
     * 更新购物车菜品信息
     *
     * @author LeeJun
     * @time 2017-5-25 17:29
     * @version 2.0.0
     */
    @Transactional
    public Map<String, Object> updateShoppingCart(Dishes dishes) {
        if (dishes.getOptionID() != null && dishes.getOptionID().longValue() == 0) {
            dishes.setOptionID(null);
        }
        String valueIDs = dishes.getValueIDs();
        if (!StringUtils.isEmpty(dishes.getValueIDs())) {
            valueIDs = StringUtil.cutoffLastExcision(dishes.getValueIDs(), ",");
        }
        dishes.setValueIDs(valueIDs);
        B_MerchantMenuInfoEntity merchantMenuInfo = menuInfoDao.getByMenuID(dishes.getMenuID(), dishes.isCombos());
        if (dishes.getQuantity() == 0) {
            updateShoppingCartDishes(dishes, merchantMenuInfo);
        } else if (dishes.getQuantity() == 1) {
            addShoppingCartDishes(dishes, merchantMenuInfo);
        } else if (dishes.getQuantity() == -1) {
            deleteShoppingCartDishes(dishes, merchantMenuInfo);
        }
        return this.getCartCollectByTableID();
    }

    /**
     * 批量加入购物车
     *
     * @author LeeJun
     * @time 2017-6-16 14:35
     * @version 2.0.0
     */
    public void batchAddShoppingCart(List<Dishes> dishesList) {
        for (Dishes dishes : dishesList) {
            B_MerchantMenuInfoEntity merchantMenuInfo = menuInfoDao.getByMenuID(dishes.getMenuID(), dishes.isCombos());
            this.addShoppingCartDishes(dishes, merchantMenuInfo);
        }
    }


    /**
     * 更新购物车菜品信息
     *
     * @author LeeJun
     * @time 2017-5-25 20:55
     * @version 2.0.0
     */
    @Transactional
    public void updateShoppingCartDishes(Dishes dishes, B_MerchantMenuInfoEntity merchantMenuInfo) {
        O_ShoppingCartDetailInfoEntity oldDetail = cartDetailInfoDao.selectByPrimaryKey(dishes.getDetailID());
        // 判断如果修改后菜品的信息与修改前一致，就不做处理
        if (detailEqualsDishes(oldDetail, dishes)) {
            return;
        }
        BigDecimal oldTotalAmount = oldDetail.getTotalAmount();
        BigDecimal produceCost = this.calcProduceCost(dishes, merchantMenuInfo.getProduceCost());
        BigDecimal newTotalAmount = this.calcDishesPrice(dishes, produceCost, merchantMenuInfo);
        O_ShoppingCartDetailInfoEntity cartDetail = this.getByDishes(dishes);
        // 判断购物车中是否存在修改后的菜品相同信息，无则更新此菜品信息，有则合并(更新已存在的菜品数量及价格)并删除原来的菜品记录
        if (cartDetail == null) {
            O_ShoppingCartDetailInfoEntity detailInfo = this.dishesConvertCartDetail(dishes, merchantMenuInfo);
            detailInfo.setDetailID(dishes.getDetailID());
            cartDetailInfoDao.updateByPrimaryKeySelective(detailInfo);
        } else {
            // 将修改的菜品信息追加到已民存在的菜品信息中
            cartDetail.setPrice(cartDetail.getPrice().add(merchantMenuInfo.getPrice()));
            cartDetail.setTotalAmount(cartDetail.getTotalAmount().add(newTotalAmount));
            cartDetail.setQuantity(cartDetail.getQuantity() + oldDetail.getQuantity());
            cartDetail.setProduceCost(cartDetail.getProduceCost().add(produceCost));
            String memo = cartDetail.getMemo();
            if (StringUtils.isEmpty(memo)) {
                memo = oldDetail.getMemo();
            } else {
                memo = " " + oldDetail.getMemo();
            }
            cartDetail.setMemo(memo);
            // 修改购物车已存在的菜品信息
            cartDetailInfoDao.updateByPrimaryKeySelective(cartDetail);
            this.checkQuantity(dishes, merchantMenuInfo.getQuantity());
            // 删除重复的菜品
            cartDetailInfoDao.deleteByPrimaryKey(oldDetail.getDetailID());
            // 还原重复锁定数量并修改新锁定数量
            if (cartDetail.getExpectedWeight() == null || cartDetail.getExpectedWeight() == 0) {
                guQingService.updateLockQuantity(cartDetail.getProductID(), cartDetail.getVariantID(), cartDetail.getOptionID(), oldDetail.getQuantity(), false);
                guQingService.updateLockQuantity(oldDetail.getProductID(), oldDetail.getVariantID(), oldDetail.getOptionID(), 0 - oldDetail.getQuantity(), false);
            } else {
                guQingService.updateLockFloatQuantity(cartDetail.getProductID(), cartDetail.getVariantID(), cartDetail.getOptionID(), oldDetail.getExpectedWeight(), false);
                guQingService.updateLockFloatQuantity(oldDetail.getProductID(), oldDetail.getVariantID(), oldDetail.getOptionID(), 0 - oldDetail.getExpectedWeight(), false);
            }
        }
        // 更新购物车总金额: 减去删除的菜品金额 + 修改后菜品金额
        O_ShoppingCartInfoEntity shoppingCartInfo = shoppingCartInfoDao.selectByPrimaryKey(oldDetail.getCartID());
        BigDecimal cartTotalAmount = shoppingCartInfo.getTotalAmount();
        cartTotalAmount = cartTotalAmount.subtract(oldTotalAmount);
        cartTotalAmount = cartTotalAmount.add(newTotalAmount);
        shoppingCartInfo.setTotalAmount(cartTotalAmount);
        shoppingCartInfoDao.updateByPrimaryKeySelective(shoppingCartInfo);
    }

    /**
     * 添加购物车信息
     *
     * @author LeeJun
     * @time 2017-3-29 16:22
     * @version 2.0.0
     */
    @Transactional
    public void addShoppingCartDishes(Dishes dishes, B_MerchantMenuInfoEntity merchantMenuInfo) {
        // 判断是否存在购物车主信息，存在则更改总数量及总金额即可
        Long cartID = this.isExistShoppingCart(dishes, merchantMenuInfo);
        O_ShoppingCartDetailInfoEntity detailInfo = this.getByDishes(dishes);
        // 判断购物车是否存在该商品，存在则更新数量和总价
        if (detailInfo != null) {
            // 判断是否超过菜品单个最大可点数据
            if (merchantMenuInfo.getQuantity() != null && detailInfo.getQuantity() > merchantMenuInfo.getQuantity()) {
                throw new BizException("不能超过此菜品最大可点数量：" + merchantMenuInfo.getQuantity());
            }
            BigDecimal produceCost = this.calcProduceCost(dishes, merchantMenuInfo.getProduceCost());
            BigDecimal totalAmount = this.calcDishesPrice(dishes, produceCost, merchantMenuInfo);
            BigDecimal price = merchantMenuInfo.getPrice();
            if (dishes.getExpectedWeight() != 0) {
                price = price.multiply(new BigDecimal(dishes.getExpectedWeight()));
            }
            detailInfo.setPrice(detailInfo.getPrice().add(price));
            detailInfo.setTotalAmount(detailInfo.getTotalAmount().add(totalAmount));
            detailInfo.setProduceCost(detailInfo.getProduceCost().add(produceCost));
            detailInfo.setQuantity(detailInfo.getQuantity() + dishes.getQuantity());
            cartDetailInfoDao.updateByPrimaryKeySelective(detailInfo);
        } else {
            // 不存在则需要新增加一条记录
            detailInfo = this.dishesConvertCartDetail(dishes, merchantMenuInfo);
            detailInfo.setDetailID(MaxIDUtils.getID(O_ShoppingCartDetailInfoEntity.class));
            detailInfo.setCartID(cartID);
            cartDetailInfoDao.insertSelective(detailInfo);
        }
        // 锁定库存
        guQingService.updateLockQuantity(dishes, false);
    }

    /**
     * 减去购物车中的商品
     *
     * @author LeeJun
     * @time 2017-3-29 18:10
     * @version 2.0.0
     */
    @Transactional
    public void deleteShoppingCartDishes(Dishes dishes, B_MerchantMenuInfoEntity merchantMenuInfo) {
        O_ShoppingCartDetailInfoEntity detail = this.getByDishes(dishes);
        if (detail == null) {
            throw new BizException("购物车无此菜品");
        }
        BigDecimal produceCost = this.calcProduceCost(dishes, merchantMenuInfo.getProduceCost());
        BigDecimal dishesPrice = this.calcDishesPrice(dishes, produceCost, merchantMenuInfo);
        if (detail.getQuantity() == 1) {
            // 此菜品在购物车数据等于1时，直接删除购物车中的菜品
            cartDetailInfoDao.deleteByPrimaryKey(detail.getDetailID());
        } else {
            // 更新购物车中商品的数量和价格
            detail.setProduceCost(detail.getProduceCost().subtract(produceCost));
            detail.setPrice(detail.getPrice().subtract(merchantMenuInfo.getPrice()));
            detail.setQuantity(detail.getQuantity() + dishes.getQuantity());
            detail.setTotalAmount(detail.getTotalAmount().subtract(dishesPrice));
            cartDetailInfoDao.updateByPrimaryKeySelective(detail);
        }
        // 更新购物车总数量和总价格
        O_ShoppingCartInfoEntity shoppingCartInfo = shoppingCartInfoDao.selectByPrimaryKey(detail.getCartID());
        if (shoppingCartInfo != null && shoppingCartInfo.getQuantity() > 1) {
            shoppingCartInfo.setQuantity(shoppingCartInfo.getQuantity() + dishes.getQuantity());
            shoppingCartInfo.setTotalAmount(shoppingCartInfo.getTotalAmount().subtract(dishesPrice));
            shoppingCartInfoDao.updateByPrimaryKeySelective(shoppingCartInfo);
        } else {
            shoppingCartInfoDao.deleteByPrimaryKey(shoppingCartInfo.getCartID());
        }
        // 还原商品库存数量
        if (detail.getExpectedWeight() == null || detail.getExpectedWeight() == 0) {
            guQingService.updateLockQuantity(detail.getProductID(), detail.getVariantID(), detail.getOptionID(), dishes.getQuantity(), false);
        } else {
            guQingService.updateLockFloatQuantity(detail.getProductID(), detail.getVariantID(), detail.getOptionID(), 0 - detail.getExpectedWeight(), false);
        }

    }

    public void checkQuantity(Dishes dishes, Integer maxQuantity) {
        O_ShoppingCartDetailInfoEntity detailInfo = this.getByDishes(dishes);
        // 判断是否超过菜品单个最大可点数据
        if (maxQuantity != null && detailInfo.getQuantity() >= maxQuantity) {
            throw new BizException("不能超过此菜品最大可点数量：" + maxQuantity);
        }
        if (guQingService.checkIsGuQing(dishes)) {
            throw new BizException("此菜品已估清！");
        }
    }

    /**
     * 清空购物车
     *
     * @author LeeJun
     * @time 2017-3-31 18:44
     * @version 2.0.0
     */
    @Transactional
    public boolean cleanShoppingCart(Long tableID, boolean isUpdateSurplus) {
        List<Map<String, Object>> shoppingCarts = cartDetailInfoDao.getShoppingCartsByTableID(tableID);
        if (CollectionUtils.isEmpty(shoppingCarts)) {
            return false;
        }
        Long variantID = null;
        for (Map<String, Object> cart : shoppingCarts) {
            variantID = MapUtils.getLong(cart, "variantID");
            // 还原所有商品的库存锁定
            MapUtils.getLong(cart, "productID");
            Long productID = MapUtils.getLong(cart, "productID");
            Long optionID = MapUtils.getLong(cart, "optionID");
            int quantity = MapUtils.getIntValue(cart, "quantity", 0);
            float expectedWeight = MapUtils.getFloatValue(cart, "expectedWeight", 0);
            if (expectedWeight == 0) {
                guQingService.updateLockQuantity(productID, variantID, optionID, 0 - quantity, isUpdateSurplus);
            } else {
                guQingService.updateLockFloatQuantity(productID, variantID, optionID, 0 - expectedWeight, isUpdateSurplus);
            }
        }
        Long cartID = Long.valueOf(String.valueOf(shoppingCarts.get(0).get("cartID")));
        cartDetailInfoDao.deleteByCartID(cartID);
        return ResultHelper.retBool(shoppingCartInfoDao.deleteByPrimaryKey(cartID));
    }

    /**
     * 计算加工费
     *
     * @author LeeJun
     * @time 2017-6-7 14:21
     * @version 2.0.0
     */
    public BigDecimal calcProduceCost(Dishes dishes, BigDecimal produceCost) {
        // 加工费 = 规格加价 + 属性加价 + 菜单中的加工费
        BigDecimal addedPrice = new BigDecimal(0.0);
        // 计算规格加价值
        if (dishes.getOptionID() != null) {
            List<SpecificationDTO> combosSpecification;
            if (dishes.isCombos()) {
                combosSpecification = menuInfoDao.getCombosSpecification(dishes.getProductID(), dishes.getOptionID());
            } else {
                combosSpecification = menuInfoDao.getVariantSpecification(dishes.getVariantID(), dishes.getOptionID());
            }
            if (!combosSpecification.isEmpty()) {
                addedPrice = addedPrice.add(combosSpecification.get(0).getAddedPrice());
            }

        }
        // 计算属性加价值
        if (!StringUtils.isEmpty(dishes.getValueIDs())) {
            addedPrice = addedPrice.add(productAttributeService.calcAttributeAddedPrice(dishes.getValueIDs()));
        }
        if (produceCost != null && produceCost.intValue() != 0) {
            addedPrice = addedPrice.add(produceCost);
        }
//        if (dishes.getQuantity() > 1) {
//            addedPrice = addedPrice.multiply(new BigDecimal(dishes.getQuantity()));
//        }
        return addedPrice;
    }

    /**
     * 计算菜品价格
     *
     * @author LeeJun
     * @time 2017-5-25 20:30
     * @version 2.0.0
     */
    public BigDecimal calcDishesPrice(Dishes dishes, BigDecimal produceCost, B_MerchantMenuInfoEntity merchantMenuInfo) {
        // 菜品总价 = 成交价 + 加价 + 厨师费
        BigDecimal totalAmount = merchantMenuInfo.getPrice();
        if (dishes.getExpectedWeight() != 0) {
            totalAmount = totalAmount.multiply(new BigDecimal(dishes.getExpectedWeight()));
        }
        if (produceCost.intValue() != 0) {
            totalAmount = totalAmount.add(produceCost);
        }
        if (dishes.getDesignerPrice() != null) {
            totalAmount = totalAmount.add(dishes.getDesignerPrice());
        }
        if (dishes.getQuantity() > 1) {
            totalAmount = totalAmount.multiply(new BigDecimal(dishes.getQuantity()));
        }
        return totalAmount;
    }

    /**
     * 根据菜品参数查询购物车中的菜品信息
     *
     * @author LeeJun
     * @time 2017-5-25 21:11
     * @version 2.0.0
     */
    public O_ShoppingCartDetailInfoEntity getByDishes(Dishes dishes) {
        Map<String, Object> param = new HashMap<>();
        param.put("tableID", MerchantCacheUtils.getCurrentTableID());
        param.put("menuID", dishes.getMenuID());
        param.put("optionID", dishes.getOptionID());
        String valueIDs = null;
        if (!StringUtils.isEmpty(dishes.getValueIDs())) {
            valueIDs = StringUtil.cutoffLastExcision(dishes.getValueIDs(), ",");
        }
        param.put("valueIDs", valueIDs);
        param.put("expectedWeight", dishes.getExpectedWeight());
        param.put("designerID", dishes.getDesignerID());
        return cartDetailInfoDao.getByParam(param);
    }

    /**
     * 菜品参数转换成购物车对象
     *
     * @author LeeJun
     * @time 2017-5-25 21:19
     * @version 2.0.0
     */
    public O_ShoppingCartDetailInfoEntity dishesConvertCartDetail(Dishes dishes, B_MerchantMenuInfoEntity merchantMenuInfo) {
        O_ShoppingCartDetailInfoEntity detailInfo = new O_ShoppingCartDetailInfoEntity();
        Long detailID = dishes.getDetailID();
        if (detailID != null && detailID.intValue() != 0) {
            int quantity = cartDetailInfoDao.selectByPrimaryKey(dishes.getDetailID()).getQuantity();
            dishes.setQuantity(quantity);
        }
        detailInfo.setTableID(MerchantCacheUtils.getCurrentTableID());
        detailInfo.setMenuID(dishes.getMenuID());
        detailInfo.setProductID(dishes.getProductID());
        if (dishes.getVariantID() != null && dishes.getVariantID() != 0) {
            detailInfo.setVariantID(dishes.getVariantID());
        }
        if (dishes.getOptionID() != null && dishes.getOptionID() != 0) {
            detailInfo.setOptionID(dishes.getOptionID());
        }
        String valueIDs = null;
        if (!StringUtils.isEmpty(dishes.getValueIDs())) {
            valueIDs = StringUtil.cutoffLastExcision(dishes.getValueIDs(), ",");
            detailInfo.setValueIDs(valueIDs);
        }
        if (dishes.getDesignerID() != null && dishes.getDesignerID() != 0) {
            detailInfo.setDesignerID(dishes.getDesignerID());
            detailInfo.setDesignerPrice(dishes.getDesignerPrice());
        }
        detailInfo.setQuantity(dishes.getQuantity());
        detailInfo.setProductUnit(merchantMenuInfo.getUnitID());
        BigDecimal produceCost = this.calcProduceCost(dishes, merchantMenuInfo.getProduceCost());
        detailInfo.setProduceCost(produceCost);
        detailInfo.setTotalAmount(this.calcDishesPrice(dishes, produceCost, merchantMenuInfo));
        detailInfo.setMemo(dishes.getMemo());
        BigDecimal price = merchantMenuInfo.getPrice();
        if (dishes.getExpectedWeight() != 0) {
            detailInfo.setExpectedWeight(dishes.getExpectedWeight());
            detailInfo.setNeedWeigh(true);
            price = merchantMenuInfo.getPrice().multiply(new BigDecimal(dishes.getExpectedWeight()));
        }
        detailInfo.setPrice(price);
        detailInfo.setCreateTime(LocalDateTime.now());
        return detailInfo;
    }

    /**
     * 判断ShoppingCartDetail与dishes的属性规格、期望重量是否相等
     *
     * @author LeeJun
     * @time 2017-6-8 17:32
     * @version 2.0.0
     */
    public boolean detailEqualsDishes(O_ShoppingCartDetailInfoEntity detailInfo, Dishes dishes) {
        long detailOptionID = detailInfo.getOptionID() == null ? 0 : detailInfo.getOptionID().longValue();
        long dishesOptionID = dishes.getOptionID() == null ? 0 : dishes.getOptionID().longValue();
        float detailWeight = detailInfo.getExpectedWeight() == null ? 0 : detailInfo.getExpectedWeight().floatValue();
        if (detailInfo.getValueIDs() == dishes.getValueIDs() && detailOptionID == dishesOptionID
                && dishes.getExpectedWeight() == detailWeight) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否存在主购物车信息，无则添加，有则修改主购物车
     *
     * @author LeeJun
     * @time 2017-5-25 16:52
     * @version 2.0.0
     */
    public Long isExistShoppingCart(Dishes dishes, B_MerchantMenuInfoEntity merchantMenuInfo) {
        Map<String, Object> shoppingCart = shoppingCartInfoDao.getByTableID(MerchantCacheUtils.getCurrentTableID());
        Long cartID;
        BigDecimal produceCost = this.calcProduceCost(dishes, merchantMenuInfo.getProduceCost());
        BigDecimal totalAmount = this.calcDishesPrice(dishes, produceCost, merchantMenuInfo);
        O_ShoppingCartInfoEntity shoppingCartInfo = new O_ShoppingCartInfoEntity();
        // 判断是否存在购物车主信息，存在则更改总金额即可
        if (MapUtils.isEmpty(shoppingCart)) {
            cartID = MaxIDUtils.getID(O_ShoppingCartInfoEntity.class);
            shoppingCartInfo.setCartID(cartID);
            shoppingCartInfo.setArchiveID(MerchantCacheUtils.getCurrentArchiveID());
            shoppingCartInfo.setQuantity(dishes.getQuantity());
            shoppingCartInfo.setCreateTime(LocalDateTime.now());
            shoppingCartInfo.setTotalAmount(totalAmount);
            shoppingCartInfoDao.insertSelective(shoppingCartInfo);
        } else {
            cartID = MapUtils.getLong(shoppingCart, "cartID");
            int quantity = MapUtils.getIntValue(shoppingCart, "totalQuantity") + dishes.getQuantity();
            BigDecimal amount = new BigDecimal(MapUtils.getDoubleValue(shoppingCart, "totalAmount")).add(totalAmount);
            this.updateShoppingCart(cartID, quantity, amount);
        }
        return cartID;
    }

    /**
     * 修改购物车总数据及总价格
     *
     * @author LeeJun
     * @time 2017-5-25 16:57
     * @version 2.0.0
     */
    public void updateShoppingCart(Long cartID, int quantity, BigDecimal totalAmount) {
        O_ShoppingCartInfoEntity shoppingCartInfo = new O_ShoppingCartInfoEntity();
        shoppingCartInfo.setCartID(cartID);
        shoppingCartInfo.setQuantity(quantity);
        shoppingCartInfo.setTotalAmount(totalAmount);
        shoppingCartInfoDao.updateByPrimaryKeySelective(shoppingCartInfo);
    }

    /**
     * 获取购物车列表
     *
     * @author LeeJun
     * @time 2017-3-31 11:24
     * @version 2.0.0
     */
    public List<Map<String, Object>> getShoppingCarts() {
        List<Map<String, Object>> shoppingCarts = cartDetailInfoDao.getShoppingCartsByTableID(MerchantCacheUtils.getCurrentTableID());
        Long optionID;
        String valueIDs;
        String filePath;
        P_SpecificationAttributeOptionInfoEntity specification = null;
        for (Map<String, Object> cart : shoppingCarts) {
            optionID = MapUtils.getLongValue(cart, "optionID");
            if (optionID != null) {
                specification = attributeOptionInfoDao.selectByPrimaryKey(optionID);
            }
            cart.remove("optionID");
            cart.put("specification", specification);

            valueIDs = MapUtils.getString(cart, "valueIDs");
            List<Map<String, Object>> attributes = null;
            if (!StringUtils.isEmpty(valueIDs)) {
                attributes = attributeValueInfoDao.getCategoryAttributeByValueIDs(valueIDs);
            }
            cart.put("attributes", attributes);
            filePath = MapUtils.getString(cart, "filePath");
            if (!StringUtils.isEmpty(filePath)) {
                filePath = BaseConfig.getImagePath() + filePath;
                cart.put("filePath", filePath);
            }
            long dishesID;
            boolean isCombo = MapUtils.getBooleanValue(cart, "isCombo");
            Long productID = MapUtils.getLongValue(cart, "productID");
            Long variantID = MapUtils.getLongValue(cart, "variantID");
            if (isCombo) {
                dishesID = productID;
            } else {
                dishesID = variantID;
            }
            cart.put("saleStop", false);
            cart.put("guqing", guQingService.checkIsGuQing(cart));
            boolean needWeigh = MapUtils.getBooleanValue(cart, "needWeigh", false);
            cart.put("isPop", productService.hasAttributes(dishesID, isCombo, needWeigh));
            cart.put("isOptionalDesigner", designerService.isOptionalDesigner(MerchantCacheUtils.getCurrentArchiveID(), productID, variantID));
        }
        return shoppingCarts;
    }

    /**
     * 获取菜品在购物车中的数量
     *
     * @author LeeJun
     * @time 2017-5-24 18:20
     * @version 2.0.0
     */
    public int getProductNumByParam(Map<String, Object> param) {
        String valueIDs = MapUtils.getString(param, "valueIDs");
        if (!StringUtils.isEmpty(valueIDs)) {
            valueIDs = StringUtil.cutoffLastExcision(valueIDs, ",");
            param.put("valueIDs", valueIDs);
        }
        O_ShoppingCartDetailInfoEntity detail = cartDetailInfoDao.getByParam(param);
        if (detail != null) {
            return detail.getQuantity();
        }
        return 0;
    }

    /**
     * 修改购物车中菜品的备注
     *
     * @author LeeJun
     * @time 2017-5-26 16:55
     * @version 2.0.0
     */
    public boolean updateDishesRemark(Long detailID, String memo) {
        O_ShoppingCartDetailInfoEntity detail = new O_ShoppingCartDetailInfoEntity();
        detail.setDetailID(detailID);
        detail.setMemo(memo);
        return ResultHelper.retBool(cartDetailInfoDao.updateByPrimaryKeySelective(detail));
    }

    /**
     * 整单备注
     *
     * @author LeeJun
     * @time 2017-4-11 17:10
     * @version 2.0.0
     */
    public boolean orderRemarks(Long cartID, String memo) {
        O_ShoppingCartInfoEntity cartInfo = new O_ShoppingCartInfoEntity();
        cartInfo.setCartID(cartID);
        cartInfo.setMemo(memo);
        int row = shoppingCartInfoDao.updateByPrimaryKeySelective(cartInfo);
        if (row > 0) {
            return true;
        }
        return false;
    }

    /**
     * 获取购物车汇总信息
     *
     * @author LeeJun
     * @time 2017-3-31 18:44
     * @version 2.0.0
     */
    public Map<String, Object> getCartCollectByTableID() {
        Map<String, Object> cartData = shoppingCartInfoDao.getByTableID(MerchantCacheUtils.getCurrentTableID());
        if (CollectionUtils.isEmpty(cartData)) {
            cartData = new HashMap<String, Object>();
            cartData.put("cartID", 0);
            cartData.put("totalAmount", 0.00);
            cartData.put("totalQuantity", 0);
            cartData.put("cartMemo", "");
        }
        return cartData;
    }

    /**
     * 保存已选厨师信息
     *
     * @author LeeJun
     * @time 2017-6-5 16:09
     * @version 2.0.0
     */
    public boolean saveDesigner(Long detailID, Long designerID, BigDecimal designerPrice) {
        O_ShoppingCartDetailInfoEntity cartDetailInfo = cartDetailInfoDao.selectByPrimaryKey(detailID);
        cartDetailInfo.setDesignerID(designerID);
        cartDetailInfo.setDesignerPrice(designerPrice);
        int row = cartDetailInfoDao.updateByPrimaryKeySelective(cartDetailInfo);
        return ResultHelper.retBool(row);
    }

}
