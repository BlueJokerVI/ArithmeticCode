package _013_binary_search;

/**
 * @author cct
 * https://leetcode.cn/problems/kth-smallest-number-in-multiplication-table/
 */
public class FindKthNumber {
    public int findKthNumber(int m, int n, int k) {
        int l = 1, r = m * n;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (check(m, n, mid, k)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r + 1;
    }

    boolean check(int m, int n, int mid, int k) {
        int t = 0;
        for (int i = 1; i <= m; i++) {
            t += Math.min(mid / i, n);
        }
        return t >= k;
    }


}
