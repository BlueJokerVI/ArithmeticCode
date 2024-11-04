package _005_towptr;

import java.util.ArrayList;
import java.util.List;

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

            if (r - l > max) {
                max = r - l;
            }

        }

        return max;
    }

    /**
     * https://leetcode.cn/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
     *
     * @param nums
     * @param limit
     * @return
     */
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        List<Integer> max = new ArrayList<>();
        List<Integer> min = new ArrayList<>();
        int ans = 0;

        for (int l = 0, r = 0; r < n; r++) {
            while (!max.isEmpty() && max.get(max.size() - 1) < nums[r]) {
                max.remove(max.size() - 1);
            }
            max.add(nums[r]);

            while (!min.isEmpty() && min.get(min.size() - 1) > nums[r]) {
                min.remove(min.size() - 1);
            }
            min.add(nums[r]);

            while (!max.isEmpty() && !min.isEmpty() && max.get(0) - min.get(0) > limit) {
                if (nums[l] == max.get(0)) {
                    max.remove(0);
                }
                if (nums[l] == min.get(0)) {
                    min.remove(0);
                }
                l++;
            }
            if (r - l + 1 > ans) {
                ans = r - l + 1;
            }
        }
        return ans;
    }


}
