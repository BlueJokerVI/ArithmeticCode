package _009_Greedy;

import java.util.Arrays;

/**
 * @author cct
 * https://leetcode.cn/problems/minimum-number-of-taps-to-open-to-water-a-garden/
 */
public class MinTaps {
    public int minTaps(int n, int[] ranges) {


        int[][] lr = new int[n + 1][2];
        for (int i = 0; i <= n; i++) {
            lr[i][0] = Math.max(0, i - ranges[i]);
            lr[i][1] = i + ranges[i];
        }

        Arrays.sort(lr, (a, b) -> a[0] - b[0]);

        int r = 0;
        int index = 0;
        int ans = 0;

        while (r < n) {
            int mv = r;
            while (index <= n && lr[index][0] <= r) {
                mv = Math.max(mv, lr[index][1]);
                index++;
            }
            if (mv == r) {
                return -1;
            }
            ans++;
            r = mv;
        }

        return ans;
    }

    public static void main(String[] args) {
        MinTaps t = new MinTaps();
        t.minTaps(97, new int[]{1, 5, 3, 1, 4, 5, 5, 1, 2, 0, 2, 2, 4, 3, 0, 0, 1, 4, 5, 5, 0, 3, 5, 1, 1, 0, 0, 0, 4, 1, 1, 1, 0, 4, 4, 1, 0, 0, 2, 5, 5, 4, 4, 4, 2, 4, 3, 4, 4, 2, 3, 4, 0, 2, 0, 1, 0, 4, 2, 3, 0, 0, 0, 1, 5, 2, 0, 2, 4, 4, 3, 3, 0, 0, 3, 1, 1, 1, 4, 2, 5, 2, 3, 1, 0, 1, 0, 2, 4, 3, 4, 0, 2, 4, 1, 1, 2, 5});
    }
}
