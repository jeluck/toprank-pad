package cc.toprank.byd.web.service.curbsale;

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.common.utils.DateUtils;
import cc.toprank.byd.common.utils.MapHelper;
import cc.toprank.byd.common.utils.SortUtil;
import cc.toprank.byd.constant.ParamConstants;
import cc.toprank.byd.constant.ParamConstants.CurbSaleParam;
import cc.toprank.byd.dao.O_OrderDetailInfoDao;
import cc.toprank.byd.dao.W_ProductHisMappingDao;
import cc.toprank.byd.dao.W_ProductMappingDao;
import cc.toprank.byd.entity.O_OrderDetailInfoEntity;
import cc.toprank.byd.entity.W_ProductMappingEntity;
import cc.toprank.byd.dao.*;
import cc.toprank.byd.entity.*;
import cc.toprank.byd.enums.MerchantManageEnum;
import cc.toprank.byd.util.MaxIDUtils;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.constant.ResultData;
import cc.toprank.byd.web.util.CurbSaleUtils;
import cc.toprank.byd.web.vo.curbsale.*;
import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.*;
import java.util.*;

/**
 * 沽清服务
 */
@Service
public class CurbSaleService {

    //日志打印
    protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private W_ProductMappingDao w_productMappingDao;

    @Autowired
    private W_ProductMappingDealInfoDao w_productMappingDealInfoDao;

    @Autowired
    private P_VariantSpecificationMappingDao p_variantSpecificationMappingDao;

    @Autowired
    private B_MerchantMenuInfoDao b_merchantMenuInfoDao;

    @Autowired
    private O_OrderDetailInfoDao o_orderDetailInfoDao;

    @Autowired
    private P_ProductSpecificationMappingDao p_productSpecificationMappingDao;

    @Autowired
    private W_ProductHisMappingDao w_productHisMappingDao;

    @Autowired
    private U_LoginInfoDao u_loginInfoDao;

    @Autowired
    private B_BasicParamInfoDao b_basicParamInfoDao;

    @Autowired
    private B_ShopStoreMappingDao b_shopStoreMappingDao;

    @Autowired
    private V_ProductMappingDao v_productMappingDao;

    @Autowired
    P_ProductInfoDao productDao;

    /**
     * @param map
     * @return
     * @Description： 获取菜品分类属性信息, 排除已经设置完沽清的菜品
     * @Author：chenkangyi
     * @Time: 2017-5-11 11:00
     * @Version 2.0.0
     */
    public List<ProductCrubSaleInfoVO> getProductListByConditionFromCurbSale(Map<String, Object> map) throws Exception {
//        int pageNum = (int) map.get("pageNum");
//        PageHelper.startPage(pageNum, PadConstants.PAGE_SIZE);
        return w_productMappingDao.getProductListByConditionFromCurbSale(map);
    }

    /**
     * @param map
     * @return
     * @Description： 获取菜单沽清信息和预定信息
     * @Author：chenkangyi
     * @Time: 2017-5-11 20:39
     * @Version 2.0.0
     */
    public CrubSaleInfoAndBookingInfoObjVO getCurbSaleInfoAndBookingInfo(Map<String, Object> map) throws Exception {
        //Integer productType = (Integer) map.get("productType");
        Long menuID = (Long) map.get("menuID");
        //boolean needWeigh = (boolean) map.get("needWeigh");
        Long archiveID = (Long) map.get("archiveID");
        CrubSaleInfoAndBookingInfoObjVO crubSaleInfoAndBookingInfoObjVO = new CrubSaleInfoAndBookingInfoObjVO();
        List<CrubSaleInfoAndBookingInfoVO> crubSaleInfoAndBookingInfoVOList = new ArrayList<>();
        //根据menuid查询菜单信息
        B_MerchantMenuInfoEntity b_merchantMenuInfoEntity = b_merchantMenuInfoDao.selectByPrimaryKey(menuID);
        //1为套餐，0位单品
        Boolean isCombo = b_merchantMenuInfoEntity.getIsCombo();
        Boolean needWeigh = b_merchantMenuInfoEntity.getNeedWeigh();
        if (isCombo == null) {
            isCombo = false;
        }
        if (needWeigh == null) {
            needWeigh = false;
        }
        if (b_merchantMenuInfoEntity == null) {
            throw new BizException(CodeMsgConstants.ERROR,
                    CodeMsgConstants.ERROR_MSG);
        }
        Long variantID = b_merchantMenuInfoEntity.getVariantID();
        Long productID = b_merchantMenuInfoEntity.getProductID();
        map.put("variantID", variantID);
        map.put("productID", productID);
        //单品productType=2,套餐productType=1
        if (!isCombo) {
            // if (productType==2){
            //根据变体id获取规格信息
            List<P_VariantSpecificationMappingEntity> variantSpecificationMappingByVariantIDList = p_variantSpecificationMappingDao.getVariantSpecificationMappingByVariantID(variantID);
            crubSaleInfoAndBookingInfoObjVO.setOptionIDSum(variantSpecificationMappingByVariantIDList.size());
            if (variantSpecificationMappingByVariantIDList.size() == 0) {  //没有规格
                W_ProductMappingEntity productMappingByVariantIDAndOptionID = w_productMappingDao.getProductMappingByVariantIDAndOptionID(map);
                CrubSaleInfoAndBookingInfoVO crubSaleInfoAndBookingInfoVO = new CrubSaleInfoAndBookingInfoVO();
                int bookingSumByMenuIDOptionIDArchiveID = o_orderDetailInfoDao.getBookingSumByMenuIDOptionIDArchiveID(map);
                if (productMappingByVariantIDAndOptionID != null) {
                    crubSaleInfoAndBookingInfoVO.setInitQuantity(productMappingByVariantIDAndOptionID.getInitQuantity());
                    crubSaleInfoAndBookingInfoVO.setInitFloatQuantity(productMappingByVariantIDAndOptionID.getInitFloatQuantity());
                    crubSaleInfoAndBookingInfoVO.setMappingID(productMappingByVariantIDAndOptionID.getMappingID());
                }
                crubSaleInfoAndBookingInfoVO.setBookingSum(bookingSumByMenuIDOptionIDArchiveID);
                crubSaleInfoAndBookingInfoVOList.add(crubSaleInfoAndBookingInfoVO);
            } else {  //有规格
                //List<CrubSaleInfoAndBookingInfoVO> crubSaleInfoAndBookingInfoVOList = w_productMappingDao.getCurbSaleInfoAndBookingInfoVariant(map);
                for (P_VariantSpecificationMappingEntity p_variantSpecificationMappingEntity : variantSpecificationMappingByVariantIDList) {
                    Long optionID = p_variantSpecificationMappingEntity.getOptionID();
                    map.put("optionID", optionID);
                    W_ProductMappingEntity productMappingByVariantIDAndOptionID = w_productMappingDao.getProductMappingByVariantIDAndOptionID(map);
                    int bookingSumByMenuIDOptionIDArchiveID = o_orderDetailInfoDao.getBookingSumByMenuIDOptionIDArchiveID(map);
                    CrubSaleInfoAndBookingInfoVO crubSaleInfoAndBookingInfoVO = new CrubSaleInfoAndBookingInfoVO();
                    if (productMappingByVariantIDAndOptionID != null) {
                        crubSaleInfoAndBookingInfoVO.setInitQuantity(productMappingByVariantIDAndOptionID.getInitQuantity());
                        crubSaleInfoAndBookingInfoVO.setInitFloatQuantity(productMappingByVariantIDAndOptionID.getInitFloatQuantity());
                        crubSaleInfoAndBookingInfoVO.setMappingID(productMappingByVariantIDAndOptionID.getMappingID());
                    }
                    crubSaleInfoAndBookingInfoVO.setBookingSum(bookingSumByMenuIDOptionIDArchiveID);
                    crubSaleInfoAndBookingInfoVO.setOptionName(p_variantSpecificationMappingEntity.getOptionName());
                    crubSaleInfoAndBookingInfoVO.setOptionID(p_variantSpecificationMappingEntity.getOptionID());
                    crubSaleInfoAndBookingInfoVO.setExchangeRate(p_variantSpecificationMappingEntity.getExchangeRate());
                    crubSaleInfoAndBookingInfoVOList.add(crubSaleInfoAndBookingInfoVO);
                }
            }
        } else {
            List<P_ProductSpecificationMappingEntity> productSpecificationMappingByProductIDList = p_productSpecificationMappingDao.getProductSpecificationMappingByProductID(productID);
            crubSaleInfoAndBookingInfoObjVO.setOptionIDSum(productSpecificationMappingByProductIDList.size());
            if (productSpecificationMappingByProductIDList.size() == 0) {  //没有规格
                W_ProductMappingEntity productMappingByProductIDAndOptionID = w_productMappingDao.getProductMappingByProductIDAndOptionID(map);
                CrubSaleInfoAndBookingInfoVO crubSaleInfoAndBookingInfoVO = new CrubSaleInfoAndBookingInfoVO();
                int bookingSumByMenuIDOptionIDArchiveID = o_orderDetailInfoDao.getBookingSumByMenuIDOptionIDArchiveID(map);
                if (productMappingByProductIDAndOptionID != null) {
                    crubSaleInfoAndBookingInfoVO.setInitQuantity(productMappingByProductIDAndOptionID.getInitQuantity());
                    crubSaleInfoAndBookingInfoVO.setInitFloatQuantity(productMappingByProductIDAndOptionID.getInitFloatQuantity());
                    crubSaleInfoAndBookingInfoVO.setMappingID(productMappingByProductIDAndOptionID.getMappingID());
                }
                crubSaleInfoAndBookingInfoVO.setBookingSum(bookingSumByMenuIDOptionIDArchiveID);
                crubSaleInfoAndBookingInfoVOList.add(crubSaleInfoAndBookingInfoVO);
            } else {
                for (P_ProductSpecificationMappingEntity p_productSpecificationMappingEntity : productSpecificationMappingByProductIDList) {
                    Long optionID = p_productSpecificationMappingEntity.getOptionID();
                    map.put("optionID", optionID);
                    W_ProductMappingEntity productMappingByProductIDAndOptionID = w_productMappingDao.getProductMappingByProductIDAndOptionID(map);
                    CrubSaleInfoAndBookingInfoVO crubSaleInfoAndBookingInfoVO = new CrubSaleInfoAndBookingInfoVO();
                    int bookingSumByMenuIDOptionIDArchiveID = o_orderDetailInfoDao.getBookingSumByMenuIDOptionIDArchiveID(map);
                    if (productMappingByProductIDAndOptionID != null) {
                        crubSaleInfoAndBookingInfoVO.setInitQuantity(productMappingByProductIDAndOptionID.getInitQuantity());
                        crubSaleInfoAndBookingInfoVO.setInitFloatQuantity(productMappingByProductIDAndOptionID.getInitFloatQuantity());
                        crubSaleInfoAndBookingInfoVO.setMappingID(productMappingByProductIDAndOptionID.getMappingID());
                    }
                    crubSaleInfoAndBookingInfoVO.setBookingSum(bookingSumByMenuIDOptionIDArchiveID);
                    crubSaleInfoAndBookingInfoVO.setOptionName(p_productSpecificationMappingEntity.getOptionName());
                    crubSaleInfoAndBookingInfoVO.setOptionID(p_productSpecificationMappingEntity.getOptionID());
                    crubSaleInfoAndBookingInfoVO.setExchangeRate(p_productSpecificationMappingEntity.getExchangeRate());
                    crubSaleInfoAndBookingInfoVOList.add(crubSaleInfoAndBookingInfoVO);
                }
            }
        }
        B_ShopStoreMappingEntity b_shopStoreMappingEntity = b_shopStoreMappingDao.selectByArchiveID(archiveID);
        if (b_shopStoreMappingEntity == null) {
            throw new BizException(CodeMsgConstants.ERROR, CodeMsgConstants.ERROR_MSG);
        }
        crubSaleInfoAndBookingInfoObjVO.setWarehouseID(b_shopStoreMappingEntity.getWarehouseID());
        crubSaleInfoAndBookingInfoObjVO.setVariantID(variantID);
        crubSaleInfoAndBookingInfoObjVO.setProductID(productID);
        crubSaleInfoAndBookingInfoObjVO.setNeedWeigh(needWeigh);
        crubSaleInfoAndBookingInfoObjVO.setList(crubSaleInfoAndBookingInfoVOList);
        return crubSaleInfoAndBookingInfoObjVO;
    }

    public List<CurbSaleOperationHistoryVO> getCurbSaleOperationListByCondition(Map<String, Object> map) throws Exception {
        String date = (String) map.get(CurbSaleParam.STOREDAY);
        List<CurbSaleOperationHistoryVO> resultList = null;
        if (DateUtils.getCurrentDate().equals(date)) {
            resultList = w_productMappingDao.getCurbSaleOperationListForToday(map);
        } else {
            resultList = w_productMappingDao.getCurbSaleOperationListForHistory(map);
        }
        setCurbSaleOperationHistoryVOCreator(resultList);
        return resultList;
    }

    private void setCurbSaleOperationHistoryVOCreator(List<CurbSaleOperationHistoryVO> resultList) {
        if (resultList != null && resultList.size() > 0) {
            List<U_LoginInfoEntity> all = u_loginInfoDao.getAll();
            if (all != null) {
                for (CurbSaleOperationHistoryVO historyVo : resultList) {
                    String creator = getCreator(historyVo.getCreatorID(), all);
                    historyVo.setCreator(creator);
                    String authorizer = getCreator(historyVo.getAuthorizerID(), all);
                    historyVo.setAuthorizer(authorizer);
                }
            }
        }
    }

    private String getCreator(Long creatorID, List<U_LoginInfoEntity> all) {
        for (U_LoginInfoEntity loginInfo : all) {
            Long loginID = loginInfo.getLoginID();
            if (loginID != null && loginID.equals(creatorID)) {
                return loginInfo.getNickName();
            }
        }
        return null;
    }

    /**
     * @param map
     * @return
     * @Description：
     * @Author：chenkangyi
     * @Time: 2017-5-12 19:21
     * @Version 2.0.0
     */
    @Transactional(rollbackFor = Exception.class)
    public void addCrubSale(List<OptionIDAndQuantityVO> optionIDAndQuantityVOList, Map<String, Object> map) throws Exception {
        //获取预定信息和沽清信息
        CrubSaleInfoAndBookingInfoObjVO crubSaleInfoAndBookingInfoObjVO = getCurbSaleInfoAndBookingInfo(map);
        boolean needWeigh = crubSaleInfoAndBookingInfoObjVO.isNeedWeigh();
        List<CrubSaleInfoAndBookingInfoVO> curbSaleInfoAndBookingInfoList = crubSaleInfoAndBookingInfoObjVO.getList();
        Map<Long, String> optionGetMap = new HashMap<>();
        for (CrubSaleInfoAndBookingInfoVO crubSaleInfoAndBookingInfoVO : curbSaleInfoAndBookingInfoList) {
            if (crubSaleInfoAndBookingInfoVO == null) {
                throw new BizException(CodeMsgConstants.ERROR, CodeMsgConstants.ERROR_MSG);
            }
            if (needWeigh) {
                optionGetMap.put(crubSaleInfoAndBookingInfoVO.getOptionID(), String.valueOf(crubSaleInfoAndBookingInfoVO.getInitFloatQuantity()));
            } else {
                optionGetMap.put(crubSaleInfoAndBookingInfoVO.getOptionID(), String.valueOf(crubSaleInfoAndBookingInfoVO.getInitQuantity()));
            }
        }
        Map<Long, String> optionMap = new HashMap<>();
        for (OptionIDAndQuantityVO optionIDAndQuantityVO : optionIDAndQuantityVOList) {
            if (optionIDAndQuantityVO == null) {
                throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
            }
            optionMap.put(optionIDAndQuantityVO.getOptionID(), optionIDAndQuantityVO.getQuantity());
        }
        //判断输入参数是否合法
        ok:
        for (Long optionKey : optionMap.keySet()) {
            if (!optionGetMap.containsKey(optionKey)) { //输入参数有误
                throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
            }
            for (CrubSaleInfoAndBookingInfoVO crubSaleInfoAndBookingInfoVO : curbSaleInfoAndBookingInfoList) {
                Long optionID = crubSaleInfoAndBookingInfoVO.getOptionID();
                if (optionKey == null) {
                    if (optionID == null) {  //没有规格
                        String optionValue = optionMap.get(optionKey);
                        if (needWeigh) {
                            crubSaleInfoAndBookingInfoVO.setInitFloatQuantity(optionValue == null ? null : Float.valueOf(optionValue));
                        } else {
                            crubSaleInfoAndBookingInfoVO.setInitQuantity(optionValue == null ? null : Integer.valueOf(optionValue));
                        }
                        break ok;
                    }
                } else {
                    if (optionKey.equals(optionID)) {
                        String optionValue = optionMap.get(optionKey);
                        if (needWeigh) {
                            crubSaleInfoAndBookingInfoVO.setInitFloatQuantity(optionValue == null ? null : Float.valueOf(optionValue));
                        } else {
                            crubSaleInfoAndBookingInfoVO.setInitQuantity(optionValue == null ? null : Integer.valueOf(optionValue));
                        }
                    }
                }
            }
        }
        Long loginID = (Long) map.get("loginID");
        boolean isAccOptionCureSale = (boolean) map.get("isAccOptionCureSale");
        //int optionIDSum = (int) map.get("optionIDSum");
        //int optionIDSum = curbSaleInfoAndBookingInfoList.size();
        int optionIDSum = crubSaleInfoAndBookingInfoObjVO.getOptionIDSum();
        //boolean  needWeigh = crubSaleInfoAndBookingInfoObjVO.isNeedWeigh();
        Long variantID = crubSaleInfoAndBookingInfoObjVO.getVariantID();
        Long productID = crubSaleInfoAndBookingInfoObjVO.getProductID();
        Long warehouseID = crubSaleInfoAndBookingInfoObjVO.getWarehouseID();
        boolean quantityIsLegal = false; //沽清数量配置是否合法
        for (CrubSaleInfoAndBookingInfoVO crubSaleInfoAndBookingInfoVO : curbSaleInfoAndBookingInfoList) {
            if (needWeigh) {
                Float initFloatQuantity = crubSaleInfoAndBookingInfoVO.getInitFloatQuantity();
                if (initFloatQuantity != null && initFloatQuantity > 0) {
                    quantityIsLegal = true;
                }
            } else {
                Integer initQuantity = crubSaleInfoAndBookingInfoVO.getInitQuantity();
                if (initQuantity != null && initQuantity > 0) {
                    quantityIsLegal = true;
                }
            }
        }
        if (!quantityIsLegal) {
            throw new BizException(CodeMsgConstants.CURBSALE_MUST_THEN_ZERO, CodeMsgConstants.CURBSALE_MUST_THEN_ZERO_MSG);
        }
        for (CrubSaleInfoAndBookingInfoVO crubSaleInfoAndBookingInfoVO : curbSaleInfoAndBookingInfoList) {
            Long mappingID = crubSaleInfoAndBookingInfoVO.getMappingID();

            if (optionIDSum > 0) {  //有规格
                if (isAccOptionCureSale) {   //按照规格配置沽清
                    if (mappingID == null) {  //新增
                        addProductMapping(crubSaleInfoAndBookingInfoVO, loginID, needWeigh, variantID, productID, warehouseID, map);
                    } else {                 //修改
                        updateProductMappingAccNeedWeigh(crubSaleInfoAndBookingInfoVO, needWeigh, map);
                    }
                } else {              //不按规格配置沽清
                    Float exchangeRate = crubSaleInfoAndBookingInfoVO.getExchangeRate();
                    if (mappingID != null) { //说明商品有规格设置了沽清，这个时候设置不按规格沽清则需要把对应在ProductMapping的数据删除，然后添加标准规格沽清数据
                        if (exchangeRate == null || exchangeRate != 1.0f) {
                            W_ProductMappingEntity w_productMappingEntitybBefore = w_productMappingDao.selectByPrimaryKey(mappingID);
                            w_productMappingDao.deleteByPrimaryKey(mappingID);

                            map.put("initQuantity", null);
                            map.put("initFloatQuantity", null);
                            map.put("changeType", MerchantManageEnum.CurbSaleChangeType.DELETERECORD.getValue());
                            insertProductMappingDealInfo(w_productMappingEntitybBefore, new W_ProductMappingEntity(), map);
                        }
                        if (exchangeRate == 1.0f) {  //如果兑换比率为1代表是按照这种规格做标准沽清
                            updateProductMappingAccNeedWeigh(crubSaleInfoAndBookingInfoVO, needWeigh, map);
                        }
                    } else {  //新增
                        if (exchangeRate != null && exchangeRate == 1.0f) {  //如果兑换比率为1代表是按照这种规格做标准沽清
                            addProductMapping(crubSaleInfoAndBookingInfoVO, loginID, needWeigh, variantID, productID, warehouseID, map);
                        }
                    }
                }
            } else {   //没有规格
                if (mappingID == null) {  //新增
                    addProductMapping(crubSaleInfoAndBookingInfoVO, loginID, needWeigh, variantID, productID, warehouseID, map);
                } else {                 //修改
                    updateProductMappingAccNeedWeigh(crubSaleInfoAndBookingInfoVO, needWeigh, map);
                }
            }
        }

    }

    /**
     * @param
     * @return
     * @Description： 插入一条沽清数据
     * @Author：chenkangyi
     * @Time: 2017-5-13 13:15
     * @Version 2.0.0
     */
    public void addProductMapping(CrubSaleInfoAndBookingInfoVO crubSaleInfoAndBookingInfoVO, Long loginID, boolean needWeigh, Long variantID, Long productID, Long warehouseID, Map<String, Object> map) {
        //沽清数量不能小于预定数量，必须大于0
        Integer bookingSum = crubSaleInfoAndBookingInfoVO.getBookingSum();
        //boolean needWeigh = crubSaleInfoAndBookingInfoVO.isNeedWeigh();
        Integer initQuantity = crubSaleInfoAndBookingInfoVO.getInitQuantity();
        Float initFloatQuantity = crubSaleInfoAndBookingInfoVO.getInitFloatQuantity();
        //校验输入数量
        boolean isNeedInsert = checkQuantityIsLegal(initQuantity, initFloatQuantity, bookingSum, needWeigh);
        if (isNeedInsert) {
            W_ProductMappingEntity w_productMappingEntity = new W_ProductMappingEntity();
            Long mappingID = MaxIDUtils.getID(W_ProductMappingEntity.class);
            w_productMappingEntity.setMappingID(mappingID);
            w_productMappingEntity.setProductID(productID);
            w_productMappingEntity.setVariantID(variantID);
            w_productMappingEntity.setWarehouseID(warehouseID);
            w_productMappingEntity.setOptionID(crubSaleInfoAndBookingInfoVO.getOptionID());
            w_productMappingEntity.setInitQuantity(crubSaleInfoAndBookingInfoVO.getInitQuantity());
            w_productMappingEntity.setInitFloatQuantity(crubSaleInfoAndBookingInfoVO.getInitFloatQuantity());
            w_productMappingEntity.setRemainingQuantity(crubSaleInfoAndBookingInfoVO.getInitQuantity());
            w_productMappingEntity.setRemainingFloatQuantity(crubSaleInfoAndBookingInfoVO.getInitFloatQuantity());
            w_productMappingEntity.setAvailableQuantity(crubSaleInfoAndBookingInfoVO.getInitQuantity());
            w_productMappingEntity.setAvailableFloatQuantity(crubSaleInfoAndBookingInfoVO.getInitFloatQuantity());
            w_productMappingEntity.setCreatorID(loginID);
            w_productMappingEntity.setCreateTime(LocalDateTime.now());
            w_productMappingDao.insertSelective(w_productMappingEntity);
            //插入历史记录
            map.put("initQuantity", initQuantity);
            map.put("initFloatQuantity", initFloatQuantity);
            map.put("changeType", MerchantManageEnum.CurbSaleChangeType.ADDRECORD.getValue());
            insertProductMappingDealInfo(new W_ProductMappingEntity(), w_productMappingEntity, map);
        }

    }

    /**
     * 校验输入数量是否合法，返回值代表是否可以插入数据
     *
     * @param initQuantity
     * @param initFloatQuantity
     * @param bookingSum
     * @param needWeigh
     * @return
     */
    private boolean checkQuantityIsLegal(Integer initQuantity, Float initFloatQuantity, Integer bookingSum, boolean needWeigh) {
        boolean isNeedInsert = false;  //是否需要插入新的数据
        if (needWeigh) {
            if (initFloatQuantity != null) {
                isNeedInsert = true;
                //校验新增数据的合法性
                if (initFloatQuantity <= 0) {
                    throw new BizException(CodeMsgConstants.CURBSALE_NOT_LESS_THEN_ZERO, CodeMsgConstants.CURBSALE_NOT_LESS_THEN_ZERO_MSG);
                }
                if (initFloatQuantity < bookingSum) {
                    throw new BizException(CodeMsgConstants.CURBSALE_NOT_LESS_THEN_BOOKING, CodeMsgConstants.CURBSALE_NOT_LESS_THEN_BOOKING_MSG);
                }
            }
        } else {
            if (initQuantity != null) {
                isNeedInsert = true;
                if (initQuantity <= 0) {
                    throw new BizException(CodeMsgConstants.CURBSALE_NOT_LESS_THEN_ZERO, CodeMsgConstants.CURBSALE_NOT_LESS_THEN_ZERO_MSG);
                }
                if (initQuantity < bookingSum) {
                    throw new BizException(CodeMsgConstants.CURBSALE_NOT_LESS_THEN_BOOKING, CodeMsgConstants.CURBSALE_NOT_LESS_THEN_BOOKING_MSG);
                }
            }
        }
        return isNeedInsert;
    }

    /**
     * @param
     * @return
     * @Description： 更新ProductMapping的数量根据是否需要称重
     * @Author：chenkangyi
     * @Time: 2017-5-13 15:15
     * @Version 2.0.0
     */

    public void updateProductMappingAccNeedWeigh(CrubSaleInfoAndBookingInfoVO crubSaleInfoAndBookingInfoVO, boolean needWeigh, Map<String, Object> map) {
        //boolean needWeigh = crubSaleInfoAndBookingInfoVO.isNeedWeigh();
        //沽清数量不能小于预定数量，必须大于0
        Integer bookingSum = crubSaleInfoAndBookingInfoVO.getBookingSum();
        W_ProductMappingEntity w_productMappingEntity = w_productMappingDao.selectByPrimaryKey(crubSaleInfoAndBookingInfoVO.getMappingID());
        Integer initQuantity = w_productMappingEntity.getInitQuantity();
        Float initFloatQuantity = w_productMappingEntity.getInitFloatQuantity();
        checkQuantityIsLegal(initQuantity, initFloatQuantity, bookingSum, needWeigh);
        if (!needWeigh) {  //不需要称重
            if (initQuantity != null && !initQuantity.equals(crubSaleInfoAndBookingInfoVO.getInitQuantity())) {
                W_ProductMappingEntity w_productMappingEntityUpdate = new W_ProductMappingEntity();
                BeanUtils.copyProperties(w_productMappingEntity, w_productMappingEntityUpdate);
                w_productMappingEntityUpdate.setInitQuantity(crubSaleInfoAndBookingInfoVO.getInitQuantity());
                w_productMappingEntityUpdate.setAvailableQuantity(crubSaleInfoAndBookingInfoVO.getInitQuantity());
                w_productMappingEntityUpdate.setRemainingQuantity(crubSaleInfoAndBookingInfoVO.getInitQuantity());
                w_productMappingDao.updateByPrimaryKeySelective(w_productMappingEntityUpdate);
                //插入历史记录
                W_ProductMappingEntity w_productMappingEntityAfter = w_productMappingDao.selectByPrimaryKey(crubSaleInfoAndBookingInfoVO.getMappingID());
                map.put("initQuantity", (w_productMappingEntityAfter.getInitQuantity() == null ? 0 : w_productMappingEntityAfter.getInitQuantity()) - initQuantity);
                map.put("initFloatQuantity", null);
                map.put("changeType", MerchantManageEnum.CurbSaleChangeType.MODIFYRECORD.getValue());
                insertProductMappingDealInfo(w_productMappingEntity, w_productMappingEntityAfter, map);
            }
        } else {          //需要称重
            if (initFloatQuantity != null && !initFloatQuantity.equals(crubSaleInfoAndBookingInfoVO.getInitFloatQuantity())) {
                W_ProductMappingEntity w_productMappingEntityUpdate = new W_ProductMappingEntity();
                BeanUtils.copyProperties(w_productMappingEntity, w_productMappingEntityUpdate);
                w_productMappingEntityUpdate.setInitFloatQuantity(crubSaleInfoAndBookingInfoVO.getInitFloatQuantity());
                w_productMappingEntityUpdate.setAvailableFloatQuantity(crubSaleInfoAndBookingInfoVO.getInitFloatQuantity());
                w_productMappingEntityUpdate.setRemainingFloatQuantity(crubSaleInfoAndBookingInfoVO.getInitFloatQuantity());
                w_productMappingDao.updateByPrimaryKeySelective(w_productMappingEntityUpdate);

                //插入历史记录
                W_ProductMappingEntity w_productMappingEntityAfter = w_productMappingDao.selectByPrimaryKey(crubSaleInfoAndBookingInfoVO.getMappingID());
                map.put("initQuantity", null);
                map.put("initFloatQuantity", (w_productMappingEntityAfter.getInitFloatQuantity() == null ? 0 : w_productMappingEntityAfter.getInitFloatQuantity()) - initFloatQuantity);
                map.put("changeType", MerchantManageEnum.CurbSaleChangeType.MODIFYRECORD.getValue());
                insertProductMappingDealInfo(w_productMappingEntity, w_productMappingEntityAfter, map);
            }

        }
    }

    private boolean getNeedWeigh(Map<String, Object> paraMap) {
        Object obj = paraMap.get(CurbSaleParam.NEEDWEIGH);
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    private boolean getNeedWeigh(CurbSaleInfoVO vo) {
        Boolean needWeigh = vo.getNeedWeigh();
        if (needWeigh != null) {
            return needWeigh.booleanValue();
        }
        return false;
    }

    public ResultData curbSaleOperation(Map<String, Object> paraMap) throws BizException {
        ResultData resultData = new ResultData();
        //校验数据是否存在
        W_ProductMappingEntity w_productMappingEntity = w_productMappingDao
                .selectByPrimaryKey((Long) paraMap.get("mappingID"));
        if (w_productMappingEntity == null) {
            throw new BizException(CodeMsgConstants.NODATA, CodeMsgConstants.NODATA_MSG);
        }
        Integer changeInitQuantity = null;
        Float changeInitFloatQuantity = null;
        boolean needWeigh = getNeedWeigh(paraMap);
        String quantity = (String) paraMap.get("quantity");
        Long changeType = (Long) paraMap.get(CurbSaleParam.CHANGETYPE);
        if (!needWeigh) {
            changeInitQuantity = getInteger(quantity);
            if (changeInitQuantity != null) {
                paraMap.put("intQuantity", changeInitQuantity);
            }
        } else {
            changeInitFloatQuantity = getFloat(quantity);
            if (changeInitFloatQuantity != null) {
                paraMap.put("floatQuantity", changeInitFloatQuantity);
            }
        }

        int opeType = changeType.intValue();
        //1-增加  2-减少  3-报损  4-沽清  5-删除
        switch (opeType) {
            case 1:
                paraMap.put(CurbSaleParam.CHANGETYPE, MerchantManageEnum.CurbSaleChangeType.ADDCOUNT.getValue());
                processIncrease(w_productMappingEntity, paraMap);
                break;
            case 2:
                paraMap.put(CurbSaleParam.CHANGETYPE, MerchantManageEnum.CurbSaleChangeType.REMOVECOUNT.getValue());
                processReduce(w_productMappingEntity, paraMap);
                break;
            case 3:
                paraMap.put(CurbSaleParam.CHANGETYPE, MerchantManageEnum.CurbSaleChangeType.MAKINGNEWSPAPERLOSS.getValue());
                processBreakage(w_productMappingEntity, paraMap);
                break;
            case 4:
                paraMap.put(CurbSaleParam.CHANGETYPE, MerchantManageEnum.CurbSaleChangeType.MANUALSELLING.getValue());
                processCurbSale(w_productMappingEntity, paraMap);
                break;
            default:
                resultData.setCode(CodeMsgConstants.FAIL);
                resultData.setMessage(CodeMsgConstants.FAIL_MSG);
                return resultData;
        }

        resultData.setCode(CodeMsgConstants.SUCCESS);
        resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
        return resultData;
    }

    /**
     * 处理增加沽清数量
     */
    @Transactional(rollbackFor = Exception.class)
    private void processIncrease(W_ProductMappingEntity dbEntity, Map<String, Object> map) {
        W_ProductMappingEntity w_productMappingEntityBefore = new W_ProductMappingEntity();
        BeanUtils.copyProperties(dbEntity, w_productMappingEntityBefore);

        boolean needWeigh = getNeedWeigh(map);
        if (needWeigh) {
            Float floatQuantity = (Float) map.get("floatQuantity");
            dbEntity.setChangeInitFloatQuantity(CurbSaleUtils.sum(dbEntity.getChangeInitFloatQuantity(), floatQuantity));
            dbEntity.setRemainingFloatQuantity(CurbSaleUtils.sum(dbEntity.getRemainingFloatQuantity(), floatQuantity));
            dbEntity.setAvailableFloatQuantity(CurbSaleUtils.sum(dbEntity.getAvailableFloatQuantity(), floatQuantity));
        } else {
            Integer intQuantity = (Integer) map.get("intQuantity");
            dbEntity.setChangeInitQuantity(CurbSaleUtils.sum(dbEntity.getChangeInitQuantity(), intQuantity));
            dbEntity.setRemainingQuantity(CurbSaleUtils.sum(dbEntity.getRemainingQuantity(), intQuantity));
            dbEntity.setAvailableQuantity(CurbSaleUtils.sum(dbEntity.getAvailableQuantity(), intQuantity));
        }
        w_productMappingDao.updateByPrimaryKeySelective(dbEntity);
        insertDealInfo(w_productMappingEntityBefore, dbEntity, map);
    }

    /**
     * 处理减少沽清数量
     */
    @Transactional(rollbackFor = Exception.class)
    private void processReduce(W_ProductMappingEntity dbEntity, Map<String, Object> map) {
        checkLossQuantity(dbEntity, map);
        W_ProductMappingEntity w_productMappingEntityBefore = new W_ProductMappingEntity();
        BeanUtils.copyProperties(dbEntity, w_productMappingEntityBefore);

        boolean needWeigh = getNeedWeigh(map);
        if (needWeigh) {
            Float floatQuantity = (Float) map.get("floatQuantity");
            dbEntity.setChangeInitFloatQuantity(CurbSaleUtils.diff(dbEntity.getChangeInitFloatQuantity(), floatQuantity));
            dbEntity.setRemainingFloatQuantity(CurbSaleUtils.diff(dbEntity.getRemainingFloatQuantity(), floatQuantity));
            dbEntity.setAvailableFloatQuantity(CurbSaleUtils.diff(dbEntity.getAvailableFloatQuantity(), floatQuantity));
        } else {
            Integer intQuantity = (Integer) map.get("intQuantity");
            dbEntity.setChangeInitQuantity(CurbSaleUtils.diff(dbEntity.getChangeInitQuantity(), intQuantity));
            dbEntity.setRemainingQuantity(CurbSaleUtils.diff(dbEntity.getRemainingQuantity(), intQuantity));
            dbEntity.setAvailableQuantity(CurbSaleUtils.diff(dbEntity.getAvailableQuantity(), intQuantity));
        }
        w_productMappingDao.updateByPrimaryKeySelective(dbEntity);
        insertDealInfo(w_productMappingEntityBefore, dbEntity, map);
    }

    private void insertDealInfo(W_ProductMappingEntity beforeMappingEntity, W_ProductMappingEntity afterMappingEntity,
                                Map<String, Object> map) {
        W_ProductMappingDealInfoEntity dealInfoEntity = new W_ProductMappingDealInfoEntity();
        dealInfoEntity.setDealID(MaxIDUtils.getID(W_ProductMappingDealInfoEntity.class));
        dealInfoEntity.setMappingID(beforeMappingEntity.getMappingID());
        dealInfoEntity.setBeforRemainingQuantity(beforeMappingEntity.getRemainingQuantity());
        dealInfoEntity.setBeforRemainingFloatQuantity(beforeMappingEntity.getRemainingFloatQuantity());
        dealInfoEntity.setAfterRemainingQuantity(afterMappingEntity.getRemainingQuantity());
        dealInfoEntity.setAfterRemainingFloatQuantity(afterMappingEntity.getRemainingFloatQuantity());
        dealInfoEntity.setBeforeAvailableQuantity(beforeMappingEntity.getAvailableQuantity());
        dealInfoEntity.setBeforeAvailableFloatQuantity(beforeMappingEntity.getAvailableFloatQuantity());
        dealInfoEntity.setAfterAvailableQuantity(afterMappingEntity.getAvailableQuantity());
        dealInfoEntity.setAfterAvailableFloatQuantity(afterMappingEntity.getAvailableFloatQuantity());
        dealInfoEntity.setBeforeLockQuantity(beforeMappingEntity.getLockQuantity());
        dealInfoEntity.setBeforeLockFloatQuantity(beforeMappingEntity.getLockFloatQuantity());
        dealInfoEntity.setAfterLockQuantity(afterMappingEntity.getLockQuantity());
        dealInfoEntity.setAfterLockFloatQuantity(afterMappingEntity.getLockFloatQuantity());
        dealInfoEntity.setChangeQuantity((Integer) map.get("intQuantity"));
        dealInfoEntity.setChangeFloatQuantity((Float) map.get("floatQuantity"));
        dealInfoEntity.setChangeType((Long) map.get(CurbSaleParam.CHANGETYPE));
        dealInfoEntity.setChangeReason((String) map.get("changeReason"));
        dealInfoEntity.setCreatorID((map.get("authorizerID") != null) ?
                (Long) map.get("authorizerID") : (Long) map.get(CurbSaleParam.LOGINID));
        dealInfoEntity.setCreateTime(LocalDateTime.now());

        w_productMappingDealInfoDao.insertSelective(dealInfoEntity);
    }

    /**
     * 处理 制作报损
     */
    @Transactional(rollbackFor = Exception.class)
    private void processBreakage(W_ProductMappingEntity dbEntity, Map<String, Object> map) throws BizException {
        checkLossQuantity(dbEntity, map);
        W_ProductMappingEntity w_productMappingEntityBefore = new W_ProductMappingEntity();
        BeanUtils.copyProperties(dbEntity, w_productMappingEntityBefore);

        boolean needWeigh = getNeedWeigh(map);
        if (needWeigh) {
            Float floatQuantity = (Float) map.get("floatQuantity");
            dbEntity.setLossFloatQuantity(CurbSaleUtils.sum(dbEntity.getLossFloatQuantity(), floatQuantity));
            dbEntity.setRemainingFloatQuantity(CurbSaleUtils.diff(dbEntity.getRemainingFloatQuantity(), floatQuantity));
            dbEntity.setAvailableFloatQuantity(CurbSaleUtils.diff(dbEntity.getAvailableFloatQuantity(), floatQuantity));
        } else {
            Integer intQuantity = (Integer) map.get("intQuantity");
            dbEntity.setLossQuantity(CurbSaleUtils.sum(dbEntity.getLossQuantity(), intQuantity));
            dbEntity.setRemainingQuantity(CurbSaleUtils.diff(dbEntity.getRemainingQuantity(), intQuantity));
            dbEntity.setAvailableQuantity(CurbSaleUtils.diff(dbEntity.getAvailableQuantity(), intQuantity));
        }
        w_productMappingDao.updateByPrimaryKeySelective(dbEntity);
        insertDealInfo(w_productMappingEntityBefore, dbEntity, map);
    }

    private void checkLossQuantity(W_ProductMappingEntity beforeMappingEntity, Map<String, Object> map) throws BizException {
        Integer lossQuantity = (Integer) map.get("intQuantity");
        Float lossFloatQuantity = (Float) map.get("floatQuantity");
        boolean needWeigh = getNeedWeigh(map);
        if (needWeigh) {
            if (lossFloatQuantity == null) {
                throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
            }
            Float availableFloatQuantity = beforeMappingEntity.getAvailableFloatQuantity();
            if (availableFloatQuantity != null && availableFloatQuantity.compareTo(lossFloatQuantity) < 0) {
                throw new BizException(CodeMsgConstants.CURBSALE_NOT_LOSS_TO_ZERO,
                        CodeMsgConstants.CURBSALE_NOT_LOSS_TO_ZERO_MSG,
                        String.valueOf(availableFloatQuantity.floatValue()));
            }
        } else {
            if (lossQuantity == null) {
                throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
            }
            Integer availableQuantity = beforeMappingEntity.getAvailableQuantity();
            if (availableQuantity != null && (availableQuantity.compareTo(lossQuantity) < 0)) {
                throw new BizException(CodeMsgConstants.CURBSALE_NOT_LOSS_TO_ZERO,
                        CodeMsgConstants.CURBSALE_NOT_LOSS_TO_ZERO_MSG,
                        String.valueOf(availableQuantity.intValue()));
            }
        }
    }

    /**
     * 沽清
     */
    @Transactional(rollbackFor = Exception.class)
    public void processCurbSale(W_ProductMappingEntity dbEntity, Map<String, Object> map)
            throws BizException {
        W_ProductMappingEntity w_productMappingEntityBefore = new W_ProductMappingEntity();
        BeanUtils.copyProperties(dbEntity, w_productMappingEntityBefore);

        boolean needWeigh = getNeedWeigh(map);
        if (needWeigh) {
            Float remaining = dbEntity.getRemainingFloatQuantity();
            //沽清时，剩余量直接减为0
            map.put("floatQuantity", remaining);
            dbEntity.setChangeInitFloatQuantity(CurbSaleUtils.diff(dbEntity.getChangeInitFloatQuantity(), remaining));
            dbEntity.setRemainingFloatQuantity(0.00f);
            dbEntity.setAvailableFloatQuantity(0.00f);
            dbEntity.setLockFloatQuantity(0.00f);
        } else {
            Integer remaining = dbEntity.getRemainingQuantity();
            map.put("intQuantity", remaining);
            dbEntity.setChangeInitQuantity(CurbSaleUtils.diff(dbEntity.getChangeInitQuantity(), remaining));
            dbEntity.setRemainingQuantity(0);
            dbEntity.setAvailableQuantity(0);
            dbEntity.setLockQuantity(0);
        }
        w_productMappingDao.updateByPrimaryKeySelective(dbEntity);
        insertDealInfo(w_productMappingEntityBefore, dbEntity, map);
    }

    /**
     * 启动前沽清操作
     * chenkangyi
     * 2017-5-18 15:31
     *
     * @param map
     * @return
     * @throws Exception
     */
    public ResultData curbSaleOperationBeforeStartUp(Map<String, Object> map) throws Exception {
        ResultData resultData = new ResultData();
        //校验数据是否存在
        Long mappingID = (Long) map.get("mappingID");
//        Long  loginID = (Long) map.get("loginID");
//        boolean needWeigh = (boolean) map.get("needWeigh");
//        String quantity = (String) map.get("quantity");
//        Long changeType = (Long) map.get("changeType");
//        if (changeType==null || mappingID==null || loginID==null){
//            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
//        }
//        if (changeType==11L){
//            if (quantity=="" || quantity==null){
//                throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
//            }
//        }
        W_ProductMappingEntity w_productMappingEntity = w_productMappingDao.selectByPrimaryKey(mappingID);
        if (w_productMappingEntity == null) {
            throw new BizException(CodeMsgConstants.NODATA, CodeMsgConstants.NODATA_MSG);
        }
//        Integer changeInitQuantity = null;
//        Float changeInitFloatQuantity = null;
//        if (!needWeigh){
//            changeInitQuantity = getInteger(quantity);
//            if (changeInitQuantity != null) {
//                map.put("initQuantity", changeInitQuantity);
//            }
//        }else {
//            changeInitFloatQuantity = getFloat(quantity);
//            if (changeInitFloatQuantity != null) {
//                map.put("initFloatQuantity", changeInitFloatQuantity);
//            }
//        }
//        switch (changeType.intValue()){
//            case 11:  //修改
//                processModifyBeforeStartUp(w_productMappingEntity,map);
//                break;
//            case 12:  //删除
//                processDeleteBeforeStartUp(w_productMappingEntity,map);
//                break;
//            default:
//                resultData.setCode(CodeMsgConstants.FAIL);
//                resultData.setMessage(CodeMsgConstants.FAIL_MSG);
//                return resultData;
//        }
        processDeleteBeforeStartUp(w_productMappingEntity, map);
        resultData.setCode(CodeMsgConstants.SUCCESS);
        resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
        return resultData;

    }

    /**
     * 启动前修改删除沽清
     *
     * @param w_productMappingEntity
     */
    @Transactional(rollbackFor = Exception.class)
    private void processDeleteBeforeStartUp(W_ProductMappingEntity w_productMappingEntity, Map<String, Object> map) {
        w_productMappingDao.deleteByPrimaryKey(w_productMappingEntity.getMappingID());
        //insertProductMappingDealInfo(w_productMappingEntity,new W_ProductMappingEntity(),map);
        //启动前删除沽清，需要把ProductMappingDealInfo对应的mappingID的记录删除
        w_productMappingDealInfoDao.deleteByMappingID(w_productMappingEntity.getMappingID());

    }

//    /**
//     * 启动前修改沽清数量
//     * @param w_productMappingEntity
//     * @param map
//     */
//    @Transactional(rollbackFor = Exception.class)
//    private void processModifyBeforeStartUp(W_ProductMappingEntity w_productMappingEntity, Map<String, Object> map) {
//        W_ProductMappingEntity w_productMappingEntityBefore = new W_ProductMappingEntity();
//        BeanUtils.copyProperties(w_productMappingEntity,w_productMappingEntityBefore);
//        Integer initQuantity = (Integer) map.get("initQuantity");
//        Float initFloatQuantity = (Float) map.get("initFloatQuantity");
//        boolean needWeigh = (boolean) map.get("needWeigh");
//        checkCurbSaleNumLegal(map,initQuantity,initFloatQuantity,needWeigh);
//        if (needWeigh) {
//            w_productMappingEntity.setInitFloatQuantity(initFloatQuantity);
//            w_productMappingEntity.setAvailableFloatQuantity(initFloatQuantity);
//            w_productMappingEntity.setRemainingFloatQuantity(initFloatQuantity);
//        }else {
//            w_productMappingEntity.setInitQuantity(initQuantity);
//            w_productMappingEntity.setAvailableQuantity(initQuantity);
//            w_productMappingEntity.setRemainingQuantity(initQuantity);
//        }
//        w_productMappingDao.updateByPrimaryKeySelective(w_productMappingEntity);
//        insertProductMappingDealInfo(w_productMappingEntityBefore,w_productMappingEntity,map);
//    }

    /**
     * 校验沽清数量的合法性
     *
     * @param map
     */
    private void checkCurbSaleNumLegal(Map<String, Object> map, Integer intQuantity, Float floatQuantity, boolean needWeigh) {
        int bookingSum = (int) map.get("bookingSum");
        if (needWeigh) {
            if (floatQuantity <= 0) {
                throw new BizException(CodeMsgConstants.CURBSALE_NOT_LESS_THEN_ZERO,
                        CodeMsgConstants.CURBSALE_NOT_LESS_THEN_ZERO_MSG);
            }
            if (floatQuantity == null || floatQuantity - bookingSum < 0) {
                throw new BizException(CodeMsgConstants.CURBSALE_NOT_LESS_THEN_BOOKING,
                        CodeMsgConstants.CURBSALE_NOT_LESS_THEN_BOOKING_MSG);
            }
        } else {
            if (intQuantity <= 0) {
                throw new BizException(CodeMsgConstants.CURBSALE_NOT_LESS_THEN_ZERO,
                        CodeMsgConstants.CURBSALE_NOT_LESS_THEN_ZERO_MSG);
            }
            if (intQuantity == null || intQuantity - bookingSum < 0) {
                throw new BizException(CodeMsgConstants.CURBSALE_NOT_LESS_THEN_BOOKING,
                        CodeMsgConstants.CURBSALE_NOT_LESS_THEN_BOOKING_MSG);
            }
        }
    }

    private Integer getInteger(String quantity) {
        try {
            return Integer.valueOf(quantity);
        } catch (Exception e) {
            return null;
        }
    }

    private Float getFloat(String quantity) {
        try {
            return Float.parseFloat(quantity);
        } catch (Exception e) {
            return null;
        }
    }

    public List<CurbSaleInfoVO> getCurbSaleList(Map<String, Object> map) throws Exception {
        String date = (String) map.get(CurbSaleParam.STOREDAY);
        List<CurbSaleInfoVO> curbSaleList = null;
        if (DateUtils.getCurrentDate().equals(date)) {
            //该计算结果不包含预定数量
            curbSaleList = w_productMappingDao.getCurbSaleDetailForToday(map);
        } else {
            curbSaleList = w_productHisMappingDao.selectHisCurbSaleDetail(map);
        }
        setPreOrderQuantity(curbSaleList, map);
        setOrderedQuantity(curbSaleList, map);
        return curbSaleList;
    }

    /**
     * 设置沽清列表的已点数量
     * 已点数量 = 沽清数量 - 剩余数量 - 报损量
     */
    private void setOrderedQuantity(List<CurbSaleInfoVO> voList, Map<String, Object> map) {
        try {
            if (voList != null && voList.size() > 0) {
                for (CurbSaleInfoVO vo : voList) {
                    if (getNeedWeigh(vo)) {
                        Float initFloatQuantity = vo.getInitFloatQuantity();
                        Float remainingFloatQuantity = vo.getRemainingFloatQuantity();
                        Float lossFloatQuantity = vo.getLossFloatQuantity();
                        Float diff = CurbSaleUtils.diff(initFloatQuantity, remainingFloatQuantity);
                        Float ordered =CurbSaleUtils.diff(diff, lossFloatQuantity);
                        vo.setOrderedFloatQuantity(ordered);
                    } else {
                        Integer initQuantity = vo.getInitQuantity();
                        Integer remainingQuantity = vo.getRemainingQuantity();
                        Integer lossQuantity = vo.getLossQuantity();
                        Integer diff = CurbSaleUtils.diff(initQuantity, remainingQuantity);
                        Integer ordered =CurbSaleUtils.diff(diff, lossQuantity);
                        vo.setOrderedQuantity(ordered);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 设置沽清列表的预订数量
     */
    private void setPreOrderQuantity(List<CurbSaleInfoVO> voList, Map<String, Object> map) {
        try {
            if (voList != null && voList.size() > 0) {
                for (CurbSaleInfoVO vo : voList) {
                    //初始化预订数量
                    if (vo.getNeedWeigh()) {
                        vo.setPreOrderFloatQuantity(0.00f);
                    } else {
                        vo.setPreOrderQuantity(0);
                    }

                    Long menuID = vo.getMenuID();
                    //根据 菜单ID、预订信息表及订单明细表 计算本日预订数量
                    Map<String, Object> temp = new HashedMap();
                    temp.put(CurbSaleParam.PARAM_ARCHIVE_ID, map.get(CurbSaleParam.PARAM_ARCHIVE_ID));
                    temp.put("menuID", menuID);
                    temp.put(CurbSaleParam.STOREDAY, map.get(CurbSaleParam.STOREDAY));
                    temp.put("bookingStatus", Long.valueOf(618));
                    List<O_OrderDetailInfoEntity> detailList = o_orderDetailInfoDao.getOrderDetailInfoByMenuID(temp);
                    setPreOrderQuantity(vo, detailList);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setPreOrderQuantity(CurbSaleInfoVO vo, List<O_OrderDetailInfoEntity> detailList) {
        if (detailList != null && detailList.size() > 0) {
            int quantity = 0;
            float floatQuantity = 0.00f;
            Boolean needWeigh = (vo.getNeedWeigh() == null) ? Boolean.FALSE : vo.getNeedWeigh();
            for (O_OrderDetailInfoEntity entity : detailList) {
                if (needWeigh.booleanValue()) {
                    Float tempFloatQuantity = entity.getFloatQuantity();
                    if (tempFloatQuantity != null) {
                        floatQuantity = floatQuantity + tempFloatQuantity.floatValue();
                    }
                } else {
                    Integer tempQuantity = entity.getQuantity();
                    if (tempQuantity != null) {
                        quantity = quantity + tempQuantity.intValue();
                    }
                }
            }

            if (needWeigh.booleanValue()) {
                vo.setPreOrderFloatQuantity(floatQuantity);
            } else {
                vo.setPreOrderQuantity(quantity);
            }
        }
    }

    /**
     * 导入沽清列表
     *
     * @param map
     * @return
     * @throws BizException
     */
    public ResultData importCurbSaleList(Map<String, Object> map) throws BizException {
        ResultData resultData = new ResultData();
        String storeDay = (String) map.get(CurbSaleParam.STOREDAY);
        if (DateUtils.getCurrentDate().equals(storeDay)) {
            throw new BizException("请选择今天以前的日期");
        }
        Long importType = (Long) map.get("importType");
        //1-全部导入 2-追加导入
        if (importType == null || (importType.intValue() != 1 && importType.intValue() != 2)) {
            throw new BizException("导入类型非法");
        }

        List<CurbSaleInfoVO> hisMappingEntityList = w_productHisMappingDao.selectHisCurbSaleDetail(map);
        if (hisMappingEntityList == null || hisMappingEntityList.size() == 0) {
            throw new BizException("没有待导入的数据");
        }

        processImport(hisMappingEntityList, importType, map);

        resultData.setCode(CodeMsgConstants.SUCCESS);
        resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
        return resultData;
    }

    @Transactional(rollbackFor = Exception.class)
    private void processImport(List<CurbSaleInfoVO> hisMappingList, Long importType, Map<String, Object> map) {
        //查询当天的沽清列表
        List<CurbSaleInfoVO> todayMappingList = w_productMappingDao.getCurbSaleDetailForToday(map);

        Map<String, List<W_ProductMappingEntity>> importDataMap = calcImportData(hisMappingList, todayMappingList, map);
        List<W_ProductMappingEntity> addList = importDataMap.get("ADD");
        //全部导入
        if (importType.intValue() == 1) {
            for (W_ProductMappingEntity addEntity : addList) {
                addEntity.setMappingID(MaxIDUtils.getID(W_ProductMappingEntity.class));
                w_productMappingDao.insertSelective(addEntity);
            }

            List<W_ProductMappingEntity> modifyList = importDataMap.get("MODIFY");
            for (W_ProductMappingEntity modifyEntity : modifyList) {
                w_productMappingDao.updateByPrimaryKeySelective(modifyEntity);
            }
        } else if (importType.intValue() == 2) {
            for (W_ProductMappingEntity addEntity : addList) {
                addEntity.setMappingID(MaxIDUtils.getID(W_ProductMappingEntity.class));
                w_productMappingDao.insertSelective(addEntity);
            }
        }
    }

    /**
     * 计算待导入的沽清列表,key有两种ADD, MODIFY(有否枚举定义？)
     */
    private Map<String, List<W_ProductMappingEntity>> calcImportData(List<CurbSaleInfoVO> hisMappingList,
                                                                     List<CurbSaleInfoVO> todayMappingList, Map<String, Object> map) {
        Map<String, List<W_ProductMappingEntity>> dataMap = new HashMap<>();
        //待导入的列表
        List<W_ProductMappingEntity> toAddedList = new ArrayList<>();
        List<W_ProductMappingEntity> toModifiedList = new ArrayList<>();
        dataMap.put("ADD", toAddedList);
        dataMap.put("MODIFY", toModifiedList);

        Long loginID = (Long) map.get(CurbSaleParam.LOGINID);
        if (todayMappingList == null || todayMappingList.isEmpty()) {
            for (CurbSaleInfoVO curbSaleInfoVO : hisMappingList) {
                toAddedList.add(convertEntity(curbSaleInfoVO, null, loginID));
            }
        } else {
            for (CurbSaleInfoVO curbSaleInfoVO : hisMappingList) {
                CurbSaleInfoVO existVO = isExist(todayMappingList, curbSaleInfoVO);
                //新增记录
                if (existVO == null) {
                    toAddedList.add(convertEntity(curbSaleInfoVO, null, loginID));
                }
                //修改记录，并且替换掉沽清数量
                else {
                    existVO.setInitQuantity(curbSaleInfoVO.getInitQuantity());
                    existVO.setInitFloatQuantity(curbSaleInfoVO.getInitFloatQuantity());
                    toModifiedList.add(convertEntity(existVO, existVO.getMappingID(), loginID));
                }
            }
        }
        return dataMap;
    }

    private W_ProductMappingEntity isExist(List<W_ProductMappingEntity> todayMappingList, Long hisProductID,
                                           Long hisVariantID, Long hisOptionID) {
        if (todayMappingList == null) return null;
        Long productID = null;
        Long variantID = null;
        Long optionID = null;
        for (W_ProductMappingEntity entity : todayMappingList) {
            productID = entity.getProductID();
            variantID = entity.getVariantID();
            optionID = entity.getOptionID();
            //套餐变体id为null,可以有规格；
            if (hisVariantID == null) {
                if (isEquals(hisProductID, productID) && isEquals(hisOptionID, optionID)) {
                    return entity;
                }
            } else { //变体id不为null,说明不是套餐
                if (isEquals(hisVariantID, variantID) && isEquals(hisOptionID, optionID)) {
                    return entity;
                }
            }
        }
        return null;
    }

    /**
     * 是否存在相同的沽清商品
     *
     * @param todayMappingList
     * @param hisEntity        待导入的沽清商品
     * @return
     */
    private CurbSaleInfoVO isExist(List<CurbSaleInfoVO> todayMappingList,
                                   CurbSaleInfoVO hisEntity) {
        if (todayMappingList == null) return null;
        Long hisProductID = hisEntity.getProductID();
        Long hisVariantID = hisEntity.getVariantID();
        Long hisOptionID = hisEntity.getOptionID();
        Long productID = null;
        Long variantID = null;
        Long optionID = null;

        for (CurbSaleInfoVO entity : todayMappingList) {
            productID = entity.getProductID();
            variantID = entity.getVariantID();
            optionID = entity.getOptionID();

            if (isEquals(hisProductID, productID) && isEquals(hisVariantID, variantID) && isEquals(hisOptionID, optionID)) {
                return entity;
            }
//            //套餐变体id为null,可以有规格；
//            if (hisVariantID == null) {
//                if(isEquals(hisProductID, productID) && isEquals(hisOptionID, optionID)) {
//                    return entity;
//                }
//            }
//            else { //变体id不为null,说明不是套餐
//                if (isEquals(hisVariantID, variantID) && isEquals(hisOptionID, optionID)) {
//                    return entity;
//                }
//            }
        }
        return null;
    }

    private boolean isEquals(Long var1, Long var2) {
        if (var1 == null) {
            return (var2 == null) ? true : var2.equals(var1);
        } else {
            return var1.equals(var2);
        }
    }

    /**
     * 将 商品配置历史信息实体 转换为 商品配置信息实体
     */
    private W_ProductMappingEntity convertEntity(CurbSaleInfoVO curbSaleVO, Long mappingID, Long creatorID) {
        W_ProductMappingEntity newEntity = new W_ProductMappingEntity();
        if (mappingID != null) {
            newEntity.setMappingID(mappingID);
        }
        newEntity.setProductID(curbSaleVO.getProductID());
        newEntity.setVariantID(curbSaleVO.getVariantID());
        newEntity.setShelfID(curbSaleVO.getShelfID());
        newEntity.setContainerID(curbSaleVO.getContainerID());
        newEntity.setWarehouseID(curbSaleVO.getWarehouseID());
        newEntity.setReceiptID(curbSaleVO.getReceiptID());
        newEntity.setOptionID(curbSaleVO.getOptionID());
        newEntity.setUnitID(curbSaleVO.getUnitID());
        newEntity.setConfigReason(curbSaleVO.getConfigReason());
        newEntity.setIsTotal(curbSaleVO.getTotal());
        newEntity.setInitQuantity(curbSaleVO.getInitQuantity()); //初始数量
        newEntity.setInitFloatQuantity(curbSaleVO.getInitFloatQuantity()); //小数数量
        //调整数量、锁定数量、损耗数量、可用数量不导入
        newEntity.setRemainingQuantity(curbSaleVO.getInitQuantity()); //剩余数量 = 初始数量
        newEntity.setRemainingFloatQuantity(curbSaleVO.getRemainingFloatQuantity());
        newEntity.setAvailableQuantity(curbSaleVO.getInitQuantity()); //可用数量 = 初始数量
        newEntity.setAvailableFloatQuantity(curbSaleVO.getInitFloatQuantity());
        newEntity.setIsSync(false);
        newEntity.setCreatorID(creatorID);
        newEntity.setCreateTime(LocalDateTime.now());
        newEntity.setMemo(curbSaleVO.getMemo());
        return newEntity;
    }

    /**
     * 操作沽清时插入W_ProductMappingDealInfo记录操作沽清记录
     */
    private void insertProductMappingDealInfo(W_ProductMappingEntity beforeMappingEntity, W_ProductMappingEntity afterMappingEntity,
                                              Map<String, Object> map) {
        Integer initQuantity = (Integer) map.get("initQuantity");
        Float initFloatQuantity = (Float) map.get("initFloatQuantity");
        Long changeType = (Long) map.get("changeType");  //10为沽清前新增，11位沽清前修改, 12位沽清前删除
        W_ProductMappingDealInfoEntity dealInfoEntity = new W_ProductMappingDealInfoEntity();
        dealInfoEntity.setDealID(MaxIDUtils.getID(W_ProductMappingDealInfoEntity.class));
        dealInfoEntity.setMappingID((changeType == MerchantManageEnum.CurbSaleChangeType.ADDRECORD.getValue()) ? afterMappingEntity.getMappingID() : beforeMappingEntity.getMappingID());
        dealInfoEntity.setBeforRemainingQuantity((changeType == MerchantManageEnum.CurbSaleChangeType.ADDRECORD.getValue()) ? null : beforeMappingEntity.getRemainingQuantity());
        dealInfoEntity.setBeforRemainingFloatQuantity((changeType == MerchantManageEnum.CurbSaleChangeType.ADDRECORD.getValue()) ? null : beforeMappingEntity.getRemainingFloatQuantity());
        dealInfoEntity.setAfterRemainingQuantity((changeType == MerchantManageEnum.CurbSaleChangeType.DELETERECORD.getValue()) ? null : afterMappingEntity.getRemainingQuantity());
        dealInfoEntity.setAfterRemainingFloatQuantity((changeType == MerchantManageEnum.CurbSaleChangeType.DELETERECORD.getValue()) ? null : afterMappingEntity.getRemainingFloatQuantity());
        dealInfoEntity.setBeforeAvailableQuantity((changeType == MerchantManageEnum.CurbSaleChangeType.ADDRECORD.getValue()) ? null : beforeMappingEntity.getAvailableQuantity());
        dealInfoEntity.setBeforeAvailableFloatQuantity((changeType == MerchantManageEnum.CurbSaleChangeType.ADDRECORD.getValue()) ? null : beforeMappingEntity.getAvailableFloatQuantity());
        dealInfoEntity.setAfterAvailableQuantity((changeType == MerchantManageEnum.CurbSaleChangeType.DELETERECORD.getValue()) ? null : afterMappingEntity.getAvailableQuantity());
        dealInfoEntity.setAfterAvailableFloatQuantity((changeType == MerchantManageEnum.CurbSaleChangeType.DELETERECORD.getValue()) ? null : afterMappingEntity.getAvailableFloatQuantity());
        dealInfoEntity.setBeforeLockQuantity((changeType == MerchantManageEnum.CurbSaleChangeType.ADDRECORD.getValue()) ? null : beforeMappingEntity.getLockQuantity());
        dealInfoEntity.setBeforeLockFloatQuantity((changeType == MerchantManageEnum.CurbSaleChangeType.ADDRECORD.getValue()) ? null : beforeMappingEntity.getLockFloatQuantity());
        dealInfoEntity.setAfterLockQuantity((changeType == MerchantManageEnum.CurbSaleChangeType.DELETERECORD.getValue()) ? null : afterMappingEntity.getLockQuantity());
        dealInfoEntity.setAfterLockFloatQuantity((changeType == MerchantManageEnum.CurbSaleChangeType.DELETERECORD.getValue()) ? null : afterMappingEntity.getLockFloatQuantity());
        dealInfoEntity.setChangeQuantity(initQuantity);
        dealInfoEntity.setChangeFloatQuantity(initFloatQuantity);
        dealInfoEntity.setChangeType(changeType);
        dealInfoEntity.setCreatorID(((Long) map.get("loginID")));
        dealInfoEntity.setCreateTime(LocalDateTime.now());

        w_productMappingDealInfoDao.insertSelective(dealInfoEntity);
    }

    private Map<String, Object> getMap(Long mappingID, boolean needWeigh, Float floatQuantity, Integer quantity) {
        Map<String, Object> map = new HashMap<>();
        map.put("mappingID", mappingID);
        if (needWeigh) {
            map.put(CurbSaleParam.NEEDWEIGH, needWeigh);
            map.put("quantity", floatQuantity);
        } else {
            map.put("quantity", quantity);
        }
        return map;
    }

    public ResultData shoppingCartOperation(Map<String, Object> map) throws BizException {
        ResultData resultData = new ResultData();
        Long operationType = (Long) map.get("operationType");
        Long productID = (Long) map.get("productID");
        Long variantID = (Long) map.get("variantID");
        Long optionID = (Long) map.get("optionID");
        boolean needWeigh = (boolean) map.get(CurbSaleParam.NEEDWEIGH);
        String quantity = (String) map.get("quantity");
        //1-添加购物车 2-从购物车移除
        if (operationType != null) {
            if (operationType.intValue() == 1) {
                addProductToShoppingCart(productID, variantID, optionID, needWeigh, quantity);
            } else if (operationType.intValue() == 2) {
                removeProductFromShoppingCart(productID, variantID, optionID, needWeigh, quantity);
            }
        }
        resultData.setCode(CodeMsgConstants.SUCCESS);
        resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
        return resultData;
    }

    //TODO
    @Transactional(rollbackFor = Exception.class)
    public void addProductToShoppingCart(Long productID, Long variantID, Long optionID, boolean needWeigh, String strQuantity)
            throws BizException {
        List<W_ProductMappingEntity> all = null;
//                w_productMappingDao.getAll(new HashMap<String, Object>());
        W_ProductMappingEntity w_productMappingEntity = isExist(all, productID, variantID, optionID);
        if (w_productMappingEntity != null) {
            //校验数量 可用数量 AvailableQuantity
            Integer quantity = null;
            Float floatQuantity = null;
            if (!needWeigh) {
                Integer availableQuantity = w_productMappingEntity.getAvailableQuantity();
                quantity = getInteger(strQuantity);
                if (availableQuantity == null || availableQuantity.compareTo(quantity) < 0) {
                    throw new BizException(CodeMsgConstants.CURBSALE_AVAILABLE_QUANTITY_NOT_ENOUGH,
                            CodeMsgConstants.CURBSALE_AVAILABLE_QUANTITY_NOT_ENOUGH_MSG);
                }
            } else {
                Float availableQuantity = w_productMappingEntity.getAvailableFloatQuantity();
                floatQuantity = getFloat(strQuantity);
                if (availableQuantity == null || availableQuantity.compareTo(floatQuantity) < 0) {
                    throw new BizException(CodeMsgConstants.CURBSALE_AVAILABLE_QUANTITY_NOT_ENOUGH,
                            CodeMsgConstants.CURBSALE_AVAILABLE_QUANTITY_NOT_ENOUGH_MSG);
                }
            }
            w_productMappingDao.updateForAddProductToShoppingCart(
                    getMap(w_productMappingEntity.getMappingID(), needWeigh, floatQuantity, quantity));
        }
    }

    //TODO
    @Transactional(rollbackFor = Exception.class)
    public void removeProductFromShoppingCart(Long productID, Long variantID, Long optionID, boolean needWeigh, String strQuantity) {
        List<W_ProductMappingEntity> all = null;
//                w_productMappingDao.getAll(new HashMap<String, Object>());
        W_ProductMappingEntity w_productMappingEntity = isExist(all, productID, variantID, optionID);
        if (w_productMappingEntity != null) {
            Float floatQuantity = null;
            Integer quantity = null;
            if (needWeigh) {
                floatQuantity = getFloat(strQuantity);
            } else {
                quantity = getInteger(strQuantity);
            }
            w_productMappingDao.updateForRemoveProductFromShoppingCart(getMap(w_productMappingEntity.getMappingID(),
                    needWeigh, floatQuantity, quantity));
        }
    }

    /**
     * 获取营业时间并判断是否到了营业时间
     */
    public boolean getMerchantOpenTime(Long archiveID) {
        B_BasicParamInfoEntity b_basicParamInfo = b_basicParamInfoDao.selectInfoByArchiveid(archiveID);
        if (b_basicParamInfo != null) {
            try {
                LocalDateTime openTime = b_basicParamInfo.getOpenTime();
                LocalTime localTimeSetting = openTime.toLocalTime();
                LocalTime localTimeNow = LocalTime.now();
                if (localTimeSetting == null || localTimeNow == null) {
                    throw new BizException(CodeMsgConstants.ERROR, CodeMsgConstants.ERROR_MSG);
                }
                if (localTimeNow.isAfter(localTimeSetting)) {  //当前时间到了营业时间
                    return true;
                }
            } catch (Exception e) {
                return false;
            }
        }

        return false;
    }

    public List<Map<String, Object>> queryOperationTypeList() {
        List<Map<String, Object>> catalogInfo = w_productMappingDao.queryOperationTypeList();
        return catalogInfo;
    }

    public List<Map<String, Object>> queryChangeReason(Map<String, Object> map) {
        String catalogCode = null;
        Long operationType = (Long) map.get("operationType");
        int changeType = (operationType == null) ? 0 : operationType.intValue();
        //1-增加  2-减少  3-报损  4-沽清  5-删除
        if (changeType == 1) {
            catalogCode = "AddCurbSaleNum";
        } else if (changeType == 2) {
            catalogCode = "ReduceCurbSaleNum";
        } else if (changeType == 3) {
            catalogCode = "Loss";
        } else if (changeType == 4) {
            catalogCode = "ManualCurbSale";
        } else if (changeType == 5) {
            catalogCode = "DeleteCurbSale";
        }
        map.put("catalogCode", catalogCode);

        List<Map<String, Object>> changeReasonList = w_productMappingDao.queryChangeReason(map);
        if (changeReasonList == null || changeReasonList.isEmpty()) {
            return w_productMappingDao.queryDefaultChangeReason(map);
        }
        return changeReasonList;
    }

    /**
     * 执行沽清任务
     */
    public void executeCurbSaleTask() {
        List<V_ProductMappingEntity> vProductmappings = v_productMappingDao.getAll();
        if (vProductmappings != null) {
            Map<Long, List<Long>> map = new HashMap<>();
            for (V_ProductMappingEntity vProductmapping : vProductmappings) {
                Long archiveid = vProductmapping.getArchiveID();
                Long mappingid = vProductmapping.getMappingID();
                List<Long> tempList = map.get(archiveid);
                if (tempList == null) {
                    tempList = new ArrayList<>();
                    tempList.add(mappingid);
                    map.put(archiveid, tempList);
                } else {
                    tempList.add(mappingid);
                }
            }

            //根据档案编号查询营业时间
            Set<Map.Entry<Long, List<Long>>> entries = map.entrySet();
            for (Map.Entry<Long, List<Long>> entry : entries) {
                Long archiveID = entry.getKey();
                logger.info("archiveID: " + archiveID);
                boolean isOutService = isOutOfBusinessTime(archiveID);
                if (isOutService) {
                    transferData(entry.getValue());
                }
            }
        }
    }

    @Transactional(rollbackFor = Exception.class)
    private void transferData(List<Long> mappingIDList) {
        logger.info("beginning transfer data. mappingIDList.size is: " + mappingIDList.size());
        for (Long mappingID : mappingIDList) {
            V_ProductMappingEntity vEntity = v_productMappingDao.selectByMappingID(mappingID);
            //校验是否已经生产了历史数据(MappingID要求唯一);  生成ID, 插入数据到历史表
            List<W_ProductHisMappingEntity> w_productHisMappingEntities = w_productHisMappingDao.selectByMappingID(vEntity.getMappingID());
            if (w_productHisMappingEntities == null || w_productHisMappingEntities.isEmpty()) {
                W_ProductHisMappingEntity hisEntity = convert(vEntity);
                hisEntity.setHisID(MaxIDUtils.getID(W_ProductHisMappingEntity.class));
                w_productHisMappingDao.insertSelective(hisEntity);

                //修改商品配置信息表
                W_ProductMappingEntity wProductmapping = w_productMappingDao.selectByPrimaryKey(vEntity.getMappingID());
                updateProductMappingInfo(wProductmapping);
            }
        }
        logger.info("beginning transfer data end.");
    }

    private void updateProductMappingInfo(W_ProductMappingEntity wProductmapping) {
        if (wProductmapping != null) {
            W_ProductMappingEntity newEntity = new W_ProductMappingEntity();
            BeanUtils.copyProperties(wProductmapping, newEntity);
            newEntity.setMappingID(MaxIDUtils.getID(W_ProductMappingEntity.class));
            newEntity.setChangeInitQuantity(null);
            newEntity.setChangeInitFloatQuantity(null);
            newEntity.setRemainingQuantity(newEntity.getInitQuantity());
            newEntity.setRemainingFloatQuantity(newEntity.getInitFloatQuantity());
            newEntity.setAvailableQuantity(newEntity.getInitQuantity());
            newEntity.setAvailableFloatQuantity(newEntity.getInitFloatQuantity());
            newEntity.setLockQuantity(null);
            newEntity.setLockFloatQuantity(null);
            newEntity.setLossQuantity(null);
            newEntity.setLossFloatQuantity(null);
            newEntity.setCreateTime(LocalDateTime.now());

            w_productMappingDao.deleteByPrimaryKey(wProductmapping.getMappingID());
            w_productMappingDao.insertSelective(newEntity);
            logger.info("newEntity ID: " + newEntity.getMappingID());
        }
    }

    /**
     * 当前时间是否营业时间范围外
     */
    private boolean isOutOfBusinessTime(Long archiveID) {
        B_BasicParamInfoEntity bBasicparaminfo = b_basicParamInfoDao.selectInfoByArchiveid(archiveID);
        if (bBasicparaminfo != null) {
            try {
                LocalDateTime openDateTime = bBasicparaminfo.getOpenTime();
                LocalTime now = LocalTime.now();
                if (openDateTime != null) {
                    LocalTime openTime = openDateTime.toLocalTime();
                    if (now.isBefore(openTime)) {
                        return true;
                    }
                }
                LocalDateTime closeDateTime = bBasicparaminfo.getCloseTime();
                if (closeDateTime != null) {
                    LocalTime closeTime = closeDateTime.toLocalTime();
                    if (now.isAfter(closeTime)) {
                        return true;
                    }
                }
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    private W_ProductHisMappingEntity convert(V_ProductMappingEntity entity) {
        W_ProductHisMappingEntity hisEntity = new W_ProductHisMappingEntity();
        hisEntity.setStoreDay(entity.getCreateTime());
        hisEntity.setMappingID(entity.getMappingID());
        hisEntity.setVariantID(entity.getVariantID());
        hisEntity.setShelfID(entity.getShelfID());
        hisEntity.setContainerID(entity.getContainerID());
        hisEntity.setWarehouseID(entity.getWarehouseID());
        hisEntity.setReceiptID(entity.getReceiptID());
        hisEntity.setProductID(entity.getProductID());
        hisEntity.setOptionID(entity.getOptionID());
        hisEntity.setUnitID(entity.getUnitID());
        hisEntity.setConfigReason(entity.getConfigReason());
        hisEntity.setIsTotal(entity.getIsTotal());
        hisEntity.setInitQuantity(entity.getInitQuantity());
        hisEntity.setInitFloatQuantity(entity.getInitFloatQuantity());
        hisEntity.setChangeInitQuantity(entity.getChangeInitQuantity());
        hisEntity.setChangeInitFloatQuantity(entity.getChangeInitFloatQuantity());
        hisEntity.setRemainingQuantity(entity.getRemainingQuantity());
        hisEntity.setRemainingFloatQuantity(entity.getRemainingFloatQuantity());
        hisEntity.setAvailableQuantity(entity.getAvailableQuantity());
        hisEntity.setAvailableFloatQuantity(entity.getAvailableFloatQuantity());
        hisEntity.setLockQuantity(entity.getLockQuantity());
        hisEntity.setLockFloatQuantity(entity.getLockFloatQuantity());
        hisEntity.setIsSync(entity.getIsSync());
        hisEntity.setCreatorID(entity.getCreatorID());
        hisEntity.setCreateTime(LocalDateTime.now());
        return hisEntity;
    }

    /**
     * @param archiveID
     * @return
     * @Description： 通用菜品分类
     * @Author：chenkangyi
     * @Time: 2017-6-2 18:02
     * @Version 2.0.0
     */
    public List<Map<String, Object>> getCategoryListForCommon(Long archiveID) {
        Map<String, Object> map = MapHelper.newMap();
        map.put(ParamConstants.GlobalParam.PARAM_ARCHIVE_ID, archiveID);
        List<Map<String, Object>> categoryListForCommon = productDao.getCategoryListForCommon(map);
        return SortUtil.treeSort(categoryListForCommon, "categoryID", "parentID");
    }
}
