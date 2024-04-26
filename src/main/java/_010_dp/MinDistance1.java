package _010_dp;

import org.junit.Test;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/edit-distance/description/
 */
public class MinDistance1 {
    public int minDistance(String word1, String word2) {

        if(word1.length()==0){
            return word2.length();
        }

        if(word2.length()==0){
            return word1.length();
        }

        /**
         * dp[i][j]  0-i子串与0-j子串的最小编辑距离
         *
         * if:word[i]1==word2[j]   dp[i][j] = dp[i-1][j-1]
         * else dp[i][j] = min(dp[i-1][j]+1,dp[i][j-1]+1,dp[i-1][j-1]+1)
         */
        int[][] dp = new int[word1.length()][word2.length()];

        //dp初始化

        boolean f = false;
        if(word1.charAt(0)==word2.charAt(0)){
            dp[0][0] = 0;
            f = true;
        }else {
            dp[0][0] = 1;
        }


        for(int i=1;i<word1.length();i++){
            if(!f){
                if(word1.charAt(i) == word2.charAt(0)){
                    f=true;
                    dp[i][0] = dp[i-1][0];
                }else {
                    dp[i][0] = dp[i-1][0]+1;
                }
            }else {
                dp[i][0] = dp[i-1][0]+1;
            }
        }

        if(dp[0][0]==1){
            f = true;
        }else {
            f = false;
        }
        for(int j=1;j<word2.length();j++){
            if(!f){
                if(word1.charAt(0)==word2.charAt(j)){
                    f=true;
                    dp[0][j] = dp[0][j-1];
                }else {
                    dp[0][j] = dp[0][j-1]+1;
                }
            }else {
                dp[0][j] = dp[0][j-1]+1;
            }
        }



        for(int i=1;i<word1.length();i++){
            for(int j=1;j<word2.length();j++){
                if(word1.charAt(i)==word2.charAt(j)){
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i-1][j]+1,Math.min(dp[i][j-1]+1,dp[i-1][j-1]+1));
                }
            }
        }

        return dp[word1.length()-1][word2.length()-1];
    }


    /**
     * 定义dp[i][j] 表示位0~i-1 与0~j-1的字串的最小编辑长度，这样方便初始化
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance1(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        // 初始化
        for (int i = 1; i <= m; i++) {
            dp[i][0] =  i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 因为dp数组有效位从1开始
                // 所以当前遍历到的字符串的位置为i-1 | j-1
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }
            }
        }
        return dp[m][n];
    }


    @Test
    public void test(){
        minDistance("pneumonoultramicroscopicsilicovolcanoconiosis","ultramicroscopically");
    }
}
