package _009_Greedy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author cct
 * https://leetcode.cn/problems/maximize-greatness-of-an-array/
 */
public class MaximizeGreatness {
    public int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);
        int l = 0, r = 0;
        int n = nums.length;
        int ans = 0;
        while (r < n) {
            while (r < n && nums[r] <= nums[l]) {
                r++;
            }

            if (r < n) {
                ans++;
                l++;
                r++;
            }
        }
        return ans;
    }
}
