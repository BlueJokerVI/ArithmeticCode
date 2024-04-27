package _010_dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/longest-common-subsequence/
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        /**
         * dp[i][j] 表示text1中0-i子串与text2中0-j的子串的公共子序列的最大长度
         *
         * if(text1[i]==text[j])    dp[i][j] = dp[i-1][j-1]+1
         */


        int[][] dp = new int[text1.length()][text2.length()];
        for(int i=0;i<text1.length();i++){
            if(text2.charAt(0)==text1.charAt(i)){
                while (i<text1.length()){
                    dp[i][0] = 1;
                    i++;
                }
            }
        }

        for(int j=0;j<text2.length();j++){
            if(text2.charAt(j)==text1.charAt(0)){
                while (j<text2.length()){
                    dp[0][j] = 1;
                    j++;
                }
            }
        }

        for(int i=1;i<text1.length();i++){
            for(int j=1;j<text2.length();j++){
                if(text1.charAt(i)==text2.charAt(j)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }



        return dp[text1.length()-1][text2.length()-1];
    }

    @Test
    public void test()
    {
        longestCommonSubsequence("abcde","ace");
    }
}
