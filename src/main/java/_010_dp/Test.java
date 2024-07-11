package _010_dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: TODO
 */
public class Test {
    public int climbStairs(int n) {
        //dp[i] = dp[i-1] + dp[i-2]
        int[] dp = new int[46];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    public int rob(int[] nums) {
        // dp[i][0]表示[0,i]偷i可获得的最大价值
        // dp[i][1]表示[0,i]不偷i可获得的最大价值
        // dp[i][0] = dp[i-1][1] + nums[i]
        // dp[i][1] = max(dp[i-1][1],dp[i-1][0])

        int[][] dp = new int[101][2];
        dp[0][0] = nums[0];
        dp[0][1] = 0;

        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = dp[i - 1][1] + nums[i];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0]);
        }

        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }

    Set<String> set = new HashSet<>();
    boolean[] memo = new boolean[301];

    public boolean wordBreak(String s, List<String> wordDict) {
        set.addAll(wordDict);
        return dfs(s, 0);
    }

    boolean dfs(String s, int start) {
        if (start == s.length()) {
            return true;
        }

        if (memo[start]) {
            return false;
        }

        for (int i = start; i < s.length(); i++) {
            String str = s.substring(start, i + 1);
            if (set.contains(str)) {
                if (dfs(s, i + 1)) {
                    return true;
                }
            }
        }
        memo[start] = true;
        return false;
    }


    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, 1);

        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            if (dp[i] > maxLen) {
                maxLen = dp[i];
            }
        }

        return maxLen;
    }


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        //dp[i][j] 到达[i,j]节点的最多路径数
        //dp[i][j] = dp[i-1][j] + dp[i][j-1];
        int[][] dp = new int[m][n];
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 1) break;
            dp[0][j] = dp[0][j - 1];
        }
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) break;
            dp[i][0] = dp[i - 1][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) continue;
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }


    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        char[] cs1 = word1.toCharArray();
        char[] cs2 = word2.toCharArray();

        //dp[i][j]：cs1[0,i-1]转换成cs2[0,j-1]最少最要多少操作
        /**
         *
         * 1. i,j都存在
         * if cs1[i]==cs2[j] :   dp[i][j] = dp[i-1][j-1]
         * else              :   dp[i][j] = min(dp[i-1][j-1],dp[i][j-1],dp[i-1][j]) + 1  (替换,添加,删除)
         */
        int[][] dp = new int[n + 1][m + 1];

        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= m; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (cs1[i - 1] == cs2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                }
            }
        }

        return dp[n][m];
    }

    public int maxProfit(int k, int[] prices) {

        int n = prices.length;


        int status = 2 * k + 1;
        int[][] dp = new int[n][status];
        for (int i = 1; i < status; i += 2) {
            dp[0][i] = -prices[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < status; j+=2) {
                //第j次买入
                dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1] - prices[i]);
                //第j次卖出
                dp[i][j+1] = Math.max(dp[i-1][j+1],dp[i-1][j] + prices[i]);
            }
        }


        return dp[n - 1][status-1];
    }
}
