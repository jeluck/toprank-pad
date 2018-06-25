package cc.toprank.byd.service;

import cc.toprank.byd.dao.P_DesignerInfoDao;
import cc.toprank.byd.pad.util.ImgPathUtils;
import cc.toprank.byd.vo.DesignerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 厨师相关service
 *
 * @author LeeJun
 * @create 2017-05-23 13:19
 */
@Service
public class DesignerService {

    @Autowired
    private P_DesignerInfoDao designerInfoDao;

    public List<DesignerVO> getProductDesigner(Long archiveID, Long productID, Long variantID) throws NoSuchMethodException {
        List<DesignerVO> designerList = designerInfoDao.getDesignerByParam(archiveID, productID, variantID);
        if (!designerList.isEmpty()) {
            ImgPathUtils.addImgHead2Object(designerList, "picture");
        }
        return designerList;
    }

    /**
     * 是否可选厨师
     *
     * @author LeeJun
     * @time 2017-5-31 10:56
     * @version 2.0.0
     */
    public boolean isOptionalDesigner(Long archiveID, Long productID, Long variantID) {
        List<DesignerVO> designerList = designerInfoDao.getDesignerByParam(archiveID, productID, variantID);
        if (designerList.isEmpty()) {
            return false;
        }
        return true;
    }
}
