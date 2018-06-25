package cc.toprank.byd.util;

import cc.toprank.byd.common.utils.ObjectUtil;
import cc.toprank.byd.config.BaseConfig;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 调用支付网关接口
 * Created by HuangCY on 2017-5-18.
 */
public class OkHttpClientUtils {

    private static final Charset UTF8 = Charset.forName("UTF-8");

    private static final String PAY_URL = "pay.url";

    private static final String PAY_TIMEOUT = "pay.timeout";

    private static final Logger LOGGER = LoggerFactory.getLogger(OkHttpClientUtils.class);

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 请求支付网关
     * @time 2017-5-18 16:42
     */
    public static JSONObject payRequest(Map map) throws Exception{
        OkHttpClient client = new OkHttpClient().newBuilder()
                .readTimeout(ObjectUtil.objectToLong(BaseConfig.get(PAY_TIMEOUT), 180L), TimeUnit.SECONDS).build();
        HttpUrl getUrl = HttpUrl.parse(BaseConfig.getString(PAY_URL)).newBuilder().build();

        LOGGER.debug("调用支付接口");

        //将Map转成Json字符串
        String json = JSON.toJSONString(map,true);

        RequestBody postBody = new FormBody.Builder().add("clientPay",json).build();

        Request request = new Request.Builder().post(postBody).url(getUrl).build();

        Response response = null;

        JSONObject payObj = null;
        try {
            response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                payObj = JSON.parseObject(response.body().byteStream(), UTF8, JSONObject.class);
                LOGGER.info("调用支付接口输出：" + payObj);
            }else {
                LOGGER.error(response.message());
            }
        } catch (IOException e) {
            LOGGER.error("支付请求失败", e);
        } finally {
            if (response != null) {
                try {
                    response.body().close();
                } catch (final Throwable th) {
                    System.out.println(th.getMessage());
                }
            }
            return payObj;
        }
    }
}
