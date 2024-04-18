package _010_dp;

import java.util.Arrays;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/coin-change/
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {

        //dp[j]  表示0~i每硬币抽成j价值的背包需要的最少硬币数
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
}
