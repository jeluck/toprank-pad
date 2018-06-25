package cc.toprank.byd.dao;

import cc.toprank.byd.entity.B_BasicParamInfoEntity;
import cc.toprank.byd.entity.B_MerchantInfoEntity;

/**
 * 基本参数信息
 * Created by HuangCY on 2017-4-10.
 */
public interface B_BasicParamInfoDao {

    int deleteByPrimaryKey(Long paramID);

    int insert(B_BasicParamInfoEntity record);

    int insertSelective(B_BasicParamInfoEntity record);

    B_BasicParamInfoEntity selectByPrimaryKey(Long paramID);

    int updateByPrimaryKeySelective(B_BasicParamInfoEntity record);

    int updateByPrimaryKey(B_BasicParamInfoEntity record);

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 根据档案编号查询商户基本参数信息
     * @time 2017-4-10 14:14
     */
    B_BasicParamInfoEntity queryBasicParamByArchiveID (long archiveID);

    /**
     * @description：根据档案编号查询档案信息
     * @author：LiYC
     * @rime: 2017-2-20 17:16
     * @version 2.0.0
     * @param b_merchantInfo
     * @return
     */
    B_BasicParamInfoEntity selectByArchiveid(Long archiveID);

    /**
     * 根据档案编号查询商户基本参数信息
     * @author：chenkangyi
     * @rime: 2017-5-19 16:18
     * @param archiveID
     * @return
     */
    B_BasicParamInfoEntity selectInfoByArchiveid(Long archiveID);
}
