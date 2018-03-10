package com.example.demo.java_code;

/**
 * 牛顿迭代法。
 *
 * @author LiuYJ
 * @since 02/02/2018
 */
public class NewtonSqrt {
    private static final double MISS = 0.00000000001;

    /**
     * 给定一个初始值，进行迭代
     *
     * @param num  原数
     * @param init 初始值
     * @return 结果
     */
    public static double sqrt(double num, double init) {
        int n = 0;
        long begin = System.nanoTime();
        do {
            init = iterate(num, init);
            n++;
        } while (test(num, init));
        long end = System.nanoTime();
        System.out.println("共执行了：" + n + "次，耗时：" + (end - begin) + "ns");
        return init;
    }


    /**
     * 牛顿迭代的公式
     *
     * @param num 原数
     * @param in  迭代点的x值
     * @return 迭代结果
     */
    private static double iterate(double num, double in) {
        return (in * in + num) / 2 / in;
    }

    /**
     * 测试误差值，给出结果
     *
     * @param num 原数
     * @param in  判定值
     * @return 判定结果
     */
    private static boolean test(double num, double in) {
        return in * in - num > MISS || in * in - num < -MISS;
    }

    /*private static double sqrt(double num) {
        if (num == 0) return 0;
        double re = num;
        double half = re * 0.5;
        int i = (int) re;
        i = 0x5f375a86 - (i >> 1);
        re = (double) i;
        re = re * (1.5 - half * re * re);
        re = re * (1.5 - half * re * re);
        return 1.0 / re;
    }*/
}
