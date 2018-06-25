package cc.toprank.byd.web.service.payment;

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.dao.F_MemberCardInfoDao;
import cc.toprank.byd.entity.F_MemberCardInfoEntity;
import cc.toprank.byd.entity.MemberCardInfoVO;
import cc.toprank.byd.enums.CustomerManageEnum;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.entity.MemCardInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 会员卡信息
 * Created by HuangCY on 2017-6-8.
 */
@Service("memberCardInfoService")
public class MemberCardInfoService {

    //会员卡信息
    @Autowired
    private F_MemberCardInfoDao memberCardInfoDao;

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 根据会员卡号或手机号查询会员信息
     * @time 2017-6-8 18:34
     */
    public MemberCardInfoVO queryMemberCardByCondition(Long cardID, String phoneNumber, Long archiveID) {
        MemberCardInfoVO memberCardInfoVO = new MemberCardInfoVO();

        F_MemberCardInfoEntity MemberCardSetParams = new F_MemberCardInfoEntity();

        MemberCardSetParams.setCardID(cardID);
        MemberCardSetParams.setMemberMobile(phoneNumber);
        MemberCardSetParams.setArchiveID(archiveID);

        MemCardInfoDTO memCardInfoDTO = memberCardInfoDao.queryMemberCardByCondition(MemberCardSetParams);

        if (null != memCardInfoDTO) {
            //失效时间
            LocalDateTime expirationDate = memCardInfoDTO.getExpirationDate();

            //如果当前日期在失效日期之后，说明还已过期
            if (LocalDateTime.now().isAfter(expirationDate)) {
                throw new BizException(CodeMsgConstants.CARD_EXPIRED,CodeMsgConstants.CARD_EXPIRED_MSG);
            }

            if (memCardInfoDTO.getCardStatus().equals(CustomerManageEnum.CardStatus.NORMAL.getValue())) {    //正常
                memberCardInfoVO.setCode(CodeMsgConstants.SUCCESS);
                memberCardInfoVO.setMessage(CodeMsgConstants.SUCCESS_MSG);

                memberCardInfoVO.setMemCardInfoDTO(memCardInfoDTO);
            } else if (memCardInfoDTO.getCardStatus().equals(CustomerManageEnum.CardStatus.DISABLE.getValue())) {   //停用
                throw new BizException(CodeMsgConstants.CARD_DISABLE,CodeMsgConstants.CARD_DISABLE_MSG);
            } else if (memCardInfoDTO.getCardStatus().equals(CustomerManageEnum.CardStatus.EXPIRED.getValue())) {    //过期
                throw new BizException(CodeMsgConstants.CARD_EXPIRED,CodeMsgConstants.CARD_EXPIRED_MSG);
            } else if (memCardInfoDTO.getCardStatus().equals(CustomerManageEnum.CardStatus.FROZEN.getValue())) {    //冻结
                throw new BizException(CodeMsgConstants.CARD_FROZEN,CodeMsgConstants.CARD_FROZEN_MSG);
            } else if (memCardInfoDTO.getCardStatus().equals(CustomerManageEnum.CardStatus.LOCKING.getValue())) {    //锁定
                throw new BizException(CodeMsgConstants.CARD_LOCKING,CodeMsgConstants.CARD_LOCKING_MSG);
            } else if (memCardInfoDTO.getCardStatus().equals(CustomerManageEnum.CardStatus.NOTCERTIFIED.getValue())) {    //未认证
                throw new BizException(CodeMsgConstants.CARD_NOTCERTIFIED,CodeMsgConstants.CARD_NOTCERTIFIED_MSG);
            } else if (memCardInfoDTO.getCardStatus().equals(CustomerManageEnum.CardStatus.INITIALIZATION.getValue())) {    //初始化
                throw new BizException(CodeMsgConstants.CARD_INITIALIZATION,CodeMsgConstants.CARD_INITIALIZATION_MSG);
            } else if (memCardInfoDTO.getCardStatus().equals(CustomerManageEnum.CardStatus.ADVANCE.getValue())) {    //预售
                throw new BizException(CodeMsgConstants.CARD_ADVANCE,CodeMsgConstants.CARD_ADVANCE_MSG);
            } else {
                throw new BizException(CodeMsgConstants.CARD_UNKNOWN,CodeMsgConstants.CARD_UNKNOWN_MSG);
            }
        } else {
            throw new BizException(CodeMsgConstants.CARD_UNKNOWN,CodeMsgConstants.CARD_UNKNOWN_MSG);
        }

        return memberCardInfoVO;
    }
}
