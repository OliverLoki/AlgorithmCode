package 数论;

import jdk.swing.interop.SwingInterOpUtils;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fib(6));
    }

    //1、递归求斐波那契数,时间复杂度为 O(2^n)，指数级别
    public static int fibonacci(int n) {
        if (n == 1 || n == 2)
            return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    //2、带备忘录的递归 O(n)
    public static int fib(int n) {
        int[] memory = new int[n + 1];
        return fib(n, memory);
    }

    public static int fib(int n, int[] memoary) {
        //base case
        if (n == 1 || n == 2) return 1;
        if (memoary[n] != 0) return memoary[n];
        memoary[n] = fib(n - 1, memoary) + fib(n - 2, memoary);

        return memoary[n];
    }


    //3、dp数组的迭代解法
    public static int fib2(int n) {
        int[] dp = new int[n + 1];//DP table
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];


    }

}
