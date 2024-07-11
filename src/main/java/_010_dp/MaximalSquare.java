package _010_dp;

import org.junit.Test;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/maximal-square/?envType=study-plan-v2&envId=top-interview-150
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        // base condition
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return 0;

        int m = matrix.length;
        int n = matrix[0].length;

        //dp[i+1][j+1] 表示一以 matrix[i][j]为正方形右下角的最大边长
        int[][] dp = new int[m+1][n+1];

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]=='1'){
                    dp[i+1][j+1] = Math.min(dp[i][j+1],Math.min(dp[i+1][j],dp[i][j])) + 1;
                    if(dp[i+1][j+1] > ans){
                        ans = dp[i+1][j+1];
                    }
                }
            }
        }
        return ans * ans;
    }
}
