package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/number-of-subarrays-with-bounded-maximum/
 */
public class NumSubarrayBoundedMax {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int l = -1, r = -1;
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] > right) {
                l = i;
                r = i;
            }

            if (nums[i] >= left && nums[i] <= right) {
                r = i;
            }

            if (nums[i] <= right) {
                ans += r - l;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        NumSubarrayBoundedMax numSubarrayBoundedMax = new NumSubarrayBoundedMax();
        numSubarrayBoundedMax.numSubarrayBoundedMax(new int[]{2, 1, 4, 3}, 2, 3);
    }
}
