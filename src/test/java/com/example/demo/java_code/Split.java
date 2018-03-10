package com.example.demo.java_code;

/**
 * 二分法实现
 *
 * @author LiuYJ
 * @since 2018/2/22
 */
public class Split {
    private static double a;
    private static double b;
    private static Double result;

    public static double sqrt(double num, double miss) {
            /*
             大于1的数，方根在1-num之间；
             小于1的数，方根在num-1之间。
              */
        int n = 0;
        long begin = System.nanoTime();
        if (num >= 1) {
            a = 1;
            b = num;
        } else {
            a = num;
            b = 1;
        }
        do {
            midOne(num, miss);
            n++;
        } while (result == null);
        long end = System.nanoTime();
        System.out.println("共执行了：" + n + "次，耗时：" + (end - begin) + "ns");
        return result;
    }

    /**
     * 取中间值，淘汰二分之一范围
     *
     * @param num 原数
     */
    private static void midOne(double num, double miss) {
        double re = a + (b - a) / 2;
        double out = re * re - num;

        if (out >= 0) {
            b = re;
            if (out <= miss) {
                result = re;
            }
        } else {
            a = re;
            if (out >= -1 * miss) {
                result = re;
            }
        }
    }
}
