package _013_binary_search;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/minimum-speed-to-arrive-on-time/
 */
public class MinSpeedOnTime {
    public int minSpeedOnTime(int[] dist, double hour) {
        int l = 1, r = 10000000;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (check(dist, mid, hour)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return r == 10000000 ? -1 : r + 1;
    }

    boolean check(int[] dist, int mid, double hour) {
        double sum = 0;

        for (int i = 0; i < dist.length; i++) {

            if (i != dist.length - 1) {
                sum += Math.ceil(dist[i] * 1.0 / mid);
            } else {
                sum += dist[i] * 1.0 / mid;
            }


            if (sum > hour) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MinSpeedOnTime t = new MinSpeedOnTime();
        t.minSpeedOnTime(new int[]{1, 3, 2}, 2.7);
    }

}
