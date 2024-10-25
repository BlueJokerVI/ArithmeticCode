package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/take-k-of-each-character-from-left-and-right/
 */
public class TakeCharacters {
    public int takeCharacters(String s, int k) {
        char[] cs = s.toCharArray();
        int[] maxv = new int[4];
        int[] curv = new int[4];
        int n = cs.length;
        for (char value : cs) {
            maxv[value & 31]++;
        }
        for (int i = 1; i <= 3; i++) {
            maxv[i] -= k;
            if (maxv[i] < 0) {
                return -1;
            }
        }

        int maxL = 0;
        int l = 0;
        for (int r = 0; r < n; r++) {
            curv[cs[r] & 31]++;
            while (curv[cs[r] & 31] == maxv[cs[r] & 31] + 1) {
                curv[cs[l] & 31]--;
                l++;
            }

            if (r - l + 1 > maxL) {
                maxL = r - l + 1;
            }
        }
        return n - maxL;
    }
}
