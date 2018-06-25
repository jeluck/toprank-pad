package cc.toprank.byd.web.util;

import cc.toprank.byd.common.utils.DateUtils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;

/**
 * Created by LanZY on 2017-4-11.
 */
public class OrderUtil {

    /**
     * 价格处理
     * @param number        数量
     * @param price         原价
     * @param produceCost   加工费
     * @param addedPrice    附加费
     * @return
     */
    public static BigDecimal calculatePrice(int number, BigDecimal price, BigDecimal produceCost, BigDecimal addedPrice) {
        BigDecimal totalPrice = price.multiply(new BigDecimal(number));
        if (null != produceCost) {
            totalPrice.add(produceCost.multiply(new BigDecimal(number)));
        }
        if (null != addedPrice) {
            totalPrice.add(addedPrice.multiply(new BigDecimal(number)));
        }
        return totalPrice;
    }


    /**
     * @return
     * @Description： 订单Code生成规则
     * @Author：LanZY
     * @Time: 2017-4-11 14:40
     * @Version 2.0.0
     */
    public static String getOrderCode() {
        Random ne = new Random();
        int x = ne.nextInt(9000) + 1000;//为变量赋随机值[1000-10000)
        return "B" + DateUtils.formaterDateToyyyyMMdd(LocalDate.now()) + x;
    }
}
