package _013_binary_search;

import java.util.Arrays;

/**
 * @author cct
 * https://leetcode.cn/problems/maximize-score-of-numbers-in-ranges/
 */
public class MaxPossibleScore {
    public int maxPossibleScore(int[] start, int d) {

        Arrays.sort(start);
        int n = start.length;
        int l = 0, r = (start[n - 1] - start[0]) / (n - 1) + 1;


        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (check(start, mid, d)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l - 1;
    }


    boolean check(int[] start, int mid, int d) {
        long pre = Integer.MIN_VALUE;
        for (int v : start) {
            if (pre + mid > v + d) {
                return false;
            }
            pre = Math.max(pre + mid, v);
        }
        return true;
    }
}
