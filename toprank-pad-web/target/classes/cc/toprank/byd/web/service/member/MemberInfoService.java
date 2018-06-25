package cc.toprank.byd.web.service.member;


import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.common.utils.DateUtils;
import cc.toprank.byd.component.PrintComponent;
import cc.toprank.byd.dao.*;
import cc.toprank.byd.entity.*;
import cc.toprank.byd.enums.*;
import cc.toprank.byd.util.BeanHelper;
import cc.toprank.byd.util.OkHttpClientUtils;
import cc.toprank.byd.vo.print.BusinessVO;
import cc.toprank.byd.vo.print.MemberCardInfoVO;
import cc.toprank.byd.vo.print.MemberRechargeVO;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.vo.UserListVO;
import cc.toprank.byd.web.vo.member.*;
import cc.toprank.byd.web.vo.member.MemberRechargeDataVO;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @Description：会员业务处理类
 * @Author：HuTao
 * @Time: 2017-3-22 15:33
 * @Version 2.0.0
 * Created by HuTao on 2017-3-22.
 */
@Service
public class MemberInfoService {
    // 日志打印
    protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    @Qualifier("u_OrgCustomerMappingDao")
    U_OrgCustomerMappingDao orgCustomerMappingDao;    //   机构客户关联信息
    @Autowired
    @Qualifier("e_MerchantBonusInfoDao")
    E_MerchantBonusInfoDao merchantBonusInfoDao;      //  商户积分信息商户积分信息
    @Autowired
    @Qualifier("f_MemberCardInfoDao")
    F_MemberCardInfoDao memberCardInfoDao;                   //    会员卡信息
    @Autowired
    @Qualifier("f_AccountCardMappingDao")
    F_AccountCardMappingDao accountCardMappingDao;              //    会员卡账户关联信息
    @Autowired
    @Qualifier("f_AccountInfoDao")
    F_AccountInfoDao accountInfoDao;           //    帐户信息
    @Autowired
    @Qualifier("f_MemberCardRequestInfoDao")
    F_MemberCardRequestInfoDao memberCardRequestInfoDao;        //   会员卡申请信息
    @Autowired
    @Qualifier("f_ViceFundInfoDao")
    F_ViceFundInfoDao viceFundInfoDao;              //         辅助资金信息
    @Autowired
    @Qualifier("f_ViceFundHistoryInfoDao")
    F_ViceFundHistoryInfoDao viceFundHistoryInfoDao;    //      辅助资金历史信息
    @Autowired
    @Qualifier("e_LoginInfoDao")
    E_LoginInfoDao loginInfoDao;                     //     客户登录信息
    @Autowired
    @Qualifier("e_CustomerInfoDao")
    E_CustomerInfoDao customerInfoDao;               //     客户信息
    @Autowired
    @Qualifier("u_LoginInfoDao")
    U_LoginInfoDao u_LoginInfoDao;                   //     用户信息
    @Autowired
    @Qualifier("f_DepositInfoDao")
    F_DepositInfoDao depositInfoDao;                   //     充值信息
    @Autowired
    @Qualifier("f_FundChangeInfoDao")
    F_FundChangeInfoDao fundChangeInfoDao;                   //     资金变动
    @Autowired
    @Qualifier("f_FundChangeDetailInfoDao")
    F_FundChangeDetailInfoDao changeDetailInfoDao;          //     资金明细变动
    @Autowired
    @Qualifier("f_DepositDealInfoDao")
    F_DepositDealInfoDao depositDealInfoDao;                 //     充值处理信息
    @Autowired
    @Qualifier("f_InvoiceInfoDao")                     //    开发票
            F_InvoiceInfoDao invoiceInfoDao;

    @Autowired
    @Qualifier("o_TicketPrintInfoDao")
    O_TicketPrintInfoDao ticketPrintInfoDao;    //  票据打印信息

    @Autowired
    @Qualifier("e_BonusChangeInfoDao")
    E_BonusChangeInfoDao bonusChangeInfoDao;        //  积分变动

    @Autowired
    @Qualifier("printComponent")
    PrintComponent printComponent;     //      打印组件


    private static final int SIGNINVOIE = 1;    //  开发票   SignInvoice


    public List<MemberLevelVO> getMemRoleLeve(Long orgID) {
        List<MemberLevelVO> levelVOList = new ArrayList<>();
        List<Map<String, Object>> dataMapList = memberCardInfoDao.getMemRoleLeve(orgID);
        if (CollectionUtils.isNotEmpty(dataMapList)) {
            for (int i = 0; i < dataMapList.size(); i++) {
                if (null != dataMapList.get(i).get("RoleID")) {
                    MemberLevelVO memberLevelVO = new MemberLevelVO();
                    memberLevelVO.setRoleID(Long.valueOf(dataMapList.get(i).get("RoleID").toString()));
                    memberLevelVO.setRoleName(dataMapList.get(i).get("RoleName").toString());
                    levelVOList.add(memberLevelVO);
                }
            }
        }
        return levelVOList;
    }

    /**
     * @param memberVO
     * @return
     * @Description：新增会员信息
     * @Author：HuTao
     * @Time: 2017-3-24 10:24
     * @Version 2.0.0
     */

    @Transactional(rollbackFor = Exception.class)
    public void addMember(MemberVO memberVO) {
        E_CustomerInfoEntity customerInfo = getCustomerInfoEntity(memberVO);    //   客户信息
        E_CustomerInfoEntity c = customerInfoDao.getCustomerInfoByMobile(customerInfo.getMobile());
        Map<String, Object> param = new HashMap();
        F_AccountInfoEntity account = null;
        if (c == null) {
            // 添加客户信息
            customerInfoDao.save(customerInfo);
            // 初始化客户登陆信息
            E_LoginInfoEntity loginInfo = getLoginInfoEntity(customerInfo);  //  登入信息
            loginInfoDao.save(loginInfo);
            customerInfo.setLoginID(loginInfo.getLoginID());
            // 初始化账户
            account = getAccountInfoEntity(customerInfo);        //  帐户信息
            accountInfoDao.save(account);
        } else {
            customerInfo.setCustomerID(c.getCustomerID());
            param.clear();
            param.put("customerID", customerInfo.getCustomerID());
            param.put("customerType", CustomerManageEnum.CustomerType.DINER.getValue());   //  食客
            account = accountInfoDao.getAccountInfoByCustomerID(param);
        }
        param.clear();
        param.put("customerID", customerInfo.getCustomerID());
        param.put("archiveID", customerInfo.getArchiveID());
        param.put("accountType", FinancialManageEnum.AccountType.MEMBERACCOUNT.getValue());       //  会员账户
        F_ViceFundInfoEntity vice =
                viceFundInfoDao.getViceFundInfoByCustomerIdAccountType(param);
        if (vice != null) {
            throw new BizException(CodeMsgConstants.MEMBER_ISACCOUNT, CodeMsgConstants.MEMBER_ISACCOUNT_MSG);
        }
        // 如何会员卡ID为空，则添加会员卡信息      cardSerialNo  卡序列号
        F_MemberCardInfoEntity memberCardInfo = null;
        //  如果有卡序列号，则根据卡序列号取会员卡信息
        // if(!customerInfo.getCardSerialNo().trim().equals("")) {   // }
        Map<String, Object> mparam = new HashMap();
        mparam.put("cardSerialNo", customerInfo.getCardSerialNo());
        mparam.put("orgID", customerInfo.getOrgID());
        memberCardInfo = memberCardInfoDao.getMemberCardInfoByCardCodeAndOrgID(mparam);
        if (memberCardInfo != null) {
            throw new BizException(CodeMsgConstants.MEMBER_ISUSED, CodeMsgConstants.MEMBER_ISUSED_MSG);
        }

        if (customerInfo.getCardID() == null || customerInfo.getCardID() == 0) {
            memberCardInfo = getMemberCardInfoEntity(customerInfo, memberVO);  //  会员卡信息
            memberCardInfoDao.save(memberCardInfo);
            customerInfo.setCardID(memberCardInfo.getCardID());
        } else {
            // 修改会员卡状态为正常：721
            memberCardInfo = new F_MemberCardInfoEntity();
            memberCardInfo.setCardID(customerInfo.getCardID());
            memberCardInfo.setCardStatus(CustomerManageEnum.CardStatus.NORMAL.getValue());  //  正常
            memberCardInfo.setIsSync(false);
            memberCardInfoDao.updateMemberCardStatus(memberCardInfo);
        }
        // 添加会员卡申请信息
        F_MemberCardRequestInfoEntity memberCardRequest = getMemberCardRequestInfoEntity(customerInfo, memberVO);  //  会员卡申请信息
        memberCardRequestInfoDao.save(memberCardRequest);
        // 添加机构客户关联信息
        U_OrgCustomerMappingEntity ocMapping = getOrgCustomerMappingEntity(customerInfo);  // 组织客户关联
        orgCustomerMappingDao.save(ocMapping);

        // 添加会员充值辅助资金信息
        F_ViceFundInfoEntity viceFundInfo = getViceFundInfoEntity(customerInfo, account);  // 添加会员充值辅助资金信息
        viceFundInfoDao.save(viceFundInfo);

        // 添加辅助资金历史 F_ViceFundHistoryInfo
        F_ViceFundHistoryInfoEntity viceFundHistory = new F_ViceFundHistoryInfoEntity();
        BeanUtils.copyProperties(viceFundInfo, viceFundHistory);
        viceFundHistoryInfoDao.save(viceFundHistory);
        // 添加会员卡账户关联信息
        F_AccountCardMappingEntity acMapping = getAccountCardMappingEntity(customerInfo, account, viceFundInfo);
        accountCardMappingDao.save(acMapping);
        // 初始化积分
        E_MerchantBonusInfoEntity bonusInfo = getMerchantBonusInfoEntity(customerInfo);
        merchantBonusInfoDao.save(bonusInfo);
        customerInfoDao.update(customerInfo);
    }

    /**
     * @param memberVO
     * @return
     * @Description：修改会员信息
     * @Author：HuTao
     * @Time: 2017-4-6 13:56
     * @Version 2.0.0
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateMember(MemberVO memberVO) {
        E_CustomerInfoEntity customerInfo = getCustomerInfoEntity(memberVO);    //   客户信息
        customerInfo.setCustomerID(memberVO.getCustomerID());
        customerInfoDao.updateCustomerMember(customerInfo);
        F_MemberCardInfoEntity memberCardInfo = getUpdateMemberCardInfoEntity(memberVO);  //  会员卡信息
        memberCardInfoDao.updateMember(memberCardInfo);
        //  修改业务员   F_MemberCardRequestInfo   CountermanID
        Map<String, Object> parm = new HashedMap();
        parm.put("cardID", memberVO.getCardID());
        parm.put("countermanID", memberVO.getCountermanID());
        parm.put("countermanName", memberVO.getCountermanName());
        memberCardInfoDao.updateCountermanID(parm);
    }

    /**
     * @param archiveID 档案ID
     * @param quValue   查询值
     * @return
     * @Description：会员信息查询 模糊查询 会员姓名，会员卡号 ，会员手机号
     * @Author：HuTao
     * @Time: 2017-4-5 14:58
     * @Version 2.0.0
     */
    public List<MemberInfoVO> queryMember(Long archiveID, String quValue) {
        List<MemberInfoVO> dataList = new ArrayList<>();
        if (!quValue.equals("%")&&!quValue.equals("_")) {   //
            Map<String, Object> parmMap = new HashedMap();
            parmMap.put("archiveID", archiveID);
            parmMap.put("quValue", quValue);
            List<E_CustomerInfoEntity> mapList = memberCardInfoDao.searchMember(parmMap);
            for (E_CustomerInfoEntity infoEntity : mapList) {
                MemberInfoVO memberInfoVO = new MemberInfoVO();
                memberInfoVO.setCustomerID(infoEntity.getCustomerID());      //  会员ID
                memberInfoVO.setMemberName(infoEntity.getCustomerName());    // 会员姓名
                memberInfoVO.setCardID(infoEntity.getCardID());          // 会员ID
                memberInfoVO.setCardCode(infoEntity.getCardCode());      // 会员卡号
                memberInfoVO.setCardSerialNo(infoEntity.getCardSerialNo());  //  会员序列号
                memberInfoVO.setMobile(infoEntity.getMobile());          //  手机号码   MemberMobile
                memberInfoVO.setCardLevelName(infoEntity.getRoleName());              //  会员卡等级
                memberInfoVO.setAccountBalance(infoEntity.getAccountBalance());        // 帐户余额
                memberInfoVO.setCumulateConsume(infoEntity.getCumulateConsume());      // 累积消费
                memberInfoVO.setCumulateRecharge(infoEntity.getCumulateRecharge());     //  累计充值
                memberInfoVO.setCreateDate(infoEntity.getCreateTime().toLocalDate());     //  注册时间
                memberInfoVO.setSourceName(infoEntity.getSourceName());                 //  客户来源
                memberInfoVO.setCardStatus(infoEntity.getCardStatus());                                //   会员状态
                dataList.add(memberInfoVO);
            }
        }
        return dataList;
    }

    /**
     * @param archiveID
     * @param quValue
     * @return
     * @Description：根据查询条件，取的查询的记录数
     * @Author：HuTao
     * @Time: 2017-4-10 16:44
     * @Version 2.0.0
     */
    public int getQueryMemberCount(Long archiveID, String quValue) {
        int result = 0;
        Map<String, Object> parmMap = new HashedMap();
        parmMap.put("archiveID", archiveID);
        parmMap.put("quValue", quValue);
        Map<String, Object> mapdata = memberCardInfoDao.getQueryMemberCount(parmMap);
        if (null != mapdata && !mapdata.isEmpty()) {
            result = Integer.parseInt(mapdata.get("count").toString());
        }
        return result;
    }

    /**
     * @param archiveID
     * @param cardID
     * @return
     * @Description： 根据会员卡ID 查询会员信息
     * @Author：HuTao
     * @Time: 2017-4-7 9:52
     * @Version 2.0.0
     */
    public MemberVO quMemberInfor(Long archiveID, Long cardID) {
        MemberVO memberVO = new MemberVO();
        Map<String, Object> parmMap = new HashedMap();
        parmMap.put("archiveID", archiveID);
        parmMap.put("cardID", cardID);
        E_CustomerInfoEntity infoEntity = memberCardInfoDao.quMemberInfor(parmMap);
        if (null != infoEntity) {
            memberVO.setMemberName(infoEntity.getCustomerName());    // 会员姓名
            memberVO.setCardSerialNo(infoEntity.getCardSerialNo());
            memberVO.setGender(infoEntity.getGender());           //  性别
            memberVO.setMobile(infoEntity.getMobile());         //  手机号码
            memberVO.setEmail(infoEntity.getEmail());           //  电子邮箱
            memberVO.setBirthday(infoEntity.getBirthday().toString());     //   生日
            memberVO.setCountermanID(infoEntity.getCountermanID());         //  业务员ID
            memberVO.setCountermanName(infoEntity.getCountermanName());                                 //   业务员名称
            memberVO.setMemo(infoEntity.getMemo());                     //  备注
            memberVO.setPassportType(infoEntity.getPassportType()); //  证件类型
            memberVO.setIDCode(infoEntity.getIDCode());             // 证件号码
            memberVO.setCustomerID(infoEntity.getCustomerID());     //  会员ID
            memberVO.setCardID(infoEntity.getCardID());            // 会员ID
            memberVO.setCardSerialNo(infoEntity.getCardSerialNo());  // 会员卡号   卡序列号= 实物卡号
            memberVO.setCardType(infoEntity.getCardType());          //  类型   电子卡， 实物卡  未知、磁条卡、芯片卡、磁条芯片复合卡、充值卡、未接触IC卡等
            memberVO.setCardCode(infoEntity.getCardCode());            //  芯片号    芯片号 = 会员卡号
            if (null == infoEntity.getRoleID() || infoEntity.getRoleID().equals("")) {
                memberVO.setRoleID("");
            } else
                memberVO.setRoleID(infoEntity.getRoleID().toString());        //  会员卡等级   未知、普卡、银卡、金卡、钻石卡等

            memberVO.setArchiveName(infoEntity.getArchiveName());     //  餐厅名称
        }
        return memberVO;
    }


    /**
     * @param archiveID
     * @param mobile
     * @return
     * @Description：根据手机号，检查此手机号是否已注册
     * @Author：HuTao
     * @Time: 2017-4-7 15:55
     * @Version 2.0.0
     */
    public MemberVO checkMobileNo(Long archiveID, String mobile) {
        MemberVO memberVO = null;
        Map<String, Object> parmMap = new HashedMap();
        parmMap.put("archiveID", archiveID);
        parmMap.put("mobile", mobile);
        List<E_CustomerInfoEntity> infoList = customerInfoDao.getMobileNoByCustomerInfo(parmMap);
        if (!CollectionUtils.isEmpty(infoList)) {
            for(E_CustomerInfoEntity  infoEntity:infoList){
                if (infoEntity.getMobile().equals(mobile)) {
                    List<Map<String, Object>> mapDatalist = customerInfoDao.getMobileNoByMemberInfo(parmMap);
                    if (CollectionUtils.isEmpty(mapDatalist)) {
                        memberVO = new MemberVO();
                        memberVO.setMemberName(infoEntity.getCustomerName());  //  会员姓名
                        memberVO.setGender(infoEntity.getGender());            //  性别
                        memberVO.setMobile(infoEntity.getMobile());            //  手机号码
                        memberVO.setEmail(infoEntity.getEmail());              //  电子邮箱
                        memberVO.setBirthday(infoEntity.getBirthday().toString());        //   生日
                        memberVO.setMemo(infoEntity.getMemo());                 //  备注
                        memberVO.setPassportType(infoEntity.getPassportType()); //  证件类型
                        memberVO.setIDCode(infoEntity.getIDCode());             //  证件号码
                    } else {
                        throw new BizException(CodeMsgConstants.MEMBER_MOBEL_ISUSE, CodeMsgConstants.MEMBER_MOBEL_ISUSE_MSG);
                    }
                }
            }
        }
        return memberVO;
    }

    /**
     * @param archiveID
     * @param cardSerialNo
     * @return
     * @Description：根据会员卡号，1检查此卡号是否已使用，2如果会员卡信息已存在，返会员卡信息
     * @Author：HuTao
     * @Time: 2017-4-7 15:57
     * @Version 2.0.0
     */
    public MemberVO checkCardCode(Long archiveID, String cardSerialNo) {
        // 1 检查卡员 是否存在
        // 2 检查卡员 是否已与客户用
        // 3 返回卡信息 //
        MemberVO memberVO = null;
        Map<String, Object> parmMap = new HashedMap();
        parmMap.put("archiveID", archiveID);
        parmMap.put("cardSerialNo", cardSerialNo);
        F_MemberCardInfoEntity memberCardInfo = memberCardInfoDao.getMemberInforByCardCode(parmMap);
        //  没有查到会员卡信息
        if (null == memberCardInfo) {
            throw new BizException(CodeMsgConstants.MEMBER_NOCARD, CodeMsgConstants.MEMBER_NOCARD_MSG);
        } else {
            //  检查会员卡 是否已使用
            Map<String, Object> mapData = memberCardInfoDao.getCustomerMemberInforByCardCode(parmMap);
            if (null == mapData || mapData.isEmpty()) {
                memberVO = new MemberVO();
                memberVO.setCardID(memberCardInfo.getCardID());
                memberVO.setRoleID(memberCardInfo.getRoleID().toString());
            } else {
                throw new BizException(CodeMsgConstants.MEMBER_CARD_ISUSE, CodeMsgConstants.MEMBER_CARD_ISUSE_MSG);
            }
        }
        return memberVO;
    }

    /**
     * @param archiveID
     * @return
     * @Description：取会员卡的总数，会员卡余额合计
     * @Author：HuTao
     * @Time: 2017-4-12 14:14
     * @Version 2.0.0
     */
    public MemberTotalVO getCardCount(Long archiveID) {
        MemberTotalVO memberTotalVO = null;
        Map<String, Object> parmMap = new HashedMap();
        parmMap.put("archiveID", archiveID);
        parmMap = memberCardInfoDao.getCardCount(parmMap);
        if (!parmMap.isEmpty()) {
            memberTotalVO = new MemberTotalVO();
            memberTotalVO.setCount(Integer.parseInt(null == parmMap.get("count") ? "0" : parmMap.get("count").toString()));
            memberTotalVO.setFundAmountCount(Double.parseDouble(null == parmMap.get("fundAmount") ? "0.0" : parmMap.get("fundAmount").toString()));
        }
        return memberTotalVO;
    }

    /**
     * @param archiveID
     * @param cardID
     * @return
     * @Description：根据cardID 取会员档案信息
     * @Author：HuTao
     * @Time: 2017-4-12 16:59
     * @Version 2.0.0
     */
    public CardMemberVO getCardMemberInfor(Long archiveID, Long cardID) {
        CardMemberVO cardMemberVO = null;
        Map<String, Object> parmMap = new HashedMap();
        parmMap.put("archiveID", archiveID);
        parmMap.put("cardID", cardID);
        F_MemberCardInfoEntity inforEntity = memberCardInfoDao.getCardMemberInfor(parmMap);
        if (null != inforEntity) {
            cardMemberVO = new CardMemberVO();
            cardMemberVO.setCustomerID(inforEntity.getCustomerID());       //  会员ID
            cardMemberVO.setMemberName(inforEntity.getMemberName());       //  会员姓名
            cardMemberVO.setBirthday(inforEntity.getBirthday());           //   生日日期
            cardMemberVO.setMobile(inforEntity.getMobile());               //  手机号码
            cardMemberVO.setSourceName(inforEntity.getSourceName());        //   客户来源
            cardMemberVO.setEmail(inforEntity.getEmail());                  //    电子邮件
            cardMemberVO.setCountermanID(inforEntity.getCountermanID());             //      业务员ID
            cardMemberVO.setCountermanName(inforEntity.getCountermanName());         //      业务员名称
            cardMemberVO.setCreateDate(inforEntity.getCreateTime().toLocalDate());         //     注册时间
            Map<String, Object> mapData = memberCardInfoDao.getCumulateValue(parmMap);
            if (null != mapData && !mapData.isEmpty()) {
                cardMemberVO.setAccountBalance(Double.parseDouble(null == mapData.get("accountBalance") ? "0" : mapData.get("accountBalance").toString()));
                cardMemberVO.setCumulateConsume(Double.parseDouble(null == mapData.get("cumulateConsume") ? "0" : mapData.get("cumulateConsume").toString()));          //  累积消费
                cardMemberVO.setConsumeCount(Integer.parseInt(null == mapData.get("consumeCount") ? "0" : mapData.get("consumeCount").toString()));             //   消费次数
                cardMemberVO.setCumulateRecharge(Double.parseDouble(null == mapData.get("cumulateRecharge") ? "0" : mapData.get("cumulateRecharge").toString()));         //  累计充值
                cardMemberVO.setBookingCount(Integer.parseInt(null == mapData.get("bookingCount") ? "0" : mapData.get("bookingCount").toString()));             //   预定次数
            }
            cardMemberVO.setCardID(inforEntity.getCardID());                  // 会员ID
            cardMemberVO.setCardSerialNo(inforEntity.getCardSerialNo());      // 会员卡序列号
            cardMemberVO.setCardCreateTime(inforEntity.getIssueTime().toLocalDate());            //   发卡日期   IssueTime
            cardMemberVO.setValidDate(inforEntity.getExpirationDate().toLocalDate());            //   有效日期   ExpirationDate
            cardMemberVO.setArchiveName(inforEntity.getArchiveName());                             //   发卡门店
            cardMemberVO.setCardCurrentBonus(inforEntity.getCardCurrentBonus());                   //   积分余额
            cardMemberVO.setCardLevelName(inforEntity.getCardLevelName());                         //   等级
            cardMemberVO.setCardStatusName(inforEntity.getCardStatusName());                 //    状态
            cardMemberVO.setCardStatus(inforEntity.getCardStatus());                         //    状态ID
        }
        return cardMemberVO;
    }

    /**
     * @return
     * @Description： 取业务员信息列表
     * @Author：HuTao
     * @Time: 2017-4-19 9:23
     * @Version 2.0.0
     */
    public List<UserListVO> getServerNameList(Long orgID, String title, String nameOrId) throws Exception {
        List<UserListVO> userList = new ArrayList<>();
        Map<String, Object> mapData = new HashMap<>();
        mapData.put("orgID", orgID);
        mapData.put("title", title);
        mapData.put("nameOrId", nameOrId);
        List<Map<String, Object>> mapList = u_LoginInfoDao.getServerNameList(mapData);
        for (int i = 0; i < mapList.size(); i++) {
            UserListVO userListVO = new UserListVO();
            BeanHelper.mapToBean(userListVO, mapList.get(i));
            userList.add(userListVO);
        }
        return userList;
    }

    /**
     * @Description：获取充值活动规则信息
     * @Author：HuTao
     * @Time: 2017-5-26 16:11
     * @Version 2.0.0
     */
    public RechargeRuleInfoVO getRechargeRuleInfo(Long archiveID, double rechargeAmount) throws Exception {
        RechargeRuleInfoVO ruleInfoVO = new RechargeRuleInfoVO();
        ruleInfoVO.setSpentAmount(rechargeAmount);
        ruleInfoVO.setPresentAmount(0);
        ruleInfoVO.setPresentBonus(0);
        Map<String, Object> parm = new HashedMap();
        parm.put("ArchiveID", archiveID);
        parm.put("SpentAmount", rechargeAmount);
        Map<String, Object> mapData = memberCardInfoDao.getRechargeRuleInfo(parm);
        if (null != mapData && !mapData.isEmpty()) {
            String discounType = mapData.get("DiscounType").toString();
            double discountPercentage = Double.valueOf(null == mapData.get("DiscountPercentage") ? "0" : mapData.get("DiscountPercentage").toString());
            double presentAmount = Double.valueOf(null == mapData.get("PresentAmount") ? "0" : mapData.get("PresentAmount").toString());
            int presentBonus = Integer.valueOf(null == mapData.get("presentBonus") ? "0" : mapData.get("presentBonus").toString());
            if (discounType.equals(FinancialManageEnum.RechargeAmountModel.FIXED_AMOUNT.getValue())) {     //    固定金额
                ruleInfoVO.setPresentAmount(Double.valueOf(presentAmount));
                ruleInfoVO.setPresentBonus(Integer.valueOf(presentBonus));
            }
            if (discounType.equals(FinancialManageEnum.RechargeAmountModel.RATIO_AMOUNT.getValue())) {     //    比率金额
                ruleInfoVO.setPresentAmount(rechargeAmount * discountPercentage);
                Long vLong = Math.round(rechargeAmount * discountPercentage);
                ruleInfoVO.setPresentBonus(vLong.intValue());
            }
        }


        return ruleInfoVO;
    }

    /**
     * @param memberDepositVO
     * @Description：会员充值
     * @Author：HuTao
     * @Time: 2017-4-21 11:30
     * @Version 2.0.0
     */

    @Transactional(rollbackFor = Exception.class)
    public void memberRecharge(MemberDepositVO memberDepositVO, String cashRegister, String loginName) throws Exception {
        //  生成充值记录
        F_DepositInfoEntity depositInfo = rechargeRecord(memberDepositVO);
        if (null == depositInfo) {
            throw new BizException(CodeMsgConstants.MEMBER_RECHARGERECORD_FAIL, CodeMsgConstants.MEMBER_RECHARGERECORD_FAIL_MSG);
        }
        rechargePayment(memberDepositVO, depositInfo);     //  充值时在线支付
        MemberRechargeDataVO memberRechargeVO = new MemberRechargeDataVO();
        setRechargeAmount(memberDepositVO, memberRechargeVO, depositInfo);      //  充值操作

        if (memberDepositVO.getSignInvoice().equals(SIGNINVOIE)) {            //  开发票
            MemberOpenTicketVO memberOpenTicketVO = new MemberOpenTicketVO();
            memberOpenTicketVO.setCardID(memberDepositVO.getCardID());
            memberOpenTicketVO.setLoginID(memberDepositVO.getOperatorID());
            BigDecimal recharge = new BigDecimal(memberDepositVO.getDeposit());
            memberOpenTicketVO.setRechargeAmount(recharge);
            memberOpenTicketVO.setTicketAmount(recharge);
            memberOpenTicketVO.setDepositID(depositInfo.getDepositID());          //   充值记录ID
            memberOpenTicketVO.setCustomerID(memberDepositVO.getCustomerID());
            //   memberOpenTicketVO.setOrderType();           //
            memberOpenTicket(memberOpenTicketVO);        //   开发票
        }
        //   充值记录打印信息
        Map<String, Object> parmMap = new HashedMap();
        parmMap.put("archiveID", memberDepositVO.getArchiveID());
        parmMap.put("cardID", memberDepositVO.getCardID());
        F_MemberCardInfoEntity inforEntity = memberCardInfoDao.getCardMemberInfor(parmMap);

        MemberCardInfoVO cardInfoVO=new MemberCardInfoVO();
        cardInfoVO.setMemberCard(inforEntity.getCardSerialNo()); // 会员卡号
        cardInfoVO.setCardLevel(inforEntity.getCardLevelName()); // 等级
        cardInfoVO.setMemberCode(inforEntity.getCardID().toString());     // 会员编号
        cardInfoVO.setMemberName(inforEntity.getMemberName());            // 会员名称

       cardInfoVO.setBeforeBalance(new BigDecimal(memberRechargeVO.getBeforeAmount())); // 付款前余额   充值前余额
        cardInfoVO.setBeforePoints(Long.valueOf(memberRechargeVO.getBeforeFraction())); // 充值前积分  充值前积分
        cardInfoVO.setAfterBalance(new BigDecimal(memberRechargeVO.getAfterAmount())); // 付款后余额     充值后余额
        cardInfoVO.setAfterPoints(Long.valueOf(memberRechargeVO.getAfterFraction())); // 充值后积分   充值后积分

        MemberRechargeVO rechargeVO=new MemberRechargeVO();
        rechargeVO.setBusinessID(depositInfo.getDepositID());
        rechargeVO.setArchiveID(memberDepositVO.getArchiveID());

        rechargeVO.setBusinessDate(LocalDate.now()); // 营业日期
        rechargeVO.setSalesMan(memberDepositVO.getCountermanName()); // 营销员
        rechargeVO.setCashier(loginName); // 收银员
        rechargeVO.setCashRegister(cashRegister); // 收银机
        rechargeVO.setBusinessID(depositInfo.getDepositID());   //  充值流水ID
        rechargeVO.setPayMethod(memberDepositVO.getDepositName());  //    充值方式

        rechargeVO.setRechargeAmount(new BigDecimal(memberDepositVO.getDeposit())); // 充值金额
        rechargeVO.setGiveAmount(new BigDecimal(memberDepositVO.getPresent())); // 赠送金额
        rechargeVO.setGivePoints( Long.valueOf(memberDepositVO.getFraction())); // 赠送积分
        try {
            printComponent.printMemberRechargeTicket(rechargeVO, cardInfoVO);    // 打印数据  //     充值票据打印
        }catch (Exception e){
            logger.error(e.getLocalizedMessage());
        }
    }

    /**
     * @param memberDepositVO
     * @Description：充值时 支付宝， 在线支付
     * @Author：HuTao
     * @Time: 2017-6-1 11:26
     * @Version 2.0.0
     */
    private void rechargePayment(MemberDepositVO memberDepositVO, F_DepositInfoEntity depositInfo) throws Exception {     //  充值时在线支付
        if (null != memberDepositVO) {
            if (memberDepositVO.getDepositType().equals(FinancialManageEnum.PayMethod.ALIPAY.getValue()) ||          //    支付宝
                    memberDepositVO.getDepositType().equals(FinancialManageEnum.PayMethod.WECHAT.getValue())) {     //   微信
                //标识请求来源
                String xmlTagName = "";
                //1为单桌支付 2为多桌支付；3为会员充值
                String businessType = "3";
                //  支付宝app
                if (memberDepositVO.getDepositType().equals(FinancialManageEnum.PayMethod.ALIPAY.getValue())) {
                    xmlTagName = "alibydapp";
                }
                //  微信app
                if (memberDepositVO.getDepositType().equals(FinancialManageEnum.PayMethod.WECHAT.getValue())) {
                    xmlTagName = "wxbydapp";
                }
                //   处理支付金额(把元转成分)
                int paymentAmount = (int) (memberDepositVO.getDeposit() * 100);
                String orderNumber = depositInfo.getDepositID().toString();        //    depositID
                Map payMap = new HashMap();
                payMap.put("xmlTagName", xmlTagName);
                payMap.put("orderNumber", orderNumber);
                payMap.put("orderMoney", String.valueOf(paymentAmount));
                payMap.put("businessType", businessType);
                payMap.put("callBackTag", PaymentEnum.CallBackTag.RECHARGE.getValue());
                payMap.put("archiveID", memberDepositVO.getArchiveID().toString());
                payMap.put("authCode", memberDepositVO.getAuthCode());

                //请求支付网关地址
                JSONObject payResultJson = OkHttpClientUtils.payRequest(payMap);
                if (null != payResultJson) {
                    //把返回的数据转为map
                    Map map = JSONObject.parseObject(payResultJson.toString(), new TypeReference<Map>() {
                    });
                    //返回的状态 0为成功 1为失败
                    int status = Integer.valueOf(map.get("status").toString());
                    if (status == 0) {
//                       //  更新平台账户信息
//                      updateAccountInfo(backPaymentDTO, accountInfoForPlatform);
//                       //  添加平台资金变动信息
//                       addFundChangeInfoByPay(backPaymentDTO, accountInfoForPlatform, accountType);
                    } else {       //  第三方支付失败
                        throw new BizException(CodeMsgConstants.THIRD_PARTY_FAIL, CodeMsgConstants.THIRD_PARTY_FAIL_MSG);
                    }
                } else {      //  第三方支付发生异常
                    throw new BizException(CodeMsgConstants.THIRD_PARTY_ERROR, CodeMsgConstants.THIRD_PARTY_ERROR_MSG);
                }
            }
        }
    }

    public void setRechargeAmount(MemberDepositVO memberDepositVO, MemberRechargeDataVO memberRechargeVO, F_DepositInfoEntity depositInfo) throws Exception {
//        // 会员账户 : 700  充值赠送账户: 703
        Map<String, Object> param = new HashMap();
        param.put("customerID", memberDepositVO.getCustomerID());
        param.put("orgID", memberDepositVO.getOrgID());
        param.put("archiveID", memberDepositVO.getArchiveID());
        param.put("accountType", FinancialManageEnum.AccountType.MEMBERACCOUNT.getValue());
        F_AccountInfoEntity account = accountInfoDao.getAccountViceFundInfoByCustomerID(param);
        if (account == null) {
            throw new BizException(CodeMsgConstants.MEMBER_NOTACCOUNT, CodeMsgConstants.MEMBER_NOTACCOUNT_MSG);
        }
        E_CustomerInfoEntity infoEntity = new E_CustomerInfoEntity();
        infoEntity.setCustomerID(memberDepositVO.getCustomerID());
        infoEntity = customerInfoDao.get(infoEntity);
        memberRechargeVO.setCreatorID(memberDepositVO.getOperatorID());
        memberRechargeVO.setDeposit(memberDepositVO.getDeposit());
        memberRechargeVO.setPresent(memberDepositVO.getPresent());

        BigDecimal depositMoney = new BigDecimal(memberDepositVO.getDeposit());  //  充值金额
        BigDecimal presentMoney = new BigDecimal(memberDepositVO.getPresent());  //  赠送金额
        Integer fraction = memberDepositVO.getFraction();                         //  赠送积分
        BigDecimal beforeAmount = account.getFundAmount();                       //  充值前金额
        BigDecimal afterAmount = beforeAmount.add(depositMoney);                //  充值后金额
        //  充值赠送  活动规则 处理   //  memberDepositVO.getRuleID() ;
        // rechargeRuleManage();
//        F_PayOrganizationInfoEntity payOrganizationInfo = payOrganizationInfoDBO.getPayOrganizationInfoByCode(depositInfoReq.getPayCode());
//        if (payOrganizationInfo == null) {
//            return new ResultData(3, "支付机构不存在!");
//        }

        memberRechargeVO.setDepositID(depositInfo.getDepositID());
        //      会员辅助资金信息    会员帐户
        F_ViceFundInfoEntity ViceFundInfoEntity = viceFundInfoDao.getViceFundInfoByCustomerIdAccountType(param);
        beforeAmount = ViceFundInfoEntity.getRealAmount();
        afterAmount = beforeAmount.add(depositMoney);
        afterAmount=afterAmount.add(presentMoney);
        ViceFundInfoEntity.setRealAmount(afterAmount);
        ViceFundInfoEntity.setIsSync(false);
        viceFundInfoDao.updateRealAmount(ViceFundInfoEntity);
        //      辅助资金历史信息
        F_ViceFundHistoryInfoEntity viceFundHistoryInfoEntity =new F_ViceFundHistoryInfoEntity();
        BeanUtils.copyProperties(ViceFundInfoEntity,viceFundHistoryInfoEntity);
        viceFundHistoryInfoEntity.setGetTime(DateUtils.getUTCLocalDateTime());
        viceFundHistoryInfoEntity.setGetMode(null);
        if(null==viceFundHistoryInfoEntity.getCardCode()) {
            viceFundHistoryInfoEntity.setCardCode("");
        }
        viceFundHistoryInfoDao.save(viceFundHistoryInfoEntity);

        //  充值处理信息
        F_DepositDealInfoEntity depositDealInfoEntity = new F_DepositDealInfoEntity();
        depositDealInfoEntity.setDepositID(depositInfo.getDepositID());
        depositDealInfoEntity.setCreatorID(memberDepositVO.getCountermanID());
        depositDealInfoEntity.setIsSync(false);
        depositDealInfoDao.save(depositDealInfoEntity);

        // 添加资金变动信息
        F_FundChangeInfoEntity fundChangeInfo = new F_FundChangeInfoEntity();
        fundChangeInfo.setCardID(memberDepositVO.getCardID());
        fundChangeInfo.setCardCode(memberDepositVO.getCardCode());
        fundChangeInfo.setArchiveID(memberDepositVO.getArchiveID());
        fundChangeInfo.setCurrencyID(1L);
        fundChangeInfo.setLoginID(account.getLoginID());
        fundChangeInfo.setCustomerID(account.getCustomerID());
        fundChangeInfo.setRealName(account.getRealName());
        fundChangeInfo.setAccountID(account.getAccountID());
        fundChangeInfo.setBusinessID(depositInfo.getDepositID());
        fundChangeInfo.setAccountType(FinancialManageEnum.AccountType.MEMBERACCOUNT.getValue());  //  帐户类别: 会员账户
        fundChangeInfo.setChangeType(FinancialManageEnum.FundChangeType.ADD.getValue());   //  变动方式: 增加s
        fundChangeInfo.setBusinessType(FinancialManageEnum.FundChangeBusinessType.RECHARGE.getValue()); //  业务类型: 充值
        fundChangeInfo.setChangeAmount(depositMoney);
        fundChangeInfo.setBeforeAmount(beforeAmount);
        fundChangeInfo.setAfterAmount(afterAmount);
        fundChangeInfo.setChangeReason("门店会员充值");
        fundChangeInfo.setCreatorID(memberDepositVO.getOperatorID());
        fundChangeInfo.setCreateTime(LocalDateTime.now());
        fundChangeInfo.setMemo(memberDepositVO.getMemo());
        fundChangeInfo.setIsSync(false);
        fundChangeInfoDao.save(fundChangeInfo);
        // 添加资金变动明细信息
        F_FundChangeDetailInfoEntity changeDetailInfo = new F_FundChangeDetailInfoEntity();
        changeDetailInfo.setChangeID(fundChangeInfo.getChangeID());
        changeDetailInfo.setAccountID(account.getAccountID());
        changeDetailInfo.setAccountType(FinancialManageEnum.AccountType.MEMBERACCOUNT.getValue());     // 帐户类别: 会员账户
        changeDetailInfo.setFundID(ViceFundInfoEntity.getFundID());
        changeDetailInfo.setChangeAmount(depositMoney);
        changeDetailInfo.setChangeReason("门店会员充值");
        changeDetailInfo.setCreateTime(LocalDateTime.now());
        changeDetailInfo.setCreatorID(memberDepositVO.getOperatorID());
        changeDetailInfo.setIsSync(false);
        changeDetailInfoDao.save(changeDetailInfo);
        // 如果有赠送金额则添加一条赠送资金变动信息记录
        param.put("accountType", FinancialManageEnum.AccountType.DEPOSITPRESENTACCOUNT.getValue());

        if (fraction != 0) {
            //   商户积分信息
            E_MerchantBonusInfoEntity bonusInfo = new E_MerchantBonusInfoEntity();
            bonusInfo.setArchiveID(memberDepositVO.getArchiveID());
            bonusInfo.setCardID(memberDepositVO.getCardID());
            bonusInfo.setCustomerID(memberDepositVO.getCustomerID());
            bonusInfo = merchantBonusInfoDao.getEntity(bonusInfo);     ///    取商户积分信息
            int memberBonus = 0;
            if (null != bonusInfo) {
                memberBonus = bonusInfo.getCurrentBonus();
                memberRechargeVO.setBeforeFraction(memberBonus);
                bonusInfo.setTotalBonus(bonusInfo.getTotalBonus() + fraction);
                bonusInfo.setCurrentBonus(memberBonus + fraction);                        //    变动积分
                merchantBonusInfoDao.updateMemberBonus(bonusInfo);
            }
            //  添加积分变动信息
            E_BonusChangeInfoEntity bonusChangeInfo = new E_BonusChangeInfoEntity();
            bonusChangeInfo.setBonusID(bonusInfo.getBonusID());
            bonusChangeInfo.setCustomerID(memberDepositVO.getCustomerID());
            bonusChangeInfo.setCreatorID(memberDepositVO.getOperatorID());
            bonusChangeInfo.setBusinessID(depositInfo.getDepositID());        //   充值记录ID
            bonusChangeInfo.setChangeType(FinancialManageEnum.FundChangeType.ADD.getValue());
            bonusChangeInfo.setBusinessType(FinancialManageEnum.FundChangeBusinessType.RECHARGE.getValue());
            bonusChangeInfo.setChangeAmount(memberDepositVO.getFraction());
            bonusChangeInfo.setBeforeAmount(memberBonus);
            bonusChangeInfo.setAfterAmount(memberBonus + memberDepositVO.getFraction());
            bonusChangeInfoDao.save(bonusChangeInfo);
        }
        //--------
        if (presentMoney.intValue() != 0) {    //  赠送金额
            //     添加赠送资金变动明细信息
            F_FundChangeDetailInfoEntity presentChangeDetailInfo = new F_FundChangeDetailInfoEntity();
            presentChangeDetailInfo.setChangeID(fundChangeInfo.getChangeID());
            presentChangeDetailInfo.setAccountID(account.getAccountID());
            presentChangeDetailInfo.setAccountType(FinancialManageEnum.AccountType.DEPOSITPRESENTACCOUNT.getValue()); // 帐户类别: 充值赠送账户
            presentChangeDetailInfo.setFundID(viceFundHistoryInfoEntity.getFundID());
            presentChangeDetailInfo.setChangeAmount(presentMoney);
            presentChangeDetailInfo.setChangeReason("门店会员充值赠送");
            presentChangeDetailInfo.setCreateTime(LocalDateTime.now());
            presentChangeDetailInfo.setCreatorID(memberDepositVO.getOperatorID());
            presentChangeDetailInfo.setMemo(memberDepositVO.getMemo());
            presentChangeDetailInfo.setIsSync(false);
            changeDetailInfoDao.save(changeDetailInfo);
        }
    }

    /**
     * @param cardID
     * @param oldPassword
     * @param newPassword
     * @Description：会员密码修改
     * @Author：HuTao
     * @Time: 2017-5-24 15:39
     * @Version 2.0.0
     */
    public void updateCardPassword(Long cardID, String oldPassword, String newPassword) {
        Map<String, Object> parm = new HashedMap();
        parm.put("cardID", cardID);
        parm.put("oldPassword", oldPassword);
        F_MemberCardInfoEntity nfoEntity = memberCardInfoDao.checkPassword(parm);
        if (null == nfoEntity) {
            throw new BizException(CodeMsgConstants.MEMBER_OLDPASSWORD, CodeMsgConstants.MEMBER_OLDPASSWORD_MSG);
        }
        parm.put("newPassword", newPassword);
        memberCardInfoDao.updateCardPassword(parm);
    }

    /**
     * @param cardID
     * @param newPassword
     * @Description：根据会员ID,重置会员密码
     * @Author：HuTao
     * @Time: 2017-5-25 13:46
     * @Version 2.0.0
     */
    public void repeatCardPassword(Long cardID, String newPassword) {
        Map<String, Object> parm = new HashedMap();
        parm.put("cardID", cardID);
        parm.put("newPassword", newPassword);
        memberCardInfoDao.updateCardPassword(parm);
    }

    /**
     * @param cardID
     * @Description：根据会员ID,做会员冻结操作
     * @Author：HuTao
     * @Time: 2017-5-25 13:58
     * @Version 2.0.0
     */
    public void blockedMember(Long cardID) {
        Map<String, Object> parm = new HashedMap();
        parm.put("cardID", cardID);
        parm.put("cardStatus", CustomerManageEnum.CardStatus.FROZEN.getValue());
        memberCardInfoDao.updateCardStatus(parm);
    }

    /**
     * @param cardID
     * @Description：根据会员ID,做会员解冻操作
     * @Author：HuTao
     * @Time: 2017-5-31 12:02
     * @Version 2.0.0
     */
    public void thawMember(Long cardID) {
        Map<String, Object> parm = new HashedMap();
        parm.put("cardID", cardID);
        parm.put("cardStatus", CustomerManageEnum.CardStatus.NORMAL.getValue());
        memberCardInfoDao.updateCardStatus(parm);
    }

    /**
     * @param cardID
     * @Description：根据会员ID,注销会员
     * @Author：HuTao
     * @Time: 2017-5-25 14:33
     * @Version 2.0.0
     * @Author：HuTao
     * @Time: 2017-5-25 14:32
     * @Version 2.0.0
     */
    public void cancellationMember(Long cardID) {
        Map<String, Object> parm = new HashedMap();
        parm.put("cardID", cardID);
        parm.put("cardStatus", CustomerManageEnum.CardStatus.DISABLE.getValue());  //  停用
        memberCardInfoDao.updateCardStatus(parm);
    }

    /**
     * @param loginID
     * @param quDate
     * @return
     * @Description：根据会员ID,时间，充值记录查询
     * @Author：HuTao
     * @Time: 2017-5-25 17:12
     * @Version 2.0.0
     */
    public List<MemberRechargeRecordVO> queryMemberRecharge(Long loginID, String quDate) throws Exception {
        List<MemberRechargeRecordVO> rechargeRecordVOList = new ArrayList<>();
        Map<String, Object> parm = new HashedMap();
        parm.put("loginID", loginID);
        parm.put("quDate", quDate);
        List<Map<String, Object>> maplist = memberCardInfoDao.queryMemberRecharge(parm);
        if (maplist != null && !maplist.isEmpty()) {
            for (int i = 0; i < maplist.size(); i++) {
                MemberRechargeRecordVO rechargeRecordVO = new MemberRechargeRecordVO();
                BeanHelper.mapToBean(rechargeRecordVO, maplist.get(i));
                rechargeRecordVOList.add(rechargeRecordVO);
            }
        }
        return rechargeRecordVOList;
    }

    /**
     * @param memberOpenTicketVO
     * @Description：会员开票
     * @Author：HuTao
     * @Time: 2017-5-26 11:09
     * @Version 2.0.0
     */
    @Transactional(rollbackFor = Exception.class)
    public void memberOpenTicket(MemberOpenTicketVO memberOpenTicketVO) {
        F_InvoiceInfoEntity infoEntity = new F_InvoiceInfoEntity();
        infoEntity.setIsSync(false);
        infoEntity.setCreatorID(memberOpenTicketVO.getLoginID());
        infoEntity.setDepartName(memberOpenTicketVO.getTicketUnit());      //    开票单位
        infoEntity.setOderAmount(memberOpenTicketVO.getTicketAmount());    //    发票金额
        infoEntity.setInvoiceDesc(memberOpenTicketVO.getTicketMemo());     //    开票备注
        infoEntity.setInvoiceCode(memberOpenTicketVO.getTicketNo());       //   发票编号
        infoEntity.setCustomerID(memberOpenTicketVO.getCustomerID());     //   客户ID
        infoEntity.setInvoiceStatus(213L);                                 //    正常
        infoEntity.setOrderType(memberOpenTicketVO.getOrderType());        //  订单类别
        infoEntity.setOrderID(memberOpenTicketVO.getDepositID());      //   订单ID  充值ID
        invoiceInfoDao.save(infoEntity);
    }

    /**
     * @param cardID
     * @param depositID
     * @Description：重打小票
     * @Author：HuTao
     * @Time: 2017-5-31 15:15
     * @Version 2.0.0
     */

    public void repeatPrintTicket(Long loginID, Long cardID, Long depositID) {
        BusinessVO businessVO = new BusinessVO() ;
        businessVO.setBusinessID(depositID);
        businessVO.setBusinessType(CommonManageEnum.BusinessType.RECHARGE.getValue());
        printComponent.reprintTicket(businessVO);
    }

    //----------------------------------------------

    private F_DepositInfoEntity rechargeRecord(MemberDepositVO memberDepositVO) {
        //        // 会员账户 : 700  充值赠送账户: 703
        Map<String, Object> param = new HashMap();
        param.put("customerID", memberDepositVO.getCustomerID());
        param.put("orgID", memberDepositVO.getOrgID());
        param.put("archiveID", memberDepositVO.getArchiveID());
        param.put("accountType", FinancialManageEnum.AccountType.MEMBERACCOUNT.getValue());
        F_AccountInfoEntity account = accountInfoDao.getAccountViceFundInfoByCustomerID(param);
        if (account == null) {
            throw new BizException(CodeMsgConstants.MEMBER_NOTACCOUNT, CodeMsgConstants.MEMBER_NOTACCOUNT_MSG);
        }
        BigDecimal depositMoney = new BigDecimal(memberDepositVO.getDeposit());  //  充值金额
        BigDecimal presentMoney = new BigDecimal(memberDepositVO.getPresent());  //  赠送金额
        F_DepositInfoEntity depositInfo = new F_DepositInfoEntity();
        // depositInfo.setPayOrgID(payOrganizationInfo.getPayOrgID());
        depositInfo.setRealName(account.getRealName());
        depositInfo.setCardID(memberDepositVO.getCardID());
        depositInfo.setCardCode(memberDepositVO.getCardCode());
        depositInfo.setDepositType(memberDepositVO.getDepositType());
        depositInfo.setArchiveID(memberDepositVO.getArchiveID());
        depositInfo.setAccountID(account.getAccountID());
        depositInfo.setAccountType(FinancialManageEnum.AccountType.MEMBERACCOUNT.getValue());
        depositInfo.setSubmitTime(LocalDateTime.now());
        depositInfo.setDepositMoney(depositMoney);    //  充值金额
        depositInfo.setCharge(0.00f);
        depositInfo.setCurrencyID(1L); // 人民币
        depositInfo.setFundID(account.getFundID());
        depositInfo.setLoginID(account.getLoginID());
        depositInfo.setDepositStatus(FinancialManageEnum.DepositStatus.SUCCESS.getValue()); // 充值状态：成功
        depositInfo.setCustomerID(account.getCustomerID());
        depositInfo.setPresentMoney(presentMoney);      // 赠送金额
        depositInfo.setPresentBonus(memberDepositVO.getFraction());      // 赠送积分
        depositInfo.setRealAmount(depositMoney.add(presentMoney)); //  实际金额
        depositInfo.setSupplyTime(LocalDateTime.now());
        depositInfo.setOperatorID(memberDepositVO.getOperatorID());
        depositInfo.setCreateTime(LocalDateTime.now());
        depositInfo.setIsSync(false);
        depositInfo.setRuleID(memberDepositVO.getRuleID());
        depositInfo.setPayOrgID(1L);
        //   保存充值记录
        depositInfoDao.save(depositInfo);

        return depositInfo;
    }

    private E_CustomerInfoEntity getCustomerInfoEntity(MemberVO memberVO) {
        E_CustomerInfoEntity infoEntity = new E_CustomerInfoEntity();
        infoEntity.setArchiveID(memberVO.getArchiveID());   //  档案I
        infoEntity.setCustomerName(memberVO.getMemberName());  //  会员姓名
        infoEntity.setGender(memberVO.getGender());     //  会员性别
        infoEntity.setOrgID(memberVO.getOrgID());       //  组织ID
        infoEntity.setMobile(memberVO.getMobile());     //  手机号码头
        infoEntity.setBirthday(LocalDate.parse(memberVO.getBirthday()));  //  生日
        infoEntity.setCardCode(memberVO.getCardCode());  //  会员卡Code
        infoEntity.setEmail(memberVO.getEmail());        //  电子邮件
        infoEntity.setPassportType(memberVO.getPassportType());  //  证件类型
        infoEntity.setIDCode(memberVO.getIDCode());  //  证件号码
        infoEntity.setCreateTime(LocalDateTime.now());  //  新建时间
        infoEntity.setLoginID(memberVO.getOperatorID());  //  操作员ID
        infoEntity.setPayPassword(memberVO.getPayPassword());    //  支付密码
        infoEntity.setSourceType(SystemManageEnum.OrgType.RESTAURANT.getValue());      //  客户来源
        return infoEntity;
    }

    private E_LoginInfoEntity getLoginInfoEntity(E_CustomerInfoEntity customerInfo) {
        E_LoginInfoEntity infoEntity = new E_LoginInfoEntity();
        infoEntity.setCustomerID(customerInfo.getCustomerID());
        infoEntity.setLoginName(customerInfo.getMobile());
        infoEntity.setIsForceChange(true);
        infoEntity.setNickName(customerInfo.getCustomerName());
        infoEntity.setTotalLoginNumber(0);
        infoEntity.setCreateTime(LocalDateTime.now());
        infoEntity.setMemo(customerInfo.getMemo());
        return infoEntity;
    }

    private F_AccountInfoEntity getAccountInfoEntity(E_CustomerInfoEntity customerInfo) {
        F_AccountInfoEntity account = new F_AccountInfoEntity();
        BigDecimal defaultAmount = new BigDecimal(0.00);
        account = new F_AccountInfoEntity();
        account.setCustomerID(customerInfo.getCustomerID());
        account.setRealName(customerInfo.getCustomerName());
        account.setCustomerType(CustomerManageEnum.CustomerType.DINER.getValue()); // 食客
        account.setFundAmount(defaultAmount);
        account.setFrozenAmount(defaultAmount);
        account.setReceivableAmount(defaultAmount);
        account.setDueAmount(defaultAmount);
        account.setStandbyAmount(defaultAmount);
        account.setCanCashAmount(defaultAmount);
        account.setDepositBalance(defaultAmount);
        account.setPrepaymentBalance(defaultAmount);
        account.setBorrowFundAmount(defaultAmount);
        account.setCreateTime(LocalDateTime.now());
        account.setLatestOperatorID(customerInfo.getOperatorID());
        account.setIsSync(false);
        return account;
    }

    private F_MemberCardInfoEntity getMemberCardInfoEntity(E_CustomerInfoEntity customerInfo, MemberVO memberVO) {
        F_MemberCardInfoEntity memberCardInfo = new F_MemberCardInfoEntity();
        memberCardInfo.setCustomerID(customerInfo.getCustomerID());
        memberCardInfo.setOrgID(memberVO.getOrgID());
        memberCardInfo.setMemberMobile(customerInfo.getMobile());
        memberCardInfo.setMemberName(memberVO.getMemberName());
        memberCardInfo.setArchiveID(customerInfo.getArchiveID());
        memberCardInfo.setCardCode(memberVO.getCardCode());
        if (null == memberVO.getRoleID() || memberVO.getRoleID().equals("")) {
            memberCardInfo.setRoleID(null);
        } else {
            memberCardInfo.setRoleID(Long.valueOf(memberVO.getRoleID()));
        }
        memberCardInfo.setCardType(memberVO.getCardType());          //   卡类型：充值卡 716
        if (null == memberVO.getCardSerialNo() || memberVO.getCardSerialNo().equals("")) {
            String serialNo = customerInfo.getCustomerID().toString();
            if (serialNo.length() >= 5) {
                serialNo = serialNo.substring(serialNo.length() - 5, serialNo.length());
            }
            memberCardInfo.setCardSerialNo(serialNo);
        } else {
            memberCardInfo.setCardSerialNo(memberVO.getCardSerialNo());
        }
        memberCardInfo.setPayPassword(memberVO.getPayPassword());         //  支付密码
        memberCardInfo.setCardStatus(CustomerManageEnum.CardStatus.NORMAL.getValue());
        memberCardInfo.setExpirationDate(DateUtils.addYear(LocalDateTime.now(), 5));     //  有效日期
        memberCardInfo.setIssueTime(LocalDateTime.now());          //  发卡日期货
        memberCardInfo.setCreatorID(customerInfo.getOperatorID());
        memberCardInfo.setCreateTime(LocalDateTime.now());
        memberCardInfo.setMemo(memberVO.getMemo());
        memberCardInfo.setIsSync(false);
        return memberCardInfo;
    }

    private F_MemberCardRequestInfoEntity getMemberCardRequestInfoEntity(E_CustomerInfoEntity customerInfo, MemberVO memberVO) {
        F_MemberCardRequestInfoEntity memberCardRequest = new F_MemberCardRequestInfoEntity();
        memberCardRequest.setCardID(customerInfo.getCardID());
        memberCardRequest.setLoginID(customerInfo.getOperatorID());
        memberCardRequest.setCardNo(customerInfo.getCardCode());
        memberCardRequest.setCreateTime(LocalDateTime.now());
        memberCardRequest.setMemo(customerInfo.getMemo());
        memberCardRequest.setApprover(customerInfo.getOperatorID());
        memberCardRequest.setIsSync(false);
        memberCardRequest.setMemberMobile(customerInfo.getMobile());
        memberCardRequest.setMemberName(customerInfo.getCustomerName());
        memberCardRequest.setCountermanID(memberVO.getCountermanID());    //  业务员ID
        memberCardRequest.setCounterman(memberVO.getCountermanName());
        return memberCardRequest;
    }

    private U_OrgCustomerMappingEntity getOrgCustomerMappingEntity(E_CustomerInfoEntity customerInfo) { // 组织客户关联
        U_OrgCustomerMappingEntity ocMapping = new U_OrgCustomerMappingEntity();
        ocMapping.setOrgID(customerInfo.getOrgID());
        ocMapping.setCustomerID(customerInfo.getCustomerID());
        ocMapping.setCreateTime(LocalDateTime.now());
        ocMapping.setCreatorID(customerInfo.getOperatorID());
        ocMapping.setMemo(customerInfo.getMemo());
        return ocMapping;
    }

    private F_ViceFundInfoEntity getViceFundInfoEntity(E_CustomerInfoEntity customerInfo, F_AccountInfoEntity account) {  // 添加会员充值辅助资金信息
        F_ViceFundInfoEntity viceFundInfo = new F_ViceFundInfoEntity();
        BigDecimal defaultAmount = new BigDecimal(0.00);
        viceFundInfo.setCardID(customerInfo.getCardID());
        viceFundInfo.setCardCode(customerInfo.getCardCode());
        viceFundInfo.setArchiveID(customerInfo.getArchiveID());
        viceFundInfo.setAccountID(account.getAccountID());
        viceFundInfo.setAccountType(FinancialManageEnum.AccountType.MEMBERACCOUNT.getValue()); // 会员账户
        viceFundInfo.setCustomerID(customerInfo.getCustomerID());
        viceFundInfo.setCurrencyID(1L); // 人民币   货币编号
        viceFundInfo.setLoginID(customerInfo.getLoginID());
        viceFundInfo.setRealName(customerInfo.getCustomerName());
        viceFundInfo.setInitAmount(defaultAmount);
        viceFundInfo.setRealAmount(defaultAmount);
        viceFundInfo.setFrozenAmount(defaultAmount);

        viceFundInfo.setUseMode(FinancialManageEnum.UseMode.SPECIFICSTORES.getValue()); // 使用方式: 特定门店
        viceFundInfo.setTargetIDs(customerInfo.getArchiveID().toString());
        viceFundInfo.setEffectiveTime(LocalDateTime.now());
        viceFundInfo.setGetMode(FinancialManageEnum.GetMode.REFILL.getValue()); // 获取方式: 储值
        viceFundInfo.setCreateTime(LocalDateTime.now());
        viceFundInfo.setMemo(customerInfo.getMemo());
        viceFundInfo.setIsSync(false);
        return viceFundInfo;
    }

    private F_ViceFundHistoryInfoEntity getViceFundHistoryInfoEntity() {    //添加辅助资金历史
        F_ViceFundHistoryInfoEntity viceFundHistory = new F_ViceFundHistoryInfoEntity();

        return viceFundHistory;
    }

    private F_AccountCardMappingEntity getAccountCardMappingEntity(E_CustomerInfoEntity customerInfo, F_AccountInfoEntity account, F_ViceFundInfoEntity viceFundInfo) {  //  添加会员卡账户关联信息
        F_AccountCardMappingEntity acMapping = new F_AccountCardMappingEntity();
        acMapping.setCardID(customerInfo.getCardID());
        acMapping.setAccountID(account.getAccountID());
        acMapping.setFundID(viceFundInfo.getFundID());
        acMapping.setCreatorID(customerInfo.getOperatorID());
        acMapping.setCreateTime(LocalDateTime.now());
        acMapping.setMemo(customerInfo.getMemo());
        acMapping.setIsSync(false);
        return acMapping;
    }

    private E_MerchantBonusInfoEntity getMerchantBonusInfoEntity(E_CustomerInfoEntity customerInfo) {   //  初始化积分
        E_MerchantBonusInfoEntity bonusInfo = new E_MerchantBonusInfoEntity();
        bonusInfo.setCustomerID(customerInfo.getCustomerID());
        bonusInfo.setArchiveID(customerInfo.getArchiveID());
        bonusInfo.setCardID(customerInfo.getCardID());
        bonusInfo.setCardCode(customerInfo.getCardCode());
        bonusInfo.setTotalBonus(0);
        bonusInfo.setCurrentBonus(0);
        bonusInfo.setCreateTime(LocalDateTime.now());
        return bonusInfo;
    }

    private F_MemberCardInfoEntity getUpdateMemberCardInfoEntity(MemberVO memberVO) {
        F_MemberCardInfoEntity memberCardInfo = new F_MemberCardInfoEntity();     //  会员卡信息
        memberCardInfo.setMemberName(memberVO.getMemberName());
        memberCardInfo.setMemberMobile(memberVO.getMobile());
        memberCardInfo.setCardID(memberVO.getCardID());
        memberCardInfo.setOrgID(memberVO.getOrgID());
        memberCardInfo.setArchiveID(memberVO.getArchiveID());
        memberCardInfo.setCardCode(memberVO.getCardCode());
        if (null == memberVO.getRoleID() || memberVO.getRoleID().equals("")) {
            memberCardInfo.setRoleID(null);
        } else {
            memberCardInfo.setRoleID(Long.valueOf(memberVO.getRoleID()));
        }
        memberCardInfo.setCardType(memberVO.getCardType()); // 卡类型： 充值卡 716
        memberCardInfo.setCardStatus(CustomerManageEnum.CardStatus.NORMAL.getValue());
        memberCardInfo.setCreatorID(memberVO.getOperatorID());
        memberCardInfo.setCreateTime(LocalDateTime.now());
        memberCardInfo.setMemo(memberVO.getMemo());
        memberCardInfo.setIsSync(false);
        return memberCardInfo;
    }

    /**
     * @Description： 根据手机号获取用户信息
     * @Author：Zhaolingchen
     * @Time: 2017-5-20 17:12
     * @Version 2.0.0
     */
    public E_LoginInfoEntity getUserInfoByMobile(String mobile) {
        return loginInfoDao.getLoginInfoByMobile(mobile);
    }

    /**
     * @Description： 根据手机号获取用户档案信息
     * @Author：Zhaolingchen
     * @Time: 2017-5-22 17:12
     * @Version 2.0.0
     */
    public Map<String, Object> getMemberRecordInfoByMobile(Map<String, Object> param) {
        return memberCardInfoDao.getMemberRecordInfoByMobile(param);
    }

}
