package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/get-equal-substrings-within-budget/
 */
public class EqualSubstring {
    public int equalSubstring(String s, String t, int maxCost) {
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        int n = cs.length;
        int remaining = maxCost;
        int max = 0;
        int l = 0;
        for (int r = 0; r < n; r++) {
            remaining -= Math.abs(cs[r] - ct[r]);
            while ( remaining < 0) {
                remaining += Math.abs(cs[l] - ct[l]);
                l++;
            }
            if (r - l + 1 > max) {
                max = r - l + 1;
            }
        }

        return max;
    }
}
