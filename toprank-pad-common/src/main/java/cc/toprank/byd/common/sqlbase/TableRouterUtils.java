
package cc.toprank.byd.common.sqlbase;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class TableRouterUtils {

    /** Field description */
    private final int NODE_NUM = 100;

    /** Field description */
    private TreeMap<Long, Object> nodes;

    /** Field description */
    private List<Object> shards;

    /**
     * Constructs ...
     *
     *
     * @param shards
     */
    public TableRouterUtils(List<Object> shards) {
        this.shards = shards;
        init();
    }

    /**
     * Method description
     *
     *
     * @param key
     *
     * @return
     */
    public Long hash(String key) {
        ByteBuffer buf       = ByteBuffer.wrap(key.getBytes());
        int        seed      = 0x1234ABCD;
        ByteOrder  byteOrder = buf.order();

        buf.order(ByteOrder.LITTLE_ENDIAN);

        long m = 0xc6a4a7935bd1e995L;
        int  r = 47;
        long h = seed ^ (buf.remaining() * m);
        long k;

        while (buf.remaining() >= 8) {
            k = buf.getLong();
            k *= m;
            k ^= k >>> r;
            k *= m;
            h ^= k;
            h *= m;
        }

        if (buf.remaining() > 0) {
            ByteBuffer finish = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);

            finish.put(buf).rewind();
            h ^= finish.getLong();
            h *= m;
        }

        h ^= h >>> r;
        h *= m;
        h ^= h >>> r;
        buf.order(byteOrder);

        return h;
    }

    /**
     * Method description
     *
     */
    private void init() {    // ��ʼ��һ����hash��
        nodes = new TreeMap<Long, Object>();

        for (int i = 0; i != shards.size(); ++i) {
            final Object shardInfo = shards.get(i);

            for (int n = 0; n < NODE_NUM; n++) {
                nodes.put(hash("SHARD-" + i + "-NODE-" + n), shardInfo);
            }
        }
    }

    /**
     * Method description
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        int          count  = 3;
        String       suffix = "2";
        List<Object> shards = new ArrayList<Object>();

        for (int i = 0; i < count; i++) {
            shards.add(i);
        }

        TableRouterUtils tableRouterUtil = new TableRouterUtils(shards);

        System.out.println(tableRouterUtil.getShardInfo(suffix).toString());
        System.out.println(tableRouterUtil.hash(suffix));
    }

    /**
     * Method description
     *
     *
     * @param key
     *
     * @return
     */
    public Object getShardInfo(String key) {
        SortedMap<Long, Object> tail = nodes.tailMap(hash(key));    // �ػ���˳ʱ���ҵ�һ������ڵ�

        if (tail.size() == 0) {
            return nodes.get(nodes.firstKey());
        }

        return tail.get(tail.firstKey());    // ���ظ�����ڵ��Ӧ����ʵ�����ڵ����Ϣ
    }
}



