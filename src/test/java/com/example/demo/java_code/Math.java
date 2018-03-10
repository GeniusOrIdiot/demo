package com.example.demo.java_code;

/**
 * 数位迭代
 *
 * @author LiuYJ
 * @since 2018/2/6
 */
public class Math {

    /**
     * 迭代公式：I * x + x * x = sub_num
     * I: 迭代累计值
     * sub_num: 迭代位剩余值
     *
     * @param num   要求的数
     * @param scale 小数点后位数，过大会溢出
     * @return 方根值
     */
    public static double sqrt(double num, int scale) {
        long begin = System.nanoTime();
        int m = 0;
        // 计算位数
        int n = sqrtPos(num);
        // 迭代公式累计数值
        long I = 0;

        StringBuilder builder = new StringBuilder("");

        // 初始迭代位的数
        num = firstNum(n, num);
        if (n < 0) {
            fillZero(n, builder);
        }

        do {
            int x = nextDecimalValue(I, num);
            num = getP(x, I, num);

            // double类型数据在这里会有精度丢失，不用BigDecimal的话暂时没有什么好的解决方案
            num *= 100;
            builder.append(x);
            if (num == 0 && n <= 0) break;
            if (n == 0) {
                builder.append(".");
            }
            I = (I + 2 * x) * 10;
            m++;
        } while (n-- > -scale);
        long end = System.nanoTime();
        System.out.println("共执行了：" + m + "次，耗时：" + (end - begin) + "ns");

        return Double.parseDouble(builder.toString());
    }

    /**
     * 计算平方根的首位在小数点前(后)多少位。
     *
     * @param num 原数
     * @return 结果首位位置
     */
    private static int sqrtPos(double num) {
        int n = 0;
        if (num >= 1) {
            while (num >= 1) {
                num /= 100;
                n++;
            }
            return --n;
        } else {
            while (num < 1) {
                num *= 100;
                n--;
            }
            return n;
        }
    }

    /**
     * 根据公式求算该数位的值(0-9)
     *
     * @param y 迭代累计值
     * @param p 迭代位剩余值
     * @return 当前位数值
     */
    private static int nextDecimalValue(long y, double p) {
        for (int x = 0; x <= 10; x++) {
            // 此处求算过程易溢出
            if ((x * x + y * x) > p) {
                return --x;
            }
        }
        throw new RuntimeException();
    }

    /**
     * 迭代过程中减去已求算的部分，可以避免数值过早溢出
     *
     * @param x   当前位数值
     * @param y   累计迭代值
     * @param num 迭代剩余值
     * @return 迭代剩余值
     */
    private static double getP(int x, long y, double num) {
        return num - x * x - x * y;
    }

    /**
     * 获得第一个迭代剩余值
     */
    private static double firstNum(int n, double num) {
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                num /= 100;
            }
        } else {
            for (int i = 0; i > n; i--) {
                num *= 100;
            }
        }
        return num;
    }

    /**
     * 对于小于0的数，需要填充开方数前面的0
     */
    private static void fillZero(int n, StringBuilder builder) {
        builder.append("0.");
        for (int i = 0; i > n + 1; i--) {
            builder.append("0");
        }
    }

}
