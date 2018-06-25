package cc.toprank.byd.web.service.payment;

import cc.toprank.byd.dao.F_InvoiceInfoDao;
import cc.toprank.byd.dao.F_InvoiceSubOrderMappingDao;
import cc.toprank.byd.entity.F_InvoiceInfoEntity;
import cc.toprank.byd.entity.F_InvoiceSubOrderMappingEntity;
import cc.toprank.byd.enums.SystemManageEnum;
import cc.toprank.byd.web.vo.paymentvo.InvoiceInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 发票信息
 * Created by HuangCY on 2017-5-26.
 */
@Service("invoiceInfoService")
public class InvoiceInfoService {

    //发票信息
    @Autowired
    private F_InvoiceInfoDao f_InvoiceInfoDao;
    //新增发票子订单关联信息
    @Autowired
    private F_InvoiceSubOrderMappingDao f_InvoiceSubOrderMappingDao;

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 开发票
     * @time 2017-5-26 18:08
     */
    @Transactional
    public void openInvoice (InvoiceInfoVO invoiceInfoVO , List<Long> subOrderIDList , Long loginID) throws Exception{
        F_InvoiceInfoEntity invoiceInfoEntity = new F_InvoiceInfoEntity();

        invoiceInfoEntity.setInvoiceCode(invoiceInfoVO.getInvoiceCode());
        invoiceInfoEntity.setDepartName(invoiceInfoVO.getDepartName());
        invoiceInfoEntity.setMemo(invoiceInfoVO.getMemo());
        invoiceInfoEntity.setOderAmount(BigDecimal.valueOf(invoiceInfoVO.getInvoiceAmount()));
        invoiceInfoEntity.setCreatorID(loginID);
        invoiceInfoEntity.setCreateTime(LocalDateTime.now());

        f_InvoiceInfoDao.save(invoiceInfoEntity);

        //发票编号
        Long invoiceID = invoiceInfoEntity.getInvoiceID();

        for (int i = 0 ; i < subOrderIDList.size() ; i++) {
            F_InvoiceSubOrderMappingEntity invoiceSubOrderMappingEntity = new F_InvoiceSubOrderMappingEntity();

            invoiceSubOrderMappingEntity.setInvoiceID(invoiceID);
            invoiceSubOrderMappingEntity.setSubOrderID(subOrderIDList.get(i));
            invoiceSubOrderMappingEntity.setMappingStatus(SystemManageEnum.EntityStatus.NORMAL.getValue());
            invoiceSubOrderMappingEntity.setCreatorID(loginID);
            invoiceSubOrderMappingEntity.setCreateTime(LocalDateTime.now());

            //新增发票子订单关联信息
            f_InvoiceSubOrderMappingDao.save(invoiceSubOrderMappingEntity);
        }
    }

}
