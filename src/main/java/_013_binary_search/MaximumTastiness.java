package _013_binary_search;

import java.util.Arrays;

/**
 * @author cct
 * https://leetcode.cn/problems/maximum-tastiness-of-candy-basket/
 */
public class MaximumTastiness {
    public int maximumTastiness(int[] price, int k) {
        int l = 0, r = 0;
        Arrays.sort(price);
        r = price[price.length - 1];

        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (check(price, mid, k)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l - 1;
    }

    //7,7,7,7
    boolean check(int[] price, int mid, int k) {
        int t = 1;
        long v = 0;
        int index = 0;
        int n = price.length;
        while (index < n) {
            v = price[index] + mid;
            index++;
            while (index < n && v > price[index]) {
                index++;
            }
            if (index < n) {
                t++;
            }
        }
        return t >= k;
    }
}
