package _010_dp;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/
 */
public class maxProfit3 {
    public int maxProfit(int k, int[] prices) {

        /**
         * dp[i][j] 对第i间物品来说j状态下可得最大利润
         *
         * j=0 第一次买入
         * j=1 第一次卖出
         * j=2 第二次买入
         * j=3 第二次卖出
         * .......
         */

        int v = 2 * k;
        int[][] dp = new int[prices.length][v];

        //初始化dp
        for (int j = 0; j < v; j += 2) {
            dp[0][j] = -prices[0];
        }

        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < v; j++) {

                if (j % 2 == 0) {
                    //买入
                    dp[i][j] = Math.max(dp[i - 1][j], j - 1 >= 0 ? dp[i - 1][j - 1] - prices[i] : -prices[i]);
                } else {
                    //卖出
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i]);
                }

            }
        }

        return dp[prices.length-1][v-1];
    }
}
