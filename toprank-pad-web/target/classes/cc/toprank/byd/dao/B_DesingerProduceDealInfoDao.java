package cc.toprank.byd.dao;


import cc.toprank.byd.entity.B_DesingerProduceDealInfoEntity;

import java.util.List;

public interface B_DesingerProduceDealInfoDao {
    B_DesingerProduceDealInfoEntity get(B_DesingerProduceDealInfoEntity entity);

    List<B_DesingerProduceDealInfoEntity> getAll();

    void update(B_DesingerProduceDealInfoEntity entity);

    void delete(B_DesingerProduceDealInfoEntity entity);

    void save(B_DesingerProduceDealInfoEntity entity);

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 新增厨师制作变动信息
     * @time 2017-6-18 19:29
     */
    void saveDesingerProduceDealInfo(B_DesingerProduceDealInfoEntity entity);
}