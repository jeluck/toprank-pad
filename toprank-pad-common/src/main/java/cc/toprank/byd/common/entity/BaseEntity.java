package cc.toprank.byd.common.entity;

import cc.toprank.byd.common.utils.json.JSONUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class BaseEntity implements Serializable {

    /** Field description */
    private static final long serialVersionUID = 1L;

    /** Field description */
    protected Long id;

    /** Field description */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    protected LocalDateTime createTime;

    /** Field description */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    protected LocalDateTime updateTime;

    /** Field description */
    protected Long createrId;

    /** Field description */
    protected String createrName;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        BaseEntity other = (BaseEntity) obj;

        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        final int prime  = 31;
        int       result = 1;

        result = prime * result + ((id == null)
                                   ? 0
                                   : id.hashCode());

        return result;
    }

    @Override
    public String toString() {
        return JSONUtils.toJson(this);
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * Method description
     *
     *
     * @param createTime
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public Long getCreaterId() {
        return createrId;
    }

    /**
     * Method description
     *
     *
     * @param createrId
     */
    public void setCreaterId(Long createrId) {
        this.createrId = createrId;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public String getCreaterName() {
        return createrName;
    }

    /**
     * Method description
     *
     *
     * @param createrName
     */
    public void setCreaterName(String createrName) {
        this.createrName = createrName;
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
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    /**
     * Method description
     *
     *
     * @param updateTime
     */
    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}



