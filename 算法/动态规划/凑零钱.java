package 动态规划;

import java.util.Arrays;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 凑零钱 {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        //定义dp数组大小为amount+1,初始值也为amount+1,
        //为什么dp数组初始化为amount + 1呢，因为凑成amount金额的硬币数最多只可能等于amount（全用 1 元面值的硬币），所以初始化为amount + 1就相当于初始化为正无穷，便于后续取最小值
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;//base case
        for (int i = 1; i <= amount; i++) {//amount为金额
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {//如果可以用硬币表示
                    //找到上一个数+x个硬币数量的最小值
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        //所需要金币数量大于金额，说明无解，返回-1
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
