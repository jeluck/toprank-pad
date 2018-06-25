package cc.toprank.byd.web.vo.order;

import java.util.List;

/**
 * Created by L on 2017/8/14.
 */
public class OrderMsgVO {
    List<String> name1;

    List<String> name2;

    List<OrderQuVO> list3;

    public List<String> getName1() {
        return name1;
    }

    public void setName1(List<String> name1) {
        this.name1 = name1;
    }

    public List<String> getName2() {
        return name2;
    }

    public void setName2(List<String> name2) {
        this.name2 = name2;
    }

    public List<OrderQuVO> getList3() {
        return list3;
    }

    public void setList3(List<OrderQuVO> list3) {
        this.list3 = list3;
    }
}
