package _005_towptr;

import java.util.Arrays;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/maximum-beauty-of-an-array-after-applying-operation/
 */
public class MaximumBeauty {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int maxLen = 0;
        int l = 0;
        for (int r = 0; r < n; r++) {

            while (nums[r] - k > nums[l] + k) {
                l++;
            }

            if (r - l + 1 > maxLen) {
                maxLen = r - l + 1;
            }

        }

        return maxLen;
    }

    public static void main(String[] args) {
        MaximumBeauty maximumBeauty = new MaximumBeauty();
        maximumBeauty.maximumBeauty(new int[]{48, 93, 96, 19}, 24);
    }
}
