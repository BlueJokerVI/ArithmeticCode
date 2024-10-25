package _005_towptr;

import java.util.Arrays;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/frequency-of-the-most-frequent-element/
 */
public class MaxFrequency {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        int n = nums.length;
        int l = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {

            sum += nums[i];
            while (nums[l] + k < nums[i] || nums[i] * (i - l + 1) - sum > k) {
                sum -= nums[l];
                l++;
            }

            if (i - l + 1 > ans) {
                ans = i - l + 1;
            }
        }
        return ans;
    }
}
