package _005_towptr;

import java.util.Arrays;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/minimum-difference-between-highest-and-lowest-of-k-scores/
 */
public class MinimumDifference {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int cur = 0;
        for (int i = k - 1; i < n; i++) {
            int v = nums[i] - nums[i - k + 1];
            if (v < min) {
                min = v;
            }
        }
        return min;
    }
}
