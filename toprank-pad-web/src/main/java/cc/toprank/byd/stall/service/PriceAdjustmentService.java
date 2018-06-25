package cc.toprank.byd.stall.service;

import cc.toprank.byd.dao.*;
import cc.toprank.byd.entity.B_MerchantMenuDealInfoEntity;
import cc.toprank.byd.entity.B_MerchantMenuInfoEntity;
import cc.toprank.byd.util.MaxIDUtils;
import cc.toprank.byd.stall.dto.MerchantMenuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * 时价维护
 * @author ZhaoLC
 * @Time 2017-3-10 14:00
 */
@Service
public class PriceAdjustmentService {
    @Autowired
    private B_MerchantMenuInfoDao merchantMenuInfoMapper;

    @Autowired
    private B_MerchantMenuDealInfoDao merchantMenuDealInfoMapper;

    @Autowired
    private P_ProductInfoDao productInfoMapper;

    @Autowired
    private O_OrderDetailInfoDao orderDetailInfoMapper;
    /**
     * 时价维护 查询菜单信息
     *  @author ZhaoLC
     * @Time 2017-3-10 14:00
     */
    public List<Map<String,Object>> queryMerchantMenuAndProductInfoByCondition(Map<String,Object> map){
       return merchantMenuInfoMapper.queryMerchantMenuAndProductInfoByCondition(map);
    }

    /**
     * 调价记录查询
     *  @author ZhaoLC
     * @Time 2017-3-13 10:00
     */
    public List<Map<String,Object>> queryMerchantMenuDealByCondition(Map<String,Object> map){
        return merchantMenuDealInfoMapper.queryMerchantMenuDealByCondition(map);
    }

    /**
     * 销量查询查询
     *  @author ZhaoLC
     * @Time 2017-3-13 10:00
     */
    public List<Map<String,Object>> queryStallSalesVolumeByCondition(Map<String,Object> map){
        return orderDetailInfoMapper.queryStallSalesVolumeByCondition(map);
    }

    /**
     * 时价维护 调整菜单价格
     *  @author ZhaoLC
     * @Time 2017-3-10 14:00
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean updateMerchantMenuPriceBatch(MerchantMenuVO merchantMenuVO){
        if(merchantMenuVO == null || merchantMenuVO.getMerchantMenuList() == null){
            return false;
        }
        B_MerchantMenuInfoEntity merchantMenuInfo = null;
        B_MerchantMenuDealInfoEntity merchantMenuDealInfo = null;

        for(MerchantMenuVO.MerchantMenu merchantMenu : merchantMenuVO.getMerchantMenuList()){
            if(merchantMenu.getPrice() == null || merchantMenu.getPrice() <= 0){
                continue;
            }
            merchantMenuInfo = merchantMenuInfoMapper.selectByPrimaryKey(merchantMenu.getMenuID());
            merchantMenuDealInfo = new B_MerchantMenuDealInfoEntity();
            merchantMenuDealInfo.setDealID(MaxIDUtils.getID(B_MerchantMenuDealInfoEntity.class));
            merchantMenuDealInfo.setMenuID(merchantMenu.getMenuID());
            merchantMenuDealInfo.setBeforePrice(merchantMenuInfo.getPrice());//处理前价格
            merchantMenuDealInfo.setAfterPrice(new BigDecimal(merchantMenu.getPrice()));//处理后价格
            merchantMenuDealInfo.setChangeDetail("时价维护");
            merchantMenuDealInfo.setDealDesc("时价维护");
            merchantMenuDealInfo.setCreatorID(merchantMenuVO.getLoginId());
            merchantMenuDealInfo.setCreateTime(LocalDateTime.now());
            merchantMenuDealInfo.setAuditorID(merchantMenuVO.getLoginId());
            merchantMenuDealInfo.setAuditTime(LocalDateTime.now());
            merchantMenuDealInfoMapper.insert(merchantMenuDealInfo);//插入菜单处理信息

            merchantMenuInfo.setPrice(new BigDecimal(merchantMenu.getPrice()));
            merchantMenuInfoMapper.updateByPrimaryKey(merchantMenuInfo);//更新菜单价格

        }
        return true;
    }

    /**
     *  修改商品原价
     *  @author ZhaoLC
     * @Time 2017-6-7 14:00
     */
    public void updateProductPrice(B_MerchantMenuInfoEntity merchantMenuInfo){

    }
}
