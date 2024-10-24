package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/maximum-erasure-value/
 */
public class MaximumUniqueSubarray {
    public int maximumUniqueSubarray(int[] nums) {
        int[] mp = new int[10001];
        int n = nums.length;
        int max = 0;
        int cur = 0;
        int l = 0;
        for (int r = 0; r < n; r++) {
            cur += nums[r];
            mp[nums[r]]++;
            if (mp[nums[r]] == 2) {
                while (mp[nums[r]] == 2) {
                    cur -= nums[l];
                    mp[nums[l]]--;
                    l++;
                }
            }

            if (cur > max) {
                max = cur;
            }
        }
        return max;
    }
}
