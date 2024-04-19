package _010_dp;

import org.apache.commons.math3.analysis.function.Max;

import java.util.Arrays;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/perfect-squares/
 */
public class NumSquares {
    public int numSquares(int n) {

        // 完全背包问题
        // dp[j]  0~i恰好凑成j的最小组成
        // dp[j] = min(dp[j],dp[j-i]+1)
        int[] dp  = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1;i<=n;i++){
            if(is(i)){
                for(int j=i;j<=n;j++){
                    dp[j] = Math.min(dp[j],dp[j-i]+1);
                }
            }
        }

        return dp[n];
    }

    boolean is(int n){
        double sqrt = Math.sqrt(n);
        int x = (int)sqrt;
        if(x*x==n){
            return true;
        }
        return false;
    }
}
