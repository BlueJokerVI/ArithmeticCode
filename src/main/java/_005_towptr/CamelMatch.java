package _005_towptr;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/camelcase-matching/
 */
public class CamelMatch {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();

        char[] p = pattern.toCharArray();
        int n = p.length;

        for (String query : queries) {
            char[] t = query.toCharArray();
            int m = t.length;
            int l = 0, r = 0;

            boolean find = true;
            while (l < n && r < m) {
                while (r < m && p[l] != t[r]) {
                    if (t[r] > 'z' || t[r] < 'a') {
                        find = false;
                        break;
                    }
                    r++;
                }
                if (r == m || !find) {
                    find = false;
                    break;
                }
                l++;
                r++;
            }

            if (l != n) {
                find = false;
            }

            while (r < m) {
                if (t[r] > 'z' || t[r] < 'a') {
                    find = false;
                    break;
                }
                r++;
            }
            ans.add(find);
        }
        return ans;
    }

    public static void main(String[] args) {
        CamelMatch t = new CamelMatch();
        t.camelMatch(new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"}, "FB");
    }
}
