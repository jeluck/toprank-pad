
package cc.toprank.byd.common.entity;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class CategoryTreeDto {

    /** Field description */
    private Long id;

    /** Field description */
    private Long parentId;

    /** Field description */
    private String name;

    /** Field description */
    private Integer level;

    /** Field description */
    private Integer type;

    /** Field description */
    private Boolean isParent;

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
    public Integer getLevel() {
        return level;
    }

    /**
     * Method description
     *
     *
     * @param level
     */
    public void setLevel(Integer level) {
        this.level = level;
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
}



