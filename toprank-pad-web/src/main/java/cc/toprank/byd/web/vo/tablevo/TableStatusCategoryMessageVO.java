package cc.toprank.byd.web.vo.tablevo;

/**
 * Created by HuTao on 2017-3-13.
 */
public class TableStatusCategoryMessageVO {
    private Long status;		//  桌台状态
    private int count;		//  该状态下的桌子数量

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
