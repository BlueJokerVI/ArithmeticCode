package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/permutation-in-string/
 */
public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        int[] target = new int[26];
        int[] cur = new int[26];
        char[] chars = s1.toCharArray();
        char[] cs2 = s2.toCharArray();
        for (char c : chars) {
            target[c - 'a']++;
        }
        int n = chars.length;
        int m = cs2.length;
        if (n > m) {
            return false;
        }

        for (int i = 0; i < n - 1; i++) {
            cur[cs2[i] - 'a']++;
        }

        for (int i = n - 1; i < m; i++) {
            cur[cs2[i] - 'a']++;

            if (same(target, cur)) {
                return true;
            }

            cur[cs2[i - n + 1] - 'a']--;

        }

        return false;
    }

    private boolean same(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

}
