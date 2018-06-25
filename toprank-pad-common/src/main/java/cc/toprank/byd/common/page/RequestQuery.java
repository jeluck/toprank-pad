
package cc.toprank.byd.common.page;

import java.io.Serializable;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class RequestQuery implements Serializable {

    /** Field description */
    private Integer draw = 0;

    /** Field description */
    private int start;

    /** Field description */
    private int length;

    /** Field description */
    private String orderType;

    /** Field description */
    private String orderColumn;

    /** Field description */
    private int orderColumnNum;

    /**
     * Method description
     *
     *
     * @return
     */
    public Integer getDraw() {
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
    public int getLength() {
        return length;
    }

    /**
     * Method description
     *
     *
     * @param length
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public String getOrderColumn() {
        return orderColumn;
    }

    /**
     * Method description
     *
     *
     * @param orderColumn
     */
    public void setOrderColumn(String orderColumn) {
        this.orderColumn = orderColumn;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public int getOrderColumnNum() {
        return orderColumnNum;
    }

    /**
     * Method description
     *
     *
     * @param orderColumnNum
     */
    public void setOrderColumnNum(int orderColumnNum) {
        this.orderColumnNum = orderColumnNum;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public String getOrderType() {
        return orderType;
    }

    /**
     * Method description
     *
     *
     * @param orderType
     */
    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public int getPage() {
        return (start / length) + 1;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public int getStart() {
        return start;
    }

    /**
     * Method description
     *
     *
     * @param start
     */
    public void setStart(int start) {
        this.start = start;
    }
}



