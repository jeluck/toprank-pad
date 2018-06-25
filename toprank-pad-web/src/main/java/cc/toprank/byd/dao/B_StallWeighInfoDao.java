package cc.toprank.byd.dao;

import cc.toprank.byd.entity.B_StallWeighInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by LanZY on 2017-5-2.
 */
public interface B_StallWeighInfoDao {
    B_StallWeighInfoEntity get(B_StallWeighInfoEntity stallWeighInfo);

    List<B_StallWeighInfoEntity> getAll();

    void update(B_StallWeighInfoEntity stallWeighInfo);

    void delete(B_StallWeighInfoEntity stallWeighInfo);

    void save(B_StallWeighInfoEntity stallWeighInfo);

    int deleteByPrimaryKey(Long weighid);

    int insert(B_StallWeighInfoEntity record);

    int insertSelective(B_StallWeighInfoEntity record);

    B_StallWeighInfoEntity selectByPrimaryKey(Long weighid);

    int updateByPrimaryKeySelective(B_StallWeighInfoEntity record);

    int updateByPrimaryKey(B_StallWeighInfoEntity record);

    int insertBatch(List<B_StallWeighInfoEntity> stallWeighInfoList);

    List<B_StallWeighInfoEntity> queryProductWeighingByCondition(Map param);

    List<B_StallWeighInfoEntity> queryWeighingRecordByCondition(Map map);


    /**
     * @Description： 根据订单明细查询称重商品关联数据
     * @Author：LanZY
     * @Time: 2017-5-16 13:34
     * @Version 2.0.0
     * @param detailIDs
     * @return
     */
    List<B_StallWeighInfoEntity> getStallWeighInfoByDetailIDs(String detailIDs);

    int deleteByDetailID(Long detailID);
}
