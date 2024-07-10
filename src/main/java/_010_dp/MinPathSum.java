package _010_dp;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/minimum-path-sum/?envType=study-plan-v2&envId=top-interview-150
 */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        //到达dp[i][j]需要的最小代价
        //dp[i][j] = min(dp[i][j-1],dp[i-1][j]) + grid[i][j];
        int[][] dp = new int[m][n];

        //初始化
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i][j-1],dp[i-1][j]) + grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }
}
