package cc.toprank.byd.web.vo.tablevo;

/**
 * Created by LanZY on 2017-5-22.
 */
public class TableHandleVO {
    private Long archiveID;
    private String combineName;
    private Integer combineNumber;
    private Long loginID;
    private Long orderID;
    private boolean isCombine;
    private Long mealsID;

    public Long getMealsID() {
        return mealsID;
    }

    public void setMealsID(Long mealsID) {
        this.mealsID = mealsID;
    }

    public boolean isCombine() {
        return isCombine;
    }

    public void setCombine(boolean combine) {
        isCombine = combine;
    }

    public Long getArchiveID() {
        return archiveID;
    }

    public void setArchiveID(Long archiveID) {
        this.archiveID = archiveID;
    }

    public String getCombineName() {
        return combineName;
    }

    public void setCombineName(String combineName) {
        this.combineName = combineName;
    }

    public Integer getCombineNumber() {
        return combineNumber;
    }

    public void setCombineNumber(Integer combineNumber) {
        this.combineNumber = combineNumber;
    }

    public Long getLoginID() {
        return loginID;
    }

    public void setLoginID(Long loginID) {
        this.loginID = loginID;
    }

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }
}
