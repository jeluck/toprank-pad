package cc.toprank.byd.pad.service;

import cc.toprank.byd.dao.B_AttachmentMappingDao;
import cc.toprank.byd.dao.B_DinningTableInfoDao;
import cc.toprank.byd.entity.*;
import cc.toprank.byd.enums.AttachmentManageEnum;
import cc.toprank.byd.enums.MerchantManageEnum;
import cc.toprank.byd.pad.util.MerchantCacheUtils;
import cc.toprank.byd.service.SystemMaxIDService;
import cc.toprank.byd.util.MaxIDUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 附件service
 *
 * @author LeeJun
 * @version 2.0.0
 * @time 2017-2-20 17:10
 */
@Service
public class AttachmentService {

    private static final int IMG_PAGE_SIZE = 10;

    @Autowired
    private B_AttachmentMappingDao attachmentMappingDAO;
    @Autowired
    private B_DinningTableInfoDao dinningTableInfoMapper;

    @Transactional
    public List test(String tableName) {
        List list = new ArrayList();
        for (int i = 0; i < 3; i++) {
            list.add(MaxIDUtils.getID(tableName));
        }
        int i = 1 / 0;
        return list;
    }

    /**
     * 获取首页banner图列表
     *
     * @author LeeJun
     * @time 2017-2-20 17:10
     * @version 2.0.0
     */
    public List<String> getHomeBanner() throws Exception {
        List<String> bannerPath = new ArrayList<String>();
        List<B_AttachmentMappingEntity> attachments = attachmentMappingDAO
                .getAttachmentByType(AttachmentManageEnum.MerchanAattachmentManage.PAD_BANNER.getValue());
        for (int i = 0; i < attachments.size(); i++) {
            bannerPath.add(MerchantCacheUtils.getImagePath() + attachments.get(i).getFilePath());
        }
        return bannerPath;
    }

    /**
     * 获取广告轮播图
     *
     * @return
     * @throws Exception
     * @author LeeJun 2017年1月21日下午3:56:51
     */
    public Map<String, Object> getAdvertSlideshow() throws Exception {
        B_DinningTableInfoEntity tableInfo = dinningTableInfoMapper.selectByPrimaryKey(MerchantCacheUtils.getCurrentTableID());
        Map<String, Object> map = new HashMap<>();
        if (tableInfo != null) {
            map.put("tableID", tableInfo.getTableID());
            map.put("tableName", tableInfo.getTableName());
            long status = tableInfo.getTableStatus();
            // 开台改成服务中
            if(status == MerchantManageEnum.TableStatus.PLACEORDER.getValue() ){
                status = MerchantManageEnum.TableStatus.PLACEMAN.getValue();
            }
            String statusName = null;
            MerchantManageEnum.TableStatus[] tableStatus = MerchantManageEnum.TableStatus.values();
            for (MerchantManageEnum.TableStatus s : tableStatus) {
                if (s.getValue() == status) {
                    statusName = s.getName();
                }
            }
            map.put("tableStatus", status);
            map.put("statusName", statusName);
        }
        map.put("bgText", "欢迎光临不用等高级餐厅");
        map.put("copyright", "Copyright www.buyongdeng.com All.Rights Reserved 2016-2017");

        PageHelper.startPage(1, IMG_PAGE_SIZE);
        List<String> bannerPath = new ArrayList<String>();
        List<B_AttachmentMappingEntity> attachments = attachmentMappingDAO
                .getAttachmentByType(AttachmentManageEnum.MerchanAattachmentManage.PAD_ADVERT.getValue());
        for (int i = 0; i < attachments.size(); i++) {
            bannerPath.add(MerchantCacheUtils.getImagePath() + attachments.get(i).getFilePath());
        }
        map.put("bannerPath", bannerPath);
        return map;
    }

}
