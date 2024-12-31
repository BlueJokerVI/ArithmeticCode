package _009_Greedy;

import java.util.Arrays;

/**
 * @author cct
 * https://leetcode.cn/problems/minimum-initial-energy-to-finish-tasks/
 */
public class MinimumEffort {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));
        int ans = 0;
        int n = tasks.length;
        for (int i = 0; i < n; i++) {
            ans += tasks[i][0];
        }

        int cur = ans;
        for (int i = 0; i < n; i++) {
            if (cur >= tasks[i][1]) {
                cur -= tasks[i][0];
            } else {
                int dv = tasks[i][1] - cur;
                ans += tasks[i][1] - cur;
                cur = cur + dv - tasks[i][0];
            }
        }
        return ans;
    }
}
