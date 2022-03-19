package 力扣;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 注意「子序列」和「子串」这两个名词的区别，子串一定是连续的，而子序列不一定是连续的
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
public class 最长连续序列 {
    class Solution {
        //用Hash表进行优化
        //这里涉及到使用Set还是Map的问题
        //key存值，value保存右边界
        public int longestConsecutive(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int ans = -1;
            for (int num : nums)
                map.put(num, num);//更新一个边界
            //更新边界
            for (int num : nums) {
                if (!map.containsKey(num - 1)) {//如果不包含上一个值，那么开始更新这个值
                    int right = map.get(num);
                    while (map.containsKey(right + 1)) {
                        right = map.get(right + 1);
                    }
                    //更新边界
                    map.put(num, right);
                    ans = Math.max(ans, right - num + 1);
                }
            }

            return ans;
        }
    }

}
