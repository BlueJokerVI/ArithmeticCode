package _009_Greedy;

import java.util.Arrays;

/**
 * @author cct
 * https://leetcode.cn/problems/rearrange-array-to-maximize-prefix-score/
 */
public class MaxScore {
    public int maxScore(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        int n = nums.length;
        long cur = 0;
        for (int i = n - 1; i >= 0; i--) {
            cur += nums[i];
            if (cur > 0) {
                ans++;
            } else {
                return ans;
            }
        }
        return ans;
    }
}
