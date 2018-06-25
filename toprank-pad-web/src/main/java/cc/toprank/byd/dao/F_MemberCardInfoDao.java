package cc.toprank.byd.dao;


import cc.toprank.byd.entity.E_CustomerInfoEntity;
import cc.toprank.byd.entity.F_MemberCardInfoEntity;
import cc.toprank.byd.entity.MemCardInfoDTO;

import java.util.List;
import java.util.Map;



public interface F_MemberCardInfoDao {

  int deleteByPrimaryKey(Long cardID);

  int insert(F_MemberCardInfoEntity record);

  int insertSelective(F_MemberCardInfoEntity record);

  F_MemberCardInfoEntity selectByPrimaryKey(Long cardID);

  int updateByPrimaryKeySelective(F_MemberCardInfoEntity record);

  int updateByPrimaryKey(F_MemberCardInfoEntity record);


  F_MemberCardInfoEntity get(F_MemberCardInfoEntity InfoEntity);

  List<F_MemberCardInfoEntity> getAll();

  int update(F_MemberCardInfoEntity InfoEntity);

  void delete(F_MemberCardInfoEntity InfoEntity);

  void save(F_MemberCardInfoEntity InfoEntity);


   int updateMemberCardStatus(F_MemberCardInfoEntity memberCardInfo);

   F_MemberCardInfoEntity getMemberCardInfoByCardCodeAndOrgID(Map<String, Object> param) ;

  /**
   * @Description： 根据会员卡编号查询会员卡充值信息
   * @Author：LanZY
   * @Time: 2017-3-27 13:12
   * @Version 2.0.0
   * @param cardID  会员卡编号
   * @return 充值信息
   *
   */
  Map<String,Object> getMemberCardRechargeInfoByCardID(Long cardID);

  /**
   * @Description：根据会员名称，电话，会员卡员 ；查询会员信息
   * @Author：HuTao
   * @Time: 2017-3-31 14:00
   * @Version 2.0.0
   * @param parm
   * @return
   */
  List<E_CustomerInfoEntity> searchMember(Map<String,Object> parm);

  /**
   * @Description：根据会员名称，电话，会员卡员 ；查询会员信息的总数
   * @Author：HuTao
   * @Time: 2017-4-10 14:16
   * @Version 2.0.0
   * @param parm
   * @return
   */

  Map<String,Object> getQueryMemberCount(Map<String,Object> parm);

  /**
   * @Description：修改会员信息
   * @Author：HuTao
   * @Time: 2017-4-5 16:57
   * @Version 2.0.0
   * @param InfoEntity
   */
  void updateMember(F_MemberCardInfoEntity InfoEntity);

  /**
   * @Description： 根据CardID , 修改业务员ID, 业务员
   * @Author：HuTao
   * @Time: 2017-5-7 15:59
   * @Version 2.0.0
   */
  void updateCountermanID(Map<String,Object> parm);
  /**
   *  @Description：根据会员卡ID 查询会员信息
   * @Author：HuTao
   * @Time: 2017-4-7 9:55
   * @Version 2.0.0
   * @param parm
   * @return
   */
  E_CustomerInfoEntity quMemberInfor(Map<String,Object> parm);

  /**
   * @Description：  根据会员卡号 查询会员信息
   * @Author：HuTao
   * @Time: 2017-4-7 17:05
   * @Version 2.0.0
   * @param parm
   * @return
   */
  F_MemberCardInfoEntity getMemberInforByCardCode(Map<String,Object> parm);

  /**
   * @Description：根据会员卡号 查询会员客户关联信息
   * @Author：HuTao
   * @Time: 2017-4-7 17:11
   * @Version 2.0.0
   * @param parm
   * @return
   *
   */

  Map<String ,Object> getCustomerMemberInforByCardCode(Map<String,Object> parm);

  /**
   * @Description：取会员卡的总数，会员卡余额合计
   * @Author：HuTao
   * @Time: 2017-4-12 14:43
   * @Version 2.0.0
   * @param parm
   * @return
   */
  Map<String,Object>  getCardCount(Map<String,Object> parm);

  /**
   * @Description：根据cardID 取会员档案信息
   * @Author：HuTao
   * @Time: 2017-4-12 17:26
   * @Version 2.0.0
   * @param parm
   * @return
   */
  F_MemberCardInfoEntity  getCardMemberInfor(Map<String,Object> parm);

  /**
   * @Description：根据cardID 获取会员的累积消费，充值，预定等信息
   * @Author：HuTao
   * @Time: 2017-4-14 9:33
   * @Version 2.0.0
   * @param parm
   * @return
   */
  Map<String,Object>  getCumulateValue(Map<String,Object> parm);

  List<Map<String,Object>> getMemRoleLeve(Long orgID);

  Map<String,Object> getMemberRecordInfoByMobile(Map<String,Object> param);

  /**
   * @Description：验证旧密码
   * @Author：HuTao
   * @Time: 2017-5-24 18:20
   * @Version 2.0.0
   * @param parm
   * @return
   */
  F_MemberCardInfoEntity  checkPassword(Map<String,Object> parm);

  /**
   * @Description：修改会员密码
   * @Author：HuTao
   * @Time: 2017-5-24 18:30
   * @Version 2.0.0
   * @param parm
   */
  void  updateCardPassword(Map<String,Object> parm);

  /**
   * @Description：根据手机号或会员卡号或会员卡序列号获取会员信息
   * @Author：chenkangyi
   * @Time: 2017-5-25 15:30
   * @Version 2.0.0
   * @param map
   */
  F_MemberCardInfoEntity selectMemberCardInfoBymemberCode(Map<String, Object> map);
    /**
     * @Description：根据会员ID,修改会员状态
     * @Author：HuTao
     * @Time: 2017-5-25 14:03
     * @Version 2.0.0
     * @param parm
     */
    void updateCardStatus(Map<String,Object> parm);

    List<Map<String,Object>> queryMemberRecharge(Map<String,Object> parm);

    Map<String,Object>  getRechargeRuleInfo(Map<String,Object> parm);

   /**
    * @author HuangCY
    * @version 1.0.0
    * @description 根据会员卡号或手机号查询会员信息
    * @time 2017-6-8 18:39
    */
    MemCardInfoDTO queryMemberCardByCondition(F_MemberCardInfoEntity MemberCardSetParams);
}
