package cc.toprank.byd.web.service.table;

import cc.toprank.byd.dao.B_DinningTableUseInfoDao;
import cc.toprank.byd.dao.B_MealTableMappingDao;
import cc.toprank.byd.dao.B_MealsInfoDao;
import cc.toprank.byd.entity.B_DinningTableUseInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**********************************************************************************************************************
 *
 * 版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司 B_AttachmentInfoService 真实的业务实现类，允许修改
 *
 ********************************************************************************************************************/
@Service("b_DinningTableUseInfoService")
public class B_DinningTableUseInfoService {


    @Autowired
    private B_MealTableMappingDao mealTableMappingDao;

    @Autowired
    private B_DinningTableUseInfoDao dinningTableUseInfoDao;

    @Autowired
    private B_MealsInfoDao mealsInfoDao;


    public B_DinningTableUseInfoEntity get(B_DinningTableUseInfoEntity dinningTableUseInfo) throws Exception {
        return dinningTableUseInfoDao.get(dinningTableUseInfo);
    }

    public List<B_DinningTableUseInfoEntity> getAll() throws Exception {
        return dinningTableUseInfoDao.getAll();
    }

    public void update(B_DinningTableUseInfoEntity dinningTableUseInfo) throws Exception {
        dinningTableUseInfoDao.update(dinningTableUseInfo);
    }

    public void delete(B_DinningTableUseInfoEntity dinningTableUseInfo) throws Exception {
        dinningTableUseInfoDao.delete(dinningTableUseInfo);
    }

    public void save(B_DinningTableUseInfoEntity dinningTableUseInfo) throws Exception {
        dinningTableUseInfoDao.save(dinningTableUseInfo);
    }

    /**
     * 拼桌后转出的桌台，需要插入一条新的桌台使用记录数据
     *
     * @param dinningTableUseInfo 实体
     * @throws Exception
     * @author xuexin
     */
    public void insertDinningTableUseInfoEntity(B_DinningTableUseInfoEntity dinningTableUseInfo) throws Exception {
        dinningTableUseInfoDao.save(dinningTableUseInfo);
    }


}