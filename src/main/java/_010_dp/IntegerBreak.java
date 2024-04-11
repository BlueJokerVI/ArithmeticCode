package _010_dp;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/integer-break/
 */


public class IntegerBreak {
    public int integerBreak(int n) {

        // dp[i]   和为i的最大乘积
        //  dp[i] = max( (i-j)*j, dp[i-j]*j )
        int[] dp = new int[n+1];
        dp[2] = 1;

        for(int i=3;i<=n;i++){
            for(int j=1;j<i;j++){
                dp[i] = Math.max((i-j)*j,dp[i-j]*j);
            }
        }

        return dp[n];
    }
}
