package cc.toprank.byd.common.utils;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Class description
 *
 *
 * @param <T>
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class DelayItem<T> implements Delayed {

    /** Field description */
    private static final long NANO_ORIGIN = System.nanoTime();

    /** Field description */
    private static final AtomicLong sequencer = new AtomicLong(0);

    /** Field description */
    private final long sequenceNumber;

    /** Field description */
    private final long time;

    /** Field description */
    private final T item;

    /**
     * Constructs ...
     *
     *
     * @param submit
     * @param timeout
     */
    public DelayItem(T submit, long timeout) {
        this.time           = now() + timeout;
        this.item           = submit;
        this.sequenceNumber = sequencer.getAndIncrement();
    }

    /**
     * Method description
     *
     *
     * @param other
     *
     * @return
     */
    public int compareTo(Delayed other) {
        if (other == this) {    // compare zero ONLY if same object
            return 0;
        }

        if (other instanceof DelayItem) {
            DelayItem x    = (DelayItem) other;
            long      diff = time - x.time;

            if (diff < 0) {
                return -1;
            } else if (diff > 0) {
                return 1;
            } else if (sequenceNumber < x.sequenceNumber) {
                return -1;
            } else {
                return 1;
            }
        }

        long d = (getDelay(TimeUnit.NANOSECONDS) - other.getDelay(TimeUnit.NANOSECONDS));

        return (d == 0)
               ? 0
               : ((d < 0)
                  ? -1
                  : 1);
    }

    /**
     * Method description
     *
     *
     * @return
     */
    final static long now() {
        return System.nanoTime() - NANO_ORIGIN;
    }

    /**
     * Method description
     *
     *
     * @param unit
     *
     * @return
     */
    public long getDelay(TimeUnit unit) {
        long d = unit.convert(time - now(), TimeUnit.NANOSECONDS);

        return d;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public T getItem() {
        return this.item;
    }
}



