package _013_binary_search;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/find-the-smallest-divisor-given-a-threshold/
 */
public class SmallestDivisor {
    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1, r = 1;
        for (int num : nums) {
            r = Math.max(r, num);
        }

        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (check(nums, mid, threshold)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r + 1;
    }

    boolean check(int[] nums, int v, int threshold) {
        int sum = 0;
        for (int num : nums) {
            sum += (int) Math.ceil(num * 1.0 / v);
            if (threshold < sum) {
                return false;
            }
        }
        return true;
    }
}
