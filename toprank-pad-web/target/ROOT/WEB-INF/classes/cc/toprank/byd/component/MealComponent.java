package cc.toprank.byd.component;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.common.utils.DateUtils;
import cc.toprank.byd.common.utils.ObjectUtil;
import cc.toprank.byd.constant.ParamConstants;
import cc.toprank.byd.dao.B_MealTableMappingDao;
import cc.toprank.byd.dao.B_MealsInfoDao;
import cc.toprank.byd.entity.B_DinningTableInfoEntity;
import cc.toprank.byd.entity.B_MealTableMappingEntity;
import cc.toprank.byd.entity.B_MealsInfoEntity;
import cc.toprank.byd.enums.MerchantManageEnum;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 餐次组件
 *
 * @author LinYN
 * @date 2017-5-13
 */
@Component
public class MealComponent implements ParamConstants.TableParam{

    @Autowired
    private B_MealTableMappingDao mealTableMappingDao;

    @Autowired
    private B_MealsInfoDao mealsInfoDao;

    @Autowired
    private TableComponent tableComponent;

    /**
   * 获取餐次桌台表信息记录
   *
   * @param tableInfo 桌台
   *
   * @author LinYN
   * @date 2017-4-7
   */
    public List<B_MealTableMappingEntity> getMealTableMappingInfo(B_DinningTableInfoEntity tableInfo) {
        HashMap<String,Object> queryParam = new HashMap<>();
        queryParam.put(PARAM_TABLE_ID, tableInfo.getTableID());
        queryParam.put(PARAM_TABLE_STATUS, MerchantManageEnum.TableStatus.PLACEMAN.getValue());//使用状态
        return mealTableMappingDao.getMealTableMappingEntityByTableIDAndTableStatus(queryParam);
    }

    /**
     * 根据桌台编号改变当前使用中的桌台餐次信息中的桌台状态
     *
     * @param tableInfo 桌台使用信息
     * @throws Exception
     *
     * @author LinYN
     * @date 2017-3-27
     */
    public void updateMealTableMappingByTableInfo(B_DinningTableInfoEntity tableInfo) throws Exception {
        B_MealTableMappingEntity updateParam = new B_MealTableMappingEntity();
        updateParam.setTableID(tableInfo.getTableID());
        updateParam.setTableStatus(tableInfo.getTableStatus());
        mealTableMappingDao.updateTableStatusByTableID(updateParam);
    }


    /**
     * 根据桌台编号改变当前使用中的桌台餐次信息中的桌台状态和预订状态
     *
     * @param tableInfo 桌台使用信息
     * @param isBooking 是否预订
     * @throws Exception
     *
     * @author LinYN
     * @date 2017-5-18
     */
    public void updateMealTableMappingByTableInfoAndBookingStatus(B_DinningTableInfoEntity tableInfo, boolean isBooking) throws Exception {
        B_MealTableMappingEntity updateParam = new B_MealTableMappingEntity();
        updateParam.setTableID(tableInfo.getTableID());
        updateParam.setTableStatus(tableInfo.getTableStatus());
        updateParam.setIsBooking(isBooking);
        mealTableMappingDao.updateTableStatusAndBookingByTableID(updateParam);
    }

    /**
    * 获取桌台的当前餐次
    *
    * @param tableInfo 桌台信息
    * @throws Exception 没有餐次信息
    *
    * @author LinYN
    * @date 2017-3-27
    */
    public B_MealsInfoEntity getCurrentMealsInfoOfTable(B_DinningTableInfoEntity tableInfo) {
        return getCurrentMealsInfo(tableInfo);
    }

    /**
     * 根据餐次ID查询餐次信息
     * @param mealsID
     * @return
     */
    public B_MealsInfoEntity getMealsInfoByMealsID(Long mealsID){
        if (mealsID == null) throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        B_MealsInfoEntity mealsInfo = new B_MealsInfoEntity();
        mealsInfo.setMealsID(mealsID);
        mealsInfo = mealsInfoDao.get(mealsInfo);
        if (mealsInfo == null) {
            throw new BizException(CodeMsgConstants.NO_MEALS_DATA, CodeMsgConstants.NO_MEALS_DATA_MSG);
        }
        return  mealsInfo;
    }

    /**
     * 查询当前餐次
     * @param tableInfo
     * @return
     */
    public B_MealsInfoEntity getCurrentMealsInfo(B_DinningTableInfoEntity tableInfo){
        B_MealsInfoEntity queryParam = new B_MealsInfoEntity();
        queryParam.setArchiveID(tableInfo.getArchiveID());
        queryParam.setAreaID(tableInfo.getAreaID());
        queryParam.setStartTime(LocalDateTime.now());
        B_MealsInfoEntity mealsInfo = mealsInfoDao.getCurrentMealsInfo(queryParam);
        if (mealsInfo == null) {
            throw new BizException(CodeMsgConstants.NO_TABLE_MEALS_DATA, CodeMsgConstants.NO_TABLE_MEALS_DATA_MSG, tableComponent.getDisplayTableName(tableInfo));
        }
        return mealsInfo;
    }

    public B_MealsInfoEntity getCurrentMealsInfo(Long archiveID,Long areaID,LocalDateTime time){
        B_MealsInfoEntity queryParam = new B_MealsInfoEntity();
        queryParam.setArchiveID(archiveID);
        queryParam.setAreaID(areaID);
        queryParam.setStartTime(time);
        B_MealsInfoEntity mealsInfo = mealsInfoDao.getCurrentMealsInfo(queryParam);
        if (mealsInfo == null) {
            throw new BizException(CodeMsgConstants.NO_MEALS_DATA, CodeMsgConstants.NO_MEALS_DATA_MSG);
        }
        return mealsInfo;
    }

    /**
     * 查询餐次
     * @param map
     * @return
     */
    public B_MealsInfoEntity getMealsInfo( Map<String,Object> map) throws Exception{
        B_MealsInfoEntity queryParam = new B_MealsInfoEntity();
        queryParam.setArchiveID(ObjectUtil.objectToLong(map.get(PARAM_ARCHIVE_ID)));
        queryParam.setAreaID(ObjectUtil.objectToLong(map.get(PARAM_AREA_ID)));
        queryParam.setStartTime(DateUtils.parseLocalDateTime(map.get(PARAM_TIME).toString()));
        B_MealsInfoEntity mealsInfo = mealsInfoDao.getCurrentMealsInfo(queryParam);
        if (mealsInfo == null) {
            throw new BizException(CodeMsgConstants.NO_TABLE_MEALS_DATA, CodeMsgConstants.NO_TABLE_MEALS_DATA_MSG,"");
        }
        return mealsInfo;
    }


}
