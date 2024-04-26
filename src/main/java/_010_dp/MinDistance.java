package _010_dp;

import org.junit.Test;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/delete-operation-for-two-strings/
 */
public class MinDistance {
    public int minDistance(String word1, String word2) {


        /**
         * 求两串最大公共字串思路求解
         *
         * dp[i][j]表示word1的0-i子串与word2的0-j子串的最大公共子序列长度
         *
         * dp[i][j] = dp[i-1][j-1] + 1
         * dp[i][j] = max(dp[i-1][j],dp[i][j-1])
         */
        int[][] dp = new int[word1.length()][word2.length()];

        for(int i=0;i<word1.length();i++){
            if(word1.charAt(i)==word2.charAt(0)){
                while (i<word1.length()){
                    dp[i][0] = 1;
                    i++;
                }
            }
        }

        for(int j=0;j<word2.length();j++){
            if(word1.charAt(0)==word2.charAt(j)){
                while (j<word2.length()){
                    dp[0][j]=1;
                    j++;
                }
            }
        }

        for(int i=1;i<word1.length();i++){
            for(int j=1;j<word2.length();j++){
                if(word1.charAt(i)==word2.charAt(j)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return word1.length()+word2.length()-2*dp[word1.length()-1][word2.length()-1];
    }

    @Test
    public void test(){
        minDistance("a","ab");
    }
}
