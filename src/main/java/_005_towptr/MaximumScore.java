package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/maximum-score-of-a-good-subarray/
 */
public class MaximumScore {
    public int maximumScore(int[] nums, int k) {
        int max = nums[k];
        int min = nums[k];
        int l = k, r = k;
        int n = nums.length;
        while (true) {

            while (l >= 0 && nums[l] >= min) {
                l--;
            }

            while (r < n && nums[r] >= min) {
                r++;
            }

            int cur = ((r - 1) - (l + 1) + 1) * min;
            if (cur > max) {
                max = cur;
            }

            if (l < 0 && r == n) {
                break;
            } else if (l < 0) {
                min = nums[r];
            } else if (r == n) {
                min = nums[l];
            } else {
                min = Math.max(nums[l], nums[r]);
            }


        }

        return max;
    }
}
