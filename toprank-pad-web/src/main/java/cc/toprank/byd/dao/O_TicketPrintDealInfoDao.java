package cc.toprank.byd.dao;


import cc.toprank.byd.entity.O_TicketPrintDealInfoEntity;

import java.util.List;
import java.util.Map;

/**********************************************************************************************************************
 *
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 *   O_TicketPrintDealInfoEntity数据访问类
 *
 * ********************************************************************************************************************/
public interface O_TicketPrintDealInfoDao {

    List<O_TicketPrintDealInfoEntity> getAll();

    void update(O_TicketPrintDealInfoEntity ticketPrintDealInfo);

    void delete(O_TicketPrintDealInfoEntity ticketPrintDealInfo);

    void save(O_TicketPrintDealInfoEntity ticketPrintDealInfo);

    O_TicketPrintDealInfoEntity get(O_TicketPrintDealInfoEntity ticketPrintDealInfo);

    List<Map<String, Object>> getPrintHistoryByRecord(Long recordID);
}