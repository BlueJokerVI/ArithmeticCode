package _013_binary_search;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/maximum-count-of-positive-integer-and-negative-integer/
 */
public class MaximumCount {
    public int maximumCount(int[] nums) {
        int neg = lowerBound(nums, 0);
        int zero = lowerBound(nums, 1);

        return Math.max(neg + 1, nums.length - 1 -zero );
    }

    private int lowerBound(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;

            if (nums[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }
}
