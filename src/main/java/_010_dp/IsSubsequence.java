package _010_dp;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/is-subsequence/
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {

        if(s.length()==0){
            return true;
        }

        int index=0;
        for(int i=0;i<t.length();i++){
            if(t.charAt(i)==s.charAt(index)){
                index++;
                if(index==s.length()){
                    return true;
                }
            }
        }

        return false;
    }



    //求两串最长公共子序列的思路求解
    public boolean isSubsequence1(String s, String t) {
        int length1 = s.length(); int length2 = t.length();

        //dp[i][j] 表示以s以i-1结尾的字符串,t以j-1结尾的字符串的最大公共字串长度

        int[][] dp = new int[length1+1][length2+1];
        for(int i = 1; i <= length1; i++){
            for(int j = 1; j <= length2; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        if(dp[length1][length2] == length1){
            return true;
        }else{
            return false;
        }
    }
}
