package _005_towptr;

import java.util.List;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/longest-word-in-dictionary-through-deleting/
 */
public class FindLongestWord {
    public String findLongestWord(String s, List<String> dictionary) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        String ans = "";

        for (String str : dictionary) {
            char[] cur = str.toCharArray();
            int m = cur.length;
            if (n < m) {
                continue;
            }

            int l = 0, r = 0;
            boolean find = true;
            while (l < n && r < m) {

                while (l < n && cs[l] != cur[r]) {
                    l++;
                }

                if (l == n) {
                    find = false;
                    break;
                }
                l++;
                r++;
            }

            if(r!=m){
                find = false;
            }

            if (find && !cmp(ans, str)) {
                ans = str;
            }

        }
        return ans;
    }

    //true 不用换
    private boolean cmp(String ans, String t) {
        if (ans.length() > t.length()) {
            return true;
        }

        if (ans.length() < t.length()) {
            return false;
        }
        return ans.compareTo(t) < 0;
    }
}
