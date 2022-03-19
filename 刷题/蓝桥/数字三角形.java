package 蓝桥;

import java.util.Arrays;
import java.util.Scanner;

/*
    原题链接：http://lx.lanqiao.cn/problem.page?gpid=T794

    状态转移方程：dp数组直接定义为二维数组，代表了这个点到下方的最大距离
        dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j + 1]) + nums[i][j]

 */
public class 数字三角形 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] nums = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                nums[i][j] = s.nextInt();
            }
        }
        dp(nums,n);
    }
    public static void dp(int[][] nums,int n){
        int[][] dp = new int[n][n];
        //先初始化，对dp最后一行中间的数赋值
        if (n % 2 == 0) {//n是偶数
            dp[n - 1][n / 2] = nums[n - 1][n / 2];
            dp[n - 1][n / 2 - 1] = nums[n - 1][n / 2 - 1];
        } else {//n是奇数
            dp[n - 1][n / 2] = nums[n - 1][n / 2];
        }
        for (int[] a:dp){
            System.out.println(Arrays.toString(a));
        }
        for (int i = n - 2; i >= 0; i--) {//从下至上遍历
            for (int j = 0; j <= i; j++) {//遍历每一行往下的两个元素的dp值，与自己相加
                if (dp[i + 1][j] != 0 || dp[i + 1][j + 1] != 0) {//判断条件
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j + 1]) + nums[i][j];
                    System.out.println(dp[i][j]+"="+nums[i][j]+"+"+Math.max(dp[i + 1][j], dp[i + 1][j + 1]));
                }
            }
        }
        for (int[] a:dp){//输出某一行某个结点到底部的距离最大值
            System.out.println(Arrays.toString(a));
        }

    }
}
