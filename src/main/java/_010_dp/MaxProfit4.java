package _010_dp;

import org.junit.Test;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 */
public class MaxProfit4 {
    public int maxProfit(int[] prices) {

        /**
         * dp[i][0]  持有股票最大利润
         * dp[i][1]  不持有股票最大利润（非冷却期）
         * dp[i][2]  冷却期最大利润（不持有股票）
         *
         * dp[i][0] = max(dp[i-1][0],dp[i-1][1] - prices[i])
         * dp[i][1] = max(dp[i-1][1],dp[i-1][2])
         * dp[i][2] = dp[i-1][0] + prices[i]
         *
         *
         */
        int[][] dp = new int[prices.length][3];
        dp[0][0] = -prices[0];


        for(int i=1;i<prices.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][2]);
            dp[i][2] = dp[i-1][0] + prices[i];
        }

        return Math.max(dp[prices.length-1][1],dp[prices.length-1][2]);
    }

    @Test
    public void test(){
    int[] s = new int[]{1,2,3,0,2};
    maxProfit(s);
    }
}
