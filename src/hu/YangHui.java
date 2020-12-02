package hu;

public class YangHui {
    /**
     * 递归实现
     *
     * @param n 行数
     * @param m 列数
     * @return 对应数字
     */
    static int f(int n, int m) {
        if (n == m || m == 1)
            return 1;
        else
            return f(n - 1, m - 1) + f(n - 1, m);
    }


    /**
     * for循环实现 两数相加得到结果
     * @param n 行数
     * @param m 列数
     * @return 对应数字
     */
    static long f1(int n, int m) {long[][] f = new long[60][60];
        f[1][1] = 1;
        f[n][1] = 1;
        f[n][n] = 1;
        for (int i = 2; i <= 50; i++)
            for (int j = 1; j <= i; j++) {
                f[i][j] = f[i - 1][j - 1] + f[i - 1][j];
            }
        return f[n][m];
    }

    public static void main(String[] args) {
        int n = 7;
        int m = 5;
        System.out.println(f(n, m));
        System.out.println(f1(n, m));
    }
}