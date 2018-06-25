package cc.toprank.byd.pad.controller;

import cc.toprank.byd.common.utils.string.StringUtil;
import cc.toprank.byd.pad.pojo.OrderDishesDTO;
import cc.toprank.byd.pad.service.ProductService;
import cc.toprank.byd.pad.service.ShoppingCartService;
import cc.toprank.byd.pad.util.MerchantCacheUtils;
import cc.toprank.byd.service.ComboService;
import cc.toprank.byd.service.DesignerService;
import cc.toprank.byd.vo.DesignerVO;
import cc.toprank.byd.web.constant.ResultData;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.POST;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 点菜控制器
 *
 * @author LeeJun
 * @version 2.0.0
 * @time 2017-2-20 17:07
 */
@RestController
@RequestMapping("/pad/dishes")
@Api(value = "/pad/dishes", description = "点菜")
public class DishesController extends PadController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private DesignerService designerService;
    @Autowired
    private ComboService comboService;

    @ApiOperation(value = "菜品规格/属性信息", httpMethod = "GET", response = ResultData.class)
    @GetMapping(value = "/attribute/{menuID}", produces = "application/json;charset=UTF-8")
    public ResultData attribute(@ApiParam("菜单ID") @PathVariable("menuID") Long menuID) throws Exception {
        return ResultData.makeResult(productService.getAttributes(menuID));
    }

    @ApiOperation(value = "商品详情", httpMethod = "GET", response = ResultData.class)
    @GetMapping(value = "/productDetails/{menuID}", produces = "application/json;charset=UTF-8")
    public ResultData productDetails(@ApiParam("菜单ID") @PathVariable("menuID") Long menuID,
                                     @ApiParam(value = "是否为套餐,默认值为false", defaultValue = "false") @RequestParam(value = "isCombo", required = false, defaultValue = "false") boolean isCombo) throws Exception {
        return ResultData.makeResult(productService.getProductDetails(menuID, isCombo));
    }

    @ApiOperation(value = "套餐明细菜品", httpMethod = "GET", response = ResultData.class)
    @GetMapping(value = "/comboDetail/{productID}", produces = "application/json;charset=UTF-8")
    public ResultData comboDetail(@PathVariable("productID") Long productID) {
        return ResultData.makeResult(comboService.getComboDetail(productID));
    }

//    @ApiOperation(value = "添加菜品到购物车(已废弃)", httpMethod = "POST", response = ResultData.class)
//    @PostMapping(value = "/shoppingCart", produces = "application/json;charset=UTF-8")
//    public ResultData addShoppingCart(@RequestBody OrderDishesDTO.Dishes dishes) throws Exception {
//        return ResultData.makeResult(shoppingCartService.addShoppingCart(dishes));
//    }

//    @ApiOperation(value = "删除购物车中的单个菜品(已废弃)", httpMethod = "POST", response = ResultData.class)
//    @PostMapping(value = "/shoppingCart/{menuID}", produces = "application/json;charset=UTF-8")
//    public ResultData updateShoppingCart(@ApiParam("菜单菜品ID") @PathVariable("menuID") Long menuID,
//                                         @ApiParam(value = "锁定数量,默认值为1", defaultValue = "1") @RequestParam(value = "lockQuantity", required = false, defaultValue = "1") int lockQuantity) throws Exception {
//        return ResultData.makeResult(shoppingCartService.deleteShoppingCart(menuID, lockQuantity));
//    }

    @ApiOperation(value = "修改购物车中的菜品", httpMethod = "POST", response = ResultData.class)
    @PostMapping(value = "/shoppingCartDishes", produces = "application/json;charset=UTF-8")
    public ResultData updateShoppingCart(@RequestBody OrderDishesDTO.Dishes dishes) throws Exception {
        return ResultData.makeResult(shoppingCartService.updateShoppingCart(dishes));
    }

    @ApiOperation(value = "修改购物车中菜品的备注", httpMethod = "POST", response = ResultData.class)
    @PostMapping(value = "/dishesRemark", produces = "application/json;charset=UTF-8")
    public ResultData updateDishesRemark(@RequestParam("detailID") Long detailID, @RequestParam("memo") String memo) throws Exception {
        return ResultData.makeResult(shoppingCartService.updateDishesRemark(detailID, memo));
    }

    @ApiOperation(value = "获取购物车列表", httpMethod = "GET", response = ResultData.class)
    @GetMapping(value = "/shoppingCarts", produces = "application/json;charset=UTF-8")
    public ResultData getShoppingCarts() throws Exception {
        return ResultData.makeSuccessResult(shoppingCartService.getShoppingCarts());
    }

    @ApiOperation(value = "获取购物车汇总信息(购物车ID,数量,总价,备注)", httpMethod = "GET", response = ResultData.class)
    @GetMapping(value = "/shoppingCart", produces = "application/json;charset=UTF-8")
    public ResultData getShoppingCart() throws Exception {
        return ResultData.makeResult(shoppingCartService.getCartCollectByTableID());
    }

    @ApiOperation(value = "清空购物车", httpMethod = "POST", response = ResultData.class)
    @PostMapping(value = "/shoppingCarts", produces = "application/json;charset=UTF-8")
    public ResultData cleanShoppingCart() throws Exception {
        boolean isOK = shoppingCartService.cleanShoppingCart(MerchantCacheUtils.getCurrentTableID(), false);
        return ResultData.makeResult(isOK);
    }

    @ApiOperation(value = "购物车整单备注", httpMethod = "POST", response = ResultData.class)
    @PostMapping(value = "/orderRemarks/{cartID}", produces = "application/json;charset=UTF-8")
    public ResultData orderRemarks(@PathVariable("cartID") Long cartID, @RequestParam("memo") String memo) throws Exception {
        boolean isOK = shoppingCartService.orderRemarks(cartID, memo);
        return ResultData.makeResult(isOK);
    }

    @ApiOperation(value = "菜品厨师列表", httpMethod = "GET", response = ResultData.class)
    @GetMapping(value = "/designer", produces = "application/json;charset=UTF-8")
    public ResultData designer(@RequestParam("productID") Long productID, @RequestParam("variantID") Long variantID) throws Exception {
        List<DesignerVO> designerList = designerService.getProductDesigner(MerchantCacheUtils.getCurrentArchiveID(), productID, variantID);
        return ResultData.makeResult(designerList);
    }

    @ApiOperation(value = "保存已选厨师ID", httpMethod = "GET", response = ResultData.class)
    @PostMapping(value = "/designer", produces = "application/json;charset=UTF-8")
    public ResultData saveDesigner(@RequestParam("detailID") Long detailID, @RequestParam("designerID") Long designerID,
                                   @RequestParam("designerPrice") BigDecimal designerPrice) throws Exception {
        return ResultData.makeResult(shoppingCartService.saveDesigner(detailID, designerID, designerPrice));
    }

    @ApiOperation(value = "获取菜品在购物车中的数量", httpMethod = "POST", response = ResultData.class)
    @PostMapping(value = "/productNum", produces = "application/json;charset=UTF-8")
    public ResultData getProductNumByParam(@RequestBody Map<String, Object> param) throws Exception {
        param.put("tableID", MerchantCacheUtils.getCurrentTableID());
        return ResultData.makeResult(shoppingCartService.getProductNumByParam(param));
    }
}
