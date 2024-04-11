package _010_dp;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/unique-paths/
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(i==1&&j==1){
                    //初始化
                    dp[1][1] = 1;
                    continue;
                }
                dp[i][j] = dp[i][j-1]+dp[i-1][j];
            }
        }

        return dp[m][n];
    }
}
