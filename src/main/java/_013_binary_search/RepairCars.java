package _013_binary_search;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/minimum-time-to-repair-cars/
 */
public class RepairCars {
    public long repairCars(int[] ranks, int cars) {
        //修 n 量车耗时  r * n^2 = t  n = sqrt(t/r)
        long l = 1, r = 0;
        for (int rank : ranks) {
            r = Math.max(r, rank);
        }
        r = r * cars * cars;

        while (l <= r) {
            long mid = (r - l) / 2 + l;
            if (check(ranks, mid, cars)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r + 1;
    }

    boolean check(int[] ranks, long mid, int cars) {
        int s = 0;
        for (int rank : ranks) {
            s += (int) (Math.sqrt(mid * 1.0 / rank));
            if (s >= cars) {
                return true;
            }
        }
        return false;
    }
}
