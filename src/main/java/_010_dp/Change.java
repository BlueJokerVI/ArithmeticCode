package _010_dp;

import org.junit.Test;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/coin-change-ii/
 */
public class Change {

    //组合
    public int change(int amount, int[] coins) {

        //dp[j] 得到j价值的组合次数
        //每枚硬币的价值与体积相等
        //dp[j] = dp[j] + dp[j-coin[i]]

        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<=amount;j++){
                dp[j] = dp[j] + dp[j-coins[i]];
            }
        }

        return dp[amount];
    }



    public int change1(int amount, int[] coins) {

        /**
         *
         * dp[j] 得到j价值的排列次数
         * 求排列数，对于每一个容量，都会尝试放入可放入值
         */
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int j=0;j<=amount;j++){
            for(int i=0;i<coins.length;i++){
                if(coins[i]<=j){
                    dp[j] = dp[j] + dp[j-coins[i]];
                }
            }
        }

        return dp[amount];
    }

    @Test
    public void test(){
        int[] coins = new int[]{1,5};

        change1(6,coins);
    }


}
