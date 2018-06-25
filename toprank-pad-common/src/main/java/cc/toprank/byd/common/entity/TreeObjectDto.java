package cc.toprank.byd.common.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class TreeObjectDto {

    /** Field description */
    private List<TreeObjectDto> children = new ArrayList<TreeObjectDto>();

    /** Field description */
    private Long id;

    /** Field description */
    private Integer type;

    /** Field description */
    private String sign;

    /** Field description */
    private String url;

    /** Field description */
    private String name;

    /** Field description */
    private String description;

    /** Field description */
    private Integer status;

    /** Field description */
    private String icon;

    /** Field description */
    private Long parentId;

    /** Field description */
    private Boolean isParent;

    /**
     * Method description
     *
     *
     * @return
     */
    public List<TreeObjectDto> getChildren() {
        return children;
    }

    /**
     * Method description
     *
     *
     * @param children
     */
    public void setChildren(List<TreeObjectDto> children) {
        this.children = children;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Method description
     *
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public String getIcon() {
        return icon;
    }

    /**
     * Method description
     *
     *
     * @param icon
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     * Method description
     *
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public Boolean getIsParent() {
        return isParent;
    }

    /**
     * Method description
     *
     *
     * @param parent
     */
    public void setIsParent(Boolean parent) {
        isParent = parent;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Method description
     *
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * Method description
     *
     *
     * @param parentId
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public String getSign() {
        return sign;
    }

    /**
     * Method description
     *
     *
     * @param sign
     */
    public void setSign(String sign) {
        this.sign = sign;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * Method description
     *
     *
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public Integer getType() {
        return type;
    }

    /**
     * Method description
     *
     *
     * @param type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public String getUrl() {
        return url;
    }

    /**
     * Method description
     *
     *
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }
}



