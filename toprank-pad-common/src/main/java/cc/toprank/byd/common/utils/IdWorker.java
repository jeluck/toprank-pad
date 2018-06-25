

package cc.toprank.byd.common.utils;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class IdWorker {

    /** Field description */
    private static final IdWorker idWorker = new IdWorker();

    /** Field description */
    private final long twepoch = 1288834974657L;

    /** Field description */
    private final long workerIdBits = 5L;

    /** Field description */
    private final long datacenterIdBits = 5L;

    /** Field description */
    private final long maxWorkerId = -1L ^ (-1L << workerIdBits);

    /** Field description */
    private final long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);

    /** Field description */
    private final long sequenceBits = 12L;

    /** Field description */
    private final long workerIdShift = sequenceBits;

    /** Field description */
    private final long datacenterIdShift = sequenceBits + workerIdBits;

    /** Field description */
    private final long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;

    /** Field description */
    private final long sequenceMask = -1L ^ (-1L << sequenceBits);

    /** Field description */
    private long workerId = 0;

    /** Field description */
    private long datacenterId = 0;

    /** Field description */
    private long sequence = 0L;

    /** Field description */
    private long lastTimestamp = -1L;

    /**
     * Constructs ...
     *
     */
    private IdWorker() {}

    /**
     * Constructs ...
     *
     *
     * @param workerId
     * @param datacenterId
     */
    private IdWorker(long workerId, long datacenterId) {
        if ((workerId > maxWorkerId) || (workerId < 0)) {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0",
                                                             maxWorkerId));
        }

        if ((datacenterId > maxDatacenterId) || (datacenterId < 0)) {
            throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0",
                                                             maxDatacenterId));
        }

        this.workerId     = workerId;
        this.datacenterId = datacenterId;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public String buildPartNumber() {
        return "P" + idWorker.nextId();
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public String buildSkuCode() {
        return "S" + idWorker.nextId();
    }

    /**
     * Method description
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        String partNumber = IdWorker.getInstance().buildPartNumber();
        String skuCode    = IdWorker.getInstance().buildSkuCode();

        System.out.println(partNumber);
        System.out.println(skuCode);
    }

    /**
     * Method description
     *
     *
     * @return
     */
    private synchronized long nextId() {
        long timestamp = timeGen();

        if (timestamp < lastTimestamp) {
            throw new RuntimeException(
                String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds",
                              lastTimestamp - timestamp));
        }

        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;

            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0L;
        }

        lastTimestamp = timestamp;

        return ((timestamp - twepoch) << timestampLeftShift) | (datacenterId << datacenterIdShift)
               | (workerId << workerIdShift) | sequence;
    }

    /**
     * Method description
     *
     *
     * @param lastTimestamp
     *
     * @return
     */
    private long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();

        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }

        return timestamp;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    private long timeGen() {
        return System.currentTimeMillis();
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public static IdWorker getInstance() {
        return idWorker;
    }
}



