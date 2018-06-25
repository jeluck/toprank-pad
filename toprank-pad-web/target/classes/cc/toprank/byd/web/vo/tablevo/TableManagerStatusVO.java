package cc.toprank.byd.web.vo.tablevo;

import java.util.List;

/**
 * Created by LiuXJ on 2017-6-12.
 */
public class TableManagerStatusVO {

    private Long tablesNumOfArea; //区域下全部的桌台数量
    private Long tablesNumOfNoManager; //无桌台负责人的桌台数量

    private List<TableManagerVO> tableManagerVOList;

    public Long getTablesNumOfArea() {
        return tablesNumOfArea;
    }

    public void setTablesNumOfArea(Long tablesNumOfArea) {
        this.tablesNumOfArea = tablesNumOfArea;
    }

    public Long getTablesNumOfNoManager() {
        return tablesNumOfNoManager;
    }

    public void setTablesNumOfNoManager(Long tablesNumOfNoManager) {
        this.tablesNumOfNoManager = tablesNumOfNoManager;
    }

    public List<TableManagerVO> getTableManagerVOList() {
        return tableManagerVOList;
    }

    public void setTableManagerVOList(List<TableManagerVO> tableManagerVOList) {
        this.tableManagerVOList = tableManagerVOList;
    }
}
