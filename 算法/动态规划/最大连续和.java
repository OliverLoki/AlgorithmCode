package 动态规划;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * 剑指 Offer II 119. 最长连续序列
 * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 * <p>
 * 问题描述：给定一个序列（整数或浮点数），求出其中连续的子序列和最大的那一个。
 * <p>
 * 例：序列{-10 1 2 3 4 -5 -23 3 7 -21}，其最大的连续子序列为{1 2 3 4}或{3 7}，最大和为10.
 */
public class 最大连续和 {
    public static void main(String[] args) {
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
    }

    //动态规划
    public int maxSubArray2(int[] nums) {
        /**
         *  对于一个元素，只有取和不取
         *  如果取：则 dp[i] = dp[i-1] + nums[i]
         *  如果不取：则 dp[i] = nums[i]（相当于从这个元素作为子区间的新起点，重新算起）
         *  所以 dp[i] = Math.max(dp[i-1] + nums[i],nums[i])
         */
        int[] dp = new int[nums.length];
        int maxSubSum= nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            maxSubSum = Math.max(maxSubSum, dp[i]);
        }
        return maxSubSum;
    }

}
