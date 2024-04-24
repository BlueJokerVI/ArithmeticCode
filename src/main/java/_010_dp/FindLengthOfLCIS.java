package _010_dp;

import java.util.Arrays;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/longest-continuous-increasing-subsequence/
 */
public class FindLengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {

        //dp[i] 0-i以i结尾的最长连续子序列
        // dp[i] = nums[i]>nums[j] ? dp[i-1]+1 : 1

        int ans = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] > nums[i - 1] ? dp[i - 1] + 1 : 1;
            if(ans<dp[i]){
                ans = dp[i];
            }
        }
        return ans;
    }
}
