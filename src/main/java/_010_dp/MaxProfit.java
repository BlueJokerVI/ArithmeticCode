package _010_dp;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
 */
public class MaxProfit {

    //贪心
    public int maxProfit(int[] prices) {

        if(prices.length==1){
            return 0;
        }

        int ans = 0;
        int pre = prices[0];

        for(int i=1;i<prices.length;i++){
            if(prices[i]<pre){
                pre  = prices[i];
            }else {
                ans = Math.max(ans,prices[i]-pre);
            }
        }

        return ans;
    }


    //dp
    public int maxProfit1(int[] prices) {

        /**
         * dp[i][0] 表示第i天持有股票可得的最大现金
         * dp[i][1] 表示第i天不持有股票可得的最大现金
         *
         * dp[i][0] = max(dp[i-1][0],- price[i])
         * dp[i][1] = max(dp[i-1][1],dp[i-1][0] + price[i])
         */
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for(int i=1;i<prices.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],-prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] + prices[i]);
        }

        return dp[prices.length-1][1];
    }
}
