package cc.toprank.byd.web.vo.menu;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LanZY on 2017-4-24.
 */
public class ComboVO {

    private List<ComboGroupVO> basicComboList = new ArrayList<>();          //基本套餐数据集合

    private List<ComboGroupVO> groupComboList = new ArrayList<>();          //分组套餐集合

    public List<ComboGroupVO> getBasicComboList() {
        return basicComboList;
    }

    public void setBasicComboList(List<ComboGroupVO> basicComboList) {
        this.basicComboList = basicComboList;
    }

    public List<ComboGroupVO> getGroupComboList() {
        return groupComboList;
    }

    public void setGroupComboList(List<ComboGroupVO> groupComboList) {
        this.groupComboList = groupComboList;
    }

    public static class ComboGroupVO {
        private Long groupID;       //分组ID
        private String groupName;   //分组名称
        private Long variantID;     //商品变体ID
        private String variantName; //商品名称
        private String unit;        //单位
        private BigDecimal price;   //价格
        private int quantity;         //数量
        private String optionName;  //规格名称
        private Integer allowQuantity; //可选数量
        private Float allowFloatQuantity; //可选小数
        private Long priceType;     //841总价 842明细合计
        private Long settingID;         //配置ID

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

        public Integer getAllowQuantity() {
            return allowQuantity;
        }

        public void setAllowQuantity(Integer allowQuantity) {
            this.allowQuantity = allowQuantity;
        }

        public Float getAllowFloatQuantity() {
            return allowFloatQuantity;
        }

        public void setAllowFloatQuantity(Float allowFloatQuantity) {
            this.allowFloatQuantity = allowFloatQuantity;
        }

        public Long getVariantID() {
            return variantID;
        }

        public void setVariantID(Long variantID) {
            this.variantID = variantID;
        }

        public String getVariantName() {
            return variantName;
        }

        public void setVariantName(String variantName) {
            this.variantName = variantName;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        public String getOptionName() {
            return optionName;
        }

        public void setOptionName(String optionName) {
            this.optionName = optionName;
        }

        private List<GroupProductVO> groupProductList = new ArrayList<>();

        public Long getGroupID() {
            return groupID;
        }

        public void setGroupID(Long groupID) {
            this.groupID = groupID;
        }

        public String getGroupName() {
            return groupName;
        }

        public void setGroupName(String groupName) {
            this.groupName = groupName;
        }
        public Long getPriceType() {
            return priceType;
        }

        public void setPriceType(Long priceType) {
            this.priceType = priceType;
        }

        public List<GroupProductVO> getGroupProductList() {
            return groupProductList;
        }

        public void setGroupProductList(List<GroupProductVO> groupProductList) {
            this.groupProductList = groupProductList;
        }

        public static class GroupProductVO {
            private Long mappingID;     //套餐分组商品关联ID
            private Long variantID;     //商品变体ID
            private String variantName; //商品名称
            private String unit;        //单位
            private int quantity;         //数量

            private BigDecimal price;   //价格

            public int getQuantity() {
                return quantity;
            }

            public void setQuantity(int quantity) {
                this.quantity = quantity;
            }

            public BigDecimal getPrice() {
                return price;
            }

            public void setPrice(BigDecimal price) {
                this.price = price;
            }

            public Long getMappingID() {
                return mappingID;
            }

            public void setMappingID(Long mappingID) {
                this.mappingID = mappingID;
            }

            public Long getVariantID() {
                return variantID;
            }

            public void setVariantID(Long variantID) {
                this.variantID = variantID;
            }

            public String getVariantName() {
                return variantName;
            }

            public void setVariantName(String variantName) {
                this.variantName = variantName;
            }

            public String getUnit() {
                return unit;
            }

            public void setUnit(String unit) {
                this.unit = unit;
            }
        }
    }
}
