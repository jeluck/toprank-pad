package cc.toprank.byd.common.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class GenerateUniqueId {

    /** Field description */
    private static char[] digits = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
    };

    /** Field description */
    private static Map<Character, Integer> rDigits = new HashMap<Character, Integer>(16);

    /** Field description */
    private static GenerateUniqueId me = new GenerateUniqueId();

    static {
        for (int i = 0; i < digits.length; ++i) {
            rDigits.put(digits[i], i);
        }
    }

    /** Field description */
    private Random random = new SecureRandom();

    /** Field description */
    private UniqTimer timer = new UniqTimer();

    /** Field description */
    private ReentrantLock opLock = new ReentrantLock();

    /** Field description */
    private String hostAddr;

    /** Field description */
    private MessageDigest mHasher;

    /**
     * Constructs ...
     *
     */
    private GenerateUniqueId() {
        try {
            InetAddress addr = InetAddress.getLocalHost();

            hostAddr = addr.getHostAddress();
        } catch (IOException e) {
            hostAddr = String.valueOf(System.currentTimeMillis());
        }

        if ((hostAddr == null) || (hostAddr.length() == 0) || "127.0.0.1".equals(hostAddr)) {
            hostAddr = String.valueOf(System.currentTimeMillis());
        }

        try {
            mHasher = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException nex) {
            mHasher = null;
        }
    }

    /**
     * Method description
     *
     *
     * @param bt
     *
     * @return
     */
    public String bytes2string(byte[] bt) {
        int    l   = bt.length;
        char[] out = new char[l << 1];

        for (int i = 0, j = 0; i < l; i++) {
            out[j++] = digits[(0xF0 & bt[i]) >>> 4];
            out[j++] = digits[0x0F & bt[i]];
        }

        return new String(out);
    }

    /**
     * Method description
     *
     *
     * @param data
     *
     * @return
     */
    public byte[] hash(byte[] data) {
        opLock.lock();

        try {
            byte[] bt = mHasher.digest(data);

            if ((null == bt) || (bt.length != 16)) {
                throw new IllegalArgumentException("md5 need");
            }

            return bt;
        } finally {
            opLock.unlock();
        }
    }

    /**
     * Method description
     *
     *
     * @param str
     *
     * @return
     */
    public byte[] hash(String str) {
        opLock.lock();

        try {
            byte[] bt = mHasher.digest(str.getBytes("UTF-8"));

            if ((null == bt) || (bt.length != 16)) {
                throw new IllegalArgumentException("md5 need");
            }

            return bt;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("unsupported utf-8 encoding", e);
        } finally {
            opLock.unlock();
        }
    }

    /**
     * Method description
     *
     *
     * @param str
     *
     * @return
     */
    public String hashBytes(byte[] str) {
        byte[] bt = hash(str);

        return bytes2string(bt);
    }

    /**
     * Method description
     *
     *
     * @param str
     *
     * @return
     */
    public String hashString(String str) {
        byte[] bt = hash(str);

        return bytes2string(bt);
    }

    /**
     * Method description
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(GenerateUniqueId.getInstance().getUniqIDHashString());
    }

    /**
     * Method description
     *
     *
     * @param str
     *
     * @return
     */
    public byte[] string2bytes(String str) {
        if (null == str) {
            throw new NullPointerException("��������Ϊ��");
        }

        if (str.length() != 32) {
            throw new IllegalArgumentException("�ַ������ȱ�����32");
        }

        byte[] data = new byte[16];
        char[] chs  = str.toCharArray();

        for (int i = 0; i < 16; ++i) {
            int h = rDigits.get(chs[i * 2]).intValue();
            int l = rDigits.get(chs[i * 2 + 1]).intValue();

            data[i] = (byte) ((h & 0x0F) << 4 | (l & 0x0F));
        }

        return data;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public static GenerateUniqueId getInstance() {
        return me;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public String getUniqID() {
        StringBuffer sb = new StringBuffer();
        long         t  = timer.getCurrentTime();

        sb.append(t);
        sb.append("-");
        sb.append(random.nextInt(8999) + 1000);
        sb.append("-");
        sb.append(hostAddr);
        sb.append("-");
        sb.append(Thread.currentThread().hashCode());

        return sb.toString();
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public byte[] getUniqIDHash() {
        return hash(getUniqID());
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public String getUniqIDHashString() {
        return hashString(getUniqID());
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public long getUniqTime() {
        return timer.getCurrentTime();
    }

    /**
     * Class description
     *
     *
     * @version        2.0.0, 2017-01-12
     * @author         David  
     */
    private static class UniqTimer {

        /** Field description */
        private AtomicLong lastTime = new AtomicLong(System.currentTimeMillis());

        /**
         * Method description
         *
         *
         * @return
         */
        public long getCurrentTime() {
            return this.lastTime.incrementAndGet();
        }
    }
}



