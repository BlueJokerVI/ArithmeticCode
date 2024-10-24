package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/maximum-length-substring-with-two-occurrences/
 */
public class MaximumLengthSubstring {
    public int maximumLengthSubstring(String s) {
        int[] cnt = new int[27];
        char[] cs = s.toCharArray();
        int n = cs.length;
        int cur = 0;
        int max = 0;
        int l = -1;
        for (int i = 0; i < n; i++) {
            int index = cs[i] & 31;
            cnt[index]++;
            while (cnt[index] > 2) {
                l++;
                cnt[ cs[l] & 31]--;
            }
            cur = i - (l + 1) + 1;
            if (cur > max) {
                max = cur;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        MaximumLengthSubstring maximumLengthSubstring = new MaximumLengthSubstring();
        maximumLengthSubstring.maximumLengthSubstring("bcbbbcba");

    }
}
