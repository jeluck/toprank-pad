package cc.toprank.byd.pad.service;

import cc.toprank.byd.common.utils.MapHelper;
import cc.toprank.byd.common.utils.ObjectUtil;
import cc.toprank.byd.common.utils.SortUtil;
import cc.toprank.byd.config.BaseConfig;
import cc.toprank.byd.constant.PadConstants;
import cc.toprank.byd.dao.*;
import cc.toprank.byd.entity.B_AttachmentMappingEntity;
import cc.toprank.byd.entity.B_MerchantMenuInfoEntity;
import cc.toprank.byd.entity.P_ProductTagMappingEntity;
import cc.toprank.byd.enums.CommonManageEnum;
import cc.toprank.byd.pad.pojo.CommendProductDTO;
import cc.toprank.byd.pad.pojo.SpecificationDTO;
import cc.toprank.byd.pad.util.ImgPathUtils;
import cc.toprank.byd.pad.util.MerchantCacheUtils;
import cc.toprank.byd.service.ComboService;
import cc.toprank.byd.service.GuQingService;
import cc.toprank.byd.util.MaxIDUtils;
import com.github.pagehelper.PageHelper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cc.toprank.byd.enums.AttachmentManageEnum.ProductAattachmentManage.PRODUCTHEADTYPE;
import static cc.toprank.byd.enums.AttachmentManageEnum.ProductAattachmentManage.PRODUCTVARIANTHEADTYPE;

/**
 * @author LeeJun 2017年1月21日下午3:57:23
 */
@Service
public class ProductService {
    private final static Logger LOGGER = LoggerFactory.getLogger(ProductService.class);
    @Autowired
    private P_ProductInfoDao productDAO;
    @Autowired
    private P_ProductVariantInfoDao productVariantInfoMapper;
    @Autowired
    private P_ProductCategoryInfoDao categoryDao;
    @Autowired
    private B_DinningTableInfoDao tableDAO;
    @Autowired
    private P_ProductTagMappingDao tagMappingDAO;
    @Autowired
    private B_MerchantMenuInfoDao menuInfoDao;
    @Autowired
    private ProductAttributeService productAttributeService;
    @Autowired
    private B_AttachmentMappingDao attachmentMappingDao;
    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private GuQingService guQingService;
    @Autowired
    private ComboService comboService;

    /**
     * 首页人气推荐菜品，按人气排序
     *
     * @param currentPage
     * @return
     * @author LeeJun 2017年1月21日下午3:57:30
     */
    public List<CommendProductDTO> getCommendProducts(int currentPage) {
        Long archiveID = MerchantCacheUtils.getCurrentArchiveID();
        Long tableID = MerchantCacheUtils.getCurrentTableID();
        Long areaID = CommonMapper.getCurrentTable().getAreaID();
        Map<String, Object> param = new HashMap();
        param.put("archiveID", archiveID);
        param.put("tableID", tableID);
        param.put("areaID", areaID);
        Long currentMealsID = CommonMapper.getCurrentMealsID();
        param.put("mealsID", currentMealsID);
        Long areaIDWithMenu = CommonMapper.getAreaIDWithMenu(param);
        PageHelper.startPage(currentPage, 10);
        List<CommendProductDTO> commends = productDAO.getCommendProducts(archiveID, areaIDWithMenu, currentMealsID);
        try {
            commends = ImgPathUtils.addImgHead2Object(commends, "filePath");
        } catch (Exception e) {
            LOGGER.error("getCommendProducts", e);
        }
        return commends;
    }

    /**
     * @description 获得餐厅的分类列表 (1.根据mealsID先查询有菜的areaID 2.再查询分类列表)  areaID + mealsID(已确定) + archiveID
     * @author LiSH
     * @time 2017-3-15 14:24
     * @version 2.0.0
     */
    /**
     * @description 获得餐厅的分类列表 (1.根据mealsID先查询有菜的areaID 2.再查询分类列表)  areaID + mealsID(已确定) + archiveID
     * @author LiSH
     * @time 2017-3-15 14:24
     * @version 2.0.0
     */
    public List<Map<String, Object>> getCategoryList(Map<String, Object> param) {
        Long areaID = MapUtils.getLong(param, "areaID");
//        1.根据mealsID先查询有菜的areaID
        if (areaID == null) {
            param.put("areaID", null);
        } else {
            Long areaIDWithMenu = CommonMapper.getAreaIDWithMenu(param);
            param.put("areaID", areaIDWithMenu);
        }

//        2.查询分类列表
        List<Map<String, Object>> categoryList = productDAO.getCategoryList(param);

        // 3.上一步查询出来的分类只是有菜品数据的分类  要把查出来的分类和它的父级查出来
        List<Long> categoryIDs = new ArrayList<>();
        for (Map map : categoryList) {
            categoryIDs.add(ObjectUtil.objectToLong(map.get("categoryID")));
            if (null != map.get("parentID")) {
                categoryIDs.add(ObjectUtil.objectToLong(map.get("parentID")));
            }
        }
        List<Map<String, Object>> categoryInfoList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(categoryIDs)) {
            categoryInfoList = categoryDao.getCategoryInfoListByCategoryIDs(categoryIDs);
        }
        List<Map<String, Object>> maps = SortUtil.treeSort(categoryInfoList, "categoryID", "parentID");
        return maps;
    }

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 获得当前区域下分类列表(1.先查询餐次 2.再查询分类列表)
     * @time 2017-6-1 13:56
     */
    public List<Map<String, Object>> getCategoryList(Long areaID, Long archiveID) {
        Map<String, Object> param = MapHelper.newMap();
        param.put("areaID", areaID);
        param.put("archiveID", archiveID);
        param.put("mealsID", CommonMapper.getCurrentMealsID());
        return getCategoryList(param);
    }

    /**
     * @description 获得餐厅的标签列表
     * @author LiSH
     * @time 2017-3-15 14:22
     * @version 2.0.0
     */
    public List<Map<String, String>> getTagListByArchiveID(Long currentArchiveID) {
        return productDAO.getTagListByArchiveID(currentArchiveID);
    }

    /**
     * @description 搜索菜品列表
     * @author LiSH
     * @time 2017-3-15 14:25
     * @version 2.0.0
     */
    public List<Map<String, Object>> getProductsByParam(Map<String, Object> map) {
        Long archiveID = MerchantCacheUtils.getCurrentArchiveID();
        Long tableID = MerchantCacheUtils.getCurrentTableID();
        Long areaID = CommonMapper.getCurrentTable().getAreaID();
        Map<String, Object> param = MapHelper.newMap();
        param.putAll(map);
        param.put("archiveID", archiveID);
        param.put("tableID", tableID);
        param.put("areaID", areaID);
        Long mealsIDWithAreaID = CommonMapper.getCurrentMealsID();
        param.put("mealsID", mealsIDWithAreaID);
        Long areaIDWithMenu = CommonMapper.getAreaIDWithMenu(param);
        param.put("areaID", areaIDWithMenu);

        PageHelper.startPage(MapUtils.getInteger(map, "pageNum", PadConstants.DEFAULT_PAGE_NUM), PadConstants.PAGE_SIZE);
        List<Map<String, Object>> productList = productDAO.getProductsByParam(param);
        int i = 0;
        boolean needWeigh = false;
        for (Map<String, Object> product : productList) {
            Boolean isCombo = product.get("isCombo").toString().equals("1");
            Long dishesID = (Long) (isCombo ? product.get("productID") : product.get("variantID"));
            product.put("saveDesc", "");
            product.put("saveNum", 0);
            needWeigh = MapUtils.getBooleanValue(product, "needWeigh", false);
            product.put("isPop", hasAttributes(dishesID, isCombo, needWeigh));
            if (!isCombo) {
                product.put("spicy", productAttributeService.getSpicyVariantID(MapUtils.getLong(product, "variantID")));
            } else {
                product.put("spicy", 0);
            }
            product.put("saleStop", false);

            if (needWeigh) {
                product.put("guqing", guQingService.checkFloatIsGuQing(product, 0));
            } else {
                product.put("guqing", guQingService.checkIsGuQing(product, 0));
            }
//            if (i == 0) {
//                p.put("spicy", 3);
//                p.put("saleStop", true);
//            } else if (i == 1) {
//                p.put("guqing", true);
//            } else if (i == 2) {
//                p.put("guqing", true);
//                p.put("saleStop", true);
//            }
            i++;
            product.put("filePath", MerchantCacheUtils.getImagePath() + product.get("filePath"));
            //处理属性值结构
            String valueList = (String) product.get("valueList");
            List<Map<String, String>> list = new ArrayList<>();
            if (valueList != null) {
                String[] split = valueList.split(",");
                for (String s : split) {
                    Map<String, String> m = new HashMap<>();
                    String[] twoSplit = s.split("=");
                    m.put("valueID", twoSplit[0]);
                    m.put("name", twoSplit[1]);
                    m.put("value", twoSplit[2]);
                    list.add(m);
                }
            }
            product.put("valueList", list);
            String tagListStr = (String) product.get("tagList");
            List<Map<String, String>> tagList = new ArrayList<>();
            if (tagListStr != null) {
                String[] split = tagListStr.split(",");
                for (String tagStr : split) {
                    Map<String, String> tagMap = new HashMap<>();
                    String[] tagStrArr = tagStr.split("=");
                    String tagID = tagStrArr[0];
                    if ("1".equals(tagID) || "2".equals(tagID) || "3".equals(tagID) || "4".equals(tagID)) {
                        tagMap.put("tagID", tagStrArr[0]);
                        tagMap.put("tagName", tagStrArr[1]);
                        tagList.add(tagMap);
                    }
                }
            }
            product.put("tagList", tagList);
        }
        return productList;
    }

    /**
     * 获取菜品详细信息
     *
     * @author LeeJun
     * @time 2017-2-21 13:12
     * @version 2.0.0
     */
    public Map<String, Object> getProductDetails(Long menuID, boolean isCombo) {
        Map<String, Object> mapData;
        Long targetType;
        Long dishesID;
        Long tableID = MerchantCacheUtils.getCurrentTableID();
        if (isCombo) {
            targetType = PRODUCTHEADTYPE.getValue();
            mapData = productDAO.getProductDetails(menuID, tableID);
            dishesID = MapUtils.getLong(mapData, "productID");
            mapData.put("produceMinute", 10);
            mapData.put("variantID", null);
            mapData.put("spicy", productAttributeService.getSpicyVariantID(MapUtils.getLong(mapData, "variantID")));
            // 查询套餐详情菜品
            mapData.put("comboDetails", comboService.getComboDetail(dishesID));
        } else {
            targetType = PRODUCTVARIANTHEADTYPE.getValue();
            mapData = productDAO.getVariantDetails(menuID, tableID);
            dishesID = MapUtils.getLong(mapData, "variantID");
            mapData.put("spicy", 0);
        }
        boolean needWeigh = MapUtils.getBooleanValue(mapData, "needWeigh", false);
        if (needWeigh) {
            mapData.put("guqing", guQingService.checkFloatIsGuQing(mapData, 0));
        } else {
            mapData.put("guqing", guQingService.checkIsGuQing(mapData, 0));
        }
        mapData.put("saleStop", false);
        mapData.put("isCombo", isCombo);
        mapData.put("isPop", hasAttributes(dishesID, isCombo, needWeigh));
        Map<String, Object> param = new HashMap<String, Object>();
        // 查询购物车汇总信息，封装在返回数据中
        Map<String, Object> cartMap = shoppingCartService.getCartCollectByTableID();
        if (cartMap == null) {
            mapData.put("cartTotalQuantity", 0);
            mapData.put("cartTotalAmount", 0.00);
        } else {
            mapData.put("cartTotalQuantity", cartMap.get("totalQuantity"));
            mapData.put("cartTotalAmount", cartMap.get("totalAmount"));
        }
        // 查询商品图片
        List<B_AttachmentMappingEntity> pictureList = attachmentMappingDao.getProductImgByParam(dishesID, targetType, CommonManageEnum.AttachmentType.IMAGE.getValue());
        List<String> pictures = new ArrayList<String>();
        for (int i = 0; i < pictureList.size(); i++) {
            pictures.add(BaseConfig.getImagePath() + pictureList.get(i).getFilePath());
        }
        mapData.put("pictures", pictures);
        return mapData;
    }

    public Object saveTag(Map<String, Object> paramMap) {
        P_ProductTagMappingEntity m = tagMappingDAO.getEntityByParams(paramMap);
        if (m != null) {
            throw new RuntimeException("mapping has exists");
        }
        P_ProductTagMappingEntity tagMapping = new P_ProductTagMappingEntity();
        tagMapping.setMappingID(MaxIDUtils.getID(tagMapping));
        tagMapping.setArchiveID(MapUtils.getLong(paramMap, "archiveID"));
        tagMapping.setTagID(MapUtils.getLong(paramMap, "tagID"));
        tagMapping.setMappingStatus(9L);
        tagMapping.setTargetID(MapUtils.getLong(paramMap, "targetID"));
        tagMapping.setCreateTime(LocalDateTime.now());
        tagMappingDAO.insert(tagMapping);
        return tagMapping;
    }

    /**
     * 是否存在属性、规格、称重
     *
     * @author LeeJun
     * @time 2017-5-24 11:14
     * @version 2.0.0
     */
    public boolean hasAttributes(Long dishesID, boolean isCombo, boolean needWeigh) {
        List<SpecificationDTO> specifications = getProductSpecification(dishesID, isCombo);
        List<Map<String, Object>> attributes = productAttributeService.getProductAttribute(dishesID, isCombo);
        return specifications.size() > 0 || attributes.size() > 0 || needWeigh;
    }

    /**
     * 获取菜品的属性和规格
     *
     * @author LeeJun
     * @time 2017-3-19 10:22
     * @version 2.0.0
     */
    public Map<String, Object> getAttributes(Long menuID) {
        B_MerchantMenuInfoEntity menuInfo = menuInfoDao.selectByPrimaryKey(menuID);
        Long dishesID;
        if (menuInfo.getIsCombo()) {
            dishesID = menuInfo.getProductID();
        } else {
            dishesID = menuInfo.getVariantID();
        }
        Map<String, Object> attrMap = new HashMap<>();
        List<SpecificationDTO> specifications = getProductSpecification(dishesID, menuInfo.getIsCombo());
        List<Map<String, Object>> attributes = productAttributeService.getProductAttribute(dishesID, menuInfo.getIsCombo());
        Map<String, List<Map<String, Object>>> maps = new HashMap<>();
        List<Map<String, Object>> attrs;
        for (Map<String, Object> attribute : attributes) {
            String attributeID = String.valueOf(attribute.get("attributeID"));
            if (maps.containsKey(attributeID)) {
                maps.get(attributeID).add(attribute);
            } else {
                attrs = new ArrayList<>();
                attrs.add(attribute);
                maps.put(attributeID, attrs);
            }
        }
        attrMap.put("specifications", specifications);
        attrMap.put("attributes", maps.values());
        attrMap.put("unitName", menuInfoDao.getProductUnitName(menuID));
        attrMap.put("needWeigh", menuInfo.getNeedWeigh());
        return attrMap;
    }

    /**
     * 获取菜品的规格信息
     *
     * @author LeeJun
     * @time 2017-2-21 13:10
     * @version 2.0.0
     */
    public List<SpecificationDTO> getProductSpecification(Long dishesID, boolean isCombo) {
        if (isCombo) {
            return menuInfoDao.getCombosSpecification(dishesID, null);
        } else {
            return menuInfoDao.getVariantSpecification(dishesID, null);
        }
    }
}
