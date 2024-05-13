package _001_shuzu;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/?envType=study-plan-v2&envId=top-interview-150
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int maxValue = 0;
        for (int i = 1; i < prices.length; i++) {
            int t = prices[i] - buy;
            if (t <= 0) {
                buy = prices[i];
            } else {
                maxValue = Math.max(t,maxValue);
            }
        }
        return maxValue;
    }
}
