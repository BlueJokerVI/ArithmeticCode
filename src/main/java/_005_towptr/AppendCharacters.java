package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/append-characters-to-string-to-make-subsequence/
 */
public class AppendCharacters {
    public int appendCharacters(String t, String s) {
        char[] ct = t.toCharArray();
        char[] cs = s.toCharArray();

        int l = 0;
        int n = ct.length;
        int ans = 0;
        for (int i = 0; i < cs.length; i++) {
            while (l < n && ct[l] != cs[i]) {
                l++;
            }

            if (l < n) {
                l++;
            } else {
                ans = cs.length - i;
                return ans;
            }
        }
        return ans;
    }
}
