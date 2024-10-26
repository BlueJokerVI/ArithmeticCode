package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/shortest-and-lexicographically-smallest-beautiful-string/
 */
public class ShortestBeautifulSubstring {
    public String shortestBeautifulSubstring(String s, int k) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int min = Integer.MAX_VALUE;
        String minStr = "";
        int l = 0;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (cs[i] == '1') {
                cnt++;
            }

            while (cnt == k) {

                String sub = s.substring(l, i + 1);

                if (i - l + 1 < min) {
                    min = i - l + 1;
                    minStr = sub;
                }

                if (i - l + 1 == min && small(minStr, sub).equals(sub)) {
                    minStr = sub;
                }

                if (cs[l] == '1') {
                    cnt--;
                }
                l++;
            }

        }
        return minStr;
    }

    String small(String a, String b) {
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();
        for (int i = 0; i < ca.length; i++) {
            if (ca[i] != cb[i]) {
                return ca[i] - cb[i] > 0 ? b : a;
            }
        }
        return a;
    }
}
