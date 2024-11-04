package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/binary-subarrays-with-sum/
 */
public class NumSubarraysWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int cur = 0;
        int ans1 = 0;
        int ans2 = 0;
        for (int l = 0, r = 0; r < n; r++) {
            cur += nums[r];
            while (l<=r && cur >= goal) {
                ans1 += n - r;
                cur -= nums[l];
                l++;
            }
        }

        cur = 0;
        for (int l = 0, r = 0; r < n; r++) {
            cur += nums[r];
            while (l<=r && cur >= goal + 1) {
                ans2 += n - r;
                cur -= nums[l];
                l++;
            }
        }

        return ans1 - ans2;
    }
}
