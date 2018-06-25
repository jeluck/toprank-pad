package cc.toprank.byd.dao;

import cc.toprank.byd.entity.F_FundChangeInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 资金变动信息
 * Created by HuangCY on 2017-4-10.
 */
public interface F_FundChangeInfoDao {


    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 根据业务类型、账户编号和业务编号查询资金变动信息
     * @time 2017-4-10 16:36
     */
     F_FundChangeInfoEntity queryByBusinessIDAndBusinessType(F_FundChangeInfoEntity entity);

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 更新资金变动信息的变动金额
     * @time 2017-4-11 10:39
     */
    void updateFundChangeAmount(F_FundChangeInfoEntity entity);

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 新增资金变动信息
     * @time 2017-4-11 11:28
     */
    void save(F_FundChangeInfoEntity fundchangeinfo) throws Exception;

    /**
     * @Description：
     * @Author：HuTao
     * @Time: 2017-5-22 10:12
     * @Version 2.0.0
     * @param parm
     * @return
     */

    List<Map<String, Object>> getAllCount(Map<String,Object> parm);

    /**
     * @Description：根据收银员ID,获取当前收银员，
     * @Author：HuTao
     * @Time: 2017-5-22 13:41
     * @Version 2.0.0
     * @param parm
     * @return
     */
   List<Map<String,Object>> getDiscountAmount(Map<String,Object> parm);

    /**
     * @Description：根据收银员ID,获取当前收银员的汇总平均数
     * @Author：HuTao
     * @Time: 2017-5-22 16:30
     * @Version 2.0.0
     * @param parm
     * @return
     */
    Map<String,Object> getAllCountAverage(Map<String,Object> parm);   //    汇总平均数

    /**
     * @Description： 根据收银员ID, 获取会员充值汇总
     * @Author：HuTao
     * @Time: 2017-5-23 10:22
     * @Version 2.0.0
     * @param parm
     * @return
     */
    List<Map<String,Object>> getMemberCount(Map<String,Object> parm);  //   会员充值

    /**
     * @Description： 根据收银员ID, 获取预订订金的汇总
     * @Author：HuTao
     * @Time: 2017-5-23 10:22
     * @Version 2.0.0
     * @param parm
     * @return
     */
    List<Map<String,Object>>  getBookningCount(Map<String,Object> parm);

    /**
     * @Description：根据收银员ID, 获取取消预订订金的汇总
     * @Author：HuTao
     * @Time: 2017-5-23 10:30
     * @Version 2.0.0
     * @param parm
     * @return
     */
    List<Map<String,Object>>  getCancelCount(Map<String,Object> parm);

    /**
     * @Description：根据收银员ID, 还款数据的汇总
     * @Author：HuTao
     * @Time: 2017-5-23 10:41
     * @Version 2.0.0
     * @param parm
     * @return
     */
    List<Map<String,Object>>   getRepaymentCount(Map<String,Object> parm);

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 新增资金变动信息
     * @time 2017-6-18 17:33
     */
    void saveFundChangeInfo(F_FundChangeInfoEntity fundchangeinfo);
}
