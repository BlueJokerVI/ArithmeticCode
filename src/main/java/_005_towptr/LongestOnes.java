package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/max-consecutive-ones-iii/
 */
public class LongestOnes {
    public int longestOnes(int[] nums, int k) {
        int max = 0;
        int n = nums.length;
        int l = 0;
        int zn = 0;
        for (int r = 0; r < n; r++) {
            if (nums[r] == 0) {
                zn++;
            }

            while (zn == k + 1) {
                if (nums[l] == 0) {
                    zn--;
                }
                l++;
            }

            if (r - l + 1 > max) {
                max = r - l + 1;
            }

        }
        return max;
    }
}
