package _005_towptr;

import java.util.Arrays;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/3sum-closest/
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int ans = nums[0] + nums[1] + nums[2];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int v = target - nums[i];
            int l = 0, r = n - 1;
            while (l < r) {

                if (l == i) {
                    l++;
                    continue;
                }
                if (r == i) {
                    r--;
                    continue;
                }

                if (nums[l] + nums[r] == v) {
                    return target;
                }
                if (Math.abs(nums[l] + nums[r] + nums[i] - target) < Math.abs(ans - target)) {
                    ans = nums[l] + nums[r] + nums[i];
                }

                if (nums[l] + nums[r] < v) {
                    l++;
                }
                if (nums[l] + nums[r] > v) {
                    r--;
                }
            }
        }
        return ans;
    }
}
