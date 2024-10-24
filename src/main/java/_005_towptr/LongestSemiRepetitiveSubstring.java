package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/find-the-longest-semi-repetitive-substring/
 */
public class LongestSemiRepetitiveSubstring {
    public int longestSemiRepetitiveSubstring(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        if (n == 1 || n == 2) {
            return n;
        }

        int max = 2;
        int cnt = 0;
        int l = 0;
        for (int r = 1; r < n; r++) {
            if (cs[r] == cs[r - 1]) {
                cnt++;
            }

            if (cnt == 2) {
                while (cs[l] != cs[l + 1]) {
                    l++;
                }
                l += 1;
                cnt--;
            }

            if (r - l + 1 > max) {
                max = r - l + 1;
            }

        }
        return max;
    }

    public static void main(String[] args) {

        LongestSemiRepetitiveSubstring ll = new LongestSemiRepetitiveSubstring();
        ll.longestSemiRepetitiveSubstring("1111111");
    }
}
