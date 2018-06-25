

package cc.toprank.byd.common.entity;

import cc.toprank.byd.common.exception.CommonErrorCode;
import cc.toprank.byd.common.validator.InsertValidator;
import cc.toprank.byd.common.validator.UpdateValidator;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class SortEntity extends BaseEntity {

    /** Field description */
    @Min(
        value             = 0,
        message           = "#" + CommonErrorCode.SORT_VALID_MIN,
        groups            = { InsertValidator.class, UpdateValidator.class }
    )
    @Max(
        value             = 10000,
        message           = "#" + CommonErrorCode.SORT_VALID_MAX,
        groups            = { InsertValidator.class, UpdateValidator.class }
    )
    protected double sort = 0.0;

    /**
     * Method description
     *
     *
     * @return
     */
    public double getSort() {
        return sort;
    }

    /**
     * Method description
     *
     *
     * @param sort
     */
    public void setSort(double sort) {
        this.sort = sort;
    }
}



