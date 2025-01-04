package _009_Greedy;

import java.util.Arrays;

/**
 * @author cct
 * https://leetcode.cn/problems/reorganize-string/description/
 */
public class ReorganizeString {
    public String reorganizeString(String s) {
        char[] cs = s.toCharArray();
        int[][] cnt = new int[26][2];
        int m = 0;
        int sum = 0;
        for (char c : cs) {
            cnt[c - 'a'][1]++;
            cnt[c - 'a'][0] = c - 'a';
        }

        for (int[] v : cnt) {
            m = Math.max(v[1], m);
            sum += v[1];
        }

        if (m > sum - m + 1) {
            return "";
        }

        Arrays.sort(cnt, (a, b) -> b[1] - a[1]);
        int n = cs.length;
        char[] ans = new char[n];
        int index = 0;
        for (int i = 0; i < 26; i++) {
            for (int t = 0; t < cnt[i][1]; t++) {
                if (index >= n) {
                    index = 1;
                }
                ans[index] = (char) (cnt[i][0] + 'a');
                index += 2;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (char v : ans) {
            stringBuilder.append(v);
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        ReorganizeString t = new ReorganizeString();
        t.reorganizeString("aabbcc");
    }
}
