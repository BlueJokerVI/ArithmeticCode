package _001_shuzu;

import org.apache.commons.math3.analysis.function.Max;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/?envType=study-plan-v2&envId=top-interview-150
 */
public class maxProfit1 {


    /**
     * 如果想到其实最终利润是可以分解的，那么本题就很容易了！
     * 如何分解呢？
     * 假如第 0 天买入，第 3 天卖出，那么利润为：prices[3] - prices[0]。
     * 相当于(prices[3] - prices[2]) + (prices[2] - prices[1]) + (prices[1] - prices[0])。
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            ans += Math.max(prices[i]-prices[i-1],0);
        }
        return ans;
    }

    public int maxProfit(int[] prices) {
        /**
         * dp[i][0] 持有票最大利润  dp[i][1] 无股票最大利润             0-i 可得最大利润
         * dp[i][0] = max(dp[i-1][0],dp[i-1][1]-prices[i])
         * dp[i][1] = max(dp[i-1][1],dp[i-1][0]  + prices[i])
         */
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for(int i=1;i<prices.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] + prices[i]);
        }

        return dp[prices.length-1][1];
    }

}
