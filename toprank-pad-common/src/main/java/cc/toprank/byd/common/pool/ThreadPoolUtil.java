package cc.toprank.byd.common.pool;
import cc.toprank.byd.common.utils.json.JSONUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class ThreadPoolUtil {

    /** Field description */
    private static final Logger logger = LoggerFactory.getLogger(ThreadPoolUtil.class);

    /** Field description */
    private static ThreadPoolUtil threadPool = null;

    /** Field description */
    private final Lock lock = new ReentrantLock();

    /** Field description */
    private final Condition notFull = lock.newCondition();

    /** Field description */
    private final Condition notEmpty = lock.newCondition();

    /** Field description */
    private ExecutorService pool = null;

    /** Field description */
    private Runnable[] items = null;

    /** Field description */
    private Integer poolSize = 30;

    /** Field description */
    private Integer capacity = 100;

    /** Field description */
    private Boolean open = false;

    /** Field description */
    private int putptr;

    /** Field description */
    private int takeptr;

    /** Field description */
    private int count;

    /**
     * Constructs ...
     *
     */
    private ThreadPoolUtil() {
        String poolParam = System.getProperty("pool.poolSize");

        if (StringUtils.isNotBlank(poolParam)) {
            try {
                Integer size = Integer.parseInt(poolParam.trim());

                if (size > 0) {
                    poolSize = size;
                }
            } catch (NumberFormatException e) {}
        }

        pool = Executors.newFixedThreadPool(poolSize);

        String openParam = System.getProperty("pool.open");

        if (StringUtils.isNotBlank(openParam)) {
            try {
                Boolean openCofig = Boolean.parseBoolean(openParam.trim());

                if (openCofig != null) {
                    open = openCofig;
                }
            } catch (Exception e) {}
        }

        if (open) {
            String capacityParam = System.getProperty("pool.capacity");

            if (StringUtils.isNotBlank(capacityParam)) {
                try {
                    Integer size = Integer.parseInt(capacityParam.trim());

                    if (size > 0) {
                        capacity = size;
                    }
                } catch (NumberFormatException e) {}
            }

            items = new Runnable[capacity];
        } else {
            items = new Runnable[1];
        }
    }

    /**
     * Method description
     *
     */
    public void close() {
        if (this.pool != null) {
            this.pool.shutdown();
        }

        this.pool = null;
    }

    /**
     * Method description
     *
     *
     * @param runnable
     */
    public void execute(Runnable runnable) {
        pool.execute(runnable);
    }

    /**
     * Method description
     *
     *
     * @param callable
     * @param timeout
     * @param unit
     *
     * @return
     */
    public Object execute(Callable<Object> callable, Long timeout, TimeUnit unit) {
        Future<Object> future = pool.submit(callable);

        try {
            if (unit == null) {

                // ����
                unit = TimeUnit.MILLISECONDS;
            }

            if (timeout == null) {

                // Ĭ������60��
                return future.get(60 * 1000, unit);
            }

            return future.get(timeout, unit);
        } catch (InterruptedException e) {}
        catch (ExecutionException e) {}
        catch (TimeoutException e) {}

        return null;
    }

    /**
     * Method description
     *
     *
     * @param callables
     * @param timeout
     * @param unit
     *
     * @return
     */
    public List<Object> execute(List<Callable<Object>> callables, Long timeout, TimeUnit unit) {
        if ((callables == null) || (callables.size() == 0)) {
            return null;
        }

        List<Object> result = new ArrayList<Object>();

        for (Callable<Object> callable : callables) {
            Object data = execute(callable, timeout, unit);

            if (logger.isDebugEnabled()) {
                logger.debug("callable�߳�ִ��,���ؽ��:{}", (data == null)
                                                     ? "null"
                                                     : JSONUtils.toJson(data));
            }

            if (data == null) {
                continue;
            }

            result.add(data);
        }

        return result;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public static ThreadPoolUtil newInstance() {
        if (threadPool != null) {
            return threadPool;
        }

        synchronized (ThreadPoolUtil.class) {
            if (threadPool == null) {
                threadPool = new ThreadPoolUtil();
            }
        }

        return threadPool;
    }

    /**
     * Method description
     *
     *
     * @param runnable
     *
     * @throws InterruptedException
     */
    public void put(Runnable runnable) throws InterruptedException {
        lock.lock();

        try {

            // �����������,��������
            while (count == items.length) {

                // ����ȡ���߳�
                notFull.await();
            }

            items[putptr] = runnable;

            if (++putptr == items.length) {
                putptr = 0;
            }

            ++count;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    /**
     * Method description
     *
     *
     * @return
     *
     * @throws InterruptedException
     */
    public Runnable take() throws InterruptedException {
        lock.lock();

        try {
            while (count == 0) {
                notEmpty.await();
            }

            Runnable runnable = items[takeptr];

            if (++takeptr == items.length) {
                takeptr = 0;
            }

            --count;
            notFull.signal();

            return runnable;
        } finally {
            lock.unlock();
        }
    }
}



