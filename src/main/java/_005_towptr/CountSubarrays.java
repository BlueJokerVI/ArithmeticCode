package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/count-subarrays-where-max-element-appears-at-least-k-times/
 */
public class CountSubarrays {
    public long countSubarrays(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }

        int t = 0;
        int n = nums.length;
        long ans = 0;
        int l = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == max) {
                t++;
            }
            while (t == k) {
                ans += n - i;
                if (nums[l] == max) {
                    t--;
                }
                l++;
            }
        }
        return ans;
    }
}
