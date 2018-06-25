package cc.toprank.byd.web.vo;

import java.time.LocalDateTime;
import java.util.Date;

/*********************************************************************************************.
 * 
 * 
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 * 
 * <p></p>
 *********************************************************************************************/

/**
 *
 * @author XuJin
 *   获取预订桌台的参数VO
 */

public class TableBookVO {
   private Long archiveID;//商家档案id
   private Long areaID;//区域id
   private LocalDateTime bookTime;//预订时间
   private Boolean isMeal;//是否是当前餐次
   private Integer duration;//就餐时常

  public Long getArchiveID() {
    return archiveID;
  }

  public void setArchiveID(Long archiveID) {
    this.archiveID = archiveID;
  }

  public Long getAreaID() {
    return areaID;
  }

  public void setAreaID(Long areaID) {
    this.areaID = areaID;
  }

  public LocalDateTime getBookTime() {
    return bookTime;
  }

  public void setBookTime(LocalDateTime bookTime) {
    this.bookTime = bookTime;
  }

  public Boolean getMeal() {
    return isMeal;
  }

  public void setMeal(Boolean meal) {
    isMeal = meal;
  }

  public Integer getDuration() {
    return duration;
  }

  public void setDuration(Integer duration) {
    this.duration = duration;
  }
}
