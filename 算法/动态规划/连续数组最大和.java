package 动态规划;

/*
https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
剑指 Offer 42. 连续子数组的最大和
输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
要求时间复杂度为O(n)
 */
public class 连续数组最大和 {


    public int maxSubArray(int[] nums) {
        int pre = 0;
        int dp = nums[0];
        for (int x : nums) {
            pre = Math.max(x + pre, x);
            dp = Math.max(dp, pre);
        }
        return dp;
    }
}
