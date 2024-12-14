package _009_Greedy;

import java.util.Arrays;

/**
 * @author cct
 * https://leetcode.cn/problems/minimum-increment-to-make-array-unique/
 */
public class MinIncrementForUnique {
    public int minIncrementForUnique(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        int n = nums.length;
        int cur = nums[0] + 1;
        for (int i = 1; i < n; i++) {
            if (cur > nums[i]) {
                ans += cur - nums[i];
                cur++;
            } else {
                cur = nums[i] + 1;
            }
        }
        return ans;
    }
}
