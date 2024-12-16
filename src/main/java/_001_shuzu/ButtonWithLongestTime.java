package _001_shuzu;

/**
 * @author cct
 * https://leetcode.cn/contest/weekly-contest-428/problems/button-with-longest-push-time/
 */
public class ButtonWithLongestTime {
    public int buttonWithLongestTime(int[][] events) {
        int[] cnt = new int[100001];
        int n = events.length;

        cnt[events[0][0]] = events[0][1];

        for (int i = 1; i < n; i++) {
            cnt[events[i][0]] = Math.max(events[i][1] - events[i - 1][1], cnt[events[i][0]]);
        }

        int maxV = 0;
        int ans = 0;
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] > maxV) {
                ans = i;
                maxV = cnt[i];
            }
        }
        return ans;
    }
}
