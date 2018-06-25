package cc.toprank.byd.web.vo.menu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LanZY on 2017-3-13.
 */
public class OrderDetailVO {
    private Long menuID;                    //菜单ID
    private Long produceStatus;             //制作状态：692.未制作 693.制作中 694.等叫 698 超时 830 未称重 981 已出品 982 已上菜 984待称重 985 已称重 986 待确认
    private Long aLaCarteMethod;            //点菜方式：684.正常点菜 685.退菜 686.赠菜 697.加菜,996.加菜 997.换菜 998.转赠
    private int quantity;                   //数量
    private int productType;                //类型 3.拼菜 4.临时改价
    private Long designerID;                //厨师ID
    private Long optionID;                  //选项规格ID
    private String valueIDs;                //做法ID或口味ID 以逗号分隔形式存储
    private double price;                   //一口价或改价
    private float expectedWeight;           //期望重量
    private String memo;                    //备注
    private String tagIDs;                  //标签  免做,先做,打包,催菜
    private Long tableID;                   //桌台ID
    private String tableName;                   //桌台ID

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Long getTableID() {
        return tableID;
    }

    public void setTableID(Long tableID) {
        this.tableID = tableID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
    public float getExpectedWeight() {
        return expectedWeight;
    }

    public void setExpectedWeight(float expectedWeight) {
        this.expectedWeight = expectedWeight;
    }

    private List<OrderComboVO> comboList = new ArrayList<>();   //套餐明细或拼菜明细

    public Long getMenuID() {
        return menuID;
    }

    public void setMenuID(Long menuID) {
        this.menuID = menuID;
    }

    public Long getProduceStatus() {
        return produceStatus;
    }

    public void setProduceStatus(Long produceStatus) {
        this.produceStatus = produceStatus;
    }

    public Long getaLaCarteMethod() {
        return aLaCarteMethod;
    }

    public void setaLaCarteMethod(Long aLaCarteMethod) {
        this.aLaCarteMethod = aLaCarteMethod;
    }

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }

    public Long getDesignerID() {
        return designerID;
    }

    public void setDesignerID(Long designerID) {
        this.designerID = designerID;
    }

    public Long getOptionID() {
        return optionID;
    }

    public void setOptionID(Long optionID) {
        this.optionID = optionID;
    }

    public String getValueIDs() {
        return valueIDs;
    }

    public void setValueIDs(String valueIDs) {
        this.valueIDs = valueIDs;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<OrderComboVO> getComboList() {
        return comboList;
    }

    public void setComboList(List<OrderComboVO> comboList) {
        this.comboList = comboList;
    }
    public String getTagIDs() {
        return tagIDs;
    }

    public void setTagIDs(String tagIDs) {
        this.tagIDs = tagIDs;
    }

    public static class OrderComboVO {
        private Long mappingID;                 //套餐分组商品关联ID
        private Long produceStatus;             //制作状态（等叫,制作中.....）
        private Long aLaCarteMethod;            //点菜方式 （正常点菜,加菜,退菜,赠菜.........）
        private int quantity;                     //数量
        private String valueIDs;                //做法ID或口味ID 以逗号分隔形式存储
        private String memo;                    //备注
        private Long variantID;                 //商品变体ID
        private String tagIDs;                  //标签  免做,先做,打包,催菜
        private Long settingID;                 //套餐明细配置ID

        public Long getSettingID() {
            return settingID;
        }

        public void setSettingID(Long settingID) {
            this.settingID = settingID;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
        public String getTagIDs() {
            return tagIDs;
        }

        public void setTagIDs(String tagIDs) {
            this.tagIDs = tagIDs;
        }

        public Long getVariantID() {
            return variantID;
        }

        public void setVariantID(Long variantID) {
            this.variantID = variantID;
        }

        public String getValueIDs() {
            return valueIDs;
        }

        public void setValueIDs(String valueIDs) {
            this.valueIDs = valueIDs;
        }

        public String getMemo() {
            return memo;
        }

        public void setMemo(String memo) {
            this.memo = memo;
        }


        public Long getMappingID() {
            return mappingID;
        }

        public void setMappingID(Long mappingID) {
            this.mappingID = mappingID;
        }

        public Long getProduceStatus() {
            return produceStatus;
        }

        public void setProduceStatus(Long produceStatus) {
            this.produceStatus = produceStatus;
        }

        public Long getaLaCarteMethod() {
            return aLaCarteMethod;
        }

        public void setaLaCarteMethod(Long aLaCarteMethod) {
            this.aLaCarteMethod = aLaCarteMethod;
        }


    }

}
