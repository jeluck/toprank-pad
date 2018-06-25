package cc.toprank.byd.pad.controller;

import cc.toprank.byd.config.BaseConfig;
import cc.toprank.byd.constant.PadConstants;
import cc.toprank.byd.entity.B_MerchantInfoEntity;
import cc.toprank.byd.entity.B_PadInfoEntity;
import cc.toprank.byd.entity.U_LoginInfoEntity;
import cc.toprank.byd.pad.pojo.MerchantPadCacheVO;
import cc.toprank.byd.pad.service.PadInfoService;
import cc.toprank.byd.pad.service.SystemService;
import cc.toprank.byd.pad.service.TableService;
import cc.toprank.byd.pad.util.MerchantCacheUtils;
import cc.toprank.byd.util.Sha1Util;
import cc.toprank.byd.web.constant.ResultData;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @version 2.0.0
 * @description：系统设置控制器
 * @author：LiYC
 * @time: 2017-2-20 17:12
 */
@RestController
@RequestMapping("/pad/system")
@Api(value = "/pad/system", description = "系统设置")
public class SystemController extends PadController {

    @Autowired
    private SystemService systemService;
    @Autowired
    private PadInfoService padInfoService;

    /**
     * @description： 系统初始化操作
     * 1：如果能成功访问该方法，说明IP和端口输入正确，因此无需再次验证ip和端口
     * 2：访问成功后，进行档案信息的查询（数据库中只有一条档案信息,取出第一条即可）
     * 3：根据档案信息查询机构信息
     * 4：返回对应信息给APP进行保存
     * 5：将查询出的信息保存在session中
     * @author：LiYC
     * @time: 2017-2-20 16:54
     * @version 2.0.0
     */
    @ApiOperation(value = "系统初始化", httpMethod = "POST", response = ResultData.class,
            notes = "为了方便测试，档案ID改为传入（本不需要传入），返回B_MerchantInfo（档案信息），B_BasicParamInfoEntity（商家基本配置信息），" +
                    "U_OrganizationInfo（机构信息），B_PadInfo（水牌信息），B_DinningTableInfoEntity（水牌绑定的桌台信息），IsLogin(true代表不需要登录，false则代表需要登录)")
    @RequestMapping(value = "/init", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultData init(@ApiParam(required = true, name = "imei", value = "水牌串号") @RequestParam(value = "imei") String imei) throws Exception {
        // 封装vo对象放入session中便于统一管理
        Map<String, Object> initData = testInit(imei);
        return ResultData.makeSuccessResult(initData);
    }

    public Map<String, Object> testInit(String imei) {
        MerchantPadCacheVO merchantCache = new MerchantPadCacheVO();
        //调用初始化接口，获取商家相关信息
        Map<String, Object> initData = systemService.getInitDate();
        B_MerchantInfoEntity b_merchantInfo = (B_MerchantInfoEntity) initData.get("B_MerchantInfo");
        merchantCache.setArchiveID(b_merchantInfo.getArchiveID());

        //根据串号IMEI查询水牌信息
        B_PadInfoEntity b_padInfo = padInfoService.queryPadInfoByIMEI(imei, b_merchantInfo.getArchiveID());

        //若没有该水牌信息，则返回档案信息即可
        if (b_padInfo != null) {
            Map<String, Object> cacheMap = systemService.reLoadCache(b_padInfo, merchantCache);
            initData.putAll(cacheMap);
            initData.put("B_PadInfo", b_padInfo);
        } else {
            initData.put("tableManager", null);
            initData.put("B_ShopAreaInfo", null);
            initData.put("B_DinningTableInfo", null);
            //需要重新登录来绑定水牌
            initData.put("isLogin", false);
        }
        //相关信息存入session
        super.getSession().setAttribute(PadConstants.MERCHANT_PAD_CACHE_KEY, merchantCache);
        return initData;
    }

    /**
     * @description： 用户登陆操作
     * 1：用户需要传入工号，密码，档案编号进行登陆权限验证
     * 2：根据登陆情况返回对应信息
     * 3：若登陆成功后，将登陆的信息保存在session中
     * @author：LiYC
     * @time: 2017-2-20 16:55
     * @version 2.0.0
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ApiOperation(value = "系统登陆", httpMethod = "POST", response = ResultData.class, notes = "用户登陆操作，返回B_PadInfo（水牌信息），U_LoginInfo（用户登陆信息）")
    public ResultData login(
            @ApiParam(required = true, name = "userName", value = "工号") @RequestParam(value = "userName") String userName,
            @ApiParam(required = true, name = "userPwd", value = "密码") @RequestParam(value = "userPwd") String userPwd,
            @ApiParam(required = true, name = "imei", value = "水牌串号") @RequestParam(value = "imei") String imei,
            HttpServletRequest request) throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("userName", userName);//用户名
        map.put("userPwd", Sha1Util.SHA1(userPwd));//密码
        map.put("imei", imei);//水牌串号
        map.put("ipAddress", super.getIPAddr(request));//水牌IP地址
        map.put("archiveId", String.valueOf(super.getCurrentArchiveID()));
        map.put("serverIp", super.getServerIp());//离线服务器IP
        map.put("serverPort", String.valueOf(request.getServerPort()));//离线服务器端口

        //进行登录
        Map<String, Object> loginData = systemService.login(map);
        if (loginData == null) {
            return ResultData.makeResult(false);
        } else {
            super.getSession().setAttribute(PadConstants.PADINFO_PAD_CACHE_KEY, loginData.get("B_PadInfo"));
            super.getSession().setAttribute(PadConstants.LOGININFO_PAD_CACHE_KEY, loginData.get("U_LoginInfo"));
            return ResultData.makeSuccessResult(loginData);
        }
    }

    /**
     * @param tableID
     * @param request
     * @return
     * @description： 1:一个水牌只能绑定一个桌台，一个桌台可以被多个水牌绑定
     * 2:如果该水牌和桌台的绑定数据已存在，则进行状态的修改，同时将其有关该水牌的状态关闭
     * 3:如果该水牌和桌台的绑定数据不存在，则进行绑定数据的新增，同时关闭其他有关该水牌的状态
     * 4:根据水牌ID，桌台ID，登陆人ID，将绑定信息保存在水牌桌台绑定信息表中，并加入相关的处理信息。
     * 5:查询出该水牌绑定过的所有桌台
     * @author：LiYC
     * @time: 2017-2-20 16:56
     * @version 2.0.0
     */
    @RequestMapping(value = "/saveSetUp", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ApiOperation(value = "保存桌台绑定", httpMethod = "POST", response = ResultData.class, notes = "桌台绑定操作，返回B_DinningTableInfo（桌台信息）")
    public ResultData saveSetUp(@ApiParam(required = true, name = "tableID", value = "桌台ID") @RequestParam(value = "tableID") Long tableID,
                                HttpServletRequest request) throws Exception {
        U_LoginInfoEntity u_loginInfo = (U_LoginInfoEntity) super.getSessionValue(PadConstants.LOGININFO_PAD_CACHE_KEY);//登录信息
        B_PadInfoEntity b_padInfo = (B_PadInfoEntity) super.getSessionValue(PadConstants.PADINFO_PAD_CACHE_KEY);//水牌信息
        systemService.saveSetUp(u_loginInfo, b_padInfo, tableID);

        MerchantPadCacheVO merchantPadCacheVO = MerchantCacheUtils.getMerchantCache();
        Map<String, Object> cacheMap = systemService.reLoadCache(b_padInfo, merchantPadCacheVO);
        super.getSession().setAttribute(PadConstants.MERCHANT_PAD_CACHE_KEY, merchantPadCacheVO);
        return ResultData.makeSuccessResult(cacheMap);
    }

}
