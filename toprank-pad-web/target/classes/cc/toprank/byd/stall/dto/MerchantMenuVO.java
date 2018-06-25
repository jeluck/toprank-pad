package cc.toprank.byd.stall.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mangofactory.swagger.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.List;

/**
 * 调整价格参数VO类
 * @author ZhaoLC
 * @Time 2017-3-10 16:00
 */
public class MerchantMenuVO {
    /**
     * 登录ID
     */
    private Long loginId;

    @JsonProperty
    private List<MerchantMenu> merchantMenuList = new ArrayList<MerchantMenu>();

    public List<MerchantMenu> getMerchantMenuList() {
        return merchantMenuList;
    }

    public void setMerchantMenuList(List<MerchantMenu> merchantMenuList) {
        this.merchantMenuList = merchantMenuList;
    }

    public static class MerchantMenu{
        /**
         * 菜单ID
         */
        private Long menuID;
        /**
         * 调整金额
         */
        private Double price;

        public Long getMenuID() {
            return menuID;
        }

        public void setMenuID(Long menuID) {
            this.menuID = menuID;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }
    }

    public Long getLoginId() {
        return loginId;
    }

    public void setLoginId(Long loginId) {
        this.loginId = loginId;
    }
}
