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

        //dp[j] 表示在0~j的子串能否由字典的字符串组成
        //dp[j+i] 诺dp[j] = true 且 substr(j+1,j+i+1) 存在于字典内 则dp[j+i] = true

        for (int j = 1; j <= s.length(); j++) {  //遍历背包容量
            for (int i = 0; i < j && !dp[j]; i++) {  // 遍历物品
                if (set.contains(s.substring(i, j)) && dp[i]) {
                    dp[j] = true;
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
