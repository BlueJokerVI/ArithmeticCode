package _013_binary_search;

import java.util.Arrays;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/compare-strings-by-frequency-of-the-smallest-character/
 */
public class NumSmallerByFrequency {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int n = queries.length;
        int[] qf = new int[n];
        for (int i = 0; i < n; i++) {
            qf[i] = f(queries[i]);
        }

        int m = words.length;
        int[] wf = new int[m];
        for (int i = 0; i < m; i++) {
            wf[i] = f(words[i]);
        }

        Arrays.sort(wf);

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int l = 0, r = m - 1;
            while (l <= r) {
                int mid = (r - l) / 2 + l;
                if(wf[mid] <= qf[i] ){
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }

            ans[i] = m - l;
        }
        return ans;
    }

    private int f(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        char minC = cs[0];
        int v = 1;
        for (int i = 1; i < n; i++) {
            char c = cs[i];
            if (c == minC) {
                v++;
            }
            if (c < minC) {
                minC = c;
                v = 1;
            }
        }
        return v;
    }
}
