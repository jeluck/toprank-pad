package cc.toprank.byd.web.service.menu;

import cc.toprank.byd.dao.O_ComboDetailInfoDao;
import cc.toprank.byd.entity.O_ComboDetailInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

/**********************************************************************************************************************
 * 
 * 版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司 B_AttachmentInfoService 真实的业务实现类，允许修改
 * 
 ********************************************************************************************************************/
@Service("o_ComboDetailInfoService")
public class O_ComboDetailInfoService  {

  @Autowired
  private P_ProductVariantInfoService productVariantInfoService;

  @Autowired
  private O_ComboDetailInfoDao comboDetailInfoDao;


  public O_ComboDetailInfoEntity get(O_ComboDetailInfoEntity comboDetailInfo) throws Exception{
    return comboDetailInfoDao.get(comboDetailInfo);
  }
  public List<O_ComboDetailInfoEntity> getAll() throws Exception{
    return comboDetailInfoDao.getAll();
  }

  public void update(O_ComboDetailInfoEntity comboDetailInfo) throws Exception{
    comboDetailInfoDao.update(comboDetailInfo);
  }

  public void delete(O_ComboDetailInfoEntity comboDetailInfo) throws Exception{
    comboDetailInfoDao.delete(comboDetailInfo);
  }

  public void save(O_ComboDetailInfoEntity comboDetailInfo) throws Exception{
    comboDetailInfoDao.save(comboDetailInfo);
  }


  /**
   * 根据套餐订单明细编号修改套餐明细数量
   * 
   * @author LanZY
   */
  public void updateComboDetailInfoByDetailID(O_ComboDetailInfoEntity comboDetailInfo)
      throws Exception {
    comboDetailInfoDao.updateComboDetailInfoByDetailID(comboDetailInfo);
  }

  /**
   * 根据明细编号修改状态 （等叫 叫起）
   * 
   * @param status
   * @param loginID
   * @throws Exception
   */
  @Transactional(rollbackFor = SQLException.class)
  public void suspendOrStart(Long RecordID, Long status, Long loginID) throws Exception {
//    String content = "";
//    O_ComboDetailInfoEntity comboDetailInfo = new O_ComboDetailInfoEntity();
//    comboDetailInfo.setRecordID(RecordID);
//    comboDetailInfo = comboDetailInfoDao.get(comboDetailInfo);
//
//    // 查询制作时间
//    P_ProductVariantInfoEntity productvariantInfo = productVariantInfoService.getP_ProductVariantInfoEntityById(comboDetailInfo.getVariantID());
//    if (status == 1) {
//      // 表示把制作状态改为等叫
//      comboDetailInfo.setProduceStatus(OrderManagerEnum.ProductionStatus.SOCALLED.getValue());
//      comboDetailInfo.setProduceTime(null);
//      content = "等叫";
//    } else {
//      // 表示把制作状态改为制作中
//      comboDetailInfo.setProduceStatus(OrderManagerEnum.ProductionStatus.INPRODUCTION.getValue());
//      Calendar lastDate = Calendar.getInstance();
//      lastDate.setTime(new Date());
//      lastDate.add(Calendar.MINUTE, productvariantInfo.getProduceMinute());
//      comboDetailInfo.setProduceTime(lastDate.getTime());
//      content = "叫起";
//    }
//
//    O_MessageInfoEntity messageInfo = new O_MessageInfoEntity();
//    messageInfo.setIsSync(0);
//    // 订单处理阶段通知
//    messageInfo.setBusinessType(674l);
//    // 业务编号
//    messageInfo.setBusinessID(RecordID);
//    // 业务状态
//    messageInfo.setBusinessStatus(676l);
//    messageInfo.setRecipientID(loginID);
//    messageInfo.setRecipientType(44l);
//    messageInfo.setSMSContent(comboDetailInfo.getProductName() + "被" + content + "了!");
//    messageInfoService.save(messageInfo);
//
//    comboDetailInfoDao.update(comboDetailInfo);
  }

  /**
   * 根据明细ID删除套餐信息
   * @param detailID
   * @throws Exception
   * @author HuangCY
   */
  public void deleteByDetailID (long detailID) throws Exception {
    O_ComboDetailInfoEntity comboDetailInfoEntity = new O_ComboDetailInfoEntity();
    comboDetailInfoEntity.setDetailID(detailID);
    comboDetailInfoDao.deleteByDetailID(comboDetailInfoEntity);
  }
  
  /**
   * @author HuangCY
   * @version 1.0.0
   * @description 根据明细ID和制作状态查询套餐明细
   */
  public List<O_ComboDetailInfoEntity> getComboDetailByDetailID(Long detailID) throws Exception{
    return comboDetailInfoDao.getComboDetailByDetailID(detailID);
  }

  /**
   * @author HuangCY
   * @version 1.0.0
   * @description 根据记录ID和制作状态查询套餐明细
   * @time 2017-5-24 18:38
   */
  public O_ComboDetailInfoEntity getComboDetailByRecordIDAndStatus(Long recordID , Long produceStatus) throws Exception{
    O_ComboDetailInfoEntity entity = new O_ComboDetailInfoEntity();

    entity.setRecordID(recordID);
    entity.setProduceStatus(produceStatus);

    return comboDetailInfoDao.getComboDetailByRecordIDAndStatus(entity);
  }
}