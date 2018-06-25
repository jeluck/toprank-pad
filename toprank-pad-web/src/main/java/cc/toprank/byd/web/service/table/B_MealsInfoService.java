package cc.toprank.byd.web.service.table;

import cc.toprank.byd.common.utils.DateUtils;
import cc.toprank.byd.dao.B_MealsInfoDao;
import cc.toprank.byd.entity.B_MealsInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**********************************************************************************************************************
 *
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   B_AttachmentInfoService 真实的业务实现类，允许修改
 *
 * ********************************************************************************************************************/
@Service("b_MealsInfoService")
public class B_MealsInfoService {

    @Autowired
    private B_MealsInfoDao mealsInfoDao;

    public B_MealsInfoEntity get(B_MealsInfoEntity mealsInfo) throws Exception {
        return mealsInfoDao.get(mealsInfo);
    }

    public List<B_MealsInfoEntity> getAll() throws Exception {
        return mealsInfoDao.getAll();
    }

    public void update(B_MealsInfoEntity mealsInfo) throws Exception {
        mealsInfoDao.update(mealsInfo);
    }

    public void delete(B_MealsInfoEntity mealsInfo) throws Exception {
        mealsInfoDao.delete(mealsInfo);
    }

    public void save(B_MealsInfoEntity mealsInfo) throws Exception {
        mealsInfoDao.save(mealsInfo);
    }

    /**
     * 根据  档案编号  获取餐次
     *
     * @param mealsInfo B_MealsInfoEntity
     * @date 2016-12-29
     * @return List<B_MealsInfoEntity>
     * @author LiuWH
     */
    public List<B_MealsInfoEntity> GetB_MealsInfoCollectionByArchiveID(B_MealsInfoEntity mealsInfo) {
        return mealsInfoDao.GetB_MealsInfoCollectionByArchiveID(mealsInfo);
    }

 /**
     * 根据  档案编号  获取餐次
     *
     * @date 2017-5-25
     * @return List<B_MealsInfoEntity>
     * @author Zhaolingchen
     */
    public List<B_MealsInfoEntity> getMealsInfoEntityListByArchiveID(Map map) {
        return mealsInfoDao.getMealsInfoEntityListByBooking(map);
    }

    /**
     * @author 赵凌晨
     * @version 2.0.0
     * @description 查询餐次信息
     * @time 2017-04-19
     */
    public List<B_MealsInfoEntity> getMealsInfoAndReserveTimeList(LocalDateTime reserveDateTime, Map map) {
        List<B_MealsInfoEntity> mealsInfoList = mealsInfoDao.getMealsInfoEntityListByBooking(map);
        return getReserveTimeMap(reserveDateTime,mealsInfoList);
    }


    /**
     * 获取可预订的餐次
     * @date 2017-5-17
     * @return					List<B_MealsInfoEntity>
     * @author Zhaolingchen
     */
    public List<B_MealsInfoEntity> getMealsInfoEntityListByBooking(Map param) {
        return getReserveTimeMap(mealsInfoDao.getMealsInfoEntityListByBooking(param));
    }

    /**
     * 拼凑餐次时间格式
     * @param reserveDateTime
     * @param mealsInfoList
     * @return
     */
    private List<B_MealsInfoEntity> getReserveTimeMap(LocalDateTime reserveDateTime, List<B_MealsInfoEntity> mealsInfoList){
        if(DateUtils.isSameDate(reserveDateTime,LocalDateTime.now())){
            return getReserveTimeMap(reserveDateTime.toLocalTime(),mealsInfoList);
        }
        return getReserveTimeMap(mealsInfoList);
    }

    /**
     * @author 赵凌晨
     * @version 2.0.0
     * @description  根据指定时间,餐次信息,拼桌预定可选择的时间段
     * @time 2017-04-25 14:00:00
     */
    private List<B_MealsInfoEntity> getReserveTimeMap(LocalTime reserveTime, List<B_MealsInfoEntity> mealsInfoList) {
        LocalDateTime reserveDateTime = reserveTime.atDate(LocalDate.now());
        for (B_MealsInfoEntity mealsInfoEntity : mealsInfoList) {
            List<String> timeList = new ArrayList<>();
            LocalTime startTime = mealsInfoEntity.getStartTime().toLocalTime();
            LocalTime endTime = mealsInfoEntity.getEndTime().toLocalTime();

            LocalDateTime startDateTime = startTime.atDate(LocalDate.now());
            LocalDateTime endDateTime = endTime.atDate(LocalDate.now());
            if(startDateTime.isAfter(endDateTime)){
                endDateTime = endDateTime.plusDays(1);
            }
            endDateTime = endDateTime.minusMinutes(mealsInfoEntity.getMinLength());

            LocalDateTime targetTime = LocalDateTime.from(startDateTime);
            while (true) {
                if (targetTime.isAfter(endDateTime)) {
                    break;
                }
                if (targetTime.isAfter(reserveDateTime) || targetTime.equals(reserveDateTime) ) {
                    mealsInfoEntity.getRserveTimeList().add(DateUtils.formaterLocalDateTime(targetTime, "HH:mm"));
                }
                targetTime = targetTime.plusMinutes(15);
            }
        }
        return mealsInfoList;
    }

    /**
     * @author 赵凌晨
     * @version 2.0.0
     * @description  根据指定时间,餐次信息,拼桌预定可选择的时间段
     * @time 2017-04-25 14:00:00
     */
    private List<B_MealsInfoEntity> getReserveTimeMap(List<B_MealsInfoEntity> mealsInfoList) {
        for (B_MealsInfoEntity mealsInfoEntity : mealsInfoList) {

            LocalTime startTime = mealsInfoEntity.getStartTime().toLocalTime();
            LocalTime endTime = mealsInfoEntity.getEndTime().toLocalTime();

            LocalDateTime startDateTime = startTime.atDate(LocalDate.now());
            LocalDateTime endDateTime = endTime.atDate(LocalDate.now());
            if(startDateTime.isAfter(endDateTime)){
                endDateTime = endDateTime.plusDays(1);
            }
            endDateTime = endDateTime.minusMinutes(mealsInfoEntity.getMinLength());

            LocalDateTime targetTime = LocalDateTime.from(startDateTime);
            while (targetTime.isBefore(endDateTime) || targetTime.equals(endDateTime)) {
                mealsInfoEntity.getRserveTimeList().add(DateUtils.formaterLocalDateTime(targetTime, "HH:mm"));
                targetTime = targetTime.plusMinutes(15);
            }
        }
        return mealsInfoList;
    }
}