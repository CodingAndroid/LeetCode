package JianZhiOffer;

/**
 * author: lihui1
 * date: 2019/4/8
 * email: 1316994947@qq.com
 * desc: 剑指offer面试题9: 斐波那契数列
 * 题目: 写一个函数, 输入n, 求斐波那契数列得第n项。斐波那契数列的定义如下:
 *        0               n=0
 * f(n) = 1               n=1
 *       f(n-1) + f(n-2)  n>1
 */

public class Fibonacci {

    /**
     * 递归方式
     * 时间复杂度: 以n的指数方式递增;
     * @param m
     * @return
     */
    public static int fibonacciRecursive(int m){
        int result[] = {0, 1};
        if (m < 2){
            return result[m];
        }
        return fibonacciRecursive(m-1) + fibonacciRecursive(m - 2);
    }

    /**
     * 非递归
     * 时间复杂度: O(n)
     * @param m
     * @return
     */
    public static int fibonacciTest(int m){
        int result[] = {0, 1};
        if (m < 2){
            return result[m];
        }
        int fn_1 = 1;
        int fn_2 = 0;
        int fn = 0;
        for (int i = 2; i <= m; i++){
            fn = fn_1 + fn_2;
            fn_2 = fn_1;
            fn_1 = fn;
        }
        return fn;
    }

    /**
     * 拓展1: 青蛙跳台阶
     * 题目: 题目：一只青蛙一次可以跳上1级台阶, 也可以跳上2级台阶。求该青蛙跳上一个n级的台阶总共有多少种跳法?
     * @param n
     * @return
     */
    public static int frogJumpStep(int n){
        int result[] = {0, 1, 2};
        if (n < 3){
            return result[n];
        }

        int fn_1 = 2;
        int fn_2 = 1;
        int fn = 0;
        for (int i = 3; i <= n; i++){
            fn = fn_1 + fn_2;
            fn_2 = fn_1;
            fn_1 = fn;
        }
        return fn;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(fibonacciTest(n));
        System.out.println(fibonacciRecursive(n));
        System.out.println(frogJumpStep(n));

    }
}
