package _010_dp;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/climbing-stairs/
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        //爬楼梯

        //i个台阶有dp[i]中方式到达
        //dp[i+1] = dp[i] + dp[i-1]


        int[] dp = new int[46];
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1] +dp[i-2];
        }

        return dp[n];
    }
}
