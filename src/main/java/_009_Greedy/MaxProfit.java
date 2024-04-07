package _009_Greedy;

import org.junit.Test;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class MaxProfit {

    //标记上次买入坐标
    int pre = -1;
    int ans = Integer.MIN_VALUE;
    int cur;

    public int maxProfit(int[] prices) {
        //利润拆分，取正利润就是最大利润
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            result += Math.max(prices[i] - prices[i - 1], 0);
        }
        return result;
    }



    //暴力回溯  ，timeout0.o
    void dfs(int index, int[] prices) {

        if (index == prices.length) {
            if (cur > ans) {
                ans = cur;
            }
            return;
        }

        //买
        if (pre == -1) {
            cur -= prices[index];

            pre = index;
            dfs(index + 1, prices);
            cur += prices[index];
            pre = -1;
        }

        //卖
        if (pre > 0) {
            cur += prices[index];
            int tmp = pre;
            pre = -1;
            dfs(index + 1, prices);
            cur -= prices[index];
            pre = tmp;
        }
        //不买也不卖
        dfs(index + 1, prices);
    }

    @Test
    public void test() {
        int[] nums = new int[]{7, 1, 5, 3, 6, 4};
        maxProfit(nums);
    }
}
