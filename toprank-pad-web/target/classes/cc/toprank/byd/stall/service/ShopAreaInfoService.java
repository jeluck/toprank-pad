package cc.toprank.byd.stall.service;

import cc.toprank.byd.dao.B_ShopAreaInfoDao;
import cc.toprank.byd.entity.B_ShopAreaInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 区域信息
 * Created by HuangCY on 2017-4-5.
 */
@Service
public class ShopAreaInfoService {

    @Autowired
    private B_ShopAreaInfoDao b_ShopAreaInfoMapper;

    /**
     * 根据条件查询区域信息
     *
     * @param map
     * @return
     */
    public List<B_ShopAreaInfoEntity> queryAreaInfoByCondition(Map map) {
        return b_ShopAreaInfoMapper.queryAreaInfoByCondition(map);
    }

    /**
     * @author 赵凌晨
     * @version 2.0.0
     * @description  获取所有区域信息（组装上下级结构）
     * @time 2017-04-19 16:00:00
     */
    public List<B_ShopAreaInfoEntity> getShopAreaInfoListByArchiveID(Long archiveID){
        List<B_ShopAreaInfoEntity> shopAreaInfoList = b_ShopAreaInfoMapper.getShopAreaInfoListByArchiveID(archiveID);

        List<B_ShopAreaInfoEntity> result = new ArrayList<>();
        //添加一级区域（父区域）
        for(int i = 0; i < shopAreaInfoList.size();i++){
            B_ShopAreaInfoEntity temp = shopAreaInfoList.get(i);
            if(temp.getParentID() == null || temp.getParentID() == 0){
                result.add(temp);
            }
        }
        //以树形结构，组装区域数据
        for(int i = 0; i < result.size() ; i++){
            B_ShopAreaInfoEntity parentAreaInfo = result.get(i);
            for(int j = 0; j < shopAreaInfoList.size(); j++){
                if(parentAreaInfo.getAreaID().equals(shopAreaInfoList.get(j).getParentID())){
                    parentAreaInfo.getChildList().add(shopAreaInfoList.get(j));
                }
            }
        }
        return result;
    }

}
