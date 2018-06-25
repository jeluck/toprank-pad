package cc.toprank.byd.web.controller.adjustprice;

import cc.toprank.byd.base.BaseController;
import cc.toprank.byd.stall.dto.MerchantMenuVO;
import cc.toprank.byd.stall.service.PriceAdjustmentService;
import cc.toprank.byd.stall.service.StallProductService;
import cc.toprank.byd.web.constant.ResultData;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 时价维护
 *
 * @author ZhaoLC
 * @Time 2017-3-10 14:00
 */
@RestController
@RequestMapping("/reception/adjustprice")
@Api(value = "/reception/adjustprice", description = "时价维护")
public class PriceAdjustmentController extends BaseController {
    @Autowired
    private PriceAdjustmentService priceAdjustmentService;
    @Autowired
    private StallProductService stallProductService;

    /**
     * 时价维护查询--查询出菜品对应的菜单价格
     *
     * @return
     * @author ZhaoLC
     * @Time 2017-3-10 14:00
     */
    @ApiOperation(value = "时价维护列表查询", httpMethod = "GET")
    @GetMapping(value = "/query", produces = "application/json;charset=UTF-8")
    public JSONPObject query(@ApiParam(value = "商品分类ID") @RequestParam(required = false) Long categoryID,
                             @ApiParam(value = "搜索关键字") @RequestParam(required = false) String searchKey) {
        HashMap paramMap = new HashMap();
        paramMap.put("categoryID", categoryID);
        paramMap.put("searchKey", searchKey);
        paramMap.put("archiveID", this.getArchiveID());
        List<Map<String, Object>> resultList = priceAdjustmentService.queryMerchantMenuAndProductInfoByCondition(paramMap);
        JSONArray resultArray = convertDateFormat(resultList);

        ResultData resultData = ResultData.makeSuccessResult(resultArray);
        return getResultJSONPObject(resultData);
    }

    private JSONArray convertDateFormat(List<Map<String, Object>> merchantMenuList) {
        JSONArray result = new JSONArray();
        for (Map<String, Object> merchantMenu : merchantMenuList) {
            if (merchantMenu.get("areaID") == null) {
                JSONObject merchantMenuObject = new JSONObject();
                merchantMenuObject.put("menuID", merchantMenu.get("menuID"));
                merchantMenuObject.put("menuName", merchantMenu.get("menuName"));
                merchantMenuObject.put("productName", merchantMenu.get("productName"));
                merchantMenuObject.put("price", merchantMenu.get("price"));
                merchantMenuObject.put("unitID", merchantMenu.get("unitID"));
                merchantMenuObject.put("productID", merchantMenu.get("productID"));
                merchantMenuObject.put("areaID", merchantMenu.get("areaID"));
                merchantMenuObject.put("child", new JSONArray());
                result.add(merchantMenuObject);
            }
        }

        for (Map<String, Object> merchantMenu : merchantMenuList) {
            if(merchantMenu.get("areaID") == null){
                continue;
            }
            for (int i = 0, l = result.size(); i < l; i++) {
                if (result.getJSONObject(i).get("productID").equals(merchantMenu.get("productID"))) {
                    result.getJSONObject(i).getJSONArray("child").add(merchantMenu);
                }
            }
        }
        return result;
    }

    /**
     * 时价维护查询--查询出菜品对应的菜单价格
     *
     * @return
     * @author ZhaoLC
     * @Time 2017-3-10 14:00
     */
    @ApiOperation(value = "调价", httpMethod = "GET")
    @GetMapping(value = "/priceAdjustment", produces = "application/json;charset=UTF-8")
    public JSONPObject priceAdjustment(@ApiParam(value = "调价数据json串") @RequestParam(required = true) String merchantMenuList) {
        List<MerchantMenuVO.MerchantMenu> menuList = JSONArray.parseArray(merchantMenuList, MerchantMenuVO.MerchantMenu.class);
        MerchantMenuVO merchantMenuVO = new MerchantMenuVO();
        merchantMenuVO.setMerchantMenuList(menuList);
        merchantMenuVO.setLoginId(this.getLoginID());
        boolean result = priceAdjustmentService.updateMerchantMenuPriceBatch(merchantMenuVO);
        ResultData resultData = ResultData.makeSuccessResult(result);
        return getResultJSONPObject(resultData);
    }

    /**
     * 调价记录查询--查询出菜品对应的菜单调价信息
     *
     * @return
     * @author ZhaoLC
     * @Time 2017-3-13 10:00
     */
    @ApiOperation(value = "调价记录查询", httpMethod = "GET")
    @GetMapping(value = "/queryMenuDealInfo", produces = "application/json;charset=UTF-8")
    public JSONPObject queryMenuDealInfo(@ApiParam(value = "商品分类ID") @RequestParam(required = false) Long categoryID,
                                         @ApiParam(value = "商品ID") @RequestParam(required = false) Long productID,
                                         @ApiParam(value = "搜索关键字") @RequestParam(required = false) String searchKey,
                                         @ApiParam(value = "开始时间") @RequestParam(required = false) String startTime,
                                         @ApiParam(value = "结束时间") @RequestParam(required = false) String endTime,
                                         HttpServletRequest request) {
        HashMap paramMap = new HashMap();
        paramMap.put("archiveID", this.getArchiveID());
        paramMap.put("categoryID", categoryID);
        paramMap.put("productID", productID);
        paramMap.put("searchKey", searchKey);
        paramMap.put("startTime", startTime);
        paramMap.put("endTime", endTime);
        List<Map<String, Object>> resultList = priceAdjustmentService.queryMerchantMenuDealByCondition(paramMap);
        ResultData resultData = ResultData.makeSuccessResult(resultList);
        return getResultJSONPObject(resultData);
    }
}
