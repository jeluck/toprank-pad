package cc.toprank.byd.common.utils;

import org.apache.commons.collections.*;

import java.math.BigDecimal;
import java.util.*;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class SortUtil {

    /**
     * Method description
     *
     *
     * @param orderNo
     *
     * @return
     */
    public static double format(double orderNo) {
        BigDecimal big = BigDecimal.valueOf(orderNo);

        return big.setScale(6, BigDecimal.ROUND_DOWN).doubleValue();
    }

    /**
     * Method description
     *
     *
     * @param max
     * @param min
     *
     * @return
     */
    public static double getOrderNo(double max, double min) {
        double     val = max - min;
        BigDecimal big = BigDecimal.valueOf(min + val / 2);
        // �ӽ��������ģʽ
        return big.setScale(6, BigDecimal.ROUND_DOWN).doubleValue();
    }

    public static List<Map<String,Object>> treeSort(List<Map<String,Object>> list, String nodeID, String nodePID) {
        //根据nodeID 和 nodePID 进行树排序
        //一次循环 将list最底层向上抽取一次 产生新的list 直至无法向上抽取 抽取退出条件为 PID指向没有ID对应
        String childName = "children";
        List<Map<String,Object>> copyList = new ArrayList<>();
        copyList.addAll(list);
        Map<String, Map> idMap = new HashMap<>();
        ArrayList<String> pidList = new ArrayList<>();
        for (Map m : copyList) {
            idMap.put(m.get(nodeID).toString(), m);
            pidList.add(MapUtils.getLongValue(m,nodePID)+"");
            Object o = m.get(childName);
            if (o == null) {
                m.put(childName,new ArrayList<Map>());
            }
        }
        Iterator<Map<String,Object>> it = copyList.iterator();
        boolean flag =false;
        while (it.hasNext()) {
            Map m = it.next();
            String id = m.get(nodeID).toString();
            String pid = MapUtils.getLongValue(m,nodePID)+"";
            if (!pidList.contains(id)) {//没有pid指向该节点
                Map pMap = idMap.get(pid);
                if(pMap==null){
                    continue;
                }
                List<Map> childrenList = (List<Map>) pMap.get(childName);
                childrenList.add(m);
                it.remove();
                flag=true;
            }
        }
        if(flag){
            copyList = treeSort(copyList,nodeID,nodePID);
        }
        return copyList;
    }

}



