package _010_dp;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class maxProfit1 {
    public int maxProfit(int[] prices) {

        //dp[i][0] 第i天持有股票可得的最大利润
        //dp[i][1] 第i天不持有股票可得的最大利润
        // dp[i][0] = max(dp[i-1][0],dp[i-1][1] - price[i])
        // dp[i][1] = max(dp[i-1][1],dp[i-1][0] + price[i])

        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for(int i=1;i<prices.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] + prices[i]);
        }

        return dp[prices.length-1][1];
    }
}
