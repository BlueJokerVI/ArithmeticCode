package _010_dp;

import org.apache.commons.math3.analysis.function.Max;

import java.util.Arrays;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/house-robber/
 */
public class Rob {

    public int rob1(int[] nums) {

        if(nums.length==1){
            return nums[0];
        }

        // dp[i]表示0~i可获得的最大价值
        // 遍历i，取或不取
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        for(int i=2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }

        return dp[nums.length-1];
    }


    /**
     * 记忆化搜索
     */
    int[] memos;
    public int rob3(int[] nums) {
        memos = new int[nums.length];
        Arrays.fill(memos, -1);
        return rob(nums, 0);
    }

    private int rob(int[] nums, int i) {

        if (i >= nums.length) {
            return 0;
        }

        if (memos[i] != -1) {
            return memos[i];
        }

        int sum = 0;

        for (int current = i; current < nums.length; current++) {
            sum = Math.max(sum, nums[current] + rob(nums, current + 2));
        }
        memos[i] = sum;
        return sum;
    }

}
