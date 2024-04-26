package _010_dp;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/distinct-subsequences/
 */
public class NumDistinct {
    public int numDistinct(String s, String t) {

        /**
         * dp[i][j]  0-i内t[0-j]出现的次数    ans = dp[s.length()-1][t.length()-1]
         *
         * if s.charAt(i) == t.charAt(j)    dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
         */

        int[][] dp = new int[s.length()][t.length()];

        //初始化
        if (t.charAt(0) == s.charAt(0)) {
            dp[0][0] = 1;
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(0)) {
                dp[i][0] = dp[i - 1][0] + 1;
            } else {
                dp[i][0] = dp[i - 1][0];
            }
        }


        for (int j = 1; j < t.length(); j++) {
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }




        return dp[s.length() - 1][t.length() - 1];
    }
}
