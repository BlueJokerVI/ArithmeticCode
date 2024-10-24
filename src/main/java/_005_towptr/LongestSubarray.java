package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/longest-subarray-of-1s-after-deleting-one-element/
 */
public class LongestSubarray {
    public int longestSubarray(int[] nums) {

        int n = nums.length;
        int l = 0;
        int max = 0;
        int zcnt = 0;
        for (int r = 0; r < n; r++) {
            if (nums[r] == 0) {
                zcnt++;
            }
            if (zcnt == 2) {
                while (nums[l] != 0) {
                    l++;
                }
                l++;
            }

            if (r - l> max) {
                max = r - l;
            }

        }

        return max;
    }
}
