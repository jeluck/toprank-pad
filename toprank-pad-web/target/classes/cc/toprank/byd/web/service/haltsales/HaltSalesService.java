package cc.toprank.byd.web.service.haltsales;

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.dao.B_MerchantMenuDealInfoDao;
import cc.toprank.byd.dao.B_MerchantMenuInfoDao;
import cc.toprank.byd.dao.U_LoginInfoDao;
import cc.toprank.byd.entity.B_MerchantMenuDealInfoEntity;
import cc.toprank.byd.entity.B_MerchantMenuInfoEntity;
import cc.toprank.byd.entity.U_LoginInfoEntity;
import cc.toprank.byd.enums.SystemManageEnum;
import cc.toprank.byd.util.MaxIDUtils;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.vo.curbsale.ProductCrubSaleInfoVO;
import cc.toprank.byd.web.vo.haltsales.HaltsSalesHistoryInfoVO;
import cc.toprank.byd.web.vo.haltsales.ProductHaltsSalesInfoVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by ChenKY on 2017-6-2.
 */
@Service
public class HaltSalesService {

    @Autowired
    private B_MerchantMenuInfoDao b_merchantMenuInfoDao;

    @Autowired
    private B_MerchantMenuDealInfoDao b_merchantMenuDealInfoDao;

    @Autowired
    private U_LoginInfoDao u_loginInfoDao;
    /**
     * @Description： 获取菜品分类属性信息,排除已经设置过停售的菜品
     * @Author：chenkangyi
     * @Time: 2017-6-5 11:00
     * @Version 2.0.0
     * @param map
     * @return
     */
    public List<ProductHaltsSalesInfoVO> getProductListFromHaltsSales(Map<String, Object> map) throws Exception{
        map.put("menuStatus",SystemManageEnum.EntityStatus.NORMAL.getValue());
        return b_merchantMenuInfoDao.getProductListFromHaltsSales(map);
    }

    /**
     * @Description： 添加停售
     * @Author：chenkangyi
     * @Time: 2017-6-5 15:00
     * @Version 2.0.0
     */
    @Transactional(rollbackFor = Exception.class)
    public void addHaltsSales(Map<String, Object> map) throws Exception{
        Long menuID = (Long) map.get("menuID");
        if (menuID == null){
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        B_MerchantMenuInfoEntity b_merchantMenuInfo = b_merchantMenuInfoDao.selectByPrimaryKey(menuID);
        Long productID = b_merchantMenuInfo.getProductID();
        Long variantID = b_merchantMenuInfo.getVariantID();
        B_MerchantMenuInfoEntity b_merchantMenuInfoBefore = new B_MerchantMenuInfoEntity();
        BeanUtils.copyProperties(b_merchantMenuInfo,b_merchantMenuInfoBefore);
        if (b_merchantMenuInfo == null){
            throw new BizException(CodeMsgConstants.MENU_NOT_EXIST_CODE, CodeMsgConstants.MENU_NOT_EXIST_MSG);
        }
        b_merchantMenuInfo.setMenuStatus(SystemManageEnum.EntityStatus.DISABLE.getValue());
        //b_merchantMenuInfoDao.updateByPrimaryKey(b_merchantMenuInfo);
        map.put("productID",productID);
        map.put("variantID",variantID);
        map.put("menuStatus",SystemManageEnum.EntityStatus.DISABLE.getValue());
        b_merchantMenuInfoDao.updateByProductIDAndVariantID(map);
        map.put("changeDetail","添加停售");
        //插入一条商户菜单处理信息数据
        insertMerchantMenuDealInfo(b_merchantMenuInfoBefore, b_merchantMenuInfo, map);
    }

    /**
     * @Description： 取消停售
     * @Author：chenkangyi
     * @Time: 2017-6-5 14:00
     * @Version 2.0.0
     */
    @Transactional(rollbackFor = Exception.class)
    public void cancleHaltsSales(Map<String, Object> map) throws Exception {
        cancleOneItemHaltSales(map);
    }

    /**
     * @Description： 批量取消停售
     * @Author：chenkangyi
     * @Time: 2017-6-5 17:40
     * @Version 2.0.0
     */
    @Transactional(rollbackFor = Exception.class)
    public void batchCancleHaltsSales(Map<String, Object> map) throws Exception {
        String menuIDs = (String) map.get("menuIDs");
        if (StringUtils.isBlank(menuIDs)){
            throw new BizException(CodeMsgConstants.BATCH_DELETE_HALTSSALES_MUST_MORE_THAN__ZERO_CODE, CodeMsgConstants.BATCH_DELETE_HALTSSALES_MUST_MORE_THAN__ZERO_MSG);
        }
        String[] menuIDSplit = menuIDs.split(",");
        if (menuIDSplit == null){
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        if (menuIDSplit.length == 0){
            throw new BizException(CodeMsgConstants.BATCH_DELETE_HALTSSALES_MUST_MORE_THAN__ZERO_CODE, CodeMsgConstants.BATCH_DELETE_HALTSSALES_MUST_MORE_THAN__ZERO_MSG);
        }
        for (String menuIDString : menuIDSplit){
            Long menuID = Long.valueOf(menuIDString);
            if (menuID == null){
                throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
            }
            map.put("menuID", menuID);
            cancleOneItemHaltSales(map);
        }
    }

    /**
     * @Description： 获取停售列表
     * @Author：chenkangyi
     * @Time: 2017-6-5 14:45
     * @Version 2.0.0
     */
    public List<HaltsSalesHistoryInfoVO> getHaltsSalesList(Map<String, Object> map) throws Exception{
        map.put("menuStatus",SystemManageEnum.EntityStatus.DISABLE.getValue());
        map.put("categoryID", 0);
        List<ProductHaltsSalesInfoVO> productListFromHaltsSalesList = b_merchantMenuInfoDao.getProductListFromHaltsSales(map);
        map.put("afterStatus",SystemManageEnum.EntityStatus.DISABLE.getValue());
        List<HaltsSalesHistoryInfoVO> haltsSalesHistoryInfoVOList = new ArrayList<>();
        for (ProductHaltsSalesInfoVO productHaltsSalesInfoVO : productListFromHaltsSalesList){
            Long menuID = productHaltsSalesInfoVO.getMenuID();
            if (menuID == null){
                throw new BizException(CodeMsgConstants.ERROR, CodeMsgConstants.ERROR_MSG);
            }
            map.put("menuID",menuID);
            HaltsSalesHistoryInfoVO haltsSalesHistoryInfoVO = b_merchantMenuDealInfoDao.selectNewItemByMenuID(map);
            if (haltsSalesHistoryInfoVO == null){
                throw new BizException(CodeMsgConstants.ERROR, CodeMsgConstants.ERROR_MSG);
            }
            Long creatorID = haltsSalesHistoryInfoVO.getCreatorID();
            U_LoginInfoEntity u_loginInfoEntity = u_loginInfoDao.selectByPrimaryKey(creatorID);
            String creatorName = null;
            if (u_loginInfoEntity != null){
                creatorName = u_loginInfoEntity.getLoginName();
            }
            haltsSalesHistoryInfoVO.setCreatorName(creatorName);
            haltsSalesHistoryInfoVO.setMenuID(menuID);
            haltsSalesHistoryInfoVO.setProductName(productHaltsSalesInfoVO.getProductName());
            haltsSalesHistoryInfoVO.setUnit(productHaltsSalesInfoVO.getUnit());
            haltsSalesHistoryInfoVOList.add(haltsSalesHistoryInfoVO);
        }
        return haltsSalesHistoryInfoVOList;
    }

    /**
     * 取消一条停售记录
     * chenkangyi
     * 2017-6-5 18:00
     */
    public void cancleOneItemHaltSales(Map<String, Object> map){
        Long menuID = (Long) map.get("menuID");
        if (menuID == null){
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        B_MerchantMenuInfoEntity b_merchantMenuInfo = b_merchantMenuInfoDao.selectByPrimaryKey(menuID);
        Long productID = b_merchantMenuInfo.getProductID();
        Long variantID = b_merchantMenuInfo.getVariantID();
        B_MerchantMenuInfoEntity b_merchantMenuInfoBefore = new B_MerchantMenuInfoEntity();
        BeanUtils.copyProperties(b_merchantMenuInfo,b_merchantMenuInfoBefore);
        if (b_merchantMenuInfo == null){
            throw new BizException(CodeMsgConstants.MENU_NOT_EXIST_CODE, CodeMsgConstants.MENU_NOT_EXIST_MSG);
        }
        b_merchantMenuInfo.setMenuStatus(SystemManageEnum.EntityStatus.NORMAL.getValue());
        //b_merchantMenuInfoDao.updateByPrimaryKey(b_merchantMenuInfo);
        map.put("productID",productID);
        map.put("variantID",variantID);
        map.put("menuStatus",SystemManageEnum.EntityStatus.NORMAL.getValue());
        b_merchantMenuInfoDao.updateByProductIDAndVariantID(map);

        map.put("changeDetail","取消停售");
        //插入一条商户菜单处理信息数据
        insertMerchantMenuDealInfo(b_merchantMenuInfoBefore, b_merchantMenuInfo, map);
    }

    /**
     * 插入一条修改菜单记录
     * chenkangyi
     * 2017-6-5 15:22
     */
    private void insertMerchantMenuDealInfo(B_MerchantMenuInfoEntity b_merchantMenuInfoBefore, B_MerchantMenuInfoEntity b_merchantMenuInfoAfter, Map<String, Object> map){
        Long loginID = (Long) map.get("loginID");
        B_MerchantMenuDealInfoEntity b_merchantMenuDealInfoEntity = new B_MerchantMenuDealInfoEntity();
        b_merchantMenuDealInfoEntity.setDealID(MaxIDUtils.getID(B_MerchantMenuDealInfoEntity.class));
        b_merchantMenuDealInfoEntity.setMenuID(b_merchantMenuInfoBefore.getMenuID());
        b_merchantMenuDealInfoEntity.setBeforeStatus(b_merchantMenuInfoBefore.getMenuStatus());
        b_merchantMenuDealInfoEntity.setAfterStatus(b_merchantMenuInfoAfter.getMenuStatus());
        b_merchantMenuDealInfoEntity.setChangeDetail((String)map.get("changeDetail"));
        b_merchantMenuDealInfoEntity.setDealDesc("停售");
        b_merchantMenuDealInfoEntity.setCreatorID(loginID);
        b_merchantMenuDealInfoEntity.setCreateTime(LocalDateTime.now());
        b_merchantMenuDealInfoDao.insertSelective(b_merchantMenuDealInfoEntity);
    }

}
