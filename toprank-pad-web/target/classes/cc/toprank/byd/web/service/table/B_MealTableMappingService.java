package cc.toprank.byd.web.service.table;

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.dao.B_MealTableMappingDao;
import cc.toprank.byd.entity.B_MealTableMappingEntity;
import cc.toprank.byd.enums.MerchantManageEnum;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**********************************************************************************************************************
 *
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   B_AttachmentInfoService 真实的业务实现类，允许修改
 *
 * ********************************************************************************************************************/
@Service("b_MealTableMappingService")
public class B_MealTableMappingService {


    @Autowired
    private B_MealTableMappingDao mealTableMappingDao;

    public B_MealTableMappingEntity get(B_MealTableMappingEntity mealTableMapping) throws Exception {
        return mealTableMappingDao.get(mealTableMapping);
    }

    public List<B_MealTableMappingEntity> getAll() throws Exception {
        return mealTableMappingDao.getAll();
    }

    public void update(B_MealTableMappingEntity mealTableMapping) throws Exception {
        mealTableMappingDao.update(mealTableMapping);
    }

    public void delete(B_MealTableMappingEntity mealTableMapping) throws Exception {
        mealTableMappingDao.delete(mealTableMapping);
    }

    public void save(B_MealTableMappingEntity mealTableMapping) throws Exception {
        mealTableMappingDao.save(mealTableMapping);
    }



    /**
     * @param list          餐次桌台集合
     * @throws Exception
     * @Description： 更新餐次桌台状态, 第一个更新为开台，其余更新为锁定
     * @Author：LanZY
     * @Time: 2017-4-5 10:44
     * @Version 2.0.0
     */
    public void updateMealTableMappingTableStatus(List<B_MealTableMappingEntity> list) throws Exception {
        B_MealTableMappingEntity one = list.get(0);
        one.setTableStatus(MerchantManageEnum.TableStatus.PLACEORDER.getValue());
        mealTableMappingDao.updateByPrimaryKeySelective(one);
        if (!CollectionUtils.isEmpty(list)) {
            for (int j = 1; j < list.size(); j++) {
                B_MealTableMappingEntity mapping = list.get(j);
                mapping.setTableStatus(MerchantManageEnum.TableStatus.LOCK.getValue());
                mealTableMappingDao.updateByPrimaryKeySelective(mapping);
            }
        }
    }

    public List<B_MealTableMappingEntity> getBetweenMealsTableMapping(Long tableID, LocalDateTime startTime, int minute) {
        List<B_MealTableMappingEntity> mealsTableList = mealTableMappingDao.getBetweenMealsTableMapping(tableID, startTime, minute);
        if (mealsTableList.isEmpty()) {
            throw new BizException("餐次桌台关联不能为空！");
        }
        return mealsTableList;
    }


}