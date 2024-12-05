package _013_binary_search;

import java.util.Arrays;

/**
 * @author cct
 * https://leetcode.cn/problems/magnetic-force-between-two-balls/
 */
public class MaxDistance {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int l = 1, r = position[position.length - 1];
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if(check(position,mid,m)){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return l - 1;
    }

    boolean check(int[] position, int mid, int n) {
        int t = 0;
        long pre = Long.MIN_VALUE;
        for (int p : position) {
            if (pre + mid <= p) {
                t++;
                pre = p;
            }
        }
        return t >= n;
    }
}
