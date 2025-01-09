package _009_Greedy;

import java.util.Arrays;

/**
 * @author cct
 * https://leetcode.cn/problems/count-ways-to-group-overlapping-ranges/
 */
public class CountWays {
    public int countWays(int[][] ranges) {
        Arrays.sort(ranges, (a, b) -> a[0] - b[0]);
        int cnt = 0;
        int n = ranges.length;
        int r = -1;
        for (int i = 0; i < n; i++) {
            if (ranges[i][0] <= r) {
                r = Math.max(r, ranges[i][1]);
            } else {
                cnt++;
                r = ranges[i][1];
            }
        }

        int mod = 1000000007;
        int ans = 1;
        for (int i = 0; i < cnt; i++) {
            ans = ans * 2 % mod;
        }
        return ans;
    }

}
