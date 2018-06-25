package cc.toprank.byd.web.service.table;

import cc.toprank.byd.dao.*;
import cc.toprank.byd.entity.B_ChangeShiftsInfoEntity;
import cc.toprank.byd.entity.B_TableManagerInfoEntity;
import cc.toprank.byd.web.vo.tablevo.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 桌台负责人调整，调班业务类
 * Created by HuTao on 2017-5-16.
 */
@Service
public class DeskPersonChargeService {
    @Autowired
    private B_TableManagerInfoDao tableManagerInfoDao;

    @Autowired
    private B_DinningTableInfoDao dinningTableInfoDao;

    @Autowired
    private B_MealsInfoDao mealsInfoDao;

    @Autowired
    private B_ShopAreaInfoDao shopAreaInfoDao;

    @Autowired
    private B_ChangeShiftsInfoDao changeShiftsInfoDao;      //    调班记录信息

    @Autowired
    private B_DutyInfoDao dutyInfoDao;                       //     餐厅排班表


    private static final String PARAM_ARCHIVEID = "archiveID"; // 商户档案id
    private static final String PARAM_AREAID = "areaID";     //   区域id
    private static final String PARAM_TABLEID = "tableID"; //   桌台编号
    private static final String PARAM_MEALID = "mealsID";    //   餐次ID

    /**
     * @return
     * @Description：取岗位角色信息
     * @Author：HuTao
     * @Time: 2017-5-16 14:46
     * @Version 2.0.0
     */
    public List<DeskRoleVO> getRoleList() {
        List<DeskRoleVO> deskRoleList = new ArrayList();
        List<Map<String, Object>> dataMapList = dutyInfoDao.getDeskRole();
        if (CollectionUtils.isNotEmpty(dataMapList)) {
            for (int i = 0; i < dataMapList.size(); i++) {
                DeskRoleVO deskRoleVO = new DeskRoleVO();

                deskRoleVO.setRoleID(Long.parseLong(null == dataMapList.get(i).get("RoleID") ? "0" : dataMapList.get(i).get("RoleID").toString()));        //  岗位角色ID
                deskRoleVO.setRoleName(null == dataMapList.get(i).get("RoleName") ? "" : dataMapList.get(i).get("RoleName").toString());                    //  岗位角色名称
                deskRoleVO.setRoleType(Long.parseLong(null == dataMapList.get(i).get("RoleType") ? "0" : dataMapList.get(i).get("RoleType").toString()));  //  岗位角色类型
                deskRoleVO.setRoleTypeName(null == dataMapList.get(i).get("RoleTypeName") ? "" : dataMapList.get(i).get("RoleTypeName").toString());       //  岗位角色类型名称
                deskRoleList.add(deskRoleVO);
            }
        }
        return deskRoleList;
    }

    /**
     * @param archiveID
     * @param mealID
     * @param curDate
     * @param tableCode
     * @return
     * @Description：根据输入的桌台编号，模糊查询出桌台的负责人
     * @Author：HuTao
     * @Time: 2017-5-16 18:14
     * @Version 2.0.0
     */

    public List<DeskPersonInfoVO> quDeskPersonByDate(Long archiveID, Long mealID, String curDate, String tableCode) {
        List<DeskPersonInfoVO> deskVolist = new ArrayList<>();
        Map<String, Object> parm = new HashedMap();
        parm.put(PARAM_ARCHIVEID, archiveID);
        parm.put(PARAM_MEALID, mealID);
        parm.put("curDate", curDate);
        parm.put("tableCode", tableCode);
        List<B_TableManagerInfoEntity> tableManagList = tableManagerInfoDao.getTableManagerInfoByCondition(parm);
        if (CollectionUtils.isNotEmpty(tableManagList)) {
            for (B_TableManagerInfoEntity infoEntity : tableManagList) {
                DeskPersonInfoVO personInfoVO = new DeskPersonInfoVO();
                personInfoVO.setAreaID(infoEntity.getAreaID());       //  区域ID
                personInfoVO.setTableID(infoEntity.getTableID());     //  桌台ID
                personInfoVO.setTableName(infoEntity.getTableName()); //  桌台名称
                personInfoVO.setPersons(infoEntity.getUserName());    //  负责人
                deskVolist.add(personInfoVO);
            }
        }

        return deskVolist;
    }

    /**
     * @return
     * @Description：按区域，餐次，日期取桌台的负责人列表信表
     * @Author：HuTao
     * @Time: 2017-5-16 14:59
     * @Version 2.0.0
     */
    public List<DeskPersonInfoVO> getByAreaMealDate(Long archiveID, Long areaID, Long mealID, String curDate) {
        List<DeskPersonInfoVO> deskVolist = new ArrayList<>();
        Map<String, Object> parm = new HashedMap();
        parm.put(PARAM_ARCHIVEID, archiveID);
        parm.put(PARAM_AREAID, areaID);
        parm.put(PARAM_MEALID, mealID);
        parm.put("curDate", curDate);
        List<B_TableManagerInfoEntity> tableManagList = tableManagerInfoDao.getTableManagerInfoByCondition(parm);
        if (CollectionUtils.isNotEmpty(tableManagList)) {
            for (B_TableManagerInfoEntity infoEntity : tableManagList) {
                DeskPersonInfoVO personInfoVO = new DeskPersonInfoVO();
                personInfoVO.setAreaID(infoEntity.getAreaID());       //  区域ID
                personInfoVO.setTableID(infoEntity.getTableID());     //  桌台ID
                personInfoVO.setTableName(infoEntity.getTableName()); //  桌台名称
                personInfoVO.setPersons(infoEntity.getUserName());    //  负责人
                deskVolist.add(personInfoVO);
            }
        }
        return deskVolist;
    }

    /**
     * @param tableCode
     * @return
     * @Description：根据桌台号，查询出该桌台的所有桌台负责人的调整记录
     * @Author：HuTao
     * @Time: 2017-5-17 14:40
     * @Version 2.0.0
     */
    public List<DeskChangeVO> getHisChangeInfo(String tableCode) {
        List<DeskChangeVO> deskVolist = new ArrayList<>();
        List<B_ChangeShiftsInfoEntity> dutyInfoList = changeShiftsInfoDao.getHisChangeInfo(tableCode);
        if (CollectionUtils.isNotEmpty(dutyInfoList)) {
            for (B_ChangeShiftsInfoEntity infoEntity : dutyInfoList) {
                DeskChangeVO deskChangeVO = new DeskChangeVO();
                deskChangeVO.setChangeID(infoEntity.getCreatorID());       //   调整ID
                deskChangeVO.setChangeReason(infoEntity.getChangeReasonName());  //  调整原因
                deskChangeVO.setBeforeName(infoEntity.getBeforeLoginName());   //   调整之前
                deskChangeVO.setAfterName(infoEntity.getAfterLoginName());   //    调整之后
                deskChangeVO.setCreatorName(infoEntity.getCreatorName());     //  操作人
                deskChangeVO.setCreateTime(infoEntity.getCreateTime());  //  操作时间
                deskVolist.add(deskChangeVO);
            }
        }
        return deskVolist;
    }

    /**
     * @param loginID
     * @Description：移除桌台负责人
     * @Author：HuTao
     * @Time: 2017-5-18 9:54
     * @Version 2.0.0
     */
    @Transactional(rollbackFor = Exception.class)
    public void delDeskPerson(Long archiveID, Long loginID) {
        Map<String, Object> parm = new HashedMap();
        parm.put(PARAM_ARCHIVEID, archiveID);
        parm.put("loginID", loginID);
        tableManagerInfoDao.updateDeskPersonStatus(parm);
        //  保存移除桌台负责人记录
        List<B_TableManagerInfoEntity>  tableList= tableManagerInfoDao.getTableManagerInfoByLoginID();
        if(CollectionUtils.isNotEmpty(tableList)){
            for(B_TableManagerInfoEntity infoEntity:tableList){
                B_ChangeShiftsInfoEntity changeInfoEntity = new B_ChangeShiftsInfoEntity();
                changeInfoEntity.setConfigID(infoEntity.getConfigID());
                changeInfoEntity.setIsSync(false);
                changeInfoEntity.setBeforeLoginID(infoEntity.getLoginID());
                changeInfoEntity.setCreatorID(loginID);
                changeShiftsInfoDao.save(changeInfoEntity);
            }
        }
    }

    /**
     * @return
     * @Description：获取所有的服务项目信息
     * @Author：HuTao
     * @Time: 2017-5-19 11:32
     * @Version 2.0.0
     */
    public List<ServerItemVO> getAllServerItem() {
        List<ServerItemVO> itemVOList = new ArrayList<>();
        List<Map<String, Object>> mapList = tableManagerInfoDao.getAllServerItem();
        if (CollectionUtils.isNotEmpty(mapList)) {
            for (int i = 0; i <= mapList.size(); i++) {
                ServerItemVO serverItemVO = new ServerItemVO();
                serverItemVO.setServerID((Long) mapList.get(i).get("DictionaryID"));
                serverItemVO.setServerName(mapList.get(i).get("DictionaryName").toString());
                itemVOList.add(serverItemVO);
            }
        }
        return itemVOList;
    }

    /**
     * @param archivelID
     * @param saveVOList
     * @Description：保存桌台负责人信息
     * @Author：HuTao
     * @Time: 2017-5-19 11:37
     * @Version 2.0.0
     */
    @Transactional(rollbackFor = Exception.class)
    public void saveDeskPerson(Long archivelID, Long loginID, List<DeskPersonSaveVO> saveVOList) {
        for (DeskPersonSaveVO pDeskPersonSaveVO : saveVOList) {
            B_TableManagerInfoEntity infoEntity = new B_TableManagerInfoEntity();
            infoEntity.setArchiveID(archivelID);
            infoEntity.setLoginID(pDeskPersonSaveVO.getLoginID());
            infoEntity.setIsSync(false);
            infoEntity.setManageType(pDeskPersonSaveVO.getServerID());
            infoEntity.setAreaID(pDeskPersonSaveVO.getAreaID());
            infoEntity.setTableID(pDeskPersonSaveVO.getTableID());
            infoEntity.setLoginID(pDeskPersonSaveVO.getLoginID());
            infoEntity.setArchiveID(archivelID);
            infoEntity.setCreatorID(loginID);
            tableManagerInfoDao.save(infoEntity);
            B_ChangeShiftsInfoEntity changeInfoEntity = new B_ChangeShiftsInfoEntity();
            changeInfoEntity.setConfigID(infoEntity.getConfigID());
            changeInfoEntity.setDealDesc(pDeskPersonSaveVO.getDealDesc());
            changeInfoEntity.setAfterLoginID(infoEntity.getLoginID());
            changeInfoEntity.setCreatorID(loginID);
            changeInfoEntity.setIsSync(false);
            changeShiftsInfoDao.save(changeInfoEntity);
        }
    }
}

