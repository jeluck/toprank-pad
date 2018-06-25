package cc.toprank.byd.common.utils;

import java.util.Random;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public final class StdRandom {

    // �����������

    /** Field description */
    private static Random random;

    // ����ֵ

    /** Field description */
    private static long seed;

    // ��̬����飬��ʼ������ֵ�������������
    static {
        seed   = System.currentTimeMillis();
        random = new Random(seed);
    }

    // ˽�й��캯������ֹʵ����

    /**
     * Constructs ...
     *
     */
    private StdRandom() {}

    /**
     * Method description
     *
     *
     * @return
     */
    public static double random() {
        return uniform();
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public static double uniform() {
        return random.nextDouble();
    }

    /**
     * Method description
     *
     *
     * @param N
     *
     * @return
     */
    public static int uniform(int N) {
        return random.nextInt(N);
    }

    /**
     * Method description
     *
     *
     * @param a
     * @param b
     *
     * @return
     */
    public static double uniform(double a, double b) {
        return a + uniform() * (b - a);
    }

    /**
     * Method description
     *
     *
     * @param a
     * @param b
     *
     * @return
     */
    public static int uniform(int a, int b) {
        return a + uniform(b - a);
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public static long getSeed() {
        return seed;
    }

    /**
     * Method description
     *
     *
     * @param s
     */
    public static void setSeed(long s) {
        seed   = s;
        random = new Random(seed);
    }
}



