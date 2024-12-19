package _009_Greedy;

import java.util.Arrays;

/**
 * @author cct
 * https://leetcode.cn/problems/minimize-maximum-pair-sum-in-array/description/
 */
public class MinPairSum {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n / 2; i++) {
            ans = Math.max(ans, nums[i] + nums[n - 1 - i]);
        }

        return ans;
    }
}
