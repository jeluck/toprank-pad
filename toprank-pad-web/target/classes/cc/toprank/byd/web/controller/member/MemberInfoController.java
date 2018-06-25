package cc.toprank.byd.web.controller.member;

import cc.toprank.byd.base.BaseController;
import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.common.utils.rsa.MD5;
import cc.toprank.byd.entity.E_LoginInfoEntity;
import cc.toprank.byd.enums.CustomerManageEnum;
import cc.toprank.byd.enums.OrderManagerEnum;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.constant.ResultData;
import cc.toprank.byd.web.service.member.MemberInfoService;
import cc.toprank.byd.web.vo.UserListVO;
import cc.toprank.byd.web.vo.member.*;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mangofactory.swagger.annotations.ApiIgnore;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * @Description：会员业务控制器类
 * @Author：HuTao
 * @Time: 2017-3-22 15:24
 * @Version 2.0.0
 * Created by HuTao on 2017-3-22.
 */

@Controller
@RequestMapping("/reception/member")
public class MemberInfoController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(MemberInfoController.class.getName());

    @Autowired
    private MemberInfoService memberInfoService;

    private static final String PAY_PASSWORD = "888888"; // 初始化密码

    /**
     * @param request
     * @return
     * @Description：取会员等级列表信息
     * @Author：HuTao
     * @Time: 2017-5-17 15:18
     * @Version 2.0.0
     */
    @ResponseBody
    @GetMapping(value = "/getMemRoleLeve", produces = "application/json;charset=UTF-8")
    public JSONPObject getMemRoleLeve(HttpServletRequest request) {
        ResultData resultData = new ResultData();
        try {
             Long orgID=getOrgID() ;
            List<MemberLevelVO>  levelVOList=  memberInfoService.getMemRoleLeve(orgID);
            resultData.setCode(CodeMsgConstants.SUCCESS);
            resultData.setData(levelVOList);
        } catch (Exception e) {
            logger.error("取会员等级列表信息发生了错误：" + e.getLocalizedMessage(), e);
            e.printStackTrace();
            resultData.setCode(CodeMsgConstants.FAIL);
            resultData.setMessage(CodeMsgConstants.FAIL_MSG);
        }
        return getResultJSONPObject(resultData);
    }

    /**
     * @param
     * @param
     * @return
     * @Description：会员注册 reception/member/addMember
     * @Author：HuTao
     * @Time: 2017-3-23 13:46
     * @Version 2.0.0
     */

    @ApiOperation(value = "返回会员注册信息", httpMethod = "GET", response = ResultData.class, notes = "返回会员注册信息, 0表示注册成功,-1表示注册失败 ")
    @ResponseBody
    @GetMapping(value = "/addMember", produces = "application/json;charset=UTF-8")
    public JSONPObject addMember(HttpServletRequest request, @ApiIgnore @ModelAttribute("memberVO") MemberVO memberVO) {
        ResultData resultData = new ResultData();
        try {
            if (null == memberVO.getMemberName() || memberVO.getMemberName().equals("")) {
                resultData.setCode(CodeMsgConstants.MEMBER_NOTNAME);
                resultData.setMessage(CodeMsgConstants.MEMBER_NOTNAME_MSG);
                return getResultJSONPObject(resultData);
            }
            if (null == memberVO.getMobile() || memberVO.getMobile().equals("")) {
                resultData.setCode(CodeMsgConstants.MEMBER_NOTMMOBILE);
                resultData.setMessage(CodeMsgConstants.MEMBER_NOTMMOBILE_MSG);
                return getResultJSONPObject(resultData);
            }
            //   实物卡的卡序列号，芯片号
            if (memberVO.getCardType() == CustomerManageEnum.MembershipCardType.PHYSICALCARD.getValue()) {
                if (null == memberVO.getCardSerialNo() || memberVO.getCardSerialNo().equals("")) {
                    if (null == memberVO.getCardCode() || memberVO.getCardCode().equals("")) {
                        resultData.setCode(CodeMsgConstants.MEMBER_NOTCODE);
                        resultData.setMessage(CodeMsgConstants.MEMBER_NOTCODE_MSG);
                        return getResultJSONPObject(resultData);
                    }
                }
            }
//            if (null == memberVO.getCountermanID()) {
//                resultData.setCode(CodeMsgConstants.MEMBER_NOTCOUNTERMAN);
//                resultData.setMessage(CodeMsgConstants.MEMBER_NOTCOUNTERMAN_MSG);
//                return getResultJSONPObject(resultData);
//            }
            //  密码的检查
            if (null == memberVO.getPayPassword() || memberVO.getPayPassword().equals("")) {
                memberVO.setPayPassword(PAY_PASSWORD);
            }
            if(memberVO.getRoleID().equals(""))
                memberVO.setRoleID(null);
            memberVO.setOrgID(getOrgID());
            memberVO.setArchiveID(getArchiveID());
            memberVO.setOperatorID(getLoginID());
            memberVO.setPayPassword(MD5.getMD5Str(memberVO.getPayPassword()));
            memberInfoService.addMember(memberVO);
            resultData.setCode(CodeMsgConstants.MEMBER_SAVE_SUCCESS);
            resultData.setMessage(CodeMsgConstants.MEMBER_SAVE_SUCCESS_MSG);
        } catch (BizException be) {
            logger.error(be.getMessage(), be);
            resultData.setCode(be.getCode());
            resultData.setMessage(be.getMessage());
        } catch (Exception e) {
            logger.error("注册会员发生了错误：" + e.getLocalizedMessage(), e);
            e.printStackTrace();
            resultData.setCode(CodeMsgConstants.MEMBER_SAVE_FAIL);
            resultData.setMessage(CodeMsgConstants.MEMBER_SAVE_FAIL_MSG);
        }
        return getResultJSONPObject(resultData);
    }

    /**
     * @param request
     * @return
     * @Description：修改会员信息
     * @Author：HuTao
     * @Time: 2017-3-23 14:00
     * @Version 2.0.0
     */
    @ResponseBody
    @RequestMapping(value = "/updateMember", produces = "application/json;charset=UTF-8")
    public JSONPObject updateMember(HttpServletRequest request, @ApiIgnore @ModelAttribute("memberVO") MemberVO memberVO) {
        ResultData resultData = new ResultData();
        try {
            if (null == memberVO.getMemberName() || memberVO.getMemberName().equals("")) {
                resultData.setCode(CodeMsgConstants.MEMBER_NOTNAME);
                resultData.setMessage(CodeMsgConstants.MEMBER_NOTNAME_MSG);
                return getResultJSONPObject(resultData);
            }
            if (null == memberVO.getMobile() || memberVO.getMobile().equals("")) {
                resultData.setCode(CodeMsgConstants.MEMBER_NOTMMOBILE);
                resultData.setMessage(CodeMsgConstants.MEMBER_NOTMMOBILE_MSG);
                return getResultJSONPObject(resultData);
            }
            memberInfoService.updateMember(memberVO);
            resultData.setCode(CodeMsgConstants.MEMBER_UPDATE_SUCCESS);
            resultData.setMessage(CodeMsgConstants.MEMBER_UPDATE_SUCCESS_MSG);
        } catch (Exception e) {
            logger.error("修改会员信息发生了错误：" + e.getLocalizedMessage(), e);
            e.printStackTrace();
            resultData.setCode(CodeMsgConstants.MEMBER_UPDATE_FAIL);
            resultData.setMessage(CodeMsgConstants.MEMBER_UPDATE_FAIL_MSG);
        }
        return getResultJSONPObject(resultData);
    }
    /**
     * @return
     * @Description：会员充值
     * @Author：HuTao
     * @Time: 2017-4-21 10:35
     * @Version 2.0.0
     */
    @ResponseBody
    @GetMapping(value = "/memberRecharge", produces = "application/json;charset=UTF-8")
    public JSONPObject memberRecharge(HttpServletRequest request, @ApiIgnore @ModelAttribute("memberDepositVO") MemberDepositVO memberDepositVO) {
        ResultData resultData = new ResultData();

        try {
            if (memberDepositVO.getDeposit() < 1) {
                resultData.setCode(CodeMsgConstants.PARAM_ERROR);
                resultData.setMessage(CodeMsgConstants.PARAM_ERROR_MSG);
                return getResultJSONPObject(resultData);
            }
            memberDepositVO.setArchiveID(getArchiveID());
            memberDepositVO.setOrgID(getOrgID());
            memberDepositVO.setOperatorID(getLoginID());

            String loginName = getLoginName();
            String cashRegister= getCasherName();
            memberInfoService.memberRecharge(memberDepositVO,cashRegister,loginName);
            resultData.setCode(CodeMsgConstants.MEMBER_RECHARGERECORD_SUCCESS);
        } catch (BizException be) {
            logger.error(be.getMessage(), be);
            resultData.setCode(be.getCode());
            resultData.setMessage(be.getMessage());
        } catch (Exception e) {
            logger.error("会员充值时息发生了错误：" + e.getLocalizedMessage(), e);
            e.printStackTrace();
            resultData.setCode(CodeMsgConstants.FAIL);
            resultData.setMessage(CodeMsgConstants.FAIL_MSG);
        }
        return getResultJSONPObject(resultData);
    }
    /**
     * @return
     * @Description：查询会员信息
     * @Author：HuTao
     * @Time: 2017-3-23 14:01
     * @Version 2.0.0
     */
    @ResponseBody
    @GetMapping(value = "/queryMember", produces = "application/json;charset=UTF-8")
    public JSONPObject queryMember(@ApiParam(required = true, name = "quValue", value = "查询值") String quValue) {
        ResultData resultData = new ResultData();
        try {
            if (null == quValue || quValue.equals("") ) {
                resultData.setCode(CodeMsgConstants.PARAM_ERROR);
                resultData.setMessage(CodeMsgConstants.PARAM_ERROR_MSG);
                return getResultJSONPObject(resultData);
            }
            Long archiveID = getArchiveID();
            List<MemberInfoVO> dataList = memberInfoService.queryMember(archiveID, quValue);
            resultData.setCode(CodeMsgConstants.SUCCESS);
            resultData.setData(dataList);
        } catch (Exception e) {
            logger.error("查询会员发生了错误：" + e.getLocalizedMessage(), e);
            e.printStackTrace();
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }
        return getResultJSONPObject(resultData);
    }

    /**
     * @param
     * @return
     * @Description：查询会员信息
     * @Author：HuTao
     * @Time: 2017-3-23 14:03
     * @Version 2.0.0
     */
    @ResponseBody
    @GetMapping(value = "/getMemberInfor", produces = "application/json;charset=UTF-8")
    public JSONPObject quMemberInfor(@ApiParam(required = true, name = "cardID", value = "会员ID号为") Long cardID) {
        ResultData resultData = new ResultData();
        try {
            if (null == cardID) {
                resultData.setCode(CodeMsgConstants.PARAM_ERROR);
                resultData.setMessage(CodeMsgConstants.PARAM_ERROR_MSG);
                return getResultJSONPObject(resultData);
            }
            Long archiveID = getArchiveID();
            MemberVO memberVO = memberInfoService.quMemberInfor(archiveID, cardID);
            resultData.setCode(CodeMsgConstants.SUCCESS);
            resultData.setData(memberVO);
        } catch (Exception e) {
            logger.error("查询会员信息发生了错误：" + e.getLocalizedMessage(), e);
            e.printStackTrace();
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }
        return getResultJSONPObject(resultData);
    }

    /**
     * @param
     * @return
     * @Description： 根据手机号，检查此手机号是否已注册
     * @Author：HuTao
     * @Time: 2017-4-7 19:13
     * @Version 2.0.0
     */
    @ResponseBody
    @GetMapping(value = "/checkMobile", produces = "application/json;charset=UTF-8")
    public JSONPObject checkMobileNo(@ApiParam(required = true, name = "mobile", value = "手机号") String mobile) {
        ResultData resultData = new ResultData();
        try {
            if (null == mobile || mobile.equals("")) {
                resultData.setCode(CodeMsgConstants.PARAM_ERROR);
                resultData.setMessage(CodeMsgConstants.PARAM_ERROR_MSG);
                return getResultJSONPObject(resultData);
            }
            Long archiveID = getArchiveID();
            MemberVO memberVO = memberInfoService.checkMobileNo(archiveID, mobile);
            resultData.setCode(CodeMsgConstants.MEMBER_MOBEL_NOTCARD);
            resultData.setMessage(CodeMsgConstants.MEMBER_MOBEL_NOTCARD_MSG);
            resultData.setData(memberVO);
        } catch (BizException be) {
            logger.error(be.getMessage(), be);
            resultData.setCode(be.getCode());
            resultData.setMessage(be.getMessage());
        } catch (Exception e) {
            logger.error("根据手机号，检查此手机号是否已注册发生了错误：" + e.getLocalizedMessage(), e);
            e.printStackTrace();
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }
        return getResultJSONPObject(resultData);
    }

    /**
     * @param
     * @return
     * @Description： 根据会员卡号，1检查此卡号是否已使用，2如果会员卡信息已存在，返会员卡信息
     * @Author：HuTao
     * @Time: 2017-4-7 19:12
     * @Version 2.0.0
     */
    @ResponseBody
    @GetMapping(value = "/checkCardCode", produces = "application/json;charset=UTF-8")
    public JSONPObject checkCardCode(@ApiParam(required = true, name = "cardSerialNo", value = "会员卡号（序列号）") String cardSerialNo) {
        ResultData resultData = new ResultData();
        try {
            if (null == cardSerialNo || cardSerialNo.equals("")) {
                resultData.setCode(CodeMsgConstants.PARAM_ERROR);
                resultData.setMessage(CodeMsgConstants.PARAM_ERROR_MSG);
                return getResultJSONPObject(resultData);
            }
            Long archiveID = getArchiveID();
            MemberVO memberVO = memberInfoService.checkCardCode(archiveID, cardSerialNo);
            resultData.setCode(CodeMsgConstants.MEMBER_CARD_NOTUSE);
            resultData.setMessage(CodeMsgConstants.MEMBER_CARD_NOTUSE_MSG);
            resultData.setData(memberVO);
        } catch (BizException be) {
            logger.error(be.getMessage(), be);
            resultData.setCode(be.getCode());
            resultData.setMessage(be.getMessage());
        } catch (Exception e) {
            logger.error("根据会员卡号，1检查此卡号是否已使用，2如果会员卡信息已存在，返会员卡信息发生了错误：" + e.getLocalizedMessage(), e);
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
            e.printStackTrace();
        }
        return getResultJSONPObject(resultData);
    }

    /**
     * @param
     * @return
     * @Description：取会员卡的总数，会员卡余额合计
     * @Author：HuTao
     * @Time: 2017-4-12 14:09
     * @Version 2.0.0
     */
    @ResponseBody
    @GetMapping(value = "/getCardCount", produces = "application/json;charset=UTF-8")
    public JSONPObject getCardCount(HttpServletRequest request) {
        ResultData resultData = new ResultData();
        try {
            Long archiveID = getArchiveID();
            MemberTotalVO memberTotalVO = memberInfoService.getCardCount(archiveID);
            resultData.setCode(CodeMsgConstants.SUCCESS);
            resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
            resultData.setData(memberTotalVO);
        } catch (Exception e) {
            logger.error("取会员卡的总数，会员卡余额合计发生了错误：" + e.getLocalizedMessage(), e);
            resultData.setCode(CodeMsgConstants.FAIL);
            resultData.setMessage(CodeMsgConstants.FAIL_MSG);
            e.printStackTrace();
        }
        return getResultJSONPObject(resultData);
    }

    /**
     * @param
     * @return
     * @Description：根据会员卡ID,取会员档案信息
     * @Author：HuTao
     * @Time: 2017-4-12 16:48
     * @Version 2.0.0
     */
    @ResponseBody
    @GetMapping(value = "/getCardMemberInfor", produces = "application/json;charset=UTF-8")
    public JSONPObject getCardMemberInfor(@ApiParam(required = true, name = "cardID", value = "会员ID号") Long cardID) {
        ResultData resultData = new ResultData();
        try {
            if (null == cardID) {
                resultData.setCode(CodeMsgConstants.PARAM_ERROR);
                resultData.setMessage(CodeMsgConstants.PARAM_ERROR_MSG);
                return getResultJSONPObject(resultData);
            }
            Long archiveID = getArchiveID();
            CardMemberVO cardMemberVO = memberInfoService.getCardMemberInfor(archiveID, cardID);
            resultData.setCode(CodeMsgConstants.SUCCESS);
            resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
            resultData.setData(cardMemberVO);
        } catch (Exception e) {
            logger.error("根据cardID 取会员档案信息发生了错误：" + e.getLocalizedMessage(), e);
            e.printStackTrace();
            resultData.setCode(CodeMsgConstants.FAIL);
            resultData.setMessage(CodeMsgConstants.FAIL_MSG);
        }
        return getResultJSONPObject(resultData);
    }

    /**
     * @param request
     * @return
     * @Description：取业务员信息列表
     * @Author：HuTao
     * @Time: 2017-4-19 8:58
     * @Version 2.0.0
     */

    @ResponseBody
    @GetMapping(value = "/getServerNameList", produces = "application/json;charset=UTF-8")
    public JSONPObject getServerNameList(HttpServletRequest request) {
        ResultData resultData = new ResultData();
        try {
            String nameOrId = request.getParameter("nameOrId").toString();
            Long orgID = getOrgID();
            String title = "业务员";
            List<UserListVO> userList = memberInfoService.getServerNameList(orgID, title, nameOrId);
            resultData.setCode(CodeMsgConstants.SUCCESS);
            resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
            resultData.setData(userList);
        } catch (Exception e) {
            logger.error("根据nameOrId 取用户列表信息发生了错误：" + e.getLocalizedMessage(), e);
            e.printStackTrace();
            resultData.setCode(CodeMsgConstants.FAIL);
            resultData.setMessage(CodeMsgConstants.FAIL_MSG);
        }
        return getResultJSONPObject(resultData);
    }

    /**
     * @Description：充值时，根据充值金额，计算赠送金额，赠送积分
     * @Author：HuTao
     * @Time: 2017-5-26 16:07
     * @Version 2.0.0
     * @param request
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/getRechargeCalc", produces = "application/json;charset=UTF-8")
    public JSONPObject getRechargeCalc(HttpServletRequest request) {
        ResultData resultData = new ResultData();
        try {
            Double rechargeAmount =Double.valueOf(request.getParameter("rechargeAmount").toString());
            Long activityID =getArchiveID();
            RechargeRuleInfoVO ruleInfoVO =  memberInfoService.getRechargeRuleInfo(activityID,rechargeAmount);
            resultData.setCode(CodeMsgConstants.SUCCESS);
            resultData.setData(ruleInfoVO);
        } catch (Exception e) {
            logger.error("获取充值活动规则信息发生了错误：" + e.getLocalizedMessage(), e);
            e.printStackTrace();
            resultData.setCode(CodeMsgConstants.FAIL);
            resultData.setMessage(CodeMsgConstants.FAIL_MSG);
        }
        return getResultJSONPObject(resultData);
    }



    /**
     * @Description： 根据手机号获取用户信息
     * @Author：Zhaolingchen
     * @Time: 2017-5-20 17:12
     * @Version 2.0.0
     */
    @ApiOperation(value = "根据手机号获取用户信息", httpMethod = "GET")
    @RequestMapping(value = "/getLoginInfoByMobile", method = RequestMethod.GET)
    @ResponseBody
    public JSONPObject getLoginInfoByMobile(@ApiParam("手机号") @RequestParam(required = true, value = "mobile") String mobile) {
        E_LoginInfoEntity loginInfo = memberInfoService.getUserInfoByMobile(mobile);
        ResultData resultData = ResultData.makeSuccessResult(loginInfo);
        return getResultJSONPObject(resultData);
    }

    /**
     * @Description：会员密码修改
     * @Author：HuTao
     * @Time: 2017-5-24 15:41
     * @Version 2.0.0
     * @param cardID
     * @param oldPassword
     * @param newPassword
     * @return
     */
    @ApiOperation(value = "会员修改密码", httpMethod = "GET")
    @RequestMapping(value = "/updateCardPassword", method = RequestMethod.GET)
    @ResponseBody
    public JSONPObject updateCardPassword(HttpServletRequest request,@ApiParam("会员卡ID") @RequestParam(required = true, value = "cardID") Long cardID,
                                          @ApiParam("原密码") @RequestParam(required = true, value = "oldPassword") String oldPassword,
                                          @ApiParam("新密码") @RequestParam(required = true, value = "newPassword") String newPassword) {
        ResultData resultData = new ResultData();
        try {
            if (null==cardID) {
                resultData.setCode(CodeMsgConstants.PARAM_ERROR);
                resultData.setMessage(CodeMsgConstants.PARAM_ERROR_MSG);
                return getResultJSONPObject(resultData);
            }
            if (null==newPassword||newPassword.equals("") ) {
                resultData.setCode(CodeMsgConstants.MEMBER_NEWPASSWORD);
                resultData.setMessage(CodeMsgConstants.MEMBER_NEWPASSWORD_MSG);
                return getResultJSONPObject(resultData);
            }
            oldPassword = MD5.getMD5Str(oldPassword);
            newPassword = MD5.getMD5Str(newPassword);
            memberInfoService.updateCardPassword(cardID,oldPassword,newPassword);
            resultData.setCode(CodeMsgConstants.SUCCESS);
        } catch (BizException be){
            logger.error(be.getMessage(), be);
            resultData.setCode(be.getCode());
            resultData.setMessage(be.getMessage());
        }
        catch (Exception e) {
            logger.error("会员修改密码发生了错误：" + e.getLocalizedMessage(), e);
            e.printStackTrace();
            resultData.setCode(CodeMsgConstants.FAIL);
            resultData.setMessage(CodeMsgConstants.FAIL_MSG);
        }
        return getResultJSONPObject(resultData);
    }

    /**
     * @Description：根据会员ID,重置会员密码
     * @Author：HuTao
     * @Time: 2017-5-27 14:11
     * @Version 2.0.0
     * @param cardID
     * @return
     */
    @ApiOperation(value = "重置会员密码", httpMethod = "GET")
    @RequestMapping(value = "/repeatCardPassword", method = RequestMethod.GET)
    @ResponseBody
    public JSONPObject repeatCardPassword( @ApiParam("会员卡ID") @RequestParam(required = true, value = "cardID") Long cardID,
                                           @RequestParam(required = true, value = "newPassword") String newPassword){
        ResultData resultData = new ResultData();
        try {
            if (null==cardID) {
                resultData.setCode(CodeMsgConstants.PARAM_ERROR);
                resultData.setMessage(CodeMsgConstants.PARAM_ERROR_MSG);
                return getResultJSONPObject(resultData);
            }
            newPassword = MD5.getMD5Str(newPassword);
            memberInfoService.repeatCardPassword(cardID,newPassword);
            resultData.setCode(CodeMsgConstants.SUCCESS);
        }
        catch (Exception e) {
            logger.error("重置会员密码发生了错误：" + e.getLocalizedMessage(), e);
            e.printStackTrace();
            resultData.setCode(CodeMsgConstants.FAIL);
            resultData.setMessage(CodeMsgConstants.FAIL_MSG);
        }
        return getResultJSONPObject(resultData);
    }

    /**
     * @Description：根据会员ID,冻结会员
     * @Author：HuTao
     * @Time: 2017-5-27 14:12
     * @Version 2.0.0
     * @param cardID
     * @return
     */
    @ApiOperation(value = "冻结会员", httpMethod = "GET")
    @RequestMapping(value = "/blockedMember", method = RequestMethod.GET)
    @ResponseBody
    public JSONPObject blockedMember( @ApiParam("会员卡ID") @RequestParam(required = true, value = "cardID") Long cardID){
        ResultData resultData = new ResultData();
        try {
            if (null==cardID) {
                resultData.setCode(CodeMsgConstants.PARAM_ERROR);
                resultData.setMessage(CodeMsgConstants.PARAM_ERROR_MSG);
                return getResultJSONPObject(resultData);
            }
            memberInfoService.blockedMember(cardID);
            resultData.setCode(CodeMsgConstants.SUCCESS);
        }
        catch (Exception e) {
            logger.error("冻结会员发生了错误：" + e.getLocalizedMessage(), e);
            e.printStackTrace();
            resultData.setCode(CodeMsgConstants.FAIL);
            resultData.setMessage(CodeMsgConstants.FAIL_MSG);
        }

        return getResultJSONPObject(resultData);
    }


    @ApiOperation(value = "解冻会员", httpMethod = "GET")
    @RequestMapping(value = "/thawMember", method = RequestMethod.GET)
    @ResponseBody
    public JSONPObject thawMember( @ApiParam("会员卡ID") @RequestParam(required = true, value = "cardID") Long cardID){
        ResultData resultData = new ResultData();
        try {
            if (null==cardID) {
                resultData.setCode(CodeMsgConstants.PARAM_ERROR);
                resultData.setMessage(CodeMsgConstants.PARAM_ERROR_MSG);
                return getResultJSONPObject(resultData);
            }
            memberInfoService.thawMember(cardID);
            resultData.setCode(CodeMsgConstants.SUCCESS);
        }
        catch (Exception e) {
            logger.error("解冻会员发生了错误：" + e.getLocalizedMessage(), e);
            e.printStackTrace();
            resultData.setCode(CodeMsgConstants.FAIL);
            resultData.setMessage(CodeMsgConstants.FAIL_MSG);
        }

        return getResultJSONPObject(resultData);
    }
    /**
     * @Description：根据会员ID,注销会员s
     * @Author：HuTao
     * @Time: 2017-5-27 14:13
     * @Version 2.0.0
     * @param cardID
     * @return
     */
    @ApiOperation(value = "注销会员", httpMethod = "GET")
    @RequestMapping(value = "/cancellationMember", method = RequestMethod.GET)
    @ResponseBody
    public JSONPObject cancellationMember( @ApiParam("会员卡ID") @RequestParam(required = true, value = "cardID") Long cardID){
        ResultData resultData = new ResultData();
        try {
            if (null==cardID) {
                resultData.setCode(CodeMsgConstants.PARAM_ERROR);
                resultData.setMessage(CodeMsgConstants.PARAM_ERROR_MSG);
                return getResultJSONPObject(resultData);
            }
            memberInfoService.cancellationMember(cardID);
            resultData.setCode(CodeMsgConstants.SUCCESS);
        }
        catch (Exception e) {
            logger.error("注销会员发生了错误：" + e.getLocalizedMessage(), e);
            e.printStackTrace();
            resultData.setCode(CodeMsgConstants.FAIL);
            resultData.setMessage(CodeMsgConstants.FAIL_MSG);
        }
        return getResultJSONPObject(resultData);
    }

    /**
     * @Description：充值记录查询
     * @Author：HuTao
     * @Time: 2017-5-27 14:14
     * @Version 2.0.0
     * @param quDate
     * @param quValue
     * @return
     */
    @ApiOperation(value = "充值记录查询", httpMethod = "GET")
    @RequestMapping(value = "/queryMemberRecharge", method = RequestMethod.GET)
    @ResponseBody
    public JSONPObject queryMemberRecharge( @ApiParam("日期") @RequestParam(required = true, value = "quDate") String quDate,
                                            @ApiParam("收银员/收银机") @RequestParam(required = true, value = "quValue") String quValue){
        //  只可以按日期 和  收银员/收银机
        ResultData resultData = new ResultData();
        try {
            Long loginID=getLoginID();
            List<MemberRechargeRecordVO>  rechargeRecordVOList= memberInfoService.queryMemberRecharge(loginID,quDate);
            resultData.setCode(CodeMsgConstants.SUCCESS);
            resultData.setData(rechargeRecordVOList);
        }
        catch (Exception e) {
            logger.error("充值记录查询发生了错误：" + e.getLocalizedMessage(), e);
            e.printStackTrace();
            resultData.setCode(CodeMsgConstants.FAIL);
            resultData.setMessage(CodeMsgConstants.FAIL_MSG);
        }
        return getResultJSONPObject(resultData);
    }

    /**
     * @Description：开发票
     * @Author：HuTao
     * @Time: 2017-5-27 14:15
     * @Version 2.0.0
     * @param request
     * @return
     */
    @ApiOperation(value = "开发票 ResultData resultData = new ResultData();", httpMethod = "GET")
    @RequestMapping(value = "/memberOpenTicket", method = RequestMethod.GET)
    @ResponseBody
    public JSONPObject  memberOpenTicket(HttpServletRequest request, @ApiIgnore @ModelAttribute("memberTicketVO")MemberOpenTicketVO memberTicketVO){
        ResultData resultData = new ResultData();
        try {
      //      MemberOpenTicketVO memberTicketVO = new MemberOpenTicketVO();

            memberTicketVO.setOrderType( OrderManagerEnum.OrderSource.RECHARGE.getValue());     //   充值
            Long loginID=getLoginID();
            memberInfoService.memberOpenTicket(memberTicketVO);
            resultData.setCode(CodeMsgConstants.SUCCESS);
        }
        catch (Exception e) {
            logger.error("会员开发票发生了错误：" + e.getLocalizedMessage(), e);
            e.printStackTrace();
            resultData.setCode(CodeMsgConstants.FAIL);
            resultData.setMessage(CodeMsgConstants.FAIL_MSG);
        }
        return getResultJSONPObject(resultData);
    }

    /**
     * @Description：根据cardID,
     * @Author：HuTao
     * @Time: 2017-5-31 14:59
     * @Version 2.0.0
     * @param request
     * @return
     */
    @ApiOperation(value = "重打小票 ResultData resultData = new ResultData();", httpMethod = "GET")
    @RequestMapping(value = "/repeatPrintTicket", method = RequestMethod.GET)
    @ResponseBody
    public JSONPObject  repeatPrintTicket(HttpServletRequest request
                                ,@ApiParam("会员ID") @RequestParam(required = true, value = "cardID") Long cardID,
                                 @ApiParam("充值流水ID") @RequestParam(required = true, value = "depositID") Long depositID){
        ResultData resultData = new ResultData();
        try {
            Long loginID=getLoginID();
            memberInfoService.repeatPrintTicket(loginID,cardID,depositID);
            resultData.setCode(CodeMsgConstants.SUCCESS);
        }
        catch (Exception e) {
            logger.error("重打小票发生了错误：" + e.getLocalizedMessage(), e);
            e.printStackTrace();
            resultData.setCode(CodeMsgConstants.FAIL);
            resultData.setMessage(CodeMsgConstants.FAIL_MSG);
        }
        return getResultJSONPObject(resultData);
    }

}
