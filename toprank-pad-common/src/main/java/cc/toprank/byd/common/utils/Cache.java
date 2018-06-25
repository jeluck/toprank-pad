package cc.toprank.byd.common.utils;

import javafx.util.Pair;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class description
 *
 *
 * @param <K>
 * @param <V>
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class Cache<K, V> {

    /** Field description */
    private static final Logger LOG = Logger.getLogger(Cache.class.getName());

    /** Field description */
    private ConcurrentMap<K, V> cacheObjMap = new ConcurrentHashMap<K, V>();

    /** Field description */
    private DelayQueue<DelayItem<Pair<K, V>>> q = new DelayQueue<DelayItem<Pair<K, V>>>();

    /** Field description */
    private Thread daemonThread;

    /**
     * Constructs ...
     *
     */
    public Cache() {
        Runnable daemonTask = new Runnable() {
            public void run() {
                daemonCheck();
            }
        };

        daemonThread = new Thread(daemonTask);
        daemonThread.setDaemon(true);
        daemonThread.setName("Cache Daemon");
        daemonThread.start();
    }

    /**
     * Method description
     *
     */
    private void daemonCheck() {
        if (LOG.isLoggable(Level.INFO)) {
            LOG.info("cache service started.");
        }

        for (;;) {
            try {
                DelayItem<Pair<K, V>> delayItem = q.take();

                if (delayItem != null) {

                    // ��ʱ������
                    Pair<K, V> pair = delayItem.getItem();

                    // ��ʱ����
//                  cacheObjMap.remove(pair.first, pair.second); // compare and remove
                }
            } catch (InterruptedException e) {
                if (LOG.isLoggable(Level.SEVERE)) {
                    LOG.log(Level.SEVERE, e.getMessage(), e);
                }

                break;
            }
        }

        if (LOG.isLoggable(Level.INFO)) {
            LOG.info("cache service stopped.");
        }
    }

    // ��ӻ������

    /**
     * Method description
     *
     *
     * @param key
     * @param value
     * @param time
     * @param unit
     */
    public void put(K key, V value, long time, TimeUnit unit) {
        V oldValue = cacheObjMap.put(key, value);

        if (oldValue != null) {
            q.remove(key);
        }

        long nanoTime = TimeUnit.NANOSECONDS.convert(time, unit);

        q.put(new DelayItem<Pair<K, V>>(new Pair<K, V>(key, value), nanoTime));
    }

    /**
     * Method description
     *
     *
     * @param key
     *
     * @return
     */
    public V get(K key) {
        return cacheObjMap.get(key);
    }
}



