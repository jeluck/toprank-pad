package cc.toprank.byd.entity;

/*********************************************************************************************.
 * 
 * 
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 * 
 * <p></p>
 *********************************************************************************************/


public class ReceptionTableEntity extends Entity{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  private long areaID;              //区域id
  private long tableID;             //桌台号  
  private long archiveID;           //档案ID
  private int defaultPerson;        //坐台缺省坐多少人
  private String tableName;         //桌台名称
  private String tableCode;         //桌台编码
  private int tableStatus;          //桌台状态
  private int shareNumber;          //拼桌数量
  private int combineNumber;        //合台数量
  private String combineName;       //合台名称
  
  public long getArchiveID() {
    return archiveID;
  }
  public void setArchiveID(long archiveID) {
    this.archiveID = archiveID;
  }
  public long getAreaID() {
    return areaID;
  }
  public void setAreaID(long areaID) {
    this.areaID = areaID;
  }
  public long getTableID() {
    return tableID;
  }
  public void setTableID(long tableID) {
    this.tableID = tableID;
  }
  public int getDefaultPerson() {
    return defaultPerson;
  }
  public void setDefaultPerson(int defaultPerson) {
    this.defaultPerson = defaultPerson;
  }
  public String getTableName() {
    return tableName;
  }
  public void setTableName(String tableName) {
    this.tableName = tableName;
  }
  public String getTableCode() {
    return tableCode;
  }
  public void setTableCode(String tableCode) {
    this.tableCode = tableCode;
  }
  public int getTableStatus() {
    return tableStatus;
  }
  public void setTableStatus(int tableStatus) {
    this.tableStatus = tableStatus;
  }
  public int getShareNumber() {
    return shareNumber;
  }
  public void setShareNumber(int shareNumber) {
    this.shareNumber = shareNumber;
  }
  public int getCombineNumber() {
    return combineNumber;
  }
  public void setCombineNumber(int combineNumber) {
    this.combineNumber = combineNumber;
  }
  public String getCombineName() {
    return combineName;
  }
  public void setCombineName(String combineName) {
    this.combineName = combineName;
  }
}
