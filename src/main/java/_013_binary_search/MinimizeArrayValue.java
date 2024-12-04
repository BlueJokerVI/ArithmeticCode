package _013_binary_search;

/**
 * @author cct
 * https://leetcode.cn/problems/minimize-maximum-of-array/
 */
public class MinimizeArrayValue {
    public int minimizeArrayValue(int[] nums) {
        int n = nums.length;
        long[] ls = new long[n];
        int l = 0, r = nums[0];
        for (int i = 1; i < n; i++) {
            ls[i] = ls[i - 1] + nums[i - 1];
            r = Math.max(r, nums[i]);
        }

        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (check(nums, ls, mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r + 1;
    }


    boolean check(int[] nums, long[] ls, int mid) {
        int n = nums.length;
        if (nums[0] > mid) {
            return false;
        }
        for (int i = 1; i < n; i++) {
            if (nums[i] > mid) {
                int dv = nums[i] - mid;
                if (ls[i] + dv > (long) mid * i) {
                    return false;
                }
            }
        }
        return true;
    }
}
