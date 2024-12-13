package _009_Greedy;

/**
 * @author cct
 * https://leetcode.cn/problems/maximum-number-of-integers-to-choose-from-a-range-i/
 */
public class MaxCount {
    public int maxCount(int[] banned, int n, int maxSum) {
        int[] vis = new int[10001];
        for (int v : banned) {
            vis[v] = 1;
        }
        int ans = 0;
        int cur = 0;
        for (int i = 1; i <= n; i++) {
            if (vis[i] != 1) {
                vis[i] = 1;
                if (cur + i > maxSum) {
                    break;
                } else {
                    ans++;
                    cur += i;
                }
            }
        }
        return ans;
    }
}
