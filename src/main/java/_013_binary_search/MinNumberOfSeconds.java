package _013_binary_search;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/minimum-number-of-seconds-to-make-mountain-height-zero/
 */
public class MinNumberOfSeconds {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        // w(1+x)*x/2 = s;
        // (1+x)*x = 2s/w  (x+1/2)^2 = 2s/w + 1/4   x = sqrt(2s/w + 1/4 ) - 1/2

        //二分找秒数
        long l = 1, r = 0;
        for (int workerTime : workerTimes) {
            r = Math.max(r, workerTime);
        }
        r = r * (1 + mountainHeight) * mountainHeight / 2;

        while (l <= r) {
            long mid = (r - l) / 2 + l;
            if (check(workerTimes, mid, mountainHeight)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r + 1;
    }


    boolean check(int[] nums, long mid, int m) {
        int x = 0;
        for (int w : nums) {
            x += (int) (Math.sqrt(2.0 * mid / w + 0.25) - 0.5);
            if (x >= m) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MinNumberOfSeconds t = new MinNumberOfSeconds();
        t.minNumberOfSeconds(5, new int[]{1});
    }
}
