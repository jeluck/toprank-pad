package cc.toprank.byd.web.service.payment;

import cc.toprank.byd.dao.B_DinningTableInfoDao;
import cc.toprank.byd.dao.B_MerchantFeeInfoDao;
import cc.toprank.byd.dao.O_SubOrderInfoDao;
import cc.toprank.byd.entity.B_DinningTableInfoEntity;
import cc.toprank.byd.entity.B_MerchantFeeInfoEntity;
import cc.toprank.byd.entity.O_SubOrderInfoEntity;
import cc.toprank.byd.enums.MerchantManageEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * 商户服务收费信息
 * Created by HuangCY on 2017-5-18.
 */
@Service("merchantFeeInfoService")
public class MerchantFeeInfoService {

    //子订单信息
    @Autowired
    private O_SubOrderInfoDao o_SubOrderInfoDao;
    //商户服务收费信息
    @Autowired
    private B_MerchantFeeInfoDao b_MerchantFeeInfoDao;
    //桌台信息
    @Autowired
    private B_DinningTableInfoDao b_DinningTableInfoDao;

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 获取商家设置的服务费
     * @time 2017-5-18 11:04
     */
    public BigDecimal getMerchantFee(Long archiveID, List<Long> subOrderIDList) throws Exception {
        //服务费金额
        BigDecimal feeAmount = new BigDecimal(0);

        for(int i = 0 ; i < subOrderIDList.size() ; i++){
            O_SubOrderInfoEntity subOrderInfoEntity = o_SubOrderInfoDao.querySubOrderInfoBySubOrderID(subOrderIDList.get(i));

            //餐次ID
            Long mealsID = subOrderInfoEntity.getMealsID();

            B_DinningTableInfoEntity dinningTableSetParamEntity = new B_DinningTableInfoEntity();

            dinningTableSetParamEntity.setTableID(subOrderInfoEntity.getTableID());

            //根据桌台ID查询桌台信息
            B_DinningTableInfoEntity dinningTableInfoEntity = b_DinningTableInfoDao.getDinningTableInfoEntityByTableId(dinningTableSetParamEntity);

            //区域ID
            Long areaID = dinningTableInfoEntity.getAreaID();

            B_MerchantFeeInfoEntity merchantFeeSetParamEntity = new B_MerchantFeeInfoEntity();

            merchantFeeSetParamEntity.setArchiveID(archiveID);
            merchantFeeSetParamEntity.setMealsID(mealsID);
            merchantFeeSetParamEntity.setAreaID(areaID);

            B_MerchantFeeInfoEntity merchantFeeInfoEntity;

            //根据档案编号,区域ID,餐次ID获取商服务收费信息
            merchantFeeInfoEntity = b_MerchantFeeInfoDao.getMerchantFeeInfoByCondition(merchantFeeSetParamEntity);

            //区域ID和餐次ID未查到数据，那么就只用区域ID再查询一次
            if(null == merchantFeeInfoEntity){
                merchantFeeSetParamEntity.setMealsID(null);
                merchantFeeInfoEntity = b_MerchantFeeInfoDao.getMerchantFeeInfoByCondition(merchantFeeSetParamEntity);

                //区域ID未查询到数据，再用餐次ID查询
                if(null == merchantFeeInfoEntity){
                    merchantFeeSetParamEntity.setMealsID(mealsID);
                    merchantFeeSetParamEntity.setAreaID(null);

                    merchantFeeInfoEntity = b_MerchantFeeInfoDao.getMerchantFeeInfoByCondition(merchantFeeSetParamEntity);
//                    if(null == merchantFeeInfoEntity){
//                        merchantFeeSetParamEntity.setMealsID(null);
//                        merchantFeeSetParamEntity.setAreaID(null);
//
//                        merchantFeeInfoEntity = b_MerchantFeeInfoDao.getMerchantFeeInfoByCondition(merchantFeeSetParamEntity);
//                    }
                }
            }

            //验证商家是否设置了服务费
            if(null != merchantFeeInfoEntity){
                //收费模式
                Long feeMode = merchantFeeInfoEntity.getFeeMode();
                //收取方式
                Long feeType = merchantFeeInfoEntity.getFeeType();

                if (null != feeMode && null != feeType) {
                    //固定金额
                    if (feeType.equals(MerchantManageEnum.ServiceFeeType.FIXAMOUNT.getValue())) {
                        //按人收费
                        if (feeMode.equals(MerchantManageEnum.FeeMode.BYPERSON.getValue())) {
                            feeAmount = feeAmount.add(BigDecimal.valueOf(subOrderInfoEntity.getPeopleNum()).multiply(merchantFeeInfoEntity.getFeeAmount()));
                        }
                        //按桌收费
                        else if (feeMode.equals(MerchantManageEnum.FeeMode.BYTABLE.getValue())) {
                            feeAmount = feeAmount.add(merchantFeeInfoEntity.getFeeAmount());
                        }
                        //按单收费
                        else if (feeMode.equals(MerchantManageEnum.FeeMode.BYORDER.getValue())) {
                            feeAmount = feeAmount.add(merchantFeeInfoEntity.getFeeAmount());
                        }
                    }
                }
                //固定比例
                if (null != feeType && feeType.equals(MerchantManageEnum.ServiceFeeType.FIXRATE.getValue())) {
                    feeAmount = subOrderInfoEntity.getTotalAmount().multiply(BigDecimal.valueOf(merchantFeeInfoEntity.getProportion() / 100).setScale(2,BigDecimal.ROUND_HALF_UP));
                }
            }
        }

        return feeAmount;
    }
}
