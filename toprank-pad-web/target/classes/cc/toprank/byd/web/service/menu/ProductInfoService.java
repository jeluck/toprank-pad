package cc.toprank.byd.web.service.menu;

import cc.toprank.byd.common.utils.MapHelper;
import cc.toprank.byd.common.utils.number.NumberUtil;
import cc.toprank.byd.component.MealComponent;
import cc.toprank.byd.component.TableComponent;
import cc.toprank.byd.constant.ParamConstants;
import cc.toprank.byd.dao.*;
import cc.toprank.byd.entity.B_DinningTableInfoEntity;
import cc.toprank.byd.entity.B_DinningTableUseInfoEntity;
import cc.toprank.byd.entity.B_MealsInfoEntity;
import cc.toprank.byd.entity.P_ComboGroupInfoEntity;
import cc.toprank.byd.pad.service.ProductService;
import cc.toprank.byd.vo.ProductInfoVO;
import cc.toprank.byd.web.vo.menu.ComboVO;
import cc.toprank.byd.web.vo.menu.ComboVO.ComboGroupVO;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description： 菜品service
 * @Author：LanZY
 * @Time: 2017-3-7 16:10
 * @Version 2.0.0
 */
@Service("productInfoService")
public class ProductInfoService {

    @Autowired
    ProductInfoDao productInfoDao;
    @Autowired
    B_DinningTableInfoDao dinningTableInfoDao;
    @Autowired
    B_DinningTableUseInfoDao dinningTableUseInfoDao;
    @Autowired
    B_MealsInfoDao mealsInfoDao;
    @Autowired
    P_ComboGroupInfoDao comboGroupInfoDao;
    @Autowired
    P_ComboGroupProductMappingDao comboGroupProductMappingDao;
    @Autowired
    B_MerchantMenuInfoDao merchantMenuInfoDao;
    @Autowired
    P_ProductInfoDao productDao;
    @Autowired
    ProductService productService;
    @Autowired
    TableComponent tableComponent;
    @Autowired
    MealComponent mealComponent;


    /**
     * @Description： 根据商品ID查询套餐分组信息
     * @Author：LanZY
     * @Time: 2017-4-26 11:50
     * @Version 2.0.0
     * @param productID
     * @return
     */
    public ComboVO getComboGroupInfoByProductID(Long productID){
        ComboVO comboVO = new ComboVO();
        List<P_ComboGroupInfoEntity> groupList = comboGroupInfoDao.getComboGroupInfoByProductID(productID);
        Map<Long,Object> map = new HashedMap();
        for (P_ComboGroupInfoEntity groupInfo :groupList) {
            ComboGroupVO comboGroupVO = new ComboGroupVO();
            if(null != groupInfo.getGroupID()){
                comboGroupVO.setGroupName(groupInfo.getGroupName());
                comboGroupVO.setGroupID(groupInfo.getGroupID());
                ComboGroupVO.GroupProductVO groupProductVO = new ComboGroupVO.GroupProductVO();
                groupProductVO.setVariantName(groupInfo.getVariantName());
                groupProductVO.setQuantity(groupInfo.getNumber());
                groupProductVO.setVariantID(groupInfo.getVariantID());
                groupProductVO.setMappingID(groupInfo.getMappingID());
                groupProductVO.setPrice(groupInfo.getPrice());
                groupProductVO.setUnit(groupInfo.getUnit());
                comboGroupVO.getGroupProductList().add(groupProductVO);
                if(!map.containsKey(groupInfo.getGroupID())){
                    map.put(groupInfo.getGroupID(),comboGroupVO);
                }else{
                    ComboGroupVO o = (ComboGroupVO)map.get(groupInfo.getGroupID());
                    o.getGroupProductList().add(groupProductVO);
                }
            }
        }

        List<ComboGroupVO> list = new ArrayList<>();
        Map<Long,Object> map2 = new HashedMap();
        for (P_ComboGroupInfoEntity groupInfo :groupList) {
            ComboGroupVO comboGroupVO = new ComboGroupVO();
            if(null != groupInfo.getGroupID()){
                comboGroupVO.setGroupName(groupInfo.getGroupName());
                comboGroupVO.setGroupID(groupInfo.getGroupID());
                comboGroupVO.setPriceType(groupInfo.getPriceType());
                if(map.containsKey(groupInfo.getGroupID())){
                    ComboGroupVO o = (ComboGroupVO) map.get(groupInfo.getGroupID());
                    comboGroupVO.getGroupProductList().addAll(o.getGroupProductList());
                }
                if(!map2.containsKey(groupInfo.getGroupID())){
                    map2.put(groupInfo.getGroupID(),comboGroupVO);
                    list.add(comboGroupVO);
                }
            }else{
                comboGroupVO.setPriceType(groupInfo.getPriceType());
                comboGroupVO.setSettingID(groupInfo.getSettingID());
                comboGroupVO.setUnit(groupInfo.getUnit());
                comboGroupVO.setVariantID(groupInfo.getVariantID());
                comboGroupVO.setPrice(groupInfo.getPrice());
                comboGroupVO.setAllowFloatQuantity(groupInfo.getAllowFloatQuantity());
                comboGroupVO.setAllowQuantity(groupInfo.getAllowQuantity());
                comboGroupVO.setOptionName(groupInfo.getOptionName());
                comboGroupVO.setQuantity(groupInfo.getNumber());
                comboGroupVO.setVariantName(groupInfo.getVariantName());
                comboVO.getBasicComboList().add(comboGroupVO);
            }
        }
        comboVO.getGroupComboList().addAll(list);
        return comboVO;
    }


    /**
     * @Description：根据餐厅编号区域编号餐次编号分类编号查询所有菜品
     * @Author：LanZY
     * @Time: 2017-3-7 16:15
     * @Version 2.0.0
     * @return
     */
    public List<ProductInfoVO> getProductListByCondition(Long categoryID,String searchCode,Long tableID,Long booking,String bookingTime) throws Exception{
        //查找桌台
        B_DinningTableInfoEntity tableInfo = tableComponent.getTableInfoById(tableID);
        Long mealsID;
        if(NumberUtil.intValue(booking) == 1){
            mealsID = getMealsID(bookingTime,tableInfo);
        }else{
            //查询开台时的餐次
            B_DinningTableUseInfoEntity dinningTableUseInfo =  tableComponent.getCurrentTableUseInfoByTableID(tableID);
            mealsID = dinningTableUseInfo.getMealsID();
        }
        Map<String,Object> map = new HashedMap();
        map.put(ParamConstants.TableParam.PARAM_AREA_ID,tableInfo.getAreaID());
        map.put(ParamConstants.TableParam.PARAM_MEALSID,mealsID);
        map.put(ParamConstants.GlobalParam.PARAM_ARCHIVE_ID,tableInfo.getArchiveID());
        map.put("categoryID",categoryID);
        map.put("searchCode",searchCode);
        List<ProductInfoVO> list = productInfoDao.getProductList(map);
        return list;
    }


    /**
     * @Description： 菜品分类
     * @Author：LanZY
     * @Time: 2017-6-1 18:02
     * @Version 2.0.0
     * @param archiveID
     * @param tableID
     * @param mealsID
     * @return
     */
    public List<Map<String, Object>> getCategoryList(Long archiveID,Long tableID,Long mealsID,Long booking,String bookingTime) throws Exception{
        //查找桌台
        B_DinningTableInfoEntity tableInfo = tableComponent.getTableInfoById(tableID);
        if(NumberUtil.intValue(booking) == 1){   //预定时用当前时间的mealsID
            mealsID = getMealsID(bookingTime, tableInfo);
        }else if(NumberUtil.intValue(mealsID) == 0){  //不是选择餐次情况时 用使用信息的mealsID
            //查询开台时的餐次
            B_DinningTableUseInfoEntity dinningTableUseInfo =  tableComponent.getCurrentTableUseInfoByTableID(tableID);
            mealsID = dinningTableUseInfo.getMealsID();
        }
        Map<String,Object> map = MapHelper.newMap();
        map.put(ParamConstants.TableParam.PARAM_AREA_ID,tableInfo.getAreaID());
        map.put(ParamConstants.TableParam.PARAM_MEALSID,mealsID);
        map.put(ParamConstants.GlobalParam.PARAM_ARCHIVE_ID,archiveID);
        return productService.getCategoryList(map);
    }

    private Long getMealsID(String bookingTime, B_DinningTableInfoEntity tableInfo) throws Exception {
        Long mealsID;Map<String,Object> mealsMap = new HashedMap();
        mealsMap.put(ParamConstants.GlobalParam.PARAM_ARCHIVE_ID, tableInfo.getArchiveID());
        mealsMap.put(ParamConstants.TableParam.PARAM_AREA_ID, tableInfo.getAreaID());
        mealsMap.put(ParamConstants.TableParam.PARAM_TIME, bookingTime);
        B_MealsInfoEntity mealsInfo = mealComponent.getMealsInfo(mealsMap);
        mealsID = mealsInfo.getMealsID();
        return mealsID;
    }


}
