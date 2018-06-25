package cc.toprank.byd.web.service.menu;

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.dao.O_SubOrderInfoDao;
import cc.toprank.byd.entity.O_SubOrderInfoEntity;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**********************************************************************************************************************
 *
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   B_AttachmentInfoService 真实的业务实现类，允许修改
 *
 * ********************************************************************************************************************/
@Service("o_SubOrderInfoService")
public class O_SubOrderInfoService {

    @Autowired
    protected O_SubOrderInfoDao subOrderInfoDao;

    public O_SubOrderInfoEntity get(O_SubOrderInfoEntity subOrderInfo)  {
        return subOrderInfoDao.get(subOrderInfo);
    }

    public List<O_SubOrderInfoEntity> getAll() throws Exception {
        return subOrderInfoDao.getAll();
    }

    public void update(O_SubOrderInfoEntity subOrderInfo) throws Exception {
        subOrderInfoDao.update(subOrderInfo);
    }

    public void delete(O_SubOrderInfoEntity subOrderInfo) throws Exception {
        subOrderInfoDao.delete(subOrderInfo);
    }

    public void save(O_SubOrderInfoEntity subOrderInfo) throws Exception {
        subOrderInfoDao.save(subOrderInfo);
    }

    /**
     * @Description： 根据桌台编号,订单状态查询子订单信息
     * @Author：LanZY
     * @Time: 2017-4-7 13:16
     * @Version 2.0.0
     * @param subOrderInfoEntity
     * @return
     */
    public List<O_SubOrderInfoEntity> getSubOrderInfoByTableIDAndOrderStatus(O_SubOrderInfoEntity subOrderInfoEntity){
        return subOrderInfoDao.getSubOrderInfoByTableIDAndOrderStatus(subOrderInfoEntity);

    }


    /**
     * 修改订单总额和实际金额
     *
     * @param o_suborderinfo
     * @throws Exception
     * @author LanZY
     */
    public void updateSubOrderInfoEntityBySubOrderID(O_SubOrderInfoEntity o_suborderinfo) throws Exception {
        subOrderInfoDao.updateSubOrderInfoEntityBySubOrderID(o_suborderinfo);
    }


    /**
     * @Description： 根据桌台编号,餐次编号,订单状态,创建时间查询子订单
     * @Author：LanZY
     * @Time: 2017-4-6 11:00
     * @Version 2.0.0
     * @param subOrderInfoEntity
     * @return
     */
    public O_SubOrderInfoEntity getSubOrderInfoByCondition(O_SubOrderInfoEntity subOrderInfoEntity) {
        return subOrderInfoDao.getSubOrderInfoByCondition(subOrderInfoEntity);
    }



    /**
     * 插入一条新的子订单
     *
     * @return
     * @throws Exception
     * @author xuexin
     */
    public long saveSubOrderInfo(O_SubOrderInfoEntity subOrderInfo) throws Exception {
        return subOrderInfoDao.saveSubOrderInfo(subOrderInfo);

    }

    /**
     * 根据子订单编号查询子订单信息
     *
     * @param subOrderID
     * @return
     * @throws Exception
     * @author HuangCY
     */
    public O_SubOrderInfoEntity queryBySubOrderID(Long subOrderID) throws Exception {
        O_SubOrderInfoEntity entity = new O_SubOrderInfoEntity();
        entity.setSubOrderID(subOrderID);
        return subOrderInfoDao.get(entity);
    }



    public O_SubOrderInfoEntity getO_SubOrderInfoEntityById(Long subOrderID) throws Exception {
        if (subOrderID == null) throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        O_SubOrderInfoEntity entity = new O_SubOrderInfoEntity();
        entity.setSubOrderID(subOrderID);
        entity = subOrderInfoDao.get(entity);
        if (entity == null) {
            throw new BizException(CodeMsgConstants.SUBORDER_NOT_EXISTENCE, CodeMsgConstants.SUBORDER_NOT_EXISTENCE_MSG);
        }
        return entity;
    }

    /**
     * @Description： 根据桌台ID查询进行状态或未下单状态
     * @Author：LanZY
     * @Time: 2017-4-24 13:25
     * @Version 2.0.0
     * @param tableID
     * @return
     */
    public List<O_SubOrderInfoEntity> getSubOrderStatusInfoByTableID(Long tableID){
       return subOrderInfoDao.getSubOrderStatusInfoByTableID(tableID);
    }

 /**
     * @Description： 根据桌台ID查询进行状态或未下单状态
     * @Author：LanZY
     * @Time: 2017-4-24 13:25
     * @Version 2.0.0
     * @return
     */
    public List<O_SubOrderInfoEntity> getSubOrderInfoByOrderID(Long orderID){
       return subOrderInfoDao.getSubOrderInfoByOrderID(orderID);
    }

    /**
     * @Description：
     * @Author：Zhaolingchen
     * @Time: 2017-4-24 13:25
     * @Version 2.0.0
     * @return
     */
    public List<O_SubOrderInfoEntity> queryByOrderID(Long orderID){
       return subOrderInfoDao.queryByOrderID(orderID);
    }

    public 	O_SubOrderInfoEntity getById(Long subOrderID){
        return subOrderInfoDao.getById(subOrderID);
    }


}