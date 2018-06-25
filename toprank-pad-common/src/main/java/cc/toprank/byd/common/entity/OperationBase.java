

package cc.toprank.byd.common.entity;

import cc.toprank.byd.common.enums.StatusEnum;
import cc.toprank.byd.common.exception.CommonErrorCode;

import javax.validation.constraints.NotNull;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class OperationBase extends BaseEntity {

    /** Field description */
    @NotNull(message = "#" + CommonErrorCode.BEAN_REQUIRED_IS_NULL)
    private StatusEnum status;

    /** Field description */
    @NotNull(message = "#" + CommonErrorCode.BEAN_REQUIRED_IS_NULL)
    private Boolean isDeleted;

    /**
     * Method description
     *
     *
     * @return
     */
    public Boolean getDeleted() {
        return isDeleted;
    }

    /**
     * Method description
     *
     *
     * @param deleted
     */
    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public StatusEnum getStatus() {
        return status;
    }

    /**
     * Method description
     *
     *
     * @param status
     */
    public void setStatus(StatusEnum status) {
        this.status = status;
    }
}



