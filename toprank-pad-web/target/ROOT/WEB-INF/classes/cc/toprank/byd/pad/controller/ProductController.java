package cc.toprank.byd.pad.controller;

import cc.toprank.byd.dao.CommonMapper;
import cc.toprank.byd.pad.service.ProductService;
import cc.toprank.byd.pad.util.MerchantCacheUtils;
import cc.toprank.byd.web.constant.ResultData;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pad/product")
@Api(value = "/pad/product", description = "商品")
public class ProductController extends PadController {

    @Autowired
    private ProductService productService;

    /**
     * @description 查询餐厅下所有分类信息
     * @author LiSH
     * @time 2017-2-21 9:51
     * @version 2.0.0
     */
    @ApiOperation(value = "桌台分类列表查询", httpMethod = "GET", response = ResultData.class)
    @RequestMapping(value = "/categorys", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResultData getCategorys() throws Exception {
//        List<Map<String, Object>> categoryList = productService.getCategoryList(1000007L, 1000002L);
//        return null;
        return ResultData.makeSuccessResult(productService.getCategoryList(MerchantCacheUtils.getCurrentAreaID(),MerchantCacheUtils.getCurrentArchiveID()));
    }

    /**
     * @description 查询桌台下所有菜品列表 搜索条件(可选)有:类别信息 标签信息 搜索内容
     * @author LiSH
     * @time 2017-2-21 9:52
     * @version 2.0.0
     */
    @ApiOperation(value = "查询菜品列表", httpMethod = "GET", response = ResultData.class)
    @RequestMapping(value = "/products", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResultData getProducts(@RequestParam(required = false) String searchKey,
                                  @RequestParam(required = false) Long categoryID,
                                  @RequestParam(required = false) Long tagID,
                                  @RequestParam(value = "pageNum", defaultValue = "1", required = false) int pageNum) throws Exception {
        return ResultData.makeResult(productService.getProductsByParam(getParaMap()));

    }

    /**
     * @description 查询所有菜品标签
     * @author LiSH
     * @time 2017-2-21 9:52
     * @version 2.0.0
     */
    /*查询菜品标签列表*/
    @ApiOperation(value = "查询菜品标签列表", httpMethod = "GET", response = ResultData.class)
    @RequestMapping(value = "/productTags", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResultData getProductTags() throws Exception {
        return ResultData.makeSuccessResult(productService.getTagListByArchiveID(getCurrentArchiveID()));
    }

    /**
     * @description 仅供后台测试数据用
     * @author LiSH
     * @time 2017-2-21 9:53
     * @version 2.0.0
     */
    /*后台新增分类*/
    @ApiOperation(value = "(此接口不用测试 后台做数据使用)后台新增餐厅分类", httpMethod = "POST", response = ResultData.class)
    @RequestMapping(value = "/addCategory", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultData addCategory(@RequestParam(required = true) Long archiveID, @RequestParam(required = true) Long tableID, @RequestParam(required = false) String searchKey, @RequestParam(required = false) Long categoryID, @RequestParam(required = false) Long tagID) throws Exception {
        return ResultData.makeSuccessResult(productService.getProductsByParam(getParaMap()));
    }

    /**
     * @description 仅供后台测试数据用
     * @author LiSH
     * @time 2017-2-21 9:53
     * @version 2.0.0
     */
    /*后台新增标签*/
    @ApiOperation(value = "(此接口不用测试 后台做数据使用)后台新增商品标签", httpMethod = "POST", response = ResultData.class)
    @RequestMapping(value = "/addTag", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultData addTag(@RequestParam(required = true) Long tagID, @RequestParam(required = true) Long archiveID, @RequestParam(required = true) Long targetID) throws Exception {
        return ResultData.makeSuccessResult(productService.saveTag(getParaMap()));
    }

}
