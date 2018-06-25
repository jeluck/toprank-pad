package cc.toprank.byd.web.controller.base;

import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import cc.toprank.byd.base.BaseController;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import cc.toprank.byd.common.utils.qrcode.QrCodeUtil;
import cc.toprank.byd.common.utils.rsa.Base64;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
// @Controller
public class ToolsController extends BaseController {

    /**
     * Method description
     *
     *
     * @param url
     * @param size
     * @param response
     */
    @RequestMapping("/qrcode")
    public void qrcode(String url, String size, HttpServletResponse response) {
        OutputStream stream = null;

        try {
            String content = new String(Base64.decode(url));
            int    isize   = Integer.parseInt(size);

            if (isize > 1000) {
                isize = 1000;
            }

            byte[] data = QrCodeUtil.INSTANCE.setSize(isize).encode(content);

            response.setContentType("image/jpg");
            stream = response.getOutputStream();
            stream.write(data);
            stream.flush();
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        } finally {
            IOUtils.closeQuietly(stream);
        }
    }
}



