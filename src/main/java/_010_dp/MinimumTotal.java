package _010_dp;

import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/triangle/?envType=study-plan-v2&envId=top-interview-150
 */
public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        //dp[i][j] 为到达[i,j]的最小路径和
        //dp[i][j] = min(dp[i-1][j-1],dp[i-1][j]) + triangle[i][j]
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        //初始化
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0] + triangle.get(i).get(0);
        }


        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            if(ans > dp[n-1][j]){
                ans = dp[n-1][j];
            }
        }

        return ans;
    }
}
