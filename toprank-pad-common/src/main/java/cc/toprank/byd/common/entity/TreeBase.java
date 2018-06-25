package cc.toprank.byd.common.entity;

import cc.toprank.byd.common.exception.CommonErrorCode;
import cc.toprank.byd.common.validator.InsertValidator;
import cc.toprank.byd.common.validator.UpdateValidator;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class TreeBase extends BaseEntity {

    /** Field description */
    private static final long serialVersionUID = 1L;

    /** Field description */
    @NotNull(message = "#" + CommonErrorCode.IS_NULL)
    @Min(
        value              = 0,
        message            = "#" + CommonErrorCode.SORT_VALID_MIN,
        groups             = { InsertValidator.class, UpdateValidator.class }
    )
    @Max(
        value              = 10000,
        message            = "#" + CommonErrorCode.SORT_VALID_MAX,
        groups             = { InsertValidator.class, UpdateValidator.class }
    )
    protected Integer sort = 1;

    /** Field description */
    protected List<TreeBase> childs;

    /** Field description */
    @NotNull(
        message = "#" + CommonErrorCode.IS_NULL,
        groups  = InsertValidator.class
    )
    protected Long parentId;

    /**
     * Method description
     *
     *
     * @return
     */
    public List<TreeBase> getChilds() {
        return childs;
    }

    /**
     * Method description
     *
     *
     * @param childs
     */
    public void setChilds(List<TreeBase> childs) {
        this.childs = childs;
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
    public Integer getSort() {
        return sort;
    }

    /**
     * Method description
     *
     *
     * @param sort
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }
}



