package cc.toprank.byd.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 *   继承自自动生成的实体，具体业务方法使用的实体类
 *   如果具体业务需要扩展字段，请扩展该类
 * 
 * ********************************************************************************************************************/
public class O_OrderDetailInfoEntity  extends O_OrderDetailInfoEntityBase implements Cloneable{
	private String unitName;
	private String cetailStatus;
	private String categoryID;   // 菜分类ID
	private String PrinterIP;   //  打印ip
	private String areaName;    //  楼层	
	private String mealName;    //   餐次名称
	private String ttableName;  //  桌台名称
	private String loginName;   //  创建人
	private Integer peopleNum;   //   人数
	private Integer recordID;   //   套餐明细记录ID
	private Long carteMethod;   //   点菜方式

	private int comboCount;     //套菜
	
	private String tableName;  //  桌台名称
	private Long tableID;   //桌台ID
	private double realityPrice ;//成交价格
	private double totalAmounts;//总金额
	private double discountAmount;//折扣金额
	private double bookingAmount;//预定金额
	private LocalDateTime startTime;
	private int useMinute;//使用时间(分钟)
	private String orderCode;         //  订单编号
    private String aLaCarteMethodName;  //  点菜方式名称
	private BigDecimal addedAmount;
	private String optionName;	//规格名称
	private Long parentID; //上级ID
	private Long mappingReason;//关联原因
	private String mappingDesc; //关联原因
	private String designerName;

	public String getDesignerName() {
		return designerName;
	}

	public void setDesignerName(String designerName) {
		this.designerName = designerName;
	}

	public Long getParentID() {
		return parentID;
	}

	public void setParentID(Long parentID) {
		this.parentID = parentID;
	}

	public Long getMappingReason() {
		return mappingReason;
	}

	public void setMappingReason(Long mappingReason) {
		this.mappingReason = mappingReason;
	}

	public String getMappingDesc() {
		return mappingDesc;
	}

	public void setMappingDesc(String mappingDesc) {
		this.mappingDesc = mappingDesc;
	}

	public Long getTableID() {
		return tableID;
	}

	public void setTableID(Long tableID) {
		this.tableID = tableID;
	}

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public String getCetailStatus() {
		return cetailStatus;
	}
	public void setCetailStatus(String cetailStatus) {
		this.cetailStatus = cetailStatus;
	}
	public String getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}
	public String getPrinterIP() {
		return PrinterIP;
	}
	public void setPrinterIP(String printerIP) {
		PrinterIP = printerIP;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getMealName() {
		return mealName;
	}
	public void setMealName(String mealName) {
		this.mealName = mealName;
	}
	public String getTtableName() {
		return ttableName;
	}
	public void setTtableName(String ttableName) {
		this.ttableName = ttableName;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public int getComboCount() {
		return comboCount;
	}
	public void setComboCount(int comboCount) {
		this.comboCount = comboCount;
	}
    public double getRealityPrice() {
      return realityPrice;
    }
    public void setRealityPrice(double realityPrice) {
      this.realityPrice = realityPrice;
    }

    public double getDiscountAmount() {
      return discountAmount;
    }
    public void setDiscountAmount(double discountAmount) {
      this.discountAmount = discountAmount;
    }
    public double getBookingAmount() {
      return bookingAmount;
    }
    public void setBookingAmount(double bookingAmount) {
      this.bookingAmount = bookingAmount;
    }
    public double getTotalAmounts() {
      return totalAmounts;
    }
    public void setTotalAmounts(double totalAmounts) {
      this.totalAmounts = totalAmounts;
    }
    public String getTableName() {
      return tableName;
    }
    public LocalDateTime getStartTime() {
      return startTime;
    }
    public void setStartTime(LocalDateTime startTime) {
      this.startTime = startTime;
    }
    public void setTableName(String tableName) {
      this.tableName = tableName;
    }
    public int getUseMinute() {
      return useMinute;
    }
    public void setUseMinute(int useMinute) {
      this.useMinute = useMinute;
    }
    public Integer getPeopleNum() {
      return peopleNum;
    }
    public void setPeopleNum(Integer peopleNum) {
      this.peopleNum = peopleNum;
    }

    public Integer getRecordID() {
		return recordID;
	}
	public void setRecordID(Integer recordID) {
		this.recordID = recordID;
	}

	public BigDecimal getAddedAmount() {
		return addedAmount;
	}

	public void setAddedAmount(BigDecimal addedAmount) {
		this.addedAmount = addedAmount;
	}

	@Override
    public Object clone() {  
      O_OrderDetailInfoEntity stu = null;  
        try{  
            stu = (O_OrderDetailInfoEntity)super.clone();  
        }catch(CloneNotSupportedException e) {  
            e.printStackTrace();  
        }  
        return stu;  
    }  
    /**
     * 拷贝 金额和库存
     * @param resoure
     */
    public boolean copyForAmount(O_OrderDetailInfoEntity resoure){
    	if(this.getVariantID().longValue()==resoure.getVariantID().longValue()){
			Integer quantity = resoure.getQuantity()==null?0:resoure.getQuantity();
			double floatQuantity = resoure.getFloatQuantity()==null?0:resoure.getFloatQuantity();
			BigDecimal totalAmount = resoure.getTotalAmount()==null?new BigDecimal(0):resoure.getTotalAmount();
			Integer servedNum = resoure.getServedNum()==null?0:resoure.getServedNum();
			this.setQuantity(this.getQuantity()==null?0:this.getQuantity());
			this.setFloatQuantity(this.getFloatQuantity()==null?0:this.getFloatQuantity());
			this.setTotalAmount(this.getTotalAmount()==null?new BigDecimal(0):this.getTotalAmount());
			this.setServedNum(this.getServedNum()==null?0:this.getServedNum());
			this.setQuantity(this.getQuantity()+quantity);
			this.setFloatQuantity(this.getFloatQuantity()+Float.valueOf(String.valueOf(floatQuantity)));
			this.setTotalAmount(this.getTotalAmount().add(totalAmount));
			this.setServedNum(this.getServedNum()+servedNum);
			return true;
		}else{
			return false;
		}
    }

	public Long getCarteMethod() {
		return carteMethod;
	}

	public void setCarteMethod(Long carteMethod) {
		this.carteMethod = carteMethod;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getaLaCarteMethodName() {
		return aLaCarteMethodName;
	}

	public void setaLaCarteMethodName(String aLaCarteMethodName) {
		this.aLaCarteMethodName = aLaCarteMethodName;
	}
}