package cc.toprank.byd.web.service.table;

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.common.utils.DateUtils;
import cc.toprank.byd.component.DictionaryComponent;
import cc.toprank.byd.constant.ParamConstants;
import cc.toprank.byd.dao.*;
import cc.toprank.byd.entity.*;
import cc.toprank.byd.enums.DictionaryCatalogEnum;
import cc.toprank.byd.util.MaxIDUtils;
import cc.toprank.byd.vo.ReasonVO;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.vo.AreaVO;
import cc.toprank.byd.web.vo.TableManagerInfoVO;
import cc.toprank.byd.web.vo.TableMesgVO;
import cc.toprank.byd.web.vo.tablevo.*;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

/**
 * @Description： 桌台负责人管理
 * @Author：HuTao
 * @Time: 2017-3-7 14:11
 * @Version 2.0.0
 */

@Service("tableManagerService")
public class TableManagerService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private B_TableManagerInfoDao tableManagerInfoDao;

    @Autowired
    private B_DinningTableInfoDao dinningTableInfoDao;

    @Autowired
    private B_MealsInfoDao mealsInfoDao;

    @Autowired
    private B_ShopAreaInfoDao shopAreaInfoDao;

    @Autowired
    private U_LoginInfoDao loginInfoDao;

    @Autowired
    private U_OrgRoleInfoDao u_orgRoleInfoDao;

    @Autowired
    private B_MerchantInfoDao b_merchantInfoDao;

    @Autowired
    private DictionaryComponent dictionaryComponent;

    @Autowired
    private B_TableManagerSettingInfoDao tableManagerSettingInfoDao;

    @Autowired
    private B_DutyInfoDao dutyInfoDao;

    @Autowired
    private B_MerchantInfoDao merchantInfoDao;

    @Autowired
    private B_TableManagerChangeInfoDao tableManagerChangeInfoDao;

    @Autowired
    private T_TableManagerHisInfoDao tableManagerHisInfoDao;

    /**
     * 字典编码 ChangeMan 调整人员
     */
    private final static Long CHANGE_MANAGER = 1065L;

    /**
     * 字典编码 ChangeDuty 调整职责
     */
    private final static Long CHANGE_DUTY = 1066L;

    /**
     * 标记桌台负责人记录的状态，表示 正常；
     */
    private final static Long STATUS_NORMAL = 9L;
    /**
     * 标记桌台负责人记录的状态，表示 已移除；
     */
    private final static Long STATUS_DELETED = 11L;


    /**
     * 获取桌台负责人首页信息
     *
     * @param archiveID 档案ID
     * @return
     * @Description：
     * @Author：HuTao
     * @Time: 2017-4-18 15:37
     * @Version 2.0.0
     */
    public List<AreaVO> getTableAreaInfo(Long archiveID) {
        AreaVO areaVo = null;
        List<AreaVO> areaList = new ArrayList<AreaVO>();
        List<B_ShopAreaInfoEntity> alist = shopAreaInfoDao.getShopAreaInfoCollectionByArchiveID(archiveID);
        areaVo = new AreaVO();
        areaVo.setAreaName("所有餐桌");
        areaList.add(areaVo);
        for (B_ShopAreaInfoEntity entity : alist) {
            areaVo = new AreaVO();
            areaVo.setAreaID(entity.getAreaID());
            areaVo.setAreaName(entity.getAreaName());
            areaList.add(areaVo);
        }
        return areaList;
    }

    /**
     * 根据区域编号获取餐次信息
     * @param map
     * @return
     */
    public List<B_MealsInfoEntity> getMealsInfoByAreaID(Map<String, Object> map) {
        List<B_MealsInfoEntity> mealsInfoByAreaID = mealsInfoDao.getMealsInfoByAreaID(map);
        //如果根据区域ID，没有找到餐次信息，则用默认的餐次
        if (CollectionUtils.isEmpty(mealsInfoByAreaID)) {
            map.remove("areaID");
            mealsInfoByAreaID = mealsInfoDao.getMealsInfoByAreaID(map);
        }
        return mealsInfoByAreaID;
    }


    /**
     * 获取桌台相关信息
     *
     * @param archiveID 档案ID
     * @param areaID    区域I
     * @param mealName  餐次名称
     * @return
     * @Description：
     * @Author：HuTao
     * @Time: 2017-4-18 15:37
     * @Version 2.0.0
     */
    public List<TableMesgVO> getTableInfo(Long archiveID, Long areaID, String mealName) {
        String result = "";
        HashMap map = new HashMap();
        map.put("archiveID", archiveID);
        map.put("areaID", areaID);
        map.put("mealName", mealName);
        List<B_DinningTableInfoEntity> list = dinningTableInfoDao.getTableInfoByAreaIDAndOrgID(map);
        String tmp = "";
        List<TableMesgVO> megList = new ArrayList<TableMesgVO>();
        for (B_DinningTableInfoEntity entity : list) {
            TableMesgVO mesgVo = new TableMesgVO();
            if (entity.getConfigID() == null) {
                mesgVo.setDefaultPeople(entity.getDefaultPerson() == null ? 8 : entity.getDefaultPerson());
                mesgVo.setTableCode(entity.getTableCode() == null ? "0" : entity.getTableCode());
            } else {
                String tmp_local = entity.getTableCode();
                if (tmp_local.equals(tmp))
                    continue;
                mesgVo.setDefaultPeople(entity.getDefaultPerson() == null ? 8 : entity.getDefaultPerson());
                mesgVo.setTableCode(entity.getTableCode() == null ? "0" : entity.getTableCode());
                mesgVo.setConfigId(entity.getConfigID());
                mesgVo.setManageType(entity.getManageType());
                mesgVo.setServiceAnswerType(entity.getServiceAnswerType());
                mesgVo.setUserName(entity.getUserName());
                mesgVo.setAreaId(entity.getAreaID());
            }
            tmp = entity.getTableCode();
            megList.add(mesgVo);
        }
        return megList;
    }

    /**
     * @param mealName
     * @param tableCode
     * @param archiveID
     * @return
     * @Description：查询桌台负责人详情
     * @Author：HuTao
     * @Time: 2017-4-18 15:07
     * @Version 2.0.0
     */
    public List<TableManagerInfoVO> getTableManagerResp(String mealName, String tableCode, Long archiveID) {
        HashMap map = new HashMap();
        map.put("archiveID", archiveID);
        map.put("mealName", mealName);
        map.put("tableCode", tableCode);
        List<B_TableManagerInfoEntity> tList = tableManagerInfoDao.getTableManagerInfoByCondition(map);
        List<TableManagerInfoVO> dataList = new ArrayList<>();
        if (!tList.isEmpty()) {
            for (B_TableManagerInfoEntity entity : tList) {
                TableManagerInfoVO tabVo = new TableManagerInfoVO();
                tabVo.setConfigID(entity.getConfigID());
                tabVo.setUserName(entity.getTableName());
                tabVo.setManagerType(entity.getManageType());
                tabVo.setServiceAnswerType(entity.getServiceAnswerType());
                dataList.add(tabVo);
            }
        }
        return dataList;
    }

    /**
     * @param configID
     * @return
     * @Description： 根据configID删除对应的桌台负责人信息
     * @Author：HuTao
     * @Time: 2017-3-7 17:46
     * @Version 2.0.0
     */
    @Transactional(rollbackFor = Exception.class)
    public void delTableManagerInfo(Long configID) {
        B_TableManagerInfoEntity entity = new B_TableManagerInfoEntity();
        entity.setConfigID(configID);
        tableManagerInfoDao.delete(entity);
    }

    /**
     * 查询区域信息
     */
    public List<B_ShopAreaInfoEntity> queryAreaInfo(Long archiveID) {
        return  shopAreaInfoDao.getShopAreaInfoCollectionByArchiveID(archiveID);
    }

    /**
     * 查询商户角色信息
     * @param map
     * @return
     */
    public List<OrgRoleVO> queryRoleInfo(Map<String, Object> map) {
        List<OrgRoleVO> orgRoleVOList = null;
        B_MerchantInfoEntity b_merchantInfoEntity = b_merchantInfoDao.selectByPrimaryKey((Long) map.get(ParamConstants.GlobalParam.PARAM_ARCHIVE_ID));
        if (b_merchantInfoEntity != null) {
            Map<String, Object> tempMap = new HashMap<>();
            tempMap.put("orgID", b_merchantInfoEntity.getOrgID());
            orgRoleVOList = u_orgRoleInfoDao.queryRoleInfo(tempMap);
        }

        return orgRoleVOList;
    }

    /**
     * 查询区域桌台信息(含桌台负责人列表)
     * @param map
     * @return
     */
    public List<TableManagerVO> queryAreaTableInfo(Map<String, Object> map) {
        List<TableManagerVO> voList = new ArrayList<>();
        String dutyDay = (String) map.get("dutyDay");
        if (DateUtils.getCurrentDate().equals(dutyDay)) {
            //1.根据区域ID、桌台名称、桌台编码查询出匹配的桌台
            final List<B_DinningTableInfoEntity> tableInfoEntityList = dinningTableInfoDao.getTablesByAreaIDAndTableCode(map);
            if (tableInfoEntityList != null && tableInfoEntityList.size() > 0) {
                //根据区域餐次查询桌台负责人
                final List<TableManagerSettingVO> tableManagerSettingVOList = tableManagerInfoDao.getTableManagerByAreaIDAndMealsID(map);
                for (B_DinningTableInfoEntity tableInfoEntity : tableInfoEntityList) {
                    TableManagerVO vo = new TableManagerVO();
                    vo.setTableID(tableInfoEntity.getTableID());
                    vo.setArchiveID(tableInfoEntity.getArchiveID());
                    vo.setTableCode(tableInfoEntity.getTableCode());
                    vo.setTableName(tableInfoEntity.getTableName());
                    vo.setDutyVOList(getDutyVOList(tableInfoEntity, tableManagerSettingVOList, map));
                    voList.add(vo);
                }
            }
            //对服务内容进行转换处理
            convertServiceAnswer(voList);
        }

        return voList;
    }

    /**
     * 根据桌台管理状态查询桌台负责人信息
     * @param map
     * @return
     */
    public TableManagerStatusVO getTableManagerListByManagerStatus(Map<String, Object> map) {
        TableManagerStatusVO statusVO = new TableManagerStatusVO();
        String dutyDay = (String) map.get("dutyDay");
        if (DateUtils.getCurrentDate().equals(dutyDay)) {
            //1.根据区域ID查询出匹配的桌台
            map.remove("searchContent");
            List<TableManagerVO> tableManagerVOList = queryAreaTableInfo(map);
            Long status = (Long) map.get("status");

            statusVO.setTablesNumOfArea(Long.valueOf(tableManagerVOList.size()));

            //无桌台负责人
            List<TableManagerVO> noManagerVOList = new ArrayList<>();
            for (TableManagerVO managerVO : tableManagerVOList) {
                List<TableManagerSettingVO> dutyVOList = managerVO.getDutyVOList();
                if (CollectionUtils.isEmpty(dutyVOList)) {
                    noManagerVOList.add(managerVO);
                }
            }
            statusVO.setTablesNumOfNoManager(Long.valueOf(noManagerVOList.size()));

            if (status == null || status.longValue() == 0L) {
                statusVO.setTableManagerVOList(tableManagerVOList);
            }
            else if (status.longValue() == 1L) {
                statusVO.setTableManagerVOList(noManagerVOList);
            }
        }
        return statusVO;
    }

    private void convertServiceAnswer(List<TableManagerVO> voList) {
        Map<Long, ServiceAnswerTypeVO> allSericeMap = getServiceAnswerTypeMap();
        for (TableManagerVO tableManagerVO : voList) {
            List<TableManagerSettingVO> dutyVOList = tableManagerVO.getDutyVOList();
            if (dutyVOList != null) {
                for (TableManagerSettingVO dutyVO : dutyVOList) {
                    convertServiceAnswer(dutyVO, allSericeMap);
                }
            }
        }
    }

    private Map<Long, ServiceAnswerTypeVO> getServiceAnswerTypeMap() {
        Map<Long, ServiceAnswerTypeVO> allSericeMap = new HashMap<>();
        List<ServiceAnswerTypeVO> allServiceAnswer = tableManagerInfoDao.getAllServiceAnswer();
        if (allServiceAnswer != null) {
            for (ServiceAnswerTypeVO typeVO : allServiceAnswer) {
                allSericeMap.put(typeVO.getServiceAnswerTypeID(), typeVO);
            }
        }
        return allSericeMap;
    }

    private void convertServiceAnswer(TableManagerSettingVO dutyVO, Map<Long, ServiceAnswerTypeVO> allSericeMap) {
        Set<Long> serviceAnswerTypeList = dutyVO.getServiceAnswerTypeList();
        if (serviceAnswerTypeList != null && serviceAnswerTypeList.size() > 0) {
            dutyVO.setServiceAnswerTypeVOList(new ArrayList<>());
            if (serviceAnswerTypeList.contains(Long.valueOf(0L))) {
                Set<Map.Entry<Long, ServiceAnswerTypeVO>> entries = allSericeMap.entrySet();
                for (Map.Entry<Long, ServiceAnswerTypeVO> entry : entries) {
                    dutyVO.getServiceAnswerTypeVOList().add(entry.getValue());
                }
            }
            else {
                for (Long type : serviceAnswerTypeList) {
                    if (allSericeMap.get(type) != null) {
                        dutyVO.getServiceAnswerTypeVOList().add(allSericeMap.get(type));
                    }
                }
            }
        }
    }

    /**
     * 返回桌台所有的负责人及服务内容
     * @param tableInfoEntity
     * @param tableManagerSettingVOList
     * @param map
     * @return
     */
    private List<TableManagerSettingVO> getDutyVOList(B_DinningTableInfoEntity tableInfoEntity,
            List<TableManagerSettingVO> tableManagerSettingVOList, Map<String, Object> map) {
        //key 为登录编号
        Map<Long, TableManagerSettingVO> dutyVOMap = new HashMap<>();
        List<TableManagerSettingVO> dutyVOList = new ArrayList<>();
        Long tableID = tableInfoEntity.getTableID();
        if (tableManagerSettingVOList != null) {
            for (TableManagerSettingVO dutyVO : tableManagerSettingVOList) {
                Long dutyTableID = dutyVO.getTableID();
                if (tableID != null && tableID.equals(dutyTableID)) {
                    mergeServiceAnswerType(dutyVOMap, dutyVO);
                }
            }
        }

        Set<Map.Entry<Long, TableManagerSettingVO>> entries = dutyVOMap.entrySet();
//        Map<Long, OrgRoleUserInfoVO> loginIDOrgRoleMap = getLoginOrgRoleMap(map);
        for (Map.Entry<Long, TableManagerSettingVO> entry : entries) {
            TableManagerSettingVO entryValue = entry.getValue();
//            OrgRoleUserInfoVO orgRoleUserInfoVO = loginIDOrgRoleMap.get(entryValue.getLoginID());
//            if (orgRoleUserInfoVO != null) {
//                entryValue.setOrgName(orgRoleUserInfoVO.getOrgName());
//                entryValue.setRoleName(orgRoleUserInfoVO.getRoleName());
//            }

            dutyVOList.add(entryValue);
        }
        return dutyVOList;
    }

    /**
     * 登录编号跟机构角色是否 1 对 1的关系？
     * @param map
     * @return
     */
    private Map<Long, OrgRoleUserInfoVO> getLoginOrgRoleMap(Map<String, Object> map) {
        Map<Long, OrgRoleUserInfoVO> resultMap = new HashMap<>();
        List<OrgRoleUserInfoVO> orgRoleList = getU_LoginInfoByOrgRoleID(map);
        if (orgRoleList != null) {
            for (OrgRoleUserInfoVO orgRole : orgRoleList) {
                resultMap.put(orgRole.getLoginID(), orgRole);
            }
        }
        return resultMap;
    }

    /**
     * 同餐次，同桌台，同一个的服务内容合并, configID也合并，移除桌台负责人
     * @param dutyVOMap
     * @param dutyVO
     */
    private void mergeServiceAnswerType(Map<Long, TableManagerSettingVO> dutyVOMap, TableManagerSettingVO dutyVO) {
        TableManagerSettingVO value = dutyVOMap.get(dutyVO.getLoginID());
        if (value == null) {
            TableManagerSettingVO temp = new TableManagerSettingVO();
            BeanUtils.copyProperties(dutyVO, temp);
            if (dutyVO.getServiceAnswerType() != null) {
                temp.setServiceAnswerTypeList(new HashSet<>());
                temp.getServiceAnswerTypeList().add(dutyVO.getServiceAnswerType());
            }
            dutyVOMap.put(dutyVO.getLoginID(), temp);
        }
        else {
            if (dutyVO.getServiceAnswerType() != null) {
                if (value.getServiceAnswerTypeList() == null) {
                    value.setServiceAnswerTypeList(new HashSet<>());
                }
                value.getServiceAnswerTypeList().add(dutyVO.getServiceAnswerType());
            }
        }
    }

    /**
     * 查询所有服务内容
     * @return
     */
    public List<ServiceAnswerTypeVO> queryAllServiceItem() {
        return tableManagerInfoDao.getAllServiceAnswer();
    }

    /**
     * 查询商户下所有员工
     */
    public List<OrgRoleUserInfoVO> getU_LoginInfoByOrgRoleID(Map<String, Object> map) {
        Long archiveID = (Long) map.get(ParamConstants.GlobalParam.PARAM_ARCHIVE_ID);
        B_MerchantInfoEntity b_merchantInfoEntity = b_merchantInfoDao.selectByPrimaryKey(archiveID);
        if (b_merchantInfoEntity != null) {
            Long orgID = b_merchantInfoEntity.getOrgID();
            String orgIDSet = tableManagerInfoDao.getChildOrgList(orgID);
            map.put("orgIDSet", orgIDSet);
            return tableManagerInfoDao.getU_LoginInfoByOrgRoleID(map);
        }
        return null;
    }

    /**
     *  查询新增桌台负责人、修改服务内容、删除桌台负责人的操作原因
     * @param archiveID
     * @param operationType
     * @return
     */
    public List<ReasonVO> queryConfigReason(Long archiveID, Long operationType) {
        List<ReasonVO> reasonVOList = null;
        if (operationType != null) {
            if (operationType.longValue() == 1L) {
                reasonVOList = dictionaryComponent.getReasonByCatalogCode(DictionaryCatalogEnum.ADD_TABLE_MANAGER, archiveID);
            }
            else if (operationType.longValue() == 2L) {
                reasonVOList =  dictionaryComponent.getReasonByCatalogCode(DictionaryCatalogEnum.CHANGE_SERVER_CONTENT, archiveID);
            }
            else if (operationType.longValue() == 3L) {
                reasonVOList =  dictionaryComponent.getReasonByCatalogCode(DictionaryCatalogEnum.REMOVE_TABLE_MANAGER, archiveID);
            }
        }
        return reasonVOList;
    }

    /**
     * 当前餐次，桌台的负责人，分为服务员、传菜员、清洁员、经理、店长等，
     * 每天营业前根据排班表生成，前端业务系统可调整负责人，日结时自动将数据导入历史信息
     */
    public void executeTableManagerTask() {
        //1、将桌台负责人信息迁移到历史表
        //历史暂时不做
        transferTableManagerInfoToHis();
        //2、根据餐厅排班表 生成桌台负责人信息
        paibanToTable();
    }

    private void transferTableManagerInfoToHis() {
        List<B_TableManagerInfoEntity> all = tableManagerInfoDao.getAll();
        if (all != null) {
            for (B_TableManagerInfoEntity tableManagerInfoEntity : all) {
                T_TableManagerHisInfoEntity hisInfoEntity = convertEntity(tableManagerInfoEntity);
//                tableManagerHisInfoDao.insertSelective(hisInfoEntity);
                tableManagerInfoDao.deleteByPrimaryKey(tableManagerInfoEntity.getConfigID());
            }
        }
    }

    private T_TableManagerHisInfoEntity convertEntity(B_TableManagerInfoEntity tableManagerInfoEntity) {
        T_TableManagerHisInfoEntity hisInfoEntity = new T_TableManagerHisInfoEntity();
        hisInfoEntity.setHisID(MaxIDUtils.getID(T_TableManagerHisInfoEntity.class));
        hisInfoEntity.setArchiveID(tableManagerInfoEntity.getArchiveID());
        hisInfoEntity.setLoginID(tableManagerInfoEntity.getLoginID());
        hisInfoEntity.setMealsID(tableManagerInfoEntity.getMealsID());
        hisInfoEntity.setAreaID(tableManagerInfoEntity.getAreaID());
        hisInfoEntity.setTableID(tableManagerInfoEntity.getTableID());
        hisInfoEntity.setTableCode(tableManagerInfoEntity.getTableCode());
        hisInfoEntity.setTableName(tableManagerInfoEntity.getTableName());
        hisInfoEntity.setDutyDate(tableManagerInfoEntity.getCreateTime());//值班日期？？？
        hisInfoEntity.setManageType(tableManagerInfoEntity.getManageType());
        hisInfoEntity.setServiceAnswerType(tableManagerInfoEntity.getServiceAnswerType());
        hisInfoEntity.setCreatorID(tableManagerInfoEntity.getCreatorID());
        hisInfoEntity.setCreateTime(LocalDateTime.now());
        hisInfoEntity.setEvaluator(tableManagerInfoEntity.getCreatorID());// 评价人？？？
        hisInfoEntity.setEvaluateTime(LocalDateTime.now());
        return hisInfoEntity;
    }

    private void paibanToTable() {
        //商户是否合法?
        List<B_MerchantInfoEntity> allMerchant = merchantInfoDao.getAll();
        if (!CollectionUtils.isEmpty(allMerchant)) {
            //循环生成每个商户的桌台负责人信息
            Map<Long, List<TableManagerSettingVO>> merchantSettingMap = new HashMap<>();
            for (B_MerchantInfoEntity merchantInfoEntity : allMerchant) {
                Long archiveID = merchantInfoEntity.getArchiveID();
                List<TableManagerSettingVO> settingVOList = new ArrayList<>();
                merchantSettingMap.put(archiveID, settingVOList);
                List<TableManagerSettingVO> allSettingInfo = tableManagerSettingInfoDao.getTableManagerSettingInfoByArchiveID(archiveID);
                if (!CollectionUtils.isEmpty(allSettingInfo)) {
                    for (TableManagerSettingVO settingVO : allSettingInfo) {
                        //是否当天排班
                        if (isDutyToday(settingVO)) {
                            settingVOList.add(settingVO);
                        }
                    }
                }
            }

            //生成每个商家当天的桌台负责人数据
            Set<Map.Entry<Long, List<TableManagerSettingVO>>> entries = merchantSettingMap.entrySet();
            //存储每个区域对应的有效餐次信息
            Map<Long, List<B_MealsInfoEntity>> areaMealsMap = new HashMap<>();
            for (Map.Entry<Long, List<TableManagerSettingVO>> entry : entries) {
                List<TableManagerSettingVO> tableManagerSettingVOS = entry.getValue();
                insertTableManagerInfo(tableManagerSettingVOS, areaMealsMap);
            }
        }
    }

    @Transactional(rollbackFor = Exception.class)
    private void insertTableManagerInfo(List<TableManagerSettingVO> tableManagerSettingVOS, Map<Long, List<B_MealsInfoEntity>> areaMealsMap) {
        for (TableManagerSettingVO settingVO : tableManagerSettingVOS) {
            // settingVO.getMealsID() 该餐次是通用餐次，需要根据该餐次的时间找到区域具体的餐次。
            addMealsMap(areaMealsMap, settingVO);
            List<Long> mealsIDList = findMealsID(settingVO, areaMealsMap);
            for (Long mealsID : mealsIDList) {
                B_TableManagerInfoEntity managerInfoEntity = converToEntity(settingVO, mealsID);
                tableManagerInfoDao.insertSelective(managerInfoEntity);
            }
        }
    }

    private void addMealsMap(Map<Long, List<B_MealsInfoEntity>> areaMealsMap, TableManagerSettingVO settingVO) {
        Long areaID = settingVO.getAreaID();
        Long archiveID = settingVO.getArchiveID();
        List<B_MealsInfoEntity> mealsInfoEntityList = areaMealsMap.get(areaID);
        if (mealsInfoEntityList == null) {
            Map<String, Object> map = new HashMap<>();
            map.put("archiveID", archiveID);
            map.put("areaID", areaID);
            List<B_MealsInfoEntity> mealsInfoByAreaID = mealsInfoDao.getMealsInfoByAreaID(map);
            //如果根据区域ID，没有找到餐次信息，则用默认的餐次
            if (CollectionUtils.isEmpty(mealsInfoByAreaID)) {
                map.remove("areaID");
                mealsInfoByAreaID = mealsInfoDao.getMealsInfoByAreaID(map);
            }
            areaMealsMap.put(areaID, (mealsInfoByAreaID == null)? new ArrayList<>() : mealsInfoByAreaID);
        }
    }

    private B_TableManagerInfoEntity converToEntity(TableManagerSettingVO settingVO, Long mealsID) {
        B_TableManagerInfoEntity entity = new B_TableManagerInfoEntity();
        entity.setConfigID(MaxIDUtils.getID(B_TableManagerInfoEntity.class));
        entity.setArchiveID(settingVO.getArchiveID());
        entity.setLoginID(settingVO.getLoginID());
        entity.setMealsID(mealsID);
        entity.setAreaID(settingVO.getAreaID());
        entity.setSettingID(settingVO.getSettingID());
        entity.setTableID(settingVO.getTableID());
        entity.setDutyID(settingVO.getDutyID());
        entity.setTableCode(settingVO.getTableCode());
        entity.setTableName(settingVO.getTableName());
        entity.setManageType(settingVO.getManageType());
        entity.setServiceAnswerType(settingVO.getServiceAnswerType());
        entity.setMappingStatus(settingVO.getMappingStatus());
        entity.setManageDesc(settingVO.getManageDesc());
        entity.setCreatorID(settingVO.getCreatorID());
        entity.setCreateTime(LocalDateTime.now());
        entity.setMemo(settingVO.getMemo());
        return entity;
    }

    /**
     * 有可能有多个区域自定义的餐次在通用餐次时间范围内。
     * @param settingVO
     * @param areaMealsMap
     * @return
     */
    private List<Long> findMealsID(TableManagerSettingVO settingVO, Map<Long, List<B_MealsInfoEntity>> areaMealsMap) {
        List<Long> mealsIDList = new ArrayList<>();
        Long areaID = settingVO.getAreaID();
        List<B_MealsInfoEntity> mealsInfoEntityList = areaMealsMap.get(areaID);
        if (!CollectionUtils.isEmpty(mealsInfoEntityList)) {
            LocalDateTime startTime = settingVO.getStartTime();
            LocalDateTime endTime = settingVO.getEndTime();
            for (B_MealsInfoEntity mealsInfoEntity : mealsInfoEntityList) {
                LocalDateTime areaMealsStartTime = mealsInfoEntity.getStartTime();
                LocalDateTime areaMealsEndTime = mealsInfoEntity.getEndTime();
                if (isBetweenTime(startTime, endTime, areaMealsStartTime, areaMealsEndTime)) {
                    mealsIDList.add(mealsInfoEntity.getMealsID());
                }
            }
        }
        return mealsIDList;
    }

    /**
     *  t1  t3  t4  t2
     * @param startTime
     * @param endTime
     * @param areaMealsStartTime
     * @param areaMealsEndTime
     * @return
     */
    private boolean isBetweenTime(LocalDateTime startTime, LocalDateTime endTime, LocalDateTime areaMealsStartTime, LocalDateTime areaMealsEndTime) {
        try {
            LocalDateTime t1 = getDateTimeOfCurrentDate(startTime);
            LocalDateTime t2 = getEndTime(startTime, endTime);
            LocalDateTime t3 = getDateTimeOfCurrentDate(areaMealsStartTime);
            LocalDateTime t4 = getEndTime(areaMealsStartTime, areaMealsEndTime);
            if ((t3.isAfter(t1) || t3.isEqual(t1)) && (t4.isBefore(t2) || t4.isEqual(t2))) {
                return true;
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
            return false;
        }
        return false;
    }


    private LocalDateTime getEndTime(LocalDateTime startTime, LocalDateTime endTime) {
        LocalDateTime currentDateTime = getDateTimeOfCurrentDate(endTime);
        boolean sameDate = DateUtils.isSameDate(startTime, endTime);
        if (sameDate) {
            return currentDateTime;
        }
        else {
            return currentDateTime.plusDays(1L);
        }
    }

    private LocalDateTime getDateTimeOfCurrentDate(LocalDateTime startTime) {
        LocalDate date = LocalDate.now();
        LocalTime time = startTime.toLocalTime();
        return LocalDateTime.of(date, time);
    }

    private boolean isDutyToday(TableManagerSettingVO settingVO) {
        try {
            DayOfWeek dayOfWeek = LocalDateTime.now().getDayOfWeek();
            Long cycleType = settingVO.getCycleType();
            String strDutyDay = settingVO.getDutyDay();
            if (cycleType != null && strDutyDay != null) {
                int dutyDay = Integer.parseInt(strDutyDay);
                //按周
                if (cycleType.longValue() == 232L) {
                    if (dutyDay == 0) {
                        dutyDay = 7;
                    }
                    int dayOfWeekValue = dayOfWeek.getValue(); // 1-7表示周一到周日
                    if (dutyDay == dayOfWeekValue) {
                        return true;
                    }
                }
                else if (cycleType.longValue() == 233L) {
                    //1-31表示按月排班
                    int dayOfMonth = LocalDateTime.now().getDayOfMonth();
                    if (dutyDay == dayOfMonth) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    /**
     * 新增桌台负责人
     * @param tableManagerVO
     * @param creatorID
     * @throws BizException
     */
    @Transactional(rollbackFor = Exception.class)
    public void addTableManager(TableManagerVO tableManagerVO, Long creatorID) throws BizException {
        checkAddTableManagerParam(tableManagerVO);
        Long tableID = tableManagerVO.getTableID();
        String tableCode = tableManagerVO.getTableCode();
        String tableName = tableManagerVO.getTableName();
        TableManagerSettingVO dutyVO = tableManagerVO.getDutyVOList().get(0);
        Long mealsID = dutyVO.getMealsID();
        Long loginID = dutyVO.getLoginID();
        Long areaID = dutyVO.getAreaID();
        Long changeReason = dutyVO.getChangeReason();

        String dealDesc = dutyVO.getDealDesc();
        Set<Long> serviceAnswerTypeList = dutyVO.getServiceAnswerTypeList();
        //多项服务内容对应多条桌台负责人记录。坑。。。但是调整信息只对应一条
        Map<String, Object> map = new HashMap<>();
        map.put("archiveID", tableManagerVO.getArchiveID());
        map.put("loginID", loginID);
        map.put("tableID", tableID);
        map.put("mealsID", mealsID);

        Long configID = null;
        for (Long serviceType : serviceAnswerTypeList) {
            map.put("serviceAnswerType", serviceType);
            B_TableManagerInfoEntity b_tableManagerInfoEntity = tableManagerInfoDao.selectOneByServiceType(map);
            if (b_tableManagerInfoEntity != null) {
                //修改为正常状态
                updateMappingStatus(b_tableManagerInfoEntity.getConfigID(), STATUS_NORMAL);
                if (configID == null) {
                    configID = b_tableManagerInfoEntity.getConfigID();
                }
            }
            else {
                //新建一条正常状态的记录
                B_TableManagerInfoEntity entity = buildB_TableManagerInfoEntity(tableManagerVO.getArchiveID(), loginID, mealsID, areaID,
                        tableID, tableCode, tableName, serviceType, creatorID);
                if (configID == null) {
                    configID = entity.getConfigID();
                }
                tableManagerInfoDao.insertSelective(entity);
            }
        }
        if (configID != null) {
            insertChangeInfo(configID, loginID, serviceAnswerTypeList, changeReason, creatorID, dealDesc, CHANGE_MANAGER);
        }
    }

    /**
     *  构建正常状态的实体
     */
    private B_TableManagerInfoEntity buildB_TableManagerInfoEntity(Long archiveID, Long loginID, Long mealsID, Long areaID,
            Long tableID, String tableCode, String tableName, Long serviceAnswerType, Long creatorID){
        B_TableManagerInfoEntity entity = new B_TableManagerInfoEntity();
        entity.setConfigID(MaxIDUtils.getID(B_TableManagerInfoEntity.class));
        entity.setArchiveID(archiveID);
        entity.setLoginID(loginID);
        entity.setMealsID(mealsID);
        entity.setAreaID(areaID);
        entity.setTableID(tableID);
        entity.setTableCode(tableCode);
        entity.setTableName(tableName);
        entity.setManageType(0L); //这个属性干什么的？要求不能为空
        entity.setServiceAnswerType(serviceAnswerType);
        entity.setMappingStatus(STATUS_NORMAL);
        entity.setCreatorID(creatorID);
        entity.setCreateTime(LocalDateTime.now());
        return entity;
    }

    /**
     * 校验新增桌台负责人数据是否合法
     * @param tableManagerVO
     * @throws BizException
     */
    private void checkAddTableManagerParam(TableManagerVO tableManagerVO) throws BizException {
        if (tableManagerVO == null
                || tableManagerVO.getTableID() == null
                || CollectionUtils.isEmpty(tableManagerVO.getDutyVOList())
                || tableManagerVO.getDutyVOList().size() > 1) { //每次添加单个桌台负责人
            logger.error("param error..");
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }

        TableManagerSettingVO dutyVO = tableManagerVO.getDutyVOList().get(0);
        Set<Long> serviceAnswerTypeList = dutyVO.getServiceAnswerTypeList();
        if (CollectionUtils.isEmpty(serviceAnswerTypeList)
                || dutyVO.getLoginID() == null
                || dutyVO.getMealsID() == null) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        //校验该桌台是否存在该负责人
        Long loginID = dutyVO.getLoginID();
        Long mealsID = dutyVO.getMealsID();
        Long tableID = tableManagerVO.getTableID();
        Map<String, Object> map = new HashMap<>();
        map.put("archiveID", tableManagerVO.getArchiveID());
        map.put("loginID", loginID);
        map.put("mealsID", mealsID);
        map.put("tableID", tableID);
        map.put("mappingStatus", STATUS_NORMAL);
        List<B_TableManagerInfoEntity> resultList = tableManagerInfoDao.getTableManagerByParams(map);
        if (!CollectionUtils.isEmpty(resultList)) {
            throw new BizException(CodeMsgConstants.TABLE_MANAGER_EXIST, CodeMsgConstants.TABLE_MANAGER_EXIST_MSG);
        }
    }

    /**
     * 删除桌台负责人
     * @param tableManagerVO
     * @param creatorID
     * @throws BizException
     */
    @Transactional(rollbackFor = Exception.class)
    public void removeTableManagerInfo(TableManagerVO tableManagerVO, Long creatorID) throws BizException {
        checkRemoveTableManagerParam(tableManagerVO);
        Long tableID = tableManagerVO.getTableID();
        TableManagerSettingVO dutyVO = tableManagerVO.getDutyVOList().get(0);
        //这里的configID, 是根据LoginID分组后的某一个configID
        Long mealsID = dutyVO.getMealsID();
        Long loginID = dutyVO.getLoginID();
        Long changeReason = dutyVO.getChangeReason();
        String dealDesc = dutyVO.getDealDesc();

        //多项服务内容对应多条桌台负责人记录。坑。。。但是调整信息只对应一条
        //先查询出待移除的记录，再标记状态为已失效
        Map<String, Object> map = new HashMap<>();
        map.put("archiveID", tableManagerVO.getArchiveID());
        map.put("loginID", loginID);
        map.put("mealsID", mealsID);
        map.put("tableID", tableID);
        Long configID = null;
        List<B_TableManagerInfoEntity> resultList = tableManagerInfoDao.getTableManagerByParams(map);
        if (!CollectionUtils.isEmpty(resultList)) {
            for (B_TableManagerInfoEntity entity: resultList) {
                updateMappingStatus(entity.getConfigID(), STATUS_DELETED);
                if (configID == null) {
                    configID = entity.getConfigID();
                }
            }
        }
        if (configID != null) {
            Set<Long> serviceAnswerTypeList = dutyVO.getServiceAnswerTypeList();
            insertChangeInfo(configID, loginID, serviceAnswerTypeList, changeReason, creatorID, dealDesc, CHANGE_MANAGER);
        }
    }

    private void updateMappingStatus(Long configID, Long mappingStatus) {
        B_TableManagerInfoEntity temp = new B_TableManagerInfoEntity();
        temp.setConfigID(configID);
        temp.setMappingStatus(mappingStatus);
        tableManagerInfoDao.updateByPrimaryKeySelective(temp);
    }

    private void insertChangeInfo(Long configID, Long loginID, Set<Long> serviceAnswerTypeList,
                                                    Long changeReason, Long creatorID, String dealDesc, Long changeType) {
        B_TableManagerChangeInfoEntity changeInfoEntity = new B_TableManagerChangeInfoEntity();
        changeInfoEntity.setChangeID(MaxIDUtils.getID(B_TableManagerChangeInfoEntity.class));
        changeInfoEntity.setConfigID(configID);
        changeInfoEntity.setChangeType(changeType);
        changeInfoEntity.setAfterLoginID(loginID);//这个移除前，移除后同一个操作类型
        changeInfoEntity.setAfterManageType(StringUtils.toDelimitedString(serviceAnswerTypeList, ","));
        changeInfoEntity.setChangeReason(changeReason);
        changeInfoEntity.setDealDesc(dealDesc);
        changeInfoEntity.setCreatorID(creatorID);
        changeInfoEntity.setCreateTime(LocalDateTime.now());
        changeInfoEntity.setApproveTime(LocalDateTime.now());
        tableManagerChangeInfoDao.insertSelective(changeInfoEntity);
    }
    /**
     * 校验移除桌台负责人数据是否合法
     * @param tableManagerVO
     * @throws BizException
     */
    private void checkRemoveTableManagerParam(TableManagerVO tableManagerVO) throws BizException {
        if (tableManagerVO == null
                || tableManagerVO.getTableID() == null
                || CollectionUtils.isEmpty(tableManagerVO.getDutyVOList())
                || tableManagerVO.getDutyVOList().size() > 1) { //单条移除桌台负责人
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }

        TableManagerSettingVO dutyVO = tableManagerVO.getDutyVOList().get(0);
        if (dutyVO.getLoginID() == null || dutyVO.getMealsID() == null) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        //校验该桌台是否存在该负责人
        Long loginID = dutyVO.getLoginID();
        Long mealsID = dutyVO.getMealsID();
        Long tableID = tableManagerVO.getTableID();
        Map<String, Object> map = new HashMap<>();
        map.put("archiveID", tableManagerVO.getArchiveID());
        map.put("loginID", loginID);
        map.put("mealsID", mealsID);
        map.put("tableID", tableID);
        map.put("mappingStatus", STATUS_NORMAL);
        List<B_TableManagerInfoEntity> resultList = tableManagerInfoDao.getTableManagerByParams(map);
        //未找到待移除的桌台负责人
        if (CollectionUtils.isEmpty(resultList)) {
            throw new BizException(CodeMsgConstants.NODATA, CodeMsgConstants.NODATA_MSG);
        }
    }

    /**
     * 调整桌台负责人的服务内容, 不区分餐次
     * @param tableManagerVO
     * @param creatorID
     * @throws BizException
     */
    @Transactional(rollbackFor = Exception.class)
    public void adjustServiceContent(TableManagerVO tableManagerVO, Long creatorID, Long adjustType) throws BizException {
        checkAdjustServiceContentParam(tableManagerVO, adjustType);
        Long tableID = tableManagerVO.getTableID();

        TableManagerSettingVO dutyVO = tableManagerVO.getDutyVOList().get(0);
        //这里的configID, 是根据LoginID分组后的某一个configID
        Long configID = null;
        Long loginID = dutyVO.getLoginID();
        //先查询出待移除的记录，再标记状态为已失效
        Map<String, Object> map = new HashMap<>();
        map.put("archiveID", tableManagerVO.getArchiveID());
        map.put("loginID", loginID);
        if (adjustType.longValue() == 1L) {
            map.put("tableID", tableID);
            //该负责人当前负责桌台列表（含所有餐次，所有关联状态）
            List<B_TableManagerInfoEntity> resultList = tableManagerInfoDao.getTableManagerByParams(map);
            adjustTableServiceType(tableManagerVO, resultList, creatorID);
        }
        else if (adjustType.longValue() == 2L) {
            //该负责人所负责的所有桌台列表（含所有餐次，所有关联状态）
            List<B_TableManagerInfoEntity> resultList = tableManagerInfoDao.getTableManagerByParams(map);
            //按桌台分组
            Map<Long, List<B_TableManagerInfoEntity>> mapByTableID = getMapByTableID(resultList);
            Set<Map.Entry<Long, List<B_TableManagerInfoEntity>>> entrySet = mapByTableID.entrySet();
            for (Map.Entry<Long, List<B_TableManagerInfoEntity>> entry : entrySet) {
                List<B_TableManagerInfoEntity> tableResultList = entry.getValue();
                adjustTableServiceType(tableManagerVO, tableResultList, creatorID);
            }
        }
    }

    /**
     * @param tableManagerVO
     * @param tableResultList  同一个桌台ID的所有桌台负责人信息
     * @param creatorID
     */
    private void adjustTableServiceType(TableManagerVO tableManagerVO, List<B_TableManagerInfoEntity> tableResultList, Long creatorID) {
        if (!CollectionUtils.isEmpty(tableResultList)) {
            TableManagerSettingVO dutyVO = tableManagerVO.getDutyVOList().get(0);
            //这里的configID, 是根据LoginID分组后的某一个configID
            Long configID = null;
            B_TableManagerInfoEntity tableManagerInfo = tableResultList.get(0);
            Long areaID = dutyVO.getAreaID();
            Long loginID = dutyVO.getLoginID();
            Long changeReason = dutyVO.getChangeReason();
            String dealDesc = dutyVO.getDealDesc();
            Set<Long> serviceAnswerTypeList = dutyVO.getServiceAnswerTypeList();

            //应用到所有桌台时，需要所有的桌台信息，所以TableManagerSettingVO前端桌台信息前端没传
            Long tableID = tableManagerInfo.getTableID();
            String tableCode = tableManagerInfo.getTableCode();
            String tableName = tableManagerInfo.getTableName();

            Map<Long, List<B_TableManagerInfoEntity>> dbMealsMap = new HashMap<>();
            for (B_TableManagerInfoEntity result : tableResultList) {
                addItemToMap(dbMealsMap, result);
            }
            //按照餐次分组，对比每个餐次的服务内容，少了内容要新增，多了内容要移除。
            Set<Map.Entry<Long, List<B_TableManagerInfoEntity>>> dbMealsEntrySet = dbMealsMap.entrySet();
            for (Map.Entry<Long, List<B_TableManagerInfoEntity>> entry : dbMealsEntrySet) {
                Long mealsID = entry.getKey();
                List<B_TableManagerInfoEntity> dbMeaslEntityList = entry.getValue();
                List<B_TableManagerInfoEntity> toBeRemovedService = findToBeRemovedService(dbMeaslEntityList, serviceAnswerTypeList);
                //更改为 已失效状态
                for (B_TableManagerInfoEntity temp : toBeRemovedService) {
                    if (configID == null) {
                        configID = temp.getConfigID();
                    }
                    updateMappingStatus(temp.getConfigID(), STATUS_DELETED);
                }
                //更改状态为正常
                List<B_TableManagerInfoEntity> toBeUpdateStatusService = findToBeUpdateStatusService(dbMeaslEntityList, serviceAnswerTypeList);
                for (B_TableManagerInfoEntity temp : toBeUpdateStatusService) {
                    if (configID == null) {
                        configID = temp.getConfigID();
                    }
                    updateMappingStatus(temp.getConfigID(), STATUS_NORMAL);
                }
                //新增各餐次桌台负责人
                List<Long> toBeAddedService = findToBeAddedService(dbMeaslEntityList, serviceAnswerTypeList);
                for (Long temp : toBeAddedService) {
                    B_TableManagerInfoEntity b_tableManagerInfoEntity = buildB_TableManagerInfoEntity(tableManagerVO.getArchiveID(), loginID, mealsID, areaID,
                            tableID, tableCode, tableName, temp, creatorID);
                    if (configID == null) {
                        configID = b_tableManagerInfoEntity.getConfigID();
                    }
                    tableManagerInfoDao.insertSelective(b_tableManagerInfoEntity);
                }
            }

            if (configID != null) {
                insertChangeInfo(configID, loginID, serviceAnswerTypeList, changeReason, creatorID, dealDesc, CHANGE_DUTY);
            }
        }
    }

    private Map<Long, List<B_TableManagerInfoEntity>> getMapByTableID(List<B_TableManagerInfoEntity> resultList) {
        Map<Long, List<B_TableManagerInfoEntity>> tableIDMap = new HashMap<>();
        if (resultList != null) {
            for (B_TableManagerInfoEntity dbEntity : resultList) {
                Long tableID = dbEntity.getTableID();
                if (tableID != null) {
                    if (tableIDMap.get(tableID) == null) {
                        List<B_TableManagerInfoEntity> tempList = new ArrayList<>();
                        tempList.add(dbEntity);
                        tableIDMap.put(tableID, tempList);
                    }
                    else {
                        tableIDMap.get(tableID).add(dbEntity);
                    }
                }
            }
        }
        return tableIDMap;
    }

    /**
     * 原来配置了3项内容1，2，3 ，4（失效的）， 修改为3，4，5，那么1，2就要更改为失效状态， 5要新增，4修改为有效状态
     */
    private List<B_TableManagerInfoEntity> findToBeRemovedService(List<B_TableManagerInfoEntity> dbMeaslEntityList,
            Set<Long> serviceAnswerTypeList) {
        List<B_TableManagerInfoEntity> toRemovedList = new ArrayList<>();
        for (B_TableManagerInfoEntity dbEntity : dbMeaslEntityList) {
            Long dbService = dbEntity.getServiceAnswerType();
            if (!serviceAnswerTypeList.contains(dbService)) {
                if (dbEntity != null && dbEntity.getMappingStatus() != null && dbEntity.getMappingStatus().longValue() == STATUS_NORMAL.longValue()) {
                    toRemovedList.add(dbEntity);
                }
            }
        }
        return toRemovedList;
    }

    /**
     * 原来配置了3项内容1，2，3 ，4（失效的）， 修改为3，4，5，那么1，2就要更改为失效状态， 5要新增，4修改为有效状态
     */
    private List<Long> findToBeAddedService(List<B_TableManagerInfoEntity> dbMeaslEntityList, Set<Long> serviceAnswerTypeList) {
        List<Long> dbServiceList = new ArrayList<>();
        for (B_TableManagerInfoEntity dbEntity : dbMeaslEntityList) {
            if (dbEntity.getServiceAnswerType() != null) {
                dbServiceList.add(dbEntity.getServiceAnswerType());
            }
        }
        List<Long> toAddedList = new ArrayList<>();
        for (Iterator<Long> ite = serviceAnswerTypeList.iterator(); ite.hasNext(); ) {
            Long next = ite.next();
            if (!dbServiceList.contains(next)) {
                toAddedList.add(next);
            }
        }
        return toAddedList;
    }

    /**
     * 查原来配置了3项内容1，2，3 ，4（失效的）， 修改为3，4，5，那么1，2就要更改为失效状态， 5要新增，4修改为有效状态
     * @param dbMeaslEntityList
     * @param serviceAnswerTypeList
     * @return
     */
    private List<B_TableManagerInfoEntity> findToBeUpdateStatusService(List<B_TableManagerInfoEntity> dbMeaslEntityList, Set<Long> serviceAnswerTypeList) {
        List<B_TableManagerInfoEntity> toUpdatedList = new ArrayList<>();
        List<Long> dbServiceList = new ArrayList<>();
        Map<Long, B_TableManagerInfoEntity> serviceMap = new HashMap<>();
        for (B_TableManagerInfoEntity dbEntity : dbMeaslEntityList) {
            if (dbEntity.getServiceAnswerType() != null) {
                dbServiceList.add(dbEntity.getServiceAnswerType());
                serviceMap.put(dbEntity.getServiceAnswerType(), dbEntity);
            }
        }
        for (Iterator<Long> ite = serviceAnswerTypeList.iterator(); ite.hasNext(); ) {
            Long next = ite.next();
            if (dbServiceList.contains(next)) {
                B_TableManagerInfoEntity temp = serviceMap.get(next);
                if (temp != null && temp.getMappingStatus() != null && temp.getMappingStatus().longValue() == STATUS_DELETED.longValue()) {
                    toUpdatedList.add(temp);
                }

            }
        }
        return toUpdatedList;
    }

    private void addItemToMap(Map<Long, List<B_TableManagerInfoEntity>> mealsMap, B_TableManagerInfoEntity entity) {
        Long mealsID = entity.getMealsID();
        if (mealsID != null) {
            List<B_TableManagerInfoEntity> mealsMapValueList = mealsMap.get(mealsID);
            if (mealsMapValueList == null) {
                mealsMapValueList = new ArrayList<>();
                mealsMapValueList.add(entity);
                mealsMap.put(mealsID, mealsMapValueList);
            }
            else {
                mealsMapValueList.add(entity);
            }
        }
    }

    /**
     * 校验调整桌台负责人服务内容请求参数是否合法
     * @param tableManagerVO
     * @throws BizException
     */
    private void checkAdjustServiceContentParam(TableManagerVO tableManagerVO, Long adjustType) throws BizException {
        if (tableManagerVO == null
                || tableManagerVO.getTableID() == null
                || CollectionUtils.isEmpty(tableManagerVO.getDutyVOList())
                || tableManagerVO.getDutyVOList().size() > 1
                || adjustType == null
                || (adjustType.longValue() != 1L && adjustType.longValue() != 2L)) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }

        TableManagerSettingVO dutyVO = tableManagerVO.getDutyVOList().get(0);
        if (dutyVO.getLoginID() == null || dutyVO.getMealsID() == null) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        //校验该桌台是否存在该负责人
        Long loginID = dutyVO.getLoginID();
        Long mealsID = dutyVO.getMealsID();
        Long tableID = tableManagerVO.getTableID();
        Map<String, Object> map = new HashMap<>();
        map.put("archiveID", tableManagerVO.getArchiveID());
        map.put("loginID", loginID);
        map.put("mealsID", mealsID);
        map.put("tableID", tableID);
        map.put("mappingStatus", STATUS_NORMAL);
        List<B_TableManagerInfoEntity> resultList = tableManagerInfoDao.getTableManagerByParams(map);
        //未找到该桌台负责人
        if (CollectionUtils.isEmpty(resultList)) {
            throw new BizException(CodeMsgConstants.NODATA, CodeMsgConstants.NODATA_MSG);
        }
    }

    /**
     * 查询调整历史记录
     */
    public List<TableManagerChangeInfoVO> getTableChangeInfo(Map<String, Object> map) {
        String dutyDay = (String) map.get("dutyDay");
        if (DateUtils.getCurrentDate().equals(dutyDay)) {
            List<TableManagerChangeInfoVO> tableManagerChangeInfo = tableManagerChangeInfoDao.getTableManagerChangeInfo(map);
            if (tableManagerChangeInfo != null) {
                Map<Long, String> userInfo = getUserInfo();
                Map<Long, ServiceAnswerTypeVO> serviceAnswerTypeMap = getServiceAnswerTypeMap();
                for (TableManagerChangeInfoVO changeInfoVO : tableManagerChangeInfo) {
                    setUserName(changeInfoVO, userInfo);
                    changeInfoVO.setChangeObjectName(userInfo.get(changeInfoVO.getAfterLoginID()));
                    setServiceName(changeInfoVO, serviceAnswerTypeMap);
                    setOperationReason(changeInfoVO);
                }
            }
            return tableManagerChangeInfo;
        }
        return null;
    }
    private void setUserName(TableManagerChangeInfoVO changeInfoVO, Map<Long, String> userInfo) {
        try {
            Long afterLoginID = changeInfoVO.getAfterLoginID();
            changeInfoVO.setChangeObjectName(userInfo.get(afterLoginID));
            changeInfoVO.setCreator(userInfo.get(changeInfoVO.getCreatorID()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setOperationReason(TableManagerChangeInfoVO changeInfoVO) {
        String changeReasonName = changeInfoVO.getChangeReasonName();
        if (changeReasonName == null || changeReasonName.isEmpty()) {
            changeInfoVO.setOperationReason(changeInfoVO.getDealDesc());
        }
        else {
            changeInfoVO.setOperationReason(changeReasonName);
        }
    }

    private void setServiceName(TableManagerChangeInfoVO changeInfoVO, Map<Long, ServiceAnswerTypeVO> serviceAnswerTypeMap) {
        StringBuffer stringBuffer = new StringBuffer("");
        try {
            String afterManageType = changeInfoVO.getAfterManageType();
            if (afterManageType != null) {
                String[] strings = afterManageType.split(",");
                for (int i = 0; i < strings.length; i++) {
                    String temp = strings[i];
                    Long service = Long.parseLong(temp);
                    ServiceAnswerTypeVO serviceAnswerTypeVO = serviceAnswerTypeMap.get(service);
                    if (serviceAnswerTypeVO != null) {
                        stringBuffer.append(serviceAnswerTypeVO.getServiceAnswerTypeName());
                    }
                    if (i != strings.length - 1) {
                        stringBuffer.append("、");
                    }
                }
            }
            changeInfoVO.setServiceName(stringBuffer.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Map<Long, String> getUserInfo() {
        Map<Long, String> userMap = new HashMap<>();
        try {
            List<Map<String, Object>> userInfo = tableManagerChangeInfoDao.getUserInfo();
            if (userInfo != null) {
                for (Map<String, Object> user : userInfo) {
                    Long loginID = Long.parseLong(String.valueOf(user.get("LoginID")));
                    String userName = (String) user.get("UserName");
                    if (userName != null) {
                        userMap.put(loginID, userName);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userMap;
    }

}
