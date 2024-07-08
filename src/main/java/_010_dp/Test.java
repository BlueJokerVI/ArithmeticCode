package _010_dp;

import java.util.*;

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




}
