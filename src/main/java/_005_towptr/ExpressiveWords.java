package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/expressive-words/
 */
public class ExpressiveWords {
    public int expressiveWords(String S, String[] words) {
        char[] s = S.toCharArray();
        int n = s.length;
        int ans = 0;
        for (String word : words) {
            char[] w = word.toCharArray();
            int m = w.length;
            if (m > n) {
                continue;
            }

            int l = 0, r = 0;
            boolean u = true;
            while (l < n && r < m) {
                int cs = 1;
                while (l + 1 < n && s[l] == s[l + 1]) {
                    l++;
                    cs++;
                }

                int cm = 0;
                while (r < m && w[r] == s[l]) {
                    r++;
                    cm++;
                }

                if (cm > cs) {
                    u = false;
                    break;
                }

                if (cm < cs && cs < 3) {
                    u = false;
                    break;
                }
                l++;
            }

            u = l == n && r == m;
            if (u) {
                ans++;
            }
        }
        return ans;
    }
}
