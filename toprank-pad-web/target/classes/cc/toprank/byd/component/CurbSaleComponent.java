package cc.toprank.byd.component;

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.constant.ParamConstants;
import cc.toprank.byd.dao.O_OrderDetailInfoDao;
import cc.toprank.byd.dao.W_ProductMappingDao;
import cc.toprank.byd.entity.O_OrderDetailInfoEntity;
import cc.toprank.byd.entity.W_ProductMappingEntity;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.util.CurbSaleUtils;
import cc.toprank.byd.web.vo.curbsale.CurbSaleInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 沽清
 */
@Component
public class CurbSaleComponent {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private W_ProductMappingDao w_productMappingDao;

    @Autowired
    private O_OrderDetailInfoDao o_orderDetailInfoDao;

    /**
     * 下单后加菜
     */
    public void addProduct(List<Long> detailIDList, Long archiveID) throws BizException {
        if (detailIDList != null && detailIDList.size() > 0) {
            List<CurbSaleInfoVO> curbSaleDetailForToday = queryCurbSaleDetail(archiveID);
            if (curbSaleDetailForToday != null && curbSaleDetailForToday.size() > 0) {
                for (Long detailID : detailIDList) {
                    //如果不是套餐，没有传商品ID？
                    O_OrderDetailInfoEntity o_orderDetailInfoEntity = o_orderDetailInfoDao.selectByPrimaryKey(detailID);
                    CurbSaleInfoVO existCurbSaleInfo = isExistCurbSaleInfo(curbSaleDetailForToday, o_orderDetailInfoEntity);
                    if (existCurbSaleInfo != null) {
                        W_ProductMappingEntity dbEntity = w_productMappingDao.selectByPrimaryKey(existCurbSaleInfo.getMappingID());
                        if (dbEntity != null) {
                            //校验数量：
                            Boolean needWeigh = (o_orderDetailInfoEntity.getNeedWeigh() == null)? Boolean.FALSE : o_orderDetailInfoEntity.getNeedWeigh();
                            Integer quantity = null;
                            Float floatQuantity = null;
                            if (!needWeigh.booleanValue()) {
                                //不称重商品
                                quantity = o_orderDetailInfoEntity.getQuantity();
                                if (quantity == null) {
                                    logger.info("quantity is null");
                                    continue;
                                }
                                Integer availableQuantity = dbEntity.getAvailableQuantity();
                                if (availableQuantity == null || (availableQuantity.compareTo(quantity) < 0) ) {
                                    throw new BizException(CodeMsgConstants.CURBSALE_AVAILABLE_QUANTITY_NOT_ENOUGH,
                                            CodeMsgConstants.CURBSALE_AVAILABLE_QUANTITY_NOT_ENOUGH_MSG);
                                }
                                dbEntity.setRemainingQuantity(CurbSaleUtils.diff(dbEntity.getRemainingQuantity(), quantity));
                                dbEntity.setAvailableQuantity(CurbSaleUtils.diff(dbEntity.getAvailableQuantity(), quantity));
                            } else {
                                floatQuantity = o_orderDetailInfoEntity.getFloatQuantity();
                                if (floatQuantity == null) {
                                    logger.info("floatQuantity is null");
                                    continue;
                                }
                                Float availableQuantity = dbEntity.getAvailableFloatQuantity();
                                if (availableQuantity == null || (availableQuantity.compareTo(availableQuantity) < 0)) {
                                    throw new BizException(CodeMsgConstants.CURBSALE_AVAILABLE_QUANTITY_NOT_ENOUGH,
                                            CodeMsgConstants.CURBSALE_AVAILABLE_QUANTITY_NOT_ENOUGH_MSG);
                                }
                                dbEntity.setRemainingFloatQuantity(CurbSaleUtils.diff(dbEntity.getRemainingFloatQuantity(), floatQuantity));
                                dbEntity.setAvailableFloatQuantity(CurbSaleUtils.diff(dbEntity.getAvailableFloatQuantity(), floatQuantity));
                            }
                            //更新数量
                            w_productMappingDao.updateByPrimaryKeySelective(dbEntity);
                        }
                    }
                }
            }
        }
    }

    private CurbSaleInfoVO isExistCurbSaleInfo(List<CurbSaleInfoVO> curbSaleDetailForToday, O_OrderDetailInfoEntity o_orderDetailInfoEntity) {
        Long orderProductID = null;
        Long orderVariantID = o_orderDetailInfoEntity.getVariantID(); //如果是套餐，没有变体ID
        //如果是套餐，ComboID对应套餐的商品编号
        if (o_orderDetailInfoEntity.getIsCombo()) {
            orderProductID = o_orderDetailInfoEntity.getComboID();
        }
        Long orderOptionID = o_orderDetailInfoEntity.getOptionID();

        for (CurbSaleInfoVO curbSaleInfoVO : curbSaleDetailForToday) {
            Long productID = curbSaleInfoVO.getProductID();
            Long variantID = curbSaleInfoVO.getVariantID();
            Long optionID = o_orderDetailInfoEntity.getOptionID();

            //是否有问题???
            if (orderProductID == null) {
                //比较变体ID及规格ID
                if (CurbSaleUtils.isEquals(orderVariantID, variantID) && CurbSaleUtils.isEquals(orderOptionID, optionID)) {
                    return curbSaleInfoVO;
                }
            } else {
                //比较商品ID及规格ID
                if (CurbSaleUtils.isEquals(orderProductID, productID) && CurbSaleUtils.isEquals(orderOptionID, optionID)) {
                    return curbSaleInfoVO;
                }
            }
        }

        return null;
    }

    /**
     * 下单后正常退菜，该菜可以继续使用，可用数量及剩余数量增加。
     */
    public void returnProduct(List<Long> detailIDList, Long archiveID) throws BizException {
        if (detailIDList != null && detailIDList.size() > 0) {
             List<CurbSaleInfoVO> curbSaleDetailForToday = queryCurbSaleDetail(archiveID);
            if (curbSaleDetailForToday != null && curbSaleDetailForToday.size() > 0) {
                for (Long detailID : detailIDList) {
                    //如果不是套餐，没有传商品ID？
                    O_OrderDetailInfoEntity o_orderDetailInfoEntity = o_orderDetailInfoDao.selectByPrimaryKey(detailID);
                    CurbSaleInfoVO existCurbSaleInfo = isExistCurbSaleInfo(curbSaleDetailForToday, o_orderDetailInfoEntity);
                    if (existCurbSaleInfo != null) {
                        W_ProductMappingEntity dbEntity = w_productMappingDao.selectByPrimaryKey(existCurbSaleInfo.getMappingID());
                        if (dbEntity != null) {
                            //校验数量：
                            Boolean needWeigh = (o_orderDetailInfoEntity.getNeedWeigh() == null)? Boolean.FALSE : o_orderDetailInfoEntity.getNeedWeigh();
                            Integer quantity = null;
                            Float floatQuantity = null;
                            if (!needWeigh.booleanValue()) {
                                //不称重商品
                                quantity = o_orderDetailInfoEntity.getQuantity();
                                if (quantity == null) {
                                    logger.info("quantity is null");
                                    continue;
                                }
                                dbEntity.setRemainingQuantity(CurbSaleUtils.sum(dbEntity.getRemainingQuantity(), quantity));
                                dbEntity.setAvailableQuantity(CurbSaleUtils.sum(dbEntity.getAvailableQuantity(), quantity));

                            } else {
                                floatQuantity = o_orderDetailInfoEntity.getFloatQuantity();
                                if (floatQuantity == null) {
                                    logger.info("floatQuantity is null");
                                    continue;
                                }
                                dbEntity.setRemainingFloatQuantity(CurbSaleUtils.sum(dbEntity.getRemainingFloatQuantity(), floatQuantity));
                                dbEntity.setAvailableFloatQuantity(CurbSaleUtils.sum(dbEntity.getAvailableFloatQuantity(), floatQuantity));
                            }
                            //更新数量
                            w_productMappingDao.updateByPrimaryKeySelective(dbEntity);
                        }
                    }
                }
            }
        }
    }

    /**
     * 下单后报损退菜。需要增加报损数量。
     */
    public void returnLossProduct(List<Long> detailIDList, Long archiveID) throws BizException {
        if (detailIDList != null && detailIDList.size() > 0) {
            List<CurbSaleInfoVO> curbSaleDetailForToday = queryCurbSaleDetail(archiveID);
            if (curbSaleDetailForToday != null && curbSaleDetailForToday.size() > 0) {
                for (Long detailID : detailIDList) {
                    //如果不是套餐，没有传商品ID？
                    O_OrderDetailInfoEntity o_orderDetailInfoEntity = o_orderDetailInfoDao.selectByPrimaryKey(detailID);
                    CurbSaleInfoVO existCurbSaleInfo = isExistCurbSaleInfo(curbSaleDetailForToday, o_orderDetailInfoEntity);
                    if (existCurbSaleInfo != null) {
                        W_ProductMappingEntity dbEntity = w_productMappingDao.selectByPrimaryKey(existCurbSaleInfo.getMappingID());
                        if (dbEntity != null) {
                            //校验数量：
                            Boolean needWeigh = (o_orderDetailInfoEntity.getNeedWeigh() == null)? Boolean.FALSE : o_orderDetailInfoEntity.getNeedWeigh();
                            Integer quantity = null;
                            Float floatQuantity = null;
                            if (!needWeigh.booleanValue()) {
                                //不称重商品
                                quantity = o_orderDetailInfoEntity.getQuantity();
                                if (quantity == null) {
                                    logger.info("quantity is null");
                                    continue;
                                }
                                dbEntity.setLossQuantity(CurbSaleUtils.sum(dbEntity.getLossQuantity(), quantity));

                            } else {
                                floatQuantity = o_orderDetailInfoEntity.getFloatQuantity();
                                if (floatQuantity == null) {
                                    logger.info("floatQuantity is null");
                                    continue;
                                }
                                dbEntity.setLossFloatQuantity(CurbSaleUtils.sum(dbEntity.getLossFloatQuantity(), floatQuantity));
                            }
                            //更新数量
                            w_productMappingDao.updateByPrimaryKeySelective(dbEntity);
                        }
                    }
                }
            }
        }
    }

    /**
     * 查询沽清列表详情
     * @param archiveID
     * @return
     */
    private List<CurbSaleInfoVO> queryCurbSaleDetail(Long archiveID) {
        Map<String, Object> map = new HashMap<>();
        map.put(ParamConstants.CurbSaleParam.PARAM_ARCHIVE_ID, archiveID);
        map.put("categoryID", 0L);
        return w_productMappingDao.getCurbSaleDetailForToday(map);
    }

}
