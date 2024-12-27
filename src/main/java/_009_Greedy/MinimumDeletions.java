package _009_Greedy;

import java.util.Arrays;

/**
 * @author cct
 * https://leetcode.cn/problems/minimum-deletions-to-make-string-k-special/
 */
public class MinimumDeletions {
    public int minimumDeletions(String word, int k) {
        char[] cs = word.toCharArray();
        int[] cnt = new int[26];
        for (char c : cs) {
            cnt[c - 'a']++;
        }
        Arrays.sort(cnt);
        long[] preSum = new long[27];
        for (int i = 0; i < 26; i++) {
            preSum[i + 1] = preSum[i] + cnt[i];
        }
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < 26; i++) {
            int v = cnt[i] + k;

            int l = 0, r = 25;
            while (l <= r) {
                int mid = (r + l) / 2;
                if (cnt[mid] <= v) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            // cnt[l] > v;

            if (l <= 25) {
                ans = (int) Math.min(ans, preSum[i] + (preSum[26] - preSum[l] - (long) v * (25 - l + 1)));
            } else {
                ans = (int) Math.min(ans, preSum[i]);
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        MinimumDeletions t = new MinimumDeletions();
        t.minimumDeletions("tllltllsttt", 4);
    }
}
