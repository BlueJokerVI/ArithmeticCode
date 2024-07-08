package _010_dp;

import java.util.Arrays;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/coin-change/
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {

        //dp[j]  表示0~i每硬币凑成j价值的背包需要的最少硬币数
        //dp[j] = min(dp[j],dp[j-coins[i]]+1)
        int[] dp = new int[amount+1];
        Arrays.fill(dp,-1);

        dp[0] =0;
        for (int i = 0; i < coins.length; i++) {
            for(int j=coins[i];j<=amount;j++){

                //诺使用i号硬币时，j-coins[i]背包凑不满直接跳过
                if(dp[j-coins[i]]!=-1){
                    if(dp[j]==-1){
                        //第一次找到符合的组成直接赋值
                        dp[j] = dp[j-coins[i]]+1;
                        continue;
                    }
                    dp[j] = Math.min(dp[j],dp[j-coins[i]]+1);
                }
            }
        }

        return dp[amount];
    }


    //暴力搜索，会超时
    class Solution {
        int res = Integer.MAX_VALUE;
        public int coinChange(int[] coins, int amount) {
            if(coins.length == 0){
                return -1;
            }

            findWay(coins,amount,0);

            // 如果没有任何一种硬币组合能组成总金额，返回 -1。
            if(res == Integer.MAX_VALUE){
                return -1;
            }
            return res;
        }

        public void findWay(int[] coins,int amount,int count){
            if(amount < 0){
                return;
            }
            if(amount == 0){
                res = Math.min(res,count);
            }

            for(int i = 0;i < coins.length;i++){
                findWay(coins,amount-coins[i],count+1);
            }
        }
    }


    //记忆化搜索
    class Solution1 {
        int[] memo;
        public int coinChange(int[] coins, int amount) {
            if(coins.length == 0){
                return -1;
            }
            memo = new int[amount+1];

            return findWay(coins,amount);
        }
        // memo[n] 表示钱币n可以被换取的最少的硬币数，不能换取就为-1
        // findWay函数的目的是为了找到 amount数量的零钱可以兑换的最少硬币数量，返回其值int
        public int findWay(int[] coins,int amount){
            if(amount < 0){
                return -1;
            }
            if(amount == 0){
                return 0;
            }
            // 记忆化的处理，memo[n]用赋予了值，就不用继续下面的循环
            // 直接的返回memo[n] 的最优值
            if(memo[amount] != 0){
                return memo[amount];
            }

            int min = Integer.MAX_VALUE;
            for(int i = 0;i < coins.length;i++){
                int res = findWay(coins,amount-coins[i]);
                if(res >= 0 && res < min){
                    min = res + 1; // 加1，是为了加上得到res结果的那个步骤中，兑换的一个硬币
                }
            }
            memo[amount] = (min == Integer.MAX_VALUE ? -1 : min);
            return memo[amount];
        }
    }

}
