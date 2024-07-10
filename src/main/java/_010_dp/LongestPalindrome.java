package _010_dp;

import org.junit.Test;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/longest-palindromic-substring/?envType=study-plan-v2&envId=top-interview-150
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        //dp[i][j] : s[i,j]子串是回文串的长度, dp[i][j]=0 : s[i,j]子串不是回文串
        //dp[i][j] = if(dp[i+1][j-1]!=0 && s[i]==s[j]) dp[i+1][j-1] + 2
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        int maxLen = 1;
        String ans = s.substring(0,1);
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {

                if(j-i==1 && chars[i] == chars[j]){
                    dp[i][j] = 2;  //i,j相邻情况特殊处理
                }else if(dp[i+1][j-1]!=0 && chars[i] == chars[j]){
                    dp[i][j] =  dp[i+1][j-1] + 2;
                }

                if(dp[i][j] > maxLen){
                    maxLen = dp[i][j];
                    ans = s.substring(i,j+1);
                }
            }
        }
        System.out.println(maxLen);
        return ans;
    }
    @Test
    public void test(){
        longestPalindrome("ccc");
    }

}
