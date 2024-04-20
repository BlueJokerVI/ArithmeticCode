package _010_dp;

import org.junit.Test;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/house-robber-ii/
 */
public class Rob1 {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }


        int[] dp = new int[nums.length];

        //dp[i] = max(dp[i-1],dp[i-2]+num[i])
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        //不含尾节点
        for(int i=2;i<nums.length-1;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }

        //不含头节点
        int[] dp1 = new int[nums.length];
        dp1[1] = nums[1];
        dp1[2] = Math.max(nums[1],nums[2]);
        for(int i=3;i<nums.length;i++){
            dp1[i] = Math.max(dp1[i-1],dp1[i-2]+nums[i]);
        }

        return Math.max(dp[nums.length-2],dp1[nums.length-1]);
    }

    @Test
    public void test(){
     int[] s = new int[]{1,2,1,1};
     rob(s);
    }

}
