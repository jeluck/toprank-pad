package cc.toprank.byd.web.service.booking;

import cc.toprank.byd.dao.B_PeriodConfigInfoDao;
import cc.toprank.byd.entity.B_PeriodConfigInfoEntity;
import cc.toprank.byd.enums.CommonManageEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**********************************************************************************************************************
 *
 * 版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司 B_AttachmentInfoService 真实的业务实现类，允许修改
 *
 ********************************************************************************************************************/
@Service("b_PeriodConfigInfoService")
public class B_PeriodConfigInfoService {

    @Autowired
    @Qualifier("b_PeriodConfigInfoDao")
    protected B_PeriodConfigInfoDao b_PeriodConfigInfoDao;

    public List<B_PeriodConfigInfoEntity> getPeriodConfigInfoList(Map param) {
        List<B_PeriodConfigInfoEntity> periodConfigInfoList = b_PeriodConfigInfoDao.getPeriodConfigInfoByCondition(param);
        //找不到信息就不通过mealsID查询
        if((periodConfigInfoList == null || periodConfigInfoList.isEmpty()) && param.get("mealsID") != null && StringUtils.isNotBlank(String.valueOf(param.get("mealsID")))){
            param.remove("mealsID");
            periodConfigInfoList = b_PeriodConfigInfoDao.getPeriodConfigInfoByCondition(param);
        }
        if((periodConfigInfoList == null || periodConfigInfoList.isEmpty()) && param.get("areaID") != null && StringUtils.isNotBlank(String.valueOf(param.get("areaID")))){
            param.remove("areaID");
            periodConfigInfoList = b_PeriodConfigInfoDao.getPeriodConfigInfoByCondition(param);
        }
        return periodConfigInfoList;
    }

    public List<B_PeriodConfigInfoEntity> getPeriodConfigInfoListSort(Map param) {
        return sortPeriodConfigInfoList(getPeriodConfigInfoList(param));
    }

    /**
     * 根据时间 升序排序
     * @param periodConfigInfoList
     * @return
     */
    private  List<B_PeriodConfigInfoEntity> sortPeriodConfigInfoList(List<B_PeriodConfigInfoEntity> periodConfigInfoList ){
        //根据查询出来的时间排序
        B_PeriodConfigInfoEntity periodConfigInfoTem = null;
        int index = 0;
        for (int i = 0, l = periodConfigInfoList.size(); i < l - 1; i++) {
            index = i;
            for (int j = i + 1; j < l; j++) {
                if (conversionMinute(periodConfigInfoList.get(index).getTimeUnit(), periodConfigInfoList.get(index).getDuration()) > conversionMinute(periodConfigInfoList.get(j).getTimeUnit(), periodConfigInfoList.get(j).getDuration())) {
                    index = j;
                }
            }
            periodConfigInfoTem = periodConfigInfoList.get(index);
            periodConfigInfoList.set(index, periodConfigInfoList.get(i));
            periodConfigInfoList.set(i, periodConfigInfoTem);
        }
        return periodConfigInfoList;
    }

    /**
     * 把年，天，小时等时间转为分钟
     *
     * @return
     */
    private int conversionMinute(long type, int date) {
        if (type == CommonManageEnum.DurationType.DAY.getValue()) {
            return 60 * 24 * date;
        } else if (type == CommonManageEnum.DurationType.HOUR.getValue()) {
            return 60 * date;
        } else if (type == CommonManageEnum.DurationType.MINUTE.getValue()) {
            return date;
        }
        return 0;
    }
}
