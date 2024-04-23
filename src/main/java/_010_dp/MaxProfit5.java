package _010_dp;

import org.junit.Test;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 */
public class MaxProfit5 {


    public int maxProfit(int[] prices, int fee) {

        /**
         *  dp[i][0] 持有股票最大利润
         *  dp[i][1] 不持有股票最大利润
         *  dp[i][0] = max(dp[i-1][0],dp[i-1][0]-prices[i])
         *  dp[i][1] = max(dp[i-1][1],dp[i-1][0]+prices[i]-fee)
         */
        int[][] dp = new int[prices.length][2];

        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]-fee);
        }
        return Math.max(dp[prices.length - 1][1], 0);
    }

    @Test
    public void test(){
        int[] s = new int[]{1,3,2,8,4,9};
        maxProfit(s,2);
    }
}
