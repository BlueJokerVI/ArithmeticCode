package _009_Greedy;

import java.util.Arrays;

/**
 * @author cct
 * https://leetcode.cn/problems/count-days-without-meetings/
 */
public class CountDays {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        int ans = 0;
        int n = meetings.length;
        int req = 1;
        for (int i = 0; i < n; i++) {
            if (meetings[i][0] < req) {
                req = Math.max(req, meetings[i][1] + 1);
                if (req > days) {
                    break;
                }
            } else {
                ans += meetings[i][0] - Math.min(req, days);
                req = Math.max(req, meetings[i][1] + 1);
                if (req > days) {
                    break;
                }
            }
        }

        if (req - 1 < days) {
            ans += days - req + 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        CountDays r = new CountDays();
        r.countDays(5, new int[][]{{2, 4}, {1, 3}});
    }
}
