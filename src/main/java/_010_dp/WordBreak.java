package _010_dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/word-break/
 */

public class WordBreak {
    private Set<String> set;
    private int[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new int[s.length()];
        set = new HashSet<>(wordDict);
        return backtracking(s, 0);
    }

    public boolean wordBreak1(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        //dp[j] 表示在[0,j-1]的子串能否由字典的字符串组成
        //诺dp[i]=true,且substring(i,j)在set内，则dp[j] = true

        for (int j = 1; j <= s.length(); j++) {
            for (int i = 0; i < j; i++) {
                if (dp[i] && set.contains(s.substring(i, j))) {
                    dp[j] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }




    //直接暴力搜索
    boolean dfs(String s,int index){
        if(index==s.length()){
            return true;
        }
        for(int i=index;i<s.length();i++){
             String cur = s.substring(index,i+1);
             if(!set.contains(cur)){
                 continue;
             }
             if(dfs(s,i+1)){
                 return true;
             }
        }
        return false;
    }




    //记忆化搜索
    public boolean backtracking(String s, int startIndex) {
        // System.out.println(startIndex);
        if (startIndex == s.length()) {
            return true;
        }
        if (memo[startIndex] == -1) {
            return false;
        }

        for (int i = startIndex; i < s.length(); i++) {
            String sub = s.substring(startIndex, i + 1);
            // 拆分出来的单词无法匹配
            if (!set.contains(sub)) {
                continue;
            }
            boolean res = backtracking(s, i + 1);
            if (res) return true;
        }
        // 这里是关键，找遍了startIndex~s.length()也没能完全匹配，标记从startIndex开始不能找到
        memo[startIndex] = -1;
        return false;
    }
}
