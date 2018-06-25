
package cc.toprank.byd.common.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Class description
 *
 *
 * @param <T>
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class ResponseQuery<T> implements Serializable {

    /** Field description */
    private Integer draw = 0;

    /** Field description */
    private Long recordsTotal = 0L;

    /** Field description */
    private Long recordsFiltered = 0L;

    /** Field description */
    private List<T> data = new ArrayList<T>();

    /** Field description */
    private String error;

    /**
     * Constructs ...
     *
     */
    public ResponseQuery() {}

    /**
     * Constructs ...
     *
     *
     * @param recordsTotal
     * @param data
     */
    public ResponseQuery(Long recordsTotal, List<T> data) {
        this.recordsTotal    = recordsTotal;
        this.recordsFiltered = recordsTotal;
        this.data            = data;
        this.error           = "";
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public List<T> getData() {
        return data;
    }

    /**
     * Method description
     *
     *
     * @param data
     */
    public void setData(List<T> data) {
        this.data = data;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public int getDraw() {
        return draw;
    }

    /**
     * Method description
     *
     *
     * @param draw
     */
    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public String getError() {
        return error;
    }

    /**
     * Method description
     *
     *
     * @param error
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public Long getRecordsFiltered() {
        return recordsFiltered;
    }

    /**
     * Method description
     *
     *
     * @param recordsFiltered
     */
    public void setRecordsFiltered(Long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public Long getRecordsTotal() {
        return recordsTotal;
    }

    /**
     * Method description
     *
     *
     * @param recordsTotal
     */
    public void setRecordsTotal(Long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }
}



