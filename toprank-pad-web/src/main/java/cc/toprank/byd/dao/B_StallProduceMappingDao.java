package cc.toprank.byd.dao;

import cc.toprank.byd.entity.B_StallProduceMappingEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by LanZY on 2017-5-2.
 */
public interface B_StallProduceMappingDao {

    B_StallProduceMappingEntity get(B_StallProduceMappingEntity stallProduceMapping);

    List<B_StallProduceMappingEntity> getAll();

    void update(B_StallProduceMappingEntity stallProduceMapping);

    void delete(B_StallProduceMappingEntity stallProduceMapping);

    void save(B_StallProduceMappingEntity stallProduceMapping);


    /**
     * @param variantID
     * @return
     * @Description： 根据变体ID查询档口称重商品关联信息
     * @Author：LanZY
     * @Time: 2017-5-2 13:28
     * @Version 2.0.0
     */
    B_StallProduceMappingEntity getStallProduceMappingInfoByVariantID(Long variantID);

    int deleteByPrimaryKey(Long mappingid);

    int insert(B_StallProduceMappingEntity record);

    int insertSelective(B_StallProduceMappingEntity record);

    B_StallProduceMappingEntity selectByPrimaryKey(Long mappingid);

    int updateByPrimaryKeySelective(B_StallProduceMappingEntity record);

    int updateByPrimaryKey(B_StallProduceMappingEntity record);

    /**
     * 根据条件查询称重商品列表
     *
     * @param map
     * @return
     * @author HuangCY
     * @Time 2017-3-13
     */
    List<Map<String, Object>> queryProductWeighingByCondition(Map map);
}
