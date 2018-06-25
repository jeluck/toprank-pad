package cc.toprank.byd.pad.util;

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.config.BaseConfig;
import cc.toprank.byd.constant.PadConstants;
import cc.toprank.byd.pad.pojo.MerchantPadCacheVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by LiSH on 2017-2-16.
 */
public class MerchantCacheUtils {

    private static final String INIT_ERROR = "session don't init";
    private static Logger logger = LoggerFactory.getLogger(MerchantCacheUtils.class);
    private static ThreadLocal<Map<String, Object>> session = new ThreadLocal<>();

    private MerchantCacheUtils() {
    }

    public static Map<String, Object> getSession() {
        if (session.get() == null) {
            session.set(new HashMap<>());
        }
        return session.get();
    }

    /**
     * @description 获得当前餐厅ID
     * @author LiSH
     * @time 2017-3-1 9:50
     * @version 2.0.0
     */
    public static Long getCurrentArchiveID() {
        return getMerchantCache().getArchiveID();
    }

    /**
     * @description 获得当前orgID
     * @author LiSH
     * @time 2017-3-16 11:54
     * @version 2.0.0
     */
    public static Long getCurrentOrgID() {
        return getMerchantCache().getOrgID();
    }

    /**
     * @description 获得桌台负责人ID
     * @author LiSH
     * @time 2017-3-2 9:37
     * @version 2.0.0
     */
    public static Long getTableManagerID() {
        return getMerchantCache().getTableManagerID();
    }

    /**
     * @description 获得当前桌台ID
     * @author LiSH
     * @time 2017-3-2 9:37
     * @version 2.0.0
     */
    public static Long getCurrentTableID() {
        return getMerchantCache().getTableID();
    }

    /**
     * 获取当前桌台名称
     * @author LeeJun
     * @time 2017-4-5 11:54
     * @version 2.0.0
     */
    public static String getCurrentTableName(){
        return getMerchantCache().getTableName();
    }

    /**
     * @description 获得当前桌台ID
     * @author LiSH
     * @time 2017-3-2 9:37
     * @version 2.0.0
     */
    public static Long getCurrentAreaID() {
        return getMerchantCache().getAreaID();
    }

    /**
     * 获取缓存中商家的信息
     *
     * @author LeeJun
     * @time 2017-2-23 15:58
     * @version 2.0.0
     */
    public static MerchantPadCacheVO getMerchantCache() {
        MerchantPadCacheVO o = (MerchantPadCacheVO) getSession().get(PadConstants.MERCHANT_PAD_CACHE_KEY);
        if (o == null) {
            logger.warn(INIT_ERROR);
//            throw new BizException(INIT_ERROR);
        }
        return o;
    }

    public static String getImagePath() {
        return BaseConfig.getImagePath();
    }
}
