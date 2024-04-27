package _010_dp;

import org.apache.logging.log4j.util.Strings;
import org.junit.Test;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/palindromic-substrings/
 */
public class CountSubstrings {
    public int countSubstrings(String s) {

        //dp[i][j] 表示[i,j]子串是否是回文串
        // j-i<=1    dp[i][j] = true
        //if s[i]==s[j]   dp[i][j] = dp[i+1][j-1]
        boolean[][] dp = new boolean[s.length()][s.length()];

        int ans = 0;
        for(int i=s.length()-1;i>=0;i--){
            for(int j=i;j<s.length();j++){
                if(s.charAt(i)==s.charAt(j)){
                    if(j-i<=1 || dp[i+1][j-1]){
                        ans++;
                        dp[i][j] = true;
                    }
                }
            }
        }
        return ans;
    }


    /**
     * 双指针法
     * @param s
     * @return
     */
    public int countSubstrings1(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            // 以i为中心
            result += extend(s, i, i, s.length());
            // 以i和i+1为中心
            result += extend(s, i, i + 1, s.length());
        }
        return result;
    }

    int extend(String s, int i, int j, int n) {
        int res = 0;
        while (i >= 0 && j < n && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
            res++;
        }
        return res;
    }

    @Test
    public void test(){
        countSubstrings("aaa");
    }
}
