package _009_Greedy;

import java.util.Arrays;

/**
 * @author cct
 * https://leetcode.cn/problems/minimum-deletions-to-make-character-frequencies-unique/
 */
public class MinDeletions {
    public int minDeletions(String s) {
        char[] cs = s.toCharArray();
        int[] cnt = new int[26];

        for (char c : cs) {
            cnt[c - 'a']++;
        }
        Arrays.sort(cnt);

        int ans = 0;
        int[] vis = new int[100001];
        for (int i = 0; i < 26; i++) {
            if (cnt[i] == 0) {
                continue;
            }
            while (vis[cnt[i]] != 0) {
                cnt[i]--;
                ans++;
                if (cnt[i] == 0) {
                    break;
                }
            }
            vis[cnt[i]] = 1;
        }
        return ans;
    }
}
