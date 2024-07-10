package _010_dp;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/interleaving-string/?envType=study-plan-v2&envId=top-interview-150
 */
public class IsInterleave {
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();
        char[] cs3 = s3.toCharArray();
        int n = s1.length();
        int m = s2.length();
        int l = s3.length();

        if(m+n!=l){
            return false;
        }

        //dp[i][j] 表示s1的前i个字符能和s2的前j个字符能否交叉组成s3
        //依据cs3[i+j-1] 与 cs1[i-1]、cs2[j-1]是否相等与和dp[i-1][j]、dp[i][j-1]的关系经行状态转移
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;
        for (int i = 1; i <= n && dp[i-1][0]; i++) {
            dp[i][0] = cs3[i - 1] == cs1[i - 1];
        }
        for (int j = 1; j <= m && dp[0][j-1]; j++) {
            dp[0][j] = cs3[j-1] == cs2[j-1];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(cs3[i+j-1]==cs1[i-1] && dp[i-1][j]) dp[i][j] = true;
                if(cs3[i+j-1]==cs2[j-1] && dp[i][j-1]) dp[i][j] = true;
            }
        }

        return dp[n][m];
    }



    //暴力搜索
    class Solution {
        char[] cs1, cs2, cs3;
        int n, m, l;
        public boolean isInterleave(String s1, String s2, String s3) {
            cs1 = s1.toCharArray(); cs2 = s2.toCharArray(); cs3 = s3.toCharArray();
            n = s1.length(); m = s2.length(); l = s3.length();
            if (n + m != l) return false;
            return dfs(0, 0);
        }
        boolean dfs(int i, int j) {
            if (i + j == l) return true;
            boolean ans = false;
            if (i < n && cs1[i] == cs3[i + j]) ans |= dfs(i + 1, j);
            if (j < m && cs2[j] == cs3[i + j]) ans |= dfs(i, j + 1);
            return ans;
        }
    }


    //记忆化搜索
    class Solution1 {
        char[] cs1, cs2, cs3;
        int n, m, l;
        int[][] cache;
        public boolean isInterleave(String s1, String s2, String s3) {
            cs1 = s1.toCharArray(); cs2 = s2.toCharArray(); cs3 = s3.toCharArray();
            n = s1.length(); m = s2.length(); l = s3.length();
            if (n + m != l) return false;
            cache = new int[n + 10][m + 10];
            return dfs(0, 0);
        }
        boolean dfs(int i, int j) {
            if (cache[i][j] != 0) return cache[i][j] == 1;
            if (i + j == l) return true;
            boolean ans = false;
            if (i < n && cs1[i] == cs3[i + j]) ans |= dfs(i + 1, j);
            if (j < m && cs2[j] == cs3[i + j]) ans |= dfs(i, j + 1);
            cache[i][j] = ans ? 1 : -1;
            return ans;
        }
    }

}
