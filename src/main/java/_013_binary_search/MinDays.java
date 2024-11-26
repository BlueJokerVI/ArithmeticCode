package _013_binary_search;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/minimum-number-of-days-to-make-m-bouquets/
 */
public class MinDays {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (n < (long) m * k) {
            return -1;
        }

        int l = 1, r = 0;
        for (int day : bloomDay) {
            r = Math.max(r, day);
        }

        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (check(bloomDay, mid, m, k)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r + 1;
    }

    boolean check(int[] b, int day, int m, int k) {
        int cur = 0;
        int t = 0;
        for (int j : b) {
            if (j <= day) {
                t++;
            } else {
                t = 0;
            }

            if (t == k) {
                cur++;
                if (cur >= m) {
                    return true;
                }
                t = 0;
            }
        }
        return false;
    }
}
