package _005_towptr;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/length-of-longest-subarray-with-at-most-k-frequency/
 */
public class MaxSubarrayLength {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        int n = nums.length;
        int l = 0;
        int max = 0;

        for (int r = 0; r < n; r++) {

            mp.put(nums[r], mp.getOrDefault(nums[r], 0) + 1);
            while (mp.get(nums[r]) == k + 1) {
                mp.put(nums[l], mp.get(nums[l]) - 1);
                l++;
            }

            if (r - l + 1 > max) {
                max = r - l + 1;
            }
        }
        return max;
    }
}
