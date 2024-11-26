package _013_binary_search;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/maximum-candies-allocated-to-k-children/
 */
public class MaximumCandies {
    public int maximumCandies(int[] candies, long k) {
        int l = 0, r = Integer.MIN_VALUE;
        for (int candy : candies) {
            r = Math.max(r, candy);
        }

        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (check(candies, mid, k)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l - 1;
    }

    boolean check(int[] c, int mid, long k) {
        long t = 0;
        if (mid == 0) {
            return true;
        }
        for (int v : c) {
            t += v / mid;
        }
        return t >= k;
    }
}
