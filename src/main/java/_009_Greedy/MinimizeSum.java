package _009_Greedy;

import java.util.Arrays;

/**
 * @author cct
 * https://leetcode.cn/problems/minimum-score-by-changing-two-elements/
 */
public class MinimizeSum {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        // 1 2 3 4
        return Math.min(nums[n - 2] - nums[1], Math.min(nums[n - 3] - nums[0], nums[n - 1] - nums[2]));
    }
}
