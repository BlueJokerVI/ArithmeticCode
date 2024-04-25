package _010_dp;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/maximum-subarray/
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {

        //dp[i] 表示0-i内，以i结尾的连续子数组和的最大值
        //dp[i] = dp[i-1]>0? dp[i-1]+nums[i] : nums[i]


        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int ans = dp[0];

        for(int i=1;i<nums.length;i++){
            dp[i] = dp[i-1] > 0? dp[i-1]+nums[i] : nums[i];
            if(ans<dp[i]){
                ans = dp[i];
            }
        }

        return ans;
    }
}
