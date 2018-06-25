package cc.toprank.byd.pad.controller;

import cc.toprank.byd.entity.B_DesignerMonitorInfoEntity;
import cc.toprank.byd.pad.service.AttachmentService;
import cc.toprank.byd.pad.service.ProductService;
import cc.toprank.byd.service.SystemMaxIDService;
import cc.toprank.byd.util.MaxIDUtils;
import cc.toprank.byd.web.constant.ResultData;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页控制器
 *
 * @author LeeJun
 * @version 2.0.0
 * @time 2017-2-20 17:08
 */
@RestController
@RequestMapping("/pad/home")
@Api(value = "/pad/home", description = "首页")
public class HomeController extends PadController {


    @Autowired
    private AttachmentService attachmentService;

    @Autowired
    private ProductService productService;


    /**
     * 首页banner图列表
     *
     * @return
     * @throws Exception
     * @author LeeJun 2017年1月21日下午3:59:17
     */
    @ApiOperation(value = "首页banner图列表", httpMethod = "GET", produces = "application/json;charset=UTF-8")
    @GetMapping(value = "/banner", produces = "application/json;charset=UTF-8")
    public ResultData banner() throws Exception {
        List<String> homeBanner = attachmentService.getHomeBanner();
        return ResultData.makeResult(homeBanner);
    }

    /**
     * 首页人气推荐
     *
     * @param currentPage
     * @return
     * @author LeeJun 2017年1月21日下午3:59:23
     */
    @ApiOperation(value = "首页人气推荐", httpMethod = "GET")
    @GetMapping(value = "/commend/{currentPage}", produces = "application/json;charset=UTF-8")
    public ResultData commend(@PathVariable int currentPage) {
        return ResultData.makeResult(productService.getCommendProducts(currentPage));
    }

    @ApiOperation(value = "首页人气推荐", httpMethod = "GET")
    @GetMapping(value = "/test/{tableName}", produces = "application/json;charset=UTF-8")
    public ResultData test(@PathVariable("tableName") String tableName) {
        return ResultData.makeResult(attachmentService.test(tableName));
    }

}
