package _010_dp;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/min-cost-climbing-stairs/
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        // dp[i] 到达i阶梯花费最小的带价
        // dp[i+1] = min(dp[i]+cost[i],dp[i-1]+cost[i-1])

        int len = cost.length;
        int[] dp = new int[cost.length+1];

        //因为一开始就可以从下标0和下标为1的地方开始爬
        dp[0] = 0;
        dp[1] = 0;

        for(int i=2;i<=len;i++){
            dp[i] = Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[len];
    }
}
