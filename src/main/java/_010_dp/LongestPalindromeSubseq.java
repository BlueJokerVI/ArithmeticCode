package _010_dp;

import org.junit.Test;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/longest-palindromic-subsequence/
 */
public class LongestPalindromeSubseq {
    public int longestPalindromeSubseq(String s) {

        //求最长回文串，转化位求s与t = reserve(s) 的最长公共子序列问题
        String t = new StringBuffer(s).reverse().toString();
        // dp[i][j] 表示s[0~i-1]与t[0~j-1]的最长公共字串的长度
        //if s[i]==s[j]    dp[i][j] = dp[i-1][j-1] + 1;
        //else  dp[i][j] = max(dp[i-1][j],dp[i][j-1])

        int[][] dp = new int[s.length() + 1][s.length() + 1];

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[s.length()][t.length()];
    }


    public int longestPalindromeSubseq1(String s) {
        //dp[i][j]：字符串s在[i, j)范围内最长的回文子序列的长度为dp[i][j]。
        //if s[i]==s[j]  dp[i][j] = dp[i+1][j-1] + 2;
        //else  dp[i][j] = dp[i+1][j-1]

        int[][] dp = new int[s.length() + 1][s.length() + 1];


        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (s.charAt(i) == s.charAt(j - 1)) {
                    if (j - 1 == i) {
                        dp[i][j] = dp[i + 1][j - 1] + 1;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }
                } else {
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }


        return dp[0][s.length()];
    }
    @Test
    public void test(){
        longestPalindromeSubseq1("bbbab");
    }
}
