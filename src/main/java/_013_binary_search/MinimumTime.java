package _013_binary_search;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/minimum-time-to-complete-trips/
 */
public class MinimumTime {
    public long minimumTime(int[] time, int totalTrips) {
        long l = 0, r = 0;
        for (int i : time) {
            r = Math.max(i, r);
        }
        r = totalTrips * r;

        while (l <= r) {
            long mid = (r - l) / 2 + l;
            if (check(time, mid, totalTrips)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r + 1;
    }

    boolean check(int[] time, long mid, int total) {
        int sum = 0;
        for (int i : time) {
            sum += mid / i;
            if (sum >= total) {
                return true;
            }
        }
        return false;
    }
}
