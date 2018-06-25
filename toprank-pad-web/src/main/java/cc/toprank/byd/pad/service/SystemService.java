package cc.toprank.byd.pad.service;

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.dao.*;
import cc.toprank.byd.entity.*;
import cc.toprank.byd.enums.CommonManageEnum;
import cc.toprank.byd.pad.pojo.MerchantPadCacheVO;
import cc.toprank.byd.util.MaxIDUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version 2.0.0
 * @description：系统设置服务
 * @author：LiYC
 * @time: 2017-2-20 17:13
 */
@Service
public class SystemService {

    @Autowired
    private B_MerchantInfoDao b_MerchantInfoMapper;
    @Autowired
    private U_OrganizationInfoDao u_OrganizationInfoMapper;
    @Autowired
    private B_BasicParamInfoDao b_BasicParamInfoMapper;
    @Autowired
    private U_LoginInfoDao u_loginInfoMapper;
    @Autowired
    private PadInfoService padInfoService;
    @Autowired
    private B_PadInfoDao b_padInfoMapper;
    @Autowired
    private B_PadDealInfoDao b_padDealInfoMapper;
    @Autowired
    private B_PadTableMappingDao b_padTableMappingMapper;
    @Autowired
    private B_PadMappingDealInfoDao b_padMappingDealInfoMapper;
    @Autowired
    private B_DinningTableInfoDao b_dinningTableInfoMapper;
    @Autowired
    private U_ActiveUserInfoDao u_activeUserInfoMapper;
    @Autowired
    private TableService tableInfoService;

    /**
     * @return
     * @description：获取该离线服务器的唯一档案信息，机构信息，商户基本参数
     * @author：LiYC
     * @time: 2017-2-20 16:57
     * @version 2.0.0
     */
    public Map<String, Object> getInitDate() {
        B_MerchantInfoEntity b_merchantInfo = b_MerchantInfoMapper.selectByListByOnly();
//        B_BasicParamInfoEntity b_basicParamInfo = b_BasicParamInfoMapper.selectByArchiveid(archiveID);//取出商户基本参数
        if (b_merchantInfo == null) {
            BizException.error(2, "当前餐厅找不到对应组织,请维护数据");
        }
        U_OrganizationInfoEntity u_organizationInfo = u_OrganizationInfoMapper.selectByPrimaryKey(b_merchantInfo.getOrgID());//取出机构信息

        //组装成MAP
        Map<String, Object> initMap = new HashedMap();
        initMap.put("B_MerchantInfo", b_merchantInfo);
//        initMap.put("B_BasicParamInfo", b_basicParamInfo);
        initMap.put("U_OrganizationInfo", u_organizationInfo);
        return initMap;
    }


    /**
     * 返回登录账号的信息
     *
     * @param map
     * @description：登陆操作 验证账号；密码；档案；是否正确
     * @author：LiYC
     * @time: 2017-2-20 16:57
     * @version 2.0.0
     */
    public Map<String, Object> login(Map<String, String> map) {
        //账号密码的验证
        Map<String, Object> resultMap = new HashedMap();
        U_LoginInfoEntity u_loginInfo = u_loginInfoMapper.selectByLogin(MapUtils.getString(map, "userName"), MapUtils.getString(map, "userPwd"));
        if (u_loginInfo != null) {//登陆成功

            //判断水牌是否已经存在，不存在则新增水牌
            B_PadInfoEntity b_padInfo = padInfoService.queryPadInfoByIMEI(map.get("imei"), Long.valueOf(map.get("archiveId")));

            if (b_padInfo == null) {//新增水牌
                b_padInfo = new B_PadInfoEntity();
                b_padInfo.setPadID(MaxIDUtils.getID(B_PadInfoEntity.class));
                b_padInfo.setArchiveID(Long.valueOf(map.get("archiveId")));
                b_padInfo.setPadName(map.get("imei"));//暂时用串号
                b_padInfo.setIMEICode(map.get("imei"));//水牌串号
                b_padInfo.setPadIP(map.get("ipAddress"));//水牌IP
                b_padInfo.setServerIP(map.get("serverIp"));//服务IP
                b_padInfo.setServerPort(Integer.valueOf(map.get("serverPort")));//服务端口
                b_padInfo.setPadStatus(CommonManageEnum.DrinkStatus.CONSENTIRE.getValue());
                b_padInfo.setIsSync(false);
                b_padInfo.setPadDesc("新增水牌");//明细
                b_padInfo.setCreatorID(u_loginInfo.getUserID());//当前登陆员工
                b_padInfo.setCreateTime(LocalDateTime.now());

                if (b_padInfoMapper.insert(b_padInfo) > 0) {
                    //新增处理信息
                    B_PadDealInfoEntity b_padDealInfo = new B_PadDealInfoEntity();
                    b_padDealInfo.setDealID(MaxIDUtils.getID(b_padDealInfo));
                    b_padDealInfo.setPadID(b_padInfo.getPadID());
                    b_padDealInfo.setAfterStatus(CommonManageEnum.DrinkStatus.CONSENTIRE.getValue());//处理后状态  -- 无处理前状态  --  字典表定义
                    b_padDealInfo.setChangeContent("新增水牌");
                    b_padDealInfo.setDealDesc("新增水牌成功");
                    b_padDealInfo.setCreatorID(u_loginInfo.getUserID());//当前登陆员工
                    b_padDealInfo.setCreateTime(LocalDateTime.now());
                    b_padDealInfo.setIsSync(false);
                    b_padDealInfoMapper.insert(b_padDealInfo);
                }
            }

            /* ------------------------------ 插入在线信息 ------------------------------ */
            U_ActiveUserInfoEntity u_activeUserInfo = new U_ActiveUserInfoEntity();
            u_activeUserInfo.setLogID(u_loginInfo.getLoginID());
            u_activeUserInfo.setLoginName(u_loginInfo.getLoginName());
            u_activeUserInfo.setLoginChannel(CommonManageEnum.AccessChannel.PRIVATE.getValue());
            u_activeUserInfo.setIMEI(b_padInfo.getIMEICode());
            u_activeUserInfo.setMacAddress(map.get("ipAddress"));
            u_activeUserInfo.setLoginTime(LocalDateTime.now());
            Long id = MaxIDUtils.getID(U_ActiveUserInfoEntity.class);
            u_activeUserInfo.setLogID(MaxIDUtils.getID(u_activeUserInfo));
            u_activeUserInfoMapper.insert(u_activeUserInfo);

            resultMap.put("B_PadInfo", b_padInfo);
            resultMap.put("U_LoginInfo", u_loginInfo);
            return resultMap;
        } else {
            throw new BizException("账号或密码错误");
        }
    }

    /**
     * @param u_loginInfo
     * @param b_padInfo
     * @param tableID
     * @return
     * @description：保存设置操作
     * @author：LiYC
     * @time: 2017-2-20 16:58
     * @version 2.0.0
     */
    public B_DinningTableInfoEntity saveSetUp(U_LoginInfoEntity u_loginInfo, B_PadInfoEntity b_padInfo, Long tableID) {
        B_PadTableMappingEntity b_padTableMapping = new B_PadTableMappingEntity();
        b_padTableMapping.setPadID(b_padInfo.getPadID());
        b_padTableMapping.setTableID(tableID);
        b_padTableMapping.setCreatorID(u_loginInfo.getUserID());
        b_padTableMapping.setCreateTime(LocalDateTime.now());
        b_padTableMapping.setIsSync(false);
        b_padTableMapping.setMappingDesc("绑定桌台：" + tableID);
        b_padTableMapping.setMappingStatus(CommonManageEnum.DrinkMappingStatus.INUNLEGAME.getValue());
        //新增修改之前先查询出所有的，该水牌绑定的，状态为启用的桌子，将状态关闭，并插入处理数据
        List<B_PadTableMappingEntity> mappingList = b_padTableMappingMapper.selectByPadStatus(b_padTableMapping.getPadID(), b_padTableMapping.getMappingStatus());
        //处理该水牌与其他桌台的绑定信息
        if (mappingList != null && mappingList.size() > 0) {
            //修改关联状态的同时插入处理数据
            for (int i = 0; i < mappingList.size(); i++) {
                B_PadTableMappingEntity entity = mappingList.get(i);
                B_PadMappingDealInfoEntity b_padMappingDealInfo = new B_PadMappingDealInfoEntity();
                b_padMappingDealInfo.setBeforeStatus(entity.getMappingStatus());
                entity.setMappingStatus(CommonManageEnum.DrinkMappingStatus.ANNULLAREVINCOLANTE.getValue());//关闭桌台与水牌的关联
                b_padTableMappingMapper.updateByPrimaryKeySelective(entity);
                b_padMappingDealInfo.setDealID(MaxIDUtils.getID(b_padMappingDealInfo));
                b_padMappingDealInfo.setMappingID(entity.getMappingID());
                b_padMappingDealInfo.setAfterStatus(entity.getMappingStatus());
                b_padMappingDealInfo.setChangeContent("变动该水牌绑定的桌台");
                b_padMappingDealInfo.setDealDesc("水牌与该桌台绑定停用");
                b_padMappingDealInfo.setIsSync(false);
                b_padMappingDealInfo.setCreatorID(b_padTableMapping.getCreatorID());
                b_padMappingDealInfo.setCreateTime(LocalDateTime.now());
                b_padMappingDealInfoMapper.insert(b_padMappingDealInfo);//插入处理信息
            }
        }

        B_PadTableMappingEntity b_padTableMapping_copy = b_padTableMappingMapper.selectByOnly(b_padTableMapping.getPadID(), b_padTableMapping.getTableID());
        /* ------------------------------ 水牌与桌台进行绑定 ------------------------------ */
        B_PadMappingDealInfoEntity b_padMappingDealInfo = new B_PadMappingDealInfoEntity();
        if (b_padTableMapping_copy == null) {//水牌与该桌台是第一次绑定
            b_padMappingDealInfo.setChangeContent("水牌绑定新增完成:水牌（IMEI:" + b_padInfo.getIMEICode() + "）与桌台（tableId:" + tableID + "）建立绑定关系。");
            b_padMappingDealInfo.setDealDesc("新水牌与桌台绑定成功");
            b_padMappingDealInfo.setMappingID(b_padTableMapping.getMappingID());
            b_padTableMapping.setMappingID(MaxIDUtils.getID(b_padTableMapping));
            b_padTableMappingMapper.insert(b_padTableMapping);//新增水牌桌台的关联
        } else {
            b_padMappingDealInfo.setBeforeStatus(b_padTableMapping_copy.getMappingStatus());
            b_padMappingDealInfo.setChangeContent("水牌绑定更新完成:水牌（IMEI:" + b_padInfo.getIMEICode() + "）与桌台（tableId:" + tableID + "）建立绑定关系。");
            b_padMappingDealInfo.setDealDesc("水牌更换所绑定的桌台");
            b_padMappingDealInfo.setMappingID(b_padTableMapping_copy.getMappingID());
            b_padTableMapping_copy.setMappingStatus(CommonManageEnum.DrinkMappingStatus.INUNLEGAME.getValue());//启用该关系
            b_padTableMappingMapper.updateByPrimaryKeySelective(b_padTableMapping_copy);//更新
        }
        /* ------------------------------ 插入处理信息 ------------------------------ */
        b_padMappingDealInfo.setDealID(MaxIDUtils.getID(b_padMappingDealInfo));
        b_padMappingDealInfo.setAfterStatus(b_padTableMapping.getMappingStatus());
        b_padMappingDealInfo.setIsSync(false);
        b_padMappingDealInfo.setCreatorID(b_padTableMapping.getCreatorID());
        b_padMappingDealInfo.setCreateTime(LocalDateTime.now());
        b_padMappingDealInfoMapper.insert(b_padMappingDealInfo);//插入处理信息

        //返回桌台信息
        return b_dinningTableInfoMapper.selectByPrimaryKey(tableID);
    }

    /**
     * 刷新session中MerchantPadCacheVO的数据
     *
     * @param b_padInfo
     * @return
     */
    public Map<String, Object> reLoadCache(B_PadInfoEntity b_padInfo, MerchantPadCacheVO merchantCache) {
        Map<String, Object> cacheMap = new HashMap<>();
        //根据水牌信息查询绑定的桌台
        B_DinningTableInfoEntity b_dinningTableInfo = padInfoService.queryDinningTableInfoByPad(b_padInfo.getPadID());

        if (b_dinningTableInfo != null) {
            merchantCache.setTableID(b_dinningTableInfo.getTableID() != null ? b_dinningTableInfo.getTableID() : null);
            merchantCache.setTableName(b_dinningTableInfo.getTableName() != null ? b_dinningTableInfo.getTableName() : null);
            merchantCache.setAreaID(b_dinningTableInfo.getAreaID() != null ? b_dinningTableInfo.getAreaID() : null);
//            //查询桌台负责人信息
//            Map<String, Object> param = new HashMap<>();
//            param.put("archiveID", merchantCache.getArchiveID());
//            param.put("tableID", merchantCache.getTableID());
//            // param.put("mealsID", CommonMapper.getCurrentMealsInfo().getMealsID());
//            B_TableManagerInfoEntity currentManager = b_TableManagerInfoMapper.getCurrentTableManager(param);
            cacheMap.put("tableManager", null);
            //查询该桌台所在的区域信息
            B_ShopAreaInfoEntity b_shopAreaInfo = tableInfoService.checkAreaInfoByTableID(b_dinningTableInfo.getTableID());
            merchantCache.setAreaID(b_shopAreaInfo.getAreaID());

            merchantCache.setOrgID(b_shopAreaInfo.getOrgID());
            cacheMap.put("B_ShopAreaInfo", b_shopAreaInfo);
            cacheMap.put("B_DinningTableInfo", b_dinningTableInfo);
            cacheMap.put("isLogin", true);
        } else {
            cacheMap.put("tableManager", null);
            cacheMap.put("B_ShopAreaInfo", null);
            cacheMap.put("B_DinningTableInfo", null);
            // 需要重新登录来绑定桌台
            cacheMap.put("isLogin", false);
        }
        return cacheMap;
    }

}
