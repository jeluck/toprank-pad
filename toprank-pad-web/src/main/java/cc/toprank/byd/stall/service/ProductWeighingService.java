package cc.toprank.byd.stall.service;

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.component.OrderComponent;
import cc.toprank.byd.dao.*;
import cc.toprank.byd.entity.B_StallWeighInfoEntity;
import cc.toprank.byd.entity.B_StallWeighSettingInfoEntity;
import cc.toprank.byd.entity.B_WeighDealInfoEntity;
import cc.toprank.byd.enums.OrderManagerEnum;
import cc.toprank.byd.enums.SystemManageEnum;
import cc.toprank.byd.util.MaxIDUtils;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.dto.UserInfoVo;
import cc.toprank.byd.web.vo.product.ProductWeightRequestVo;
import cc.toprank.byd.web.vo.product.ProductWeightVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * 商品称重
 * Created by HuangCY on 2017-3-13.
 */
@Service
public class ProductWeighingService {
    @Autowired
    //档口商品称重关联信息
    private B_StallProduceMappingDao stallProduceMappingMapper;

    @Autowired
    //桌台信息
    private DinningTableInfoService dinningTableInfoService;

    @Autowired
    //档口称重配置信息
    private StallWeighSettingInfoService stallWeighSettingInfoService;

    @Autowired
    //订单明细
    private O_OrderDetailInfoDao orderDetailInfoMapper;

    @Autowired
    //档口称重处理信息
    private B_StallWeighDealInfoDao stallWeighDealInfoMapper;

    @Autowired
    private B_StallWeighInfoDao stallWeighInfoMapper;

    @Autowired
    private B_WeighDealInfoDao weighDealInfoMapper;

    @Autowired
    private O_OrderInfoDao orderInfoMapper;

    @Autowired
    private O_SubOrderInfoDao subOrderInfoMapper;

    @Autowired
    private O_OrderDealInfoDao orderDealInfoMapper;

    @Autowired
    private OrderComponent orderComponent;
    /**
     * 根据条件查询称重商品列表
     *
     * @param map
     * @return
     * @author HuangCY
     * @Time 2017-3-13 update 2017-5-7
     */
    public List<B_StallWeighInfoEntity> queryProductWeighingByCondition(Map map) {
        return stallWeighInfoMapper.queryProductWeighingByCondition(map);
    }
    /**
     * 根据条件查询改重记录
     *
     * @param map
     * @return
     * @author HuangCY
     * @Time 2017-3-16
     */
    public List<B_StallWeighInfoEntity> queryWeighingRecordByCondition(Map map) {
        return stallWeighInfoMapper.queryWeighingRecordByCondition(map);
    }
    /**
     * 改重录入
     *
     * @param map
     * @return
     * @author HuangCY
     * @Time 2017-3-14 update 2017-5-7
     */
    public void updateProductWeighingInput(Map map)  {
        UserInfoVo loginInfo = (UserInfoVo) map.get("loginInfo");
        //根据档口ID查询档口称重配置信息
        B_StallWeighSettingInfoEntity stallWeighSettingInfo = stallWeighSettingInfoService.queryStallWeighSettingInfoByStallID(Long.valueOf(map.get("stallID").toString()));

        Long weighID = (Long) map.get("weighID");

        B_StallWeighInfoEntity stallWeighInfo = stallWeighInfoMapper.selectByPrimaryKey(weighID);

        if(stallWeighInfo.getExpectedWeight() == null || stallWeighInfo.getExpectedWeight() <= 0){
            throw new BizException(CodeMsgConstants.WEIGH_NOTINFOR, CodeMsgConstants.WEIGH_NOTINFOR_MSG);
        }

        //超重或不足时是否需要确认
        boolean needconfirm = false;
        if (stallWeighSettingInfo != null) {
            needconfirm = stallWeighSettingInfo.getNeedConfirm();
        }

        //本次称重的重量
        Float weight = (Float) map.get("weight");

        //修改前的重量
        double befWeight = stallWeighInfo.getRealWeight() == null ? 0 : stallWeighInfo.getRealWeight();

        //修改前的状态
        Long befStatus = stallWeighInfo.getWeightStatus();

        //差异比例
        int diffrate = stallWeighSettingInfo.getDiffRate() == null ? 0 : stallWeighSettingInfo.getDiffRate();

        //相差比例值
        double rate = 0;

        //计算相差重量值 = 实际称重 - 期望重量
        double diffWeight = Math.abs(weight - stallWeighInfo.getExpectedWeight());

        //计算相差的比例值 = 相差的重量值 / 修改前的重量 乘100转成百分比
        rate = diffWeight / stallWeighInfo.getExpectedWeight() * 100;

        if (needconfirm && rate > diffrate) {//超过期望重量的待确认比例
            stallWeighInfo.setWeightStatus(OrderManagerEnum.WeighingStatus.WAITINGCONFIRM.getValue());
        } else {
            stallWeighInfo.setWeightStatus(OrderManagerEnum.WeighingStatus.BEWEIGHING.getValue());

            //调用公共修改商品重量接口类
            ProductWeightRequestVo productWeightRequestVo = new ProductWeightRequestVo();
            productWeightRequestVo.setArchiveID(stallWeighInfo.getArchiveID());
            ProductWeightVo productWeightVo = new ProductWeightVo();
            productWeightVo.setOrderDetailID(stallWeighInfo.getDetailID());
            productWeightVo.setWeight(weight);
            productWeightRequestVo.getProductWeights().add(productWeightVo);
            orderComponent.updateProductWeight(productWeightRequestVo);
        }
        if (befWeight > 0) {
            stallWeighInfo.setConfirmorID(loginInfo.getLoginID());
            stallWeighInfo.setConfirmTime(LocalDateTime.now());
        } else {
            stallWeighInfo.setWeigherID(loginInfo.getLoginID());
            stallWeighInfo.setWeigher(loginInfo.getUserName());
            stallWeighInfo.setWeighTime(LocalDateTime.now());
        }
        stallWeighInfo.setConfirmorType(SystemManageEnum.UserType.SYSTEMUSER.getValue());
        stallWeighInfo.setRealWeight(weight);

        stallWeighInfoMapper.updateByPrimaryKey(stallWeighInfo);//修改称重档口信息

        //插入称重变动信息
        B_WeighDealInfoEntity weighDealInfo = new B_WeighDealInfoEntity();
        weighDealInfo.setDealID(MaxIDUtils.getID(B_WeighDealInfoEntity.class));
        weighDealInfo.setWeighID(stallWeighInfo.getWeighID());
        weighDealInfo.setVariantID(stallWeighInfo.getVariantID());
        weighDealInfo.setDetailID(stallWeighInfo.getDetailID());
        weighDealInfo.setDealType(OrderManagerEnum.DealType.CHANGEWEIGH.getValue()); //变动类型 --变重量
        weighDealInfo.setChangeNum(new BigDecimal(diffWeight));
        weighDealInfo.setBeforeNum(new BigDecimal(befWeight));
        weighDealInfo.setAfterNum(new BigDecimal(stallWeighInfo.getRealWeight()));
        weighDealInfo.setBeforeStatus(befStatus);
        weighDealInfo.setAfterStatus(stallWeighInfo.getWeightStatus());
        weighDealInfo.setIsSync(true);
        weighDealInfo.setCreatorID(loginInfo.getLoginID());
        weighDealInfo.setCerateTime(LocalDateTime.now());
        if (befWeight > 0) {
            weighDealInfo.setChangeDetail("商品改重录入");
        } else {
            weighDealInfo.setChangeDetail("商品称重录入");
        }
        weighDealInfoMapper.insert(weighDealInfo);
    }
}
