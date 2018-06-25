package cc.toprank.byd.pad.controller;

import cc.toprank.byd.pad.service.AttachmentService;
import cc.toprank.byd.web.constant.ResultData;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 广告控制器
 *
 * @author LeeJun
 * @version 2.0.0
 * @time 2017-2-20 17:07
 */
@RestController
@RequestMapping("/pad/home/advert")
@Api(value = "/pad/home/advert", description = "广告")
public class AdvertController extends PadController {

    @Autowired
    private AttachmentService attachmentService;

    /**
     * 广告轮播图
     *
     * @author LeeJun
     * @time 2017-2-20 17:08
     * @version 2.0.0
     */
    @ApiOperation(value = "广告轮播图", httpMethod = "GET", response = ResultData.class)
    @GetMapping(value = "/slideshow", produces = "application/json;charset=UTF-8")
    public ResultData slideshow() throws Exception {
        return ResultData.makeResult(attachmentService.getAdvertSlideshow());
    }


}
